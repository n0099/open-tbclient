package com.baidu.swan.apps.core.pms;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes11.dex */
public class e extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public e(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null && eVar.aIu()) {
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
        fi(aVar.errorNo);
        if (com.baidu.swan.apps.core.pms.d.a.c(aVar)) {
            com.baidu.swan.apps.core.pms.d.a.jG(this.mAppId);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaR() {
        super.aaR();
        if (this.ccw != null) {
            abh();
            H("checkForUpdate", false);
            com.baidu.swan.apps.core.pms.d.a.jG(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aaX() {
        super.aaX();
        this.ccx.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.an.a abg = abg();
        this.ccx.add(new UbcFlowEvent("na_end_update_db"));
        if (abg == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
            }
            H("updateReady", true);
            bc("main_async_download", "0");
            com.baidu.swan.apps.core.pms.d.a.jG(this.mAppId);
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
    protected PMSDownloadType aaY() {
        return PMSDownloadType.ASYNC;
    }

    private void H(String str, boolean z) {
        if (!TextUtils.isEmpty(this.mAppId)) {
            h.j(str, this.mAppId, z);
        }
    }
}
