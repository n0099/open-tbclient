package com.baidu.permissionhelper.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.permissionhelper.context.ContextCompat;
/* loaded from: classes2.dex */
public class ActivityCompat extends ContextCompat {

    /* loaded from: classes2.dex */
    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        if (ApiUtil.shouldCheckPermission()) {
            ActivityCompatApi23.requestPermissions(activity, strArr, i);
        } else if (activity instanceof OnRequestPermissionsResultCallback) {
            requestPermissions(activity, strArr, i, (OnRequestPermissionsResultCallback) activity);
        }
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        if (ApiUtil.shouldCheckPermission()) {
            return ActivityCompatApi23.shouldShowRequestPermissionRationale(activity, str);
        }
        return false;
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String... strArr) {
        if (!ApiUtil.shouldCheckPermission() || strArr == null || strArr.length == 0) {
            return false;
        }
        for (int length = strArr.length - 1; length >= 0; length--) {
            if (!shouldShowRequestPermissionRationale(activity, strArr[length])) {
                return false;
            }
        }
        return true;
    }

    public static void requestPermissions(final Activity activity, final String[] strArr, final int i, final OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        if (ApiUtil.shouldCheckPermission()) {
            ActivityCompatApi23.requestPermissions(activity, strArr, i);
        } else if (activity.isFinishing() || onRequestPermissionsResultCallback == null) {
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.permissionhelper.app.ActivityCompat.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    onRequestPermissionsResultCallback.onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }
}
