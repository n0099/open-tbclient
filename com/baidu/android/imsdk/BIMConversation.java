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
/* loaded from: classes2.dex */
public class BIMConversation implements NoProGuard {
    public static final String TAG = "BIMConversation";
    public boolean isMulAppSync = false;
    public BIMManager.CATEGORY mCategory;
    public Context mContext;
    public ChatSession session;

    /* loaded from: classes2.dex */
    public enum MSGTYPE {
        ALL,
        MSG,
        SYSTEMMSG
    }

    public BIMConversation(Context context, BIMManager.CATEGORY category, String str, ChatSession chatSession) {
        this.mCategory = BIMManager.CATEGORY.UNKOWN;
        this.mContext = context.getApplicationContext();
        this.session = chatSession;
        this.mCategory = category;
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
        } catch (ClassCastException e2) {
            LogUtils.e(TAG, "sendMessage", e2);
            ISendMessageStatusListener iSendMessageStatusListener2 = (ISendMessageStatusListener) ListenerManager.getInstance().removeListener(chatMsg.mListenerKey);
            if (iSendMessageStatusListener2 != null) {
                iSendMessageStatusListener2.onSendStatus(1007, chatMsg);
            }
            new IMTrack.CrashBuilder(this.mContext).exception(e2.getMessage()).build();
        }
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
        int msgType = chatMsg.getMsgType();
        if (msgType == 1) {
            ImageMsg imageMsg = (ImageMsg) chatMsg;
            imageMsg.setContent(imageMsg.getLocalUrl(), imageMsg.getWidth(), imageMsg.getHeight());
            handleRichMediaMsg(chatMsg, iSendMessageListener);
        } else if (msgType != 2) {
            ChatMsgManagerImpl.getInstance(this.mContext).sendMessage(chatMsg, iSendMessageListener);
        } else {
            AudioMsg audioMsg = (AudioMsg) chatMsg;
            audioMsg.setContent(audioMsg.getLocalUrl(), audioMsg.getFormat(), audioMsg.getDuration());
            handleRichMediaMsg(chatMsg, iSendMessageListener);
        }
    }

    public void beginWithCompletion(IMcastSetListener iMcastSetListener) {
    }

    public long clear() {
        return -1L;
    }

    public boolean deleteChatMsg(ChatMsg chatMsg) {
        return false;
    }

    public int deleteDraftMessage() {
        return -1;
    }

    public void endWithCompletion(IMcastSetListener iMcastSetListener) {
    }

    public void fetchMessage(MSGTYPE msgtype, ChatMsg chatMsg, int i, boolean z, IFetchMessageListener iFetchMessageListener) {
    }

    public BIMManager.CATEGORY getCategory() {
        return BIMManager.CATEGORY.ALL;
    }

    public ChatSession getChatSession() {
        return this.session;
    }

    public int getChatType() {
        return 0;
    }

    public ChatMsg getDraftMessage() {
        return null;
    }

    public String getIconUrl() {
        return "";
    }

    public String getId() {
        return "";
    }

    public ChatMsg getLastChatmsg() {
        return new TextMsg("");
    }

    public long getLastMsgTime() {
        return -1L;
    }

    public String getName() {
        return "";
    }

    public long getUnReadChatMsgCount() {
        return -1L;
    }

    public boolean markMsgClicked(ChatMsg chatMsg) {
        return false;
    }

    public void pauseCastMessage() {
    }

    public void playCastMessage() {
    }

    public void quitLiveShow() {
    }

    public void registerLiveMsgReceiveListener(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        ChatMsgManagerImpl.getInstance(this.mContext).registerLiveMsgReceiveListener(iLiveMsgReceiveListener);
    }

    public int saveAsDraftMessage(ChatMsg chatMsg) {
        return -1;
    }

    public void seekCastMessage(int i) {
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
                                return;
                            }
                            ISendMessageStatusListener iSendMessageStatusListener2 = iSendMessageStatusListener;
                            if (iSendMessageStatusListener2 != null) {
                                iSendMessageStatusListener2.onSendStatus(2, chatMsg);
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

    public void sendQuizOpts(long j, long j2, int i, String str, IMcastSetListener iMcastSetListener) {
    }

    public boolean setAllMessageReaded(ChatMsg chatMsg) {
        return false;
    }

    public void setDisturb(int i, BIMValueCallBack<String> bIMValueCallBack) {
    }

    public void setPullInterval(int i) {
    }

    public boolean setSingleMessageReaded(ChatMsg chatMsg) {
        return false;
    }

    public void unregisterLiveMsgReceiveListener(String str, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        ChatMsgManagerImpl.getInstance(this.mContext).unregisterLiveMsgReceiveListener(str);
        ChatMsgManagerImpl.getInstance(this.mContext).unregisterLiveMsgReceiveListener(iLiveMsgReceiveListener);
    }

    public void unregisterMessageReceiveListener(IMessageReceiveListener iMessageReceiveListener) {
        ChatMsgManagerImpl.getInstance(this.mContext).unregisterMessageReceiveListener(this.mContext, iMessageReceiveListener);
    }

    public void updateConversation(ChatSession chatSession) {
    }

    public void registerLiveMsgReceiveListener(long j, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        ChatMsgManagerImpl chatMsgManagerImpl = ChatMsgManagerImpl.getInstance(this.mContext);
        chatMsgManagerImpl.registerLiveMsgReceiveListener(j + "", iLiveMsgReceiveListener);
    }

    public void registerLiveMsgReceiveListener(long j, boolean z, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        if (z) {
            ConversationStudioManImpl.getInstance(this.mContext).addReliableCastId(j);
        }
        ChatMsgManagerImpl chatMsgManagerImpl = ChatMsgManagerImpl.getInstance(this.mContext);
        chatMsgManagerImpl.registerLiveMsgReceiveListener(j + "", iLiveMsgReceiveListener);
    }

    public void unregisterLiveMsgReceiveListener(long j) {
        ChatMsgManagerImpl chatMsgManagerImpl = ChatMsgManagerImpl.getInstance(this.mContext);
        chatMsgManagerImpl.unregisterLiveMsgReceiveListener(j + "");
    }

    public BIMConversation(Context context, BIMManager.CATEGORY category, String str, ChatSession chatSession, String str2, int i) {
        this.mCategory = BIMManager.CATEGORY.UNKOWN;
        this.mContext = context.getApplicationContext();
        this.session = chatSession;
        this.mCategory = category;
    }
}
