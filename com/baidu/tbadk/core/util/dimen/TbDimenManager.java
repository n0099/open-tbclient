package com.baidu.tbadk.core.util.dimen;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class TbDimenManager {
    public static volatile TbDimenManager sInstance = null;
    public static final int targetDensity = 3;
    public static final int targetDensityDpi = 480;
    public static final int targetWidthDp = 360;
    public TbDimenAdaptActivityLifecycle adaptActivityLifecycle;
    public Application mApplication;
    public float mDefaultDensity;
    public int mDefaultDensityDpi;

    public static TbDimenManager getInstance() {
        if (sInstance == null) {
            synchronized (TbDimenManager.class) {
                if (sInstance == null) {
                    sInstance = new TbDimenManager();
                }
            }
        }
        return sInstance;
    }

    public static DisplayMetrics getMetrics(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static DisplayMetrics getMetricsOnMiui(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        if ("MiuiResources".equals(resources.getClass().getSimpleName()) || "XResources".equals(resources.getClass().getSimpleName())) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mTmpMetrics");
                declaredField.setAccessible(true);
                return (DisplayMetrics) declaredField.get(resources);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private void setDensity(DisplayMetrics displayMetrics, float f2, int i2) {
        TbDimenUtil.setDensity(displayMetrics, f2, i2);
    }

    public void adaptDimen(Context context, float f2, int i2) {
        DisplayMetrics metrics = getMetrics(context);
        DisplayMetrics metrics2 = getMetrics(this.mApplication);
        setDensity(metrics, f2, i2);
        setDensity(metrics2, f2, i2);
        DisplayMetrics metricsOnMiui = getMetricsOnMiui(context);
        DisplayMetrics metricsOnMiui2 = getMetricsOnMiui(this.mApplication);
        setDensity(metricsOnMiui, f2, i2);
        setDensity(metricsOnMiui2, f2, i2);
    }

    public float getDefaultDensity() {
        return this.mDefaultDensity;
    }

    public int getDefaultDensityDpi() {
        return this.mDefaultDensityDpi;
    }

    public void init(Application application) {
        this.mApplication = application;
        Display defaultDisplay = ((WindowManager) application.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        float f2 = displayMetrics.density;
        this.mDefaultDensity = f2;
        this.mDefaultDensityDpi = displayMetrics.densityDpi;
        if (f2 <= 2.5d || f2 >= 3.0f) {
            return;
        }
        adaptDimen(null);
        TbDimenAdaptActivityLifecycle tbDimenAdaptActivityLifecycle = new TbDimenAdaptActivityLifecycle(displayMetrics);
        this.adaptActivityLifecycle = tbDimenAdaptActivityLifecycle;
        this.mApplication.registerActivityLifecycleCallbacks(tbDimenAdaptActivityLifecycle);
    }

    public void adaptDimen(Context context) {
        DisplayMetrics metrics = getMetrics(context);
        DisplayMetrics metrics2 = getMetrics(this.mApplication);
        setDensity(metrics, 3.0f, 480);
        setDensity(metrics2, 3.0f, 480);
        DisplayMetrics metricsOnMiui = getMetricsOnMiui(context);
        DisplayMetrics metricsOnMiui2 = getMetricsOnMiui(this.mApplication);
        setDensity(metricsOnMiui, 3.0f, 480);
        setDensity(metricsOnMiui2, 3.0f, 480);
    }
}
