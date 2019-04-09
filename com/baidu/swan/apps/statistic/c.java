package com.baidu.swan.apps.statistic;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.q;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String aSj = "";

    public static Flow gQ(String str) {
        return q.jT(str);
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
                    q.onEvent("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
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
                    f.this.ai(c.Kr());
                    q.onEvent(str, f.this.toJSONObject());
                }
            }, "SwanAppUBCOnEvent");
        }
    }

    public static void f(String str, String str2, int i) {
        if (!TextUtils.isEmpty(aSj) && TextUtils.equals(aSj, str2)) {
            if (DEBUG) {
                Log.d("SwanAppUBCStatistic", "onLaunchShow: not first start or different source");
                return;
            }
            return;
        }
        f fVar = new f();
        fVar.mFrom = dB(i);
        fVar.mAppId = str;
        fVar.mSource = str2;
        fVar.mType = "launchshow";
        onEvent(fVar);
        aSj = str2;
    }

    public static void Kq() {
        aSj = "";
    }

    public static void f(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "login";
        bVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        bVar.mAppId = str;
        bVar.mSource = com.baidu.swan.apps.ae.b.IV().uA().axK;
        j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.4
            @Override // java.lang.Runnable
            public void run() {
                q.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnLogin");
    }

    public static void a(boolean z, String str, String str2, int i) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.ae.b.Jg();
        bVar.mFrom = dB(i);
        bVar.aB("money", str2);
        j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.5
            @Override // java.lang.Runnable
            public void run() {
                q.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void gR(String str) {
        int i = 0;
        com.baidu.swan.apps.v.b.b uA = com.baidu.swan.apps.ae.b.IV().uA();
        if (uA != null) {
            i = uA.ayb;
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.ae.b.Jg();
        bVar.mFrom = dB(i);
        j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.6
            @Override // java.lang.Runnable
            public void run() {
                q.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void g(boolean z, String str) {
        final f fVar = new f();
        fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
        fVar.mSource = str;
        fVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        fVar.mAppId = com.baidu.swan.apps.ae.b.Jg();
        j.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.7
            @Override // java.lang.Runnable
            public void run() {
                f.this.ai(c.Kr());
                q.onEvent("778", f.this.toJSONObject());
            }
        }, "SwanAppUBCOnPagesRoute");
    }

    public static void a(int i, String str, int i2, String str2) {
        if (i != 200) {
            final com.baidu.swan.apps.statistic.a.c cVar = new com.baidu.swan.apps.statistic.a.c(i, str, str2);
            cVar.mType = "request";
            if (com.baidu.swan.apps.ae.b.IV() != null && com.baidu.swan.apps.ae.b.IV().uA() != null) {
                cVar.mSource = com.baidu.swan.apps.ae.b.IV().uA().axK;
            }
            cVar.mAppId = com.baidu.swan.apps.ae.b.Jg();
            cVar.mFrom = dB(i2);
            j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.8
                @Override // java.lang.Runnable
                public void run() {
                    q.onEvent("834", com.baidu.swan.apps.statistic.a.c.this.toJSONObject());
                }
            }, "SwanAppUBCRequest");
        }
    }

    public static String dB(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    public static JSONObject Kr() {
        com.baidu.swan.apps.v.b.b uA;
        JSONObject jSONObject;
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV == null || (uA = IV.uA()) == null || (jSONObject = uA.ayh) == null || !TextUtils.equals(jSONObject.optString("token"), "swanubc")) {
            return null;
        }
        return jSONObject;
    }

    public static void a(com.baidu.swan.apps.v.b.b bVar, String str) {
        if (bVar != null) {
            f fVar = new f();
            fVar.mFrom = dB(bVar.ayb);
            fVar.mAppId = bVar.mAppId;
            fVar.mSource = bVar.axK;
            fVar.mType = str;
            a("859", fVar);
        }
    }

    public static void i(String str, String str2, boolean z) {
        final f fVar = new f();
        fVar.mType = str;
        fVar.mValue = str2;
        fVar.mAppId = com.baidu.swan.apps.ae.b.Jg();
        if (com.baidu.swan.apps.ae.b.IV() != null && com.baidu.swan.apps.ae.b.IV().uA() != null) {
            com.baidu.swan.apps.v.b.b uA = com.baidu.swan.apps.ae.b.IV().uA();
            fVar.mSource = uA.axK;
            fVar.mFrom = dB(uA.ayb);
        }
        if (TextUtils.equals("click", str)) {
            fVar.aB("authorize", z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL);
        }
        j.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.c.9
            @Override // java.lang.Runnable
            public void run() {
                q.onEvent("894", f.this.toJSONObject());
            }
        }, "SwanAppUBCOnAuthDialog");
    }
}
