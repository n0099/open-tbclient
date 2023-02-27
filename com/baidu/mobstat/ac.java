package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class ac extends bm {
    public static final String a = "baidu_mtj_sdk_record";
    public static ac b = new ac();

    public static ac a() {
        return b;
    }

    @Override // com.baidu.mobstat.bm
    public SharedPreferences a(Context context) {
        return context.getSharedPreferences(a, 0);
    }

    public Long b(Context context) {
        return Long.valueOf(a(context, "session_first_visit_time", 0L));
    }

    public Long c(Context context) {
        return Long.valueOf(a(context, "session_last_visit_time", 0L));
    }

    public Long d(Context context) {
        return Long.valueOf(a(context, "session_visit_interval", 0L));
    }

    public String e(Context context) {
        return a(context, "session_today_visit_count", "");
    }

    public String f(Context context) {
        return a(context, "session_recent_visit", "");
    }

    public void a(Context context, long j) {
        b(context, "session_first_visit_time", j);
    }

    public void b(Context context, long j) {
        b(context, "session_last_visit_time", j);
    }

    public void c(Context context, long j) {
        b(context, "session_visit_interval", j);
    }

    public void a(Context context, String str) {
        b(context, "session_today_visit_count", str);
    }

    public void b(Context context, String str) {
        b(context, "session_recent_visit", str);
    }
}
