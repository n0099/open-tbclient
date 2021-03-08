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
/* loaded from: classes8.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.e cWI;
    private Timer mTimer;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.cWI = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aqJ() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void anL() {
        if (this.cWI.getFrameType() != 1) {
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
        com.baidu.swan.apps.performance.i.qr("startup").f(new UbcFlowEvent("aps_start_req"));
        super.anL();
    }

    @Override // com.baidu.swan.pms.a.g
    public void U(String str, int i) {
        super.U(str, i);
        com.baidu.swan.pms.c.c yh = com.baidu.swan.pms.c.c.yh(str);
        if (yh != null) {
            boolean di = com.baidu.swan.pms.utils.e.di(yh.getData());
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "resetCore: " + di);
            if (di) {
                com.baidu.swan.apps.process.messaging.a.aFC().a(new com.baidu.swan.apps.process.messaging.c(129).gF(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void aqK() {
        super.aqK();
        com.baidu.swan.apps.performance.i.qr("startup").f(new UbcFlowEvent("aps_end_req"));
        if (this.cWI.getFrameType() != 1) {
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
        com.baidu.swan.apps.performance.i.qr("startup").f(new UbcFlowEvent("aps_start_download"));
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
                    com.baidu.swan.apps.performance.i.qr("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.cWk != null) {
                        this.cWk.add(new UbcFlowEvent(str2));
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
            com.baidu.swan.apps.performance.i.qr("startup").f(new UbcFlowEvent("pms_network_start").cE(optLong5)).f(new UbcFlowEvent("pms_network_conn").cE(optLong4)).f(new UbcFlowEvent("pms_dns_start").cE(optLong3)).f(new UbcFlowEvent("pms_dns_end").cE(optLong2)).f(new UbcFlowEvent("pms_network_response").cE(jSONObject.optLong("responseTime", optLong))).f(new UbcFlowEvent("pms_send_header").cE(jSONObject.optLong("sendHeaderTime", optLong))).f(new UbcFlowEvent("pms_receive_header").cE(jSONObject.optLong("receiveHeaderTime", optLong)));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a2 = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a2.putString("launch_id", this.cWI.aIR().azw());
        }
        return a2;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.al.a tN = new com.baidu.swan.apps.al.a().db(10L).dc(aVar.errorNo).tM(aVar.errorMsg).tN(aVar.evF);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.t.a.axH().a(com.baidu.swan.apps.t.a.awZ(), this.mAppId, tN)) {
            a(tN, false);
            a(this.cWI.aIR(), tN);
        } else if (aVar.errorNo == 1020) {
            a(tN, false);
            a(this.cWI.aIR(), tN);
        } else {
            a(tN, true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void anJ() {
        super.anJ();
        if (this.cWj != null) {
            aqW();
        }
        a(new com.baidu.swan.apps.al.a().db(10L).dc(2901L).tM("同步获取-> Server无包"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aqN() {
        super.aqN();
        if (DEBUG) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.i.qr("startup").f(new UbcFlowEvent("aps_end_download")).p("type", "0");
        com.baidu.swan.apps.inlinewidget.f.b.b.oz("0");
        this.cWk.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.al.a aqV = aqV();
        this.cWk.add(new UbcFlowEvent("na_end_update_db"));
        if (aqV == null) {
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.u.c.b aqY = aqY();
            if (this.cWh != null && this.cWh.category == 0) {
                aqY.b(com.baidu.swan.apps.swancore.b.jE(0));
                aqY.hT(1);
            }
            if (this.cWh != null && this.cWh.category == 1) {
                aqY.b(com.baidu.swan.apps.swancore.b.jE(1));
                aqY.hT(1);
            }
            if (this.cWi != null && this.cWi.category == 0) {
                aqY.c(com.baidu.swan.apps.extcore.b.hl(0));
                aqY.hT(2);
            }
            if (this.cWi != null && this.cWi.category == 1) {
                aqY.c(com.baidu.swan.apps.extcore.b.hl(1));
                aqY.hT(2);
            }
            if (this.cWm != null) {
                aqY.fW(this.cWm.evI);
                aqY.pj(this.cWm.pkgName);
            }
            d(this.cWj);
            bw("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(aqV, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void l(Throwable th) {
        com.baidu.swan.apps.al.a tM;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            tM = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "未知错误");
            }
            tM = new com.baidu.swan.apps.al.a().db(10L).dc(2900L).tM("包下载过程未知错误");
        }
        a(tM, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aqO() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int anM() {
        return 200;
    }

    public com.baidu.swan.apps.u.c.b aqY() {
        return this.cWI.aIR();
    }

    private void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.al.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.jv(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.azd();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.s("status", "1");
            if (aVar != null) {
                fVar.s("errcode", String.valueOf(aVar.aNi()));
                fVar.s("msg", aVar.aNh().toString());
            }
            fVar.ta(bVar.azj().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
            HybridUbcFlow qt = com.baidu.swan.apps.performance.i.qt("startup");
            if (qt != null) {
                qt.p("value", "na_success");
            }
        }
    }
}
