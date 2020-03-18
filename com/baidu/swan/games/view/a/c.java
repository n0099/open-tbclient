package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d WY = f.WV().WY();
        return WY != null && WY.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d WY = f.WV().WY();
        return WY != null && WY.b(view, aVar);
    }

    public static boolean au(View view) {
        d WY = f.WV().WY();
        return WY != null && WY.au(view);
    }

    public static boolean ay(View view) {
        d WY = f.WV().WY();
        return WY != null && WY.ax(view);
    }

    public static boolean isLandScape() {
        d WY = f.WV().WY();
        return WY != null && WY.isLandScape();
    }

    public static int aqC() {
        return ((Integer) f.WV().WJ().first).intValue();
    }

    public static int aqD() {
        return ((Integer) f.WV().WJ().second).intValue();
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d WY = f.WV().WY();
        if (WY != null) {
            WY.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d WY = f.WV().WY();
        if (WY != null) {
            WY.b(aVar);
        }
    }
}
