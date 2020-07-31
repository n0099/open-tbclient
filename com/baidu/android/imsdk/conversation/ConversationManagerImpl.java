package com.baidu.android.imsdk.conversation;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.BIMConversationMsg;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUserListener;
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ConversationManagerImpl {
    private static final String TAG = "ConversationManagerImpl";
    public static Context mContext;
    private static volatile ConversationManagerImpl sInstance = null;
    protected static Object syncObject = new Object();
    private ArrayList<IConversationChangeListener> mAllConversationChangeListener;
    private ArrayList<BIMConversation> mAllConversations;
    private String mUid = null;
    private HashMap<BIMManager.CATEGORY, ArrayList<BIMConversation>> mConversationsListMaps = new HashMap<>();
    private HashMap<String, BIMConversation> mConversationsMaps = new HashMap<>();
    private IChatSessionChangeListener listener = new IChatSessionChangeListener() { // from class: com.baidu.android.imsdk.conversation.ConversationManagerImpl.1
        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatSessionUpdate(ChatSession chatSession, boolean z) {
            if (chatSession != null) {
                synchronized (ConversationManagerImpl.syncObject) {
                    String str = chatSession.getCategory() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + chatSession.getContacter();
                    if (ConversationManagerImpl.this.mConversationsMaps.containsKey(str)) {
                        ((BIMConversation) ConversationManagerImpl.this.mConversationsMaps.get(str)).updateConversation(chatSession);
                    } else {
                        ConversationManagerImpl.this.putConversationInternal(new BIMConversationMsg(ConversationManagerImpl.mContext, ConversationManagerImpl.getCategoryByProtocolCategory(chatSession.getCategory(), chatSession.getChatType()), String.valueOf(chatSession.getContacterId()), chatSession));
                    }
                }
                ConversationManagerImpl.this.notifyConversationChange();
                return;
            }
            LogUtils.e(ConversationManagerImpl.TAG, "session is null ");
        }

        @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
        public void onChatRecordDelete(int i, long j) {
            ConversationManagerImpl.this.deleteConversationInternal(i, j);
            ConversationManagerImpl.this.notifyConversationChange();
        }
    };

    public static ConversationManagerImpl getInstance(Context context) {
        if (sInstance == null) {
            synchronized (ConversationManagerImpl.class) {
                if (sInstance == null) {
                    if (context != null) {
                        sInstance = new ConversationManagerImpl(context);
                    } else {
                        LogUtils.e(TAG, "Context should be not null!");
                    }
                }
            }
        }
        return sInstance;
    }

    public ConversationManagerImpl(Context context) {
        this.mAllConversationChangeListener = null;
        mContext = context.getApplicationContext();
        this.mAllConversationChangeListener = new ArrayList<>();
        this.mAllConversations = new ArrayList<>();
        this.mConversationsListMaps.put(BIMManager.CATEGORY.ALL, this.mAllConversations);
    }

    public void init(String str) {
        LogUtils.d(TAG, "uid: " + str + " , mUid : " + this.mUid);
        if (this.mUid == null || !this.mUid.equals(str)) {
            ArrayList<ChatSession> chatRecords = ChatSessionManagerImpl.getInstance(mContext).getChatRecords(0L, 0L);
            ChatSessionManagerImpl.getInstance(mContext).registerRecordChangeListener(mContext, this.listener);
            clear();
            synchronized (syncObject) {
                this.mUid = str;
                initConversation(chatRecords);
                notifyConversationChange();
                LogUtils.d(TAG, "---Conversation init done -- sessions.size : " + (chatRecords != null ? chatRecords.size() : 0));
            }
        }
    }

    private void initConversation(ArrayList<ChatSession> arrayList) {
        if (arrayList != null) {
            Iterator<ChatSession> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatSession next = it.next();
                putConversationInternal(new BIMConversationMsg(mContext, getCategoryByProtocolCategory(next.getCategory(), next.getChatType()), String.valueOf(next.getContacterId()), next));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putConversationInternal(BIMConversation bIMConversation) {
        String str = bIMConversation.getCategory().getValue() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bIMConversation.getId();
        try {
            if (this.mConversationsMaps.containsKey(str)) {
                BIMConversation bIMConversation2 = this.mConversationsMaps.get(str);
                if (bIMConversation != bIMConversation2) {
                    this.mConversationsMaps.remove(str);
                    this.mConversationsMaps.put(str, bIMConversation);
                    this.mAllConversations.remove(bIMConversation2);
                    this.mAllConversations.add(bIMConversation);
                    this.mConversationsListMaps.get(bIMConversation.getCategory()).remove(bIMConversation2);
                    this.mConversationsListMaps.get(bIMConversation.getCategory()).add(bIMConversation);
                    return;
                }
                return;
            }
            this.mConversationsMaps.put(str, bIMConversation);
            if (!this.mConversationsListMaps.containsKey(bIMConversation.getCategory())) {
                this.mConversationsListMaps.put(bIMConversation.getCategory(), new ArrayList<>());
            }
            this.mAllConversations.add(bIMConversation);
            this.mConversationsListMaps.get(bIMConversation.getCategory()).add(bIMConversation);
        } catch (Exception e) {
            LogUtils.e(TAG, "putConversationInternal exception :", e);
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteConversationInternal(int i, long j) {
        String str = i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j;
        BIMConversation bIMConversation = this.mConversationsMaps.get(str);
        if (bIMConversation != null) {
            this.mConversationsMaps.remove(str);
            this.mAllConversations.remove(bIMConversation);
            this.mConversationsListMaps.get(bIMConversation.getCategory()).remove(bIMConversation);
        }
    }

    public BIMConversation getConversation(final BIMManager.CATEGORY category, final String str) {
        ChatSession chatSession;
        if (TextUtils.isEmpty(str)) {
            LogUtils.e(TAG, "id should not be empty");
            return null;
        }
        synchronized (syncObject) {
            String str2 = category.getValue() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
            if (this.mConversationsMaps.containsKey(str2)) {
                return this.mConversationsMaps.get(str2);
            }
            try {
                long longValue = Long.valueOf(str).longValue();
                int value = category.getValue();
                if (BIMManager.CATEGORY.SINGLEPERSON == category) {
                    long uKbyBuid = IMUserManager.getInstance(mContext).getUKbyBuid(longValue);
                    if (uKbyBuid >= 0) {
                        ChatSession chatRecord = ChatSessionManagerImpl.getInstance(mContext).getChatRecord(value, uKbyBuid);
                        BIMConversationMsg bIMConversationMsg = new BIMConversationMsg(mContext, BIMManager.CATEGORY.SINGLEPERSON, str, chatRecord == null ? new ChatSession(value, uKbyBuid, longValue, null) : chatRecord);
                        putConversationInternal(bIMConversationMsg);
                        return bIMConversationMsg;
                    }
                    ChatSession chatSession2 = new ChatSession(value, uKbyBuid, longValue, null);
                    ChatUserManagerImpl.getInstance(mContext).getUserByBuid(longValue, 0, new IGetUserListener() { // from class: com.baidu.android.imsdk.conversation.ConversationManagerImpl.2
                        @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
                        public void onGetUserResult(int i, long j, ChatUser chatUser) {
                            BIMConversation conversation;
                            ChatSession chatSession3;
                            if (i == 0 && chatUser != null && (conversation = ConversationManagerImpl.this.getConversation(category, str)) != null && (chatSession3 = conversation.getChatSession()) != null) {
                                chatSession3.setName(chatUser.getUserName());
                                chatSession3.setContacter(chatUser.getUk());
                                chatSession3.setIconUrl(chatUser.getIconUrl());
                                ConversationManagerImpl.this.updateConversationName(chatUser.getUserName(), 0, str);
                            }
                        }
                    });
                    BIMConversationMsg bIMConversationMsg2 = new BIMConversationMsg(mContext, category, str, chatSession2);
                    putConversationInternal(bIMConversationMsg2);
                    return bIMConversationMsg2;
                } else if (BIMManager.CATEGORY.GROUP == category) {
                    ChatSession chatRecord2 = ChatSessionManagerImpl.getInstance(mContext).getChatRecord(value, longValue);
                    if (chatRecord2 == null) {
                        ChatSession chatSession3 = new ChatSession(value, longValue, longValue, null);
                        if (value == 1) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(String.valueOf(longValue));
                            ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
                            if (groupInfo != null && groupInfo.size() > 0 && groupInfo.get(0).getType() == 2 && chatSession3 != null) {
                                chatSession3.setChatType(4);
                            }
                        }
                        chatSession = chatSession3;
                    } else {
                        chatSession = chatRecord2;
                    }
                    BIMConversationMsg bIMConversationMsg3 = new BIMConversationMsg(mContext, category, str, chatSession);
                    putConversationInternal(bIMConversationMsg3);
                    return bIMConversationMsg3;
                } else if (BIMManager.CATEGORY.PA == category) {
                    ChatSession chatRecord3 = ChatSessionManagerImpl.getInstance(mContext).getChatRecord(0, longValue);
                    BIMConversationMsg bIMConversationMsg4 = new BIMConversationMsg(mContext, category, str, chatRecord3 == null ? new ChatSession(value, longValue, longValue, null) : chatRecord3);
                    putConversationInternal(bIMConversationMsg4);
                    return bIMConversationMsg4;
                } else if (BIMManager.CATEGORY.STUDIO == category) {
                    BIMConversationMsg bIMConversationMsg5 = new BIMConversationMsg(mContext, category, str, new ChatSession(value, longValue, longValue, null));
                    putConversationInternal(bIMConversationMsg5);
                    return bIMConversationMsg5;
                } else {
                    return null;
                }
            } catch (ClassCastException e) {
                LogUtils.e(TAG, "Id is not long value", e);
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                return null;
            }
        }
    }

    public void updateConversationName(String str, int i, String str2) {
        ChatSession chatSession;
        BIMConversation bIMConversation = this.mConversationsMaps.get(i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2);
        if (bIMConversation != null && (chatSession = bIMConversation.getChatSession()) != null) {
            chatSession.setName(str);
            ChatMsgManagerImpl.getInstance(mContext).updateChatSeesionName(bIMConversation.getChatSession());
            notifyConversationChange();
        }
    }

    public boolean deleteConversation(int i, String str) {
        boolean deleteConversation;
        synchronized (syncObject) {
            deleteConversation = deleteConversation(this.mConversationsMaps.get(i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str));
        }
        return deleteConversation;
    }

    public boolean deleteConversation(BIMConversation bIMConversation) {
        if (bIMConversation == null) {
            return false;
        }
        ChatMsgManagerImpl.getInstance(mContext).deleteAllMsgs(bIMConversation.getCategory().getValue(), bIMConversation.getChatSession().getContacter(), false);
        return ChatSessionManagerImpl.getInstance(mContext).deleteChatSession(bIMConversation.getChatSession());
    }

    public ArrayList<BIMConversation> getAllConversation(BIMManager.CATEGORY category) {
        ArrayList<BIMConversation> arrayList;
        synchronized (syncObject) {
            arrayList = BIMManager.CATEGORY.ALL == category ? this.mAllConversations : this.mConversationsListMaps.get(category);
        }
        return arrayList;
    }

    public void registerConversationListener(IConversationChangeListener iConversationChangeListener) {
        if (iConversationChangeListener != null && !this.mAllConversationChangeListener.contains(iConversationChangeListener)) {
            this.mAllConversationChangeListener.add(iConversationChangeListener);
        }
    }

    public void unregisterConversationListener(IConversationChangeListener iConversationChangeListener) {
        if (iConversationChangeListener != null && this.mAllConversationChangeListener.contains(iConversationChangeListener)) {
            this.mAllConversationChangeListener.remove(iConversationChangeListener);
        }
    }

    public void notifyConversationChange() {
        Iterator<IConversationChangeListener> it = this.mAllConversationChangeListener.iterator();
        while (it.hasNext()) {
            it.next().onConversationChange();
        }
    }

    public void clear() {
        synchronized (syncObject) {
            this.mUid = null;
            this.mAllConversations.clear();
            this.mConversationsMaps.clear();
            for (BIMManager.CATEGORY category : this.mConversationsListMaps.keySet()) {
                this.mConversationsListMaps.get(category).clear();
            }
        }
    }

    public static BIMManager.CATEGORY getCategoryByProtocolCategory(int i, int i2) {
        if (1 == i) {
            return BIMManager.CATEGORY.GROUP;
        }
        if (i == 0) {
            if (1 == i2) {
                return BIMManager.CATEGORY.PA;
            }
            if (i2 == 0) {
                return BIMManager.CATEGORY.SINGLEPERSON;
            }
        } else if (2 == i) {
            return BIMManager.CATEGORY.SYSTEM;
        }
        return BIMManager.CATEGORY.UNKOWN;
    }
}
