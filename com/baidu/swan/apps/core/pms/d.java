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
/* loaded from: classes8.dex */
public class d extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.utils.f cjZ;
    private a cka;
    private final List<com.baidu.swan.pms.model.g> ckb;
    private com.baidu.swan.pms.a.a<a.C0520a> ckc;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> ckd;

    public d() {
        this(null);
    }

    public d(a aVar) {
        this.ckc = new com.baidu.swan.pms.a.a<a.C0520a>() { // from class: com.baidu.swan.apps.core.pms.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.c
            /* renamed from: c */
            public String Q(a.C0520a c0520a) {
                if (c0520a == null) {
                    return null;
                }
                if (c0520a.category == 0) {
                    return com.baidu.swan.apps.core.pms.f.a.aiS();
                }
                if (c0520a.category == 1) {
                    return com.baidu.swan.apps.core.pms.f.a.aiT();
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
            public void a(a.C0520a c0520a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar2) {
                com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar2.errorNo + ",msg: " + aVar2.errorMsg);
                if (d.this.cka != null) {
                    d.this.cka.a(aVar2);
                }
                if (aVar2 != null && aVar2.errorNo == 1010) {
                    PMSAppInfo pMSAppInfo2 = c0520a == null ? null : c0520a.dGd;
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    d.this.a(pMSAppInfo2, pMSAppInfo);
                    if (com.baidu.swan.apps.core.pms.d.a.c(aVar2)) {
                        com.baidu.swan.apps.core.pms.d.a.lC(pMSAppInfo2.appId);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: d */
            public void O(a.C0520a c0520a) {
                super.O(c0520a);
                com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0520a.dFj);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: e */
            public void P(a.C0520a c0520a) {
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0520a.dFj);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: f */
            public void N(a.C0520a c0520a) {
                super.N(c0520a);
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0520a.dGb.currentSize + "/" + c0520a.dGb.size);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            public void a(a.C0520a c0520a, com.baidu.swan.pms.model.a aVar2) {
                super.a((AnonymousClass2) c0520a, aVar2);
                com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar2.toString());
                com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(11L).bP(aVar2.errorNo).sk("批量下载，主包下载失败：" + c0520a.dFj).sm(aVar2.toString());
                if (c0520a.errorCode != 0) {
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + sm.toString());
                    }
                } else if (c0520a.dGb != null) {
                    d.this.cjZ.f(c0520a.dGb);
                    c.ait().a(c0520a.dGb, PMSDownloadType.BATCH, sm);
                    com.baidu.swan.c.d.deleteFile(c0520a.dGb.filePath);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: g */
            public void M(final a.C0520a c0520a) {
                super.M(c0520a);
                com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0520a.dGb.versionCode);
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b(c0520a)) {
                            if (d.this.cka != null) {
                                d.this.cka.a(c0520a);
                            }
                            com.baidu.swan.apps.core.pms.d.a.lC(c0520a.dGd.appId);
                        }
                    }
                }, c0520a.dGb.dFj + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        };
        this.ckd = new k<d>(this) { // from class: com.baidu.swan.apps.core.pms.d.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.swan.apps.core.pms.k
            public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar2) {
                super.a(gVar, aVar2);
                if (aVar2 == null) {
                    d.this.ckb.add(gVar);
                } else if (d.DEBUG) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + ", " + aVar2);
                }
            }
        };
        this.cka = aVar;
        this.ckb = new Vector();
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aiv() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void afD() {
        super.afD();
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiw() {
        super.aiw();
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        if (this.cka != null) {
            this.cka.hg(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void afB() {
        super.afB();
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onNoPackage");
        if (this.cka != null) {
            this.cka.afB();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cjZ = fVar;
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.aUK());
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void air() {
        super.air();
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.ckb.isEmpty()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean a = com.baidu.swan.pms.database.a.aTt().a(null, d.this.ckb, null, null, null);
                    if (a && d.this.cka != null) {
                        for (com.baidu.swan.pms.model.g gVar : d.this.ckb) {
                            d.this.cka.a(gVar);
                        }
                    }
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + a + ", size=" + d.this.ckb);
                    }
                }
            }, "SwanAppBatchDownloadCallback");
        }
        if (this.cka != null) {
            this.cka.air();
        }
        com.baidu.swan.apps.env.e.alr().als().a((Set<String>) null, com.baidu.swan.apps.env.c.c.alW().hu(7).alX());
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0520a> aix() {
        return this.ckc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable final PMSAppInfo pMSAppInfo, @Nullable final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pMSAppInfo2 != null) {
                        pMSAppInfo2.lO(d.this.aiN());
                        pMSAppInfo.u(pMSAppInfo2);
                    } else {
                        pMSAppInfo.lO(d.this.aiN());
                    }
                    pMSAppInfo.aTE();
                    if (com.baidu.swan.pms.database.a.aTt().r(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.g(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(a.C0520a c0520a) {
        if (c0520a == null || c0520a.dGb == null || c0520a.dGd == null) {
            return false;
        }
        if (!ae.e(new File(c0520a.dGb.filePath), c0520a.dGb.sign)) {
            com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        com.baidu.swan.apps.am.a a = com.baidu.swan.apps.core.pms.f.a.a(c0520a.dGb, this);
        if (a != null) {
            com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a);
            return false;
        }
        c0520a.dGd.aTE();
        com.baidu.swan.apps.core.pms.f.a.a(c0520a.dGd, c0520a.dGb);
        c0520a.dGd.lO(aiN());
        if (!com.baidu.swan.pms.database.a.aTt().a(c0520a.dGb, c0520a.dGd)) {
            com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.cjZ.g(c0520a.dGb);
        if (!c0520a.dGe) {
            com.baidu.swan.apps.core.pms.f.a.g(c0520a.dGd);
        }
        com.baidu.swan.apps.core.pms.f.a.b(c0520a.dGb);
        return true;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aiy() {
        return this.ckd;
    }
}
