package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.games.u.d;
/* loaded from: classes11.dex */
public class b {
    public static void ch(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.akM() != null && e.akM().Ov() != null) {
            b.a Ov = e.akM().Ov();
            aVar.mFrom = f.gz(Ov.getAppFrameType());
            aVar.mAppId = Ov.getAppId();
            aVar.mSource = Ov.adA();
        }
        f.a("916", aVar);
    }

    public static void N(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.akM() != null && e.akM().Ov() != null) {
            b.a Ov = e.akM().Ov();
            aVar.mFrom = f.gz(Ov.getAppFrameType());
            aVar.mAppId = Ov.getAppId();
            aVar.mSource = Ov.adA();
        }
        aVar.mErrorCode = str3;
        f.a("916", aVar);
    }

    public static void re(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.akM() != null && e.akM().Ov() != null) {
            b.a Ov = e.akM().Ov();
            aVar.mFrom = f.gz(Ov.getAppFrameType());
            aVar.mAppId = Ov.getAppId();
            aVar.mSource = Ov.adA();
        }
        aVar.s("early", ayN() ? "0" : "1");
        f.a("916", aVar);
    }

    private static boolean ayN() {
        return d.axV() > 0 && com.baidu.swan.games.glsurface.a.b.awK() && System.currentTimeMillis() - d.axV() > 6000;
    }
}
