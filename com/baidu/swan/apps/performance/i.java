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
    public static final boolean djc = com.baidu.swan.apps.t.a.awD().getSwitch("swan_performance_aligned_search_switch", false);
    private static Timer djd;
    public static String dje;
    @Deprecated
    private static volatile b djf;

    private static b aDF() {
        if (djf == null) {
            synchronized (b.class) {
                if (djf == null) {
                    djf = new b();
                    a(djf);
                }
            }
        }
        return djf;
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
    public static synchronized HybridUbcFlow aDG() {
        HybridUbcFlow qJ;
        synchronized (i.class) {
            qJ = qJ("startup");
        }
        return qJ;
    }

    public static synchronized HybridUbcFlow qJ(String str) {
        HybridUbcFlow qJ;
        synchronized (i.class) {
            qJ = aDF().qJ(str);
        }
        return qJ;
    }

    public static synchronized HybridUbcFlow cf(String str, String str2) {
        HybridUbcFlow cf;
        synchronized (i.class) {
            cf = aDF().cf(str, str2);
        }
        return cf;
    }

    public static synchronized HybridUbcFlow qL(String str) {
        HybridUbcFlow qL;
        synchronized (i.class) {
            qL = aDF().qL(str);
        }
        return qL;
    }

    public static synchronized void qR(String str) {
        synchronized (i.class) {
            aDF().qK(str);
        }
    }

    public static synchronized void cj(String str, String str2) {
        synchronized (i.class) {
            aDF().cg(str, str2);
        }
    }

    public static synchronized void ck(String str, String str2) {
        synchronized (i.class) {
            HybridUbcFlow qL = aDF().qL(str);
            if (qL != null) {
                aDF().qJ(str2).d(qL);
                qR(str);
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
        com.baidu.swan.apps.console.c.bn("SwanAppPerformanceUBC", "recordForStartup");
        if (bVar != null && bVar.ayI() != null) {
            final String i = i(bVar);
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.i.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow qJ = i.qJ("startup");
                    String ayD = TextUtils.isEmpty(com.baidu.swan.apps.u.c.b.this.ayD()) ? "NA" : com.baidu.swan.apps.u.c.b.this.ayD();
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1) {
                        qJ.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    qJ.r("from", "swan");
                    qJ.r("source", ayD);
                    qJ.ci("appid", com.baidu.swan.apps.u.c.b.this.getAppId());
                    qJ.ci("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.u.c.b.this.asd(), com.baidu.swan.apps.u.c.b.this.getAppFrameType()));
                    qJ.ci("mobile", l.aMx());
                    long j = com.baidu.swan.apps.u.c.b.this.getLong("box_cold_launch", -1L);
                    if (j < 0) {
                        j = c.aDi();
                    }
                    if (j > 0) {
                        qJ.ci("box_cold_launch", String.valueOf(j));
                    }
                    qJ.ci("net", SwanAppNetworkUtils.aCH().type);
                    qJ.ci(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.u.c.b.this.getVersion());
                    qJ.ci("thirdversion", com.baidu.swan.apps.u.c.b.this.getVersionCode());
                    qJ.r("from", com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
                    qJ.ci("scheme", com.baidu.swan.apps.u.c.b.this.ayF());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ai.deleteQueryParam(i, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    qJ.ci("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (i.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    if (z) {
                        qJ.r("value", "arrive_success");
                    }
                    qJ.ci("launchid", com.baidu.swan.apps.u.c.b.this.ayW());
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 0) {
                        qJ.aDl();
                    }
                    com.baidu.swan.apps.console.c.bn("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + com.baidu.swan.apps.u.c.b.this);
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void qS(String str) {
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
        qJ("startup").ci("package_type", str2);
    }

    public static synchronized HybridUbcFlow aDH() {
        HybridUbcFlow qL;
        synchronized (i.class) {
            akq();
            com.baidu.swan.apps.inlinewidget.f.b.b.awd();
            qL = qL("startup");
            if (qL == null) {
                qL = null;
            } else {
                qL.f(new UbcFlowEvent("performanceEnd"));
                qL.aDl();
                qL.aDo();
                qL.aDn();
                qL.aDp();
            }
        }
        return qL;
    }

    public static void aDI() {
        djd = new Timer();
        djd.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.i.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                i.aDH();
            }
        }, 15000L);
    }

    public static void akq() {
        if (djd != null) {
            djd.cancel();
            djd = null;
        }
    }

    public static synchronized void d(com.baidu.swan.apps.am.a aVar) {
        synchronized (i.class) {
            HybridUbcFlow aDH = aDH();
            if (aDH != null) {
                aDH.r("value", SmsLoginView.f.l);
                if (aVar != null) {
                    aDH.ci("statusCode", String.valueOf(aVar.aLP()));
                    aDH.ci("launchid", com.baidu.swan.apps.runtime.d.aHq().aHm().aHy().ayW());
                }
                aDH.aDm();
            }
        }
    }

    private static String i(com.baidu.swan.apps.u.c.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(dje)) {
                dje = com.baidu.swan.apps.scheme.actions.k.c.aIN();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + dje);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + dje);
            }
        } else {
            dje = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + dje);
            }
        }
        return dje;
    }

    /* loaded from: classes10.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int djg = 35;
        public JSONObject djh;
        private boolean dji = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a qT(String str) {
            this.mFrom = str;
            return this;
        }

        public a qU(String str) {
            this.mType = str;
            return this;
        }

        public a qV(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.dAh == null) {
                this.dAh = new JSONObject();
            }
            try {
                if (this.djh != null) {
                    if (this.dji) {
                        String lq = ak.lq(djg);
                        if (!TextUtils.isEmpty(lq)) {
                            this.djh.put("stacktrace", lq);
                        }
                    }
                    this.dAh.put("info", this.djh);
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
