package com.baidu.sofire.utility;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public final class w {

    /* renamed from: c  reason: collision with root package name */
    public static w f10451c;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f10452a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f10453b;

    public w(Context context) {
        SharedPreferences sharedPreferences = com.baidu.sofire.h.a.a(context).f10321a;
        this.f10452a = sharedPreferences;
        this.f10453b = sharedPreferences.edit();
    }

    public static synchronized w a(Context context) {
        synchronized (w.class) {
            if (context == null) {
                return f10451c;
            }
            if (f10451c == null) {
                f10451c = new w(context);
            }
            return f10451c;
        }
    }

    public final boolean a() {
        return this.f10452a.getBoolean("lt_sdcf", true);
    }

    public final void a(boolean z) {
        this.f10453b.putBoolean("lt_sssf", z);
        this.f10453b.commit();
    }
}
