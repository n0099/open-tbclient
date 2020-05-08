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
/* loaded from: classes11.dex */
public abstract class f extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.pms.model.b bOA;
    protected PMSAppInfo bOB;
    protected com.baidu.swan.pms.model.g bOE;
    protected com.baidu.swan.pms.f.e bOl;
    private rx.j<? super com.baidu.swan.pms.model.f> bOt;
    private rx.j<? super com.baidu.swan.pms.model.g> bOu;
    private rx.j<? super com.baidu.swan.pms.model.d> bOv;
    private rx.j<? super com.baidu.swan.pms.model.b> bOw;
    protected com.baidu.swan.pms.model.f bOx;
    protected List<com.baidu.swan.pms.model.g> bOy;
    protected com.baidu.swan.pms.model.d bOz;
    protected String mAppId;
    private String mClassName = "";
    protected String bOD = "0";
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> bOF = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String M(com.baidu.swan.pms.model.f fVar) {
            if (fVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.Xy();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.Xz();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.UR();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void K(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.jY(f.this.Xm()).aea().fr(1);
            super.K(fVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void L(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.jY(f.this.Xm()).aea().fr(1);
            super.L(fVar);
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
            f.this.bOl.f(fVar);
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(11L).bo(aVar.errorNo).nK("主包下载失败").nL(aVar.toString());
            if (f.this.bOt != null) {
                f.this.bOt.onError(new PkgDownloadError(fVar, nL));
            }
            c.Xb().a(fVar, f.this.Xg(), nL);
            com.baidu.swan.d.c.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void I(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.jY(f.this.Xm()).aea().fr(1);
            super.I(fVar);
            f.this.bOC.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ap.a a = f.this.a(fVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: pmsPkgMain=" + fVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: errCode=" + a);
            }
            if (a == null) {
                f.this.bOx = fVar;
                f.this.bOl.g(fVar);
                if (f.this.bOt != null) {
                    f.this.bOt.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.bOt.onCompleted();
                }
                c.Xb().a(fVar, f.this.Xg());
                return;
            }
            f.this.bOl.f(fVar);
            if (f.this.bOt != null) {
                f.this.bOt.onError(new PkgDownloadError(fVar, a));
            }
            c.Xb().a(fVar, f.this.Xg(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            com.baidu.swan.apps.x.c.a.jY(f.this.Xm()).jZ(fVar.toString()).fr(1);
            com.baidu.swan.apps.as.d.b<i.a> bVar = new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.core.pms.f.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void F(i.a aVar) {
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> bOG = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.7
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String M(com.baidu.swan.pms.model.g gVar) {
            if (gVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.b.aK(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            if (gVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.b.aL(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.UR();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void K(com.baidu.swan.pms.model.g gVar) {
            super.K(gVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void L(com.baidu.swan.pms.model.g gVar) {
            super.L(gVar);
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
            f.this.bOl.f(gVar);
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(12L).bo(aVar.errorNo).nK("分包下载失败").nL(aVar.toString());
            if (f.this.bOu != null) {
                f.this.bOu.onError(new PkgDownloadError(gVar, nL));
            }
            c.Xb().a(gVar, f.this.Xg(), nL);
            com.baidu.swan.d.c.deleteFile(gVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void I(com.baidu.swan.pms.model.g gVar) {
            super.I(gVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onFileDownloaded: " + gVar.toString());
            }
            if (f.this.bOy == null) {
                f.this.bOy = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            com.baidu.swan.apps.ap.a a = f.this.a(gVar);
            if (a == null) {
                f.this.bOy.add(gVar);
                f.this.bOl.g(gVar);
                c.Xb().a(gVar, f.this.Xg());
            } else {
                f.this.bOl.f(gVar);
                c.Xb().a(gVar, f.this.Xg(), a);
            }
            if (f.this.bOu != null) {
                f.this.bOu.onNext(gVar);
                if (!f.this.bOl.aCM()) {
                    f.this.bOu.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> bOH = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.8
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String M(com.baidu.swan.pms.model.d dVar) {
            if (dVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.XA();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.XB();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.UR();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void K(com.baidu.swan.pms.model.d dVar) {
            super.K(dVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void L(com.baidu.swan.pms.model.d dVar) {
            super.L(dVar);
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
            f.this.bOl.f(dVar);
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(13L).bo(aVar.errorNo).nK("Framework包下载失败").nL(aVar.toString());
            if (f.this.bOv != null) {
                f.this.bOv.onError(new PkgDownloadError(dVar, nL));
            }
            c.Xb().a(dVar, f.this.Xg(), nL);
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void I(com.baidu.swan.pms.model.d dVar) {
            super.I(dVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": swancore onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ap.a a = f.this.a(dVar);
            if (a == null) {
                f.this.bOz = dVar;
                f.this.bOl.g(dVar);
                if (f.this.bOv != null) {
                    f.this.bOv.onNext(dVar);
                    f.this.bOv.onCompleted();
                }
                c.Xb().a(dVar, f.this.Xg());
                return;
            }
            f.this.bOl.f(dVar);
            if (f.this.bOv != null) {
                f.this.bOv.onError(new PkgDownloadError(dVar, a));
            }
            c.Xb().a(dVar, f.this.Xg(), a);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> bOI = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String M(com.baidu.swan.pms.model.b bVar) {
            if (bVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.Xt();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.XC();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.UR();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void K(com.baidu.swan.pms.model.b bVar) {
            super.K(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(com.baidu.swan.pms.model.b bVar) {
            super.L(bVar);
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
            f.this.bOl.f(bVar);
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(14L).bo(aVar.errorNo).nK("Extension下载失败").nL(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", nL.toString());
            }
            f.this.c(bVar);
            c.Xb().a(bVar, f.this.Xg(), nL);
            com.baidu.swan.d.c.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void I(com.baidu.swan.pms.model.b bVar) {
            super.I(bVar);
            com.baidu.swan.apps.ap.a a = f.this.a(bVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext onFileDownloaded: " + bVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext errcode=" + a);
            }
            if (a != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.bOl.f(bVar);
                f.this.c(bVar);
                c.Xb().a(bVar, f.this.Xg(), a);
                return;
            }
            f.this.bOA = bVar;
            f.this.bOl.g(bVar);
            f.this.c(bVar);
            c.Xb().a(bVar, f.this.Xg());
        }
    };
    private com.baidu.swan.pms.a.f bOJ = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.10
        @Override // com.baidu.swan.pms.a.f
        public void b(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.bOB = pMSAppInfo;
            if (f.this.bOB != null) {
                f.this.a(f.this.bOB);
                com.baidu.swan.apps.ag.g.b.C(f.this.bOB.pluginInfo, true);
                if (f.this.bOC != null) {
                    f.this.bOC.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.d.c.a(f.this.bOB.iconUrl, f.this.bOB.appCategory, new c.a() { // from class: com.baidu.swan.apps.core.pms.f.10.1
                    @Override // com.baidu.swan.apps.core.pms.d.c.a
                    public void i(Bitmap bitmap) {
                        if (f.this.bOC != null) {
                            f.this.bOC.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> bOK = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.2
        @Override // rx.e
        public void onCompleted() {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.Xg() + " : 包下载onCompleted");
            }
            f.this.Xf();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.Xg() + " : 包下载OnError：" + th.toString());
            }
            f.this.o(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.Xg() + " : 单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> bOC = new ArrayList();

    protected abstract void Xf();

    protected abstract PMSDownloadType Xg();

    protected abstract void o(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void UQ() {
        this.bOC.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xd() {
        this.bOC.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        }
        if (aVar != null && aVar.errorNo == 1010) {
            Xn();
        }
        this.bOC.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + eVar.aCH());
            }
            this.bOC.add(new UbcFlowEvent("na_pms_start_download"));
            this.bOl = eVar;
            if (!this.bOl.isEmpty()) {
                Xq();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> Xh() {
        return this.bOF;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> Xi() {
        return this.bOG;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> Xj() {
        return this.bOH;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> Xk() {
        return this.bOI;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f Xl() {
        return this.bOJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Xm() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int UR() {
        return 100;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.apps.x.c.a jY = com.baidu.swan.apps.x.c.a.jY(Xm());
        jY.aea().fr(1);
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.ap.a b = com.baidu.swan.apps.core.pms.d.a.b(fVar);
        jY.jZ("CostRenameZip: " + (System.currentTimeMillis() - currentTimeMillis));
        return b;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.g gVar) {
        if (!ab.e(new File(gVar.filePath), gVar.sign)) {
            return new com.baidu.swan.apps.ap.a().bn(12L).bp(2300L).nK("分包签名校验失败");
        }
        if (!com.baidu.swan.apps.core.pms.d.b.i(gVar)) {
            return new com.baidu.swan.apps.ap.a().bn(12L).bp(2320L).nK("分包解压失败");
        }
        return null;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0351a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.ap.a().bn(13L).bp(2907L).nK("Core包更新失败");
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.bTG = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(bVar.category, aVar)) {
            return null;
        }
        return new com.baidu.swan.apps.ap.a().bn(14L).bp(2908L).nK("Extension包更新失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eM(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.aBI().Y(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.aBI().Y(this.mAppId, 0);
        }
    }

    private void Xn() {
        PMSAppInfo rA = com.baidu.swan.pms.database.a.aBI().rA(this.mAppId);
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "updateMainMaxageTime: localAppInfo = " + rA);
        }
        if (rA != null) {
            rA.aBV();
            if (this.bOx != null) {
                this.bOx.createTime = rA.createTime;
            }
            if (this.bOB != null) {
                this.bOB.createTime = rA.createTime;
            }
            com.baidu.swan.pms.database.a.aBI().m(rA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.ap.a Xo() {
        if (this.bOB == null) {
            if (this.bOx == null) {
                return new com.baidu.swan.apps.ap.a().bn(10L).bo(2903L).nK("Server未返回主包&AppInfo");
            }
            PMSAppInfo rA = com.baidu.swan.pms.database.a.aBI().rA(this.mAppId);
            if (rA == null) {
                return new com.baidu.swan.apps.ap.a().bn(10L).bo(2904L).nK("Server未返回AppInfo数据，本地也没有数据");
            }
            this.bOB = rA;
            com.baidu.swan.apps.core.pms.d.a.a(this.bOB, this.bOx);
            this.bOB.aBV();
            if (com.baidu.swan.pms.database.a.aBI().a(this.bOx, this.bOy, this.bOz, this.bOA, this.bOB)) {
                return null;
            }
            return new com.baidu.swan.apps.ap.a().bn(10L).bo(2906L).nK("更新DB失败");
        }
        if (this.bOx != null) {
            com.baidu.swan.apps.core.pms.d.a.a(this.bOB, this.bOx);
        } else if (com.baidu.swan.apps.core.pms.d.b.T(this.bOy)) {
            this.bOE = this.bOy.get(0);
            this.bOE.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.d.a.a(this.bOB, this.bOE);
        } else {
            PMSAppInfo rA2 = com.baidu.swan.pms.database.a.aBI().rA(this.mAppId);
            if (rA2 == null) {
                return new com.baidu.swan.apps.ap.a().bn(10L).bo(2905L).nK("Server未返回包数据，本地也没有数据");
            }
            this.bOB.appId = this.mAppId;
            this.bOB.o(rA2);
        }
        this.bOB.aBV();
        if (com.baidu.swan.pms.database.a.aBI().a(this.bOx, this.bOy, this.bOz, this.bOA, this.bOB)) {
            com.baidu.swan.apps.core.pms.d.a.d(this.bOB);
            return null;
        }
        return new com.baidu.swan.apps.ap.a().bn(10L).bo(2906L).nK("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xp() {
        if (this.bOB != null) {
            PMSAppInfo rA = com.baidu.swan.pms.database.a.aBI().rA(this.mAppId);
            if (rA == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", getClassName() + ": Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.bOB.appId = this.mAppId;
            this.bOB.o(rA);
            if (this.bOB.ark()) {
                this.bOB.aBV();
            }
            if (com.baidu.swan.pms.database.a.aBI().m(this.bOB)) {
                com.baidu.swan.apps.core.pms.d.a.d(this.bOB);
            }
        }
    }

    public void a(PMSAppInfo pMSAppInfo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        c.Xb().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.11
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.bOx = fVar;
                f.this.bOl.g(fVar);
                if (f.this.bOt != null) {
                    f.this.bOt.onNext(fVar);
                    f.this.bOt.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bOl.f(fVar);
                if (f.this.bOt != null) {
                    f.this.bOt.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.Xb().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.12
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.bOy == null) {
                    f.this.bOy = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.bOy.add(gVar);
                f.this.bOl.g(gVar);
                if (f.this.bOu != null) {
                    f.this.bOu.onNext(gVar);
                    if (!f.this.bOl.aCM()) {
                        f.this.bOu.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bOl.f(gVar);
                if (f.this.bOu != null) {
                    f.this.bOu.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.Xb().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.13
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.bOz = dVar;
                f.this.bOl.g(dVar);
                if (f.this.bOv != null) {
                    f.this.bOv.onNext(dVar);
                    f.this.bOv.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bOl.f(dVar);
                if (f.this.bOv != null) {
                    f.this.bOv.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.Xb().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.14
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onSuccess ：" + pMSDownloadType);
                }
                f.this.bOA = bVar;
                f.this.bOl.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                }
                f.this.bOl.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.bOw != null) {
            this.bOw.onNext(bVar);
            this.bOw.onCompleted();
        }
    }

    private void Xq() {
        ArrayList arrayList = new ArrayList();
        if (this.bOl.aCI()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.bOt = jVar;
                }
            }));
        }
        if (this.bOl.aCJ()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.bOu = jVar;
                }
            }));
        }
        if (this.bOl.aCK()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.bOv = jVar;
                }
            }));
        }
        if (this.bOl.aCL()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.bOw = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.bOK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aJ(String str, String str2) {
        com.baidu.swan.apps.performance.c.a.a(this.mAppId, str, this.bOC, str2);
        this.bOC.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
