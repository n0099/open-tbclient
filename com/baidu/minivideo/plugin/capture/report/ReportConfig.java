package com.baidu.minivideo.plugin.capture.report;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class ReportConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_KEY_PUBLISH_DEBUG = "perf_publish_debug";
    public static final String LOG_KEY_PUBLISH_ERROR = "perf_publish_error";
    public static final String LOG_KEY_PUBLISH_SUCC = "perf_publish_succ";
    public static final String LOG_VALUE_UPLOAD_PROGRESS_STATUS = "v_upload_progress_status";
    public transient /* synthetic */ FieldHolder $fh;

    public ReportConfig() {
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
