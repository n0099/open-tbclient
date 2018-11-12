package com.baidu.sofire;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public class g {
    private SharedPreferences a;
    private SharedPreferences.Editor b;
    private Context c;

    public void a(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (this.a != null) {
            this.a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    public g(Context context) {
        try {
            this.c = context;
            this.a = context.getSharedPreferences("leroadcfg", 0);
            this.b = this.a.edit();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public String a() {
        return this.a.getString("xytk", "");
    }

    public String b() {
        return this.a.getString("xytk_m", "");
    }

    public void a(String str) {
        this.b.putString("xytk_m", str);
        this.b.commit();
    }
}
