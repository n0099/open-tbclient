package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatDelegate;
import android.util.LruCache;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public class aq {
    private b arE;
    private Resources mResources;

    /* loaded from: classes.dex */
    private static class a {
        static aq arF = new aq();
    }

    private aq() {
        this.arE = new b();
        try {
            this.mResources = (Resources) Class.forName("android.support.v7.widget.VectorEnabledTintResources").getDeclaredConstructor(Context.class, Resources.class).newInstance(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources());
        } catch (Exception e) {
            com.baidu.tbadk.core.d.a.a(SocialConstants.PARAM_IMG_URL, -1L, 0, "svg_load", 0, "svg_load_error", "reason", "resource_init_error");
            this.mResources = TbadkCoreApplication.getInst().getResources();
        }
    }

    public static synchronized aq zE() {
        aq aqVar;
        synchronized (aq.class) {
            aqVar = a.arF;
        }
        return aqVar;
    }

    public void c(ImageView imageView, int i, int i2) {
        Drawable v;
        ColorStateList cQ;
        if (imageView != null && i != 0 && i2 != 0 && (v = v(i, 1)) != null && (cQ = am.cQ(i2)) != null) {
            DrawableCompat.setTintList(v, cQ);
            imageView.setImageDrawable(v);
        }
    }

    public Drawable v(int i, int i2) {
        if (i == 0) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        try {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
            int a2 = skinType == 1 ? am.a(this.mResources, i) : i;
            if (a2 == 0) {
                a2 = i;
            }
            switch (i2) {
                case 1:
                    VectorDrawableCompat cZ = this.arE.cZ(a2);
                    if (cZ == null) {
                        return am.c(skinType, this.mResources, am.g(this.mResources, i));
                    }
                    com.baidu.tbadk.core.d.a.a(SocialConstants.PARAM_IMG_URL, -1L, 0, "svg_load_success", 0, "", new Object[0]);
                    return cZ;
                case 2:
                    AnimatedVectorDrawableCompat da = this.arE.da(a2);
                    if (da == null) {
                        return am.c(skinType, this.mResources, am.g(this.mResources, i));
                    }
                    com.baidu.tbadk.core.d.a.a(SocialConstants.PARAM_IMG_URL, -1L, 0, "svg_load_success", 0, "", new Object[0]);
                    return da;
                case 3:
                    StateListDrawable a3 = this.arE.a(a2, this.mResources);
                    if (a3 == null) {
                        return am.c(skinType, this.mResources, am.g(this.mResources, i));
                    }
                    com.baidu.tbadk.core.d.a.a(SocialConstants.PARAM_IMG_URL, -1L, 0, "svg_load_success", 0, "", new Object[0]);
                    return a3;
                default:
                    return null;
            }
        } catch (Exception e) {
            com.baidu.tbadk.core.d.a.a(SocialConstants.PARAM_IMG_URL, -1L, 0, "svg_load_error_not_found", 0, "svg_load_error", "reason", "class_not_found");
            return am.c(skinType, this.mResources, am.g(this.mResources, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private LruCache<Integer, Drawable.ConstantState> arG = new LruCache<>(50);

        b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public VectorDrawableCompat cZ(int i) {
            Drawable.ConstantState constantState;
            Throwable th;
            VectorDrawableCompat vectorDrawableCompat;
            Drawable.ConstantState constantState2;
            Drawable.ConstantState constantState3 = this.arG.get(Integer.valueOf(i));
            if (constantState3 == null) {
                try {
                    VectorDrawableCompat create = VectorDrawableCompat.create(TbadkCoreApplication.getInst().getResources(), i, null);
                    if (create != null) {
                        try {
                            constantState2 = create.getConstantState();
                        } catch (Throwable th2) {
                            vectorDrawableCompat = create;
                            constantState = constantState3;
                            th = th2;
                            BdLog.e(th);
                            if (constantState != null) {
                            }
                            if (vectorDrawableCompat != null) {
                            }
                        }
                    } else {
                        constantState2 = constantState3;
                    }
                    if (constantState2 != null) {
                        try {
                            this.arG.put(Integer.valueOf(i), constantState2);
                        } catch (Throwable th3) {
                            th = th3;
                            constantState = constantState2;
                            vectorDrawableCompat = create;
                            BdLog.e(th);
                            if (constantState != null) {
                            }
                            if (vectorDrawableCompat != null) {
                            }
                        }
                    }
                    constantState = constantState2;
                    vectorDrawableCompat = create;
                } catch (Throwable th4) {
                    constantState = constantState3;
                    th = th4;
                    vectorDrawableCompat = null;
                }
            } else {
                vectorDrawableCompat = null;
                constantState = constantState3;
            }
            if (constantState != null) {
                Drawable newDrawable = constantState.newDrawable();
                if (newDrawable instanceof VectorDrawableCompat) {
                    return (VectorDrawableCompat) newDrawable;
                }
            }
            if (vectorDrawableCompat != null) {
                return vectorDrawableCompat;
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public StateListDrawable a(int i, @NonNull Resources resources) {
            StateListDrawable stateListDrawable;
            StateListDrawable stateListDrawable2;
            Drawable.ConstantState constantState = this.arG.get(Integer.valueOf(i));
            if (constantState == null) {
                try {
                    stateListDrawable2 = (StateListDrawable) ResourcesCompat.getDrawable(resources, i, null);
                    if (stateListDrawable2 != null) {
                        try {
                            constantState = stateListDrawable2.getConstantState();
                        } catch (Throwable th) {
                            th = th;
                            BdLog.e(th);
                            stateListDrawable = stateListDrawable2;
                            if (stateListDrawable != null) {
                            }
                        }
                    }
                    if (constantState != null) {
                        this.arG.put(Integer.valueOf(i), constantState);
                        Drawable newDrawable = constantState.newDrawable();
                        if (newDrawable instanceof StateListDrawable) {
                            return (StateListDrawable) newDrawable;
                        }
                    }
                    stateListDrawable = stateListDrawable2;
                } catch (Throwable th2) {
                    th = th2;
                    stateListDrawable2 = null;
                }
            } else {
                stateListDrawable = null;
            }
            if (stateListDrawable != null) {
                return null;
            }
            return stateListDrawable;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AnimatedVectorDrawableCompat da(int i) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
            Drawable.ConstantState constantState = this.arG.get(Integer.valueOf(i));
            if (constantState == null) {
                try {
                    animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(TbadkCoreApplication.getInst(), i);
                    if (animatedVectorDrawableCompat != null) {
                        try {
                            constantState = animatedVectorDrawableCompat.getConstantState();
                        } catch (Throwable th) {
                            th = th;
                            BdLog.e(th);
                            constantState = null;
                            if (constantState != null) {
                            }
                            if (animatedVectorDrawableCompat == null) {
                            }
                        }
                    }
                    if (constantState != null) {
                        this.arG.put(Integer.valueOf(i), constantState);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    animatedVectorDrawableCompat = null;
                }
            } else {
                animatedVectorDrawableCompat = null;
            }
            if (constantState != null) {
                Drawable newDrawable = constantState.newDrawable();
                if (newDrawable instanceof AnimatedVectorDrawableCompat) {
                    return (AnimatedVectorDrawableCompat) newDrawable;
                }
            }
            if (animatedVectorDrawableCompat == null) {
                return animatedVectorDrawableCompat;
            }
            return null;
        }
    }
}
