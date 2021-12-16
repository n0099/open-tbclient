package com.baidu.fsg.base.restnet.beans.business.core.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ABTestConstant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ABTestEndEk = "ABTestEnd";
    public static final String ABTestStartEk = "ABTestStart";
    public static final String LIVENESS_BG_STYLE_EXP_ID = "1";
    public static final String LIVENESS_BG_STYLE_EXP_KEY_LIVENESS_BG_STYLE = "liveness_bg_style";
    public static final String LIVENESS_BG_STYLE_EXP_KEY_LIVENESS_BG_STYLE_VALUE_DEFAULT = "0";
    public static final String LIVENESS_BG_STYLE_EXP_KEY_LIVENESS_BG_STYLE_VALUE_WHITE = "1";
    public transient /* synthetic */ FieldHolder $fh;

    public ABTestConstant() {
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
