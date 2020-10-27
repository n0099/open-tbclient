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
    public static final boolean ddf = com.baidu.swan.apps.t.a.aud().getSwitch("swan_performance_aligned_search_switch", false);
    private static Timer ddg;
    public static String ddh;
    @Deprecated
    private static volatile b ddi;

    private static b aBf() {
        if (ddi == null) {
            synchronized (b.class) {
                if (ddi == null) {
                    ddi = new b();
                    a(ddi);
                }
            }
        }
        return ddi;
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
    public static synchronized HybridUbcFlow aBg() {
        HybridUbcFlow qv;
        synchronized (i.class) {
            qv = qv("startup");
        }
        return qv;
    }

    public static synchronized HybridUbcFlow qv(String str) {
        HybridUbcFlow qv;
        synchronized (i.class) {
            qv = aBf().qv(str);
        }
        return qv;
    }

    public static synchronized HybridUbcFlow cf(String str, String str2) {
        HybridUbcFlow cf;
        synchronized (i.class) {
            cf = aBf().cf(str, str2);
        }
        return cf;
    }

    public static synchronized HybridUbcFlow qx(String str) {
        HybridUbcFlow qx;
        synchronized (i.class) {
            qx = aBf().qx(str);
        }
        return qx;
    }

    public static synchronized void qD(String str) {
        synchronized (i.class) {
            aBf().qw(str);
        }
    }

    public static synchronized void cj(String str, String str2) {
        synchronized (i.class) {
            aBf().cg(str, str2);
        }
    }

    public static synchronized void ck(String str, String str2) {
        synchronized (i.class) {
            HybridUbcFlow qx = aBf().qx(str);
            if (qx != null) {
                aBf().qv(str2).d(qx);
                qD(str);
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
        if (bVar != null && bVar.awi() != null) {
            final String i = i(bVar);
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.i.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow qv = i.qv("startup");
                    String awd = TextUtils.isEmpty(com.baidu.swan.apps.u.c.b.this.awd()) ? "NA" : com.baidu.swan.apps.u.c.b.this.awd();
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1) {
                        qv.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    qv.r("from", "swan");
                    qv.r("source", awd);
                    qv.ci("appid", com.baidu.swan.apps.u.c.b.this.getAppId());
                    qv.ci("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.u.c.b.this.apD(), com.baidu.swan.apps.u.c.b.this.getAppFrameType()));
                    qv.ci("mobile", l.aJX());
                    long j = com.baidu.swan.apps.u.c.b.this.getLong("box_cold_launch", -1L);
                    if (j < 0) {
                        j = c.aAI();
                    }
                    if (j > 0) {
                        qv.ci("box_cold_launch", String.valueOf(j));
                    }
                    qv.ci("net", SwanAppNetworkUtils.aAh().type);
                    qv.ci(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.u.c.b.this.getVersion());
                    qv.ci("thirdversion", com.baidu.swan.apps.u.c.b.this.getVersionCode());
                    qv.r("from", com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
                    qv.ci("scheme", com.baidu.swan.apps.u.c.b.this.awf());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ai.deleteQueryParam(i, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    qv.ci("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (i.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    if (z) {
                        qv.r("value", "arrive_success");
                    }
                    qv.ci("launchid", com.baidu.swan.apps.u.c.b.this.aww());
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 0) {
                        qv.aAL();
                    }
                    com.baidu.swan.apps.console.c.bn("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + com.baidu.swan.apps.u.c.b.this);
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void qE(String str) {
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
        qv("startup").ci("package_type", str2);
    }

    public static synchronized HybridUbcFlow aBh() {
        HybridUbcFlow qx;
        synchronized (i.class) {
            ahQ();
            com.baidu.swan.apps.inlinewidget.f.b.b.atD();
            qx = qx("startup");
            if (qx == null) {
                qx = null;
            } else {
                qx.f(new UbcFlowEvent("performanceEnd"));
                qx.aAL();
                qx.aAO();
                qx.aAN();
                qx.aAP();
            }
        }
        return qx;
    }

    public static void aBi() {
        ddg = new Timer();
        ddg.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.i.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                i.aBh();
            }
        }, 15000L);
    }

    public static void ahQ() {
        if (ddg != null) {
            ddg.cancel();
            ddg = null;
        }
    }

    public static synchronized void d(com.baidu.swan.apps.am.a aVar) {
        synchronized (i.class) {
            HybridUbcFlow aBh = aBh();
            if (aBh != null) {
                aBh.r("value", SmsLoginView.f.l);
                if (aVar != null) {
                    aBh.ci("statusCode", String.valueOf(aVar.aJp()));
                    aBh.ci("launchid", com.baidu.swan.apps.runtime.d.aEQ().aEM().aEY().aww());
                }
                aBh.aAM();
            }
        }
    }

    private static String i(com.baidu.swan.apps.u.c.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(ddh)) {
                ddh = com.baidu.swan.apps.scheme.actions.k.c.aGn();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + ddh);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + ddh);
            }
        } else {
            ddh = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + ddh);
            }
        }
        return ddh;
    }

    /* loaded from: classes10.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int ddj = 35;
        public JSONObject ddk;
        private boolean ddl = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a qF(String str) {
            this.mFrom = str;
            return this;
        }

        public a qG(String str) {
            this.mType = str;
            return this;
        }

        public a qH(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.dup == null) {
                this.dup = new JSONObject();
            }
            try {
                if (this.ddk != null) {
                    if (this.ddl) {
                        String lg = ak.lg(ddj);
                        if (!TextUtils.isEmpty(lg)) {
                            this.ddk.put("stacktrace", lg);
                        }
                    }
                    this.dup.put("info", this.ddk);
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
