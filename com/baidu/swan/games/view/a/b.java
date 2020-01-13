package com.baidu.swan.games.view.a;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.games.u.d;
/* loaded from: classes10.dex */
public class b {
    public static void bO(String str, String str2) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aap() != null && e.aap().En() != null) {
            b.a En = e.aap().En();
            aVar.mFrom = f.gb(En.getAppFrameType());
            aVar.mAppId = En.getAppId();
            aVar.mSource = En.Tt();
        }
        f.a("916", aVar);
    }

    public static void M(String str, String str2, String str3) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = str2;
        if (e.aap() != null && e.aap().En() != null) {
            b.a En = e.aap().En();
            aVar.mFrom = f.gb(En.getAppFrameType());
            aVar.mAppId = En.getAppId();
            aVar.mSource = En.Tt();
        }
        aVar.mErrorCode = str3;
        f.a("916", aVar);
    }

    public static void pD(String str) {
        a aVar = new a();
        aVar.mType = str;
        aVar.mValue = "show";
        if (e.aap() != null && e.aap().En() != null) {
            b.a En = e.aap().En();
            aVar.mFrom = f.gb(En.getAppFrameType());
            aVar.mAppId = En.getAppId();
            aVar.mSource = En.Tt();
        }
        aVar.n("early", aoi() ? "0" : "1");
        f.a("916", aVar);
    }

    private static boolean aoi() {
        return d.anq() > 0 && com.baidu.swan.games.glsurface.a.b.amf() && System.currentTimeMillis() - d.anq() > 6000;
    }
}
