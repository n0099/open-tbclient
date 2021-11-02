package com.baidu.ar.statistic;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class q {
    public static /* synthetic */ Interceptable $ic;
    public static final String[][] xb;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2090663769, "Lcom/baidu/ar/statistic/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2090663769, "Lcom/baidu/ar/statistic/q;");
                return;
            }
        }
        xb = new String[][]{new String[]{StatisticConstants.EVENT_SDK_START, StatisticConstants.EVENT_SDK_END}, new String[]{StatisticConstants.EVENT_CASE_START, StatisticConstants.EVENT_CASE_END}, new String[]{StatisticConstants.START_DOWNLOAD_3D_RES, StatisticConstants.DOWNLOAD_3D_RES_SUCCESS}, new String[]{StatisticConstants.FIRST_LOAD_START_QUERY, StatisticConstants.FIRST_LOAD_QUERY_SUCCESS}};
    }
}
