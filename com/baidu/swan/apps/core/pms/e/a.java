package com.baidu.swan.apps.core.pms.e;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.aq.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.c;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes11.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private c<g> bXQ = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.apps.core.pms.e.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String P(g gVar) {
            return com.baidu.swan.apps.core.pms.f.b.jA(a.this.bYD);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void O(g gVar) {
            super.O(gVar);
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
            a.this.eY(3);
            com.baidu.swan.apps.core.pms.c.ZN().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.an.a().bw(12L).bx(aVar.errorNo).pr("分包下载失败").pt(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(g gVar) {
            super.L(gVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish:" + gVar.toString());
            }
            a.this.g(gVar);
        }
    };
    private com.baidu.swan.apps.core.pms.b bYC;
    private String bYD;
    private String mAppId;

    public a(String str, String str2, com.baidu.swan.apps.core.pms.b bVar) {
        this.mAppId = str;
        this.bYC = bVar;
        this.bYD = e.d.bk(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        eY(1);
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZL() {
        super.ZL();
        eY(2);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> ZU() {
        return this.bXQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(g gVar) {
        if (!ac.e(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            eY(4);
            com.baidu.swan.apps.core.pms.c.ZN().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.an.a().bw(12L).bx(2300L).pr("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.f.b.f(new File(gVar.filePath), new File(this.bYD, gVar.pkgName))) {
            if (DEBUG) {
                Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.aFV().c(gVar);
            aal();
            com.baidu.swan.apps.core.pms.c.ZN().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            eY(5);
            com.baidu.swan.apps.core.pms.c.ZN().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.an.a().bw(12L).bx(2320L).pr("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        com.baidu.swan.apps.core.pms.c.ZN().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.e.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.aal();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                a.this.eY(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(int i) {
        if (this.bYC != null) {
            this.bYC.eU(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aal() {
        if (this.bYC != null) {
            this.bYC.ZM();
        }
    }
}
