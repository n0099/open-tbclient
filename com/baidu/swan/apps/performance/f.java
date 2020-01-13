package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.j;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.ubc.s;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @Deprecated
    private static b bDC;

    private static b XE() {
        if (bDC == null) {
            bDC = new b();
            a(bDC);
        }
        return bDC;
    }

    private static void a(b bVar) {
        bVar.b("preload", new com.baidu.swan.apps.performance.a.a()).b("startup", new com.baidu.swan.apps.performance.a.c()).b("route", new com.baidu.swan.apps.performance.a.b());
    }

    public static void onEvent(a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "onEvent " + aVar);
        }
        s.k(aVar.eventId, aVar.toJSONObject());
    }

    @Deprecated
    public static synchronized HybridUbcFlow XF() {
        HybridUbcFlow jA;
        synchronized (f.class) {
            jA = jA("startup");
        }
        return jA;
    }

    public static synchronized HybridUbcFlow jA(String str) {
        HybridUbcFlow jA;
        synchronized (f.class) {
            jA = XE().jA(str);
        }
        return jA;
    }

    public static synchronized HybridUbcFlow aP(String str, String str2) {
        HybridUbcFlow aP;
        synchronized (f.class) {
            aP = XE().aP(str, str2);
        }
        return aP;
    }

    public static synchronized void jG(String str) {
        synchronized (f.class) {
            XE().jB(str);
        }
    }

    public static synchronized void aT(String str, String str2) {
        synchronized (f.class) {
            XE().aQ(str, str2);
        }
    }

    public static synchronized void aU(String str, String str2) {
        synchronized (f.class) {
            HybridUbcFlow jC = XE().jC(str);
            if (jC != null) {
                XE().jA(str2).c(jC);
                jG(str);
            }
        }
    }

    public static void h(final com.baidu.swan.apps.x.b.b bVar) {
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.performance.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.i(com.baidu.swan.apps.x.b.b.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(final com.baidu.swan.apps.x.b.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup: info=" + bVar);
        }
        if (bVar != null && bVar.Ty() != null) {
            final String page = bVar.getPage();
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.f.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow jA = f.jA("startup");
                    String Tt = TextUtils.isEmpty(com.baidu.swan.apps.x.b.b.this.Tt()) ? "NA" : com.baidu.swan.apps.x.b.b.this.Tt();
                    if (com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 1) {
                        jA.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    jA.k("from", "swan");
                    jA.k("source", Tt);
                    jA.aS("appid", com.baidu.swan.apps.x.b.b.this.getAppId());
                    jA.aS("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.x.b.b.this.OA(), com.baidu.swan.apps.x.b.b.this.getAppFrameType()));
                    jA.aS("mobile", j.aet());
                    jA.aS("net", SwanAppNetworkUtils.WJ().type);
                    jA.aS(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.x.b.b.this.getVersion());
                    jA.aS("thirdversion", com.baidu.swan.apps.x.b.b.this.getVersionCode());
                    jA.k("from", com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
                    HashSet hashSet = new HashSet();
                    hashSet.add(BuyTBeanActivityConfig.CALLBACK);
                    hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
                    String deleteQueryParam = ag.deleteQueryParam(page, hashSet);
                    if (!TextUtils.isEmpty(deleteQueryParam) && deleteQueryParam.startsWith(File.separator)) {
                        deleteQueryParam = deleteQueryParam.substring(1);
                    }
                    if (TextUtils.isEmpty(deleteQueryParam)) {
                        deleteQueryParam = "";
                    }
                    jA.aS("path", deleteQueryParam);
                    jA.aS("launchid", com.baidu.swan.apps.x.b.b.this.TM());
                    if (com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 0) {
                        jA.Xk();
                    }
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void jH(String str) {
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
            default:
                str2 = "-1";
                break;
        }
        jA("startup").aS("package_type", str2);
    }

    /* loaded from: classes10.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int bDD = 35;
        public JSONObject bDE;
        private boolean bDF = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a jI(String str) {
            this.mFrom = str;
            return this;
        }

        public a jJ(String str) {
            this.mType = str;
            return this;
        }

        public a jK(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.bRf == null) {
                this.bRf = new JSONObject();
            }
            try {
                if (this.bDE != null) {
                    if (this.bDF) {
                        String gO = ai.gO(bDD);
                        if (!TextUtils.isEmpty(gO)) {
                            this.bDE.put("stacktrace", gO);
                        }
                    }
                    this.bRf.put("info", this.bDE);
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
