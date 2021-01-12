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
/* loaded from: classes8.dex */
public class a {
    private static boolean DEBUG = b.DEBUG;
    public static final int dyO = Color.parseColor("#80000000");
    public static final boolean dyP = aHp();
    private static int dyQ;

    static {
        dyQ = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            dyQ = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            dyQ = 2;
        }
    }

    public static LinearLayout aHo() {
        com.baidu.swan.apps.tabbar.b.a ajA = g.ajA();
        if (ajA == null) {
            return null;
        }
        return ajA.aMC();
    }

    public static View getActionBar() {
        f afz = com.baidu.swan.apps.v.f.azN().afz();
        c aoY = afz != null ? afz.aoY() : null;
        if (aoY != null) {
            return aoY.aoz();
        }
        return null;
    }

    private static boolean aHp() {
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

    public static boolean aJ(View view) {
        return (!dyP || view == null || view.findViewById(a.f.immersion_custom_statusbar_view) == null) ? false : true;
    }

    public static void aHq() {
        f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null) {
            final com.baidu.swan.apps.view.a.b aoo = afz.aoY().aoo();
            ak.l(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    View aOz;
                    if (com.baidu.swan.apps.view.a.b.this != null && (aOz = com.baidu.swan.apps.view.a.b.this.aOz()) != null) {
                        aOz.setVisibility(0);
                    }
                }
            });
        }
    }

    public static void aHr() {
        final c aoY;
        final View view;
        f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null && (view = (aoY = afz.aoY()).getView()) != null) {
            ak.l(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.2
                @Override // java.lang.Runnable
                public void run() {
                    View aOz;
                    com.baidu.swan.apps.view.a.b aoo = c.this.aoo();
                    if (aoo != null && (aOz = aoo.aOz()) != null) {
                        aOz.setVisibility(8);
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
        a(com.baidu.swan.apps.v.f.azN().azx(), 100L, z);
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
                view.setSystemUiVisibility(e.aNj());
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
