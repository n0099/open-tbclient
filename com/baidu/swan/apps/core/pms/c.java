package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.a.i;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.Set;
/* loaded from: classes2.dex */
public class c extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.v.b.c aks;

    public c(com.baidu.swan.apps.v.b.c cVar) {
        super(cVar.mAppId);
        this.aks = cVar;
    }

    @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.d
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.aks.apD);
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.e.e eVar) {
        super.a(eVar);
        if (eVar != null && eVar.WV()) {
            l("checkForUpdate", true);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        l("checkForUpdate", false);
        cq(aVar.errorNo);
    }

    @Override // com.baidu.swan.pms.a.f
    public void Bj() {
        super.Bj();
        if (this.asX != null) {
            Bv();
            l("checkForUpdate", false);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void Bk() {
        this.apK.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a Bu = Bu();
        this.apK.add(new UbcFlowEvent("na_end_update_db"));
        if (Bu == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgAsyncDownloadCallback", "异步更新-> DB 存储成功");
            }
            l("updateReady", true);
            aa("main_async_download", "0");
        } else if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "异步更新-> DB 存储失败");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        l("updateFailed", false);
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgAsyncDownloadCallback", "pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage());
            }
        } else if (DEBUG) {
            Log.e("SwanAppPkgAsyncDownloadCallback", "未知错误：" + th.getMessage());
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType Bl() {
        return PMSDownloadType.ASYNC;
    }

    public com.baidu.swan.apps.v.b.c Bm() {
        return this.aks;
    }

    private void l(String str, boolean z) {
        String str2 = this.aks != null ? this.aks.mAppId : null;
        if (!TextUtils.isEmpty(str2)) {
            i.d(str, str2, z);
        }
    }
}
