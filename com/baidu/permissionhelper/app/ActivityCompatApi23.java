package com.baidu.permissionhelper.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
@SuppressLint({"NewApi"})
@TargetApi(23)
/* loaded from: classes2.dex */
public class ActivityCompatApi23 {

    /* loaded from: classes2.dex */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i2);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i2) {
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i2);
        }
        activity.requestPermissions(strArr, i2);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
