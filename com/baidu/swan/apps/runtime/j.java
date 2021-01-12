package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class j extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e cEY;
    private SwanAppActivity cJC;
    private final com.baidu.swan.apps.process.messaging.client.a dCp = new com.baidu.swan.apps.process.messaging.client.a(this);
    private boolean dCq = false;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aFB() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.cEY == null ? "" : this.cEY.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aFD() {
        return aIj().aFD();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aFC() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aFE() {
        return aIj().aFE();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int afr() {
        return aIj().afr();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e aIj() {
        if (this.cEY == null) {
            this.cEY = new e(this, "");
        }
        return this.cEY;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a aIi() {
        return this.dCp;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String F(String... strArr) {
        String str;
        if (this.dCq) {
            str = "";
        } else {
            this.dCq = true;
            str = "";
            if (this.cEY != null && this.cEY.aFD()) {
                String G = this.cEY.G(strArr);
                this.cEY = null;
                i((i.a) new i.a("event_on_app_reseted").e("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = G;
            }
            this.dCq = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aIk() {
        if (this.cEY != null && this.cEY.aFD()) {
            this.cEY.aIk();
            F("flag_finish_activity", "flag_remove_task");
            ak.l(new Runnable() { // from class: com.baidu.swan.apps.runtime.j.1
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
        long currentTimeMillis = System.currentTimeMillis();
        if (bundle != null) {
            if (DEBUG) {
                Log.i("SwanImpl", "updateSwanApp: " + str);
            }
            String string = bundle.getString("mAppId");
            String string2 = bundle.getString("launch_id");
            HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
            if (!pS.pV(string2)) {
                com.baidu.swan.apps.performance.i.qa("startup");
                pS = com.baidu.swan.apps.performance.i.pS("startup").f(new UbcFlowEvent("resetFlow").gp(true));
                pS.pV(string2);
            }
            HybridUbcFlow hybridUbcFlow = pS;
            if (rp(str) || rq(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.cEY = new e(this, string);
                }
                this.cEY.S(bundle);
            } else {
                boolean rr = rr(str);
                boolean z2 = false;
                long j = 0;
                long j2 = 0;
                if (TextUtils.isEmpty(string) || (TextUtils.equals(string, getAppId()) && !com.baidu.swan.apps.console.debugger.a.e.alM())) {
                    z = false;
                } else {
                    if (com.baidu.swan.apps.console.debugger.a.e.alM()) {
                        com.baidu.swan.apps.console.debugger.a.e.lG(str);
                    }
                    j = System.currentTimeMillis();
                    z2 = !TextUtils.isEmpty(F(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z2) {
                        com.baidu.swan.apps.statistic.g.setStartType(3);
                    }
                    rr = true;
                    this.cEY = new e(this, string);
                    z = true;
                }
                if (aFD()) {
                    if (rr) {
                        SwanLauncher.v(bundle);
                        b(bundle, z2);
                    }
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_start").cy(currentTimeMillis).gp(true));
                    if (j > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_start").cy(j).gp(true));
                    }
                    if (j2 > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_ok").cy(j2).gp(true));
                    }
                    boolean b2 = this.cEY.b(bundle, str, z || !this.cEY.available());
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_end").gp(true));
                    if (!b2 && this.cEY.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        g("event_on_app_updated", bundle2);
                    }
                }
                if (z) {
                    com.baidu.swan.apps.core.turbo.d.arG().fy(z2);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aIm() {
        return new com.baidu.swan.apps.core.pms.b.b(this);
    }

    private boolean rp(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean rq(String str) {
        return TextUtils.equals("update_tag_by_app_launch", str);
    }

    private boolean rr(String str) {
        return dCo.contains(str);
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
        HybridUbcFlow cm = com.baidu.swan.apps.performance.i.pS("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cy(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cy(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cy(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cy(j4)).cm("process", String.valueOf(SwanAppProcessInfo.current())).cm("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            cm.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cy(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String rs = rs(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(rs)) {
                cm.cm(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, rs);
            }
            cm.cm("abtest", bundle2.getString("aiapp_abtest_info", ""));
            long j6 = bundle2.getLong("click_time", -1L);
            if (j6 > 0) {
                com.baidu.swan.apps.performance.i.pS("startup").f(new UbcFlowEvent("user_action").cy(j6));
            }
        }
        com.baidu.swan.apps.performance.i.aDI();
        this.cEY.aIv().ck(j3);
        this.cEY.aIv().cm(j3);
        com.baidu.swan.apps.performance.a.f.aDP().start(j);
        long j7 = bundle.getLong("launch_flag_for_statistic");
        long j8 = bundle.getLong("page_display_flag_for_statistic");
        if (j7 < 1 || j8 < 1 || currentTimeMillis - j7 > millis || currentTimeMillis - j8 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String rs(String str) {
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
    public SwanAppActivity aIl() {
        return this.cJC;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.cJC != swanAppActivity) {
            if (this.cJC != null) {
                k(this.cJC);
            }
            this.cJC = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        this.cJC = null;
    }
}
