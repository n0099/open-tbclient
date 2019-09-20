package com.baidu.swan.apps.statistic;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.s;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean aWh = false;

    public static Flow ht(String str) {
        return s.lb(str);
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

    public static synchronized void cx(boolean z) {
        synchronized (e.class) {
            aWh = z;
        }
    }

    public static synchronized boolean NI() {
        boolean z;
        synchronized (e.class) {
            z = aWh;
        }
        return z;
    }

    public static void NJ() {
        cx(false);
    }

    public static void NK() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null) {
            r(Mh.vP());
        }
    }

    public static void r(com.baidu.swan.apps.v.b.b bVar) {
        Bundle FO;
        if (bVar != null && NI() && (FO = bVar.FO()) != null && FO.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = dQ(bVar.FU());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.FK();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            onEvent(fVar);
            FO.remove("page_display_flag_for_statistic");
        }
    }

    public static void a(boolean z, String str, String str2, int i) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.ae.b.Ms();
        bVar.mFrom = dQ(i);
        bVar.k("money", str2);
        bVar.ak(NL());
        j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.4
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void hu(String str) {
        int i = 0;
        com.baidu.swan.apps.v.b.b vP = com.baidu.swan.apps.ae.b.Mh().vP();
        if (vP != null) {
            i = vP.FU();
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.ae.b.Ms();
        bVar.mFrom = dQ(i);
        bVar.ak(NL());
        j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.5
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void f(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
        fVar.mSource = str;
        fVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        fVar.mAppId = com.baidu.swan.apps.ae.b.Ms();
        fVar.ak(NL());
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
            if (com.baidu.swan.apps.ae.b.Mh() != null && com.baidu.swan.apps.ae.b.Mh().vP() != null) {
                cVar.mSource = com.baidu.swan.apps.ae.b.Mh().vP().FK();
            }
            cVar.mAppId = com.baidu.swan.apps.ae.b.Ms();
            cVar.mFrom = dQ(i2);
            j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.7
                @Override // java.lang.Runnable
                public void run() {
                    s.onEvent("834", com.baidu.swan.apps.statistic.a.c.this.toJSONObject());
                }
            }, "SwanAppUBCRequest");
        }
    }

    public static String dQ(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    public static JSONObject NL() {
        com.baidu.swan.apps.v.b.b vP;
        JSONObject Gb;
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh == null || (vP = Mh.vP()) == null || (Gb = vP.Gb()) == null || !TextUtils.equals(Gb.optString("token"), "swanubc")) {
            return null;
        }
        return Gb;
    }

    public static JSONObject hv(String str) {
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

    public static void j(String str, String str2, boolean z) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mType = str;
        fVar.mValue = str2;
        fVar.mAppId = com.baidu.swan.apps.ae.b.Ms();
        if (com.baidu.swan.apps.ae.b.Mh() != null && com.baidu.swan.apps.ae.b.Mh().vP() != null) {
            com.baidu.swan.apps.v.b.b vP = com.baidu.swan.apps.ae.b.Mh().vP();
            fVar.mSource = vP.FK();
            fVar.mFrom = dQ(vP.FU());
        }
        if (TextUtils.equals("click", str)) {
            fVar.k("authorize", z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL);
        }
        j.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.8
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("894", com.baidu.swan.apps.statistic.a.f.this.toJSONObject());
            }
        }, "SwanAppUBCOnAuthDialog");
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (com.baidu.swan.apps.ae.b.Mh() != null && com.baidu.swan.apps.ae.b.Mh().vP() != null) {
            com.baidu.swan.apps.v.b.b vP = com.baidu.swan.apps.ae.b.Mh().vP();
            fVar.mFrom = dQ(vP.FU());
            fVar.mAppId = vP.getAppId();
            fVar.mSource = vP.FK();
        }
        a("914", fVar);
    }

    public static void d(com.baidu.swan.apps.statistic.a.f fVar) {
        if (com.baidu.swan.apps.ae.b.Mh() != null && com.baidu.swan.apps.ae.b.Mh().vP() != null) {
            com.baidu.swan.apps.v.b.b vP = com.baidu.swan.apps.ae.b.Mh().vP();
            fVar.mFrom = dQ(vP.FU());
            fVar.mAppId = vP.getAppId();
            fVar.mSource = vP.FK();
        }
        a("936", fVar);
    }
}
