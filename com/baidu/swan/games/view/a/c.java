package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d WT = f.WQ().WT();
        return WT != null && WT.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d WT = f.WQ().WT();
        return WT != null && WT.b(view, aVar);
    }

    public static boolean au(View view) {
        d WT = f.WQ().WT();
        return WT != null && WT.au(view);
    }

    public static boolean ay(View view) {
        d WT = f.WQ().WT();
        return WT != null && WT.ax(view);
    }

    public static boolean isLandScape() {
        d WT = f.WQ().WT();
        return WT != null && WT.isLandScape();
    }

    public static int aqx() {
        return ((Integer) f.WQ().WE().first).intValue();
    }

    public static int aqy() {
        return ((Integer) f.WQ().WE().second).intValue();
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d WT = f.WQ().WT();
        if (WT != null) {
            WT.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d WT = f.WQ().WT();
        if (WT != null) {
            WT.b(aVar);
        }
    }
}
