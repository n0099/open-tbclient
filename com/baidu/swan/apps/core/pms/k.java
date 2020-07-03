package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.aq.am;
import com.baidu.swan.apps.core.pms.c;
import java.util.ArrayList;
import java.util.Set;
import rx.d;
/* loaded from: classes11.dex */
public abstract class k extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private rx.j<com.baidu.swan.pms.model.e> ccJ;
    private com.baidu.swan.apps.aq.e.b<Exception> ccX;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> ccY;
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> ccZ;
    private com.baidu.swan.pms.f.e ccf;
    private rx.j<? super com.baidu.swan.pms.model.d> ccp;
    private rx.j<? super com.baidu.swan.pms.model.b> ccq;

    protected abstract PMSDownloadType aaY();

    protected abstract String abk();

    protected abstract String abl();

    protected abstract com.baidu.swan.apps.an.a g(com.baidu.swan.pms.model.d dVar);

    protected abstract int getCategory();

    protected abstract com.baidu.swan.apps.an.a h(com.baidu.swan.pms.model.b bVar);

    public k(com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        this.ccX = bVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaV() {
        super.aaV();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        }
        if (aVar.errorNo == 1010) {
            abm();
        } else {
            o(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaR() {
        super.aaR();
        if (DEBUG) {
            Log.e("UpdateCoreCallback", "onNoPackage:");
        }
        abm();
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.ccf = eVar;
            if (!this.ccf.isEmpty()) {
                abi();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> abb() {
        if (this.ccY == null) {
            this.ccY = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.k.1
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return k.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: c */
                public String P(com.baidu.swan.pms.model.d dVar) {
                    return k.this.abk();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: d */
                public void N(com.baidu.swan.pms.model.d dVar) {
                    super.N(dVar);
                    if (k.DEBUG) {
                        Log.i("UpdateCoreCallback", "onDownloadStart");
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void O(com.baidu.swan.pms.model.d dVar) {
                    super.O(dVar);
                    if (k.DEBUG) {
                        Log.i("UpdateCoreCallback", "framework onDownloading");
                    }
                    k.this.b(dVar);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
                    super.a((AnonymousClass1) dVar, aVar);
                    if (k.DEBUG) {
                        Log.i("UpdateCoreCallback", "onDownloadError:" + aVar);
                    }
                    k.this.ccf.f(dVar);
                    com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(13L).bx(aVar.errorNo).pz("Framework包下载失败").pB(aVar.toString());
                    if (k.this.ccp != null) {
                        k.this.ccp.onError(new PkgDownloadError(dVar, pB));
                    }
                    c.aaT().a(dVar, k.this.aaY(), pB);
                    com.baidu.swan.e.d.deleteFile(dVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void L(com.baidu.swan.pms.model.d dVar) {
                    super.L(dVar);
                    if (k.DEBUG) {
                        Log.d("UpdateCoreCallback", "onFileDownloaded: " + dVar.toString());
                    }
                    com.baidu.swan.apps.an.a g = k.this.g(dVar);
                    if (g == null) {
                        k.this.ccf.g(dVar);
                        if (k.this.ccp != null) {
                            k.this.ccp.onNext(dVar);
                            k.this.ccp.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.aHb().c(dVar);
                        c.aaT().a(dVar, k.this.aaY());
                        am.avb();
                        return;
                    }
                    k.this.ccf.f(dVar);
                    if (k.this.ccp != null) {
                        k.this.ccp.onError(new PkgDownloadError(dVar, g));
                    }
                    c.aaT().a(dVar, k.this.aaY(), g);
                }
            };
        }
        return this.ccY;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> abc() {
        if (this.ccZ == null) {
            this.ccZ = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.k.2
                @Override // com.baidu.swan.pms.a.e
                @NonNull
                public Bundle a(@NonNull Bundle bundle, Set<String> set) {
                    return k.this.a(bundle, set);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.c
                /* renamed from: d */
                public String P(com.baidu.swan.pms.model.b bVar) {
                    return k.this.abl();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: e */
                public void N(com.baidu.swan.pms.model.b bVar) {
                    super.N(bVar);
                    if (k.DEBUG) {
                        Log.i("UpdateCoreCallback", "onDownloadStart");
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: f */
                public void O(com.baidu.swan.pms.model.b bVar) {
                    super.O(bVar);
                    if (k.DEBUG) {
                        Log.i("UpdateCoreCallback", "extension onDownloading");
                    }
                    k.this.b(bVar);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
                    super.a((AnonymousClass2) bVar, aVar);
                    if (k.DEBUG) {
                        Log.i("UpdateCoreCallback", "onDownloadError:" + aVar);
                    }
                    k.this.ccf.f(bVar);
                    com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(14L).bx(aVar.errorNo).pz("Extension下载失败").pB(aVar.toString());
                    if (k.this.ccq != null) {
                        k.this.ccq.onError(new PkgDownloadError(bVar, pB));
                    }
                    c.aaT().a(bVar, k.this.aaY(), pB);
                    com.baidu.swan.e.d.deleteFile(bVar.filePath);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
                /* renamed from: g */
                public void L(com.baidu.swan.pms.model.b bVar) {
                    super.L(bVar);
                    if (k.DEBUG) {
                        Log.d("UpdateCoreCallback", "onFileDownloaded: " + bVar.toString());
                    }
                    com.baidu.swan.apps.an.a h = k.this.h(bVar);
                    if (h == null) {
                        k.this.ccf.g(bVar);
                        if (k.this.ccq != null) {
                            k.this.ccq.onNext(bVar);
                            k.this.ccq.onCompleted();
                        }
                        com.baidu.swan.pms.database.a.aHb().c(bVar);
                        c.aaT().a(bVar, k.this.aaY());
                        return;
                    }
                    k.this.ccf.f(bVar);
                    if (k.this.ccq != null) {
                        k.this.ccq.onError(new PkgDownloadError(bVar, h));
                    }
                    c.aaT().a(bVar, k.this.aaY(), h);
                }
            };
        }
        return this.ccZ;
    }

    protected void n(Exception exc) {
        if (this.ccX != null) {
            this.ccX.H(exc);
        }
        this.ccX = null;
    }

    protected void abm() {
        com.baidu.swan.pms.e.a.l(getCategory(), System.currentTimeMillis());
        n(null);
    }

    protected void o(Exception exc) {
        com.baidu.swan.pms.e.a.l(getCategory(), 0L);
        n(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.aaT().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.k.3
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                k.this.ccf.g(dVar);
                if (k.this.ccp != null) {
                    k.this.ccp.onNext(dVar);
                    k.this.ccp.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                k.this.ccf.f(dVar);
                if (k.this.ccp != null) {
                    k.this.ccp.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.aaT().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.k.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                k.this.ccf.g(bVar);
                if (k.this.ccq != null) {
                    k.this.ccq.onNext(bVar);
                    k.this.ccq.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                k.this.ccf.f(bVar);
                if (k.this.ccq != null) {
                    k.this.ccq.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void abi() {
        ArrayList arrayList = new ArrayList();
        if (this.ccf.aIw()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.k.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    k.this.ccp = jVar;
                }
            }));
        }
        if (this.ccf.aIx()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.k.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    k.this.ccq = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(abn());
        }
    }

    private rx.j<com.baidu.swan.pms.model.e> abn() {
        if (this.ccJ == null) {
            this.ccJ = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.k.7
                @Override // rx.e
                public void onCompleted() {
                    if (k.DEBUG) {
                        Log.e("UpdateCoreCallback", "包下载完成");
                    }
                    k.this.abm();
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    if (k.DEBUG) {
                        Log.e("UpdateCoreCallback", "包下载、业务层处理 OnError：" + th.toString());
                    }
                    k.this.o(new Exception("UpdateCoreCallback failed by Download error = ", th));
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.e
                /* renamed from: a */
                public void onNext(com.baidu.swan.pms.model.e eVar) {
                    if (k.DEBUG) {
                        Log.e("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.toString());
                    }
                }
            };
        }
        return this.ccJ;
    }
}
