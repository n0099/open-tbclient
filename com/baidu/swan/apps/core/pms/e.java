package com.baidu.swan.apps.core.pms;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes7.dex */
public class e extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public e(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int abW() {
        return 3;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.f fVar) {
        super.a(fVar);
        if (fVar != null && fVar.aMm()) {
            H("checkForUpdate", true);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: onFetchError: " + aVar.toString());
        }
        H("checkForUpdate", false);
        fm(aVar.errorNo);
        if (com.baidu.swan.apps.core.pms.d.a.c(aVar)) {
            com.baidu.swan.apps.core.pms.d.a.jY(this.mAppId);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void Zs() {
        super.Zs();
        if (this.cea != null) {
            acj();
            H("checkForUpdate", false);
            com.baidu.swan.apps.core.pms.d.a.jY(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aca() {
        super.aca();
        this.ceb.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.an.a aci = aci();
        this.ceb.add(new UbcFlowEvent("na_end_update_db"));
        if (aci == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
            }
            H("updateReady", true);
            be("main_async_download", "0");
            com.baidu.swan.apps.core.pms.d.a.jY(this.mAppId);
        } else if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储失败");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void p(Throwable th) {
        H("updateFailed", false);
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage());
            }
        } else if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 未知错误：" + th.getMessage());
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType acb() {
        return PMSDownloadType.ASYNC;
    }

    private void H(String str, boolean z) {
        if (!TextUtils.isEmpty(this.mAppId)) {
            h.j(str, this.mAppId, z);
        }
    }
}
