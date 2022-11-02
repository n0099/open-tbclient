package com.baidu.livesdk.sdk.im.live;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.im.IMCastSetListener;
import com.baidu.livesdk.api.im.IMConversation;
import com.baidu.livesdk.api.im.MsgReceiveListener;
import com.baidu.livesdk.api.im.SendMessageListener;
import com.baidu.livesdk.api.im.live.LiveIM;
import com.baidu.livesdk.api.im.live.LiveMessageBean;
import com.baidu.livesdk.api.im.live.LiveMsgReceiverListener;
import com.baidu.livesdk.api.im.live.LiveSendMessage;
import com.baidu.livesdk.api.im.live.LiveSendMessageListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class LiveIMController implements LiveIM {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "LiveIMController";
    public transient /* synthetic */ FieldHolder $fh;
    public String mCastId;
    public IMCastSetListener mCastSetListener;
    public IMConversation mConversation;
    public boolean mIsConnect;
    public boolean mNecessary;
    public int mPullInterval;
    public String mUrl;

    public LiveIMController(IMConversation iMConversation) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMConversation};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mConversation = iMConversation;
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public void exitRoom(String str) {
        IMConversation iMConversation;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || (iMConversation = this.mConversation) == null) {
            return;
        }
        iMConversation.unregisterMsgReceiveListener(str);
        this.mConversation.endWithCompletion(new IMCastSetListener(this) { // from class: com.baidu.livesdk.sdk.im.live.LiveIMController.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LiveIMController this$0;

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

            @Override // com.baidu.livesdk.api.im.IMCastSetListener
            public void onResult(int i, long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.this$0.mIsConnect = false;
                }
            }
        });
        this.mConversation.quitLiveShow();
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public void registerMsgReceiveListener(String str, LiveMsgReceiverListener liveMsgReceiverListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, liveMsgReceiverListener) == null) {
            this.mConversation.registerMsgReceiveListener(str, new MsgReceiveListener(this, liveMsgReceiverListener) { // from class: com.baidu.livesdk.sdk.im.live.LiveIMController.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveIMController this$0;
                public final /* synthetic */ LiveMsgReceiverListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, liveMsgReceiverListener};
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
                    this.val$listener = liveMsgReceiverListener;
                }

                @Override // com.baidu.livesdk.api.im.MsgReceiveListener
                public void onReceiveMessage(int i, Object obj) {
                    LiveMsgReceiverListener liveMsgReceiverListener2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i, obj) == null) && (liveMsgReceiverListener2 = this.val$listener) != null) {
                        try {
                            liveMsgReceiverListener2.onReceiveMessage(i, (List) obj);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    public void enterRoom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mConversation.beginWithCompletion(new IMCastSetListener(this) { // from class: com.baidu.livesdk.sdk.im.live.LiveIMController.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveIMController this$0;

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

                @Override // com.baidu.livesdk.api.im.IMCastSetListener
                public void onResult(int i, long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        if (this.this$0.mCastSetListener != null) {
                            this.this$0.mCastSetListener.onResult(i, j, j2);
                        }
                        this.this$0.mIsConnect = true;
                    }
                }
            });
        }
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public void exitRoom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            exitRoom(this.mCastId);
        }
    }

    public IMConversation getConversation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mConversation;
        }
        return (IMConversation) invokeV.objValue;
    }

    public boolean isConnect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mIsConnect;
        }
        return invokeV.booleanValue;
    }

    public void quitLiveShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mConversation.quitLiveShow();
        }
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public void enterRoom(String str, String str2, int i, IMCastSetListener iMCastSetListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), iMCastSetListener, Boolean.valueOf(z)}) == null) {
            this.mCastId = str;
            this.mUrl = str2;
            this.mPullInterval = i;
            this.mCastSetListener = iMCastSetListener;
            this.mNecessary = z;
            this.mConversation.setPullInterval(i);
            this.mConversation.beginWithCompletion(new IMCastSetListener(this, iMCastSetListener) { // from class: com.baidu.livesdk.sdk.im.live.LiveIMController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveIMController this$0;
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

                @Override // com.baidu.livesdk.api.im.IMCastSetListener
                public void onResult(int i2, long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        IMCastSetListener iMCastSetListener2 = this.val$listener;
                        if (iMCastSetListener2 != null) {
                            iMCastSetListener2.onResult(i2, j, j2);
                        }
                        this.this$0.mIsConnect = true;
                    }
                }
            });
        }
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public void sendMessage(String str, LiveSendMessage liveSendMessage, LiveSendMessageListener liveSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, liveSendMessage, liveSendMessageListener) == null) {
            IMConversation iMConversation = this.mConversation;
            if (iMConversation != null && liveSendMessage != null) {
                iMConversation.sendMessage(liveSendMessage, null, new SendMessageListener(this, liveSendMessageListener, str) { // from class: com.baidu.livesdk.sdk.im.live.LiveIMController.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveIMController this$0;
                    public final /* synthetic */ String val$castId;
                    public final /* synthetic */ LiveSendMessageListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, liveSendMessageListener, str};
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
                        this.val$listener = liveSendMessageListener;
                        this.val$castId = str;
                    }

                    @Override // com.baidu.livesdk.api.im.SendMessageListener
                    public void onSendMessageResult(int i, Object obj) {
                        LiveSendMessageListener liveSendMessageListener2;
                        List<LiveMessageBean> list;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i, obj) == null) && (liveSendMessageListener2 = this.val$listener) != null) {
                            try {
                                String str2 = this.val$castId;
                                if (obj != null) {
                                    list = (List) obj;
                                } else {
                                    list = null;
                                }
                                liveSendMessageListener2.onSendSuccess(str2, i, list);
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            } else if (liveSendMessageListener != null) {
                liveSendMessageListener.onSendSuccess(str, -1, null);
            }
        }
    }
}
