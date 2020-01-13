package com.baidu.swan.apps.core.pms;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ab;
import com.baidu.swan.apps.core.pms.c;
import com.baidu.swan.apps.core.pms.d.c;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.swancore.e.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import okio.BufferedSource;
import rx.d;
/* loaded from: classes10.dex */
public abstract class f extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.pms.f.e blB;
    private rx.j<? super com.baidu.swan.pms.model.f> blJ;
    private rx.j<? super com.baidu.swan.pms.model.g> blK;
    private rx.j<? super com.baidu.swan.pms.model.d> blL;
    private rx.j<? super com.baidu.swan.pms.model.b> blM;
    protected com.baidu.swan.pms.model.f blN;
    protected List<com.baidu.swan.pms.model.g> blO;
    protected com.baidu.swan.pms.model.d blP;
    protected com.baidu.swan.pms.model.b blQ;
    protected PMSAppInfo blR;
    protected com.baidu.swan.pms.model.g blU;
    protected String mAppId;
    private String mClassName = "";
    protected String blT = "0";
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> blV = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String I(com.baidu.swan.pms.model.f fVar) {
            if (fVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.Nr();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.Ns();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.KL();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.ix(f.this.Nf()).TT().eW(1);
            super.G(fVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void H(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.ix(f.this.Nf()).TT().eW(1);
            super.H(fVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onDownloading");
            }
            f.this.b(fVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.f fVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) fVar, aVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onDownloadError：" + aVar.toString());
            }
            f.this.blB.f(fVar);
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(11L).aF(aVar.errorNo).mj("主包下载失败").mk(aVar.toString());
            if (f.this.blJ != null) {
                f.this.blJ.onError(new PkgDownloadError(fVar, mk));
            }
            c.MU().a(fVar, f.this.MZ(), mk);
            com.baidu.swan.d.c.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void E(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.ix(f.this.Nf()).TT().eW(1);
            super.E(fVar);
            f.this.blS.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ap.a a = f.this.a(fVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: pmsPkgMain=" + fVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: errCode=" + a);
            }
            if (a == null) {
                f.this.blN = fVar;
                f.this.blB.g(fVar);
                if (f.this.blJ != null) {
                    f.this.blJ.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.blJ.onCompleted();
                }
                c.MU().a(fVar, f.this.MZ());
                return;
            }
            f.this.blB.f(fVar);
            if (f.this.blJ != null) {
                f.this.blJ.onError(new PkgDownloadError(fVar, a));
            }
            c.MU().a(fVar, f.this.MZ(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            com.baidu.swan.apps.x.c.a.ix(f.this.Nf()).iy(fVar.toString()).eW(1);
            com.baidu.swan.apps.as.d.b<i.a> bVar = new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.core.pms.f.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(i.a aVar) {
                    if ("installer_on_pump_finish".equals(aVar.id)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("performance_ubc_event_id", "670");
                        bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                        com.baidu.swan.pms.a.h.a(f.this, bundle, "event_performance_ubc");
                    }
                }
            };
            Bundle bundle = new Bundle();
            bundle.putLong("length", j);
            bundle.putFloat("progress_granularity", 0.1f);
            com.baidu.swan.apps.t.g gVar = new com.baidu.swan.apps.t.g();
            gVar.e(bVar);
            boolean isOk = gVar.x(bundle).a(new com.baidu.swan.apps.t.f(fVar, f.this)).a(new com.baidu.swan.apps.t.d(fVar.sign, f.this)).a(new com.baidu.swan.apps.t.c(file)).a(bufferedSource).isOk();
            gVar.f(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onProcessStream: installOk=" + isOk);
            }
            return isOk ? new com.baidu.swan.pms.model.a(PushConstants.DOWN_LOAD_LARGE_ICON_ERROR, "业务层处理下载流成功") : new com.baidu.swan.pms.model.a(PushConstants.DOWN_LOAD_LARGE_ICON_SUCCESS, "业务层处理下载流失败");
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> blW = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.7
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String I(com.baidu.swan.pms.model.g gVar) {
            if (gVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.b.as(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            if (gVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.b.at(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.KL();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.g gVar) {
            super.G(gVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void H(com.baidu.swan.pms.model.g gVar) {
            super.H(gVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onDownloading");
            }
            f.this.b(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.g gVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass7) gVar, aVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onDownloadError：" + aVar.toString());
            }
            f.this.blB.f(gVar);
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(12L).aF(aVar.errorNo).mj("分包下载失败").mk(aVar.toString());
            if (f.this.blK != null) {
                f.this.blK.onError(new PkgDownloadError(gVar, mk));
            }
            c.MU().a(gVar, f.this.MZ(), mk);
            com.baidu.swan.d.c.deleteFile(gVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void E(com.baidu.swan.pms.model.g gVar) {
            super.E(gVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onFileDownloaded: " + gVar.toString());
            }
            if (f.this.blO == null) {
                f.this.blO = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            com.baidu.swan.apps.ap.a a = f.this.a(gVar);
            if (a == null) {
                f.this.blO.add(gVar);
                f.this.blB.g(gVar);
                c.MU().a(gVar, f.this.MZ());
            } else {
                f.this.blB.f(gVar);
                c.MU().a(gVar, f.this.MZ(), a);
            }
            if (f.this.blK != null) {
                f.this.blK.onNext(gVar);
                if (!f.this.blB.asi()) {
                    f.this.blK.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> blX = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.8
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String I(com.baidu.swan.pms.model.d dVar) {
            if (dVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.Nt();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.Nu();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.KL();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.d dVar) {
            super.G(dVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void H(com.baidu.swan.pms.model.d dVar) {
            super.H(dVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": framework onDownloading");
            }
            f.this.b(dVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass8) dVar, aVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onDownloadError：" + aVar.toString());
            }
            f.this.blB.f(dVar);
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(13L).aF(aVar.errorNo).mj("Framework包下载失败").mk(aVar.toString());
            if (f.this.blL != null) {
                f.this.blL.onError(new PkgDownloadError(dVar, mk));
            }
            c.MU().a(dVar, f.this.MZ(), mk);
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void E(com.baidu.swan.pms.model.d dVar) {
            super.E(dVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": swancore onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ap.a a = f.this.a(dVar);
            if (a == null) {
                f.this.blP = dVar;
                f.this.blB.g(dVar);
                if (f.this.blL != null) {
                    f.this.blL.onNext(dVar);
                    f.this.blL.onCompleted();
                }
                c.MU().a(dVar, f.this.MZ());
                return;
            }
            f.this.blB.f(dVar);
            if (f.this.blL != null) {
                f.this.blL.onError(new PkgDownloadError(dVar, a));
            }
            c.MU().a(dVar, f.this.MZ(), a);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> blY = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String I(com.baidu.swan.pms.model.b bVar) {
            if (bVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.Nm();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.Nv();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.KL();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void G(com.baidu.swan.pms.model.b bVar) {
            super.G(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void H(com.baidu.swan.pms.model.b bVar) {
            super.H(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": extension onDownloading");
            }
            f.this.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass9) bVar, aVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onDownloadError：" + aVar.toString());
            }
            f.this.blB.f(bVar);
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(14L).aF(aVar.errorNo).mj("Extension下载失败").mk(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", mk.toString());
            }
            f.this.c(bVar);
            c.MU().a(bVar, f.this.MZ(), mk);
            com.baidu.swan.d.c.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void E(com.baidu.swan.pms.model.b bVar) {
            super.E(bVar);
            com.baidu.swan.apps.ap.a a = f.this.a(bVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext onFileDownloaded: " + bVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext errcode=" + a);
            }
            if (a != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.blB.f(bVar);
                f.this.c(bVar);
                c.MU().a(bVar, f.this.MZ(), a);
                return;
            }
            f.this.blQ = bVar;
            f.this.blB.g(bVar);
            f.this.c(bVar);
            c.MU().a(bVar, f.this.MZ());
        }
    };
    private com.baidu.swan.pms.a.f blZ = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.10
        @Override // com.baidu.swan.pms.a.f
        public void b(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.blR = pMSAppInfo;
            if (f.this.blR != null) {
                f.this.a(f.this.blR);
                com.baidu.swan.apps.ag.g.b.x(f.this.blR.pluginInfo, true);
                if (f.this.blS != null) {
                    f.this.blS.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.d.c.a(f.this.blR.iconUrl, f.this.blR.appCategory, new c.a() { // from class: com.baidu.swan.apps.core.pms.f.10.1
                    @Override // com.baidu.swan.apps.core.pms.d.c.a
                    public void h(Bitmap bitmap) {
                        if (f.this.blS != null) {
                            f.this.blS.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> bma = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.2
        @Override // rx.e
        public void onCompleted() {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.MZ() + " : 包下载onCompleted");
            }
            f.this.MY();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.MZ() + " : 包下载OnError：" + th.toString());
            }
            f.this.n(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.MZ() + " : 单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> blS = new ArrayList();

    protected abstract void MY();

    protected abstract PMSDownloadType MZ();

    protected abstract void n(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void KK() {
        this.blS.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void MW() {
        this.blS.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        }
        if (aVar != null && aVar.errorNo == 1010) {
            Ng();
        }
        this.blS.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + eVar.asd());
            }
            this.blS.add(new UbcFlowEvent("na_pms_start_download"));
            this.blB = eVar;
            if (!this.blB.isEmpty()) {
                Nj();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> Na() {
        return this.blV;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> Nb() {
        return this.blW;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> Nc() {
        return this.blX;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> Nd() {
        return this.blY;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f Ne() {
        return this.blZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Nf() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int KL() {
        return 100;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.apps.x.c.a ix = com.baidu.swan.apps.x.c.a.ix(Nf());
        ix.TT().eW(1);
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.ap.a b = com.baidu.swan.apps.core.pms.d.a.b(fVar);
        ix.iy("CostRenameZip: " + (System.currentTimeMillis() - currentTimeMillis));
        return b;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.g gVar) {
        if (!ab.d(new File(gVar.filePath), gVar.sign)) {
            return new com.baidu.swan.apps.ap.a().aE(12L).aG(2300L).mj("分包签名校验失败");
        }
        if (!com.baidu.swan.apps.core.pms.d.b.i(gVar)) {
            return new com.baidu.swan.apps.ap.a().aE(12L).aG(2320L).mj("分包解压失败");
        }
        return null;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0290a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aE(13L).aG(2907L).mj("Core包更新失败");
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.bqW = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(bVar.category, aVar)) {
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aE(14L).aG(2908L).mj("Extension包更新失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void er(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.arf().S(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.arf().S(this.mAppId, 0);
        }
    }

    private void Ng() {
        PMSAppInfo pZ = com.baidu.swan.pms.database.a.arf().pZ(this.mAppId);
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "updateMainMaxageTime: localAppInfo = " + pZ);
        }
        if (pZ != null) {
            pZ.ars();
            if (this.blN != null) {
                this.blN.createTime = pZ.createTime;
            }
            if (this.blR != null) {
                this.blR.createTime = pZ.createTime;
            }
            com.baidu.swan.pms.database.a.arf().m(pZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.ap.a Nh() {
        if (this.blR == null) {
            if (this.blN == null) {
                return new com.baidu.swan.apps.ap.a().aE(10L).aF(2903L).mj("Server未返回主包&AppInfo");
            }
            PMSAppInfo pZ = com.baidu.swan.pms.database.a.arf().pZ(this.mAppId);
            if (pZ == null) {
                return new com.baidu.swan.apps.ap.a().aE(10L).aF(2904L).mj("Server未返回AppInfo数据，本地也没有数据");
            }
            this.blR = pZ;
            com.baidu.swan.apps.core.pms.d.a.a(this.blR, this.blN);
            this.blR.ars();
            if (com.baidu.swan.pms.database.a.arf().a(this.blN, this.blO, this.blP, this.blQ, this.blR)) {
                return null;
            }
            return new com.baidu.swan.apps.ap.a().aE(10L).aF(2906L).mj("更新DB失败");
        }
        if (this.blN != null) {
            com.baidu.swan.apps.core.pms.d.a.a(this.blR, this.blN);
        } else if (com.baidu.swan.apps.core.pms.d.b.L(this.blO)) {
            this.blU = this.blO.get(0);
            this.blU.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.d.a.a(this.blR, this.blU);
        } else {
            PMSAppInfo pZ2 = com.baidu.swan.pms.database.a.arf().pZ(this.mAppId);
            if (pZ2 == null) {
                return new com.baidu.swan.apps.ap.a().aE(10L).aF(2905L).mj("Server未返回包数据，本地也没有数据");
            }
            this.blR.appId = this.mAppId;
            this.blR.o(pZ2);
        }
        this.blR.ars();
        if (com.baidu.swan.pms.database.a.arf().a(this.blN, this.blO, this.blP, this.blQ, this.blR)) {
            com.baidu.swan.apps.core.pms.d.a.d(this.blR);
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aE(10L).aF(2906L).mj("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ni() {
        if (this.blR != null) {
            PMSAppInfo pZ = com.baidu.swan.pms.database.a.arf().pZ(this.mAppId);
            if (pZ == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", getClassName() + ": Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.blR.appId = this.mAppId;
            this.blR.o(pZ);
            if (this.blR.agK()) {
                this.blR.ars();
            }
            if (com.baidu.swan.pms.database.a.arf().m(this.blR)) {
                com.baidu.swan.apps.core.pms.d.a.d(this.blR);
            }
        }
    }

    public void a(PMSAppInfo pMSAppInfo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        c.MU().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.11
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.blN = fVar;
                f.this.blB.g(fVar);
                if (f.this.blJ != null) {
                    f.this.blJ.onNext(fVar);
                    f.this.blJ.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.blB.f(fVar);
                if (f.this.blJ != null) {
                    f.this.blJ.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.MU().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.12
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.blO == null) {
                    f.this.blO = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.blO.add(gVar);
                f.this.blB.g(gVar);
                if (f.this.blK != null) {
                    f.this.blK.onNext(gVar);
                    if (!f.this.blB.asi()) {
                        f.this.blK.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.blB.f(gVar);
                if (f.this.blK != null) {
                    f.this.blK.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.MU().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.13
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.blP = dVar;
                f.this.blB.g(dVar);
                if (f.this.blL != null) {
                    f.this.blL.onNext(dVar);
                    f.this.blL.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.blB.f(dVar);
                if (f.this.blL != null) {
                    f.this.blL.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.MU().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.14
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onSuccess ：" + pMSDownloadType);
                }
                f.this.blQ = bVar;
                f.this.blB.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                }
                f.this.blB.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.blM != null) {
            this.blM.onNext(bVar);
            this.blM.onCompleted();
        }
    }

    private void Nj() {
        ArrayList arrayList = new ArrayList();
        if (this.blB.ase()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.blJ = jVar;
                }
            }));
        }
        if (this.blB.asf()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.blK = jVar;
                }
            }));
        }
        if (this.blB.asg()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.blL = jVar;
                }
            }));
        }
        if (this.blB.ash()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.blM = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.m(arrayList).b(this.bma);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ar(String str, String str2) {
        com.baidu.swan.apps.performance.c.a.a(this.mAppId, str, this.blS, str2);
        this.blS.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
