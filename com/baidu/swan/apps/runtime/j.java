package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.al;
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
    private e bRs;
    private SwanAppActivity bVJ;
    private final com.baidu.swan.apps.process.messaging.client.a cHw = new com.baidu.swan.apps.process.messaging.client.a(this);
    private boolean cHx = false;

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo apS() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.bRs == null ? "" : this.bRs.getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean apU() {
        return arn().apU();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean apT() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores apV() {
        return arn().apV();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int RU() {
        return arn().RU();
    }

    @Override // com.baidu.swan.apps.runtime.h
    @NonNull
    public e arn() {
        if (this.bRs == null) {
            this.bRs = new e(this, "");
        }
        return this.bRs;
    }

    @Override // com.baidu.swan.apps.runtime.h
    @Nullable
    public com.baidu.swan.apps.process.messaging.client.a arm() {
        return this.cHw;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public synchronized String v(String... strArr) {
        String str;
        if (this.cHx) {
            str = "";
        } else {
            this.cHx = true;
            str = "";
            if (this.bRs != null && this.bRs.apU()) {
                String w = this.bRs.w(strArr);
                this.bRs = null;
                i((i.a) new i.a("event_on_app_reseted").d("event_params_reset_flags", strArr));
                com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(2));
                str = w;
            }
            this.cHx = false;
        }
        return str;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aro() {
        if (this.bRs != null && this.bRs.apU()) {
            this.bRs.aro();
            v("flag_finish_activity", "flag_remove_task");
            al.p(new Runnable() { // from class: com.baidu.swan.apps.runtime.j.1
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
            HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
            if (!mX.na(string2)) {
                com.baidu.swan.apps.performance.i.ng("startup");
                mX = com.baidu.swan.apps.performance.i.mX("startup").f(new UbcFlowEvent("resetFlow").eI(true));
                mX.na(string2);
            }
            HybridUbcFlow hybridUbcFlow = mX;
            if (os(str) || ot(str)) {
                if (!TextUtils.equals(string, getAppId())) {
                    this.bRs = new e(this, string);
                }
                this.bRs.U(bundle);
            } else {
                boolean ou = ou(str);
                boolean z = false;
                long j = 0;
                long j2 = 0;
                boolean z2 = false;
                if (!TextUtils.isEmpty(string) && (!TextUtils.equals(string, getAppId()) || com.baidu.swan.apps.console.debugger.a.e.XY())) {
                    if (com.baidu.swan.apps.console.debugger.a.e.XY()) {
                        com.baidu.swan.apps.console.debugger.a.e.jj(str);
                    }
                    j = System.currentTimeMillis();
                    z = !TextUtils.isEmpty(v(new String[0]));
                    j2 = System.currentTimeMillis();
                    if (z) {
                        com.baidu.swan.apps.statistic.g.hn(3);
                    }
                    ou = true;
                    this.bRs = new e(this, string);
                    z2 = true;
                }
                if (apU()) {
                    if (ou) {
                        SwanLauncher.x(bundle);
                        b(bundle, z);
                    }
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_start").bm(currentTimeMillis).eI(true));
                    if (j > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_start").bm(j).eI(true));
                    }
                    if (j2 > 0) {
                        hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_reset_ok").bm(j2).eI(true));
                    }
                    boolean b = this.bRs.b(bundle, str, z2 || !this.bRs.available());
                    hybridUbcFlow.f(new UbcFlowEvent("swan_app_update_end").eI(true));
                    if (!b && this.bRs.available()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        g("event_on_app_updated", bundle2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f arq() {
        return new com.baidu.swan.apps.core.pms.b.b(this);
    }

    private boolean os(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    private boolean ot(String str) {
        return TextUtils.equals("update_tag_by_app_launch", str);
    }

    private boolean ou(String str) {
        return cHv.contains(str);
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
        HybridUbcFlow bH = com.baidu.swan.apps.performance.i.mX("startup").f(new UbcFlowEvent("naStart").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bm(j)).f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bm(j)).f(new UbcFlowEvent("na_launch_activity").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bm(j3)).f(new UbcFlowEvent("na_receive_intent").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bm(j4)).bH("process", String.valueOf(SwanAppProcessInfo.current())).bH("reuse", z ? "1" : "0");
        long j5 = bundle.getLong("veloce_start_time", 0L);
        if (j5 > 0) {
            bH.f(new UbcFlowEvent("na_veloce_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).bm(j5));
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String ov = ov(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(ov)) {
                bH.bH(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ov);
            }
            bH.bH("abtest", bundle2.getString("aiapp_abtest_info", ""));
            long j6 = bundle2.getLong("click_time", -1L);
            if (j6 > 0) {
                com.baidu.swan.apps.performance.i.mX("startup").f(new UbcFlowEvent("user_action").bm(j6));
            }
        }
        com.baidu.swan.apps.performance.i.anZ();
        this.bRs.arz().aY(j3);
        this.bRs.arz().ba(j3);
        com.baidu.swan.apps.performance.a.f.aoh().start(j);
        long j7 = bundle.getLong("launch_flag_for_statistic");
        long j8 = bundle.getLong("page_display_flag_for_statistic");
        if (j7 < 1 || j8 < 1 || currentTimeMillis - j7 > millis || currentTimeMillis - j8 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    private static String ov(String str) {
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
    public SwanAppActivity arp() {
        return this.bVJ;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && this.bVJ != swanAppActivity) {
            if (this.bVJ != null) {
                k(this.bVJ);
            }
            this.bVJ = swanAppActivity;
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        this.bVJ = null;
    }
}
