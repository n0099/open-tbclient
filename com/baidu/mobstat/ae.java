package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes15.dex */
class ae extends bn {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3682a = "baidu_mtj_sdk_record";

    /* renamed from: b  reason: collision with root package name */
    private static ae f3683b = new ae();

    private ae() {
    }

    public static ae a() {
        return f3683b;
    }

    @Override // com.baidu.mobstat.bn
    public SharedPreferences a(Context context) {
        return Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences(f3682a, 4) : context.getSharedPreferences(f3682a, 0);
    }

    public void a(Context context, long j) {
        b(context, "session_first_visit_time", j);
    }

    public Long b(Context context) {
        return Long.valueOf(a(context, "session_first_visit_time", 0L));
    }

    public void b(Context context, long j) {
        b(context, "session_last_visit_time", j);
    }

    public Long c(Context context) {
        return Long.valueOf(a(context, "session_last_visit_time", 0L));
    }

    public void c(Context context, long j) {
        b(context, "session_visit_interval", j);
    }

    public Long d(Context context) {
        return Long.valueOf(a(context, "session_visit_interval", 0L));
    }

    public void a(Context context, String str) {
        b(context, "session_today_visit_count", str);
    }

    public String e(Context context) {
        return a(context, "session_today_visit_count", "");
    }

    public void b(Context context, String str) {
        b(context, "session_recent_visit", str);
    }

    public String f(Context context) {
        return a(context, "session_recent_visit", "");
    }
}
