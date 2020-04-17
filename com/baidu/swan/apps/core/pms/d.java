package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.as.ab;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import java.util.Set;
/* loaded from: classes11.dex */
public class d extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.f.e bOg;
    private a bOh;
    private com.baidu.swan.pms.a.a<a.C0394a> bOi = new com.baidu.swan.pms.a.a<a.C0394a>() { // from class: com.baidu.swan.apps.core.pms.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: b */
        public String L(a.C0394a c0394a) {
            if (c0394a == null) {
                return null;
            }
            if (c0394a.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.Xz();
            }
            if (c0394a.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.XA();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public void a(final PMSAppInfo pMSAppInfo, final PMSAppInfo pMSAppInfo2) {
            if (pMSAppInfo != null && pMSAppInfo2 != null) {
                m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pMSAppInfo.o(pMSAppInfo2);
                        pMSAppInfo.aBV();
                        if (com.baidu.swan.pms.database.a.aBI().m(pMSAppInfo)) {
                            com.baidu.swan.apps.core.pms.d.a.d(pMSAppInfo);
                        }
                    }
                }, "批量下载-只更新AppInfo-存储DB");
            }
        }

        @Override // com.baidu.swan.pms.a.a
        public void b(com.baidu.swan.pms.model.a aVar) {
            if (d.DEBUG) {
                Log.e("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.errorNo + ",msg: " + aVar.errorMsg);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void J(a.C0394a c0394a) {
            super.J(c0394a);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0394a.dai);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void K(a.C0394a c0394a) {
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0394a.dai);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void I(a.C0394a c0394a) {
            super.I(c0394a);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0394a.dbc.currentSize + "/" + c0394a.dbc.size);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(a.C0394a c0394a, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) c0394a, aVar);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            }
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(11L).bo(aVar.errorNo).nK("批量下载，主包下载失败：" + c0394a.dai).nL(aVar.toString());
            if (c0394a.errorCode != 0) {
                if (d.DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + nL.toString());
                }
            } else if (c0394a.dbc != null) {
                d.this.bOg.f(c0394a.dbc);
                c.Xc().a(c0394a.dbc, PMSDownloadType.BATCH, nL);
                com.baidu.swan.d.c.deleteFile(c0394a.dbc.filePath);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void H(final a.C0394a c0394a) {
            super.H(c0394a);
            if (d.DEBUG) {
                Log.d("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0394a.dbc);
            }
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.a(c0394a);
                }
            }, c0394a.dbc.dai + " 下载完成，执行签名校验-重命名-解压-DB");
        }
    };

    @Override // com.baidu.swan.pms.a.g
    public void UR() {
        super.UR();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xe() {
        super.Xe();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.bOh != null) {
            this.bOh.eK(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xa() {
        super.Xa();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onNoPackage");
        }
        if (this.bOh != null) {
            this.bOh.Xa();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        this.bOg = eVar;
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onPrepareDownload: " + eVar.aCH());
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void WZ() {
        super.WZ();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (this.bOh != null) {
            this.bOh.WZ();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0394a> Xf() {
        return this.bOi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0394a c0394a) {
        if (c0394a != null && c0394a.dbc != null && c0394a.dbd != null) {
            if (!ab.e(new File(c0394a.dbc.filePath), c0394a.dbc.sign)) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                    return;
                }
                return;
            }
            com.baidu.swan.apps.ap.a b = com.baidu.swan.apps.core.pms.d.a.b(c0394a.dbc);
            if (b != null) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 重命名失败，" + b);
                    return;
                }
                return;
            }
            com.baidu.swan.apps.ap.a a = com.baidu.swan.apps.core.pms.d.a.a(c0394a.dbc, this);
            if (a != null) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a);
                    return;
                }
                return;
            }
            c0394a.dbd.aBV();
            com.baidu.swan.apps.core.pms.d.a.a(c0394a.dbd, c0394a.dbc);
            if (!com.baidu.swan.pms.database.a.aBI().a(c0394a.dbc, c0394a.dbd)) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                    return;
                }
                return;
            }
            this.bOg.g(c0394a.dbc);
            if (!c0394a.dbe) {
                com.baidu.swan.apps.core.pms.d.a.d(c0394a.dbd);
            }
        }
    }
}
