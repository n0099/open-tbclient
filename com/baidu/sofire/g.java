package com.baidu.sofire;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f11237a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f11238b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11239c;

    public g(Context context) {
        try {
            this.f11239c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 0);
            this.f11237a = sharedPreferences;
            this.f11238b = sharedPreferences.edit();
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    public final String a() {
        return this.f11237a.getString("xytk", "");
    }

    public final String b() {
        return this.f11237a.getString("xytk_m", "");
    }

    public final void a(String str) {
        this.f11238b.putString("xytk_m", str);
        if (Build.VERSION.SDK_INT >= 9) {
            this.f11238b.apply();
        } else {
            this.f11238b.commit();
        }
    }
}
