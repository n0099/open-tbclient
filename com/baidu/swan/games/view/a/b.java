package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes9.dex */
public class b {
    public static void dl(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aIK() != null && e.aIK().afZ() != null) {
            b.a afZ = e.aIK().afZ();
            aVar.mFrom = h.ju(afZ.getAppFrameType());
            aVar.mAppId = afZ.getAppId();
            aVar.mSource = afZ.aza();
        }
        h.a("916", "68", aVar);
    }

    public static void ai(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aIK() != null && e.aIK().afZ() != null) {
            b.a afZ = e.aIK().afZ();
            aVar.mFrom = h.ju(afZ.getAppFrameType());
            aVar.mAppId = afZ.getAppId();
            aVar.mSource = afZ.aza();
        }
        aVar.mErrorCode = str3;
        h.a("916", "68", aVar);
    }

    public static void i(String str, String str2, long j) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aIK() != null && e.aIK().afZ() != null) {
            b.a afZ = e.aIK().afZ();
            aVar.mFrom = h.ju(afZ.getAppFrameType());
            aVar.mAppId = afZ.getAppId();
            aVar.mSource = afZ.aza();
            aVar.r("play_time", Long.valueOf(j));
        }
        h.a("916", "68", aVar);
    }

    public static void xF(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.aIK() != null && e.aIK().afZ() != null) {
            b.a afZ = e.aIK().afZ();
            aVar.mFrom = h.ju(afZ.getAppFrameType());
            aVar.mAppId = afZ.getAppId();
            aVar.mSource = afZ.aza();
        }
        aVar.r("early", aZp() ? "0" : "1");
        h.a("916", "68", aVar);
    }

    private static boolean aZp() {
        return d.aYo() > 0 && com.baidu.swan.games.glsurface.a.b.aWZ() && System.currentTimeMillis() - d.aYo() > 6000;
    }
}
