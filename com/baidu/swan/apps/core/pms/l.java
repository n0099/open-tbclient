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
    private rx.j<? super com.baidu.swan.pms.model.d> cUE;
    private rx.j<? super com.baidu.swan.pms.model.b> cUF;
    private rx.j<com.baidu.swan.pms.model.e> cUV;
    private com.baidu.swan.pms.utils.f cUs;
    private com.baidu.swan.apps.ao.e.b<Exception> cVn;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cVo;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cVp;

    protected abstract PMSDownloadType aqL();

    protected abstract String aqW();

    protected abstract String aqX();

    protected abstract com.baidu.swan.apps.al.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.al.a h(com.baidu.swan.pms.model.b bVar);

    public l(com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        this.cVn = bVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqH() {
        super.aqH();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        if (aVar.errorNo == 1010) {
            aqZ();
        } else {
            p(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void anG() {
        super.anG();
        com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onNoPackage:");
        aqZ();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null) {
            this.cUs = fVar;
            if (!this.cUs.isEmpty()) {
                aqU();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> aqN() {
        if (this.cVo == null) {
            this.cVo = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.1
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: c */
                public String U(com.baidu.swan.pms.model.d dVar) {
                    return l.this.aqW();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: d */
                public void S(com.baidu.swan.pms.model.d dVar) {
                    super.S(dVar);
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onDownloadStart");
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
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cUs.f(dVar);
                    com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(13L).dc(aVar.errorNo).tF("Framework包下载失败").tH(aVar.toString());
                    if (l.this.cUE != null) {
                        l.this.cUE.onError(new PkgDownloadError(dVar, tH));
                    }
                    c.aqE().a(dVar, l.this.aqL(), tH);
                    com.baidu.swan.c.d.deleteFile(dVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void Q(com.baidu.swan.pms.model.d dVar) {
                    super.Q(dVar);
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onFileDownloaded: " + dVar.versionCode);
                    com.baidu.swan.apps.al.a g = l.this.g(dVar);
                    if (g == null) {
                        l.this.cUs.g(dVar);
                        if (l.this.cUE != null) {
                            l.this.cUE.onNext(dVar);
                            l.this.cUE.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.bcv().c(dVar);
                        c.aqE().a(dVar, l.this.aqL());
                        ao.aOw();
                        return;
                    }
                    l.this.cUs.f(dVar);
                    if (l.this.cUE != null) {
                        l.this.cUE.onError(new PkgDownloadError(dVar, g));
                    }
                    c.aqE().a(dVar, l.this.aqL(), g);
                }
            };
        }
        return this.cVo;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> aqO() {
        if (this.cVp == null) {
            this.cVp = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.2
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: d */
                public String U(com.baidu.swan.pms.model.b bVar) {
                    return l.this.aqX();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void S(com.baidu.swan.pms.model.b bVar) {
                    super.S(bVar);
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onDownloadStart");
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
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cUs.f(bVar);
                    com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(14L).dc(aVar.errorNo).tF("Extension下载失败").tH(aVar.toString());
                    if (l.this.cUF != null) {
                        l.this.cUF.onError(new PkgDownloadError(bVar, tH));
                    }
                    c.aqE().a(bVar, l.this.aqL(), tH);
                    com.baidu.swan.c.d.deleteFile(bVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: g */
                public void Q(com.baidu.swan.pms.model.b bVar) {
                    super.Q(bVar);
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "onFileDownloaded: " + bVar.versionCode);
                    com.baidu.swan.apps.al.a h = l.this.h(bVar);
                    if (h == null) {
                        l.this.cUs.g(bVar);
                        if (l.this.cUF != null) {
                            l.this.cUF.onNext(bVar);
                            l.this.cUF.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.bcv().c(bVar);
                        c.aqE().a(bVar, l.this.aqL());
                        return;
                    }
                    l.this.cUs.f(bVar);
                    if (l.this.cUF != null) {
                        l.this.cUF.onError(new PkgDownloadError(bVar, h));
                    }
                    c.aqE().a(bVar, l.this.aqL(), h);
                }
            };
        }
        return this.cVp;
    }

    protected void o(Exception exc) {
        com.baidu.swan.apps.console.c.g("UpdateCoreCallback", "notifyFinalCallback", exc);
        if (this.cVn != null) {
            this.cVn.L(exc);
        }
        this.cVn = null;
    }

    protected void aqZ() {
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
        c.aqE().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cUs.g(dVar);
                if (l.this.cUE != null) {
                    l.this.cUE.onNext(dVar);
                    l.this.cUE.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                l.this.cUs.f(dVar);
                if (l.this.cUE != null) {
                    l.this.cUE.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.aqE().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cUs.g(bVar);
                if (l.this.cUF != null) {
                    l.this.cUF.onNext(bVar);
                    l.this.cUF.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                l.this.cUs.f(bVar);
                if (l.this.cUF != null) {
                    l.this.cUF.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void aqU() {
        ArrayList arrayList = new ArrayList();
        if (this.cUs.bdP()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    l.this.cUE = jVar;
                }
            }));
        }
        if (this.cUs.bdQ()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    l.this.cUF = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(ara());
        }
    }

    private rx.j<com.baidu.swan.pms.model.e> ara() {
        if (this.cUV == null) {
            this.cUV = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.l.7
                @Override // rx.e
                public void onCompleted() {
                    com.baidu.swan.apps.console.c.bl("UpdateCoreCallback", "包下载完成");
                    l.this.aqZ();
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
        return this.cUV;
    }
}
