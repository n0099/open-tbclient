package com.baidu.swan.apps.core.pms.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.an.w;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.b;
import com.baidu.swan.apps.core.pms.g;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class a extends g {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.pms.a.a<h> aMO = new c<h>() { // from class: com.baidu.swan.apps.core.pms.b.a.1
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String getDownloadPath() {
            return com.baidu.swan.apps.core.a.d.a.e(a.this.aNe);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void E(h hVar) {
            super.E(hVar);
            if (a.DEBUG) {
                Log.i("SwanAppSubPkgDownloadCallback", "onDownloading");
            }
            a.this.f(hVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(h hVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) hVar, aVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownloadCallback", "onDownloadError:" + aVar.toString());
            }
            com.baidu.swan.apps.core.a.d.a.b(a.this.aNe, 2103);
            com.baidu.swan.apps.core.pms.b.Gg().a(hVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ak.a().as(12L).at(aVar.errorNo).iK("分包下载失败").iL(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void C(h hVar) {
            super.C(hVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownloadCallback", "onDownloadFinish:" + hVar.toString());
            }
            a.this.e(hVar);
        }
    };
    private SubPackageAPSInfo aNe;

    public a(SubPackageAPSInfo subPackageAPSInfo) {
        this.aNe = subPackageAPSInfo;
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        com.baidu.swan.apps.core.a.d.a.b(this.aNe, 2103);
    }

    @Override // com.baidu.swan.pms.a.f
    public void Gi() {
        super.Gi();
        com.baidu.swan.apps.core.a.d.a.b(this.aNe, 2102);
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<h> Go() {
        return this.aMO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(h hVar) {
        if (!w.b(new File(hVar.filePath), hVar.sign)) {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownloadCallback", "onDownloadFinish: 签名校验失败");
            }
            com.baidu.swan.apps.core.a.d.a.b(this.aNe, 2104);
            com.baidu.swan.apps.core.pms.b.Gg().a(hVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ak.a().as(12L).at(2300L).iK("分包签名校验"));
        } else if (com.baidu.swan.apps.core.a.d.a.a(this.aNe, hVar.filePath) && com.baidu.swan.apps.core.a.d.a.f(this.aNe)) {
            if (DEBUG) {
                Log.i("SwanAppSubPkgDownloadCallback", "onDownloadFinish: 解压成功");
            }
            com.baidu.swan.apps.database.subpackage.a.HI().m(this.aNe.mAppId, this.aNe.mAppVersion, this.aNe.aSA, this.aNe.mKey);
            com.baidu.swan.apps.core.a.d.a.d(this.aNe);
            hVar.appId = this.aNe.mAppId;
            com.baidu.swan.pms.database.a.aaX().c(hVar);
            com.baidu.swan.apps.core.pms.b.Gg().a(hVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownloadCallback", "onDownloadFinish: 解压失败");
            }
            com.baidu.swan.apps.core.a.d.a.b(this.aNe, 2105);
            com.baidu.swan.apps.core.pms.b.Gg().a(hVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ak.a().as(12L).at(2320L).iK("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(h hVar) {
        com.baidu.swan.apps.core.pms.b.Gg().a(hVar, new b.InterfaceC0182b() { // from class: com.baidu.swan.apps.core.pms.b.a.2
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.core.a.d.a.d(a.this.aNe);
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                com.baidu.swan.apps.core.a.d.a.b(a.this.aNe, 2103);
            }
        });
    }
}
