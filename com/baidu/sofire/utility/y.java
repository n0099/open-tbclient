package com.baidu.sofire.utility;

import android.annotation.SuppressLint;
import android.net.TrafficStats;
import android.os.Build;
/* loaded from: classes2.dex */
public final class y {
    @SuppressLint({"NewApi"})
    public static void a() {
        try {
            if (Build.VERSION.SDK_INT >= 15) {
                TrafficStats.setThreadStatsTag(155648);
            }
        } catch (Throwable unused) {
            c.a();
        }
    }

    @SuppressLint({"NewApi"})
    public static void b() {
        try {
            if (Build.VERSION.SDK_INT >= 15) {
                TrafficStats.clearThreadStatsTag();
            }
        } catch (Throwable unused) {
            c.a();
        }
    }
}
