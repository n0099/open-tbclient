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
/* loaded from: classes25.dex */
public class d extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.utils.f cRU;
    private a cRV;
    private final List<com.baidu.swan.pms.model.g> cRW;
    private com.baidu.swan.pms.a.a<a.C0568a> cRX;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cRY;

    public d() {
        this(null);
    }

    public d(a aVar) {
        this.cRX = new com.baidu.swan.pms.a.a<a.C0568a>() { // from class: com.baidu.swan.apps.core.pms.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.c
            /* renamed from: c */
            public String U(a.C0568a c0568a) {
                if (c0568a == null) {
                    return null;
                }
                if (c0568a.category == 0) {
                    return com.baidu.swan.apps.core.pms.f.a.ati();
                }
                if (c0568a.category == 1) {
                    return com.baidu.swan.apps.core.pms.f.a.atj();
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
            public void a(a.C0568a c0568a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar2) {
                com.baidu.swan.apps.console.c.bt("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar2.errorNo + ",msg: " + aVar2.errorMsg);
                if (d.this.cRV != null) {
                    d.this.cRV.a(aVar2);
                }
                if (aVar2 != null && aVar2.errorNo == 1010) {
                    PMSAppInfo pMSAppInfo2 = c0568a == null ? null : c0568a.enU;
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    d.this.a(pMSAppInfo2, pMSAppInfo);
                    if (com.baidu.swan.apps.core.pms.d.a.c(aVar2)) {
                        com.baidu.swan.apps.core.pms.d.a.nR(pMSAppInfo2.appId);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: d */
            public void S(a.C0568a c0568a) {
                super.S(c0568a);
                com.baidu.swan.apps.console.c.bt("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0568a.emZ);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: e */
            public void T(a.C0568a c0568a) {
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0568a.emZ);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: f */
            public void R(a.C0568a c0568a) {
                super.R(c0568a);
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0568a.enS.currentSize + "/" + c0568a.enS.size);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            public void a(a.C0568a c0568a, com.baidu.swan.pms.model.a aVar2) {
                super.a((AnonymousClass2) c0568a, aVar2);
                com.baidu.swan.apps.console.c.bt("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar2.toString());
                com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(11L).cV(aVar2.errorNo).uA("批量下载，主包下载失败：" + c0568a.emZ).uC(aVar2.toString());
                if (c0568a.errorCode != 0) {
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + uC.toString());
                    }
                } else if (c0568a.enS != null) {
                    d.this.cRU.f(c0568a.enS);
                    c.asJ().a(c0568a.enS, PMSDownloadType.BATCH, uC);
                    com.baidu.swan.c.d.deleteFile(c0568a.enS.filePath);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: g */
            public void Q(final a.C0568a c0568a) {
                super.Q(c0568a);
                com.baidu.swan.apps.console.c.bt("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0568a.enS.versionCode);
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b(c0568a)) {
                            if (d.this.cRV != null) {
                                d.this.cRV.a(c0568a);
                            }
                            com.baidu.swan.apps.core.pms.d.a.nR(c0568a.enU.appId);
                        }
                    }
                }, c0568a.enS.emZ + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        };
        this.cRY = new k<d>(this) { // from class: com.baidu.swan.apps.core.pms.d.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.swan.apps.core.pms.k
            public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar2) {
                super.a(gVar, aVar2);
                if (aVar2 == null) {
                    d.this.cRW.add(gVar);
                } else if (d.DEBUG) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + ", " + aVar2);
                }
            }
        };
        this.cRV = aVar;
        this.cRW = new Vector();
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int asL() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void apS() {
        super.apS();
        com.baidu.swan.apps.console.c.bt("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // com.baidu.swan.pms.a.g
    public void asM() {
        super.asM();
        com.baidu.swan.apps.console.c.bt("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bt("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        if (this.cRV != null) {
            this.cRV.iB(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void apQ() {
        super.apQ();
        com.baidu.swan.apps.console.c.bt("SwanAppBatchDownloadCallback", "onNoPackage");
        if (this.cRV != null) {
            this.cRV.apQ();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cRU = fVar;
        com.baidu.swan.apps.console.c.bt("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.beW());
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void asH() {
        super.asH();
        com.baidu.swan.apps.console.c.bt("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.cRW.isEmpty()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean a2 = com.baidu.swan.pms.database.a.bdF().a(null, d.this.cRW, null, null, null);
                    if (a2 && d.this.cRV != null) {
                        for (com.baidu.swan.pms.model.g gVar : d.this.cRW) {
                            d.this.cRV.a(gVar);
                        }
                    }
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + a2 + ", size=" + d.this.cRW);
                    }
                }
            }, "SwanAppBatchDownloadCallback");
        }
        if (this.cRV != null) {
            this.cRV.asH();
        }
        com.baidu.swan.apps.env.e.avI().avJ().a((Set<String>) null, com.baidu.swan.apps.env.c.c.awn().iP(7).awo());
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0568a> asN() {
        return this.cRX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable final PMSAppInfo pMSAppInfo, @Nullable final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pMSAppInfo2 != null) {
                        pMSAppInfo2.nl(d.this.atd());
                        pMSAppInfo.u(pMSAppInfo2);
                    } else {
                        pMSAppInfo.nl(d.this.atd());
                    }
                    pMSAppInfo.bdQ();
                    if (com.baidu.swan.pms.database.a.bdF().r(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.g(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(a.C0568a c0568a) {
        if (c0568a == null || c0568a.enS == null || c0568a.enU == null) {
            return false;
        }
        if (!ae.e(new File(c0568a.enS.filePath), c0568a.enS.sign)) {
            com.baidu.swan.apps.console.c.bt("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        com.baidu.swan.apps.am.a a2 = com.baidu.swan.apps.core.pms.f.a.a(c0568a.enS, this);
        if (a2 != null) {
            com.baidu.swan.apps.console.c.bt("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a2);
            return false;
        }
        c0568a.enU.bdQ();
        com.baidu.swan.apps.core.pms.f.a.a(c0568a.enU, c0568a.enS);
        c0568a.enU.nl(atd());
        if (!com.baidu.swan.pms.database.a.bdF().a(c0568a.enS, c0568a.enU)) {
            com.baidu.swan.apps.console.c.bt("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.cRU.g(c0568a.enS);
        if (!c0568a.enV) {
            com.baidu.swan.apps.core.pms.f.a.g(c0568a.enU);
        }
        com.baidu.swan.apps.core.pms.f.a.b(c0568a.enS);
        return true;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> asO() {
        return this.cRY;
    }
}
