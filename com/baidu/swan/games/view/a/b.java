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
        if (com.baidu.swan.apps.ae.b.QZ() != null && com.baidu.swan.apps.ae.b.QZ().AJ() != null) {
            com.baidu.swan.apps.v.b.b AJ = com.baidu.swan.apps.ae.b.QZ().AJ();
            fVar.mFrom = e.eL(AJ.KO());
            fVar.mAppId = AJ.getAppId();
            fVar.mSource = AJ.KE();
        }
        e.a("916", fVar);
    }

    public static void kH(String str) {
        f fVar = new f();
        fVar.mType = str;
        fVar.mValue = "show";
        if (com.baidu.swan.apps.ae.b.QZ() != null && com.baidu.swan.apps.ae.b.QZ().AJ() != null) {
            com.baidu.swan.apps.v.b.b AJ = com.baidu.swan.apps.ae.b.QZ().AJ();
            fVar.mFrom = e.eL(AJ.KO());
            fVar.mAppId = AJ.getAppId();
            fVar.mSource = AJ.KE();
        }
        fVar.h("early", Yu() ? "0" : "1");
        e.a("916", fVar);
    }

    private static boolean Yu() {
        return Yv() > 0 && com.baidu.swan.games.glsurface.a.b.Xf() && System.currentTimeMillis() - Yv() > 6000;
    }

    private static long Yv() {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ == null) {
            return 0L;
        }
        Activity activity = QZ.getActivity();
        if (activity instanceof SwanAppActivity) {
            d AC = ((SwanAppActivity) activity).AC();
            if (AC instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) AC).WV();
            }
            return 0L;
        }
        return 0L;
    }
}
