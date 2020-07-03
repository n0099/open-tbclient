package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes11.dex */
public class b {
    public static void cE(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.apM() != null && e.apM().RP() != null) {
            b.a RP = e.apM().RP();
            aVar.mFrom = h.hf(RP.getAppFrameType());
            aVar.mAppId = RP.getAppId();
            aVar.mSource = RP.ahQ();
        }
        h.a("916", aVar);
    }

    public static void R(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.apM() != null && e.apM().RP() != null) {
            b.a RP = e.apM().RP();
            aVar.mFrom = h.hf(RP.getAppFrameType());
            aVar.mAppId = RP.getAppId();
            aVar.mSource = RP.ahQ();
        }
        aVar.mErrorCode = str3;
        h.a("916", aVar);
    }

    public static void sQ(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.apM() != null && e.apM().RP() != null) {
            b.a RP = e.apM().RP();
            aVar.mFrom = h.hf(RP.getAppFrameType());
            aVar.mAppId = RP.getAppId();
            aVar.mSource = RP.ahQ();
        }
        aVar.v("early", aDL() ? "0" : "1");
        h.a("916", aVar);
    }

    private static boolean aDL() {
        return d.aCS() > 0 && com.baidu.swan.games.glsurface.a.b.aBF() && System.currentTimeMillis() - d.aCS() > 6000;
    }
}
