package com.baidu.swan.games.y.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.aq.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.c;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.games.l.a;
import com.baidu.swan.games.y.b;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes11.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private String cdt;
    private c<g> dhA = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.games.y.b.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String P(g gVar) {
            return com.baidu.swan.apps.core.pms.f.b.jJ(a.this.cdt);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void O(g gVar) {
            super.O(gVar);
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
            a.this.fl(2103);
            com.baidu.swan.apps.core.pms.c.aaT().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.an.a().bw(12L).bx(aVar.errorNo).pz("分包下载失败").pB(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: j */
        public void M(g gVar) {
            super.M(gVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + gVar.size + ":" + gVar.currentSize);
            }
            a.this.r(gVar.currentSize, gVar.size);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(g gVar) {
            super.L(gVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + gVar.toString());
            }
            a.this.g(gVar);
        }
    };
    private b.a dhy;
    private String dhz;
    private String mAppId;

    public a(String str, String str2, String str3, b.a aVar) {
        this.mAppId = str;
        this.dhz = str3;
        this.dhy = aVar;
        this.cdt = a.c.bm(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanGameSubPkgDownload", "onFetchError: " + aVar.toString());
        }
        fl(2103);
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaR() {
        super.aaR();
        if (DEBUG) {
            Log.i("SwanGameSubPkgDownload", "onNoPackage");
        }
        fl(2102);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> aba() {
        return this.dhA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(g gVar) {
        if (!ac.e(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            fl(2104);
            com.baidu.swan.apps.core.pms.c.aaT().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.an.a().bw(12L).bx(2300L).pz("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.f.b.f(new File(gVar.filePath), new File(this.cdt, this.dhz))) {
            if (DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            abr();
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.aHb().c(gVar);
            com.baidu.swan.apps.core.pms.c.aaT().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            fl(2105);
            com.baidu.swan.apps.core.pms.c.aaT().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.an.a().bw(12L).bx(2320L).pz("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        com.baidu.swan.apps.core.pms.c.aaT().a(gVar, new c.b() { // from class: com.baidu.swan.games.y.b.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.abr();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                a.this.fl(2103);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fl(int i) {
        if (this.dhy != null) {
            this.dhy.ew(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abr() {
        if (this.dhy != null) {
            this.dhy.aDd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, long j2) {
        if (this.dhy != null) {
            if (j2 <= 0 || j > j2) {
                fl(2114);
                return;
            }
            int floor = (int) Math.floor((j * 100.0d) / j2);
            if (floor != 100) {
                if (DEBUG) {
                    Log.i("SwanGameSubPkgDownload", "callbackProgress: " + floor);
                }
                this.dhy.d(floor, j, j2);
            }
        }
    }
}
