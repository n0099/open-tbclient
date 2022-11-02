package com.baidu.android.imsdk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BIMConversationMsg extends BIMConversation {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "BIMConversation";
    public transient /* synthetic */ FieldHolder $fh;
    public ISendMessageListener mInternalSendMessageListener;
    public ChatMsg mLastChatMsg;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2120823524, "Lcom/baidu/android/imsdk/BIMConversationMsg;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2120823524, "Lcom/baidu/android/imsdk/BIMConversationMsg;");
        }
    }

    /* renamed from: com.baidu.android.imsdk.BIMConversationMsg$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$imsdk$BIMConversation$MSGTYPE;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1998038604, "Lcom/baidu/android/imsdk/BIMConversationMsg$4;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1998038604, "Lcom/baidu/android/imsdk/BIMConversationMsg$4;");
                    return;
                }
            }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BIMConversationMsg(Context context, BIMManager.CATEGORY category, String str, ChatSession chatSession) {
        super(context, category, str, chatSession);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, category, str, chatSession};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BIMManager.CATEGORY) objArr2[1], (String) objArr2[2], (ChatSession) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mInternalSendMessageListener = new ISendMessageListener(this) { // from class: com.baidu.android.imsdk.BIMConversationMsg.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BIMConversationMsg this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i3, ChatMsg chatMsg) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, chatMsg) == null) {
                    String str2 = BIMConversationMsg.TAG;
                    LogUtils.d(str2, "conversion onSendMessageResult" + i3);
                    if (i3 == 0 && chatMsg != null) {
                        if (this.this$0.mLastChatMsg != null && this.this$0.mLastChatMsg.getMsgId() >= chatMsg.getMsgId()) {
                            return;
                        }
                        this.this$0.mLastChatMsg = chatMsg;
                    }
                }
            }
        };
        ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSync(this.session.getCategory(), this.session.getContacter(), 1, (ChatMsg) null);
        if (fetchMessageSync != null && fetchMessageSync.size() > 0) {
            this.mLastChatMsg = fetchMessageSync.get(fetchMessageSync.size() - 1);
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public long clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ChatMsgManagerImpl.getInstance(this.mContext).deleteAllMsgs(this.mCategory.getValue(), this.session.getContacter(), this.isMulAppSync);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public int deleteDraftMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ChatMsgManagerImpl.getInstance(this.mContext).deleteDraftMsg(this.session.getCategory(), this.session.getContacter());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public BIMManager.CATEGORY getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mCategory;
        }
        return (BIMManager.CATEGORY) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public int getChatType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.session.getChatType();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public ChatMsg getDraftMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return ChatMsgManagerImpl.getInstance(this.mContext).getDraftMsg(this.session.getCategory(), this.session.getContacter());
        }
        return (ChatMsg) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.session.getIconUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return String.valueOf(this.session.getContacterId());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public ChatMsg getLastChatmsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mLastChatMsg;
        }
        return (ChatMsg) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public long getLastMsgTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.session.getLastMsgTime();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.session.getName();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public long getUnReadChatMsgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.session.getNewMsgSum();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public boolean markMsgClicked(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, chatMsg)) == null) {
            if (!checkChatMsg(chatMsg) || ChatMsgManagerImpl.getInstance(this.mContext).markMessageClicked(chatMsg) == -1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void updateConversation(ChatSession chatSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, chatSession) == null) {
            ChatSession chatSession2 = this.session;
            if (chatSession2 == null || chatSession2.getContacter() == chatSession.getContacter()) {
                this.session = chatSession;
                TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.BIMConversationMsg.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BIMConversationMsg this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList<ChatMsg> fetchMessageSync;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (fetchMessageSync = ChatMsgManagerImpl.getInstance(this.this$0.mContext).fetchMessageSync(this.this$0.session.getCategory(), this.this$0.session.getContacter(), 1, (ChatMsg) null)) != null && fetchMessageSync.size() > 0) {
                            if (this.this$0.mLastChatMsg != null) {
                                if (this.this$0.mLastChatMsg != null && this.this$0.mLastChatMsg.getMsgId() >= fetchMessageSync.get(0).getMsgId()) {
                                    return;
                                }
                                this.this$0.mLastChatMsg = fetchMessageSync.get(0);
                                return;
                            }
                            this.this$0.mLastChatMsg = fetchMessageSync.get(0);
                        }
                    }
                });
            }
        }
    }

    private boolean checkChatMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, chatMsg)) == null) {
            if (chatMsg != null && chatMsg.getCategory() == this.session.getCategory() && chatMsg.getContacter() == this.session.getContacter()) {
                return true;
            }
            String str = TAG;
            LogUtils.d(str, "msg doest not belong to the conversation." + chatMsg);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public boolean setAllMessageReaded(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, chatMsg)) == null) {
            if (chatMsg != null) {
                if (checkChatMsg(chatMsg)) {
                    return ChatMsgManagerImpl.getInstance(this.mContext).setBeforeMsgRead(this.session.getCategory(), this.session.getContacter(), chatMsg.getMsgId(), chatMsg.isZhida());
                }
                return false;
            }
            return ChatMsgManagerImpl.getInstance(this.mContext).setAllMsgRead(this.session.getCategory(), this.session.getContacter(), this.isMulAppSync);
        }
        return invokeL.booleanValue;
    }

    private void handleFetchMessage(BIMConversation.MSGTYPE msgtype, ChatMsg chatMsg, int i, boolean z, IFetchMessageListener iFetchMessageListener) {
        ArrayList<ChatMsg> fetchMessageSync;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{msgtype, chatMsg, Integer.valueOf(i), Boolean.valueOf(z), iFetchMessageListener}) == null) {
            int i2 = AnonymousClass4.$SwitchMap$com$baidu$android$imsdk$BIMConversation$MSGTYPE[msgtype.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        fetchMessageSync = null;
                    } else {
                        fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchGroupNotifyMsgsSync(this.session.getCategory(), this.session.getContacter(), i, z, chatMsg);
                    }
                } else {
                    fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSyncExceptSystemMsg(this.session.getCategory(), this.session.getContacter(), i, z, chatMsg);
                }
            } else {
                fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSync(this.session.getCategory(), this.session.getContacter(), i, z, chatMsg);
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
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public boolean deleteChatMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMsg)) == null) {
            if (!checkChatMsg(chatMsg)) {
                return false;
            }
            int deleteMsgs = ChatMsgManagerImpl.getInstance(this.mContext).deleteMsgs(chatMsg);
            if (this.mLastChatMsg != null && chatMsg.getMsgId() == this.mLastChatMsg.getMsgId()) {
                ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSync(this.session.getCategory(), this.session.getContacter(), 1, (ChatMsg) null);
                if (fetchMessageSync != null && fetchMessageSync.size() > 0) {
                    this.mLastChatMsg = fetchMessageSync.get(fetchMessageSync.size() - 1);
                } else {
                    this.mLastChatMsg = null;
                }
            }
            if (deleteMsgs != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public int saveAsDraftMessage(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, chatMsg)) == null) {
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
        return invokeL.intValue;
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void fetchMessage(BIMConversation.MSGTYPE msgtype, ChatMsg chatMsg, int i, boolean z, IFetchMessageListener iFetchMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{msgtype, chatMsg, Integer.valueOf(i), Boolean.valueOf(z), iFetchMessageListener}) == null) {
            if (chatMsg != null && !checkChatMsg(chatMsg)) {
                if (iFetchMessageListener != null) {
                    iFetchMessageListener.onFetchMessageResult(1005, null);
                    return;
                }
                return;
            }
            handleFetchMessage(msgtype, chatMsg, i, z, iFetchMessageListener);
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void setDisturb(int i, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i, bIMValueCallBack) == null) {
            if (this.session.getCategory() == 1) {
                GroupManagerImpl.getInstance(this.mContext).setGroupDisturb(String.valueOf(this.session.getContacter()), i, bIMValueCallBack);
            } else {
                ChatUserManager.setUserDisturb(this.mContext, this.session.getContacter(), i, new IUserPrivacyListener(this, bIMValueCallBack) { // from class: com.baidu.android.imsdk.BIMConversationMsg.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BIMConversationMsg this$0;
                    public final /* synthetic */ BIMValueCallBack val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bIMValueCallBack};
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
                        this.val$listener = bIMValueCallBack;
                    }

                    @Override // com.baidu.android.imsdk.chatuser.IUserPrivacyListener
                    public void onResult(int i2, String str) {
                        BIMValueCallBack bIMValueCallBack2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) && (bIMValueCallBack2 = this.val$listener) != null) {
                            bIMValueCallBack2.onResult(i2, str, this.this$0.getId());
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public boolean setSingleMessageReaded(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, chatMsg)) == null) {
            if (checkChatMsg(chatMsg)) {
                return ChatMsgManagerImpl.getInstance(this.mContext).setMsgRead(this.session.getCategory(), this.session.getContacter(), chatMsg.getMsgId(), chatMsg.isZhida());
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
