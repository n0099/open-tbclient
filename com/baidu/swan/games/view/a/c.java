package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes10.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d UF = f.UC().UF();
        return UF != null && UF.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d UF = f.UC().UF();
        return UF != null && UF.b(view, aVar);
    }

    public static boolean au(View view) {
        d UF = f.UC().UF();
        return UF != null && UF.au(view);
    }

    public static boolean ay(View view) {
        d UF = f.UC().UF();
        return UF != null && UF.ax(view);
    }

    public static boolean isLandScape() {
        d UF = f.UC().UF();
        return UF != null && UF.isLandScape();
    }

    public static int aoj() {
        return ((Integer) f.UC().Uq().first).intValue();
    }

    public static int aok() {
        return ((Integer) f.UC().Uq().second).intValue();
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d UF = f.UC().UF();
        if (UF != null) {
            UF.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d UF = f.UC().UF();
        if (UF != null) {
            UF.b(aVar);
        }
    }
}
