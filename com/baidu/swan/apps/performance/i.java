package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
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
/* loaded from: classes8.dex */
public final class i {
    private static Timer cGA;
    public static String cGB;
    @Deprecated
    private static volatile b cGC;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean cGz = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_performance_aligned_search_switch", false);

    private static b avR() {
        if (cGC == null) {
            synchronized (b.class) {
                if (cGC == null) {
                    cGC = new b();
                    a(cGC);
                }
            }
        }
        return cGC;
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
    public static synchronized HybridUbcFlow avS() {
        HybridUbcFlow oW;
        synchronized (i.class) {
            oW = oW("startup");
        }
        return oW;
    }

    public static synchronized HybridUbcFlow oW(String str) {
        HybridUbcFlow oW;
        synchronized (i.class) {
            oW = avR().oW(str);
        }
        return oW;
    }

    public static synchronized HybridUbcFlow bT(String str, String str2) {
        HybridUbcFlow bT;
        synchronized (i.class) {
            bT = avR().bT(str, str2);
        }
        return bT;
    }

    public static synchronized HybridUbcFlow oY(String str) {
        HybridUbcFlow oY;
        synchronized (i.class) {
            oY = avR().oY(str);
        }
        return oY;
    }

    public static synchronized void pe(String str) {
        synchronized (i.class) {
            avR().oX(str);
        }
    }

    public static synchronized void bX(String str, String str2) {
        synchronized (i.class) {
            avR().bU(str, str2);
        }
    }

    public static synchronized void bY(String str, String str2) {
        synchronized (i.class) {
            HybridUbcFlow oY = avR().oY(str);
            if (oY != null) {
                avR().oW(str2).d(oY);
                pe(str);
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
        if (bVar != null && bVar.aqS() != null) {
            final String i = i(bVar);
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.i.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow oW = i.oW("startup");
                    String aqN = TextUtils.isEmpty(com.baidu.swan.apps.u.c.b.this.aqN()) ? "NA" : com.baidu.swan.apps.u.c.b.this.aqN();
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1) {
                        oW.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    oW.r("from", "swan");
                    oW.r("source", aqN);
                    oW.bW("appid", com.baidu.swan.apps.u.c.b.this.getAppId());
                    oW.bW("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.u.c.b.this.akn(), com.baidu.swan.apps.u.c.b.this.getAppFrameType()));
                    oW.bW("mobile", l.aEK());
                    long j = com.baidu.swan.apps.u.c.b.this.getLong("box_cold_launch", -1L);
                    if (j < 0) {
                        j = c.avu();
                    }
                    if (j > 0) {
                        oW.bW("box_cold_launch", String.valueOf(j));
                    }
                    oW.bW("net", SwanAppNetworkUtils.auT().type);
                    oW.bW(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.u.c.b.this.getVersion());
                    oW.bW("thirdversion", com.baidu.swan.apps.u.c.b.this.getVersionCode());
                    oW.r("from", com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
                    oW.bW(SuspensionBallEntity.KEY_SCHEME, com.baidu.swan.apps.u.c.b.this.aqP());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ai.deleteQueryParam(i, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    oW.bW("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (i.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    if (z) {
                        oW.r("value", "arrive_success");
                    }
                    oW.bW("launchid", com.baidu.swan.apps.u.c.b.this.arg());
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 0) {
                        oW.avx();
                    }
                    com.baidu.swan.apps.console.c.bb("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + com.baidu.swan.apps.u.c.b.this);
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void pf(String str) {
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
        oW("startup").bW("package_type", str2);
    }

    public static synchronized HybridUbcFlow avT() {
        HybridUbcFlow oY;
        synchronized (i.class) {
            acB();
            com.baidu.swan.apps.inlinewidget.f.b.b.aom();
            oY = oY("startup");
            if (oY == null) {
                oY = null;
            } else {
                oY.f(new UbcFlowEvent("performanceEnd"));
                oY.avx();
                oY.avA();
                oY.avz();
                oY.avB();
            }
        }
        return oY;
    }

    public static void avU() {
        cGA = new Timer();
        cGA.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.i.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                i.avT();
            }
        }, 15000L);
    }

    public static void acB() {
        if (cGA != null) {
            cGA.cancel();
            cGA = null;
        }
    }

    public static synchronized void d(com.baidu.swan.apps.am.a aVar) {
        synchronized (i.class) {
            HybridUbcFlow avT = avT();
            if (avT != null) {
                avT.r("value", SmsLoginView.f.l);
                if (aVar != null) {
                    avT.bW("statusCode", String.valueOf(aVar.aEc()));
                    avT.bW("launchid", com.baidu.swan.apps.runtime.d.azE().azA().azM().arg());
                }
                avT.avy();
            }
        }
    }

    private static String i(com.baidu.swan.apps.u.c.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(cGB)) {
                cGB = com.baidu.swan.apps.scheme.actions.k.c.aBb();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + cGB);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + cGB);
            }
        } else {
            cGB = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + cGB);
            }
        }
        return cGB;
    }

    /* loaded from: classes8.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int cGD = 35;
        public JSONObject cGE;
        private boolean cGF = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a pg(String str) {
            this.mFrom = str;
            return this;
        }

        public a ph(String str) {
            this.mType = str;
            return this;
        }

        public a pi(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.cXz == null) {
                this.cXz = new JSONObject();
            }
            try {
                if (this.cGE != null) {
                    if (this.cGF) {
                        String kn = ak.kn(cGD);
                        if (!TextUtils.isEmpty(kn)) {
                            this.cGE.put("stacktrace", kn);
                        }
                    }
                    this.cXz.put("info", this.cGE);
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
