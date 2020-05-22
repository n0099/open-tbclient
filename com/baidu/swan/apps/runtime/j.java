package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.aj;
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
    private e bLN;
    private SwanAppActivity bQd;
    private final com.baidu.swan.apps.process.messaging.client.a czZ = new com.baidu.swan.apps.process.messaging.client.a(this);
    private boolean cAa = false;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo anc() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.bLN == null ? "" : this.bLN.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean ane() {
        return aox().ane();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean and() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores anf() {
        return aox().anf();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int Qz() {
        return aox().Qz();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e aox() {
        if (this.bLN == null) {
            this.bLN = new e(this, "");
        }
        return this.bLN;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a aow() {
        return this.czZ;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String w(String... strArr) {
        String str;
        if (this.cAa) {
            str = "";
        } else {
            this.cAa = true;
            str = "";
            if (this.bLN != null && this.bLN.ane()) {
                String x = this.bLN.x(strArr);
                this.bLN = null;
                i((i.a) new i.a("event_on_app_reseted").d("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = x;
            }
            this.cAa = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aoy() {
        if (this.bLN != null && this.bLN.ane()) {
            this.bLN.aoy();
            w("flag_finish_activity", "flag_remove_task");
            aj.p(new Runnable() { // from class: com.baidu.swan.apps.runtime.j.1
                @Override // java.lang.Runnable
                public void run() {
                    Process.killProcess(Process.myPid());
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized void d(Bundle bundle, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (bundle != null) {
            if (DEBUG) {
                Log.i("SwanImpl", "updateSwanApp: " + str);
            }
            String string = bundle.getString("mAppId");
            String string2 = bundle.getString("launch_id");
            HybridUbcFlow mp = com.baidu.swan.apps.performance.g.mp("startup");
            if (!mp.ms(string2)) {
                com.baidu.swan.apps.performance.g.mw("startup");
                mp = com.baidu.swan.apps.performance.g.mp("startup").f(new UbcFlowEvent("resetFlow").eu(true));
                mp.ms(string2);
            }
            HybridUbcFlow hybridUbcFlow = mp;
            if (nC(str) || nD(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.bLN = new e(this, string);
                }
                this.bLN.T(bundle);
            } else {
                boolean nE = nE(str);
                boolean z = false;
                long j = 0;
                long j2 = 0;
                boolean z2 = false;
                if (!TextUtils.isEmpty(string) && (!TextUtils.equals(string, getAppId()) || com.baidu.swan.apps.console.debugger.a.e.Wm())) {
                    if (com.baidu.swan.apps.console.debugger.a.e.Wm()) {
                        com.baidu.swan.apps.console.debugger.a.e.iR(str);
                    }
                    j = System.currentTimeMillis();
                    z = !TextUtils.isEmpty(w(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z) {
                        com.baidu.swan.apps.statistic.g.gR(3);
                    }
                    nE = true;
                    this.bLN = new e(this, string);
                    z2 = true;
                }
                if (ane()) {
                    if (nE) {
                        SwanLauncher.x(bundle);
                        b(bundle, z);
                    }
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_start").bg(currentTimeMillis).eu(true));
                    if (j > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_start").bg(j).eu(true));
                    }
                    if (j2 > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_ok").bg(j2).eu(true));
                    }
                    boolean b = this.bLN.b(bundle, str, z2 || !this.bLN.available());
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_end").eu(true));
                    if (!b && this.bLN.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        g("event_on_app_updated", bundle2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aoA() {
        return new com.baidu.swan.apps.core.pms.b.b(this);
    }

    private boolean nC(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean nD(String str) {
        return TextUtils.equals("update_tag_by_app_launch", str);
    }

    private boolean nE(String str) {
        return czY.contains(str);
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
        HybridUbcFlow bD = com.baidu.swan.apps.performance.g.mp("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bg(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bg(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bg(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bg(j4)).bD("process", String.valueOf(SwanAppProcessInfo.current())).bD("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            bD.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bg(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String nF = nF(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(nF)) {
                bD.bD(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, nF);
            }
            bD.bD("abtest", bundle2.getString("aiapp_abtest_info", ""));
            long j6 = bundle2.getLong("click_time", -1L);
            if (j6 > 0) {
                com.baidu.swan.apps.performance.g.mp("startup").f(new UbcFlowEvent("user_action").bg(j6));
            }
        }
        com.baidu.swan.apps.performance.g.alz();
        this.bLN.aoJ().aU(j3);
        this.bLN.aoJ().aW(j3);
        com.baidu.swan.apps.performance.a.f.alH().start(j);
        long j7 = bundle.getLong("launch_flag_for_statistic");
        long j8 = bundle.getLong("page_display_flag_for_statistic");
        if (j7 < 1 || j8 < 1 || currentTimeMillis - j7 > millis || currentTimeMillis - j8 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String nF(String str) {
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
    public SwanAppActivity aoz() {
        return this.bQd;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.bQd != swanAppActivity) {
            if (this.bQd != null) {
                j(this.bQd);
            }
            this.bQd = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        this.bQd = null;
    }
}
