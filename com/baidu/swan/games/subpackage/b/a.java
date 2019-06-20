package com.baidu.swan.games.subpackage.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.an.w;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.b;
import com.baidu.swan.apps.core.pms.g;
import com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class a extends g {
    private static final boolean DEBUG = b.DEBUG;
    private SwanGameSubPackageAPSInfo bkN;
    private com.baidu.swan.pms.a.a<h> bkO = new c<h>() { // from class: com.baidu.swan.games.subpackage.b.a.1
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gj() {
            return com.baidu.swan.games.subpackage.b.e(a.this.bkN);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void G(h hVar) {
            super.G(hVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownloadCallback", "onDownloading");
            }
            a.this.f(hVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(h hVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) hVar, aVar);
            if (a.DEBUG) {
                Log.e("SwanGameSubPkgDownloadCallback", "onDownloadError: " + aVar.toString());
            }
            com.baidu.swan.games.subpackage.b.b(a.this.bkN, 2103);
            com.baidu.swan.apps.core.pms.b.Az().a(hVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ak.a().Y(12L).Z(aVar.errorNo).hX("分包下载失败").hY(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: g */
        public void R(h hVar) {
            super.R(hVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownloadCallback", "onDownloadProgress: " + hVar.size + ":" + hVar.currentSize);
            }
            com.baidu.swan.games.subpackage.b.a(a.this.bkN, hVar.currentSize, hVar.size);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void E(h hVar) {
            super.E(hVar);
            if (a.DEBUG) {
                Log.i("SwanGameSubPkgDownloadCallback", "onDownloadFinish: " + hVar.toString());
            }
            a.this.e(hVar);
        }
    };

    public a(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo) {
        this.bkN = swanGameSubPackageAPSInfo;
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("SwanGameSubPkgDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.games.subpackage.b.b(this.bkN, 2103);
    }

    @Override // com.baidu.swan.pms.a.f
    public void AB() {
        super.AB();
        if (DEBUG) {
            Log.i("SwanGameSubPkgDownloadCallback", "onNoPackage");
        }
        com.baidu.swan.games.subpackage.b.b(this.bkN, 2102);
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<h> AH() {
        return this.bkO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(h hVar) {
        if (!w.b(new File(hVar.filePath), hVar.sign)) {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownloadCallback", "onDownloadFinish: 签名校验失败");
            }
            com.baidu.swan.games.subpackage.b.b(this.bkN, 2104);
            com.baidu.swan.apps.core.pms.b.Az().a(hVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ak.a().Y(12L).Z(2300L).hX("分包签名校验"));
        } else if (com.baidu.swan.games.subpackage.b.a(this.bkN, hVar.filePath) && com.baidu.swan.games.subpackage.b.a(this.bkN)) {
            if (DEBUG) {
                Log.i("SwanGameSubPkgDownloadCallback", "onDownloadFinish: 解压成功");
            }
            com.baidu.swan.apps.database.subpackage.a.Cb().j(this.bkN.appId, this.bkN.appVersion, this.bkN.bkJ, this.bkN.key);
            com.baidu.swan.games.subpackage.b.d(this.bkN);
            hVar.appId = this.bkN.appId;
            com.baidu.swan.pms.database.a.Vl().c(hVar);
            com.baidu.swan.apps.core.pms.b.Az().a(hVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanGameSubPkgDownloadCallback", "onDownloadFinish: 解压失败");
            }
            com.baidu.swan.games.subpackage.b.b(this.bkN, 2105);
            com.baidu.swan.apps.core.pms.b.Az().a(hVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ak.a().Y(12L).Z(2320L).hX("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(h hVar) {
        com.baidu.swan.apps.core.pms.b.Az().a(hVar, new b.InterfaceC0139b() { // from class: com.baidu.swan.games.subpackage.b.a.2
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.games.subpackage.b.d(a.this.bkN);
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                com.baidu.swan.games.subpackage.b.b(a.this.bkN, 2103);
            }
        });
    }
}
