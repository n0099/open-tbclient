package com.baidu.swan.games.view.a;

import android.app.Activity;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.o.d;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.e;
/* loaded from: classes2.dex */
public class b {
    public static void bk(String str, String str2) {
        f fVar = new f();
        fVar.mType = str;
        fVar.mValue = str2;
        if (com.baidu.swan.apps.ae.b.Mh() != null && com.baidu.swan.apps.ae.b.Mh().vP() != null) {
            com.baidu.swan.apps.v.b.b vP = com.baidu.swan.apps.ae.b.Mh().vP();
            fVar.mFrom = e.dQ(vP.FU());
            fVar.mAppId = vP.getAppId();
            fVar.mSource = vP.FK();
        }
        e.a("916", fVar);
    }

    public static void kf(String str) {
        f fVar = new f();
        fVar.mType = str;
        fVar.mValue = SmsLoginView.StatEvent.LOGIN_SHOW;
        if (com.baidu.swan.apps.ae.b.Mh() != null && com.baidu.swan.apps.ae.b.Mh().vP() != null) {
            com.baidu.swan.apps.v.b.b vP = com.baidu.swan.apps.ae.b.Mh().vP();
            fVar.mFrom = e.dQ(vP.FU());
            fVar.mAppId = vP.getAppId();
            fVar.mSource = vP.FK();
        }
        fVar.k("early", TD() ? "0" : "1");
        e.a("916", fVar);
    }

    private static boolean TD() {
        return TE() > 0 && com.baidu.swan.games.glsurface.a.b.So() && System.currentTimeMillis() - TE() > 6000;
    }

    private static long TE() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh == null) {
            return 0L;
        }
        Activity activity = Mh.getActivity();
        if (activity instanceof SwanAppActivity) {
            d vI = ((SwanAppActivity) activity).vI();
            if (vI instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) vI).Se();
            }
            return 0L;
        }
        return 0L;
    }
}
