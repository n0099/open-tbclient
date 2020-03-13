package com.baidu.swan.games.x.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.as.ab;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.c;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.games.k.a;
import com.baidu.swan.games.x.b;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes11.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private String bqD;
    private b.a csD;
    private String csE;
    private c<g> csF = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.games.x.b.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String K(g gVar) {
            return com.baidu.swan.apps.core.pms.d.b.hk(a.this.bqD);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void J(g gVar) {
            super.J(gVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloading");
            }
            a.this.h(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(g gVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) gVar, aVar);
            if (a.DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadError: " + aVar.toString());
            }
            a.this.eJ(2103);
            com.baidu.swan.apps.core.pms.c.Pk().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().aI(12L).aJ(aVar.errorNo).my("分包下载失败").mz(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: j */
        public void H(g gVar) {
            super.H(gVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + gVar.size + ":" + gVar.currentSize);
            }
            a.this.p(gVar.currentSize, gVar.size);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void G(g gVar) {
            super.G(gVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + gVar.toString());
            }
            a.this.g(gVar);
        }
    };
    private String mAppId;

    public a(String str, String str2, String str3, b.a aVar) {
        this.mAppId = str;
        this.csE = str3;
        this.csD = aVar;
        this.bqD = a.c.aL(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanGameSubPkgDownload", "onFetchError: " + aVar.toString());
        }
        eJ(2103);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pi() {
        super.Pi();
        if (DEBUG) {
            Log.i("SwanGameSubPkgDownload", "onNoPackage");
        }
        eJ(2102);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> Pr() {
        return this.csF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(g gVar) {
        if (!ab.d(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            eJ(2104);
            com.baidu.swan.apps.core.pms.c.Pk().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().aI(12L).aJ(2300L).my("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.d.b.e(new File(gVar.filePath), new File(this.bqD, this.csE))) {
            if (DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            PG();
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.atv().c(gVar);
            com.baidu.swan.apps.core.pms.c.Pk().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            eJ(2105);
            com.baidu.swan.apps.core.pms.c.Pk().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().aI(12L).aJ(2320L).my("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        com.baidu.swan.apps.core.pms.c.Pk().a(gVar, new c.b() { // from class: com.baidu.swan.games.x.b.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.PG();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                a.this.eJ(2103);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(int i) {
        if (this.csD != null) {
            this.csD.dY(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PG() {
        if (this.csD != null) {
            this.csD.apR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, long j2) {
        if (this.csD != null) {
            if (j2 <= 0 || j > j2) {
                eJ(2114);
                return;
            }
            int floor = (int) Math.floor((j * 100.0d) / j2);
            if (floor != 100) {
                if (DEBUG) {
                    Log.i("SwanGameSubPkgDownload", "callbackProgress: " + floor);
                }
                this.csD.d(floor, j, j2);
            }
        }
    }
}
