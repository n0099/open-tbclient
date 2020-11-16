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
/* loaded from: classes7.dex */
public final class j extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppActivity cCy;
    private e cyc;
    private final com.baidu.swan.apps.process.messaging.client.a drv = new com.baidu.swan.apps.process.messaging.client.a(this);
    private boolean drw = false;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aET() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.cyc == null ? "" : this.cyc.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aEV() {
        return aGE().aEV();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aEU() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aEW() {
        return aGE().aEW();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int aeW() {
        return aGE().aeW();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e aGE() {
        if (this.cyc == null) {
            this.cyc = new e(this, "");
        }
        return this.cyc;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a aGD() {
        return this.drv;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String y(String... strArr) {
        String str;
        if (this.drw) {
            str = "";
        } else {
            this.drw = true;
            str = "";
            if (this.cyc != null && this.cyc.aEV()) {
                String z = this.cyc.z(strArr);
                this.cyc = null;
                i((i.a) new i.a("event_on_app_reseted").d("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = z;
            }
            this.drw = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aGF() {
        if (this.cyc != null && this.cyc.aEV()) {
            this.cyc.aGF();
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
            HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
            if (!qD.qG(string2)) {
                com.baidu.swan.apps.performance.i.qL("startup");
                qD = com.baidu.swan.apps.performance.i.qD("startup").f(new UbcFlowEvent("resetFlow").fV(true));
                qD.qG(string2);
            }
            HybridUbcFlow hybridUbcFlow = qD;
            if (rW(str) || rX(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.cyc = new e(this, string);
                }
                this.cyc.S(bundle);
            } else {
                boolean rY = rY(str);
                long j = 0;
                long j2 = 0;
                if (TextUtils.isEmpty(string) || (TextUtils.equals(string, getAppId()) && !com.baidu.swan.apps.console.debugger.a.e.all())) {
                    z = rY;
                    z2 = false;
                    z3 = false;
                } else {
                    if (com.baidu.swan.apps.console.debugger.a.e.all()) {
                        com.baidu.swan.apps.console.debugger.a.e.mr(str);
                    }
                    j = System.currentTimeMillis();
                    boolean z4 = !TextUtils.isEmpty(y(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z4) {
                        com.baidu.swan.apps.statistic.g.kt(3);
                    }
                    this.cyc = new e(this, string);
                    z = true;
                    z2 = z4;
                    z3 = true;
                }
                if (aEV()) {
                    if (z) {
                        SwanLauncher.v(bundle);
                        b(bundle, z2);
                    }
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_start").bY(currentTimeMillis).fV(true));
                    if (j > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_start").bY(j).fV(true));
                    }
                    if (j2 > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_ok").bY(j2).fV(true));
                    }
                    boolean b = this.cyc.b(bundle, str, z3 || !this.cyc.available());
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_end").fV(true));
                    if (!b && this.cyc.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        f("event_on_app_updated", bundle2);
                    }
                }
                if (z3) {
                    com.baidu.swan.apps.core.turbo.d.ara().fe(z2);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aGH() {
        return new com.baidu.swan.apps.core.pms.b.b(this);
    }

    private boolean rW(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean rX(String str) {
        return TextUtils.equals("update_tag_by_app_launch", str);
    }

    private boolean rY(String str) {
        return dru.contains(str);
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
        HybridUbcFlow ch = com.baidu.swan.apps.performance.i.qD("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bY(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bY(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bY(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bY(j4)).ch("process", String.valueOf(SwanAppProcessInfo.current())).ch("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            ch.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bY(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String rZ = rZ(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(rZ)) {
                ch.ch(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, rZ);
            }
            ch.ch("abtest", bundle2.getString("aiapp_abtest_info", ""));
            long j6 = bundle2.getLong("click_time", -1L);
            if (j6 > 0) {
                com.baidu.swan.apps.performance.i.qD("startup").f(new UbcFlowEvent("user_action").bY(j6));
            }
        }
        com.baidu.swan.apps.performance.i.aDa();
        this.cyc.aGQ().bK(j3);
        this.cyc.aGQ().bM(j3);
        com.baidu.swan.apps.performance.a.f.aDh().start(j);
        long j7 = bundle.getLong("launch_flag_for_statistic");
        long j8 = bundle.getLong("page_display_flag_for_statistic");
        if (j7 < 1 || j8 < 1 || currentTimeMillis - j7 > millis || currentTimeMillis - j8 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String rZ(String str) {
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
    public SwanAppActivity aGG() {
        return this.cCy;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.cCy != swanAppActivity) {
            if (this.cCy != null) {
                k(this.cCy);
            }
            this.cCy = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        this.cCy = null;
    }
}
