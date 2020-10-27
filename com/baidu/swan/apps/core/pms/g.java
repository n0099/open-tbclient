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
    private final com.baidu.swan.apps.runtime.e cHI;
    private Timer mTimer;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.cHI = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int anK() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void akS() {
        if (this.cHI.ade() != 1) {
            synchronized (g.class) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.pms.g.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.bp("pms_getPkg", "PMS获取包接口返回超过3秒");
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
            }
        }
        com.baidu.swan.apps.performance.i.qv("startup").f(new UbcFlowEvent("aps_start_req"));
        super.akS();
    }

    @Override // com.baidu.swan.pms.a.g
    public void N(String str, int i) {
        super.N(str, i);
        com.baidu.swan.pms.c.c yd = com.baidu.swan.pms.c.c.yd(str);
        if (yd != null) {
            boolean cZ = com.baidu.swan.pms.utils.e.cZ(yd.getData());
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "resetCore: " + cZ);
            if (cZ) {
                com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(129).fX(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void anL() {
        super.anL();
        com.baidu.swan.apps.performance.i.qv("startup").f(new UbcFlowEvent("aps_end_req"));
        if (this.cHI.ade() != 1) {
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
        com.baidu.swan.apps.performance.i.qv("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void br(String str, String str2) {
        super.br(str, str2);
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
                    com.baidu.swan.apps.performance.i.qv("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.cHk != null) {
                        this.cHk.add(new UbcFlowEvent(str2));
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
            com.baidu.swan.apps.performance.i.qv("startup").f(new UbcFlowEvent("pms_network_start").bC(optLong5)).f(new UbcFlowEvent("pms_network_conn").bC(optLong4)).f(new UbcFlowEvent("pms_dns_start").bC(optLong3)).f(new UbcFlowEvent("pms_dns_end").bC(optLong2)).f(new UbcFlowEvent("pms_network_response").bC(jSONObject.optLong("responseTime", optLong))).f(new UbcFlowEvent("pms_send_header").bC(jSONObject.optLong("sendHeaderTime", optLong))).f(new UbcFlowEvent("pms_receive_header").bC(jSONObject.optLong("receiveHeaderTime", optLong)));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a2 = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a2.putString("launch_id", this.cHI.aEY().aww());
        }
        return a2;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.am.a tL = new com.baidu.swan.apps.am.a().bZ(10L).ca(aVar.errorNo).tK(aVar.errorMsg).tL(aVar.ebQ);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.t.a.auI().a(com.baidu.swan.apps.t.a.aua(), this.mAppId, tL)) {
            a(tL, false);
            a(this.cHI.aEY(), tL);
        } else if (aVar.errorNo == 1020) {
            a(tL, false);
            a(this.cHI.aEY(), tL);
        } else {
            a(tL, true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void akQ() {
        super.akQ();
        if (this.cHj != null) {
            anX();
        }
        a(new com.baidu.swan.apps.am.a().bZ(10L).ca(2901L).tK("同步获取-> Server无包"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void anO() {
        super.anO();
        if (DEBUG) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.i.qv("startup").f(new UbcFlowEvent("aps_end_download")).r("type", "0");
        com.baidu.swan.apps.inlinewidget.f.b.b.oD("0");
        this.cHk.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a anW = anW();
        this.cHk.add(new UbcFlowEvent("na_end_update_db"));
        if (anW == null) {
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.u.c.b anZ = anZ();
            if (this.cHh != null && this.cHh.category == 0) {
                anZ.b(com.baidu.swan.apps.swancore.b.kx(0));
                anZ.iW(1);
            }
            if (this.cHh != null && this.cHh.category == 1) {
                anZ.b(com.baidu.swan.apps.swancore.b.kx(1));
                anZ.iW(1);
            }
            if (this.cHi != null && this.cHi.category == 0) {
                anZ.c(com.baidu.swan.apps.extcore.b.io(0));
                anZ.iW(2);
            }
            if (this.cHi != null && this.cHi.category == 1) {
                anZ.c(com.baidu.swan.apps.extcore.b.io(1));
                anZ.iW(2);
            }
            if (this.cHm != null) {
                anZ.fo(this.cHm.ebT);
                anZ.pn(this.cHm.pkgName);
            }
            d(this.cHj);
            by("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(anW, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        com.baidu.swan.apps.am.a tK;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            tK = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "未知错误");
            }
            tK = new com.baidu.swan.apps.am.a().bZ(10L).ca(2900L).tK("包下载过程未知错误");
        }
        a(tK, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType anP() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int akT() {
        return 200;
    }

    public com.baidu.swan.apps.u.c.b anZ() {
        return this.cHI.aEY();
    }

    private void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.am.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.ko(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.awd();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.u("status", "1");
            if (aVar != null) {
                fVar.u("errcode", String.valueOf(aVar.aJp()));
                fVar.u("msg", aVar.aJo().toString());
            }
            fVar.sY(bVar.awj().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
            HybridUbcFlow qx = com.baidu.swan.apps.performance.i.qx("startup");
            if (qx != null) {
                qx.r("value", "na_success");
            }
        }
    }
}
