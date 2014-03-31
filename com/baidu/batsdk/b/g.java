package com.baidu.batsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class g {
    private static Context a;
    private static SharedPreferences b;
    private static String c;
    private static long d;

    public static void a(Context context) {
        a = context;
        b = context.getSharedPreferences("batsdk_user_info", 0);
        a();
    }

    public static long a() {
        if (0 == d) {
            String str = "installTime_v" + e.c();
            long j = b.getLong(str, 0L);
            if (0 == j) {
                d = System.currentTimeMillis();
                b.edit().putLong(str, d).commit();
            } else {
                d = j;
            }
        }
        return d;
    }

    public static String b() {
        if (c == null) {
            try {
                if (!b.contains("userId") || "" == b.getString("userId", "")) {
                    b.edit().putString("userId", UUID.randomUUID().toString()).commit();
                }
                c = b.getString("userId", "");
            } catch (RuntimeException e) {
                com.baidu.batsdk.f.a.a("Couldn't retrieve UUId for " + a.getPackageName(), e);
                return "";
            }
        }
        return c;
    }

    public static String c() {
        StringBuilder sb = new StringBuilder();
        Map<String, ?> all = b.getAll();
        for (String str : all.keySet()) {
            sb.append(str).append(": ").append(all.get(str)).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        return sb.toString();
    }

    public static String d() {
        return b.getString("userName", "");
    }

    public static long e() {
        return b.getLong("lastUploadTime", 0L);
    }

    public static void a(String str) {
        b.edit().putString("userName", str).commit();
    }

    public static void f() {
        b.edit().putInt("crashNum", b.getInt("crashNum", 0) + 1).commit();
    }

    public static void a(long j) {
        b.edit().putLong("lastUploadTime", j).commit();
    }
}
