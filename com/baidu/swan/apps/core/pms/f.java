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
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private j<? super com.baidu.swan.pms.model.e> ase;
    private j<? super com.baidu.swan.pms.model.c> asf;
    private com.baidu.swan.pms.d.e asg;
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.e> asy = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.1
        @Override // com.baidu.swan.pms.a.a
        public String hp() {
            return com.baidu.swan.apps.core.pms.c.a.zL();
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
            com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(13L).M(bVar.errorNo).hw("Framework包下载失败").hx(bVar.toString());
            if (f.this.ase != null) {
                f.this.ase.onError(new PkgDownloadError(eVar, hx));
            }
            b.zw().a(eVar, PMSDownloadType.UPDATE_CORE, hx);
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
            a.C0177a c = com.baidu.swan.apps.swancore.e.a.c(eVar.versionName, eVar.filePath, eVar.sign, 0);
            if (f.DEBUG) {
                Log.d("SwanAppUpdateCoreCallback", "SwanCore RemoteCoreUpdateStatus: " + c);
            }
            if (!TextUtils.isEmpty(eVar.filePath)) {
                com.baidu.swan.c.b.deleteFile(eVar.filePath);
            }
            if (c.isOk()) {
                long dZ = com.baidu.swan.apps.swancore.e.a.dZ(0);
                if (dZ > 0 && (serviceObject = SwanAppMessengerService.getServiceObject()) != null) {
                    serviceObject.sendMessageWithDataToAllClient(114, dZ);
                }
                if (f.this.ase != null) {
                    f.this.ase.onNext(eVar);
                    f.this.ase.onCompleted();
                }
                com.baidu.swan.pms.database.a.Ry().c(eVar);
                b.zw().a(eVar, PMSDownloadType.UPDATE_CORE);
                return;
            }
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(13L).N(2907L).hw("Core包更新失败");
            if (f.this.ase != null) {
                f.this.ase.onError(new PkgDownloadError(eVar, hw));
            }
            b.zw().a(eVar, PMSDownloadType.UPDATE_CORE, hw);
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.c> asz = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.c>() { // from class: com.baidu.swan.apps.core.pms.f.2
        @Override // com.baidu.swan.pms.a.a
        public String hp() {
            return com.baidu.swan.apps.core.pms.c.a.zM();
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
            com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(14L).M(bVar.errorNo).hw("Extension下载失败").hx(bVar.toString());
            if (f.this.asf != null) {
                f.this.asf.onError(new PkgDownloadError(cVar, hx));
            }
            b.zw().a(cVar, PMSDownloadType.UPDATE_CORE, hx);
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
                aVar.avS = cVar.filePath;
                aVar.sign = cVar.sign;
                if (com.baidu.swan.apps.extcore.a.Bh().a((com.baidu.swan.apps.extcore.a) aVar)) {
                    if (f.this.asf != null) {
                        f.this.asf.onNext(cVar);
                        f.this.asf.onCompleted();
                    }
                    com.baidu.swan.pms.database.a.Ry().c(cVar);
                    b.zw().a(cVar, PMSDownloadType.UPDATE_CORE);
                    return;
                }
                com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(14L).N(2908L).hw("Extension包更新失败");
                if (f.this.asf != null) {
                    f.this.asf.onError(new PkgDownloadError(cVar, hw));
                }
                b.zw().a(cVar, PMSDownloadType.UPDATE_CORE, hw);
            }
        }
    };
    private j<com.baidu.swan.pms.model.f> asr = new j<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.7
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
    public void zB() {
        super.zB();
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
    public void zy() {
        super.zy();
        if (DEBUG) {
            Log.e("SwanAppUpdateCoreCallback", "onNoPackage:");
        }
        com.baidu.swan.pms.c.a.W(System.currentTimeMillis());
    }

    @Override // com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.d.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.asg = eVar;
            if (!this.asg.isEmpty()) {
                zJ();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.e> zE() {
        return this.asy;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.c> zF() {
        return this.asz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.e eVar) {
        b.zw().a(eVar, new b.InterfaceC0136b() { // from class: com.baidu.swan.apps.core.pms.f.3
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.asg.g(eVar);
                if (f.this.ase != null) {
                    f.this.ase.onNext(eVar);
                    f.this.ase.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                f.this.asg.f(eVar);
                if (f.this.ase != null) {
                    f.this.ase.onError(new PkgDownloadError(eVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.c cVar) {
        b.zw().a(cVar, new b.InterfaceC0136b() { // from class: com.baidu.swan.apps.core.pms.f.4
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.asg.g(cVar);
                if (f.this.asf != null) {
                    f.this.asf.onNext(cVar);
                    f.this.asf.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                f.this.asg.f(cVar);
                if (f.this.asf != null) {
                    f.this.asf.onError(new PkgDownloadError(cVar, aVar));
                }
            }
        });
    }

    private void zJ() {
        ArrayList arrayList = new ArrayList();
        if (this.asg.Sr()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.e> jVar) {
                    f.this.ase = jVar;
                }
            }));
        }
        if (this.asg.Ss()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.c>() { // from class: com.baidu.swan.apps.core.pms.f.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.c> jVar) {
                    f.this.asf = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.h(arrayList).b(this.asr);
        }
    }
}
