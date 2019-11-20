package com.baidu.swan.apps.statistic;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.s;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean boT = false;

    public static Flow hW(String str) {
        return s.lD(str);
    }

    public static void a(final Flow flow, final com.baidu.swan.apps.statistic.a.e eVar) {
        if (flow != null) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.statistic.a.e.this != null) {
                        flow.setValueWithDuration(com.baidu.swan.apps.statistic.a.e.this.toJSONObject().toString());
                    }
                    flow.end();
                }
            }, "SwanAppUBCEndFlow");
        }
    }

    public static void b(final com.baidu.swan.apps.statistic.a.d dVar) {
        if (dVar != null) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.2
                @Override // java.lang.Runnable
                public void run() {
                    s.onEvent("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
                }
            }, "SwanAppUBCStability");
        }
    }

    public static void onEvent(com.baidu.swan.apps.statistic.a.f fVar) {
        a("606", fVar);
    }

    public static void a(final String str, final com.baidu.swan.apps.statistic.a.f fVar) {
        if (!TextUtils.isEmpty(str)) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.3
                @Override // java.lang.Runnable
                public void run() {
                    s.onEvent(str, fVar.toJSONObject());
                }
            }, "SwanAppUBCOnEvent");
        }
    }

    public static synchronized void cO(boolean z) {
        synchronized (e.class) {
            boT = z;
        }
    }

    public static synchronized boolean SA() {
        boolean z;
        synchronized (e.class) {
            z = boT;
        }
        return z;
    }

    public static void SB() {
        cO(false);
    }

    public static void SC() {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            r(Ra.AK());
        }
    }

    public static void r(com.baidu.swan.apps.v.b.b bVar) {
        Bundle KJ;
        if (bVar != null && SA() && (KJ = bVar.KJ()) != null && KJ.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = eL(bVar.KP());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.KF();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            onEvent(fVar);
            KJ.remove("page_display_flag_for_statistic");
        }
    }

    public static void a(boolean z, String str, String str2, int i) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.ae.b.Rm();
        bVar.mFrom = eL(i);
        bVar.h("money", str2);
        bVar.aJ(SD());
        j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.4
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void hX(String str) {
        int i = 0;
        com.baidu.swan.apps.v.b.b AK = com.baidu.swan.apps.ae.b.Ra().AK();
        if (AK != null) {
            i = AK.KP();
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.ae.b.Rm();
        bVar.mFrom = eL(i);
        bVar.aJ(SD());
        j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.5
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void g(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mType = "show";
        fVar.mSource = str;
        fVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        fVar.mAppId = com.baidu.swan.apps.ae.b.Rm();
        fVar.aJ(SD());
        j.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.6
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("778", com.baidu.swan.apps.statistic.a.f.this.toJSONObject());
            }
        }, "SwanAppUBCOnPagesRoute");
    }

    public static void a(int i, String str, int i2, String str2) {
        if (i != 200) {
            final com.baidu.swan.apps.statistic.a.c cVar = new com.baidu.swan.apps.statistic.a.c(i, str, str2);
            cVar.mType = "request";
            if (com.baidu.swan.apps.ae.b.Ra() != null && com.baidu.swan.apps.ae.b.Ra().AK() != null) {
                cVar.mSource = com.baidu.swan.apps.ae.b.Ra().AK().KF();
            }
            cVar.mAppId = com.baidu.swan.apps.ae.b.Rm();
            cVar.mFrom = eL(i2);
            j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.7
                @Override // java.lang.Runnable
                public void run() {
                    s.onEvent("834", com.baidu.swan.apps.statistic.a.c.this.toJSONObject());
                }
            }, "SwanAppUBCRequest");
        }
    }

    public static String eL(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    public static JSONObject SD() {
        com.baidu.swan.apps.v.b.b AK;
        JSONObject KW;
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra == null || (AK = Ra.AK()) == null || (KW = AK.KW()) == null || !TextUtils.equals(KW.optString("token"), "swanubc")) {
            return null;
        }
        return KW;
    }

    public static JSONObject hY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String queryParameter = Uri.parse(str).getQueryParameter("_baiduboxapp");
        if (TextUtils.isEmpty(queryParameter)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(queryParameter).optJSONObject("ext");
            if (optJSONObject != null) {
                if (TextUtils.equals(optJSONObject.optString("token"), "swanubc")) {
                    return optJSONObject;
                }
                return null;
            }
            return null;
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static void m(String str, String str2, boolean z) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mType = str;
        fVar.mValue = str2;
        fVar.mAppId = com.baidu.swan.apps.ae.b.Rm();
        if (com.baidu.swan.apps.ae.b.Ra() != null && com.baidu.swan.apps.ae.b.Ra().AK() != null) {
            com.baidu.swan.apps.v.b.b AK = com.baidu.swan.apps.ae.b.Ra().AK();
            fVar.mSource = AK.KF();
            fVar.mFrom = eL(AK.KP());
        }
        if (TextUtils.equals("click", str)) {
            fVar.h("authorize", z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL);
        }
        j.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.8
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("894", com.baidu.swan.apps.statistic.a.f.this.toJSONObject());
            }
        }, "SwanAppUBCOnAuthDialog");
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (com.baidu.swan.apps.ae.b.Ra() != null && com.baidu.swan.apps.ae.b.Ra().AK() != null) {
            com.baidu.swan.apps.v.b.b AK = com.baidu.swan.apps.ae.b.Ra().AK();
            fVar.mFrom = eL(AK.KP());
            fVar.mAppId = AK.getAppId();
            fVar.mSource = AK.KF();
        }
        a("914", fVar);
    }

    public static void d(com.baidu.swan.apps.statistic.a.f fVar) {
        if (com.baidu.swan.apps.ae.b.Ra() != null && com.baidu.swan.apps.ae.b.Ra().AK() != null) {
            com.baidu.swan.apps.v.b.b AK = com.baidu.swan.apps.ae.b.Ra().AK();
            fVar.mFrom = eL(AK.KP());
            fVar.mAppId = AK.getAppId();
            fVar.mSource = AK.KF();
        }
        a("936", fVar);
    }
}
