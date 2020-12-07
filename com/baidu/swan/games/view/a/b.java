package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes25.dex */
public class b {
    public static void dt(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aJU() != null && e.aJU().aio() != null) {
            b.a aio = e.aJU().aio();
            aVar.mFrom = h.kS(aio.getAppFrameType());
            aVar.mAppId = aio.getAppId();
            aVar.mSource = aio.aBe();
        }
        h.a("916", "68", aVar);
    }

    public static void af(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aJU() != null && e.aJU().aio() != null) {
            b.a aio = e.aJU().aio();
            aVar.mFrom = h.kS(aio.getAppFrameType());
            aVar.mAppId = aio.getAppId();
            aVar.mSource = aio.aBe();
        }
        aVar.mErrorCode = str3;
        h.a("916", "68", aVar);
    }

    public static void g(String str, String str2, long j) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aJU() != null && e.aJU().aio() != null) {
            b.a aio = e.aJU().aio();
            aVar.mFrom = h.kS(aio.getAppFrameType());
            aVar.mAppId = aio.getAppId();
            aVar.mSource = aio.aBe();
            aVar.t("play_time", Long.valueOf(j));
        }
        h.a("916", "68", aVar);
    }

    public static void yy(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.aJU() != null && e.aJU().aio() != null) {
            b.a aio = e.aJU().aio();
            aVar.mFrom = h.kS(aio.getAppFrameType());
            aVar.mAppId = aio.getAppId();
            aVar.mSource = aio.aBe();
        }
        aVar.t("early", baE() ? "0" : "1");
        h.a("916", "68", aVar);
    }

    private static boolean baE() {
        return d.aZB() > 0 && com.baidu.swan.games.glsurface.a.b.aYm() && System.currentTimeMillis() - d.aZB() > 6000;
    }
}
