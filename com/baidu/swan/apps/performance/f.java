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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static boolean aGG = false;
    @Deprecated
    private static com.baidu.swan.apps.performance.a aGH;

    private static com.baidu.swan.apps.performance.a IJ() {
        if (aGH == null) {
            aGH = new com.baidu.swan.apps.performance.a();
            a(aGH);
        }
        return aGH;
    }

    private static void a(com.baidu.swan.apps.performance.a aVar) {
        aVar.b("preload", new com.baidu.swan.apps.performance.b.a()).b("startup", new com.baidu.swan.apps.performance.b.b());
    }

    private f() {
    }

    public static boolean IK() {
        boolean i = com.baidu.swan.apps.u.a.En().i("aiapp_launch_ext_ab", false);
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
    public static synchronized HybridUbcFlow IL() {
        HybridUbcFlow fS;
        synchronized (f.class) {
            fS = fS("startup");
        }
        return fS;
    }

    public static synchronized HybridUbcFlow fS(String str) {
        HybridUbcFlow fS;
        synchronized (f.class) {
            fS = IJ().fS(str);
        }
        return fS;
    }

    public static synchronized void gb(String str) {
        synchronized (f.class) {
            IJ().fT(str);
        }
    }

    public static synchronized void at(String str, String str2) {
        synchronized (f.class) {
            HybridUbcFlow fU = IJ().fU(str);
            if (fU != null) {
                IJ().fS(str2).b(fU);
                gb(str);
            }
        }
    }

    public static void k(Message message) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchExtForStartup: msg=" + message);
        }
        if (message == null || !(message.obj instanceof Bundle)) {
            fS("startup").Io();
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
                f.fS("startup").Io();
            }
        }, "recordFromLaunchInfo");
    }

    public static void k(final com.baidu.swan.apps.v.b.b bVar) {
        final Bundle FK;
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup: info=" + bVar);
        }
        if (bVar != null && (FK = bVar.FK()) != null) {
            final String page = bVar.getPage();
            final boolean z = FK.getBoolean("aiapp_launch_ext_ab", false);
            if (DEBUG) {
                Log.i("SwanAppPerformanceUBC", "xpass -> recordFromLaunchInfoForStartup: extAbSwitch=" + z);
            }
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.f.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow fS = f.fS("startup");
                    if (!f.aGG) {
                        f.r(FK);
                        f.a(fS, FK, "aiapp_launch_activity_timestamp", "na_launch_activity");
                    }
                    if (!z) {
                        f.q(FK);
                    }
                    String FG = TextUtils.isEmpty(bVar.FG()) ? "NA" : bVar.FG();
                    if (bVar.FQ() == 1) {
                        fS.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    fS.j("from", "swan");
                    fS.j("source", FG);
                    fS.ar("appid", bVar.getAppId());
                    fS.ar("swan", com.baidu.swan.apps.swancore.b.a(bVar.Ci(), bVar.FQ()));
                    fS.ar("mobile", g.Pm());
                    fS.ar("net", SwanAppNetworkUtils.HR().type);
                    fS.ar("appversion", bVar.getVersion());
                    fS.ar("thirdversion", bVar.getVersionCode());
                    fS.j("from", bVar.FQ() == 1 ? "swangame" : "swan");
                    String iq = aa.iq(page);
                    if (!TextUtils.isEmpty(iq) && iq.startsWith(File.separator)) {
                        iq = iq.substring(1);
                    }
                    if (TextUtils.isEmpty(iq)) {
                        iq = "";
                    }
                    fS.ar("path", iq);
                    if (bVar.FQ() == 0) {
                        fS.In();
                    }
                }
            }, "recordFromLaunchInfo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Bundle bundle) {
        boolean a2;
        if (bundle != null && !bundle.isEmpty()) {
            HybridUbcFlow fS = fS("startup");
            if (aGG) {
                a2 = false;
            } else {
                a(fS, bundle, "aiapp_aps_check_start_timestamp", "aps_start_req");
                a(fS, bundle, "aiapp_aps_check_end_timestamp", "aps_end_req");
                a(fS, bundle, "aiapp_download_start_timestamp", "aps_start_download");
                a(fS, bundle, "aiapp_aps_unzip_start_timestamp", "package_start_unzip");
                a(fS, bundle, "aiapp_aps_unzip_end_timestamp", "package_end_unzip");
                a(fS, bundle, "aiapp_aps_decrypt_start_timestamp", "package_start_decrypt");
                a(fS, bundle, "aiapp_aps_decrypt_end_timestamp", "package_end_decrypt");
                a(fS, bundle, "aiapp_query_db_timestamp", "na_query_db");
                a(fS, bundle, "aiapp_stream_bump_end_timestamp", "na_stream_bump_end");
                a2 = a(fS, bundle, "aiapp_download_end_timestamp", "aps_end_download");
            }
            if (!fS.Im().has("type")) {
                fS.j("type", a2 ? "0" : "1");
            }
            fS.ar(ImageViewerConfig.ABTEST, bundle.getString("aiapp_abtest_info", ""));
            fS.ar("is_updating", String.valueOf(bundle.getBoolean("is_sileng_updating_when_start")));
            fS.ar("check_result", String.valueOf(bundle.getInt("aiapp_check_result", 0)));
            fS.ar("launch_state", String.valueOf(bundle.getInt("aiapp_launch_state", -1)));
            fS.ar("launch_type", String.valueOf(bundle.getInt("swan_launch_type", -1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(@NonNull Bundle bundle) {
        long j = bundle.getLong("aiapp_start_timestamp", -1L);
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordStartFromExtraForStartup:" + j);
        }
        if (j > 0) {
            fS("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(j));
            fS("startup").f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(j));
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
        gb("startup");
        HybridUbcFlow fS = fS("startup");
        if (aGG) {
            fS.f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(j));
            fS.f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(j));
        }
        fS.f(new UbcFlowEvent("frame_start_create").M(j)).ar("process", String.valueOf(SwanAppProcessInfo.current())).ar("reuse", z ? "1" : "0");
    }

    public static void a(boolean z, Intent intent) {
        boolean J = J(intent);
        aGG = J || z;
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: isIntentNeedDiscard=" + J);
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: hasSaved=" + z);
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: sNeedDiscard=" + aGG);
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
        private static int aGL = 35;
        public JSONObject aGM;
        private boolean aGN = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a gc(String str) {
            this.mFrom = str;
            return this;
        }

        public a gd(String str) {
            this.mType = str;
            return this;
        }

        public a ge(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.aVS == null) {
                this.aVS = new JSONObject();
            }
            try {
                if (this.aGM != null) {
                    if (this.aGN) {
                        String eC = ac.eC(aGL);
                        if (!TextUtils.isEmpty(eC)) {
                            this.aGM.put("stacktrace", eC);
                        }
                    }
                    this.aVS.put(Config.LAUNCH_INFO, this.aGM);
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
