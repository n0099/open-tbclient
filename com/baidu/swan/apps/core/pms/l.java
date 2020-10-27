package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.ap.ao;
import com.baidu.swan.apps.core.pms.c;
import java.util.ArrayList;
import java.util.Set;
import rx.d;
/* loaded from: classes10.dex */
public abstract class l extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.utils.f cGS;
    private com.baidu.swan.apps.ap.e.b<Exception> cHN;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cHO;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cHP;
    private rx.j<? super com.baidu.swan.pms.model.d> cHe;
    private rx.j<? super com.baidu.swan.pms.model.b> cHf;
    private rx.j<com.baidu.swan.pms.model.e> cHv;

    protected abstract PMSDownloadType anP();

    protected abstract String aoa();

    protected abstract String aob();

    protected abstract com.baidu.swan.apps.am.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.am.a h(com.baidu.swan.pms.model.b bVar);

    public l(com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cHN = bVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void anL() {
        super.anL();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        if (aVar.errorNo == 1010) {
            aod();
        } else {
            o(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void akQ() {
        super.akQ();
        com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onNoPackage:");
        aod();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null) {
            this.cGS = fVar;
            if (!this.cGS.isEmpty()) {
                anY();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> anR() {
        if (this.cHO == null) {
            this.cHO = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.1
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: c */
                public String U(com.baidu.swan.pms.model.d dVar) {
                    return l.this.aoa();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: d */
                public void S(com.baidu.swan.pms.model.d dVar) {
                    super.S(dVar);
                    com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onDownloadStart");
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
                    com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cGS.f(dVar);
                    com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(13L).ca(aVar.errorNo).tK("Framework包下载失败").tM(aVar.toString());
                    if (l.this.cHe != null) {
                        l.this.cHe.onError(new PkgDownloadError(dVar, tM));
                    }
                    c.anI().a(dVar, l.this.anP(), tM);
                    com.baidu.swan.c.d.deleteFile(dVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void Q(com.baidu.swan.pms.model.d dVar) {
                    super.Q(dVar);
                    com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onFileDownloaded: " + dVar.versionCode);
                    com.baidu.swan.apps.am.a g = l.this.g(dVar);
                    if (g == null) {
                        l.this.cGS.g(dVar);
                        if (l.this.cHe != null) {
                            l.this.cHe.onNext(dVar);
                            l.this.cHe.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.aYH().c(dVar);
                        c.anI().a(dVar, l.this.anP());
                        ao.aKG();
                        return;
                    }
                    l.this.cGS.f(dVar);
                    if (l.this.cHe != null) {
                        l.this.cHe.onError(new PkgDownloadError(dVar, g));
                    }
                    c.anI().a(dVar, l.this.anP(), g);
                }
            };
        }
        return this.cHO;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> anS() {
        if (this.cHP == null) {
            this.cHP = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.2
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: d */
                public String U(com.baidu.swan.pms.model.b bVar) {
                    return l.this.aob();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void S(com.baidu.swan.pms.model.b bVar) {
                    super.S(bVar);
                    com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onDownloadStart");
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
                    com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cGS.f(bVar);
                    com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(14L).ca(aVar.errorNo).tK("Extension下载失败").tM(aVar.toString());
                    if (l.this.cHf != null) {
                        l.this.cHf.onError(new PkgDownloadError(bVar, tM));
                    }
                    c.anI().a(bVar, l.this.anP(), tM);
                    com.baidu.swan.c.d.deleteFile(bVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: g */
                public void Q(com.baidu.swan.pms.model.b bVar) {
                    super.Q(bVar);
                    com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onFileDownloaded: " + bVar.versionCode);
                    com.baidu.swan.apps.am.a h = l.this.h(bVar);
                    if (h == null) {
                        l.this.cGS.g(bVar);
                        if (l.this.cHf != null) {
                            l.this.cHf.onNext(bVar);
                            l.this.cHf.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.aYH().c(bVar);
                        c.anI().a(bVar, l.this.anP());
                        return;
                    }
                    l.this.cGS.f(bVar);
                    if (l.this.cHf != null) {
                        l.this.cHf.onError(new PkgDownloadError(bVar, h));
                    }
                    c.anI().a(bVar, l.this.anP(), h);
                }
            };
        }
        return this.cHP;
    }

    protected void n(Exception exc) {
        com.baidu.swan.apps.console.c.f("UpdateCoreCallback", "notifyFinalCallback", exc);
        if (this.cHN != null) {
            this.cHN.M(exc);
        }
        this.cHN = null;
    }

    protected void aod() {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
        com.baidu.swan.pms.g.a.m(getCategory(), currentTimeMillis);
        n(null);
    }

    protected void o(Exception exc) {
        com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
        com.baidu.swan.pms.g.a.m(getCategory(), 0L);
        n(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.anI().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cGS.g(dVar);
                if (l.this.cHe != null) {
                    l.this.cHe.onNext(dVar);
                    l.this.cHe.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                l.this.cGS.f(dVar);
                if (l.this.cHe != null) {
                    l.this.cHe.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.anI().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cGS.g(bVar);
                if (l.this.cHf != null) {
                    l.this.cHf.onNext(bVar);
                    l.this.cHf.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                l.this.cGS.f(bVar);
                if (l.this.cHf != null) {
                    l.this.cHf.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void anY() {
        ArrayList arrayList = new ArrayList();
        if (this.cGS.bac()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    l.this.cHe = jVar;
                }
            }));
        }
        if (this.cGS.bad()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    l.this.cHf = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(aoe());
        }
    }

    private rx.j<com.baidu.swan.pms.model.e> aoe() {
        if (this.cHv == null) {
            this.cHv = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.l.7
                @Override // rx.e
                public void onCompleted() {
                    com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "包下载完成");
                    l.this.aod();
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
                    com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.versionCode);
                }
            };
        }
        return this.cHv;
    }
}
