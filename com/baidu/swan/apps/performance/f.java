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
/* loaded from: classes9.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @Deprecated
    private static b bCR;

    private static b Xh() {
        if (bCR == null) {
            bCR = new b();
            a(bCR);
        }
        return bCR;
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
    public static synchronized HybridUbcFlow Xi() {
        HybridUbcFlow jx;
        synchronized (f.class) {
            jx = jx("startup");
        }
        return jx;
    }

    public static synchronized HybridUbcFlow jx(String str) {
        HybridUbcFlow jx;
        synchronized (f.class) {
            jx = Xh().jx(str);
        }
        return jx;
    }

    public static synchronized HybridUbcFlow aO(String str, String str2) {
        HybridUbcFlow aO;
        synchronized (f.class) {
            aO = Xh().aO(str, str2);
        }
        return aO;
    }

    public static synchronized void jD(String str) {
        synchronized (f.class) {
            Xh().jy(str);
        }
    }

    public static synchronized void aS(String str, String str2) {
        synchronized (f.class) {
            Xh().aP(str, str2);
        }
    }

    public static synchronized void aT(String str, String str2) {
        synchronized (f.class) {
            HybridUbcFlow jz = Xh().jz(str);
            if (jz != null) {
                Xh().jx(str2).c(jz);
                jD(str);
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
        if (bVar != null && bVar.Tb() != null) {
            final String page = bVar.getPage();
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.f.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow jx = f.jx("startup");
                    String SW = TextUtils.isEmpty(com.baidu.swan.apps.x.b.b.this.SW()) ? "NA" : com.baidu.swan.apps.x.b.b.this.SW();
                    if (com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 1) {
                        jx.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    jx.k("from", "swan");
                    jx.k("source", SW);
                    jx.aR("appid", com.baidu.swan.apps.x.b.b.this.getAppId());
                    jx.aR("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.x.b.b.this.Oe(), com.baidu.swan.apps.x.b.b.this.getAppFrameType()));
                    jx.aR("mobile", j.aea());
                    jx.aR("net", SwanAppNetworkUtils.Wm().type);
                    jx.aR(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.x.b.b.this.getVersion());
                    jx.aR("thirdversion", com.baidu.swan.apps.x.b.b.this.getVersionCode());
                    jx.k("from", com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
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
                    jx.aR("path", deleteQueryParam);
                    jx.aR("launchid", com.baidu.swan.apps.x.b.b.this.Tp());
                    if (com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 0) {
                        jx.WN();
                    }
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void jE(String str) {
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
        jx("startup").aR("package_type", str2);
    }

    /* loaded from: classes9.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int bCS = 35;
        public JSONObject bCT;
        private boolean bCU = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a jF(String str) {
            this.mFrom = str;
            return this;
        }

        public a jG(String str) {
            this.mType = str;
            return this;
        }

        public a jH(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.bQv == null) {
                this.bQv = new JSONObject();
            }
            try {
                if (this.bCT != null) {
                    if (this.bCU) {
                        String gO = ai.gO(bCS);
                        if (!TextUtils.isEmpty(gO)) {
                            this.bCT.put("stacktrace", gO);
                        }
                    }
                    this.bQv.put("info", this.bCT);
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
