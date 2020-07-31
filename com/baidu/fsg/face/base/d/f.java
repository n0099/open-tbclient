package com.baidu.fsg.face.base.d;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
/* loaded from: classes7.dex */
public class f {
    public static void a(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= 67108864;
            window.setAttributes(attributes);
        }
        j jVar = new j(activity);
        jVar.a(true);
        jVar.a(i);
    }

    public static void b(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= 134217728;
            window.setAttributes(attributes);
        }
        j jVar = new j(activity);
        jVar.b(true);
        jVar.b(i);
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
        return new j(activity).a().a();
    }
}
