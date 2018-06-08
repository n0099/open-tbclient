package com.baidu.ar.recg.feares;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class b {
    private final Context a;

    public b(Context context) {
        this.a = context;
    }

    private SharedPreferences b() {
        if (this.a == null) {
            return null;
        }
        return this.a.getSharedPreferences("fea_res_info", 0);
    }

    public String a() {
        SharedPreferences b = b();
        return b == null ? "" : b.getString("fea_res_md5", "");
    }

    public void a(String str) {
        SharedPreferences b = b();
        if (b == null || b.edit() == null) {
            return;
        }
        b.edit().putString("fea_res_md5", str).apply();
    }
}
