package com.baidu.searchbox.player.ubc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PlayerSpeedMonitorConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PART_ACTIVITY_CREATE = "P12_ActivityCreate";
    public static final String PART_AFTER_INIT_PLAYER_TO_START = "P24_AfterInitPlayerToStart";
    public static final String PART_CALL_PLAYER = "P1_CallPlayer";
    public static final String PART_INIT_LAYER = "P22_InitLayer";
    public static final String PART_INIT_PLAYER_ENV = "P21_InitPlayer";
    public static final String PART_INIT_PLUGIN = "P23_InitPlugin";
    public static final String PART_PREPARE_RESOURCE = "P24_1_PrepareResource";
    public static final String PART_SCHEME_DISPATCH = "P11_SchemeDispatch";
    public static final String PART_START_PLAYER = "P2_StartPlayer";
    public static final String PART_START_PLAY_TO_FIRST_FRAME_DISPLAY = "P3_PlayerCore";
    public transient /* synthetic */ FieldHolder $fh;

    public PlayerSpeedMonitorConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
