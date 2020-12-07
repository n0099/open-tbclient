package com.baidu.swan.apps.core.pms;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes25.dex */
public class e extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public e(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int asL() {
        return 3;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null && fVar.beX()) {
            S("checkForUpdate", true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void Q(String str, int i) {
        super.Q(str, i);
        com.baidu.swan.pms.c.c yT = com.baidu.swan.pms.c.c.yT(str);
        if (yT != null) {
            boolean db = com.baidu.swan.pms.utils.e.db(yT.getData());
            com.baidu.swan.apps.console.c.i("SwanAppPkgAsyncDownloadCallback", "resetCore: " + db);
            if (db) {
                com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(129).gy(true));
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
        iD(aVar.errorNo);
        if (com.baidu.swan.apps.core.pms.d.a.c(aVar)) {
            com.baidu.swan.apps.core.pms.d.a.nR(this.mAppId);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void apQ() {
        super.apQ();
        if (this.cSl != null) {
            asY();
            S("checkForUpdate", false);
            com.baidu.swan.apps.core.pms.d.a.nR(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void asP() {
        super.asP();
        this.cSm.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a asX = asX();
        this.cSm.add(new UbcFlowEvent("na_end_update_db"));
        if (asX == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
            }
            S("updateReady", true);
            bE("main_async_download", "0");
            com.baidu.swan.apps.core.pms.d.a.nR(this.mAppId);
        } else if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储失败");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
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
    protected PMSDownloadType asQ() {
        return PMSDownloadType.ASYNC;
    }

    private void S(String str, boolean z) {
        if (!TextUtils.isEmpty(this.mAppId)) {
            h.l(str, this.mAppId, z);
        }
    }
}
