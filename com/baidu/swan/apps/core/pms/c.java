package com.baidu.swan.apps.core.pms;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.a.i;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes2.dex */
public class c extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.v.b.c ajB;

    public c(com.baidu.swan.apps.v.b.c cVar) {
        super(cVar.mAppId);
        this.ajB = cVar;
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.d.e eVar) {
        super.a(eVar);
        if (eVar != null && eVar.Sp()) {
            l("checkForUpdate", true);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.model.b bVar) {
        super.a(bVar);
        if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "onFetchError: " + bVar.toString());
        }
        l("checkForUpdate", false);
        co(bVar.errorNo);
    }

    @Override // com.baidu.swan.pms.a.e
    public void zy() {
        super.zy();
        if (this.ask != null) {
            zI();
            l("checkForUpdate", false);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void zz() {
        this.aoT.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a zH = zH();
        this.aoT.add(new UbcFlowEvent("na_end_update_db"));
        if (zH == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "异步更新-> DB 存储成功");
            }
            l("updateReady", true);
            ae("main_async_download", "0");
        } else if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "异步更新-> DB 存储失败");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        l("updateFailed", false);
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgAsyncDownloadCallback", "pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage());
            }
        } else if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "未知错误：" + th.getMessage());
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType zA() {
        return PMSDownloadType.ASYNC;
    }

    private void l(String str, boolean z) {
        String str2 = this.ajB != null ? this.ajB.mAppId : null;
        if (!TextUtils.isEmpty(str2)) {
            i.d(str, str2, z);
        }
    }
}
