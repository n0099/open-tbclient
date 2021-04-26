package com.baidu.android.util.time;

import android.content.Context;
@Deprecated
/* loaded from: classes.dex */
public class TimeUtils {
    public static final String MD = "MM-dd";
    public static long MSEC_OF_ONE_DAY = 86400000;
    public static long MSEC_OF_ONE_HOUR = 3600000;
    public static long MSEC_OF_ONE_MINUTE = 60000;
    public static long MSEC_OF_ONE_SEC = 1000;
    public static final String Y4MD = "yyyy-MM-dd";
    public static final String Y4MD_HM = "yyyy-MM-dd HH:mm";

    public static String getFormatTeletextTime(Context context, long j) {
        return getFormatTeletextTime(context, j, true);
    }

    public static String getFormatTeletextTime(Context context, long j, boolean z) {
        return DateTimeUtil.getFormatTeletextTime(context, j, z);
    }
}
