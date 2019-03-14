package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import com.baidu.sapi2.base.network.Apn;
/* loaded from: classes3.dex */
public final class g {
    private static Intent abO;

    public static void d(Context context) {
        if (abO != null || context == null) {
            return;
        }
        try {
            abO = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            com.baidu.crabsdk.c.a.cx("Battery Broadcast Regist Success");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("Register Battery Error!", e);
        }
    }

    public static String f(Context context) {
        Object[] objArr;
        if (com.baidu.crabsdk.c.c.rW() < 5) {
            return Apn.APN_UNKNOWN;
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
        if (abO == null) {
            return Apn.APN_UNKNOWN;
        }
        try {
            return ((int) ((abO.getIntExtra("level", 0) * 100.0f) / abO.getIntExtra("scale", 100))) + "%";
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("Get Battery Error!", e);
            return Apn.APN_UNKNOWN;
        }
    }
}
