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
    private com.baidu.swan.pms.f.e bpN;
    private a bpO;
    private com.baidu.swan.pms.a.a<a.C0364a> bpP = new com.baidu.swan.pms.a.a<a.C0364a>() { // from class: com.baidu.swan.apps.core.pms.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: b */
        public String K(a.C0364a c0364a) {
            if (c0364a == null) {
                return null;
            }
            if (c0364a.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.PH();
            }
            if (c0364a.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.PI();
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
                        pMSAppInfo.atI();
                        if (com.baidu.swan.pms.database.a.atv().m(pMSAppInfo)) {
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
        public void I(a.C0364a c0364a) {
            super.I(c0364a);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0364a.cAZ);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void J(a.C0364a c0364a) {
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0364a.cAZ);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void H(a.C0364a c0364a) {
            super.H(c0364a);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0364a.cBR.currentSize + "/" + c0364a.cBR.size);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(a.C0364a c0364a, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) c0364a, aVar);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            }
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(11L).aJ(aVar.errorNo).my("批量下载，主包下载失败：" + c0364a.cAZ).mz(aVar.toString());
            if (c0364a.errorCode != 0) {
                if (d.DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + mz.toString());
                }
            } else if (c0364a.cBR != null) {
                d.this.bpN.f(c0364a.cBR);
                c.Pk().a(c0364a.cBR, PMSDownloadType.BATCH, mz);
                com.baidu.swan.d.c.deleteFile(c0364a.cBR.filePath);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void G(final a.C0364a c0364a) {
            super.G(c0364a);
            if (d.DEBUG) {
                Log.d("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0364a.cBR);
            }
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.a(c0364a);
                }
            }, c0364a.cBR.cAZ + " 下载完成，执行签名校验-重命名-解压-DB");
        }
    };

    @Override // com.baidu.swan.pms.a.g
    public void Nb() {
        super.Nb();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pm() {
        super.Pm();
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
        if (this.bpO != null) {
            this.bpO.eF(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pi() {
        super.Pi();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onNoPackage");
        }
        if (this.bpO != null) {
            this.bpO.Pi();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        this.bpN = eVar;
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onPrepareDownload: " + eVar.aut());
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void Ph() {
        super.Ph();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (this.bpO != null) {
            this.bpO.Ph();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0364a> Pn() {
        return this.bpP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0364a c0364a) {
        if (c0364a != null && c0364a.cBR != null && c0364a.cBS != null) {
            if (!ab.d(new File(c0364a.cBR.filePath), c0364a.cBR.sign)) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                    return;
                }
                return;
            }
            com.baidu.swan.apps.ap.a b = com.baidu.swan.apps.core.pms.d.a.b(c0364a.cBR);
            if (b != null) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 重命名失败，" + b);
                    return;
                }
                return;
            }
            com.baidu.swan.apps.ap.a a = com.baidu.swan.apps.core.pms.d.a.a(c0364a.cBR, this);
            if (a != null) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a);
                    return;
                }
                return;
            }
            c0364a.cBS.atI();
            com.baidu.swan.apps.core.pms.d.a.a(c0364a.cBS, c0364a.cBR);
            if (!com.baidu.swan.pms.database.a.atv().a(c0364a.cBR, c0364a.cBS)) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                    return;
                }
                return;
            }
            this.bpN.g(c0364a.cBR);
            if (!c0364a.cBT) {
                com.baidu.swan.apps.core.pms.d.a.d(c0364a.cBS);
            }
        }
    }
}
