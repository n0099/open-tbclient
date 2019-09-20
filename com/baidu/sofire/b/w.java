package com.baidu.sofire.b;

import android.annotation.SuppressLint;
import android.net.TrafficStats;
import android.os.Build;
/* loaded from: classes2.dex */
public final class w {
    @SuppressLint({"NewApi"})
    public static void a() {
        try {
            if (Build.VERSION.SDK_INT >= 15) {
                TrafficStats.setThreadStatsTag(155648);
            }
        } catch (Throwable th) {
            e.a();
        }
    }

    @SuppressLint({"NewApi"})
    public static void b() {
        try {
            if (Build.VERSION.SDK_INT >= 15) {
                TrafficStats.clearThreadStatsTag();
            }
        } catch (Throwable th) {
            e.a();
        }
    }
}
