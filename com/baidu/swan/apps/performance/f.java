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
    private static b bHI;

    private static b ZS() {
        if (bHI == null) {
            bHI = new b();
            a(bHI);
        }
        return bHI;
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
    public static synchronized HybridUbcFlow ZT() {
        HybridUbcFlow jP;
        synchronized (f.class) {
            jP = jP("startup");
        }
        return jP;
    }

    public static synchronized HybridUbcFlow jP(String str) {
        HybridUbcFlow jP;
        synchronized (f.class) {
            jP = ZS().jP(str);
        }
        return jP;
    }

    public static synchronized HybridUbcFlow aY(String str, String str2) {
        HybridUbcFlow aY;
        synchronized (f.class) {
            aY = ZS().aY(str, str2);
        }
        return aY;
    }

    public static synchronized void jV(String str) {
        synchronized (f.class) {
            ZS().jQ(str);
        }
    }

    public static synchronized void bc(String str, String str2) {
        synchronized (f.class) {
            ZS().aZ(str, str2);
        }
    }

    public static synchronized void bd(String str, String str2) {
        synchronized (f.class) {
            HybridUbcFlow jR = ZS().jR(str);
            if (jR != null) {
                ZS().jP(str2).c(jR);
                jV(str);
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
        if (bVar != null && bVar.VM() != null) {
            final String page = bVar.getPage();
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.f.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow jP = f.jP("startup");
                    String VH = TextUtils.isEmpty(com.baidu.swan.apps.x.b.b.this.VH()) ? "NA" : com.baidu.swan.apps.x.b.b.this.VH();
                    if (com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 1) {
                        jP.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    jP.k("from", "swan");
                    jP.k("source", VH);
                    jP.bb("appid", com.baidu.swan.apps.x.b.b.this.getAppId());
                    jP.bb("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.x.b.b.this.QO(), com.baidu.swan.apps.x.b.b.this.getAppFrameType()));
                    jP.bb("mobile", j.agH());
                    jP.bb("net", SwanAppNetworkUtils.YX().type);
                    jP.bb(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.x.b.b.this.getVersion());
                    jP.bb("thirdversion", com.baidu.swan.apps.x.b.b.this.getVersionCode());
                    jP.k("from", com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
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
                    jP.bb("path", deleteQueryParam);
                    jP.bb("launchid", com.baidu.swan.apps.x.b.b.this.Wa());
                    if (com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 0) {
                        jP.Zy();
                    }
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void jW(String str) {
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
        jP("startup").bb("package_type", str2);
    }

    /* loaded from: classes11.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int bHJ = 35;
        public JSONObject bHK;
        private boolean bHL = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a jX(String str) {
            this.mFrom = str;
            return this;
        }

        public a jY(String str) {
            this.mType = str;
            return this;
        }

        public a jZ(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.bVk == null) {
                this.bVk = new JSONObject();
            }
            try {
                if (this.bHK != null) {
                    if (this.bHL) {
                        String hf = ai.hf(bHJ);
                        if (!TextUtils.isEmpty(hf)) {
                            this.bHK.put("stacktrace", hf);
                        }
                    }
                    this.bVk.put("info", this.bHK);
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
