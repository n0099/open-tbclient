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
    protected com.baidu.swan.pms.f.e bOg;
    private rx.j<? super com.baidu.swan.pms.model.f> bOo;
    private rx.j<? super com.baidu.swan.pms.model.g> bOp;
    private rx.j<? super com.baidu.swan.pms.model.d> bOq;
    private rx.j<? super com.baidu.swan.pms.model.b> bOr;
    protected com.baidu.swan.pms.model.f bOs;
    protected List<com.baidu.swan.pms.model.g> bOt;
    protected com.baidu.swan.pms.model.d bOu;
    protected com.baidu.swan.pms.model.b bOv;
    protected PMSAppInfo bOw;
    protected com.baidu.swan.pms.model.g bOz;
    protected String mAppId;
    private String mClassName = "";
    protected String bOy = "0";
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> bOA = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String L(com.baidu.swan.pms.model.f fVar) {
            if (fVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.Xz();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.XA();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.US();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void J(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.jY(f.this.Xn()).aeb().fr(1);
            super.J(fVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void K(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.jY(f.this.Xn()).aeb().fr(1);
            super.K(fVar);
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
            f.this.bOg.f(fVar);
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(11L).bo(aVar.errorNo).nK("主包下载失败").nL(aVar.toString());
            if (f.this.bOo != null) {
                f.this.bOo.onError(new PkgDownloadError(fVar, nL));
            }
            c.Xc().a(fVar, f.this.Xh(), nL);
            com.baidu.swan.d.c.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void H(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.jY(f.this.Xn()).aeb().fr(1);
            super.H(fVar);
            f.this.bOx.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ap.a a = f.this.a(fVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: pmsPkgMain=" + fVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: errCode=" + a);
            }
            if (a == null) {
                f.this.bOs = fVar;
                f.this.bOg.g(fVar);
                if (f.this.bOo != null) {
                    f.this.bOo.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.bOo.onCompleted();
                }
                c.Xc().a(fVar, f.this.Xh());
                return;
            }
            f.this.bOg.f(fVar);
            if (f.this.bOo != null) {
                f.this.bOo.onError(new PkgDownloadError(fVar, a));
            }
            c.Xc().a(fVar, f.this.Xh(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            com.baidu.swan.apps.x.c.a.jY(f.this.Xn()).jZ(fVar.toString()).fr(1);
            com.baidu.swan.apps.as.d.b<i.a> bVar = new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.core.pms.f.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void E(i.a aVar) {
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> bOB = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.7
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String L(com.baidu.swan.pms.model.g gVar) {
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
            return f.this.US();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void J(com.baidu.swan.pms.model.g gVar) {
            super.J(gVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void K(com.baidu.swan.pms.model.g gVar) {
            super.K(gVar);
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
            f.this.bOg.f(gVar);
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(12L).bo(aVar.errorNo).nK("分包下载失败").nL(aVar.toString());
            if (f.this.bOp != null) {
                f.this.bOp.onError(new PkgDownloadError(gVar, nL));
            }
            c.Xc().a(gVar, f.this.Xh(), nL);
            com.baidu.swan.d.c.deleteFile(gVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void H(com.baidu.swan.pms.model.g gVar) {
            super.H(gVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onFileDownloaded: " + gVar.toString());
            }
            if (f.this.bOt == null) {
                f.this.bOt = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            com.baidu.swan.apps.ap.a a = f.this.a(gVar);
            if (a == null) {
                f.this.bOt.add(gVar);
                f.this.bOg.g(gVar);
                c.Xc().a(gVar, f.this.Xh());
            } else {
                f.this.bOg.f(gVar);
                c.Xc().a(gVar, f.this.Xh(), a);
            }
            if (f.this.bOp != null) {
                f.this.bOp.onNext(gVar);
                if (!f.this.bOg.aCM()) {
                    f.this.bOp.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> bOC = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.8
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String L(com.baidu.swan.pms.model.d dVar) {
            if (dVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.XB();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.XC();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.US();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void J(com.baidu.swan.pms.model.d dVar) {
            super.J(dVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void K(com.baidu.swan.pms.model.d dVar) {
            super.K(dVar);
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
            f.this.bOg.f(dVar);
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(13L).bo(aVar.errorNo).nK("Framework包下载失败").nL(aVar.toString());
            if (f.this.bOq != null) {
                f.this.bOq.onError(new PkgDownloadError(dVar, nL));
            }
            c.Xc().a(dVar, f.this.Xh(), nL);
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void H(com.baidu.swan.pms.model.d dVar) {
            super.H(dVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": swancore onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ap.a a = f.this.a(dVar);
            if (a == null) {
                f.this.bOu = dVar;
                f.this.bOg.g(dVar);
                if (f.this.bOq != null) {
                    f.this.bOq.onNext(dVar);
                    f.this.bOq.onCompleted();
                }
                c.Xc().a(dVar, f.this.Xh());
                return;
            }
            f.this.bOg.f(dVar);
            if (f.this.bOq != null) {
                f.this.bOq.onError(new PkgDownloadError(dVar, a));
            }
            c.Xc().a(dVar, f.this.Xh(), a);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> bOD = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String L(com.baidu.swan.pms.model.b bVar) {
            if (bVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.Xu();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.XD();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.US();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void J(com.baidu.swan.pms.model.b bVar) {
            super.J(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void K(com.baidu.swan.pms.model.b bVar) {
            super.K(bVar);
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
            f.this.bOg.f(bVar);
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(14L).bo(aVar.errorNo).nK("Extension下载失败").nL(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", nL.toString());
            }
            f.this.c(bVar);
            c.Xc().a(bVar, f.this.Xh(), nL);
            com.baidu.swan.d.c.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void H(com.baidu.swan.pms.model.b bVar) {
            super.H(bVar);
            com.baidu.swan.apps.ap.a a = f.this.a(bVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext onFileDownloaded: " + bVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext errcode=" + a);
            }
            if (a != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.bOg.f(bVar);
                f.this.c(bVar);
                c.Xc().a(bVar, f.this.Xh(), a);
                return;
            }
            f.this.bOv = bVar;
            f.this.bOg.g(bVar);
            f.this.c(bVar);
            c.Xc().a(bVar, f.this.Xh());
        }
    };
    private com.baidu.swan.pms.a.f bOE = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.10
        @Override // com.baidu.swan.pms.a.f
        public void b(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.bOw = pMSAppInfo;
            if (f.this.bOw != null) {
                f.this.a(f.this.bOw);
                com.baidu.swan.apps.ag.g.b.C(f.this.bOw.pluginInfo, true);
                if (f.this.bOx != null) {
                    f.this.bOx.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.d.c.a(f.this.bOw.iconUrl, f.this.bOw.appCategory, new c.a() { // from class: com.baidu.swan.apps.core.pms.f.10.1
                    @Override // com.baidu.swan.apps.core.pms.d.c.a
                    public void i(Bitmap bitmap) {
                        if (f.this.bOx != null) {
                            f.this.bOx.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> bOF = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.2
        @Override // rx.e
        public void onCompleted() {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.Xh() + " : 包下载onCompleted");
            }
            f.this.Xg();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.Xh() + " : 包下载OnError：" + th.toString());
            }
            f.this.o(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.Xh() + " : 单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> bOx = new ArrayList();

    protected abstract void Xg();

    protected abstract PMSDownloadType Xh();

    protected abstract void o(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void UR() {
        this.bOx.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xe() {
        this.bOx.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        }
        if (aVar != null && aVar.errorNo == 1010) {
            Xo();
        }
        this.bOx.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + eVar.aCH());
            }
            this.bOx.add(new UbcFlowEvent("na_pms_start_download"));
            this.bOg = eVar;
            if (!this.bOg.isEmpty()) {
                Xr();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> Xi() {
        return this.bOA;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> Xj() {
        return this.bOB;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> Xk() {
        return this.bOC;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> Xl() {
        return this.bOD;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f Xm() {
        return this.bOE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Xn() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int US() {
        return 100;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.apps.x.c.a jY = com.baidu.swan.apps.x.c.a.jY(Xn());
        jY.aeb().fr(1);
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
        a.C0330a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
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
        aVar.bTA = bVar.filePath;
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

    private void Xo() {
        PMSAppInfo rA = com.baidu.swan.pms.database.a.aBI().rA(this.mAppId);
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "updateMainMaxageTime: localAppInfo = " + rA);
        }
        if (rA != null) {
            rA.aBV();
            if (this.bOs != null) {
                this.bOs.createTime = rA.createTime;
            }
            if (this.bOw != null) {
                this.bOw.createTime = rA.createTime;
            }
            com.baidu.swan.pms.database.a.aBI().m(rA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.ap.a Xp() {
        if (this.bOw == null) {
            if (this.bOs == null) {
                return new com.baidu.swan.apps.ap.a().bn(10L).bo(2903L).nK("Server未返回主包&AppInfo");
            }
            PMSAppInfo rA = com.baidu.swan.pms.database.a.aBI().rA(this.mAppId);
            if (rA == null) {
                return new com.baidu.swan.apps.ap.a().bn(10L).bo(2904L).nK("Server未返回AppInfo数据，本地也没有数据");
            }
            this.bOw = rA;
            com.baidu.swan.apps.core.pms.d.a.a(this.bOw, this.bOs);
            this.bOw.aBV();
            if (com.baidu.swan.pms.database.a.aBI().a(this.bOs, this.bOt, this.bOu, this.bOv, this.bOw)) {
                return null;
            }
            return new com.baidu.swan.apps.ap.a().bn(10L).bo(2906L).nK("更新DB失败");
        }
        if (this.bOs != null) {
            com.baidu.swan.apps.core.pms.d.a.a(this.bOw, this.bOs);
        } else if (com.baidu.swan.apps.core.pms.d.b.T(this.bOt)) {
            this.bOz = this.bOt.get(0);
            this.bOz.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.d.a.a(this.bOw, this.bOz);
        } else {
            PMSAppInfo rA2 = com.baidu.swan.pms.database.a.aBI().rA(this.mAppId);
            if (rA2 == null) {
                return new com.baidu.swan.apps.ap.a().bn(10L).bo(2905L).nK("Server未返回包数据，本地也没有数据");
            }
            this.bOw.appId = this.mAppId;
            this.bOw.o(rA2);
        }
        this.bOw.aBV();
        if (com.baidu.swan.pms.database.a.aBI().a(this.bOs, this.bOt, this.bOu, this.bOv, this.bOw)) {
            com.baidu.swan.apps.core.pms.d.a.d(this.bOw);
            return null;
        }
        return new com.baidu.swan.apps.ap.a().bn(10L).bo(2906L).nK("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xq() {
        if (this.bOw != null) {
            PMSAppInfo rA = com.baidu.swan.pms.database.a.aBI().rA(this.mAppId);
            if (rA == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", getClassName() + ": Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.bOw.appId = this.mAppId;
            this.bOw.o(rA);
            if (this.bOw.arl()) {
                this.bOw.aBV();
            }
            if (com.baidu.swan.pms.database.a.aBI().m(this.bOw)) {
                com.baidu.swan.apps.core.pms.d.a.d(this.bOw);
            }
        }
    }

    public void a(PMSAppInfo pMSAppInfo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        c.Xc().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.11
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.bOs = fVar;
                f.this.bOg.g(fVar);
                if (f.this.bOo != null) {
                    f.this.bOo.onNext(fVar);
                    f.this.bOo.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bOg.f(fVar);
                if (f.this.bOo != null) {
                    f.this.bOo.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.Xc().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.12
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.bOt == null) {
                    f.this.bOt = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.bOt.add(gVar);
                f.this.bOg.g(gVar);
                if (f.this.bOp != null) {
                    f.this.bOp.onNext(gVar);
                    if (!f.this.bOg.aCM()) {
                        f.this.bOp.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bOg.f(gVar);
                if (f.this.bOp != null) {
                    f.this.bOp.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.Xc().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.13
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.bOu = dVar;
                f.this.bOg.g(dVar);
                if (f.this.bOq != null) {
                    f.this.bOq.onNext(dVar);
                    f.this.bOq.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bOg.f(dVar);
                if (f.this.bOq != null) {
                    f.this.bOq.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.Xc().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.14
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onSuccess ：" + pMSDownloadType);
                }
                f.this.bOv = bVar;
                f.this.bOg.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                }
                f.this.bOg.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.bOr != null) {
            this.bOr.onNext(bVar);
            this.bOr.onCompleted();
        }
    }

    private void Xr() {
        ArrayList arrayList = new ArrayList();
        if (this.bOg.aCI()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.bOo = jVar;
                }
            }));
        }
        if (this.bOg.aCJ()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.bOp = jVar;
                }
            }));
        }
        if (this.bOg.aCK()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.bOq = jVar;
                }
            }));
        }
        if (this.bOg.aCL()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.bOr = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.m(arrayList).b(this.bOF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aJ(String str, String str2) {
        com.baidu.swan.apps.performance.c.a.a(this.mAppId, str, this.bOx, str2);
        this.bOx.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
