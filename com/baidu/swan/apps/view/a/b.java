package com.baidu.swan.apps.view.a;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.view.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class b {
    public static final boolean dAU = aHI();
    private static int dAV;
    private boolean dQX;
    @Nullable
    private View dRc;
    private int dRd;
    private a dRe;
    private View.OnSystemUiVisibilityChangeListener dRf;
    @NonNull
    private Activity mActivity;
    @Nullable
    private View mContentView;
    @NonNull
    private ViewGroup mRootView;

    static {
        dAV = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            dAV = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            dAV = 2;
        }
    }

    public b(@NonNull Activity activity) {
        this(activity, (ViewGroup) activity.findViewById(16908290));
    }

    public b(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        this.dRd = 1;
        this.mActivity = activity;
        this.mRootView = viewGroup;
        this.mContentView = this.mRootView.getChildAt(0);
    }

    public void d(int i, boolean z, boolean z2) {
        a(i, z, true, z2);
    }

    public void a(int i, boolean z, boolean z2, boolean z3) {
        a a2;
        if (dAU) {
            if (i == 1) {
                if (this.dRd != 1) {
                    reset();
                }
                this.dRd = i;
                a2 = aOR();
            } else {
                this.dRd = i;
                a2 = a(i, ks(i), z3, z, z2);
                this.dRe = a2;
            }
            this.dQX = z;
            a(a2);
        }
    }

    public void aoL() {
        a(aOR());
    }

    public void reset() {
        this.dRe = null;
        this.dRd = 1;
    }

    @NonNull
    public a aOR() {
        if (this.dRe == null) {
            aOV();
        }
        return this.dRe;
    }

    @Nullable
    public View aOS() {
        return this.dRc;
    }

    public boolean aOT() {
        return this.dQX;
    }

    private void a(@NonNull a aVar) {
        if (dAV == 2) {
            c(aVar);
        } else {
            aOU();
            b(aVar);
        }
        if (this.mContentView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
            if (aVar.dQX) {
                layoutParams.topMargin = 0;
            } else {
                layoutParams.topMargin = ah.getStatusBarHeight();
            }
            this.mContentView.setLayoutParams(layoutParams);
        }
    }

    private void aOU() {
        Window window = this.mActivity.getWindow();
        window.clearFlags(1024);
        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            switch (dAV) {
                case 1:
                    d(window, aOR().dQV);
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
        if (aVar.dQU) {
        }
        if (aVar.dQV) {
            i = 13312;
        } else {
            i = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        }
        if (!aVar.dQW) {
            i2 = i & (-257);
        } else {
            i2 = i | 256;
        }
        int i3 = aVar.dQT;
        if (i3 == 1) {
            i3 = aOW();
        }
        window.getDecorView().setSystemUiVisibility(i2);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(aVar.dQS);
        }
        View d = d(aVar);
        if (d != null) {
            d.setBackgroundColor(i3);
        }
        if (this.dRf == null) {
            this.dRf = new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.view.a.b.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i4) {
                }
            };
            window.getDecorView().setOnSystemUiVisibilityChangeListener(this.dRf);
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
            if (aVar.dQV) {
                i = i2 | i3;
            } else {
                i = (i2 ^ (-1)) & i3;
            }
            declaredField2.setInt(attributes, i);
            window.setAttributes(attributes);
            int i4 = aVar.dQT;
            if (i4 == 1) {
                i4 = aOW();
            }
            View d = d(aVar);
            if (d != null) {
                d.setBackgroundColor(i4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean d(Window window, boolean z) {
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

    private View d(@NonNull a aVar) {
        if (aVar.dQY) {
            if (this.dRc != null) {
                if (!aVar.dQW) {
                    this.mRootView.removeView(this.dRc);
                    this.dRc = null;
                    return null;
                }
                return this.dRc;
            } else if (!aVar.dQW) {
                this.dRc = null;
                return null;
            } else {
                int statusBarHeight = ah.getStatusBarHeight();
                View view = new View(this.mActivity);
                view.setTag("IMMERSION_VIEW");
                view.setId(a.f.immersion_custom_statusbar_view);
                this.mRootView.addView(view, new ViewGroup.LayoutParams(-1, statusBarHeight));
                this.dRc = view;
                return view;
            }
        }
        return null;
    }

    private void aOV() {
        int aOW = aOW();
        this.dRe = a(aOW, ks(aOW), false, false, true);
    }

    private a a(int i, int i2, boolean z, boolean z2, boolean z3) {
        return a.C0477a.aOP().hC(z).hD(true).hB(false).kq(i2).kr(i).hE(z2).hF(z3).aOQ();
    }

    private int aOW() {
        return Build.VERSION.SDK_INT >= 21 ? this.mActivity.getResources().getColor(a.c.aiapps_statusbar_immersion_bg) : this.mActivity.getResources().getColor(a.c.aiapps_statusbar_immersion_bg_below_lollipop);
    }

    private int ks(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return 0;
        }
        return ap(i, 45);
    }

    private static int ap(int i, int i2) {
        if (i2 != 0) {
            float f = 1.0f - (i2 / 255.0f);
            return (((int) ((((i >> 16) & 255) * f) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) ((((i >> 8) & 255) * f) + 0.5d)) << 8) | ((int) ((f * (i & 255)) + 0.5d));
        }
        return i;
    }

    private static boolean aHI() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
