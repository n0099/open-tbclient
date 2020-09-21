package com.baidu.browser.core.permission;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.browser.core.util.BdLog;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes10.dex */
public class b {
    public static final String TAG = b.class.getSimpleName();

    public static boolean checkCamera(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return com.baidu.m.a.a.checkPermissionGranted(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        } catch (Throwable th) {
            BdLog.e(TAG, th);
            return !com.baidu.m.a.UA();
        }
    }

    public static boolean Q(Context context) {
        if (context == null) {
            return false;
        }
        try {
            boolean checkPermissionGranted = com.baidu.m.a.a.checkPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (Build.VERSION.SDK_INT >= 16) {
                if (!checkPermissionGranted) {
                    if (!com.baidu.m.a.a.checkPermissionGranted(context, "android.permission.READ_EXTERNAL_STORAGE")) {
                        return false;
                    }
                }
                return true;
            }
            return checkPermissionGranted;
        } catch (Throwable th) {
            BdLog.e(TAG, th);
            return !com.baidu.m.a.UA();
        }
    }

    public static boolean f(Context context, int i) {
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(TAG, 0);
        if (sharedPreferences == null) {
            return true;
        }
        String str = "permission_request_code=" + String.valueOf(i);
        boolean z = sharedPreferences.getBoolean(str, true);
        x(context, str);
        return z;
    }

    private static void x(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = context.getSharedPreferences(TAG, 0)) != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, false);
            edit.apply();
        }
    }
}
