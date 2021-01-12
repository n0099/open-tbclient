package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.l;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import java.io.File;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean doD = com.baidu.swan.apps.t.a.awB().getSwitch("swan_performance_aligned_search_switch", false);
    private static Timer doE;
    public static String doF;
    @Deprecated
    private static volatile b doG;

    private static b aDF() {
        if (doG == null) {
            synchronized (b.class) {
                if (doG == null) {
                    doG = new b();
                    a(doG);
                }
            }
        }
        return doG;
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
        HybridUbcFlow pS;
        synchronized (i.class) {
            pS = pS("startup");
        }
        return pS;
    }

    public static synchronized HybridUbcFlow pS(String str) {
        HybridUbcFlow pS;
        synchronized (i.class) {
            pS = aDF().pS(str);
        }
        return pS;
    }

    public static synchronized HybridUbcFlow cj(String str, String str2) {
        HybridUbcFlow cj;
        synchronized (i.class) {
            cj = aDF().cj(str, str2);
        }
        return cj;
    }

    public static synchronized HybridUbcFlow pU(String str) {
        HybridUbcFlow pU;
        synchronized (i.class) {
            pU = aDF().pU(str);
        }
        return pU;
    }

    public static synchronized void qa(String str) {
        synchronized (i.class) {
            aDF().pT(str);
        }
    }

    public static synchronized void cn(String str, String str2) {
        synchronized (i.class) {
            aDF().ck(str, str2);
        }
    }

    public static synchronized void co(String str, String str2) {
        synchronized (i.class) {
            HybridUbcFlow pU = aDF().pU(str);
            if (pU != null) {
                aDF().pS(str2).d(pU);
                qa(str);
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
        com.baidu.swan.apps.console.c.br("SwanAppPerformanceUBC", "recordForStartup");
        if (bVar != null && bVar.ayH() != null) {
            final String i = i(bVar);
            p.b(new Runnable() { // from class: com.baidu.swan.apps.performance.i.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow pS = i.pS("startup");
                    String ayC = TextUtils.isEmpty(com.baidu.swan.apps.u.c.b.this.ayC()) ? "NA" : com.baidu.swan.apps.u.c.b.this.ayC();
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1) {
                        pS.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    pS.q("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
                    pS.q("source", ayC);
                    pS.cm("appid", com.baidu.swan.apps.u.c.b.this.getAppId());
                    pS.cm(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME, com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.u.c.b.this.asb(), com.baidu.swan.apps.u.c.b.this.getAppFrameType()));
                    pS.cm("mobile", l.aNu());
                    long j = com.baidu.swan.apps.u.c.b.this.getLong("box_cold_launch", -1L);
                    if (j < 0) {
                        j = c.aDk();
                    }
                    if (j > 0) {
                        pS.cm("box_cold_launch", String.valueOf(j));
                    }
                    pS.cm("net", SwanAppNetworkUtils.aCJ().type);
                    pS.cm("appversion", com.baidu.swan.apps.u.c.b.this.getVersion());
                    pS.cm("thirdversion", com.baidu.swan.apps.u.c.b.this.getVersionCode());
                    pS.q("from", com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1 ? "swangame" : GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
                    pS.cm("scheme", com.baidu.swan.apps.u.c.b.this.ayE());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ai.deleteQueryParam(i, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    pS.cm("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (i.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    if (z) {
                        pS.q("value", "arrive_success");
                    }
                    pS.cm(Constant.KEY_LAUNCHID, com.baidu.swan.apps.u.c.b.this.ayV());
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 0) {
                        pS.aDm();
                    }
                    com.baidu.swan.apps.console.c.br("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + com.baidu.swan.apps.u.c.b.this);
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void qb(String str) {
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
        pS("startup").cm("package_type", str2);
    }

    public static synchronized HybridUbcFlow aDH() {
        HybridUbcFlow pU;
        synchronized (i.class) {
            akh();
            com.baidu.swan.apps.inlinewidget.f.b.b.awb();
            pU = pU("startup");
            if (pU == null) {
                pU = null;
            } else {
                pU.f(new UbcFlowEvent("performanceEnd"));
                pU.aDm();
                pU.aDp();
                pU.aDo();
                pU.aDq();
            }
        }
        return pU;
    }

    public static void aDI() {
        doE = new Timer();
        doE.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.i.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                i.aDH();
            }
        }, 15000L);
    }

    public static void akh() {
        if (doE != null) {
            doE.cancel();
            doE = null;
        }
    }

    public static synchronized void d(com.baidu.swan.apps.al.a aVar) {
        synchronized (i.class) {
            HybridUbcFlow aDH = aDH();
            if (aDH != null) {
                aDH.q("value", SmsLoginView.f.l);
                if (aVar != null) {
                    aDH.cm("statusCode", String.valueOf(aVar.aMM()));
                    aDH.cm(Constant.KEY_LAUNCHID, com.baidu.swan.apps.runtime.d.aIn().aIj().aIv().ayV());
                }
                aDH.aDn();
            }
        }
    }

    private static String i(com.baidu.swan.apps.u.c.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(doF)) {
                doF = com.baidu.swan.apps.scheme.actions.k.c.aJK();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + doF);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + doF);
            }
        } else {
            doF = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + doF);
            }
        }
        return doF;
    }

    /* loaded from: classes8.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int doH = 35;
        public JSONObject doI;
        private boolean doJ = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a qc(String str) {
            this.mFrom = str;
            return this;
        }

        public a qd(String str) {
            this.mType = str;
            return this;
        }

        public a qe(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.dJr == null) {
                this.dJr = new JSONObject();
            }
            try {
                if (this.doI != null) {
                    if (this.doJ) {
                        String kj = ak.kj(doH);
                        if (!TextUtils.isEmpty(kj)) {
                            this.doI.put("stacktrace", kj);
                        }
                    }
                    this.dJr.put("info", this.doI);
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
