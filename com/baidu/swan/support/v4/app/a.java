package com.baidu.swan.support.v4.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.support.v4.a.a {

    /* renamed from: com.baidu.swan.support.v4.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0416a {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    public static void finishAfterTransition(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.finishAfterTransition(activity);
        } else {
            activity.finish();
        }
    }

    public static void requestPermissions(@NonNull final Activity activity, @NonNull final String[] strArr, final int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            c.requestPermissions(activity, strArr, i);
        } else if (activity instanceof InterfaceC0416a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.swan.support.v4.app.a.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    ((InterfaceC0416a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }
}
