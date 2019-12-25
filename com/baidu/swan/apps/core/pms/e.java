package com.baidu.swan.apps.core.pms;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes9.dex */
public class e extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public e(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null && eVar.arL()) {
            r("checkForUpdate", true);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: onFetchError: " + aVar.toString());
        }
        r("checkForUpdate", false);
        eq(aVar.errorNo);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Mw() {
        super.Mw();
        if (this.blc != null) {
            MM();
            r("checkForUpdate", false);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void MC() {
        this.bld.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ap.a ML = ML();
        this.bld.add(new UbcFlowEvent("na_end_update_db"));
        if (ML == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
            }
            r("updateReady", true);
            aq("main_async_download", "0");
        } else if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储失败");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void n(Throwable th) {
        r("updateFailed", false);
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
    protected PMSDownloadType MD() {
        return PMSDownloadType.ASYNC;
    }

    private void r(String str, boolean z) {
        if (!TextUtils.isEmpty(this.mAppId)) {
            h.h(str, this.mAppId, z);
        }
    }
}
