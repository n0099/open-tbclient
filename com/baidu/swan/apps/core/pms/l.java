package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.aq.ap;
import com.baidu.swan.apps.core.pms.c;
import java.util.ArrayList;
import java.util.Set;
import rx.d;
/* loaded from: classes7.dex */
public abstract class l extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.f.f cdJ;
    private rx.j<? super com.baidu.swan.pms.model.d> cdV;
    private rx.j<? super com.baidu.swan.pms.model.b> cdW;
    private com.baidu.swan.apps.aq.e.b<Exception> ceD;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> ceE;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> ceF;
    private rx.j<com.baidu.swan.pms.model.e> cem;

    protected abstract PMSDownloadType acb();

    protected abstract String acm();

    protected abstract String acn();

    protected abstract com.baidu.swan.apps.an.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.an.a h(com.baidu.swan.pms.model.b bVar);

    public l(com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        this.ceD = bVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void abX() {
        super.abX();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.aW("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        if (aVar.errorNo == 1010) {
            acp();
        } else {
            o(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void Zs() {
        super.Zs();
        com.baidu.swan.apps.console.c.aW("UpdateCoreCallback", "onNoPackage:");
        acp();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.f fVar) {
        super.a(fVar);
        if (fVar != null) {
            this.cdJ = fVar;
            if (!this.cdJ.isEmpty()) {
                ack();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> acd() {
        if (this.ceE == null) {
            this.ceE = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.1
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: c */
                public String P(com.baidu.swan.pms.model.d dVar) {
                    return l.this.acm();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: d */
                public void N(com.baidu.swan.pms.model.d dVar) {
                    super.N(dVar);
                    com.baidu.swan.apps.console.c.aW("UpdateCoreCallback", "onDownloadStart");
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void O(com.baidu.swan.pms.model.d dVar) {
                    super.O(dVar);
                    if (l.DEBUG) {
                        Log.i("UpdateCoreCallback", "framework onDownloading");
                    }
                    l.this.b(dVar);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
                    super.a((AnonymousClass1) dVar, aVar);
                    com.baidu.swan.apps.console.c.aW("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cdJ.f(dVar);
                    com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(13L).bK(aVar.errorNo).qk("Framework包下载失败").qm(aVar.toString());
                    if (l.this.cdV != null) {
                        l.this.cdV.onError(new PkgDownloadError(dVar, qm));
                    }
                    c.abU().a(dVar, l.this.acb(), qm);
                    com.baidu.swan.d.d.deleteFile(dVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void L(com.baidu.swan.pms.model.d dVar) {
                    super.L(dVar);
                    com.baidu.swan.apps.console.c.aW("UpdateCoreCallback", "onFileDownloaded: " + dVar.versionCode);
                    com.baidu.swan.apps.an.a g = l.this.g(dVar);
                    if (g == null) {
                        l.this.cdJ.g(dVar);
                        if (l.this.cdV != null) {
                            l.this.cdV.onNext(dVar);
                            l.this.cdV.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.aKS().c(dVar);
                        c.abU().a(dVar, l.this.acb());
                        ap.axk();
                        return;
                    }
                    l.this.cdJ.f(dVar);
                    if (l.this.cdV != null) {
                        l.this.cdV.onError(new PkgDownloadError(dVar, g));
                    }
                    c.abU().a(dVar, l.this.acb(), g);
                }
            };
        }
        return this.ceE;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> ace() {
        if (this.ceF == null) {
            this.ceF = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.2
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: d */
                public String P(com.baidu.swan.pms.model.b bVar) {
                    return l.this.acn();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void N(com.baidu.swan.pms.model.b bVar) {
                    super.N(bVar);
                    com.baidu.swan.apps.console.c.aW("UpdateCoreCallback", "onDownloadStart");
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void O(com.baidu.swan.pms.model.b bVar) {
                    super.O(bVar);
                    if (l.DEBUG) {
                        Log.i("UpdateCoreCallback", "extension onDownloading");
                    }
                    l.this.b(bVar);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
                    super.a((AnonymousClass2) bVar, aVar);
                    com.baidu.swan.apps.console.c.aW("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cdJ.f(bVar);
                    com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(14L).bK(aVar.errorNo).qk("Extension下载失败").qm(aVar.toString());
                    if (l.this.cdW != null) {
                        l.this.cdW.onError(new PkgDownloadError(bVar, qm));
                    }
                    c.abU().a(bVar, l.this.acb(), qm);
                    com.baidu.swan.d.d.deleteFile(bVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: g */
                public void L(com.baidu.swan.pms.model.b bVar) {
                    super.L(bVar);
                    com.baidu.swan.apps.console.c.aW("UpdateCoreCallback", "onFileDownloaded: " + bVar.versionCode);
                    com.baidu.swan.apps.an.a h = l.this.h(bVar);
                    if (h == null) {
                        l.this.cdJ.g(bVar);
                        if (l.this.cdW != null) {
                            l.this.cdW.onNext(bVar);
                            l.this.cdW.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.aKS().c(bVar);
                        c.abU().a(bVar, l.this.acb());
                        return;
                    }
                    l.this.cdJ.f(bVar);
                    if (l.this.cdW != null) {
                        l.this.cdW.onError(new PkgDownloadError(bVar, h));
                    }
                    c.abU().a(bVar, l.this.acb(), h);
                }
            };
        }
        return this.ceF;
    }

    protected void n(Exception exc) {
        if (this.ceD != null) {
            this.ceD.H(exc);
        }
        this.ceD = null;
    }

    protected void acp() {
        com.baidu.swan.pms.e.a.l(getCategory(), System.currentTimeMillis());
        n(null);
    }

    protected void o(Exception exc) {
        com.baidu.swan.pms.e.a.l(getCategory(), 0L);
        n(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.abU().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cdJ.g(dVar);
                if (l.this.cdV != null) {
                    l.this.cdV.onNext(dVar);
                    l.this.cdV.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                l.this.cdJ.f(dVar);
                if (l.this.cdV != null) {
                    l.this.cdV.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.abU().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cdJ.g(bVar);
                if (l.this.cdW != null) {
                    l.this.cdW.onNext(bVar);
                    l.this.cdW.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                l.this.cdJ.f(bVar);
                if (l.this.cdW != null) {
                    l.this.cdW.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void ack() {
        ArrayList arrayList = new ArrayList();
        if (this.cdJ.aMo()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    l.this.cdV = jVar;
                }
            }));
        }
        if (this.cdJ.aMp()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    l.this.cdW = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(acq());
        }
    }

    private rx.j<com.baidu.swan.pms.model.e> acq() {
        if (this.cem == null) {
            this.cem = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.l.7
                @Override // rx.e
                public void onCompleted() {
                    com.baidu.swan.apps.console.c.aW("UpdateCoreCallback", "包下载完成");
                    l.this.acp();
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    com.baidu.swan.apps.console.c.f("UpdateCoreCallback", "OnError", th);
                    l.this.o(new Exception("UpdateCoreCallback failed by Download error = ", th));
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.e
                /* renamed from: a */
                public void onNext(com.baidu.swan.pms.model.e eVar) {
                    com.baidu.swan.apps.console.c.aW("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.versionCode);
                }
            };
        }
        return this.cem;
    }
}
