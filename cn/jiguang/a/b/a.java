package cn.jiguang.a.b;

import android.content.Context;
import cn.jiguang.d.a.d;
/* loaded from: classes3.dex */
public final class a {
    public static long a(Context context) {
        long longValue = ((Long) d.b(context, "report_location_frequency", 3600000L)).longValue();
        if (longValue > 0) {
            return longValue;
        }
        return 3600000L;
    }

    public static void a(Context context, boolean z) {
        d.a(context, "lbs_report_enable", Boolean.valueOf(z));
    }

    public static String b(Context context) {
        return cn.jiguang.d.a.a.b(context, "number_appsecret", "2b90de0f1f88eaf49593f1d827b19c63");
    }

    public static void b(Context context, boolean z) {
        d.a(context, "lbs_report_now", Boolean.valueOf(z));
    }

    public static long c(Context context) {
        return ((Long) d.b(context, "report_arpinfo_frequency", 0L)).longValue();
    }

    public static void c(Context context, boolean z) {
        d.a(context, "nb_upload", Boolean.valueOf(z));
    }
}
