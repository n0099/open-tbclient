package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes3.dex */
public class b {
    public static void db(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aAr() != null && e.aAr().YI() != null) {
            b.a YI = e.aAr().YI();
            aVar.mFrom = h.jG(YI.getAppFrameType());
            aVar.mAppId = YI.getAppId();
            aVar.mSource = YI.arx();
        }
        h.a("916", "68", aVar);
    }

    public static void U(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aAr() != null && e.aAr().YI() != null) {
            b.a YI = e.aAr().YI();
            aVar.mFrom = h.jG(YI.getAppFrameType());
            aVar.mAppId = YI.getAppId();
            aVar.mSource = YI.arx();
        }
        aVar.mErrorCode = str3;
        h.a("916", "68", aVar);
    }

    public static void f(String str, String str2, long j) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aAr() != null && e.aAr().YI() != null) {
            b.a YI = e.aAr().YI();
            aVar.mFrom = h.jG(YI.getAppFrameType());
            aVar.mAppId = YI.getAppId();
            aVar.mSource = YI.arx();
            aVar.u("play_time", Long.valueOf(j));
        }
        h.a("916", "68", aVar);
    }

    public static void wD(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.aAr() != null && e.aAr().YI() != null) {
            b.a YI = e.aAr().YI();
            aVar.mFrom = h.jG(YI.getAppFrameType());
            aVar.mAppId = YI.getAppId();
            aVar.mSource = YI.arx();
        }
        aVar.u("early", aRe() ? "0" : "1");
        h.a("916", "68", aVar);
    }

    private static boolean aRe() {
        return d.aQb() > 0 && com.baidu.swan.games.glsurface.a.b.aOM() && System.currentTimeMillis() - d.aQb() > 6000;
    }
}
