package com.baidu.ala;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class AlaCmdConfigCustom {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CMD_ALA_ALL_GAME_LIVE_ENTRY = 2913032;
    public static final int CMD_ALA_ALL_LIVE_SIMPLE = 2913033;
    public static final int CMD_ALA_ENTER_EFFECT_BUY_SUCCESS = 2913089;
    public static final int CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER = 2913083;
    public static final int CMD_ALA_LIVE_FRAGMENT_NET_BTN_CLICKED = 2913061;
    public static final int CMD_ALA_LIVE_TAB_RESPONSE = 2913090;
    public static final int CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH = 2913010;
    public static final int CMD_ALA_RES_ZIP_DOWNLOADED_STATUS = 2913079;
    public static final int CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON = 2913064;
    public static final int CMD_ALA_SQUARE_TAB_CONTROLLER = 2913057;
    public static final int CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA = 2913030;
    public transient /* synthetic */ FieldHolder $fh;

    public AlaCmdConfigCustom() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
