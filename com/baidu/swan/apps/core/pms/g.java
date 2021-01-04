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
    private final com.baidu.swan.apps.runtime.e cXH;
    private Timer mTimer;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.cXH = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int auc() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void are() {
        if (this.cXH.ajk() != 1) {
            synchronized (g.class) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.pms.g.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.bu("pms_getPkg", "PMS获取包接口返回超过3秒");
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
            }
        }
        com.baidu.swan.apps.performance.i.rd("startup").f(new UbcFlowEvent("aps_start_req"));
        super.are();
    }

    @Override // com.baidu.swan.pms.a.g
    public void R(String str, int i) {
        super.R(str, i);
        com.baidu.swan.pms.c.c yS = com.baidu.swan.pms.c.c.yS(str);
        if (yS != null) {
            boolean dj = com.baidu.swan.pms.utils.e.dj(yS.getData());
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "resetCore: " + dj);
            if (dj) {
                com.baidu.swan.apps.process.messaging.a.aIX().a(new com.baidu.swan.apps.process.messaging.c(129).gH(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void aud() {
        super.aud();
        com.baidu.swan.apps.performance.i.rd("startup").f(new UbcFlowEvent("aps_end_req"));
        if (this.cXH.ajk() != 1) {
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
        com.baidu.swan.apps.performance.i.rd("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void bw(String str, String str2) {
        super.bw(str, str2);
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
                    com.baidu.swan.apps.performance.i.rd("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.cXj != null) {
                        this.cXj.add(new UbcFlowEvent(str2));
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
            com.baidu.swan.apps.performance.i.rd("startup").f(new UbcFlowEvent("pms_network_start").cy(optLong5)).f(new UbcFlowEvent("pms_network_conn").cy(optLong4)).f(new UbcFlowEvent("pms_dns_start").cy(optLong3)).f(new UbcFlowEvent("pms_dns_end").cy(optLong2)).f(new UbcFlowEvent("pms_network_response").cy(jSONObject.optLong("responseTime", optLong))).f(new UbcFlowEvent("pms_send_header").cy(jSONObject.optLong("sendHeaderTime", optLong))).f(new UbcFlowEvent("pms_receive_header").cy(jSONObject.optLong("receiveHeaderTime", optLong)));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a2 = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a2.putString("launch_id", this.cXH.aMo().aCO());
        }
        return a2;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.al.a uy = new com.baidu.swan.apps.al.a().cV(10L).cW(aVar.errorNo).ux(aVar.errorMsg).uy(aVar.ewK);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.t.a.aAZ().a(com.baidu.swan.apps.t.a.aAr(), this.mAppId, uy)) {
            a(uy, false);
            a(this.cXH.aMo(), uy);
        } else if (aVar.errorNo == 1020) {
            a(uy, false);
            a(this.cXH.aMo(), uy);
        } else {
            a(uy, true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void arc() {
        super.arc();
        if (this.cXi != null) {
            aup();
        }
        a(new com.baidu.swan.apps.al.a().cV(10L).cW(2901L).ux("同步获取-> Server无包"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aug() {
        super.aug();
        if (DEBUG) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.i.rd("startup").f(new UbcFlowEvent("aps_end_download")).q("type", "0");
        com.baidu.swan.apps.inlinewidget.f.b.b.pl("0");
        this.cXj.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.al.a auo = auo();
        this.cXj.add(new UbcFlowEvent("na_end_update_db"));
        if (auo == null) {
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.u.c.b aur = aur();
            if (this.cXg != null && this.cXg.category == 0) {
                aur.b(com.baidu.swan.apps.swancore.b.lg(0));
                aur.jv(1);
            }
            if (this.cXg != null && this.cXg.category == 1) {
                aur.b(com.baidu.swan.apps.swancore.b.lg(1));
                aur.jv(1);
            }
            if (this.cXh != null && this.cXh.category == 0) {
                aur.c(com.baidu.swan.apps.extcore.b.iN(0));
                aur.jv(2);
            }
            if (this.cXh != null && this.cXh.category == 1) {
                aur.c(com.baidu.swan.apps.extcore.b.iN(1));
                aur.jv(2);
            }
            if (this.cXl != null) {
                aur.fY(this.cXl.ewN);
                aur.pV(this.cXl.pkgName);
            }
            d(this.cXi);
            bD("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(auo, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void m(Throwable th) {
        com.baidu.swan.apps.al.a ux;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            ux = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "未知错误");
            }
            ux = new com.baidu.swan.apps.al.a().cV(10L).cW(2900L).ux("包下载过程未知错误");
        }
        a(ux, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType auh() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int arf() {
        return 200;
    }

    public com.baidu.swan.apps.u.c.b aur() {
        return this.cXH.aMo();
    }

    private void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.al.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.kX(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.aCv();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.t("status", "1");
            if (aVar != null) {
                fVar.t("errcode", String.valueOf(aVar.aQF()));
                fVar.t("msg", aVar.aQE().toString());
            }
            fVar.tL(bVar.aCB().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
            HybridUbcFlow rf = com.baidu.swan.apps.performance.i.rf("startup");
            if (rf != null) {
                rf.q("value", "na_success");
            }
        }
    }
}
