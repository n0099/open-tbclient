package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes8.dex */
public class c {
    private static int djH = com.baidu.swan.apps.t.a.aoM().YA();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d asc = f.arY().asc();
        return asc != null && asc.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d asc = f.arY().asc();
        return asc != null && asc.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d asc = f.arY().asc();
        if (asc == null) {
            return false;
        }
        if (asc.aQo()) {
            SwanAppActivity arI = f.arY().arI();
            if (arI != null) {
                arI.setRequestedOrientation(0);
            }
            asc.gQ(false);
        }
        return asc.removeView(view);
    }

    public static boolean aF(View view) {
        d asc = f.arY().asc();
        return asc != null && asc.aE(view);
    }

    public static boolean isLandScape() {
        d asc = f.arY().asc();
        return (asc == null || !asc.isLandScape() || asc.aQo()) ? false : true;
    }

    public static int aQt() {
        return ((Integer) f.arY().arL().first).intValue();
    }

    public static int aQu() {
        return ((Integer) f.arY().arL().second).intValue();
    }

    public static boolean aQv() {
        return djH == 3;
    }

    public static boolean aQw() {
        return djH == 2;
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d asc = f.arY().asc();
        if (asc != null) {
            asc.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d asc = f.arY().asc();
        if (asc != null) {
            asc.b(aVar);
        }
    }
}
