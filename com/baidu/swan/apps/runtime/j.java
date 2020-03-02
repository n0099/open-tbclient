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
    private e bHc;
    private com.baidu.swan.apps.process.messaging.client.a bPo;
    private boolean bPp = false;
    private SwanAppActivity biK;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo abh() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.bHc == null ? "" : this.bHc.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean abj() {
        return acz().abj();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean abi() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores abk() {
        return acz().abk();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int Gu() {
        return acz().Gu();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e acz() {
        if (this.bHc == null) {
            this.bHc = new e(this, "");
        }
        return this.bHc;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a acy() {
        if (this.bPo == null) {
            this.bPo = new com.baidu.swan.apps.process.messaging.client.a(this);
        }
        return this.bPo;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String v(String... strArr) {
        String str;
        if (this.bPp) {
            str = "";
        } else {
            this.bPp = true;
            str = "";
            if (this.bHc != null && this.bHc.abj()) {
                String w = this.bHc.w(strArr);
                this.bHc = null;
                d((i.a) new i.a("event_on_app_reseted").d("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = w;
            }
            this.bPp = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void acA() {
        if (this.bHc != null && this.bHc.abj()) {
            this.bHc.acA();
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
            if (kV(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.bHc = new e(this, string);
                }
                this.bHc.N(bundle);
            } else {
                boolean kW = kW(str);
                boolean z = false;
                long j = 0;
                long j2 = 0;
                boolean z2 = false;
                if (!TextUtils.isEmpty(string) && (!TextUtils.equals(string, getAppId()) || com.baidu.swan.apps.console.debugger.a.e.LP())) {
                    if (com.baidu.swan.apps.console.debugger.a.e.LP()) {
                        com.baidu.swan.apps.console.debugger.a.e.gE(str);
                    }
                    j = System.currentTimeMillis();
                    z = !TextUtils.isEmpty(v(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z) {
                        com.baidu.swan.apps.statistic.e.gr(3);
                    }
                    kW = true;
                    this.bHc = new e(this, string);
                    z2 = true;
                }
                if (abj()) {
                    if (kW) {
                        SwanLauncher.u(bundle);
                        b(bundle, z);
                    }
                    HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
                    jP.f(new UbcFlowEvent("swan_app_update_start").au(currentTimeMillis).dg(true));
                    if (j > 0) {
                        jP.f(new UbcFlowEvent("swan_app_update_reset_start").au(j).dg(true));
                    }
                    if (j2 > 0) {
                        jP.f(new UbcFlowEvent("swan_app_update_reset_ok").au(j2).dg(true));
                    }
                    boolean b = this.bHc.b(bundle, str, z2 || !this.bHc.available());
                    jP.f(new UbcFlowEvent("swan_app_update_end").dg(true));
                    if (!b && this.bHc.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        d("event_on_app_updated", bundle2);
                    }
                }
            }
        }
    }

    private boolean kV(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean kW(String str) {
        return bPn.contains(str);
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
        com.baidu.swan.apps.performance.f.jV("startup");
        HybridUbcFlow bb = com.baidu.swan.apps.performance.f.jP("startup").f(new UbcFlowEvent("resetFlow").dg(true)).f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).au(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).au(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).au(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).au(j4)).bb("process", String.valueOf(SwanAppProcessInfo.current())).bb("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            bb.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).au(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String kX = kX(bundle.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(kX)) {
                bb.bb(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, kX);
            }
            bb.bb("abtest", bundle2.getString("aiapp_abtest_info", ""));
        }
        this.bHc.acI().aj(j3);
        this.bHc.acI().al(j3);
        long j6 = bundle.getLong("launch_flag_for_statistic");
        long j7 = bundle.getLong("page_display_flag_for_statistic");
        if (j6 < 1 || j7 < 1 || currentTimeMillis - j6 > millis || currentTimeMillis - j7 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String kX(String str) {
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
    public SwanAppActivity acB() {
        return this.biK;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.biK != swanAppActivity) {
            if (this.biK != null) {
                k(this.biK);
            }
            this.biK = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        this.biK = null;
    }
}
