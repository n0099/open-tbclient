package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes10.dex */
public class b {
    public static void dn(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aHu() != null && e.aHu().afO() != null) {
            b.a afO = e.aHu().afO();
            aVar.mFrom = h.ky(afO.getAppFrameType());
            aVar.mAppId = afO.getAppId();
            aVar.mSource = afO.ayD();
        }
        h.a("916", "68", aVar);
    }

    public static void ac(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aHu() != null && e.aHu().afO() != null) {
            b.a afO = e.aHu().afO();
            aVar.mFrom = h.ky(afO.getAppFrameType());
            aVar.mAppId = afO.getAppId();
            aVar.mSource = afO.ayD();
        }
        aVar.mErrorCode = str3;
        h.a("916", "68", aVar);
    }

    public static void g(String str, String str2, long j) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aHu() != null && e.aHu().afO() != null) {
            b.a afO = e.aHu().afO();
            aVar.mFrom = h.ky(afO.getAppFrameType());
            aVar.mAppId = afO.getAppId();
            aVar.mSource = afO.ayD();
            aVar.u("play_time", Long.valueOf(j));
        }
        h.a("916", "68", aVar);
    }

    public static void xW(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.aHu() != null && e.aHu().afO() != null) {
            b.a afO = e.aHu().afO();
            aVar.mFrom = h.ky(afO.getAppFrameType());
            aVar.mAppId = afO.getAppId();
            aVar.mSource = afO.ayD();
        }
        aVar.u("early", aYh() ? "0" : "1");
        h.a("916", "68", aVar);
    }

    private static boolean aYh() {
        return d.aXe() > 0 && com.baidu.swan.games.glsurface.a.b.aVP() && System.currentTimeMillis() - d.aXe() > 6000;
    }
}
