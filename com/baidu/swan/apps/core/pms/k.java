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
    private com.baidu.swan.pms.f.e bpN;
    private rx.j<? super com.baidu.swan.pms.model.d> bpX;
    private rx.j<? super com.baidu.swan.pms.model.b> bpY;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> bqv = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.k.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return k.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String K(com.baidu.swan.pms.model.d dVar) {
            return k.this.PB();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void I(com.baidu.swan.pms.model.d dVar) {
            super.I(dVar);
            if (k.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void J(com.baidu.swan.pms.model.d dVar) {
            super.J(dVar);
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
            k.this.bpN.f(dVar);
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(13L).aJ(aVar.errorNo).my("Framework包下载失败").mz(aVar.toString());
            if (k.this.bpX != null) {
                k.this.bpX.onError(new PkgDownloadError(dVar, mz));
            }
            c.Pk().a(dVar, k.this.Pp(), mz);
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void G(com.baidu.swan.pms.model.d dVar) {
            super.G(dVar);
            if (k.DEBUG) {
                Log.d("UpdateCoreCallback", "onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ap.a g = k.this.g(dVar);
            if (g == null) {
                k.this.bpN.g(dVar);
                if (k.this.bpX != null) {
                    k.this.bpX.onNext(dVar);
                    k.this.bpX.onCompleted();
                }
                com.baidu.swan.pms.database.a.atv().c(dVar);
                c.Pk().a(dVar, k.this.Pp());
                return;
            }
            k.this.bpN.f(dVar);
            if (k.this.bpX != null) {
                k.this.bpX.onError(new PkgDownloadError(dVar, g));
            }
            c.Pk().a(dVar, k.this.Pp(), g);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> bqw = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.k.2
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return k.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String K(com.baidu.swan.pms.model.b bVar) {
            return k.this.PC();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void I(com.baidu.swan.pms.model.b bVar) {
            super.I(bVar);
            if (k.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void J(com.baidu.swan.pms.model.b bVar) {
            super.J(bVar);
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
            k.this.bpN.f(bVar);
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(14L).aJ(aVar.errorNo).my("Extension下载失败").mz(aVar.toString());
            if (k.this.bpY != null) {
                k.this.bpY.onError(new PkgDownloadError(bVar, mz));
            }
            c.Pk().a(bVar, k.this.Pp(), mz);
            com.baidu.swan.d.c.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void G(com.baidu.swan.pms.model.b bVar) {
            super.G(bVar);
            if (k.DEBUG) {
                Log.d("UpdateCoreCallback", "onFileDownloaded: " + bVar.toString());
            }
            com.baidu.swan.apps.ap.a h = k.this.h(bVar);
            if (h == null) {
                k.this.bpN.g(bVar);
                if (k.this.bpY != null) {
                    k.this.bpY.onNext(bVar);
                    k.this.bpY.onCompleted();
                }
                com.baidu.swan.pms.database.a.atv().c(bVar);
                c.Pk().a(bVar, k.this.Pp());
                return;
            }
            k.this.bpN.f(bVar);
            if (k.this.bpY != null) {
                k.this.bpY.onError(new PkgDownloadError(bVar, h));
            }
            c.Pk().a(bVar, k.this.Pp(), h);
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> bqm = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.k.7
        @Override // rx.e
        public void onCompleted() {
            if (k.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载完成");
            }
            k.this.PD();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (k.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载、业务层处理 OnError：" + th.toString());
            }
            k.this.PE();
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

    protected abstract String PB();

    protected abstract String PC();

    protected abstract PMSDownloadType Pp();

    protected abstract com.baidu.swan.apps.ap.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.ap.a h(com.baidu.swan.pms.model.b bVar);

    @Override // com.baidu.swan.pms.a.g
    public void Pm() {
        super.Pm();
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
            PD();
        } else {
            PE();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pi() {
        super.Pi();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onNoPackage:");
        }
        PD();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.bpN = eVar;
            if (!this.bpN.isEmpty()) {
                Pz();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> Ps() {
        return this.bqv;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> Pt() {
        return this.bqw;
    }

    protected void PD() {
        com.baidu.swan.pms.e.a.k(getCategory(), System.currentTimeMillis());
    }

    protected void PE() {
        com.baidu.swan.pms.e.a.k(getCategory(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.Pk().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.k.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                k.this.bpN.g(dVar);
                if (k.this.bpX != null) {
                    k.this.bpX.onNext(dVar);
                    k.this.bpX.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                k.this.bpN.f(dVar);
                if (k.this.bpX != null) {
                    k.this.bpX.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.Pk().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.k.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                k.this.bpN.g(bVar);
                if (k.this.bpY != null) {
                    k.this.bpY.onNext(bVar);
                    k.this.bpY.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                k.this.bpN.f(bVar);
                if (k.this.bpY != null) {
                    k.this.bpY.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void Pz() {
        ArrayList arrayList = new ArrayList();
        if (this.bpN.auw()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.k.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    k.this.bpX = jVar;
                }
            }));
        }
        if (this.bpN.aux()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.k.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    k.this.bpY = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.m(arrayList).b(this.bqm);
        }
    }
}
