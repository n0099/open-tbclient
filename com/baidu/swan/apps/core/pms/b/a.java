package com.baidu.swan.apps.core.pms.b;

import android.util.Log;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.b;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.swan.pms.a.e;
import com.baidu.swan.pms.model.b;
import com.baidu.swan.pms.model.i;
/* loaded from: classes2.dex */
public class a extends e {
    private static final boolean DEBUG = c.DEBUG;
    private com.baidu.swan.pms.a.a<i> ash = new com.baidu.swan.pms.a.c<i>() { // from class: com.baidu.swan.apps.core.pms.b.a.1
        @Override // com.baidu.swan.pms.a.a
        public String hp() {
            return com.baidu.swan.apps.core.a.d.a.e(a.this.asv);
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
        public void a(i iVar, b bVar) {
            super.a((AnonymousClass1) iVar, bVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownloadCallback", "onDownloadError:" + bVar.toString());
            }
            com.baidu.swan.apps.core.a.d.a.b(a.this.asv, 2103);
            com.baidu.swan.apps.core.pms.b.zx().a(iVar, PMSDownloadType.ALONE_SUB, new com.baidu.swan.apps.ak.a().L(12L).M(bVar.errorNo).hv("分包下载失败").hw(bVar.toString()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void E(i iVar) {
            super.E(iVar);
            if (a.DEBUG) {
                Log.e("SwanAppSubPkgDownloadCallback", "onDownloadFinish:" + iVar.toString());
            }
            com.baidu.swan.apps.core.a.d.a.a(a.this.asv, iVar.sign, iVar.filePath, true);
            iVar.appId = a.this.asv.mAppId;
            com.baidu.swan.pms.database.a.RA().c(iVar);
            com.baidu.swan.apps.core.pms.b.zx().a(iVar, PMSDownloadType.ALONE_SUB);
        }
    };
    private SubPackageAPSInfo asv;

    public a(SubPackageAPSInfo subPackageAPSInfo) {
        this.asv = subPackageAPSInfo;
    }

    @Override // com.baidu.swan.pms.a.e
    public void a(b bVar) {
        super.a(bVar);
        com.baidu.swan.apps.core.a.d.a.b(this.asv, 2103);
    }

    @Override // com.baidu.swan.pms.a.e
    public void zz() {
        super.zz();
        com.baidu.swan.apps.core.a.d.a.b(this.asv, 2102);
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<i> zE() {
        return this.ash;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final i iVar) {
        com.baidu.swan.apps.core.pms.b.zx().a(iVar, new b.InterfaceC0107b() { // from class: com.baidu.swan.apps.core.pms.b.a.2
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.core.a.d.a.a(a.this.asv, iVar.sign, iVar.filePath, true);
                iVar.appId = a.this.asv.mAppId;
                com.baidu.swan.pms.database.a.RA().c(iVar);
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                com.baidu.swan.apps.core.a.d.a.b(a.this.asv, 2103);
            }
        });
    }
}
