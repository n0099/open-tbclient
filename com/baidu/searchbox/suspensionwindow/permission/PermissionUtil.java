package com.baidu.searchbox.suspensionwindow.permission;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.WindowManager;
/* loaded from: classes6.dex */
public class PermissionUtil {
    public static boolean hasPermission(Context context) {
        return Build.VERSION.SDK_INT >= 23 ? Settings.canDrawOverlays(context) : hasPermissionBelowMarshmallow(context);
    }

    public static boolean hasPermissionOnActivityResult(Context context) {
        if (Build.VERSION.SDK_INT == 26) {
            return hasPermissionForO(context);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(context);
        }
        return hasPermissionBelowMarshmallow(context);
    }

    public static boolean hasPermissionBelowMarshmallow(Context context) {
        try {
            return ((Integer) AppOpsManager.class.getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), 24, Integer.valueOf(Binder.getCallingUid()), context.getApplicationContext().getPackageName())).intValue() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    @RequiresApi(api = 23)
    private static boolean hasPermissionForO(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return false;
            }
            View view = new View(context);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, Build.VERSION.SDK_INT >= 26 ? 2038 : 2003, 24, -2);
            view.setLayoutParams(layoutParams);
            windowManager.addView(view, layoutParams);
            windowManager.removeView(view);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
