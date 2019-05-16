package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.sapi2.base.network.Apn;
/* loaded from: classes3.dex */
public final class g {
    private static Intent ZF;

    public static void e(Context context) {
        if (ZF != null || context == null) {
            return;
        }
        try {
            ZF = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            com.baidu.crabsdk.c.a.v("Battery Broadcast Regist Success");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("Register Battery Error!", e);
        }
    }

    public static String f(Context context) {
        Object[] objArr;
        if (Build.VERSION.SDK_INT < 5) {
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

    public static String v() {
        if (ZF == null) {
            return Apn.APN_UNKNOWN;
        }
        try {
            return ((int) ((ZF.getIntExtra("level", 0) * 100.0f) / ZF.getIntExtra("scale", 100))) + "%";
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("Get Battery Error!", e);
            return Apn.APN_UNKNOWN;
        }
    }
}
