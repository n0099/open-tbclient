package com.baidu.d.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class a extends com.baidu.d.b.a {

    /* renamed from: com.baidu.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0061a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        if (com.baidu.d.a.rz()) {
            b.requestPermissions(activity, strArr, i);
        } else if (activity instanceof InterfaceC0061a) {
            a(activity, strArr, i, (InterfaceC0061a) activity);
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i, final InterfaceC0061a interfaceC0061a) {
        if (com.baidu.d.a.rz()) {
            b.requestPermissions(activity, strArr, i);
        } else if (!activity.isFinishing() && interfaceC0061a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.d.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    interfaceC0061a.onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        if (com.baidu.d.a.rz()) {
            return b.shouldShowRequestPermissionRationale(activity, str);
        }
        return false;
    }
}
