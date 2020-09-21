package com.baidu.platform.comapi.walknavi.d.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class f {
    private final Context a;

    public f(Context context) {
        this.a = context;
    }

    public void a(String str, String str2) {
        try {
            a().edit().putString(str, str2).apply();
        } catch (Exception e) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("saveLocalResourcePath exception");
        }
    }

    public String a(String str) {
        return a().getString(str, "");
    }

    private SharedPreferences a() {
        return this.a.getSharedPreferences("ar_resource_info", 0);
    }
}
