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
    protected com.baidu.swan.pms.f.e bpM;
    private rx.j<? super com.baidu.swan.pms.model.f> bpU;
    private rx.j<? super com.baidu.swan.pms.model.g> bpV;
    private rx.j<? super com.baidu.swan.pms.model.d> bpW;
    private rx.j<? super com.baidu.swan.pms.model.b> bpX;
    protected com.baidu.swan.pms.model.f bpY;
    protected List<com.baidu.swan.pms.model.g> bpZ;
    protected com.baidu.swan.pms.model.d bqa;
    protected com.baidu.swan.pms.model.b bqb;
    protected PMSAppInfo bqc;
    protected com.baidu.swan.pms.model.g bqf;
    protected String mAppId;
    private String mClassName = "";
    protected String bqe = "0";
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> bqg = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String K(com.baidu.swan.pms.model.f fVar) {
            if (fVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.PH();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.PI();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Nc();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void I(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.iM(f.this.Pv()).Wj().fm(1);
            super.I(fVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void J(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.iM(f.this.Pv()).Wj().fm(1);
            super.J(fVar);
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
            f.this.bpM.f(fVar);
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(11L).aJ(aVar.errorNo).my("主包下载失败").mz(aVar.toString());
            if (f.this.bpU != null) {
                f.this.bpU.onError(new PkgDownloadError(fVar, mz));
            }
            c.Pk().a(fVar, f.this.Pp(), mz);
            com.baidu.swan.d.c.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void G(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.iM(f.this.Pv()).Wj().fm(1);
            super.G(fVar);
            f.this.bqd.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ap.a a = f.this.a(fVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: pmsPkgMain=" + fVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: errCode=" + a);
            }
            if (a == null) {
                f.this.bpY = fVar;
                f.this.bpM.g(fVar);
                if (f.this.bpU != null) {
                    f.this.bpU.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.bpU.onCompleted();
                }
                c.Pk().a(fVar, f.this.Pp());
                return;
            }
            f.this.bpM.f(fVar);
            if (f.this.bpU != null) {
                f.this.bpU.onError(new PkgDownloadError(fVar, a));
            }
            c.Pk().a(fVar, f.this.Pp(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            com.baidu.swan.apps.x.c.a.iM(f.this.Pv()).iN(fVar.toString()).fm(1);
            com.baidu.swan.apps.as.d.b<i.a> bVar = new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.core.pms.f.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(i.a aVar) {
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> bqh = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.7
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String K(com.baidu.swan.pms.model.g gVar) {
            if (gVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.b.aC(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            if (gVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.b.aD(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Nc();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void I(com.baidu.swan.pms.model.g gVar) {
            super.I(gVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void J(com.baidu.swan.pms.model.g gVar) {
            super.J(gVar);
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
            f.this.bpM.f(gVar);
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(12L).aJ(aVar.errorNo).my("分包下载失败").mz(aVar.toString());
            if (f.this.bpV != null) {
                f.this.bpV.onError(new PkgDownloadError(gVar, mz));
            }
            c.Pk().a(gVar, f.this.Pp(), mz);
            com.baidu.swan.d.c.deleteFile(gVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void G(com.baidu.swan.pms.model.g gVar) {
            super.G(gVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onFileDownloaded: " + gVar.toString());
            }
            if (f.this.bpZ == null) {
                f.this.bpZ = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            com.baidu.swan.apps.ap.a a = f.this.a(gVar);
            if (a == null) {
                f.this.bpZ.add(gVar);
                f.this.bpM.g(gVar);
                c.Pk().a(gVar, f.this.Pp());
            } else {
                f.this.bpM.f(gVar);
                c.Pk().a(gVar, f.this.Pp(), a);
            }
            if (f.this.bpV != null) {
                f.this.bpV.onNext(gVar);
                if (!f.this.bpM.auy()) {
                    f.this.bpV.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> bqi = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.8
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String K(com.baidu.swan.pms.model.d dVar) {
            if (dVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.PJ();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.PK();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Nc();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void I(com.baidu.swan.pms.model.d dVar) {
            super.I(dVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void J(com.baidu.swan.pms.model.d dVar) {
            super.J(dVar);
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
            f.this.bpM.f(dVar);
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(13L).aJ(aVar.errorNo).my("Framework包下载失败").mz(aVar.toString());
            if (f.this.bpW != null) {
                f.this.bpW.onError(new PkgDownloadError(dVar, mz));
            }
            c.Pk().a(dVar, f.this.Pp(), mz);
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void G(com.baidu.swan.pms.model.d dVar) {
            super.G(dVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": swancore onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ap.a a = f.this.a(dVar);
            if (a == null) {
                f.this.bqa = dVar;
                f.this.bpM.g(dVar);
                if (f.this.bpW != null) {
                    f.this.bpW.onNext(dVar);
                    f.this.bpW.onCompleted();
                }
                c.Pk().a(dVar, f.this.Pp());
                return;
            }
            f.this.bpM.f(dVar);
            if (f.this.bpW != null) {
                f.this.bpW.onError(new PkgDownloadError(dVar, a));
            }
            c.Pk().a(dVar, f.this.Pp(), a);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> bqj = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String K(com.baidu.swan.pms.model.b bVar) {
            if (bVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.PC();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.PL();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Nc();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void I(com.baidu.swan.pms.model.b bVar) {
            super.I(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void J(com.baidu.swan.pms.model.b bVar) {
            super.J(bVar);
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
            f.this.bpM.f(bVar);
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(14L).aJ(aVar.errorNo).my("Extension下载失败").mz(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", mz.toString());
            }
            f.this.c(bVar);
            c.Pk().a(bVar, f.this.Pp(), mz);
            com.baidu.swan.d.c.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void G(com.baidu.swan.pms.model.b bVar) {
            super.G(bVar);
            com.baidu.swan.apps.ap.a a = f.this.a(bVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext onFileDownloaded: " + bVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext errcode=" + a);
            }
            if (a != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.bpM.f(bVar);
                f.this.c(bVar);
                c.Pk().a(bVar, f.this.Pp(), a);
                return;
            }
            f.this.bqb = bVar;
            f.this.bpM.g(bVar);
            f.this.c(bVar);
            c.Pk().a(bVar, f.this.Pp());
        }
    };
    private com.baidu.swan.pms.a.f bqk = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.10
        @Override // com.baidu.swan.pms.a.f
        public void b(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.bqc = pMSAppInfo;
            if (f.this.bqc != null) {
                f.this.a(f.this.bqc);
                com.baidu.swan.apps.ag.g.b.x(f.this.bqc.pluginInfo, true);
                if (f.this.bqd != null) {
                    f.this.bqd.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.d.c.a(f.this.bqc.iconUrl, f.this.bqc.appCategory, new c.a() { // from class: com.baidu.swan.apps.core.pms.f.10.1
                    @Override // com.baidu.swan.apps.core.pms.d.c.a
                    public void h(Bitmap bitmap) {
                        if (f.this.bqd != null) {
                            f.this.bqd.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> bql = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.2
        @Override // rx.e
        public void onCompleted() {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.Pp() + " : 包下载onCompleted");
            }
            f.this.Po();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.Pp() + " : 包下载OnError：" + th.toString());
            }
            f.this.m(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.Pp() + " : 单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> bqd = new ArrayList();

    protected abstract void Po();

    protected abstract PMSDownloadType Pp();

    protected abstract void m(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Nb() {
        this.bqd.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pm() {
        this.bqd.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        }
        if (aVar != null && aVar.errorNo == 1010) {
            Pw();
        }
        this.bqd.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + eVar.aut());
            }
            this.bqd.add(new UbcFlowEvent("na_pms_start_download"));
            this.bpM = eVar;
            if (!this.bpM.isEmpty()) {
                Pz();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> Pq() {
        return this.bqg;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> Pr() {
        return this.bqh;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> Ps() {
        return this.bqi;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> Pt() {
        return this.bqj;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f Pu() {
        return this.bqk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Pv() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int Nc() {
        return 100;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.apps.x.c.a iM = com.baidu.swan.apps.x.c.a.iM(Pv());
        iM.Wj().fm(1);
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.ap.a b = com.baidu.swan.apps.core.pms.d.a.b(fVar);
        iM.iN("CostRenameZip: " + (System.currentTimeMillis() - currentTimeMillis));
        return b;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.g gVar) {
        if (!ab.d(new File(gVar.filePath), gVar.sign)) {
            return new com.baidu.swan.apps.ap.a().aI(12L).aK(2300L).my("分包签名校验失败");
        }
        if (!com.baidu.swan.apps.core.pms.d.b.i(gVar)) {
            return new com.baidu.swan.apps.ap.a().aI(12L).aK(2320L).my("分包解压失败");
        }
        return null;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0300a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aI(13L).aK(2907L).my("Core包更新失败");
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.bvh = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(bVar.category, aVar)) {
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aI(14L).aK(2908L).my("Extension包更新失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eH(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.atv().Q(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.atv().Q(this.mAppId, 0);
        }
    }

    private void Pw() {
        PMSAppInfo qo = com.baidu.swan.pms.database.a.atv().qo(this.mAppId);
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "updateMainMaxageTime: localAppInfo = " + qo);
        }
        if (qo != null) {
            qo.atI();
            if (this.bpY != null) {
                this.bpY.createTime = qo.createTime;
            }
            if (this.bqc != null) {
                this.bqc.createTime = qo.createTime;
            }
            com.baidu.swan.pms.database.a.atv().m(qo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.ap.a Px() {
        if (this.bqc == null) {
            if (this.bpY == null) {
                return new com.baidu.swan.apps.ap.a().aI(10L).aJ(2903L).my("Server未返回主包&AppInfo");
            }
            PMSAppInfo qo = com.baidu.swan.pms.database.a.atv().qo(this.mAppId);
            if (qo == null) {
                return new com.baidu.swan.apps.ap.a().aI(10L).aJ(2904L).my("Server未返回AppInfo数据，本地也没有数据");
            }
            this.bqc = qo;
            com.baidu.swan.apps.core.pms.d.a.a(this.bqc, this.bpY);
            this.bqc.atI();
            if (com.baidu.swan.pms.database.a.atv().a(this.bpY, this.bpZ, this.bqa, this.bqb, this.bqc)) {
                return null;
            }
            return new com.baidu.swan.apps.ap.a().aI(10L).aJ(2906L).my("更新DB失败");
        }
        if (this.bpY != null) {
            com.baidu.swan.apps.core.pms.d.a.a(this.bqc, this.bpY);
        } else if (com.baidu.swan.apps.core.pms.d.b.L(this.bpZ)) {
            this.bqf = this.bpZ.get(0);
            this.bqf.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.d.a.a(this.bqc, this.bqf);
        } else {
            PMSAppInfo qo2 = com.baidu.swan.pms.database.a.atv().qo(this.mAppId);
            if (qo2 == null) {
                return new com.baidu.swan.apps.ap.a().aI(10L).aJ(2905L).my("Server未返回包数据，本地也没有数据");
            }
            this.bqc.appId = this.mAppId;
            this.bqc.o(qo2);
        }
        this.bqc.atI();
        if (com.baidu.swan.pms.database.a.atv().a(this.bpY, this.bpZ, this.bqa, this.bqb, this.bqc)) {
            com.baidu.swan.apps.core.pms.d.a.d(this.bqc);
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aI(10L).aJ(2906L).my("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Py() {
        if (this.bqc != null) {
            PMSAppInfo qo = com.baidu.swan.pms.database.a.atv().qo(this.mAppId);
            if (qo == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", getClassName() + ": Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.bqc.appId = this.mAppId;
            this.bqc.o(qo);
            if (this.bqc.aja()) {
                this.bqc.atI();
            }
            if (com.baidu.swan.pms.database.a.atv().m(this.bqc)) {
                com.baidu.swan.apps.core.pms.d.a.d(this.bqc);
            }
        }
    }

    public void a(PMSAppInfo pMSAppInfo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        c.Pk().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.11
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.bpY = fVar;
                f.this.bpM.g(fVar);
                if (f.this.bpU != null) {
                    f.this.bpU.onNext(fVar);
                    f.this.bpU.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bpM.f(fVar);
                if (f.this.bpU != null) {
                    f.this.bpU.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.Pk().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.12
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.bpZ == null) {
                    f.this.bpZ = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.bpZ.add(gVar);
                f.this.bpM.g(gVar);
                if (f.this.bpV != null) {
                    f.this.bpV.onNext(gVar);
                    if (!f.this.bpM.auy()) {
                        f.this.bpV.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bpM.f(gVar);
                if (f.this.bpV != null) {
                    f.this.bpV.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.Pk().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.13
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.bqa = dVar;
                f.this.bpM.g(dVar);
                if (f.this.bpW != null) {
                    f.this.bpW.onNext(dVar);
                    f.this.bpW.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bpM.f(dVar);
                if (f.this.bpW != null) {
                    f.this.bpW.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.Pk().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.14
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onSuccess ：" + pMSDownloadType);
                }
                f.this.bqb = bVar;
                f.this.bpM.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                }
                f.this.bpM.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.bpX != null) {
            this.bpX.onNext(bVar);
            this.bpX.onCompleted();
        }
    }

    private void Pz() {
        ArrayList arrayList = new ArrayList();
        if (this.bpM.auu()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.bpU = jVar;
                }
            }));
        }
        if (this.bpM.auv()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.bpV = jVar;
                }
            }));
        }
        if (this.bpM.auw()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.bpW = jVar;
                }
            }));
        }
        if (this.bpM.aux()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.bpX = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.m(arrayList).b(this.bql);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aB(String str, String str2) {
        com.baidu.swan.apps.performance.c.a.a(this.mAppId, str, this.bqd, str2);
        this.bqd.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
