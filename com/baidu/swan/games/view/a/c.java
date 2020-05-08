package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aeN = f.aeJ().aeN();
        return aeN != null && aeN.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aeN = f.aeJ().aeN();
        return aeN != null && aeN.b(view, aVar);
    }

    public static boolean av(View view) {
        d aeN = f.aeJ().aeN();
        return aeN != null && aeN.av(view);
    }

    public static boolean az(View view) {
        d aeN = f.aeJ().aeN();
        return aeN != null && aeN.ay(view);
    }

    public static boolean isLandScape() {
        d aeN = f.aeJ().aeN();
        return aeN != null && aeN.isLandScape();
    }

    public static int ayO() {
        return ((Integer) f.aeJ().aex().first).intValue();
    }

    public static int ayP() {
        return ((Integer) f.aeJ().aex().second).intValue();
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d aeN = f.aeJ().aeN();
        if (aeN != null) {
            aeN.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d aeN = f.aeJ().aeN();
        if (aeN != null) {
            aeN.b(aVar);
        }
    }
}
