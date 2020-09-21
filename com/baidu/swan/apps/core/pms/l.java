package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.ap.ao;
import com.baidu.swan.apps.core.pms.c;
import java.util.ArrayList;
import java.util.Set;
import rx.d;
/* loaded from: classes3.dex */
public abstract class l extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private rx.j<com.baidu.swan.pms.model.e> cmI;
    private com.baidu.swan.pms.utils.f cmf;
    private rx.j<? super com.baidu.swan.pms.model.d> cmr;
    private rx.j<? super com.baidu.swan.pms.model.b> cms;
    private com.baidu.swan.apps.ap.e.b<Exception> cna;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cnb;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cnc;

    protected abstract PMSDownloadType ajk();

    protected abstract String ajv();

    protected abstract String ajw();

    protected abstract com.baidu.swan.apps.am.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.am.a h(com.baidu.swan.pms.model.b bVar);

    public l(com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cna = bVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ajg() {
        super.ajg();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        com.baidu.swan.apps.console.c.bb("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        if (aVar.errorNo == 1010) {
            ajy();
        } else {
            o(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void agl() {
        super.agl();
        com.baidu.swan.apps.console.c.bb("UpdateCoreCallback", "onNoPackage:");
        ajy();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        if (fVar != null) {
            this.cmf = fVar;
            if (!this.cmf.isEmpty()) {
                ajt();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> ajm() {
        if (this.cnb == null) {
            this.cnb = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.1
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: c */
                public String R(com.baidu.swan.pms.model.d dVar) {
                    return l.this.ajv();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: d */
                public void P(com.baidu.swan.pms.model.d dVar) {
                    super.P(dVar);
                    com.baidu.swan.apps.console.c.bb("UpdateCoreCallback", "onDownloadStart");
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void Q(com.baidu.swan.pms.model.d dVar) {
                    super.Q(dVar);
                    if (l.DEBUG) {
                        Log.i("UpdateCoreCallback", "framework onDownloading");
                    }
                    l.this.b(dVar);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
                    super.a((AnonymousClass1) dVar, aVar);
                    com.baidu.swan.apps.console.c.bb("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cmf.f(dVar);
                    com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(13L).bQ(aVar.errorNo).sF("Framework包下载失败").sH(aVar.toString());
                    if (l.this.cmr != null) {
                        l.this.cmr.onError(new PkgDownloadError(dVar, sH));
                    }
                    c.ajd().a(dVar, l.this.ajk(), sH);
                    com.baidu.swan.c.d.deleteFile(dVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void N(com.baidu.swan.pms.model.d dVar) {
                    super.N(dVar);
                    com.baidu.swan.apps.console.c.bb("UpdateCoreCallback", "onFileDownloaded: " + dVar.versionCode);
                    com.baidu.swan.apps.am.a g = l.this.g(dVar);
                    if (g == null) {
                        l.this.cmf.g(dVar);
                        if (l.this.cmr != null) {
                            l.this.cmr.onNext(dVar);
                            l.this.cmr.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.aUf().c(dVar);
                        c.ajd().a(dVar, l.this.ajk());
                        ao.aGd();
                        return;
                    }
                    l.this.cmf.f(dVar);
                    if (l.this.cmr != null) {
                        l.this.cmr.onError(new PkgDownloadError(dVar, g));
                    }
                    c.ajd().a(dVar, l.this.ajk(), g);
                }
            };
        }
        return this.cnb;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> ajn() {
        if (this.cnc == null) {
            this.cnc = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.2
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return l.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: d */
                public String R(com.baidu.swan.pms.model.b bVar) {
                    return l.this.ajw();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void P(com.baidu.swan.pms.model.b bVar) {
                    super.P(bVar);
                    com.baidu.swan.apps.console.c.bb("UpdateCoreCallback", "onDownloadStart");
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void Q(com.baidu.swan.pms.model.b bVar) {
                    super.Q(bVar);
                    if (l.DEBUG) {
                        Log.i("UpdateCoreCallback", "extension onDownloading");
                    }
                    l.this.b(bVar);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
                    super.a((AnonymousClass2) bVar, aVar);
                    com.baidu.swan.apps.console.c.bb("UpdateCoreCallback", "onDownloadError:" + aVar);
                    l.this.cmf.f(bVar);
                    com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(14L).bQ(aVar.errorNo).sF("Extension下载失败").sH(aVar.toString());
                    if (l.this.cms != null) {
                        l.this.cms.onError(new PkgDownloadError(bVar, sH));
                    }
                    c.ajd().a(bVar, l.this.ajk(), sH);
                    com.baidu.swan.c.d.deleteFile(bVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: g */
                public void N(com.baidu.swan.pms.model.b bVar) {
                    super.N(bVar);
                    com.baidu.swan.apps.console.c.bb("UpdateCoreCallback", "onFileDownloaded: " + bVar.versionCode);
                    com.baidu.swan.apps.am.a h = l.this.h(bVar);
                    if (h == null) {
                        l.this.cmf.g(bVar);
                        if (l.this.cms != null) {
                            l.this.cms.onNext(bVar);
                            l.this.cms.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.aUf().c(bVar);
                        c.ajd().a(bVar, l.this.ajk());
                        return;
                    }
                    l.this.cmf.f(bVar);
                    if (l.this.cms != null) {
                        l.this.cms.onError(new PkgDownloadError(bVar, h));
                    }
                    c.ajd().a(bVar, l.this.ajk(), h);
                }
            };
        }
        return this.cnc;
    }

    protected void n(Exception exc) {
        com.baidu.swan.apps.console.c.f("UpdateCoreCallback", "notifyFinalCallback", exc);
        if (this.cna != null) {
            this.cna.J(exc);
        }
        this.cna = null;
    }

    protected void ajy() {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.console.c.bb("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
        com.baidu.swan.pms.g.a.l(getCategory(), currentTimeMillis);
        n(null);
    }

    protected void o(Exception exc) {
        com.baidu.swan.apps.console.c.bb("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
        com.baidu.swan.pms.g.a.l(getCategory(), 0L);
        n(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.ajd().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cmf.g(dVar);
                if (l.this.cmr != null) {
                    l.this.cmr.onNext(dVar);
                    l.this.cmr.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                l.this.cmf.f(dVar);
                if (l.this.cmr != null) {
                    l.this.cmr.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.ajd().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.l.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                l.this.cmf.g(bVar);
                if (l.this.cms != null) {
                    l.this.cms.onNext(bVar);
                    l.this.cms.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                l.this.cmf.f(bVar);
                if (l.this.cms != null) {
                    l.this.cms.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void ajt() {
        ArrayList arrayList = new ArrayList();
        if (this.cmf.aVA()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.l.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    l.this.cmr = jVar;
                }
            }));
        }
        if (this.cmf.aVB()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.l.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    l.this.cms = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(ajz());
        }
    }

    private rx.j<com.baidu.swan.pms.model.e> ajz() {
        if (this.cmI == null) {
            this.cmI = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.l.7
                @Override // rx.e
                public void onCompleted() {
                    com.baidu.swan.apps.console.c.bb("UpdateCoreCallback", "包下载完成");
                    l.this.ajy();
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
                    com.baidu.swan.apps.console.c.bb("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.versionCode);
                }
            };
        }
        return this.cmI;
    }
}
