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
    private j<? super com.baidu.swan.pms.model.d> asQ;
    private j<? super com.baidu.swan.pms.model.b> asR;
    private com.baidu.swan.pms.e.e asS;
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> atm = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.h.1
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return h.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gs() {
            return h.this.By();
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
            h.this.asS.h(dVar);
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(13L).aa(aVar.errorNo).m14if("Framework包下载失败").ig(aVar.toString());
            if (h.this.asQ != null) {
                h.this.asQ.onError(new PkgDownloadError(dVar, ig));
            }
            b.Bh().a(dVar, h.this.Bl(), ig);
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
                h.this.asS.i(dVar);
                if (h.this.asQ != null) {
                    h.this.asQ.onNext(dVar);
                    h.this.asQ.onCompleted();
                }
                com.baidu.swan.pms.database.a.We().c(dVar);
                b.Bh().a(dVar, h.this.Bl());
                return;
            }
            h.this.asS.h(dVar);
            if (h.this.asQ != null) {
                h.this.asQ.onError(new PkgDownloadError(dVar, f));
            }
            b.Bh().a(dVar, h.this.Bl(), f);
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> atn = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.h.2
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return h.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gs() {
            return h.this.Bz();
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
            h.this.asS.h(bVar);
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(14L).aa(aVar.errorNo).m14if("Extension下载失败").ig(aVar.toString());
            if (h.this.asR != null) {
                h.this.asR.onError(new PkgDownloadError(bVar, ig));
            }
            b.Bh().a(bVar, h.this.Bl(), ig);
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
                h.this.asS.i(bVar);
                if (h.this.asR != null) {
                    h.this.asR.onNext(bVar);
                    h.this.asR.onCompleted();
                }
                com.baidu.swan.pms.database.a.We().c(bVar);
                b.Bh().a(bVar, h.this.Bl());
                return;
            }
            h.this.asS.h(bVar);
            if (h.this.asR != null) {
                h.this.asR.onError(new PkgDownloadError(bVar, f));
            }
            b.Bh().a(bVar, h.this.Bl(), f);
        }
    };
    private j<com.baidu.swan.pms.model.e> atd = new j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.h.7
        @Override // rx.e
        public void onCompleted() {
            if (h.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载完成");
            }
            com.baidu.swan.pms.d.a.g(h.this.Bx(), System.currentTimeMillis());
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (h.DEBUG) {
                Log.e("UpdateCoreCallback", "包下载、业务层处理 OnError：" + th.toString());
            }
            com.baidu.swan.pms.d.a.g(h.this.Bx(), 0L);
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

    protected abstract PMSDownloadType Bl();

    protected abstract int Bx();

    protected abstract String By();

    protected abstract String Bz();

    protected abstract com.baidu.swan.apps.ak.a f(com.baidu.swan.pms.model.b bVar);

    protected abstract com.baidu.swan.apps.ak.a f(com.baidu.swan.pms.model.d dVar);

    @Override // com.baidu.swan.pms.a.f
    public void Bn() {
        super.Bn();
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
            com.baidu.swan.pms.d.a.g(Bx(), System.currentTimeMillis());
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public void Bj() {
        super.Bj();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onNoPackage:");
        }
        com.baidu.swan.pms.d.a.g(Bx(), System.currentTimeMillis());
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.e.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.asS = eVar;
            if (!this.asS.isEmpty()) {
                Bw();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> Bq() {
        return this.atm;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> Br() {
        return this.atn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        b.Bh().a(dVar, new b.InterfaceC0136b() { // from class: com.baidu.swan.apps.core.pms.h.3
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType) {
                h.this.asS.i(dVar);
                if (h.this.asQ != null) {
                    h.this.asQ.onNext(dVar);
                    h.this.asQ.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                h.this.asS.h(dVar);
                if (h.this.asQ != null) {
                    h.this.asQ.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        b.Bh().a(bVar, new b.InterfaceC0136b() { // from class: com.baidu.swan.apps.core.pms.h.4
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType) {
                h.this.asS.i(bVar);
                if (h.this.asR != null) {
                    h.this.asR.onNext(bVar);
                    h.this.asR.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                h.this.asS.h(bVar);
                if (h.this.asR != null) {
                    h.this.asR.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void Bw() {
        ArrayList arrayList = new ArrayList();
        if (this.asS.WX()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.h.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.d> jVar) {
                    h.this.asQ = jVar;
                }
            }));
        }
        if (this.asS.WY()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.h.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.b> jVar) {
                    h.this.asR = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.h(arrayList).b(this.atd);
        }
    }
}
