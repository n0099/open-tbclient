package com.baidu.android.imsdk;

import android.content.Context;
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
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUserListener;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
/* loaded from: classes9.dex */
public class BIMConversation implements NoProGuard {
    private static final String TAG = "BIMConversation";
    protected boolean isMulAppSync = false;
    protected BIMManager.CATEGORY mCategory;
    protected Context mContext;
    protected ChatSession session;

    /* loaded from: classes9.dex */
    public enum MSGTYPE {
        ALL,
        MSG,
        SYSTEMMSG
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BIMConversation(Context context, BIMManager.CATEGORY category, String str, ChatSession chatSession) {
        this.mCategory = BIMManager.CATEGORY.UNKOWN;
        this.mContext = context.getApplicationContext();
        this.session = chatSession;
        this.mCategory = category;
    }

    public BIMConversation(Context context, BIMManager.CATEGORY category, String str, ChatSession chatSession, String str2, int i) {
        this.mCategory = BIMManager.CATEGORY.UNKOWN;
        this.mContext = context.getApplicationContext();
        this.session = chatSession;
        this.mCategory = category;
    }

    public ChatSession getChatSession() {
        return this.session;
    }

    private void handleUpload(final RichMediaMsg richMediaMsg, final ISendMessageListener iSendMessageListener) {
        new AsyncChatTask(this.mContext, richMediaMsg, new IUploadTransferListener() { // from class: com.baidu.android.imsdk.BIMConversation.1
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
                    ChatUserManagerImpl.getInstance(this.mContext).getUserByBuid(this.session.getContacterId(), 0, new IGetUserListener() { // from class: com.baidu.android.imsdk.BIMConversation.2
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
            new IMTrack.CrashBuilder(this.mContext).exception(e.getMessage()).build();
        }
    }

    public boolean deleteChatMsg(ChatMsg chatMsg) {
        return false;
    }

    public boolean markMsgClicked(ChatMsg chatMsg) {
        return false;
    }

    public ChatMsg getLastChatmsg() {
        return new TextMsg("");
    }

    public boolean setSingleMessageReaded(ChatMsg chatMsg) {
        return false;
    }

    public boolean setAllMessageReaded(ChatMsg chatMsg) {
        return false;
    }

    public void setDisturb(int i, BIMValueCallBack<String> bIMValueCallBack) {
    }

    public int saveAsDraftMessage(ChatMsg chatMsg) {
        return -1;
    }

    public int deleteDraftMessage() {
        return -1;
    }

    public ChatMsg getDraftMessage() {
        return null;
    }

    public long getUnReadChatMsgCount() {
        return -1L;
    }

    public void fetchMessage(MSGTYPE msgtype, ChatMsg chatMsg, int i, boolean z, IFetchMessageListener iFetchMessageListener) {
    }

    public void updateConversation(ChatSession chatSession) {
    }

    public String getId() {
        return "";
    }

    public String getName() {
        return "";
    }

    public long getLastMsgTime() {
        return -1L;
    }

    public BIMManager.CATEGORY getCategory() {
        return BIMManager.CATEGORY.ALL;
    }

    public String getIconUrl() {
        return "";
    }

    public int getChatType() {
        return 0;
    }

    public long clear() {
        return -1L;
    }

    public void registerLiveMsgReceiveListener(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        ChatMsgManagerImpl.getInstance(this.mContext).registerLiveMsgReceiveListener(iLiveMsgReceiveListener);
    }

    public void registerLiveMsgReceiveListener(long j, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        ChatMsgManagerImpl.getInstance(this.mContext).registerLiveMsgReceiveListener(j + "", iLiveMsgReceiveListener);
    }

    public void registerLiveMsgReceiveListener(long j, boolean z, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        if (z) {
            ConversationStudioManImpl.getInstance(this.mContext).addReliableCastId(j);
        }
        ChatMsgManagerImpl.getInstance(this.mContext).registerLiveMsgReceiveListener(j + "", iLiveMsgReceiveListener);
    }

    public void unregisterLiveMsgReceiveListener(String str, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
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
    }

    public void endWithCompletion(IMcastSetListener iMcastSetListener) {
    }

    public void sendQuizOpts(long j, long j2, int i, String str, IMcastSetListener iMcastSetListener) {
    }

    public void setPullInterval(int i) {
    }

    public void playCastMessage() {
    }

    public void pauseCastMessage() {
    }

    public void seekCastMessage(int i) {
    }

    public void quitLiveShow() {
    }
}
