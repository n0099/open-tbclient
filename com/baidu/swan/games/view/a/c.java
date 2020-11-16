package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes7.dex */
public class c {
    private static int dKw = com.baidu.swan.apps.t.a.avV().afH();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d azk = f.azg().azk();
        return azk != null && azk.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d azk = f.azg().azk();
        return azk != null && azk.b(view, aVar);
    }

    public static boolean removeView(View view) {
        d azk = f.azg().azk();
        if (azk == null) {
            return false;
        }
        if (azk.aXv()) {
            SwanAppActivity ayQ = f.azg().ayQ();
            if (ayQ != null) {
                ayQ.setRequestedOrientation(0);
            }
            azk.hJ(false);
        }
        return azk.removeView(view);
    }

    public static boolean aN(View view) {
        d azk = f.azg().azk();
        return azk != null && azk.aM(view);
    }

    public static boolean isLandScape() {
        d azk = f.azg().azk();
        return (azk == null || !azk.isLandScape() || azk.aXv()) ? false : true;
    }

    public static int aXA() {
        return ((Integer) f.azg().ayT().first).intValue();
    }

    public static int aXB() {
        return ((Integer) f.azg().ayT().second).intValue();
    }

    public static boolean aXC() {
        return dKw == 3;
    }

    public static boolean aXD() {
        return dKw == 2;
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d azk = f.azg().azk();
        if (azk != null) {
            azk.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d azk = f.azg().azk();
        if (azk != null) {
            azk.b(aVar);
        }
    }
}
