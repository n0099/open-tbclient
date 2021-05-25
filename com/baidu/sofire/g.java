package com.baidu.sofire;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f10205a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f10206b;

    /* renamed from: c  reason: collision with root package name */
    public Context f10207c;

    public g(Context context) {
        try {
            this.f10207c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 0);
            this.f10205a = sharedPreferences;
            this.f10206b = sharedPreferences.edit();
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    public final String a() {
        return this.f10205a.getString("xytk", "");
    }

    public final String b() {
        return this.f10205a.getString("xytk_m", "");
    }

    public final void a(String str) {
        this.f10206b.putString("xytk_m", str);
        if (Build.VERSION.SDK_INT >= 9) {
            this.f10206b.apply();
        } else {
            this.f10206b.commit();
        }
    }
}
