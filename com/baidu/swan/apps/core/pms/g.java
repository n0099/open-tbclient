package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.e cVi;
    private Timer mTimer;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.cVi = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aqG() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void anI() {
        if (this.cVi.getFrameType() != 1) {
            synchronized (g.class) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.pms.g.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.bn("pms_getPkg", "PMS获取包接口返回超过3秒");
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
            }
        }
        com.baidu.swan.apps.performance.i.qk("startup").f(new UbcFlowEvent("aps_start_req"));
        super.anI();
    }

    @Override // com.baidu.swan.pms.a.g
    public void T(String str, int i) {
        super.T(str, i);
        com.baidu.swan.pms.c.c ya = com.baidu.swan.pms.c.c.ya(str);
        if (ya != null) {
            boolean dg = com.baidu.swan.pms.utils.e.dg(ya.getData());
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "resetCore: " + dg);
            if (dg) {
                com.baidu.swan.apps.process.messaging.a.aFz().a(new com.baidu.swan.apps.process.messaging.c(129).gF(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void aqH() {
        super.aqH();
        com.baidu.swan.apps.performance.i.qk("startup").f(new UbcFlowEvent("aps_end_req"));
        if (this.cVi.getFrameType() != 1) {
            synchronized (g.class) {
                if (this.mTimer != null) {
                    this.mTimer.cancel();
                    this.mTimer = null;
                }
            }
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "PMS CS协议信息获取成功");
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        com.baidu.swan.apps.performance.i.qk("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void bp(String str, String str2) {
        super.bp(str, str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            char c = 65535;
            switch (str.hashCode()) {
                case 53647:
                    if (str.equals("670")) {
                        c = 0;
                        break;
                    }
                    break;
                case 54608:
                    if (str.equals("770")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    com.baidu.swan.apps.performance.i.qk("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.cUK != null) {
                        this.cUK.add(new UbcFlowEvent(str2));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(String str, String str2, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (DEBUG) {
                try {
                    try {
                        Log.i("PkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + jSONObject.toString(4));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.i("PkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + jSONObject.toString());
                    }
                } catch (Throwable th) {
                    Log.i("PkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + ((String) null));
                    throw th;
                }
            }
            long optLong = jSONObject.optLong("stat_recode_start_time", System.currentTimeMillis());
            long optLong2 = jSONObject.optLong("dnsEndTime", optLong);
            long optLong3 = jSONObject.optLong("dnsStartTime", optLong);
            long optLong4 = jSONObject.optLong("connectedTime", optLong);
            long optLong5 = jSONObject.optLong("startTime", optLong);
            com.baidu.swan.apps.performance.i.qk("startup").f(new UbcFlowEvent("pms_network_start").cE(optLong5)).f(new UbcFlowEvent("pms_network_conn").cE(optLong4)).f(new UbcFlowEvent("pms_dns_start").cE(optLong3)).f(new UbcFlowEvent("pms_dns_end").cE(optLong2)).f(new UbcFlowEvent("pms_network_response").cE(jSONObject.optLong("responseTime", optLong))).f(new UbcFlowEvent("pms_send_header").cE(jSONObject.optLong("sendHeaderTime", optLong))).f(new UbcFlowEvent("pms_receive_header").cE(jSONObject.optLong("receiveHeaderTime", optLong)));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a2 = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a2.putString("launch_id", this.cVi.aIO().azt());
        }
        return a2;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.al.a tG = new com.baidu.swan.apps.al.a().db(10L).dc(aVar.errorNo).tF(aVar.errorMsg).tG(aVar.eue);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.t.a.axE().a(com.baidu.swan.apps.t.a.awW(), this.mAppId, tG)) {
            a(tG, false);
            a(this.cVi.aIO(), tG);
        } else if (aVar.errorNo == 1020) {
            a(tG, false);
            a(this.cVi.aIO(), tG);
        } else {
            a(tG, true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void anG() {
        super.anG();
        if (this.cUJ != null) {
            aqT();
        }
        a(new com.baidu.swan.apps.al.a().db(10L).dc(2901L).tF("同步获取-> Server无包"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aqK() {
        super.aqK();
        if (DEBUG) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.i.qk("startup").f(new UbcFlowEvent("aps_end_download")).o("type", "0");
        com.baidu.swan.apps.inlinewidget.f.b.b.os("0");
        this.cUK.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.al.a aqS = aqS();
        this.cUK.add(new UbcFlowEvent("na_end_update_db"));
        if (aqS == null) {
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.u.c.b aqV = aqV();
            if (this.cUH != null && this.cUH.category == 0) {
                aqV.b(com.baidu.swan.apps.swancore.b.jD(0));
                aqV.hS(1);
            }
            if (this.cUH != null && this.cUH.category == 1) {
                aqV.b(com.baidu.swan.apps.swancore.b.jD(1));
                aqV.hS(1);
            }
            if (this.cUI != null && this.cUI.category == 0) {
                aqV.c(com.baidu.swan.apps.extcore.b.hk(0));
                aqV.hS(2);
            }
            if (this.cUI != null && this.cUI.category == 1) {
                aqV.c(com.baidu.swan.apps.extcore.b.hk(1));
                aqV.hS(2);
            }
            if (this.cUM != null) {
                aqV.fW(this.cUM.euh);
                aqV.pc(this.cUM.pkgName);
            }
            d(this.cUJ);
            bw("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(aqS, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void l(Throwable th) {
        com.baidu.swan.apps.al.a tF;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            tF = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "未知错误");
            }
            tF = new com.baidu.swan.apps.al.a().db(10L).dc(2900L).tF("包下载过程未知错误");
        }
        a(tF, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aqL() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int anJ() {
        return 200;
    }

    public com.baidu.swan.apps.u.c.b aqV() {
        return this.cVi.aIO();
    }

    private void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.al.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.ju(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.aza();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.r("status", "1");
            if (aVar != null) {
                fVar.r("errcode", String.valueOf(aVar.aNf()));
                fVar.r("msg", aVar.aNe().toString());
            }
            fVar.sT(bVar.azg().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
            HybridUbcFlow qm = com.baidu.swan.apps.performance.i.qm("startup");
            if (qm != null) {
                qm.o("value", "na_success");
            }
        }
    }
}
