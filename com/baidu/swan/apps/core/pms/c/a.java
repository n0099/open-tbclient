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
/* loaded from: classes10.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private c<g> blW = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.apps.core.pms.c.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String I(g gVar) {
            return com.baidu.swan.apps.core.pms.d.b.gU(a.this.bms);
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
            a.this.et(3);
            com.baidu.swan.apps.core.pms.c.MU().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().aE(12L).aF(aVar.errorNo).mj("分包下载失败").mk(aVar.toString()));
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
    private com.baidu.swan.apps.core.pms.b bmr;
    private String bms;
    private String mAppId;

    public a(String str, String str2, com.baidu.swan.apps.core.pms.b bVar) {
        this.mAppId = str;
        this.bmr = bVar;
        this.bms = e.d.aB(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        et(1);
    }

    @Override // com.baidu.swan.pms.a.g
    public void MS() {
        super.MS();
        et(2);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> Nb() {
        return this.blW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(g gVar) {
        if (!ab.d(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            et(4);
            com.baidu.swan.apps.core.pms.c.MU().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().aE(12L).aF(2300L).mj("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.d.b.e(new File(gVar.filePath), new File(this.bms, gVar.pkgName))) {
            if (DEBUG) {
                Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.arf().c(gVar);
            Nq();
            com.baidu.swan.apps.core.pms.c.MU().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            et(5);
            com.baidu.swan.apps.core.pms.c.MU().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().aE(12L).aF(2320L).mj("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        com.baidu.swan.apps.core.pms.c.MU().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.c.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.Nq();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                a.this.et(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void et(int i) {
        if (this.bmr != null) {
            this.bmr.eq(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nq() {
        if (this.bmr != null) {
            this.bmr.MT();
        }
    }
}
