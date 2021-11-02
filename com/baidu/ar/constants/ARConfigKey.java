package com.baidu.ar.constants;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ARConfigKey {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AR_FROM = "ar_from";
    public static final String AR_ID = "ar_id";
    public static final String AR_KEY = "ar_key";
    public static final String AR_LAUNCH_MODE = "ar_launch_mode";
    public static final String AR_NEED_LAST_PREVIEW = "ar_last_preview";
    public static final String AR_PATH = "ar_path";
    public static final String AR_TYPE = "ar_type";
    public static final String AR_VALUE = "arValue";
    public static final String EXTRA_INFO = "extra_info";
    public static final String OLD_AR_KEY = "arKey";
    public static final String OLD_AR_TYPE = "arType";
    public transient /* synthetic */ FieldHolder $fh;

    public ARConfigKey() {
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
