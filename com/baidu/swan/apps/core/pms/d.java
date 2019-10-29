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
    private j<? super com.baidu.swan.pms.model.f> aMD;
    private j<? super com.baidu.swan.pms.model.h> aME;
    private j<? super com.baidu.swan.pms.model.d> aMF;
    private j<? super com.baidu.swan.pms.model.b> aMG;
    protected com.baidu.swan.pms.e.e aMH;
    protected com.baidu.swan.pms.model.f aMI;
    protected List<com.baidu.swan.pms.model.h> aMJ;
    protected com.baidu.swan.pms.model.d aMK;
    protected com.baidu.swan.pms.model.b aML;
    protected PMSAppInfo aMM;
    protected String mAppId;
    protected String aJN = "0";
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.f> aMN = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.d.1
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String getDownloadPath() {
            return com.baidu.swan.apps.core.pms.c.a.DZ().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void D(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.fF(d.this.Gs()).KW().dD(1);
            super.D(fVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void E(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.fF(d.this.Gs()).KW().dD(1);
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
            d.this.aMH.h(fVar);
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(11L).at(aVar.errorNo).iK("主包下载失败").iL(aVar.toString());
            if (d.this.aMD != null) {
                d.this.aMD.onError(new PkgDownloadError(fVar, iL));
            }
            b.Gg().a(fVar, d.this.Gk(), iL);
            com.baidu.swan.c.a.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void C(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.fF(d.this.Gs()).KW().dD(1);
            super.C(fVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + fVar.toString());
            }
            d.this.aJy.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ak.a a = d.this.a(fVar);
            if (a == null) {
                d.this.aMI = fVar;
                d.this.aMH.i(fVar);
                if (d.this.aMD != null) {
                    d.this.aMD.onNext(fVar);
                    d.this.aMD.onCompleted();
                }
                b.Gg().a(fVar, d.this.Gk());
                return;
            }
            d.this.aMH.h(fVar);
            if (d.this.aMD != null) {
                d.this.aMD.onError(new PkgDownloadError(fVar, a));
            }
            b.Gg().a(fVar, d.this.Gk(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public boolean a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            boolean Bx = com.baidu.swan.apps.u.a.Jl().Bx();
            com.baidu.swan.apps.v.c.a.fF(d.this.Gs()).at("stream", String.valueOf(Bx)).fG(fVar.toString()).dD(1);
            com.baidu.swan.apps.install.g gVar = new com.baidu.swan.apps.install.g();
            if (Bx) {
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
                    com.baidu.swan.apps.v.c.a.fF(d.this.Gs()).as("SwanAppPkgDownloadCallback", "install Event: " + str).Le();
                }
            });
            return gVar.b(bufferedSource).isOk();
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.h> aMO = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.h>() { // from class: com.baidu.swan.apps.core.pms.d.7
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
            d.this.aMH.h(hVar);
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(12L).at(aVar.errorNo).iK("分包下载失败").iL(aVar.toString());
            if (d.this.aME != null) {
                d.this.aME.onError(new PkgDownloadError(hVar, iL));
            }
            b.Gg().a(hVar, d.this.Gk(), iL);
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
            if (d.this.aMJ == null) {
                d.this.aMJ = new ArrayList();
            }
            hVar.appId = d.this.mAppId;
            d.this.aMJ.add(hVar);
            d.this.aMH.i(hVar);
            if (d.this.aME != null) {
                d.this.aME.onNext(hVar);
                if (!d.this.aMH.abS()) {
                    d.this.aME.onCompleted();
                }
            }
            b.Gg().a(hVar, d.this.Gk());
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> aMP = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.d.8
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String getDownloadPath() {
            return com.baidu.swan.apps.core.pms.c.a.Gz();
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
            d.this.aMH.h(dVar);
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(13L).at(aVar.errorNo).iK("Framework包下载失败").iL(aVar.toString());
            if (d.this.aMF != null) {
                d.this.aMF.onError(new PkgDownloadError(dVar, iL));
            }
            b.Gg().a(dVar, d.this.Gk(), iL);
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
                d.this.aMK = dVar;
                d.this.aMH.i(dVar);
                if (d.this.aMF != null) {
                    d.this.aMF.onNext(dVar);
                    d.this.aMF.onCompleted();
                }
                b.Gg().a(dVar, d.this.Gk());
                return;
            }
            d.this.aMH.h(dVar);
            if (d.this.aMF != null) {
                d.this.aMF.onError(new PkgDownloadError(dVar, a));
            }
            b.Gg().a(dVar, d.this.Gk(), a);
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> aMQ = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.d.9
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String getDownloadPath() {
            return com.baidu.swan.apps.core.pms.c.a.Gx();
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
            d.this.aMH.h(bVar);
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(14L).at(aVar.errorNo).iK("Extension下载失败").iL(aVar.toString());
            if (d.this.aMG != null) {
                d.this.aMG.onError(new PkgDownloadError(bVar, iL));
            }
            b.Gg().a(bVar, d.this.Gk(), iL);
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
                d.this.aML = bVar;
                d.this.aMH.i(bVar);
                if (d.this.aMG != null) {
                    d.this.aMG.onNext(bVar);
                    d.this.aMG.onCompleted();
                }
                b.Gg().a(bVar, d.this.Gk());
                return;
            }
            d.this.aMH.h(bVar);
            if (d.this.aMG != null) {
                d.this.aMG.onError(new PkgDownloadError(bVar, a));
            }
            b.Gg().a(bVar, d.this.Gk(), a);
        }
    };
    private com.baidu.swan.pms.a.e aMR = new com.baidu.swan.pms.a.e() { // from class: com.baidu.swan.apps.core.pms.d.10
        @Override // com.baidu.swan.pms.a.e
        public void b(PMSAppInfo pMSAppInfo) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", "onSwanAppReceive: " + pMSAppInfo.toString());
            }
            d.this.aMM = pMSAppInfo;
            if (d.this.aMM != null) {
                if (d.this.aJy != null) {
                    d.this.aJy.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.c.c.a(d.this.aMM.iconUrl, new c.a() { // from class: com.baidu.swan.apps.core.pms.d.10.1
                    @Override // com.baidu.swan.apps.core.pms.c.c.a
                    public void i(Bitmap bitmap) {
                        if (d.this.aJy != null) {
                            d.this.aJy.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private j<com.baidu.swan.pms.model.e> aMS = new j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.d.2
        @Override // rx.e
        public void onCompleted() {
            if (d.this.aMI != null && d.this.aMJ != null) {
                com.baidu.swan.apps.core.pms.c.b.b(d.this.aMI.bMa, d.this.aMI.versionCode, d.this.aMJ);
            }
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.Gk() + " : 包下载onCompleted");
            }
            d.this.Gj();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.Gk() + " : 包下载OnError：" + th.toString());
            }
            d.this.k(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.Gk() + " : 单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> aJy = new ArrayList();

    protected abstract void Gj();

    protected abstract PMSDownloadType Gk();

    protected abstract void k(Throwable th);

    public d(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.f
    public void Ei() {
        this.aJy.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void Gm() {
        this.aJy.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        this.aJy.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.e.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.aJy.add(new UbcFlowEvent("na_pms_start_download"));
            this.aMH = eVar;
            if (!this.aMH.isEmpty()) {
                Gv();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.f> Gn() {
        return this.aMN;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.h> Go() {
        return this.aMO;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> Gp() {
        return this.aMP;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> Gq() {
        return this.aMQ;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.e Gr() {
        return this.aMR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Gs() {
        return com.baidu.swan.pms.a.g.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.apps.v.c.a fF = com.baidu.swan.apps.v.c.a.fF(Gs());
        fF.KW().dD(1);
        boolean Bx = com.baidu.swan.apps.u.a.Jl().Bx();
        long currentTimeMillis = System.currentTimeMillis();
        if (!Bx) {
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
            if (!Bx) {
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
        return new com.baidu.swan.apps.ak.a().as(13L).au(2907L).iK("Core包更新失败");
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.aQH = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.a.HR().a((com.baidu.swan.apps.extcore.a) aVar)) {
            return null;
        }
        return new com.baidu.swan.apps.ak.a().as(14L).au(2908L).iK("Extension包更新失败");
    }

    protected void a(PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.f fVar) {
        if (pMSAppInfo != null && fVar != null) {
            this.aMM.g(fVar);
            if (fVar.category == 1) {
                com.baidu.swan.games.p.a.a u = com.baidu.swan.apps.core.pms.c.a.u(fVar.bMa, fVar.versionCode);
                if (u != null) {
                    pMSAppInfo.orientation = u.bDj;
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
            com.baidu.swan.pms.database.a.aaX().I(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.aaX().I(this.mAppId, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.ak.a Gt() {
        if (this.aMM == null) {
            if (this.aMI == null) {
                return new com.baidu.swan.apps.ak.a().as(10L).at(2903L).iK("Server未返回主包&AppInfo");
            }
            PMSAppInfo kT = com.baidu.swan.pms.database.a.aaX().kT(this.mAppId);
            if (kT == null) {
                return new com.baidu.swan.apps.ak.a().as(10L).at(2904L).iK("Server未返回AppInfo数据，本地也没有数据");
            }
            this.aMM = kT;
            a(this.aMM, this.aMI);
            this.aMM.abg();
            if (com.baidu.swan.pms.database.a.aaX().a(this.aMI, this.aMJ, this.aMK, this.aML, this.aMM)) {
                return null;
            }
            return new com.baidu.swan.apps.ak.a().as(10L).at(2906L).iK("更新DB失败");
        }
        if (this.aMI != null) {
            a(this.aMM, this.aMI);
        } else {
            PMSAppInfo kT2 = com.baidu.swan.pms.database.a.aaX().kT(this.mAppId);
            if (kT2 == null) {
                return new com.baidu.swan.apps.ak.a().as(10L).at(2905L).iK("Server未返回包数据，本地也没有数据");
            }
            this.aMM.appId = this.mAppId;
            this.aMM.h(kT2);
        }
        this.aMM.abg();
        if (com.baidu.swan.pms.database.a.aaX().a(this.aMI, this.aMJ, this.aMK, this.aML, this.aMM)) {
            a(this.aMM);
            return null;
        }
        return new com.baidu.swan.apps.ak.a().as(10L).at(2906L).iK("更新DB失败");
    }

    protected void a(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(this.aMM.bLV)) {
                com.baidu.swan.apps.af.a.c.a(this.aMM.appId, "", o.iQ(this.aMM.bLV));
            }
            if (!TextUtils.isEmpty(this.aMM.bLW)) {
                com.baidu.swan.apps.af.a.c.a("", o.iQ(this.aMM.bLW));
            }
            if (!TextUtils.isEmpty(this.aMM.bLX)) {
                com.baidu.swan.apps.af.a.c.h(this.aMM.appId, o.dP(this.aMM.bLX));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Gu() {
        if (this.aMM != null) {
            PMSAppInfo kT = com.baidu.swan.pms.database.a.aaX().kT(this.mAppId);
            if (kT == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.aMM.appId = this.mAppId;
            this.aMM.h(kT);
            if (this.aMM.Hr()) {
                this.aMM.abg();
            }
            com.baidu.swan.pms.database.a.aaX().f(this.aMM);
            a(this.aMM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        b.Gg().a(fVar, new b.InterfaceC0182b() { // from class: com.baidu.swan.apps.core.pms.d.11
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.aMI = fVar;
                d.this.aMH.i(fVar);
                if (d.this.aMD != null) {
                    d.this.aMD.onNext(fVar);
                    d.this.aMD.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.aMH.h(fVar);
                if (d.this.aMD != null) {
                    d.this.aMD.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.swan.pms.model.h hVar) {
        b.Gg().a(hVar, new b.InterfaceC0182b() { // from class: com.baidu.swan.apps.core.pms.d.12
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType) {
                if (d.this.aMJ == null) {
                    d.this.aMJ = new ArrayList();
                }
                hVar.appId = d.this.mAppId;
                d.this.aMJ.add(hVar);
                d.this.aMH.i(hVar);
                if (d.this.aME != null) {
                    d.this.aME.onNext(hVar);
                    if (!d.this.aMH.abS()) {
                        d.this.aME.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.aMH.h(hVar);
                if (d.this.aME != null) {
                    d.this.aME.onError(new PkgDownloadError(hVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        b.Gg().a(dVar, new b.InterfaceC0182b() { // from class: com.baidu.swan.apps.core.pms.d.13
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.aMK = dVar;
                d.this.aMH.i(dVar);
                if (d.this.aMF != null) {
                    d.this.aMF.onNext(dVar);
                    d.this.aMF.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.aMH.h(dVar);
                if (d.this.aMF != null) {
                    d.this.aMF.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        b.Gg().a(bVar, new b.InterfaceC0182b() { // from class: com.baidu.swan.apps.core.pms.d.14
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.aML = bVar;
                d.this.aMH.i(bVar);
                if (d.this.aMG != null) {
                    d.this.aMG.onNext(bVar);
                    d.this.aMG.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0182b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.aMH.h(bVar);
                if (d.this.aMG != null) {
                    d.this.aMG.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void Gv() {
        ArrayList arrayList = new ArrayList();
        if (this.aMH.abO()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.d.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.f> jVar) {
                    d.this.aMD = jVar;
                }
            }));
        }
        if (this.aMH.abP()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.h>() { // from class: com.baidu.swan.apps.core.pms.d.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.h> jVar) {
                    d.this.aME = jVar;
                }
            }));
        }
        if (this.aMH.abQ()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.d.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.d> jVar) {
                    d.this.aMF = jVar;
                }
            }));
        }
        if (this.aMH.abR()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.d.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.b> jVar) {
                    d.this.aMG = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.h(arrayList).b(this.aMS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(String str, String str2) {
        com.baidu.swan.apps.performance.d.a.a(this.mAppId, str, this.aJy, str2);
        this.aJy.clear();
    }
}
