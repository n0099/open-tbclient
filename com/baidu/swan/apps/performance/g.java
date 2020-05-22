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
    public static final boolean crD = com.baidu.swan.apps.u.a.aeU().getSwitch("swan_app_use_performance_end", false);
    private static final int crE = com.baidu.swan.apps.u.a.aeU().getSwitch("swan_app_delay_upload_performance_ubc", 15000);
    private static Timer crF;
    public static String crG;
    @Deprecated
    private static b crH;

    private static b alw() {
        if (crH == null) {
            crH = new b();
            a(crH);
        }
        return crH;
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
    public static synchronized HybridUbcFlow alx() {
        HybridUbcFlow mp;
        synchronized (g.class) {
            mp = mp("startup");
        }
        return mp;
    }

    public static synchronized HybridUbcFlow mp(String str) {
        HybridUbcFlow mp;
        synchronized (g.class) {
            mp = alw().mp(str);
        }
        return mp;
    }

    public static synchronized HybridUbcFlow bA(String str, String str2) {
        HybridUbcFlow bA;
        synchronized (g.class) {
            bA = alw().bA(str, str2);
        }
        return bA;
    }

    public static synchronized HybridUbcFlow mr(String str) {
        HybridUbcFlow mr;
        synchronized (g.class) {
            mr = alw().mr(str);
        }
        return mr;
    }

    public static synchronized void mw(String str) {
        synchronized (g.class) {
            alw().mq(str);
        }
    }

    public static synchronized void bE(String str, String str2) {
        synchronized (g.class) {
            alw().bB(str, str2);
        }
    }

    public static synchronized void bF(String str, String str2) {
        synchronized (g.class) {
            HybridUbcFlow mr = alw().mr(str);
            if (mr != null) {
                alw().mp(str2).c(mr);
                mw(str);
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
        if (bVar != null && bVar.agP() != null) {
            final String k = k(bVar);
            n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.g.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow mp = g.mp("startup");
                    String agK = TextUtils.isEmpty(com.baidu.swan.apps.v.b.b.this.agK()) ? "NA" : com.baidu.swan.apps.v.b.b.this.agK();
                    if (com.baidu.swan.apps.v.b.b.this.getAppFrameType() == 1) {
                        mp.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    mp.r("from", "swan");
                    mp.r("source", agK);
                    mp.bD("appid", com.baidu.swan.apps.v.b.b.this.getAppId());
                    mp.bD("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.b.b.this.abG(), com.baidu.swan.apps.v.b.b.this.getAppFrameType()));
                    mp.bD("mobile", k.ats());
                    mp.bD("net", SwanAppNetworkUtils.akA().type);
                    mp.bD(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.v.b.b.this.getVersion());
                    mp.bD("thirdversion", com.baidu.swan.apps.v.b.b.this.getVersionCode());
                    mp.r("from", com.baidu.swan.apps.v.b.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
                    mp.bD(SuspensionBallEntity.KEY_SCHEME, com.baidu.swan.apps.v.b.b.this.agM());
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ah.deleteQueryParam(k, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    mp.bD("path", TextUtils.isEmpty(deleteQueryParam) ? "" : deleteQueryParam);
                    if (g.DEBUG) {
                        StringBuilder append = new StringBuilder().append("PerformanceUbc path: ");
                        if (TextUtils.isEmpty(deleteQueryParam)) {
                            deleteQueryParam = "";
                        }
                        Log.v("SwanAppPerformanceUBC", append.append(deleteQueryParam).toString());
                    }
                    mp.bD("launchid", com.baidu.swan.apps.v.b.b.this.ahd());
                    if (com.baidu.swan.apps.v.b.b.this.getAppFrameType() == 0) {
                        mp.alc();
                    }
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void mx(String str) {
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
        mp("startup").bD("package_type", str2);
    }

    public static synchronized HybridUbcFlow aly() {
        HybridUbcFlow hybridUbcFlow = null;
        synchronized (g.class) {
            if (crD) {
                UI();
                HybridUbcFlow mr = mr("startup");
                if (mr != null) {
                    mr.f(new UbcFlowEvent("performanceEnd"));
                    mr.alc();
                    mr.alf();
                    mr.ale();
                    mr.alg();
                    hybridUbcFlow = mr;
                }
            }
        }
        return hybridUbcFlow;
    }

    public static void alz() {
        if (crD) {
            crF = new Timer();
            crF.schedule(new TimerTask() { // from class: com.baidu.swan.apps.performance.g.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    g.aly();
                }
            }, crE);
        }
    }

    public static void UI() {
        if (crF != null) {
            crF.cancel();
            crF = null;
        }
    }

    public static synchronized void a(com.baidu.swan.apps.an.a aVar) {
        synchronized (g.class) {
            HybridUbcFlow aly = aly();
            if (aly != null) {
                if (aVar != null) {
                    aly.bD("statusCode", String.valueOf(aVar.asM()));
                }
                aly.ald();
            }
        }
    }

    private static String k(com.baidu.swan.apps.v.b.b bVar) {
        String page = bVar.getPage();
        if (TextUtils.isEmpty(page)) {
            if (TextUtils.isEmpty(crG)) {
                crG = com.baidu.swan.apps.scheme.actions.k.c.apW();
                if (DEBUG) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + crG);
                }
            } else if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + crG);
            }
        } else {
            crG = page;
            if (DEBUG) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + crG);
            }
        }
        return crG;
    }

    /* loaded from: classes11.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int crI = 35;
        public JSONObject crJ;
        private boolean crK = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a my(String str) {
            this.mFrom = str;
            return this;
        }

        public a mz(String str) {
            this.mType = str;
            return this;
        }

        public a mA(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.cGu == null) {
                this.cGu = new JSONObject();
            }
            try {
                if (this.crJ != null) {
                    if (this.crK) {
                        String hH = aj.hH(crI);
                        if (!TextUtils.isEmpty(hH)) {
                            this.crJ.put("stacktrace", hH);
                        }
                    }
                    this.cGu.put("info", this.crJ);
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
