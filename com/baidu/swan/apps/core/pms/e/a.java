package com.baidu.swan.apps.core.pms.e;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.ap.ae;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.c;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private c<g> cmj = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.apps.core.pms.e.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: e */
        public String R(g gVar) {
            return com.baidu.swan.apps.core.pms.f.b.lZ(a.this.cnx);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void Q(g gVar) {
            super.Q(gVar);
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
            a.this.hv(3);
            com.baidu.swan.apps.core.pms.c.ajd().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.am.a().bP(12L).bQ(aVar.errorNo).sF("分包下载失败").sH(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void N(g gVar) {
            super.N(gVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish:" + gVar.toString());
            }
            a.this.h(gVar);
        }
    };
    private com.baidu.swan.apps.core.pms.b cnw;
    private String cnx;
    private String mAppId;

    public a(String str, String str2, com.baidu.swan.apps.core.pms.b bVar) {
        this.mAppId = str;
        this.cnw = bVar;
        this.cnx = d.C0421d.bB(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        hv(1);
    }

    @Override // com.baidu.swan.pms.a.g
    public void agl() {
        super.agl();
        hv(2);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> aji() {
        return this.cmj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        if (!ae.e(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            hv(4);
            com.baidu.swan.apps.core.pms.c.ajd().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.am.a().bP(12L).bQ(2300L).sF("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.f.b.g(new File(gVar.filePath), new File(this.cnx, gVar.pkgName))) {
            if (DEBUG) {
                Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.aUf().c(gVar);
            ajB();
            com.baidu.swan.apps.core.pms.c.ajd().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            hv(5);
            com.baidu.swan.apps.core.pms.c.ajd().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.am.a().bP(12L).bQ(2320L).sF("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(g gVar) {
        com.baidu.swan.apps.core.pms.c.ajd().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.e.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.ajB();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                a.this.hv(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hv(int i) {
        if (this.cnw != null) {
            this.cnw.hq(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajB() {
        if (this.cnw != null) {
            this.cnw.ajc();
        }
    }
}
