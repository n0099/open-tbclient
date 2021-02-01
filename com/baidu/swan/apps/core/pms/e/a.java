package com.baidu.swan.apps.core.pms.e;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ae;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.c;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes9.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private c<g> cUw = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.apps.core.pms.e.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: e */
        public String U(g gVar) {
            return com.baidu.swan.apps.core.pms.f.b.mU(a.this.cVJ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void T(g gVar) {
            super.T(gVar);
            if (a.DEBUG) {
                Log.i("SwanAppSubPkgDownload", "onDownloading");
            }
            a.this.i(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(g gVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) gVar, aVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadError:" + aVar.toString());
            }
            a.this.gZ(3);
            com.baidu.swan.apps.core.pms.c.aqE().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.al.a().db(12L).dc(aVar.errorNo).tF("分包下载失败").tH(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(g gVar) {
            super.Q(gVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish:" + gVar.toString());
            }
            a.this.h(gVar);
        }
    };
    private com.baidu.swan.apps.core.pms.b cVI;
    private String cVJ;
    private String mAppId;

    public a(String str, String str2, com.baidu.swan.apps.core.pms.b bVar) {
        this.mAppId = str;
        this.cVI = bVar;
        this.cVJ = d.C0446d.bL(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        gZ(1);
    }

    @Override // com.baidu.swan.pms.a.g
    public void anG() {
        super.anG();
        gZ(2);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> aqJ() {
        return this.cUw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        if (!ae.e(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            gZ(4);
            com.baidu.swan.apps.core.pms.c.aqE().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.al.a().db(12L).dc(2300L).tF("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.f.b.e(new File(gVar.filePath), new File(this.cVJ, gVar.pkgName))) {
            if (DEBUG) {
                Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.bcv().c(gVar);
            arc();
            com.baidu.swan.apps.core.pms.c.aqE().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            gZ(5);
            com.baidu.swan.apps.core.pms.c.aqE().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.al.a().db(12L).dc(2320L).tF("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(g gVar) {
        com.baidu.swan.apps.core.pms.c.aqE().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.e.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.arc();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                a.this.gZ(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gZ(int i) {
        if (this.cVI != null) {
            this.cVI.gU(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arc() {
        if (this.cVI != null) {
            this.cVI.aqD();
        }
    }
}
