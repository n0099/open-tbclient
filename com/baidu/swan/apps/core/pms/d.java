package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.ap.ae;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
/* loaded from: classes10.dex */
public class d extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.utils.f cML;
    private a cMM;
    private final List<com.baidu.swan.pms.model.g> cMN;
    private com.baidu.swan.pms.a.a<a.C0558a> cMO;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cMP;

    public d() {
        this(null);
    }

    public d(a aVar) {
        this.cMO = new com.baidu.swan.pms.a.a<a.C0558a>() { // from class: com.baidu.swan.apps.core.pms.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.c
            /* renamed from: c */
            public String U(a.C0558a c0558a) {
                if (c0558a == null) {
                    return null;
                }
                if (c0558a.category == 0) {
                    return com.baidu.swan.apps.core.pms.f.a.aqI();
                }
                if (c0558a.category == 1) {
                    return com.baidu.swan.apps.core.pms.f.a.aqJ();
                }
                return null;
            }

            @Override // com.baidu.swan.pms.a.e
            @NonNull
            public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                return d.this.a(bundle, set);
            }

            @Override // com.baidu.swan.pms.a.a
            public void b(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
                d.this.a(pMSAppInfo, pMSAppInfo2);
            }

            @Override // com.baidu.swan.pms.a.a
            public void a(a.C0558a c0558a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar2) {
                com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar2.errorNo + ",msg: " + aVar2.errorMsg);
                if (d.this.cMM != null) {
                    d.this.cMM.a(aVar2);
                }
                if (aVar2 != null && aVar2.errorNo == 1010) {
                    PMSAppInfo pMSAppInfo2 = c0558a == null ? null : c0558a.eiA;
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    d.this.a(pMSAppInfo2, pMSAppInfo);
                    if (com.baidu.swan.apps.core.pms.d.a.c(aVar2)) {
                        com.baidu.swan.apps.core.pms.d.a.nq(pMSAppInfo2.appId);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: d */
            public void S(a.C0558a c0558a) {
                super.S(c0558a);
                com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0558a.ehG);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: e */
            public void T(a.C0558a c0558a) {
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0558a.ehG);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: f */
            public void R(a.C0558a c0558a) {
                super.R(c0558a);
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0558a.eiy.currentSize + "/" + c0558a.eiy.size);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            public void a(a.C0558a c0558a, com.baidu.swan.pms.model.a aVar2) {
                super.a((AnonymousClass2) c0558a, aVar2);
                com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar2.toString());
                com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(11L).cw(aVar2.errorNo).tY("批量下载，主包下载失败：" + c0558a.ehG).ua(aVar2.toString());
                if (c0558a.errorCode != 0) {
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + ua.toString());
                    }
                } else if (c0558a.eiy != null) {
                    d.this.cML.f(c0558a.eiy);
                    c.aqj().a(c0558a.eiy, PMSDownloadType.BATCH, ua);
                    com.baidu.swan.c.d.deleteFile(c0558a.eiy.filePath);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: g */
            public void Q(final a.C0558a c0558a) {
                super.Q(c0558a);
                com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0558a.eiy.versionCode);
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b(c0558a)) {
                            if (d.this.cMM != null) {
                                d.this.cMM.a(c0558a);
                            }
                            com.baidu.swan.apps.core.pms.d.a.nq(c0558a.eiA.appId);
                        }
                    }
                }, c0558a.eiy.ehG + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        };
        this.cMP = new k<d>(this) { // from class: com.baidu.swan.apps.core.pms.d.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.swan.apps.core.pms.k
            public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar2) {
                super.a(gVar, aVar2);
                if (aVar2 == null) {
                    d.this.cMN.add(gVar);
                } else if (d.DEBUG) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + ", " + aVar2);
                }
            }
        };
        this.cMM = aVar;
        this.cMN = new Vector();
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aql() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ans() {
        super.ans();
        com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqm() {
        super.aqm();
        com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        if (this.cMM != null) {
            this.cMM.ih(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void anq() {
        super.anq();
        com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onNoPackage");
        if (this.cMM != null) {
            this.cMM.anq();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cML = fVar;
        com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.bcy());
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void aqh() {
        super.aqh();
        com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.cMN.isEmpty()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean a2 = com.baidu.swan.pms.database.a.bbh().a(null, d.this.cMN, null, null, null);
                    if (a2 && d.this.cMM != null) {
                        for (com.baidu.swan.pms.model.g gVar : d.this.cMN) {
                            d.this.cMM.a(gVar);
                        }
                    }
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + a2 + ", size=" + d.this.cMN);
                    }
                }
            }, "SwanAppBatchDownloadCallback");
        }
        if (this.cMM != null) {
            this.cMM.aqh();
        }
        com.baidu.swan.apps.env.e.ati().atj().a((Set<String>) null, com.baidu.swan.apps.env.c.c.atN().iv(7).atO());
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0558a> aqn() {
        return this.cMO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable final PMSAppInfo pMSAppInfo, @Nullable final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pMSAppInfo2 != null) {
                        pMSAppInfo2.mR(d.this.aqD());
                        pMSAppInfo.u(pMSAppInfo2);
                    } else {
                        pMSAppInfo.mR(d.this.aqD());
                    }
                    pMSAppInfo.bbs();
                    if (com.baidu.swan.pms.database.a.bbh().r(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.g(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(a.C0558a c0558a) {
        if (c0558a == null || c0558a.eiy == null || c0558a.eiA == null) {
            return false;
        }
        if (!ae.e(new File(c0558a.eiy.filePath), c0558a.eiy.sign)) {
            com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        com.baidu.swan.apps.am.a a2 = com.baidu.swan.apps.core.pms.f.a.a(c0558a.eiy, this);
        if (a2 != null) {
            com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a2);
            return false;
        }
        c0558a.eiA.bbs();
        com.baidu.swan.apps.core.pms.f.a.a(c0558a.eiA, c0558a.eiy);
        c0558a.eiA.mR(aqD());
        if (!com.baidu.swan.pms.database.a.bbh().a(c0558a.eiy, c0558a.eiA)) {
            com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.cML.g(c0558a.eiy);
        if (!c0558a.eiB) {
            com.baidu.swan.apps.core.pms.f.a.g(c0558a.eiA);
        }
        com.baidu.swan.apps.core.pms.f.a.b(c0558a.eiy);
        return true;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aqo() {
        return this.cMP;
    }
}
