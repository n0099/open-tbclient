package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes7.dex */
public class b {
    public static void dm(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aGM() != null && e.aGM().afg() != null) {
            b.a afg = e.aGM().afg();
            aVar.mFrom = h.ku(afg.getAppFrameType());
            aVar.mAppId = afg.getAppId();
            aVar.mSource = afg.axV();
        }
        h.a("916", "68", aVar);
    }

    public static void ac(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aGM() != null && e.aGM().afg() != null) {
            b.a afg = e.aGM().afg();
            aVar.mFrom = h.ku(afg.getAppFrameType());
            aVar.mAppId = afg.getAppId();
            aVar.mSource = afg.axV();
        }
        aVar.mErrorCode = str3;
        h.a("916", "68", aVar);
    }

    public static void g(String str, String str2, long j) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aGM() != null && e.aGM().afg() != null) {
            b.a afg = e.aGM().afg();
            aVar.mFrom = h.ku(afg.getAppFrameType());
            aVar.mAppId = afg.getAppId();
            aVar.mSource = afg.axV();
            aVar.u("play_time", Long.valueOf(j));
        }
        h.a("916", "68", aVar);
    }

    public static void xR(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.aGM() != null && e.aGM().afg() != null) {
            b.a afg = e.aGM().afg();
            aVar.mFrom = h.ku(afg.getAppFrameType());
            aVar.mAppId = afg.getAppId();
            aVar.mSource = afg.axV();
        }
        aVar.u("early", aXz() ? "0" : "1");
        h.a("916", "68", aVar);
    }

    private static boolean aXz() {
        return d.aWw() > 0 && com.baidu.swan.games.glsurface.a.b.aVh() && System.currentTimeMillis() - d.aWw() > 6000;
    }
}
