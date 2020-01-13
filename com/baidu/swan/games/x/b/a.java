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
/* loaded from: classes10.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private String bms;
    private b.a coA;
    private String coB;
    private c<g> coC = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.games.x.b.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String I(g gVar) {
            return com.baidu.swan.apps.core.pms.d.b.gV(a.this.bms);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void H(g gVar) {
            super.H(gVar);
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
            a.this.et(2103);
            com.baidu.swan.apps.core.pms.c.MU().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().aE(12L).aF(aVar.errorNo).mj("分包下载失败").mk(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: j */
        public void F(g gVar) {
            super.F(gVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + gVar.size + ":" + gVar.currentSize);
            }
            a.this.p(gVar.currentSize, gVar.size);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void E(g gVar) {
            super.E(gVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + gVar.toString());
            }
            a.this.g(gVar);
        }
    };
    private String mAppId;

    public a(String str, String str2, String str3, b.a aVar) {
        this.mAppId = str;
        this.coB = str3;
        this.coA = aVar;
        this.bms = a.c.aB(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanGameSubPkgDownload", "onFetchError: " + aVar.toString());
        }
        et(2103);
    }

    @Override // com.baidu.swan.pms.a.g
    public void MS() {
        super.MS();
        if (DEBUG) {
            Log.i("SwanGameSubPkgDownload", "onNoPackage");
        }
        et(2102);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> Nb() {
        return this.coC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(g gVar) {
        if (!ab.d(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            et(2104);
            com.baidu.swan.apps.core.pms.c.MU().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().aE(12L).aF(2300L).mj("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.d.b.e(new File(gVar.filePath), new File(this.bms, this.coB))) {
            if (DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            Nq();
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.arf().c(gVar);
            com.baidu.swan.apps.core.pms.c.MU().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            et(2105);
            com.baidu.swan.apps.core.pms.c.MU().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().aE(12L).aF(2320L).mj("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        com.baidu.swan.apps.core.pms.c.MU().a(gVar, new c.b() { // from class: com.baidu.swan.games.x.b.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.Nq();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                a.this.et(2103);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void et(int i) {
        if (this.coA != null) {
            this.coA.dI(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nq() {
        if (this.coA != null) {
            this.coA.anB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, long j2) {
        if (this.coA != null) {
            if (j2 <= 0 || j > j2) {
                et(2114);
                return;
            }
            int floor = (int) Math.floor((j * 100.0d) / j2);
            if (floor != 100) {
                if (DEBUG) {
                    Log.i("SwanGameSubPkgDownload", "callbackProgress: " + floor);
                }
                this.coA.d(floor, j, j2);
            }
        }
    }
}
