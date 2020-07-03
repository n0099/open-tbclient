package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.k;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean cwr = com.baidu.swan.apps.u.a.aga().getSwitch("swan_app_use_performance_end", false);
    private static final int cws = com.baidu.swan.apps.u.a.aga().getSwitch("swan_app_delay_upload_performance_ubc", 15000);
    private static Timer cwt;
    public static String cwu;
    @Deprecated
    private static b cwv;

    private static b amC() {
        if (cwv == null) {
            cwv = new b();
            a(cwv);
        }
        return cwv;
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
    public static synchronized HybridUbcFlow amD() {
        HybridUbcFlow mx;
        synchronized (g.class) {
            mx = mx("startup");
        }
        return mx;
    }

    public static synchronized HybridUbcFlow mx(String str) {
        HybridUbcFlow mx;
        synchronized (g.class) {
            mx = amC().mx(str);
        }
        return mx;
    }

    public static synchronized HybridUbcFlow bC(String str, String str2) {
        HybridUbcFlow bC;
        synchronized (g.class) {
            bC = amC().bC(str, str2);
        }
        return bC;
    }

    public static synchronized HybridUbcFlow mz(String str) {
        HybridUbcFlow mz;
        synchronized (g.class) {
            mz = amC().mz(str);
        }
        return mz;
    }

    public static synchronized void mE(String str) {
        synchronized (g.class) {
            amC().my(str);
        }
    }

    public static synchronized void bG(String str, String str2) {
        synchronized (g.class) {
            amC().bD(str, str2);
        }
    }

    public static synchronized void bH(String str, String str2) {
        synchronized (g.class) {
            HybridUbcFlow mz = amC().mz(str);
            if (mz != null) {
                amC().mx(str2).c(mz);
                mE(str);
            }
        }
    }

    public static void i(final com.baidu.swan.apps.v.b.b bVar) {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.performance.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.j(com.baidu.swan.apps.v.b.b.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(final com.baidu.swan.apps.v.b.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup: info=" + bVar);
        }
        if (bVar != null && bVar.ahV() != null) {
            final String k = k(bVar);
            n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.g.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow mx = g.mx("startup");
                    String ahQ = TextUtils.isEmpty(com.baidu.swan.apps.v.b.b.this.ahQ()) ? "NA" : com.baidu.swan.apps.v.b.b.this.ahQ();
                    if (com.baidu.swan.apps.v.b.b.this.getAppFrameType() == 1) {
                        mx.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    mx.r("from", "swan");
                    mx.r("source", ahQ);
                    mx.bF("appid", com.baidu.swan.apps.v.b.b.this.getAppId());
                    mx.bF("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.b.b.this.acM(), com.baidu.swan.apps.v.b.b.this.getAppFrameType()));
                    mx.bF("mobile", k.auy());
                    mx.bF("net", SwanAppNetworkUtils.alG().type);
                    mx.bF(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.v.b.b.this.getVersion());
                    mx.bF("thirdversion", com.baidu.swan.apps.v.b.b.this.getVersionCode());
                    mx.r("from", com.baidu.swan.apps.v.b.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
                    mx.bF(SuspensionBallEntity.KEY_SCHEME, com.baidu.swan.apps.v.b.b.this.ahS());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ah.deleteQueryParam(k, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    mx.bF("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (g.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    mx.bF("launchid", com.baidu.swan.apps.v.b.b.this.aij());
                    if (com.baidu.swan.apps.v.b.b.this.getAppFrameType() == 0) {
                        mx.ami();
                    }
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void mF(String str) {
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
        mx("startup").bF("package_type", str2);
    }

    public static synchronized HybridUbcFlow amE() {
        HybridUbcFlow hybridUbcFlow = null;
        synchronized (g.class) {
            if (cwr) {
                VO();
                HybridUbcFlow mz = mz("startup");
                if (mz != null) {
                    mz.f(new UbcFlowEvent("performanceEnd"));
                    mz.ami();
                    mz.aml();
                    mz.amk();
                    mz.amm();
                    hybridUbcFlow = mz;
                }
            }
        }
        return hybridUbcFlow;
    }

    public static void amF() {
        if (cwr) {
            cwt = new Timer();
            cwt.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.g.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    g.amE();
                }
            }, cws);
        }
    }

    public static void VO() {
        if (cwt != null) {
            cwt.cancel();
            cwt = null;
        }
    }

    public static synchronized void a(com.baidu.swan.apps.an.a aVar) {
        synchronized (g.class) {
            HybridUbcFlow amE = amE();
            if (amE != null) {
                if (aVar != null) {
                    amE.bF("statusCode", String.valueOf(aVar.atS()));
                }
                amE.amj();
            }
        }
    }

    private static String k(com.baidu.swan.apps.v.b.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(cwu)) {
                cwu = com.baidu.swan.apps.scheme.actions.k.c.arc();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + cwu);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + cwu);
            }
        } else {
            cwu = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + cwu);
            }
        }
        return cwu;
    }

    /* loaded from: classes11.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int cww = 35;
        public JSONObject cwx;
        private boolean cwy = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a mG(String str) {
            this.mFrom = str;
            return this;
        }

        public a mH(String str) {
            this.mType = str;
            return this;
        }

        public a mI(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.cLe == null) {
                this.cLe = new JSONObject();
            }
            try {
                if (this.cwx != null) {
                    if (this.cwy) {
                        String hU = aj.hU(cww);
                        if (!TextUtils.isEmpty(hU)) {
                            this.cwx.put("stacktrace", hU);
                        }
                    }
                    this.cLe.put("info", this.cwx);
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
