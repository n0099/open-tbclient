package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes9.dex */
public class c {
    private static int dXM = com.baidu.swan.apps.t.a.awZ().agC();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aAp = f.aAl().aAp();
        return aAp != null && aAp.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aAp = f.aAl().aAp();
        return aAp != null && aAp.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d aAp = f.aAl().aAp();
        if (aAp == null) {
            return false;
        }
        if (aAp.aZm()) {
            SwanAppActivity azV = f.aAl().azV();
            if (azV != null) {
                azV.setRequestedOrientation(0);
            }
            aAp.io(false);
        }
        return aAp.removeView(view);
    }

    public static boolean aU(View view) {
        d aAp = f.aAl().aAp();
        return aAp != null && aAp.aT(view);
    }

    public static boolean isLandScape() {
        d aAp = f.aAl().aAp();
        return (aAp == null || !aAp.isLandScape() || aAp.aZm()) ? false : true;
    }

    public static int aZq() {
        return ((Integer) f.aAl().azY().first).intValue();
    }

    public static int aZr() {
        return ((Integer) f.aAl().azY().second).intValue();
    }

    public static boolean aZs() {
        return dXM == 3;
    }

    public static boolean aZt() {
        return dXM == 2;
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d aAp = f.aAl().aAp();
        if (aAp != null) {
            aAp.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d aAp = f.aAl().aAp();
        if (aAp != null) {
            aAp.b(aVar);
        }
    }
}
