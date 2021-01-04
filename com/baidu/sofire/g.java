package com.baidu.sofire;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes15.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f5529a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f5530b;
    private Context c;

    public g(Context context) {
        try {
            this.c = context;
            this.f5529a = context.getSharedPreferences("leroadcfg", 0);
            this.f5530b = this.f5529a.edit();
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
    }

    public final String a() {
        return this.f5529a.getString("xytk", "");
    }

    public final int b() {
        return this.f5529a.getInt("td_a_c", 0);
    }
}
