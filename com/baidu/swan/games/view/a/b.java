package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes8.dex */
public class b {
    public static void dr(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aIr() != null && e.aIr().afB() != null) {
            b.a afB = e.aIr().afB();
            aVar.mFrom = h.jr(afB.getAppFrameType());
            aVar.mAppId = afB.getAppId();
            aVar.mSource = afB.ayC();
        }
        h.a("916", "68", aVar);
    }

    public static void ah(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aIr() != null && e.aIr().afB() != null) {
            b.a afB = e.aIr().afB();
            aVar.mFrom = h.jr(afB.getAppFrameType());
            aVar.mAppId = afB.getAppId();
            aVar.mSource = afB.ayC();
        }
        aVar.mErrorCode = str3;
        h.a("916", "68", aVar);
    }

    public static void h(String str, String str2, long j) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aIr() != null && e.aIr().afB() != null) {
            b.a afB = e.aIr().afB();
            aVar.mFrom = h.jr(afB.getAppFrameType());
            aVar.mAppId = afB.getAppId();
            aVar.mSource = afB.ayC();
            aVar.t("play_time", Long.valueOf(j));
        }
        h.a("916", "68", aVar);
    }

    public static void xm(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.aIr() != null && e.aIr().afB() != null) {
            b.a afB = e.aIr().afB();
            aVar.mFrom = h.jr(afB.getAppFrameType());
            aVar.mAppId = afB.getAppId();
            aVar.mSource = afB.ayC();
        }
        aVar.t("early", aZd() ? "0" : "1");
        h.a("916", "68", aVar);
    }

    private static boolean aZd() {
        return d.aYc() > 0 && com.baidu.swan.games.glsurface.a.b.aWN() && System.currentTimeMillis() - d.aYc() > 6000;
    }
}
