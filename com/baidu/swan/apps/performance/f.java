package com.baidu.swan.apps.performance;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.g;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.an.y;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.ubc.r;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public static boolean aEb = false;
    @Deprecated
    private static com.baidu.swan.apps.performance.a aEc;

    private static com.baidu.swan.apps.performance.a FQ() {
        if (aEc == null) {
            aEc = new com.baidu.swan.apps.performance.a();
            a(aEc);
        }
        return aEc;
    }

    private static void a(com.baidu.swan.apps.performance.a aVar) {
        aVar.b("preload", new com.baidu.swan.apps.performance.b.a()).b("startup", new com.baidu.swan.apps.performance.b.b());
    }

    private f() {
    }

    public static boolean FR() {
        boolean j = com.baidu.swan.apps.u.a.CB().j("aiapp_launch_ext_ab", false);
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "xpass -> getAbSwitch:" + j);
        }
        return j;
    }

    public static void onEvent(a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "onEvent " + aVar);
        }
        r.onEvent(aVar.eventId, aVar.toJSONObject());
    }

    @Deprecated
    public static synchronized HybridUbcFlow FS() {
        HybridUbcFlow fy;
        synchronized (f.class) {
            fy = fy("startup");
        }
        return fy;
    }

    public static synchronized HybridUbcFlow fy(String str) {
        HybridUbcFlow fy;
        synchronized (f.class) {
            fy = FQ().fy(str);
        }
        return fy;
    }

    public static synchronized void fG(String str) {
        synchronized (f.class) {
            FQ().fz(str);
        }
    }

    public static synchronized void at(String str, String str2) {
        synchronized (f.class) {
            HybridUbcFlow fA = FQ().fA(str);
            if (fA != null) {
                FQ().fy(str2).b(fA);
                fG(str);
            }
        }
    }

    public static void k(Message message) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchExtForStartup: msg=" + message);
        }
        if (message == null || !(message.obj instanceof Bundle)) {
            fy("startup").Fw();
            return;
        }
        final Bundle bundle = (Bundle) message.obj;
        bundle.setClassLoader(f.class.getClassLoader());
        final boolean z = bundle.getBoolean("aiapp_launch_ext_ab", false);
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "xpass -> recordFromLaunchExtForStartup: extAbSwitch=" + z);
        }
        j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    f.p(bundle);
                }
                f.fy("startup").Fw();
            }
        }, "recordFromLaunchInfo");
    }

    public static void k(final com.baidu.swan.apps.v.b.b bVar) {
        final Bundle bundle;
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup: info=" + bVar);
        }
        if (bVar != null && (bundle = bVar.axP) != null) {
            final String str = bVar.axH;
            final boolean z = bundle.getBoolean("aiapp_launch_ext_ab", false);
            if (DEBUG) {
                Log.i("SwanAppPerformanceUBC", "xpass -> recordFromLaunchInfoForStartup: extAbSwitch=" + z);
            }
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.f.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow fy = f.fy("startup");
                    if (!f.aEb) {
                        f.q(bundle);
                        f.a(fy, bundle, "aiapp_launch_activity_timestamp", "na_launch_activity");
                    }
                    if (!z) {
                        f.p(bundle);
                    }
                    String str2 = TextUtils.isEmpty(bVar.axF) ? "NA" : bVar.axF;
                    if (bVar.axW == 1) {
                        fy.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    fy.i("from", "swan");
                    fy.i("source", str2);
                    fy.aq("appid", bVar.mAppId);
                    fy.aq("swan", com.baidu.swan.apps.swancore.b.a(bVar.atp, bVar.axW));
                    fy.aq("mobile", g.LS());
                    fy.aq("net", SwanAppNetworkUtils.Fd().type);
                    fy.aq("appversion", bVar.mVersion);
                    fy.aq("thirdversion", bVar.auf);
                    fy.i("from", bVar.axW == 1 ? "swangame" : "swan");
                    String hF = y.hF(str);
                    if (!TextUtils.isEmpty(hF) && hF.startsWith(File.separator)) {
                        hF = hF.substring(1);
                    }
                    if (TextUtils.isEmpty(hF)) {
                        hF = "";
                    }
                    fy.aq(ClientCookie.PATH_ATTR, hF);
                    if (bVar.axW == 0) {
                        fy.Fv();
                    }
                }
            }, "recordFromLaunchInfo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(Bundle bundle) {
        boolean a2;
        if (bundle != null && !bundle.isEmpty()) {
            HybridUbcFlow fy = fy("startup");
            if (aEb) {
                a2 = false;
            } else {
                a(fy, bundle, "aiapp_aps_check_start_timestamp", "aps_start_req");
                a(fy, bundle, "aiapp_aps_check_end_timestamp", "aps_end_req");
                a(fy, bundle, "aiapp_download_start_timestamp", "aps_start_download");
                a(fy, bundle, "aiapp_aps_unzip_start_timestamp", "package_start_unzip");
                a(fy, bundle, "aiapp_aps_unzip_end_timestamp", "package_end_unzip");
                a(fy, bundle, "aiapp_aps_decrypt_start_timestamp", "package_start_decrypt");
                a(fy, bundle, "aiapp_aps_decrypt_end_timestamp", "package_end_decrypt");
                a(fy, bundle, "aiapp_query_db_timestamp", "na_query_db");
                a2 = a(fy, bundle, "aiapp_download_end_timestamp", "aps_end_download");
            }
            if (!fy.Fu().has("type")) {
                fy.i("type", a2 ? "0" : "1");
            }
            fy.aq(ImageViewerConfig.ABTEST, bundle.getString("aiapp_abtest_info", ""));
            fy.aq("is_updating", String.valueOf(bundle.getBoolean("is_sileng_updating_when_start")));
            fy.aq("check_result", String.valueOf(bundle.getInt("aiapp_check_result", 0)));
            fy.aq("launch_state", String.valueOf(bundle.getInt("aiapp_launch_state", -1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(@NonNull Bundle bundle) {
        long j = bundle.getLong("aiapp_start_timestamp", -1L);
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordStartFromExtraForStartup:" + j);
        }
        if (j > 0) {
            fy("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).A(j));
            fy("startup").f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).A(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(@NonNull HybridUbcFlow hybridUbcFlow, @NonNull Bundle bundle, String str, String str2) {
        long j = bundle.getLong(str, -1L);
        if (j > 0) {
            hybridUbcFlow.f(new UbcFlowEvent(str2).A(j));
            return true;
        }
        return false;
    }

    public static void c(long j, boolean z) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "initSessionForStartup:" + j);
        }
        fG("startup");
        HybridUbcFlow fy = fy("startup");
        if (aEb) {
            fy.f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).A(j));
            fy.f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).A(j));
        }
        fy.f(new UbcFlowEvent("frame_start_create").A(j)).aq("process", String.valueOf(SwanAppProcessInfo.current())).aq("reuse", z ? "1" : "0");
    }

    public static void a(boolean z, Intent intent) {
        boolean K = K(intent);
        aEb = K || z;
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: isIntentNeedDiscard=" + K);
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: hasSaved=" + z);
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: sNeedDiscard=" + aEb);
        }
    }

    private static boolean K(Intent intent) {
        Bundle b = m.b(intent, "aiapps_extra_data");
        if (b == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - b.getLong("aiapp_launch_activity_timestamp", 0L);
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "isIntentNeedDiscard: intentAge=" + currentTimeMillis);
        }
        return currentTimeMillis < 0 || currentTimeMillis > TimeUnit.SECONDS.toMillis(10L);
    }

    /* loaded from: classes2.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int aEg = 35;
        public JSONObject aEh;
        private boolean aEi = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a fH(String str) {
            this.mFrom = str;
            return this;
        }

        public a fI(String str) {
            this.mType = str;
            return this;
        }

        public a fJ(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.aSp == null) {
                this.aSp = new JSONObject();
            }
            try {
                if (this.aEh != null) {
                    if (this.aEi) {
                        String ep = aa.ep(aEg);
                        if (!TextUtils.isEmpty(ep)) {
                            this.aEh.put("stacktrace", ep);
                        }
                    }
                    this.aSp.put("info", this.aEh);
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
