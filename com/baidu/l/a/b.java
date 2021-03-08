package com.baidu.l.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
@SuppressLint({"NewApi"})
@TargetApi(23)
/* loaded from: classes5.dex */
public class b {

    /* loaded from: classes5.dex */
    public interface a {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        if (activity instanceof a) {
            ((a) activity).validateRequestPermissionsRequestCode(i);
        }
        activity.requestPermissions(strArr, i);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
