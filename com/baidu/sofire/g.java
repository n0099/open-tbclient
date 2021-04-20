package com.baidu.sofire;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f11406a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f11407b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11408c;

    public g(Context context) {
        try {
            this.f11408c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 0);
            this.f11406a = sharedPreferences;
            this.f11407b = sharedPreferences.edit();
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    public final String a() {
        return this.f11406a.getString("xytk", "");
    }

    public final String b() {
        return this.f11406a.getString("xytk_m", "");
    }

    public final void a(String str) {
        this.f11407b.putString("xytk_m", str);
        if (Build.VERSION.SDK_INT >= 9) {
            this.f11407b.apply();
        } else {
            this.f11407b.commit();
        }
    }
}
