package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatDelegate;
import android.util.SparseArray;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class an {
    private b aXp;
    private Resources mResources;

    /* loaded from: classes.dex */
    private static class a {
        static an aXq = new an();
    }

    private an() {
        this.aXp = new b();
        try {
            this.mResources = (Resources) Class.forName("android.support.v7.widget.VectorEnabledTintResources").getDeclaredConstructor(Context.class, Resources.class).newInstance(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources());
        } catch (Exception e) {
            com.baidu.tbadk.core.d.a.a("img", -1L, 0, "svg_load", 0, "svg_load_error", "reason", "resource_init_error");
            this.mResources = TbadkCoreApplication.getInst().getResources();
        }
    }

    public static synchronized an Dd() {
        an anVar;
        synchronized (an.class) {
            anVar = a.aXq;
        }
        return anVar;
    }

    public void c(ImageView imageView, int i, int i2) {
        Drawable au;
        ColorStateList fN;
        if (imageView != null && i != 0 && i2 != 0 && (au = au(i, 1)) != null && (fN = aj.fN(i2)) != null) {
            DrawableCompat.setTintList(au, fN);
            imageView.setImageDrawable(au);
        }
    }

    public Drawable au(int i, int i2) {
        if (i == 0) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        try {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
            int a2 = skinType == 1 ? aj.a(this.mResources, i) : i;
            if (a2 == 0) {
                a2 = i;
            }
            switch (i2) {
                case 1:
                    android.support.a.a.f fW = this.aXp.fW(a2);
                    if (fW == null) {
                        return aj.c(skinType, this.mResources, aj.g(this.mResources, i));
                    }
                    com.baidu.tbadk.core.d.a.a("img", -1L, 0, "svg_load_success", 0, "", new Object[0]);
                    return fW;
                case 2:
                    android.support.a.a.b fX = this.aXp.fX(a2);
                    if (fX == null) {
                        return aj.c(skinType, this.mResources, aj.g(this.mResources, i));
                    }
                    com.baidu.tbadk.core.d.a.a("img", -1L, 0, "svg_load_success", 0, "", new Object[0]);
                    return fX;
                case 3:
                    StateListDrawable a3 = this.aXp.a(a2, this.mResources);
                    if (a3 == null) {
                        return aj.c(skinType, this.mResources, aj.g(this.mResources, i));
                    }
                    com.baidu.tbadk.core.d.a.a("img", -1L, 0, "svg_load_success", 0, "", new Object[0]);
                    return a3;
                default:
                    return null;
            }
        } catch (Exception e) {
            com.baidu.tbadk.core.d.a.a("img", -1L, 0, "svg_load_error_not_found", 0, "svg_load_error", "reason", "class_not_found");
            return aj.c(skinType, this.mResources, aj.g(this.mResources, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private SparseArray<WeakReference<Drawable.ConstantState>> aXr = new SparseArray<>(30);

        b() {
        }

        public android.support.a.a.f fW(int i) {
            Drawable drawable;
            WeakReference<Drawable.ConstantState> weakReference = this.aXr.get(i);
            if (weakReference == null || weakReference.get() == null) {
                try {
                    android.support.a.a.f a = android.support.a.a.f.a(TbadkCoreApplication.getInst().getResources(), i, (Resources.Theme) null);
                    if (a != null) {
                        weakReference = new WeakReference<>(a.getConstantState());
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    weakReference = null;
                }
                if (weakReference == null || weakReference.get() == null) {
                    return null;
                }
                this.aXr.put(i, weakReference);
            }
            if (weakReference.get() != null) {
                drawable = weakReference.get().newDrawable();
            } else {
                com.baidu.tbadk.core.d.a.a("img", -1L, 0, "svg_load_failed_by_gc", 0, "", new Object[0]);
                this.aXr.delete(i);
                drawable = null;
            }
            if (drawable instanceof android.support.a.a.f) {
                return (android.support.a.a.f) drawable;
            }
            return null;
        }

        public StateListDrawable a(int i, Resources resources) {
            Drawable drawable;
            WeakReference<Drawable.ConstantState> weakReference = this.aXr.get(i);
            if (weakReference == null || weakReference.get() == null) {
                try {
                    StateListDrawable stateListDrawable = (StateListDrawable) ResourcesCompat.getDrawable(resources, i, null);
                    if (stateListDrawable != null && stateListDrawable.getConstantState() != null) {
                        weakReference = new WeakReference<>(stateListDrawable.getConstantState());
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    weakReference = null;
                }
                if (weakReference == null || weakReference.get() == null) {
                    return null;
                }
                this.aXr.put(i, weakReference);
            }
            if (weakReference.get() != null) {
                drawable = weakReference.get().newDrawable();
            } else {
                com.baidu.tbadk.core.d.a.a("img", -1L, 0, "svg_load_failed_by_gc", 0, "", new Object[0]);
                this.aXr.delete(i);
                drawable = null;
            }
            if (drawable instanceof StateListDrawable) {
                return (StateListDrawable) drawable;
            }
            return null;
        }

        public android.support.a.a.b fX(int i) {
            Drawable drawable;
            WeakReference<Drawable.ConstantState> weakReference = this.aXr.get(i);
            if (weakReference == null || weakReference.get() == null) {
                try {
                    android.support.a.a.b d = android.support.a.a.b.d(TbadkCoreApplication.getInst(), i);
                    if (d != null && d.getConstantState() != null) {
                        weakReference = new WeakReference<>(d.getConstantState());
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                    weakReference = null;
                }
                if (weakReference == null || weakReference.get() == null) {
                    return null;
                }
                this.aXr.put(i, weakReference);
            }
            if (weakReference.get() != null) {
                drawable = weakReference.get().newDrawable();
            } else {
                com.baidu.tbadk.core.d.a.a("img", -1L, 0, "svg_load_failed_by_gc", 0, "", new Object[0]);
                this.aXr.delete(i);
                drawable = null;
            }
            if (drawable instanceof android.support.a.a.b) {
                return (android.support.a.a.b) drawable;
            }
            return null;
        }
    }
}
