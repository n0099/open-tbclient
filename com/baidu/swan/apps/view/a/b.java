package com.baidu.swan.apps.view.a;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.d;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.view.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean aNC = Lm();
    private static int aND;
    private boolean bbj;
    @Nullable
    private View bbn;
    private int bbo;
    private a bbp;
    private View.OnSystemUiVisibilityChangeListener bbq;
    @NonNull
    private Activity mActivity;
    @Nullable
    private View mContentView;
    @NonNull
    private ViewGroup mRootView;

    static {
        aND = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            aND = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            aND = 2;
        }
    }

    public b(@NonNull Activity activity) {
        this(activity, (ViewGroup) activity.findViewById(16908290));
    }

    public b(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        this.bbo = 1;
        this.mActivity = activity;
        this.mRootView = viewGroup;
        this.mContentView = this.mRootView.getChildAt(0);
    }

    public void eG(int i) {
        c(i, d.eB(i), false);
    }

    public void c(int i, boolean z, boolean z2) {
        a b;
        if (aNC) {
            if (i == 1) {
                if (this.bbo != 1) {
                    reset();
                }
                this.bbo = i;
                b = PX();
            } else {
                this.bbo = i;
                b = b(i, eH(i), z, z2);
                this.bbp = b;
            }
            this.bbj = z2;
            a(b);
        }
    }

    public void zM() {
        a(PX());
    }

    public void reset() {
        this.bbp = null;
        this.bbo = 1;
    }

    @NonNull
    public a PX() {
        if (this.bbp == null) {
            Qb();
        }
        return this.bbp;
    }

    @Nullable
    public View PY() {
        return this.bbn;
    }

    public boolean PZ() {
        return this.bbj;
    }

    private void a(@NonNull a aVar) {
        if (aND == 2) {
            c(aVar);
        } else {
            Qa();
            b(aVar);
        }
        if (this.mContentView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
            if (aVar.bbj) {
                layoutParams.topMargin = 0;
            } else {
                layoutParams.topMargin = z.getStatusBarHeight();
            }
            this.mContentView.setLayoutParams(layoutParams);
        }
    }

    private void Qa() {
        Window window = this.mActivity.getWindow();
        window.clearFlags(1024);
        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            switch (aND) {
                case 1:
                    a(window, PX().bbh);
                    return;
                default:
                    return;
            }
        } else if (Build.VERSION.SDK_INT >= 19) {
            window.addFlags(67108864);
        }
    }

    private void b(a aVar) {
        int i;
        int i2;
        Window window = this.mActivity.getWindow();
        if (aVar.bbg) {
        }
        if (aVar.bbh) {
            i = 13312;
        } else {
            i = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        }
        if (!aVar.bbi) {
            i2 = i & (-257);
        } else {
            i2 = i | 256;
        }
        int i3 = aVar.bbf;
        if (i3 == 1) {
            i3 = Qc();
        }
        window.getDecorView().setSystemUiVisibility(i2);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(aVar.bbe);
        }
        View d = d(aVar);
        if (d != null) {
            d.setBackgroundColor(i3);
        }
        if (this.bbq == null) {
            this.bbq = new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.view.a.b.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i4) {
                }
            };
            window.getDecorView().setOnSystemUiVisibilityChangeListener(this.bbq);
        }
    }

    private void c(a aVar) {
        int i;
        try {
            Window window = this.mActivity.getWindow();
            window.addFlags(67108864);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i2 = declaredField.getInt(null);
            int i3 = declaredField2.getInt(attributes);
            if (aVar.bbh) {
                i = i2 | i3;
            } else {
                i = (i2 ^ (-1)) & i3;
            }
            declaredField2.setInt(attributes, i);
            window.setAttributes(attributes);
            int i4 = aVar.bbf;
            if (i4 == 1) {
                i4 = Qc();
            }
            View d = d(aVar);
            if (d != null) {
                d.setBackgroundColor(i4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean a(Window window, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i));
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Nullable
    private View d(@NonNull a aVar) {
        if (this.bbn != null) {
            if (!aVar.bbi) {
                this.mRootView.removeView(this.bbn);
                this.bbn = null;
                return null;
            }
            return this.bbn;
        } else if (!aVar.bbi) {
            this.bbn = null;
            return null;
        } else {
            int statusBarHeight = z.getStatusBarHeight();
            View view = new View(this.mActivity);
            view.setTag("IMMERSION_VIEW");
            view.setId(a.f.immersion_custom_statusbar_view);
            this.mRootView.addView(view, new ViewGroup.LayoutParams(-1, statusBarHeight));
            this.bbn = view;
            return view;
        }
    }

    private void Qb() {
        int Qc = Qc();
        this.bbp = b(Qc, eH(Qc), false, false);
    }

    private a b(int i, int i2, boolean z, boolean z2) {
        return a.C0185a.PV().cH(z).cI(true).cG(false).eE(i2).eF(i).cJ(z2).PW();
    }

    private int Qc() {
        return Build.VERSION.SDK_INT >= 21 ? this.mActivity.getResources().getColor(a.c.aiapps_statusbar_immersion_bg) : this.mActivity.getResources().getColor(a.c.aiapps_statusbar_immersion_bg_below_lollipop);
    }

    private int eH(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return 0;
        }
        return I(i, 45);
    }

    private static int I(int i, int i2) {
        if (i2 != 0) {
            float f = 1.0f - (i2 / 255.0f);
            return (((int) ((((i >> 16) & 255) * f) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) ((((i >> 8) & 255) * f) + 0.5d)) << 8) | ((int) ((f * (i & 255)) + 0.5d));
        }
        return i;
    }

    private static boolean Lm() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
