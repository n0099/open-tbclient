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
/* loaded from: classes10.dex */
public final class j extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e clo;
    private SwanAppActivity cpO;
    private final com.baidu.swan.apps.process.messaging.client.a deH = new com.baidu.swan.apps.process.messaging.client.a(this);
    private boolean deI = false;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aBh() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.clo == null ? "" : this.clo.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aBj() {
        return aCS().aBj();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aBi() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aBk() {
        return aCS().aBk();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int abk() {
        return aCS().abk();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e aCS() {
        if (this.clo == null) {
            this.clo = new e(this, "");
        }
        return this.clo;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a aCR() {
        return this.deH;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String x(String... strArr) {
        String str;
        if (this.deI) {
            str = "";
        } else {
            this.deI = true;
            str = "";
            if (this.clo != null && this.clo.aBj()) {
                String y = this.clo.y(strArr);
                this.clo = null;
                i((i.a) new i.a("event_on_app_reseted").d("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.aAK().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = y;
            }
            this.deI = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aCT() {
        if (this.clo != null && this.clo.aBj()) {
            this.clo.aCT();
            x("flag_finish_activity", "flag_remove_task");
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
            HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
            if (!qc.qf(string2)) {
                com.baidu.swan.apps.performance.i.qk("startup");
                qc = com.baidu.swan.apps.performance.i.qc("startup").f(new UbcFlowEvent("resetFlow").fw(true));
                qc.qf(string2);
            }
            HybridUbcFlow hybridUbcFlow = qc;
            if (rv(str) || rw(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.clo = new e(this, string);
                }
                this.clo.S(bundle);
            } else {
                boolean rx2 = rx(str);
                long j = 0;
                long j2 = 0;
                if (TextUtils.isEmpty(string) || (TextUtils.equals(string, getAppId()) && !com.baidu.swan.apps.console.debugger.a.e.ahz())) {
                    z = rx2;
                    z2 = false;
                    z3 = false;
                } else {
                    if (com.baidu.swan.apps.console.debugger.a.e.ahz()) {
                        com.baidu.swan.apps.console.debugger.a.e.lP(str);
                    }
                    j = System.currentTimeMillis();
                    boolean z4 = !TextUtils.isEmpty(x(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z4) {
                        com.baidu.swan.apps.statistic.g.kc(3);
                    }
                    this.clo = new e(this, string);
                    z = true;
                    z2 = z4;
                    z3 = true;
                }
                if (aBj()) {
                    if (z) {
                        SwanLauncher.v(bundle);
                        b(bundle, z2);
                    }
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_start").bA(currentTimeMillis).fw(true));
                    if (j > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_start").bA(j).fw(true));
                    }
                    if (j2 > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_ok").bA(j2).fw(true));
                    }
                    boolean b = this.clo.b(bundle, str, z3 || !this.clo.available());
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_end").fw(true));
                    if (!b && this.clo.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        f("event_on_app_updated", bundle2);
                    }
                }
                if (z3) {
                    com.baidu.swan.apps.core.turbo.d.ann().eF(z2);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aCV() {
        return new com.baidu.swan.apps.core.pms.b.b(this);
    }

    private boolean rv(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean rw(String str) {
        return TextUtils.equals("update_tag_by_app_launch", str);
    }

    private boolean rx(String str) {
        return deG.contains(str);
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
        HybridUbcFlow cb = com.baidu.swan.apps.performance.i.qc("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bA(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bA(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bA(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bA(j4)).cb("process", String.valueOf(SwanAppProcessInfo.current())).cb("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            cb.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bA(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String ry = ry(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(ry)) {
                cb.cb(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ry);
            }
            cb.cb("abtest", bundle2.getString("aiapp_abtest_info", ""));
            long j6 = bundle2.getLong("click_time", -1L);
            if (j6 > 0) {
                com.baidu.swan.apps.performance.i.qc("startup").f(new UbcFlowEvent("user_action").bA(j6));
            }
        }
        com.baidu.swan.apps.performance.i.azo();
        this.clo.aDe().bm(j3);
        this.clo.aDe().bo(j3);
        com.baidu.swan.apps.performance.a.f.azv().start(j);
        long j7 = bundle.getLong("launch_flag_for_statistic");
        long j8 = bundle.getLong("page_display_flag_for_statistic");
        if (j7 < 1 || j8 < 1 || currentTimeMillis - j7 > millis || currentTimeMillis - j8 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String ry(String str) {
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
    public SwanAppActivity aCU() {
        return this.cpO;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.cpO != swanAppActivity) {
            if (this.cpO != null) {
                k(this.cpO);
            }
            this.cpO = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        this.cpO = null;
    }
}
