package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes10.dex */
public class c {
    private static int dxP = com.baidu.swan.apps.t.a.asi().abV();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d avy = f.avu().avy();
        return avy != null && avy.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d avy = f.avu().avy();
        return avy != null && avy.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d avy = f.avu().avy();
        if (avy == null) {
            return false;
        }
        if (avy.aTJ()) {
            SwanAppActivity ave = f.avu().ave();
            if (ave != null) {
                ave.setRequestedOrientation(0);
            }
            avy.hk(false);
        }
        return avy.removeView(view);
    }

    public static boolean aI(View view) {
        d avy = f.avu().avy();
        return avy != null && avy.aH(view);
    }

    public static boolean isLandScape() {
        d avy = f.avu().avy();
        return (avy == null || !avy.isLandScape() || avy.aTJ()) ? false : true;
    }

    public static int aTO() {
        return ((Integer) f.avu().avh().first).intValue();
    }

    public static int aTP() {
        return ((Integer) f.avu().avh().second).intValue();
    }

    public static boolean aTQ() {
        return dxP == 3;
    }

    public static boolean aTR() {
        return dxP == 2;
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d avy = f.avu().avy();
        if (avy != null) {
            avy.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d avy = f.avu().avy();
        if (avy != null) {
            avy.b(aVar);
        }
    }
}
