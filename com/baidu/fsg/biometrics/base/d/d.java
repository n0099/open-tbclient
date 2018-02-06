package com.baidu.fsg.biometrics.base.d;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
/* loaded from: classes2.dex */
public class d {
    public static void a(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= 67108864;
            window.setAttributes(attributes);
        }
        k kVar = new k(activity);
        kVar.a(true);
        kVar.a(i);
    }

    public static void b(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= 134217728;
            window.setAttributes(attributes);
        }
        k kVar = new k(activity);
        kVar.b(true);
        kVar.b(i);
    }

    public static boolean a(WindowManager windowManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            int i2 = displayMetrics.widthPixels;
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics2);
            return i2 - displayMetrics2.widthPixels > 0 || i - displayMetrics2.heightPixels > 0;
        }
        return false;
    }

    public static int a(Activity activity) {
        if (!a(activity.getWindowManager())) {
            return 0;
        }
        return new k(activity).a().a();
    }
}
