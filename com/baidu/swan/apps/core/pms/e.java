package com.baidu.swan.apps.core.pms;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.Set;
/* loaded from: classes2.dex */
public class e extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.v.b.c ajQ;
    private String aoZ;
    private Context mContext;

    public e(Context context, com.baidu.swan.apps.v.b.c cVar, String str) {
        super(cVar.mAppId);
        this.mContext = context;
        this.ajQ = cVar;
        this.aoZ = str;
        com.baidu.swan.apps.v.c.a.eR(str).Fo().Fw();
    }

    @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.d
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.ajQ.aoZ);
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
    public void AF() {
        com.baidu.swan.apps.v.c.a.eR(this.aoZ).Fo().cG(1);
        super.AF();
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
        com.baidu.swan.apps.ak.a hX = new com.baidu.swan.apps.ak.a().Y(10L).Z(aVar.errorNo).hX(aVar.errorMsg);
        if (aVar.errorNo == 1013 && com.baidu.swan.pms.e.Vg().A(this.mAppId, aVar.errorNo)) {
            com.baidu.swan.apps.v.b.ED().EF();
            a(this.ajQ, hX);
            return;
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.ajQ, hX, this.aoZ);
    }

    @Override // com.baidu.swan.pms.a.f
    public void AB() {
        super.AB();
        if (this.asu != null) {
            AN();
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.ajQ, new com.baidu.swan.apps.ak.a().Y(10L).Z(2901L).hX("同步获取-> Server无包"), this.aoZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.d
    public void AC() {
        com.baidu.swan.apps.v.c.a.eR(this.aoZ).Fo().cG(1);
        this.apg.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a AM = AM();
        this.apg.add(new UbcFlowEvent("na_end_update_db"));
        if (AM == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            if (this.ass != null && this.ass.category == 0) {
                this.ajQ.atK = com.baidu.swan.apps.swancore.b.dU(0);
                this.ajQ.cF(1);
            }
            if (this.ast != null && this.ast.category == 0) {
                this.ajQ.atL = com.baidu.swan.apps.extcore.a.Ck().BB();
                this.ajQ.cF(2);
            }
            if (this.asu != null && !TextUtils.isEmpty(this.asu.appId) && !TextUtils.isEmpty(this.asu.iconUrl)) {
                com.baidu.swan.apps.core.a.c.b(this.asu.appId, this.asu.iconUrl, String.valueOf(this.asu.versionCode), this.asu.appCategory);
            }
            com.baidu.swan.apps.v.d.a(this.mContext, this.ajQ, this.asu, this.aoZ);
            aa("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.ajQ, AM, this.aoZ);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        com.baidu.swan.apps.ak.a hX;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            hX = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "未知错误");
            }
            hX = new com.baidu.swan.apps.ak.a().Y(10L).Z(2900L).hX("包下载过程未知错误");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.ajQ, hX, this.aoZ);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType AD() {
        return PMSDownloadType.SYNC;
    }

    public com.baidu.swan.apps.v.b.c AE() {
        return this.ajQ;
    }

    private void a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar) {
        if (cVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dM(cVar.ayS);
            fVar.mAppId = cVar.mAppId;
            fVar.mSource = cVar.mFrom;
            fVar.mType = "launch";
            fVar.mValue = "success";
            fVar.k("status", "1");
            if (aVar != null) {
                fVar.k("errcode", String.valueOf(aVar.Og()));
                fVar.k("msg", aVar.Of().toString());
            }
            fVar.d(cVar);
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
        }
    }
}
