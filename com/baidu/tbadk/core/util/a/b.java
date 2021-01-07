package com.baidu.tbadk.core.util.a;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class b {
    private static volatile b fec;
    private a fed;
    private Application mApplication;

    public static b bwz() {
        if (fec == null) {
            synchronized (b.class) {
                if (fec == null) {
                    fec = new b();
                }
            }
        }
        return fec;
    }

    private b() {
    }

    public void c(Application application) {
        this.mApplication = application;
        Display defaultDisplay = ((WindowManager) this.mApplication.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        float f = displayMetrics.density;
        if (f > 2.5d && f < 3.0f) {
            fd(null);
            this.fed = new a(displayMetrics);
            this.mApplication.registerActivityLifecycleCallbacks(this.fed);
        }
    }

    public void a(Context context, float f, int i) {
        DisplayMetrics fe = fe(context);
        DisplayMetrics fe2 = fe(this.mApplication);
        a(fe, f, i);
        a(fe2, f, i);
        DisplayMetrics ff = ff(context);
        DisplayMetrics ff2 = ff(this.mApplication);
        a(ff, f, i);
        a(ff2, f, i);
    }

    public void fd(Context context) {
        DisplayMetrics fe = fe(context);
        DisplayMetrics fe2 = fe(this.mApplication);
        a(fe, 3.0f, 480);
        a(fe2, 3.0f, 480);
        DisplayMetrics ff = ff(context);
        DisplayMetrics ff2 = ff(this.mApplication);
        a(ff, 3.0f, 480);
        a(ff2, 3.0f, 480);
    }

    private static DisplayMetrics fe(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    private static DisplayMetrics ff(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        if ("MiuiResources".equals(resources.getClass().getSimpleName()) || "XResources".equals(resources.getClass().getSimpleName())) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mTmpMetrics");
                declaredField.setAccessible(true);
                return (DisplayMetrics) declaredField.get(resources);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private void a(DisplayMetrics displayMetrics, float f, int i) {
        c.a(displayMetrics, f, i);
    }
}
