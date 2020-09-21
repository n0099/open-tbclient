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
/* loaded from: classes3.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.e cmV;
    private Timer mTimer;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.cmV = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int ajf() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void agn() {
        if (this.cmV.Yy() != 1) {
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
        com.baidu.swan.apps.performance.i.pq("startup").f(new UbcFlowEvent("aps_start_req"));
        super.agn();
    }

    @Override // com.baidu.swan.pms.a.g
    public void M(String str, int i) {
        super.M(str, i);
        com.baidu.swan.pms.c.c wY = com.baidu.swan.pms.c.c.wY(str);
        if (wY != null) {
            boolean cP = com.baidu.swan.pms.utils.e.cP(wY.getData());
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "resetCore: " + cP);
            if (cP) {
                com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(129).fo(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void ajg() {
        super.ajg();
        com.baidu.swan.apps.performance.i.pq("startup").f(new UbcFlowEvent("aps_end_req"));
        if (this.cmV.Yy() != 1) {
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
        com.baidu.swan.apps.performance.i.pq("startup").f(new UbcFlowEvent("aps_start_download"));
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
                    com.baidu.swan.apps.performance.i.pq("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.cmx != null) {
                        this.cmx.add(new UbcFlowEvent(str2));
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
            com.baidu.swan.apps.performance.i.pq("startup").f(new UbcFlowEvent("pms_network_start").bs(optLong5)).f(new UbcFlowEvent("pms_network_conn").bs(optLong4)).f(new UbcFlowEvent("pms_dns_start").bs(optLong3)).f(new UbcFlowEvent("pms_dns_end").bs(optLong2)).f(new UbcFlowEvent("pms_network_response").bs(jSONObject.optLong("responseTime", optLong))).f(new UbcFlowEvent("pms_send_header").bs(jSONObject.optLong("sendHeaderTime", optLong))).f(new UbcFlowEvent("pms_receive_header").bs(jSONObject.optLong("receiveHeaderTime", optLong)));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.cmV.aAv().arQ());
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.am.a sG = new com.baidu.swan.apps.am.a().bP(10L).bQ(aVar.errorNo).sF(aVar.errorMsg).sG(aVar.dHt);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.t.a.aqc().a(com.baidu.swan.apps.t.a.apu(), this.mAppId, sG)) {
            a(sG, false);
            a(this.cmV.aAv(), sG);
        } else if (aVar.errorNo == 1020) {
            a(sG, false);
            a(this.cmV.aAv(), sG);
        } else {
            a(sG, true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void agl() {
        super.agl();
        if (this.cmw != null) {
            ajs();
        }
        a(new com.baidu.swan.apps.am.a().bP(10L).bQ(2901L).sF("同步获取-> Server无包"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void ajj() {
        super.ajj();
        if (DEBUG) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.i.pq("startup").f(new UbcFlowEvent("aps_end_download")).r("type", "0");
        com.baidu.swan.apps.inlinewidget.f.b.b.nw("0");
        this.cmx.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a ajr = ajr();
        this.cmx.add(new UbcFlowEvent("na_end_update_db"));
        if (ajr == null) {
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.u.c.b aju = aju();
            if (this.cmu != null && this.cmu.category == 0) {
                aju.b(com.baidu.swan.apps.swancore.b.jP(0));
                aju.io(1);
            }
            if (this.cmu != null && this.cmu.category == 1) {
                aju.b(com.baidu.swan.apps.swancore.b.jP(1));
                aju.io(1);
            }
            if (this.cmv != null && this.cmv.category == 0) {
                aju.c(com.baidu.swan.apps.extcore.b.hG(0));
                aju.io(2);
            }
            if (this.cmv != null && this.cmv.category == 1) {
                aju.c(com.baidu.swan.apps.extcore.b.hG(1));
                aju.io(2);
            }
            if (this.cmz != null) {
                aju.eF(this.cmz.dHw);
                aju.oh(this.cmz.pkgName);
            }
            d(this.cmw);
            bm("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(ajr, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        com.baidu.swan.apps.am.a sF;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            sF = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "未知错误");
            }
            sF = new com.baidu.swan.apps.am.a().bP(10L).bQ(2900L).sF("包下载过程未知错误");
        }
        a(sF, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType ajk() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int ago() {
        return 200;
    }

    public com.baidu.swan.apps.u.c.b aju() {
        return this.cmV.aAv();
    }

    private void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.am.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.jG(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.arx();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.u("status", "1");
            if (aVar != null) {
                fVar.u("errcode", String.valueOf(aVar.aEM()));
                fVar.u("msg", aVar.aEL().toString());
            }
            fVar.rS(bVar.arD().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
            HybridUbcFlow ps = com.baidu.swan.apps.performance.i.ps("startup");
            if (ps != null) {
                ps.r("value", "na_success");
            }
        }
    }
}
