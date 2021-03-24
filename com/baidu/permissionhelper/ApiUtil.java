package com.baidu.permissionhelper;

import android.os.Build;
/* loaded from: classes2.dex */
public class ApiUtil {
    public static boolean shouldCheckPermission() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
