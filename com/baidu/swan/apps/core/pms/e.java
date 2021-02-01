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
    protected int aqG() {
        return 3;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null && fVar.bdM()) {
            R("checkForUpdate", true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void T(String str, int i) {
        super.T(str, i);
        com.baidu.swan.pms.c.c ya = com.baidu.swan.pms.c.c.ya(str);
        if (ya != null) {
            boolean dg = com.baidu.swan.pms.utils.e.dg(ya.getData());
            com.baidu.swan.apps.console.c.i("SwanAppPkgAsyncDownloadCallback", "resetCore: " + dg);
            if (dg) {
                com.baidu.swan.apps.process.messaging.a.aFz().a(new com.baidu.swan.apps.process.messaging.c(129).gF(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: onFetchError: " + aVar.toString());
        }
        R("checkForUpdate", false);
        gV(aVar.errorNo);
        if (com.baidu.swan.apps.core.pms.d.a.c(aVar)) {
            com.baidu.swan.apps.core.pms.d.a.mR(this.mAppId);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void anG() {
        super.anG();
        if (this.cUJ != null) {
            aqT();
            R("checkForUpdate", false);
            com.baidu.swan.apps.core.pms.d.a.mR(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aqK() {
        super.aqK();
        this.cUK.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.al.a aqS = aqS();
        this.cUK.add(new UbcFlowEvent("na_end_update_db"));
        if (aqS == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
            }
            R("updateReady", true);
            bw("main_async_download", "0");
            com.baidu.swan.apps.core.pms.d.a.mR(this.mAppId);
        } else if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储失败");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void l(Throwable th) {
        R("updateFailed", false);
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
    protected PMSDownloadType aqL() {
        return PMSDownloadType.ASYNC;
    }

    private void R(String str, boolean z) {
        if (!TextUtils.isEmpty(this.mAppId)) {
            h.n(str, this.mAppId, z);
        }
    }
}
