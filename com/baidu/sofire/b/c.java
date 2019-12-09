package com.baidu.sofire.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public final class c {
    public SharedPreferences.Editor a;
    private SharedPreferences b;
    private long c = 86400000;

    public c(Context context) {
        try {
            this.b = context.getSharedPreferences("leroadcfg", 4);
            this.a = this.b.edit();
        } catch (Throwable th) {
        }
    }

    public static String a(String str) {
        try {
            return new String(Base64.encode(a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes(HTTP.UTF_8)), 10), HTTP.UTF_8);
        } catch (Throwable th) {
            return "";
        }
    }

    private static String b(String str) {
        try {
            return new String(a.b("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(str, 10)), HTTP.UTF_8);
        } catch (Throwable th) {
            return "";
        }
    }

    public final String a() {
        try {
            if (System.currentTimeMillis() - Long.valueOf(this.b.getLong("dd_v_d_t", System.currentTimeMillis())).longValue() > this.c) {
                return "";
            }
            String string = this.b.getString("dd_v_d", "");
            return !TextUtils.isEmpty(string) ? b(string) : "";
        } catch (Throwable th) {
            return "";
        }
    }
}
