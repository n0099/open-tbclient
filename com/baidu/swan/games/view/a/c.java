package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes10.dex */
public class c {
    private static int dGm = com.baidu.swan.apps.t.a.aud().adP();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d axs = f.axo().axs();
        return axs != null && axs.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d axs = f.axo().axs();
        return axs != null && axs.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d axs = f.axo().axs();
        if (axs == null) {
            return false;
        }
        if (axs.aVD()) {
            SwanAppActivity awY = f.axo().awY();
            if (awY != null) {
                awY.setRequestedOrientation(0);
            }
            axs.hx(false);
        }
        return axs.removeView(view);
    }

    public static boolean aJ(View view) {
        d axs = f.axo().axs();
        return axs != null && axs.aI(view);
    }

    public static boolean isLandScape() {
        d axs = f.axo().axs();
        return (axs == null || !axs.isLandScape() || axs.aVD()) ? false : true;
    }

    public static int aVI() {
        return ((Integer) f.axo().axb().first).intValue();
    }

    public static int aVJ() {
        return ((Integer) f.axo().axb().second).intValue();
    }

    public static boolean aVK() {
        return dGm == 3;
    }

    public static boolean aVL() {
        return dGm == 2;
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d axs = f.axo().axs();
        if (axs != null) {
            axs.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d axs = f.axo().axs();
        if (axs != null) {
            axs.b(aVar);
        }
    }
}
