package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes10.dex */
public final class j extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e bCV;
    private com.baidu.swan.apps.process.messaging.client.a bLi;
    private boolean bLj = false;
    private SwanAppActivity bev;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo YR() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.bCV == null ? "" : this.bCV.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean YT() {
        return aaj().YT();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean YS() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores YU() {
        return aaj().YU();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int Ed() {
        return aaj().Ed();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e aaj() {
        if (this.bCV == null) {
            this.bCV = new e(this, "");
        }
        return this.bCV;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a aai() {
        if (this.bLi == null) {
            this.bLi = new com.baidu.swan.apps.process.messaging.client.a(this);
        }
        return this.bLi;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String r(String... strArr) {
        String str;
        if (this.bLj) {
            str = "";
        } else {
            this.bLj = true;
            str = "";
            if (this.bCV != null && this.bCV.YT()) {
                String s = this.bCV.s(strArr);
                this.bCV = null;
                d((i.a) new i.a("event_on_app_reseted").d("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = s;
            }
            this.bLj = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aak() {
        if (this.bCV != null && this.bCV.YT()) {
            this.bCV.aak();
            r("flag_finish_activity", "flag_remove_task");
            ai.l(new Runnable() { // from class: com.baidu.swan.apps.runtime.j.1
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
            if (kG(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.bCV = new e(this, string);
                }
                this.bCV.N(bundle);
            } else {
                boolean kH = kH(str);
                boolean z = false;
                long j = 0;
                long j2 = 0;
                boolean z2 = false;
                if (!TextUtils.isEmpty(string) && (!TextUtils.equals(string, getAppId()) || com.baidu.swan.apps.console.debugger.a.e.Jy())) {
                    if (com.baidu.swan.apps.console.debugger.a.e.Jy()) {
                        com.baidu.swan.apps.console.debugger.a.e.go(str);
                    }
                    j = System.currentTimeMillis();
                    z = !TextUtils.isEmpty(r(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z) {
                        com.baidu.swan.apps.statistic.e.ga(3);
                    }
                    kH = true;
                    this.bCV = new e(this, string);
                    z2 = true;
                }
                if (YT()) {
                    if (kH) {
                        SwanLauncher.u(bundle);
                        b(bundle, z);
                    }
                    HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
                    jA.f(new UbcFlowEvent("swan_app_update_start").aq(currentTimeMillis).cZ(true));
                    if (j > 0) {
                        jA.f(new UbcFlowEvent("swan_app_update_reset_start").aq(j).cZ(true));
                    }
                    if (j2 > 0) {
                        jA.f(new UbcFlowEvent("swan_app_update_reset_ok").aq(j2).cZ(true));
                    }
                    boolean b = this.bCV.b(bundle, str, z2 || !this.bCV.available());
                    jA.f(new UbcFlowEvent("swan_app_update_end").cZ(true));
                    if (!b && this.bCV.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        d("event_on_app_updated", bundle2);
                    }
                }
            }
        }
    }

    private boolean kG(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean kH(String str) {
        return bLh.contains(str);
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
        com.baidu.swan.apps.performance.f.jG("startup");
        HybridUbcFlow aS = com.baidu.swan.apps.performance.f.jA("startup").f(new UbcFlowEvent("resetFlow").cZ(true)).f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).aq(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).aq(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).aq(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).aq(j4)).aS("process", String.valueOf(SwanAppProcessInfo.current())).aS("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            aS.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).aq(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String kI = kI(bundle.getString("third_ext", ""));
            if (!TextUtils.isEmpty(kI)) {
                aS.aS("third_ext", kI);
            }
            aS.aS("abtest", bundle2.getString("aiapp_abtest_info", ""));
        }
        this.bCV.aas().af(j3);
        this.bCV.aas().ah(j3);
        long j6 = bundle.getLong("launch_flag_for_statistic");
        long j7 = bundle.getLong("page_display_flag_for_statistic");
        if (j6 < 1 || j7 < 1 || currentTimeMillis - j6 > millis || currentTimeMillis - j7 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String kI(String str) {
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
    public SwanAppActivity aal() {
        return this.bev;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.bev != swanAppActivity) {
            if (this.bev != null) {
                k(this.bev);
            }
            this.bev = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        this.bev = null;
    }
}
