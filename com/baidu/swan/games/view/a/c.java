package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes9.dex */
public class c {
    private static int eaq = com.baidu.swan.apps.t.a.aAu().ajX();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aDK = f.aDG().aDK();
        return aDK != null && aDK.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aDK = f.aDG().aDK();
        return aDK != null && aDK.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d aDK = f.aDG().aDK();
        if (aDK == null) {
            return false;
        }
        if (aDK.bcT()) {
            SwanAppActivity aDq = f.aDG().aDq();
            if (aDq != null) {
                aDq.setRequestedOrientation(0);
            }
            aDK.iq(false);
        }
        return aDK.removeView(view);
    }

    public static boolean aY(View view) {
        d aDK = f.aDG().aDK();
        return aDK != null && aDK.aX(view);
    }

    public static boolean isLandScape() {
        d aDK = f.aDG().aDK();
        return (aDK == null || !aDK.isLandScape() || aDK.bcT()) ? false : true;
    }

    public static int bcX() {
        return ((Integer) f.aDG().aDt().first).intValue();
    }

    public static int bcY() {
        return ((Integer) f.aDG().aDt().second).intValue();
    }

    public static boolean bcZ() {
        return eaq == 3;
    }

    public static boolean bda() {
        return eaq == 2;
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d aDK = f.aDG().aDK();
        if (aDK != null) {
            aDK.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d aDK = f.aDG().aDK();
        if (aDK != null) {
            aDK.b(aVar);
        }
    }
}
