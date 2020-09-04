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
/* loaded from: classes8.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.e ckT;
    private Timer mTimer;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.ckT = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aiv() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void afD() {
        if (this.ckT.XP() != 1) {
            synchronized (g.class) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.pms.g.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.bd("pms_getPkg", "PMS获取包接口返回超过3秒");
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
            }
        }
        com.baidu.swan.apps.performance.i.oX("startup").f(new UbcFlowEvent("aps_start_req"));
        super.afD();
    }

    @Override // com.baidu.swan.pms.a.g
    public void M(String str, int i) {
        super.M(str, i);
        com.baidu.swan.pms.c.c wF = com.baidu.swan.pms.c.c.wF(str);
        if (wF != null) {
            boolean cM = com.baidu.swan.pms.utils.e.cM(wF.getData());
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "resetCore: " + cM);
            if (cM) {
                com.baidu.swan.apps.process.messaging.a.axs().a(new com.baidu.swan.apps.process.messaging.c(129).fq(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void aiw() {
        super.aiw();
        com.baidu.swan.apps.performance.i.oX("startup").f(new UbcFlowEvent("aps_end_req"));
        if (this.ckT.XP() != 1) {
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
        com.baidu.swan.apps.performance.i.oX("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void bf(String str, String str2) {
        super.bf(str, str2);
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
                    com.baidu.swan.apps.performance.i.oX("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.ckv != null) {
                        this.ckv.add(new UbcFlowEvent(str2));
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
            com.baidu.swan.apps.performance.i.oX("startup").f(new UbcFlowEvent("pms_network_start").br(optLong5)).f(new UbcFlowEvent("pms_network_conn").br(optLong4)).f(new UbcFlowEvent("pms_dns_start").br(optLong3)).f(new UbcFlowEvent("pms_dns_end").br(optLong2)).f(new UbcFlowEvent("pms_network_response").br(jSONObject.optLong("responseTime", optLong))).f(new UbcFlowEvent("pms_send_header").br(jSONObject.optLong("sendHeaderTime", optLong))).f(new UbcFlowEvent("pms_receive_header").br(jSONObject.optLong("receiveHeaderTime", optLong)));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.ckT.azM().arg());
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(10L).bP(aVar.errorNo).sl(aVar.errorMsg).sm(aVar.dFp);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.t.a.aps().a(com.baidu.swan.apps.t.a.aoJ(), this.mAppId, sm)) {
            a(sm, false);
            a(this.ckT.azM(), sm);
        } else if (aVar.errorNo == 1020) {
            a(sm, false);
            a(this.ckT.azM(), sm);
        } else {
            a(sm, true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void afB() {
        super.afB();
        if (this.cku != null) {
            aiI();
        }
        a(new com.baidu.swan.apps.am.a().bO(10L).bP(2901L).sl("同步获取-> Server无包"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aiz() {
        super.aiz();
        if (DEBUG) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.i.oX("startup").f(new UbcFlowEvent("aps_end_download")).r("type", "0");
        com.baidu.swan.apps.inlinewidget.f.b.b.nd("0");
        this.ckv.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a aiH = aiH();
        this.ckv.add(new UbcFlowEvent("na_end_update_db"));
        if (aiH == null) {
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.u.c.b aiK = aiK();
            if (this.cks != null && this.cks.category == 0) {
                aiK.b(com.baidu.swan.apps.swancore.b.jE(0));
                aiK.ie(1);
            }
            if (this.cks != null && this.cks.category == 1) {
                aiK.b(com.baidu.swan.apps.swancore.b.jE(1));
                aiK.ie(1);
            }
            if (this.ckt != null && this.ckt.category == 0) {
                aiK.c(com.baidu.swan.apps.extcore.b.hx(0));
                aiK.ie(2);
            }
            if (this.ckt != null && this.ckt.category == 1) {
                aiK.c(com.baidu.swan.apps.extcore.b.hx(1));
                aiK.ie(2);
            }
            if (this.ckx != null) {
                aiK.eH(this.ckx.dFs);
                aiK.nN(this.ckx.pkgName);
            }
            d(this.cku);
            bm("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(aiH, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        com.baidu.swan.apps.am.a sl;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            sl = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "未知错误");
            }
            sl = new com.baidu.swan.apps.am.a().bO(10L).bP(2900L).sl("包下载过程未知错误");
        }
        a(sl, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aiA() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int afE() {
        return 200;
    }

    public com.baidu.swan.apps.u.c.b aiK() {
        return this.ckT.azM();
    }

    private void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.am.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.jv(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.aqN();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.u("status", "1");
            if (aVar != null) {
                fVar.u("errcode", String.valueOf(aVar.aEc()));
                fVar.u("msg", aVar.aEb().toString());
            }
            fVar.rz(bVar.aqT().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
            HybridUbcFlow oZ = com.baidu.swan.apps.performance.i.oZ("startup");
            if (oZ != null) {
                oZ.r("value", "na_success");
            }
        }
    }
}
