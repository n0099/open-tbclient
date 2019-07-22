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
            com.baidu.swan.apps.ak.a bW = bW(a);
            e.OZ().b(bW);
            b(context, cVar, bW);
            b.Fn().Fp();
            return;
        }
        c(context, a(pMSAppInfo, cVar), str);
    }

    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar, String str) {
        com.baidu.swan.apps.v.b.b a = a(cVar);
        if (a == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.ak.a().Z(10L).aa(2902L).ig("no aiapps info in database");
                e.OZ().b(aVar);
            }
            b(context, cVar, aVar);
            b.Fn().Fp();
            return;
        }
        PMSAppInfo FW = a.FW();
        if (FW != null && !TextUtils.isEmpty(FW.appId) && !TextUtils.isEmpty(FW.iconUrl)) {
            com.baidu.swan.apps.core.a.c.b(FW.appId, FW.iconUrl, String.valueOf(FW.versionCode), FW.bsL);
        }
        c(context, a, str);
        com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(aVar).c(cVar));
    }

    private static com.baidu.swan.apps.v.b.b a(com.baidu.swan.apps.v.b.c cVar) {
        PMSAppInfo kp;
        if (cVar == null || (kp = com.baidu.swan.pms.database.a.We().kp(cVar.mAppId)) == null || TextUtils.isEmpty(kp.appId)) {
            return null;
        }
        return a(kp, cVar);
    }

    private static void c(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        if (bVar.Fx() == 0) {
            b(context, bVar, str);
            return;
        }
        b.Fn().Fp();
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
            new com.baidu.swan.apps.ak.a().Z(2L).aa(35L).ig("app has been offline");
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dP(bVar.FQ());
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
        if ((cVar.azz == 0 && pMSAppInfo.bsL != 0) || (cVar.azz == 1 && pMSAppInfo.bsL != 1)) {
            return 2;
        }
        return 0;
    }

    private static com.baidu.swan.apps.ak.a bW(int i) {
        com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
        switch (i) {
            case 1:
                aVar.Z(10L).aa(2902L).ig("no aiapps info in database");
                break;
            case 2:
                aVar.Z(10L).aa(27L).ig("category not match");
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
            com.baidu.swan.apps.v.a.a.a(context, aVar, cVar.azz, cVar2);
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dP(cVar.azz);
            fVar.d(cVar);
            fVar.mType = Config.LAUNCH;
            fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
            fVar.k("errcode", String.valueOf(aVar.OV()));
            fVar.k("msg", aVar.OU().toString());
            fVar.ak(com.baidu.swan.apps.statistic.e.ht(cVar.azw));
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
            if (!aVar.OW()) {
                com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().hv(com.baidu.swan.apps.statistic.e.dP(cVar.azz)).a(aVar).hw(cVar.mAppId).hx(cVar.mFrom));
                aVar.OX();
            }
        }
    }

    private static com.baidu.swan.apps.v.b.b a(PMSAppInfo pMSAppInfo, com.baidu.swan.apps.v.b.c cVar) {
        if (pMSAppInfo == null) {
            return null;
        }
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        bVar.e(pMSAppInfo);
        bVar.eM(cVar.mFrom);
        bVar.setPage(cVar.azs);
        bVar.setDebug(cVar.azt);
        bVar.p(cVar.Fu());
        bVar.eN(cVar.azw);
        bVar.eR(cVar.azx);
        bVar.a(cVar.aun);
        bVar.a(cVar.auo);
        bVar.eQ(cVar.azv);
        bVar.cF(cVar.azm);
        if (pMSAppInfo.bsL == 1) {
            bVar.cr(1);
            return bVar;
        }
        bVar.cr(0);
        return bVar;
    }
}
