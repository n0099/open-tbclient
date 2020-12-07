package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public final class j extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e cEU;
    private SwanAppActivity cJt;
    private final com.baidu.swan.apps.process.messaging.client.a dyw = new com.baidu.swan.apps.process.messaging.client.a(this);
    private boolean dyx = false;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aIb() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.cEU == null ? "" : this.cEU.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aId() {
        return aJM().aId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aIc() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aIe() {
        return aJM().aIe();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int aie() {
        return aJM().aie();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e aJM() {
        if (this.cEU == null) {
            this.cEU = new e(this, "");
        }
        return this.cEU;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a aJL() {
        return this.dyw;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String y(String... strArr) {
        String str;
        if (this.dyx) {
            str = "";
        } else {
            this.dyx = true;
            str = "";
            if (this.cEU != null && this.cEU.aId()) {
                String z = this.cEU.z(strArr);
                this.cEU = null;
                i((i.a) new i.a("event_on_app_reseted").d("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = z;
            }
            this.dyx = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aJN() {
        if (this.cEU != null && this.cEU.aId()) {
            this.cEU.aJN();
            y("flag_finish_activity", "flag_remove_task");
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.runtime.j.1
                @Override // java.lang.Runnable
                public void run() {
                    Process.killProcess(Process.myPid());
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized void e(Bundle bundle, String str) {
        boolean z;
        boolean z2;
        boolean z3;
        long currentTimeMillis = System.currentTimeMillis();
        if (bundle != null) {
            if (DEBUG) {
                Log.i("SwanImpl", "updateSwanApp: " + str);
            }
            String string = bundle.getString("mAppId");
            String string2 = bundle.getString("launch_id");
            HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
            if (!rk.rn(string2)) {
                com.baidu.swan.apps.performance.i.rs("startup");
                rk = com.baidu.swan.apps.performance.i.rk("startup").f(new UbcFlowEvent("resetFlow").gk(true));
                rk.rn(string2);
            }
            HybridUbcFlow hybridUbcFlow = rk;
            if (sE(str) || sF(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.cEU = new e(this, string);
                }
                this.cEU.S(bundle);
            } else {
                boolean sG = sG(str);
                long j = 0;
                long j2 = 0;
                if (TextUtils.isEmpty(string) || (TextUtils.equals(string, getAppId()) && !com.baidu.swan.apps.console.debugger.a.e.aot())) {
                    z = sG;
                    z2 = false;
                    z3 = false;
                } else {
                    if (com.baidu.swan.apps.console.debugger.a.e.aot()) {
                        com.baidu.swan.apps.console.debugger.a.e.mY(str);
                    }
                    j = System.currentTimeMillis();
                    boolean z4 = !TextUtils.isEmpty(y(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z4) {
                        com.baidu.swan.apps.statistic.g.kR(3);
                    }
                    this.cEU = new e(this, string);
                    z = true;
                    z2 = z4;
                    z3 = true;
                }
                if (aId()) {
                    if (z) {
                        SwanLauncher.v(bundle);
                        b(bundle, z2);
                    }
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_start").cx(currentTimeMillis).gk(true));
                    if (j > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_start").cx(j).gk(true));
                    }
                    if (j2 > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_ok").cx(j2).gk(true));
                    }
                    boolean b = this.cEU.b(bundle, str, z3 || !this.cEU.available());
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_end").gk(true));
                    if (!b && this.cEU.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        f("event_on_app_updated", bundle2);
                    }
                }
                if (z3) {
                    com.baidu.swan.apps.core.turbo.d.aui().ft(z2);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aJP() {
        return new com.baidu.swan.apps.core.pms.b.b(this);
    }

    private boolean sE(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean sF(String str) {
        return TextUtils.equals("update_tag_by_app_launch", str);
    }

    private boolean sG(String str) {
        return dyv.contains(str);
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
        HybridUbcFlow co = com.baidu.swan.apps.performance.i.rk("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cx(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cx(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cx(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cx(j4)).co("process", String.valueOf(SwanAppProcessInfo.current())).co("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            co.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cx(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String sH = sH(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(sH)) {
                co.co(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, sH);
            }
            co.co("abtest", bundle2.getString("aiapp_abtest_info", ""));
            long j6 = bundle2.getLong("click_time", -1L);
            if (j6 > 0) {
                com.baidu.swan.apps.performance.i.rk("startup").f(new UbcFlowEvent("user_action").cx(j6));
            }
        }
        com.baidu.swan.apps.performance.i.aGi();
        this.cEU.aJY().cj(j3);
        this.cEU.aJY().cl(j3);
        com.baidu.swan.apps.performance.a.f.aGp().start(j);
        long j7 = bundle.getLong("launch_flag_for_statistic");
        long j8 = bundle.getLong("page_display_flag_for_statistic");
        if (j7 < 1 || j8 < 1 || currentTimeMillis - j7 > millis || currentTimeMillis - j8 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String sH(String str) {
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
    public SwanAppActivity aJO() {
        return this.cJt;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.cJt != swanAppActivity) {
            if (this.cJt != null) {
                k(this.cJt);
            }
            this.cJt = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        this.cJt = null;
    }
}
