package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes8.dex */
public class c {
    private static int dZn = com.baidu.swan.apps.t.a.axc().agF();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aAs = f.aAo().aAs();
        return aAs != null && aAs.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aAs = f.aAo().aAs();
        return aAs != null && aAs.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d aAs = f.aAo().aAs();
        if (aAs == null) {
            return false;
        }
        if (aAs.aZp()) {
            SwanAppActivity azY = f.aAo().azY();
            if (azY != null) {
                azY.setRequestedOrientation(0);
            }
            aAs.io(false);
        }
        return aAs.removeView(view);
    }

    public static boolean aU(View view) {
        d aAs = f.aAo().aAs();
        return aAs != null && aAs.aT(view);
    }

    public static boolean isLandScape() {
        d aAs = f.aAo().aAs();
        return (aAs == null || !aAs.isLandScape() || aAs.aZp()) ? false : true;
    }

    public static int aZt() {
        return ((Integer) f.aAo().aAb().first).intValue();
    }

    public static int aZu() {
        return ((Integer) f.aAo().aAb().second).intValue();
    }

    public static boolean aZv() {
        return dZn == 3;
    }

    public static boolean aZw() {
        return dZn == 2;
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d aAs = f.aAo().aAs();
        if (aAs != null) {
            aAs.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d aAs = f.aAo().aAs();
        if (aAs != null) {
            aAs.b(aVar);
        }
    }
}
