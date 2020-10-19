package com.baidu.swan.apps.core.pms;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes10.dex */
public class e extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public e(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int alQ() {
        return 3;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null && fVar.aYg()) {
            P("checkForUpdate", true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void N(String str, int i) {
        super.N(str, i);
        com.baidu.swan.pms.c.c xK = com.baidu.swan.pms.c.c.xK(str);
        if (xK != null) {
            boolean cW = com.baidu.swan.pms.utils.e.cW(xK.getData());
            com.baidu.swan.apps.console.c.i("SwanAppPkgAsyncDownloadCallback", "resetCore: " + cW);
            if (cW) {
                com.baidu.swan.apps.process.messaging.a.aAK().a(new com.baidu.swan.apps.process.messaging.c(129).fK(true));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: onFetchError: " + aVar.toString());
        }
        P("checkForUpdate", false);
        hO(aVar.errorNo);
        if (com.baidu.swan.apps.core.pms.d.a.c(aVar)) {
            com.baidu.swan.apps.core.pms.d.a.mI(this.mAppId);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiW() {
        super.aiW();
        if (this.cyN != null) {
            amd();
            P("checkForUpdate", false);
            com.baidu.swan.apps.core.pms.d.a.mI(this.mAppId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void alU() {
        super.alU();
        this.cyO.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.am.a amc = amc();
        this.cyO.add(new UbcFlowEvent("na_end_update_db"));
        if (amc == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
            }
            P("updateReady", true);
            br("main_async_download", "0");
            com.baidu.swan.apps.core.pms.d.a.mI(this.mAppId);
        } else if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储失败");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        P("updateFailed", false);
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
    protected PMSDownloadType alV() {
        return PMSDownloadType.ASYNC;
    }

    private void P(String str, boolean z) {
        if (!TextUtils.isEmpty(this.mAppId)) {
            h.j(str, this.mAppId, z);
        }
    }
}
