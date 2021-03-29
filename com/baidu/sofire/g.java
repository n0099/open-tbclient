package com.baidu.sofire;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f11745a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f11746b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11747c;

    public g(Context context) {
        try {
            this.f11747c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 0);
            this.f11745a = sharedPreferences;
            this.f11746b = sharedPreferences.edit();
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    public final String a() {
        return this.f11745a.getString("xytk", "");
    }

    public final String b() {
        return this.f11745a.getString("xytk_m", "");
    }

    public final void a(String str) {
        this.f11746b.putString("xytk_m", str);
        if (Build.VERSION.SDK_INT >= 9) {
            this.f11746b.apply();
        } else {
            this.f11746b.commit();
        }
    }
}
