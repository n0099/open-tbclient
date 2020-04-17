package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.Set;
import okhttp3.Response;
/* loaded from: classes11.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.e bON;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.bON = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void UR() {
        com.baidu.swan.apps.performance.f.lb("startup").f(new UbcFlowEvent("aps_start_req"));
        super.UR();
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void Xe() {
        super.Xe();
        com.baidu.swan.apps.performance.f.lb("startup").f(new UbcFlowEvent("aps_end_req"));
        if (DEBUG) {
            Log.d("SwanAppPkgSyncDownloadCallback", "PMS CS协议信息获取成功");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        com.baidu.swan.apps.performance.f.lb("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(eVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void aE(String str, String str2) {
        super.aE(str, str2);
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
                    com.baidu.swan.apps.performance.f.lb("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.bOx != null) {
                        this.bOx.add(new UbcFlowEvent(str2));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(Response response, int i, NetworkStatRecord networkStatRecord) {
        if (networkStatRecord != null) {
            com.baidu.swan.apps.performance.f.lb("startup").f(new UbcFlowEvent("pms_network_start").aZ(networkStatRecord.startTs)).f(new UbcFlowEvent("pms_network_conn").aZ(networkStatRecord.connTs)).f(new UbcFlowEvent("pms_dns_start").aZ(networkStatRecord.dnsStartTs)).f(new UbcFlowEvent("pms_dns_end").aZ(networkStatRecord.dnsEndTs)).f(new UbcFlowEvent("pms_network_response").aZ(networkStatRecord.responseTs)).f(new UbcFlowEvent("pms_send_header").aZ(networkStatRecord.sendHeaderTs)).f(new UbcFlowEvent("pms_receive_header").aZ(networkStatRecord.receiveHeaderTs));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.bON.akQ().adU());
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.ap.a nK = new com.baidu.swan.apps.ap.a().bn(10L).bo(aVar.errorNo).nK(aVar.errorMsg);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.w.a.acv().a(this.mAppId, nK)) {
            a(nK, false);
            a(this.bON.akQ(), nK);
            return;
        }
        a(nK, true);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xa() {
        super.Xa();
        if (this.bOw != null) {
            Xq();
        }
        a(new com.baidu.swan.apps.ap.a().bn(10L).bo(2901L).nK("同步获取-> Server无包"), true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void Xg() {
        if (DEBUG) {
            Log.i("SwanAppPkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.f.lb("startup").f(new UbcFlowEvent("aps_end_download")).p("type", "0");
        this.bOx.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ap.a Xp = Xp();
        this.bOx.add(new UbcFlowEvent("na_end_update_db"));
        if (Xp == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.x.b.b Xs = Xs();
            if (this.bOu != null && this.bOu.category == 0) {
                Xs.b(com.baidu.swan.apps.swancore.b.gH(0));
                Xs.fq(1);
            }
            if (this.bOu != null && this.bOu.category == 1) {
                Xs.b(com.baidu.swan.apps.swancore.b.gH(1));
                Xs.fq(1);
            }
            if (this.bOv != null && this.bOv.category == 0) {
                Xs.c(com.baidu.swan.apps.extcore.b.eT(0));
                Xs.fq(2);
            }
            if (this.bOv != null && this.bOv.category == 1) {
                Xs.c(com.baidu.swan.apps.extcore.b.eT(1));
                Xs.fq(2);
            }
            if (this.bOz != null) {
                Xs.dL(this.bOz.independent);
                Xs.jU(this.bOz.pkgName);
            }
            c(this.bOw);
            aJ("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(Xp, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        com.baidu.swan.apps.ap.a nK;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            nK = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "未知错误");
            }
            nK = new com.baidu.swan.apps.ap.a().bn(10L).bo(2900L).nK("包下载过程未知错误");
        }
        a(nK, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType Xh() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int US() {
        return 200;
    }

    public com.baidu.swan.apps.x.b.b Xs() {
        return this.bON.akQ();
    }

    private void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.ap.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.adB();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.s("status", "1");
            if (aVar != null) {
                fVar.s("errcode", String.valueOf(aVar.aos()));
                fVar.s("msg", aVar.aor().toString());
            }
            fVar.nd(bVar.adH().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
    }

    protected void a(com.baidu.swan.apps.ap.a aVar, boolean z) {
    }

    protected void c(PMSAppInfo pMSAppInfo) {
    }
}
