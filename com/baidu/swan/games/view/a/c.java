package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes11.dex */
public class c {
    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d ahZ = f.ahV().ahZ();
        return ahZ != null && ahZ.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d ahZ = f.ahV().ahZ();
        return ahZ != null && ahZ.b(view, aVar);
    }

    public static boolean av(View view) {
        d ahZ = f.ahV().ahZ();
        return ahZ != null && ahZ.av(view);
    }

    public static boolean ay(View view) {
        d ahZ = f.ahV().ahZ();
        return ahZ != null && ahZ.ax(view);
    }

    public static boolean isLandScape() {
        d ahZ = f.ahV().ahZ();
        return ahZ != null && ahZ.isLandScape();
    }

    public static int aCG() {
        return ((Integer) f.ahV().ahI().first).intValue();
    }

    public static int aCH() {
        return ((Integer) f.ahV().ahI().second).intValue();
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d ahZ = f.ahV().ahZ();
        if (ahZ != null) {
            ahZ.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d ahZ = f.ahV().ahZ();
        if (ahZ != null) {
            ahZ.b(aVar);
        }
    }
}
