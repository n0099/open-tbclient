package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes8.dex */
public class b {
    public static void dl(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aIN() != null && e.aIN().agc() != null) {
            b.a agc = e.aIN().agc();
            aVar.mFrom = h.jv(agc.getAppFrameType());
            aVar.mAppId = agc.getAppId();
            aVar.mSource = agc.azd();
        }
        h.a("916", "68", aVar);
    }

    public static void ai(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aIN() != null && e.aIN().agc() != null) {
            b.a agc = e.aIN().agc();
            aVar.mFrom = h.jv(agc.getAppFrameType());
            aVar.mAppId = agc.getAppId();
            aVar.mSource = agc.azd();
        }
        aVar.mErrorCode = str3;
        h.a("916", "68", aVar);
    }

    public static void i(String str, String str2, long j) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aIN() != null && e.aIN().agc() != null) {
            b.a agc = e.aIN().agc();
            aVar.mFrom = h.jv(agc.getAppFrameType());
            aVar.mAppId = agc.getAppId();
            aVar.mSource = agc.azd();
            aVar.s("play_time", Long.valueOf(j));
        }
        h.a("916", "68", aVar);
    }

    public static void xM(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.aIN() != null && e.aIN().agc() != null) {
            b.a agc = e.aIN().agc();
            aVar.mFrom = h.jv(agc.getAppFrameType());
            aVar.mAppId = agc.getAppId();
            aVar.mSource = agc.azd();
        }
        aVar.s("early", aZs() ? "0" : "1");
        h.a("916", "68", aVar);
    }

    private static boolean aZs() {
        return d.aYr() > 0 && com.baidu.swan.games.glsurface.a.b.aXc() && System.currentTimeMillis() - d.aYr() > 6000;
    }
}
