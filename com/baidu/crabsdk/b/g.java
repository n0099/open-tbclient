package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
/* loaded from: classes2.dex */
public final class g {
    private static Intent SL;

    public static void d(Context context) {
        if (SL != null || context == null) {
            return;
        }
        try {
            SL = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            com.baidu.crabsdk.c.a.cg("Battery Broadcast Regist Success");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.b("Register Battery Error!", e);
        }
    }

    public static String f(Context context) {
        Object[] objArr;
        if (com.baidu.crabsdk.c.c.pg() < 5) {
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
        } catch (Throwable th) {
        }
        return sb.toString();
    }

    public static String w() {
        if (SL == null) {
            return "N/A";
        }
        try {
            return ((int) ((SL.getIntExtra("level", 0) * 100.0f) / SL.getIntExtra("scale", 100))) + "%";
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.b("Get Battery Error!", e);
            return "N/A";
        }
    }
}
