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
/* loaded from: classes9.dex */
public final class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean dqO = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_performance_aligned_search_switch", false);
    private static Timer dqP;
    public static String dqQ;
    @Deprecated
    private static volatile b dqR;

    private static b aEa() {
        if (dqR == null) {
            synchronized (b.class) {
                if (dqR == null) {
                    dqR = new b();
                    a(dqR);
                }
            }
        }
        return dqR;
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
    public static synchronized HybridUbcFlow aEb() {
        HybridUbcFlow qk;
        synchronized (i.class) {
            qk = qk("startup");
        }
        return qk;
    }

    public static synchronized HybridUbcFlow qk(String str) {
        HybridUbcFlow qk;
        synchronized (i.class) {
            qk = aEa().qk(str);
        }
        return qk;
    }

    public static synchronized HybridUbcFlow cd(String str, String str2) {
        HybridUbcFlow cd;
        synchronized (i.class) {
            cd = aEa().cd(str, str2);
        }
        return cd;
    }

    public static synchronized HybridUbcFlow qm(String str) {
        HybridUbcFlow qm;
        synchronized (i.class) {
            qm = aEa().qm(str);
        }
        return qm;
    }

    public static synchronized void qs(String str) {
        synchronized (i.class) {
            aEa().ql(str);
        }
    }

    public static synchronized void ch(String str, String str2) {
        synchronized (i.class) {
            aEa().ce(str, str2);
        }
    }

    public static synchronized void ci(String str, String str2) {
        synchronized (i.class) {
            HybridUbcFlow qm = aEa().qm(str);
            if (qm != null) {
                aEa().qk(str2).d(qm);
                qs(str);
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
        com.baidu.swan.apps.console.c.bl("SwanAppPerformanceUBC", "recordForStartup");
        if (bVar != null && bVar.azf() != null) {
            final String i = i(bVar);
            p.b(new Runnable() { // from class: com.baidu.swan.apps.performance.i.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow qk = i.qk("startup");
                    String aza = TextUtils.isEmpty(com.baidu.swan.apps.u.c.b.this.aza()) ? "NA" : com.baidu.swan.apps.u.c.b.this.aza();
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1) {
                        qk.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    qk.o("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
                    qk.o("source", aza);
                    qk.cg("appid", com.baidu.swan.apps.u.c.b.this.getAppId());
                    qk.cg(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME, com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.u.c.b.this.asA(), com.baidu.swan.apps.u.c.b.this.getAppFrameType()));
                    qk.cg("mobile", l.aNN());
                    long j = com.baidu.swan.apps.u.c.b.this.getLong("box_cold_launch", -1L);
                    if (j < 0) {
                        j = c.aDG();
                    }
                    if (j > 0) {
                        qk.cg("box_cold_launch", String.valueOf(j));
                    }
                    qk.cg("net", SwanAppNetworkUtils.aDf().type);
                    qk.cg("appversion", com.baidu.swan.apps.u.c.b.this.getVersion());
                    qk.cg("thirdversion", com.baidu.swan.apps.u.c.b.this.getVersionCode());
                    qk.o("from", com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1 ? "swangame" : GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
                    qk.cg("scheme", com.baidu.swan.apps.u.c.b.this.azc());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ai.deleteQueryParam(i, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    qk.cg("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (i.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    if (z) {
                        qk.o("value", "arrive_success");
                    }
                    qk.cg(Constant.KEY_LAUNCHID, com.baidu.swan.apps.u.c.b.this.azt());
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 0) {
                        qk.aDI();
                    }
                    com.baidu.swan.apps.console.c.bl("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + com.baidu.swan.apps.u.c.b.this);
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void qt(String str) {
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
        qk("startup").cg("package_type", str2);
    }

    public static synchronized HybridUbcFlow aEc() {
        HybridUbcFlow qm;
        synchronized (i.class) {
            akF();
            com.baidu.swan.apps.inlinewidget.f.b.b.awz();
            qm = qm("startup");
            if (qm == null) {
                qm = null;
            } else {
                qm.f(new UbcFlowEvent("performanceEnd"));
                qm.aDI();
                qm.aDL();
                qm.aDK();
                qm.aDM();
            }
        }
        return qm;
    }

    public static void aEd() {
        dqP = new Timer();
        dqP.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.i.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                i.aEc();
            }
        }, 15000L);
    }

    public static void akF() {
        if (dqP != null) {
            dqP.cancel();
            dqP = null;
        }
    }

    public static synchronized void d(com.baidu.swan.apps.al.a aVar) {
        synchronized (i.class) {
            HybridUbcFlow aEc = aEc();
            if (aEc != null) {
                aEc.o("value", SmsLoginView.f.l);
                if (aVar != null) {
                    aEc.cg("statusCode", String.valueOf(aVar.aNf()));
                    aEc.cg(Constant.KEY_LAUNCHID, com.baidu.swan.apps.runtime.d.aIG().aIC().aIO().azt());
                }
                aEc.aDJ();
            }
        }
    }

    private static String i(com.baidu.swan.apps.u.c.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(dqQ)) {
                dqQ = com.baidu.swan.apps.scheme.actions.k.c.aKd();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + dqQ);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + dqQ);
            }
        } else {
            dqQ = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + dqQ);
            }
        }
        return dqQ;
    }

    /* loaded from: classes9.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int dqS = 35;
        public JSONObject dqT;
        private boolean dqU = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a qu(String str) {
            this.mFrom = str;
            return this;
        }

        public a qv(String str) {
            this.mType = str;
            return this;
        }

        public a qw(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.dLv == null) {
                this.dLv = new JSONObject();
            }
            try {
                if (this.dqT != null) {
                    if (this.dqU) {
                        String km = ak.km(dqS);
                        if (!TextUtils.isEmpty(km)) {
                            this.dqT.put("stacktrace", km);
                        }
                    }
                    this.dLv.put("info", this.dqT);
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
