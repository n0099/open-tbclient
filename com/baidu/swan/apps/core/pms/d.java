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
    private j<? super com.baidu.swan.pms.model.f> asl;
    private j<? super com.baidu.swan.pms.model.h> asm;
    private j<? super com.baidu.swan.pms.model.d> asn;
    private j<? super com.baidu.swan.pms.model.b> aso;
    protected com.baidu.swan.pms.e.e asp;
    protected com.baidu.swan.pms.model.f asq;
    protected List<com.baidu.swan.pms.model.h> asr;
    protected com.baidu.swan.pms.model.d ass;
    protected com.baidu.swan.pms.model.b ast;
    protected PMSAppInfo asu;
    protected String mAppId;
    protected String apw = "0";
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.f> asv = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.d.1
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gj() {
            return com.baidu.swan.apps.core.pms.c.a.yu().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void F(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.eR(d.this.AL()).Fo().cG(1);
            super.F(fVar);
            if (d.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.eR(d.this.AL()).Fo().cG(1);
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
            d.this.asp.h(fVar);
            com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(11L).Z(aVar.errorNo).hX("主包下载失败").hY(aVar.toString());
            if (d.this.asl != null) {
                d.this.asl.onError(new PkgDownloadError(fVar, hY));
            }
            b.Az().a(fVar, d.this.AD(), hY);
            com.baidu.swan.c.a.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: e */
        public void E(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.eR(d.this.AL()).Fo().cG(1);
            super.E(fVar);
            if (d.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "onFileDownloaded: " + fVar.toString());
            }
            d.this.apg.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ak.a a = d.this.a(fVar);
            if (a == null) {
                d.this.asq = fVar;
                d.this.asp.i(fVar);
                if (d.this.asl != null) {
                    d.this.asl.onNext(fVar);
                    d.this.asl.onCompleted();
                }
                b.Az().a(fVar, d.this.AD());
                return;
            }
            d.this.asp.h(fVar);
            if (d.this.asl != null) {
                d.this.asl.onError(new PkgDownloadError(fVar, a));
            }
            b.Az().a(fVar, d.this.AD(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public boolean a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            boolean vY = com.baidu.swan.apps.u.a.DE().vY();
            com.baidu.swan.apps.v.c.a.eR(d.this.AL()).al("stream", String.valueOf(vY)).eS(fVar.toString()).cG(1);
            com.baidu.swan.apps.install.g gVar = new com.baidu.swan.apps.install.g();
            if (vY) {
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
                    com.baidu.swan.apps.v.c.a.eR(d.this.AL()).ak("SwanAppPkgDownloadCallback", "install Event: " + str).Fw();
                }
            });
            return gVar.b(bufferedSource).isOk();
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.h> asw = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.h>() { // from class: com.baidu.swan.apps.core.pms.d.7
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gj() {
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
            d.this.asp.h(hVar);
            com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(12L).Z(aVar.errorNo).hX("分包下载失败").hY(aVar.toString());
            if (d.this.asm != null) {
                d.this.asm.onError(new PkgDownloadError(hVar, hY));
            }
            b.Az().a(hVar, d.this.AD(), hY);
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
            if (d.this.asr == null) {
                d.this.asr = new ArrayList();
            }
            hVar.appId = d.this.mAppId;
            d.this.asr.add(hVar);
            d.this.asp.i(hVar);
            if (d.this.asm != null) {
                d.this.asm.onNext(hVar);
                if (!d.this.asp.Wf()) {
                    d.this.asm.onCompleted();
                }
            }
            b.Az().a(hVar, d.this.AD());
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> asx = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.d.8
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gj() {
            return com.baidu.swan.apps.core.pms.c.a.AT();
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
            d.this.asp.h(dVar);
            com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(13L).Z(aVar.errorNo).hX("Framework包下载失败").hY(aVar.toString());
            if (d.this.asn != null) {
                d.this.asn.onError(new PkgDownloadError(dVar, hY));
            }
            b.Az().a(dVar, d.this.AD(), hY);
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
                d.this.ass = dVar;
                d.this.asp.i(dVar);
                if (d.this.asn != null) {
                    d.this.asn.onNext(dVar);
                    d.this.asn.onCompleted();
                }
                b.Az().a(dVar, d.this.AD());
                return;
            }
            d.this.asp.h(dVar);
            if (d.this.asn != null) {
                d.this.asn.onError(new PkgDownloadError(dVar, a));
            }
            b.Az().a(dVar, d.this.AD(), a);
        }
    };
    private com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> asy = new com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.d.9
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return d.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gj() {
            return com.baidu.swan.apps.core.pms.c.a.AR();
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
            d.this.asp.h(bVar);
            com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(14L).Z(aVar.errorNo).hX("Extension下载失败").hY(aVar.toString());
            if (d.this.aso != null) {
                d.this.aso.onError(new PkgDownloadError(bVar, hY));
            }
            b.Az().a(bVar, d.this.AD(), hY);
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
                d.this.ast = bVar;
                d.this.asp.i(bVar);
                if (d.this.aso != null) {
                    d.this.aso.onNext(bVar);
                    d.this.aso.onCompleted();
                }
                b.Az().a(bVar, d.this.AD());
                return;
            }
            d.this.asp.h(bVar);
            if (d.this.aso != null) {
                d.this.aso.onError(new PkgDownloadError(bVar, a));
            }
            b.Az().a(bVar, d.this.AD(), a);
        }
    };
    private com.baidu.swan.pms.a.e asz = new com.baidu.swan.pms.a.e() { // from class: com.baidu.swan.apps.core.pms.d.10
        @Override // com.baidu.swan.pms.a.e
        public void b(PMSAppInfo pMSAppInfo) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", "onSwanAppReceive: " + pMSAppInfo.toString());
            }
            d.this.asu = pMSAppInfo;
            if (d.this.asu != null) {
                if (d.this.apg != null) {
                    d.this.apg.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.c.c.a(d.this.asu.iconUrl, new c.a() { // from class: com.baidu.swan.apps.core.pms.d.10.1
                    @Override // com.baidu.swan.apps.core.pms.c.c.a
                    public void g(Bitmap bitmap) {
                        if (d.this.apg != null) {
                            d.this.apg.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private j<com.baidu.swan.pms.model.e> asA = new j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.d.2
        @Override // rx.e
        public void onCompleted() {
            if (d.this.asq != null && d.this.asr != null) {
                com.baidu.swan.apps.core.pms.c.b.a(d.this.asq.bsc, d.this.asq.versionCode, d.this.asr);
            }
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.AD() + " : 包下载onCompleted");
            }
            d.this.AC();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.AD() + " : 包下载OnError：" + th.toString());
            }
            d.this.k(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (d.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", d.this.AD() + " : 单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> apg = new ArrayList();

    protected abstract void AC();

    protected abstract PMSDownloadType AD();

    protected abstract void k(Throwable th);

    public d(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.f
    public void yD() {
        this.apg.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void AF() {
        this.apg.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        this.apg.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.e.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            this.apg.add(new UbcFlowEvent("na_pms_start_download"));
            this.asp = eVar;
            if (!this.asp.isEmpty()) {
                AO();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.f> AG() {
        return this.asv;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.h> AH() {
        return this.asw;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.d> AI() {
        return this.asx;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<com.baidu.swan.pms.model.b> AJ() {
        return this.asy;
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.e AK() {
        return this.asz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String AL() {
        return com.baidu.swan.pms.a.g.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.apps.v.c.a eR = com.baidu.swan.apps.v.c.a.eR(AL());
        eR.Fo().cG(1);
        boolean vY = com.baidu.swan.apps.u.a.DE().vY();
        long currentTimeMillis = System.currentTimeMillis();
        if (!vY) {
            com.baidu.swan.apps.ak.a a = com.baidu.swan.apps.core.pms.c.a.a(fVar, this);
            eR.eS("CostCheckSign: " + (System.currentTimeMillis() - currentTimeMillis));
            if (a != null) {
                return a;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        com.baidu.swan.apps.ak.a b = com.baidu.swan.apps.core.pms.c.a.b(fVar);
        eR.eS("CostRenameZip: " + (System.currentTimeMillis() - currentTimeMillis2));
        if (b == null) {
            if (!vY) {
                long currentTimeMillis3 = System.currentTimeMillis();
                com.baidu.swan.apps.ak.a b2 = com.baidu.swan.apps.core.pms.c.a.b(fVar, this);
                eR.eS("CostUnzip: " + (System.currentTimeMillis() - currentTimeMillis3));
                if (b2 != null) {
                    return b2;
                }
            }
            return null;
        }
        return b;
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0184a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.a.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.ak.a().Y(13L).aa(2907L).hX("Core包更新失败");
    }

    protected com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.awp = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.a.Ck().a((com.baidu.swan.apps.extcore.a) aVar)) {
            return null;
        }
        return new com.baidu.swan.apps.ak.a().Y(14L).aa(2908L).hX("Extension包更新失败");
    }

    protected void a(PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.f fVar) {
        if (pMSAppInfo != null && fVar != null) {
            this.asu.g(fVar);
            if (fVar.category == 1) {
                com.baidu.swan.games.p.a.a u = com.baidu.swan.apps.core.pms.c.a.u(fVar.bsc, fVar.versionCode);
                if (u != null) {
                    pMSAppInfo.orientation = u.bjk;
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
            com.baidu.swan.pms.database.a.Vl().I(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.Vl().I(this.mAppId, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.ak.a AM() {
        if (this.asu == null) {
            if (this.asq == null) {
                return new com.baidu.swan.apps.ak.a().Y(10L).Z(2903L).hX("Server未返回主包&AppInfo");
            }
            PMSAppInfo kh = com.baidu.swan.pms.database.a.Vl().kh(this.mAppId);
            if (kh == null) {
                return new com.baidu.swan.apps.ak.a().Y(10L).Z(2904L).hX("Server未返回AppInfo数据，本地也没有数据");
            }
            this.asu = kh;
            a(this.asu, this.asq);
            this.asu.Vu();
            if (com.baidu.swan.pms.database.a.Vl().a(this.asq, this.asr, this.ass, this.ast, this.asu)) {
                return null;
            }
            return new com.baidu.swan.apps.ak.a().Y(10L).Z(2906L).hX("更新DB失败");
        }
        if (this.asq != null) {
            a(this.asu, this.asq);
        } else {
            PMSAppInfo kh2 = com.baidu.swan.pms.database.a.Vl().kh(this.mAppId);
            if (kh2 == null) {
                return new com.baidu.swan.apps.ak.a().Y(10L).Z(2905L).hX("Server未返回包数据，本地也没有数据");
            }
            this.asu.appId = this.mAppId;
            this.asu.h(kh2);
        }
        this.asu.Vu();
        if (com.baidu.swan.pms.database.a.Vl().a(this.asq, this.asr, this.ass, this.ast, this.asu)) {
            a(this.asu);
            return null;
        }
        return new com.baidu.swan.apps.ak.a().Y(10L).Z(2906L).hX("更新DB失败");
    }

    protected void a(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(this.asu.brX)) {
                com.baidu.swan.apps.af.a.c.a(this.asu.appId, "", o.ie(this.asu.brX));
            }
            if (!TextUtils.isEmpty(this.asu.brY)) {
                com.baidu.swan.apps.af.a.c.a("", o.ie(this.asu.brY));
            }
            if (!TextUtils.isEmpty(this.asu.brZ)) {
                com.baidu.swan.apps.af.a.c.h(this.asu.appId, o.cY(this.asu.brZ));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AN() {
        if (this.asu != null) {
            PMSAppInfo kh = com.baidu.swan.pms.database.a.Vl().kh(this.mAppId);
            if (kh == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.asu.appId = this.mAppId;
            this.asu.h(kh);
            if (this.asu.BL()) {
                this.asu.Vu();
            }
            com.baidu.swan.pms.database.a.Vl().f(this.asu);
            a(this.asu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        b.Az().a(fVar, new b.InterfaceC0139b() { // from class: com.baidu.swan.apps.core.pms.d.11
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.asq = fVar;
                d.this.asp.i(fVar);
                if (d.this.asl != null) {
                    d.this.asl.onNext(fVar);
                    d.this.asl.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asp.h(fVar);
                if (d.this.asl != null) {
                    d.this.asl.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.swan.pms.model.h hVar) {
        b.Az().a(hVar, new b.InterfaceC0139b() { // from class: com.baidu.swan.apps.core.pms.d.12
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType) {
                if (d.this.asr == null) {
                    d.this.asr = new ArrayList();
                }
                hVar.appId = d.this.mAppId;
                d.this.asr.add(hVar);
                d.this.asp.i(hVar);
                if (d.this.asm != null) {
                    d.this.asm.onNext(hVar);
                    if (!d.this.asp.Wf()) {
                        d.this.asm.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asp.h(hVar);
                if (d.this.asm != null) {
                    d.this.asm.onError(new PkgDownloadError(hVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        b.Az().a(dVar, new b.InterfaceC0139b() { // from class: com.baidu.swan.apps.core.pms.d.13
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.ass = dVar;
                d.this.asp.i(dVar);
                if (d.this.asn != null) {
                    d.this.asn.onNext(dVar);
                    d.this.asn.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asp.h(dVar);
                if (d.this.asn != null) {
                    d.this.asn.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        b.Az().a(bVar, new b.InterfaceC0139b() { // from class: com.baidu.swan.apps.core.pms.d.14
            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType) {
                d.this.ast = bVar;
                d.this.asp.i(bVar);
                if (d.this.aso != null) {
                    d.this.aso.onNext(bVar);
                    d.this.aso.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.b.InterfaceC0139b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ak.a aVar) {
                d.this.asp.h(bVar);
                if (d.this.aso != null) {
                    d.this.aso.onError(new PkgDownloadError(bVar, aVar));
                }
            }
        });
    }

    private void AO() {
        ArrayList arrayList = new ArrayList();
        if (this.asp.Wb()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.d.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.f> jVar) {
                    d.this.asl = jVar;
                }
            }));
        }
        if (this.asp.Wc()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.h>() { // from class: com.baidu.swan.apps.core.pms.d.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.h> jVar) {
                    d.this.asm = jVar;
                }
            }));
        }
        if (this.asp.Wd()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.d.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.d> jVar) {
                    d.this.asn = jVar;
                }
            }));
        }
        if (this.asp.We()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.d.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super com.baidu.swan.pms.model.b> jVar) {
                    d.this.aso = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.h(arrayList).b(this.asA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa(String str, String str2) {
        com.baidu.swan.apps.performance.d.a.a(this.mAppId, str, this.apg, str2);
        this.apg.clear();
    }
}
