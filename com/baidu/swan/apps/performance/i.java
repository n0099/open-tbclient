package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.l;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean cUG = com.baidu.swan.apps.t.a.asi().getSwitch("swan_performance_aligned_search_switch", false);
    private static Timer cUH;
    public static String cUI;
    @Deprecated
    private static volatile b cUJ;

    private static b azl() {
        if (cUJ == null) {
            synchronized (b.class) {
                if (cUJ == null) {
                    cUJ = new b();
                    a(cUJ);
                }
            }
        }
        return cUJ;
    }

    private static void a(b bVar) {
        bVar.c("preload", new com.baidu.swan.apps.performance.c.a()).c("startup", new com.baidu.swan.apps.performance.c.c()).c("route", new com.baidu.swan.apps.performance.c.b()).c("video", new com.baidu.swan.apps.performance.c.d());
    }

    public static void onEvent(a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "onEvent " + aVar);
        }
        com.baidu.swan.apps.statistic.b.onEvent(aVar.eventId, aVar.toJSONObject());
    }

    @Deprecated
    public static synchronized HybridUbcFlow azm() {
        HybridUbcFlow qc;
        synchronized (i.class) {
            qc = qc("startup");
        }
        return qc;
    }

    public static synchronized HybridUbcFlow qc(String str) {
        HybridUbcFlow qc;
        synchronized (i.class) {
            qc = azl().qc(str);
        }
        return qc;
    }

    public static synchronized HybridUbcFlow bY(String str, String str2) {
        HybridUbcFlow bY;
        synchronized (i.class) {
            bY = azl().bY(str, str2);
        }
        return bY;
    }

    public static synchronized HybridUbcFlow qe(String str) {
        HybridUbcFlow qe;
        synchronized (i.class) {
            qe = azl().qe(str);
        }
        return qe;
    }

    public static synchronized void qk(String str) {
        synchronized (i.class) {
            azl().qd(str);
        }
    }

    public static synchronized void cc(String str, String str2) {
        synchronized (i.class) {
            azl().bZ(str, str2);
        }
    }

    public static synchronized void cd(String str, String str2) {
        synchronized (i.class) {
            HybridUbcFlow qe = azl().qe(str);
            if (qe != null) {
                azl().qc(str2).d(qe);
                qk(str);
            }
        }
    }

    public static void a(final com.baidu.swan.apps.u.c.b bVar, final boolean z) {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.performance.i.1
            @Override // java.lang.Runnable
            public void run() {
                i.b(com.baidu.swan.apps.u.c.b.this, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final com.baidu.swan.apps.u.c.b bVar, final boolean z) {
        com.baidu.swan.apps.console.c.bg("SwanAppPerformanceUBC", "recordForStartup");
        if (bVar != null && bVar.auo() != null) {
            final String i = i(bVar);
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.i.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow qc = i.qc("startup");
                    String auj = TextUtils.isEmpty(com.baidu.swan.apps.u.c.b.this.auj()) ? "NA" : com.baidu.swan.apps.u.c.b.this.auj();
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1) {
                        qc.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    qc.r("from", "swan");
                    qc.r("source", auj);
                    qc.cb("appid", com.baidu.swan.apps.u.c.b.this.getAppId());
                    qc.cb("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.u.c.b.this.anI(), com.baidu.swan.apps.u.c.b.this.getAppFrameType()));
                    qc.cb("mobile", l.aId());
                    long j = com.baidu.swan.apps.u.c.b.this.getLong("box_cold_launch", -1L);
                    if (j < 0) {
                        j = c.ayO();
                    }
                    if (j > 0) {
                        qc.cb("box_cold_launch", String.valueOf(j));
                    }
                    qc.cb("net", SwanAppNetworkUtils.ayn().type);
                    qc.cb(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.u.c.b.this.getVersion());
                    qc.cb("thirdversion", com.baidu.swan.apps.u.c.b.this.getVersionCode());
                    qc.r("from", com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
                    qc.cb("scheme", com.baidu.swan.apps.u.c.b.this.aul());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ai.deleteQueryParam(i, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    qc.cb("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (i.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    if (z) {
                        qc.r("value", "arrive_success");
                    }
                    qc.cb("launchid", com.baidu.swan.apps.u.c.b.this.auC());
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 0) {
                        qc.ayR();
                    }
                    com.baidu.swan.apps.console.c.bg("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + com.baidu.swan.apps.u.c.b.this);
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void ql(String str) {
        String str2;
        char c = 65535;
        switch (str.hashCode()) {
            case -952207494:
                if (str.equals("independent")) {
                    c = 2;
                    break;
                }
                break;
            case -533350585:
                if (str.equals("subNormal")) {
                    c = 1;
                    break;
                }
                break;
            case -285446714:
                if (str.equals("dynamicLib")) {
                    c = 3;
                    break;
                }
                break;
            case 3343801:
                if (str.equals("main")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                str2 = "0";
                break;
            case 1:
                str2 = "2";
                break;
            case 2:
                str2 = "1";
                break;
            case 3:
                str2 = "3";
                break;
            default:
                str2 = "-1";
                break;
        }
        qc("startup").cb("package_type", str2);
    }

    public static synchronized HybridUbcFlow azn() {
        HybridUbcFlow qe;
        synchronized (i.class) {
            afW();
            com.baidu.swan.apps.inlinewidget.f.b.b.arI();
            qe = qe("startup");
            if (qe == null) {
                qe = null;
            } else {
                qe.f(new UbcFlowEvent("performanceEnd"));
                qe.ayR();
                qe.ayU();
                qe.ayT();
                qe.ayV();
            }
        }
        return qe;
    }

    public static void azo() {
        cUH = new Timer();
        cUH.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.i.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                i.azn();
            }
        }, 15000L);
    }

    public static void afW() {
        if (cUH != null) {
            cUH.cancel();
            cUH = null;
        }
    }

    public static synchronized void d(com.baidu.swan.apps.am.a aVar) {
        synchronized (i.class) {
            HybridUbcFlow azn = azn();
            if (azn != null) {
                azn.r("value", SmsLoginView.f.l);
                if (aVar != null) {
                    azn.cb("statusCode", String.valueOf(aVar.aHv()));
                    azn.cb("launchid", com.baidu.swan.apps.runtime.d.aCW().aCS().aDe().auC());
                }
                azn.ayS();
            }
        }
    }

    private static String i(com.baidu.swan.apps.u.c.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(cUI)) {
                cUI = com.baidu.swan.apps.scheme.actions.k.c.aEt();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + cUI);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + cUI);
            }
        } else {
            cUI = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + cUI);
            }
        }
        return cUI;
    }

    /* loaded from: classes10.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int cUK = 35;
        public JSONObject cUL;
        private boolean cUM = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a qm(String str) {
            this.mFrom = str;
            return this;
        }

        public a qn(String str) {
            this.mType = str;
            return this;
        }

        public a qo(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.dlN == null) {
                this.dlN = new JSONObject();
            }
            try {
                if (this.cUL != null) {
                    if (this.cUM) {
                        String kV = ak.kV(cUK);
                        if (!TextUtils.isEmpty(kV)) {
                            this.cUL.put("stacktrace", kV);
                        }
                    }
                    this.dlN.put("info", this.cUL);
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return super.toJSONObject();
        }
    }
}
