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
    public static final boolean bgQ = Qk();
    private static int bgR;
    private boolean btP;
    @Nullable
    private View btT;
    private int btU;
    private a btV;
    private View.OnSystemUiVisibilityChangeListener btW;
    @NonNull
    private Activity mActivity;
    @Nullable
    private View mContentView;
    @NonNull
    private ViewGroup mRootView;

    static {
        bgR = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            bgR = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            bgR = 2;
        }
    }

    public b(@NonNull Activity activity) {
        this(activity, (ViewGroup) activity.findViewById(16908290));
    }

    public b(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        this.btU = 1;
        this.mActivity = activity;
        this.mRootView = viewGroup;
        this.mContentView = this.mRootView.getChildAt(0);
    }

    public void fB(int i) {
        c(i, d.fw(i), false);
    }

    public void c(int i, boolean z, boolean z2) {
        a b;
        if (bgQ) {
            if (i == 1) {
                if (this.btU != 1) {
                    reset();
                }
                this.btU = i;
                b = UP();
            } else {
                this.btU = i;
                b = b(i, fC(i), z, z2);
                this.btV = b;
            }
            this.btP = z2;
            a(b);
        }
    }

    public void EM() {
        a(UP());
    }

    public void reset() {
        this.btV = null;
        this.btU = 1;
    }

    @NonNull
    public a UP() {
        if (this.btV == null) {
            UT();
        }
        return this.btV;
    }

    @Nullable
    public View UQ() {
        return this.btT;
    }

    public boolean UR() {
        return this.btP;
    }

    private void a(@NonNull a aVar) {
        if (bgR == 2) {
            c(aVar);
        } else {
            US();
            b(aVar);
        }
        if (this.mContentView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
            if (aVar.btP) {
                layoutParams.topMargin = 0;
            } else {
                layoutParams.topMargin = z.getStatusBarHeight();
            }
            this.mContentView.setLayoutParams(layoutParams);
        }
    }

    private void US() {
        Window window = this.mActivity.getWindow();
        window.clearFlags(1024);
        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            switch (bgR) {
                case 1:
                    a(window, UP().btN);
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
        if (aVar.btM) {
        }
        if (aVar.btN) {
            i = 13312;
        } else {
            i = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        }
        if (!aVar.btO) {
            i2 = i & (-257);
        } else {
            i2 = i | 256;
        }
        int i3 = aVar.btL;
        if (i3 == 1) {
            i3 = UU();
        }
        window.getDecorView().setSystemUiVisibility(i2);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(aVar.btK);
        }
        View d = d(aVar);
        if (d != null) {
            d.setBackgroundColor(i3);
        }
        if (this.btW == null) {
            this.btW = new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.swan.apps.view.a.b.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i4) {
                }
            };
            window.getDecorView().setOnSystemUiVisibilityChangeListener(this.btW);
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
            if (aVar.btN) {
                i = i2 | i3;
            } else {
                i = (i2 ^ (-1)) & i3;
            }
            declaredField2.setInt(attributes, i);
            window.setAttributes(attributes);
            int i4 = aVar.btL;
            if (i4 == 1) {
                i4 = UU();
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
        if (this.btT != null) {
            if (!aVar.btO) {
                this.mRootView.removeView(this.btT);
                this.btT = null;
                return null;
            }
            return this.btT;
        } else if (!aVar.btO) {
            this.btT = null;
            return null;
        } else {
            int statusBarHeight = z.getStatusBarHeight();
            View view = new View(this.mActivity);
            view.setTag("IMMERSION_VIEW");
            view.setId(a.f.immersion_custom_statusbar_view);
            this.mRootView.addView(view, new ViewGroup.LayoutParams(-1, statusBarHeight));
            this.btT = view;
            return view;
        }
    }

    private void UT() {
        int UU = UU();
        this.btV = b(UU, fC(UU), false, false);
    }

    private a b(int i, int i2, boolean z, boolean z2) {
        return a.C0226a.UN().cY(z).cZ(true).cX(false).fz(i2).fA(i).da(z2).UO();
    }

    private int UU() {
        return Build.VERSION.SDK_INT >= 21 ? this.mActivity.getResources().getColor(a.c.aiapps_statusbar_immersion_bg) : this.mActivity.getResources().getColor(a.c.aiapps_statusbar_immersion_bg_below_lollipop);
    }

    private int fC(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return 0;
        }
        return M(i, 45);
    }

    private static int M(int i, int i2) {
        if (i2 != 0) {
            float f = 1.0f - (i2 / 255.0f);
            return (((int) ((((i >> 16) & 255) * f) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) ((((i >> 8) & 255) * f) + 0.5d)) << 8) | ((int) ((f * (i & 255)) + 0.5d));
        }
        return i;
    }

    private static boolean Qk() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
