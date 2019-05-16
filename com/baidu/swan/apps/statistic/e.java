package com.baidu.swan.apps.statistic;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
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
    private static volatile boolean aUZ = false;

    public static Flow hl(String str) {
        return s.kS(str);
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

    public static synchronized void cu(boolean z) {
        synchronized (e.class) {
            aUZ = z;
        }
    }

    public static synchronized boolean MP() {
        boolean z;
        synchronized (e.class) {
            z = aUZ;
        }
        return z;
    }

    public static void MQ() {
        cu(false);
    }

    public static void MR() {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null) {
            r(Lq.vk());
        }
    }

    public static void r(com.baidu.swan.apps.v.b.b bVar) {
        Bundle Fa;
        if (bVar != null && MP() && (Fa = bVar.Fa()) != null && Fa.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = dM(bVar.Fg());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.EW();
            fVar.mType = "launch";
            fVar.mValue = "realsuccess";
            onEvent(fVar);
            Fa.remove("page_display_flag_for_statistic");
        }
    }

    public static void a(boolean z, String str, String str2, int i) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.ae.b.LB();
        bVar.mFrom = dM(i);
        bVar.k("money", str2);
        bVar.ak(MS());
        j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.4
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void hm(String str) {
        int i = 0;
        com.baidu.swan.apps.v.b.b vk = com.baidu.swan.apps.ae.b.Lq().vk();
        if (vk != null) {
            i = vk.Fg();
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.ae.b.LB();
        bVar.mFrom = dM(i);
        bVar.ak(MS());
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
        fVar.mAppId = com.baidu.swan.apps.ae.b.LB();
        fVar.ak(MS());
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
            if (com.baidu.swan.apps.ae.b.Lq() != null && com.baidu.swan.apps.ae.b.Lq().vk() != null) {
                cVar.mSource = com.baidu.swan.apps.ae.b.Lq().vk().EW();
            }
            cVar.mAppId = com.baidu.swan.apps.ae.b.LB();
            cVar.mFrom = dM(i2);
            j.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.7
                @Override // java.lang.Runnable
                public void run() {
                    s.onEvent("834", com.baidu.swan.apps.statistic.a.c.this.toJSONObject());
                }
            }, "SwanAppUBCRequest");
        }
    }

    public static String dM(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    public static JSONObject MS() {
        com.baidu.swan.apps.v.b.b vk;
        JSONObject Fn;
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq == null || (vk = Lq.vk()) == null || (Fn = vk.Fn()) == null || !TextUtils.equals(Fn.optString("token"), "swanubc")) {
            return null;
        }
        return Fn;
    }

    public static JSONObject hn(String str) {
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
        fVar.mAppId = com.baidu.swan.apps.ae.b.LB();
        if (com.baidu.swan.apps.ae.b.Lq() != null && com.baidu.swan.apps.ae.b.Lq().vk() != null) {
            com.baidu.swan.apps.v.b.b vk = com.baidu.swan.apps.ae.b.Lq().vk();
            fVar.mSource = vk.EW();
            fVar.mFrom = dM(vk.Fg());
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
        if (com.baidu.swan.apps.ae.b.Lq() != null && com.baidu.swan.apps.ae.b.Lq().vk() != null) {
            com.baidu.swan.apps.v.b.b vk = com.baidu.swan.apps.ae.b.Lq().vk();
            fVar.mFrom = dM(vk.Fg());
            fVar.mAppId = vk.getAppId();
            fVar.mSource = vk.EW();
        }
        a("914", fVar);
    }

    public static void d(com.baidu.swan.apps.statistic.a.f fVar) {
        if (com.baidu.swan.apps.ae.b.Lq() != null && com.baidu.swan.apps.ae.b.Lq().vk() != null) {
            com.baidu.swan.apps.v.b.b vk = com.baidu.swan.apps.ae.b.Lq().vk();
            fVar.mFrom = dM(vk.Fg());
            fVar.mAppId = vk.getAppId();
            fVar.mSource = vk.EW();
        }
        a("936", fVar);
    }
}
