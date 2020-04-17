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
        if (e.akN() != null && e.akN().Ow() != null) {
            b.a Ow = e.akN().Ow();
            aVar.mFrom = f.gz(Ow.getAppFrameType());
            aVar.mAppId = Ow.getAppId();
            aVar.mSource = Ow.adB();
        }
        f.a("916", aVar);
    }

    public static void N(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.akN() != null && e.akN().Ow() != null) {
            b.a Ow = e.akN().Ow();
            aVar.mFrom = f.gz(Ow.getAppFrameType());
            aVar.mAppId = Ow.getAppId();
            aVar.mSource = Ow.adB();
        }
        aVar.mErrorCode = str3;
        f.a("916", aVar);
    }

    public static void re(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.akN() != null && e.akN().Ow() != null) {
            b.a Ow = e.akN().Ow();
            aVar.mFrom = f.gz(Ow.getAppFrameType());
            aVar.mAppId = Ow.getAppId();
            aVar.mSource = Ow.adB();
        }
        aVar.s("early", ayN() ? "0" : "1");
        f.a("916", aVar);
    }

    private static boolean ayN() {
        return d.axV() > 0 && com.baidu.swan.games.glsurface.a.b.awK() && System.currentTimeMillis() - d.axV() > 6000;
    }
}
