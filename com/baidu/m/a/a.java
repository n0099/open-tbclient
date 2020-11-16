package com.baidu.m.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
/* JADX WARN: Classes with same name are omitted:
  classes10.dex
 */
/* loaded from: classes16.dex */
public class a extends com.baidu.m.b.a {

    /* JADX WARN: Classes with same name are omitted:
      classes10.dex
     */
    /* renamed from: com.baidu.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0248a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        if (com.baidu.m.a.aah()) {
            b.requestPermissions(activity, strArr, i);
        } else if (activity instanceof InterfaceC0248a) {
            a(activity, strArr, i, (InterfaceC0248a) activity);
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i, final InterfaceC0248a interfaceC0248a) {
        if (com.baidu.m.a.aah()) {
            b.requestPermissions(activity, strArr, i);
        } else if (!activity.isFinishing() && interfaceC0248a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.m.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    interfaceC0248a.onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        if (com.baidu.m.a.aah()) {
            return b.shouldShowRequestPermissionRationale(activity, str);
        }
        return false;
    }
}
