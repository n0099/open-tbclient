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
        if (e.aMl() != null && e.aMl().ajv() != null) {
            b.a ajv = e.aMl().ajv();
            aVar.mFrom = h.kX(ajv.getAppFrameType());
            aVar.mAppId = ajv.getAppId();
            aVar.mSource = ajv.aCw();
        }
        h.a("916", "68", aVar);
    }

    public static void ai(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aMl() != null && e.aMl().ajv() != null) {
            b.a ajv = e.aMl().ajv();
            aVar.mFrom = h.kX(ajv.getAppFrameType());
            aVar.mAppId = ajv.getAppId();
            aVar.mSource = ajv.aCw();
        }
        aVar.mErrorCode = str3;
        h.a("916", "68", aVar);
    }

    public static void h(String str, String str2, long j) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aMl() != null && e.aMl().ajv() != null) {
            b.a ajv = e.aMl().ajv();
            aVar.mFrom = h.kX(ajv.getAppFrameType());
            aVar.mAppId = ajv.getAppId();
            aVar.mSource = ajv.aCw();
            aVar.t("play_time", Long.valueOf(j));
        }
        h.a("916", "68", aVar);
    }

    public static void yx(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.aMl() != null && e.aMl().ajv() != null) {
            b.a ajv = e.aMl().ajv();
            aVar.mFrom = h.kX(ajv.getAppFrameType());
            aVar.mAppId = ajv.getAppId();
            aVar.mSource = ajv.aCw();
        }
        aVar.t("early", bcX() ? "0" : "1");
        h.a("916", "68", aVar);
    }

    private static boolean bcX() {
        return d.bbW() > 0 && com.baidu.swan.games.glsurface.a.b.baH() && System.currentTimeMillis() - d.bbW() > 6000;
    }
}
