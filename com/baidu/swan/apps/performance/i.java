package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.l;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import java.io.File;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public final class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean dou = com.baidu.swan.apps.t.a.azd().getSwitch("swan_performance_aligned_search_switch", false);
    private static Timer dov;
    public static String dow;
    @Deprecated
    private static volatile b dox;

    private static b aGf() {
        if (dox == null) {
            synchronized (b.class) {
                if (dox == null) {
                    dox = new b();
                    a(dox);
                }
            }
        }
        return dox;
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
    public static synchronized HybridUbcFlow aGg() {
        HybridUbcFlow rk;
        synchronized (i.class) {
            rk = rk("startup");
        }
        return rk;
    }

    public static synchronized HybridUbcFlow rk(String str) {
        HybridUbcFlow rk;
        synchronized (i.class) {
            rk = aGf().rk(str);
        }
        return rk;
    }

    public static synchronized HybridUbcFlow cl(String str, String str2) {
        HybridUbcFlow cl;
        synchronized (i.class) {
            cl = aGf().cl(str, str2);
        }
        return cl;
    }

    public static synchronized HybridUbcFlow rm(String str) {
        HybridUbcFlow rm;
        synchronized (i.class) {
            rm = aGf().rm(str);
        }
        return rm;
    }

    public static synchronized void rs(String str) {
        synchronized (i.class) {
            aGf().rl(str);
        }
    }

    public static synchronized void cp(String str, String str2) {
        synchronized (i.class) {
            aGf().cm(str, str2);
        }
    }

    public static synchronized void cq(String str, String str2) {
        synchronized (i.class) {
            HybridUbcFlow rm = aGf().rm(str);
            if (rm != null) {
                aGf().rk(str2).d(rm);
                rs(str);
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
        com.baidu.swan.apps.console.c.bt("SwanAppPerformanceUBC", "recordForStartup");
        if (bVar != null && bVar.aBj() != null) {
            final String i = i(bVar);
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.i.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow rk = i.rk("startup");
                    String aBe = TextUtils.isEmpty(com.baidu.swan.apps.u.c.b.this.aBe()) ? "NA" : com.baidu.swan.apps.u.c.b.this.aBe();
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1) {
                        rk.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    rk.q("from", "swan");
                    rk.q("source", aBe);
                    rk.co("appid", com.baidu.swan.apps.u.c.b.this.getAppId());
                    rk.co("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.u.c.b.this.auD(), com.baidu.swan.apps.u.c.b.this.getAppFrameType()));
                    rk.co("mobile", l.aOW());
                    long j = com.baidu.swan.apps.u.c.b.this.getLong("box_cold_launch", -1L);
                    if (j < 0) {
                        j = c.aFJ();
                    }
                    if (j > 0) {
                        rk.co("box_cold_launch", String.valueOf(j));
                    }
                    rk.co("net", SwanAppNetworkUtils.aFi().type);
                    rk.co("appversion", com.baidu.swan.apps.u.c.b.this.getVersion());
                    rk.co("thirdversion", com.baidu.swan.apps.u.c.b.this.getVersionCode());
                    rk.q("from", com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
                    rk.co("scheme", com.baidu.swan.apps.u.c.b.this.aBg());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ai.deleteQueryParam(i, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    rk.co("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (i.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    if (z) {
                        rk.q("value", "arrive_success");
                    }
                    rk.co(Constant.KEY_LAUNCHID, com.baidu.swan.apps.u.c.b.this.aBx());
                    if (com.baidu.swan.apps.u.c.b.this.getAppFrameType() == 0) {
                        rk.aFL();
                    }
                    com.baidu.swan.apps.console.c.bt("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + com.baidu.swan.apps.u.c.b.this);
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void rt(String str) {
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
        rk("startup").co("package_type", str2);
    }

    public static synchronized HybridUbcFlow aGh() {
        HybridUbcFlow rm;
        synchronized (i.class) {
            amQ();
            com.baidu.swan.apps.inlinewidget.f.b.b.ayD();
            rm = rm("startup");
            if (rm == null) {
                rm = null;
            } else {
                rm.f(new UbcFlowEvent("performanceEnd"));
                rm.aFL();
                rm.aFO();
                rm.aFN();
                rm.aFP();
            }
        }
        return rm;
    }

    public static void aGi() {
        dov = new Timer();
        dov.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.i.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                i.aGh();
            }
        }, 15000L);
    }

    public static void amQ() {
        if (dov != null) {
            dov.cancel();
            dov = null;
        }
    }

    public static synchronized void d(com.baidu.swan.apps.am.a aVar) {
        synchronized (i.class) {
            HybridUbcFlow aGh = aGh();
            if (aGh != null) {
                aGh.q("value", SmsLoginView.f.l);
                if (aVar != null) {
                    aGh.co("statusCode", String.valueOf(aVar.aOo()));
                    aGh.co(Constant.KEY_LAUNCHID, com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY().aBx());
                }
                aGh.aFM();
            }
        }
    }

    private static String i(com.baidu.swan.apps.u.c.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(dow)) {
                dow = com.baidu.swan.apps.scheme.actions.k.c.aLn();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + dow);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + dow);
            }
        } else {
            dow = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + dow);
            }
        }
        return dow;
    }

    /* loaded from: classes25.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int doy = 35;
        private boolean doA = true;
        public JSONObject doz;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a ru(String str) {
            this.mFrom = str;
            return this;
        }

        public a rv(String str) {
            this.mType = str;
            return this;
        }

        public a rw(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.dFz == null) {
                this.dFz = new JSONObject();
            }
            try {
                if (this.doz != null) {
                    if (this.doA) {
                        String lK = ak.lK(doy);
                        if (!TextUtils.isEmpty(lK)) {
                            this.doz.put("stacktrace", lK);
                        }
                    }
                    this.dFz.put("info", this.doz);
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
