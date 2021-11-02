package com.baidu.mobstat;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class Build {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SDK_CHANNEL_VALUE = 14;
    public static final boolean SDK_ENABLE_DEVICE = false;
    public static final boolean SDK_ENABLE_FEED = true;
    public static final boolean SDK_ENABLE_INPUT = false;
    public static final boolean SDK_ENABLE_MAC = true;
    public static final boolean SDK_FOR_CAR = false;
    public static final boolean SDK_FOR_DUEROS = false;
    public static final boolean SDK_FOR_HUAWEI = false;
    public static final boolean SDK_FOR_MAP = false;
    public static final boolean SDK_FOR_MB_DEV = false;
    public static final boolean SDK_FOR_RAVEN = false;
    public static final boolean SDK_FOR_SDK = false;
    public static final boolean SDK_INTERNAL = false;
    public static final boolean SDK_LOG_FILTER = false;
    public static final boolean SDK_RELEASE = true;
    public static final int SDK_TAG_VALUE = 1;
    public static final boolean SDK_TRACE_ALL = true;
    public static final String SDK_VERSION = "3.9.5.1";
    public static final boolean SDK_WITH_AUTOTRACE = true;
    public static final int SDK_WITH_BPLUS = 2;
    public static final boolean SDK_WITH_EXT = false;
    public transient /* synthetic */ FieldHolder $fh;

    public Build() {
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
