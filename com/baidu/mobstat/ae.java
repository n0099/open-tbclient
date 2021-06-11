package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes2.dex */
public class ae extends bn {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8536a = "baidu_mtj_sdk_record";

    /* renamed from: b  reason: collision with root package name */
    public static ae f8537b = new ae();

    public static ae a() {
        return f8537b;
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

    @Override // com.baidu.mobstat.bn
    public SharedPreferences a(Context context) {
        if (Build.VERSION.SDK_INT >= 11) {
            return context.getSharedPreferences(f8536a, 4);
        }
        return context.getSharedPreferences(f8536a, 0);
    }

    public void b(Context context, long j) {
        b(context, "session_last_visit_time", j);
    }

    public void c(Context context, long j) {
        b(context, "session_visit_interval", j);
    }

    public void b(Context context, String str) {
        b(context, "session_recent_visit", str);
    }

    public void a(Context context, long j) {
        b(context, "session_first_visit_time", j);
    }

    public void a(Context context, String str) {
        b(context, "session_today_visit_count", str);
    }
}
