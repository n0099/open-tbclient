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
    private com.baidu.swan.apps.v.b.c aDU;
    private String aIZ;
    private Context mContext;

    public e(Context context, com.baidu.swan.apps.v.b.c cVar, String str) {
        super(cVar.mAppId);
        this.mContext = context;
        this.aDU = cVar;
        this.aIZ = str;
        com.baidu.swan.apps.v.c.a.fF(str).KX().Lf();
    }

    @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.d
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.aDU.aIZ);
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
    public void Gn() {
        com.baidu.swan.apps.v.c.a.fF(this.aIZ).KX().dD(1);
        super.Gn();
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
        com.baidu.swan.apps.ak.a iK = new com.baidu.swan.apps.ak.a().ar(10L).as(aVar.errorNo).iK(aVar.errorMsg);
        if (aVar.errorNo == 1013 && com.baidu.swan.pms.e.aaQ().A(this.mAppId, aVar.errorNo)) {
            com.baidu.swan.apps.v.b.Km().Ko();
            a(this.aDU, iK);
            return;
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.aDU, iK, this.aIZ);
    }

    @Override // com.baidu.swan.pms.a.f
    public void Gj() {
        super.Gj();
        if (this.aMu != null) {
            Gv();
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.aDU, new com.baidu.swan.apps.ak.a().ar(10L).as(2901L).iK("同步获取-> Server无包"), this.aIZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.d
    public void Gk() {
        com.baidu.swan.apps.v.c.a.fF(this.aIZ).KX().dD(1);
        this.aJg.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a Gu = Gu();
        this.aJg.add(new UbcFlowEvent("na_end_update_db"));
        if (Gu == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            if (this.aMs != null && this.aMs.category == 0) {
                this.aDU.aNK = com.baidu.swan.apps.swancore.b.eT(0);
                this.aDU.dC(1);
            }
            if (this.aMt != null && this.aMt.category == 0) {
                this.aDU.aNL = com.baidu.swan.apps.extcore.a.HS().Hi();
                this.aDU.dC(2);
            }
            if (this.aMu != null && !TextUtils.isEmpty(this.aMu.appId) && !TextUtils.isEmpty(this.aMu.iconUrl)) {
                com.baidu.swan.apps.core.a.c.c(this.aMu.appId, this.aMu.iconUrl, String.valueOf(this.aMu.versionCode), this.aMu.bLd);
            }
            com.baidu.swan.apps.v.d.a(this.mContext, this.aDU, this.aMu, this.aIZ);
            ai("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.aDU, Gu, this.aIZ);
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
            iK = new com.baidu.swan.apps.ak.a().ar(10L).as(2900L).iK("包下载过程未知错误");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.aDU, iK, this.aIZ);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType Gl() {
        return PMSDownloadType.SYNC;
    }

    public com.baidu.swan.apps.v.b.c Gm() {
        return this.aDU;
    }

    private void a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar) {
        if (cVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.eL(cVar.aST);
            fVar.mAppId = cVar.mAppId;
            fVar.mSource = cVar.mFrom;
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.h("status", "1");
            if (aVar != null) {
                fVar.h("errcode", String.valueOf(aVar.TN()));
                fVar.h("msg", aVar.TM().toString());
            }
            fVar.d(cVar);
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
        }
    }
}
