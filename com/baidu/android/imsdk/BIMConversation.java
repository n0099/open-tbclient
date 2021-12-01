package com.baidu.android.imsdk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class BIMConversation implements NoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BIMConversation";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isMulAppSync;
    public BIMManager.CATEGORY mCategory;
    public Context mContext;
    public ChatSession session;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class MSGTYPE {
        public static final /* synthetic */ MSGTYPE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MSGTYPE ALL;
        public static final MSGTYPE MSG;
        public static final MSGTYPE SYSTEMMSG;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-632456510, "Lcom/baidu/android/imsdk/BIMConversation$MSGTYPE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-632456510, "Lcom/baidu/android/imsdk/BIMConversation$MSGTYPE;");
                    return;
                }
            }
            ALL = new MSGTYPE("ALL", 0);
            MSG = new MSGTYPE("MSG", 1);
            MSGTYPE msgtype = new MSGTYPE("SYSTEMMSG", 2);
            SYSTEMMSG = msgtype;
            $VALUES = new MSGTYPE[]{ALL, MSG, msgtype};
        }

        public MSGTYPE(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MSGTYPE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MSGTYPE) Enum.valueOf(MSGTYPE.class, str) : (MSGTYPE) invokeL.objValue;
        }

        public static MSGTYPE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MSGTYPE[]) $VALUES.clone() : (MSGTYPE[]) invokeV.objValue;
        }
    }

    public BIMConversation(Context context, BIMManager.CATEGORY category, String str, ChatSession chatSession) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, category, str, chatSession};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isMulAppSync = false;
        this.mCategory = BIMManager.CATEGORY.UNKOWN;
        this.mContext = context.getApplicationContext();
        this.session = chatSession;
        this.mCategory = category;
    }

    private void handleRichMediaMsg(ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, chatMsg, iSendMessageListener) == null) {
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
    }

    private void handleUpload(RichMediaMsg richMediaMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, richMediaMsg, iSendMessageListener) == null) {
            new AsyncChatTask(this.mContext, richMediaMsg, new IUploadTransferListener(this, richMediaMsg, iSendMessageListener) { // from class: com.baidu.android.imsdk.BIMConversation.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BIMConversation this$0;
                public final /* synthetic */ ISendMessageListener val$listener2;
                public final /* synthetic */ RichMediaMsg val$msg;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, richMediaMsg, iSendMessageListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$msg = richMediaMsg;
                    this.val$listener2 = iSendMessageListener;
                }

                @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
                public void onFailed(int i2, int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                        this.val$msg.setStatus(2);
                        ChatMsgManagerImpl.getInstance(this.this$0.mContext).onSendMessageResult(i2, this.val$msg, -1L, null);
                    }
                }

                @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
                public void onFinished(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        if (this.val$msg.getMsgType() == 1) {
                            ((ImageMsg) this.val$msg).setContent(str);
                        } else if (this.val$msg.getMsgType() == 2) {
                            AudioMsg audioMsg = (AudioMsg) this.val$msg;
                            audioMsg.setContent(str, audioMsg.getFormat(), audioMsg.getDuration());
                        }
                        ChatMsgManagerImpl.getInstance(this.this$0.mContext).sendMessage(this.val$msg, this.val$listener2);
                    }
                }

                @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
                public void onProgress(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                        this.val$msg.setProgress(i2);
                    }
                }
            }).execute();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void senMessageInternal(ChatMsg chatMsg, ISendMessageStatusListener iSendMessageStatusListener, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, chatMsg, iSendMessageStatusListener, iSendMessageListener) == null) {
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
    }

    public void beginWithCompletion(IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iMcastSetListener) == null) {
        }
    }

    public long clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return -1L;
        }
        return invokeV.longValue;
    }

    public boolean deleteChatMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMsg)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public int deleteDraftMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public void endWithCompletion(IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iMcastSetListener) == null) {
        }
    }

    public void fetchMessage(MSGTYPE msgtype, ChatMsg chatMsg, int i2, boolean z, IFetchMessageListener iFetchMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{msgtype, chatMsg, Integer.valueOf(i2), Boolean.valueOf(z), iFetchMessageListener}) == null) {
        }
    }

    public BIMManager.CATEGORY getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? BIMManager.CATEGORY.ALL : (BIMManager.CATEGORY) invokeV.objValue;
    }

    public ChatSession getChatSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.session : (ChatSession) invokeV.objValue;
    }

    public int getChatType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public ChatMsg getDraftMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (ChatMsg) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public ChatMsg getLastChatmsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new TextMsg("") : (ChatMsg) invokeV.objValue;
    }

    public long getLastMsgTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return -1L;
        }
        return invokeV.longValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public long getUnReadChatMsgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return -1L;
        }
        return invokeV.longValue;
    }

    public boolean markMsgClicked(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, chatMsg)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void pauseCastMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public void playCastMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public void quitLiveShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    public void registerLiveMsgReceiveListener(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, iLiveMsgReceiveListener) == null) {
            ChatMsgManagerImpl.getInstance(this.mContext).registerLiveMsgReceiveListener(iLiveMsgReceiveListener);
        }
    }

    public int saveAsDraftMessage(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, chatMsg)) == null) {
            return -1;
        }
        return invokeL.intValue;
    }

    public void seekCastMessage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
        }
    }

    public ChatMsg sendMessage(ChatMsg chatMsg, ISendMessageStatusListener iSendMessageStatusListener, ISendMessageListener iSendMessageListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, chatMsg, iSendMessageStatusListener, iSendMessageListener)) == null) {
            if (chatMsg != null) {
                if (this.session.getContacter() < 0) {
                    if (BIMManager.CATEGORY.SINGLEPERSON == this.mCategory) {
                        ChatUserManagerImpl.getInstance(this.mContext).getUserByBuid(this.session.getContacterId(), 0, new IGetUserListener(this, chatMsg, iSendMessageStatusListener, iSendMessageListener) { // from class: com.baidu.android.imsdk.BIMConversation.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ BIMConversation this$0;
                            public final /* synthetic */ ISendMessageStatusListener val$listener;
                            public final /* synthetic */ ISendMessageListener val$listener2;
                            public final /* synthetic */ ChatMsg val$msg;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, chatMsg, iSendMessageStatusListener, iSendMessageListener};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$msg = chatMsg;
                                this.val$listener = iSendMessageStatusListener;
                                this.val$listener2 = iSendMessageListener;
                            }

                            @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
                            public void onGetUserResult(int i2, long j2, ChatUser chatUser) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), chatUser}) == null) {
                                    if (i2 == 0 && chatUser != null) {
                                        this.this$0.session.setContacter(chatUser.getUk());
                                        this.this$0.senMessageInternal(this.val$msg, this.val$listener, this.val$listener2);
                                        return;
                                    }
                                    ISendMessageStatusListener iSendMessageStatusListener2 = this.val$listener;
                                    if (iSendMessageStatusListener2 != null) {
                                        iSendMessageStatusListener2.onSendStatus(2, this.val$msg);
                                    }
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
        return (ChatMsg) invokeLLL.objValue;
    }

    public void sendQuizOpts(long j2, long j3, int i2, String str, IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), str, iMcastSetListener}) == null) {
        }
    }

    public boolean setAllMessageReaded(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, chatMsg)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setDisturb(int i2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048604, this, i2, bIMValueCallBack) == null) {
        }
    }

    public void setPullInterval(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
        }
    }

    public boolean setSingleMessageReaded(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, chatMsg)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void unregisterLiveMsgReceiveListener(String str, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, str, iLiveMsgReceiveListener) == null) {
            ChatMsgManagerImpl.getInstance(this.mContext).unregisterLiveMsgReceiveListener(str);
            ChatMsgManagerImpl.getInstance(this.mContext).unregisterLiveMsgReceiveListener(iLiveMsgReceiveListener);
        }
    }

    public void unregisterMessageReceiveListener(IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, iMessageReceiveListener) == null) {
            ChatMsgManagerImpl.getInstance(this.mContext).unregisterMessageReceiveListener(this.mContext, iMessageReceiveListener);
        }
    }

    public void updateConversation(ChatSession chatSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, chatSession) == null) {
        }
    }

    public void registerLiveMsgReceiveListener(long j2, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048596, this, j2, iLiveMsgReceiveListener) == null) {
            ChatMsgManagerImpl chatMsgManagerImpl = ChatMsgManagerImpl.getInstance(this.mContext);
            chatMsgManagerImpl.registerLiveMsgReceiveListener(j2 + "", iLiveMsgReceiveListener);
        }
    }

    public void registerLiveMsgReceiveListener(long j2, boolean z, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), iLiveMsgReceiveListener}) == null) {
            if (z) {
                ConversationStudioManImpl.getInstance(this.mContext).addReliableCastId(j2);
            }
            ChatMsgManagerImpl chatMsgManagerImpl = ChatMsgManagerImpl.getInstance(this.mContext);
            chatMsgManagerImpl.registerLiveMsgReceiveListener(j2 + "", iLiveMsgReceiveListener);
        }
    }

    public void unregisterLiveMsgReceiveListener(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j2) == null) {
            ChatMsgManagerImpl chatMsgManagerImpl = ChatMsgManagerImpl.getInstance(this.mContext);
            chatMsgManagerImpl.unregisterLiveMsgReceiveListener(j2 + "");
        }
    }

    public BIMConversation(Context context, BIMManager.CATEGORY category, String str, ChatSession chatSession, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, category, str, chatSession, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isMulAppSync = false;
        this.mCategory = BIMManager.CATEGORY.UNKOWN;
        this.mContext = context.getApplicationContext();
        this.session = chatSession;
        this.mCategory = category;
    }
}
