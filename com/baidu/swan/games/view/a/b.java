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
        if (e.aEU() != null && e.aEU().ado() != null) {
            b.a ado = e.aEU().ado();
            aVar.mFrom = h.ko(ado.getAppFrameType());
            aVar.mAppId = ado.getAppId();
            aVar.mSource = ado.awd();
        }
        h.a("916", "68", aVar);
    }

    public static void ac(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aEU() != null && e.aEU().ado() != null) {
            b.a ado = e.aEU().ado();
            aVar.mFrom = h.ko(ado.getAppFrameType());
            aVar.mAppId = ado.getAppId();
            aVar.mSource = ado.awd();
        }
        aVar.mErrorCode = str3;
        h.a("916", "68", aVar);
    }

    public static void g(String str, String str2, long j) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aEU() != null && e.aEU().ado() != null) {
            b.a ado = e.aEU().ado();
            aVar.mFrom = h.ko(ado.getAppFrameType());
            aVar.mAppId = ado.getAppId();
            aVar.mSource = ado.awd();
            aVar.u("play_time", Long.valueOf(j));
        }
        h.a("916", "68", aVar);
    }

    public static void xI(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.aEU() != null && e.aEU().ado() != null) {
            b.a ado = e.aEU().ado();
            aVar.mFrom = h.ko(ado.getAppFrameType());
            aVar.mAppId = ado.getAppId();
            aVar.mSource = ado.awd();
        }
        aVar.u("early", aVH() ? "0" : "1");
        h.a("916", "68", aVar);
    }

    private static boolean aVH() {
        return d.aUE() > 0 && com.baidu.swan.games.glsurface.a.b.aTp() && System.currentTimeMillis() - d.aUE() > 6000;
    }
}
