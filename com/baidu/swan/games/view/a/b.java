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
        if (e.acD() != null && e.acD().GC() != null) {
            b.a GC = e.acD().GC();
            aVar.mFrom = f.gs(GC.getAppFrameType());
            aVar.mAppId = GC.getAppId();
            aVar.mSource = GC.VH();
        }
        f.a("916", aVar);
    }

    public static void N(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.acD() != null && e.acD().GC() != null) {
            b.a GC = e.acD().GC();
            aVar.mFrom = f.gs(GC.getAppFrameType());
            aVar.mAppId = GC.getAppId();
            aVar.mSource = GC.VH();
        }
        aVar.mErrorCode = str3;
        f.a("916", aVar);
    }

    public static void pS(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.acD() != null && e.acD().GC() != null) {
            b.a GC = e.acD().GC();
            aVar.mFrom = f.gs(GC.getAppFrameType());
            aVar.mAppId = GC.getAppId();
            aVar.mSource = GC.VH();
        }
        aVar.n("early", aqw() ? "0" : "1");
        f.a("916", aVar);
    }

    private static boolean aqw() {
        return d.apE() > 0 && com.baidu.swan.games.glsurface.a.b.aos() && System.currentTimeMillis() - d.apE() > 6000;
    }
}
