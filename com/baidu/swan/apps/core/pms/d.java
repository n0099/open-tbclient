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
    private com.baidu.swan.pms.utils.f cUs;
    private a cUt;
    private final List<com.baidu.swan.pms.model.g> cUu;
    private com.baidu.swan.pms.a.a<a.C0539a> cUv;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cUw;

    public d() {
        this(null);
    }

    public d(a aVar) {
        this.cUv = new com.baidu.swan.pms.a.a<a.C0539a>() { // from class: com.baidu.swan.apps.core.pms.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.c
            /* renamed from: c */
            public String U(a.C0539a c0539a) {
                if (c0539a == null) {
                    return null;
                }
                if (c0539a.category == 0) {
                    return com.baidu.swan.apps.core.pms.f.a.ard();
                }
                if (c0539a.category == 1) {
                    return com.baidu.swan.apps.core.pms.f.a.are();
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
            public void a(a.C0539a c0539a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar2) {
                com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar2.errorNo + ",msg: " + aVar2.errorMsg);
                if (d.this.cUt != null) {
                    d.this.cUt.a(aVar2);
                }
                if (aVar2 != null && aVar2.errorNo == 1010) {
                    PMSAppInfo pMSAppInfo2 = c0539a == null ? null : c0539a.euV;
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    d.this.a(pMSAppInfo2, pMSAppInfo);
                    if (com.baidu.swan.apps.core.pms.d.a.c(aVar2)) {
                        com.baidu.swan.apps.core.pms.d.a.mR(pMSAppInfo2.appId);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: d */
            public void S(a.C0539a c0539a) {
                super.S(c0539a);
                com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0539a.euc);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: e */
            public void T(a.C0539a c0539a) {
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0539a.euc);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: f */
            public void R(a.C0539a c0539a) {
                super.R(c0539a);
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0539a.euT.currentSize + "/" + c0539a.euT.size);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            public void a(a.C0539a c0539a, com.baidu.swan.pms.model.a aVar2) {
                super.a((AnonymousClass2) c0539a, aVar2);
                com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar2.toString());
                com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(11L).dc(aVar2.errorNo).tF("批量下载，主包下载失败：" + c0539a.euc).tH(aVar2.toString());
                if (c0539a.errorCode != 0) {
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + tH.toString());
                    }
                } else if (c0539a.euT != null) {
                    d.this.cUs.f(c0539a.euT);
                    c.aqE().a(c0539a.euT, PMSDownloadType.BATCH, tH);
                    com.baidu.swan.c.d.deleteFile(c0539a.euT.filePath);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: g */
            public void Q(final a.C0539a c0539a) {
                super.Q(c0539a);
                com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0539a.euT.versionCode);
                p.a(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b(c0539a)) {
                            if (d.this.cUt != null) {
                                d.this.cUt.a(c0539a);
                            }
                            com.baidu.swan.apps.core.pms.d.a.mR(c0539a.euV.appId);
                        }
                    }
                }, c0539a.euT.euc + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        };
        this.cUw = new k<d>(this) { // from class: com.baidu.swan.apps.core.pms.d.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.swan.apps.core.pms.k
            public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.al.a aVar2) {
                super.a(gVar, aVar2);
                if (aVar2 == null) {
                    d.this.cUu.add(gVar);
                } else if (d.DEBUG) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + ", " + aVar2);
                }
            }
        };
        this.cUt = aVar;
        this.cUu = new Vector();
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aqG() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void anI() {
        super.anI();
        com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqH() {
        super.aqH();
        com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        if (this.cUt != null) {
            this.cUt.gT(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void anG() {
        super.anG();
        com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onNoPackage");
        if (this.cUt != null) {
            this.cUt.anG();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cUs = fVar;
        com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.bdL());
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void aqC() {
        super.aqC();
        com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.cUu.isEmpty()) {
            p.a(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean a2 = com.baidu.swan.pms.database.a.bcv().a(null, d.this.cUu, null, null, null);
                    if (a2 && d.this.cUt != null) {
                        for (com.baidu.swan.pms.model.g gVar : d.this.cUu) {
                            d.this.cUt.a(gVar);
                        }
                    }
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + a2 + ", size=" + d.this.cUu);
                    }
                }
            }, "SwanAppBatchDownloadCallback");
        }
        if (this.cUt != null) {
            this.cUt.aqC();
        }
        com.baidu.swan.apps.env.e.atF().atG().a((Set<String>) null, com.baidu.swan.apps.env.c.c.auk().hh(7).aul());
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0539a> aqI() {
        return this.cUv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable final PMSAppInfo pMSAppInfo, @Nullable final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null) {
            p.a(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pMSAppInfo2 != null) {
                        pMSAppInfo2.lR(d.this.aqY());
                        pMSAppInfo.u(pMSAppInfo2);
                    } else {
                        pMSAppInfo.lR(d.this.aqY());
                    }
                    pMSAppInfo.bcG();
                    if (com.baidu.swan.pms.database.a.bcv().r(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.g(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(a.C0539a c0539a) {
        if (c0539a == null || c0539a.euT == null || c0539a.euV == null) {
            return false;
        }
        if (!ae.e(new File(c0539a.euT.filePath), c0539a.euT.sign)) {
            com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        com.baidu.swan.apps.al.a a2 = com.baidu.swan.apps.core.pms.f.a.a(c0539a.euT, this);
        if (a2 != null) {
            com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a2);
            return false;
        }
        c0539a.euV.bcG();
        com.baidu.swan.apps.core.pms.f.a.a(c0539a.euV, c0539a.euT);
        c0539a.euV.lR(aqY());
        if (!com.baidu.swan.pms.database.a.bcv().a(c0539a.euT, c0539a.euV)) {
            com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.cUs.g(c0539a.euT);
        if (!c0539a.euW) {
            com.baidu.swan.apps.core.pms.f.a.g(c0539a.euV);
        }
        com.baidu.swan.apps.core.pms.f.a.b(c0539a.euT);
        return true;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aqJ() {
        return this.cUw;
    }
}
