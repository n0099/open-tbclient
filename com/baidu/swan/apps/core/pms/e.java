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
    protected int apD() {
        return 3;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null && fVar.bbS()) {
            R("checkForUpdate", true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void P(String str, int i) {
        super.P(str, i);
        com.baidu.swan.pms.c.c ym = com.baidu.swan.pms.c.c.ym(str);
        if (ym != null) {
            boolean cZ = com.baidu.swan.pms.utils.e.cZ(ym.getData());
            com.baidu.swan.apps.console.c.i("SwanAppPkgAsyncDownloadCallback", "resetCore: " + cZ);
            if (cZ) {
                com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(129).gj(true));
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
        m33if(aVar.errorNo);
        if (com.baidu.swan.apps.core.pms.d.a.c(aVar)) {
            com.baidu.swan.apps.core.pms.d.a.nk(this.mAppId);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void amI() {
        super.amI();
        if (this.cLs != null) {
            apQ();
            R("checkForUpdate", false);
            com.baidu.swan.apps.core.pms.d.a.nk(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void apH() {
        super.apH();
        this.cLt.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a apP = apP();
        this.cLt.add(new UbcFlowEvent("na_end_update_db"));
        if (apP == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
            }
            R("updateReady", true);
            bx("main_async_download", "0");
            com.baidu.swan.apps.core.pms.d.a.nk(this.mAppId);
        } else if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储失败");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
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
    protected PMSDownloadType apI() {
        return PMSDownloadType.ASYNC;
    }

    private void R(String str, boolean z) {
        if (!TextUtils.isEmpty(this.mAppId)) {
            h.k(str, this.mAppId, z);
        }
    }
}
