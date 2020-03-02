package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d WV = f.WS().WV();
        return WV != null && WV.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d WV = f.WS().WV();
        return WV != null && WV.b(view, aVar);
    }

    public static boolean au(View view) {
        d WV = f.WS().WV();
        return WV != null && WV.au(view);
    }

    public static boolean ay(View view) {
        d WV = f.WS().WV();
        return WV != null && WV.ax(view);
    }

    public static boolean isLandScape() {
        d WV = f.WS().WV();
        return WV != null && WV.isLandScape();
    }

    public static int aqz() {
        return ((Integer) f.WS().WG().first).intValue();
    }

    public static int aqA() {
        return ((Integer) f.WS().WG().second).intValue();
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d WV = f.WS().WV();
        if (WV != null) {
            WV.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d WV = f.WS().WV();
        if (WV != null) {
            WV.b(aVar);
        }
    }
}
