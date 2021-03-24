package com.baidu.android.imsdk;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.IFetchMessageListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatuser.ChatUserManager;
import com.baidu.android.imsdk.chatuser.IUserPrivacyListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupManagerImpl;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BIMConversationMsg extends BIMConversation {
    public static String TAG = "BIMConversation";
    public ISendMessageListener mInternalSendMessageListener;
    public ChatMsg mLastChatMsg;

    /* renamed from: com.baidu.android.imsdk.BIMConversationMsg$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$imsdk$BIMConversation$MSGTYPE;

        static {
            int[] iArr = new int[BIMConversation.MSGTYPE.values().length];
            $SwitchMap$com$baidu$android$imsdk$BIMConversation$MSGTYPE = iArr;
            try {
                iArr[BIMConversation.MSGTYPE.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$BIMConversation$MSGTYPE[BIMConversation.MSGTYPE.MSG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$BIMConversation$MSGTYPE[BIMConversation.MSGTYPE.SYSTEMMSG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public BIMConversationMsg(Context context, BIMManager.CATEGORY category, String str, ChatSession chatSession) {
        super(context, category, str, chatSession);
        this.mInternalSendMessageListener = new ISendMessageListener() { // from class: com.baidu.android.imsdk.BIMConversationMsg.1
            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i, ChatMsg chatMsg) {
                String str2 = BIMConversationMsg.TAG;
                LogUtils.d(str2, "conversion onSendMessageResult" + i);
                if (i != 0 || chatMsg == null) {
                    return;
                }
                if (BIMConversationMsg.this.mLastChatMsg == null || BIMConversationMsg.this.mLastChatMsg.getMsgId() < chatMsg.getMsgId()) {
                    BIMConversationMsg.this.mLastChatMsg = chatMsg;
                }
            }
        };
        ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSync(this.session.getCategory(), this.session.getContacter(), 1, (ChatMsg) null);
        if (fetchMessageSync == null || fetchMessageSync.size() <= 0) {
            return;
        }
        this.mLastChatMsg = fetchMessageSync.get(fetchMessageSync.size() - 1);
    }

    private boolean checkChatMsg(ChatMsg chatMsg) {
        if (chatMsg != null && chatMsg.getCategory() == this.session.getCategory() && chatMsg.getContacter() == this.session.getContacter()) {
            return true;
        }
        String str = TAG;
        LogUtils.d(str, "msg doest not belong to the conversation." + chatMsg);
        return false;
    }

    private void handleFetchMessage(BIMConversation.MSGTYPE msgtype, ChatMsg chatMsg, int i, boolean z, IFetchMessageListener iFetchMessageListener) {
        ArrayList<ChatMsg> fetchMessageSync;
        int i2 = AnonymousClass4.$SwitchMap$com$baidu$android$imsdk$BIMConversation$MSGTYPE[msgtype.ordinal()];
        if (i2 == 1) {
            fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSync(this.session.getCategory(), this.session.getContacter(), i, z, chatMsg);
        } else if (i2 != 2) {
            fetchMessageSync = i2 != 3 ? null : ChatMsgManagerImpl.getInstance(this.mContext).fetchGroupNotifyMsgsSync(this.session.getCategory(), this.session.getContacter(), i, z, chatMsg);
        } else {
            fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSyncExceptSystemMsg(this.session.getCategory(), this.session.getContacter(), i, z, chatMsg);
        }
        if (fetchMessageSync != null && fetchMessageSync.size() > 0) {
            ChatMsg chatMsg2 = fetchMessageSync.get(fetchMessageSync.size() - 1);
            ChatMsg chatMsg3 = this.mLastChatMsg;
            if (chatMsg3 == null || chatMsg3.getMsgId() < chatMsg2.getMsgId()) {
                this.mLastChatMsg = chatMsg2;
            }
        }
        if (iFetchMessageListener != null) {
            iFetchMessageListener.onFetchMessageResult(0, fetchMessageSync);
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public long clear() {
        return ChatMsgManagerImpl.getInstance(this.mContext).deleteAllMsgs(this.mCategory.getValue(), this.session.getContacter(), this.isMulAppSync);
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public boolean deleteChatMsg(ChatMsg chatMsg) {
        if (checkChatMsg(chatMsg)) {
            int deleteMsgs = ChatMsgManagerImpl.getInstance(this.mContext).deleteMsgs(chatMsg);
            if (this.mLastChatMsg != null && chatMsg.getMsgId() == this.mLastChatMsg.getMsgId()) {
                ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSync(this.session.getCategory(), this.session.getContacter(), 1, (ChatMsg) null);
                if (fetchMessageSync != null && fetchMessageSync.size() > 0) {
                    this.mLastChatMsg = fetchMessageSync.get(fetchMessageSync.size() - 1);
                } else {
                    this.mLastChatMsg = null;
                }
            }
            return deleteMsgs == 0;
        }
        return false;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public int deleteDraftMessage() {
        return ChatMsgManagerImpl.getInstance(this.mContext).deleteDraftMsg(this.session.getCategory(), this.session.getContacter());
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void fetchMessage(BIMConversation.MSGTYPE msgtype, ChatMsg chatMsg, int i, boolean z, IFetchMessageListener iFetchMessageListener) {
        if (chatMsg == null || checkChatMsg(chatMsg)) {
            handleFetchMessage(msgtype, chatMsg, i, z, iFetchMessageListener);
        } else if (iFetchMessageListener != null) {
            iFetchMessageListener.onFetchMessageResult(1005, null);
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public BIMManager.CATEGORY getCategory() {
        return this.mCategory;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public int getChatType() {
        return this.session.getChatType();
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public ChatMsg getDraftMessage() {
        return ChatMsgManagerImpl.getInstance(this.mContext).getDraftMsg(this.session.getCategory(), this.session.getContacter());
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public String getIconUrl() {
        return this.session.getIconUrl();
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public String getId() {
        return String.valueOf(this.session.getContacterId());
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public ChatMsg getLastChatmsg() {
        return this.mLastChatMsg;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public long getLastMsgTime() {
        return this.session.getLastMsgTime();
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public String getName() {
        return this.session.getName();
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public long getUnReadChatMsgCount() {
        return this.session.getNewMsgSum();
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public boolean markMsgClicked(ChatMsg chatMsg) {
        return checkChatMsg(chatMsg) && ChatMsgManagerImpl.getInstance(this.mContext).markMessageClicked(chatMsg) != -1;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public int saveAsDraftMessage(ChatMsg chatMsg) {
        if (chatMsg.getMsgType() != 0) {
            LogUtils.d(TAG, " DraftMessage should be textmsg");
            return -1;
        }
        chatMsg.setCategory(this.session.getCategory());
        chatMsg.setContacter(this.session.getContacter());
        chatMsg.setFromUser(AccountManager.getUK(this.mContext));
        chatMsg.setSenderUid(AccountManagerImpl.getInstance(this.mContext).getUid());
        chatMsg.setStatus(1);
        chatMsg.setIsZhida(this.isMulAppSync);
        chatMsg.setMsgTime(System.currentTimeMillis() / 1000);
        return ChatMsgManagerImpl.getInstance(this.mContext).saveAsDraftMsg(chatMsg);
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public boolean setAllMessageReaded(ChatMsg chatMsg) {
        if (chatMsg != null) {
            if (checkChatMsg(chatMsg)) {
                return ChatMsgManagerImpl.getInstance(this.mContext).setBeforeMsgRead(this.session.getCategory(), this.session.getContacter(), chatMsg.getMsgId(), chatMsg.isZhida());
            }
            return false;
        }
        return ChatMsgManagerImpl.getInstance(this.mContext).setAllMsgRead(this.session.getCategory(), this.session.getContacter(), this.isMulAppSync);
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void setDisturb(int i, final BIMValueCallBack<String> bIMValueCallBack) {
        if (this.session.getCategory() == 1) {
            GroupManagerImpl.getInstance(this.mContext).setGroupDisturb(String.valueOf(this.session.getContacter()), i, bIMValueCallBack);
        } else {
            ChatUserManager.setUserDisturb(this.mContext, this.session.getContacter(), i, new IUserPrivacyListener() { // from class: com.baidu.android.imsdk.BIMConversationMsg.3
                @Override // com.baidu.android.imsdk.chatuser.IUserPrivacyListener
                public void onResult(int i2, String str) {
                    BIMValueCallBack bIMValueCallBack2 = bIMValueCallBack;
                    if (bIMValueCallBack2 != null) {
                        bIMValueCallBack2.onResult(i2, str, BIMConversationMsg.this.getId());
                    }
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public boolean setSingleMessageReaded(ChatMsg chatMsg) {
        if (checkChatMsg(chatMsg)) {
            return ChatMsgManagerImpl.getInstance(this.mContext).setMsgRead(this.session.getCategory(), this.session.getContacter(), chatMsg.getMsgId(), chatMsg.isZhida());
        }
        return false;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void updateConversation(ChatSession chatSession) {
        ChatSession chatSession2 = this.session;
        if (chatSession2 == null || chatSession2.getContacter() == chatSession.getContacter()) {
            this.session = chatSession;
            TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.BIMConversationMsg.2
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(BIMConversationMsg.this.mContext).fetchMessageSync(BIMConversationMsg.this.session.getCategory(), BIMConversationMsg.this.session.getContacter(), 1, (ChatMsg) null);
                    if (fetchMessageSync == null || fetchMessageSync.size() <= 0) {
                        return;
                    }
                    if (BIMConversationMsg.this.mLastChatMsg != null) {
                        if (BIMConversationMsg.this.mLastChatMsg == null || BIMConversationMsg.this.mLastChatMsg.getMsgId() < fetchMessageSync.get(0).getMsgId()) {
                            BIMConversationMsg.this.mLastChatMsg = fetchMessageSync.get(0);
                            return;
                        }
                        return;
                    }
                    BIMConversationMsg.this.mLastChatMsg = fetchMessageSync.get(0);
                }
            });
        }
    }
}
