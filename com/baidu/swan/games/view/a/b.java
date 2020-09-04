package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes8.dex */
public class b {
    public static void db(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.azI() != null && e.azI().XZ() != null) {
            b.a XZ = e.azI().XZ();
            aVar.mFrom = h.jv(XZ.getAppFrameType());
            aVar.mAppId = XZ.getAppId();
            aVar.mSource = XZ.aqN();
        }
        h.a("916", "68", aVar);
    }

    public static void U(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.azI() != null && e.azI().XZ() != null) {
            b.a XZ = e.azI().XZ();
            aVar.mFrom = h.jv(XZ.getAppFrameType());
            aVar.mAppId = XZ.getAppId();
            aVar.mSource = XZ.aqN();
        }
        aVar.mErrorCode = str3;
        h.a("916", "68", aVar);
    }

    public static void f(String str, String str2, long j) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.azI() != null && e.azI().XZ() != null) {
            b.a XZ = e.azI().XZ();
            aVar.mFrom = h.jv(XZ.getAppFrameType());
            aVar.mAppId = XZ.getAppId();
            aVar.mSource = XZ.aqN();
            aVar.u("play_time", Long.valueOf(j));
        }
        h.a("916", "68", aVar);
    }

    public static void wk(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.azI() != null && e.azI().XZ() != null) {
            b.a XZ = e.azI().XZ();
            aVar.mFrom = h.jv(XZ.getAppFrameType());
            aVar.mAppId = XZ.getAppId();
            aVar.mSource = XZ.aqN();
        }
        aVar.u("early", aQs() ? "0" : "1");
        h.a("916", "68", aVar);
    }

    private static boolean aQs() {
        return d.aPq() > 0 && com.baidu.swan.games.glsurface.a.b.aOb() && System.currentTimeMillis() - d.aPq() > 6000;
    }
}
