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
    public static final int dDA = Color.parseColor("#80000000");
    public static final boolean dDB = aLj();
    private static int dDC;

    static {
        dDC = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            dDC = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            dDC = 2;
        }
    }

    public static LinearLayout aLi() {
        com.baidu.swan.apps.tabbar.b.a anu = g.anu();
        if (anu == null) {
            return null;
        }
        return anu.aQw();
    }

    public static View getActionBar() {
        f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        c asU = ajt != null ? ajt.asU() : null;
        if (asU != null) {
            return asU.asv();
        }
        return null;
    }

    private static boolean aLj() {
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
        return (!dDB || view == null || view.findViewById(a.f.immersion_custom_statusbar_view) == null) ? false : true;
    }

    public static void aLk() {
        f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt != null) {
            final com.baidu.swan.apps.view.a.b asj = ajt.asU().asj();
            ak.l(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    View aSt;
                    if (com.baidu.swan.apps.view.a.b.this != null && (aSt = com.baidu.swan.apps.view.a.b.this.aSt()) != null) {
                        aSt.setVisibility(0);
                    }
                }
            });
        }
    }

    public static void aLl() {
        final c asU;
        final View view;
        f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt != null && (view = (asU = ajt.asU()).getView()) != null) {
            ak.l(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.2
                @Override // java.lang.Runnable
                public void run() {
                    View aSt;
                    com.baidu.swan.apps.view.a.b asj = c.this.asj();
                    if (asj != null && (aSt = asj.aSt()) != null) {
                        aSt.setVisibility(8);
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
        a(com.baidu.swan.apps.v.f.aDH().aDr(), 100L, z);
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
                view.setSystemUiVisibility(e.aRd());
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
