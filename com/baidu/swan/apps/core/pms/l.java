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
    private rx.j<? super com.baidu.swan.pms.model.d> cyI;
    private rx.j<? super com.baidu.swan.pms.model.b> cyJ;
    private rx.j<com.baidu.swan.pms.model.e> cyZ;
    private com.baidu.swan.pms.utils.f cyw;
    private com.baidu.swan.apps.ap.e.b<Exception> czr;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> czs;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> czt;

    protected abstract PMSDownloadType alV();

    protected abstract String amg();

    protected abstract String amh();

    protected abstract com.baidu.swan.apps.am.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.am.a h(com.baidu.swan.pms.model.b bVar);

    public l(com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.czr = bVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void alR() {
        super.alR();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bg("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        if (aVar.errorNo == 1010) {
            amj();
        } else {
            o(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiW() {
        super.aiW();
        com.baidu.swan.apps.console.c.bg("UpdateCoreCallback", "onNoPackage:");
        amj();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null) {
            this.cyw = fVar;
            if (!this.cyw.isEmpty()) {
                ame();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> alX() {
        if (this.czs == null) {
            this.czs = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.1
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: c */
                public String U(com.baidu.swan.pms.model.d dVar) {
                    return l.this.amg();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: d */
                public void S(com.baidu.swan.pms.model.d dVar) {
                    super.S(dVar);
                    com.baidu.swan.apps.console.c.bg("UpdateCoreCallback", "onDownloadStart");
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
                    com.baidu.swan.apps.console.c.bg("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cyw.f(dVar);
                    com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(13L).bY(aVar.errorNo).tr("Framework包下载失败").tt(aVar.toString());
                    if (l.this.cyI != null) {
                        l.this.cyI.onError(new PkgDownloadError(dVar, tt));
                    }
                    c.alO().a(dVar, l.this.alV(), tt);
                    com.baidu.swan.c.d.deleteFile(dVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void Q(com.baidu.swan.pms.model.d dVar) {
                    super.Q(dVar);
                    com.baidu.swan.apps.console.c.bg("UpdateCoreCallback", "onFileDownloaded: " + dVar.versionCode);
                    com.baidu.swan.apps.am.a g = l.this.g(dVar);
                    if (g == null) {
                        l.this.cyw.g(dVar);
                        if (l.this.cyI != null) {
                            l.this.cyI.onNext(dVar);
                            l.this.cyI.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.aWO().c(dVar);
                        c.alO().a(dVar, l.this.alV());
                        ao.aIM();
                        return;
                    }
                    l.this.cyw.f(dVar);
                    if (l.this.cyI != null) {
                        l.this.cyI.onError(new PkgDownloadError(dVar, g));
                    }
                    c.alO().a(dVar, l.this.alV(), g);
                }
            };
        }
        return this.czs;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> alY() {
        if (this.czt == null) {
            this.czt = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.2
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: d */
                public String U(com.baidu.swan.pms.model.b bVar) {
                    return l.this.amh();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void S(com.baidu.swan.pms.model.b bVar) {
                    super.S(bVar);
                    com.baidu.swan.apps.console.c.bg("UpdateCoreCallback", "onDownloadStart");
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
                    com.baidu.swan.apps.console.c.bg("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cyw.f(bVar);
                    com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(14L).bY(aVar.errorNo).tr("Extension下载失败").tt(aVar.toString());
                    if (l.this.cyJ != null) {
                        l.this.cyJ.onError(new PkgDownloadError(bVar, tt));
                    }
                    c.alO().a(bVar, l.this.alV(), tt);
                    com.baidu.swan.c.d.deleteFile(bVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: g */
                public void Q(com.baidu.swan.pms.model.b bVar) {
                    super.Q(bVar);
                    com.baidu.swan.apps.console.c.bg("UpdateCoreCallback", "onFileDownloaded: " + bVar.versionCode);
                    com.baidu.swan.apps.am.a h = l.this.h(bVar);
                    if (h == null) {
                        l.this.cyw.g(bVar);
                        if (l.this.cyJ != null) {
                            l.this.cyJ.onNext(bVar);
                            l.this.cyJ.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.aWO().c(bVar);
                        c.alO().a(bVar, l.this.alV());
                        return;
                    }
                    l.this.cyw.f(bVar);
                    if (l.this.cyJ != null) {
                        l.this.cyJ.onError(new PkgDownloadError(bVar, h));
                    }
                    c.alO().a(bVar, l.this.alV(), h);
                }
            };
        }
        return this.czt;
    }

    protected void n(Exception exc) {
        com.baidu.swan.apps.console.c.f("UpdateCoreCallback", "notifyFinalCallback", exc);
        if (this.czr != null) {
            this.czr.M(exc);
        }
        this.czr = null;
    }

    protected void amj() {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.console.c.bg("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
        com.baidu.swan.pms.g.a.m(getCategory(), currentTimeMillis);
        n(null);
    }

    protected void o(Exception exc) {
        com.baidu.swan.apps.console.c.bg("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
        com.baidu.swan.pms.g.a.m(getCategory(), 0L);
        n(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.alO().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cyw.g(dVar);
                if (l.this.cyI != null) {
                    l.this.cyI.onNext(dVar);
                    l.this.cyI.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                l.this.cyw.f(dVar);
                if (l.this.cyI != null) {
                    l.this.cyI.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.alO().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cyw.g(bVar);
                if (l.this.cyJ != null) {
                    l.this.cyJ.onNext(bVar);
                    l.this.cyJ.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                l.this.cyw.f(bVar);
                if (l.this.cyJ != null) {
                    l.this.cyJ.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void ame() {
        ArrayList arrayList = new ArrayList();
        if (this.cyw.aYj()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    l.this.cyI = jVar;
                }
            }));
        }
        if (this.cyw.aYk()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    l.this.cyJ = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(amk());
        }
    }

    private rx.j<com.baidu.swan.pms.model.e> amk() {
        if (this.cyZ == null) {
            this.cyZ = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.l.7
                @Override // rx.e
                public void onCompleted() {
                    com.baidu.swan.apps.console.c.bg("UpdateCoreCallback", "包下载完成");
                    l.this.amj();
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
                    com.baidu.swan.apps.console.c.bg("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.versionCode);
                }
            };
        }
        return this.cyZ;
    }
}
