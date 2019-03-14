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
            com.baidu.swan.apps.ak.a bX = bX(a);
            e.LG().b(bX);
            b(context, cVar, bX);
            b.Dx().Dz();
            return;
        }
        c(context, a(aVar, cVar), str);
    }

    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar, String str) {
        com.baidu.swan.apps.v.b.b a = a(cVar);
        if (a == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.ak.a().L(10L).M(2902L).hw("no aiapps info in database");
                e.LG().b(aVar);
            }
            b(context, cVar, aVar);
            b.Dx().Dz();
            return;
        }
        c(context, a, str);
        com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().a(aVar).c(cVar));
    }

    private static com.baidu.swan.apps.v.b.b a(com.baidu.swan.apps.v.b.c cVar) {
        com.baidu.swan.pms.model.a ji;
        if (cVar == null || (ji = com.baidu.swan.pms.database.a.RA().ji(cVar.mAppId)) == null || TextUtils.isEmpty(ji.appId)) {
            return null;
        }
        return a(ji, cVar);
    }

    private static void c(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        if (bVar.mErrorCode == 0) {
            b(context, bVar, str);
            return;
        }
        b.Dx().Dz();
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
        if ((cVar.axX == 0 && aVar.appCategory != 0) || (cVar.axX == 1 && aVar.appCategory != 1)) {
            return 2;
        }
        return 0;
    }

    private static com.baidu.swan.apps.ak.a bX(int i) {
        com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
        switch (i) {
            case 1:
                aVar.L(10L).M(2902L).hw("no aiapps info in database");
                break;
            case 2:
                aVar.L(10L).M(27L).hw("category not match");
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
        com.baidu.swan.apps.v.a.a.a(context, aVar, cVar.axX);
        f fVar = new f();
        fVar.mFrom = com.baidu.swan.apps.statistic.c.dC(cVar.axX);
        fVar.d(cVar);
        fVar.mType = "launch";
        fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        fVar.aB("errcode", String.valueOf(aVar.LC()));
        fVar.aB("msg", aVar.LB().toString());
        com.baidu.swan.apps.statistic.c.onEvent(fVar);
        if (!aVar.LD()) {
            com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().gR(com.baidu.swan.apps.statistic.c.dC(cVar.axX)).a(aVar).gS(cVar.mAppId).gT(cVar.mFrom));
            aVar.LE();
        }
        com.baidu.swan.apps.storage.b.f.KL().putLong(cVar.mAppId, 0L);
    }

    private static com.baidu.swan.apps.v.b.b a(com.baidu.swan.pms.model.a aVar, com.baidu.swan.apps.v.b.c cVar) {
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        if (aVar == null) {
            return null;
        }
        bVar.axD = aVar.appName;
        bVar.axE = aVar.iconUrl;
        bVar.mAppId = cVar.mAppId;
        bVar.axG = cVar.mFrom;
        bVar.axI = cVar.axI;
        bVar.axS = cVar.axS;
        bVar.mAppKey = aVar.appKey;
        bVar.mDescription = aVar.description;
        bVar.mErrorCode = aVar.appStatus;
        bVar.axJ = aVar.blN;
        bVar.mErrorMsg = aVar.blO;
        bVar.axK = aVar.atU;
        bVar.axN = aVar.atX;
        bVar.axO = aVar.atY;
        bVar.axP = new SwanAppBearInfo(aVar.atZ);
        bVar.mVersion = String.valueOf(aVar.versionCode);
        bVar.axQ = cVar.DC();
        bVar.axH = cVar.axH;
        bVar.mType = aVar.type;
        bVar.axT = cVar.axT;
        bVar.atq = cVar.atq;
        bVar.atr = cVar.atr;
        bVar.aue = aVar.blP;
        bVar.aug = aVar.versionName;
        bVar.axR = cVar.axR;
        bVar.axZ = cVar.axZ;
        if (aVar.appCategory == 1) {
            bVar.axX = 1;
        } else {
            bVar.axX = 0;
        }
        bVar.orientation = aVar.orientation;
        return bVar;
    }
}
