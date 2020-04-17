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
    private com.baidu.swan.pms.f.e bOg;
    private rx.j<? super com.baidu.swan.pms.model.d> bOq;
    private rx.j<? super com.baidu.swan.pms.model.b> bOr;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> bOO = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.k.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return k.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String L(com.baidu.swan.pms.model.d dVar) {
            return k.this.Xt();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void J(com.baidu.swan.pms.model.d dVar) {
            super.J(dVar);
            if (k.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void K(com.baidu.swan.pms.model.d dVar) {
            super.K(dVar);
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
            k.this.bOg.f(dVar);
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(13L).bo(aVar.errorNo).nK("Framework包下载失败").nL(aVar.toString());
            if (k.this.bOq != null) {
                k.this.bOq.onError(new PkgDownloadError(dVar, nL));
            }
            c.Xc().a(dVar, k.this.Xh(), nL);
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void H(com.baidu.swan.pms.model.d dVar) {
            super.H(dVar);
            if (k.DEBUG) {
                Log.d("UpdateCoreCallback", "onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ap.a g = k.this.g(dVar);
            if (g == null) {
                k.this.bOg.g(dVar);
                if (k.this.bOq != null) {
                    k.this.bOq.onNext(dVar);
                    k.this.bOq.onCompleted();
                }
                com.baidu.swan.pms.database.a.aBI().c(dVar);
                c.Xc().a(dVar, k.this.Xh());
                return;
            }
            k.this.bOg.f(dVar);
            if (k.this.bOq != null) {
                k.this.bOq.onError(new PkgDownloadError(dVar, g));
            }
            c.Xc().a(dVar, k.this.Xh(), g);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> bOP = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.k.2
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return k.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String L(com.baidu.swan.pms.model.b bVar) {
            return k.this.Xu();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void J(com.baidu.swan.pms.model.b bVar) {
            super.J(bVar);
            if (k.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void K(com.baidu.swan.pms.model.b bVar) {
            super.K(bVar);
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
            k.this.bOg.f(bVar);
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(14L).bo(aVar.errorNo).nK("Extension下载失败").nL(aVar.toString());
            if (k.this.bOr != null) {
                k.this.bOr.onError(new PkgDownloadError(bVar, nL));
            }
            c.Xc().a(bVar, k.this.Xh(), nL);
            com.baidu.swan.d.c.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void H(com.baidu.swan.pms.model.b bVar) {
            super.H(bVar);
            if (k.DEBUG) {
                Log.d("UpdateCoreCallback", "onFileDownloaded: " + bVar.toString());
            }
            com.baidu.swan.apps.ap.a h = k.this.h(bVar);
            if (h == null) {
                k.this.bOg.g(bVar);
                if (k.this.bOr != null) {
                    k.this.bOr.onNext(bVar);
                    k.this.bOr.onCompleted();
                }
                com.baidu.swan.pms.database.a.aBI().c(bVar);
                c.Xc().a(bVar, k.this.Xh());
                return;
            }
            k.this.bOg.f(bVar);
            if (k.this.bOr != null) {
                k.this.bOr.onError(new PkgDownloadError(bVar, h));
            }
            c.Xc().a(bVar, k.this.Xh(), h);
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> bOF = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.k.7
        @Override // rx.e
        public void onCompleted() {
            if (k.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载完成");
            }
            k.this.Xv();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (k.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载、业务层处理 OnError：" + th.toString());
            }
            k.this.Xw();
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

    protected abstract PMSDownloadType Xh();

    protected abstract String Xt();

    protected abstract String Xu();

    protected abstract com.baidu.swan.apps.ap.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.ap.a h(com.baidu.swan.pms.model.b bVar);

    @Override // com.baidu.swan.pms.a.g
    public void Xe() {
        super.Xe();
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
            Xv();
        } else {
            Xw();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xa() {
        super.Xa();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onNoPackage:");
        }
        Xv();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.bOg = eVar;
            if (!this.bOg.isEmpty()) {
                Xr();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> Xk() {
        return this.bOO;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> Xl() {
        return this.bOP;
    }

    protected void Xv() {
        com.baidu.swan.pms.e.a.k(getCategory(), System.currentTimeMillis());
    }

    protected void Xw() {
        com.baidu.swan.pms.e.a.k(getCategory(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.Xc().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.k.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                k.this.bOg.g(dVar);
                if (k.this.bOq != null) {
                    k.this.bOq.onNext(dVar);
                    k.this.bOq.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                k.this.bOg.f(dVar);
                if (k.this.bOq != null) {
                    k.this.bOq.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.Xc().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.k.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                k.this.bOg.g(bVar);
                if (k.this.bOr != null) {
                    k.this.bOr.onNext(bVar);
                    k.this.bOr.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                k.this.bOg.f(bVar);
                if (k.this.bOr != null) {
                    k.this.bOr.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void Xr() {
        ArrayList arrayList = new ArrayList();
        if (this.bOg.aCK()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.k.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    k.this.bOq = jVar;
                }
            }));
        }
        if (this.bOg.aCL()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.k.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    k.this.bOr = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.m(arrayList).b(this.bOF);
        }
    }
}
