package com.baidu.swan.apps.core.pms;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.pms.b;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.e.a;
import java.util.ArrayList;
import rx.d;
import rx.j;
/* loaded from: classes2.dex */
public class f extends com.baidu.swan.pms.a.e {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private j<? super com.baidu.swan.pms.model.e> arY;
    private j<? super com.baidu.swan.pms.model.c> arZ;
    private com.baidu.swan.pms.d.e asa;
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.e> ass = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.1
        @Override // com.baidu.swan.pms.a.a
        public String hp() {
            return com.baidu.swan.apps.core.pms.c.a.zM();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void F(com.baidu.swan.pms.model.e eVar) {
            super.F(eVar);
            if (f.DEBUG) {
                Log.i("SwanAppUpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.e eVar) {
            super.G(eVar);
            if (f.DEBUG) {
                Log.i("SwanAppUpdateCoreCallback", "framework onDownloading");
            }
            f.this.b(eVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.model.b bVar) {
            super.a((AnonymousClass1) eVar, bVar);
            if (f.DEBUG) {
                Log.i("SwanAppUpdateCoreCallback", "onDownloadError:" + bVar);
            }
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(13L).M(bVar.errorNo).hv("Framework包下载失败").hw(bVar.toString());
            if (f.this.arY != null) {
                f.this.arY.onError(new PkgDownloadError(eVar, hw));
            }
            b.zx().a(eVar, PMSDownloadType.UPDATE_CORE, hw);
            com.baidu.swan.c.b.deleteFile(eVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void E(com.baidu.swan.pms.model.e eVar) {
            SwanAppMessengerService serviceObject;
            super.E(eVar);
            if (f.DEBUG) {
                Log.d("SwanAppUpdateCoreCallback", "onFileDownloaded: " + eVar.toString());
            }
            a.C0148a c = com.baidu.swan.apps.swancore.e.a.c(eVar.versionName, eVar.filePath, eVar.sign, 0);
            if (f.DEBUG) {
                Log.d("SwanAppUpdateCoreCallback", "SwanCore RemoteCoreUpdateStatus: " + c);
            }
            if (!TextUtils.isEmpty(eVar.filePath)) {
                com.baidu.swan.c.b.deleteFile(eVar.filePath);
            }
            if (c.isOk()) {
                long ea = com.baidu.swan.apps.swancore.e.a.ea(0);
                if (ea > 0 && (serviceObject = SwanAppMessengerService.getServiceObject()) != null) {
                    serviceObject.sendMessageWithDataToAllClient(114, ea);
                }
                if (f.this.arY != null) {
                    f.this.arY.onNext(eVar);
                    f.this.arY.onCompleted();
                }
                com.baidu.swan.pms.database.a.RA().c(eVar);
                b.zx().a(eVar, PMSDownloadType.UPDATE_CORE);
                return;
            }
            com.baidu.swan.apps.ak.a hv = new com.baidu.swan.apps.ak.a().L(13L).N(2907L).hv("Core包更新失败");
            if (f.this.arY != null) {
                f.this.arY.onError(new PkgDownloadError(eVar, hv));
            }
            b.zx().a(eVar, PMSDownloadType.UPDATE_CORE, hv);
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.c> ast = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.c>() { // from class: com.baidu.swan.apps.core.pms.f.2
        @Override // com.baidu.swan.pms.a.a
        public String hp() {
            return com.baidu.swan.apps.core.pms.c.a.zN();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void F(com.baidu.swan.pms.model.c cVar) {
            super.F(cVar);
            if (f.DEBUG) {
                Log.i("SwanAppUpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.c cVar) {
            super.G(cVar);
            if (f.DEBUG) {
                Log.i("SwanAppUpdateCoreCallback", "extension onDownloading");
            }
            f.this.b(cVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(com.baidu.swan.pms.model.c cVar, com.baidu.swan.pms.model.b bVar) {
            super.a((AnonymousClass2) cVar, bVar);
            if (f.DEBUG) {
                Log.i("SwanAppUpdateCoreCallback", "onDownloadError:" + bVar);
            }
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(14L).M(bVar.errorNo).hv("Extension下载失败").hw(bVar.toString());
            if (f.this.arZ != null) {
                f.this.arZ.onError(new PkgDownloadError(cVar, hw));
            }
            b.zx().a(cVar, PMSDownloadType.UPDATE_CORE, hw);
            com.baidu.swan.c.b.deleteFile(cVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void E(com.baidu.swan.pms.model.c cVar) {
            super.E(cVar);
            if (f.DEBUG) {
                Log.d("SwanAppUpdateCoreCallback", "onFileDownloaded: " + cVar.toString());
            }
            if (cVar != null) {
                com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
                aVar.versionName = cVar.versionName;
                aVar.avN = cVar.filePath;
                aVar.sign = cVar.sign;
                if (com.baidu.swan.apps.extcore.a.Bj().a((com.baidu.swan.apps.extcore.a) aVar)) {
                    if (f.this.arZ != null) {
                        f.this.arZ.onNext(cVar);
                        f.this.arZ.onCompleted();
                    }
                    com.baidu.swan.pms.database.a.RA().c(cVar);
                    b.zx().a(cVar, PMSDownloadType.UPDATE_CORE);
                    return;
                }
                com.baidu.swan.apps.ak.a hv = new com.baidu.swan.apps.ak.a().L(14L).N(2908L).hv("Extension包更新失败");
                if (f.this.arZ != null) {
                    f.this.arZ.onError(new PkgDownloadError(cVar, hv));
                }
                b.zx().a(cVar, PMSDownloadType.UPDATE_CORE, hv);
            }
        }
    };
    private j<com.baidu.swan.pms.model.f> asl = new j<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.7
        @Override // rx.e
        public void onCompleted() {
            if (f.DEBUG) {
                Log.e("SwanAppUpdateCoreCallback", "包下载完成");
            }
            com.baidu.swan.pms.c.a.W(System.currentTimeMillis());
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (f.DEBUG) {
                Log.e("SwanAppUpdateCoreCallback", "包下载、业务层处理 OnError：" + th.toString());
            }
            com.baidu.swan.pms.c.a.W(0L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.f fVar) {
            if (f.DEBUG) {
                Log.e("SwanAppUpdateCoreCallback", "单个包下载、业务层处理完成：" + fVar.toString());
            }
        }
    };

    @Override // com.baidu.swan.pms.a.e
    public void zC() {
        super.zC();
        if (DEBUG) {
            Log.e("SwanAppUpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.model.b bVar) {
        super.a(bVar);
        if (DEBUG) {
            Log.e("SwanAppUpdateCoreCallback", "onFetchError: " + bVar.toString());
        }
        if (bVar.errorNo == 1010) {
            com.baidu.swan.pms.c.a.W(System.currentTimeMillis());
        }
    }

    @Override // com.baidu.swan.pms.a.e
    public void zz() {
        super.zz();
        if (DEBUG) {
            Log.e("SwanAppUpdateCoreCallback", "onNoPackage:");
        }
        com.baidu.swan.pms.c.a.W(System.currentTimeMillis());
    }

    @Override // com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.d.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.asa = eVar;
            if (!this.asa.isEmpty()) {
                zK();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.e> zF() {
        return this.ass;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.c> zG() {
        return this.ast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.e eVar) {
        b.zx().a(eVar, new b.InterfaceC0107b() { // from class: com.baidu.swan.apps.core.pms.f.3
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.asa.g(eVar);
                if (f.this.arY != null) {
                    f.this.arY.onNext(eVar);
                    f.this.arY.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                f.this.asa.f(eVar);
                if (f.this.arY != null) {
                    f.this.arY.onError(new PkgDownloadError(eVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.c cVar) {
        b.zx().a(cVar, new b.InterfaceC0107b() { // from class: com.baidu.swan.apps.core.pms.f.4
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.asa.g(cVar);
                if (f.this.arZ != null) {
                    f.this.arZ.onNext(cVar);
                    f.this.arZ.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                f.this.asa.f(cVar);
                if (f.this.arZ != null) {
                    f.this.arZ.onError(new PkgDownloadError(cVar, aVar));
                }
            }
        });
    }

    private void zK() {
        ArrayList arrayList = new ArrayList();
        if (this.asa.St()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.e> jVar) {
                    f.this.arY = jVar;
                }
            }));
        }
        if (this.asa.Su()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.c>() { // from class: com.baidu.swan.apps.core.pms.f.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.c> jVar) {
                    f.this.arZ = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.h(arrayList).b(this.asl);
        }
    }
}
