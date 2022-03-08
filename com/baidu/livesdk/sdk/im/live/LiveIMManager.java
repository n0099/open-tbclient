package com.baidu.livesdk.sdk.im.live;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.im.ConnectListener;
import com.baidu.livesdk.api.im.IMCastSetListener;
import com.baidu.livesdk.api.im.IMConversation;
import com.baidu.livesdk.api.im.IMManager;
import com.baidu.livesdk.api.im.live.LiveIM;
import com.baidu.livesdk.api.im.live.LiveMsgReceiverListener;
import com.baidu.livesdk.api.im.live.LiveSendMessage;
import com.baidu.livesdk.api.im.live.LiveSendMessageListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class LiveIMManager implements LiveIM {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "LiveIMController";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public final Map<String, LiveIMController> mHashMap;
    public IMManager mIMManager;
    public boolean mIsRegisterConnectListener;

    public LiveIMManager(Context context, IMManager iMManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iMManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsRegisterConnectListener = false;
        this.mHashMap = new ConcurrentHashMap();
        this.mContext = context;
        this.mIMManager = iMManager;
    }

    private LiveIMController create(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, this, str, str2, z)) == null) {
            LiveIMController liveIMController = new LiveIMController(this.mIMManager.build(this.mContext, str, str2, z));
            this.mHashMap.put(str, liveIMController);
            return liveIMController;
        }
        return (LiveIMController) invokeLLZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                for (Map.Entry<String, LiveIMController> entry : this.mHashMap.entrySet()) {
                    LiveIMController liveIMController = this.mHashMap.get(entry.getKey());
                    if (liveIMController != null) {
                        liveIMController.enterRoom();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void register() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || this.mIsRegisterConnectListener) {
            return;
        }
        this.mIMManager.unregisterConnectListener();
        this.mIMManager.registerConnectListener(new ConnectListener(this) { // from class: com.baidu.livesdk.sdk.im.live.LiveIMManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LiveIMManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            @Override // com.baidu.livesdk.api.im.ConnectListener
            public void onResult(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                    if (i2 == 0) {
                        this.this$0.reconnect();
                    } else if (1 == i2) {
                        this.this$0.mIMManager.tryConnection();
                    }
                }
            }
        });
        this.mIsRegisterConnectListener = true;
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public synchronized void enterRoom(String str, String str2, int i2, IMCastSetListener iMCastSetListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i2), iMCastSetListener, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                register();
                create(str, str2, z).enterRoom(str, str2, i2, iMCastSetListener, z);
            }
        }
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public synchronized void exitRoom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                LiveIMController liveIMController = getLiveIMController(str);
                if (liveIMController != null) {
                    liveIMController.exitRoom(str);
                    this.mHashMap.remove(str);
                }
            }
        }
    }

    public IMConversation getConversation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.mHashMap.get(str).getConversation() : (IMConversation) invokeL.objValue;
    }

    public LiveIMController getLiveIMController(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.mHashMap.get(str) : (LiveIMController) invokeL.objValue;
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public void registerMsgReceiveListener(String str, LiveMsgReceiverListener liveMsgReceiverListener) {
        LiveIMController liveIMController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, liveMsgReceiverListener) == null) || (liveIMController = getLiveIMController(str)) == null) {
            return;
        }
        liveIMController.registerMsgReceiveListener(str, liveMsgReceiverListener);
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public synchronized void sendMessage(String str, LiveSendMessage liveSendMessage, LiveSendMessageListener liveSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, liveSendMessage, liveSendMessageListener) == null) {
            synchronized (this) {
                LiveIMController liveIMController = getLiveIMController(str);
                if (liveIMController != null) {
                    liveIMController.sendMessage(str, liveSendMessage, liveSendMessageListener);
                }
            }
        }
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public synchronized void exitRoom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                try {
                    for (Map.Entry<String, LiveIMController> entry : this.mHashMap.entrySet()) {
                        String key = entry.getKey();
                        LiveIMController liveIMController = this.mHashMap.get(key);
                        if (liveIMController != null) {
                            if (liveIMController.isConnect()) {
                                liveIMController.exitRoom();
                            }
                            this.mHashMap.remove(key);
                        }
                    }
                    this.mIMManager.unregisterConnectListener();
                    this.mIsRegisterConnectListener = false;
                } catch (Exception unused) {
                }
            }
        }
    }
}
