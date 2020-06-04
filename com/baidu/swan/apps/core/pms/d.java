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
    private com.baidu.swan.pms.f.e bXr;
    private a bXs;
    private com.baidu.swan.pms.a.a<a.C0456a> bXt = new com.baidu.swan.pms.a.a<a.C0456a>() { // from class: com.baidu.swan.apps.core.pms.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: b */
        public String P(a.C0456a c0456a) {
            if (c0456a == null) {
                return null;
            }
            if (c0456a.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.aam();
            }
            if (c0456a.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aan();
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
        public void a(a.C0456a c0456a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar) {
            if (d.DEBUG) {
                Log.e("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.errorNo + ",msg: " + aVar.errorMsg);
            }
            if (d.this.bXs != null) {
                d.this.bXs.a(aVar);
            }
            if (aVar != null && aVar.errorNo == 1010) {
                PMSAppInfo pMSAppInfo2 = c0456a == null ? null : c0456a.dmu;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                d.this.a(pMSAppInfo2, pMSAppInfo);
                if (com.baidu.swan.apps.core.pms.d.a.c(aVar)) {
                    com.baidu.swan.apps.core.pms.d.a.jy(pMSAppInfo2.appId);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void N(a.C0456a c0456a) {
            super.N(c0456a);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0456a.dlx);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void O(a.C0456a c0456a) {
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0456a.dlx);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void M(a.C0456a c0456a) {
            super.M(c0456a);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0456a.dmt.currentSize + "/" + c0456a.dmt.size);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(a.C0456a c0456a, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) c0456a, aVar);
            if (d.DEBUG) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            }
            com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(11L).bx(aVar.errorNo).pr("批量下载，主包下载失败：" + c0456a.dlx).pt(aVar.toString());
            if (c0456a.errorCode != 0) {
                if (d.DEBUG) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + pt.toString());
                }
            } else if (c0456a.dmt != null) {
                d.this.bXr.f(c0456a.dmt);
                c.ZN().a(c0456a.dmt, PMSDownloadType.BATCH, pt);
                com.baidu.swan.e.d.deleteFile(c0456a.dmt.filePath);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(final a.C0456a c0456a) {
            super.L(c0456a);
            if (d.DEBUG) {
                Log.d("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0456a.dmt);
            }
            n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.a(c0456a)) {
                        com.baidu.swan.apps.core.pms.d.a.jy(c0456a.dmu.appId);
                    }
                }
            }, c0456a.dmt.dlx + " 下载完成，执行签名校验-重命名-解压-DB");
        }
    };

    public d() {
    }

    public d(a aVar) {
        this.bXs = aVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xw() {
        super.Xw();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZP() {
        super.ZP();
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
        if (this.bXs != null) {
            this.bXs.eV(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZL() {
        super.ZL();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onNoPackage");
        }
        if (this.bXs != null) {
            this.bXs.ZL();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        this.bXr = eVar;
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onPrepareDownload: " + eVar.aHn());
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void ZK() {
        super.ZK();
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (this.bXs != null) {
            this.bXs.ZK();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0456a> ZQ() {
        return this.bXt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final PMSAppInfo pMSAppInfo, final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null && pMSAppInfo2 != null) {
            n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2
                @Override // java.lang.Runnable
                public void run() {
                    pMSAppInfo.q(pMSAppInfo2);
                    pMSAppInfo.aGj();
                    if (com.baidu.swan.pms.database.a.aFV().o(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.e(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(a.C0456a c0456a) {
        if (c0456a == null || c0456a.dmt == null || c0456a.dmu == null) {
            return false;
        }
        if (!ac.e(new File(c0456a.dmt.filePath), c0456a.dmt.sign)) {
            if (DEBUG) {
                Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            return false;
        }
        com.baidu.swan.apps.an.a b = com.baidu.swan.apps.core.pms.f.a.b(c0456a.dmt);
        if (b != null) {
            if (DEBUG) {
                Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 重命名失败，" + b);
                return false;
            }
            return false;
        }
        com.baidu.swan.apps.an.a a = com.baidu.swan.apps.core.pms.f.a.a(c0456a.dmt, this);
        if (a != null) {
            if (DEBUG) {
                Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a);
                return false;
            }
            return false;
        }
        c0456a.dmu.aGj();
        com.baidu.swan.apps.core.pms.f.a.a(c0456a.dmu, c0456a.dmt);
        if (!com.baidu.swan.pms.database.a.aFV().a(c0456a.dmt, c0456a.dmu)) {
            if (DEBUG) {
                Log.e("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            return false;
        }
        this.bXr.g(c0456a.dmt);
        if (!c0456a.dmv) {
            com.baidu.swan.apps.core.pms.f.a.e(c0456a.dmu);
        }
        return true;
    }
}
