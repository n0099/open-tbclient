package com.baidu.i.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
/* JADX WARN: Classes with same name are omitted:
  classes11.dex
 */
/* loaded from: classes3.dex */
public class a extends com.baidu.i.b.a {

    /* JADX WARN: Classes with same name are omitted:
      classes11.dex
     */
    /* renamed from: com.baidu.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0153a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        if (com.baidu.i.a.NX()) {
            b.requestPermissions(activity, strArr, i);
        } else if (activity instanceof InterfaceC0153a) {
            a(activity, strArr, i, (InterfaceC0153a) activity);
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i, final InterfaceC0153a interfaceC0153a) {
        if (com.baidu.i.a.NX()) {
            b.requestPermissions(activity, strArr, i);
        } else if (!activity.isFinishing() && interfaceC0153a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.i.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    interfaceC0153a.onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        if (com.baidu.i.a.NX()) {
            return b.shouldShowRequestPermissionRationale(activity, str);
        }
        return false;
    }
}
