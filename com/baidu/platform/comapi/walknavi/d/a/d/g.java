package com.baidu.platform.comapi.walknavi.d.a.d;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final Context f9985a;

    public g(Context context) {
        this.f9985a = context;
    }

    private SharedPreferences c() {
        return this.f9985a.getSharedPreferences("ar_so_info", 0);
    }

    public String a() {
        return c().getString("so_version", "");
    }

    public void b(String str) {
        c().edit().putString("ar_sdk_version", str).commit();
    }

    public void a(String str) {
        c().edit().putString("so_version", str).commit();
    }

    public String b() {
        return c().getString("ar_sdk_version", "");
    }
}
