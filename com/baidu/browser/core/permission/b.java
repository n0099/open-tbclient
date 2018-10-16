package com.baidu.browser.core.permission;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes2.dex */
public class b {
    public static final String TAG = b.class.getSimpleName();

    public static boolean aX(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return com.baidu.f.a.a.checkPermissionGranted(context, "android.permission.CAMERA");
        } catch (Throwable th) {
            BdLog.e(TAG, th);
            return !com.baidu.f.a.uf();
        }
    }

    public static boolean aY(Context context) {
        if (context == null) {
            return false;
        }
        try {
            boolean z = com.baidu.f.a.a.checkPermissionGranted(context, "android.permission.CALL_PHONE") || com.baidu.f.a.a.checkPermissionGranted(context, "android.permission.MODIFY_PHONE_STATE") || com.baidu.f.a.a.checkPermissionGranted(context, "android.permission.READ_PHONE_STATE") || com.baidu.f.a.a.checkPermissionGranted(context, "android.permission.PROCESS_OUTGOING_CALLS");
            if (Build.VERSION.SDK_INT >= 16) {
                if (!z) {
                    if (!com.baidu.f.a.a.checkPermissionGranted(context, "android.permission.READ_CALL_LOG")) {
                        return false;
                    }
                }
                return true;
            }
            return z;
        } catch (Throwable th) {
            BdLog.e(TAG, th);
            return !com.baidu.f.a.uf();
        }
    }

    public static boolean i(Context context, int i) {
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(TAG, 0);
        if (sharedPreferences == null) {
            return true;
        }
        String str = "permission_request_code=" + String.valueOf(i);
        boolean z = sharedPreferences.getBoolean(str, true);
        W(context, str);
        return z;
    }

    private static void W(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = context.getSharedPreferences(TAG, 0)) != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, false);
            edit.apply();
        }
    }
}
