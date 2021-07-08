package com.baidu.searchbox.player.session;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEventTrigger;
import com.baidu.searchbox.player.event.PlayerEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.layer.ILayer;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.pool.IPoolItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class VideoSession implements IPoolItem {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ControlEventTrigger mControlEventTrigger;
    public IMessenger mCourier;
    public StringBuilder mDesc;
    public PlayerEventTrigger mPlayerEventTrigger;
    public VideoKernelState mState;
    public BDVideoPlayer mTargetPlayer;

    public VideoSession() {
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
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            IMessenger createMessenger = BDPlayerConfig.getMessengerFactory().createMessenger(this);
            this.mCourier = createMessenger;
            this.mState = new VideoKernelState(createMessenger);
            PlayerEventTrigger playerEventTrigger = new PlayerEventTrigger();
            this.mPlayerEventTrigger = playerEventTrigger;
            playerEventTrigger.register(this.mCourier);
            ControlEventTrigger controlEventTrigger = new ControlEventTrigger();
            this.mControlEventTrigger = controlEventTrigger;
            controlEventTrigger.register(this.mCourier);
        }
    }

    public void bind(@NonNull BDVideoPlayer bDVideoPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bDVideoPlayer) == null) {
            this.mTargetPlayer = bDVideoPlayer;
        }
    }

    @NonNull
    @PublicMethod
    public ControlEventTrigger getControlEventTrigger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mControlEventTrigger : (ControlEventTrigger) invokeV.objValue;
    }

    @PublicMethod
    public IMessenger getMessenger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCourier : (IMessenger) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public PlayerEventTrigger getPlayerEventTrigger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPlayerEventTrigger : (PlayerEventTrigger) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public VideoKernelState getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mState : (VideoKernelState) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public PlayerStatus getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mState.getStatus() : (PlayerStatus) invokeV.objValue;
    }

    @PublicMethod
    public BDVideoPlayer getTargetPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mTargetPlayer : (BDVideoPlayer) invokeV.objValue;
    }

    @PublicMethod
    public boolean isBindPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mTargetPlayer != null : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mState.isComplete() : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mState.isError() : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mState.isPause() : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mState.isPlaying() : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPrepared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mState.isPrepared() : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPreparing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mState.isPreparing() : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mState.isStop() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            init();
        }
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            unbind();
            IMessenger iMessenger = this.mCourier;
            if (iMessenger != null) {
                iMessenger.release();
                this.mCourier = null;
            }
            this.mPlayerEventTrigger.clear();
            this.mControlEventTrigger.clear();
        }
    }

    @PublicMethod
    public void registerLayer(@NonNull ILayer iLayer, int i2) {
        IMessenger iMessenger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048593, this, iLayer, i2) == null) || (iMessenger = this.mCourier) == null) {
            return;
        }
        iMessenger.register(i2, iLayer);
    }

    @PublicMethod
    public void sendEvent(VideoEvent videoEvent) {
        IMessenger iMessenger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, videoEvent) == null) || (iMessenger = this.mCourier) == null) {
            return;
        }
        iMessenger.notifyEvent(videoEvent);
    }

    @PublicMethod
    public void setInterceptor(IVideoEventInterceptor iVideoEventInterceptor) {
        IMessenger iMessenger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, iVideoEventInterceptor) == null) || (iMessenger = this.mCourier) == null) {
            return;
        }
        iMessenger.setInterceptor(iVideoEventInterceptor);
    }

    @PublicMethod
    public void syncSession(@NonNull VideoSession videoSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, videoSession) == null) {
            this.mTargetPlayer = videoSession.getTargetPlayer();
            this.mState.stateChangeNotify(videoSession.getStatus());
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (BDPlayerConfig.isDebug()) {
                StringBuilder sb = this.mDesc;
                if (sb == null) {
                    this.mDesc = new StringBuilder();
                } else if (sb.length() > 0) {
                    StringBuilder sb2 = this.mDesc;
                    sb2.delete(0, sb2.length());
                }
                StringBuilder sb3 = this.mDesc;
                sb3.append("VideoSession【TargetPlayer :");
                sb3.append(this.mTargetPlayer);
                sb3.append("，Courier :");
                sb3.append(this.mCourier);
                sb3.append("，VideoKernelState :");
                sb3.append(this.mState);
                sb3.append("，PlayerEventTrigger :");
                sb3.append(this.mPlayerEventTrigger);
                sb3.append("，ControlEventTrigger :");
                sb3.append(this.mControlEventTrigger);
                sb3.append("，hash :");
                sb3.append(hashCode());
                sb3.append("】");
                return this.mDesc.toString();
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }

    public void unbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.mTargetPlayer = null;
        }
    }

    @PublicMethod
    public void unregisterLayer(@NonNull ILayer iLayer) {
        IMessenger iMessenger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, iLayer) == null) || (iMessenger = this.mCourier) == null) {
            return;
        }
        iMessenger.unregister(iLayer);
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}
