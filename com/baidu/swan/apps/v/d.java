package com.baidu.swan.apps.v;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar, PMSAppInfo pMSAppInfo, String str) {
        int a = a(cVar, pMSAppInfo);
        if (a != 0 || pMSAppInfo == null) {
            com.baidu.swan.apps.ak.a cT = cT(a);
            e.TR().b(cT);
            b(context, cVar, cT);
            b.Km().Ko();
            return;
        }
        c(context, a(pMSAppInfo, cVar), str);
    }

    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar, String str) {
        com.baidu.swan.apps.v.b.b a = a(cVar);
        if (a == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.ak.a().ar(10L).as(2902L).iL("no aiapps info in database");
                e.TR().b(aVar);
            }
            b(context, cVar, aVar);
            b.Km().Ko();
            return;
        }
        PMSAppInfo KV = a.KV();
        if (KV != null && !TextUtils.isEmpty(KV.appId) && !TextUtils.isEmpty(KV.iconUrl)) {
            com.baidu.swan.apps.core.a.c.c(KV.appId, KV.iconUrl, String.valueOf(KV.versionCode), KV.bLd);
        }
        c(context, a, str);
        com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(aVar).c(cVar));
    }

    private static com.baidu.swan.apps.v.b.b a(com.baidu.swan.apps.v.b.c cVar) {
        PMSAppInfo kT;
        if (cVar == null || (kT = com.baidu.swan.pms.database.a.aaV().kT(cVar.mAppId)) == null || TextUtils.isEmpty(kT.appId)) {
            return null;
        }
        return a(kT, cVar);
    }

    private static void c(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        if (bVar.Kw() == 0) {
            b(context, bVar, str);
            return;
        }
        b.Km().Ko();
        a(context, bVar);
    }

    private static void b(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        SwanAppLauncherActivity.a(context, bVar, str);
    }

    public static void a(Context context, com.baidu.swan.apps.v.b.b bVar) {
        Intent c = com.baidu.swan.apps.v.b.b.c(context, bVar);
        if (c != null) {
            c.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            context.startActivity(c);
            new com.baidu.swan.apps.ak.a().ar(2L).as(35L).iL("app has been offline");
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.eL(bVar.KP());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.t(bVar);
            fVar.h("status", "2");
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
        }
    }

    private static int a(com.baidu.swan.apps.v.b.c cVar, PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId)) {
            return 1;
        }
        if ((cVar.aST == 0 && pMSAppInfo.bLd != 0) || (cVar.aST == 1 && pMSAppInfo.bLd != 1)) {
            return 2;
        }
        return 0;
    }

    private static com.baidu.swan.apps.ak.a cT(int i) {
        com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
        switch (i) {
            case 1:
                aVar.ar(10L).as(2902L).iL("no aiapps info in database");
                break;
            case 2:
                aVar.ar(10L).as(27L).iL("category not match");
                break;
        }
        return aVar;
    }

    private static void b(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar) {
        if (cVar == null) {
            if (DEBUG) {
                Log.e("SwanAppLoader", "Fatal: launchparams is null");
            }
        } else if ((context instanceof SwanAppLauncherActivity) && SwanAppLauncherActivity.aG(context)) {
            if (DEBUG) {
                Log.d("SwanAppLoader", "launcher activity closed, ignore launch err");
            }
        } else {
            com.baidu.swan.apps.v.a.c cVar2 = new com.baidu.swan.apps.v.a.c();
            cVar2.mAppId = cVar.mAppId;
            com.baidu.swan.apps.v.a.a.a(context, aVar, cVar.aST, cVar2);
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.eL(cVar.aST);
            fVar.d(cVar);
            fVar.mType = Config.LAUNCH;
            fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
            fVar.h("errcode", String.valueOf(aVar.TN()));
            fVar.h("msg", aVar.TM().toString());
            fVar.aJ(com.baidu.swan.apps.statistic.e.hY(cVar.aSQ));
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
            if (!aVar.TO()) {
                com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().ia(com.baidu.swan.apps.statistic.e.eL(cVar.aST)).a(aVar).ib(cVar.mAppId).ic(cVar.mFrom));
                aVar.TP();
            }
        }
    }

    private static com.baidu.swan.apps.v.b.b a(PMSAppInfo pMSAppInfo, com.baidu.swan.apps.v.b.c cVar) {
        if (pMSAppInfo == null) {
            return null;
        }
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        bVar.e(pMSAppInfo);
        bVar.fv(cVar.mFrom);
        bVar.setPage(cVar.aSM);
        bVar.setDebug(cVar.aSN);
        bVar.p(cVar.Kt());
        bVar.fw(cVar.aSQ);
        bVar.fA(cVar.aSR);
        bVar.a(cVar.aNK);
        bVar.a(cVar.aNL);
        bVar.fz(cVar.aSP);
        bVar.dB(cVar.aSG);
        if (pMSAppInfo.bLd == 1) {
            bVar.m19do(1);
            return bVar;
        }
        bVar.m19do(0);
        return bVar;
    }
}
