package com.baidu.livesdk.sdk.im;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.livesdk.api.im.IMCastSetListener;
import com.baidu.livesdk.api.im.IMConversation;
import com.baidu.livesdk.api.im.MsgReceiveListener;
import com.baidu.livesdk.api.im.SendMessageListener;
import com.baidu.livesdk.api.im.SendMessageStatusListener;
import com.baidu.livesdk.api.im.live.LiveSendMessage;
import com.baidu.livesdk.sdk.im.live.parser.LiveMessageParser;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class BDIMConversation implements IMConversation {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "BDIMConversation";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public BIMConversation mConversation;

    public BDIMConversation(Context context, BIMConversation bIMConversation) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bIMConversation};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mConversation = bIMConversation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSendMessageResponse(int i2, ChatMsg chatMsg, SendMessageListener sendMessageListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65538, this, i2, chatMsg, sendMessageListener) == null) || sendMessageListener == null) {
            return;
        }
        ArrayList arrayList = null;
        if (i2 != 22 && i2 != 1024 && i2 != 1001) {
            arrayList = new ArrayList();
            arrayList.add(LiveMessageParser.parseChatMsg(chatMsg));
        }
        sendMessageListener.onSendMessageResult(i2, arrayList);
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void beginWithCompletion(IMCastSetListener iMCastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iMCastSetListener) == null) {
            this.mConversation.beginWithCompletion(new IMcastSetListener(this, iMCastSetListener) { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDIMConversation this$0;
                public final /* synthetic */ IMCastSetListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iMCastSetListener};
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
                    this.val$listener = iMCastSetListener;
                }

                @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                public void onResult(int i2, long j, long j2) {
                    IMCastSetListener iMCastSetListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || (iMCastSetListener2 = this.val$listener) == null) {
                        return;
                    }
                    iMCastSetListener2.onResult(i2, j, j2);
                }
            });
        }
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void endWithCompletion(IMCastSetListener iMCastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iMCastSetListener) == null) {
            this.mConversation.endWithCompletion(new IMcastSetListener(this, iMCastSetListener) { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDIMConversation this$0;
                public final /* synthetic */ IMCastSetListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iMCastSetListener};
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
                    this.val$listener = iMCastSetListener;
                }

                @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                public void onResult(int i2, long j, long j2) {
                    IMCastSetListener iMCastSetListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || (iMCastSetListener2 = this.val$listener) == null) {
                        return;
                    }
                    iMCastSetListener2.onResult(i2, j, j2);
                }
            });
        }
    }

    public BIMConversation getBaseConversation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mConversation : (BIMConversation) invokeV.objValue;
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void quitLiveShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void registerMsgReceiveListener(String str, MsgReceiveListener msgReceiveListener) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, msgReceiveListener) == null) {
            try {
                j = Long.parseLong(str);
            } catch (Exception unused) {
                j = 0;
            }
            this.mConversation.registerLiveMsgReceiveListener(j, new ILiveMsgReceiveListener(this, msgReceiveListener) { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDIMConversation this$0;
                public final /* synthetic */ MsgReceiveListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, msgReceiveListener};
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
                    this.val$listener = msgReceiveListener;
                }

                @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
                public void onReceiveMessage(int i2, JSONArray jSONArray) {
                    MsgReceiveListener msgReceiveListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, jSONArray) == null) || (msgReceiveListener2 = this.val$listener) == null) {
                        return;
                    }
                    msgReceiveListener2.onReceiveMessage(i2, LiveMessageParser.getMessageList(jSONArray));
                }
            });
        }
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void sendMessage(Object obj, SendMessageStatusListener sendMessageStatusListener, SendMessageListener sendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, obj, sendMessageStatusListener, sendMessageListener) == null) {
            this.mConversation.sendMessage(LiveMessageParser.trans2ChatMsg(this.mContext, (LiveSendMessage) obj), new ISendMessageStatusListener(this, sendMessageStatusListener) { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDIMConversation this$0;
                public final /* synthetic */ SendMessageStatusListener val$statusListener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sendMessageStatusListener};
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
                    this.val$statusListener = sendMessageStatusListener;
                }

                @Override // com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener
                public void onSendProgress(int i2, ChatMsg chatMsg) {
                    SendMessageStatusListener sendMessageStatusListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, chatMsg) == null) || (sendMessageStatusListener2 = this.val$statusListener) == null) {
                        return;
                    }
                    sendMessageStatusListener2.onSendProgress(i2, chatMsg);
                }

                @Override // com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener
                public void onSendStatus(int i2, ChatMsg chatMsg) {
                    SendMessageStatusListener sendMessageStatusListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, chatMsg) == null) || (sendMessageStatusListener2 = this.val$statusListener) == null) {
                        return;
                    }
                    sendMessageStatusListener2.onSendStatus(i2, chatMsg);
                }
            }, new ISendMessageListener(this, sendMessageListener) { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDIMConversation this$0;
                public final /* synthetic */ SendMessageListener val$sendListener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sendMessageListener};
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
                    this.val$sendListener = sendMessageListener;
                }

                @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
                public void onSendMessageResult(int i2, ChatMsg chatMsg) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, chatMsg) == null) {
                        this.this$0.handleSendMessageResponse(i2, chatMsg, this.val$sendListener);
                    }
                }
            });
        }
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void setPullInterval(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mConversation.setPullInterval(i2);
        }
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void unregisterMsgReceiveListener(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            try {
                this.mConversation.unregisterLiveMsgReceiveListener(Long.parseLong(str));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
