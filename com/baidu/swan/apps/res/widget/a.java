package com.baidu.swan.apps.res.widget;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.aa;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.e;
import com.baidu.swan.apps.api.module.e.g;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.c;
import com.baidu.swan.apps.core.d.f;
/* loaded from: classes9.dex */
public class a {
    private static boolean DEBUG = b.DEBUG;
    public static final int dAT = Color.parseColor("#80000000");
    public static final boolean dAU = aHI();
    private static int dAV;

    static {
        dAV = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            dAV = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            dAV = 2;
        }
    }

    public static LinearLayout aHH() {
        com.baidu.swan.apps.tabbar.b.a ajY = g.ajY();
        if (ajY == null) {
            return null;
        }
        return ajY.aMV();
    }

    public static View getActionBar() {
        f afX = com.baidu.swan.apps.v.f.aAl().afX();
        c apx = afX != null ? afX.apx() : null;
        if (apx != null) {
            return apx.aoX();
        }
        return null;
    }

    private static boolean aHI() {
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (DEBUG) {
            return z & aa.getBoolean("sp_key_immersion_switch", z);
        }
        return z;
    }

    public static void e(Dialog dialog) {
        if (Build.VERSION.SDK_INT >= 21) {
            int color = dialog.getContext().getResources().getColor(a.c.aiapps_dialog_immersion_status_bar_color);
            Window window = dialog.getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(color);
        }
    }

    public static boolean f(Dialog dialog) {
        return ((dialog.getWindow().getAttributes().systemUiVisibility | dialog.getWindow().getDecorView().getSystemUiVisibility()) & 2) != 0;
    }

    public static boolean aF(View view) {
        return (!dAU || view == null || view.findViewById(a.f.immersion_custom_statusbar_view) == null) ? false : true;
    }

    public static void aHJ() {
        f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX != null) {
            final com.baidu.swan.apps.view.a.b aoM = afX.apx().aoM();
            ak.k(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    View aOS;
                    if (com.baidu.swan.apps.view.a.b.this != null && (aOS = com.baidu.swan.apps.view.a.b.this.aOS()) != null) {
                        aOS.setVisibility(0);
                    }
                }
            });
        }
    }

    public static void aHK() {
        final c apx;
        final View view;
        f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX != null && (view = (apx = afX.apx()).getView()) != null) {
            ak.k(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.2
                @Override // java.lang.Runnable
                public void run() {
                    View aOS;
                    com.baidu.swan.apps.view.a.b aoM = c.this.aoM();
                    if (aoM != null && (aOS = aoM.aOS()) != null) {
                        aOS.setVisibility(8);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.ai_apps_fragment_base_view);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams.topMargin = 0;
                    linearLayout.setLayoutParams(layoutParams);
                    FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(a.f.ai_apps_fragment_content);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    frameLayout.setLayoutParams(layoutParams2);
                }
            });
        }
    }

    public static void setImmersive(boolean z) {
        a(com.baidu.swan.apps.v.f.aAl().azV(), 100L, z);
    }

    private static void a(final Activity activity, long j, final boolean z) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.3
            @Override // java.lang.Runnable
            public void run() {
                activity.getWindow().clearFlags(2048);
                a.setSystemUiVisibility(a.getDecorView(activity), z);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setSystemUiVisibility(View view, boolean z) {
        if (view != null) {
            if (z) {
                view.setSystemUiVisibility(e.aNC());
            } else {
                view.setSystemUiVisibility(0);
            }
        }
    }

    public static ViewGroup getDecorView(Activity activity) {
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }
}
