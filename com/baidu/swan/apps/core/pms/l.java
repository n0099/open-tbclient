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
    private rx.j<com.baidu.swan.pms.model.e> cSI;
    private com.baidu.swan.pms.utils.f cSf;
    private rx.j<? super com.baidu.swan.pms.model.d> cSr;
    private rx.j<? super com.baidu.swan.pms.model.b> cSs;
    private com.baidu.swan.apps.ao.e.b<Exception> cTa;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cTb;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cTc;

    protected abstract PMSDownloadType aqn();

    protected abstract String aqy();

    protected abstract String aqz();

    protected abstract com.baidu.swan.apps.al.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.al.a h(com.baidu.swan.pms.model.b bVar);

    public l(com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        this.cTa = bVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqj() {
        super.aqj();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.br("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        if (aVar.errorNo == 1010) {
            aqB();
        } else {
            p(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void ani() {
        super.ani();
        com.baidu.swan.apps.console.c.br("UpdateCoreCallback", "onNoPackage:");
        aqB();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null) {
            this.cSf = fVar;
            if (!this.cSf.isEmpty()) {
                aqw();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> aqp() {
        if (this.cTb == null) {
            this.cTb = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.1
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: c */
                public String U(com.baidu.swan.pms.model.d dVar) {
                    return l.this.aqy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: d */
                public void S(com.baidu.swan.pms.model.d dVar) {
                    super.S(dVar);
                    com.baidu.swan.apps.console.c.br("UpdateCoreCallback", "onDownloadStart");
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
                    com.baidu.swan.apps.console.c.br("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cSf.f(dVar);
                    com.baidu.swan.apps.al.a aVar2 = new com.baidu.swan.apps.al.a().cV(13L).cW(aVar.errorNo).tm("Framework包下载失败").to(aVar.toString());
                    if (l.this.cSr != null) {
                        l.this.cSr.onError(new PkgDownloadError(dVar, aVar2));
                    }
                    c.aqg().a(dVar, l.this.aqn(), aVar2);
                    com.baidu.swan.c.d.deleteFile(dVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void Q(com.baidu.swan.pms.model.d dVar) {
                    super.Q(dVar);
                    com.baidu.swan.apps.console.c.br("UpdateCoreCallback", "onFileDownloaded: " + dVar.versionCode);
                    com.baidu.swan.apps.al.a g = l.this.g(dVar);
                    if (g == null) {
                        l.this.cSf.g(dVar);
                        if (l.this.cSr != null) {
                            l.this.cSr.onNext(dVar);
                            l.this.cSr.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.bci().c(dVar);
                        c.aqg().a(dVar, l.this.aqn());
                        ao.aOd();
                        return;
                    }
                    l.this.cSf.f(dVar);
                    if (l.this.cSr != null) {
                        l.this.cSr.onError(new PkgDownloadError(dVar, g));
                    }
                    c.aqg().a(dVar, l.this.aqn(), g);
                }
            };
        }
        return this.cTb;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> aqq() {
        if (this.cTc == null) {
            this.cTc = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.2
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: d */
                public String U(com.baidu.swan.pms.model.b bVar) {
                    return l.this.aqz();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void S(com.baidu.swan.pms.model.b bVar) {
                    super.S(bVar);
                    com.baidu.swan.apps.console.c.br("UpdateCoreCallback", "onDownloadStart");
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
                    com.baidu.swan.apps.console.c.br("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cSf.f(bVar);
                    com.baidu.swan.apps.al.a aVar2 = new com.baidu.swan.apps.al.a().cV(14L).cW(aVar.errorNo).tm("Extension下载失败").to(aVar.toString());
                    if (l.this.cSs != null) {
                        l.this.cSs.onError(new PkgDownloadError(bVar, aVar2));
                    }
                    c.aqg().a(bVar, l.this.aqn(), aVar2);
                    com.baidu.swan.c.d.deleteFile(bVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: g */
                public void Q(com.baidu.swan.pms.model.b bVar) {
                    super.Q(bVar);
                    com.baidu.swan.apps.console.c.br("UpdateCoreCallback", "onFileDownloaded: " + bVar.versionCode);
                    com.baidu.swan.apps.al.a h = l.this.h(bVar);
                    if (h == null) {
                        l.this.cSf.g(bVar);
                        if (l.this.cSs != null) {
                            l.this.cSs.onNext(bVar);
                            l.this.cSs.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.bci().c(bVar);
                        c.aqg().a(bVar, l.this.aqn());
                        return;
                    }
                    l.this.cSf.f(bVar);
                    if (l.this.cSs != null) {
                        l.this.cSs.onError(new PkgDownloadError(bVar, h));
                    }
                    c.aqg().a(bVar, l.this.aqn(), h);
                }
            };
        }
        return this.cTc;
    }

    protected void o(Exception exc) {
        com.baidu.swan.apps.console.c.g("UpdateCoreCallback", "notifyFinalCallback", exc);
        if (this.cTa != null) {
            this.cTa.L(exc);
        }
        this.cTa = null;
    }

    protected void aqB() {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.console.c.br("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
        com.baidu.swan.pms.g.a.l(getCategory(), currentTimeMillis);
        o(null);
    }

    protected void p(Exception exc) {
        com.baidu.swan.apps.console.c.br("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
        com.baidu.swan.pms.g.a.l(getCategory(), 0L);
        o(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.aqg().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cSf.g(dVar);
                if (l.this.cSr != null) {
                    l.this.cSr.onNext(dVar);
                    l.this.cSr.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                l.this.cSf.f(dVar);
                if (l.this.cSr != null) {
                    l.this.cSr.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.aqg().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cSf.g(bVar);
                if (l.this.cSs != null) {
                    l.this.cSs.onNext(bVar);
                    l.this.cSs.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                l.this.cSf.f(bVar);
                if (l.this.cSs != null) {
                    l.this.cSs.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void aqw() {
        ArrayList arrayList = new ArrayList();
        if (this.cSf.bdC()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    l.this.cSr = jVar;
                }
            }));
        }
        if (this.cSf.bdD()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    l.this.cSs = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(aqC());
        }
    }

    private rx.j<com.baidu.swan.pms.model.e> aqC() {
        if (this.cSI == null) {
            this.cSI = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.l.7
                @Override // rx.e
                public void onCompleted() {
                    com.baidu.swan.apps.console.c.br("UpdateCoreCallback", "包下载完成");
                    l.this.aqB();
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
                    com.baidu.swan.apps.console.c.br("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.versionCode);
                }
            };
        }
        return this.cSI;
    }
}
