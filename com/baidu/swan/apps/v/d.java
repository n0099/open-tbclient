package com.baidu.swan.apps.v;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
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
            e.Ok().b(bW);
            b(context, cVar, bW);
            b.ED().EF();
            return;
        }
        c(context, a(pMSAppInfo, cVar), str);
    }

    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar, String str) {
        com.baidu.swan.apps.v.b.b a = a(cVar);
        if (a == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.ak.a().Y(10L).Z(2902L).hZ("no aiapps info in database");
                e.Ok().b(aVar);
            }
            b(context, cVar, aVar);
            b.ED().EF();
            return;
        }
        PMSAppInfo Fm = a.Fm();
        if (Fm != null && !TextUtils.isEmpty(Fm.appId) && !TextUtils.isEmpty(Fm.iconUrl)) {
            com.baidu.swan.apps.core.a.c.b(Fm.appId, Fm.iconUrl, String.valueOf(Fm.versionCode), Fm.appCategory);
        }
        c(context, a, str);
        com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(aVar).c(cVar));
    }

    private static com.baidu.swan.apps.v.b.b a(com.baidu.swan.apps.v.b.c cVar) {
        PMSAppInfo ki;
        if (cVar == null || (ki = com.baidu.swan.pms.database.a.Vl().ki(cVar.mAppId)) == null || TextUtils.isEmpty(ki.appId)) {
            return null;
        }
        return a(ki, cVar);
    }

    private static void c(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        if (bVar.EN() == 0) {
            b(context, bVar, str);
            return;
        }
        b.ED().EF();
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
            new com.baidu.swan.apps.ak.a().Y(2L).Z(35L).hZ("app has been offline");
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dM(bVar.Fg());
            fVar.mType = "launch";
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
        if ((cVar.ayS == 0 && pMSAppInfo.appCategory != 0) || (cVar.ayS == 1 && pMSAppInfo.appCategory != 1)) {
            return 2;
        }
        return 0;
    }

    private static com.baidu.swan.apps.ak.a bW(int i) {
        com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
        switch (i) {
            case 1:
                aVar.Y(10L).Z(2902L).hZ("no aiapps info in database");
                break;
            case 2:
                aVar.Y(10L).Z(27L).hZ("category not match");
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
            com.baidu.swan.apps.v.a.a.a(context, aVar, cVar.ayS, cVar2);
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dM(cVar.ayS);
            fVar.d(cVar);
            fVar.mType = "launch";
            fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
            fVar.k("errcode", String.valueOf(aVar.Og()));
            fVar.k("msg", aVar.Of().toString());
            fVar.ak(com.baidu.swan.apps.statistic.e.hn(cVar.ayP));
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
            if (!aVar.Oh()) {
                com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().hp(com.baidu.swan.apps.statistic.e.dM(cVar.ayS)).a(aVar).hq(cVar.mAppId).hr(cVar.mFrom));
                aVar.Oi();
            }
        }
    }

    private static com.baidu.swan.apps.v.b.b a(PMSAppInfo pMSAppInfo, com.baidu.swan.apps.v.b.c cVar) {
        if (pMSAppInfo == null) {
            return null;
        }
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        bVar.e(pMSAppInfo);
        bVar.eI(cVar.mFrom);
        bVar.setPage(cVar.ayL);
        bVar.setDebug(cVar.ayM);
        bVar.p(cVar.EK());
        bVar.eJ(cVar.ayP);
        bVar.eN(cVar.ayQ);
        bVar.a(cVar.atK);
        bVar.a(cVar.atL);
        bVar.eM(cVar.ayO);
        bVar.cE(cVar.ayF);
        if (pMSAppInfo.appCategory == 1) {
            bVar.cr(1);
            return bVar;
        }
        bVar.cr(0);
        return bVar;
    }
}
