package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes10.dex */
public class b {
    public static void dg(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aDa() != null && e.aDa().abu() != null) {
            b.a abu = e.aDa().abu();
            aVar.mFrom = h.kd(abu.getAppFrameType());
            aVar.mAppId = abu.getAppId();
            aVar.mSource = abu.auj();
        }
        h.a("916", "68", aVar);
    }

    public static void V(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aDa() != null && e.aDa().abu() != null) {
            b.a abu = e.aDa().abu();
            aVar.mFrom = h.kd(abu.getAppFrameType());
            aVar.mAppId = abu.getAppId();
            aVar.mSource = abu.auj();
        }
        aVar.mErrorCode = str3;
        h.a("916", "68", aVar);
    }

    public static void g(String str, String str2, long j) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aDa() != null && e.aDa().abu() != null) {
            b.a abu = e.aDa().abu();
            aVar.mFrom = h.kd(abu.getAppFrameType());
            aVar.mAppId = abu.getAppId();
            aVar.mSource = abu.auj();
            aVar.u("play_time", Long.valueOf(j));
        }
        h.a("916", "68", aVar);
    }

    public static void xp(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.aDa() != null && e.aDa().abu() != null) {
            b.a abu = e.aDa().abu();
            aVar.mFrom = h.kd(abu.getAppFrameType());
            aVar.mAppId = abu.getAppId();
            aVar.mSource = abu.auj();
        }
        aVar.u("early", aTN() ? "0" : "1");
        h.a("916", "68", aVar);
    }

    private static boolean aTN() {
        return d.aSK() > 0 && com.baidu.swan.games.glsurface.a.b.aRv() && System.currentTimeMillis() - d.aSK() > 6000;
    }
}
