package com.baidu.swan.apps.core.pms.e;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.aq.ae;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.c;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private c<g> cdN = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.apps.core.pms.e.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: e */
        public String P(g gVar) {
            return com.baidu.swan.apps.core.pms.f.b.kb(a.this.ceY);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void O(g gVar) {
            super.O(gVar);
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
            a.this.fq(3);
            com.baidu.swan.apps.core.pms.c.abU().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.an.a().bJ(12L).bK(aVar.errorNo).qk("分包下载失败").qm(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(g gVar) {
            super.L(gVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish:" + gVar.toString());
            }
            a.this.h(gVar);
        }
    };
    private com.baidu.swan.apps.core.pms.b ceX;
    private String ceY;
    private String mAppId;

    public a(String str, String str2, com.baidu.swan.apps.core.pms.b bVar) {
        this.mAppId = str;
        this.ceX = bVar;
        this.ceY = d.C0380d.bq(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        fq(1);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Zs() {
        super.Zs();
        fq(2);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> abZ() {
        return this.cdN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        if (!ae.e(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            fq(4);
            com.baidu.swan.apps.core.pms.c.abU().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.an.a().bJ(12L).bK(2300L).qk("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.f.b.g(new File(gVar.filePath), new File(this.ceY, gVar.pkgName))) {
            if (DEBUG) {
                Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.aKS().c(gVar);
            acs();
            com.baidu.swan.apps.core.pms.c.abU().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            fq(5);
            com.baidu.swan.apps.core.pms.c.abU().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.an.a().bJ(12L).bK(2320L).qk("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(g gVar) {
        com.baidu.swan.apps.core.pms.c.abU().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.e.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.acs();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                a.this.fq(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(int i) {
        if (this.ceX != null) {
            this.ceX.fl(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acs() {
        if (this.ceX != null) {
            this.ceX.abT();
        }
    }
}
