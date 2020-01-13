package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
/* loaded from: classes6.dex */
public final class g {
    private static Intent Qj;

    public static void e(Context context) {
        if (Qj != null || context == null) {
            return;
        }
        try {
            Qj = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            com.baidu.crabsdk.c.a.v("Battery Broadcast Regist Success");
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("Register Battery Error!", e);
        }
    }

    public static String f(Context context) {
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
        } catch (Throwable th) {
        }
        return sb.toString();
    }

    public static String v() {
        if (Qj == null) {
            return "N/A";
        }
        try {
            return ((int) ((Qj.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0) * 100.0f) / Qj.getIntExtra("scale", 100))) + "%";
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("Get Battery Error!", e);
            return "N/A";
        }
    }
}
