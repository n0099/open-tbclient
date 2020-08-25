package com.baidu.swan.apps.core.pms;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes8.dex */
public class e extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public e(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aiv() {
        return 3;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null && fVar.aUL()) {
            L("checkForUpdate", true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void M(String str, int i) {
        super.M(str, i);
        com.baidu.swan.pms.c.c wE = com.baidu.swan.pms.c.c.wE(str);
        if (wE != null) {
            boolean cM = com.baidu.swan.pms.utils.e.cM(wE.getData());
            com.baidu.swan.apps.console.c.i("SwanAppPkgAsyncDownloadCallback", "resetCore: " + cM);
            if (cM) {
                com.baidu.swan.apps.process.messaging.a.axs().a(new com.baidu.swan.apps.process.messaging.c(129).fp(true));
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
        hi(aVar.errorNo);
        if (com.baidu.swan.apps.core.pms.d.a.c(aVar)) {
            com.baidu.swan.apps.core.pms.d.a.lC(this.mAppId);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void afB() {
        super.afB();
        if (this.ckq != null) {
            aiI();
            L("checkForUpdate", false);
            com.baidu.swan.apps.core.pms.d.a.lC(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aiz() {
        super.aiz();
        this.ckr.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a aiH = aiH();
        this.ckr.add(new UbcFlowEvent("na_end_update_db"));
        if (aiH == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
            }
            L("updateReady", true);
            bm("main_async_download", "0");
            com.baidu.swan.apps.core.pms.d.a.lC(this.mAppId);
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
    protected PMSDownloadType aiA() {
        return PMSDownloadType.ASYNC;
    }

    private void L(String str, boolean z) {
        if (!TextUtils.isEmpty(this.mAppId)) {
            h.j(str, this.mAppId, z);
        }
    }
}
