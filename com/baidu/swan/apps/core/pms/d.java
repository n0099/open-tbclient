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
    private com.baidu.swan.pms.utils.f cGS;
    private a cGT;
    private final List<com.baidu.swan.pms.model.g> cGU;
    private com.baidu.swan.pms.a.a<a.C0546a> cGV;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cGW;

    public d() {
        this(null);
    }

    public d(a aVar) {
        this.cGV = new com.baidu.swan.pms.a.a<a.C0546a>() { // from class: com.baidu.swan.apps.core.pms.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.c
            /* renamed from: c */
            public String U(a.C0546a c0546a) {
                if (c0546a == null) {
                    return null;
                }
                if (c0546a.category == 0) {
                    return com.baidu.swan.apps.core.pms.f.a.aoh();
                }
                if (c0546a.category == 1) {
                    return com.baidu.swan.apps.core.pms.f.a.aoi();
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
            public void a(a.C0546a c0546a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar2) {
                com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar2.errorNo + ",msg: " + aVar2.errorMsg);
                if (d.this.cGT != null) {
                    d.this.cGT.a(aVar2);
                }
                if (aVar2 != null && aVar2.errorNo == 1010) {
                    PMSAppInfo pMSAppInfo2 = c0546a == null ? null : c0546a.ecI;
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    d.this.a(pMSAppInfo2, pMSAppInfo);
                    if (com.baidu.swan.apps.core.pms.d.a.c(aVar2)) {
                        com.baidu.swan.apps.core.pms.d.a.nb(pMSAppInfo2.appId);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: d */
            public void S(a.C0546a c0546a) {
                super.S(c0546a);
                com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0546a.ebO);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: e */
            public void T(a.C0546a c0546a) {
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0546a.ebO);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: f */
            public void R(a.C0546a c0546a) {
                super.R(c0546a);
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0546a.ecG.currentSize + "/" + c0546a.ecG.size);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            public void a(a.C0546a c0546a, com.baidu.swan.pms.model.a aVar2) {
                super.a((AnonymousClass2) c0546a, aVar2);
                com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar2.toString());
                com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(11L).ca(aVar2.errorNo).tK("批量下载，主包下载失败：" + c0546a.ebO).tM(aVar2.toString());
                if (c0546a.errorCode != 0) {
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + tM.toString());
                    }
                } else if (c0546a.ecG != null) {
                    d.this.cGS.f(c0546a.ecG);
                    c.anI().a(c0546a.ecG, PMSDownloadType.BATCH, tM);
                    com.baidu.swan.c.d.deleteFile(c0546a.ecG.filePath);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: g */
            public void Q(final a.C0546a c0546a) {
                super.Q(c0546a);
                com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0546a.ecG.versionCode);
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b(c0546a)) {
                            if (d.this.cGT != null) {
                                d.this.cGT.a(c0546a);
                            }
                            com.baidu.swan.apps.core.pms.d.a.nb(c0546a.ecI.appId);
                        }
                    }
                }, c0546a.ecG.ebO + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        };
        this.cGW = new k<d>(this) { // from class: com.baidu.swan.apps.core.pms.d.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.swan.apps.core.pms.k
            public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar2) {
                super.a(gVar, aVar2);
                if (aVar2 == null) {
                    d.this.cGU.add(gVar);
                } else if (d.DEBUG) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + ", " + aVar2);
                }
            }
        };
        this.cGT = aVar;
        this.cGU = new Vector();
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int anK() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void akS() {
        super.akS();
        com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // com.baidu.swan.pms.a.g
    public void anL() {
        super.anL();
        com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        if (this.cGT != null) {
            this.cGT.hX(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void akQ() {
        super.akQ();
        com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onNoPackage");
        if (this.cGT != null) {
            this.cGT.akQ();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cGS = fVar;
        com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.aZY());
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void anG() {
        super.anG();
        com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.cGU.isEmpty()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean a2 = com.baidu.swan.pms.database.a.aYH().a(null, d.this.cGU, null, null, null);
                    if (a2 && d.this.cGT != null) {
                        for (com.baidu.swan.pms.model.g gVar : d.this.cGU) {
                            d.this.cGT.a(gVar);
                        }
                    }
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + a2 + ", size=" + d.this.cGU);
                    }
                }
            }, "SwanAppBatchDownloadCallback");
        }
        if (this.cGT != null) {
            this.cGT.anG();
        }
        com.baidu.swan.apps.env.e.aqH().aqI().a((Set<String>) null, com.baidu.swan.apps.env.c.c.arm().il(7).arn());
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0546a> anM() {
        return this.cGV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable final PMSAppInfo pMSAppInfo, @Nullable final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pMSAppInfo2 != null) {
                        pMSAppInfo2.mH(d.this.aoc());
                        pMSAppInfo.u(pMSAppInfo2);
                    } else {
                        pMSAppInfo.mH(d.this.aoc());
                    }
                    pMSAppInfo.aYS();
                    if (com.baidu.swan.pms.database.a.aYH().r(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.g(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(a.C0546a c0546a) {
        if (c0546a == null || c0546a.ecG == null || c0546a.ecI == null) {
            return false;
        }
        if (!ae.e(new File(c0546a.ecG.filePath), c0546a.ecG.sign)) {
            com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        com.baidu.swan.apps.am.a a2 = com.baidu.swan.apps.core.pms.f.a.a(c0546a.ecG, this);
        if (a2 != null) {
            com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a2);
            return false;
        }
        c0546a.ecI.aYS();
        com.baidu.swan.apps.core.pms.f.a.a(c0546a.ecI, c0546a.ecG);
        c0546a.ecI.mH(aoc());
        if (!com.baidu.swan.pms.database.a.aYH().a(c0546a.ecG, c0546a.ecI)) {
            com.baidu.swan.apps.console.c.bn("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.cGS.g(c0546a.ecG);
        if (!c0546a.ecJ) {
            com.baidu.swan.apps.core.pms.f.a.g(c0546a.ecI);
        }
        com.baidu.swan.apps.core.pms.f.a.b(c0546a.ecG);
        return true;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> anN() {
        return this.cGW;
    }
}
