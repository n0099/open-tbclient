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
/* loaded from: classes3.dex */
public class d extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.utils.f cmf;
    private a cmg;
    private final List<com.baidu.swan.pms.model.g> cmh;
    private com.baidu.swan.pms.a.a<a.C0515a> cmi;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cmj;

    public d() {
        this(null);
    }

    public d(a aVar) {
        this.cmi = new com.baidu.swan.pms.a.a<a.C0515a>() { // from class: com.baidu.swan.apps.core.pms.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.c
            /* renamed from: c */
            public String R(a.C0515a c0515a) {
                if (c0515a == null) {
                    return null;
                }
                if (c0515a.category == 0) {
                    return com.baidu.swan.apps.core.pms.f.a.ajC();
                }
                if (c0515a.category == 1) {
                    return com.baidu.swan.apps.core.pms.f.a.ajD();
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
            public void a(a.C0515a c0515a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar2) {
                com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar2.errorNo + ",msg: " + aVar2.errorMsg);
                if (d.this.cmg != null) {
                    d.this.cmg.a(aVar2);
                }
                if (aVar2 != null && aVar2.errorNo == 1010) {
                    PMSAppInfo pMSAppInfo2 = c0515a == null ? null : c0515a.dIl;
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    d.this.a(pMSAppInfo2, pMSAppInfo);
                    if (com.baidu.swan.apps.core.pms.d.a.c(aVar2)) {
                        com.baidu.swan.apps.core.pms.d.a.lW(pMSAppInfo2.appId);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: d */
            public void P(a.C0515a c0515a) {
                super.P(c0515a);
                com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0515a.dHr);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: e */
            public void Q(a.C0515a c0515a) {
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0515a.dHr);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: f */
            public void O(a.C0515a c0515a) {
                super.O(c0515a);
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0515a.dIj.currentSize + "/" + c0515a.dIj.size);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            public void a(a.C0515a c0515a, com.baidu.swan.pms.model.a aVar2) {
                super.a((AnonymousClass2) c0515a, aVar2);
                com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar2.toString());
                com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(11L).bQ(aVar2.errorNo).sF("批量下载，主包下载失败：" + c0515a.dHr).sH(aVar2.toString());
                if (c0515a.errorCode != 0) {
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + sH.toString());
                    }
                } else if (c0515a.dIj != null) {
                    d.this.cmf.f(c0515a.dIj);
                    c.ajd().a(c0515a.dIj, PMSDownloadType.BATCH, sH);
                    com.baidu.swan.c.d.deleteFile(c0515a.dIj.filePath);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: g */
            public void N(final a.C0515a c0515a) {
                super.N(c0515a);
                com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0515a.dIj.versionCode);
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b(c0515a)) {
                            if (d.this.cmg != null) {
                                d.this.cmg.a(c0515a);
                            }
                            com.baidu.swan.apps.core.pms.d.a.lW(c0515a.dIl.appId);
                        }
                    }
                }, c0515a.dIj.dHr + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        };
        this.cmj = new k<d>(this) { // from class: com.baidu.swan.apps.core.pms.d.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.swan.apps.core.pms.k
            public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar2) {
                super.a(gVar, aVar2);
                if (aVar2 == null) {
                    d.this.cmh.add(gVar);
                } else if (d.DEBUG) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + ", " + aVar2);
                }
            }
        };
        this.cmg = aVar;
        this.cmh = new Vector();
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int ajf() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void agn() {
        super.agn();
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // com.baidu.swan.pms.a.g
    public void ajg() {
        super.ajg();
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        if (this.cmg != null) {
            this.cmg.hp(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void agl() {
        super.agl();
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onNoPackage");
        if (this.cmg != null) {
            this.cmg.agl();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cmf = fVar;
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.aVw());
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void ajb() {
        super.ajb();
        com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.cmh.isEmpty()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean a = com.baidu.swan.pms.database.a.aUf().a(null, d.this.cmh, null, null, null);
                    if (a && d.this.cmg != null) {
                        for (com.baidu.swan.pms.model.g gVar : d.this.cmh) {
                            d.this.cmg.a(gVar);
                        }
                    }
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + a + ", size=" + d.this.cmh);
                    }
                }
            }, "SwanAppBatchDownloadCallback");
        }
        if (this.cmg != null) {
            this.cmg.ajb();
        }
        com.baidu.swan.apps.env.e.amb().amc().a((Set<String>) null, com.baidu.swan.apps.env.c.c.amG().hD(7).amH());
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0515a> ajh() {
        return this.cmi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable final PMSAppInfo pMSAppInfo, @Nullable final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pMSAppInfo2 != null) {
                        pMSAppInfo2.lZ(d.this.ajx());
                        pMSAppInfo.u(pMSAppInfo2);
                    } else {
                        pMSAppInfo.lZ(d.this.ajx());
                    }
                    pMSAppInfo.aUq();
                    if (com.baidu.swan.pms.database.a.aUf().r(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.g(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(a.C0515a c0515a) {
        if (c0515a == null || c0515a.dIj == null || c0515a.dIl == null) {
            return false;
        }
        if (!ae.e(new File(c0515a.dIj.filePath), c0515a.dIj.sign)) {
            com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        com.baidu.swan.apps.am.a a = com.baidu.swan.apps.core.pms.f.a.a(c0515a.dIj, this);
        if (a != null) {
            com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a);
            return false;
        }
        c0515a.dIl.aUq();
        com.baidu.swan.apps.core.pms.f.a.a(c0515a.dIl, c0515a.dIj);
        c0515a.dIl.lZ(ajx());
        if (!com.baidu.swan.pms.database.a.aUf().a(c0515a.dIj, c0515a.dIl)) {
            com.baidu.swan.apps.console.c.bb("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.cmf.g(c0515a.dIj);
        if (!c0515a.dIm) {
            com.baidu.swan.apps.core.pms.f.a.g(c0515a.dIl);
        }
        com.baidu.swan.apps.core.pms.f.a.b(c0515a.dIj);
        return true;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aji() {
        return this.cmj;
    }
}
