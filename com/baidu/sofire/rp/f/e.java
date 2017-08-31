package com.baidu.sofire.rp.f;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
/* loaded from: classes.dex */
public final class e {
    public static String a(Context context) {
        byte[] bytes = (b.b(context) + ":" + b.c(context)).getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 246);
        }
        return i.a(bytes);
    }

    public static String b(Context context) {
        if (!j.b(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getSubscriberId();
            }
        } catch (Throwable th) {
            b.a();
        }
        return "";
    }

    public static String c(Context context) {
        String str;
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                str = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            } else {
                str = displayMetrics.heightPixels + "*" + displayMetrics.widthPixels;
            }
            return str;
        } catch (Exception e) {
            b.a();
            return "";
        }
    }
}
