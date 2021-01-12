package com.baidu.sofire.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences.Editor f5197a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f5198b;
    private long c = 86400000;

    public c(Context context) {
        try {
            this.f5198b = context.getSharedPreferences("leroadcfg", 4);
            this.f5197a = this.f5198b.edit();
        } catch (Throwable th) {
        }
    }

    public static String a(String str) {
        try {
            return new String(Base64.encode(a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8")), 10), "UTF-8");
        } catch (Throwable th) {
            return "";
        }
    }

    private static String b(String str) {
        try {
            return new String(a.b("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(str, 10)), "UTF-8");
        } catch (Throwable th) {
            return "";
        }
    }

    public final String a() {
        try {
            if (System.currentTimeMillis() - Long.valueOf(this.f5198b.getLong("dd_v_d_t", System.currentTimeMillis())).longValue() > this.c) {
                return "";
            }
            String string = this.f5198b.getString("dd_v_d", "");
            return !TextUtils.isEmpty(string) ? b(string) : "";
        } catch (Throwable th) {
            return "";
        }
    }
}
