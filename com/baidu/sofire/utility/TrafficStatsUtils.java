package com.baidu.sofire.utility;

import android.annotation.SuppressLint;
import android.net.TrafficStats;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class TrafficStatsUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TAG_SOFIRE = 155648;
    public transient /* synthetic */ FieldHolder $fh;

    public TrafficStatsUtils() {
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

    @SuppressLint({"NewApi"})
    public static void clearThreadStatsTag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 15) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void setThreadStatsTag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 15) {
                    TrafficStats.setThreadStatsTag(TAG_SOFIRE);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }
}
