package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.aq.am;
import com.baidu.swan.apps.core.pms.c;
import java.util.ArrayList;
import java.util.Set;
import rx.d;
/* loaded from: classes11.dex */
public abstract class k extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private rx.j<? super com.baidu.swan.pms.model.d> bXB;
    private rx.j<? super com.baidu.swan.pms.model.b> bXC;
    private rx.j<com.baidu.swan.pms.model.e> bXU;
    private com.baidu.swan.pms.f.e bXr;
    private com.baidu.swan.apps.aq.e.b<Exception> bYi;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> bYj;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> bYk;

    protected abstract PMSDownloadType ZS();

    protected abstract String aae();

    protected abstract String aaf();

    protected abstract com.baidu.swan.apps.an.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.an.a h(com.baidu.swan.pms.model.b bVar);

    public k(com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        this.bYi = bVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZP() {
        super.ZP();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        }
        if (aVar.errorNo == 1010) {
            aag();
        } else {
            o(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZL() {
        super.ZL();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onNoPackage:");
        }
        aag();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.bXr = eVar;
            if (!this.bXr.isEmpty()) {
                aac();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> ZV() {
        if (this.bYj == null) {
            this.bYj = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.k.1
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return k.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: c */
                public String P(com.baidu.swan.pms.model.d dVar) {
                    return k.this.aae();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: d */
                public void N(com.baidu.swan.pms.model.d dVar) {
                    super.N(dVar);
                    if (k.DEBUG) {
                        Log.i("UpdateCoreCallback", "onDownloadStart");
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void O(com.baidu.swan.pms.model.d dVar) {
                    super.O(dVar);
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
                    k.this.bXr.f(dVar);
                    com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(13L).bx(aVar.errorNo).pr("Framework包下载失败").pt(aVar.toString());
                    if (k.this.bXB != null) {
                        k.this.bXB.onError(new PkgDownloadError(dVar, pt));
                    }
                    c.ZN().a(dVar, k.this.ZS(), pt);
                    com.baidu.swan.e.d.deleteFile(dVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void L(com.baidu.swan.pms.model.d dVar) {
                    super.L(dVar);
                    if (k.DEBUG) {
                        Log.d("UpdateCoreCallback", "onFileDownloaded: " + dVar.toString());
                    }
                    com.baidu.swan.apps.an.a g = k.this.g(dVar);
                    if (g == null) {
                        k.this.bXr.g(dVar);
                        if (k.this.bXB != null) {
                            k.this.bXB.onNext(dVar);
                            k.this.bXB.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.aFV().c(dVar);
                        c.ZN().a(dVar, k.this.ZS());
                        am.atV();
                        return;
                    }
                    k.this.bXr.f(dVar);
                    if (k.this.bXB != null) {
                        k.this.bXB.onError(new PkgDownloadError(dVar, g));
                    }
                    c.ZN().a(dVar, k.this.ZS(), g);
                }
            };
        }
        return this.bYj;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> ZW() {
        if (this.bYk == null) {
            this.bYk = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.k.2
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return k.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: d */
                public String P(com.baidu.swan.pms.model.b bVar) {
                    return k.this.aaf();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void N(com.baidu.swan.pms.model.b bVar) {
                    super.N(bVar);
                    if (k.DEBUG) {
                        Log.i("UpdateCoreCallback", "onDownloadStart");
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void O(com.baidu.swan.pms.model.b bVar) {
                    super.O(bVar);
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
                    k.this.bXr.f(bVar);
                    com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(14L).bx(aVar.errorNo).pr("Extension下载失败").pt(aVar.toString());
                    if (k.this.bXC != null) {
                        k.this.bXC.onError(new PkgDownloadError(bVar, pt));
                    }
                    c.ZN().a(bVar, k.this.ZS(), pt);
                    com.baidu.swan.e.d.deleteFile(bVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: g */
                public void L(com.baidu.swan.pms.model.b bVar) {
                    super.L(bVar);
                    if (k.DEBUG) {
                        Log.d("UpdateCoreCallback", "onFileDownloaded: " + bVar.toString());
                    }
                    com.baidu.swan.apps.an.a h = k.this.h(bVar);
                    if (h == null) {
                        k.this.bXr.g(bVar);
                        if (k.this.bXC != null) {
                            k.this.bXC.onNext(bVar);
                            k.this.bXC.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.aFV().c(bVar);
                        c.ZN().a(bVar, k.this.ZS());
                        return;
                    }
                    k.this.bXr.f(bVar);
                    if (k.this.bXC != null) {
                        k.this.bXC.onError(new PkgDownloadError(bVar, h));
                    }
                    c.ZN().a(bVar, k.this.ZS(), h);
                }
            };
        }
        return this.bYk;
    }

    protected void n(Exception exc) {
        if (this.bYi != null) {
            this.bYi.H(exc);
        }
        this.bYi = null;
    }

    protected void aag() {
        com.baidu.swan.pms.e.a.k(getCategory(), System.currentTimeMillis());
        n(null);
    }

    protected void o(Exception exc) {
        com.baidu.swan.pms.e.a.k(getCategory(), 0L);
        n(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.ZN().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.k.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                k.this.bXr.g(dVar);
                if (k.this.bXB != null) {
                    k.this.bXB.onNext(dVar);
                    k.this.bXB.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                k.this.bXr.f(dVar);
                if (k.this.bXB != null) {
                    k.this.bXB.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.ZN().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.k.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                k.this.bXr.g(bVar);
                if (k.this.bXC != null) {
                    k.this.bXC.onNext(bVar);
                    k.this.bXC.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                k.this.bXr.f(bVar);
                if (k.this.bXC != null) {
                    k.this.bXC.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void aac() {
        ArrayList arrayList = new ArrayList();
        if (this.bXr.aHq()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.k.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    k.this.bXB = jVar;
                }
            }));
        }
        if (this.bXr.aHr()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.k.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    k.this.bXC = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(aah());
        }
    }

    private rx.j<com.baidu.swan.pms.model.e> aah() {
        if (this.bXU == null) {
            this.bXU = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.k.7
                @Override // rx.e
                public void onCompleted() {
                    if (k.DEBUG) {
                        Log.e("UpdateCoreCallback", "包下载完成");
                    }
                    k.this.aag();
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    if (k.DEBUG) {
                        Log.e("UpdateCoreCallback", "包下载、业务层处理 OnError：" + th.toString());
                    }
                    k.this.o(new Exception("UpdateCoreCallback failed by Download error = ", th));
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
        }
        return this.bXU;
    }
}
