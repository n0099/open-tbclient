package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.core.pms.b;
import java.util.ArrayList;
import java.util.Set;
import rx.d;
import rx.j;
/* loaded from: classes2.dex */
public abstract class h extends g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private j<? super com.baidu.swan.pms.model.d> aMn;
    private j<? super com.baidu.swan.pms.model.b> aMo;
    private com.baidu.swan.pms.e.e aMp;
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> aMJ = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.h.1
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return h.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String getDownloadPath() {
            return h.this.Gx();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void D(com.baidu.swan.pms.model.d dVar) {
            super.D(dVar);
            if (h.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void E(com.baidu.swan.pms.model.d dVar) {
            super.E(dVar);
            if (h.DEBUG) {
                Log.i("UpdateCoreCallback", "framework onDownloading");
            }
            h.this.b(dVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) dVar, aVar);
            if (h.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadError:" + aVar);
            }
            h.this.aMp.h(dVar);
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(13L).as(aVar.errorNo).iK("Framework包下载失败").iL(aVar.toString());
            if (h.this.aMn != null) {
                h.this.aMn.onError(new PkgDownloadError(dVar, iL));
            }
            b.Gh().a(dVar, h.this.Gl(), iL);
            com.baidu.swan.c.a.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void C(com.baidu.swan.pms.model.d dVar) {
            super.C(dVar);
            if (h.DEBUG) {
                Log.d("UpdateCoreCallback", "onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ak.a f = h.this.f(dVar);
            if (f == null) {
                h.this.aMp.i(dVar);
                if (h.this.aMn != null) {
                    h.this.aMn.onNext(dVar);
                    h.this.aMn.onCompleted();
                }
                com.baidu.swan.pms.database.a.aaV().c(dVar);
                b.Gh().a(dVar, h.this.Gl());
                return;
            }
            h.this.aMp.h(dVar);
            if (h.this.aMn != null) {
                h.this.aMn.onError(new PkgDownloadError(dVar, f));
            }
            b.Gh().a(dVar, h.this.Gl(), f);
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> aMK = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.h.2
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return h.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String getDownloadPath() {
            return h.this.Gy();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void D(com.baidu.swan.pms.model.b bVar) {
            super.D(bVar);
            if (h.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void E(com.baidu.swan.pms.model.b bVar) {
            super.E(bVar);
            if (h.DEBUG) {
                Log.i("UpdateCoreCallback", "extension onDownloading");
            }
            h.this.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass2) bVar, aVar);
            if (h.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadError:" + aVar);
            }
            h.this.aMp.h(bVar);
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(14L).as(aVar.errorNo).iK("Extension下载失败").iL(aVar.toString());
            if (h.this.aMo != null) {
                h.this.aMo.onError(new PkgDownloadError(bVar, iL));
            }
            b.Gh().a(bVar, h.this.Gl(), iL);
            com.baidu.swan.c.a.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void C(com.baidu.swan.pms.model.b bVar) {
            super.C(bVar);
            if (h.DEBUG) {
                Log.d("UpdateCoreCallback", "onFileDownloaded: " + bVar.toString());
            }
            com.baidu.swan.apps.ak.a f = h.this.f(bVar);
            if (f == null) {
                h.this.aMp.i(bVar);
                if (h.this.aMo != null) {
                    h.this.aMo.onNext(bVar);
                    h.this.aMo.onCompleted();
                }
                com.baidu.swan.pms.database.a.aaV().c(bVar);
                b.Gh().a(bVar, h.this.Gl());
                return;
            }
            h.this.aMp.h(bVar);
            if (h.this.aMo != null) {
                h.this.aMo.onError(new PkgDownloadError(bVar, f));
            }
            b.Gh().a(bVar, h.this.Gl(), f);
        }
    };
    private j<com.baidu.swan.pms.model.e> aMA = new j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.h.7
        @Override // rx.e
        public void onCompleted() {
            if (h.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载完成");
            }
            com.baidu.swan.pms.d.a.e(h.this.getCategory(), System.currentTimeMillis());
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (h.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载、业务层处理 OnError：" + th.toString());
            }
            com.baidu.swan.pms.d.a.e(h.this.getCategory(), 0L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (h.DEBUG) {
                Log.e("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };

    protected abstract PMSDownloadType Gl();

    protected abstract String Gx();

    protected abstract String Gy();

    protected abstract com.baidu.swan.apps.ak.a f(com.baidu.swan.pms.model.b bVar);

    protected abstract com.baidu.swan.apps.ak.a f(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    @Override // com.baidu.swan.pms.a.f
    public void Gn() {
        super.Gn();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        }
        if (aVar.errorNo == 1010) {
            com.baidu.swan.pms.d.a.e(getCategory(), System.currentTimeMillis());
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public void Gj() {
        super.Gj();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onNoPackage:");
        }
        com.baidu.swan.pms.d.a.e(getCategory(), System.currentTimeMillis());
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.e.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.aMp = eVar;
            if (!this.aMp.isEmpty()) {
                Gw();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> Gq() {
        return this.aMJ;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> Gr() {
        return this.aMK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        b.Gh().a(dVar, new b.InterfaceC0177b() { // from class: com.baidu.swan.apps.core.pms.h.3
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0177b
            public void a(PMSDownloadType pMSDownloadType) {
                h.this.aMp.i(dVar);
                if (h.this.aMn != null) {
                    h.this.aMn.onNext(dVar);
                    h.this.aMn.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0177b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                h.this.aMp.h(dVar);
                if (h.this.aMn != null) {
                    h.this.aMn.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        b.Gh().a(bVar, new b.InterfaceC0177b() { // from class: com.baidu.swan.apps.core.pms.h.4
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0177b
            public void a(PMSDownloadType pMSDownloadType) {
                h.this.aMp.i(bVar);
                if (h.this.aMo != null) {
                    h.this.aMo.onNext(bVar);
                    h.this.aMo.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0177b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                h.this.aMp.h(bVar);
                if (h.this.aMo != null) {
                    h.this.aMo.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void Gw() {
        ArrayList arrayList = new ArrayList();
        if (this.aMp.abO()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.h.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.d> jVar) {
                    h.this.aMn = jVar;
                }
            }));
        }
        if (this.aMp.abP()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.h.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.b> jVar) {
                    h.this.aMo = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.h(arrayList).b(this.aMA);
        }
    }
}
