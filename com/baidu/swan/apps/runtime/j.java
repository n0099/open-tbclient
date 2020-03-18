package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class j extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e bHo;
    private com.baidu.swan.apps.process.messaging.client.a bPA;
    private boolean bPB = false;
    private SwanAppActivity biY;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo abk() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.bHo == null ? "" : this.bHo.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean abm() {
        return acC().abm();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean abl() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores abn() {
        return acC().abn();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int Gz() {
        return acC().Gz();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e acC() {
        if (this.bHo == null) {
            this.bHo = new e(this, "");
        }
        return this.bHo;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a acB() {
        if (this.bPA == null) {
            this.bPA = new com.baidu.swan.apps.process.messaging.client.a(this);
        }
        return this.bPA;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String v(String... strArr) {
        String str;
        if (this.bPB) {
            str = "";
        } else {
            this.bPB = true;
            str = "";
            if (this.bHo != null && this.bHo.abm()) {
                String w = this.bHo.w(strArr);
                this.bHo = null;
                d((i.a) new i.a("event_on_app_reseted").d("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.aaO().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = w;
            }
            this.bPB = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void acD() {
        if (this.bHo != null && this.bHo.abm()) {
            this.bHo.acD();
            v("flag_finish_activity", "flag_remove_task");
            ai.l(new Runnable() { // from class: com.baidu.swan.apps.runtime.j.1
                @Override // java.lang.Runnable
                public void run() {
                    Process.killProcess(Process.myPid());
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized void c(Bundle bundle, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (bundle != null) {
            if (DEBUG) {
                Log.i("SwanImpl", "updateSwanApp: " + str);
            }
            String string = bundle.getString("mAppId");
            if (kU(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.bHo = new e(this, string);
                }
                this.bHo.N(bundle);
            } else {
                boolean kV = kV(str);
                boolean z = false;
                long j = 0;
                long j2 = 0;
                boolean z2 = false;
                if (!TextUtils.isEmpty(string) && (!TextUtils.equals(string, getAppId()) || com.baidu.swan.apps.console.debugger.a.e.LS())) {
                    if (com.baidu.swan.apps.console.debugger.a.e.LS()) {
                        com.baidu.swan.apps.console.debugger.a.e.gD(str);
                    }
                    j = System.currentTimeMillis();
                    z = !TextUtils.isEmpty(v(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z) {
                        com.baidu.swan.apps.statistic.e.gr(3);
                    }
                    kV = true;
                    this.bHo = new e(this, string);
                    z2 = true;
                }
                if (abm()) {
                    if (kV) {
                        SwanLauncher.u(bundle);
                        b(bundle, z);
                    }
                    HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
                    jO.f(new UbcFlowEvent("swan_app_update_start").au(currentTimeMillis).dh(true));
                    if (j > 0) {
                        jO.f(new UbcFlowEvent("swan_app_update_reset_start").au(j).dh(true));
                    }
                    if (j2 > 0) {
                        jO.f(new UbcFlowEvent("swan_app_update_reset_ok").au(j2).dh(true));
                    }
                    boolean b = this.bHo.b(bundle, str, z2 || !this.bHo.available());
                    jO.f(new UbcFlowEvent("swan_app_update_end").dh(true));
                    if (!b && this.bHo.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        d("event_on_app_updated", bundle2);
                    }
                }
            }
        }
    }

    private boolean kU(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean kV(String str) {
        return bPz.contains(str);
    }

    private void b(@NonNull Bundle bundle, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = bundle.getLong("launch_time");
        long j2 = currentTimeMillis - j;
        long millis = TimeUnit.SECONDS.toMillis(10L);
        boolean z2 = bundle.getBoolean("should_ignore_launch_time", false) || j <= 1 || j2 > millis;
        if (z2) {
            bundle.putLong("launch_time", currentTimeMillis);
            j = currentTimeMillis;
        }
        long j3 = bundle.getLong("start_activity_time");
        if (z2 || j3 < 1) {
            j3 = j;
        }
        long j4 = bundle.getLong("receive_launch_intent_time");
        if (z2 || j4 < 1) {
            j4 = j3;
        }
        com.baidu.swan.apps.performance.f.jU("startup");
        HybridUbcFlow ba = com.baidu.swan.apps.performance.f.jO("startup").f(new UbcFlowEvent("resetFlow").dh(true)).f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).au(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).au(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).au(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).au(j4)).ba("process", String.valueOf(SwanAppProcessInfo.current())).ba("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            ba.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).au(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String kW = kW(bundle.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(kW)) {
                ba.ba(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, kW);
            }
            ba.ba("abtest", bundle2.getString("aiapp_abtest_info", ""));
        }
        this.bHo.acL().aj(j3);
        this.bHo.acL().al(j3);
        long j6 = bundle.getLong("launch_flag_for_statistic");
        long j7 = bundle.getLong("page_display_flag_for_statistic");
        if (j6 < 1 || j7 < 1 || currentTimeMillis - j6 > millis || currentTimeMillis - j7 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String kW(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (TextUtils.equals(jSONObject.optString("token"), "swanubc")) {
                return jSONObject.toString();
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity acE() {
        return this.biY;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.biY != swanAppActivity) {
            if (this.biY != null) {
                k(this.biY);
            }
            this.biY = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        this.biY = null;
    }
}
