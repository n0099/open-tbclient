package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.d;
/* loaded from: classes7.dex */
public class c {
    private static int dnU = com.baidu.swan.apps.t.a.ahm().SG();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d akv = f.akr().akv();
        return akv != null && akv.a(view, aVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        d akv = f.akr().akv();
        return akv != null && akv.b(view, aVar);
    }

    public static boolean ay(View view) {
        d akv = f.akr().akv();
        if (akv == null) {
            return false;
        }
        if (akv.aHw()) {
            SwanAppActivity akb = f.akr().akb();
            if (akb != null) {
                akb.setRequestedOrientation(0);
            }
            akv.gt(false);
        }
        return akv.ay(view);
    }

    public static boolean aD(View view) {
        d akv = f.akr().akv();
        return akv != null && akv.aC(view);
    }

    public static boolean isLandScape() {
        d akv = f.akr().akv();
        return (akv == null || !akv.isLandScape() || akv.aHw()) ? false : true;
    }

    public static int aHD() {
        return ((Integer) f.akr().ake().first).intValue();
    }

    public static int aHE() {
        return ((Integer) f.akr().ake().second).intValue();
    }

    public static boolean aHF() {
        return dnU == 3;
    }

    public static boolean aHG() {
        return dnU == 2;
    }

    public static void a(com.baidu.swan.games.view.a aVar) {
        d akv = f.akr().akv();
        if (akv != null) {
            akv.a(aVar);
        }
    }

    public static void b(com.baidu.swan.games.view.a aVar) {
        d akv = f.akr().akv();
        if (akv != null) {
            akv.b(aVar);
        }
    }
}
