package com.baidu.fsg.base.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
/* loaded from: classes10.dex */
public class DangerousPermissionManagerProxy {
    private DangerousPermissionManagerProxy() {
    }

    public static DangerousPermissionManagerProxy getInstance() {
        return SingleInstance.mInstance;
    }

    /* loaded from: classes10.dex */
    private static class SingleInstance {
        private static DangerousPermissionManagerProxy mInstance = new DangerousPermissionManagerProxy();

        private SingleInstance() {
        }
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
}
