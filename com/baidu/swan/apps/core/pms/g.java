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
/* loaded from: classes9.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.e blt;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.blt = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void Ko() {
        com.baidu.swan.apps.performance.f.jx("startup").f(new UbcFlowEvent("aps_start_req"));
        super.Ko();
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void MA() {
        super.MA();
        com.baidu.swan.apps.performance.f.jx("startup").f(new UbcFlowEvent("aps_end_req"));
        if (DEBUG) {
            Log.d("SwanAppPkgSyncDownloadCallback", "PMS CS协议信息获取成功");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        com.baidu.swan.apps.performance.f.jx("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(eVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void al(String str, String str2) {
        super.al(str, str2);
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
                    com.baidu.swan.apps.performance.f.jx("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.bld != null) {
                        this.bld.add(new UbcFlowEvent(str2));
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
            com.baidu.swan.apps.performance.f.jx("startup").f(new UbcFlowEvent("pms_network_start").an(networkStatRecord.startTs)).f(new UbcFlowEvent("pms_network_conn").an(networkStatRecord.connTs)).f(new UbcFlowEvent("pms_dns_start").an(networkStatRecord.dnsStartTs)).f(new UbcFlowEvent("pms_dns_end").an(networkStatRecord.dnsEndTs)).f(new UbcFlowEvent("pms_network_response").an(networkStatRecord.responseTs)).f(new UbcFlowEvent("pms_send_header").an(networkStatRecord.sendHeaderTs)).f(new UbcFlowEvent("pms_receive_header").an(networkStatRecord.receiveHeaderTs));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.blt.ZV().Tp());
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.ap.a mg = new com.baidu.swan.apps.ap.a().aB(10L).aC(aVar.errorNo).mg(aVar.errorMsg);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.w.a.RR().a(this.mAppId, mg)) {
            a(mg, false);
            a(this.blt.ZV(), mg);
            return;
        }
        a(mg, true);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Mw() {
        super.Mw();
        if (this.blc != null) {
            MM();
        }
        a(new com.baidu.swan.apps.ap.a().aB(10L).aC(2901L).mg("同步获取-> Server无包"), true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void MC() {
        if (DEBUG) {
            Log.i("SwanAppPkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.f.jx("startup").f(new UbcFlowEvent("aps_end_download")).k("type", "0");
        this.bld.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ap.a ML = ML();
        this.bld.add(new UbcFlowEvent("na_end_update_db"));
        if (ML == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.x.b.b MO = MO();
            if (this.bla != null && this.bla.category == 0) {
                MO.b(com.baidu.swan.apps.swancore.b.gi(0));
                MO.eU(1);
            }
            if (this.bla != null && this.bla.category == 1) {
                MO.b(com.baidu.swan.apps.swancore.b.gi(1));
                MO.eU(1);
            }
            if (this.blb != null && this.blb.category == 0) {
                MO.c(com.baidu.swan.apps.extcore.b.ex(0));
                MO.eU(2);
            }
            if (this.blb != null && this.blb.category == 1) {
                MO.c(com.baidu.swan.apps.extcore.b.ex(1));
                MO.eU(2);
            }
            if (this.blf != null) {
                MO.cC(this.blf.independent);
                MO.iq(this.blf.pkgName);
            }
            c(this.blc);
            aq("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(ML, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void n(Throwable th) {
        com.baidu.swan.apps.ap.a mg;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            mg = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "未知错误");
            }
            mg = new com.baidu.swan.apps.ap.a().aB(10L).aC(2900L).mg("包下载过程未知错误");
        }
        a(mg, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType MD() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int Kp() {
        return 200;
    }

    public com.baidu.swan.apps.x.b.b MO() {
        return this.blt.ZV();
    }

    private void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.ap.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.ga(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.SW();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.n("status", "1");
            if (aVar != null) {
                fVar.n("errcode", String.valueOf(aVar.adB()));
                fVar.n("msg", aVar.adA().toString());
            }
            fVar.lz(bVar.Tc().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
    }

    protected void a(com.baidu.swan.apps.ap.a aVar, boolean z) {
    }

    protected void c(PMSAppInfo pMSAppInfo) {
    }
}
