package com.baidu.sofire;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public final class g {
    public SharedPreferences a;
    public SharedPreferences.Editor b;
    private Context c;

    public g(Context context) {
        try {
            this.c = context;
            this.a = context.getSharedPreferences("leroadcfg", 0);
            this.b = this.a.edit();
        } catch (Throwable th) {
            com.baidu.sofire.i.d.a();
        }
    }

    public final String a() {
        return this.a.getString("xytk", "");
    }

    public final int b() {
        return this.a.getInt("td_a_c", 0);
    }
}
