package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.e cSK;
    private Timer mTimer;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.cSK = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int asL() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void apS() {
        if (this.cSK.aie() != 1) {
            synchronized (g.class) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.pms.g.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.bv("pms_getPkg", "PMS获取包接口返回超过3秒");
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
            }
        }
        com.baidu.swan.apps.performance.i.rk("startup").f(new UbcFlowEvent("aps_start_req"));
        super.apS();
    }

    @Override // com.baidu.swan.pms.a.g
    public void Q(String str, int i) {
        super.Q(str, i);
        com.baidu.swan.pms.c.c yT = com.baidu.swan.pms.c.c.yT(str);
        if (yT != null) {
            boolean db = com.baidu.swan.pms.utils.e.db(yT.getData());
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "resetCore: " + db);
            if (db) {
                com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(129).gy(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void asM() {
        super.asM();
        com.baidu.swan.apps.performance.i.rk("startup").f(new UbcFlowEvent("aps_end_req"));
        if (this.cSK.aie() != 1) {
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
        com.baidu.swan.apps.performance.i.rk("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void bx(String str, String str2) {
        super.bx(str, str2);
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
                    com.baidu.swan.apps.performance.i.rk("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.cSm != null) {
                        this.cSm.add(new UbcFlowEvent(str2));
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
            com.baidu.swan.apps.performance.i.rk("startup").f(new UbcFlowEvent("pms_network_start").cx(optLong5)).f(new UbcFlowEvent("pms_network_conn").cx(optLong4)).f(new UbcFlowEvent("pms_dns_start").cx(optLong3)).f(new UbcFlowEvent("pms_dns_end").cx(optLong2)).f(new UbcFlowEvent("pms_network_response").cx(jSONObject.optLong("responseTime", optLong))).f(new UbcFlowEvent("pms_send_header").cx(jSONObject.optLong("sendHeaderTime", optLong))).f(new UbcFlowEvent("pms_receive_header").cx(jSONObject.optLong("receiveHeaderTime", optLong)));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a2 = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a2.putString("launch_id", this.cSK.aJY().aBx());
        }
        return a2;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.am.a uB = new com.baidu.swan.apps.am.a().cU(10L).cV(aVar.errorNo).uA(aVar.errorMsg).uB(aVar.enb);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.t.a.azI().a(com.baidu.swan.apps.t.a.aza(), this.mAppId, uB)) {
            a(uB, false);
            a(this.cSK.aJY(), uB);
        } else if (aVar.errorNo == 1020) {
            a(uB, false);
            a(this.cSK.aJY(), uB);
        } else {
            a(uB, true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void apQ() {
        super.apQ();
        if (this.cSl != null) {
            asY();
        }
        a(new com.baidu.swan.apps.am.a().cU(10L).cV(2901L).uA("同步获取-> Server无包"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void asP() {
        super.asP();
        if (DEBUG) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.i.rk("startup").f(new UbcFlowEvent("aps_end_download")).q("type", "0");
        com.baidu.swan.apps.inlinewidget.f.b.b.ps("0");
        this.cSm.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a asX = asX();
        this.cSm.add(new UbcFlowEvent("na_end_update_db"));
        if (asX == null) {
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.u.c.b ata = ata();
            if (this.cSj != null && this.cSj.category == 0) {
                ata.b(com.baidu.swan.apps.swancore.b.lb(0));
                ata.jA(1);
            }
            if (this.cSj != null && this.cSj.category == 1) {
                ata.b(com.baidu.swan.apps.swancore.b.lb(1));
                ata.jA(1);
            }
            if (this.cSk != null && this.cSk.category == 0) {
                ata.c(com.baidu.swan.apps.extcore.b.iS(0));
                ata.jA(2);
            }
            if (this.cSk != null && this.cSk.category == 1) {
                ata.c(com.baidu.swan.apps.extcore.b.iS(1));
                ata.jA(2);
            }
            if (this.cSo != null) {
                ata.fP(this.cSo.enf);
                ata.qc(this.cSo.pkgName);
            }
            d(this.cSl);
            bE("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(asX, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        com.baidu.swan.apps.am.a uA;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            uA = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "未知错误");
            }
            uA = new com.baidu.swan.apps.am.a().cU(10L).cV(2900L).uA("包下载过程未知错误");
        }
        a(uA, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType asQ() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int apT() {
        return 200;
    }

    public com.baidu.swan.apps.u.c.b ata() {
        return this.cSK.aJY();
    }

    private void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.am.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.kS(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.aBe();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.t("status", "1");
            if (aVar != null) {
                fVar.t("errcode", String.valueOf(aVar.aOo()));
                fVar.t("msg", aVar.aOn().toString());
            }
            fVar.tO(bVar.aBk().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
            HybridUbcFlow rm = com.baidu.swan.apps.performance.i.rm("startup");
            if (rm != null) {
                rm.q("value", "na_success");
            }
        }
    }
}
