package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes7.dex */
public class b {
    public static void cH(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.arv() != null && e.arv().Se() != null) {
            b.a Se = e.arv().Se();
            aVar.mFrom = h.ho(Se.getAppFrameType());
            aVar.mAppId = Se.getAppId();
            aVar.mSource = Se.ajg();
        }
        h.a("916", "68", aVar);
    }

    public static void R(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.arv() != null && e.arv().Se() != null) {
            b.a Se = e.arv().Se();
            aVar.mFrom = h.ho(Se.getAppFrameType());
            aVar.mAppId = Se.getAppId();
            aVar.mSource = Se.ajg();
        }
        aVar.mErrorCode = str3;
        h.a("916", "68", aVar);
    }

    public static void f(String str, String str2, long j) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.arv() != null && e.arv().Se() != null) {
            b.a Se = e.arv().Se();
            aVar.mFrom = h.ho(Se.getAppFrameType());
            aVar.mAppId = Se.getAppId();
            aVar.mSource = Se.ajg();
            aVar.v("play_time", Long.valueOf(j));
        }
        h.a("916", "68", aVar);
    }

    public static void tT(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.arv() != null && e.arv().Se() != null) {
            b.a Se = e.arv().Se();
            aVar.mFrom = h.ho(Se.getAppFrameType());
            aVar.mAppId = Se.getAppId();
            aVar.mSource = Se.ajg();
        }
        aVar.v("early", aHC() ? "0" : "1");
        h.a("916", "68", aVar);
    }

    private static boolean aHC() {
        return d.aGz() > 0 && com.baidu.swan.games.glsurface.a.b.aFm() && System.currentTimeMillis() - d.aGz() > 6000;
    }
}
