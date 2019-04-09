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
    private j<? super g> asc;
    private j<? super i> asd;
    private j<? super com.baidu.swan.pms.model.e> ase;
    private j<? super com.baidu.swan.pms.model.c> asf;
    protected com.baidu.swan.pms.d.e asg;
    protected g ash;
    protected List<i> asi;
    protected com.baidu.swan.pms.model.e asj;
    protected com.baidu.swan.pms.model.c ask;
    protected com.baidu.swan.pms.model.a asl;
    protected String mAppId;
    protected String apj = "0";
    private com.baidu.swan.pms.a.a<g> asm = new com.baidu.swan.pms.a.c<g>() { // from class: com.baidu.swan.apps.core.pms.d.1
        @Override // com.baidu.swan.pms.a.a
        public String hp() {
            return com.baidu.swan.apps.core.pms.c.a.xC().getPath();
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
            d.this.asg.f(gVar);
            com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(11L).M(bVar.errorNo).hw("主包下载失败").hx(bVar.toString());
            if (d.this.asc != null) {
                d.this.asc.onError(new PkgDownloadError(gVar, hx));
            }
            b.zw().a(gVar, d.this.zA(), hx);
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
            d.this.aoU.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ak.a a = d.this.a(gVar);
            if (a == null) {
                d.this.ash = gVar;
                d.this.asg.g(gVar);
                if (d.this.asc != null) {
                    d.this.asc.onNext(gVar);
                    d.this.asc.onCompleted();
                }
                b.zw().a(gVar, d.this.zA());
                return;
            }
            d.this.asg.f(gVar);
            if (d.this.asc != null) {
                d.this.asc.onError(new PkgDownloadError(gVar, a));
            }
            b.zw().a(gVar, d.this.zA(), a);
        }
    };
    private com.baidu.swan.pms.a.a<i> asn = new com.baidu.swan.pms.a.c<i>() { // from class: com.baidu.swan.apps.core.pms.d.7
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
            d.this.asg.f(iVar);
            com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(12L).M(bVar.errorNo).hw("分包下载失败").hx(bVar.toString());
            if (d.this.asd != null) {
                d.this.asd.onError(new PkgDownloadError(iVar, hx));
            }
            b.zw().a(iVar, d.this.zA(), hx);
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
            if (d.this.asi == null) {
                d.this.asi = new ArrayList();
            }
            iVar.appId = d.this.mAppId;
            d.this.asi.add(iVar);
            d.this.asg.g(iVar);
            if (d.this.asd != null) {
                d.this.asd.onNext(iVar);
                if (!d.this.asg.St()) {
                    d.this.asd.onCompleted();
                }
            }
            b.zw().a(iVar, d.this.zA());
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.e> aso = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.d.8
        @Override // com.baidu.swan.pms.a.a
        public String hp() {
            return com.baidu.swan.apps.core.pms.c.a.zL();
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
            d.this.asg.f(eVar);
            com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(13L).M(bVar.errorNo).hw("Framework包下载失败").hx(bVar.toString());
            if (d.this.ase != null) {
                d.this.ase.onError(new PkgDownloadError(eVar, hx));
            }
            b.zw().a(eVar, d.this.zA(), hx);
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
                d.this.asj = eVar;
                d.this.asg.g(eVar);
                if (d.this.ase != null) {
                    d.this.ase.onNext(eVar);
                    d.this.ase.onCompleted();
                }
                b.zw().a(eVar, d.this.zA());
                return;
            }
            d.this.asg.f(eVar);
            if (d.this.ase != null) {
                d.this.ase.onError(new PkgDownloadError(eVar, a));
            }
            b.zw().a(eVar, d.this.zA(), a);
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.c> asp = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.c>() { // from class: com.baidu.swan.apps.core.pms.d.9
        @Override // com.baidu.swan.pms.a.a
        public String hp() {
            return com.baidu.swan.apps.core.pms.c.a.zM();
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
            d.this.asg.f(cVar);
            com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(14L).M(bVar.errorNo).hw("Extension下载失败").hx(bVar.toString());
            if (d.this.asf != null) {
                d.this.asf.onError(new PkgDownloadError(cVar, hx));
            }
            b.zw().a(cVar, d.this.zA(), hx);
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
                d.this.ask = cVar;
                d.this.asg.g(cVar);
                if (d.this.asf != null) {
                    d.this.asf.onNext(cVar);
                    d.this.asf.onCompleted();
                }
                b.zw().a(cVar, d.this.zA());
                return;
            }
            d.this.asg.f(cVar);
            if (d.this.asf != null) {
                d.this.asf.onError(new PkgDownloadError(cVar, a));
            }
            b.zw().a(cVar, d.this.zA(), a);
        }
    };
    private com.baidu.swan.pms.a.d asq = new com.baidu.swan.pms.a.d() { // from class: com.baidu.swan.apps.core.pms.d.10
        @Override // com.baidu.swan.pms.a.d
        public void c(com.baidu.swan.pms.model.a aVar) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", "onSwanAppReceive: " + aVar.toString());
            }
            d.this.asl = aVar;
            if (d.this.asl != null) {
                if (d.this.aoU != null) {
                    d.this.aoU.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.c.c.a(d.this.asl.iconUrl, new c.a() { // from class: com.baidu.swan.apps.core.pms.d.10.1
                    @Override // com.baidu.swan.apps.core.pms.c.c.a
                    public void g(Bitmap bitmap) {
                        if (d.this.aoU != null) {
                            d.this.aoU.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private j<com.baidu.swan.pms.model.f> asr = new j<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.d.2
        @Override // rx.e
        public void onCompleted() {
            if (d.this.ash != null && d.this.asi != null) {
                com.baidu.swan.apps.core.pms.c.b.a(d.this.ash.bma, d.this.ash.versionCode, d.this.asi);
            }
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.zA() + " : 包下载onCompleted");
            }
            d.this.zz();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.zA() + " : 包下载OnError：" + th.toString());
            }
            d.this.k(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.f fVar) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.zA() + " : 单个包下载、业务层处理完成：" + fVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> aoU = new ArrayList();

    protected abstract void k(Throwable th);

    protected abstract PMSDownloadType zA();

    protected abstract void zz();

    public d(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.e
    public void xL() {
        this.aoU.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.e
    public void zB() {
        this.aoU.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.model.b bVar) {
        this.aoU.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.d.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.aoU.add(new UbcFlowEvent("na_pms_start_download"));
            this.asg = eVar;
            if (!this.asg.isEmpty()) {
                zJ();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<g> zC() {
        return this.asm;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<i> zD() {
        return this.asn;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.e> zE() {
        return this.aso;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.c> zF() {
        return this.asp;
    }

    @Override // com.baidu.swan.pms.a.e
    public com.baidu.swan.pms.a.d zG() {
        return this.asq;
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
        return new com.baidu.swan.apps.ak.a().L(13L).N(2907L).hw("Core包更新失败");
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.c cVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = cVar.versionName;
        aVar.avS = cVar.filePath;
        aVar.sign = cVar.sign;
        if (com.baidu.swan.apps.extcore.a.Bh().a((com.baidu.swan.apps.extcore.a) aVar)) {
            return null;
        }
        return new com.baidu.swan.apps.ak.a().L(14L).N(2908L).hw("Extension包更新失败");
    }

    protected com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.a aVar) {
        if (aVar == null) {
            return null;
        }
        aVar.orientation = 0;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void co(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.Ry().N(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.Ry().N(this.mAppId, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.ak.a zH() {
        if (this.asl == null) {
            if (this.ash == null) {
                return new com.baidu.swan.apps.ak.a().L(10L).M(2903L).hw("Server未返回主包&AppInfo");
            }
            com.baidu.swan.pms.model.a jj = com.baidu.swan.pms.database.a.Ry().jj(this.mAppId);
            if (jj == null) {
                return new com.baidu.swan.apps.ak.a().L(10L).M(2904L).hw("Server未返回AppInfo数据，本地也没有数据");
            }
            this.asl = jj;
            this.asl.g(this.ash);
            a(this.asl);
            this.asl.RH();
            if (com.baidu.swan.pms.database.a.Ry().a(this.ash, this.asi, this.asj, this.ask, this.asl)) {
                return null;
            }
            return new com.baidu.swan.apps.ak.a().L(10L).M(2906L).hw("更新DB失败");
        }
        if (this.ash != null) {
            this.asl.g(this.ash);
            a(this.asl);
        } else {
            com.baidu.swan.pms.model.a jj2 = com.baidu.swan.pms.database.a.Ry().jj(this.mAppId);
            if (jj2 == null) {
                return new com.baidu.swan.apps.ak.a().L(10L).M(2905L).hw("Server未返回包数据，本地也没有数据");
            }
            this.asl.appId = this.mAppId;
            this.asl.h(jj2);
        }
        this.asl.RH();
        if (com.baidu.swan.pms.database.a.Ry().a(this.ash, this.asi, this.asj, this.ask, this.asl)) {
            b(this.asl);
            return null;
        }
        return new com.baidu.swan.apps.ak.a().L(10L).M(2906L).hw("更新DB失败");
    }

    protected void b(com.baidu.swan.pms.model.a aVar) {
        if (aVar != null) {
            if (!TextUtils.isEmpty(this.asl.blV)) {
                com.baidu.swan.apps.af.a.c.a(this.asl.appId, "", n.hC(this.asl.blV));
            }
            if (!TextUtils.isEmpty(this.asl.blW)) {
                com.baidu.swan.apps.af.a.c.b("", n.hC(this.asl.blW));
            }
            if (!TextUtils.isEmpty(this.asl.blX)) {
                com.baidu.swan.apps.af.a.c.g(this.asl.appId, n.dm(this.asl.blX));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zI() {
        if (this.asl != null) {
            com.baidu.swan.pms.model.a jj = com.baidu.swan.pms.database.a.Ry().jj(this.mAppId);
            if (jj == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.asl.appId = this.mAppId;
            this.asl.h(jj);
            if (this.asl.AE()) {
                this.asl.RH();
            }
            com.baidu.swan.pms.database.a.Ry().f(this.asl);
            b(this.asl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final g gVar) {
        b.zw().a(gVar, new b.InterfaceC0136b() { // from class: com.baidu.swan.apps.core.pms.d.11
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.ash = gVar;
                d.this.asg.g(gVar);
                if (d.this.asc != null) {
                    d.this.asc.onNext(gVar);
                    d.this.asc.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asg.f(gVar);
                if (d.this.asc != null) {
                    d.this.asc.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final i iVar) {
        b.zw().a(iVar, new b.InterfaceC0136b() { // from class: com.baidu.swan.apps.core.pms.d.12
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType) {
                if (d.this.asi == null) {
                    d.this.asi = new ArrayList();
                }
                iVar.appId = d.this.mAppId;
                d.this.asi.add(iVar);
                d.this.asg.g(iVar);
                if (d.this.asd != null) {
                    d.this.asd.onNext(iVar);
                    if (!d.this.asg.St()) {
                        d.this.asd.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asg.f(iVar);
                if (d.this.asd != null) {
                    d.this.asd.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.e eVar) {
        b.zw().a(eVar, new b.InterfaceC0136b() { // from class: com.baidu.swan.apps.core.pms.d.13
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.asj = eVar;
                d.this.asg.g(eVar);
                if (d.this.ase != null) {
                    d.this.ase.onNext(eVar);
                    d.this.ase.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asg.f(eVar);
                if (d.this.ase != null) {
                    d.this.ase.onError(new PkgDownloadError(eVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.c cVar) {
        b.zw().a(cVar, new b.InterfaceC0136b() { // from class: com.baidu.swan.apps.core.pms.d.14
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.ask = cVar;
                d.this.asg.g(cVar);
                if (d.this.asf != null) {
                    d.this.asf.onNext(cVar);
                    d.this.asf.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0136b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asg.f(cVar);
                if (d.this.asf != null) {
                    d.this.asf.onError(new PkgDownloadError(cVar, aVar));
                }
            }
        });
    }

    private void zJ() {
        ArrayList arrayList = new ArrayList();
        if (this.asg.Sp()) {
            arrayList.add(rx.d.a((d.a) new d.a<g>() { // from class: com.baidu.swan.apps.core.pms.d.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super g> jVar) {
                    d.this.asc = jVar;
                }
            }));
        }
        if (this.asg.Sq()) {
            arrayList.add(rx.d.a((d.a) new d.a<i>() { // from class: com.baidu.swan.apps.core.pms.d.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super i> jVar) {
                    d.this.asd = jVar;
                }
            }));
        }
        if (this.asg.Sr()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.d.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.e> jVar) {
                    d.this.ase = jVar;
                }
            }));
        }
        if (this.asg.Ss()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.c>() { // from class: com.baidu.swan.apps.core.pms.d.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.c> jVar) {
                    d.this.asf = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.h(arrayList).b(this.asr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(String str, String str2) {
        com.baidu.swan.apps.performance.d.a.a(this.mAppId, str, this.aoU, str2);
        this.aoU.clear();
    }
}
