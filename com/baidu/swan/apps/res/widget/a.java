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
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.api.module.e.g;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.d;
import com.baidu.swan.apps.aq.y;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.w.f;
/* loaded from: classes11.dex */
public class a {
    private static boolean DEBUG = b.DEBUG;
    public static final int DEFAULT_POP_DIALOG_COLOR = Color.parseColor("#80000000");
    public static final boolean SUPPORT_IMMERSION = isSupportImmersion();
    private static int sRomType;

    static {
        sRomType = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            sRomType = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            sRomType = 2;
        }
    }

    public static LinearLayout aob() {
        com.baidu.swan.apps.tabbar.b.a Ud = g.Ud();
        if (Ud == null) {
            return null;
        }
        return Ud.asC();
    }

    public static View getActionBar() {
        e QH = f.ahV().QH();
        com.baidu.swan.apps.core.d.b YP = QH != null ? QH.YP() : null;
        if (YP != null) {
            return YP.Yu();
        }
        return null;
    }

    private static boolean isSupportImmersion() {
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (DEBUG) {
            return z & y.getBoolean(ImmersionHelper.SP_KEY_IMMERSION_SWITCH, z);
        }
        return z;
    }

    public static void setDialogImmersion(Dialog dialog) {
        if (Build.VERSION.SDK_INT >= 21) {
            int color = dialog.getContext().getResources().getColor(a.c.aiapps_dialog_immersion_status_bar_color);
            Window window = dialog.getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(color);
        }
    }

    public static boolean b(Dialog dialog) {
        return ((dialog.getWindow().getAttributes().systemUiVisibility | dialog.getWindow().getDecorView().getSystemUiVisibility()) & 2) != 0;
    }

    public static boolean isImmersionEnabled(View view) {
        return (!SUPPORT_IMMERSION || view == null || view.findViewById(a.f.immersion_custom_statusbar_view) == null) ? false : true;
    }

    public static void aoc() {
        e QH = f.ahV().QH();
        if (QH != null) {
            final com.baidu.swan.apps.view.a.b Yi = QH.YP().Yi();
            aj.p(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    View aum;
                    if (com.baidu.swan.apps.view.a.b.this != null && (aum = com.baidu.swan.apps.view.a.b.this.aum()) != null) {
                        aum.setVisibility(0);
                    }
                }
            });
        }
    }

    public static void aod() {
        final com.baidu.swan.apps.core.d.b YP;
        final View view;
        e QH = f.ahV().QH();
        if (QH != null && (view = (YP = QH.YP()).getView()) != null) {
            aj.p(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.2
                @Override // java.lang.Runnable
                public void run() {
                    View aum;
                    com.baidu.swan.apps.view.a.b Yi = com.baidu.swan.apps.core.d.b.this.Yi();
                    if (Yi != null && (aum = Yi.aum()) != null) {
                        aum.setVisibility(8);
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
        a(f.ahV().ahF(), 100L, z);
    }

    private static void a(final Activity activity, long j, final boolean z) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.3
            @Override // java.lang.Runnable
            public void run() {
                activity.getWindow().clearFlags(2048);
                a.b(a.L(activity), z);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(View view, boolean z) {
        if (view != null) {
            if (z) {
                view.setSystemUiVisibility(d.ath());
            } else {
                view.setSystemUiVisibility(0);
            }
        }
    }

    public static ViewGroup L(Activity activity) {
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }
}
