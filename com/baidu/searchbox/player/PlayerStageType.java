package com.baidu.searchbox.player;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PlayerStageType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AD = 23;
    public static final int APS = 14;
    public static final int BAIKE = 10;
    public static final int COMIC = 4;
    public static final int DUOMO = 11;
    public static final int FEED_LIVE = 8;
    public static final int FEED_SHORT_VIDEO = 1;
    public static final int FLOW_FROM_H5_VIDEO = 44;
    public static final int HOT_DISCUSSION = 48;
    public static final int INTERACT = 9;
    public static final int KANKAN = 45;
    public static final int LIVE = 8;
    public static final int LOCAL = -2;
    public static final int MINIGAME = 21;
    public static final int MINI_VIDEO = 22;
    public static final int MINI_VIDEO_LIVE_CARD_BD = 1005;
    public static final int MINI_VIDEO_LIVE_CARD_XC = 1006;
    public static final int MINI_VIDEO_LIVE_CARD_YY = 1009;
    public static final int MINI_VIDEO_LIVE_FLOAT_BD = 1008;
    public static final int MINI_VIDEO_LIVE_FLOAT_XC = 1007;
    public static final int MINI_VIDEO_LIVE_FLOAT_YY = 1010;
    public static final int NEWS = 5;
    public static final int NOVEL = 3;
    public static final int NUOMI = 13;
    public static final int OTHER = -1;
    public static final int SEARCH = 6;
    public static final int SPLASH_VIDEO = 47;
    public static final int STARTUP = 12;
    public static final int SWAN = 43;
    public static final int TALOS = 50;
    public static final int TIEBA = 24;
    public static final int UGC = 7;
    public transient /* synthetic */ FieldHolder $fh;

    public PlayerStageType() {
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
