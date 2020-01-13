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
/* loaded from: classes10.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.e bmi;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.bmi = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void KK() {
        com.baidu.swan.apps.performance.f.jA("startup").f(new UbcFlowEvent("aps_start_req"));
        super.KK();
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void MW() {
        super.MW();
        com.baidu.swan.apps.performance.f.jA("startup").f(new UbcFlowEvent("aps_end_req"));
        if (DEBUG) {
            Log.d("SwanAppPkgSyncDownloadCallback", "PMS CS协议信息获取成功");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        com.baidu.swan.apps.performance.f.jA("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(eVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void am(String str, String str2) {
        super.am(str, str2);
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
                    com.baidu.swan.apps.performance.f.jA("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.blS != null) {
                        this.blS.add(new UbcFlowEvent(str2));
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
            com.baidu.swan.apps.performance.f.jA("startup").f(new UbcFlowEvent("pms_network_start").aq(networkStatRecord.startTs)).f(new UbcFlowEvent("pms_network_conn").aq(networkStatRecord.connTs)).f(new UbcFlowEvent("pms_dns_start").aq(networkStatRecord.dnsStartTs)).f(new UbcFlowEvent("pms_dns_end").aq(networkStatRecord.dnsEndTs)).f(new UbcFlowEvent("pms_network_response").aq(networkStatRecord.responseTs)).f(new UbcFlowEvent("pms_send_header").aq(networkStatRecord.sendHeaderTs)).f(new UbcFlowEvent("pms_receive_header").aq(networkStatRecord.receiveHeaderTs));
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.bmi.aas().TM());
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.ap.a mj = new com.baidu.swan.apps.ap.a().aE(10L).aF(aVar.errorNo).mj(aVar.errorMsg);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.w.a.Sn().a(this.mAppId, mj)) {
            a(mj, false);
            a(this.bmi.aas(), mj);
            return;
        }
        a(mj, true);
    }

    @Override // com.baidu.swan.pms.a.g
    public void MS() {
        super.MS();
        if (this.blR != null) {
            Ni();
        }
        a(new com.baidu.swan.apps.ap.a().aE(10L).aF(2901L).mj("同步获取-> Server无包"), true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void MY() {
        if (DEBUG) {
            Log.i("SwanAppPkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.f.jA("startup").f(new UbcFlowEvent("aps_end_download")).k("type", "0");
        this.blS.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ap.a Nh = Nh();
        this.blS.add(new UbcFlowEvent("na_end_update_db"));
        if (Nh == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.x.b.b Nk = Nk();
            if (this.blP != null && this.blP.category == 0) {
                Nk.b(com.baidu.swan.apps.swancore.b.gj(0));
                Nk.eV(1);
            }
            if (this.blP != null && this.blP.category == 1) {
                Nk.b(com.baidu.swan.apps.swancore.b.gj(1));
                Nk.eV(1);
            }
            if (this.blQ != null && this.blQ.category == 0) {
                Nk.c(com.baidu.swan.apps.extcore.b.ey(0));
                Nk.eV(2);
            }
            if (this.blQ != null && this.blQ.category == 1) {
                Nk.c(com.baidu.swan.apps.extcore.b.ey(1));
                Nk.eV(2);
            }
            if (this.blU != null) {
                Nk.cH(this.blU.independent);
                Nk.it(this.blU.pkgName);
            }
            c(this.blR);
            ar("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(Nh, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void n(Throwable th) {
        com.baidu.swan.apps.ap.a mj;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            mj = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "未知错误");
            }
            mj = new com.baidu.swan.apps.ap.a().aE(10L).aF(2900L).mj("包下载过程未知错误");
        }
        a(mj, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType MZ() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int KL() {
        return 200;
    }

    public com.baidu.swan.apps.x.b.b Nk() {
        return this.bmi.aas();
    }

    private void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.ap.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.Tt();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.n("status", "1");
            if (aVar != null) {
                fVar.n("errcode", String.valueOf(aVar.adU()));
                fVar.n("msg", aVar.adT().toString());
            }
            fVar.lC(bVar.Tz().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
    }

    protected void a(com.baidu.swan.apps.ap.a aVar, boolean z) {
    }

    protected void c(PMSAppInfo pMSAppInfo) {
    }
}
