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
        if (com.baidu.swan.apps.ae.b.Lq() != null && com.baidu.swan.apps.ae.b.Lq().vk() != null) {
            com.baidu.swan.apps.v.b.b vk = com.baidu.swan.apps.ae.b.Lq().vk();
            fVar.mFrom = e.dM(vk.Fg());
            fVar.mAppId = vk.getAppId();
            fVar.mSource = vk.EW();
        }
        e.a("916", fVar);
    }

    public static void jW(String str) {
        f fVar = new f();
        fVar.mType = str;
        fVar.mValue = SmsLoginView.StatEvent.LOGIN_SHOW;
        if (com.baidu.swan.apps.ae.b.Lq() != null && com.baidu.swan.apps.ae.b.Lq().vk() != null) {
            com.baidu.swan.apps.v.b.b vk = com.baidu.swan.apps.ae.b.Lq().vk();
            fVar.mFrom = e.dM(vk.Fg());
            fVar.mAppId = vk.getAppId();
            fVar.mSource = vk.EW();
        }
        fVar.k("early", SG() ? "0" : "1");
        e.a("916", fVar);
    }

    private static boolean SG() {
        return SH() > 0 && com.baidu.swan.games.glsurface.a.b.Rr() && System.currentTimeMillis() - SH() > 6000;
    }

    private static long SH() {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq == null) {
            return 0L;
        }
        Activity activity = Lq.getActivity();
        if (activity instanceof SwanAppActivity) {
            d vd = ((SwanAppActivity) activity).vd();
            if (vd instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) vd).Rh();
            }
            return 0L;
        }
        return 0L;
    }
}
