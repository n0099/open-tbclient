package com.baidu.c.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class a extends com.baidu.c.b.a {

    /* renamed from: com.baidu.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0023a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public static void a(Activity activity, String[] strArr, int i) {
        if (com.baidu.c.a.nl()) {
            b.a(activity, strArr, i);
        } else if (activity instanceof InterfaceC0023a) {
            a(activity, strArr, i, (InterfaceC0023a) activity);
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i, final InterfaceC0023a interfaceC0023a) {
        if (com.baidu.c.a.nl()) {
            b.a(activity, strArr, i);
        } else if (!activity.isFinishing() && interfaceC0023a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.c.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    interfaceC0023a.onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }
}
