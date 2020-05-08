package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.core.pms.c;
import java.util.ArrayList;
import java.util.Set;
import rx.d;
/* loaded from: classes11.dex */
public abstract class k extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.f.e bOl;
    private rx.j<? super com.baidu.swan.pms.model.d> bOv;
    private rx.j<? super com.baidu.swan.pms.model.b> bOw;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> bOT = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.k.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return k.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String M(com.baidu.swan.pms.model.d dVar) {
            return k.this.Xs();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void K(com.baidu.swan.pms.model.d dVar) {
            super.K(dVar);
            if (k.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void L(com.baidu.swan.pms.model.d dVar) {
            super.L(dVar);
            if (k.DEBUG) {
                Log.i("UpdateCoreCallback", "framework onDownloading");
            }
            k.this.b(dVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) dVar, aVar);
            if (k.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadError:" + aVar);
            }
            k.this.bOl.f(dVar);
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(13L).bo(aVar.errorNo).nK("Framework包下载失败").nL(aVar.toString());
            if (k.this.bOv != null) {
                k.this.bOv.onError(new PkgDownloadError(dVar, nL));
            }
            c.Xb().a(dVar, k.this.Xg(), nL);
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void I(com.baidu.swan.pms.model.d dVar) {
            super.I(dVar);
            if (k.DEBUG) {
                Log.d("UpdateCoreCallback", "onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ap.a g = k.this.g(dVar);
            if (g == null) {
                k.this.bOl.g(dVar);
                if (k.this.bOv != null) {
                    k.this.bOv.onNext(dVar);
                    k.this.bOv.onCompleted();
                }
                com.baidu.swan.pms.database.a.aBI().c(dVar);
                c.Xb().a(dVar, k.this.Xg());
                return;
            }
            k.this.bOl.f(dVar);
            if (k.this.bOv != null) {
                k.this.bOv.onError(new PkgDownloadError(dVar, g));
            }
            c.Xb().a(dVar, k.this.Xg(), g);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> bOU = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.k.2
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return k.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String M(com.baidu.swan.pms.model.b bVar) {
            return k.this.Xt();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void K(com.baidu.swan.pms.model.b bVar) {
            super.K(bVar);
            if (k.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(com.baidu.swan.pms.model.b bVar) {
            super.L(bVar);
            if (k.DEBUG) {
                Log.i("UpdateCoreCallback", "extension onDownloading");
            }
            k.this.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass2) bVar, aVar);
            if (k.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadError:" + aVar);
            }
            k.this.bOl.f(bVar);
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(14L).bo(aVar.errorNo).nK("Extension下载失败").nL(aVar.toString());
            if (k.this.bOw != null) {
                k.this.bOw.onError(new PkgDownloadError(bVar, nL));
            }
            c.Xb().a(bVar, k.this.Xg(), nL);
            com.baidu.swan.d.c.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void I(com.baidu.swan.pms.model.b bVar) {
            super.I(bVar);
            if (k.DEBUG) {
                Log.d("UpdateCoreCallback", "onFileDownloaded: " + bVar.toString());
            }
            com.baidu.swan.apps.ap.a h = k.this.h(bVar);
            if (h == null) {
                k.this.bOl.g(bVar);
                if (k.this.bOw != null) {
                    k.this.bOw.onNext(bVar);
                    k.this.bOw.onCompleted();
                }
                com.baidu.swan.pms.database.a.aBI().c(bVar);
                c.Xb().a(bVar, k.this.Xg());
                return;
            }
            k.this.bOl.f(bVar);
            if (k.this.bOw != null) {
                k.this.bOw.onError(new PkgDownloadError(bVar, h));
            }
            c.Xb().a(bVar, k.this.Xg(), h);
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> bOK = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.k.7
        @Override // rx.e
        public void onCompleted() {
            if (k.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载完成");
            }
            k.this.Xu();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (k.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载、业务层处理 OnError：" + th.toString());
            }
            k.this.Xv();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (k.DEBUG) {
                Log.e("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };

    protected abstract PMSDownloadType Xg();

    protected abstract String Xs();

    protected abstract String Xt();

    protected abstract com.baidu.swan.apps.ap.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.ap.a h(com.baidu.swan.pms.model.b bVar);

    @Override // com.baidu.swan.pms.a.g
    public void Xd() {
        super.Xd();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        }
        if (aVar.errorNo == 1010) {
            Xu();
        } else {
            Xv();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void WZ() {
        super.WZ();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onNoPackage:");
        }
        Xu();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.bOl = eVar;
            if (!this.bOl.isEmpty()) {
                Xq();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> Xj() {
        return this.bOT;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> Xk() {
        return this.bOU;
    }

    protected void Xu() {
        com.baidu.swan.pms.e.a.k(getCategory(), System.currentTimeMillis());
    }

    protected void Xv() {
        com.baidu.swan.pms.e.a.k(getCategory(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.Xb().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.k.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                k.this.bOl.g(dVar);
                if (k.this.bOv != null) {
                    k.this.bOv.onNext(dVar);
                    k.this.bOv.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                k.this.bOl.f(dVar);
                if (k.this.bOv != null) {
                    k.this.bOv.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.Xb().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.k.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                k.this.bOl.g(bVar);
                if (k.this.bOw != null) {
                    k.this.bOw.onNext(bVar);
                    k.this.bOw.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                k.this.bOl.f(bVar);
                if (k.this.bOw != null) {
                    k.this.bOw.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void Xq() {
        ArrayList arrayList = new ArrayList();
        if (this.bOl.aCK()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.k.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    k.this.bOv = jVar;
                }
            }));
        }
        if (this.bOl.aCL()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.k.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    k.this.bOw = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.bOK);
        }
    }
}
