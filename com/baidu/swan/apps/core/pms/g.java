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
/* loaded from: classes10.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.e czm;
    private Timer mTimer;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.czm = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int alQ() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void aiY() {
        if (this.czm.abk() != 1) {
            synchronized (g.class) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.pms.g.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.bi("pms_getPkg", "PMS获取包接口返回超过3秒");
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
            }
        }
        com.baidu.swan.apps.performance.i.qc("startup").f(new UbcFlowEvent("aps_start_req"));
        super.aiY();
    }

    @Override // com.baidu.swan.pms.a.g
    public void N(String str, int i) {
        super.N(str, i);
        com.baidu.swan.pms.c.c xK = com.baidu.swan.pms.c.c.xK(str);
        if (xK != null) {
            boolean cW = com.baidu.swan.pms.utils.e.cW(xK.getData());
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "resetCore: " + cW);
            if (cW) {
                com.baidu.swan.apps.process.messaging.a.aAK().a(new com.baidu.swan.apps.process.messaging.c(129).fK(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void alR() {
        super.alR();
        com.baidu.swan.apps.performance.i.qc("startup").f(new UbcFlowEvent("aps_end_req"));
        if (this.czm.abk() != 1) {
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
        com.baidu.swan.apps.performance.i.qc("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void bk(String str, String str2) {
        super.bk(str, str2);
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
                    com.baidu.swan.apps.performance.i.qc("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.cyO != null) {
                        this.cyO.add(new UbcFlowEvent(str2));
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
            com.baidu.swan.apps.performance.i.qc("startup").f(new UbcFlowEvent("pms_network_start").bA(optLong5)).f(new UbcFlowEvent("pms_network_conn").bA(optLong4)).f(new UbcFlowEvent("pms_dns_start").bA(optLong3)).f(new UbcFlowEvent("pms_dns_end").bA(optLong2)).f(new UbcFlowEvent("pms_network_response").bA(jSONObject.optLong("responseTime", optLong))).f(new UbcFlowEvent("pms_send_header").bA(jSONObject.optLong("sendHeaderTime", optLong))).f(new UbcFlowEvent("pms_receive_header").bA(jSONObject.optLong("receiveHeaderTime", optLong)));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a2 = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a2.putString("launch_id", this.czm.aDe().auC());
        }
        return a2;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.am.a ts = new com.baidu.swan.apps.am.a().bX(10L).bY(aVar.errorNo).tr(aVar.errorMsg).ts(aVar.dTu);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.t.a.asO().a(com.baidu.swan.apps.t.a.asf(), this.mAppId, ts)) {
            a(ts, false);
            a(this.czm.aDe(), ts);
        } else if (aVar.errorNo == 1020) {
            a(ts, false);
            a(this.czm.aDe(), ts);
        } else {
            a(ts, true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiW() {
        super.aiW();
        if (this.cyN != null) {
            amd();
        }
        a(new com.baidu.swan.apps.am.a().bX(10L).bY(2901L).tr("同步获取-> Server无包"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void alU() {
        super.alU();
        if (DEBUG) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.i.qc("startup").f(new UbcFlowEvent("aps_end_download")).r("type", "0");
        com.baidu.swan.apps.inlinewidget.f.b.b.oj("0");
        this.cyO.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a amc = amc();
        this.cyO.add(new UbcFlowEvent("na_end_update_db"));
        if (amc == null) {
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.u.c.b amf = amf();
            if (this.cyL != null && this.cyL.category == 0) {
                amf.b(com.baidu.swan.apps.swancore.b.km(0));
                amf.iL(1);
            }
            if (this.cyL != null && this.cyL.category == 1) {
                amf.b(com.baidu.swan.apps.swancore.b.km(1));
                amf.iL(1);
            }
            if (this.cyM != null && this.cyM.category == 0) {
                amf.c(com.baidu.swan.apps.extcore.b.id(0));
                amf.iL(2);
            }
            if (this.cyM != null && this.cyM.category == 1) {
                amf.c(com.baidu.swan.apps.extcore.b.id(1));
                amf.iL(2);
            }
            if (this.cyQ != null) {
                amf.fb(this.cyQ.dTx);
                amf.oU(this.cyQ.pkgName);
            }
            d(this.cyN);
            br("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(amc, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        com.baidu.swan.apps.am.a tr;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            tr = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "未知错误");
            }
            tr = new com.baidu.swan.apps.am.a().bX(10L).bY(2900L).tr("包下载过程未知错误");
        }
        a(tr, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType alV() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int aiZ() {
        return 200;
    }

    public com.baidu.swan.apps.u.c.b amf() {
        return this.czm.aDe();
    }

    private void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.am.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.kd(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.auj();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.u("status", "1");
            if (aVar != null) {
                fVar.u("errcode", String.valueOf(aVar.aHv()));
                fVar.u("msg", aVar.aHu().toString());
            }
            fVar.sF(bVar.aup().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
            HybridUbcFlow qe = com.baidu.swan.apps.performance.i.qe("startup");
            if (qe != null) {
                qe.r("value", "na_success");
            }
        }
    }
}
