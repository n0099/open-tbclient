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
/* loaded from: classes7.dex */
public final class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean dhs = com.baidu.swan.apps.t.a.avV().getSwitch("swan_performance_aligned_search_switch", false);
    private static Timer dht;
    public static String dhu;
    @Deprecated
    private static volatile b dhv;

    private static b aCX() {
        if (dhv == null) {
            synchronized (b.class) {
                if (dhv == null) {
                    dhv = new b();
                    a(dhv);
                }
            }
        }
        return dhv;
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
    public static synchronized HybridUbcFlow aCY() {
        HybridUbcFlow qD;
        synchronized (i.class) {
            qD = qD("startup");
        }
        return qD;
    }

    public static synchronized HybridUbcFlow qD(String str) {
        HybridUbcFlow qD;
        synchronized (i.class) {
            qD = aCX().qD(str);
        }
        return qD;
    }

    public static synchronized HybridUbcFlow ce(String str, String str2) {
        HybridUbcFlow ce;
        synchronized (i.class) {
            ce = aCX().ce(str, str2);
        }
        return ce;
    }

    public static synchronized HybridUbcFlow qF(String str) {
        HybridUbcFlow qF;
        synchronized (i.class) {
            qF = aCX().qF(str);
        }
        return qF;
    }

    public static synchronized void qL(String str) {
        synchronized (i.class) {
            aCX().qE(str);
        }
    }

    public static synchronized void ci(String str, String str2) {
        synchronized (i.class) {
            aCX().cf(str, str2);
        }
    }

    public static synchronized void cj(String str, String str2) {
        synchronized (i.class) {
            HybridUbcFlow qF = aCX().qF(str);
            if (qF != null) {
                aCX().qD(str2).d(qF);
                qL(str);
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
        com.baidu.swan.apps.console.c.bm("SwanAppPerformanceUBC", "recordForStartup");
        if (bVar != null && bVar.aya() != null) {
            final String i = i(bVar);
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.i.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow qD = i.qD("startup");
                    String axV = TextUtils.isEmpty(com.baidu.swan.apps.u.c.b.this.axV()) ? "NA" : com.baidu.swan.apps.u.c.b.this.axV();
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1) {
                        qD.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    qD.r("from", "swan");
                    qD.r("source", axV);
                    qD.ch("appid", com.baidu.swan.apps.u.c.b.this.getAppId());
                    qD.ch("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.u.c.b.this.arv(), com.baidu.swan.apps.u.c.b.this.getAppFrameType()));
                    qD.ch("mobile", l.aLP());
                    long j = com.baidu.swan.apps.u.c.b.this.getLong("box_cold_launch", -1L);
                    if (j < 0) {
                        j = c.aCA();
                    }
                    if (j > 0) {
                        qD.ch("box_cold_launch", String.valueOf(j));
                    }
                    qD.ch("net", SwanAppNetworkUtils.aBZ().type);
                    qD.ch(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.u.c.b.this.getVersion());
                    qD.ch("thirdversion", com.baidu.swan.apps.u.c.b.this.getVersionCode());
                    qD.r("from", com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
                    qD.ch("scheme", com.baidu.swan.apps.u.c.b.this.axX());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ai.deleteQueryParam(i, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    qD.ch("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (i.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    if (z) {
                        qD.r("value", "arrive_success");
                    }
                    qD.ch("launchid", com.baidu.swan.apps.u.c.b.this.ayo());
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 0) {
                        qD.aCD();
                    }
                    com.baidu.swan.apps.console.c.bm("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + com.baidu.swan.apps.u.c.b.this);
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void qM(String str) {
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
        qD("startup").ch("package_type", str2);
    }

    public static synchronized HybridUbcFlow aCZ() {
        HybridUbcFlow qF;
        synchronized (i.class) {
            ajI();
            com.baidu.swan.apps.inlinewidget.f.b.b.avv();
            qF = qF("startup");
            if (qF == null) {
                qF = null;
            } else {
                qF.f(new UbcFlowEvent("performanceEnd"));
                qF.aCD();
                qF.aCG();
                qF.aCF();
                qF.aCH();
            }
        }
        return qF;
    }

    public static void aDa() {
        dht = new Timer();
        dht.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.i.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                i.aCZ();
            }
        }, 15000L);
    }

    public static void ajI() {
        if (dht != null) {
            dht.cancel();
            dht = null;
        }
    }

    public static synchronized void d(com.baidu.swan.apps.am.a aVar) {
        synchronized (i.class) {
            HybridUbcFlow aCZ = aCZ();
            if (aCZ != null) {
                aCZ.r("value", SmsLoginView.f.l);
                if (aVar != null) {
                    aCZ.ch("statusCode", String.valueOf(aVar.aLh()));
                    aCZ.ch("launchid", com.baidu.swan.apps.runtime.d.aGI().aGE().aGQ().ayo());
                }
                aCZ.aCE();
            }
        }
    }

    private static String i(com.baidu.swan.apps.u.c.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(dhu)) {
                dhu = com.baidu.swan.apps.scheme.actions.k.c.aIf();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + dhu);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + dhu);
            }
        } else {
            dhu = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + dhu);
            }
        }
        return dhu;
    }

    /* loaded from: classes7.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int dhw = 35;
        public JSONObject dhx;
        private boolean dhy = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a qN(String str) {
            this.mFrom = str;
            return this;
        }

        public a qO(String str) {
            this.mType = str;
            return this;
        }

        public a qP(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.dyA == null) {
                this.dyA = new JSONObject();
            }
            try {
                if (this.dhx != null) {
                    if (this.dhy) {
                        String lm = ak.lm(dhw);
                        if (!TextUtils.isEmpty(lm)) {
                            this.dhx.put("stacktrace", lm);
                        }
                    }
                    this.dyA.put("info", this.dhx);
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
