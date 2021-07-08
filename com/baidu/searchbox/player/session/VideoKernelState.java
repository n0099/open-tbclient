package com.baidu.searchbox.player.session;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.StateEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class VideoKernelState {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IMessenger mCourier;
    public PlayerStatus mStatus;

    public VideoKernelState(IMessenger iMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMessenger};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCourier = iMessenger;
        init();
    }

    private VideoEvent setupEvent(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, playerStatus, playerStatus2)) == null) {
            VideoEvent obtainEvent = StateEvent.obtainEvent();
            obtainEvent.putExtra(1, playerStatus);
            obtainEvent.putExtra(2, playerStatus2);
            return obtainEvent;
        }
        return (VideoEvent) invokeLL.objValue;
    }

    @PublicMethod
    public PlayerStatus getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mStatus : (PlayerStatus) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mStatus = PlayerStatus.IDLE;
        }
    }

    @PublicMethod
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mStatus == PlayerStatus.COMPLETE : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mStatus == PlayerStatus.ERROR : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mStatus == PlayerStatus.IDLE : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mStatus == PlayerStatus.PAUSE : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mStatus == PlayerStatus.PLAYING : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPrepared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mStatus == PlayerStatus.PREPARED : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPreparing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mStatus == PlayerStatus.PREPARING : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mStatus == PlayerStatus.STOP : invokeV.booleanValue;
    }

    public void receivePlayerEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, videoEvent) == null) {
            if (videoEvent.getType() == 4 || videoEvent.getType() == 2) {
                String action = videoEvent.getAction();
                char c2 = 65535;
                switch (action.hashCode()) {
                    case -525235558:
                        if (action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -461848373:
                        if (action.equals(PlayerEvent.ACTION_ON_ERROR)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 154871702:
                        if (action.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1370689931:
                        if (action.equals(PlayerEvent.ACTION_ON_INFO)) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    int intValue = ((Integer) videoEvent.getExtra(1)).intValue();
                    if (904 == intValue || 956 == intValue) {
                        stateChangeNotify(PlayerStatus.PLAYING);
                    }
                } else if (c2 == 1) {
                    stateChangeNotify(PlayerStatus.COMPLETE);
                } else if (c2 == 2) {
                    stateChangeNotify(PlayerStatus.PREPARED);
                } else if (c2 != 3) {
                } else {
                    stateChangeNotify(PlayerStatus.ERROR);
                }
            }
        }
    }

    public void stateChangeNotify(PlayerStatus playerStatus) {
        PlayerStatus playerStatus2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, playerStatus) == null) || playerStatus == (playerStatus2 = this.mStatus)) {
            return;
        }
        this.mCourier.notifyEvent(setupEvent(playerStatus2, playerStatus));
        this.mStatus = playerStatus;
    }
}
