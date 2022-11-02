package com.baidu.searchbox.player.layer;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public abstract class AbsLayer implements ILayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Handler mHandler;
    public LayerContainer mLayerContainer;
    @Nullable
    public IMessenger mMessenger;

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int getExpectOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public void handleLayerMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, message) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void initLayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onContainerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onInteractiveEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onLayerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, playerStatus, playerStatus2) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, videoEvent) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public static class PrivateHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AbsLayer> mWeakControl;

        public PrivateHandler(AbsLayer absLayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absLayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mWeakControl = new WeakReference<>(absLayer);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            AbsLayer absLayer;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (absLayer = this.mWeakControl.get()) != null && absLayer.getContentView() != null && absLayer.getContentView().getParent() != null) {
                absLayer.handleLayerMessage(message);
            }
        }
    }

    public AbsLayer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init(null);
    }

    private boolean isMessengerValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.mMessenger != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void registerEvent() {
        int[] subscribeEvent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && isMessengerValid() && (subscribeEvent = getSubscribeEvent()) != null && subscribeEvent.length > 0) {
            for (int i : subscribeEvent) {
                this.mMessenger.register(i, this);
            }
        }
    }

    public void detachMessenger() {
        IMessenger iMessenger;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (iMessenger = this.mMessenger) != null) {
            iMessenger.unregister(this);
            this.mMessenger = null;
        }
    }

    @Nullable
    @PublicMethod
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return getBindPlayer().getActivity();
        }
        return (Activity) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mContext.getApplicationContext();
        }
        return (Context) invokeV.objValue;
    }

    @PublicMethod
    public BDVideoPlayer getBindPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            LayerContainer layerContainer = this.mLayerContainer;
            if (layerContainer != null) {
                return layerContainer.getBindPlayer();
            }
            return null;
        }
        return (BDVideoPlayer) invokeV.objValue;
    }

    @PublicMethod
    public ControlEventTrigger getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return getBindPlayer().getControlEventTrigger();
        }
        return (ControlEventTrigger) invokeV.objValue;
    }

    @PublicMethod
    public Handler getHandlerInnerLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mHandler;
        }
        return (Handler) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public LayerContainer getLayerContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mLayerContainer;
        }
        return (LayerContainer) invokeV.objValue;
    }

    @Nullable
    public IMessenger getMessenger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mMessenger;
        }
        return (IMessenger) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            BdVideoLog.d("onLayerRelease() = " + this);
            this.mHandler.removeCallbacksAndMessages(null);
            this.mContext = null;
            this.mMessenger = null;
        }
    }

    public AbsLayer(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        BdVideoLog.d("AbsLayer(context@" + System.identityHashCode(context) + ") = " + this);
        init(context);
    }

    private void init(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            if (context == null) {
                this.mContext = BDPlayerConfig.getAppContext();
            } else {
                this.mContext = context;
            }
            this.mHandler = new PrivateHandler(this);
        }
    }

    private void sendVideoEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, this, videoEvent) == null) && isMessengerValid()) {
            videoEvent.setSender(this);
            this.mMessenger.notifyEvent(videoEvent);
        }
    }

    public void addInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVideoEventInterceptor) == null) {
            getBindPlayer().addInterceptor(iVideoEventInterceptor);
        }
    }

    public void attachMessenger(@NonNull IMessenger iMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iMessenger) == null) {
            this.mMessenger = iMessenger;
            registerEvent();
        }
    }

    public void removeInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iVideoEventInterceptor) == null) {
            getBindPlayer().removeInterceptor(iVideoEventInterceptor);
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void sendEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, videoEvent) == null) {
            sendVideoEvent(videoEvent);
        }
    }

    public void sendPluginEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, videoEvent) == null) && isMessengerValid()) {
            videoEvent.setTargetType(1);
            this.mMessenger.notifyEvent(videoEvent);
        }
    }

    public void setInterceptor(@Nullable IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, iVideoEventInterceptor) == null) {
            getBindPlayer().setInterceptor(iVideoEventInterceptor);
        }
    }

    public void setLayerContainer(@NonNull LayerContainer layerContainer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, layerContainer) == null) {
            this.mLayerContainer = layerContainer;
        }
    }

    public void addInterceptor(int i, @NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, iVideoEventInterceptor) == null) {
            getBindPlayer().addInterceptor(i, iVideoEventInterceptor);
        }
    }
}
