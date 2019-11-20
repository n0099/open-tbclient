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
    private j<? super com.baidu.swan.pms.model.f> aMl;
    private j<? super com.baidu.swan.pms.model.h> aMm;
    private j<? super com.baidu.swan.pms.model.d> aMn;
    private j<? super com.baidu.swan.pms.model.b> aMo;
    protected com.baidu.swan.pms.e.e aMp;
    protected com.baidu.swan.pms.model.f aMq;
    protected List<com.baidu.swan.pms.model.h> aMr;
    protected com.baidu.swan.pms.model.d aMs;
    protected com.baidu.swan.pms.model.b aMt;
    protected PMSAppInfo aMu;
    protected String mAppId;
    protected String aJv = "0";
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.f> aMv = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.d.1
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String getDownloadPath() {
            return com.baidu.swan.apps.core.pms.c.a.Ea().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void D(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.fF(d.this.Gt()).KX().dD(1);
            super.D(fVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void E(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.fF(d.this.Gt()).KX().dD(1);
            super.E(fVar);
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
            d.this.aMp.h(fVar);
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(11L).as(aVar.errorNo).iK("主包下载失败").iL(aVar.toString());
            if (d.this.aMl != null) {
                d.this.aMl.onError(new PkgDownloadError(fVar, iL));
            }
            b.Gh().a(fVar, d.this.Gl(), iL);
            com.baidu.swan.c.a.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void C(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.fF(d.this.Gt()).KX().dD(1);
            super.C(fVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + fVar.toString());
            }
            d.this.aJg.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ak.a a = d.this.a(fVar);
            if (a == null) {
                d.this.aMq = fVar;
                d.this.aMp.i(fVar);
                if (d.this.aMl != null) {
                    d.this.aMl.onNext(fVar);
                    d.this.aMl.onCompleted();
                }
                b.Gh().a(fVar, d.this.Gl());
                return;
            }
            d.this.aMp.h(fVar);
            if (d.this.aMl != null) {
                d.this.aMl.onError(new PkgDownloadError(fVar, a));
            }
            b.Gh().a(fVar, d.this.Gl(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public boolean a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            boolean By = com.baidu.swan.apps.u.a.Jm().By();
            com.baidu.swan.apps.v.c.a.fF(d.this.Gt()).at("stream", String.valueOf(By)).fG(fVar.toString()).dD(1);
            com.baidu.swan.apps.install.g gVar = new com.baidu.swan.apps.install.g();
            if (By) {
                gVar.a(new com.baidu.swan.apps.install.f(fVar, d.this));
                gVar.a(new com.baidu.swan.apps.install.d(fVar.sign, d.this));
            }
            gVar.a(new com.baidu.swan.apps.install.c(file));
            gVar.a(new com.baidu.swan.apps.an.d.a<String>() { // from class: com.baidu.swan.apps.core.pms.d.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: onCallback */
                public void B(String str) {
                    if ("pump_finish".equals(str)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("performance_ubc_event_id", "670");
                        bundle.putString("performance_ubc_extra_key_for_event", "aiapp_stream_bump_end_timestamp");
                        com.baidu.swan.pms.a.g.a(this, bundle, "event_performance_ubc");
                    }
                    com.baidu.swan.apps.v.c.a.fF(d.this.Gt()).as("SwanAppPkgDownloadCallback", "install Event: " + str).Lf();
                }
            });
            return gVar.b(bufferedSource).isOk();
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.h> aMw = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.h>() { // from class: com.baidu.swan.apps.core.pms.d.7
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String getDownloadPath() {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: b */
        public void D(com.baidu.swan.pms.model.h hVar) {
            super.D(hVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void E(com.baidu.swan.pms.model.h hVar) {
            super.E(hVar);
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
            d.this.aMp.h(hVar);
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(12L).as(aVar.errorNo).iK("分包下载失败").iL(aVar.toString());
            if (d.this.aMm != null) {
                d.this.aMm.onError(new PkgDownloadError(hVar, iL));
            }
            b.Gh().a(hVar, d.this.Gl(), iL);
            com.baidu.swan.c.a.deleteFile(hVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void C(com.baidu.swan.pms.model.h hVar) {
            super.C(hVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + hVar.toString());
            }
            if (d.this.aMr == null) {
                d.this.aMr = new ArrayList();
            }
            hVar.appId = d.this.mAppId;
            d.this.aMr.add(hVar);
            d.this.aMp.i(hVar);
            if (d.this.aMm != null) {
                d.this.aMm.onNext(hVar);
                if (!d.this.aMp.abQ()) {
                    d.this.aMm.onCompleted();
                }
            }
            b.Gh().a(hVar, d.this.Gl());
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> aMx = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.d.8
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String getDownloadPath() {
            return com.baidu.swan.apps.core.pms.c.a.GA();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void D(com.baidu.swan.pms.model.d dVar) {
            super.D(dVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void E(com.baidu.swan.pms.model.d dVar) {
            super.E(dVar);
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
            d.this.aMp.h(dVar);
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(13L).as(aVar.errorNo).iK("Framework包下载失败").iL(aVar.toString());
            if (d.this.aMn != null) {
                d.this.aMn.onError(new PkgDownloadError(dVar, iL));
            }
            b.Gh().a(dVar, d.this.Gl(), iL);
            com.baidu.swan.c.a.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void C(com.baidu.swan.pms.model.d dVar) {
            super.C(dVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ak.a a = d.this.a(dVar);
            if (a == null) {
                d.this.aMs = dVar;
                d.this.aMp.i(dVar);
                if (d.this.aMn != null) {
                    d.this.aMn.onNext(dVar);
                    d.this.aMn.onCompleted();
                }
                b.Gh().a(dVar, d.this.Gl());
                return;
            }
            d.this.aMp.h(dVar);
            if (d.this.aMn != null) {
                d.this.aMn.onError(new PkgDownloadError(dVar, a));
            }
            b.Gh().a(dVar, d.this.Gl(), a);
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> aMy = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.d.9
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String getDownloadPath() {
            return com.baidu.swan.apps.core.pms.c.a.Gy();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void D(com.baidu.swan.pms.model.b bVar) {
            super.D(bVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void E(com.baidu.swan.pms.model.b bVar) {
            super.E(bVar);
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
            d.this.aMp.h(bVar);
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(14L).as(aVar.errorNo).iK("Extension下载失败").iL(aVar.toString());
            if (d.this.aMo != null) {
                d.this.aMo.onError(new PkgDownloadError(bVar, iL));
            }
            b.Gh().a(bVar, d.this.Gl(), iL);
            com.baidu.swan.c.a.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void C(com.baidu.swan.pms.model.b bVar) {
            super.C(bVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + bVar.toString());
            }
            com.baidu.swan.apps.ak.a a = d.this.a(bVar);
            if (a == null) {
                d.this.aMt = bVar;
                d.this.aMp.i(bVar);
                if (d.this.aMo != null) {
                    d.this.aMo.onNext(bVar);
                    d.this.aMo.onCompleted();
                }
                b.Gh().a(bVar, d.this.Gl());
                return;
            }
            d.this.aMp.h(bVar);
            if (d.this.aMo != null) {
                d.this.aMo.onError(new PkgDownloadError(bVar, a));
            }
            b.Gh().a(bVar, d.this.Gl(), a);
        }
    };
    private com.baidu.swan.pms.a.e aMz = new com.baidu.swan.pms.a.e() { // from class: com.baidu.swan.apps.core.pms.d.10
        @Override // com.baidu.swan.pms.a.e
        public void b(PMSAppInfo pMSAppInfo) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", "onSwanAppReceive: " + pMSAppInfo.toString());
            }
            d.this.aMu = pMSAppInfo;
            if (d.this.aMu != null) {
                if (d.this.aJg != null) {
                    d.this.aJg.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.c.c.a(d.this.aMu.iconUrl, new c.a() { // from class: com.baidu.swan.apps.core.pms.d.10.1
                    @Override // com.baidu.swan.apps.core.pms.c.c.a
                    public void i(Bitmap bitmap) {
                        if (d.this.aJg != null) {
                            d.this.aJg.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private j<com.baidu.swan.pms.model.e> aMA = new j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.d.2
        @Override // rx.e
        public void onCompleted() {
            if (d.this.aMq != null && d.this.aMr != null) {
                com.baidu.swan.apps.core.pms.c.b.b(d.this.aMq.bLj, d.this.aMq.versionCode, d.this.aMr);
            }
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.Gl() + " : 包下载onCompleted");
            }
            d.this.Gk();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.Gl() + " : 包下载OnError：" + th.toString());
            }
            d.this.k(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.Gl() + " : 单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> aJg = new ArrayList();

    protected abstract void Gk();

    protected abstract PMSDownloadType Gl();

    protected abstract void k(Throwable th);

    public d(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.f
    public void Ej() {
        this.aJg.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void Gn() {
        this.aJg.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        this.aJg.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.e.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.aJg.add(new UbcFlowEvent("na_pms_start_download"));
            this.aMp = eVar;
            if (!this.aMp.isEmpty()) {
                Gw();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.f> Go() {
        return this.aMv;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.h> Gp() {
        return this.aMw;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> Gq() {
        return this.aMx;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> Gr() {
        return this.aMy;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.e Gs() {
        return this.aMz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Gt() {
        return com.baidu.swan.pms.a.g.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.apps.v.c.a fF = com.baidu.swan.apps.v.c.a.fF(Gt());
        fF.KX().dD(1);
        boolean By = com.baidu.swan.apps.u.a.Jm().By();
        long currentTimeMillis = System.currentTimeMillis();
        if (!By) {
            com.baidu.swan.apps.ak.a a = com.baidu.swan.apps.core.pms.c.a.a(fVar, this);
            fF.fG("CostCheckSign: " + (System.currentTimeMillis() - currentTimeMillis));
            if (a != null) {
                return a;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        com.baidu.swan.apps.ak.a b = com.baidu.swan.apps.core.pms.c.a.b(fVar);
        fF.fG("CostRenameZip: " + (System.currentTimeMillis() - currentTimeMillis2));
        if (b == null) {
            if (!By) {
                long currentTimeMillis3 = System.currentTimeMillis();
                com.baidu.swan.apps.ak.a b2 = com.baidu.swan.apps.core.pms.c.a.b(fVar, this);
                fF.fG("CostUnzip: " + (System.currentTimeMillis() - currentTimeMillis3));
                if (b2 != null) {
                    return b2;
                }
            }
            return null;
        }
        return b;
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0227a d = com.baidu.swan.apps.swancore.e.a.d(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.a.deleteFile(dVar.filePath);
        }
        if (d.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.ak.a().ar(13L).at(2907L).iK("Core包更新失败");
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.aQp = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.a.HS().a((com.baidu.swan.apps.extcore.a) aVar)) {
            return null;
        }
        return new com.baidu.swan.apps.ak.a().ar(14L).at(2908L).iK("Extension包更新失败");
    }

    protected void a(PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.f fVar) {
        if (pMSAppInfo != null && fVar != null) {
            this.aMu.g(fVar);
            if (fVar.category == 1) {
                com.baidu.swan.games.p.a.a u = com.baidu.swan.apps.core.pms.c.a.u(fVar.bLj, fVar.versionCode);
                if (u != null) {
                    pMSAppInfo.orientation = u.bCs;
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
    public void dn(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.aaV().I(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.aaV().I(this.mAppId, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.ak.a Gu() {
        if (this.aMu == null) {
            if (this.aMq == null) {
                return new com.baidu.swan.apps.ak.a().ar(10L).as(2903L).iK("Server未返回主包&AppInfo");
            }
            PMSAppInfo kT = com.baidu.swan.pms.database.a.aaV().kT(this.mAppId);
            if (kT == null) {
                return new com.baidu.swan.apps.ak.a().ar(10L).as(2904L).iK("Server未返回AppInfo数据，本地也没有数据");
            }
            this.aMu = kT;
            a(this.aMu, this.aMq);
            this.aMu.abe();
            if (com.baidu.swan.pms.database.a.aaV().a(this.aMq, this.aMr, this.aMs, this.aMt, this.aMu)) {
                return null;
            }
            return new com.baidu.swan.apps.ak.a().ar(10L).as(2906L).iK("更新DB失败");
        }
        if (this.aMq != null) {
            a(this.aMu, this.aMq);
        } else {
            PMSAppInfo kT2 = com.baidu.swan.pms.database.a.aaV().kT(this.mAppId);
            if (kT2 == null) {
                return new com.baidu.swan.apps.ak.a().ar(10L).as(2905L).iK("Server未返回包数据，本地也没有数据");
            }
            this.aMu.appId = this.mAppId;
            this.aMu.h(kT2);
        }
        this.aMu.abe();
        if (com.baidu.swan.pms.database.a.aaV().a(this.aMq, this.aMr, this.aMs, this.aMt, this.aMu)) {
            a(this.aMu);
            return null;
        }
        return new com.baidu.swan.apps.ak.a().ar(10L).as(2906L).iK("更新DB失败");
    }

    protected void a(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(this.aMu.bLe)) {
                com.baidu.swan.apps.af.a.c.a(this.aMu.appId, "", o.iQ(this.aMu.bLe));
            }
            if (!TextUtils.isEmpty(this.aMu.bLf)) {
                com.baidu.swan.apps.af.a.c.a("", o.iQ(this.aMu.bLf));
            }
            if (!TextUtils.isEmpty(this.aMu.bLg)) {
                com.baidu.swan.apps.af.a.c.h(this.aMu.appId, o.dP(this.aMu.bLg));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Gv() {
        if (this.aMu != null) {
            PMSAppInfo kT = com.baidu.swan.pms.database.a.aaV().kT(this.mAppId);
            if (kT == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.aMu.appId = this.mAppId;
            this.aMu.h(kT);
            if (this.aMu.Hs()) {
                this.aMu.abe();
            }
            com.baidu.swan.pms.database.a.aaV().f(this.aMu);
            a(this.aMu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        b.Gh().a(fVar, new b.InterfaceC0182b() { // from class: com.baidu.swan.apps.core.pms.d.11
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.aMq = fVar;
                d.this.aMp.i(fVar);
                if (d.this.aMl != null) {
                    d.this.aMl.onNext(fVar);
                    d.this.aMl.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.aMp.h(fVar);
                if (d.this.aMl != null) {
                    d.this.aMl.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.swan.pms.model.h hVar) {
        b.Gh().a(hVar, new b.InterfaceC0182b() { // from class: com.baidu.swan.apps.core.pms.d.12
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType) {
                if (d.this.aMr == null) {
                    d.this.aMr = new ArrayList();
                }
                hVar.appId = d.this.mAppId;
                d.this.aMr.add(hVar);
                d.this.aMp.i(hVar);
                if (d.this.aMm != null) {
                    d.this.aMm.onNext(hVar);
                    if (!d.this.aMp.abQ()) {
                        d.this.aMm.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.aMp.h(hVar);
                if (d.this.aMm != null) {
                    d.this.aMm.onError(new PkgDownloadError(hVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        b.Gh().a(dVar, new b.InterfaceC0182b() { // from class: com.baidu.swan.apps.core.pms.d.13
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.aMs = dVar;
                d.this.aMp.i(dVar);
                if (d.this.aMn != null) {
                    d.this.aMn.onNext(dVar);
                    d.this.aMn.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.aMp.h(dVar);
                if (d.this.aMn != null) {
                    d.this.aMn.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        b.Gh().a(bVar, new b.InterfaceC0182b() { // from class: com.baidu.swan.apps.core.pms.d.14
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.aMt = bVar;
                d.this.aMp.i(bVar);
                if (d.this.aMo != null) {
                    d.this.aMo.onNext(bVar);
                    d.this.aMo.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.aMp.h(bVar);
                if (d.this.aMo != null) {
                    d.this.aMo.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void Gw() {
        ArrayList arrayList = new ArrayList();
        if (this.aMp.abM()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.d.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.f> jVar) {
                    d.this.aMl = jVar;
                }
            }));
        }
        if (this.aMp.abN()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.h>() { // from class: com.baidu.swan.apps.core.pms.d.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.h> jVar) {
                    d.this.aMm = jVar;
                }
            }));
        }
        if (this.aMp.abO()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.d.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.d> jVar) {
                    d.this.aMn = jVar;
                }
            }));
        }
        if (this.aMp.abP()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.d.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.b> jVar) {
                    d.this.aMo = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.h(arrayList).b(this.aMA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(String str, String str2) {
        com.baidu.swan.apps.performance.d.a.a(this.mAppId, str, this.aJg, str2);
        this.aJg.clear();
    }
}
