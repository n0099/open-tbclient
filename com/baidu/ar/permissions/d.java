package com.baidu.ar.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import com.baidu.tbadk.BaseActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private static int a = 153;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        a++;
        if (a > 240) {
            a = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        }
        return a;
    }

    public static List<String> a(Activity activity, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 23) {
            for (String str : strArr) {
                if (activity.checkSelfPermission(str) != 0) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PermissionAction permissionAction) {
        if (permissionAction != null) {
            permissionAction.onGranted();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(c cVar, String[] strArr) {
        if (cVar != null) {
            boolean[] zArr = new boolean[strArr.length];
            Arrays.fill(zArr, true);
            cVar.a(strArr, zArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Activity activity, String str) {
        if (a((Context) activity, str)) {
            return true;
        }
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
    }

    private static boolean a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("permission_check", 0);
        boolean z = sharedPreferences.getBoolean(str, true);
        if (z) {
            sharedPreferences.edit().putBoolean(str, false).commit();
        }
        return z;
    }

    public static boolean a(boolean[] zArr) {
        for (boolean z : zArr) {
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(PermissionAction permissionAction) {
        if (permissionAction != null) {
            permissionAction.onDenied();
        }
    }

    public static boolean b(Activity activity, String str) {
        return Build.VERSION.SDK_INT < 23 || activity.checkSelfPermission(str) == 0;
    }
}
