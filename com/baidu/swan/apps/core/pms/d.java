package com.baidu.swan.apps.core.pms;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.core.pms.b;
import com.baidu.swan.apps.core.pms.c.c;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.e.a;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.i;
import java.util.ArrayList;
import java.util.List;
import rx.d;
import rx.j;
/* loaded from: classes2.dex */
public abstract class d extends com.baidu.swan.pms.a.e {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private j<? super g> arW;
    private j<? super i> arX;
    private j<? super com.baidu.swan.pms.model.e> arY;
    private j<? super com.baidu.swan.pms.model.c> arZ;
    protected com.baidu.swan.pms.d.e asa;
    protected g asb;
    protected List<i> asc;
    protected com.baidu.swan.pms.model.e asd;
    protected com.baidu.swan.pms.model.c ase;
    protected com.baidu.swan.pms.model.a asf;
    protected String mAppId;
    protected String apd = "0";
    private com.baidu.swan.pms.a.a<g> asg = new com.baidu.swan.pms.a.c<g>() { // from class: com.baidu.swan.apps.core.pms.d.1
        @Override // com.baidu.swan.pms.a.a
        public String hp() {
            return com.baidu.swan.apps.core.pms.c.a.xD().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void F(g gVar) {
            super.F(gVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void G(g gVar) {
            super.G(gVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "main onDownloading");
            }
            d.this.b(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(g gVar, com.baidu.swan.pms.model.b bVar) {
            super.a((AnonymousClass1) gVar, bVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "onDownloadError：" + bVar.toString());
            }
            d.this.asa.f(gVar);
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(11L).M(bVar.errorNo).hv("主包下载失败").hw(bVar.toString());
            if (d.this.arW != null) {
                d.this.arW.onError(new PkgDownloadError(gVar, hw));
            }
            b.zx().a(gVar, d.this.zB(), hw);
            com.baidu.swan.c.b.deleteFile(gVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void E(g gVar) {
            super.E(gVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + gVar.toString());
            }
            d.this.aoO.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ak.a a = d.this.a(gVar);
            if (a == null) {
                d.this.asb = gVar;
                d.this.asa.g(gVar);
                if (d.this.arW != null) {
                    d.this.arW.onNext(gVar);
                    d.this.arW.onCompleted();
                }
                b.zx().a(gVar, d.this.zB());
                return;
            }
            d.this.asa.f(gVar);
            if (d.this.arW != null) {
                d.this.arW.onError(new PkgDownloadError(gVar, a));
            }
            b.zx().a(gVar, d.this.zB(), a);
        }
    };
    private com.baidu.swan.pms.a.a<i> ash = new com.baidu.swan.pms.a.c<i>() { // from class: com.baidu.swan.apps.core.pms.d.7
        @Override // com.baidu.swan.pms.a.a
        public String hp() {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: b */
        public void F(i iVar) {
            super.F(iVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void G(i iVar) {
            super.G(iVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "sub onDownloading");
            }
            d.this.a(iVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(i iVar, com.baidu.swan.pms.model.b bVar) {
            super.a((AnonymousClass7) iVar, bVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "onDownloadError：" + bVar.toString());
            }
            d.this.asa.f(iVar);
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(12L).M(bVar.errorNo).hv("分包下载失败").hw(bVar.toString());
            if (d.this.arX != null) {
                d.this.arX.onError(new PkgDownloadError(iVar, hw));
            }
            b.zx().a(iVar, d.this.zB(), hw);
            com.baidu.swan.c.b.deleteFile(iVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void E(i iVar) {
            super.E(iVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + iVar.toString());
            }
            if (d.this.asc == null) {
                d.this.asc = new ArrayList();
            }
            iVar.appId = d.this.mAppId;
            d.this.asc.add(iVar);
            d.this.asa.g(iVar);
            if (d.this.arX != null) {
                d.this.arX.onNext(iVar);
                if (!d.this.asa.Sv()) {
                    d.this.arX.onCompleted();
                }
            }
            b.zx().a(iVar, d.this.zB());
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.e> asi = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.d.8
        @Override // com.baidu.swan.pms.a.a
        public String hp() {
            return com.baidu.swan.apps.core.pms.c.a.zM();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void F(com.baidu.swan.pms.model.e eVar) {
            super.F(eVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.e eVar) {
            super.G(eVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "framework onDownloading");
            }
            d.this.b(eVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.model.b bVar) {
            super.a((AnonymousClass8) eVar, bVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "onDownloadError：" + bVar.toString());
            }
            d.this.asa.f(eVar);
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(13L).M(bVar.errorNo).hv("Framework包下载失败").hw(bVar.toString());
            if (d.this.arY != null) {
                d.this.arY.onError(new PkgDownloadError(eVar, hw));
            }
            b.zx().a(eVar, d.this.zB(), hw);
            com.baidu.swan.c.b.deleteFile(eVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void E(com.baidu.swan.pms.model.e eVar) {
            super.E(eVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + eVar.toString());
            }
            com.baidu.swan.apps.ak.a a = d.this.a(eVar);
            if (a == null) {
                d.this.asd = eVar;
                d.this.asa.g(eVar);
                if (d.this.arY != null) {
                    d.this.arY.onNext(eVar);
                    d.this.arY.onCompleted();
                }
                b.zx().a(eVar, d.this.zB());
                return;
            }
            d.this.asa.f(eVar);
            if (d.this.arY != null) {
                d.this.arY.onError(new PkgDownloadError(eVar, a));
            }
            b.zx().a(eVar, d.this.zB(), a);
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.c> asj = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.c>() { // from class: com.baidu.swan.apps.core.pms.d.9
        @Override // com.baidu.swan.pms.a.a
        public String hp() {
            return com.baidu.swan.apps.core.pms.c.a.zN();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void F(com.baidu.swan.pms.model.c cVar) {
            super.F(cVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.c cVar) {
            super.G(cVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "extension onDownloading");
            }
            d.this.b(cVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(com.baidu.swan.pms.model.c cVar, com.baidu.swan.pms.model.b bVar) {
            super.a((AnonymousClass9) cVar, bVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "onDownloadError：" + bVar.toString());
            }
            d.this.asa.f(cVar);
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(14L).M(bVar.errorNo).hv("Extension下载失败").hw(bVar.toString());
            if (d.this.arZ != null) {
                d.this.arZ.onError(new PkgDownloadError(cVar, hw));
            }
            b.zx().a(cVar, d.this.zB(), hw);
            com.baidu.swan.c.b.deleteFile(cVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void E(com.baidu.swan.pms.model.c cVar) {
            super.E(cVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + cVar.toString());
            }
            com.baidu.swan.apps.ak.a a = d.this.a(cVar);
            if (a == null) {
                d.this.ase = cVar;
                d.this.asa.g(cVar);
                if (d.this.arZ != null) {
                    d.this.arZ.onNext(cVar);
                    d.this.arZ.onCompleted();
                }
                b.zx().a(cVar, d.this.zB());
                return;
            }
            d.this.asa.f(cVar);
            if (d.this.arZ != null) {
                d.this.arZ.onError(new PkgDownloadError(cVar, a));
            }
            b.zx().a(cVar, d.this.zB(), a);
        }
    };
    private com.baidu.swan.pms.a.d ask = new com.baidu.swan.pms.a.d() { // from class: com.baidu.swan.apps.core.pms.d.10
        @Override // com.baidu.swan.pms.a.d
        public void c(com.baidu.swan.pms.model.a aVar) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", "onSwanAppReceive: " + aVar.toString());
            }
            d.this.asf = aVar;
            if (d.this.asf != null) {
                if (d.this.aoO != null) {
                    d.this.aoO.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.c.c.a(d.this.asf.iconUrl, new c.a() { // from class: com.baidu.swan.apps.core.pms.d.10.1
                    @Override // com.baidu.swan.apps.core.pms.c.c.a
                    public void g(Bitmap bitmap) {
                        if (d.this.aoO != null) {
                            d.this.aoO.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private j<com.baidu.swan.pms.model.f> asl = new j<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.d.2
        @Override // rx.e
        public void onCompleted() {
            if (d.this.asb != null && d.this.asc != null) {
                com.baidu.swan.apps.core.pms.c.b.a(d.this.asb.blV, d.this.asb.versionCode, d.this.asc);
            }
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.zB() + " : 包下载onCompleted");
            }
            d.this.zA();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.zB() + " : 包下载OnError：" + th.toString());
            }
            d.this.k(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.f fVar) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.zB() + " : 单个包下载、业务层处理完成：" + fVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> aoO = new ArrayList();

    protected abstract void k(Throwable th);

    protected abstract void zA();

    protected abstract PMSDownloadType zB();

    public d(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.e
    public void xM() {
        this.aoO.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.e
    public void zC() {
        this.aoO.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.model.b bVar) {
        this.aoO.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.d.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.aoO.add(new UbcFlowEvent("na_pms_start_download"));
            this.asa = eVar;
            if (!this.asa.isEmpty()) {
                zK();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<g> zD() {
        return this.asg;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<i> zE() {
        return this.ash;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.e> zF() {
        return this.asi;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.c> zG() {
        return this.asj;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.d zH() {
        return this.ask;
    }

    protected com.baidu.swan.apps.ak.a a(g gVar) {
        com.baidu.swan.apps.ak.a a = com.baidu.swan.apps.core.pms.c.a.a(gVar, this);
        if (a == null) {
            com.baidu.swan.apps.ak.a b = com.baidu.swan.apps.core.pms.c.a.b(gVar);
            if (b == null) {
                com.baidu.swan.apps.ak.a b2 = com.baidu.swan.apps.core.pms.c.a.b(gVar, this);
                if (b2 == null) {
                    return null;
                }
                return b2;
            }
            return b;
        }
        return a;
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.e eVar) {
        a.C0148a c = com.baidu.swan.apps.swancore.e.a.c(eVar.versionName, eVar.filePath, eVar.sign, 0);
        if (!TextUtils.isEmpty(eVar.filePath)) {
            com.baidu.swan.c.b.deleteFile(eVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.ak.a().L(13L).N(2907L).hv("Core包更新失败");
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.c cVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = cVar.versionName;
        aVar.avN = cVar.filePath;
        aVar.sign = cVar.sign;
        if (com.baidu.swan.apps.extcore.a.Bj().a((com.baidu.swan.apps.extcore.a) aVar)) {
            return null;
        }
        return new com.baidu.swan.apps.ak.a().L(14L).N(2908L).hv("Extension包更新失败");
    }

    protected com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.a aVar) {
        if (aVar == null) {
            return null;
        }
        aVar.orientation = 0;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cp(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.RA().N(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.RA().N(this.mAppId, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.ak.a zI() {
        if (this.asf == null) {
            if (this.asb == null) {
                return new com.baidu.swan.apps.ak.a().L(10L).M(2903L).hv("Server未返回主包&AppInfo");
            }
            com.baidu.swan.pms.model.a ji = com.baidu.swan.pms.database.a.RA().ji(this.mAppId);
            if (ji == null) {
                return new com.baidu.swan.apps.ak.a().L(10L).M(2904L).hv("Server未返回AppInfo数据，本地也没有数据");
            }
            this.asf = ji;
            this.asf.g(this.asb);
            a(this.asf);
            this.asf.RJ();
            if (com.baidu.swan.pms.database.a.RA().a(this.asb, this.asc, this.asd, this.ase, this.asf)) {
                return null;
            }
            return new com.baidu.swan.apps.ak.a().L(10L).M(2906L).hv("更新DB失败");
        }
        if (this.asb != null) {
            this.asf.g(this.asb);
            a(this.asf);
        } else {
            com.baidu.swan.pms.model.a ji2 = com.baidu.swan.pms.database.a.RA().ji(this.mAppId);
            if (ji2 == null) {
                return new com.baidu.swan.apps.ak.a().L(10L).M(2905L).hv("Server未返回包数据，本地也没有数据");
            }
            this.asf.appId = this.mAppId;
            this.asf.h(ji2);
        }
        this.asf.RJ();
        if (com.baidu.swan.pms.database.a.RA().a(this.asb, this.asc, this.asd, this.ase, this.asf)) {
            b(this.asf);
            return null;
        }
        return new com.baidu.swan.apps.ak.a().L(10L).M(2906L).hv("更新DB失败");
    }

    protected void b(com.baidu.swan.pms.model.a aVar) {
        if (aVar != null) {
            if (!TextUtils.isEmpty(this.asf.blQ)) {
                com.baidu.swan.apps.af.a.c.a(this.asf.appId, "", n.hB(this.asf.blQ));
            }
            if (!TextUtils.isEmpty(this.asf.blR)) {
                com.baidu.swan.apps.af.a.c.b("", n.hB(this.asf.blR));
            }
            if (!TextUtils.isEmpty(this.asf.blS)) {
                com.baidu.swan.apps.af.a.c.g(this.asf.appId, n.dk(this.asf.blS));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zJ() {
        if (this.asf != null) {
            com.baidu.swan.pms.model.a ji = com.baidu.swan.pms.database.a.RA().ji(this.mAppId);
            if (ji == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.asf.appId = this.mAppId;
            this.asf.h(ji);
            if (this.asf.AF()) {
                this.asf.RJ();
            }
            com.baidu.swan.pms.database.a.RA().f(this.asf);
            b(this.asf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final g gVar) {
        b.zx().a(gVar, new b.InterfaceC0107b() { // from class: com.baidu.swan.apps.core.pms.d.11
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.asb = gVar;
                d.this.asa.g(gVar);
                if (d.this.arW != null) {
                    d.this.arW.onNext(gVar);
                    d.this.arW.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asa.f(gVar);
                if (d.this.arW != null) {
                    d.this.arW.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final i iVar) {
        b.zx().a(iVar, new b.InterfaceC0107b() { // from class: com.baidu.swan.apps.core.pms.d.12
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType) {
                if (d.this.asc == null) {
                    d.this.asc = new ArrayList();
                }
                iVar.appId = d.this.mAppId;
                d.this.asc.add(iVar);
                d.this.asa.g(iVar);
                if (d.this.arX != null) {
                    d.this.arX.onNext(iVar);
                    if (!d.this.asa.Sv()) {
                        d.this.arX.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asa.f(iVar);
                if (d.this.arX != null) {
                    d.this.arX.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.e eVar) {
        b.zx().a(eVar, new b.InterfaceC0107b() { // from class: com.baidu.swan.apps.core.pms.d.13
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.asd = eVar;
                d.this.asa.g(eVar);
                if (d.this.arY != null) {
                    d.this.arY.onNext(eVar);
                    d.this.arY.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asa.f(eVar);
                if (d.this.arY != null) {
                    d.this.arY.onError(new PkgDownloadError(eVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.c cVar) {
        b.zx().a(cVar, new b.InterfaceC0107b() { // from class: com.baidu.swan.apps.core.pms.d.14
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.ase = cVar;
                d.this.asa.g(cVar);
                if (d.this.arZ != null) {
                    d.this.arZ.onNext(cVar);
                    d.this.arZ.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0107b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asa.f(cVar);
                if (d.this.arZ != null) {
                    d.this.arZ.onError(new PkgDownloadError(cVar, aVar));
                }
            }
        });
    }

    private void zK() {
        ArrayList arrayList = new ArrayList();
        if (this.asa.Sr()) {
            arrayList.add(rx.d.a((d.a) new d.a<g>() { // from class: com.baidu.swan.apps.core.pms.d.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super g> jVar) {
                    d.this.arW = jVar;
                }
            }));
        }
        if (this.asa.Ss()) {
            arrayList.add(rx.d.a((d.a) new d.a<i>() { // from class: com.baidu.swan.apps.core.pms.d.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super i> jVar) {
                    d.this.arX = jVar;
                }
            }));
        }
        if (this.asa.St()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.d.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.e> jVar) {
                    d.this.arY = jVar;
                }
            }));
        }
        if (this.asa.Su()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.c>() { // from class: com.baidu.swan.apps.core.pms.d.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.c> jVar) {
                    d.this.arZ = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.h(arrayList).b(this.asl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(String str, String str2) {
        com.baidu.swan.apps.performance.d.a.a(this.mAppId, str, this.aoO, str2);
        this.aoO.clear();
    }
}
