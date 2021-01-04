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
/* loaded from: classes9.dex */
public final class j extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e cJK;
    private SwanAppActivity cOo;
    private final com.baidu.swan.apps.process.messaging.client.a dHb = new com.baidu.swan.apps.process.messaging.client.a(this);
    private boolean dHc = false;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aJu() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.cJK == null ? "" : this.cJK.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aJw() {
        return aMc().aJw();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aJv() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aJx() {
        return aMc().aJx();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int ajk() {
        return aMc().ajk();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e aMc() {
        if (this.cJK == null) {
            this.cJK = new e(this, "");
        }
        return this.cJK;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a aMb() {
        return this.dHb;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String F(String... strArr) {
        String str;
        if (this.dHc) {
            str = "";
        } else {
            this.dHc = true;
            str = "";
            if (this.cJK != null && this.cJK.aJw()) {
                String G = this.cJK.G(strArr);
                this.cJK = null;
                i((i.a) new i.a("event_on_app_reseted").e("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.aIX().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = G;
            }
            this.dHc = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aMd() {
        if (this.cJK != null && this.cJK.aJw()) {
            this.cJK.aMd();
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
            HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
            if (!rd.rg(string2)) {
                com.baidu.swan.apps.performance.i.rl("startup");
                rd = com.baidu.swan.apps.performance.i.rd("startup").f(new UbcFlowEvent("resetFlow").gt(true));
                rd.rg(string2);
            }
            HybridUbcFlow hybridUbcFlow = rd;
            if (sB(str) || sC(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.cJK = new e(this, string);
                }
                this.cJK.S(bundle);
            } else {
                boolean sD = sD(str);
                boolean z2 = false;
                long j = 0;
                long j2 = 0;
                if (TextUtils.isEmpty(string) || (TextUtils.equals(string, getAppId()) && !com.baidu.swan.apps.console.debugger.a.e.apG())) {
                    z = false;
                } else {
                    if (com.baidu.swan.apps.console.debugger.a.e.apG()) {
                        com.baidu.swan.apps.console.debugger.a.e.mR(str);
                    }
                    j = System.currentTimeMillis();
                    z2 = !TextUtils.isEmpty(F(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z2) {
                        com.baidu.swan.apps.statistic.g.setStartType(3);
                    }
                    sD = true;
                    this.cJK = new e(this, string);
                    z = true;
                }
                if (aJw()) {
                    if (sD) {
                        SwanLauncher.v(bundle);
                        b(bundle, z2);
                    }
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_start").cy(currentTimeMillis).gt(true));
                    if (j > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_start").cy(j).gt(true));
                    }
                    if (j2 > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_ok").cy(j2).gt(true));
                    }
                    boolean b2 = this.cJK.b(bundle, str, z || !this.cJK.available());
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_end").gt(true));
                    if (!b2 && this.cJK.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        f("event_on_app_updated", bundle2);
                    }
                }
                if (z) {
                    com.baidu.swan.apps.core.turbo.d.avA().fC(z2);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aMf() {
        return new com.baidu.swan.apps.core.pms.b.b(this);
    }

    private boolean sB(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean sC(String str) {
        return TextUtils.equals("update_tag_by_app_launch", str);
    }

    private boolean sD(String str) {
        return dHa.contains(str);
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
        HybridUbcFlow cn2 = com.baidu.swan.apps.performance.i.rd("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cy(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cy(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cy(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cy(j4)).cn("process", String.valueOf(SwanAppProcessInfo.current())).cn("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            cn2.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).cy(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String sE = sE(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(sE)) {
                cn2.cn(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, sE);
            }
            cn2.cn("abtest", bundle2.getString("aiapp_abtest_info", ""));
            long j6 = bundle2.getLong("click_time", -1L);
            if (j6 > 0) {
                com.baidu.swan.apps.performance.i.rd("startup").f(new UbcFlowEvent("user_action").cy(j6));
            }
        }
        com.baidu.swan.apps.performance.i.aHB();
        this.cJK.aMo().ck(j3);
        this.cJK.aMo().cm(j3);
        com.baidu.swan.apps.performance.a.f.aHI().start(j);
        long j7 = bundle.getLong("launch_flag_for_statistic");
        long j8 = bundle.getLong("page_display_flag_for_statistic");
        if (j7 < 1 || j8 < 1 || currentTimeMillis - j7 > millis || currentTimeMillis - j8 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String sE(String str) {
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
    public SwanAppActivity aMe() {
        return this.cOo;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.cOo != swanAppActivity) {
            if (this.cOo != null) {
                k(this.cOo);
            }
            this.cOo = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        this.cOo = null;
    }
}
