package com.baidu.swan.apps.core.pms.c;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.as.ab;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.c;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes9.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.core.pms.b blB;
    private String blC;
    private c<g> blh = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.apps.core.pms.c.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String I(g gVar) {
            return com.baidu.swan.apps.core.pms.d.b.gR(a.this.blC);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void H(g gVar) {
            super.H(gVar);
            if (a.DEBUG) {
                Log.i("SwanAppSubPkgDownload", "onDownloading");
            }
            a.this.h(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(g gVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) gVar, aVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadError:" + aVar.toString());
            }
            a.this.es(3);
            com.baidu.swan.apps.core.pms.c.My().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().aB(12L).aC(aVar.errorNo).mg("分包下载失败").mh(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void E(g gVar) {
            super.E(gVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish:" + gVar.toString());
            }
            a.this.g(gVar);
        }
    };
    private String mAppId;

    public a(String str, String str2, com.baidu.swan.apps.core.pms.b bVar) {
        this.mAppId = str;
        this.blB = bVar;
        this.blC = e.d.aA(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        es(1);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Mw() {
        super.Mw();
        es(2);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> MF() {
        return this.blh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(g gVar) {
        if (!ab.d(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            es(4);
            com.baidu.swan.apps.core.pms.c.My().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().aB(12L).aC(2300L).mg("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.d.b.e(new File(gVar.filePath), new File(this.blC, gVar.pkgName))) {
            if (DEBUG) {
                Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.aqM().c(gVar);
            MU();
            com.baidu.swan.apps.core.pms.c.My().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            es(5);
            com.baidu.swan.apps.core.pms.c.My().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().aB(12L).aC(2320L).mg("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        com.baidu.swan.apps.core.pms.c.My().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.c.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.MU();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                a.this.es(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(int i) {
        if (this.blB != null) {
            this.blB.ep(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MU() {
        if (this.blB != null) {
            this.blB.Mx();
        }
    }
}
