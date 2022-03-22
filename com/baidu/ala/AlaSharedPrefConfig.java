package com.baidu.ala;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AlaSharedPrefConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME = "ala_live_tab_notifi_close_time";
    public static final String ALA_MY_LIVE_PRIVILEGE_HAS_ENTERED = "ala_my_live_privilege_has_entered";
    public static final String ALA_SHARED_PRE_FILE_NAME = "ala_setting";
    public static final String SQUARE_GUIDE_MARK_MANAGE_TIP_SHOW = "square_guide_mark_manage_tip_show";
    public transient /* synthetic */ FieldHolder $fh;

    public AlaSharedPrefConfig() {
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
