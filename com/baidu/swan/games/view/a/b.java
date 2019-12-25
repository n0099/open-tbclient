package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.games.u.d;
/* loaded from: classes9.dex */
public class b {
    public static void bN(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.ZS() != null && e.ZS().DR() != null) {
            b.a DR = e.ZS().DR();
            aVar.mFrom = f.ga(DR.getAppFrameType());
            aVar.mAppId = DR.getAppId();
            aVar.mSource = DR.SW();
        }
        f.a("916", aVar);
    }

    public static void M(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.ZS() != null && e.ZS().DR() != null) {
            b.a DR = e.ZS().DR();
            aVar.mFrom = f.ga(DR.getAppFrameType());
            aVar.mAppId = DR.getAppId();
            aVar.mSource = DR.SW();
        }
        aVar.mErrorCode = str3;
        f.a("916", aVar);
    }

    public static void pA(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.ZS() != null && e.ZS().DR() != null) {
            b.a DR = e.ZS().DR();
            aVar.mFrom = f.ga(DR.getAppFrameType());
            aVar.mAppId = DR.getAppId();
            aVar.mSource = DR.SW();
        }
        aVar.n("early", anP() ? "0" : "1");
        f.a("916", aVar);
    }

    private static boolean anP() {
        return d.amX() > 0 && com.baidu.swan.games.glsurface.a.b.alM() && System.currentTimeMillis() - d.amX() > 6000;
    }
}
