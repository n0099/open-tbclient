package com.baidu.n.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class a extends com.baidu.n.b.a {

    /* renamed from: com.baidu.n.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0277a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        if (com.baidu.n.a.afl()) {
            b.requestPermissions(activity, strArr, i);
        } else if (activity instanceof InterfaceC0277a) {
            a(activity, strArr, i, (InterfaceC0277a) activity);
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i, final InterfaceC0277a interfaceC0277a) {
        if (com.baidu.n.a.afl()) {
            b.requestPermissions(activity, strArr, i);
        } else if (!activity.isFinishing() && interfaceC0277a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.n.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    interfaceC0277a.onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        if (com.baidu.n.a.afl()) {
            return b.shouldShowRequestPermissionRationale(activity, str);
        }
        return false;
    }
}
