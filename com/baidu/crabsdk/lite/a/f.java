package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static Intent f4765a;

    public static String a(Context context) {
        Object[] objArr;
        if (com.baidu.crabsdk.lite.b.c.g() < 5) {
            return "N/A";
        }
        StringBuilder sb = new StringBuilder();
        try {
            for (Object obj : (Object[]) PackageManager.class.getMethod("getSystemAvailableFeatures", null).invoke(context.getPackageManager(), new Object[0])) {
                String str = (String) obj.getClass().getField("name").get(obj);
                if (str != null) {
                    sb.append(str);
                } else {
                    sb.append("glEsVersion = ");
                    sb.append((String) obj.getClass().getMethod("getGlEsVersion", null).invoke(obj, new Object[0]));
                }
                sb.append("\n");
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static void b(String str, Context context) {
        if (f4765a != null || context == null) {
            return;
        }
        try {
            f4765a = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            com.baidu.crabsdk.lite.b.a.c(str, "Battery Broadcast Regist Success");
        } catch (Exception e2) {
            com.baidu.crabsdk.lite.b.a.e(str, "Register Battery Error!", e2);
        }
    }

    public static String c(String str) {
        Intent intent = f4765a;
        if (intent == null) {
            return "N/A";
        }
        try {
            float intExtra = (intent.getIntExtra("level", 0) * 100.0f) / f4765a.getIntExtra("scale", 100);
            return ((int) intExtra) + "%";
        } catch (Exception e2) {
            com.baidu.crabsdk.lite.b.a.e(str, "Get Battery Error!", e2);
            return "N/A";
        }
    }
}
