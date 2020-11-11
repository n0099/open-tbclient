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
    private com.baidu.swan.pms.utils.f cML;
    private rx.j<? super com.baidu.swan.pms.model.d> cMX;
    private rx.j<? super com.baidu.swan.pms.model.b> cMY;
    private com.baidu.swan.apps.ap.e.b<Exception> cNG;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cNH;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cNI;
    private rx.j<com.baidu.swan.pms.model.e> cNo;

    protected abstract String aqB();

    protected abstract String aqC();

    protected abstract PMSDownloadType aqq();

    protected abstract com.baidu.swan.apps.am.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.am.a h(com.baidu.swan.pms.model.b bVar);

    public l(com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cNG = bVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqm() {
        super.aqm();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        if (aVar.errorNo == 1010) {
            aqE();
        } else {
            o(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void anq() {
        super.anq();
        com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onNoPackage:");
        aqE();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null) {
            this.cML = fVar;
            if (!this.cML.isEmpty()) {
                aqz();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> aqs() {
        if (this.cNH == null) {
            this.cNH = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.1
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: c */
                public String U(com.baidu.swan.pms.model.d dVar) {
                    return l.this.aqB();
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
                    l.this.cML.f(dVar);
                    com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(13L).cw(aVar.errorNo).tY("Framework包下载失败").ua(aVar.toString());
                    if (l.this.cMX != null) {
                        l.this.cMX.onError(new PkgDownloadError(dVar, ua));
                    }
                    c.aqj().a(dVar, l.this.aqq(), ua);
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
                        l.this.cML.g(dVar);
                        if (l.this.cMX != null) {
                            l.this.cMX.onNext(dVar);
                            l.this.cMX.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.bbh().c(dVar);
                        c.aqj().a(dVar, l.this.aqq());
                        ao.aNg();
                        return;
                    }
                    l.this.cML.f(dVar);
                    if (l.this.cMX != null) {
                        l.this.cMX.onError(new PkgDownloadError(dVar, g));
                    }
                    c.aqj().a(dVar, l.this.aqq(), g);
                }
            };
        }
        return this.cNH;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> aqt() {
        if (this.cNI == null) {
            this.cNI = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.2
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: d */
                public String U(com.baidu.swan.pms.model.b bVar) {
                    return l.this.aqC();
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
                    l.this.cML.f(bVar);
                    com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(14L).cw(aVar.errorNo).tY("Extension下载失败").ua(aVar.toString());
                    if (l.this.cMY != null) {
                        l.this.cMY.onError(new PkgDownloadError(bVar, ua));
                    }
                    c.aqj().a(bVar, l.this.aqq(), ua);
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
                        l.this.cML.g(bVar);
                        if (l.this.cMY != null) {
                            l.this.cMY.onNext(bVar);
                            l.this.cMY.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.bbh().c(bVar);
                        c.aqj().a(bVar, l.this.aqq());
                        return;
                    }
                    l.this.cML.f(bVar);
                    if (l.this.cMY != null) {
                        l.this.cMY.onError(new PkgDownloadError(bVar, h));
                    }
                    c.aqj().a(bVar, l.this.aqq(), h);
                }
            };
        }
        return this.cNI;
    }

    protected void n(Exception exc) {
        com.baidu.swan.apps.console.c.f("UpdateCoreCallback", "notifyFinalCallback", exc);
        if (this.cNG != null) {
            this.cNG.M(exc);
        }
        this.cNG = null;
    }

    protected void aqE() {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
        com.baidu.swan.pms.g.a.l(getCategory(), currentTimeMillis);
        n(null);
    }

    protected void o(Exception exc) {
        com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
        com.baidu.swan.pms.g.a.l(getCategory(), 0L);
        n(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.aqj().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cML.g(dVar);
                if (l.this.cMX != null) {
                    l.this.cMX.onNext(dVar);
                    l.this.cMX.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                l.this.cML.f(dVar);
                if (l.this.cMX != null) {
                    l.this.cMX.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.aqj().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cML.g(bVar);
                if (l.this.cMY != null) {
                    l.this.cMY.onNext(bVar);
                    l.this.cMY.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                l.this.cML.f(bVar);
                if (l.this.cMY != null) {
                    l.this.cMY.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void aqz() {
        ArrayList arrayList = new ArrayList();
        if (this.cML.bcC()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    l.this.cMX = jVar;
                }
            }));
        }
        if (this.cML.bcD()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    l.this.cMY = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(aqF());
        }
    }

    private rx.j<com.baidu.swan.pms.model.e> aqF() {
        if (this.cNo == null) {
            this.cNo = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.l.7
                @Override // rx.e
                public void onCompleted() {
                    com.baidu.swan.apps.console.c.bn("UpdateCoreCallback", "包下载完成");
                    l.this.aqE();
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
        return this.cNo;
    }
}
