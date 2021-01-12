package com.baidu.platform.comapi.walknavi.d.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4234a;

    public f(Context context) {
        this.f4234a = context;
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
        return this.f4234a.getSharedPreferences("ar_resource_info", 0);
    }
}
