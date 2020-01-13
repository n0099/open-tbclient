package com.baidu.k.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class a extends com.baidu.k.b.a {

    /* renamed from: com.baidu.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0072a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        if (com.baidu.k.a.BZ()) {
            b.requestPermissions(activity, strArr, i);
        } else if (activity instanceof InterfaceC0072a) {
            a(activity, strArr, i, (InterfaceC0072a) activity);
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i, final InterfaceC0072a interfaceC0072a) {
        if (com.baidu.k.a.BZ()) {
            b.requestPermissions(activity, strArr, i);
        } else if (!activity.isFinishing() && interfaceC0072a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.k.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    interfaceC0072a.onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        if (com.baidu.k.a.BZ()) {
            return b.shouldShowRequestPermissionRationale(activity, str);
        }
        return false;
    }
}
