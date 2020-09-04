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
    private com.baidu.swan.pms.utils.f ckd;
    private a cke;
    private final List<com.baidu.swan.pms.model.g> ckf;
    private com.baidu.swan.pms.a.a<a.C0520a> ckg;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> ckh;

    public d() {
        this(null);
    }

    public d(a aVar) {
        this.ckg = new com.baidu.swan.pms.a.a<a.C0520a>() { // from class: com.baidu.swan.apps.core.pms.d.2
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
                if (d.this.cke != null) {
                    d.this.cke.a(aVar2);
                }
                if (aVar2 != null && aVar2.errorNo == 1010) {
                    PMSAppInfo pMSAppInfo2 = c0520a == null ? null : c0520a.dGh;
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    d.this.a(pMSAppInfo2, pMSAppInfo);
                    if (com.baidu.swan.apps.core.pms.d.a.c(aVar2)) {
                        com.baidu.swan.apps.core.pms.d.a.lD(pMSAppInfo2.appId);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: d */
            public void O(a.C0520a c0520a) {
                super.O(c0520a);
                com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0520a.dFn);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: e */
            public void P(a.C0520a c0520a) {
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0520a.dFn);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: f */
            public void N(a.C0520a c0520a) {
                super.N(c0520a);
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0520a.dGf.currentSize + "/" + c0520a.dGf.size);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            public void a(a.C0520a c0520a, com.baidu.swan.pms.model.a aVar2) {
                super.a((AnonymousClass2) c0520a, aVar2);
                com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar2.toString());
                com.baidu.swan.apps.am.a sn = new com.baidu.swan.apps.am.a().bO(11L).bP(aVar2.errorNo).sl("批量下载，主包下载失败：" + c0520a.dFn).sn(aVar2.toString());
                if (c0520a.errorCode != 0) {
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + sn.toString());
                    }
                } else if (c0520a.dGf != null) {
                    d.this.ckd.f(c0520a.dGf);
                    c.ait().a(c0520a.dGf, PMSDownloadType.BATCH, sn);
                    com.baidu.swan.c.d.deleteFile(c0520a.dGf.filePath);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: g */
            public void M(final a.C0520a c0520a) {
                super.M(c0520a);
                com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0520a.dGf.versionCode);
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b(c0520a)) {
                            if (d.this.cke != null) {
                                d.this.cke.a(c0520a);
                            }
                            com.baidu.swan.apps.core.pms.d.a.lD(c0520a.dGh.appId);
                        }
                    }
                }, c0520a.dGf.dFn + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        };
        this.ckh = new k<d>(this) { // from class: com.baidu.swan.apps.core.pms.d.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.swan.apps.core.pms.k
            public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar2) {
                super.a(gVar, aVar2);
                if (aVar2 == null) {
                    d.this.ckf.add(gVar);
                } else if (d.DEBUG) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + ", " + aVar2);
                }
            }
        };
        this.cke = aVar;
        this.ckf = new Vector();
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
        if (this.cke != null) {
            this.cke.hg(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void afB() {
        super.afB();
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onNoPackage");
        if (this.cke != null) {
            this.cke.afB();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.ckd = fVar;
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.aUK());
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void air() {
        super.air();
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.ckf.isEmpty()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean a = com.baidu.swan.pms.database.a.aTt().a(null, d.this.ckf, null, null, null);
                    if (a && d.this.cke != null) {
                        for (com.baidu.swan.pms.model.g gVar : d.this.ckf) {
                            d.this.cke.a(gVar);
                        }
                    }
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + a + ", size=" + d.this.ckf);
                    }
                }
            }, "SwanAppBatchDownloadCallback");
        }
        if (this.cke != null) {
            this.cke.air();
        }
        com.baidu.swan.apps.env.e.alr().als().a((Set<String>) null, com.baidu.swan.apps.env.c.c.alW().hu(7).alX());
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0520a> aix() {
        return this.ckg;
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
        if (c0520a == null || c0520a.dGf == null || c0520a.dGh == null) {
            return false;
        }
        if (!ae.e(new File(c0520a.dGf.filePath), c0520a.dGf.sign)) {
            com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        com.baidu.swan.apps.am.a a = com.baidu.swan.apps.core.pms.f.a.a(c0520a.dGf, this);
        if (a != null) {
            com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a);
            return false;
        }
        c0520a.dGh.aTE();
        com.baidu.swan.apps.core.pms.f.a.a(c0520a.dGh, c0520a.dGf);
        c0520a.dGh.lO(aiN());
        if (!com.baidu.swan.pms.database.a.aTt().a(c0520a.dGf, c0520a.dGh)) {
            com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.ckd.g(c0520a.dGf);
        if (!c0520a.dGi) {
            com.baidu.swan.apps.core.pms.f.a.g(c0520a.dGh);
        }
        com.baidu.swan.apps.core.pms.f.a.b(c0520a.dGf);
        return true;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aiy() {
        return this.ckh;
    }
}
