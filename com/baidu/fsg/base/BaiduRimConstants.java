package com.baidu.fsg.base;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class BaiduRimConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_TARGET = "target";
    public static final String APPID_INIT_KEY = "appid";
    public static final String APPKEY_INIT_KEY = "appkey";
    public static final String METHODDATA_KEY = "methodData";
    public static final String METHODNAME_KEY = "method";
    public static final String RESULT_KEY = "result";
    public static final int RESULT_KEY_VALUE_SUCCESS = 0;
    public static final String RETCODE_KEY = "retCode";
    public static final String RETMSG_KEY = "retMsg";
    public static final String RIM_ID_KEY = "rimid";
    public static final String TARGET_TPL = "pp";
    public static final String TPL_INIT_KEY = "tpl";
    public transient /* synthetic */ FieldHolder $fh;

    public BaiduRimConstants() {
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
