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
import com.baidu.swan.ubc.q;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static boolean aEf = false;
    @Deprecated
    private static com.baidu.swan.apps.performance.a aEg;

    private static com.baidu.swan.apps.performance.a FO() {
        if (aEg == null) {
            aEg = new com.baidu.swan.apps.performance.a();
            a(aEg);
        }
        return aEg;
    }

    private static void a(com.baidu.swan.apps.performance.a aVar) {
        aVar.b("preload", new com.baidu.swan.apps.performance.b.a()).b("startup", new com.baidu.swan.apps.performance.b.b());
    }

    private f() {
    }

    public static boolean FP() {
        boolean j = com.baidu.swan.apps.u.a.Cz().j("aiapp_launch_ext_ab", false);
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "xpass -> getAbSwitch:" + j);
        }
        return j;
    }

    public static void onEvent(a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "onEvent " + aVar);
        }
        q.onEvent(aVar.eventId, aVar.toJSONObject());
    }

    @Deprecated
    public static synchronized HybridUbcFlow FQ() {
        HybridUbcFlow fz;
        synchronized (f.class) {
            fz = fz("startup");
        }
        return fz;
    }

    public static synchronized HybridUbcFlow fz(String str) {
        HybridUbcFlow fz;
        synchronized (f.class) {
            fz = FO().fz(str);
        }
        return fz;
    }

    public static synchronized void fH(String str) {
        synchronized (f.class) {
            FO().fA(str);
        }
    }

    public static synchronized void at(String str, String str2) {
        synchronized (f.class) {
            HybridUbcFlow fB = FO().fB(str);
            if (fB != null) {
                FO().fz(str2).b(fB);
                fH(str);
            }
        }
    }

    public static void k(Message message) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchExtForStartup: msg=" + message);
        }
        if (message == null || !(message.obj instanceof Bundle)) {
            fz("startup").Fu();
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
                f.fz("startup").Fu();
            }
        }, "recordFromLaunchInfo");
    }

    public static void k(final com.baidu.swan.apps.v.b.b bVar) {
        final Bundle bundle;
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup: info=" + bVar);
        }
        if (bVar != null && (bundle = bVar.axT) != null) {
            final String str = bVar.axL;
            final boolean z = bundle.getBoolean("aiapp_launch_ext_ab", false);
            if (DEBUG) {
                Log.i("SwanAppPerformanceUBC", "xpass -> recordFromLaunchInfoForStartup: extAbSwitch=" + z);
            }
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.f.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow fz = f.fz("startup");
                    if (!f.aEf) {
                        f.q(bundle);
                        f.a(fz, bundle, "aiapp_launch_activity_timestamp", "na_launch_activity");
                    }
                    if (!z) {
                        f.p(bundle);
                    }
                    String str2 = TextUtils.isEmpty(bVar.axJ) ? "NA" : bVar.axJ;
                    if (bVar.aya == 1) {
                        fz.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    fz.i("from", "swan");
                    fz.i("source", str2);
                    fz.aq("appid", bVar.mAppId);
                    fz.aq("swan", com.baidu.swan.apps.swancore.b.a(bVar.atu, bVar.aya));
                    fz.aq("mobile", g.LQ());
                    fz.aq("net", SwanAppNetworkUtils.Fb().type);
                    fz.aq("appversion", bVar.mVersion);
                    fz.aq("thirdversion", bVar.auk);
                    fz.i("from", bVar.aya == 1 ? "swangame" : "swan");
                    String hG = y.hG(str);
                    if (!TextUtils.isEmpty(hG) && hG.startsWith(File.separator)) {
                        hG = hG.substring(1);
                    }
                    if (TextUtils.isEmpty(hG)) {
                        hG = "";
                    }
                    fz.aq("path", hG);
                    if (bVar.aya == 0) {
                        fz.Ft();
                    }
                }
            }, "recordFromLaunchInfo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(Bundle bundle) {
        boolean a2;
        if (bundle != null && !bundle.isEmpty()) {
            HybridUbcFlow fz = fz("startup");
            if (aEf) {
                a2 = false;
            } else {
                a(fz, bundle, "aiapp_aps_check_start_timestamp", "aps_start_req");
                a(fz, bundle, "aiapp_aps_check_end_timestamp", "aps_end_req");
                a(fz, bundle, "aiapp_download_start_timestamp", "aps_start_download");
                a(fz, bundle, "aiapp_aps_unzip_start_timestamp", "package_start_unzip");
                a(fz, bundle, "aiapp_aps_unzip_end_timestamp", "package_end_unzip");
                a(fz, bundle, "aiapp_aps_decrypt_start_timestamp", "package_start_decrypt");
                a(fz, bundle, "aiapp_aps_decrypt_end_timestamp", "package_end_decrypt");
                a(fz, bundle, "aiapp_query_db_timestamp", "na_query_db");
                a2 = a(fz, bundle, "aiapp_download_end_timestamp", "aps_end_download");
            }
            if (!fz.Fs().has("type")) {
                fz.i("type", a2 ? "0" : "1");
            }
            fz.aq(ImageViewerConfig.ABTEST, bundle.getString("aiapp_abtest_info", ""));
            fz.aq("is_updating", String.valueOf(bundle.getBoolean("is_sileng_updating_when_start")));
            fz.aq("check_result", String.valueOf(bundle.getInt("aiapp_check_result", 0)));
            fz.aq("launch_state", String.valueOf(bundle.getInt("aiapp_launch_state", -1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(@NonNull Bundle bundle) {
        long j = bundle.getLong("aiapp_start_timestamp", -1L);
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordStartFromExtraForStartup:" + j);
        }
        if (j > 0) {
            fz("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).A(j));
            fz("startup").f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).A(j));
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
        fH("startup");
        HybridUbcFlow fz = fz("startup");
        if (aEf) {
            fz.f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).A(j));
            fz.f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).A(j));
        }
        fz.f(new UbcFlowEvent("frame_start_create").A(j)).aq("process", String.valueOf(SwanAppProcessInfo.current())).aq("reuse", z ? "1" : "0");
    }

    public static void a(boolean z, Intent intent) {
        boolean K = K(intent);
        aEf = K || z;
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: isIntentNeedDiscard=" + K);
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: hasSaved=" + z);
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: sNeedDiscard=" + aEf);
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
        private static int aEk = 35;
        public JSONObject aEl;
        private boolean aEm = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a fI(String str) {
            this.mFrom = str;
            return this;
        }

        public a fJ(String str) {
            this.mType = str;
            return this;
        }

        public a fK(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.aSt == null) {
                this.aSt = new JSONObject();
            }
            try {
                if (this.aEl != null) {
                    if (this.aEm) {
                        String eo = aa.eo(aEk);
                        if (!TextUtils.isEmpty(eo)) {
                            this.aEl.put("stacktrace", eo);
                        }
                    }
                    this.aSt.put("info", this.aEl);
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
