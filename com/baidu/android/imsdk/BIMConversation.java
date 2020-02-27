package com.baidu.android.imsdk;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.IFetchMessageListener;
import com.baidu.android.imsdk.chatmessage.IMessageReceiveListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener;
import com.baidu.android.imsdk.chatmessage.messages.AudioMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.android.imsdk.chatmessage.messages.RichMediaMsg;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManager;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUserListener;
import com.baidu.android.imsdk.chatuser.IUserPrivacyListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupManagerImpl;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.mcast.CastServiceFactory;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.android.imsdk.mcast.McastManagerImpl;
import com.baidu.android.imsdk.mcast.UnLoginCastService;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class BIMConversation implements NoProGuard {
    private static String TAG = "BIMConversation";
    private boolean isMulAppSync;
    private String mCastId;
    IMcastSetListener mCastListener;
    UnLoginCastService mCastService;
    private int mCastType;
    private String mCastUrl;
    private BIMManager.CATEGORY mCategory;
    private Context mContext;
    private ISendMessageListener mInternalSendMessageListener;
    private ChatMsg mLastChatMsg;
    private ChatSession session;

    /* loaded from: classes3.dex */
    public enum MSGTYPE {
        ALL,
        MSG,
        SYSTEMMSG
    }

    public BIMConversation(Context context, BIMManager.CATEGORY category, String str, ChatSession chatSession) {
        this.isMulAppSync = false;
        this.mCategory = BIMManager.CATEGORY.UNKOWN;
        this.mCastUrl = null;
        this.mCastId = "";
        this.mCastService = null;
        this.mInternalSendMessageListener = new ISendMessageListener() { // from class: com.baidu.android.imsdk.BIMConversation.1
            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i, ChatMsg chatMsg) {
                LogUtils.d(BIMConversation.TAG, "conversion onSendMessageResult" + i);
                if (i == 0 && chatMsg != null) {
                    if (BIMConversation.this.mLastChatMsg == null || BIMConversation.this.mLastChatMsg.getMsgId() < chatMsg.getMsgId()) {
                        BIMConversation.this.mLastChatMsg = chatMsg;
                    }
                }
            }
        };
        this.mContext = context.getApplicationContext();
        this.session = chatSession;
        this.mCategory = category;
        this.mCastId = str;
        ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSync(this.session.getCategory(), this.session.getContacter(), 1, (ChatMsg) null);
        if (fetchMessageSync != null && fetchMessageSync.size() > 0) {
            this.mLastChatMsg = fetchMessageSync.get(fetchMessageSync.size() - 1);
        }
    }

    public BIMConversation(Context context, BIMManager.CATEGORY category, String str, ChatSession chatSession, String str2, int i) {
        this.isMulAppSync = false;
        this.mCategory = BIMManager.CATEGORY.UNKOWN;
        this.mCastUrl = null;
        this.mCastId = "";
        this.mCastService = null;
        this.mInternalSendMessageListener = new ISendMessageListener() { // from class: com.baidu.android.imsdk.BIMConversation.1
            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i2, ChatMsg chatMsg) {
                LogUtils.d(BIMConversation.TAG, "conversion onSendMessageResult" + i2);
                if (i2 == 0 && chatMsg != null) {
                    if (BIMConversation.this.mLastChatMsg == null || BIMConversation.this.mLastChatMsg.getMsgId() < chatMsg.getMsgId()) {
                        BIMConversation.this.mLastChatMsg = chatMsg;
                    }
                }
            }
        };
        this.mContext = context.getApplicationContext();
        this.session = chatSession;
        this.mCategory = category;
        this.mCastUrl = str2;
        this.mCastType = i;
        this.mCastId = str;
    }

    public void updateConversation(ChatSession chatSession) {
        if (this.session == null || this.session.getContacter() == chatSession.getContacter()) {
            this.session = chatSession;
            TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.BIMConversation.2
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(BIMConversation.this.mContext).fetchMessageSync(BIMConversation.this.session.getCategory(), BIMConversation.this.session.getContacter(), 1, (ChatMsg) null);
                    if (fetchMessageSync != null && fetchMessageSync.size() > 0) {
                        if (BIMConversation.this.mLastChatMsg != null) {
                            if (BIMConversation.this.mLastChatMsg == null || BIMConversation.this.mLastChatMsg.getMsgId() < fetchMessageSync.get(0).getMsgId()) {
                                BIMConversation.this.mLastChatMsg = fetchMessageSync.get(0);
                                return;
                            }
                            return;
                        }
                        BIMConversation.this.mLastChatMsg = fetchMessageSync.get(0);
                    }
                }
            });
        }
    }

    public ChatSession getChatSession() {
        return this.session;
    }

    private void handleUpload(final RichMediaMsg richMediaMsg, final ISendMessageListener iSendMessageListener) {
        new AsyncChatTask(this.mContext, richMediaMsg, new IUploadTransferListener() { // from class: com.baidu.android.imsdk.BIMConversation.3
            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFailed(int i, int i2, String str) {
                richMediaMsg.setStatus(2);
                ChatMsgManagerImpl.getInstance(BIMConversation.this.mContext).onSendMessageResult(i, richMediaMsg, -1L, null);
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFinished(int i, String str) {
                if (richMediaMsg.getMsgType() == 1) {
                    ((ImageMsg) richMediaMsg).setContent(str);
                } else if (richMediaMsg.getMsgType() == 2) {
                    AudioMsg audioMsg = (AudioMsg) richMediaMsg;
                    audioMsg.setContent(str, audioMsg.getFormat(), audioMsg.getDuration());
                }
                ChatMsgManagerImpl.getInstance(BIMConversation.this.mContext).sendMessage(richMediaMsg, iSendMessageListener);
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onProgress(int i) {
                richMediaMsg.setProgress(i);
            }
        }).execute();
    }

    public ChatMsg sendMessage(final ChatMsg chatMsg, final ISendMessageStatusListener iSendMessageStatusListener, final ISendMessageListener iSendMessageListener) {
        if (chatMsg != null) {
            if (this.session.getContacter() < 0) {
                if (BIMManager.CATEGORY.SINGLEPERSON == this.mCategory) {
                    ChatUserManagerImpl.getInstance(this.mContext).getUserByBuid(this.session.getContacterId(), 0, new IGetUserListener() { // from class: com.baidu.android.imsdk.BIMConversation.4
                        @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
                        public void onGetUserResult(int i, long j, ChatUser chatUser) {
                            if (i == 0 && chatUser != null) {
                                BIMConversation.this.session.setContacter(chatUser.getUk());
                                BIMConversation.this.senMessageInternal(chatMsg, iSendMessageStatusListener, iSendMessageListener);
                            } else if (iSendMessageStatusListener != null) {
                                iSendMessageStatusListener.onSendStatus(2, chatMsg);
                            }
                        }
                    });
                }
            } else {
                senMessageInternal(chatMsg, iSendMessageStatusListener, iSendMessageListener);
            }
        }
        return chatMsg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void senMessageInternal(ChatMsg chatMsg, ISendMessageStatusListener iSendMessageStatusListener, ISendMessageListener iSendMessageListener) {
        chatMsg.setCategory(this.session.getCategory());
        chatMsg.setContacter(this.session.getContacter());
        chatMsg.setFromUser(AccountManager.getUK(this.mContext));
        chatMsg.setSenderUid(AccountManagerImpl.getInstance(this.mContext).getUid());
        chatMsg.setStatus(1);
        chatMsg.setIsZhida(this.isMulAppSync);
        chatMsg.setMsgTime(System.currentTimeMillis() / 1000);
        chatMsg.setListenerKey(ListenerManager.getInstance().addListener(iSendMessageStatusListener));
        switch (chatMsg.getMsgType()) {
            case 1:
                ImageMsg imageMsg = (ImageMsg) chatMsg;
                imageMsg.setContent(imageMsg.getLocalUrl(), imageMsg.getWidth(), imageMsg.getHeight());
                handleRichMediaMsg(chatMsg, iSendMessageListener);
                return;
            case 2:
                AudioMsg audioMsg = (AudioMsg) chatMsg;
                audioMsg.setContent(audioMsg.getLocalUrl(), audioMsg.getFormat(), audioMsg.getDuration());
                handleRichMediaMsg(chatMsg, iSendMessageListener);
                return;
            default:
                ChatMsgManagerImpl.getInstance(this.mContext).sendMessage(chatMsg, iSendMessageListener);
                return;
        }
    }

    private void handleRichMediaMsg(ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        try {
            RichMediaMsg richMediaMsg = (RichMediaMsg) chatMsg;
            if (richMediaMsg.getLocalUrl() != null) {
                ChatMsgManagerImpl.getInstance(this.mContext).saveMessage(chatMsg);
                handleUpload(richMediaMsg, iSendMessageListener);
                return;
            }
            ISendMessageStatusListener iSendMessageStatusListener = (ISendMessageStatusListener) ListenerManager.getInstance().removeListener(chatMsg.mListenerKey);
            if (iSendMessageStatusListener != null) {
                iSendMessageStatusListener.onSendStatus(1007, chatMsg);
            }
            LogUtils.e(TAG, "local url should be not null.");
        } catch (ClassCastException e) {
            LogUtils.e(TAG, "sendMessage", e);
            ISendMessageStatusListener iSendMessageStatusListener2 = (ISendMessageStatusListener) ListenerManager.getInstance().removeListener(chatMsg.mListenerKey);
            if (iSendMessageStatusListener2 != null) {
                iSendMessageStatusListener2.onSendStatus(1007, chatMsg);
            }
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

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

    public boolean markMsgClicked(ChatMsg chatMsg) {
        return checkChatMsg(chatMsg) && ChatMsgManagerImpl.getInstance(this.mContext).markMessageClicked(chatMsg) != -1;
    }

    public ChatMsg getLastChatmsg() {
        return this.mLastChatMsg;
    }

    public boolean setSingleMessageReaded(ChatMsg chatMsg) {
        if (checkChatMsg(chatMsg)) {
            return ChatMsgManagerImpl.getInstance(this.mContext).setMsgRead(this.session.getCategory(), this.session.getContacter(), chatMsg.getMsgId(), chatMsg.isZhida());
        }
        return false;
    }

    public boolean setAllMessageReaded(ChatMsg chatMsg) {
        if (chatMsg != null) {
            if (checkChatMsg(chatMsg)) {
                return ChatMsgManagerImpl.getInstance(this.mContext).setBeforeMsgRead(this.session.getCategory(), this.session.getContacter(), chatMsg.getMsgId(), chatMsg.isZhida());
            }
            return false;
        }
        return ChatMsgManagerImpl.getInstance(this.mContext).setAllMsgRead(this.session.getCategory(), this.session.getContacter(), this.isMulAppSync);
    }

    public void setDisturb(int i, final BIMValueCallBack<String> bIMValueCallBack) {
        if (this.session.getCategory() == 1) {
            GroupManagerImpl.getInstance(this.mContext).setGroupDisturb(String.valueOf(this.session.getContacter()), i, bIMValueCallBack);
        } else {
            ChatUserManager.setUserDisturb(this.mContext, this.session.getContacter(), i, new IUserPrivacyListener() { // from class: com.baidu.android.imsdk.BIMConversation.5
                @Override // com.baidu.android.imsdk.chatuser.IUserPrivacyListener
                public void onResult(int i2, String str) {
                    if (bIMValueCallBack != null) {
                        bIMValueCallBack.onResult(i2, str, BIMConversation.this.getId());
                    }
                }
            });
        }
    }

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

    public int deleteDraftMessage() {
        return ChatMsgManagerImpl.getInstance(this.mContext).deleteDraftMsg(this.session.getCategory(), this.session.getContacter());
    }

    public ChatMsg getDraftMessage() {
        return ChatMsgManagerImpl.getInstance(this.mContext).getDraftMsg(this.session.getCategory(), this.session.getContacter());
    }

    public long getUnReadChatMsgCount() {
        return this.session.getNewMsgSum();
    }

    public void fetchMessage(MSGTYPE msgtype, ChatMsg chatMsg, int i, boolean z, IFetchMessageListener iFetchMessageListener) {
        if (chatMsg != null && !checkChatMsg(chatMsg)) {
            if (iFetchMessageListener != null) {
                iFetchMessageListener.onFetchMessageResult(1005, null);
                return;
            }
            return;
        }
        handleFetchMessage(msgtype, chatMsg, i, z, iFetchMessageListener);
    }

    private void handleFetchMessage(MSGTYPE msgtype, ChatMsg chatMsg, int i, boolean z, IFetchMessageListener iFetchMessageListener) {
        ArrayList<ChatMsg> fetchGroupNotifyMsgsSync;
        switch (msgtype) {
            case ALL:
                fetchGroupNotifyMsgsSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSync(this.session.getCategory(), this.session.getContacter(), i, z, chatMsg);
                break;
            case MSG:
                fetchGroupNotifyMsgsSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSyncExceptSystemMsg(this.session.getCategory(), this.session.getContacter(), i, z, chatMsg);
                break;
            case SYSTEMMSG:
                fetchGroupNotifyMsgsSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchGroupNotifyMsgsSync(this.session.getCategory(), this.session.getContacter(), i, z, chatMsg);
                break;
            default:
                fetchGroupNotifyMsgsSync = null;
                break;
        }
        if (fetchGroupNotifyMsgsSync != null && fetchGroupNotifyMsgsSync.size() > 0) {
            ChatMsg chatMsg2 = fetchGroupNotifyMsgsSync.get(fetchGroupNotifyMsgsSync.size() - 1);
            if (this.mLastChatMsg == null || this.mLastChatMsg.getMsgId() < chatMsg2.getMsgId()) {
                this.mLastChatMsg = chatMsg2;
            }
        }
        if (iFetchMessageListener != null) {
            iFetchMessageListener.onFetchMessageResult(0, fetchGroupNotifyMsgsSync);
        }
    }

    public String getId() {
        return String.valueOf(this.session.getContacterId());
    }

    public String getName() {
        return this.session.getName();
    }

    public long getLastMsgTime() {
        return this.session.getLastMsgTime();
    }

    public BIMManager.CATEGORY getCategory() {
        return this.mCategory;
    }

    public String getIconUrl() {
        return this.session.getIconUrl();
    }

    public int getChatType() {
        return this.session.getChatType();
    }

    public long clear() {
        return ChatMsgManagerImpl.getInstance(this.mContext).deleteAllMsgs(this.mCategory.getValue(), this.session.getContacter(), this.isMulAppSync);
    }

    private boolean checkChatMsg(ChatMsg chatMsg) {
        if (chatMsg != null && chatMsg.getCategory() == this.session.getCategory() && chatMsg.getContacter() == this.session.getContacter()) {
            return true;
        }
        LogUtils.d(TAG, "msg doest not belong to the conversation." + chatMsg);
        return false;
    }

    public void registerLiveMsgReceiveListener(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        ChatMsgManagerImpl.getInstance(this.mContext).registerLiveMsgReceiveListener(iLiveMsgReceiveListener);
    }

    public void registerLiveMsgReceiveListener(long j, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        ChatMsgManagerImpl.getInstance(this.mContext).registerLiveMsgReceiveListener(j + "", iLiveMsgReceiveListener);
    }

    public void registerLiveMsgReceiveListener(long j, boolean z, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        McastManagerImpl.getInstance(this.mContext).setCastIdReliable(j, z);
        ChatMsgManagerImpl.getInstance(this.mContext).registerLiveMsgReceiveListener(j + "", iLiveMsgReceiveListener);
    }

    public void unregisterLiveMsgReceiveListener(String str, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        McastManagerImpl.getInstance(this.mContext).clearReliableCastList();
        ChatMsgManagerImpl.getInstance(this.mContext).unregisterLiveMsgReceiveListener(str);
        ChatMsgManagerImpl.getInstance(this.mContext).unregisterLiveMsgReceiveListener(iLiveMsgReceiveListener);
    }

    public void unregisterLiveMsgReceiveListener(long j) {
        ChatMsgManagerImpl.getInstance(this.mContext).unregisterLiveMsgReceiveListener(j + "");
    }

    public void unregisterMessageReceiveListener(IMessageReceiveListener iMessageReceiveListener) {
        ChatMsgManagerImpl.getInstance(this.mContext).unregisterMessageReceiveListener(this.mContext, iMessageReceiveListener);
    }

    public void beginWithCompletion(IMcastSetListener iMcastSetListener) {
        this.mCastListener = iMcastSetListener;
        if (this.mCastType == 2) {
            McastManagerImpl.getInstance(this.mContext).beginWithCompletion(Long.parseLong(this.mCastId), new IMcastSetListener() { // from class: com.baidu.android.imsdk.BIMConversation.6
                @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                public void onResult(int i, long j, long j2) {
                    if (i == 1316) {
                        BIMConversation.this.mCastType = 0;
                        BIMConversation.this.beginWithCompletion(BIMConversation.this.mCastListener);
                    }
                    if (BIMConversation.this.mCastListener != null) {
                        BIMConversation.this.mCastListener.onResult(i, j, j2);
                    }
                }
            });
            return;
        }
        if (this.mCastService != null) {
            this.mCastService.stopService(0);
            LogUtils.d(TAG, "stop service before start as service is not null.");
        }
        this.mCastService = CastServiceFactory.createCastService(this.mContext);
        try {
            iMcastSetListener.onResult(this.mCastService.startService(this.mCastId, this.mCastUrl, this.mCastType), this.session.getContacter(), -1L);
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    public void setPullInterval(int i) {
        if (this.mCastService != null) {
            this.mCastService.setPullInterval(i);
        }
    }

    public void endWithCompletion(IMcastSetListener iMcastSetListener) {
        if (this.mCastType == 2) {
            McastManagerImpl.getInstance(this.mContext).endWithCompletion(this.session.getContacter(), iMcastSetListener);
        } else {
            if (this.mCastService != null) {
                this.mCastService.stopService(0);
            }
            iMcastSetListener.onResult(0, this.session.getContacter(), -1L);
        }
        try {
            unregisterLiveMsgReceiveListener(Long.valueOf(this.mCastId).longValue());
        } catch (NumberFormatException e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    public void playCastMessage() {
        if (this.mCastService != null) {
            this.mCastService.replay(this.mCastId, this.mCastUrl, this.mCastType);
        }
    }

    public void pauseCastMessage() {
        if (this.mCastService != null) {
            this.mCastService.pause();
        }
    }

    public void seekCastMessage(int i) {
        if (this.mCastService != null) {
            this.mCastService.seek(i);
        }
    }

    public void sendQuizOpts(long j, long j2, int i, String str, IMcastSetListener iMcastSetListener) {
        if (this.mCastType == 2) {
            McastManagerImpl.getInstance(this.mContext).sendQuizOpts(j, j2, i, str, iMcastSetListener);
            return;
        }
        if (this.mCastService != null) {
            this.mCastService.stopService(0);
        }
        iMcastSetListener.onResult(0, this.session.getContacter(), -1L);
    }

    public void quitLiveShow() {
        McastManagerImpl.getInstance(this.mContext).cancelMcastQuickHeartBeat();
    }
}
