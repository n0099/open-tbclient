package com.baidu.sofire;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f3530a;
    public SharedPreferences.Editor b;
    private Context c;

    public g(Context context) {
        try {
            this.c = context;
            this.f3530a = context.getSharedPreferences("leroadcfg", 0);
            this.b = this.f3530a.edit();
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
    }

    public final String a() {
        return this.f3530a.getString("xytk", "");
    }

    public final int b() {
        return this.f3530a.getInt("td_a_c", 0);
    }
}
