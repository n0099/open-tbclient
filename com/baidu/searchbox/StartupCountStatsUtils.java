package com.baidu.searchbox;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class StartupCountStatsUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BACKGROUND_TIME_STAMP = "btime";
    public static final String CONTENT = "ext";
    public static final String DEFAULT_STARTUP_UBC_ID = "1482";
    public static final String DEFAULT_USE_DURATION_UBC_ID = "1557";
    public static final String FOREGROUND_TIME_STAMP = "ftime";
    public static final String FROM = "from";
    public static final String LAUNCH_SAMPLE = "launch_sample";
    public static final int MIN_RECORD_DURATION = 300000;
    public static final String PERF_SAMPLE_FLAG = "pf";
    public static final String PERF_SAMPLE_SEPARATOR = ",";
    public static final String SOURCE = "source";
    public static final String STARTUP_COLD_START = "cold_start";
    public static final String STARTUP_FROM_KEY = "research";
    public static final String START_WARM_START = "warm_start";
    public static final String TYPE = "type";
    public static final String USE_DURATION = "duration";
    public transient /* synthetic */ FieldHolder $fh;

    public StartupCountStatsUtils() {
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
