package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.l;
import com.baidu.swan.apps.aq.p;
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
    public static final boolean cyF = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_app_use_performance_end", false);
    public static final boolean cyG = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_performance_aligned_search_switch", false);
    private static final int cyH = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_app_delay_upload_performance_ubc", 15000);
    private static Timer cyI;
    public static String cyJ;
    @Deprecated
    private static volatile b cyK;

    private static b anW() {
        if (cyK == null) {
            synchronized (b.class) {
                if (cyK == null) {
                    cyK = new b();
                    a(cyK);
                }
            }
        }
        return cyK;
    }

    private static void a(b bVar) {
        bVar.b("preload", new com.baidu.swan.apps.performance.c.a()).b("startup", new com.baidu.swan.apps.performance.c.c()).b("route", new com.baidu.swan.apps.performance.c.b());
    }

    public static void onEvent(a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "onEvent " + aVar);
        }
        com.baidu.swan.apps.statistic.b.onEvent(aVar.eventId, aVar.toJSONObject());
    }

    @Deprecated
    public static synchronized HybridUbcFlow anX() {
        HybridUbcFlow mX;
        synchronized (i.class) {
            mX = mX("startup");
        }
        return mX;
    }

    public static synchronized HybridUbcFlow mX(String str) {
        HybridUbcFlow mX;
        synchronized (i.class) {
            mX = anW().mX(str);
        }
        return mX;
    }

    public static synchronized HybridUbcFlow bE(String str, String str2) {
        HybridUbcFlow bE;
        synchronized (i.class) {
            bE = anW().bE(str, str2);
        }
        return bE;
    }

    public static synchronized HybridUbcFlow mZ(String str) {
        HybridUbcFlow mZ;
        synchronized (i.class) {
            mZ = anW().mZ(str);
        }
        return mZ;
    }

    public static synchronized void ng(String str) {
        synchronized (i.class) {
            anW().mY(str);
        }
    }

    public static synchronized void bI(String str, String str2) {
        synchronized (i.class) {
            anW().bF(str, str2);
        }
    }

    public static synchronized void bJ(String str, String str2) {
        synchronized (i.class) {
            HybridUbcFlow mZ = anW().mZ(str);
            if (mZ != null) {
                anW().mX(str2).d(mZ);
                ng(str);
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
        com.baidu.swan.apps.console.c.aW("SwanAppPerformanceUBC", "recordForStartup");
        if (bVar != null && bVar.ajl() != null) {
            final String i = i(bVar);
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.i.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow mX = i.mX("startup");
                    String ajg = TextUtils.isEmpty(com.baidu.swan.apps.u.c.b.this.ajg()) ? "NA" : com.baidu.swan.apps.u.c.b.this.ajg();
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1) {
                        mX.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    mX.r("from", "swan");
                    mX.r("source", ajg);
                    mX.bH("appid", com.baidu.swan.apps.u.c.b.this.getAppId());
                    mX.bH("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.u.c.b.this.adQ(), com.baidu.swan.apps.u.c.b.this.getAppFrameType()));
                    mX.bH("mobile", l.awA());
                    long j = com.baidu.swan.apps.u.c.b.this.getLong("box_cold_launch", -1L);
                    if (j < 0) {
                        j = c.anz();
                    }
                    if (j > 0) {
                        mX.bH("box_cold_launch", String.valueOf(j));
                    }
                    mX.bH("net", SwanAppNetworkUtils.amW().type);
                    mX.bH(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.u.c.b.this.getVersion());
                    mX.bH("thirdversion", com.baidu.swan.apps.u.c.b.this.getVersionCode());
                    mX.r("from", com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
                    mX.bH(SuspensionBallEntity.KEY_SCHEME, com.baidu.swan.apps.u.c.b.this.aji());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = aj.deleteQueryParam(i, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    mX.bH("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (i.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    if (z) {
                        mX.r("value", "arrive_success");
                    }
                    mX.bH("launchid", com.baidu.swan.apps.u.c.b.this.ajz());
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 0) {
                        mX.anC();
                    }
                    com.baidu.swan.apps.console.c.aW("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + com.baidu.swan.apps.u.c.b.this);
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void nh(String str) {
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
        mX("startup").bH("package_type", str2);
    }

    public static synchronized HybridUbcFlow anY() {
        HybridUbcFlow hybridUbcFlow = null;
        synchronized (i.class) {
            if (cyF) {
                Wv();
                HybridUbcFlow mZ = mZ("startup");
                if (mZ != null) {
                    mZ.f(new UbcFlowEvent("performanceEnd"));
                    mZ.anC();
                    mZ.anF();
                    mZ.anE();
                    mZ.anG();
                    hybridUbcFlow = mZ;
                }
            }
        }
        return hybridUbcFlow;
    }

    public static void anZ() {
        if (cyF) {
            cyI = new Timer();
            cyI.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.i.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    i.anY();
                }
            }, cyH);
        }
    }

    public static void Wv() {
        if (cyI != null) {
            cyI.cancel();
            cyI = null;
        }
    }

    public static synchronized void a(com.baidu.swan.apps.an.a aVar) {
        synchronized (i.class) {
            HybridUbcFlow anY = anY();
            if (anY != null) {
                anY.r("value", SmsLoginView.f.l);
                if (aVar != null) {
                    anY.bH("statusCode", String.valueOf(aVar.avT()));
                    anY.bH("launchid", com.baidu.swan.apps.runtime.d.arr().arn().arz().ajz());
                }
                anY.anD();
            }
        }
    }

    private static String i(com.baidu.swan.apps.u.c.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(cyJ)) {
                cyJ = com.baidu.swan.apps.scheme.actions.k.c.asT();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + cyJ);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + cyJ);
            }
        } else {
            cyJ = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + cyJ);
            }
        }
        return cyJ;
    }

    /* loaded from: classes7.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int cyL = 35;
        public JSONObject cyM;
        private boolean cyN = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a ni(String str) {
            this.mFrom = str;
            return this;
        }

        public a nj(String str) {
            this.mType = str;
            return this;
        }

        public a nk(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.cOz == null) {
                this.cOz = new JSONObject();
            }
            try {
                if (this.cyM != null) {
                    if (this.cyN) {
                        String m27if = al.m27if(cyL);
                        if (!TextUtils.isEmpty(m27if)) {
                            this.cyM.put("stacktrace", m27if);
                        }
                    }
                    this.cOz.put("info", this.cyM);
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
