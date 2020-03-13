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
    private final com.baidu.swan.apps.runtime.e bqu;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.bqu = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void Nb() {
        com.baidu.swan.apps.performance.f.jP("startup").f(new UbcFlowEvent("aps_start_req"));
        super.Nb();
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void Pm() {
        super.Pm();
        com.baidu.swan.apps.performance.f.jP("startup").f(new UbcFlowEvent("aps_end_req"));
        if (DEBUG) {
            Log.d("SwanAppPkgSyncDownloadCallback", "PMS CS协议信息获取成功");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        com.baidu.swan.apps.performance.f.jP("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(eVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void aw(String str, String str2) {
        super.aw(str, str2);
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
                    com.baidu.swan.apps.performance.f.jP("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.bqe != null) {
                        this.bqe.add(new UbcFlowEvent(str2));
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
            com.baidu.swan.apps.performance.f.jP("startup").f(new UbcFlowEvent("pms_network_start").au(networkStatRecord.startTs)).f(new UbcFlowEvent("pms_network_conn").au(networkStatRecord.connTs)).f(new UbcFlowEvent("pms_dns_start").au(networkStatRecord.dnsStartTs)).f(new UbcFlowEvent("pms_dns_end").au(networkStatRecord.dnsEndTs)).f(new UbcFlowEvent("pms_network_response").au(networkStatRecord.responseTs)).f(new UbcFlowEvent("pms_send_header").au(networkStatRecord.sendHeaderTs)).f(new UbcFlowEvent("pms_receive_header").au(networkStatRecord.receiveHeaderTs));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.bqu.acI().Wc());
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(10L).aJ(aVar.errorNo).my(aVar.errorMsg);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.w.a.UD().a(this.mAppId, my)) {
            a(my, false);
            a(this.bqu.acI(), my);
            return;
        }
        a(my, true);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pi() {
        super.Pi();
        if (this.bqd != null) {
            Py();
        }
        a(new com.baidu.swan.apps.ap.a().aI(10L).aJ(2901L).my("同步获取-> Server无包"), true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void Po() {
        if (DEBUG) {
            Log.i("SwanAppPkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.f.jP("startup").f(new UbcFlowEvent("aps_end_download")).k("type", "0");
        this.bqe.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ap.a Px = Px();
        this.bqe.add(new UbcFlowEvent("na_end_update_db"));
        if (Px == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.x.b.b PA = PA();
            if (this.bqb != null && this.bqb.category == 0) {
                PA.b(com.baidu.swan.apps.swancore.b.gA(0));
                PA.fl(1);
            }
            if (this.bqb != null && this.bqb.category == 1) {
                PA.b(com.baidu.swan.apps.swancore.b.gA(1));
                PA.fl(1);
            }
            if (this.bqc != null && this.bqc.category == 0) {
                PA.c(com.baidu.swan.apps.extcore.b.eO(0));
                PA.fl(2);
            }
            if (this.bqc != null && this.bqc.category == 1) {
                PA.c(com.baidu.swan.apps.extcore.b.eO(1));
                PA.fl(2);
            }
            if (this.bqg != null) {
                PA.cO(this.bqg.independent);
                PA.iI(this.bqg.pkgName);
            }
            c(this.bqd);
            aB("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(Px, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void m(Throwable th) {
        com.baidu.swan.apps.ap.a my;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            my = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "未知错误");
            }
            my = new com.baidu.swan.apps.ap.a().aI(10L).aJ(2900L).my("包下载过程未知错误");
        }
        a(my, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType Pp() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int Nc() {
        return 200;
    }

    public com.baidu.swan.apps.x.b.b PA() {
        return this.bqu.acI();
    }

    private void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.ap.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.VJ();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.n("status", "1");
            if (aVar != null) {
                fVar.n("errcode", String.valueOf(aVar.agk()));
                fVar.n("msg", aVar.agj().toString());
            }
            fVar.lR(bVar.VP().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
    }

    protected void a(com.baidu.swan.apps.ap.a aVar, boolean z) {
    }

    protected void c(PMSAppInfo pMSAppInfo) {
    }
}
