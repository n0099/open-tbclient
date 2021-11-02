package com.baidu.searchbox.player.layer;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes7.dex */
public abstract class AbsLayer implements ILayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public IMessenger mCourier;
    public Handler mHandler;
    public LayerContainer mLayerContainer;

    /* loaded from: classes7.dex */
    public static class PrivateHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<AbsLayer> mWeakControl;

        public PrivateHandler(AbsLayer absLayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absLayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (absLayer = this.mWeakControl.get()) == null || absLayer.getContentView() == null || absLayer.getContentView().getParent() == null) {
                return;
            }
            absLayer.handleLayerMessage(message);
        }
    }

    public AbsLayer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init(null);
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

    private boolean isCourierValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.mCourier != null : invokeV.booleanValue;
    }

    private void registerEvent() {
        int[] subscribeEvent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || !isCourierValid() || (subscribeEvent = getSubscribeEvent()) == null || subscribeEvent.length <= 0) {
            return;
        }
        for (int i2 : subscribeEvent) {
            this.mCourier.register(i2, this);
        }
    }

    private void sendVideoEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, videoEvent) == null) && isCourierValid()) {
            videoEvent.setSender(this);
            this.mCourier.notifyEvent(videoEvent);
        }
    }

    @Nullable
    @PublicMethod
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getBindPlayer().getActivity() : (Activity) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mContext.getApplicationContext() : (Context) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public BDVideoPlayer getBindPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mLayerContainer.getBindPlayer() : (BDVideoPlayer) invokeV.objValue;
    }

    @PublicMethod
    public ControlEventTrigger getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getBindPlayer().getVideoSession().getControlEventTrigger() : (ControlEventTrigger) invokeV.objValue;
    }

    @PublicMethod
    public Handler getHandlerInnerLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mHandler : (Handler) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    @NonNull
    public LayerContainer getLayerContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLayerContainer : (LayerContainer) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public void handleLayerMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, message) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void initLayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void injectMessenger(@NonNull IMessenger iMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iMessenger) == null) {
            this.mCourier = iMessenger;
            registerEvent();
        }
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onContainerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onLayerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            BdVideoLog.d("onLayerRelease:" + this);
            this.mHandler.removeCallbacksAndMessages(null);
            this.mContext = null;
            this.mCourier = null;
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, playerStatus, playerStatus2) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void sendEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, videoEvent) == null) {
            sendVideoEvent(videoEvent);
        }
    }

    public void sendPluginEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, videoEvent) == null) && isCourierValid()) {
            videoEvent.setTargetType(1);
            this.mCourier.notifyEvent(videoEvent);
        }
    }

    public void setInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, iVideoEventInterceptor) == null) {
            getBindPlayer().getVideoSession().setInterceptor(iVideoEventInterceptor);
        }
    }

    public void setLayerContainer(@NonNull LayerContainer layerContainer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, layerContainer) == null) {
            this.mLayerContainer = layerContainer;
        }
    }

    public AbsLayer(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init(context);
    }
}
