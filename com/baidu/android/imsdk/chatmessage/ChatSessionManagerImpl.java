package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.DialogSyncMsg;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.UnSupportedMsg;
import com.baidu.android.imsdk.chatmessage.request.IMMediaContactorSettingRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaDeleteSessionRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaGetChatSessionRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaGetContactorPauidRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaGetContactorSettingRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaSetSessionReadRequest;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecord;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecordDBManager;
import com.baidu.android.imsdk.chatmessage.sync.SyncAllMessage;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Dispatcher;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.cyberplayer.sdk.dlna.DlnaManager;
import d.b.r.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ChatSessionManagerImpl {
    public static final String TAG = "SessionManagerImpl";
    public static Context mContext;
    public static volatile ChatSessionManagerImpl mInstance;
    public List<IDialogSyncListener> mDialogSyncListeners = new LinkedList();
    public ArrayList<IChatSessionChangeListener> mChatRecordChangeListener = new ArrayList<>();
    public ISyncDialogListener syncDialogListener = new ISyncDialogListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.3
        @Override // com.baidu.android.imsdk.chatmessage.ISyncDialogListener
        public void onSyncDialogResult(int i, String str, long j, List<ChatMsg> list) {
            if (i != 0 || list == null) {
                return;
            }
            LinkedList linkedList = null;
            for (ChatMsg chatMsg : list) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (chatMsg.getCategory() == 1) {
                    DialogRecord dialogRecord = DialogRecordDBManager.getInstance(ChatSessionManagerImpl.mContext).getDialogRecord(chatMsg.getCategory(), chatMsg.getContacter());
                    LogUtils.i(ChatSessionManagerImpl.TAG, " onSyncDialogResult " + chatMsg.getContacter() + " mmd: " + dialogRecord);
                    if (dialogRecord == null) {
                        dialogRecord = new DialogRecord();
                        dialogRecord.setCategory(chatMsg.getCategory()).setContacter(chatMsg.getContacter()).setJumpToRecent(1).setMaxMsgid(0L);
                    }
                    dialogRecord.setState(0).setUpdateTime(System.currentTimeMillis()).setDialogueMsgid(chatMsg.getMsgId());
                    linkedList.add(dialogRecord);
                }
            }
            LogUtils.i(ChatSessionManagerImpl.TAG, "add DialogRecord mmds : " + linkedList);
            if (DialogRecordDBManager.getInstance(ChatSessionManagerImpl.mContext).addBatch(linkedList) > 0) {
                Context context = ChatSessionManagerImpl.mContext;
                Utility.writeLongData(context, "sync_max_msgid_" + Utility.getUK(ChatSessionManagerImpl.mContext), j);
                Utility.writeIntData(ChatSessionManagerImpl.mContext, Constants.KEY_SYNC_FIRST_TIME, 0);
                for (DialogRecord dialogRecord2 : DialogRecordDBManager.getInstance(ChatSessionManagerImpl.mContext).getDialogRecord(-1)) {
                    SyncGroupMessageService.getInstance().execute(ChatSessionManagerImpl.mContext, dialogRecord2, 0);
                }
            }
        }
    };
    public Dispatcher.MsgListener dialogSyncListener = new Dispatcher.MsgListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.4
        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i, ChatMsg chatMsg) {
            int i2;
            if (chatMsg instanceof DialogSyncMsg) {
                DialogSyncMsg dialogSyncMsg = (DialogSyncMsg) chatMsg;
                int syncCategory = dialogSyncMsg.getSyncCategory();
                long syncFromUid = dialogSyncMsg.getSyncFromUid();
                long operatedMaxMsgid = dialogSyncMsg.getOperatedMaxMsgid();
                int syncStatus = dialogSyncMsg.getSyncStatus();
                long paid = dialogSyncMsg.getPaid();
                if (syncStatus == 0) {
                    i2 = syncStatus;
                    r16 = ChatMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).deleteAllMsgWithMsgid(new ChatObject(ChatSessionManagerImpl.mContext, syncCategory, syncFromUid, paid, -1), operatedMaxMsgid);
                    if (r16 > 0 && ChatSessionManagerImpl.this.mDialogSyncListeners != null && ChatSessionManagerImpl.this.mDialogSyncListeners.size() != 0) {
                        for (IDialogSyncListener iDialogSyncListener : ChatSessionManagerImpl.this.mDialogSyncListeners) {
                            iDialogSyncListener.onDialogDel(syncCategory, syncFromUid);
                        }
                    }
                } else if (syncStatus != 1) {
                    i2 = syncStatus;
                } else if (operatedMaxMsgid <= 0) {
                    return;
                } else {
                    i2 = syncStatus;
                    boolean allMsgReadWithMsgid = ChatMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).setAllMsgReadWithMsgid(new ChatObject(ChatSessionManagerImpl.mContext, syncCategory, syncFromUid, paid, -1), operatedMaxMsgid);
                    r16 = allMsgReadWithMsgid ? 1 : -1;
                    if (allMsgReadWithMsgid && ChatSessionManagerImpl.this.mDialogSyncListeners != null && ChatSessionManagerImpl.this.mDialogSyncListeners.size() != 0) {
                        for (IDialogSyncListener iDialogSyncListener2 : ChatSessionManagerImpl.this.mDialogSyncListeners) {
                            iDialogSyncListener2.onDialogDel(syncCategory, syncFromUid);
                        }
                    }
                }
                if (r16 > 0) {
                    Intent intent = new Intent(IMConstants.SYNC_ACTION);
                    intent.setPackage(ChatSessionManagerImpl.mContext.getApplicationContext().getPackageName());
                    intent.putExtra("category", syncCategory);
                    intent.putExtra("contacter", syncFromUid);
                    intent.putExtra(IMConstants.SYNC_MSGID, operatedMaxMsgid);
                    intent.putExtra(IMConstants.SYNC_STATUS, i2);
                    intent.putExtra(IMConstants.SYNC_TYPE, 1);
                    ChatSessionManagerImpl.mContext.sendBroadcast(intent);
                }
            }
        }

        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i, ArrayList<ChatMsg> arrayList) {
        }
    };

    public ChatSessionManagerImpl() {
        Dispatcher.Event event = new Dispatcher.Event();
        event.setCategory(2);
        event.setType(22);
        Dispatcher.registerListener(event, this.dialogSyncListener);
        ChatMessageDBManager.getInstance(mContext).registerObserver(new ChatMessageDBManager.ChatMessageDbOberser() { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.1
            @Override // com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.ChatMessageDbOberser
            public void notifyDbChange(int i, ChatSession chatSession) {
                ChatSessionManagerImpl.this.triggerChatSessionChangerCallBack(i, chatSession);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSessionChangeListenerNotify(int i, ChatSession chatSession, ArrayList<IChatSessionChangeListener> arrayList) {
        Iterator<IChatSessionChangeListener> it = arrayList.iterator();
        while (it.hasNext()) {
            IChatSessionChangeListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                boolean z = true;
                if (IMConfigInternal.getInstance().getProductLine(mContext) != 4 || chatSession.getCategory() == 1) {
                    if (i == 2) {
                        next.onChatRecordDelete(chatSession.getCategory(), chatSession.getContacter());
                    } else if (i == 1) {
                        LogUtils.d(TAG, "triggerChatSessionChange-> listener = " + next.getClass().getSimpleName());
                        try {
                            if (1 == chatSession.getCategory()) {
                                int state = SyncGroupMessageService.getInstance().getState(mContext);
                                if (state != 0) {
                                    z = false;
                                }
                                long contacter = chatSession.getContacter();
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(String.valueOf(contacter));
                                ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList2);
                                if (groupInfo != null && groupInfo.size() > 0 && groupInfo.get(0).getType() == 2) {
                                    chatSession.setChatType(4);
                                }
                                LogUtils.d(TAG, "FXF triggerChatSessionChange " + state + " " + z + " chattype: " + chatSession.getChatType() + " id is: " + chatSession.getContacter());
                                String lastMsg = chatSession.getLastMsg();
                                StringBuilder sb = new StringBuilder();
                                sb.append("FXF triggerChatSessionChange lastmsg is: ");
                                sb.append(lastMsg);
                                LogUtils.d(TAG, sb.toString());
                                next.onChatSessionUpdate(chatSession.m11clone(), z);
                            } else {
                                int state2 = SyncAllMessage.getInstance(mContext).getState();
                                if (state2 != 0) {
                                    z = false;
                                }
                                next.onChatSessionUpdate(chatSession.m11clone(), z);
                                LogUtils.d(TAG, "FXF triggerChatSessionChange " + state2 + " " + z + " chattype: " + chatSession.getChatType() + " id is: " + chatSession.getContacter());
                            }
                        } catch (CloneNotSupportedException e2) {
                            LogUtils.e(TAG, "ChatSessionChangerCallBack throw RuntimeException", e2);
                            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
                            throw new RuntimeException("ChatSession Clone Error!");
                        }
                    }
                }
            }
        }
    }

    public static ChatSessionManagerImpl getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ChatSessionManagerImpl.class) {
                if (mInstance == null) {
                    if (mContext == null) {
                        mContext = context.getApplicationContext();
                    }
                    mInstance = new ChatSessionManagerImpl();
                }
            }
        }
        return mInstance;
    }

    private long getMaxMsgid() {
        Context context = mContext;
        return Math.max(Utility.readLongData(context, "sync_max_msgid_" + Utility.getUK(mContext), 0L), DialogRecordDBManager.getInstance(mContext).getMaxMsgid());
    }

    private void notifySessionChange(final int i, final ChatSession chatSession) {
        final ArrayList arrayList = new ArrayList(this.mChatRecordChangeListener);
        if (arrayList.size() == 0) {
            return;
        }
        TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                ChatSessionManagerImpl.this.doSessionChangeListenerNotify(i, chatSession, arrayList);
            }
        });
    }

    private void updateGroupChatSession(ChatSession chatSession) {
        if (chatSession.getChatType() == 3 || chatSession.getChatType() == 4) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(chatSession.getContacter()));
            ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
            if (groupInfo == null || groupInfo.size() <= 0) {
                return;
            }
            LogUtils.d(TAG, "set session name as " + groupInfo.get(0).getGroupName());
            GroupInfo groupInfo2 = groupInfo.get(0);
            if (groupInfo2.getType() == 2) {
                chatSession.setChatType(4);
                if (TextUtils.isEmpty(chatSession.getName())) {
                    chatSession.setName(groupInfo2.getGroupName());
                }
                String headUrl = groupInfo2.getHeadUrl();
                if (!TextUtils.isEmpty(headUrl)) {
                    headUrl = headUrl.trim();
                }
                chatSession.setIconUrl(headUrl);
            }
        }
    }

    private void updatePADesc(ChatSession chatSession, String str) {
        int chatType = chatSession.getChatType();
        if (chatType == 7 || chatType == 16 || chatType == 17 || chatType == 27 || chatType == 23 || chatType == 25 || chatType == 26) {
            try {
                JSONObject jSONObject = new JSONObject(new JSONObject(str).optString("msg"));
                String optString = jSONObject.optString("ext");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                int optInt = new JSONObject(optString).optInt("type", -1);
                String optString2 = jSONObject.optString("description");
                if (TextUtils.isEmpty(optString2) || optInt == -1) {
                    return;
                }
                chatSession.setLastMsg(optString2);
            } catch (Exception e2) {
                LogUtils.e(TAG, "it doesn't matter>" + e2.getMessage());
            }
        }
    }

    private void updateUnsupportDesc(ChatSession chatSession, String str) {
        ChatMsg latestMsg;
        if (IMConstants.IS_UPDATE_VERSION && !TextUtils.isEmpty(str) && str.equals(UnSupportedMsg.unSupportedMsgDesc) && (latestMsg = ChatMessageDBManager.getInstance(mContext).getLatestMsg(chatSession.getCategory(), chatSession.getContacter())) != null && BIMManager.isSupportMsgType(latestMsg.getMsgType())) {
            String recommendDescription = latestMsg.getRecommendDescription();
            if (latestMsg instanceof HtmlMsg) {
                recommendDescription = ((HtmlMsg) latestMsg).getLocalUrl();
            }
            if (TextUtils.isEmpty(recommendDescription) || str.equals(recommendDescription)) {
                return;
            }
            chatSession.setLastMsg(recommendDescription);
            ChatMessageDBManager.getInstance(mContext).updateChatSession(1, chatSession);
        }
    }

    public void createChatSession(ChatObject chatObject, String str, int i, String str2, int i2, String str3, String str4, int i3, int i4, long j, int i5, long j2, String str5, String str6, String str7) {
        long createChatSession = ChatMessageDBManager.getInstance(mContext).createChatSession(chatObject, str, i, str2, i2, str3, str4, i3, i4, j, i5, j2, str5, str6, str7);
        LogUtils.i(TAG, "createChatSession result : " + createChatSession + " chatType: " + i + "  name:" + str);
        if (createChatSession > 0) {
            ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(mContext).fetchMessageSync(chatObject.getCategory(), chatObject.getContacter(), 50, (ChatMsg) null);
            if (fetchMessageSync != null && fetchMessageSync.size() != 0) {
                for (int i6 = 0; i6 < fetchMessageSync.size(); i6++) {
                    fetchMessageSync.get(i6).setChatType(i);
                }
                ChatMsgManagerImpl.getInstance(mContext).broadcastMessage(fetchMessageSync, true);
                return;
            }
            LogUtils.i(TAG, "createChatSession:  fetch msgs is null : ");
        }
    }

    public boolean deleteChatSession(ChatSession chatSession) {
        long paid = ChatMsgManagerImpl.getInstance(mContext).getPaid();
        return paid != -2 && ChatMessageDBManager.getInstance(mContext).delChatRecord(new ChatObject(mContext, chatSession.getCategory(), chatSession.getContacter(), paid, -1)) >= 0;
    }

    public ArrayList<SessionClass> getAllClassType() {
        ArrayList<SessionClass> allClassType = ChatMessageDBManager.getInstance(mContext).getAllClassType();
        if (allClassType != null && allClassType.size() > 0) {
            Iterator<SessionClass> it = allClassType.iterator();
            while (it.hasNext()) {
                SessionClass next = it.next();
                next.setUnread(ChatMessageDBManager.getInstance(mContext).getNewMsgCountOfClass(next.getType()));
                LogUtils.d(TAG, " class session is " + next.getType() + " " + next.getTitle() + " " + next.getUnread());
            }
        }
        return allClassType;
    }

    public ChatSession getChatRecord(int i, long j) {
        LogUtils.enter();
        long paid = ChatMsgManagerImpl.getInstance(mContext).getPaid();
        if (paid == -2) {
            LogUtils.e(TAG, "getPaid() == Constants.CRM_ZHIDAID_NOT_SET");
            return null;
        }
        ChatSession chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(new ChatObject(mContext, i, j, paid, -1));
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(j));
            ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
            if (groupInfo != null && groupInfo.size() > 0 && groupInfo.get(0).getType() == 2 && chatRecord != null) {
                chatRecord.setChatType(4);
            }
        }
        return chatRecord;
    }

    public ArrayList<ChatSession> getChatRecords(long j, long j2, List<Integer> list) {
        long paid = ChatMsgManagerImpl.getInstance(mContext).getPaid();
        if (paid == -2) {
            LogUtils.d(TAG, "getChatRecords CRM_ZHIDAID_NOT_SET");
            return null;
        }
        ArrayList<ChatSession> chatRecords = ChatMessageDBManager.getInstance(mContext).getChatRecords(j, j2, paid, list);
        if (chatRecords != null && chatRecords.size() > 0) {
            LogUtils.d(TAG, "getChatRecords :" + chatRecords.size());
            Iterator<ChatSession> it = chatRecords.iterator();
            while (it.hasNext()) {
                ChatSession next = it.next();
                updateGroupChatSession(next);
                String lastMsg = next.getLastMsg();
                updateUnsupportDesc(next, lastMsg);
                updatePADesc(next, lastMsg);
            }
        }
        return chatRecords;
    }

    public ArrayList<ChatSession> getChatRecordsByClass(long j, long j2, List<Integer> list) {
        if (AccountManager.isLogin(mContext)) {
            long paid = ChatMsgManagerImpl.getInstance(mContext).getPaid();
            if (paid == -2) {
                return null;
            }
            return ChatMessageDBManager.getInstance(mContext).getChatRecordsByClass(j, j2, paid, list);
        }
        return null;
    }

    public List<ChatSession> getGroupSession() {
        return ChatMessageDBManager.getInstance(mContext).getGroupSession();
    }

    public int hideAllChatSession() {
        long paid = ChatMsgManagerImpl.getInstance(mContext).getPaid();
        return paid == -2 ? DlnaManager.DLNA_ERROR_CREATE_SSDP_THREAD_FIAL : ChatMessageDBManager.getInstance(mContext).deleteChatSession(paid);
    }

    public void mediaContactorSetting(long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", operation" + i + ", listener=" + iMediaContactorSettingListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaContactorSettingRequest iMMediaContactorSettingRequest = new IMMediaContactorSettingRequest(mContext, j, i, ListenerManager.getInstance().addListener(iMediaContactorSettingListener));
            HttpHelper.executor(mContext, iMMediaContactorSettingRequest, iMMediaContactorSettingRequest);
        } else if (iMediaContactorSettingListener != null) {
            iMediaContactorSettingListener.onMediaContactorSettingResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR, -1);
        }
    }

    public void mediaDeleteChatSession(long j, long j2, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", lastTime=" + j2 + ", listener=" + iMediaDeleteChatSessionListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaDeleteChatSessionListener != null) {
                iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaDeleteSessionRequest iMMediaDeleteSessionRequest = new IMMediaDeleteSessionRequest(mContext, j, j2, ListenerManager.getInstance().addListener(iMediaDeleteChatSessionListener));
            HttpHelper.executor(mContext, iMMediaDeleteSessionRequest, iMMediaDeleteSessionRequest);
        } else if (iMediaDeleteChatSessionListener != null) {
            iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
        }
    }

    public void mediaGetChatSessions(long j, int i, long j2, String str, long j3, int i2, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", startSessionTime=" + j3 + ", count=" + i2 + ", listener=" + iMediaGetChatSessionListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaGetChatSessionListener != null) {
                iMediaGetChatSessionListener.onMediaGetChatSessionResult(1000, 0, false, null);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaGetChatSessionRequest iMMediaGetChatSessionRequest = new IMMediaGetChatSessionRequest(mContext, j, i, j2, str, i2, j3, ListenerManager.getInstance().addListener(iMediaGetChatSessionListener));
            HttpHelper.executor(mContext, iMMediaGetChatSessionRequest, iMMediaGetChatSessionRequest);
        } else if (iMediaGetChatSessionListener != null) {
            iMediaGetChatSessionListener.onMediaGetChatSessionResult(2000, 0, false, null);
        }
    }

    public void mediaGetContactorPauid(long j, int i, long j2, String str, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", listener=" + iMediaGetContactorPauidListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaGetContactorPauidListener != null) {
                iMediaGetContactorPauidListener.onMediaGetContactorPauidResult(1000, -1L, -1, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                return;
            }
            return;
        }
        IMMediaGetContactorPauidRequest iMMediaGetContactorPauidRequest = new IMMediaGetContactorPauidRequest(mContext, j, i, j2, str, ListenerManager.getInstance().addListener(iMediaGetContactorPauidListener));
        HttpHelper.executor(mContext, iMMediaGetContactorPauidRequest, iMMediaGetContactorPauidRequest);
    }

    public void mediaGetContactorSetting(long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", setting=" + i + ", listener=" + iMediaContactorSettingListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1);
                return;
            }
            return;
        }
        IMMediaGetContactorSettingRequest iMMediaGetContactorSettingRequest = new IMMediaGetContactorSettingRequest(mContext, j, i, ListenerManager.getInstance().addListener(iMediaContactorSettingListener));
        HttpHelper.executor(mContext, iMMediaGetContactorSettingRequest, iMMediaGetContactorSettingRequest);
    }

    public void mediaSetSessionRead(long j, int i, long j2, String str, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", lastTime=" + j3 + ", listener=" + iMediaSetSessionReadListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaSetSessionReadListener != null) {
                iMediaSetSessionReadListener.onMediaSetSessionReadResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaSetSessionReadRequest iMMediaSetSessionReadRequest = new IMMediaSetSessionReadRequest(mContext, j, i, j2, str, j3, ListenerManager.getInstance().addListener(iMediaSetSessionReadListener));
            HttpHelper.executor(mContext, iMMediaSetSessionReadRequest, iMMediaSetSessionReadRequest);
        } else if (iMediaSetSessionReadListener != null) {
            iMediaSetSessionReadListener.onMediaSetSessionReadResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
        }
    }

    public void onMediaGetChatSessionRequest(int i, boolean z, int i2, Map<Long, ChatSession> map, Map<Long, ChatSession> map2, String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        IMediaGetChatSessionListener iMediaGetChatSessionListener = (IMediaGetChatSessionListener) ListenerManager.getInstance().removeListener(str);
        if (iMediaGetChatSessionListener == null) {
            return;
        }
        if (i == 0) {
            IMMediaBuildSessionListener iMMediaBuildSessionListener = new IMMediaBuildSessionListener(mContext, i2, z, iMediaGetChatSessionListener);
            if (map2 == null || map2.size() <= 0) {
                arrayList = null;
            } else {
                iMMediaBuildSessionListener.setUserMap(map2);
                arrayList = new ArrayList(map2.keySet());
            }
            if (map == null || map.size() <= 0) {
                arrayList2 = null;
            } else {
                iMMediaBuildSessionListener.setPaMap(map);
                arrayList2 = new ArrayList(map.keySet());
            }
            if (arrayList != null) {
                ChatUserManagerImpl.getInstance(mContext).updateUserIdentity(arrayList, iMMediaBuildSessionListener);
            }
            if (arrayList2 != null) {
                PaManager.getPaInfos(mContext, arrayList2, iMMediaBuildSessionListener);
            }
            if (arrayList == null && arrayList2 == null) {
                iMediaGetChatSessionListener.onMediaGetChatSessionResult(i, i2, z, null);
                return;
            }
            return;
        }
        iMediaGetChatSessionListener.onMediaGetChatSessionResult(i, i2, z, null);
    }

    public void onSyncComplete() {
        Iterator<IChatSessionChangeListener> it = this.mChatRecordChangeListener.iterator();
        while (it.hasNext()) {
            IChatSessionChangeListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onChatSessionUpdate(null, false);
            }
        }
    }

    public void onSyncDialogResult(int i, String str, String str2, long j, List<ChatMsg> list) {
        LogUtils.d(TAG, String.format("--onSyncDialogResult--errCode:%d--msg:%s--maxMsgid:%d", Integer.valueOf(i), str, Long.valueOf(j)));
        IMListener removeListener = ListenerManager.getInstance().removeListener(str2);
        if (removeListener != null && (removeListener instanceof ISyncDialogListener)) {
            ((ISyncDialogListener) removeListener).onSyncDialogResult(i, str, j, list);
        } else {
            LogUtils.d(TAG, "onSyncDialogResult listener is nul!");
        }
    }

    public void registerDialogSyncListener(Context context, IDialogSyncListener iDialogSyncListener) {
        if (iDialogSyncListener == null || this.mDialogSyncListeners.contains(iDialogSyncListener)) {
            return;
        }
        this.mDialogSyncListeners.add(iDialogSyncListener);
    }

    public void registerRecordChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        if (iChatSessionChangeListener == null || this.mChatRecordChangeListener.contains(iChatSessionChangeListener)) {
            return;
        }
        this.mChatRecordChangeListener.add(iChatSessionChangeListener);
    }

    public void syncDialog() {
        ISyncDialogListener iSyncDialogListener = this.syncDialogListener;
        if (iSyncDialogListener == null) {
            return;
        }
        String addListener = ListenerManager.getInstance().addListener(iSyncDialogListener);
        long maxMsgid = getMaxMsgid();
        if (maxMsgid < 0) {
            iSyncDialogListener.onSyncDialogResult(1009, Constants.ERROR_MSG_INTERNAL_DB_ERROR, maxMsgid, null);
        }
        if (!LoginManager.getInstance(mContext).isIMLogined()) {
            iSyncDialogListener.onSyncDialogResult(5, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1L, null);
            LogUtils.d(TAG, "syncDialog methodId :94 by intercept because unlogin ");
            return;
        }
        Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 94);
        creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, maxMsgid);
        creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
        try {
            a.e(mContext).d(mContext, creatMethodIntent);
        } catch (Exception e2) {
            onSyncDialogResult(1003, Constants.ERROR_MSG_SERVICE_ERROR, addListener, maxMsgid, null);
            LogUtils.e(TAG, "Exception ", e2);
        }
    }

    public void triggerChatSessionChangerCallBack(int i, ChatSession chatSession) {
        if (chatSession == null) {
            return;
        }
        if (IMConfigInternal.getInstance().getIMConfig(mContext).isNeedPaid()) {
            if (Utility.getPaid(mContext) == -1 || chatSession == null) {
                return;
            }
            if (Utility.getPaid(mContext) == chatSession.getPaid() || Utility.getNotifyPaid(mContext) == chatSession.getPaid()) {
                notifySessionChange(i, chatSession);
                return;
            }
            return;
        }
        notifySessionChange(i, chatSession);
    }

    public void unregisterDialogSyncListener(Context context, IDialogSyncListener iDialogSyncListener) {
        if (iDialogSyncListener == null || !this.mDialogSyncListeners.contains(iDialogSyncListener)) {
            return;
        }
        this.mDialogSyncListeners.remove(iDialogSyncListener);
    }

    public void unregisterMessageReceiveListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        if (iChatSessionChangeListener == null || !this.mChatRecordChangeListener.contains(iChatSessionChangeListener)) {
            return;
        }
        this.mChatRecordChangeListener.remove(iChatSessionChangeListener);
    }

    public void mediaGetContactorPauid(long j, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", listener=" + iMediaGetContactorPauidListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaGetContactorPauidListener != null) {
                iMediaGetContactorPauidListener.onMediaGetContactorPauidResult(1000, -1L, -1, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                return;
            }
            return;
        }
        IMMediaGetContactorPauidRequest iMMediaGetContactorPauidRequest = new IMMediaGetContactorPauidRequest(mContext, j, ListenerManager.getInstance().addListener(iMediaGetContactorPauidListener));
        HttpHelper.executor(mContext, iMMediaGetContactorPauidRequest, iMMediaGetContactorPauidRequest);
    }

    public void mediaGetContactorSetting(long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", setting=" + i2 + ", listener=" + iMediaContactorSettingListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaGetContactorSettingRequest iMMediaGetContactorSettingRequest = new IMMediaGetContactorSettingRequest(mContext, j, i, j2, str, i2, ListenerManager.getInstance().addListener(iMediaContactorSettingListener));
            HttpHelper.executor(mContext, iMMediaGetContactorSettingRequest, iMMediaGetContactorSettingRequest);
        } else if (iMediaContactorSettingListener != null) {
            iMediaContactorSettingListener.onMediaContactorSettingResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR, -1);
        }
    }

    public void mediaContactorSetting(long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", operation" + i2 + ", listener=" + iMediaContactorSettingListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaContactorSettingRequest iMMediaContactorSettingRequest = new IMMediaContactorSettingRequest(mContext, j, i, j2, str, i2, ListenerManager.getInstance().addListener(iMediaContactorSettingListener));
            HttpHelper.executor(mContext, iMMediaContactorSettingRequest, iMMediaContactorSettingRequest);
        } else if (iMediaContactorSettingListener != null) {
            iMediaContactorSettingListener.onMediaContactorSettingResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR, -1);
        }
    }

    public void mediaDeleteChatSession(long j, int i, long j2, String str, long j3, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", lastTime=" + j3 + ", listener=" + iMediaDeleteChatSessionListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaDeleteChatSessionListener != null) {
                iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaDeleteSessionRequest iMMediaDeleteSessionRequest = new IMMediaDeleteSessionRequest(mContext, j, i, j2, str, j3, ListenerManager.getInstance().addListener(iMediaDeleteChatSessionListener));
            HttpHelper.executor(mContext, iMMediaDeleteSessionRequest, iMMediaDeleteSessionRequest);
        } else if (iMediaDeleteChatSessionListener != null) {
            iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
        }
    }

    public void mediaGetChatSessions(long j, long j2, int i, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", startSessionTime=" + j2 + ", count=" + i + ", listener=" + iMediaGetChatSessionListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaGetChatSessionListener != null) {
                iMediaGetChatSessionListener.onMediaGetChatSessionResult(1000, 0, false, null);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaGetChatSessionRequest iMMediaGetChatSessionRequest = new IMMediaGetChatSessionRequest(mContext, j, i, j2, ListenerManager.getInstance().addListener(iMediaGetChatSessionListener));
            HttpHelper.executor(mContext, iMMediaGetChatSessionRequest, iMMediaGetChatSessionRequest);
        } else if (iMediaGetChatSessionListener != null) {
            iMediaGetChatSessionListener.onMediaGetChatSessionResult(2000, 0, false, null);
        }
    }

    public void mediaSetSessionRead(long j, long j2, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", lastTime" + j2 + ", listener=" + iMediaSetSessionReadListener);
        if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
            if (iMediaSetSessionReadListener != null) {
                iMediaSetSessionReadListener.onMediaSetSessionReadResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        } else if (AccountManager.getMediaRole(mContext)) {
            IMMediaSetSessionReadRequest iMMediaSetSessionReadRequest = new IMMediaSetSessionReadRequest(mContext, j, j2, ListenerManager.getInstance().addListener(iMediaSetSessionReadListener));
            HttpHelper.executor(mContext, iMMediaSetSessionReadRequest, iMMediaSetSessionReadRequest);
        } else if (iMediaSetSessionReadListener != null) {
            iMediaSetSessionReadListener.onMediaSetSessionReadResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
        }
    }

    public ChatSession getChatRecord(int i, long j, long j2) {
        LogUtils.enter();
        if (ChatMsgManagerImpl.getInstance(mContext).getPaid() == -2) {
            LogUtils.e(TAG, "getPaid() == Constants.CRM_ZHIDAID_NOT_SET");
            return null;
        }
        ChatSession chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(i, j, j2);
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(j));
            ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
            if (groupInfo != null && groupInfo.size() > 0 && groupInfo.get(0).getType() == 2 && chatRecord != null) {
                chatRecord.setChatType(4);
            }
        }
        return chatRecord;
    }

    public ArrayList<ChatSession> getChatRecords(long j, long j2) {
        LogUtils.enter();
        if (AccountManager.isLogin(mContext)) {
            long paid = ChatMsgManagerImpl.getInstance(mContext).getPaid();
            LogUtils.e(TAG, "AccountManager.isLogin(mContext)");
            if (paid == -2) {
                LogUtils.e(TAG, "getPaid() == Constants.CRM_ZHIDAID_NOT_SET");
                return null;
            }
            return ChatMessageDBManager.getInstance(mContext).getChatRecords(j, j2, paid);
        }
        return null;
    }
}
