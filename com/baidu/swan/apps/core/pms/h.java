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
    private j<? super com.baidu.swan.pms.model.d> asn;
    private j<? super com.baidu.swan.pms.model.b> aso;
    private com.baidu.swan.pms.e.e asp;
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> asJ = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.h.1
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return h.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gj() {
            return h.this.AQ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void F(com.baidu.swan.pms.model.d dVar) {
            super.F(dVar);
            if (h.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.d dVar) {
            super.G(dVar);
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
            h.this.asp.h(dVar);
            com.baidu.swan.apps.ak.a hZ = new com.baidu.swan.apps.ak.a().Y(13L).Z(aVar.errorNo).hY("Framework包下载失败").hZ(aVar.toString());
            if (h.this.asn != null) {
                h.this.asn.onError(new PkgDownloadError(dVar, hZ));
            }
            b.Az().a(dVar, h.this.AD(), hZ);
            com.baidu.swan.c.a.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void E(com.baidu.swan.pms.model.d dVar) {
            super.E(dVar);
            if (h.DEBUG) {
                Log.d("UpdateCoreCallback", "onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ak.a f = h.this.f(dVar);
            if (f == null) {
                h.this.asp.i(dVar);
                if (h.this.asn != null) {
                    h.this.asn.onNext(dVar);
                    h.this.asn.onCompleted();
                }
                com.baidu.swan.pms.database.a.Vl().c(dVar);
                b.Az().a(dVar, h.this.AD());
                return;
            }
            h.this.asp.h(dVar);
            if (h.this.asn != null) {
                h.this.asn.onError(new PkgDownloadError(dVar, f));
            }
            b.Az().a(dVar, h.this.AD(), f);
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> asK = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.h.2
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return h.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gj() {
            return h.this.AR();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void F(com.baidu.swan.pms.model.b bVar) {
            super.F(bVar);
            if (h.DEBUG) {
                Log.i("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.b bVar) {
            super.G(bVar);
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
            h.this.asp.h(bVar);
            com.baidu.swan.apps.ak.a hZ = new com.baidu.swan.apps.ak.a().Y(14L).Z(aVar.errorNo).hY("Extension下载失败").hZ(aVar.toString());
            if (h.this.aso != null) {
                h.this.aso.onError(new PkgDownloadError(bVar, hZ));
            }
            b.Az().a(bVar, h.this.AD(), hZ);
            com.baidu.swan.c.a.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void E(com.baidu.swan.pms.model.b bVar) {
            super.E(bVar);
            if (h.DEBUG) {
                Log.d("UpdateCoreCallback", "onFileDownloaded: " + bVar.toString());
            }
            com.baidu.swan.apps.ak.a f = h.this.f(bVar);
            if (f == null) {
                h.this.asp.i(bVar);
                if (h.this.aso != null) {
                    h.this.aso.onNext(bVar);
                    h.this.aso.onCompleted();
                }
                com.baidu.swan.pms.database.a.Vl().c(bVar);
                b.Az().a(bVar, h.this.AD());
                return;
            }
            h.this.asp.h(bVar);
            if (h.this.aso != null) {
                h.this.aso.onError(new PkgDownloadError(bVar, f));
            }
            b.Az().a(bVar, h.this.AD(), f);
        }
    };
    private j<com.baidu.swan.pms.model.e> asA = new j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.h.7
        @Override // rx.e
        public void onCompleted() {
            if (h.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载完成");
            }
            com.baidu.swan.pms.d.a.g(h.this.AP(), System.currentTimeMillis());
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (h.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载、业务层处理 OnError：" + th.toString());
            }
            com.baidu.swan.pms.d.a.g(h.this.AP(), 0L);
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

    protected abstract PMSDownloadType AD();

    protected abstract int AP();

    protected abstract String AQ();

    protected abstract String AR();

    protected abstract com.baidu.swan.apps.ak.a f(com.baidu.swan.pms.model.b bVar);

    protected abstract com.baidu.swan.apps.ak.a f(com.baidu.swan.pms.model.d dVar);

    @Override // com.baidu.swan.pms.a.f
    public void AF() {
        super.AF();
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
            com.baidu.swan.pms.d.a.g(AP(), System.currentTimeMillis());
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public void AB() {
        super.AB();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onNoPackage:");
        }
        com.baidu.swan.pms.d.a.g(AP(), System.currentTimeMillis());
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.e.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.asp = eVar;
            if (!this.asp.isEmpty()) {
                AO();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> AI() {
        return this.asJ;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> AJ() {
        return this.asK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        b.Az().a(dVar, new b.InterfaceC0139b() { // from class: com.baidu.swan.apps.core.pms.h.3
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType) {
                h.this.asp.i(dVar);
                if (h.this.asn != null) {
                    h.this.asn.onNext(dVar);
                    h.this.asn.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                h.this.asp.h(dVar);
                if (h.this.asn != null) {
                    h.this.asn.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        b.Az().a(bVar, new b.InterfaceC0139b() { // from class: com.baidu.swan.apps.core.pms.h.4
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType) {
                h.this.asp.i(bVar);
                if (h.this.aso != null) {
                    h.this.aso.onNext(bVar);
                    h.this.aso.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                h.this.asp.h(bVar);
                if (h.this.aso != null) {
                    h.this.aso.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void AO() {
        ArrayList arrayList = new ArrayList();
        if (this.asp.Wd()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.h.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.d> jVar) {
                    h.this.asn = jVar;
                }
            }));
        }
        if (this.asp.We()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.h.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.b> jVar) {
                    h.this.aso = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.h(arrayList).b(this.asA);
        }
    }
}
