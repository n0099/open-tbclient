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

    @Override // com.baidu.swan.apps.core.pms.j
    protected int auc() {
        return 3;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null && fVar.bhs()) {
            S("checkForUpdate", true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void R(String str, int i) {
        super.R(str, i);
        com.baidu.swan.pms.c.c yS = com.baidu.swan.pms.c.c.yS(str);
        if (yS != null) {
            boolean dj = com.baidu.swan.pms.utils.e.dj(yS.getData());
            com.baidu.swan.apps.console.c.i("SwanAppPkgAsyncDownloadCallback", "resetCore: " + dj);
            if (dj) {
                com.baidu.swan.apps.process.messaging.a.aIX().a(new com.baidu.swan.apps.process.messaging.c(129).gH(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: onFetchError: " + aVar.toString());
        }
        S("checkForUpdate", false);
        iy(aVar.errorNo);
        if (com.baidu.swan.apps.core.pms.d.a.c(aVar)) {
            com.baidu.swan.apps.core.pms.d.a.nK(this.mAppId);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void arc() {
        super.arc();
        if (this.cXi != null) {
            aup();
            S("checkForUpdate", false);
            com.baidu.swan.apps.core.pms.d.a.nK(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aug() {
        super.aug();
        this.cXj.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.al.a auo = auo();
        this.cXj.add(new UbcFlowEvent("na_end_update_db"));
        if (auo == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
            }
            S("updateReady", true);
            bD("main_async_download", "0");
            com.baidu.swan.apps.core.pms.d.a.nK(this.mAppId);
        } else if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储失败");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void m(Throwable th) {
        S("updateFailed", false);
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
    protected PMSDownloadType auh() {
        return PMSDownloadType.ASYNC;
    }

    private void S(String str, boolean z) {
        if (!TextUtils.isEmpty(this.mAppId)) {
            h.n(str, this.mAppId, z);
        }
    }
}
