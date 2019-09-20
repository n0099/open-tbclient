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
    private j<? super com.baidu.swan.pms.model.f> atm;
    private j<? super com.baidu.swan.pms.model.h> atn;
    private j<? super com.baidu.swan.pms.model.d> ato;
    private j<? super com.baidu.swan.pms.model.b> atp;
    protected com.baidu.swan.pms.e.e atq;
    protected com.baidu.swan.pms.model.f atr;
    protected List<com.baidu.swan.pms.model.h> ats;
    protected com.baidu.swan.pms.model.d att;
    protected com.baidu.swan.pms.model.b atu;
    protected PMSAppInfo atv;
    protected String mAppId;
    protected String aqx = "0";
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.f> atw = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.d.1
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gs() {
            return com.baidu.swan.apps.core.pms.c.a.ze().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void F(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.eY(d.this.Bx()).Gc().cI(1);
            super.F(fVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.eY(d.this.Bx()).Gc().cI(1);
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
            d.this.atq.h(fVar);
            com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(11L).aa(aVar.errorNo).ih("主包下载失败").ii(aVar.toString());
            if (d.this.atm != null) {
                d.this.atm.onError(new PkgDownloadError(fVar, ii));
            }
            b.Bl().a(fVar, d.this.Bp(), ii);
            com.baidu.swan.c.a.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void E(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.eY(d.this.Bx()).Gc().cI(1);
            super.E(fVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + fVar.toString());
            }
            d.this.aqi.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ak.a a = d.this.a(fVar);
            if (a == null) {
                d.this.atr = fVar;
                d.this.atq.i(fVar);
                if (d.this.atm != null) {
                    d.this.atm.onNext(fVar);
                    d.this.atm.onCompleted();
                }
                b.Bl().a(fVar, d.this.Bp());
                return;
            }
            d.this.atq.h(fVar);
            if (d.this.atm != null) {
                d.this.atm.onError(new PkgDownloadError(fVar, a));
            }
            b.Bl().a(fVar, d.this.Bp(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public boolean a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            boolean wD = com.baidu.swan.apps.u.a.Er().wD();
            com.baidu.swan.apps.v.c.a.eY(d.this.Bx()).al("stream", String.valueOf(wD)).eZ(fVar.toString()).cI(1);
            com.baidu.swan.apps.install.g gVar = new com.baidu.swan.apps.install.g();
            if (wD) {
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
                    com.baidu.swan.apps.v.c.a.eY(d.this.Bx()).ak("SwanAppPkgDownloadCallback", "install Event: " + str).Gk();
                }
            });
            return gVar.b(bufferedSource).isOk();
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.h> atx = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.h>() { // from class: com.baidu.swan.apps.core.pms.d.7
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
            d.this.atq.h(hVar);
            com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(12L).aa(aVar.errorNo).ih("分包下载失败").ii(aVar.toString());
            if (d.this.atn != null) {
                d.this.atn.onError(new PkgDownloadError(hVar, ii));
            }
            b.Bl().a(hVar, d.this.Bp(), ii);
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
            if (d.this.ats == null) {
                d.this.ats = new ArrayList();
            }
            hVar.appId = d.this.mAppId;
            d.this.ats.add(hVar);
            d.this.atq.i(hVar);
            if (d.this.atn != null) {
                d.this.atn.onNext(hVar);
                if (!d.this.atq.Xd()) {
                    d.this.atn.onCompleted();
                }
            }
            b.Bl().a(hVar, d.this.Bp());
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> aty = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.d.8
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gs() {
            return com.baidu.swan.apps.core.pms.c.a.BF();
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
            d.this.atq.h(dVar);
            com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(13L).aa(aVar.errorNo).ih("Framework包下载失败").ii(aVar.toString());
            if (d.this.ato != null) {
                d.this.ato.onError(new PkgDownloadError(dVar, ii));
            }
            b.Bl().a(dVar, d.this.Bp(), ii);
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
                d.this.att = dVar;
                d.this.atq.i(dVar);
                if (d.this.ato != null) {
                    d.this.ato.onNext(dVar);
                    d.this.ato.onCompleted();
                }
                b.Bl().a(dVar, d.this.Bp());
                return;
            }
            d.this.atq.h(dVar);
            if (d.this.ato != null) {
                d.this.ato.onError(new PkgDownloadError(dVar, a));
            }
            b.Bl().a(dVar, d.this.Bp(), a);
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> atz = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.d.9
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gs() {
            return com.baidu.swan.apps.core.pms.c.a.BD();
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
            d.this.atq.h(bVar);
            com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(14L).aa(aVar.errorNo).ih("Extension下载失败").ii(aVar.toString());
            if (d.this.atp != null) {
                d.this.atp.onError(new PkgDownloadError(bVar, ii));
            }
            b.Bl().a(bVar, d.this.Bp(), ii);
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
                d.this.atu = bVar;
                d.this.atq.i(bVar);
                if (d.this.atp != null) {
                    d.this.atp.onNext(bVar);
                    d.this.atp.onCompleted();
                }
                b.Bl().a(bVar, d.this.Bp());
                return;
            }
            d.this.atq.h(bVar);
            if (d.this.atp != null) {
                d.this.atp.onError(new PkgDownloadError(bVar, a));
            }
            b.Bl().a(bVar, d.this.Bp(), a);
        }
    };
    private com.baidu.swan.pms.a.e atA = new com.baidu.swan.pms.a.e() { // from class: com.baidu.swan.apps.core.pms.d.10
        @Override // com.baidu.swan.pms.a.e
        public void b(PMSAppInfo pMSAppInfo) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", "onSwanAppReceive: " + pMSAppInfo.toString());
            }
            d.this.atv = pMSAppInfo;
            if (d.this.atv != null) {
                if (d.this.aqi != null) {
                    d.this.aqi.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.c.c.a(d.this.atv.iconUrl, new c.a() { // from class: com.baidu.swan.apps.core.pms.d.10.1
                    @Override // com.baidu.swan.apps.core.pms.c.c.a
                    public void g(Bitmap bitmap) {
                        if (d.this.aqi != null) {
                            d.this.aqi.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private j<com.baidu.swan.pms.model.e> atB = new j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.d.2
        @Override // rx.e
        public void onCompleted() {
            if (d.this.atr != null && d.this.ats != null) {
                com.baidu.swan.apps.core.pms.c.b.a(d.this.atr.btp, d.this.atr.versionCode, d.this.ats);
            }
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.Bp() + " : 包下载onCompleted");
            }
            d.this.Bo();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.Bp() + " : 包下载OnError：" + th.toString());
            }
            d.this.k(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.Bp() + " : 单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> aqi = new ArrayList();

    protected abstract void Bo();

    protected abstract PMSDownloadType Bp();

    protected abstract void k(Throwable th);

    public d(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.f
    public void zn() {
        this.aqi.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void Br() {
        this.aqi.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        this.aqi.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.e.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.aqi.add(new UbcFlowEvent("na_pms_start_download"));
            this.atq = eVar;
            if (!this.atq.isEmpty()) {
                BA();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.f> Bs() {
        return this.atw;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.h> Bt() {
        return this.atx;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> Bu() {
        return this.aty;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> Bv() {
        return this.atz;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.e Bw() {
        return this.atA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Bx() {
        return com.baidu.swan.pms.a.g.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.apps.v.c.a eY = com.baidu.swan.apps.v.c.a.eY(Bx());
        eY.Gc().cI(1);
        boolean wD = com.baidu.swan.apps.u.a.Er().wD();
        long currentTimeMillis = System.currentTimeMillis();
        if (!wD) {
            com.baidu.swan.apps.ak.a a = com.baidu.swan.apps.core.pms.c.a.a(fVar, this);
            eY.eZ("CostCheckSign: " + (System.currentTimeMillis() - currentTimeMillis));
            if (a != null) {
                return a;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        com.baidu.swan.apps.ak.a b = com.baidu.swan.apps.core.pms.c.a.b(fVar);
        eY.eZ("CostRenameZip: " + (System.currentTimeMillis() - currentTimeMillis2));
        if (b == null) {
            if (!wD) {
                long currentTimeMillis3 = System.currentTimeMillis();
                com.baidu.swan.apps.ak.a b2 = com.baidu.swan.apps.core.pms.c.a.b(fVar, this);
                eY.eZ("CostUnzip: " + (System.currentTimeMillis() - currentTimeMillis3));
                if (b2 != null) {
                    return b2;
                }
            }
            return null;
        }
        return b;
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0195a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.avC);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.a.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.ak.a().Z(13L).ab(2907L).ih("Core包更新失败");
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.axs = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.a.CX().a((com.baidu.swan.apps.extcore.a) aVar)) {
            return null;
        }
        return new com.baidu.swan.apps.ak.a().Z(14L).ab(2908L).ih("Extension包更新失败");
    }

    protected void a(PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.f fVar) {
        if (pMSAppInfo != null && fVar != null) {
            this.atv.g(fVar);
            if (fVar.avC == 1) {
                com.baidu.swan.games.p.a.a u = com.baidu.swan.apps.core.pms.c.a.u(fVar.btp, fVar.versionCode);
                if (u != null) {
                    pMSAppInfo.orientation = u.bkv;
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
    public void cr(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.Wi().I(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.Wi().I(this.mAppId, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.ak.a By() {
        if (this.atv == null) {
            if (this.atr == null) {
                return new com.baidu.swan.apps.ak.a().Z(10L).aa(2903L).ih("Server未返回主包&AppInfo");
            }
            PMSAppInfo kr = com.baidu.swan.pms.database.a.Wi().kr(this.mAppId);
            if (kr == null) {
                return new com.baidu.swan.apps.ak.a().Z(10L).aa(2904L).ih("Server未返回AppInfo数据，本地也没有数据");
            }
            this.atv = kr;
            a(this.atv, this.atr);
            this.atv.Wr();
            if (com.baidu.swan.pms.database.a.Wi().a(this.atr, this.ats, this.att, this.atu, this.atv)) {
                return null;
            }
            return new com.baidu.swan.apps.ak.a().Z(10L).aa(2906L).ih("更新DB失败");
        }
        if (this.atr != null) {
            a(this.atv, this.atr);
        } else {
            PMSAppInfo kr2 = com.baidu.swan.pms.database.a.Wi().kr(this.mAppId);
            if (kr2 == null) {
                return new com.baidu.swan.apps.ak.a().Z(10L).aa(2905L).ih("Server未返回包数据，本地也没有数据");
            }
            this.atv.appId = this.mAppId;
            this.atv.h(kr2);
        }
        this.atv.Wr();
        if (com.baidu.swan.pms.database.a.Wi().a(this.atr, this.ats, this.att, this.atu, this.atv)) {
            a(this.atv);
            return null;
        }
        return new com.baidu.swan.apps.ak.a().Z(10L).aa(2906L).ih("更新DB失败");
    }

    protected void a(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(this.atv.btk)) {
                com.baidu.swan.apps.af.a.c.a(this.atv.appId, "", o.in(this.atv.btk));
            }
            if (!TextUtils.isEmpty(this.atv.btl)) {
                com.baidu.swan.apps.af.a.c.a("", o.in(this.atv.btl));
            }
            if (!TextUtils.isEmpty(this.atv.btm)) {
                com.baidu.swan.apps.af.a.c.h(this.atv.appId, o.df(this.atv.btm));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bz() {
        if (this.atv != null) {
            PMSAppInfo kr = com.baidu.swan.pms.database.a.Wi().kr(this.mAppId);
            if (kr == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.atv.appId = this.mAppId;
            this.atv.h(kr);
            if (this.atv.Cx()) {
                this.atv.Wr();
            }
            com.baidu.swan.pms.database.a.Wi().f(this.atv);
            a(this.atv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        b.Bl().a(fVar, new b.InterfaceC0150b() { // from class: com.baidu.swan.apps.core.pms.d.11
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0150b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.atr = fVar;
                d.this.atq.i(fVar);
                if (d.this.atm != null) {
                    d.this.atm.onNext(fVar);
                    d.this.atm.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0150b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.atq.h(fVar);
                if (d.this.atm != null) {
                    d.this.atm.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.swan.pms.model.h hVar) {
        b.Bl().a(hVar, new b.InterfaceC0150b() { // from class: com.baidu.swan.apps.core.pms.d.12
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0150b
            public void a(PMSDownloadType pMSDownloadType) {
                if (d.this.ats == null) {
                    d.this.ats = new ArrayList();
                }
                hVar.appId = d.this.mAppId;
                d.this.ats.add(hVar);
                d.this.atq.i(hVar);
                if (d.this.atn != null) {
                    d.this.atn.onNext(hVar);
                    if (!d.this.atq.Xd()) {
                        d.this.atn.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0150b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.atq.h(hVar);
                if (d.this.atn != null) {
                    d.this.atn.onError(new PkgDownloadError(hVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        b.Bl().a(dVar, new b.InterfaceC0150b() { // from class: com.baidu.swan.apps.core.pms.d.13
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0150b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.att = dVar;
                d.this.atq.i(dVar);
                if (d.this.ato != null) {
                    d.this.ato.onNext(dVar);
                    d.this.ato.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0150b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.atq.h(dVar);
                if (d.this.ato != null) {
                    d.this.ato.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        b.Bl().a(bVar, new b.InterfaceC0150b() { // from class: com.baidu.swan.apps.core.pms.d.14
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0150b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.atu = bVar;
                d.this.atq.i(bVar);
                if (d.this.atp != null) {
                    d.this.atp.onNext(bVar);
                    d.this.atp.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0150b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.atq.h(bVar);
                if (d.this.atp != null) {
                    d.this.atp.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void BA() {
        ArrayList arrayList = new ArrayList();
        if (this.atq.WZ()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.d.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.f> jVar) {
                    d.this.atm = jVar;
                }
            }));
        }
        if (this.atq.Xa()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.h>() { // from class: com.baidu.swan.apps.core.pms.d.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.h> jVar) {
                    d.this.atn = jVar;
                }
            }));
        }
        if (this.atq.Xb()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.d.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.d> jVar) {
                    d.this.ato = jVar;
                }
            }));
        }
        if (this.atq.Xc()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.d.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.b> jVar) {
                    d.this.atp = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.h(arrayList).b(this.atB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa(String str, String str2) {
        com.baidu.swan.apps.performance.d.a.a(this.mAppId, str, this.aqi, str2);
        this.aqi.clear();
    }
}
