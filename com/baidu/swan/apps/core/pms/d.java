package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.ae;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
/* loaded from: classes9.dex */
public class d extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.utils.f cWR;
    private a cWS;
    private final List<com.baidu.swan.pms.model.g> cWT;
    private com.baidu.swan.pms.a.a<a.C0559a> cWU;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cWV;

    public d() {
        this(null);
    }

    public d(a aVar) {
        this.cWU = new com.baidu.swan.pms.a.a<a.C0559a>() { // from class: com.baidu.swan.apps.core.pms.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.c
            /* renamed from: c */
            public String U(a.C0559a c0559a) {
                if (c0559a == null) {
                    return null;
                }
                if (c0559a.category == 0) {
                    return com.baidu.swan.apps.core.pms.f.a.auA();
                }
                if (c0559a.category == 1) {
                    return com.baidu.swan.apps.core.pms.f.a.auB();
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
            public void a(a.C0559a c0559a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar2) {
                com.baidu.swan.apps.console.c.bs("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar2.errorNo + ",msg: " + aVar2.errorMsg);
                if (d.this.cWS != null) {
                    d.this.cWS.a(aVar2);
                }
                if (aVar2 != null && aVar2.errorNo == 1010) {
                    PMSAppInfo pMSAppInfo2 = c0559a == null ? null : c0559a.exC;
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    d.this.a(pMSAppInfo2, pMSAppInfo);
                    if (com.baidu.swan.apps.core.pms.d.a.c(aVar2)) {
                        com.baidu.swan.apps.core.pms.d.a.nK(pMSAppInfo2.appId);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: d */
            public void S(a.C0559a c0559a) {
                super.S(c0559a);
                com.baidu.swan.apps.console.c.bs("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0559a.ewI);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: e */
            public void T(a.C0559a c0559a) {
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0559a.ewI);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: f */
            public void R(a.C0559a c0559a) {
                super.R(c0559a);
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0559a.exA.currentSize + "/" + c0559a.exA.size);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            public void a(a.C0559a c0559a, com.baidu.swan.pms.model.a aVar2) {
                super.a((AnonymousClass2) c0559a, aVar2);
                com.baidu.swan.apps.console.c.bs("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar2.toString());
                com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(11L).cW(aVar2.errorNo).ux("批量下载，主包下载失败：" + c0559a.ewI).uz(aVar2.toString());
                if (c0559a.errorCode != 0) {
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + uz.toString());
                    }
                } else if (c0559a.exA != null) {
                    d.this.cWR.f(c0559a.exA);
                    c.aub().a(c0559a.exA, PMSDownloadType.BATCH, uz);
                    com.baidu.swan.c.d.deleteFile(c0559a.exA.filePath);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: g */
            public void Q(final a.C0559a c0559a) {
                super.Q(c0559a);
                com.baidu.swan.apps.console.c.bs("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0559a.exA.versionCode);
                p.a(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b(c0559a)) {
                            if (d.this.cWS != null) {
                                d.this.cWS.a(c0559a);
                            }
                            com.baidu.swan.apps.core.pms.d.a.nK(c0559a.exC.appId);
                        }
                    }
                }, c0559a.exA.ewI + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        };
        this.cWV = new k<d>(this) { // from class: com.baidu.swan.apps.core.pms.d.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.swan.apps.core.pms.k
            public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.al.a aVar2) {
                super.a(gVar, aVar2);
                if (aVar2 == null) {
                    d.this.cWT.add(gVar);
                } else if (d.DEBUG) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + ", " + aVar2);
                }
            }
        };
        this.cWS = aVar;
        this.cWT = new Vector();
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aud() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void arf() {
        super.arf();
        com.baidu.swan.apps.console.c.bs("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // com.baidu.swan.pms.a.g
    public void aue() {
        super.aue();
        com.baidu.swan.apps.console.c.bs("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bs("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        if (this.cWS != null) {
            this.cWS.iw(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void ard() {
        super.ard();
        com.baidu.swan.apps.console.c.bs("SwanAppBatchDownloadCallback", "onNoPackage");
        if (this.cWS != null) {
            this.cWS.ard();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cWR = fVar;
        com.baidu.swan.apps.console.c.bs("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.bhs());
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void atZ() {
        super.atZ();
        com.baidu.swan.apps.console.c.bs("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.cWT.isEmpty()) {
            p.a(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean a2 = com.baidu.swan.pms.database.a.bgc().a(null, d.this.cWT, null, null, null);
                    if (a2 && d.this.cWS != null) {
                        for (com.baidu.swan.pms.model.g gVar : d.this.cWT) {
                            d.this.cWS.a(gVar);
                        }
                    }
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + a2 + ", size=" + d.this.cWT);
                    }
                }
            }, "SwanAppBatchDownloadCallback");
        }
        if (this.cWS != null) {
            this.cWS.atZ();
        }
        com.baidu.swan.apps.env.e.axb().axc().a((Set<String>) null, com.baidu.swan.apps.env.c.c.axG().iK(7).axH());
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0559a> auf() {
        return this.cWU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable final PMSAppInfo pMSAppInfo, @Nullable final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null) {
            p.a(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pMSAppInfo2 != null) {
                        pMSAppInfo2.nu(d.this.auv());
                        pMSAppInfo.u(pMSAppInfo2);
                    } else {
                        pMSAppInfo.nu(d.this.auv());
                    }
                    pMSAppInfo.bgn();
                    if (com.baidu.swan.pms.database.a.bgc().r(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.g(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(a.C0559a c0559a) {
        if (c0559a == null || c0559a.exA == null || c0559a.exC == null) {
            return false;
        }
        if (!ae.f(new File(c0559a.exA.filePath), c0559a.exA.sign)) {
            com.baidu.swan.apps.console.c.bs("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        com.baidu.swan.apps.al.a a2 = com.baidu.swan.apps.core.pms.f.a.a(c0559a.exA, this);
        if (a2 != null) {
            com.baidu.swan.apps.console.c.bs("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a2);
            return false;
        }
        c0559a.exC.bgn();
        com.baidu.swan.apps.core.pms.f.a.a(c0559a.exC, c0559a.exA);
        c0559a.exC.nu(auv());
        if (!com.baidu.swan.pms.database.a.bgc().a(c0559a.exA, c0559a.exC)) {
            com.baidu.swan.apps.console.c.bs("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.cWR.g(c0559a.exA);
        if (!c0559a.exD) {
            com.baidu.swan.apps.core.pms.f.a.g(c0559a.exC);
        }
        com.baidu.swan.apps.core.pms.f.a.b(c0559a.exA);
        return true;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aug() {
        return this.cWV;
    }
}
