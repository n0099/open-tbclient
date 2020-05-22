package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes11.dex */
public class b {
    public static void cC(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aoF() != null && e.aoF().QJ() != null) {
            b.a QJ = e.aoF().QJ();
            aVar.mFrom = h.gS(QJ.getAppFrameType());
            aVar.mAppId = QJ.getAppId();
            aVar.mSource = QJ.agK();
        }
        h.a("916", aVar);
    }

    public static void Q(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aoF() != null && e.aoF().QJ() != null) {
            b.a QJ = e.aoF().QJ();
            aVar.mFrom = h.gS(QJ.getAppFrameType());
            aVar.mAppId = QJ.getAppId();
            aVar.mSource = QJ.agK();
        }
        aVar.mErrorCode = str3;
        h.a("916", aVar);
    }

    public static void sI(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.aoF() != null && e.aoF().QJ() != null) {
            b.a QJ = e.aoF().QJ();
            aVar.mFrom = h.gS(QJ.getAppFrameType());
            aVar.mAppId = QJ.getAppId();
            aVar.mSource = QJ.agK();
        }
        aVar.v("early", aCF() ? "0" : "1");
        h.a("916", aVar);
    }

    private static boolean aCF() {
        return d.aBM() > 0 && com.baidu.swan.games.glsurface.a.b.aAz() && System.currentTimeMillis() - d.aBM() > 6000;
    }
}
