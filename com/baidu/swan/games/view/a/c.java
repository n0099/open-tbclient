package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aeO = f.aeK().aeO();
        return aeO != null && aeO.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d aeO = f.aeK().aeO();
        return aeO != null && aeO.b(view, aVar);
    }

    public static boolean av(View view) {
        d aeO = f.aeK().aeO();
        return aeO != null && aeO.av(view);
    }

    public static boolean az(View view) {
        d aeO = f.aeK().aeO();
        return aeO != null && aeO.ay(view);
    }

    public static boolean isLandScape() {
        d aeO = f.aeK().aeO();
        return aeO != null && aeO.isLandScape();
    }

    public static int ayO() {
        return ((Integer) f.aeK().aey().first).intValue();
    }

    public static int ayP() {
        return ((Integer) f.aeK().aey().second).intValue();
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d aeO = f.aeK().aeO();
        if (aeO != null) {
            aeO.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d aeO = f.aeK().aeO();
        if (aeO != null) {
            aeO.b(aVar);
        }
    }
}
