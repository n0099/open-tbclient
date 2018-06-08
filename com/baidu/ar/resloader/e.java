package com.baidu.ar.resloader;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class e {
    private SharedPreferences a;

    public e(Context context) {
        this.a = context.getSharedPreferences("ar_so_info", 0);
    }

    private SharedPreferences c() {
        return this.a;
    }

    public String a() {
        return c().getString("so_version", "");
    }

    public void a(String str) {
        c().edit().putString("so_version", str).commit();
    }

    public String b() {
        return c().getString("ar_sdk_version", "");
    }

    public void b(String str) {
        c().edit().putString("ar_sdk_version", str).commit();
    }
}
