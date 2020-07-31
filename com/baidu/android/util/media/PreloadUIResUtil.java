package com.baidu.android.util.media;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.util.LongSparseArray;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes5.dex */
public class PreloadUIResUtil {
    private static final boolean DEBUG = false;
    public static final String TAG = "PreloadUIResUtil";
    private static final LongSparseArray<Drawable.ConstantState> mPreloadedDrawableCS = new LongSparseArray<>(30);
    private static final Object mAccessLock = new Object();

    public static void preloadDrawable(@DrawableRes int i, String str) {
        preloadDrawable(i);
    }

    public static void preloadDrawable(@DrawableRes int i) {
        preloadDrawable(i, false);
    }

    public static void preloadDrawable(@DrawableRes int i, boolean z) {
        Drawable drawable;
        try {
            if (z) {
                Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(i);
                if (drawable2 != null) {
                    synchronized (mAccessLock) {
                        Drawable.ConstantState constantState = drawable2.getConstantState();
                        if (constantState != null) {
                            mPreloadedDrawableCS.put(i, constantState);
                        }
                    }
                }
            } else if (mPreloadedDrawableCS.get(i) == null && (drawable = AppRuntime.getAppContext().getResources().getDrawable(i)) != null) {
                synchronized (mAccessLock) {
                    Drawable.ConstantState constantState2 = drawable.getConstantState();
                    if (constantState2 != null) {
                        mPreloadedDrawableCS.put(i, constantState2);
                    }
                }
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Drawable getPreloadedDrawable(@DrawableRes int i) {
        Drawable.ConstantState constantState = mPreloadedDrawableCS.get(i);
        if (constantState != null) {
            return constantState.newDrawable(AppRuntime.getAppContext().getResources());
        }
        return null;
    }

    public static void cleanPreloadedDrawable() {
        synchronized (mAccessLock) {
            mPreloadedDrawableCS.clear();
        }
    }
}
