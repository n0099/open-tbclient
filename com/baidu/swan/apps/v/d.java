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
            com.baidu.swan.apps.ak.a bX = bX(a);
            e.Pd().b(bX);
            b(context, cVar, bX);
            b.Fr().Ft();
            return;
        }
        c(context, a(pMSAppInfo, cVar), str);
    }

    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar, String str) {
        com.baidu.swan.apps.v.b.b a = a(cVar);
        if (a == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.ak.a().Z(10L).aa(2902L).ii("no aiapps info in database");
                e.Pd().b(aVar);
            }
            b(context, cVar, aVar);
            b.Fr().Ft();
            return;
        }
        PMSAppInfo Ga = a.Ga();
        if (Ga != null && !TextUtils.isEmpty(Ga.appId) && !TextUtils.isEmpty(Ga.iconUrl)) {
            com.baidu.swan.apps.core.a.c.b(Ga.appId, Ga.iconUrl, String.valueOf(Ga.versionCode), Ga.btj);
        }
        c(context, a, str);
        com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(aVar).c(cVar));
    }

    private static com.baidu.swan.apps.v.b.b a(com.baidu.swan.apps.v.b.c cVar) {
        PMSAppInfo kr;
        if (cVar == null || (kr = com.baidu.swan.pms.database.a.Wi().kr(cVar.mAppId)) == null || TextUtils.isEmpty(kr.appId)) {
            return null;
        }
        return a(kr, cVar);
    }

    private static void c(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        if (bVar.FB() == 0) {
            b(context, bVar, str);
            return;
        }
        b.Fr().Ft();
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
            new com.baidu.swan.apps.ak.a().Z(2L).aa(35L).ii("app has been offline");
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dQ(bVar.FU());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.t(bVar);
            fVar.k("status", "2");
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
        }
    }

    private static int a(com.baidu.swan.apps.v.b.c cVar, PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId)) {
            return 1;
        }
        if ((cVar.azX == 0 && pMSAppInfo.btj != 0) || (cVar.azX == 1 && pMSAppInfo.btj != 1)) {
            return 2;
        }
        return 0;
    }

    private static com.baidu.swan.apps.ak.a bX(int i) {
        com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
        switch (i) {
            case 1:
                aVar.Z(10L).aa(2902L).ii("no aiapps info in database");
                break;
            case 2:
                aVar.Z(10L).aa(27L).ii("category not match");
                break;
        }
        return aVar;
    }

    private static void b(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar) {
        if (cVar == null) {
            if (DEBUG) {
                Log.e("SwanAppLoader", "Fatal: launchparams is null");
            }
        } else if ((context instanceof SwanAppLauncherActivity) && SwanAppLauncherActivity.aC(context)) {
            if (DEBUG) {
                Log.d("SwanAppLoader", "launcher activity closed, ignore launch err");
            }
        } else {
            com.baidu.swan.apps.v.a.c cVar2 = new com.baidu.swan.apps.v.a.c();
            cVar2.mAppId = cVar.mAppId;
            com.baidu.swan.apps.v.a.a.a(context, aVar, cVar.azX, cVar2);
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dQ(cVar.azX);
            fVar.d(cVar);
            fVar.mType = Config.LAUNCH;
            fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
            fVar.k("errcode", String.valueOf(aVar.OZ()));
            fVar.k("msg", aVar.OY().toString());
            fVar.ak(com.baidu.swan.apps.statistic.e.hv(cVar.azU));
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
            if (!aVar.Pa()) {
                com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().hx(com.baidu.swan.apps.statistic.e.dQ(cVar.azX)).a(aVar).hy(cVar.mAppId).hz(cVar.mFrom));
                aVar.Pb();
            }
        }
    }

    private static com.baidu.swan.apps.v.b.b a(PMSAppInfo pMSAppInfo, com.baidu.swan.apps.v.b.c cVar) {
        if (pMSAppInfo == null) {
            return null;
        }
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        bVar.e(pMSAppInfo);
        bVar.eO(cVar.mFrom);
        bVar.setPage(cVar.azQ);
        bVar.setDebug(cVar.azR);
        bVar.p(cVar.Fy());
        bVar.eP(cVar.azU);
        bVar.eT(cVar.azV);
        bVar.a(cVar.auL);
        bVar.a(cVar.auM);
        bVar.eS(cVar.azT);
        bVar.cG(cVar.azK);
        if (pMSAppInfo.btj == 1) {
            bVar.cs(1);
            return bVar;
        }
        bVar.cs(0);
        return bVar;
    }
}
