package com.baidu.sofire;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f11744a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f11745b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11746c;

    public g(Context context) {
        try {
            this.f11746c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 0);
            this.f11744a = sharedPreferences;
            this.f11745b = sharedPreferences.edit();
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    public final String a() {
        return this.f11744a.getString("xytk", "");
    }

    public final String b() {
        return this.f11744a.getString("xytk_m", "");
    }

    public final void a(String str) {
        this.f11745b.putString("xytk_m", str);
        if (Build.VERSION.SDK_INT >= 9) {
            this.f11745b.apply();
        } else {
            this.f11745b.commit();
        }
    }
}
