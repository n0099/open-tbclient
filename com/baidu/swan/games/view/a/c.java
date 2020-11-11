package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes10.dex */
public class c {
    private static int dMe = com.baidu.swan.apps.t.a.awD().agp();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d azS = f.azO().azS();
        return azS != null && azS.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d azS = f.azO().azS();
        return azS != null && azS.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d azS = f.azO().azS();
        if (azS == null) {
            return false;
        }
        if (azS.aYd()) {
            SwanAppActivity azy = f.azO().azy();
            if (azy != null) {
                azy.setRequestedOrientation(0);
            }
            azS.hG(false);
        }
        return azS.removeView(view);
    }

    public static boolean aN(View view) {
        d azS = f.azO().azS();
        return azS != null && azS.aM(view);
    }

    public static boolean isLandScape() {
        d azS = f.azO().azS();
        return (azS == null || !azS.isLandScape() || azS.aYd()) ? false : true;
    }

    public static int aYi() {
        return ((Integer) f.azO().azB().first).intValue();
    }

    public static int aYj() {
        return ((Integer) f.azO().azB().second).intValue();
    }

    public static boolean aYk() {
        return dMe == 3;
    }

    public static boolean aYl() {
        return dMe == 2;
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d azS = f.azO().azS();
        if (azS != null) {
            azS.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d azS = f.azO().azS();
        if (azS != null) {
            azS.b(aVar);
        }
    }
}
