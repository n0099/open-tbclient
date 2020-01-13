package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.core.pms.c;
import java.util.ArrayList;
import java.util.Set;
import rx.d;
/* loaded from: classes10.dex */
public abstract class k extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.f.e blB;
    private rx.j<? super com.baidu.swan.pms.model.d> blL;
    private rx.j<? super com.baidu.swan.pms.model.b> blM;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> bmj = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.k.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return k.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String I(com.baidu.swan.pms.model.d dVar) {
            return k.this.Nl();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.d dVar) {
            super.G(dVar);
            if (k.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void H(com.baidu.swan.pms.model.d dVar) {
            super.H(dVar);
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
            k.this.blB.f(dVar);
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(13L).aF(aVar.errorNo).mj("Framework包下载失败").mk(aVar.toString());
            if (k.this.blL != null) {
                k.this.blL.onError(new PkgDownloadError(dVar, mk));
            }
            c.MU().a(dVar, k.this.MZ(), mk);
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void E(com.baidu.swan.pms.model.d dVar) {
            super.E(dVar);
            if (k.DEBUG) {
                Log.d("UpdateCoreCallback", "onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ap.a g = k.this.g(dVar);
            if (g == null) {
                k.this.blB.g(dVar);
                if (k.this.blL != null) {
                    k.this.blL.onNext(dVar);
                    k.this.blL.onCompleted();
                }
                com.baidu.swan.pms.database.a.arf().c(dVar);
                c.MU().a(dVar, k.this.MZ());
                return;
            }
            k.this.blB.f(dVar);
            if (k.this.blL != null) {
                k.this.blL.onError(new PkgDownloadError(dVar, g));
            }
            c.MU().a(dVar, k.this.MZ(), g);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> bmk = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.k.2
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return k.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String I(com.baidu.swan.pms.model.b bVar) {
            return k.this.Nm();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void G(com.baidu.swan.pms.model.b bVar) {
            super.G(bVar);
            if (k.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void H(com.baidu.swan.pms.model.b bVar) {
            super.H(bVar);
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
            k.this.blB.f(bVar);
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(14L).aF(aVar.errorNo).mj("Extension下载失败").mk(aVar.toString());
            if (k.this.blM != null) {
                k.this.blM.onError(new PkgDownloadError(bVar, mk));
            }
            c.MU().a(bVar, k.this.MZ(), mk);
            com.baidu.swan.d.c.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void E(com.baidu.swan.pms.model.b bVar) {
            super.E(bVar);
            if (k.DEBUG) {
                Log.d("UpdateCoreCallback", "onFileDownloaded: " + bVar.toString());
            }
            com.baidu.swan.apps.ap.a h = k.this.h(bVar);
            if (h == null) {
                k.this.blB.g(bVar);
                if (k.this.blM != null) {
                    k.this.blM.onNext(bVar);
                    k.this.blM.onCompleted();
                }
                com.baidu.swan.pms.database.a.arf().c(bVar);
                c.MU().a(bVar, k.this.MZ());
                return;
            }
            k.this.blB.f(bVar);
            if (k.this.blM != null) {
                k.this.blM.onError(new PkgDownloadError(bVar, h));
            }
            c.MU().a(bVar, k.this.MZ(), h);
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> bma = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.k.7
        @Override // rx.e
        public void onCompleted() {
            if (k.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载完成");
            }
            k.this.Nn();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (k.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载、业务层处理 OnError：" + th.toString());
            }
            k.this.No();
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

    protected abstract PMSDownloadType MZ();

    protected abstract String Nl();

    protected abstract String Nm();

    protected abstract com.baidu.swan.apps.ap.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.ap.a h(com.baidu.swan.pms.model.b bVar);

    @Override // com.baidu.swan.pms.a.g
    public void MW() {
        super.MW();
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
            Nn();
        } else {
            No();
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void MS() {
        super.MS();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onNoPackage:");
        }
        Nn();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.blB = eVar;
            if (!this.blB.isEmpty()) {
                Nj();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> Nc() {
        return this.bmj;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> Nd() {
        return this.bmk;
    }

    protected void Nn() {
        com.baidu.swan.pms.e.a.k(getCategory(), System.currentTimeMillis());
    }

    protected void No() {
        com.baidu.swan.pms.e.a.k(getCategory(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.MU().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.k.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                k.this.blB.g(dVar);
                if (k.this.blL != null) {
                    k.this.blL.onNext(dVar);
                    k.this.blL.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                k.this.blB.f(dVar);
                if (k.this.blL != null) {
                    k.this.blL.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.MU().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.k.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                k.this.blB.g(bVar);
                if (k.this.blM != null) {
                    k.this.blM.onNext(bVar);
                    k.this.blM.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                k.this.blB.f(bVar);
                if (k.this.blM != null) {
                    k.this.blM.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void Nj() {
        ArrayList arrayList = new ArrayList();
        if (this.blB.asg()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.k.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    k.this.blL = jVar;
                }
            }));
        }
        if (this.blB.ash()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.k.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    k.this.blM = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.m(arrayList).b(this.bma);
        }
    }
}
