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
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.e;
import com.baidu.swan.apps.aq.z;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.c;
import com.baidu.swan.apps.core.d.f;
/* loaded from: classes7.dex */
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

    public static LinearLayout aqR() {
        com.baidu.swan.apps.tabbar.b.a VO = g.VO();
        if (VO == null) {
            return null;
        }
        return VO.avJ();
    }

    public static View getActionBar() {
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        c aaZ = Sc != null ? Sc.aaZ() : null;
        if (aaZ != null) {
            return aaZ.aaD();
        }
        return null;
    }

    private static boolean isSupportImmersion() {
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (DEBUG) {
            return z & z.getBoolean(ImmersionHelper.SP_KEY_IMMERSION_SWITCH, z);
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

    public static void aqS() {
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null) {
            final com.baidu.swan.apps.view.a.b aas = Sc.aaZ().aas();
            al.p(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    View axG;
                    if (com.baidu.swan.apps.view.a.b.this != null && (axG = com.baidu.swan.apps.view.a.b.this.axG()) != null) {
                        axG.setVisibility(0);
                    }
                }
            });
        }
    }

    public static void aqT() {
        final c aaZ;
        final View view;
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null && (view = (aaZ = Sc.aaZ()).getView()) != null) {
            al.p(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.2
                @Override // java.lang.Runnable
                public void run() {
                    View axG;
                    com.baidu.swan.apps.view.a.b aas = c.this.aas();
                    if (aas != null && (axG = aas.axG()) != null) {
                        axG.setVisibility(8);
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
        a(com.baidu.swan.apps.v.f.akr().akb(), 100L, z);
    }

    private static void a(final Activity activity, long j, final boolean z) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.widget.a.3
            @Override // java.lang.Runnable
            public void run() {
                activity.getWindow().clearFlags(2048);
                a.b(a.K(activity), z);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(View view, boolean z) {
        if (view != null) {
            if (z) {
                view.setSystemUiVisibility(e.awp());
            } else {
                view.setSystemUiVisibility(0);
            }
        }
    }

    public static ViewGroup K(Activity activity) {
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }
}
