package com.baidu.swan.apps.core.pms.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.b;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.a.e;
import com.baidu.swan.pms.model.i;
/* loaded from: classes2.dex */
public class a extends e {
    private static final boolean DEBUG = b.DEBUG;
    private SubPackageAPSInfo asB;
    private com.baidu.swan.pms.a.a<i> asn = new c<i>() { // from class: com.baidu.swan.apps.core.pms.b.a.1
        @Override // com.baidu.swan.pms.a.a
        public String hp() {
            return com.baidu.swan.apps.core.a.d.a.e(a.this.asB);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void G(i iVar) {
            super.G(iVar);
            if (a.DEBUG) {
                Log.i("SwanAppSubPkgDownloadCallback", "onDownloading");
            }
            a.this.e(iVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(i iVar, com.baidu.swan.pms.model.b bVar) {
            super.a((AnonymousClass1) iVar, bVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownloadCallback", "onDownloadError:" + bVar.toString());
            }
            com.baidu.swan.apps.core.a.d.a.b(a.this.asB, 2103);
            com.baidu.swan.apps.core.pms.b.zw().a(iVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ak.a().L(12L).M(bVar.errorNo).hw("分包下载失败").hx(bVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void E(i iVar) {
            super.E(iVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownloadCallback", "onDownloadFinish:" + iVar.toString());
            }
            com.baidu.swan.apps.core.a.d.a.a(a.this.asB, iVar.sign, iVar.filePath, true);
            iVar.appId = a.this.asB.mAppId;
            com.baidu.swan.pms.database.a.Ry().c(iVar);
            com.baidu.swan.apps.core.pms.b.zw().a(iVar, PMSDownloadType.ALONE_SUB);
        }
    };

    public a(SubPackageAPSInfo subPackageAPSInfo) {
        this.asB = subPackageAPSInfo;
    }

    @Override // com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.model.b bVar) {
        super.a(bVar);
        com.baidu.swan.apps.core.a.d.a.b(this.asB, 2103);
    }

    @Override // com.baidu.swan.pms.a.e
    public void zy() {
        super.zy();
        com.baidu.swan.apps.core.a.d.a.b(this.asB, 2102);
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<i> zD() {
        return this.asn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final i iVar) {
        com.baidu.swan.apps.core.pms.b.zw().a(iVar, new b.InterfaceC0136b() { // from class: com.baidu.swan.apps.core.pms.b.a.2
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.core.a.d.a.a(a.this.asB, iVar.sign, iVar.filePath, true);
                iVar.appId = a.this.asB.mAppId;
                com.baidu.swan.pms.database.a.Ry().c(iVar);
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                com.baidu.swan.apps.core.a.d.a.b(a.this.asB, 2103);
            }
        });
    }
}
