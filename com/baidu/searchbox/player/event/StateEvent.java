package com.baidu.searchbox.player.event;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class StateEvent extends VideoEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_STATE_CHANGED = "state_event_state_changed";
    public static final int KEY_NEW_STATUS = 2;
    public static final int KEY_OLD_STATUS = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateEvent() {
        super(ACTION_STATE_CHANGED);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setType(5);
    }

    public PlayerStatus getOldStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return getStatus(1);
        }
        return (PlayerStatus) invokeV.objValue;
    }

    public PlayerStatus getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return getStatus(2);
        }
        return (PlayerStatus) invokeV.objValue;
    }

    private PlayerStatus getStatus(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            return (PlayerStatus) getExtra(i);
        }
        return (PlayerStatus) invokeI.objValue;
    }

    public static VideoEvent obtainEvent(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, playerStatus, playerStatus2)) == null) {
            VideoEvent obtain = VideoEvent.obtain(ACTION_STATE_CHANGED, 5);
            obtain.putExtra(1, playerStatus);
            obtain.putExtra(2, playerStatus2);
            return obtain;
        }
        return (VideoEvent) invokeLL.objValue;
    }

    public void setStatus(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, playerStatus, playerStatus2) == null) {
            putExtra(1, playerStatus);
            putExtra(2, playerStatus2);
        }
    }
}
