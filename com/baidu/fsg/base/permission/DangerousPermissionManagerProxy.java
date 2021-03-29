package com.baidu.fsg.base.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
/* loaded from: classes.dex */
public class DangerousPermissionManagerProxy {

    /* loaded from: classes.dex */
    public static class SingleInstance {
        public static DangerousPermissionManagerProxy mInstance = new DangerousPermissionManagerProxy();
    }

    public static DangerousPermissionManagerProxy getInstance() {
        return SingleInstance.mInstance;
    }

    public boolean isPermissionGroupGranted(Context context, String[] strArr) {
        if (context == null || strArr == null || strArr.length == 0) {
            return false;
        }
        for (String str : strArr) {
            if (Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission(str) != 0) {
                return false;
            }
        }
        return true;
    }

    public void requestPermissionsDialog(Activity activity, String[] strArr, RequestPermissionDialogCallBack requestPermissionDialogCallBack) {
        requestPermissionDialogCallBack.isAllAgree(true);
    }

    public DangerousPermissionManagerProxy() {
    }
}
