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
        if (com.baidu.swan.apps.ae.b.Md() != null && com.baidu.swan.apps.ae.b.Md().vL() != null) {
            com.baidu.swan.apps.v.b.b vL = com.baidu.swan.apps.ae.b.Md().vL();
            fVar.mFrom = e.dP(vL.FQ());
            fVar.mAppId = vL.getAppId();
            fVar.mSource = vL.FG();
        }
        e.a("916", fVar);
    }

    public static void kd(String str) {
        f fVar = new f();
        fVar.mType = str;
        fVar.mValue = SmsLoginView.StatEvent.LOGIN_SHOW;
        if (com.baidu.swan.apps.ae.b.Md() != null && com.baidu.swan.apps.ae.b.Md().vL() != null) {
            com.baidu.swan.apps.v.b.b vL = com.baidu.swan.apps.ae.b.Md().vL();
            fVar.mFrom = e.dP(vL.FQ());
            fVar.mAppId = vL.getAppId();
            fVar.mSource = vL.FG();
        }
        fVar.k("early", Tz() ? "0" : "1");
        e.a("916", fVar);
    }

    private static boolean Tz() {
        return TA() > 0 && com.baidu.swan.games.glsurface.a.b.Sk() && System.currentTimeMillis() - TA() > 6000;
    }

    private static long TA() {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md == null) {
            return 0L;
        }
        Activity activity = Md.getActivity();
        if (activity instanceof SwanAppActivity) {
            d vE = ((SwanAppActivity) activity).vE();
            if (vE instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) vE).Sa();
            }
            return 0L;
        }
        return 0L;
    }
}
