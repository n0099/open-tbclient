package com.baidu.searchbox.retrieve.inter.constants;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FetchConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FETCH_UBC_ID = "1289";
    public static final String KEY_COUNT = "count";
    public static final String KEY_EXPIRED_TIME = "expiredTime";
    public static final String KEY_EXT = "ext";
    public static final String KEY_JOBID = "jobId";
    public static final String KEY_ORIGIN = "origin";
    public static final String KEY_REPORT_JOBID = "jobid";
    public static final String KEY_STATUS = "status";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VALUE = "value";
    public static final String KEY_VERSION = "version";
    public transient /* synthetic */ FieldHolder $fh;

    public FetchConstants() {
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
