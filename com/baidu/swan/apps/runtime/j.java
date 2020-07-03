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
    private e bQB;
    private SwanAppActivity bUR;
    private final com.baidu.swan.apps.process.messaging.client.a cEJ = new com.baidu.swan.apps.process.messaging.client.a(this);
    private boolean cEK = false;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aoi() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.bQB == null ? "" : this.bQB.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aok() {
        return apE().aok();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aoj() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aol() {
        return apE().aol();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int RF() {
        return apE().RF();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e apE() {
        if (this.bQB == null) {
            this.bQB = new e(this, "");
        }
        return this.bQB;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a apD() {
        return this.cEJ;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String v(String... strArr) {
        String str;
        if (this.cEK) {
            str = "";
        } else {
            this.cEK = true;
            str = "";
            if (this.bQB != null && this.bQB.aok()) {
                String w = this.bQB.w(strArr);
                this.bQB = null;
                i((i.a) new i.a("event_on_app_reseted").d("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.anM().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = w;
            }
            this.cEK = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void apF() {
        if (this.bQB != null && this.bQB.aok()) {
            this.bQB.apF();
            v("flag_finish_activity", "flag_remove_task");
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
            HybridUbcFlow mx = com.baidu.swan.apps.performance.g.mx("startup");
            if (!mx.mA(string2)) {
                com.baidu.swan.apps.performance.g.mE("startup");
                mx = com.baidu.swan.apps.performance.g.mx("startup").f(new UbcFlowEvent("resetFlow").ez(true));
                mx.mA(string2);
            }
            HybridUbcFlow hybridUbcFlow = mx;
            if (nK(str) || nL(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.bQB = new e(this, string);
                }
                this.bQB.T(bundle);
            } else {
                boolean nM = nM(str);
                boolean z = false;
                long j = 0;
                long j2 = 0;
                boolean z2 = false;
                if (!TextUtils.isEmpty(string) && (!TextUtils.equals(string, getAppId()) || com.baidu.swan.apps.console.debugger.a.e.Xs())) {
                    if (com.baidu.swan.apps.console.debugger.a.e.Xs()) {
                        com.baidu.swan.apps.console.debugger.a.e.iZ(str);
                    }
                    j = System.currentTimeMillis();
                    z = !TextUtils.isEmpty(v(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z) {
                        com.baidu.swan.apps.statistic.g.he(3);
                    }
                    nM = true;
                    this.bQB = new e(this, string);
                    z2 = true;
                }
                if (aok()) {
                    if (nM) {
                        SwanLauncher.x(bundle);
                        b(bundle, z);
                    }
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_start").bg(currentTimeMillis).ez(true));
                    if (j > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_start").bg(j).ez(true));
                    }
                    if (j2 > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_ok").bg(j2).ez(true));
                    }
                    boolean b = this.bQB.b(bundle, str, z2 || !this.bQB.available());
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_end").ez(true));
                    if (!b && this.bQB.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        g("event_on_app_updated", bundle2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f apH() {
        return new com.baidu.swan.apps.core.pms.b.b(this);
    }

    private boolean nK(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean nL(String str) {
        return TextUtils.equals("update_tag_by_app_launch", str);
    }

    private boolean nM(String str) {
        return cEI.contains(str);
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
        HybridUbcFlow bF = com.baidu.swan.apps.performance.g.mx("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bg(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bg(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bg(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bg(j4)).bF("process", String.valueOf(SwanAppProcessInfo.current())).bF("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            bF.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bg(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String nN = nN(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(nN)) {
                bF.bF(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, nN);
            }
            bF.bF("abtest", bundle2.getString("aiapp_abtest_info", ""));
            long j6 = bundle2.getLong("click_time", -1L);
            if (j6 > 0) {
                com.baidu.swan.apps.performance.g.mx("startup").f(new UbcFlowEvent("user_action").bg(j6));
            }
        }
        com.baidu.swan.apps.performance.g.amF();
        this.bQB.apQ().aU(j3);
        this.bQB.apQ().aW(j3);
        com.baidu.swan.apps.performance.a.f.amN().start(j);
        long j7 = bundle.getLong("launch_flag_for_statistic");
        long j8 = bundle.getLong("page_display_flag_for_statistic");
        if (j7 < 1 || j8 < 1 || currentTimeMillis - j7 > millis || currentTimeMillis - j8 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String nN(String str) {
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
    public SwanAppActivity apG() {
        return this.bUR;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.bUR != swanAppActivity) {
            if (this.bUR != null) {
                j(this.bUR);
            }
            this.bUR = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        this.bUR = null;
    }
}
