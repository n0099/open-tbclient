package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ao;
import com.baidu.swan.apps.core.pms.c;
import java.util.ArrayList;
import java.util.Set;
import rx.d;
/* loaded from: classes8.dex */
public abstract class l extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.utils.f cVS;
    private com.baidu.swan.apps.ao.e.b<Exception> cWN;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cWO;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cWP;
    private rx.j<? super com.baidu.swan.pms.model.d> cWe;
    private rx.j<? super com.baidu.swan.pms.model.b> cWf;
    private rx.j<com.baidu.swan.pms.model.e> cWv;

    protected abstract PMSDownloadType aqO();

    protected abstract String aqZ();

    protected abstract String ara();

    protected abstract com.baidu.swan.apps.al.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.al.a h(com.baidu.swan.pms.model.b bVar);

    public l(com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        this.cWN = bVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqK() {
        super.aqK();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        if (aVar.errorNo == 1010) {
            arc();
        } else {
            p(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void anJ() {
        super.anJ();
        com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onNoPackage:");
        arc();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null) {
            this.cVS = fVar;
            if (!this.cVS.isEmpty()) {
                aqX();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> aqQ() {
        if (this.cWO == null) {
            this.cWO = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.1
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: c */
                public String W(com.baidu.swan.pms.model.d dVar) {
                    return l.this.aqZ();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: d */
                public void U(com.baidu.swan.pms.model.d dVar) {
                    super.U(dVar);
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onDownloadStart");
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void V(com.baidu.swan.pms.model.d dVar) {
                    super.V(dVar);
                    if (l.DEBUG) {
                        Log.i("UpdateCoreCallback", "framework onDownloading");
                    }
                    l.this.b(dVar);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
                    super.a((AnonymousClass1) dVar, aVar);
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cVS.f(dVar);
                    com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(13L).dc(aVar.errorNo).tM("Framework包下载失败").tO(aVar.toString());
                    if (l.this.cWe != null) {
                        l.this.cWe.onError(new PkgDownloadError(dVar, tO));
                    }
                    c.aqH().a(dVar, l.this.aqO(), tO);
                    com.baidu.swan.c.d.deleteFile(dVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void S(com.baidu.swan.pms.model.d dVar) {
                    super.S(dVar);
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onFileDownloaded: " + dVar.versionCode);
                    com.baidu.swan.apps.al.a g = l.this.g(dVar);
                    if (g == null) {
                        l.this.cVS.g(dVar);
                        if (l.this.cWe != null) {
                            l.this.cWe.onNext(dVar);
                            l.this.cWe.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.bcx().c(dVar);
                        c.aqH().a(dVar, l.this.aqO());
                        ao.aOz();
                        return;
                    }
                    l.this.cVS.f(dVar);
                    if (l.this.cWe != null) {
                        l.this.cWe.onError(new PkgDownloadError(dVar, g));
                    }
                    c.aqH().a(dVar, l.this.aqO(), g);
                }
            };
        }
        return this.cWO;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> aqR() {
        if (this.cWP == null) {
            this.cWP = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.2
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: d */
                public String W(com.baidu.swan.pms.model.b bVar) {
                    return l.this.ara();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void U(com.baidu.swan.pms.model.b bVar) {
                    super.U(bVar);
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onDownloadStart");
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void V(com.baidu.swan.pms.model.b bVar) {
                    super.V(bVar);
                    if (l.DEBUG) {
                        Log.i("UpdateCoreCallback", "extension onDownloading");
                    }
                    l.this.b(bVar);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
                    super.a((AnonymousClass2) bVar, aVar);
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cVS.f(bVar);
                    com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(14L).dc(aVar.errorNo).tM("Extension下载失败").tO(aVar.toString());
                    if (l.this.cWf != null) {
                        l.this.cWf.onError(new PkgDownloadError(bVar, tO));
                    }
                    c.aqH().a(bVar, l.this.aqO(), tO);
                    com.baidu.swan.c.d.deleteFile(bVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: g */
                public void S(com.baidu.swan.pms.model.b bVar) {
                    super.S(bVar);
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onFileDownloaded: " + bVar.versionCode);
                    com.baidu.swan.apps.al.a h = l.this.h(bVar);
                    if (h == null) {
                        l.this.cVS.g(bVar);
                        if (l.this.cWf != null) {
                            l.this.cWf.onNext(bVar);
                            l.this.cWf.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.bcx().c(bVar);
                        c.aqH().a(bVar, l.this.aqO());
                        return;
                    }
                    l.this.cVS.f(bVar);
                    if (l.this.cWf != null) {
                        l.this.cWf.onError(new PkgDownloadError(bVar, h));
                    }
                    c.aqH().a(bVar, l.this.aqO(), h);
                }
            };
        }
        return this.cWP;
    }

    protected void o(Exception exc) {
        com.baidu.swan.apps.console.c.g("UpdateCoreCallback", "notifyFinalCallback", exc);
        if (this.cWN != null) {
            this.cWN.N(exc);
        }
        this.cWN = null;
    }

    protected void arc() {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
        com.baidu.swan.pms.g.a.m(getCategory(), currentTimeMillis);
        o(null);
    }

    protected void p(Exception exc) {
        com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
        com.baidu.swan.pms.g.a.m(getCategory(), 0L);
        o(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.aqH().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cVS.g(dVar);
                if (l.this.cWe != null) {
                    l.this.cWe.onNext(dVar);
                    l.this.cWe.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                l.this.cVS.f(dVar);
                if (l.this.cWe != null) {
                    l.this.cWe.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.aqH().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cVS.g(bVar);
                if (l.this.cWf != null) {
                    l.this.cWf.onNext(bVar);
                    l.this.cWf.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                l.this.cVS.f(bVar);
                if (l.this.cWf != null) {
                    l.this.cWf.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void aqX() {
        ArrayList arrayList = new ArrayList();
        if (this.cVS.bdR()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    l.this.cWe = jVar;
                }
            }));
        }
        if (this.cVS.bdS()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    l.this.cWf = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(ard());
        }
    }

    private rx.j<com.baidu.swan.pms.model.e> ard() {
        if (this.cWv == null) {
            this.cWv = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.l.7
                @Override // rx.e
                public void onCompleted() {
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "包下载完成");
                    l.this.arc();
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    com.baidu.swan.apps.console.c.g("UpdateCoreCallback", "OnError", th);
                    l.this.p(new Exception("UpdateCoreCallback failed by Download error = ", th));
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.e
                /* renamed from: a */
                public void onNext(com.baidu.swan.pms.model.e eVar) {
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.versionCode);
                }
            };
        }
        return this.cWv;
    }
}
