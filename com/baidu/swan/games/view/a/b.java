package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.games.u.d;
/* loaded from: classes11.dex */
public class b {
    public static void bX(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.acF() != null && e.acF().GE() != null) {
            b.a GE = e.acF().GE();
            aVar.mFrom = f.gs(GE.getAppFrameType());
            aVar.mAppId = GE.getAppId();
            aVar.mSource = GE.VJ();
        }
        f.a("916", aVar);
    }

    public static void N(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.acF() != null && e.acF().GE() != null) {
            b.a GE = e.acF().GE();
            aVar.mFrom = f.gs(GE.getAppFrameType());
            aVar.mAppId = GE.getAppId();
            aVar.mSource = GE.VJ();
        }
        aVar.mErrorCode = str3;
        f.a("916", aVar);
    }

    public static void pS(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.acF() != null && e.acF().GE() != null) {
            b.a GE = e.acF().GE();
            aVar.mFrom = f.gs(GE.getAppFrameType());
            aVar.mAppId = GE.getAppId();
            aVar.mSource = GE.VJ();
        }
        aVar.n("early", aqy() ? "0" : "1");
        f.a("916", aVar);
    }

    private static boolean aqy() {
        return d.apG() > 0 && com.baidu.swan.games.glsurface.a.b.aou() && System.currentTimeMillis() - d.apG() > 6000;
    }
}
