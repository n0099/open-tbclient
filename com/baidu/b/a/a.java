package com.baidu.b.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class a extends com.baidu.b.b.a {

    /* renamed from: com.baidu.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0022a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public static void a(Activity activity, String[] strArr, int i) {
        if (com.baidu.b.a.nm()) {
            b.a(activity, strArr, i);
        } else if (activity instanceof InterfaceC0022a) {
            a(activity, strArr, i, (InterfaceC0022a) activity);
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i, final InterfaceC0022a interfaceC0022a) {
        if (com.baidu.b.a.nm()) {
            b.a(activity, strArr, i);
        } else if (!activity.isFinishing() && interfaceC0022a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.b.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    interfaceC0022a.onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }
}
