package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.ap.ao;
import com.baidu.swan.apps.core.pms.c;
import java.util.ArrayList;
import java.util.Set;
import rx.d;
/* loaded from: classes25.dex */
public abstract class l extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.utils.f cRU;
    private com.baidu.swan.apps.ap.e.b<Exception> cSP;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cSQ;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cSR;
    private rx.j<? super com.baidu.swan.pms.model.d> cSg;
    private rx.j<? super com.baidu.swan.pms.model.b> cSh;
    private rx.j<com.baidu.swan.pms.model.e> cSx;

    protected abstract PMSDownloadType asQ();

    protected abstract String atb();

    protected abstract String atc();

    protected abstract com.baidu.swan.apps.am.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.am.a h(com.baidu.swan.pms.model.b bVar);

    public l(com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cSP = bVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void asM() {
        super.asM();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bt("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        if (aVar.errorNo == 1010) {
            ate();
        } else {
            o(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void apQ() {
        super.apQ();
        com.baidu.swan.apps.console.c.bt("UpdateCoreCallback", "onNoPackage:");
        ate();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null) {
            this.cRU = fVar;
            if (!this.cRU.isEmpty()) {
                asZ();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> asS() {
        if (this.cSQ == null) {
            this.cSQ = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.1
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: c */
                public String U(com.baidu.swan.pms.model.d dVar) {
                    return l.this.atb();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: d */
                public void S(com.baidu.swan.pms.model.d dVar) {
                    super.S(dVar);
                    com.baidu.swan.apps.console.c.bt("UpdateCoreCallback", "onDownloadStart");
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void T(com.baidu.swan.pms.model.d dVar) {
                    super.T(dVar);
                    if (l.DEBUG) {
                        Log.i("UpdateCoreCallback", "framework onDownloading");
                    }
                    l.this.b(dVar);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
                    super.a((AnonymousClass1) dVar, aVar);
                    com.baidu.swan.apps.console.c.bt("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cRU.f(dVar);
                    com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(13L).cV(aVar.errorNo).uA("Framework包下载失败").uC(aVar.toString());
                    if (l.this.cSg != null) {
                        l.this.cSg.onError(new PkgDownloadError(dVar, uC));
                    }
                    c.asJ().a(dVar, l.this.asQ(), uC);
                    com.baidu.swan.c.d.deleteFile(dVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void Q(com.baidu.swan.pms.model.d dVar) {
                    super.Q(dVar);
                    com.baidu.swan.apps.console.c.bt("UpdateCoreCallback", "onFileDownloaded: " + dVar.versionCode);
                    com.baidu.swan.apps.am.a g = l.this.g(dVar);
                    if (g == null) {
                        l.this.cRU.g(dVar);
                        if (l.this.cSg != null) {
                            l.this.cSg.onNext(dVar);
                            l.this.cSg.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.bdF().c(dVar);
                        c.asJ().a(dVar, l.this.asQ());
                        ao.aPE();
                        return;
                    }
                    l.this.cRU.f(dVar);
                    if (l.this.cSg != null) {
                        l.this.cSg.onError(new PkgDownloadError(dVar, g));
                    }
                    c.asJ().a(dVar, l.this.asQ(), g);
                }
            };
        }
        return this.cSQ;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> asT() {
        if (this.cSR == null) {
            this.cSR = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.2
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: d */
                public String U(com.baidu.swan.pms.model.b bVar) {
                    return l.this.atc();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void S(com.baidu.swan.pms.model.b bVar) {
                    super.S(bVar);
                    com.baidu.swan.apps.console.c.bt("UpdateCoreCallback", "onDownloadStart");
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void T(com.baidu.swan.pms.model.b bVar) {
                    super.T(bVar);
                    if (l.DEBUG) {
                        Log.i("UpdateCoreCallback", "extension onDownloading");
                    }
                    l.this.b(bVar);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
                    super.a((AnonymousClass2) bVar, aVar);
                    com.baidu.swan.apps.console.c.bt("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cRU.f(bVar);
                    com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(14L).cV(aVar.errorNo).uA("Extension下载失败").uC(aVar.toString());
                    if (l.this.cSh != null) {
                        l.this.cSh.onError(new PkgDownloadError(bVar, uC));
                    }
                    c.asJ().a(bVar, l.this.asQ(), uC);
                    com.baidu.swan.c.d.deleteFile(bVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: g */
                public void Q(com.baidu.swan.pms.model.b bVar) {
                    super.Q(bVar);
                    com.baidu.swan.apps.console.c.bt("UpdateCoreCallback", "onFileDownloaded: " + bVar.versionCode);
                    com.baidu.swan.apps.am.a h = l.this.h(bVar);
                    if (h == null) {
                        l.this.cRU.g(bVar);
                        if (l.this.cSh != null) {
                            l.this.cSh.onNext(bVar);
                            l.this.cSh.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.bdF().c(bVar);
                        c.asJ().a(bVar, l.this.asQ());
                        return;
                    }
                    l.this.cRU.f(bVar);
                    if (l.this.cSh != null) {
                        l.this.cSh.onError(new PkgDownloadError(bVar, h));
                    }
                    c.asJ().a(bVar, l.this.asQ(), h);
                }
            };
        }
        return this.cSR;
    }

    protected void n(Exception exc) {
        com.baidu.swan.apps.console.c.f("UpdateCoreCallback", "notifyFinalCallback", exc);
        if (this.cSP != null) {
            this.cSP.M(exc);
        }
        this.cSP = null;
    }

    protected void ate() {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.console.c.bt("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
        com.baidu.swan.pms.g.a.l(getCategory(), currentTimeMillis);
        n(null);
    }

    protected void o(Exception exc) {
        com.baidu.swan.apps.console.c.bt("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
        com.baidu.swan.pms.g.a.l(getCategory(), 0L);
        n(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.asJ().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cRU.g(dVar);
                if (l.this.cSg != null) {
                    l.this.cSg.onNext(dVar);
                    l.this.cSg.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                l.this.cRU.f(dVar);
                if (l.this.cSg != null) {
                    l.this.cSg.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.asJ().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cRU.g(bVar);
                if (l.this.cSh != null) {
                    l.this.cSh.onNext(bVar);
                    l.this.cSh.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                l.this.cRU.f(bVar);
                if (l.this.cSh != null) {
                    l.this.cSh.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void asZ() {
        ArrayList arrayList = new ArrayList();
        if (this.cRU.bfa()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    l.this.cSg = jVar;
                }
            }));
        }
        if (this.cRU.bfb()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    l.this.cSh = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(atf());
        }
    }

    private rx.j<com.baidu.swan.pms.model.e> atf() {
        if (this.cSx == null) {
            this.cSx = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.l.7
                @Override // rx.e
                public void onCompleted() {
                    com.baidu.swan.apps.console.c.bt("UpdateCoreCallback", "包下载完成");
                    l.this.ate();
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
                    com.baidu.swan.apps.console.c.bt("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.versionCode);
                }
            };
        }
        return this.cSx;
    }
}
