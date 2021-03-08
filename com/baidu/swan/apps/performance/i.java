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
    public static final boolean dsq = com.baidu.swan.apps.t.a.axc().getSwitch("swan_performance_aligned_search_switch", false);
    private static Timer dsr;
    public static String dss;
    @Deprecated
    private static volatile b dsu;

    private static b aEd() {
        if (dsu == null) {
            synchronized (b.class) {
                if (dsu == null) {
                    dsu = new b();
                    a(dsu);
                }
            }
        }
        return dsu;
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
    public static synchronized HybridUbcFlow aEe() {
        HybridUbcFlow qr;
        synchronized (i.class) {
            qr = qr("startup");
        }
        return qr;
    }

    public static synchronized HybridUbcFlow qr(String str) {
        HybridUbcFlow qr;
        synchronized (i.class) {
            qr = aEd().qr(str);
        }
        return qr;
    }

    public static synchronized HybridUbcFlow cd(String str, String str2) {
        HybridUbcFlow cd;
        synchronized (i.class) {
            cd = aEd().cd(str, str2);
        }
        return cd;
    }

    public static synchronized HybridUbcFlow qt(String str) {
        HybridUbcFlow qt;
        synchronized (i.class) {
            qt = aEd().qt(str);
        }
        return qt;
    }

    public static synchronized void qz(String str) {
        synchronized (i.class) {
            aEd().qs(str);
        }
    }

    public static synchronized void ch(String str, String str2) {
        synchronized (i.class) {
            aEd().ce(str, str2);
        }
    }

    public static synchronized void ci(String str, String str2) {
        synchronized (i.class) {
            HybridUbcFlow qt = aEd().qt(str);
            if (qt != null) {
                aEd().qr(str2).d(qt);
                qz(str);
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
        if (bVar != null && bVar.azi() != null) {
            final String i = i(bVar);
            p.b(new Runnable() { // from class: com.baidu.swan.apps.performance.i.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow qr = i.qr("startup");
                    String azd = TextUtils.isEmpty(com.baidu.swan.apps.u.c.b.this.azd()) ? "NA" : com.baidu.swan.apps.u.c.b.this.azd();
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1) {
                        qr.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    qr.p("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
                    qr.p("source", azd);
                    qr.cg("appid", com.baidu.swan.apps.u.c.b.this.getAppId());
                    qr.cg(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME, com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.u.c.b.this.asD(), com.baidu.swan.apps.u.c.b.this.getAppFrameType()));
                    qr.cg("mobile", l.aNQ());
                    long j = com.baidu.swan.apps.u.c.b.this.getLong("box_cold_launch", -1L);
                    if (j < 0) {
                        j = c.aDJ();
                    }
                    if (j > 0) {
                        qr.cg("box_cold_launch", String.valueOf(j));
                    }
                    qr.cg("net", SwanAppNetworkUtils.aDi().type);
                    qr.cg("appversion", com.baidu.swan.apps.u.c.b.this.getVersion());
                    qr.cg("thirdversion", com.baidu.swan.apps.u.c.b.this.getVersionCode());
                    qr.p("from", com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1 ? "swangame" : GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
                    qr.cg("scheme", com.baidu.swan.apps.u.c.b.this.azf());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ai.deleteQueryParam(i, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    qr.cg("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (i.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    if (z) {
                        qr.p("value", "arrive_success");
                    }
                    qr.cg(Constant.KEY_LAUNCHID, com.baidu.swan.apps.u.c.b.this.azw());
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 0) {
                        qr.aDL();
                    }
                    com.baidu.swan.apps.console.c.bl("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + com.baidu.swan.apps.u.c.b.this);
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void qA(String str) {
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
        qr("startup").cg("package_type", str2);
    }

    public static synchronized HybridUbcFlow aEf() {
        HybridUbcFlow qt;
        synchronized (i.class) {
            akI();
            com.baidu.swan.apps.inlinewidget.f.b.b.awC();
            qt = qt("startup");
            if (qt == null) {
                qt = null;
            } else {
                qt.f(new UbcFlowEvent("performanceEnd"));
                qt.aDL();
                qt.aDO();
                qt.aDN();
                qt.aDP();
            }
        }
        return qt;
    }

    public static void aEg() {
        dsr = new Timer();
        dsr.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.i.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                i.aEf();
            }
        }, 15000L);
    }

    public static void akI() {
        if (dsr != null) {
            dsr.cancel();
            dsr = null;
        }
    }

    public static synchronized void d(com.baidu.swan.apps.al.a aVar) {
        synchronized (i.class) {
            HybridUbcFlow aEf = aEf();
            if (aEf != null) {
                aEf.p("value", SmsLoginView.f.l);
                if (aVar != null) {
                    aEf.cg("statusCode", String.valueOf(aVar.aNi()));
                    aEf.cg(Constant.KEY_LAUNCHID, com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR().azw());
                }
                aEf.aDM();
            }
        }
    }

    private static String i(com.baidu.swan.apps.u.c.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(dss)) {
                dss = com.baidu.swan.apps.scheme.actions.k.c.aKg();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + dss);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + dss);
            }
        } else {
            dss = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + dss);
            }
        }
        return dss;
    }

    /* loaded from: classes8.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int dsv = 35;
        public JSONObject dsw;
        private boolean dsx = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a qB(String str) {
            this.mFrom = str;
            return this;
        }

        public a qC(String str) {
            this.mType = str;
            return this;
        }

        public a qD(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.dMW == null) {
                this.dMW = new JSONObject();
            }
            try {
                if (this.dsw != null) {
                    if (this.dsx) {
                        String kn = ak.kn(dsv);
                        if (!TextUtils.isEmpty(kn)) {
                            this.dsw.put("stacktrace", kn);
                        }
                    }
                    this.dMW.put("info", this.dsw);
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
