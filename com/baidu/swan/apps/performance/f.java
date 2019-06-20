package com.baidu.swan.apps.performance;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
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
    public static boolean aFY = false;
    @Deprecated
    private static com.baidu.swan.apps.performance.a aFZ;

    private static com.baidu.swan.apps.performance.a HW() {
        if (aFZ == null) {
            aFZ = new com.baidu.swan.apps.performance.a();
            a(aFZ);
        }
        return aFZ;
    }

    private static void a(com.baidu.swan.apps.performance.a aVar) {
        aVar.b("preload", new com.baidu.swan.apps.performance.b.a()).b("startup", new com.baidu.swan.apps.performance.b.b());
    }

    private f() {
    }

    public static boolean HX() {
        boolean i = com.baidu.swan.apps.u.a.DE().i("aiapp_launch_ext_ab", false);
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
    public static synchronized HybridUbcFlow HY() {
        HybridUbcFlow fN;
        synchronized (f.class) {
            fN = fN("startup");
        }
        return fN;
    }

    public static synchronized HybridUbcFlow fN(String str) {
        HybridUbcFlow fN;
        synchronized (f.class) {
            fN = HW().fN(str);
        }
        return fN;
    }

    public static synchronized void fV(String str) {
        synchronized (f.class) {
            HW().fO(str);
        }
    }

    public static synchronized void at(String str, String str2) {
        synchronized (f.class) {
            HybridUbcFlow fP = HW().fP(str);
            if (fP != null) {
                HW().fN(str2).b(fP);
                fV(str);
            }
        }
    }

    public static void k(Message message) {
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchExtForStartup: msg=" + message);
        }
        if (message == null || !(message.obj instanceof Bundle)) {
            fN("startup").HC();
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
                f.fN("startup").HC();
            }
        }, "recordFromLaunchInfo");
    }

    public static void k(final com.baidu.swan.apps.v.b.b bVar) {
        final Bundle Fa;
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup: info=" + bVar);
        }
        if (bVar != null && (Fa = bVar.Fa()) != null) {
            final String page = bVar.getPage();
            final boolean z = Fa.getBoolean("aiapp_launch_ext_ab", false);
            if (DEBUG) {
                Log.i("SwanAppPerformanceUBC", "xpass -> recordFromLaunchInfoForStartup: extAbSwitch=" + z);
            }
            j.b(new Runnable() { // from class: com.baidu.swan.apps.performance.f.2
                @Override // java.lang.Runnable
                public void run() {
                    HybridUbcFlow fN = f.fN("startup");
                    if (!f.aFY) {
                        f.r(Fa);
                        f.a(fN, Fa, "aiapp_launch_activity_timestamp", "na_launch_activity");
                    }
                    if (!z) {
                        f.q(Fa);
                    }
                    String EW = TextUtils.isEmpty(bVar.EW()) ? "NA" : bVar.EW();
                    if (bVar.Fg() == 1) {
                        fN.a(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                    }
                    fN.j("from", "swan");
                    fN.j("source", EW);
                    fN.ar("appid", bVar.getAppId());
                    fN.ar("swan", com.baidu.swan.apps.swancore.b.a(bVar.BA(), bVar.Fg()));
                    fN.ar("mobile", g.Ox());
                    fN.ar("net", SwanAppNetworkUtils.Hg().type);
                    fN.ar("appversion", bVar.getVersion());
                    fN.ar("thirdversion", bVar.getVersionCode());
                    fN.j("from", bVar.Fg() == 1 ? "swangame" : "swan");
                    String ij = aa.ij(page);
                    if (!TextUtils.isEmpty(ij) && ij.startsWith(File.separator)) {
                        ij = ij.substring(1);
                    }
                    if (TextUtils.isEmpty(ij)) {
                        ij = "";
                    }
                    fN.ar("path", ij);
                    if (bVar.Fg() == 0) {
                        fN.HB();
                    }
                }
            }, "recordFromLaunchInfo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Bundle bundle) {
        boolean a2;
        if (bundle != null && !bundle.isEmpty()) {
            HybridUbcFlow fN = fN("startup");
            if (aFY) {
                a2 = false;
            } else {
                a(fN, bundle, "aiapp_aps_check_start_timestamp", "aps_start_req");
                a(fN, bundle, "aiapp_aps_check_end_timestamp", "aps_end_req");
                a(fN, bundle, "aiapp_download_start_timestamp", "aps_start_download");
                a(fN, bundle, "aiapp_aps_unzip_start_timestamp", "package_start_unzip");
                a(fN, bundle, "aiapp_aps_unzip_end_timestamp", "package_end_unzip");
                a(fN, bundle, "aiapp_aps_decrypt_start_timestamp", "package_start_decrypt");
                a(fN, bundle, "aiapp_aps_decrypt_end_timestamp", "package_end_decrypt");
                a(fN, bundle, "aiapp_query_db_timestamp", "na_query_db");
                a(fN, bundle, "aiapp_stream_bump_end_timestamp", "na_stream_bump_end");
                a2 = a(fN, bundle, "aiapp_download_end_timestamp", "aps_end_download");
            }
            if (!fN.HA().has("type")) {
                fN.j("type", a2 ? "0" : "1");
            }
            fN.ar(ImageViewerConfig.ABTEST, bundle.getString("aiapp_abtest_info", ""));
            fN.ar("is_updating", String.valueOf(bundle.getBoolean("is_sileng_updating_when_start")));
            fN.ar("check_result", String.valueOf(bundle.getInt("aiapp_check_result", 0)));
            fN.ar("launch_state", String.valueOf(bundle.getInt("aiapp_launch_state", -1)));
            fN.ar("launch_type", String.valueOf(bundle.getInt("swan_launch_type", -1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(@NonNull Bundle bundle) {
        long j = bundle.getLong("aiapp_start_timestamp", -1L);
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "recordStartFromExtraForStartup:" + j);
        }
        if (j > 0) {
            fN("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(j));
            fN("startup").f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(j));
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
        fV("startup");
        HybridUbcFlow fN = fN("startup");
        if (aFY) {
            fN.f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(j));
            fN.f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(j));
        }
        fN.f(new UbcFlowEvent("frame_start_create").M(j)).ar("process", String.valueOf(SwanAppProcessInfo.current())).ar("reuse", z ? "1" : "0");
    }

    public static void a(boolean z, Intent intent) {
        boolean J = J(intent);
        aFY = J || z;
        if (DEBUG) {
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: isIntentNeedDiscard=" + J);
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: hasSaved=" + z);
            Log.i("SwanAppPerformanceUBC", "updateFlagNeedDiscard: sNeedDiscard=" + aFY);
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
        private static int aGd = 35;
        public JSONObject aGe;
        private boolean aGf = true;
        final String eventId;

        public a(String str) {
            this.eventId = str;
        }

        public a fW(String str) {
            this.mFrom = str;
            return this;
        }

        public a fX(String str) {
            this.mType = str;
            return this;
        }

        public a fY(String str) {
            this.mSource = str;
            return this;
        }

        @Override // com.baidu.swan.apps.statistic.a.e
        public JSONObject toJSONObject() {
            this.mSource = TextUtils.isEmpty(this.mSource) ? "NA" : this.mSource;
            if (this.aVi == null) {
                this.aVi = new JSONObject();
            }
            try {
                if (this.aGe != null) {
                    if (this.aGf) {
                        String ez = ac.ez(aGd);
                        if (!TextUtils.isEmpty(ez)) {
                            this.aGe.put("stacktrace", ez);
                        }
                    }
                    this.aVi.put("info", this.aGe);
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
