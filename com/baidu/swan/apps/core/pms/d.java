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
/* loaded from: classes10.dex */
public class d extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.f.e blB;
    private a blC;
    private com.baidu.swan.pms.a.a<a.C0354a> blD = new com.baidu.swan.pms.a.a<a.C0354a>() { // from class: com.baidu.swan.apps.core.pms.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: b */
        public String I(a.C0354a c0354a) {
            if (c0354a == null) {
                return null;
            }
            if (c0354a.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.Nr();
            }
            if (c0354a.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.Ns();
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
                        pMSAppInfo.ars();
                        if (com.baidu.swan.pms.database.a.arf().m(pMSAppInfo)) {
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
        public void G(a.C0354a c0354a) {
            super.G(c0354a);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0354a.cwZ);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void H(a.C0354a c0354a) {
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0354a.cwZ);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void F(a.C0354a c0354a) {
            super.F(c0354a);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0354a.cxR.currentSize + "/" + c0354a.cxR.size);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(a.C0354a c0354a, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) c0354a, aVar);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            }
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(11L).aF(aVar.errorNo).mj("批量下载，主包下载失败：" + c0354a.cwZ).mk(aVar.toString());
            if (c0354a.errorCode != 0) {
                if (d.DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + mk.toString());
                }
            } else if (c0354a.cxR != null) {
                d.this.blB.f(c0354a.cxR);
                c.MU().a(c0354a.cxR, PMSDownloadType.BATCH, mk);
                com.baidu.swan.d.c.deleteFile(c0354a.cxR.filePath);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void E(final a.C0354a c0354a) {
            super.E(c0354a);
            if (d.DEBUG) {
                Log.d("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0354a.cxR);
            }
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.a(c0354a);
                }
            }, c0354a.cxR.cwZ + " 下载完成，执行签名校验-重命名-解压-DB");
        }
    };

    @Override // com.baidu.swan.pms.a.g
    public void KK() {
        super.KK();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void MW() {
        super.MW();
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
        if (this.blC != null) {
            this.blC.ep(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void MS() {
        super.MS();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onNoPackage");
        }
        if (this.blC != null) {
            this.blC.MS();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        this.blB = eVar;
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onPrepareDownload: " + eVar.asd());
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void MR() {
        super.MR();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (this.blC != null) {
            this.blC.MR();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0354a> MX() {
        return this.blD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0354a c0354a) {
        if (c0354a != null && c0354a.cxR != null && c0354a.cxS != null) {
            if (!ab.d(new File(c0354a.cxR.filePath), c0354a.cxR.sign)) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                    return;
                }
                return;
            }
            com.baidu.swan.apps.ap.a b = com.baidu.swan.apps.core.pms.d.a.b(c0354a.cxR);
            if (b != null) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 重命名失败，" + b);
                    return;
                }
                return;
            }
            com.baidu.swan.apps.ap.a a = com.baidu.swan.apps.core.pms.d.a.a(c0354a.cxR, this);
            if (a != null) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a);
                    return;
                }
                return;
            }
            c0354a.cxS.ars();
            com.baidu.swan.apps.core.pms.d.a.a(c0354a.cxS, c0354a.cxR);
            if (!com.baidu.swan.pms.database.a.arf().a(c0354a.cxR, c0354a.cxS)) {
                if (DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                    return;
                }
                return;
            }
            this.blB.g(c0354a.cxR);
            if (!c0354a.cxT) {
                com.baidu.swan.apps.core.pms.d.a.d(c0354a.cxS);
            }
        }
    }
}
