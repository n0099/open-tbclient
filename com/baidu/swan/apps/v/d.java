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
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.statistic.a.f;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.pms.model.a aVar, String str) {
        int a = a(cVar, aVar);
        if (a != 0) {
            com.baidu.swan.apps.ak.a bW = bW(a);
            e.LE().b(bW);
            b(context, cVar, bW);
            b.Dv().Dx();
            return;
        }
        c(context, a(aVar, cVar), str);
    }

    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar, String str) {
        com.baidu.swan.apps.v.b.b a = a(cVar);
        if (a == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.ak.a().L(10L).M(2902L).hx("no aiapps info in database");
                e.LE().b(aVar);
            }
            b(context, cVar, aVar);
            b.Dv().Dx();
            return;
        }
        c(context, a, str);
        com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().a(aVar).c(cVar));
    }

    private static com.baidu.swan.apps.v.b.b a(com.baidu.swan.apps.v.b.c cVar) {
        com.baidu.swan.pms.model.a jj;
        if (cVar == null || (jj = com.baidu.swan.pms.database.a.Ry().jj(cVar.mAppId)) == null || TextUtils.isEmpty(jj.appId)) {
            return null;
        }
        return a(jj, cVar);
    }

    private static void c(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        if (bVar.mErrorCode == 0) {
            b(context, bVar, str);
            return;
        }
        b.Dv().Dx();
        a(context, bVar);
    }

    private static void b(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        SwanAppLauncherActivity.a(context, bVar, str);
    }

    private static void a(Context context, com.baidu.swan.apps.v.b.b bVar) {
        Intent c = com.baidu.swan.apps.v.b.b.c(context, bVar);
        if (c != null) {
            c.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            context.startActivity(c);
        }
    }

    private static int a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.pms.model.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.appId)) {
            return 1;
        }
        if ((cVar.ayb == 0 && aVar.appCategory != 0) || (cVar.ayb == 1 && aVar.appCategory != 1)) {
            return 2;
        }
        return 0;
    }

    private static com.baidu.swan.apps.ak.a bW(int i) {
        com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
        switch (i) {
            case 1:
                aVar.L(10L).M(2902L).hx("no aiapps info in database");
                break;
            case 2:
                aVar.L(10L).M(27L).hx("category not match");
                break;
        }
        return aVar;
    }

    private static void b(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar) {
        if (cVar == null) {
            if (DEBUG) {
                Log.e("SwanAppLoader", "Fatal: launchparams is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.v.a.a.a(context, aVar, cVar.ayb);
        f fVar = new f();
        fVar.mFrom = com.baidu.swan.apps.statistic.c.dB(cVar.ayb);
        fVar.d(cVar);
        fVar.mType = "launch";
        fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        fVar.aB("errcode", String.valueOf(aVar.LA()));
        fVar.aB("msg", aVar.Lz().toString());
        com.baidu.swan.apps.statistic.c.onEvent(fVar);
        if (!aVar.LB()) {
            com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().gS(com.baidu.swan.apps.statistic.c.dB(cVar.ayb)).a(aVar).gT(cVar.mAppId).gU(cVar.mFrom));
            aVar.LC();
        }
        com.baidu.swan.apps.storage.b.f.KJ().putLong(cVar.mAppId, 0L);
    }

    private static com.baidu.swan.apps.v.b.b a(com.baidu.swan.pms.model.a aVar, com.baidu.swan.apps.v.b.c cVar) {
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        if (aVar == null) {
            return null;
        }
        bVar.axH = aVar.appName;
        bVar.axI = aVar.iconUrl;
        bVar.mAppId = cVar.mAppId;
        bVar.axK = cVar.mFrom;
        bVar.axM = cVar.axM;
        bVar.axW = cVar.axW;
        bVar.mAppKey = aVar.appKey;
        bVar.mDescription = aVar.description;
        bVar.mErrorCode = aVar.appStatus;
        bVar.axN = aVar.blR;
        bVar.mErrorMsg = aVar.blS;
        bVar.axO = aVar.atZ;
        bVar.axR = aVar.auc;
        bVar.axS = aVar.aud;
        bVar.axT = new SwanAppBearInfo(aVar.aue);
        bVar.mVersion = String.valueOf(aVar.versionCode);
        bVar.axU = cVar.DA();
        bVar.axL = cVar.axL;
        bVar.mType = aVar.type;
        bVar.axX = cVar.axX;
        bVar.atv = cVar.atv;
        bVar.atw = cVar.atw;
        bVar.auj = aVar.blT;
        bVar.aul = aVar.versionName;
        bVar.axV = cVar.axV;
        bVar.ayd = cVar.ayd;
        if (aVar.appCategory == 1) {
            bVar.ayb = 1;
        } else {
            bVar.ayb = 0;
        }
        bVar.orientation = aVar.orientation;
        return bVar;
    }
}
