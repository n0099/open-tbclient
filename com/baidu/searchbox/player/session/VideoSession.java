package com.baidu.searchbox.player.session;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEventTrigger;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.StateEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class VideoSession {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ControlEventTrigger mControlEventTrigger;
    public StringBuilder mDesc;
    @Nullable
    public IMessenger mMessenger;
    public PlayerStatus mStatus;

    public VideoSession() {
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
        this.mStatus = PlayerStatus.IDLE;
        this.mControlEventTrigger = new ControlEventTrigger();
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
        }
    }

    public void accessEventNotify(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, videoEvent) == null) {
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
                    int intExtra = videoEvent.getIntExtra(1);
                    if (904 == intExtra || 956 == intExtra) {
                        statusChangeNotify(PlayerStatus.PLAYING);
                    }
                } else if (c2 == 1) {
                    statusChangeNotify(PlayerStatus.COMPLETE);
                } else if (c2 == 2) {
                    statusChangeNotify(PlayerStatus.PREPARED);
                } else if (c2 != 3) {
                } else {
                    statusChangeNotify(PlayerStatus.ERROR);
                }
            }
        }
    }

    public void bindMessenger(@NonNull IMessenger iMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iMessenger) == null) {
            this.mMessenger = iMessenger;
        }
    }

    @Deprecated
    public ControlEventTrigger getControlEventTrigger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mControlEventTrigger : (ControlEventTrigger) invokeV.objValue;
    }

    @Nullable
    @PublicMethod
    public IMessenger getMessenger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMessenger : (IMessenger) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public PlayerStatus getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mStatus : (PlayerStatus) invokeV.objValue;
    }

    @PublicMethod
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mStatus == PlayerStatus.COMPLETE : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mStatus == PlayerStatus.ERROR : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mStatus == PlayerStatus.IDLE : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mStatus == PlayerStatus.PAUSE : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mStatus == PlayerStatus.PLAYING : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPrepared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mStatus == PlayerStatus.PREPARED : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPreparing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mStatus == PlayerStatus.PREPARING : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mStatus == PlayerStatus.STOP : invokeV.booleanValue;
    }

    public boolean matchStatus(@NonNull PlayerStatus... playerStatusArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, playerStatusArr)) == null) {
            for (PlayerStatus playerStatus : playerStatusArr) {
                if (playerStatus == getStatus()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            unbindMessenger();
            this.mStatus = PlayerStatus.IDLE;
        }
    }

    public void statusChangeNotify(PlayerStatus playerStatus) {
        PlayerStatus playerStatus2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, playerStatus) == null) || playerStatus == (playerStatus2 = this.mStatus)) {
            return;
        }
        this.mStatus = playerStatus;
        IMessenger iMessenger = this.mMessenger;
        if (iMessenger != null) {
            iMessenger.notifyEvent(StateEvent.obtainEvent(playerStatus2, playerStatus));
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (BDPlayerConfig.isDebug()) {
                StringBuilder sb = this.mDesc;
                if (sb == null) {
                    this.mDesc = new StringBuilder();
                } else if (sb.length() > 0) {
                    StringBuilder sb2 = this.mDesc;
                    sb2.delete(0, sb2.length());
                }
                StringBuilder sb3 = this.mDesc;
                sb3.append("，Courier :");
                sb3.append(this.mMessenger);
                sb3.append("，status :");
                sb3.append(this.mStatus);
                sb3.append("，hash :");
                sb3.append(hashCode());
                sb3.append("】");
                return this.mDesc.toString();
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }

    public void unbindMessenger() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mMessenger = null;
        }
    }
}
