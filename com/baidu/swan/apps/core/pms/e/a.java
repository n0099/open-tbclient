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
/* loaded from: classes8.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private c<g> cSj = new com.baidu.swan.pms.a.b<g>() { // from class: com.baidu.swan.apps.core.pms.e.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: e */
        public String U(g gVar) {
            return com.baidu.swan.apps.core.pms.f.b.mC(a.this.cTw);
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
            a.this.gW(3);
            com.baidu.swan.apps.core.pms.c.aqg().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.al.a().cV(12L).cW(aVar.errorNo).tm("分包下载失败").to(aVar.toString()));
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
    private com.baidu.swan.apps.core.pms.b cTv;
    private String cTw;
    private String mAppId;

    public a(String str, String str2, com.baidu.swan.apps.core.pms.b bVar) {
        this.mAppId = str;
        this.cTv = bVar;
        this.cTw = d.C0449d.bR(str, str2).getPath();
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        gW(1);
    }

    @Override // com.baidu.swan.pms.a.g
    public void ani() {
        super.ani();
        gW(2);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<g> aql() {
        return this.cSj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        if (!ae.f(new File(gVar.filePath), gVar.sign)) {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            gW(4);
            com.baidu.swan.apps.core.pms.c.aqg().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.al.a().cV(12L).cW(2300L).tm("分包签名校验"));
        } else if (com.baidu.swan.apps.core.pms.f.b.h(new File(gVar.filePath), new File(this.cTw, gVar.pkgName))) {
            if (DEBUG) {
                Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            gVar.appId = this.mAppId;
            com.baidu.swan.pms.database.a.bci().c(gVar);
            aqE();
            com.baidu.swan.apps.core.pms.c.aqg().a(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            gW(5);
            com.baidu.swan.apps.core.pms.c.aqg().a(gVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.al.a().cV(12L).cW(2320L).tm("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(g gVar) {
        com.baidu.swan.apps.core.pms.c.aqg().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.e.a.2
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                a.this.aqE();
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                a.this.gW(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gW(int i) {
        if (this.cTv != null) {
            this.cTv.gR(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqE() {
        if (this.cTv != null) {
            this.cTv.aqf();
        }
    }
}
