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
    private SubPackageAPSInfo atN;
    private com.baidu.swan.pms.a.a<h> atx = new c<h>() { // from class: com.baidu.swan.apps.core.pms.b.a.1
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gs() {
            return com.baidu.swan.apps.core.a.d.a.e(a.this.atN);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void G(h hVar) {
            super.G(hVar);
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
            com.baidu.swan.apps.core.a.d.a.b(a.this.atN, 2103);
            com.baidu.swan.apps.core.pms.b.Bl().a(hVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ak.a().Z(12L).aa(aVar.errorNo).ih("分包下载失败").ii(aVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void E(h hVar) {
            super.E(hVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownloadCallback", "onDownloadFinish:" + hVar.toString());
            }
            a.this.e(hVar);
        }
    };

    public a(SubPackageAPSInfo subPackageAPSInfo) {
        this.atN = subPackageAPSInfo;
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        com.baidu.swan.apps.core.a.d.a.b(this.atN, 2103);
    }

    @Override // com.baidu.swan.pms.a.f
    public void Bn() {
        super.Bn();
        com.baidu.swan.apps.core.a.d.a.b(this.atN, 2102);
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<h> Bt() {
        return this.atx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(h hVar) {
        if (!w.b(new File(hVar.filePath), hVar.sign)) {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownloadCallback", "onDownloadFinish: 签名校验失败");
            }
            com.baidu.swan.apps.core.a.d.a.b(this.atN, 2104);
            com.baidu.swan.apps.core.pms.b.Bl().a(hVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ak.a().Z(12L).aa(2300L).ih("分包签名校验"));
        } else if (com.baidu.swan.apps.core.a.d.a.a(this.atN, hVar.filePath) && com.baidu.swan.apps.core.a.d.a.f(this.atN)) {
            if (DEBUG) {
                Log.i("SwanAppSubPkgDownloadCallback", "onDownloadFinish: 解压成功");
            }
            com.baidu.swan.apps.database.subpackage.a.CO().j(this.atN.mAppId, this.atN.mAppVersion, this.atN.azk, this.atN.mKey);
            com.baidu.swan.apps.core.a.d.a.d(this.atN);
            hVar.appId = this.atN.mAppId;
            com.baidu.swan.pms.database.a.Wi().c(hVar);
            com.baidu.swan.apps.core.pms.b.Bl().a(hVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (DEBUG) {
                Log.e("SwanAppSubPkgDownloadCallback", "onDownloadFinish: 解压失败");
            }
            com.baidu.swan.apps.core.a.d.a.b(this.atN, 2105);
            com.baidu.swan.apps.core.pms.b.Bl().a(hVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ak.a().Z(12L).aa(2320L).ih("分包解压失败"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(h hVar) {
        com.baidu.swan.apps.core.pms.b.Bl().a(hVar, new b.InterfaceC0150b() { // from class: com.baidu.swan.apps.core.pms.b.a.2
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0150b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.core.a.d.a.d(a.this.atN);
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0150b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                com.baidu.swan.apps.core.a.d.a.b(a.this.atN, 2103);
            }
        });
    }
}
