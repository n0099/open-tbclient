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
/* loaded from: classes10.dex */
public class d extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cyA;
    private com.baidu.swan.pms.utils.f cyw;
    private a cyx;
    private final List<com.baidu.swan.pms.model.g> cyy;
    private com.baidu.swan.pms.a.a<a.C0532a> cyz;

    public d() {
        this(null);
    }

    public d(a aVar) {
        this.cyz = new com.baidu.swan.pms.a.a<a.C0532a>() { // from class: com.baidu.swan.apps.core.pms.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.c
            /* renamed from: c */
            public String U(a.C0532a c0532a) {
                if (c0532a == null) {
                    return null;
                }
                if (c0532a.category == 0) {
                    return com.baidu.swan.apps.core.pms.f.a.amn();
                }
                if (c0532a.category == 1) {
                    return com.baidu.swan.apps.core.pms.f.a.amo();
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
            public void a(a.C0532a c0532a, PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.a aVar2) {
                com.baidu.swan.apps.console.c.bg("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar2.errorNo + ",msg: " + aVar2.errorMsg);
                if (d.this.cyx != null) {
                    d.this.cyx.a(aVar2);
                }
                if (aVar2 != null && aVar2.errorNo == 1010) {
                    PMSAppInfo pMSAppInfo2 = c0532a == null ? null : c0532a.dUm;
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    d.this.a(pMSAppInfo2, pMSAppInfo);
                    if (com.baidu.swan.apps.core.pms.d.a.c(aVar2)) {
                        com.baidu.swan.apps.core.pms.d.a.mI(pMSAppInfo2.appId);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: d */
            public void S(a.C0532a c0532a) {
                super.S(c0532a);
                com.baidu.swan.apps.console.c.bg("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0532a.dTs);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: e */
            public void T(a.C0532a c0532a) {
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0532a.dTs);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: f */
            public void R(a.C0532a c0532a) {
                super.R(c0532a);
                if (d.DEBUG) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0532a.dUk.currentSize + "/" + c0532a.dUk.size);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            public void a(a.C0532a c0532a, com.baidu.swan.pms.model.a aVar2) {
                super.a((AnonymousClass2) c0532a, aVar2);
                com.baidu.swan.apps.console.c.bg("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar2.toString());
                com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(11L).bY(aVar2.errorNo).tr("批量下载，主包下载失败：" + c0532a.dTs).tt(aVar2.toString());
                if (c0532a.errorCode != 0) {
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + tt.toString());
                    }
                } else if (c0532a.dUk != null) {
                    d.this.cyw.f(c0532a.dUk);
                    c.alO().a(c0532a.dUk, PMSDownloadType.BATCH, tt);
                    com.baidu.swan.c.d.deleteFile(c0532a.dUk.filePath);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
            /* renamed from: g */
            public void Q(final a.C0532a c0532a) {
                super.Q(c0532a);
                com.baidu.swan.apps.console.c.bg("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0532a.dUk.versionCode);
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b(c0532a)) {
                            if (d.this.cyx != null) {
                                d.this.cyx.a(c0532a);
                            }
                            com.baidu.swan.apps.core.pms.d.a.mI(c0532a.dUm.appId);
                        }
                    }
                }, c0532a.dUk.dTs + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        };
        this.cyA = new k<d>(this) { // from class: com.baidu.swan.apps.core.pms.d.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.swan.apps.core.pms.k
            public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar2) {
                super.a(gVar, aVar2);
                if (aVar2 == null) {
                    d.this.cyy.add(gVar);
                } else if (d.DEBUG) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + ", " + aVar2);
                }
            }
        };
        this.cyx = aVar;
        this.cyy = new Vector();
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int alQ() {
        return 7;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiY() {
        super.aiY();
        com.baidu.swan.apps.console.c.bg("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // com.baidu.swan.pms.a.g
    public void alR() {
        super.alR();
        com.baidu.swan.apps.console.c.bg("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bg("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        if (this.cyx != null) {
            this.cyx.hM(aVar.errorNo);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiW() {
        super.aiW();
        com.baidu.swan.apps.console.c.bg("SwanAppBatchDownloadCallback", "onNoPackage");
        if (this.cyx != null) {
            this.cyx.aiW();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cyw = fVar;
        com.baidu.swan.apps.console.c.bg("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.aYf());
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void alM() {
        super.alM();
        com.baidu.swan.apps.console.c.bg("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (DEBUG) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.cyy.isEmpty()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean a2 = com.baidu.swan.pms.database.a.aWO().a(null, d.this.cyy, null, null, null);
                    if (a2 && d.this.cyx != null) {
                        for (com.baidu.swan.pms.model.g gVar : d.this.cyy) {
                            d.this.cyx.a(gVar);
                        }
                    }
                    if (d.DEBUG) {
                        Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + a2 + ", size=" + d.this.cyy);
                    }
                }
            }, "SwanAppBatchDownloadCallback");
        }
        if (this.cyx != null) {
            this.cyx.alM();
        }
        com.baidu.swan.apps.env.e.aoM().aoN().a((Set<String>) null, com.baidu.swan.apps.env.c.c.aps().ia(7).apt());
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.a<a.C0532a> alS() {
        return this.cyz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable final PMSAppInfo pMSAppInfo, @Nullable final PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo != null) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pMSAppInfo2 != null) {
                        pMSAppInfo2.mw(d.this.ami());
                        pMSAppInfo.u(pMSAppInfo2);
                    } else {
                        pMSAppInfo.mw(d.this.ami());
                    }
                    pMSAppInfo.aWZ();
                    if (com.baidu.swan.pms.database.a.aWO().r(pMSAppInfo)) {
                        com.baidu.swan.apps.core.pms.f.a.g(pMSAppInfo);
                    }
                }
            }, "批量下载-只更新AppInfo-存储DB");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(a.C0532a c0532a) {
        if (c0532a == null || c0532a.dUk == null || c0532a.dUm == null) {
            return false;
        }
        if (!ae.e(new File(c0532a.dUk.filePath), c0532a.dUk.sign)) {
            com.baidu.swan.apps.console.c.bg("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        com.baidu.swan.apps.am.a a2 = com.baidu.swan.apps.core.pms.f.a.a(c0532a.dUk, this);
        if (a2 != null) {
            com.baidu.swan.apps.console.c.bg("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + a2);
            return false;
        }
        c0532a.dUm.aWZ();
        com.baidu.swan.apps.core.pms.f.a.a(c0532a.dUm, c0532a.dUk);
        c0532a.dUm.mw(ami());
        if (!com.baidu.swan.pms.database.a.aWO().a(c0532a.dUk, c0532a.dUm)) {
            com.baidu.swan.apps.console.c.bg("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.cyw.g(c0532a.dUk);
        if (!c0532a.dUn) {
            com.baidu.swan.apps.core.pms.f.a.g(c0532a.dUm);
        }
        com.baidu.swan.apps.core.pms.f.a.b(c0532a.dUk);
        return true;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> alT() {
        return this.cyA;
    }
}
