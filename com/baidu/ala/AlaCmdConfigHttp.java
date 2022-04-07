package com.baidu.ala;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AlaCmdConfigHttp {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CMD_ALA_ENTER_EFFECT_BUY_PROP = 1021145;
    public static final int CMD_ALA_FRS_STORY_LIVE_GATHER = 1021075;
    public static final int CMD_ALA_GET_ENTER_EFFECT = 1021133;
    public static final int CMD_ALA_GET_GLOBAL_PUSH_SWITCH = 1021051;
    public static final int CMD_ALA_GET_PRIVILEGE_MARK_LIST = 1021134;
    public static final int CMD_ALA_GET_RECENT_HISTORY_LIST = 1021082;
    public static final int CMD_ALA_GET_TAB_LIVE_INFO = 1021141;
    public static final int CMD_ALA_GET_USER_NOTIFY = 1021149;
    public static final int CMD_ALA_GIFT_REFRESH_SCORES = 1021019;
    public static final int CMD_ALA_LIVE_FRS_GAME = 1021064;
    public static final int CMD_ALA_LIVE_GET_CLOSED_STATUS = 1021020;
    public static final int CMD_ALA_LIVE_SHARE_IN_BAR = 1021151;
    public static final int CMD_ALA_LIVE_SQUARE_GET_TAB_INFO = 1021080;
    public static final int CMD_ALA_NEW_SQUARE_SUB_LIST = 1021081;
    public static final int CMD_ALA_PERSON_GET_LIVES = 1021025;
    public static final int CMD_ALA_SPECIAL_CONCERN_TAB = 1021094;
    public static final int CMD_ALA_SPECIAL_LIVE_DATA = 1021093;
    public static final int CMD_ALA_SPECIAL_RECOMMEND_TAB = 1021095;
    public static final int CMD_ALA_SUB_LIVE_LIST = 1021055;
    public static final int CMD_ALA_SYNC = 1021011;
    public static final int CMD_ALA_TAB_SUB_MY_CONCERN_LIST = 1021140;
    public static final int CMD_ALA_UPDATE_ENTER_EFFECT = 1021136;
    public static final int CMD_ALA_UPDATE_MARK_WEAR_STATUS = 1021135;
    public static final int CMD_ALA_USER_CENTER = 1021001;
    public static final int CMD_SQUARE_LIVE = 1021054;
    public static final int FRS_ALA_LIVE_TAB_CMD = 1021038;
    public transient /* synthetic */ FieldHolder $fh;

    public AlaCmdConfigHttp() {
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
