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
    private com.baidu.swan.pms.f.e bOl;
    private a bOm;
    private com.baidu.swan.pms.a.a<a.C0415a> bOn = new com.baidu.swan.pms.a.a<a.C0415a>() { // from class: com.baidu.swan.apps.core.pms.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: b */
        public String M(a.C0415a c0415a) {
            if (c0415a == null) {
                return null;
            }
            if (c0415a.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.Xy();
            }
            if (c0415a.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.Xz();
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
        public void K(a.C0415a c0415a) {
            super.K(c0415a);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0415a.dan);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void L(a.C0415a c0415a) {
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0415a.dan);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void J(a.C0415a c0415a) {
            super.J(c0415a);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0415a.dbh.currentSize + "/" + c0415a.dbh.size);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(a.C0415a c0415a, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) c0415a, aVar);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            }
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(11L).bo(aVar.errorNo).nK("批量下载，主包下载失败：" + c0415a.dan).nL(aVar.toString());
            if (c0415a.errorCode != 0) {
                if (d.DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + nL.toString());
                }
            } else if (c0415a.dbh != null) {
                d.this.bOl.f(c0415a.dbh);
                c.Xb().a(c0415a.dbh, PMSDownloadType.BATCH, nL);
                com.baidu.swan.d.c.deleteFile(c0415a.dbh.filePath);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void I(final a.C0415a c0415a) {
            super.I(c0415a);
            if (d.DEBUG) {
                Log.d("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0415a.dbh);
            }
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.a(c0415a);
                }
            }, c0415a.dbh.dan + " 下载完成，执行签名校验-重命名-解压-DB");
        }
    };

    @Override // com.baidu.swan.pms.a.g
    public void UQ() {
        super.UQ();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xd() {
        super.Xd();
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
        if (this.bOm != null) {
            this.bOm.eK(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void WZ() {
        super.WZ();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onNoPackage");
        }
        if (this.bOm != null) {
            this.bOm.WZ();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        this.bOl = eVar;
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onPrepareDownload: " + eVar.aCH());
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void WY() {
        super.WY();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (this.bOm != null) {
            this.bOm.WY();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0415a> Xe() {
        return this.bOn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0415a c0415a) {
        if (c0415a != null && c0415a.dbh != null && c0415a.dbi != null) {
            if (!ab.e(new File(c0415a.dbh.filePath), c0415a.dbh.sign)) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                    return;
                }
                return;
            }
            com.baidu.swan.apps.ap.a b = com.baidu.swan.apps.core.pms.d.a.b(c0415a.dbh);
            if (b != null) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 重命名失败，" + b);
                    return;
                }
                return;
            }
            com.baidu.swan.apps.ap.a a = com.baidu.swan.apps.core.pms.d.a.a(c0415a.dbh, this);
            if (a != null) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a);
                    return;
                }
                return;
            }
            c0415a.dbi.aBV();
            com.baidu.swan.apps.core.pms.d.a.a(c0415a.dbi, c0415a.dbh);
            if (!com.baidu.swan.pms.database.a.aBI().a(c0415a.dbh, c0415a.dbi)) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                    return;
                }
                return;
            }
            this.bOl.g(c0415a.dbh);
            if (!c0415a.dbj) {
                com.baidu.swan.apps.core.pms.d.a.d(c0415a.dbi);
            }
        }
    }
}
