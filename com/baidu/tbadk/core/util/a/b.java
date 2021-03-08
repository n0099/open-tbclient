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
    private static volatile b fdi;
    private a fdj;
    private Application mApplication;

    public static b btc() {
        if (fdi == null) {
            synchronized (b.class) {
                if (fdi == null) {
                    fdi = new b();
                }
            }
        }
        return fdi;
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
            eZ(null);
            this.fdj = new a(displayMetrics);
            this.mApplication.registerActivityLifecycleCallbacks(this.fdj);
        }
    }

    public void a(Context context, float f, int i) {
        DisplayMetrics fa = fa(context);
        DisplayMetrics fa2 = fa(this.mApplication);
        a(fa, f, i);
        a(fa2, f, i);
        DisplayMetrics fb = fb(context);
        DisplayMetrics fb2 = fb(this.mApplication);
        a(fb, f, i);
        a(fb2, f, i);
    }

    public void eZ(Context context) {
        DisplayMetrics fa = fa(context);
        DisplayMetrics fa2 = fa(this.mApplication);
        a(fa, 3.0f, 480);
        a(fa2, 3.0f, 480);
        DisplayMetrics fb = fb(context);
        DisplayMetrics fb2 = fb(this.mApplication);
        a(fb, 3.0f, 480);
        a(fb2, 3.0f, 480);
    }

    private static DisplayMetrics fa(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    private static DisplayMetrics fb(Context context) {
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
