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
    private static b cgK;

    private static b aib() {
        if (cgK == null) {
            cgK = new b();
            a(cgK);
        }
        return cgK;
    }

    private static void a(b bVar) {
        bVar.b("preload", new com.baidu.swan.apps.performance.a.a()).b("startup", new com.baidu.swan.apps.performance.a.c()).b("route", new com.baidu.swan.apps.performance.a.b());
    }

    public static void onEvent(a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "onEvent " + aVar);
        }
        s.onEvent(aVar.eventId, aVar.toJSONObject());
    }

    @Deprecated
    public static synchronized HybridUbcFlow aic() {
        HybridUbcFlow lb;
        synchronized (f.class) {
            lb = lb("startup");
        }
        return lb;
    }

    public static synchronized HybridUbcFlow lb(String str) {
        HybridUbcFlow lb;
        synchronized (f.class) {
            lb = aib().lb(str);
        }
        return lb;
    }

    public static synchronized HybridUbcFlow bh(String str, String str2) {
        HybridUbcFlow bh;
        synchronized (f.class) {
            bh = aib().bh(str, str2);
        }
        return bh;
    }

    public static synchronized void lh(String str) {
        synchronized (f.class) {
            aib().lc(str);
        }
    }

    public static synchronized void bl(String str, String str2) {
        synchronized (f.class) {
            aib().bi(str, str2);
        }
    }

    public static synchronized void bm(String str, String str2) {
        synchronized (f.class) {
            HybridUbcFlow ld = aib().ld(str);
            if (ld != null) {
                aib().lb(str2).c(ld);
                lh(str);
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
        if (bVar != null && bVar.adF() != null) {
            final String page = bVar.getPage();
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.performance.f.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow lb = f.lb("startup");
                    String adA = TextUtils.isEmpty(com.baidu.swan.apps.x.b.b.this.adA()) ? "NA" : com.baidu.swan.apps.x.b.b.this.adA();
                    if (com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 1) {
                        lb.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    lb.p("from", "swan");
                    lb.p("source", adA);
                    lb.bk("appid", com.baidu.swan.apps.x.b.b.this.getAppId());
                    lb.bk("swan", com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.x.b.b.this.YH(), com.baidu.swan.apps.x.b.b.this.getAppFrameType()));
                    lb.bk("mobile", j.aoR());
                    lb.bk("net", SwanAppNetworkUtils.ahh().type);
                    lb.bk(ETAG.KEY_APP_VERSION, com.baidu.swan.apps.x.b.b.this.getVersion());
                    lb.bk("thirdversion", com.baidu.swan.apps.x.b.b.this.getVersionCode());
                    lb.p("from", com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 1 ? "swangame" : "swan");
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
                    lb.bk("path", deleteQueryParam);
                    lb.bk("launchid", com.baidu.swan.apps.x.b.b.this.adT());
                    if (com.baidu.swan.apps.x.b.b.this.getAppFrameType() == 0) {
                        lb.ahH();
                    }
                }
            }, "recordFromLaunchInfo");
        }
    }

    public static void li(String str) {
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
        lb("startup").bk("package_type", str2);
    }

    /* loaded from: classes11.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int cgL = 35;
        public JSONObject cgM;
        private boolean cgN = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a lj(String str) {
            this.mFrom = str;
            return this;
        }

        public a lk(String str) {
            this.mType = str;
            return this;
        }

        public a ll(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.cuv == null) {
                this.cuv = new JSONObject();
            }
            try {
                if (this.cgM != null) {
                    if (this.cgN) {
                        String hm = ai.hm(cgL);
                        if (!TextUtils.isEmpty(hm)) {
                            this.cgM.put("stacktrace", hm);
                        }
                    }
                    this.cuv.put("info", this.cgM);
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
