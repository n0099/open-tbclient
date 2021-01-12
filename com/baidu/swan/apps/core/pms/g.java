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
    private final com.baidu.swan.apps.runtime.e cSV;
    private Timer mTimer;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.cSV = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aqi() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void ank() {
        if (this.cSV.afr() != 1) {
            synchronized (g.class) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.pms.g.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.bt("pms_getPkg", "PMS获取包接口返回超过3秒");
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
            }
        }
        com.baidu.swan.apps.performance.i.pS("startup").f(new UbcFlowEvent("aps_start_req"));
        super.ank();
    }

    @Override // com.baidu.swan.pms.a.g
    public void R(String str, int i) {
        super.R(str, i);
        com.baidu.swan.pms.c.c xH = com.baidu.swan.pms.c.c.xH(str);
        if (xH != null) {
            boolean dj = com.baidu.swan.pms.utils.e.dj(xH.getData());
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "resetCore: " + dj);
            if (dj) {
                com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(129).gD(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void aqj() {
        super.aqj();
        com.baidu.swan.apps.performance.i.pS("startup").f(new UbcFlowEvent("aps_end_req"));
        if (this.cSV.afr() != 1) {
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
        com.baidu.swan.apps.performance.i.pS("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void bv(String str, String str2) {
        super.bv(str, str2);
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
                    com.baidu.swan.apps.performance.i.pS("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.cSx != null) {
                        this.cSx.add(new UbcFlowEvent(str2));
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
            com.baidu.swan.apps.performance.i.pS("startup").f(new UbcFlowEvent("pms_network_start").cy(optLong5)).f(new UbcFlowEvent("pms_network_conn").cy(optLong4)).f(new UbcFlowEvent("pms_dns_start").cy(optLong3)).f(new UbcFlowEvent("pms_dns_end").cy(optLong2)).f(new UbcFlowEvent("pms_network_response").cy(jSONObject.optLong("responseTime", optLong))).f(new UbcFlowEvent("pms_send_header").cy(jSONObject.optLong("sendHeaderTime", optLong))).f(new UbcFlowEvent("pms_receive_header").cy(jSONObject.optLong("receiveHeaderTime", optLong)));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a2 = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a2.putString("launch_id", this.cSV.aIv().ayV());
        }
        return a2;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.al.a tn = new com.baidu.swan.apps.al.a().cV(10L).cW(aVar.errorNo).tm(aVar.errorMsg).tn(aVar.erX);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.t.a.axg().a(com.baidu.swan.apps.t.a.awy(), this.mAppId, tn)) {
            a(tn, false);
            a(this.cSV.aIv(), tn);
        } else if (aVar.errorNo == 1020) {
            a(tn, false);
            a(this.cSV.aIv(), tn);
        } else {
            a(tn, true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void ani() {
        super.ani();
        if (this.cSw != null) {
            aqv();
        }
        a(new com.baidu.swan.apps.al.a().cV(10L).cW(2901L).tm("同步获取-> Server无包"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aqm() {
        super.aqm();
        if (DEBUG) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.i.pS("startup").f(new UbcFlowEvent("aps_end_download")).q("type", "0");
        com.baidu.swan.apps.inlinewidget.f.b.b.nY("0");
        this.cSx.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.al.a aqu = aqu();
        this.cSx.add(new UbcFlowEvent("na_end_update_db"));
        if (aqu == null) {
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.u.c.b aqx = aqx();
            if (this.cSu != null && this.cSu.category == 0) {
                aqx.b(com.baidu.swan.apps.swancore.b.jA(0));
                aqx.hP(1);
            }
            if (this.cSu != null && this.cSu.category == 1) {
                aqx.b(com.baidu.swan.apps.swancore.b.jA(1));
                aqx.hP(1);
            }
            if (this.cSv != null && this.cSv.category == 0) {
                aqx.c(com.baidu.swan.apps.extcore.b.hh(0));
                aqx.hP(2);
            }
            if (this.cSv != null && this.cSv.category == 1) {
                aqx.c(com.baidu.swan.apps.extcore.b.hh(1));
                aqx.hP(2);
            }
            if (this.cSz != null) {
                aqx.fU(this.cSz.esa);
                aqx.oK(this.cSz.pkgName);
            }
            d(this.cSw);
            bC("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(aqu, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void m(Throwable th) {
        com.baidu.swan.apps.al.a tm;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            tm = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "未知错误");
            }
            tm = new com.baidu.swan.apps.al.a().cV(10L).cW(2900L).tm("包下载过程未知错误");
        }
        a(tm, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aqn() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int anl() {
        return 200;
    }

    public com.baidu.swan.apps.u.c.b aqx() {
        return this.cSV.aIv();
    }

    private void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.al.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.jr(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.ayC();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.t("status", "1");
            if (aVar != null) {
                fVar.t("errcode", String.valueOf(aVar.aMM()));
                fVar.t("msg", aVar.aML().toString());
            }
            fVar.sA(bVar.ayI().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
            HybridUbcFlow pU = com.baidu.swan.apps.performance.i.pU("startup");
            if (pU != null) {
                pU.q("value", "na_success");
            }
        }
    }
}
