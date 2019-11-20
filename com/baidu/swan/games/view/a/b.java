package com.baidu.swan.games.view.a;

import android.app.Activity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.o.d;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.e;
/* loaded from: classes2.dex */
public class b {
    public static void br(String str, String str2) {
        f fVar = new f();
        fVar.mType = str;
        fVar.mValue = str2;
        if (com.baidu.swan.apps.ae.b.Ra() != null && com.baidu.swan.apps.ae.b.Ra().AK() != null) {
            com.baidu.swan.apps.v.b.b AK = com.baidu.swan.apps.ae.b.Ra().AK();
            fVar.mFrom = e.eL(AK.KP());
            fVar.mAppId = AK.getAppId();
            fVar.mSource = AK.KF();
        }
        e.a("916", fVar);
    }

    public static void kH(String str) {
        f fVar = new f();
        fVar.mType = str;
        fVar.mValue = "show";
        if (com.baidu.swan.apps.ae.b.Ra() != null && com.baidu.swan.apps.ae.b.Ra().AK() != null) {
            com.baidu.swan.apps.v.b.b AK = com.baidu.swan.apps.ae.b.Ra().AK();
            fVar.mFrom = e.eL(AK.KP());
            fVar.mAppId = AK.getAppId();
            fVar.mSource = AK.KF();
        }
        fVar.h("early", Ys() ? "0" : "1");
        e.a("916", fVar);
    }

    private static boolean Ys() {
        return Yt() > 0 && com.baidu.swan.games.glsurface.a.b.Xd() && System.currentTimeMillis() - Yt() > 6000;
    }

    private static long Yt() {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra == null) {
            return 0L;
        }
        Activity activity = Ra.getActivity();
        if (activity instanceof SwanAppActivity) {
            d AD = ((SwanAppActivity) activity).AD();
            if (AD instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) AD).WT();
            }
            return 0L;
        }
        return 0L;
    }
}
