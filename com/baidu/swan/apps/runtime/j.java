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
    private e cIT;
    private SwanAppActivity cNq;
    private final com.baidu.swan.apps.process.messaging.client.a dFU = new com.baidu.swan.apps.process.messaging.client.a(this);
    private boolean dFV = false;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aFZ() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.cIT == null ? "" : this.cIT.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aGb() {
        return aIF().aGb();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aGa() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aGc() {
        return aIF().aGc();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int getFrameType() {
        return aIF().getFrameType();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e aIF() {
        if (this.cIT == null) {
            this.cIT = new e(this, "");
        }
        return this.cIT;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a aIE() {
        return this.dFU;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String F(String... strArr) {
        String str;
        if (this.dFV) {
            str = "";
        } else {
            this.dFV = true;
            str = "";
            if (this.cIT != null && this.cIT.aGb()) {
                String G = this.cIT.G(strArr);
                this.cIT = null;
                i((i.a) new i.a("event_on_app_reseted").e("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.aFC().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = G;
            }
            this.dFV = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aIG() {
        if (this.cIT != null && this.cIT.aGb()) {
            this.cIT.aIG();
            F("flag_finish_activity", "flag_remove_task");
            ak.j(new Runnable() { // from class: com.baidu.swan.apps.runtime.j.1
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
            HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
            if (!qr.qu(string2)) {
                com.baidu.swan.apps.performance.i.qz("startup");
                qr = com.baidu.swan.apps.performance.i.qr("startup").f(new UbcFlowEvent("resetFlow").gr(true));
                qr.qu(string2);
            }
            HybridUbcFlow hybridUbcFlow = qr;
            if (rP(str) || rQ(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.cIT = new e(this, string);
                }
                this.cIT.S(bundle);
            } else {
                boolean rR = rR(str);
                boolean z2 = false;
                long j = 0;
                long j2 = 0;
                if (TextUtils.isEmpty(string) || (TextUtils.equals(string, getAppId()) && !com.baidu.swan.apps.console.debugger.a.e.amn())) {
                    z = false;
                } else {
                    if (com.baidu.swan.apps.console.debugger.a.e.amn()) {
                        com.baidu.swan.apps.console.debugger.a.e.mf(str);
                    }
                    j = System.currentTimeMillis();
                    z2 = !TextUtils.isEmpty(F(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z2) {
                        com.baidu.swan.apps.statistic.g.setStartType(3);
                    }
                    rR = true;
                    this.cIT = new e(this, string);
                    z = true;
                }
                if (aGb()) {
                    if (rR) {
                        SwanLauncher.v(bundle);
                        b(bundle, z2);
                    }
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_start").cE(currentTimeMillis).gr(true));
                    if (j > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_start").cE(j).gr(true));
                    }
                    if (j2 > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_ok").cE(j2).gr(true));
                    }
                    boolean b = this.cIT.b(bundle, str, z || !this.cIT.available());
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_end").gr(true));
                    if (!b && this.cIT.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        g("event_on_app_updated", bundle2);
                    }
                }
                if (z) {
                    com.baidu.swan.apps.core.turbo.d.ash().fA(z2);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aII() {
        return new com.baidu.swan.apps.core.pms.b.b(this);
    }

    private boolean rP(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean rQ(String str) {
        return TextUtils.equals("update_tag_by_app_launch", str);
    }

    private boolean rR(String str) {
        return dFT.contains(str);
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
        HybridUbcFlow cg = com.baidu.swan.apps.performance.i.qr("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cE(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cE(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cE(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cE(j4)).cg("process", String.valueOf(SwanAppProcessInfo.current())).cg("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            cg.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cE(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String rS = rS(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(rS)) {
                cg.cg(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, rS);
            }
            cg.cg("abtest", bundle2.getString("aiapp_abtest_info", ""));
            long j6 = bundle2.getLong("click_time", -1L);
            if (j6 > 0) {
                com.baidu.swan.apps.performance.i.qr("startup").f(new UbcFlowEvent("user_action").cE(j6));
            }
        }
        com.baidu.swan.apps.performance.i.aEg();
        this.cIT.aIR().cq(j3);
        this.cIT.aIR().cs(j3);
        com.baidu.swan.apps.performance.a.f.aEn().start(j);
        long j7 = bundle.getLong("launch_flag_for_statistic");
        long j8 = bundle.getLong("page_display_flag_for_statistic");
        if (j7 < 1 || j8 < 1 || currentTimeMillis - j7 > millis || currentTimeMillis - j8 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String rS(String str) {
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
    public SwanAppActivity aIH() {
        return this.cNq;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.cNq != swanAppActivity) {
            if (this.cNq != null) {
                k(this.cNq);
            }
            this.cNq = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        this.cNq = null;
    }
}
