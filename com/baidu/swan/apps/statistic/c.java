package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.r;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static String aSe = "";

    public static Flow gP(String str) {
        return r.jS(str);
    }

    public static void a(final Flow flow, final e eVar) {
        if (flow != null) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this != null) {
                        flow.setValueWithDuration(e.this.toJSONObject().toString());
                    }
                    flow.end();
                }
            }, "SwanAppUBCEndFlow");
        }
    }

    public static void a(final com.baidu.swan.apps.statistic.a.d dVar) {
        if (dVar != null) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.2
                @Override // java.lang.Runnable
                public void run() {
                    r.onEvent("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
                }
            }, "SwanAppUBCStability");
        }
    }

    public static void onEvent(f fVar) {
        a("606", fVar);
    }

    public static void a(final String str, final f fVar) {
        if (!TextUtils.isEmpty(str)) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.3
                @Override // java.lang.Runnable
                public void run() {
                    f.this.ai(c.Kt());
                    r.onEvent(str, f.this.toJSONObject());
                }
            }, "SwanAppUBCOnEvent");
        }
    }

    public static void f(String str, String str2, int i) {
        if (!TextUtils.isEmpty(aSe) && TextUtils.equals(aSe, str2)) {
            if (DEBUG) {
                Log.d("SwanAppUBCStatistic", "onLaunchShow: not first start or different source");
                return;
            }
            return;
        }
        f fVar = new f();
        fVar.mFrom = dC(i);
        fVar.mAppId = str;
        fVar.mSource = str2;
        fVar.mType = "launchshow";
        onEvent(fVar);
        aSe = str2;
    }

    public static void Ks() {
        aSe = "";
    }

    public static void f(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "login";
        bVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        bVar.mAppId = str;
        bVar.mSource = com.baidu.swan.apps.ae.b.IX().uB().axF;
        j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.4
            @Override // java.lang.Runnable
            public void run() {
                r.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnLogin");
    }

    public static void a(boolean z, String str, String str2, int i) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.ae.b.Ji();
        bVar.mFrom = dC(i);
        bVar.aB("money", str2);
        j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.5
            @Override // java.lang.Runnable
            public void run() {
                r.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void gQ(String str) {
        int i = 0;
        com.baidu.swan.apps.v.b.b uB = com.baidu.swan.apps.ae.b.IX().uB();
        if (uB != null) {
            i = uB.axW;
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.ae.b.Ji();
        bVar.mFrom = dC(i);
        j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.6
            @Override // java.lang.Runnable
            public void run() {
                r.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void g(boolean z, String str) {
        final f fVar = new f();
        fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
        fVar.mSource = str;
        fVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        fVar.mAppId = com.baidu.swan.apps.ae.b.Ji();
        j.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.7
            @Override // java.lang.Runnable
            public void run() {
                f.this.ai(c.Kt());
                r.onEvent("778", f.this.toJSONObject());
            }
        }, "SwanAppUBCOnPagesRoute");
    }

    public static void a(int i, String str, int i2, String str2) {
        if (i != 200) {
            final com.baidu.swan.apps.statistic.a.c cVar = new com.baidu.swan.apps.statistic.a.c(i, str, str2);
            cVar.mType = "request";
            if (com.baidu.swan.apps.ae.b.IX() != null && com.baidu.swan.apps.ae.b.IX().uB() != null) {
                cVar.mSource = com.baidu.swan.apps.ae.b.IX().uB().axF;
            }
            cVar.mAppId = com.baidu.swan.apps.ae.b.Ji();
            cVar.mFrom = dC(i2);
            j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.8
                @Override // java.lang.Runnable
                public void run() {
                    r.onEvent("834", com.baidu.swan.apps.statistic.a.c.this.toJSONObject());
                }
            }, "SwanAppUBCRequest");
        }
    }

    public static String dC(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    public static JSONObject Kt() {
        com.baidu.swan.apps.v.b.b uB;
        JSONObject jSONObject;
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX == null || (uB = IX.uB()) == null || (jSONObject = uB.ayc) == null || !TextUtils.equals(jSONObject.optString("token"), "swanubc")) {
            return null;
        }
        return jSONObject;
    }

    public static void a(com.baidu.swan.apps.v.b.b bVar, String str) {
        if (bVar != null) {
            f fVar = new f();
            fVar.mFrom = dC(bVar.axW);
            fVar.mAppId = bVar.mAppId;
            fVar.mSource = bVar.axF;
            fVar.mType = str;
            a("859", fVar);
        }
    }

    public static void i(String str, String str2, boolean z) {
        final f fVar = new f();
        fVar.mType = str;
        fVar.mValue = str2;
        fVar.mAppId = com.baidu.swan.apps.ae.b.Ji();
        if (com.baidu.swan.apps.ae.b.IX() != null && com.baidu.swan.apps.ae.b.IX().uB() != null) {
            com.baidu.swan.apps.v.b.b uB = com.baidu.swan.apps.ae.b.IX().uB();
            fVar.mSource = uB.axF;
            fVar.mFrom = dC(uB.axW);
        }
        if (TextUtils.equals("click", str)) {
            fVar.aB("authorize", z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL);
        }
        j.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.9
            @Override // java.lang.Runnable
            public void run() {
                r.onEvent("894", f.this.toJSONObject());
            }
        }, "SwanAppUBCOnAuthDialog");
    }
}
