package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes25.dex */
public class c {
    private static int dRu = com.baidu.swan.apps.t.a.azd().aiP();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aCt = f.aCp().aCt();
        return aCt != null && aCt.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aCt = f.aCp().aCt();
        return aCt != null && aCt.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d aCt = f.aCp().aCt();
        if (aCt == null) {
            return false;
        }
        if (aCt.baA()) {
            SwanAppActivity aBZ = f.aCp().aBZ();
            if (aBZ != null) {
                aBZ.setRequestedOrientation(0);
            }
            aCt.hY(false);
        }
        return aCt.removeView(view);
    }

    public static boolean aP(View view) {
        d aCt = f.aCp().aCt();
        return aCt != null && aCt.aO(view);
    }

    public static boolean isLandScape() {
        d aCt = f.aCp().aCt();
        return (aCt == null || !aCt.isLandScape() || aCt.baA()) ? false : true;
    }

    public static int baF() {
        return ((Integer) f.aCp().aCc().first).intValue();
    }

    public static int baG() {
        return ((Integer) f.aCp().aCc().second).intValue();
    }

    public static boolean baH() {
        return dRu == 3;
    }

    public static boolean baI() {
        return dRu == 2;
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d aCt = f.aCp().aCt();
        if (aCt != null) {
            aCt.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d aCt = f.aCp().aCt();
        if (aCt != null) {
            aCt.b(aVar);
        }
    }
}
