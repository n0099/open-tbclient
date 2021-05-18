package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static Intent f4685a;

    public static void a(Context context) {
        if (f4685a != null || context == null) {
            return;
        }
        try {
            f4685a = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            com.baidu.crabsdk.c.a.c("Battery Broadcast Regist Success");
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("Register Battery Error!", e2);
        }
    }

    public static String b(Context context) {
        Object[] objArr;
        if (Build.VERSION.SDK_INT < 5) {
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

    public static String c() {
        Intent intent = f4685a;
        if (intent == null) {
            return "N/A";
        }
        try {
            float intExtra = (intent.getIntExtra("level", 0) * 100.0f) / f4685a.getIntExtra("scale", 100);
            return ((int) intExtra) + "%";
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("Get Battery Error!", e2);
            return "N/A";
        }
    }
}
