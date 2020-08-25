package com.baidu.m.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
/* JADX WARN: Classes with same name are omitted:
  classes10.dex
 */
@SuppressLint({"NewApi"})
@TargetApi(23)
/* loaded from: classes18.dex */
public class b {

    /* JADX WARN: Classes with same name are omitted:
      classes10.dex
     */
    /* loaded from: classes18.dex */
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
