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
/* loaded from: classes11.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @Deprecated
    private static b bHV;

    private static b ZX() {
        if (bHV == null) {
            bHV = new b();
            a(bHV);
        }
        return bHV;
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
    public static synchronized HybridUbcFlow ZY() {
        HybridUbcFlow jO;
        synchronized (f.class) {
            jO = jO("startup");
        }
        return jO;
    }

    public static synchronized HybridUbcFlow jO(String str) {
        HybridUbcFlow jO;
        synchronized (f.class) {
            jO = ZX().jO(str);
        }
        return jO;
    }

    public static synchronized HybridUbcFlow aX(String str, String str2) {
        HybridUbcFlow aX;
        synchronized (f.class) {
            aX = ZX().aX(str, str2);
        }
        return aX;
    }

    public static synchronized void jU(String str) {
        synchronized (f.class) {
            ZX().jP(str);
        }
    }

    public static synchronized void bb(String str, String str2) {
        synchronized (f.class) {
            ZX().aY(str, str2);
        }
    }

    public static synchronized void bc(String str, String str2) {
        synchronized (f.class) {
            HybridUbcFlow jQ = ZX().jQ(str);
            if (jQ != null) {
                ZX().jO(str2).c(jQ);
                jU(str);
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
        if (bVar != null && bVar.VR() != null) {
            final String page = bVar.getPage();
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.f.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow jO = f.jO("startup");
                    String VM = TextUtils.isEmpty(com.baidu.swan.apps.x.b.b.this.VM()) ? "NA" : com.baidu.swan.apps.x.b.b.this.VM();
                    if (com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 1) {
                        jO.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    jO.k("from", "swan");
                    jO.k("source", VM);
                    jO.ba("appid", com.baidu.swan.apps.x.b.b.this.getAppId());
                    jO.ba("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.x.b.b.this.QT(), com.baidu.swan.apps.x.b.b.this.getAppFrameType()));
                    jO.ba("mobile", j.agM());
                    jO.ba("net", SwanAppNetworkUtils.Zc().type);
                    jO.ba(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.x.b.b.this.getVersion());
                    jO.ba("thirdversion", com.baidu.swan.apps.x.b.b.this.getVersionCode());
                    jO.k("from", com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
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
                    jO.ba("path", deleteQueryParam);
                    jO.ba("launchid", com.baidu.swan.apps.x.b.b.this.Wf());
                    if (com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 0) {
                        jO.ZD();
                    }
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void jV(String str) {
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
        jO("startup").ba("package_type", str2);
    }

    /* loaded from: classes11.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int bHW = 35;
        public JSONObject bHX;
        private boolean bHY = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a jW(String str) {
            this.mFrom = str;
            return this;
        }

        public a jX(String str) {
            this.mType = str;
            return this;
        }

        public a jY(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.bVx == null) {
                this.bVx = new JSONObject();
            }
            try {
                if (this.bHX != null) {
                    if (this.bHY) {
                        String hf = ai.hf(bHW);
                        if (!TextUtils.isEmpty(hf)) {
                            this.bHX.put("stacktrace", hf);
                        }
                    }
                    this.bVx.put("info", this.bHX);
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
