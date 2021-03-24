package com.baidu.apollon.permission;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
@TargetApi(23)
/* loaded from: classes2.dex */
public class b {
    public static String a(String str) {
        return AppOpsManager.permissionToOp(str);
    }

    public static int a(Context context, String str, int i, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteOp(str, i, str2);
    }

    public static int a(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }
}
