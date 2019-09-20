package com.baidu.swan.apps.performance;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.result.AddressManageResult;
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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static boolean aHe = false;
    @Deprecated
    private static com.baidu.swan.apps.performance.a aHf;

    private static com.baidu.swan.apps.performance.a IN() {
        if (aHf == null) {
            aHf = new com.baidu.swan.apps.performance.a();
            a(aHf);
        }
        return aHf;
    }

    private static void a(com.baidu.swan.apps.performance.a aVar) {
        aVar.b("preload", new com.baidu.swan.apps.performance.b.a()).b("startup", new com.baidu.swan.apps.performance.b.b());
    }

    private f() {
    }

    public static boolean IO() {
        boolean i = com.baidu.swan.apps.u.a.Er().i("aiapp_launch_ext_ab", false);
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "xpass -> getAbSwitch:" + i);
        }
        return i;
    }

    public static void onEvent(a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "onEvent " + aVar);
        }
        s.onEvent(aVar.eventId, aVar.toJSONObject());
    }

    @Deprecated
    public static synchronized HybridUbcFlow IP() {
        HybridUbcFlow fU;
        synchronized (f.class) {
            fU = fU("startup");
        }
        return fU;
    }

    public static synchronized HybridUbcFlow fU(String str) {
        HybridUbcFlow fU;
        synchronized (f.class) {
            fU = IN().fU(str);
        }
        return fU;
    }

    public static synchronized void gd(String str) {
        synchronized (f.class) {
            IN().fV(str);
        }
    }

    public static synchronized void at(String str, String str2) {
        synchronized (f.class) {
            HybridUbcFlow fW = IN().fW(str);
            if (fW != null) {
                IN().fU(str2).b(fW);
                gd(str);
            }
        }
    }

    public static void k(Message message) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchExtForStartup: msg=" + message);
        }
        if (message == null || !(message.obj instanceof Bundle)) {
            fU("startup").Is();
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
                f.fU("startup").Is();
            }
        }, "recordFromLaunchInfo");
    }

    public static void k(final com.baidu.swan.apps.v.b.b bVar) {
        final Bundle FO;
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup: info=" + bVar);
        }
        if (bVar != null && (FO = bVar.FO()) != null) {
            final String page = bVar.getPage();
            final boolean z = FO.getBoolean("aiapp_launch_ext_ab", false);
            if (DEBUG) {
                Log.i("SwanAppPerformanceUBC", "xpass -> recordFromLaunchInfoForStartup: extAbSwitch=" + z);
            }
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.f.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow fU = f.fU("startup");
                    if (!f.aHe) {
                        f.r(FO);
                        f.a(fU, FO, "aiapp_launch_activity_timestamp", "na_launch_activity");
                    }
                    if (!z) {
                        f.q(FO);
                    }
                    String FK = TextUtils.isEmpty(bVar.FK()) ? "NA" : bVar.FK();
                    if (bVar.FU() == 1) {
                        fU.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    fU.j("from", "swan");
                    fU.j("source", FK);
                    fU.ar("appid", bVar.getAppId());
                    fU.ar("swan", com.baidu.swan.apps.swancore.b.a(bVar.Cm(), bVar.FU()));
                    fU.ar(AddressManageResult.KEY_MOBILE, g.Pq());
                    fU.ar("net", SwanAppNetworkUtils.HV().type);
                    fU.ar("appversion", bVar.getVersion());
                    fU.ar("thirdversion", bVar.getVersionCode());
                    fU.j("from", bVar.FU() == 1 ? "swangame" : "swan");
                    String is = aa.is(page);
                    if (!TextUtils.isEmpty(is) && is.startsWith(File.separator)) {
                        is = is.substring(1);
                    }
                    if (TextUtils.isEmpty(is)) {
                        is = "";
                    }
                    fU.ar("path", is);
                    if (bVar.FU() == 0) {
                        fU.Ir();
                    }
                }
            }, "recordFromLaunchInfo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Bundle bundle) {
        boolean a2;
        if (bundle != null && !bundle.isEmpty()) {
            HybridUbcFlow fU = fU("startup");
            if (aHe) {
                a2 = false;
            } else {
                a(fU, bundle, "aiapp_aps_check_start_timestamp", "aps_start_req");
                a(fU, bundle, "aiapp_aps_check_end_timestamp", "aps_end_req");
                a(fU, bundle, "aiapp_download_start_timestamp", "aps_start_download");
                a(fU, bundle, "aiapp_aps_unzip_start_timestamp", "package_start_unzip");
                a(fU, bundle, "aiapp_aps_unzip_end_timestamp", "package_end_unzip");
                a(fU, bundle, "aiapp_aps_decrypt_start_timestamp", "package_start_decrypt");
                a(fU, bundle, "aiapp_aps_decrypt_end_timestamp", "package_end_decrypt");
                a(fU, bundle, "aiapp_query_db_timestamp", "na_query_db");
                a(fU, bundle, "aiapp_stream_bump_end_timestamp", "na_stream_bump_end");
                a2 = a(fU, bundle, "aiapp_download_end_timestamp", "aps_end_download");
            }
            if (!fU.Iq().has("type")) {
                fU.j("type", a2 ? "0" : "1");
            }
            fU.ar(ImageViewerConfig.ABTEST, bundle.getString("aiapp_abtest_info", ""));
            fU.ar("is_updating", String.valueOf(bundle.getBoolean("is_sileng_updating_when_start")));
            fU.ar("check_result", String.valueOf(bundle.getInt("aiapp_check_result", 0)));
            fU.ar("launch_state", String.valueOf(bundle.getInt("aiapp_launch_state", -1)));
            fU.ar("launch_type", String.valueOf(bundle.getInt("swan_launch_type", -1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(@NonNull Bundle bundle) {
        long j = bundle.getLong("aiapp_start_timestamp", -1L);
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordStartFromExtraForStartup:" + j);
        }
        if (j > 0) {
            fU("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(j));
            fU("startup").f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(@NonNull HybridUbcFlow hybridUbcFlow, @NonNull Bundle bundle, String str, String str2) {
        long j = bundle.getLong(str, -1L);
        if (j > 0) {
            hybridUbcFlow.f(new UbcFlowEvent(str2).M(j));
            return true;
        }
        return false;
    }

    public static void c(long j, boolean z) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "initSessionForStartup:" + j);
        }
        gd("startup");
        HybridUbcFlow fU = fU("startup");
        if (aHe) {
            fU.f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(j));
            fU.f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(j));
        }
        fU.f(new UbcFlowEvent("frame_start_create").M(j)).ar("process", String.valueOf(SwanAppProcessInfo.current())).ar("reuse", z ? "1" : "0");
    }

    public static void a(boolean z, Intent intent) {
        boolean J = J(intent);
        aHe = J || z;
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: isIntentNeedDiscard=" + J);
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: hasSaved=" + z);
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: sNeedDiscard=" + aHe);
        }
    }

    private static boolean J(Intent intent) {
        Bundle c = n.c(intent, "aiapps_extra_data");
        if (c == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - c.getLong("aiapp_launch_activity_timestamp", 0L);
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "isIntentNeedDiscard: intentAge=" + currentTimeMillis);
        }
        return currentTimeMillis < 0 || currentTimeMillis > TimeUnit.SECONDS.toMillis(10L);
    }

    /* loaded from: classes2.dex */
    public static class a extends com.baidu.swan.apps.statistic.a.e {
        private static int aHj = 35;
        public JSONObject aHk;
        private boolean aHl = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a ge(String str) {
            this.mFrom = str;
            return this;
        }

        public a gf(String str) {
            this.mType = str;
            return this;
        }

        public a gg(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.aWq == null) {
                this.aWq = new JSONObject();
            }
            try {
                if (this.aHk != null) {
                    if (this.aHl) {
                        String eD = ac.eD(aHj);
                        if (!TextUtils.isEmpty(eD)) {
                            this.aHk.put("stacktrace", eD);
                        }
                    }
                    this.aWq.put(Config.LAUNCH_INFO, this.aHk);
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
