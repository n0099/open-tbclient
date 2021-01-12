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
    private static volatile b eZt;
    private a eZu;
    private Application mApplication;

    public static b bsF() {
        if (eZt == null) {
            synchronized (b.class) {
                if (eZt == null) {
                    eZt = new b();
                }
            }
        }
        return eZt;
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
            fb(null);
            this.eZu = new a(displayMetrics);
            this.mApplication.registerActivityLifecycleCallbacks(this.eZu);
        }
    }

    public void a(Context context, float f, int i) {
        DisplayMetrics fc = fc(context);
        DisplayMetrics fc2 = fc(this.mApplication);
        a(fc, f, i);
        a(fc2, f, i);
        DisplayMetrics fd = fd(context);
        DisplayMetrics fd2 = fd(this.mApplication);
        a(fd, f, i);
        a(fd2, f, i);
    }

    public void fb(Context context) {
        DisplayMetrics fc = fc(context);
        DisplayMetrics fc2 = fc(this.mApplication);
        a(fc, 3.0f, 480);
        a(fc2, 3.0f, 480);
        DisplayMetrics fd = fd(context);
        DisplayMetrics fd2 = fd(this.mApplication);
        a(fd, 3.0f, 480);
        a(fd2, 3.0f, 480);
    }

    private static DisplayMetrics fc(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    private static DisplayMetrics fd(Context context) {
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
