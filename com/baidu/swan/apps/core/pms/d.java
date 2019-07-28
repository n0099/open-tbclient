package com.baidu.swan.apps.core.pms;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.o;
import com.baidu.swan.apps.core.pms.b;
import com.baidu.swan.apps.core.pms.c.c;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.e.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import okio.BufferedSource;
import rx.d;
import rx.j;
/* loaded from: classes2.dex */
public abstract class d extends g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private j<? super com.baidu.swan.pms.model.f> asO;
    private j<? super com.baidu.swan.pms.model.h> asP;
    private j<? super com.baidu.swan.pms.model.d> asQ;
    private j<? super com.baidu.swan.pms.model.b> asR;
    protected com.baidu.swan.pms.e.e asS;
    protected com.baidu.swan.pms.model.f asT;
    protected List<com.baidu.swan.pms.model.h> asU;
    protected com.baidu.swan.pms.model.d asV;
    protected com.baidu.swan.pms.model.b asW;
    protected PMSAppInfo asX;
    protected String mAppId;
    protected String apZ = "0";
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.f> asY = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.d.1
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gs() {
            return com.baidu.swan.apps.core.pms.c.a.za().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void F(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.eW(d.this.Bt()).FY().cH(1);
            super.F(fVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.eW(d.this.Bt()).FY().cH(1);
            super.G(fVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "main onDownloading");
            }
            d.this.b(fVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(com.baidu.swan.pms.model.f fVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) fVar, aVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            }
            d.this.asS.h(fVar);
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(11L).aa(aVar.errorNo).m14if("主包下载失败").ig(aVar.toString());
            if (d.this.asO != null) {
                d.this.asO.onError(new PkgDownloadError(fVar, ig));
            }
            b.Bh().a(fVar, d.this.Bl(), ig);
            com.baidu.swan.c.a.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void E(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.eW(d.this.Bt()).FY().cH(1);
            super.E(fVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + fVar.toString());
            }
            d.this.apK.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ak.a a = d.this.a(fVar);
            if (a == null) {
                d.this.asT = fVar;
                d.this.asS.i(fVar);
                if (d.this.asO != null) {
                    d.this.asO.onNext(fVar);
                    d.this.asO.onCompleted();
                }
                b.Bh().a(fVar, d.this.Bl());
                return;
            }
            d.this.asS.h(fVar);
            if (d.this.asO != null) {
                d.this.asO.onError(new PkgDownloadError(fVar, a));
            }
            b.Bh().a(fVar, d.this.Bl(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public boolean a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            boolean wz = com.baidu.swan.apps.u.a.En().wz();
            com.baidu.swan.apps.v.c.a.eW(d.this.Bt()).al("stream", String.valueOf(wz)).eX(fVar.toString()).cH(1);
            com.baidu.swan.apps.install.g gVar = new com.baidu.swan.apps.install.g();
            if (wz) {
                gVar.a(new com.baidu.swan.apps.install.f(fVar, d.this));
                gVar.a(new com.baidu.swan.apps.install.d(fVar.sign, d.this));
            }
            gVar.a(new com.baidu.swan.apps.install.c(file));
            gVar.a(new com.baidu.swan.apps.an.d.a<String>() { // from class: com.baidu.swan.apps.core.pms.d.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: onCallback */
                public void D(String str) {
                    if ("pump_finish".equals(str)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("performance_ubc_event_id", "670");
                        bundle.putString("performance_ubc_extra_key_for_event", "aiapp_stream_bump_end_timestamp");
                        com.baidu.swan.pms.a.g.a(this, bundle, "event_performance_ubc");
                    }
                    com.baidu.swan.apps.v.c.a.eW(d.this.Bt()).ak("SwanAppPkgDownloadCallback", "install Event: " + str).Gg();
                }
            });
            return gVar.b(bufferedSource).isOk();
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.h> asZ = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.h>() { // from class: com.baidu.swan.apps.core.pms.d.7
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gs() {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: b */
        public void F(com.baidu.swan.pms.model.h hVar) {
            super.F(hVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void G(com.baidu.swan.pms.model.h hVar) {
            super.G(hVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "sub onDownloading");
            }
            d.this.a(hVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(com.baidu.swan.pms.model.h hVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass7) hVar, aVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            }
            d.this.asS.h(hVar);
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(12L).aa(aVar.errorNo).m14if("分包下载失败").ig(aVar.toString());
            if (d.this.asP != null) {
                d.this.asP.onError(new PkgDownloadError(hVar, ig));
            }
            b.Bh().a(hVar, d.this.Bl(), ig);
            com.baidu.swan.c.a.deleteFile(hVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void E(com.baidu.swan.pms.model.h hVar) {
            super.E(hVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + hVar.toString());
            }
            if (d.this.asU == null) {
                d.this.asU = new ArrayList();
            }
            hVar.appId = d.this.mAppId;
            d.this.asU.add(hVar);
            d.this.asS.i(hVar);
            if (d.this.asP != null) {
                d.this.asP.onNext(hVar);
                if (!d.this.asS.WZ()) {
                    d.this.asP.onCompleted();
                }
            }
            b.Bh().a(hVar, d.this.Bl());
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> ata = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.d.8
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gs() {
            return com.baidu.swan.apps.core.pms.c.a.BB();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void F(com.baidu.swan.pms.model.d dVar) {
            super.F(dVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.d dVar) {
            super.G(dVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "framework onDownloading");
            }
            d.this.b(dVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass8) dVar, aVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            }
            d.this.asS.h(dVar);
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(13L).aa(aVar.errorNo).m14if("Framework包下载失败").ig(aVar.toString());
            if (d.this.asQ != null) {
                d.this.asQ.onError(new PkgDownloadError(dVar, ig));
            }
            b.Bh().a(dVar, d.this.Bl(), ig);
            com.baidu.swan.c.a.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void E(com.baidu.swan.pms.model.d dVar) {
            super.E(dVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ak.a a = d.this.a(dVar);
            if (a == null) {
                d.this.asV = dVar;
                d.this.asS.i(dVar);
                if (d.this.asQ != null) {
                    d.this.asQ.onNext(dVar);
                    d.this.asQ.onCompleted();
                }
                b.Bh().a(dVar, d.this.Bl());
                return;
            }
            d.this.asS.h(dVar);
            if (d.this.asQ != null) {
                d.this.asQ.onError(new PkgDownloadError(dVar, a));
            }
            b.Bh().a(dVar, d.this.Bl(), a);
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> atb = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.d.9
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gs() {
            return com.baidu.swan.apps.core.pms.c.a.Bz();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void F(com.baidu.swan.pms.model.b bVar) {
            super.F(bVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.b bVar) {
            super.G(bVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "extension onDownloading");
            }
            d.this.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass9) bVar, aVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            }
            d.this.asS.h(bVar);
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(14L).aa(aVar.errorNo).m14if("Extension下载失败").ig(aVar.toString());
            if (d.this.asR != null) {
                d.this.asR.onError(new PkgDownloadError(bVar, ig));
            }
            b.Bh().a(bVar, d.this.Bl(), ig);
            com.baidu.swan.c.a.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void E(com.baidu.swan.pms.model.b bVar) {
            super.E(bVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + bVar.toString());
            }
            com.baidu.swan.apps.ak.a a = d.this.a(bVar);
            if (a == null) {
                d.this.asW = bVar;
                d.this.asS.i(bVar);
                if (d.this.asR != null) {
                    d.this.asR.onNext(bVar);
                    d.this.asR.onCompleted();
                }
                b.Bh().a(bVar, d.this.Bl());
                return;
            }
            d.this.asS.h(bVar);
            if (d.this.asR != null) {
                d.this.asR.onError(new PkgDownloadError(bVar, a));
            }
            b.Bh().a(bVar, d.this.Bl(), a);
        }
    };
    private com.baidu.swan.pms.a.e atc = new com.baidu.swan.pms.a.e() { // from class: com.baidu.swan.apps.core.pms.d.10
        @Override // com.baidu.swan.pms.a.e
        public void b(PMSAppInfo pMSAppInfo) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", "onSwanAppReceive: " + pMSAppInfo.toString());
            }
            d.this.asX = pMSAppInfo;
            if (d.this.asX != null) {
                if (d.this.apK != null) {
                    d.this.apK.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.c.c.a(d.this.asX.iconUrl, new c.a() { // from class: com.baidu.swan.apps.core.pms.d.10.1
                    @Override // com.baidu.swan.apps.core.pms.c.c.a
                    public void g(Bitmap bitmap) {
                        if (d.this.apK != null) {
                            d.this.apK.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private j<com.baidu.swan.pms.model.e> atd = new j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.d.2
        @Override // rx.e
        public void onCompleted() {
            if (d.this.asT != null && d.this.asU != null) {
                com.baidu.swan.apps.core.pms.c.b.a(d.this.asT.bsR, d.this.asT.versionCode, d.this.asU);
            }
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.Bl() + " : 包下载onCompleted");
            }
            d.this.Bk();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.Bl() + " : 包下载OnError：" + th.toString());
            }
            d.this.k(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.Bl() + " : 单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> apK = new ArrayList();

    protected abstract void Bk();

    protected abstract PMSDownloadType Bl();

    protected abstract void k(Throwable th);

    public d(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.f
    public void zj() {
        this.apK.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void Bn() {
        this.apK.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        this.apK.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.e.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.apK.add(new UbcFlowEvent("na_pms_start_download"));
            this.asS = eVar;
            if (!this.asS.isEmpty()) {
                Bw();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.f> Bo() {
        return this.asY;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.h> Bp() {
        return this.asZ;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> Bq() {
        return this.ata;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> Br() {
        return this.atb;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.e Bs() {
        return this.atc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Bt() {
        return com.baidu.swan.pms.a.g.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.apps.v.c.a eW = com.baidu.swan.apps.v.c.a.eW(Bt());
        eW.FY().cH(1);
        boolean wz = com.baidu.swan.apps.u.a.En().wz();
        long currentTimeMillis = System.currentTimeMillis();
        if (!wz) {
            com.baidu.swan.apps.ak.a a = com.baidu.swan.apps.core.pms.c.a.a(fVar, this);
            eW.eX("CostCheckSign: " + (System.currentTimeMillis() - currentTimeMillis));
            if (a != null) {
                return a;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        com.baidu.swan.apps.ak.a b = com.baidu.swan.apps.core.pms.c.a.b(fVar);
        eW.eX("CostRenameZip: " + (System.currentTimeMillis() - currentTimeMillis2));
        if (b == null) {
            if (!wz) {
                long currentTimeMillis3 = System.currentTimeMillis();
                com.baidu.swan.apps.ak.a b2 = com.baidu.swan.apps.core.pms.c.a.b(fVar, this);
                eW.eX("CostUnzip: " + (System.currentTimeMillis() - currentTimeMillis3));
                if (b2 != null) {
                    return b2;
                }
            }
            return null;
        }
        return b;
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0186a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.ave);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.a.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.ak.a().Z(13L).ab(2907L).m14if("Core包更新失败");
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.awU = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.a.CT().a((com.baidu.swan.apps.extcore.a) aVar)) {
            return null;
        }
        return new com.baidu.swan.apps.ak.a().Z(14L).ab(2908L).m14if("Extension包更新失败");
    }

    protected void a(PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.f fVar) {
        if (pMSAppInfo != null && fVar != null) {
            this.asX.g(fVar);
            if (fVar.ave == 1) {
                com.baidu.swan.games.p.a.a u = com.baidu.swan.apps.core.pms.c.a.u(fVar.bsR, fVar.versionCode);
                if (u != null) {
                    pMSAppInfo.orientation = u.bjX;
                    return;
                } else {
                    pMSAppInfo.orientation = 0;
                    return;
                }
            }
            pMSAppInfo.orientation = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cq(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.We().I(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.We().I(this.mAppId, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.ak.a Bu() {
        if (this.asX == null) {
            if (this.asT == null) {
                return new com.baidu.swan.apps.ak.a().Z(10L).aa(2903L).m14if("Server未返回主包&AppInfo");
            }
            PMSAppInfo kp = com.baidu.swan.pms.database.a.We().kp(this.mAppId);
            if (kp == null) {
                return new com.baidu.swan.apps.ak.a().Z(10L).aa(2904L).m14if("Server未返回AppInfo数据，本地也没有数据");
            }
            this.asX = kp;
            a(this.asX, this.asT);
            this.asX.Wn();
            if (com.baidu.swan.pms.database.a.We().a(this.asT, this.asU, this.asV, this.asW, this.asX)) {
                return null;
            }
            return new com.baidu.swan.apps.ak.a().Z(10L).aa(2906L).m14if("更新DB失败");
        }
        if (this.asT != null) {
            a(this.asX, this.asT);
        } else {
            PMSAppInfo kp2 = com.baidu.swan.pms.database.a.We().kp(this.mAppId);
            if (kp2 == null) {
                return new com.baidu.swan.apps.ak.a().Z(10L).aa(2905L).m14if("Server未返回包数据，本地也没有数据");
            }
            this.asX.appId = this.mAppId;
            this.asX.h(kp2);
        }
        this.asX.Wn();
        if (com.baidu.swan.pms.database.a.We().a(this.asT, this.asU, this.asV, this.asW, this.asX)) {
            a(this.asX);
            return null;
        }
        return new com.baidu.swan.apps.ak.a().Z(10L).aa(2906L).m14if("更新DB失败");
    }

    protected void a(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(this.asX.bsM)) {
                com.baidu.swan.apps.af.a.c.a(this.asX.appId, "", o.il(this.asX.bsM));
            }
            if (!TextUtils.isEmpty(this.asX.bsN)) {
                com.baidu.swan.apps.af.a.c.a("", o.il(this.asX.bsN));
            }
            if (!TextUtils.isEmpty(this.asX.bsO)) {
                com.baidu.swan.apps.af.a.c.h(this.asX.appId, o.dd(this.asX.bsO));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bv() {
        if (this.asX != null) {
            PMSAppInfo kp = com.baidu.swan.pms.database.a.We().kp(this.mAppId);
            if (kp == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.asX.appId = this.mAppId;
            this.asX.h(kp);
            if (this.asX.Ct()) {
                this.asX.Wn();
            }
            com.baidu.swan.pms.database.a.We().f(this.asX);
            a(this.asX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        b.Bh().a(fVar, new b.InterfaceC0141b() { // from class: com.baidu.swan.apps.core.pms.d.11
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0141b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.asT = fVar;
                d.this.asS.i(fVar);
                if (d.this.asO != null) {
                    d.this.asO.onNext(fVar);
                    d.this.asO.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0141b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asS.h(fVar);
                if (d.this.asO != null) {
                    d.this.asO.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.swan.pms.model.h hVar) {
        b.Bh().a(hVar, new b.InterfaceC0141b() { // from class: com.baidu.swan.apps.core.pms.d.12
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0141b
            public void a(PMSDownloadType pMSDownloadType) {
                if (d.this.asU == null) {
                    d.this.asU = new ArrayList();
                }
                hVar.appId = d.this.mAppId;
                d.this.asU.add(hVar);
                d.this.asS.i(hVar);
                if (d.this.asP != null) {
                    d.this.asP.onNext(hVar);
                    if (!d.this.asS.WZ()) {
                        d.this.asP.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0141b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asS.h(hVar);
                if (d.this.asP != null) {
                    d.this.asP.onError(new PkgDownloadError(hVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        b.Bh().a(dVar, new b.InterfaceC0141b() { // from class: com.baidu.swan.apps.core.pms.d.13
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0141b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.asV = dVar;
                d.this.asS.i(dVar);
                if (d.this.asQ != null) {
                    d.this.asQ.onNext(dVar);
                    d.this.asQ.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0141b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asS.h(dVar);
                if (d.this.asQ != null) {
                    d.this.asQ.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        b.Bh().a(bVar, new b.InterfaceC0141b() { // from class: com.baidu.swan.apps.core.pms.d.14
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0141b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.asW = bVar;
                d.this.asS.i(bVar);
                if (d.this.asR != null) {
                    d.this.asR.onNext(bVar);
                    d.this.asR.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0141b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asS.h(bVar);
                if (d.this.asR != null) {
                    d.this.asR.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void Bw() {
        ArrayList arrayList = new ArrayList();
        if (this.asS.WV()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.d.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.f> jVar) {
                    d.this.asO = jVar;
                }
            }));
        }
        if (this.asS.WW()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.h>() { // from class: com.baidu.swan.apps.core.pms.d.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.h> jVar) {
                    d.this.asP = jVar;
                }
            }));
        }
        if (this.asS.WX()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.d.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.d> jVar) {
                    d.this.asQ = jVar;
                }
            }));
        }
        if (this.asS.WY()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.d.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.b> jVar) {
                    d.this.asR = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.h(arrayList).b(this.atd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa(String str, String str2) {
        com.baidu.swan.apps.performance.d.a.a(this.mAppId, str, this.apK, str2);
        this.apK.clear();
    }
}
