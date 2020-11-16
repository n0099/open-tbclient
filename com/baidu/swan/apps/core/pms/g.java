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
/* loaded from: classes7.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.e cLR;
    private Timer mTimer;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.cLR = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int apD() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void amK() {
        if (this.cLR.aeW() != 1) {
            synchronized (g.class) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.pms.g.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.bo("pms_getPkg", "PMS获取包接口返回超过3秒");
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
            }
        }
        com.baidu.swan.apps.performance.i.qD("startup").f(new UbcFlowEvent("aps_start_req"));
        super.amK();
    }

    @Override // com.baidu.swan.pms.a.g
    public void P(String str, int i) {
        super.P(str, i);
        com.baidu.swan.pms.c.c ym = com.baidu.swan.pms.c.c.ym(str);
        if (ym != null) {
            boolean cZ = com.baidu.swan.pms.utils.e.cZ(ym.getData());
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "resetCore: " + cZ);
            if (cZ) {
                com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(129).gj(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void apE() {
        super.apE();
        com.baidu.swan.apps.performance.i.qD("startup").f(new UbcFlowEvent("aps_end_req"));
        if (this.cLR.aeW() != 1) {
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
        com.baidu.swan.apps.performance.i.qD("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void bq(String str, String str2) {
        super.bq(str, str2);
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
                    com.baidu.swan.apps.performance.i.qD("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.cLt != null) {
                        this.cLt.add(new UbcFlowEvent(str2));
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
            com.baidu.swan.apps.performance.i.qD("startup").f(new UbcFlowEvent("pms_network_start").bY(optLong5)).f(new UbcFlowEvent("pms_network_conn").bY(optLong4)).f(new UbcFlowEvent("pms_dns_start").bY(optLong3)).f(new UbcFlowEvent("pms_dns_end").bY(optLong2)).f(new UbcFlowEvent("pms_network_response").bY(jSONObject.optLong("responseTime", optLong))).f(new UbcFlowEvent("pms_send_header").bY(jSONObject.optLong("sendHeaderTime", optLong))).f(new UbcFlowEvent("pms_receive_header").bY(jSONObject.optLong("receiveHeaderTime", optLong)));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
            com.baidu.swan.apps.console.c.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a2 = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a2.putString("launch_id", this.cLR.aGQ().ayo());
        }
        return a2;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.am.a tU = new com.baidu.swan.apps.am.a().cv(10L).cw(aVar.errorNo).tT(aVar.errorMsg).tU(aVar.ega);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.t.a.awA().a(com.baidu.swan.apps.t.a.avS(), this.mAppId, tU)) {
            a(tU, false);
            a(this.cLR.aGQ(), tU);
        } else if (aVar.errorNo == 1020) {
            a(tU, false);
            a(this.cLR.aGQ(), tU);
        } else {
            a(tU, true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void amI() {
        super.amI();
        if (this.cLs != null) {
            apQ();
        }
        a(new com.baidu.swan.apps.am.a().cv(10L).cw(2901L).tT("同步获取-> Server无包"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void apH() {
        super.apH();
        if (DEBUG) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.i.qD("startup").f(new UbcFlowEvent("aps_end_download")).r("type", "0");
        com.baidu.swan.apps.inlinewidget.f.b.b.oL("0");
        this.cLt.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a apP = apP();
        this.cLt.add(new UbcFlowEvent("na_end_update_db"));
        if (apP == null) {
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.u.c.b apS = apS();
            if (this.cLq != null && this.cLq.category == 0) {
                apS.b(com.baidu.swan.apps.swancore.b.kD(0));
                apS.jc(1);
            }
            if (this.cLq != null && this.cLq.category == 1) {
                apS.b(com.baidu.swan.apps.swancore.b.kD(1));
                apS.jc(1);
            }
            if (this.cLr != null && this.cLr.category == 0) {
                apS.c(com.baidu.swan.apps.extcore.b.iu(0));
                apS.jc(2);
            }
            if (this.cLr != null && this.cLr.category == 1) {
                apS.c(com.baidu.swan.apps.extcore.b.iu(1));
                apS.jc(2);
            }
            if (this.cLv != null) {
                apS.fA(this.cLv.egd);
                apS.pv(this.cLv.pkgName);
            }
            d(this.cLs);
            bx("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(apP, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        com.baidu.swan.apps.am.a tT;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            tT = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "未知错误");
            }
            tT = new com.baidu.swan.apps.am.a().cv(10L).cw(2900L).tT("包下载过程未知错误");
        }
        a(tT, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType apI() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int amL() {
        return 200;
    }

    public com.baidu.swan.apps.u.c.b apS() {
        return this.cLR.aGQ();
    }

    private void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.am.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.ku(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.axV();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.u("status", "1");
            if (aVar != null) {
                fVar.u("errcode", String.valueOf(aVar.aLh()));
                fVar.u("msg", aVar.aLg().toString());
            }
            fVar.th(bVar.ayb().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
            HybridUbcFlow qF = com.baidu.swan.apps.performance.i.qF("startup");
            if (qF != null) {
                qF.r("value", "na_success");
            }
        }
    }
}
