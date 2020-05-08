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
    private SwanAppActivity bHl;
    private e cgd;
    private com.baidu.swan.apps.process.messaging.client.a cos;
    private boolean cot = false;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo ajo() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.cgd == null ? "" : this.cgd.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean ajq() {
        return akG().ajq();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean ajp() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores ajr() {
        return akG().ajr();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int Ol() {
        return akG().Ol();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e akG() {
        if (this.cgd == null) {
            this.cgd = new e(this, "");
        }
        return this.cgd;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a akF() {
        if (this.cos == null) {
            this.cos = new com.baidu.swan.apps.process.messaging.client.a(this);
        }
        return this.cos;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String v(String... strArr) {
        String str;
        if (this.cot) {
            str = "";
        } else {
            this.cot = true;
            str = "";
            if (this.cgd != null && this.cgd.ajq()) {
                String w = this.cgd.w(strArr);
                this.cgd = null;
                d((i.a) new i.a("event_on_app_reseted").d("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.aiS().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = w;
            }
            this.cot = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void akH() {
        if (this.cgd != null && this.cgd.ajq()) {
            this.cgd.akH();
            v("flag_finish_activity", "flag_remove_task");
            ai.o(new Runnable() { // from class: com.baidu.swan.apps.runtime.j.1
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
            if (mh(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.cgd = new e(this, string);
                }
                this.cgd.N(bundle);
            } else {
                boolean mi = mi(str);
                boolean z = false;
                long j = 0;
                long j2 = 0;
                boolean z2 = false;
                if (!TextUtils.isEmpty(string) && (!TextUtils.equals(string, getAppId()) || com.baidu.swan.apps.console.debugger.a.e.TF())) {
                    if (com.baidu.swan.apps.console.debugger.a.e.TF()) {
                        com.baidu.swan.apps.console.debugger.a.e.hQ(str);
                    }
                    j = System.currentTimeMillis();
                    z = !TextUtils.isEmpty(v(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z) {
                        com.baidu.swan.apps.statistic.e.gy(3);
                    }
                    mi = true;
                    this.cgd = new e(this, string);
                    z2 = true;
                }
                if (ajq()) {
                    if (mi) {
                        SwanLauncher.u(bundle);
                        b(bundle, z);
                    }
                    HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
                    lb.f(new UbcFlowEvent("swan_app_update_start").aZ(currentTimeMillis).ed(true));
                    if (j > 0) {
                        lb.f(new UbcFlowEvent("swan_app_update_reset_start").aZ(j).ed(true));
                    }
                    if (j2 > 0) {
                        lb.f(new UbcFlowEvent("swan_app_update_reset_ok").aZ(j2).ed(true));
                    }
                    boolean b = this.cgd.b(bundle, str, z2 || !this.cgd.available());
                    lb.f(new UbcFlowEvent("swan_app_update_end").ed(true));
                    if (!b && this.cgd.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        d("event_on_app_updated", bundle2);
                    }
                }
            }
        }
    }

    private boolean mh(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean mi(String str) {
        return cor.contains(str);
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
        com.baidu.swan.apps.performance.f.lh("startup");
        HybridUbcFlow bk = com.baidu.swan.apps.performance.f.lb("startup").f(new UbcFlowEvent("resetFlow").ed(true)).f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).aZ(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).aZ(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).aZ(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).aZ(j4)).bk("process", String.valueOf(SwanAppProcessInfo.current())).bk("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            bk.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).aZ(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String mj = mj(bundle.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(mj)) {
                bk.bk(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, mj);
            }
            bk.bk("abtest", bundle2.getString("aiapp_abtest_info", ""));
        }
        this.cgd.akP().aN(j3);
        this.cgd.akP().aP(j3);
        long j6 = bundle.getLong("launch_flag_for_statistic");
        long j7 = bundle.getLong("page_display_flag_for_statistic");
        if (j6 < 1 || j7 < 1 || currentTimeMillis - j6 > millis || currentTimeMillis - j7 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String mj(String str) {
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
    public SwanAppActivity akI() {
        return this.bHl;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.bHl != swanAppActivity) {
            if (this.bHl != null) {
                k(this.bHl);
            }
            this.bHl = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        this.bHl = null;
    }
}
