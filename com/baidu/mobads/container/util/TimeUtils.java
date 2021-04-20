package com.baidu.mobads.container.util;

import android.content.Context;
import d.b.b.a.a.b.a;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class TimeUtils {
    public static long getDateHour() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:00:00").format(new Date(System.currentTimeMillis()))).getTime();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static long getLastOpenAppTime(Context context) {
        try {
            return ((Long) a.b(context).c("com.baidu.searchbox").second).longValue();
        } catch (Throwable unused) {
            return -1L;
        }
    }
}
