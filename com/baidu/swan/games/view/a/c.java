package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes8.dex */
public class c {
    private static int dVE = com.baidu.swan.apps.t.a.awB().age();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d azR = f.azN().azR();
        return azR != null && azR.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d azR = f.azN().azR();
        return azR != null && azR.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d azR = f.azN().azR();
        if (azR == null) {
            return false;
        }
        if (azR.aZa()) {
            SwanAppActivity azx = f.azN().azx();
            if (azx != null) {
                azx.setRequestedOrientation(0);
            }
            azR.im(false);
        }
        return azR.removeView(view);
    }

    public static boolean aY(View view) {
        d azR = f.azN().azR();
        return azR != null && azR.aX(view);
    }

    public static boolean isLandScape() {
        d azR = f.azN().azR();
        return (azR == null || !azR.isLandScape() || azR.aZa()) ? false : true;
    }

    public static int aZe() {
        return ((Integer) f.azN().azA().first).intValue();
    }

    public static int aZf() {
        return ((Integer) f.azN().azA().second).intValue();
    }

    public static boolean aZg() {
        return dVE == 3;
    }

    public static boolean aZh() {
        return dVE == 2;
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d azR = f.azN().azR();
        if (azR != null) {
            azR.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d azR = f.azN().azR();
        if (azR != null) {
            azR.b(aVar);
        }
    }
}
