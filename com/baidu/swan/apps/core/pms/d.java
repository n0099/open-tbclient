package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.aq.ac;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import java.util.Set;
/* loaded from: classes11.dex */
public class d extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.f.e ccf;
    private a ccg;
    private com.baidu.swan.pms.a.a<a.C0462a> cch = new com.baidu.swan.pms.a.a<a.C0462a>() { // from class: com.baidu.swan.apps.core.pms.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: b */
        public String P(a.C0462a c0462a) {
            if (c0462a == null) {
                return null;
            }
            if (c0462a.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.abs();
            }
            if (c0462a.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.abt();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public void b(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            d.this.a(pMSAppInfo, pMSAppInfo2);
        }

        @Override // com.baidu.swan.pms.a.a
        public void a(a.C0462a c0462a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar) {
            if (d.DEBUG) {
                Log.e("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.errorNo + ",msg: " + aVar.errorMsg);
            }
            if (d.this.ccg != null) {
                d.this.ccg.a(aVar);
            }
            if (aVar != null && aVar.errorNo == 1010) {
                PMSAppInfo pMSAppInfo2 = c0462a == null ? null : c0462a.drf;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                d.this.a(pMSAppInfo2, pMSAppInfo);
                if (com.baidu.swan.apps.core.pms.d.a.c(aVar)) {
                    com.baidu.swan.apps.core.pms.d.a.jG(pMSAppInfo2.appId);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void N(a.C0462a c0462a) {
            super.N(c0462a);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0462a.dqi);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void O(a.C0462a c0462a) {
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0462a.dqi);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void M(a.C0462a c0462a) {
            super.M(c0462a);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0462a.dre.currentSize + "/" + c0462a.dre.size);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(a.C0462a c0462a, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) c0462a, aVar);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            }
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(11L).bx(aVar.errorNo).pz("批量下载，主包下载失败：" + c0462a.dqi).pB(aVar.toString());
            if (c0462a.errorCode != 0) {
                if (d.DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + pB.toString());
                }
            } else if (c0462a.dre != null) {
                d.this.ccf.f(c0462a.dre);
                c.aaT().a(c0462a.dre, PMSDownloadType.BATCH, pB);
                com.baidu.swan.e.d.deleteFile(c0462a.dre.filePath);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(final a.C0462a c0462a) {
            super.L(c0462a);
            if (d.DEBUG) {
                Log.d("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0462a.dre);
            }
            n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.a(c0462a)) {
                        com.baidu.swan.apps.core.pms.d.a.jG(c0462a.drf.appId);
                    }
                }
            }, c0462a.dre.dqi + " 下载完成，执行签名校验-重命名-解压-DB");
        }
    };

    public d() {
    }

    public d(a aVar) {
        this.ccg = aVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void YC() {
        super.YC();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaV() {
        super.aaV();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        }
        if (this.ccg != null) {
            this.ccg.fg(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaR() {
        super.aaR();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onNoPackage");
        }
        if (this.ccg != null) {
            this.ccg.aaR();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        this.ccf = eVar;
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onPrepareDownload: " + eVar.aIt());
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void aaQ() {
        super.aaQ();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (this.ccg != null) {
            this.ccg.aaQ();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0462a> aaW() {
        return this.cch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final PMSAppInfo pMSAppInfo, final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null && pMSAppInfo2 != null) {
            n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2
                @Override // java.lang.Runnable
                public void run() {
                    pMSAppInfo.q(pMSAppInfo2);
                    pMSAppInfo.aHp();
                    if (com.baidu.swan.pms.database.a.aHb().o(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.e(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a.C0462a c0462a) {
        if (c0462a == null || c0462a.dre == null || c0462a.drf == null) {
            return false;
        }
        if (!ac.e(new File(c0462a.dre.filePath), c0462a.dre.sign)) {
            if (DEBUG) {
                Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            return false;
        }
        com.baidu.swan.apps.an.a b = com.baidu.swan.apps.core.pms.f.a.b(c0462a.dre);
        if (b != null) {
            if (DEBUG) {
                Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 重命名失败，" + b);
                return false;
            }
            return false;
        }
        com.baidu.swan.apps.an.a a = com.baidu.swan.apps.core.pms.f.a.a(c0462a.dre, this);
        if (a != null) {
            if (DEBUG) {
                Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a);
                return false;
            }
            return false;
        }
        c0462a.drf.aHp();
        com.baidu.swan.apps.core.pms.f.a.a(c0462a.drf, c0462a.dre);
        if (!com.baidu.swan.pms.database.a.aHb().a(c0462a.dre, c0462a.drf)) {
            if (DEBUG) {
                Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            return false;
        }
        this.ccf.g(c0462a.dre);
        if (!c0462a.drg) {
            com.baidu.swan.apps.core.pms.f.a.e(c0462a.drf);
        }
        return true;
    }
}
