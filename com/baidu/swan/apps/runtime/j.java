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
/* loaded from: classes3.dex */
public final class j extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e bYZ;
    private SwanAppActivity cdy;
    private final com.baidu.swan.apps.process.messaging.client.a cSz = new com.baidu.swan.apps.process.messaging.client.a(this);
    private boolean cSA = false;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo ayy() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.bYZ == null ? "" : this.bYZ.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean ayA() {
        return aAj().ayA();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean ayz() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores ayB() {
        return aAj().ayB();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int Yy() {
        return aAj().Yy();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e aAj() {
        if (this.bYZ == null) {
            this.bYZ = new e(this, "");
        }
        return this.bYZ;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a aAi() {
        return this.cSz;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String w(String... strArr) {
        String str;
        if (this.cSA) {
            str = "";
        } else {
            this.cSA = true;
            str = "";
            if (this.bYZ != null && this.bYZ.ayA()) {
                String x = this.bYZ.x(strArr);
                this.bYZ = null;
                i((i.a) new i.a("event_on_app_reseted").d("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = x;
            }
            this.cSA = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aAk() {
        if (this.bYZ != null && this.bYZ.ayA()) {
            this.bYZ.aAk();
            w("flag_finish_activity", "flag_remove_task");
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
            HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
            if (!pq.pt(string2)) {
                com.baidu.swan.apps.performance.i.py("startup");
                pq = com.baidu.swan.apps.performance.i.pq("startup").f(new UbcFlowEvent("resetFlow").fa(true));
                pq.pt(string2);
            }
            HybridUbcFlow hybridUbcFlow = pq;
            if (qJ(str) || qK(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.bYZ = new e(this, string);
                }
                this.bYZ.S(bundle);
            } else {
                boolean qL = qL(str);
                long j = 0;
                long j2 = 0;
                if (TextUtils.isEmpty(string) || (TextUtils.equals(string, getAppId()) && !com.baidu.swan.apps.console.debugger.a.e.aeO())) {
                    z = qL;
                    z2 = false;
                    z3 = false;
                } else {
                    if (com.baidu.swan.apps.console.debugger.a.e.aeO()) {
                        com.baidu.swan.apps.console.debugger.a.e.ld(str);
                    }
                    j = System.currentTimeMillis();
                    boolean z4 = !TextUtils.isEmpty(w(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z4) {
                        com.baidu.swan.apps.statistic.g.jF(3);
                    }
                    this.bYZ = new e(this, string);
                    z = true;
                    z2 = z4;
                    z3 = true;
                }
                if (ayA()) {
                    if (z) {
                        SwanLauncher.v(bundle);
                        b(bundle, z2);
                    }
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_start").bs(currentTimeMillis).fa(true));
                    if (j > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_start").bs(j).fa(true));
                    }
                    if (j2 > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_ok").bs(j2).fa(true));
                    }
                    boolean b = this.bYZ.b(bundle, str, z3 || !this.bYZ.available());
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_end").fa(true));
                    if (!b && this.bYZ.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        f("event_on_app_updated", bundle2);
                    }
                }
                if (z3) {
                    com.baidu.swan.apps.core.turbo.d.akC().ej(z2);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aAm() {
        return new com.baidu.swan.apps.core.pms.b.b(this);
    }

    private boolean qJ(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean qK(String str) {
        return TextUtils.equals("update_tag_by_app_launch", str);
    }

    private boolean qL(String str) {
        return cSy.contains(str);
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
        HybridUbcFlow bW = com.baidu.swan.apps.performance.i.pq("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bs(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bs(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bs(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bs(j4)).bW("process", String.valueOf(SwanAppProcessInfo.current())).bW("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            bW.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bs(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String qM = qM(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(qM)) {
                bW.bW(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, qM);
            }
            bW.bW("abtest", bundle2.getString("aiapp_abtest_info", ""));
            long j6 = bundle2.getLong("click_time", -1L);
            if (j6 > 0) {
                com.baidu.swan.apps.performance.i.pq("startup").f(new UbcFlowEvent("user_action").bs(j6));
            }
        }
        com.baidu.swan.apps.performance.i.awD();
        this.bYZ.aAv().be(j3);
        this.bYZ.aAv().bg(j3);
        com.baidu.swan.apps.performance.a.f.awK().start(j);
        long j7 = bundle.getLong("launch_flag_for_statistic");
        long j8 = bundle.getLong("page_display_flag_for_statistic");
        if (j7 < 1 || j8 < 1 || currentTimeMillis - j7 > millis || currentTimeMillis - j8 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String qM(String str) {
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
    public SwanAppActivity aAl() {
        return this.cdy;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.cdy != swanAppActivity) {
            if (this.cdy != null) {
                k(this.cdy);
            }
            this.cdy = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        this.cdy = null;
    }
}
