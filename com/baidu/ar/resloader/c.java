package com.baidu.ar.resloader;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class c {
    private final Context a;

    public c(Context context) {
        this.a = context;
    }

    private SharedPreferences c() {
        return this.a.getSharedPreferences("ar_so_info", 0);
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
