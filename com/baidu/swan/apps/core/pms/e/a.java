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
    private c<g> ccF = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.apps.core.pms.e.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String P(g gVar) {
            return com.baidu.swan.apps.core.pms.f.b.jI(a.this.cdt);
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
            a.this.fl(3);
            com.baidu.swan.apps.core.pms.c.aaT().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.an.a().bw(12L).bx(aVar.errorNo).pz("分包下载失败").pB(aVar.toString()));
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
    private com.baidu.swan.apps.core.pms.b cds;
    private String cdt;
    private String mAppId;

    public a(String str, String str2, com.baidu.swan.apps.core.pms.b bVar) {
        this.mAppId = str;
        this.cds = bVar;
        this.cdt = e.d.bm(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        fl(1);
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaR() {
        super.aaR();
        fl(2);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> aba() {
        return this.ccF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(g gVar) {
        if (!ac.e(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            fl(4);
            com.baidu.swan.apps.core.pms.c.aaT().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.an.a().bw(12L).bx(2300L).pz("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.f.b.f(new File(gVar.filePath), new File(this.cdt, gVar.pkgName))) {
            if (DEBUG) {
                Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.aHb().c(gVar);
            abr();
            com.baidu.swan.apps.core.pms.c.aaT().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            fl(5);
            com.baidu.swan.apps.core.pms.c.aaT().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.an.a().bw(12L).bx(2320L).pz("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        com.baidu.swan.apps.core.pms.c.aaT().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.e.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.abr();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                a.this.fl(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fl(int i) {
        if (this.cds != null) {
            this.cds.fh(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abr() {
        if (this.cds != null) {
            this.cds.aaS();
        }
    }
}
