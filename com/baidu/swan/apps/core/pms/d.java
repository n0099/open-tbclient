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
/* loaded from: classes8.dex */
public class d extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.utils.f cSf;
    private a cSg;
    private final List<com.baidu.swan.pms.model.g> cSh;
    private com.baidu.swan.pms.a.a<a.C0542a> cSi;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cSj;

    public d() {
        this(null);
    }

    public d(a aVar) {
        this.cSi = new com.baidu.swan.pms.a.a<a.C0542a>() { // from class: com.baidu.swan.apps.core.pms.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.c
            /* renamed from: c */
            public String U(a.C0542a c0542a) {
                if (c0542a == null) {
                    return null;
                }
                if (c0542a.category == 0) {
                    return com.baidu.swan.apps.core.pms.f.a.aqF();
                }
                if (c0542a.category == 1) {
                    return com.baidu.swan.apps.core.pms.f.a.aqG();
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
            public void a(a.C0542a c0542a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar2) {
                com.baidu.swan.apps.console.c.br("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar2.errorNo + ",msg: " + aVar2.errorMsg);
                if (d.this.cSg != null) {
                    d.this.cSg.a(aVar2);
                }
                if (aVar2 != null && aVar2.errorNo == 1010) {
                    PMSAppInfo pMSAppInfo2 = c0542a == null ? null : c0542a.esO;
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    d.this.a(pMSAppInfo2, pMSAppInfo);
                    if (com.baidu.swan.apps.core.pms.d.a.c(aVar2)) {
                        com.baidu.swan.apps.core.pms.d.a.mz(pMSAppInfo2.appId);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: d */
            public void S(a.C0542a c0542a) {
                super.S(c0542a);
                com.baidu.swan.apps.console.c.br("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0542a.erV);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: e */
            public void T(a.C0542a c0542a) {
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0542a.erV);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: f */
            public void R(a.C0542a c0542a) {
                super.R(c0542a);
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0542a.esM.currentSize + "/" + c0542a.esM.size);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            public void a(a.C0542a c0542a, com.baidu.swan.pms.model.a aVar2) {
                super.a((AnonymousClass2) c0542a, aVar2);
                com.baidu.swan.apps.console.c.br("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar2.toString());
                com.baidu.swan.apps.al.a aVar3 = new com.baidu.swan.apps.al.a().cV(11L).cW(aVar2.errorNo).tm("批量下载，主包下载失败：" + c0542a.erV).to(aVar2.toString());
                if (c0542a.errorCode != 0) {
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + aVar3.toString());
                    }
                } else if (c0542a.esM != null) {
                    d.this.cSf.f(c0542a.esM);
                    c.aqg().a(c0542a.esM, PMSDownloadType.BATCH, aVar3);
                    com.baidu.swan.c.d.deleteFile(c0542a.esM.filePath);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: g */
            public void Q(final a.C0542a c0542a) {
                super.Q(c0542a);
                com.baidu.swan.apps.console.c.br("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0542a.esM.versionCode);
                p.a(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b(c0542a)) {
                            if (d.this.cSg != null) {
                                d.this.cSg.a(c0542a);
                            }
                            com.baidu.swan.apps.core.pms.d.a.mz(c0542a.esO.appId);
                        }
                    }
                }, c0542a.esM.erV + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        };
        this.cSj = new k<d>(this) { // from class: com.baidu.swan.apps.core.pms.d.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.swan.apps.core.pms.k
            public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.al.a aVar2) {
                super.a(gVar, aVar2);
                if (aVar2 == null) {
                    d.this.cSh.add(gVar);
                } else if (d.DEBUG) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + ", " + aVar2);
                }
            }
        };
        this.cSg = aVar;
        this.cSh = new Vector();
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aqi() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ank() {
        super.ank();
        com.baidu.swan.apps.console.c.br("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqj() {
        super.aqj();
        com.baidu.swan.apps.console.c.br("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.br("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        if (this.cSg != null) {
            this.cSg.gQ(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void ani() {
        super.ani();
        com.baidu.swan.apps.console.c.br("SwanAppBatchDownloadCallback", "onNoPackage");
        if (this.cSg != null) {
            this.cSg.ani();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cSf = fVar;
        com.baidu.swan.apps.console.c.br("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.bdy());
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void aqe() {
        super.aqe();
        com.baidu.swan.apps.console.c.br("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.cSh.isEmpty()) {
            p.a(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean a2 = com.baidu.swan.pms.database.a.bci().a(null, d.this.cSh, null, null, null);
                    if (a2 && d.this.cSg != null) {
                        for (com.baidu.swan.pms.model.g gVar : d.this.cSh) {
                            d.this.cSg.a(gVar);
                        }
                    }
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + a2 + ", size=" + d.this.cSh);
                    }
                }
            }, "SwanAppBatchDownloadCallback");
        }
        if (this.cSg != null) {
            this.cSg.aqe();
        }
        com.baidu.swan.apps.env.e.ath().ati().a((Set<String>) null, com.baidu.swan.apps.env.c.c.atM().he(7).atN());
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0542a> aqk() {
        return this.cSi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable final PMSAppInfo pMSAppInfo, @Nullable final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null) {
            p.a(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pMSAppInfo2 != null) {
                        pMSAppInfo2.lO(d.this.aqA());
                        pMSAppInfo.u(pMSAppInfo2);
                    } else {
                        pMSAppInfo.lO(d.this.aqA());
                    }
                    pMSAppInfo.bct();
                    if (com.baidu.swan.pms.database.a.bci().r(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.g(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(a.C0542a c0542a) {
        if (c0542a == null || c0542a.esM == null || c0542a.esO == null) {
            return false;
        }
        if (!ae.f(new File(c0542a.esM.filePath), c0542a.esM.sign)) {
            com.baidu.swan.apps.console.c.br("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        com.baidu.swan.apps.al.a a2 = com.baidu.swan.apps.core.pms.f.a.a(c0542a.esM, this);
        if (a2 != null) {
            com.baidu.swan.apps.console.c.br("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a2);
            return false;
        }
        c0542a.esO.bct();
        com.baidu.swan.apps.core.pms.f.a.a(c0542a.esO, c0542a.esM);
        c0542a.esO.lO(aqA());
        if (!com.baidu.swan.pms.database.a.bci().a(c0542a.esM, c0542a.esO)) {
            com.baidu.swan.apps.console.c.br("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.cSf.g(c0542a.esM);
        if (!c0542a.esP) {
            com.baidu.swan.apps.core.pms.f.a.g(c0542a.esO);
        }
        com.baidu.swan.apps.core.pms.f.a.b(c0542a.esM);
        return true;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aql() {
        return this.cSj;
    }
}
