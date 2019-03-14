package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes6.dex */
class al extends bu {
    private static final String a = "baidu_mtj_sdk_record";
    private static al b = new al();

    private al() {
    }

    public static al a() {
        return b;
    }

    @Override // com.baidu.mobstat.bu
    public SharedPreferences getSharedPreferences(Context context) {
        return Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences(a, 4) : context.getSharedPreferences(a, 0);
    }

    public void a(Context context, long j) {
        putLong(context, "session_first_visit_time", j);
    }

    public Long a(Context context) {
        return Long.valueOf(getLong(context, "session_first_visit_time", 0L));
    }

    public void b(Context context, long j) {
        putLong(context, "session_last_visit_time", j);
    }

    public Long b(Context context) {
        return Long.valueOf(getLong(context, "session_last_visit_time", 0L));
    }

    public void c(Context context, long j) {
        putLong(context, "session_visit_interval", j);
    }

    public Long c(Context context) {
        return Long.valueOf(getLong(context, "session_visit_interval", 0L));
    }

    public void a(Context context, String str) {
        putString(context, "session_today_visit_count", str);
    }

    public String d(Context context) {
        return getString(context, "session_today_visit_count", "");
    }

    public void b(Context context, String str) {
        putString(context, "session_recent_visit", str);
    }

    public String e(Context context) {
        return getString(context, "session_recent_visit", "");
    }
}
