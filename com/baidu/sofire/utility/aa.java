package com.baidu.sofire.utility;

import android.annotation.SuppressLint;
import android.net.TrafficStats;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"NewApi"})
    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 15) {
                    TrafficStats.setThreadStatsTag(155648);
                }
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 15) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (Throwable unused) {
                c.a();
            }
        }
    }
}
