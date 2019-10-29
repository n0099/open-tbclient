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
    private com.baidu.swan.apps.v.b.c aEm;
    private String aJr;
    private Context mContext;

    public e(Context context, com.baidu.swan.apps.v.b.c cVar, String str) {
        super(cVar.mAppId);
        this.mContext = context;
        this.aEm = cVar;
        this.aJr = str;
        com.baidu.swan.apps.v.c.a.fF(str).KW().Le();
    }

    @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.d
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.aEm.aJr);
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
    public void Gm() {
        com.baidu.swan.apps.v.c.a.fF(this.aJr).KW().dD(1);
        super.Gm();
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
        com.baidu.swan.apps.ak.a iK = new com.baidu.swan.apps.ak.a().as(10L).at(aVar.errorNo).iK(aVar.errorMsg);
        if (aVar.errorNo == 1013 && com.baidu.swan.pms.e.aaS().A(this.mAppId, aVar.errorNo)) {
            com.baidu.swan.apps.v.b.Kl().Kn();
            a(this.aEm, iK);
            return;
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.aEm, iK, this.aJr);
    }

    @Override // com.baidu.swan.pms.a.f
    public void Gi() {
        super.Gi();
        if (this.aMM != null) {
            Gu();
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.aEm, new com.baidu.swan.apps.ak.a().as(10L).at(2901L).iK("同步获取-> Server无包"), this.aJr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.d
    public void Gj() {
        com.baidu.swan.apps.v.c.a.fF(this.aJr).KW().dD(1);
        this.aJy.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a Gt = Gt();
        this.aJy.add(new UbcFlowEvent("na_end_update_db"));
        if (Gt == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            if (this.aMK != null && this.aMK.category == 0) {
                this.aEm.aOc = com.baidu.swan.apps.swancore.b.eT(0);
                this.aEm.dC(1);
            }
            if (this.aML != null && this.aML.category == 0) {
                this.aEm.aOd = com.baidu.swan.apps.extcore.a.HR().Hh();
                this.aEm.dC(2);
            }
            if (this.aMM != null && !TextUtils.isEmpty(this.aMM.appId) && !TextUtils.isEmpty(this.aMM.iconUrl)) {
                com.baidu.swan.apps.core.a.c.c(this.aMM.appId, this.aMM.iconUrl, String.valueOf(this.aMM.versionCode), this.aMM.bLU);
            }
            com.baidu.swan.apps.v.d.a(this.mContext, this.aEm, this.aMM, this.aJr);
            ai("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.aEm, Gt, this.aJr);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        com.baidu.swan.apps.ak.a iK;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            iK = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "未知错误");
            }
            iK = new com.baidu.swan.apps.ak.a().as(10L).at(2900L).iK("包下载过程未知错误");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.aEm, iK, this.aJr);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType Gk() {
        return PMSDownloadType.SYNC;
    }

    public com.baidu.swan.apps.v.b.c Gl() {
        return this.aEm;
    }

    private void a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar) {
        if (cVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.eL(cVar.aTl);
            fVar.mAppId = cVar.mAppId;
            fVar.mSource = cVar.mFrom;
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.h("status", "1");
            if (aVar != null) {
                fVar.h("errcode", String.valueOf(aVar.TP()));
                fVar.h("msg", aVar.TO().toString());
            }
            fVar.d(cVar);
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
        }
    }
}
