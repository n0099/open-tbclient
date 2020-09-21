package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes3.dex */
public class c {
    private static int dlJ = com.baidu.swan.apps.t.a.apx().Zj();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d asN = f.asJ().asN();
        return asN != null && asN.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d asN = f.asJ().asN();
        return asN != null && asN.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d asN = f.asJ().asN();
        if (asN == null) {
            return false;
        }
        if (asN.aRa()) {
            SwanAppActivity ast = f.asJ().ast();
            if (ast != null) {
                ast.setRequestedOrientation(0);
            }
            asN.gO(false);
        }
        return asN.removeView(view);
    }

    public static boolean aH(View view) {
        d asN = f.asJ().asN();
        return asN != null && asN.aG(view);
    }

    public static boolean isLandScape() {
        d asN = f.asJ().asN();
        return (asN == null || !asN.isLandScape() || asN.aRa()) ? false : true;
    }

    public static int aRf() {
        return ((Integer) f.asJ().asw().first).intValue();
    }

    public static int aRg() {
        return ((Integer) f.asJ().asw().second).intValue();
    }

    public static boolean aRh() {
        return dlJ == 3;
    }

    public static boolean aRi() {
        return dlJ == 2;
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d asN = f.asJ().asN();
        if (asN != null) {
            asN.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d asN = f.asJ().asN();
        if (asN != null) {
            asN.b(aVar);
        }
    }
}
