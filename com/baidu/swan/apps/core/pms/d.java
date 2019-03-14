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
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private j<? super g> arX;
    private j<? super i> arY;
    private j<? super com.baidu.swan.pms.model.e> arZ;
    private j<? super com.baidu.swan.pms.model.c> asa;
    protected com.baidu.swan.pms.d.e asb;
    protected g asc;
    protected List<i> asd;
    protected com.baidu.swan.pms.model.e ase;
    protected com.baidu.swan.pms.model.c asf;
    protected com.baidu.swan.pms.model.a asg;
    protected String mAppId;
    protected String ape = "0";
    private com.baidu.swan.pms.a.a<g> ash = new com.baidu.swan.pms.a.c<g>() { // from class: com.baidu.swan.apps.core.pms.d.1
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
            d.this.asb.f(gVar);
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(11L).M(bVar.errorNo).hv("主包下载失败").hw(bVar.toString());
            if (d.this.arX != null) {
                d.this.arX.onError(new PkgDownloadError(gVar, hw));
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
            d.this.aoP.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ak.a a = d.this.a(gVar);
            if (a == null) {
                d.this.asc = gVar;
                d.this.asb.g(gVar);
                if (d.this.arX != null) {
                    d.this.arX.onNext(gVar);
                    d.this.arX.onCompleted();
                }
                b.zx().a(gVar, d.this.zB());
                return;
            }
            d.this.asb.f(gVar);
            if (d.this.arX != null) {
                d.this.arX.onError(new PkgDownloadError(gVar, a));
            }
            b.zx().a(gVar, d.this.zB(), a);
        }
    };
    private com.baidu.swan.pms.a.a<i> asi = new com.baidu.swan.pms.a.c<i>() { // from class: com.baidu.swan.apps.core.pms.d.7
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
            d.this.asb.f(iVar);
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(12L).M(bVar.errorNo).hv("分包下载失败").hw(bVar.toString());
            if (d.this.arY != null) {
                d.this.arY.onError(new PkgDownloadError(iVar, hw));
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
            if (d.this.asd == null) {
                d.this.asd = new ArrayList();
            }
            iVar.appId = d.this.mAppId;
            d.this.asd.add(iVar);
            d.this.asb.g(iVar);
            if (d.this.arY != null) {
                d.this.arY.onNext(iVar);
                if (!d.this.asb.Sv()) {
                    d.this.arY.onCompleted();
                }
            }
            b.zx().a(iVar, d.this.zB());
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.e> asj = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.d.8
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
            d.this.asb.f(eVar);
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(13L).M(bVar.errorNo).hv("Framework包下载失败").hw(bVar.toString());
            if (d.this.arZ != null) {
                d.this.arZ.onError(new PkgDownloadError(eVar, hw));
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
                d.this.ase = eVar;
                d.this.asb.g(eVar);
                if (d.this.arZ != null) {
                    d.this.arZ.onNext(eVar);
                    d.this.arZ.onCompleted();
                }
                b.zx().a(eVar, d.this.zB());
                return;
            }
            d.this.asb.f(eVar);
            if (d.this.arZ != null) {
                d.this.arZ.onError(new PkgDownloadError(eVar, a));
            }
            b.zx().a(eVar, d.this.zB(), a);
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.c> ask = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.c>() { // from class: com.baidu.swan.apps.core.pms.d.9
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
            d.this.asb.f(cVar);
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(14L).M(bVar.errorNo).hv("Extension下载失败").hw(bVar.toString());
            if (d.this.asa != null) {
                d.this.asa.onError(new PkgDownloadError(cVar, hw));
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
                d.this.asf = cVar;
                d.this.asb.g(cVar);
                if (d.this.asa != null) {
                    d.this.asa.onNext(cVar);
                    d.this.asa.onCompleted();
                }
                b.zx().a(cVar, d.this.zB());
                return;
            }
            d.this.asb.f(cVar);
            if (d.this.asa != null) {
                d.this.asa.onError(new PkgDownloadError(cVar, a));
            }
            b.zx().a(cVar, d.this.zB(), a);
        }
    };
    private com.baidu.swan.pms.a.d asl = new com.baidu.swan.pms.a.d() { // from class: com.baidu.swan.apps.core.pms.d.10
        @Override // com.baidu.swan.pms.a.d
        public void c(com.baidu.swan.pms.model.a aVar) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", "onSwanAppReceive: " + aVar.toString());
            }
            d.this.asg = aVar;
            if (d.this.asg != null) {
                if (d.this.aoP != null) {
                    d.this.aoP.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.c.c.a(d.this.asg.iconUrl, new c.a() { // from class: com.baidu.swan.apps.core.pms.d.10.1
                    @Override // com.baidu.swan.apps.core.pms.c.c.a
                    public void g(Bitmap bitmap) {
                        if (d.this.aoP != null) {
                            d.this.aoP.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private j<com.baidu.swan.pms.model.f> asm = new j<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.d.2
        @Override // rx.e
        public void onCompleted() {
            if (d.this.asc != null && d.this.asd != null) {
                com.baidu.swan.apps.core.pms.c.b.a(d.this.asc.blW, d.this.asc.versionCode, d.this.asd);
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
    protected List<UbcFlowEvent> aoP = new ArrayList();

    protected abstract void k(Throwable th);

    protected abstract void zA();

    protected abstract PMSDownloadType zB();

    public d(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.e
    public void xM() {
        this.aoP.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.e
    public void zC() {
        this.aoP.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.model.b bVar) {
        this.aoP.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.d.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.aoP.add(new UbcFlowEvent("na_pms_start_download"));
            this.asb = eVar;
            if (!this.asb.isEmpty()) {
                zK();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<g> zD() {
        return this.ash;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<i> zE() {
        return this.asi;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.e> zF() {
        return this.asj;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.c> zG() {
        return this.ask;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.d zH() {
        return this.asl;
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
        a.C0177a c = com.baidu.swan.apps.swancore.e.a.c(eVar.versionName, eVar.filePath, eVar.sign, 0);
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
        aVar.avO = cVar.filePath;
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
        if (this.asg == null) {
            if (this.asc == null) {
                return new com.baidu.swan.apps.ak.a().L(10L).M(2903L).hv("Server未返回主包&AppInfo");
            }
            com.baidu.swan.pms.model.a ji = com.baidu.swan.pms.database.a.RA().ji(this.mAppId);
            if (ji == null) {
                return new com.baidu.swan.apps.ak.a().L(10L).M(2904L).hv("Server未返回AppInfo数据，本地也没有数据");
            }
            this.asg = ji;
            this.asg.g(this.asc);
            a(this.asg);
            this.asg.RJ();
            if (com.baidu.swan.pms.database.a.RA().a(this.asc, this.asd, this.ase, this.asf, this.asg)) {
                return null;
            }
            return new com.baidu.swan.apps.ak.a().L(10L).M(2906L).hv("更新DB失败");
        }
        if (this.asc != null) {
            this.asg.g(this.asc);
            a(this.asg);
        } else {
            com.baidu.swan.pms.model.a ji2 = com.baidu.swan.pms.database.a.RA().ji(this.mAppId);
            if (ji2 == null) {
                return new com.baidu.swan.apps.ak.a().L(10L).M(2905L).hv("Server未返回包数据，本地也没有数据");
            }
            this.asg.appId = this.mAppId;
            this.asg.h(ji2);
        }
        this.asg.RJ();
        if (com.baidu.swan.pms.database.a.RA().a(this.asc, this.asd, this.ase, this.asf, this.asg)) {
            b(this.asg);
            return null;
        }
        return new com.baidu.swan.apps.ak.a().L(10L).M(2906L).hv("更新DB失败");
    }

    protected void b(com.baidu.swan.pms.model.a aVar) {
        if (aVar != null) {
            if (!TextUtils.isEmpty(this.asg.blR)) {
                com.baidu.swan.apps.af.a.c.a(this.asg.appId, "", n.hB(this.asg.blR));
            }
            if (!TextUtils.isEmpty(this.asg.blS)) {
                com.baidu.swan.apps.af.a.c.b("", n.hB(this.asg.blS));
            }
            if (!TextUtils.isEmpty(this.asg.blT)) {
                com.baidu.swan.apps.af.a.c.g(this.asg.appId, n.dk(this.asg.blT));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zJ() {
        if (this.asg != null) {
            com.baidu.swan.pms.model.a ji = com.baidu.swan.pms.database.a.RA().ji(this.mAppId);
            if (ji == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.asg.appId = this.mAppId;
            this.asg.h(ji);
            if (this.asg.AF()) {
                this.asg.RJ();
            }
            com.baidu.swan.pms.database.a.RA().f(this.asg);
            b(this.asg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final g gVar) {
        b.zx().a(gVar, new b.InterfaceC0136b() { // from class: com.baidu.swan.apps.core.pms.d.11
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.asc = gVar;
                d.this.asb.g(gVar);
                if (d.this.arX != null) {
                    d.this.arX.onNext(gVar);
                    d.this.arX.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asb.f(gVar);
                if (d.this.arX != null) {
                    d.this.arX.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final i iVar) {
        b.zx().a(iVar, new b.InterfaceC0136b() { // from class: com.baidu.swan.apps.core.pms.d.12
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType) {
                if (d.this.asd == null) {
                    d.this.asd = new ArrayList();
                }
                iVar.appId = d.this.mAppId;
                d.this.asd.add(iVar);
                d.this.asb.g(iVar);
                if (d.this.arY != null) {
                    d.this.arY.onNext(iVar);
                    if (!d.this.asb.Sv()) {
                        d.this.arY.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asb.f(iVar);
                if (d.this.arY != null) {
                    d.this.arY.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.e eVar) {
        b.zx().a(eVar, new b.InterfaceC0136b() { // from class: com.baidu.swan.apps.core.pms.d.13
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.ase = eVar;
                d.this.asb.g(eVar);
                if (d.this.arZ != null) {
                    d.this.arZ.onNext(eVar);
                    d.this.arZ.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asb.f(eVar);
                if (d.this.arZ != null) {
                    d.this.arZ.onError(new PkgDownloadError(eVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.c cVar) {
        b.zx().a(cVar, new b.InterfaceC0136b() { // from class: com.baidu.swan.apps.core.pms.d.14
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.asf = cVar;
                d.this.asb.g(cVar);
                if (d.this.asa != null) {
                    d.this.asa.onNext(cVar);
                    d.this.asa.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asb.f(cVar);
                if (d.this.asa != null) {
                    d.this.asa.onError(new PkgDownloadError(cVar, aVar));
                }
            }
        });
    }

    private void zK() {
        ArrayList arrayList = new ArrayList();
        if (this.asb.Sr()) {
            arrayList.add(rx.d.a((d.a) new d.a<g>() { // from class: com.baidu.swan.apps.core.pms.d.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super g> jVar) {
                    d.this.arX = jVar;
                }
            }));
        }
        if (this.asb.Ss()) {
            arrayList.add(rx.d.a((d.a) new d.a<i>() { // from class: com.baidu.swan.apps.core.pms.d.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super i> jVar) {
                    d.this.arY = jVar;
                }
            }));
        }
        if (this.asb.St()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.d.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.e> jVar) {
                    d.this.arZ = jVar;
                }
            }));
        }
        if (this.asb.Su()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.c>() { // from class: com.baidu.swan.apps.core.pms.d.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.c> jVar) {
                    d.this.asa = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.h(arrayList).b(this.asm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(String str, String str2) {
        com.baidu.swan.apps.performance.d.a.a(this.mAppId, str, this.aoP, str2);
        this.aoP.clear();
    }
}
