package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.aq.ae;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
/* loaded from: classes7.dex */
public class d extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.f.f cdJ;
    private a cdK;
    private final List<com.baidu.swan.pms.model.g> cdL;
    private com.baidu.swan.pms.a.a<a.C0474a> cdM;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cdN;

    public d() {
        this(null);
    }

    public d(a aVar) {
        this.cdM = new com.baidu.swan.pms.a.a<a.C0474a>() { // from class: com.baidu.swan.apps.core.pms.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.c
            /* renamed from: c */
            public String P(a.C0474a c0474a) {
                if (c0474a == null) {
                    return null;
                }
                if (c0474a.category == 0) {
                    return com.baidu.swan.apps.core.pms.f.a.act();
                }
                if (c0474a.category == 1) {
                    return com.baidu.swan.apps.core.pms.f.a.acu();
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
            public void a(a.C0474a c0474a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar2) {
                com.baidu.swan.apps.console.c.aW("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar2.errorNo + ",msg: " + aVar2.errorMsg);
                if (d.this.cdK != null) {
                    d.this.cdK.a(aVar2);
                }
                if (aVar2 != null && aVar2.errorNo == 1010) {
                    PMSAppInfo pMSAppInfo2 = c0474a == null ? null : c0474a.dwY;
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    d.this.a(pMSAppInfo2, pMSAppInfo);
                    if (com.baidu.swan.apps.core.pms.d.a.c(aVar2)) {
                        com.baidu.swan.apps.core.pms.d.a.jY(pMSAppInfo2.appId);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: d */
            public void N(a.C0474a c0474a) {
                super.N(c0474a);
                com.baidu.swan.apps.console.c.aW("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0474a.dvZ);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: e */
            public void O(a.C0474a c0474a) {
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0474a.dvZ);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: f */
            public void M(a.C0474a c0474a) {
                super.M(c0474a);
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0474a.dwW.currentSize + "/" + c0474a.dwW.size);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            public void a(a.C0474a c0474a, com.baidu.swan.pms.model.a aVar2) {
                super.a((AnonymousClass2) c0474a, aVar2);
                com.baidu.swan.apps.console.c.aW("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar2.toString());
                com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(11L).bK(aVar2.errorNo).qk("批量下载，主包下载失败：" + c0474a.dvZ).qm(aVar2.toString());
                if (c0474a.errorCode != 0) {
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + qm.toString());
                    }
                } else if (c0474a.dwW != null) {
                    d.this.cdJ.f(c0474a.dwW);
                    c.abU().a(c0474a.dwW, PMSDownloadType.BATCH, qm);
                    com.baidu.swan.d.d.deleteFile(c0474a.dwW.filePath);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: g */
            public void L(final a.C0474a c0474a) {
                super.L(c0474a);
                com.baidu.swan.apps.console.c.aW("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0474a.dwW.versionCode);
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b(c0474a)) {
                            if (d.this.cdK != null) {
                                d.this.cdK.a(c0474a);
                            }
                            com.baidu.swan.apps.core.pms.d.a.jY(c0474a.dwY.appId);
                        }
                    }
                }, c0474a.dwW.dvZ + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        };
        this.cdN = new k<d>(this) { // from class: com.baidu.swan.apps.core.pms.d.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.swan.apps.core.pms.k
            public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.an.a aVar2) {
                super.a(gVar, aVar2);
                if (aVar2 == null) {
                    d.this.cdL.add(gVar);
                } else if (d.DEBUG) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + ", " + aVar2);
                }
            }
        };
        this.cdK = aVar;
        this.cdL = new Vector();
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int abW() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Zu() {
        super.Zu();
        com.baidu.swan.apps.console.c.aW("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // com.baidu.swan.pms.a.g
    public void abX() {
        super.abX();
        com.baidu.swan.apps.console.c.aW("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.aW("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        if (this.cdK != null) {
            this.cdK.fk(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void Zs() {
        super.Zs();
        com.baidu.swan.apps.console.c.aW("SwanAppBatchDownloadCallback", "onNoPackage");
        if (this.cdK != null) {
            this.cdK.Zs();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.f fVar) {
        super.a(fVar);
        this.cdJ = fVar;
        com.baidu.swan.apps.console.c.aW("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.aMl());
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void abS() {
        super.abS();
        com.baidu.swan.apps.console.c.aW("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.cdL.isEmpty()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean a = com.baidu.swan.pms.database.a.aKS().a(null, d.this.cdL, null, null, null);
                    if (a && d.this.cdK != null) {
                        for (com.baidu.swan.pms.model.g gVar : d.this.cdL) {
                            d.this.cdK.a(gVar);
                        }
                    }
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + a + ", size=" + d.this.cdL);
                    }
                }
            }, "SwanAppBatchDownloadCallback");
        }
        if (this.cdK != null) {
            this.cdK.abS();
        }
        com.baidu.swan.apps.env.e.aeI().aeJ().a((Set<String>) null, com.baidu.swan.apps.env.b.c.aeQ().fx(7).aeR());
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0474a> abY() {
        return this.cdM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable final PMSAppInfo pMSAppInfo, @Nullable final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pMSAppInfo2 != null) {
                        pMSAppInfo2.jG(d.this.aco());
                        pMSAppInfo.u(pMSAppInfo2);
                    } else {
                        pMSAppInfo.jG(d.this.aco());
                    }
                    pMSAppInfo.aLg();
                    if (com.baidu.swan.pms.database.a.aKS().r(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.g(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(a.C0474a c0474a) {
        if (c0474a == null || c0474a.dwW == null || c0474a.dwY == null) {
            return false;
        }
        if (!ae.e(new File(c0474a.dwW.filePath), c0474a.dwW.sign)) {
            com.baidu.swan.apps.console.c.aW("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        com.baidu.swan.apps.an.a a = com.baidu.swan.apps.core.pms.f.a.a(c0474a.dwW, this);
        if (a != null) {
            com.baidu.swan.apps.console.c.aW("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a);
            return false;
        }
        c0474a.dwY.aLg();
        com.baidu.swan.apps.core.pms.f.a.a(c0474a.dwY, c0474a.dwW);
        c0474a.dwY.jG(aco());
        if (!com.baidu.swan.pms.database.a.aKS().a(c0474a.dwW, c0474a.dwY)) {
            com.baidu.swan.apps.console.c.aW("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.cdJ.g(c0474a.dwW);
        if (!c0474a.dwZ) {
            com.baidu.swan.apps.core.pms.f.a.g(c0474a.dwY);
        }
        com.baidu.swan.apps.core.pms.f.a.b(c0474a.dwW);
        return true;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> abZ() {
        return this.cdN;
    }
}
