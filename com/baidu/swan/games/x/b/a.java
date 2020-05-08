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
    private String bPb;
    private b.a cRO;
    private String cRP;
    private c<g> cRQ = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.games.x.b.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String M(g gVar) {
            return com.baidu.swan.apps.core.pms.d.b.ix(a.this.bPb);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void L(g gVar) {
            super.L(gVar);
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
            a.this.eO(2103);
            com.baidu.swan.apps.core.pms.c.Xb().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().bn(12L).bo(aVar.errorNo).nK("分包下载失败").nL(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: j */
        public void J(g gVar) {
            super.J(gVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + gVar.size + ":" + gVar.currentSize);
            }
            a.this.q(gVar.currentSize, gVar.size);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void I(g gVar) {
            super.I(gVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + gVar.toString());
            }
            a.this.g(gVar);
        }
    };
    private String mAppId;

    public a(String str, String str2, String str3, b.a aVar) {
        this.mAppId = str;
        this.cRP = str3;
        this.cRO = aVar;
        this.bPb = a.c.aT(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanGameSubPkgDownload", "onFetchError: " + aVar.toString());
        }
        eO(2103);
    }

    @Override // com.baidu.swan.pms.a.g
    public void WZ() {
        super.WZ();
        if (DEBUG) {
            Log.i("SwanGameSubPkgDownload", "onNoPackage");
        }
        eO(2102);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> Xi() {
        return this.cRQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(g gVar) {
        if (!ab.e(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            eO(2104);
            com.baidu.swan.apps.core.pms.c.Xb().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().bn(12L).bo(2300L).nK("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.d.b.f(new File(gVar.filePath), new File(this.bPb, this.cRP))) {
            if (DEBUG) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            Xx();
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.aBI().c(gVar);
            com.baidu.swan.apps.core.pms.c.Xb().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            eO(2105);
            com.baidu.swan.apps.core.pms.c.Xb().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().bn(12L).bo(2320L).nK("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        com.baidu.swan.apps.core.pms.c.Xb().a(gVar, new c.b() { // from class: com.baidu.swan.games.x.b.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.Xx();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                a.this.eO(2103);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eO(int i) {
        if (this.cRO != null) {
            this.cRO.ed(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xx() {
        if (this.cRO != null) {
            this.cRO.ayg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(long j, long j2) {
        if (this.cRO != null) {
            if (j2 <= 0 || j > j2) {
                eO(2114);
                return;
            }
            int floor = (int) Math.floor((j * 100.0d) / j2);
            if (floor != 100) {
                if (DEBUG) {
                    Log.i("SwanGameSubPkgDownload", "callbackProgress: " + floor);
                }
                this.cRO.d(floor, j, j2);
            }
        }
    }
}
