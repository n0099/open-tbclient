package com.baidu.platform.comapi.walknavi.d.a.d;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public class g {
    private final Context a;

    public g(Context context) {
        this.a = context;
    }

    public String a() {
        return c().getString("so_version", "");
    }

    public void a(String str) {
        c().edit().putString("so_version", str).commit();
    }

    public void b(String str) {
        c().edit().putString("ar_sdk_version", str).commit();
    }

    public String b() {
        return c().getString("ar_sdk_version", "");
    }

    private SharedPreferences c() {
        return this.a.getSharedPreferences("ar_so_info", 0);
    }
}
