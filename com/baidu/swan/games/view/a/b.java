package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.games.u.d;
/* loaded from: classes11.dex */
public class b {
    public static void bW(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.acI() != null && e.acI().GJ() != null) {
            b.a GJ = e.acI().GJ();
            aVar.mFrom = f.gs(GJ.getAppFrameType());
            aVar.mAppId = GJ.getAppId();
            aVar.mSource = GJ.VM();
        }
        f.a("916", aVar);
    }

    public static void N(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.acI() != null && e.acI().GJ() != null) {
            b.a GJ = e.acI().GJ();
            aVar.mFrom = f.gs(GJ.getAppFrameType());
            aVar.mAppId = GJ.getAppId();
            aVar.mSource = GJ.VM();
        }
        aVar.mErrorCode = str3;
        f.a("916", aVar);
    }

    public static void pR(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.acI() != null && e.acI().GJ() != null) {
            b.a GJ = e.acI().GJ();
            aVar.mFrom = f.gs(GJ.getAppFrameType());
            aVar.mAppId = GJ.getAppId();
            aVar.mSource = GJ.VM();
        }
        aVar.n("early", aqB() ? "0" : "1");
        f.a("916", aVar);
    }

    private static boolean aqB() {
        return d.apJ() > 0 && com.baidu.swan.games.glsurface.a.b.aox() && System.currentTimeMillis() - d.apJ() > 6000;
    }
}
