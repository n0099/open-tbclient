package com.baidu.swan.apps.performance;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.g;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.ubc.s;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static boolean bab = false;
    @Deprecated
    private static com.baidu.swan.apps.performance.a bac;

    private static com.baidu.swan.apps.performance.a NI() {
        if (bac == null) {
            bac = new com.baidu.swan.apps.performance.a();
            a(bac);
        }
        return bac;
    }

    private static void a(com.baidu.swan.apps.performance.a aVar) {
        aVar.b("preload", new com.baidu.swan.apps.performance.b.a()).b("startup", new com.baidu.swan.apps.performance.b.b());
    }

    private f() {
    }

    public static boolean NJ() {
        boolean l = com.baidu.swan.apps.u.a.Jm().l("aiapp_launch_ext_ab", false);
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "xpass -> getAbSwitch:" + l);
        }
        return l;
    }

    public static void onEvent(a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "onEvent " + aVar);
        }
        s.onEvent(aVar.eventId, aVar.toJSONObject());
    }

    @Deprecated
    public static synchronized HybridUbcFlow NK() {
        HybridUbcFlow gz;
        synchronized (f.class) {
            gz = gz("startup");
        }
        return gz;
    }

    public static synchronized HybridUbcFlow gz(String str) {
        HybridUbcFlow gz;
        synchronized (f.class) {
            gz = NI().gz(str);
        }
        return gz;
    }

    public static synchronized void gI(String str) {
        synchronized (f.class) {
            NI().gA(str);
        }
    }

    public static synchronized void aB(String str, String str2) {
        synchronized (f.class) {
            HybridUbcFlow gB = NI().gB(str);
            if (gB != null) {
                NI().gz(str2).b(gB);
                gI(str);
            }
        }
    }

    public static void k(Message message) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchExtForStartup: msg=" + message);
        }
        if (message == null || !(message.obj instanceof Bundle)) {
            gz("startup").Nn();
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
                    f.q(bundle);
                }
                f.gz("startup").Nn();
            }
        }, "recordFromLaunchInfo");
    }

    public static void k(final com.baidu.swan.apps.v.b.b bVar) {
        final Bundle KJ;
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup: info=" + bVar);
        }
        if (bVar != null && (KJ = bVar.KJ()) != null) {
            final String page = bVar.getPage();
            final boolean z = KJ.getBoolean("aiapp_launch_ext_ab", false);
            if (DEBUG) {
                Log.i("SwanAppPerformanceUBC", "xpass -> recordFromLaunchInfoForStartup: extAbSwitch=" + z);
            }
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.f.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow gz = f.gz("startup");
                    if (!f.bab) {
                        f.r(KJ);
                        f.a(gz, KJ, "aiapp_launch_activity_timestamp", "na_launch_activity");
                    }
                    if (!z) {
                        f.q(KJ);
                    }
                    String KF = TextUtils.isEmpty(bVar.KF()) ? "NA" : bVar.KF();
                    if (bVar.KP() == 1) {
                        gz.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    gz.g("from", "swan");
                    gz.g("source", KF);
                    gz.az("appid", bVar.getAppId());
                    gz.az("swan", com.baidu.swan.apps.swancore.b.a(bVar.Hh(), bVar.KP()));
                    gz.az("mobile", g.Ue());
                    gz.az("net", SwanAppNetworkUtils.MQ().type);
                    gz.az("appversion", bVar.getVersion());
                    gz.az("thirdversion", bVar.getVersionCode());
                    gz.g("from", bVar.KP() == 1 ? "swangame" : "swan");
                    String iV = aa.iV(page);
                    if (!TextUtils.isEmpty(iV) && iV.startsWith(File.separator)) {
                        iV = iV.substring(1);
                    }
                    if (TextUtils.isEmpty(iV)) {
                        iV = "";
                    }
                    gz.az("path", iV);
                    if (bVar.KP() == 0) {
                        gz.Nm();
                    }
                }
            }, "recordFromLaunchInfo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Bundle bundle) {
        boolean a2;
        if (bundle != null && !bundle.isEmpty()) {
            HybridUbcFlow gz = gz("startup");
            if (bab) {
                a2 = false;
            } else {
                a(gz, bundle, "aiapp_aps_check_start_timestamp", "aps_start_req");
                a(gz, bundle, "aiapp_aps_check_end_timestamp", "aps_end_req");
                a(gz, bundle, "aiapp_download_start_timestamp", "aps_start_download");
                a(gz, bundle, "aiapp_aps_unzip_start_timestamp", "package_start_unzip");
                a(gz, bundle, "aiapp_aps_unzip_end_timestamp", "package_end_unzip");
                a(gz, bundle, "aiapp_aps_decrypt_start_timestamp", "package_start_decrypt");
                a(gz, bundle, "aiapp_aps_decrypt_end_timestamp", "package_end_decrypt");
                a(gz, bundle, "aiapp_query_db_timestamp", "na_query_db");
                a(gz, bundle, "aiapp_stream_bump_end_timestamp", "na_stream_bump_end");
                a2 = a(gz, bundle, "aiapp_download_end_timestamp", "aps_end_download");
            }
            if (!gz.Nl().has("type")) {
                gz.g("type", a2 ? "0" : "1");
            }
            gz.az("abtest", bundle.getString("aiapp_abtest_info", ""));
            gz.az("is_updating", String.valueOf(bundle.getBoolean("is_sileng_updating_when_start")));
            gz.az("check_result", String.valueOf(bundle.getInt("aiapp_check_result", 0)));
            gz.az("launch_state", String.valueOf(bundle.getInt("aiapp_launch_state", -1)));
            gz.az("launch_type", String.valueOf(bundle.getInt("swan_launch_type", -1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(@NonNull Bundle bundle) {
        long j = bundle.getLong("aiapp_start_timestamp", -1L);
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordStartFromExtraForStartup:" + j);
        }
        if (j > 0) {
            gz("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).ae(j));
            gz("startup").f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).ae(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(@NonNull HybridUbcFlow hybridUbcFlow, @NonNull Bundle bundle, String str, String str2) {
        long j = bundle.getLong(str, -1L);
        if (j > 0) {
            hybridUbcFlow.f(new UbcFlowEvent(str2).ae(j));
            return true;
        }
        return false;
    }

    public static void c(long j, boolean z) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "initSessionForStartup:" + j);
        }
        gI("startup");
        HybridUbcFlow gz = gz("startup");
        if (bab) {
            gz.f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).ae(j));
            gz.f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).ae(j));
        }
        gz.f(new UbcFlowEvent("frame_start_create").ae(j)).az("process", String.valueOf(SwanAppProcessInfo.current())).az("reuse", z ? "1" : "0");
    }

    public static void a(boolean z, Intent intent) {
        boolean P = P(intent);
        bab = P || z;
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: isIntentNeedDiscard=" + P);
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: hasSaved=" + z);
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: sNeedDiscard=" + bab);
        }
    }

    private static boolean P(Intent intent) {
        Bundle b = n.b(intent, "aiapps_extra_data");
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
        private static int baf = 35;
        public JSONObject bag;
        private boolean bah = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a gJ(String str) {
            this.mFrom = str;
            return this;
        }

        public a gK(String str) {
            this.mType = str;
            return this;
        }

        public a gL(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.bpc == null) {
                this.bpc = new JSONObject();
            }
            try {
                if (this.bag != null) {
                    if (this.bah) {
                        String fx = ac.fx(baf);
                        if (!TextUtils.isEmpty(fx)) {
                            this.bag.put("stacktrace", fx);
                        }
                    }
                    this.bpc.put(Config.LAUNCH_INFO, this.bag);
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
