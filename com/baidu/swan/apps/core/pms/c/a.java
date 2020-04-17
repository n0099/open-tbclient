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
/* loaded from: classes11.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private c<g> bOB = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.apps.core.pms.c.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String L(g gVar) {
            return com.baidu.swan.apps.core.pms.d.b.iw(a.this.bOW);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void K(g gVar) {
            super.K(gVar);
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
            a.this.eO(3);
            com.baidu.swan.apps.core.pms.c.Xc().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().bn(12L).bo(aVar.errorNo).nK("分包下载失败").nL(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void H(g gVar) {
            super.H(gVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish:" + gVar.toString());
            }
            a.this.g(gVar);
        }
    };
    private com.baidu.swan.apps.core.pms.b bOV;
    private String bOW;
    private String mAppId;

    public a(String str, String str2, com.baidu.swan.apps.core.pms.b bVar) {
        this.mAppId = str;
        this.bOV = bVar;
        this.bOW = e.d.aT(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        eO(1);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xa() {
        super.Xa();
        eO(2);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> Xj() {
        return this.bOB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(g gVar) {
        if (!ab.e(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            eO(4);
            com.baidu.swan.apps.core.pms.c.Xc().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().bn(12L).bo(2300L).nK("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.d.b.f(new File(gVar.filePath), new File(this.bOW, gVar.pkgName))) {
            if (DEBUG) {
                Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.aBI().c(gVar);
            Xy();
            com.baidu.swan.apps.core.pms.c.Xc().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            eO(5);
            com.baidu.swan.apps.core.pms.c.Xc().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ap.a().bn(12L).bo(2320L).nK("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        com.baidu.swan.apps.core.pms.c.Xc().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.c.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.Xy();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                a.this.eO(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eO(int i) {
        if (this.bOV != null) {
            this.bOV.eL(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xy() {
        if (this.bOV != null) {
            this.bOV.Xb();
        }
    }
}
