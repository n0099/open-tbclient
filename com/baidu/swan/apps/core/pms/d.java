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
    private com.baidu.swan.pms.utils.f cVS;
    private a cVT;
    private final List<com.baidu.swan.pms.model.g> cVU;
    private com.baidu.swan.pms.a.a<a.C0545a> cVV;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cVW;

    public d() {
        this(null);
    }

    public d(a aVar) {
        this.cVV = new com.baidu.swan.pms.a.a<a.C0545a>() { // from class: com.baidu.swan.apps.core.pms.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.c
            /* renamed from: c */
            public String W(a.C0545a c0545a) {
                if (c0545a == null) {
                    return null;
                }
                if (c0545a.category == 0) {
                    return com.baidu.swan.apps.core.pms.f.a.arg();
                }
                if (c0545a.category == 1) {
                    return com.baidu.swan.apps.core.pms.f.a.arh();
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
            public void a(a.C0545a c0545a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar2) {
                com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar2.errorNo + ",msg: " + aVar2.errorMsg);
                if (d.this.cVT != null) {
                    d.this.cVT.a(aVar2);
                }
                if (aVar2 != null && aVar2.errorNo == 1010) {
                    PMSAppInfo pMSAppInfo2 = c0545a == null ? null : c0545a.eww;
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    d.this.a(pMSAppInfo2, pMSAppInfo);
                    if (com.baidu.swan.apps.core.pms.d.a.c(aVar2)) {
                        com.baidu.swan.apps.core.pms.d.a.mY(pMSAppInfo2.appId);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: d */
            public void U(a.C0545a c0545a) {
                super.U(c0545a);
                com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0545a.evD);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: e */
            public void V(a.C0545a c0545a) {
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0545a.evD);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: f */
            public void T(a.C0545a c0545a) {
                super.T(c0545a);
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0545a.ewu.currentSize + "/" + c0545a.ewu.size);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            public void a(a.C0545a c0545a, com.baidu.swan.pms.model.a aVar2) {
                super.a((AnonymousClass2) c0545a, aVar2);
                com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar2.toString());
                com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(11L).dc(aVar2.errorNo).tM("批量下载，主包下载失败：" + c0545a.evD).tO(aVar2.toString());
                if (c0545a.errorCode != 0) {
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + tO.toString());
                    }
                } else if (c0545a.ewu != null) {
                    d.this.cVS.f(c0545a.ewu);
                    c.aqH().a(c0545a.ewu, PMSDownloadType.BATCH, tO);
                    com.baidu.swan.c.d.deleteFile(c0545a.ewu.filePath);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: g */
            public void S(final a.C0545a c0545a) {
                super.S(c0545a);
                com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0545a.ewu.versionCode);
                p.a(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b(c0545a)) {
                            if (d.this.cVT != null) {
                                d.this.cVT.a(c0545a);
                            }
                            com.baidu.swan.apps.core.pms.d.a.mY(c0545a.eww.appId);
                        }
                    }
                }, c0545a.ewu.evD + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        };
        this.cVW = new k<d>(this) { // from class: com.baidu.swan.apps.core.pms.d.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.swan.apps.core.pms.k
            public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.al.a aVar2) {
                super.a(gVar, aVar2);
                if (aVar2 == null) {
                    d.this.cVU.add(gVar);
                } else if (d.DEBUG) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + ", " + aVar2);
                }
            }
        };
        this.cVT = aVar;
        this.cVU = new Vector();
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aqJ() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void anL() {
        super.anL();
        com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqK() {
        super.aqK();
        com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        if (this.cVT != null) {
            this.cVT.gU(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void anJ() {
        super.anJ();
        com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onNoPackage");
        if (this.cVT != null) {
            this.cVT.anJ();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cVS = fVar;
        com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.bdN());
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void aqF() {
        super.aqF();
        com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.cVU.isEmpty()) {
            p.a(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean a2 = com.baidu.swan.pms.database.a.bcx().a(null, d.this.cVU, null, null, null);
                    if (a2 && d.this.cVT != null) {
                        for (com.baidu.swan.pms.model.g gVar : d.this.cVU) {
                            d.this.cVT.a(gVar);
                        }
                    }
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + a2 + ", size=" + d.this.cVU);
                    }
                }
            }, "SwanAppBatchDownloadCallback");
        }
        if (this.cVT != null) {
            this.cVT.aqF();
        }
        com.baidu.swan.apps.env.e.atI().atJ().a((Set<String>) null, com.baidu.swan.apps.env.c.c.aun().hi(7).auo());
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0545a> aqL() {
        return this.cVV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable final PMSAppInfo pMSAppInfo, @Nullable final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null) {
            p.a(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pMSAppInfo2 != null) {
                        pMSAppInfo2.lS(d.this.arb());
                        pMSAppInfo.u(pMSAppInfo2);
                    } else {
                        pMSAppInfo.lS(d.this.arb());
                    }
                    pMSAppInfo.bcI();
                    if (com.baidu.swan.pms.database.a.bcx().r(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.g(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(a.C0545a c0545a) {
        if (c0545a == null || c0545a.ewu == null || c0545a.eww == null) {
            return false;
        }
        if (!ae.e(new File(c0545a.ewu.filePath), c0545a.ewu.sign)) {
            com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        com.baidu.swan.apps.al.a a2 = com.baidu.swan.apps.core.pms.f.a.a(c0545a.ewu, this);
        if (a2 != null) {
            com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a2);
            return false;
        }
        c0545a.eww.bcI();
        com.baidu.swan.apps.core.pms.f.a.a(c0545a.eww, c0545a.ewu);
        c0545a.eww.lS(arb());
        if (!com.baidu.swan.pms.database.a.bcx().a(c0545a.ewu, c0545a.eww)) {
            com.baidu.swan.apps.console.c.bl("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.cVS.g(c0545a.ewu);
        if (!c0545a.ewx) {
            com.baidu.swan.apps.core.pms.f.a.g(c0545a.eww);
        }
        com.baidu.swan.apps.core.pms.f.a.b(c0545a.ewu);
        return true;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aqM() {
        return this.cVW;
    }
}
