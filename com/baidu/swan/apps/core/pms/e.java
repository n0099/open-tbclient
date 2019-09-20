package com.baidu.swan.apps.core.pms;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.Set;
/* loaded from: classes2.dex */
public class e extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.v.b.c akQ;
    private String aqb;
    private Context mContext;

    public e(Context context, com.baidu.swan.apps.v.b.c cVar, String str) {
        super(cVar.mAppId);
        this.mContext = context;
        this.akQ = cVar;
        this.aqb = str;
        com.baidu.swan.apps.v.c.a.eY(str).Gc().Gk();
    }

    @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.d
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.akQ.aqb);
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
    public void Br() {
        com.baidu.swan.apps.v.c.a.eY(this.aqb).Gc().cI(1);
        super.Br();
        if (DEBUG) {
            Log.d("SwanAppPkgSyncDownloadCallback", "PMS CS协议信息获取成功");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.ak.a ih = new com.baidu.swan.apps.ak.a().Z(10L).aa(aVar.errorNo).ih(aVar.errorMsg);
        if (aVar.errorNo == 1013 && com.baidu.swan.pms.e.Wd().A(this.mAppId, aVar.errorNo)) {
            com.baidu.swan.apps.v.b.Fr().Ft();
            a(this.akQ, ih);
            return;
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.akQ, ih, this.aqb);
    }

    @Override // com.baidu.swan.pms.a.f
    public void Bn() {
        super.Bn();
        if (this.atv != null) {
            Bz();
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.akQ, new com.baidu.swan.apps.ak.a().Z(10L).aa(2901L).ih("同步获取-> Server无包"), this.aqb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.d
    public void Bo() {
        com.baidu.swan.apps.v.c.a.eY(this.aqb).Gc().cI(1);
        this.aqi.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a By = By();
        this.aqi.add(new UbcFlowEvent("na_end_update_db"));
        if (By == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            if (this.att != null && this.att.avC == 0) {
                this.akQ.auL = com.baidu.swan.apps.swancore.b.dY(0);
                this.akQ.cH(1);
            }
            if (this.atu != null && this.atu.avC == 0) {
                this.akQ.auM = com.baidu.swan.apps.extcore.a.CX().Cn();
                this.akQ.cH(2);
            }
            if (this.atv != null && !TextUtils.isEmpty(this.atv.appId) && !TextUtils.isEmpty(this.atv.iconUrl)) {
                com.baidu.swan.apps.core.a.c.b(this.atv.appId, this.atv.iconUrl, String.valueOf(this.atv.versionCode), this.atv.btj);
            }
            com.baidu.swan.apps.v.d.a(this.mContext, this.akQ, this.atv, this.aqb);
            aa("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.akQ, By, this.aqb);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        com.baidu.swan.apps.ak.a ih;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            ih = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "未知错误");
            }
            ih = new com.baidu.swan.apps.ak.a().Z(10L).aa(2900L).ih("包下载过程未知错误");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.akQ, ih, this.aqb);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType Bp() {
        return PMSDownloadType.SYNC;
    }

    public com.baidu.swan.apps.v.b.c Bq() {
        return this.akQ;
    }

    private void a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar) {
        if (cVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dQ(cVar.azX);
            fVar.mAppId = cVar.mAppId;
            fVar.mSource = cVar.mFrom;
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.k("status", "1");
            if (aVar != null) {
                fVar.k("errcode", String.valueOf(aVar.OZ()));
                fVar.k("msg", aVar.OY().toString());
            }
            fVar.d(cVar);
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
        }
    }
}
