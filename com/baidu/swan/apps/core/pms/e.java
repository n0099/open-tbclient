package com.baidu.swan.apps.core.pms;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes3.dex */
public class e extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public e(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int ajf() {
        return 3;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null && fVar.aVx()) {
            L("checkForUpdate", true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void M(String str, int i) {
        super.M(str, i);
        com.baidu.swan.pms.c.c wY = com.baidu.swan.pms.c.c.wY(str);
        if (wY != null) {
            boolean cP = com.baidu.swan.pms.utils.e.cP(wY.getData());
            com.baidu.swan.apps.console.c.i("SwanAppPkgAsyncDownloadCallback", "resetCore: " + cP);
            if (cP) {
                com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(129).fo(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: onFetchError: " + aVar.toString());
        }
        L("checkForUpdate", false);
        hr(aVar.errorNo);
        if (com.baidu.swan.apps.core.pms.d.a.c(aVar)) {
            com.baidu.swan.apps.core.pms.d.a.lW(this.mAppId);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void agl() {
        super.agl();
        if (this.cmw != null) {
            ajs();
            L("checkForUpdate", false);
            com.baidu.swan.apps.core.pms.d.a.lW(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void ajj() {
        super.ajj();
        this.cmx.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a ajr = ajr();
        this.cmx.add(new UbcFlowEvent("na_end_update_db"));
        if (ajr == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
            }
            L("updateReady", true);
            bm("main_async_download", "0");
            com.baidu.swan.apps.core.pms.d.a.lW(this.mAppId);
        } else if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储失败");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        L("updateFailed", false);
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
    protected PMSDownloadType ajk() {
        return PMSDownloadType.ASYNC;
    }

    private void L(String str, boolean z) {
        if (!TextUtils.isEmpty(this.mAppId)) {
            h.j(str, this.mAppId, z);
        }
    }
}
