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
/* loaded from: classes3.dex */
public final class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean cID = com.baidu.swan.apps.t.a.apx().getSwitch("swan_performance_aligned_search_switch", false);
    private static Timer cIE;
    public static String cIF;
    @Deprecated
    private static volatile b cIG;

    private static b awA() {
        if (cIG == null) {
            synchronized (b.class) {
                if (cIG == null) {
                    cIG = new b();
                    a(cIG);
                }
            }
        }
        return cIG;
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
    public static synchronized HybridUbcFlow awB() {
        HybridUbcFlow pq;
        synchronized (i.class) {
            pq = pq("startup");
        }
        return pq;
    }

    public static synchronized HybridUbcFlow pq(String str) {
        HybridUbcFlow pq;
        synchronized (i.class) {
            pq = awA().pq(str);
        }
        return pq;
    }

    public static synchronized HybridUbcFlow bT(String str, String str2) {
        HybridUbcFlow bT;
        synchronized (i.class) {
            bT = awA().bT(str, str2);
        }
        return bT;
    }

    public static synchronized HybridUbcFlow ps(String str) {
        HybridUbcFlow ps;
        synchronized (i.class) {
            ps = awA().ps(str);
        }
        return ps;
    }

    public static synchronized void py(String str) {
        synchronized (i.class) {
            awA().pr(str);
        }
    }

    public static synchronized void bX(String str, String str2) {
        synchronized (i.class) {
            awA().bU(str, str2);
        }
    }

    public static synchronized void bY(String str, String str2) {
        synchronized (i.class) {
            HybridUbcFlow ps = awA().ps(str);
            if (ps != null) {
                awA().pq(str2).d(ps);
                py(str);
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
        com.baidu.swan.apps.console.c.bb("SwanAppPerformanceUBC", "recordForStartup");
        if (bVar != null && bVar.arC() != null) {
            final String i = i(bVar);
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.i.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow pq = i.pq("startup");
                    String arx = TextUtils.isEmpty(com.baidu.swan.apps.u.c.b.this.arx()) ? "NA" : com.baidu.swan.apps.u.c.b.this.arx();
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1) {
                        pq.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    pq.r("from", "swan");
                    pq.r("source", arx);
                    pq.bW("appid", com.baidu.swan.apps.u.c.b.this.getAppId());
                    pq.bW("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.u.c.b.this.akX(), com.baidu.swan.apps.u.c.b.this.getAppFrameType()));
                    pq.bW("mobile", l.aFu());
                    long j = com.baidu.swan.apps.u.c.b.this.getLong("box_cold_launch", -1L);
                    if (j < 0) {
                        j = c.awd();
                    }
                    if (j > 0) {
                        pq.bW("box_cold_launch", String.valueOf(j));
                    }
                    pq.bW("net", SwanAppNetworkUtils.avC().type);
                    pq.bW(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.u.c.b.this.getVersion());
                    pq.bW("thirdversion", com.baidu.swan.apps.u.c.b.this.getVersionCode());
                    pq.r("from", com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
                    pq.bW("scheme", com.baidu.swan.apps.u.c.b.this.arz());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ai.deleteQueryParam(i, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    pq.bW("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (i.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    if (z) {
                        pq.r("value", "arrive_success");
                    }
                    pq.bW("launchid", com.baidu.swan.apps.u.c.b.this.arQ());
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 0) {
                        pq.awg();
                    }
                    com.baidu.swan.apps.console.c.bb("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + com.baidu.swan.apps.u.c.b.this);
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void pz(String str) {
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
        pq("startup").bW("package_type", str2);
    }

    public static synchronized HybridUbcFlow awC() {
        HybridUbcFlow ps;
        synchronized (i.class) {
            adk();
            com.baidu.swan.apps.inlinewidget.f.b.b.aoW();
            ps = ps("startup");
            if (ps == null) {
                ps = null;
            } else {
                ps.f(new UbcFlowEvent("performanceEnd"));
                ps.awg();
                ps.awj();
                ps.awi();
                ps.awk();
            }
        }
        return ps;
    }

    public static void awD() {
        cIE = new Timer();
        cIE.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.i.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                i.awC();
            }
        }, 15000L);
    }

    public static void adk() {
        if (cIE != null) {
            cIE.cancel();
            cIE = null;
        }
    }

    public static synchronized void d(com.baidu.swan.apps.am.a aVar) {
        synchronized (i.class) {
            HybridUbcFlow awC = awC();
            if (awC != null) {
                awC.r("value", SmsLoginView.f.l);
                if (aVar != null) {
                    awC.bW("statusCode", String.valueOf(aVar.aEM()));
                    awC.bW("launchid", com.baidu.swan.apps.runtime.d.aAn().aAj().aAv().arQ());
                }
                awC.awh();
            }
        }
    }

    private static String i(com.baidu.swan.apps.u.c.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(cIF)) {
                cIF = com.baidu.swan.apps.scheme.actions.k.c.aBK();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + cIF);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + cIF);
            }
        } else {
            cIF = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + cIF);
            }
        }
        return cIF;
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int cIH = 35;
        public JSONObject cII;
        private boolean cIJ = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a pA(String str) {
            this.mFrom = str;
            return this;
        }

        public a pB(String str) {
            this.mType = str;
            return this;
        }

        public a pC(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.cZD == null) {
                this.cZD = new JSONObject();
            }
            try {
                if (this.cII != null) {
                    if (this.cIJ) {
                        String ky = ak.ky(cIH);
                        if (!TextUtils.isEmpty(ky)) {
                            this.cII.put("stacktrace", ky);
                        }
                    }
                    this.cZD.put("info", this.cII);
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
