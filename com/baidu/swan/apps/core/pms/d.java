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
/* loaded from: classes7.dex */
public class d extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.utils.f cLb;
    private a cLc;
    private final List<com.baidu.swan.pms.model.g> cLd;
    private com.baidu.swan.pms.a.a<a.C0556a> cLe;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cLf;

    public d() {
        this(null);
    }

    public d(a aVar) {
        this.cLe = new com.baidu.swan.pms.a.a<a.C0556a>() { // from class: com.baidu.swan.apps.core.pms.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.c
            /* renamed from: c */
            public String U(a.C0556a c0556a) {
                if (c0556a == null) {
                    return null;
                }
                if (c0556a.category == 0) {
                    return com.baidu.swan.apps.core.pms.f.a.aqa();
                }
                if (c0556a.category == 1) {
                    return com.baidu.swan.apps.core.pms.f.a.aqb();
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
            public void a(a.C0556a c0556a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar2) {
                com.baidu.swan.apps.console.c.bm("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar2.errorNo + ",msg: " + aVar2.errorMsg);
                if (d.this.cLc != null) {
                    d.this.cLc.a(aVar2);
                }
                if (aVar2 != null && aVar2.errorNo == 1010) {
                    PMSAppInfo pMSAppInfo2 = c0556a == null ? null : c0556a.egT;
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    d.this.a(pMSAppInfo2, pMSAppInfo);
                    if (com.baidu.swan.apps.core.pms.d.a.c(aVar2)) {
                        com.baidu.swan.apps.core.pms.d.a.nk(pMSAppInfo2.appId);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: d */
            public void S(a.C0556a c0556a) {
                super.S(c0556a);
                com.baidu.swan.apps.console.c.bm("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0556a.efY);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: e */
            public void T(a.C0556a c0556a) {
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0556a.efY);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: f */
            public void R(a.C0556a c0556a) {
                super.R(c0556a);
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0556a.egR.currentSize + "/" + c0556a.egR.size);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            public void a(a.C0556a c0556a, com.baidu.swan.pms.model.a aVar2) {
                super.a((AnonymousClass2) c0556a, aVar2);
                com.baidu.swan.apps.console.c.bm("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar2.toString());
                com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(11L).cw(aVar2.errorNo).tT("批量下载，主包下载失败：" + c0556a.efY).tV(aVar2.toString());
                if (c0556a.errorCode != 0) {
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + tV.toString());
                    }
                } else if (c0556a.egR != null) {
                    d.this.cLb.f(c0556a.egR);
                    c.apB().a(c0556a.egR, PMSDownloadType.BATCH, tV);
                    com.baidu.swan.c.d.deleteFile(c0556a.egR.filePath);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: g */
            public void Q(final a.C0556a c0556a) {
                super.Q(c0556a);
                com.baidu.swan.apps.console.c.bm("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0556a.egR.versionCode);
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b(c0556a)) {
                            if (d.this.cLc != null) {
                                d.this.cLc.a(c0556a);
                            }
                            com.baidu.swan.apps.core.pms.d.a.nk(c0556a.egT.appId);
                        }
                    }
                }, c0556a.egR.efY + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        };
        this.cLf = new k<d>(this) { // from class: com.baidu.swan.apps.core.pms.d.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.swan.apps.core.pms.k
            public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar2) {
                super.a(gVar, aVar2);
                if (aVar2 == null) {
                    d.this.cLd.add(gVar);
                } else if (d.DEBUG) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + ", " + aVar2);
                }
            }
        };
        this.cLc = aVar;
        this.cLd = new Vector();
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int apD() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void amK() {
        super.amK();
        com.baidu.swan.apps.console.c.bm("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // com.baidu.swan.pms.a.g
    public void apE() {
        super.apE();
        com.baidu.swan.apps.console.c.bm("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bm("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        if (this.cLc != null) {
            this.cLc.id(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void amI() {
        super.amI();
        com.baidu.swan.apps.console.c.bm("SwanAppBatchDownloadCallback", "onNoPackage");
        if (this.cLc != null) {
            this.cLc.amI();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cLb = fVar;
        com.baidu.swan.apps.console.c.bm("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.bbR());
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void apz() {
        super.apz();
        com.baidu.swan.apps.console.c.bm("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.cLd.isEmpty()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean a2 = com.baidu.swan.pms.database.a.baA().a(null, d.this.cLd, null, null, null);
                    if (a2 && d.this.cLc != null) {
                        for (com.baidu.swan.pms.model.g gVar : d.this.cLd) {
                            d.this.cLc.a(gVar);
                        }
                    }
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + a2 + ", size=" + d.this.cLd);
                    }
                }
            }, "SwanAppBatchDownloadCallback");
        }
        if (this.cLc != null) {
            this.cLc.apz();
        }
        com.baidu.swan.apps.env.e.asA().asB().a((Set<String>) null, com.baidu.swan.apps.env.c.c.atf().ir(7).atg());
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0556a> apF() {
        return this.cLe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable final PMSAppInfo pMSAppInfo, @Nullable final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pMSAppInfo2 != null) {
                        pMSAppInfo2.mN(d.this.apV());
                        pMSAppInfo.u(pMSAppInfo2);
                    } else {
                        pMSAppInfo.mN(d.this.apV());
                    }
                    pMSAppInfo.baL();
                    if (com.baidu.swan.pms.database.a.baA().r(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.g(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(a.C0556a c0556a) {
        if (c0556a == null || c0556a.egR == null || c0556a.egT == null) {
            return false;
        }
        if (!ae.e(new File(c0556a.egR.filePath), c0556a.egR.sign)) {
            com.baidu.swan.apps.console.c.bm("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        com.baidu.swan.apps.am.a a2 = com.baidu.swan.apps.core.pms.f.a.a(c0556a.egR, this);
        if (a2 != null) {
            com.baidu.swan.apps.console.c.bm("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a2);
            return false;
        }
        c0556a.egT.baL();
        com.baidu.swan.apps.core.pms.f.a.a(c0556a.egT, c0556a.egR);
        c0556a.egT.mN(apV());
        if (!com.baidu.swan.pms.database.a.baA().a(c0556a.egR, c0556a.egT)) {
            com.baidu.swan.apps.console.c.bm("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.cLb.g(c0556a.egR);
        if (!c0556a.egU) {
            com.baidu.swan.apps.core.pms.f.a.g(c0556a.egT);
        }
        com.baidu.swan.apps.core.pms.f.a.b(c0556a.egR);
        return true;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> apG() {
        return this.cLf;
    }
}
