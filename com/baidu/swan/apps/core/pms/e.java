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
    private com.baidu.swan.apps.v.b.c aks;
    private String apD;
    private Context mContext;

    public e(Context context, com.baidu.swan.apps.v.b.c cVar, String str) {
        super(cVar.mAppId);
        this.mContext = context;
        this.aks = cVar;
        this.apD = str;
        com.baidu.swan.apps.v.c.a.eW(str).FY().Gg();
    }

    @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.d
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.aks.apD);
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
    public void Bn() {
        com.baidu.swan.apps.v.c.a.eW(this.apD).FY().cH(1);
        super.Bn();
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
        com.baidu.swan.apps.ak.a m14if = new com.baidu.swan.apps.ak.a().Z(10L).aa(aVar.errorNo).m14if(aVar.errorMsg);
        if (aVar.errorNo == 1013 && com.baidu.swan.pms.e.VZ().A(this.mAppId, aVar.errorNo)) {
            com.baidu.swan.apps.v.b.Fn().Fp();
            a(this.aks, m14if);
            return;
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.aks, m14if, this.apD);
    }

    @Override // com.baidu.swan.pms.a.f
    public void Bj() {
        super.Bj();
        if (this.asX != null) {
            Bv();
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.aks, new com.baidu.swan.apps.ak.a().Z(10L).aa(2901L).m14if("同步获取-> Server无包"), this.apD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.d
    public void Bk() {
        com.baidu.swan.apps.v.c.a.eW(this.apD).FY().cH(1);
        this.apK.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a Bu = Bu();
        this.apK.add(new UbcFlowEvent("na_end_update_db"));
        if (Bu == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            if (this.asV != null && this.asV.ave == 0) {
                this.aks.aun = com.baidu.swan.apps.swancore.b.dX(0);
                this.aks.cG(1);
            }
            if (this.asW != null && this.asW.ave == 0) {
                this.aks.auo = com.baidu.swan.apps.extcore.a.CT().Cj();
                this.aks.cG(2);
            }
            if (this.asX != null && !TextUtils.isEmpty(this.asX.appId) && !TextUtils.isEmpty(this.asX.iconUrl)) {
                com.baidu.swan.apps.core.a.c.b(this.asX.appId, this.asX.iconUrl, String.valueOf(this.asX.versionCode), this.asX.bsL);
            }
            com.baidu.swan.apps.v.d.a(this.mContext, this.aks, this.asX, this.apD);
            aa("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.aks, Bu, this.apD);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        com.baidu.swan.apps.ak.a m14if;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            m14if = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "未知错误");
            }
            m14if = new com.baidu.swan.apps.ak.a().Z(10L).aa(2900L).m14if("包下载过程未知错误");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.aks, m14if, this.apD);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType Bl() {
        return PMSDownloadType.SYNC;
    }

    public com.baidu.swan.apps.v.b.c Bm() {
        return this.aks;
    }

    private void a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar) {
        if (cVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dP(cVar.azz);
            fVar.mAppId = cVar.mAppId;
            fVar.mSource = cVar.mFrom;
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.k("status", "1");
            if (aVar != null) {
                fVar.k("errcode", String.valueOf(aVar.OV()));
                fVar.k("msg", aVar.OU().toString());
            }
            fVar.d(cVar);
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
        }
    }
}
