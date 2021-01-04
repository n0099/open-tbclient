package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes9.dex */
public class b {
    public static void ds(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aMk() != null && e.aMk().aju() != null) {
            b.a aju = e.aMk().aju();
            aVar.mFrom = h.kX(aju.getAppFrameType());
            aVar.mAppId = aju.getAppId();
            aVar.mSource = aju.aCv();
        }
        h.a("916", "68", aVar);
    }

    public static void ai(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aMk() != null && e.aMk().aju() != null) {
            b.a aju = e.aMk().aju();
            aVar.mFrom = h.kX(aju.getAppFrameType());
            aVar.mAppId = aju.getAppId();
            aVar.mSource = aju.aCv();
        }
        aVar.mErrorCode = str3;
        h.a("916", "68", aVar);
    }

    public static void h(String str, String str2, long j) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aMk() != null && e.aMk().aju() != null) {
            b.a aju = e.aMk().aju();
            aVar.mFrom = h.kX(aju.getAppFrameType());
            aVar.mAppId = aju.getAppId();
            aVar.mSource = aju.aCv();
            aVar.t("play_time", Long.valueOf(j));
        }
        h.a("916", "68", aVar);
    }

    public static void yx(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.aMk() != null && e.aMk().aju() != null) {
            b.a aju = e.aMk().aju();
            aVar.mFrom = h.kX(aju.getAppFrameType());
            aVar.mAppId = aju.getAppId();
            aVar.mSource = aju.aCv();
        }
        aVar.t("early", bcW() ? "0" : "1");
        h.a("916", "68", aVar);
    }

    private static boolean bcW() {
        return d.bbV() > 0 && com.baidu.swan.games.glsurface.a.b.baG() && System.currentTimeMillis() - d.bbV() > 6000;
    }
}
