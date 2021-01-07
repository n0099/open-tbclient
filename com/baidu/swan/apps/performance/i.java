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
    public static final boolean dtt = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_performance_aligned_search_switch", false);
    private static Timer dtu;
    public static String dtv;
    @Deprecated
    private static volatile b dtw;

    private static b aHz() {
        if (dtw == null) {
            synchronized (b.class) {
                if (dtw == null) {
                    dtw = new b();
                    a(dtw);
                }
            }
        }
        return dtw;
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
    public static synchronized HybridUbcFlow aHA() {
        HybridUbcFlow rd;
        synchronized (i.class) {
            rd = rd("startup");
        }
        return rd;
    }

    public static synchronized HybridUbcFlow rd(String str) {
        HybridUbcFlow rd;
        synchronized (i.class) {
            rd = aHz().rd(str);
        }
        return rd;
    }

    public static synchronized HybridUbcFlow ck(String str, String str2) {
        HybridUbcFlow ck;
        synchronized (i.class) {
            ck = aHz().ck(str, str2);
        }
        return ck;
    }

    public static synchronized HybridUbcFlow rf(String str) {
        HybridUbcFlow rf;
        synchronized (i.class) {
            rf = aHz().rf(str);
        }
        return rf;
    }

    public static synchronized void rl(String str) {
        synchronized (i.class) {
            aHz().re(str);
        }
    }

    public static synchronized void co(String str, String str2) {
        synchronized (i.class) {
            aHz().cl(str, str2);
        }
    }

    public static synchronized void cp(String str, String str2) {
        synchronized (i.class) {
            HybridUbcFlow rf = aHz().rf(str);
            if (rf != null) {
                aHz().rd(str2).d(rf);
                rl(str);
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
        com.baidu.swan.apps.console.c.bs("SwanAppPerformanceUBC", "recordForStartup");
        if (bVar != null && bVar.aCB() != null) {
            final String i = i(bVar);
            p.b(new Runnable() { // from class: com.baidu.swan.apps.performance.i.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow rd = i.rd("startup");
                    String aCw = TextUtils.isEmpty(com.baidu.swan.apps.u.c.b.this.aCw()) ? "NA" : com.baidu.swan.apps.u.c.b.this.aCw();
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1) {
                        rd.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    rd.q("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
                    rd.q("source", aCw);
                    rd.cn("appid", com.baidu.swan.apps.u.c.b.this.getAppId());
                    rd.cn(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME, com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.u.c.b.this.avW(), com.baidu.swan.apps.u.c.b.this.getAppFrameType()));
                    rd.cn("mobile", l.aRo());
                    long j = com.baidu.swan.apps.u.c.b.this.getLong("box_cold_launch", -1L);
                    if (j < 0) {
                        j = c.aHe();
                    }
                    if (j > 0) {
                        rd.cn("box_cold_launch", String.valueOf(j));
                    }
                    rd.cn("net", SwanAppNetworkUtils.aGD().type);
                    rd.cn("appversion", com.baidu.swan.apps.u.c.b.this.getVersion());
                    rd.cn("thirdversion", com.baidu.swan.apps.u.c.b.this.getVersionCode());
                    rd.q("from", com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1 ? "swangame" : GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
                    rd.cn("scheme", com.baidu.swan.apps.u.c.b.this.aCy());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ai.deleteQueryParam(i, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    rd.cn("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (i.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    if (z) {
                        rd.q("value", "arrive_success");
                    }
                    rd.cn(Constant.KEY_LAUNCHID, com.baidu.swan.apps.u.c.b.this.aCP());
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 0) {
                        rd.aHg();
                    }
                    com.baidu.swan.apps.console.c.bs("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + com.baidu.swan.apps.u.c.b.this);
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void rm(String str) {
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
        rd("startup").cn("package_type", str2);
    }

    public static synchronized HybridUbcFlow aHB() {
        HybridUbcFlow rf;
        synchronized (i.class) {
            aob();
            com.baidu.swan.apps.inlinewidget.f.b.b.azV();
            rf = rf("startup");
            if (rf == null) {
                rf = null;
            } else {
                rf.f(new UbcFlowEvent("performanceEnd"));
                rf.aHg();
                rf.aHj();
                rf.aHi();
                rf.aHk();
            }
        }
        return rf;
    }

    public static void aHC() {
        dtu = new Timer();
        dtu.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.i.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                i.aHB();
            }
        }, 15000L);
    }

    public static void aob() {
        if (dtu != null) {
            dtu.cancel();
            dtu = null;
        }
    }

    public static synchronized void d(com.baidu.swan.apps.al.a aVar) {
        synchronized (i.class) {
            HybridUbcFlow aHB = aHB();
            if (aHB != null) {
                aHB.q("value", SmsLoginView.f.l);
                if (aVar != null) {
                    aHB.cn("statusCode", String.valueOf(aVar.aQG()));
                    aHB.cn(Constant.KEY_LAUNCHID, com.baidu.swan.apps.runtime.d.aMh().aMd().aMp().aCP());
                }
                aHB.aHh();
            }
        }
    }

    private static String i(com.baidu.swan.apps.u.c.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(dtv)) {
                dtv = com.baidu.swan.apps.scheme.actions.k.c.aNE();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + dtv);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + dtv);
            }
        } else {
            dtv = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + dtv);
            }
        }
        return dtv;
    }

    /* loaded from: classes9.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int dtx = 35;
        public JSONObject dty;
        private boolean dtz = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a rn(String str) {
            this.mFrom = str;
            return this;
        }

        public a ro(String str) {
            this.mType = str;
            return this;
        }

        public a rp(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.dOd == null) {
                this.dOd = new JSONObject();
            }
            try {
                if (this.dty != null) {
                    if (this.dtz) {
                        String lP = ak.lP(dtx);
                        if (!TextUtils.isEmpty(lP)) {
                            this.dty.put("stacktrace", lP);
                        }
                    }
                    this.dOd.put("info", this.dty);
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
