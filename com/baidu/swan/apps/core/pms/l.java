package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ao;
import com.baidu.swan.apps.core.pms.c;
import java.util.ArrayList;
import java.util.Set;
import rx.d;
/* loaded from: classes9.dex */
public abstract class l extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.pms.utils.f cWR;
    private com.baidu.swan.apps.ao.e.b<Exception> cXM;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cXN;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cXO;
    private rx.j<? super com.baidu.swan.pms.model.d> cXd;
    private rx.j<? super com.baidu.swan.pms.model.b> cXe;
    private rx.j<com.baidu.swan.pms.model.e> cXu;

    protected abstract PMSDownloadType aui();

    protected abstract String aut();

    protected abstract String auu();

    protected abstract com.baidu.swan.apps.al.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.al.a h(com.baidu.swan.pms.model.b bVar);

    public l(com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        this.cXM = bVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aue() {
        super.aue();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bs("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        if (aVar.errorNo == 1010) {
            auw();
        } else {
            p(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void ard() {
        super.ard();
        com.baidu.swan.apps.console.c.bs("UpdateCoreCallback", "onNoPackage:");
        auw();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null) {
            this.cWR = fVar;
            if (!this.cWR.isEmpty()) {
                aur();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> auk() {
        if (this.cXN == null) {
            this.cXN = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.1
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: c */
                public String U(com.baidu.swan.pms.model.d dVar) {
                    return l.this.aut();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: d */
                public void S(com.baidu.swan.pms.model.d dVar) {
                    super.S(dVar);
                    com.baidu.swan.apps.console.c.bs("UpdateCoreCallback", "onDownloadStart");
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
                    com.baidu.swan.apps.console.c.bs("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cWR.f(dVar);
                    com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(13L).cW(aVar.errorNo).ux("Framework包下载失败").uz(aVar.toString());
                    if (l.this.cXd != null) {
                        l.this.cXd.onError(new PkgDownloadError(dVar, uz));
                    }
                    c.aub().a(dVar, l.this.aui(), uz);
                    com.baidu.swan.c.d.deleteFile(dVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void Q(com.baidu.swan.pms.model.d dVar) {
                    super.Q(dVar);
                    com.baidu.swan.apps.console.c.bs("UpdateCoreCallback", "onFileDownloaded: " + dVar.versionCode);
                    com.baidu.swan.apps.al.a g = l.this.g(dVar);
                    if (g == null) {
                        l.this.cWR.g(dVar);
                        if (l.this.cXd != null) {
                            l.this.cXd.onNext(dVar);
                            l.this.cXd.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.bgc().c(dVar);
                        c.aub().a(dVar, l.this.aui());
                        ao.aRX();
                        return;
                    }
                    l.this.cWR.f(dVar);
                    if (l.this.cXd != null) {
                        l.this.cXd.onError(new PkgDownloadError(dVar, g));
                    }
                    c.aub().a(dVar, l.this.aui(), g);
                }
            };
        }
        return this.cXN;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> aul() {
        if (this.cXO == null) {
            this.cXO = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.2
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: d */
                public String U(com.baidu.swan.pms.model.b bVar) {
                    return l.this.auu();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void S(com.baidu.swan.pms.model.b bVar) {
                    super.S(bVar);
                    com.baidu.swan.apps.console.c.bs("UpdateCoreCallback", "onDownloadStart");
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
                    com.baidu.swan.apps.console.c.bs("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cWR.f(bVar);
                    com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(14L).cW(aVar.errorNo).ux("Extension下载失败").uz(aVar.toString());
                    if (l.this.cXe != null) {
                        l.this.cXe.onError(new PkgDownloadError(bVar, uz));
                    }
                    c.aub().a(bVar, l.this.aui(), uz);
                    com.baidu.swan.c.d.deleteFile(bVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: g */
                public void Q(com.baidu.swan.pms.model.b bVar) {
                    super.Q(bVar);
                    com.baidu.swan.apps.console.c.bs("UpdateCoreCallback", "onFileDownloaded: " + bVar.versionCode);
                    com.baidu.swan.apps.al.a h = l.this.h(bVar);
                    if (h == null) {
                        l.this.cWR.g(bVar);
                        if (l.this.cXe != null) {
                            l.this.cXe.onNext(bVar);
                            l.this.cXe.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.bgc().c(bVar);
                        c.aub().a(bVar, l.this.aui());
                        return;
                    }
                    l.this.cWR.f(bVar);
                    if (l.this.cXe != null) {
                        l.this.cXe.onError(new PkgDownloadError(bVar, h));
                    }
                    c.aub().a(bVar, l.this.aui(), h);
                }
            };
        }
        return this.cXO;
    }

    protected void o(Exception exc) {
        com.baidu.swan.apps.console.c.g("UpdateCoreCallback", "notifyFinalCallback", exc);
        if (this.cXM != null) {
            this.cXM.L(exc);
        }
        this.cXM = null;
    }

    protected void auw() {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.console.c.bs("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
        com.baidu.swan.pms.g.a.l(getCategory(), currentTimeMillis);
        o(null);
    }

    protected void p(Exception exc) {
        com.baidu.swan.apps.console.c.bs("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
        com.baidu.swan.pms.g.a.l(getCategory(), 0L);
        o(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.aub().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cWR.g(dVar);
                if (l.this.cXd != null) {
                    l.this.cXd.onNext(dVar);
                    l.this.cXd.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                l.this.cWR.f(dVar);
                if (l.this.cXd != null) {
                    l.this.cXd.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.aub().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cWR.g(bVar);
                if (l.this.cXe != null) {
                    l.this.cXe.onNext(bVar);
                    l.this.cXe.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                l.this.cWR.f(bVar);
                if (l.this.cXe != null) {
                    l.this.cXe.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void aur() {
        ArrayList arrayList = new ArrayList();
        if (this.cWR.bhw()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    l.this.cXd = jVar;
                }
            }));
        }
        if (this.cWR.bhx()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    l.this.cXe = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(aux());
        }
    }

    private rx.j<com.baidu.swan.pms.model.e> aux() {
        if (this.cXu == null) {
            this.cXu = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.l.7
                @Override // rx.e
                public void onCompleted() {
                    com.baidu.swan.apps.console.c.bs("UpdateCoreCallback", "包下载完成");
                    l.this.auw();
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
                    com.baidu.swan.apps.console.c.bs("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.versionCode);
                }
            };
        }
        return this.cXu;
    }
}
