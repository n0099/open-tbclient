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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.f;
import com.baidu.swan.apps.view.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean SUPPORT_IMMERSION = isSupportImmersion();
    private static int sRomType;
    private boolean bZL;
    @Nullable
    private View bZN;
    private a bZO;
    private View.OnSystemUiVisibilityChangeListener bZP;
    @NonNull
    private Activity mActivity;
    @Nullable
    private View mContentView;
    @NonNull
    private ViewGroup mRootView;
    private int mStatusBarViewBg;

    static {
        sRomType = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            sRomType = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            sRomType = 2;
        }
    }

    public b(@NonNull Activity activity) {
        this(activity, (ViewGroup) activity.findViewById(16908290));
    }

    public b(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        this.mStatusBarViewBg = 1;
        this.mActivity = activity;
        this.mRootView = viewGroup;
        this.mContentView = this.mRootView.getChildAt(0);
    }

    public void setImmersion(int i, boolean z) {
        c(i, z, true);
    }

    public void c(int i, boolean z, boolean z2) {
        a(i, f.he(i), z, z2);
    }

    public void a(int i, boolean z, boolean z2, boolean z3) {
        a a;
        if (SUPPORT_IMMERSION) {
            if (i == 1) {
                if (this.mStatusBarViewBg != 1) {
                    reset();
                }
                this.mStatusBarViewBg = i;
                a = ahx();
            } else {
                this.mStatusBarViewBg = i;
                a = a(i, getStatusBarColor(i), z, z2, z3);
                this.bZO = a;
            }
            this.bZL = z2;
            a(a);
        }
    }

    public void resetWithCurImmersion() {
        a(ahx());
    }

    public void reset() {
        this.bZO = null;
        this.mStatusBarViewBg = 1;
    }

    @NonNull
    public a ahx() {
        if (this.bZO == null) {
            ahA();
        }
        return this.bZO;
    }

    @Nullable
    public View ahy() {
        return this.bZN;
    }

    public boolean ahz() {
        return this.bZL;
    }

    private void a(@NonNull a aVar) {
        if (sRomType == 2) {
            c(aVar);
        } else {
            setWindowFlag();
            b(aVar);
        }
        if (this.mContentView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
            if (aVar.bZL) {
                layoutParams.topMargin = 0;
            } else {
                layoutParams.topMargin = af.getStatusBarHeight();
            }
            this.mContentView.setLayoutParams(layoutParams);
        }
    }

    private void setWindowFlag() {
        Window window = this.mActivity.getWindow();
        window.clearFlags(1024);
        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            switch (sRomType) {
                case 1:
                    setMIUISetStatusBarLightMode(window, ahx().bZJ);
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
        if (aVar.isShowNavBar) {
        }
        if (aVar.bZJ) {
            i = 13312;
        } else {
            i = 5120;
        }
        if (!aVar.bZK) {
            i2 = i & (-257);
        } else {
            i2 = i | 256;
        }
        int i3 = aVar.bZI;
        if (i3 == 1) {
            i3 = getDefaultStatusBarViewBg();
        }
        window.getDecorView().setSystemUiVisibility(i2);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(aVar.statusBarColor);
        }
        View d = d(aVar);
        if (d != null) {
            d.setBackgroundColor(i3);
        }
        if (this.bZP == null) {
            this.bZP = new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.view.a.b.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i4) {
                }
            };
            window.getDecorView().setOnSystemUiVisibilityChangeListener(this.bZP);
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
            if (aVar.bZJ) {
                i = i2 | i3;
            } else {
                i = (i2 ^ (-1)) & i3;
            }
            declaredField2.setInt(attributes, i);
            window.setAttributes(attributes);
            int i4 = aVar.bZI;
            if (i4 == 1) {
                i4 = getDefaultStatusBarViewBg();
            }
            View d = d(aVar);
            if (d != null) {
                d.setBackgroundColor(i4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean setMIUISetStatusBarLightMode(Window window, boolean z) {
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
        if (aVar.bZM) {
            if (this.bZN != null) {
                if (!aVar.bZK) {
                    this.mRootView.removeView(this.bZN);
                    this.bZN = null;
                    return null;
                }
                return this.bZN;
            } else if (!aVar.bZK) {
                this.bZN = null;
                return null;
            } else {
                int statusBarHeight = af.getStatusBarHeight();
                View view = new View(this.mActivity);
                view.setTag("IMMERSION_VIEW");
                view.setId(a.f.immersion_custom_statusbar_view);
                this.mRootView.addView(view, new ViewGroup.LayoutParams(-1, statusBarHeight));
                this.bZN = view;
                return view;
            }
        }
        return null;
    }

    private void ahA() {
        int defaultStatusBarViewBg = getDefaultStatusBarViewBg();
        this.bZO = a(defaultStatusBarViewBg, getStatusBarColor(defaultStatusBarViewBg), false, false, true);
    }

    private a a(int i, int i2, boolean z, boolean z2, boolean z3) {
        return a.C0304a.ahv().ef(z).eg(true).ee(false).hh(i2).hi(i).eh(z2).ei(z3).ahw();
    }

    private int getDefaultStatusBarViewBg() {
        return Build.VERSION.SDK_INT >= 21 ? this.mActivity.getResources().getColor(a.c.aiapps_statusbar_immersion_bg) : this.mActivity.getResources().getColor(a.c.aiapps_statusbar_immersion_bg_below_lollipop);
    }

    private int getStatusBarColor(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return 0;
        }
        return calculateStatusColor(i, 45);
    }

    private static int calculateStatusColor(int i, int i2) {
        if (i2 != 0) {
            float f = 1.0f - (i2 / 255.0f);
            return (((int) ((((i >> 16) & 255) * f) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) ((((i >> 8) & 255) * f) + 0.5d)) << 8) | ((int) ((f * (i & 255)) + 0.5d));
        }
        return i;
    }

    private static boolean isSupportImmersion() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
