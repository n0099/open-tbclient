package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes9.dex */
public class c {
    private static int eaq = com.baidu.swan.apps.t.a.aAv().ajY();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aDL = f.aDH().aDL();
        return aDL != null && aDL.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aDL = f.aDH().aDL();
        return aDL != null && aDL.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d aDL = f.aDH().aDL();
        if (aDL == null) {
            return false;
        }
        if (aDL.bcU()) {
            SwanAppActivity aDr = f.aDH().aDr();
            if (aDr != null) {
                aDr.setRequestedOrientation(0);
            }
            aDL.iq(false);
        }
        return aDL.removeView(view);
    }

    public static boolean aY(View view) {
        d aDL = f.aDH().aDL();
        return aDL != null && aDL.aX(view);
    }

    public static boolean isLandScape() {
        d aDL = f.aDH().aDL();
        return (aDL == null || !aDL.isLandScape() || aDL.bcU()) ? false : true;
    }

    public static int bcY() {
        return ((Integer) f.aDH().aDu().first).intValue();
    }

    public static int bcZ() {
        return ((Integer) f.aDH().aDu().second).intValue();
    }

    public static boolean bda() {
        return eaq == 3;
    }

    public static boolean bdb() {
        return eaq == 2;
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d aDL = f.aDH().aDL();
        if (aDL != null) {
            aDL.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d aDL = f.aDH().aDL();
        if (aDL != null) {
            aDL.b(aVar);
        }
    }
}
