package com.baidu.down.utils;

import android.net.TrafficStats;
import android.os.Build;
/* loaded from: classes4.dex */
public class TrafficStatsUtils {
    public static void setThreadStatsTag(int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            TrafficStats.setThreadStatsTag(i);
        }
    }

    public static void clearThreadStatsTag() {
        if (Build.VERSION.SDK_INT >= 15) {
            TrafficStats.clearThreadStatsTag();
        }
    }
}
