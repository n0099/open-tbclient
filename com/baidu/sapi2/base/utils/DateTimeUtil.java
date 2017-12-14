package com.baidu.sapi2.base.utils;

import com.baidu.sapi2.base.debug.Log;
/* loaded from: classes.dex */
public final class DateTimeUtil {
    public static int getHourDiff(long j, long j2) {
        long j3 = 0;
        try {
            j3 = Math.abs(j - j2) / 3600000;
        } catch (Exception e) {
            Log.e(Log.TAG, e);
        }
        return (int) j3;
    }
}
