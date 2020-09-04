package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.aq;
import com.baidu.swan.apps.core.pms.c;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.swancore.d.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okio.BufferedSource;
import rx.d;
/* loaded from: classes8.dex */
public abstract class f extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.pms.utils.f ckd;
    protected List<com.baidu.swan.pms.model.g> ckf;
    private rx.j<? super com.baidu.swan.pms.model.f> ckn;
    private rx.j<? super com.baidu.swan.pms.model.g> cko;
    private rx.j<? super com.baidu.swan.pms.model.d> ckp;
    private rx.j<? super com.baidu.swan.pms.model.b> ckq;
    protected com.baidu.swan.pms.model.f ckr;
    protected com.baidu.swan.pms.model.d cks;
    protected com.baidu.swan.pms.model.b ckt;
    protected PMSAppInfo cku;
    protected com.baidu.swan.pms.model.g ckx;
    protected String mAppId;
    private String mClassName = "";
    protected String ckw = "0";
    private long cky = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> ckz = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>> ckA = new HashSet();
    private final aq ckB = new aq();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> ckC = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String Q(com.baidu.swan.pms.model.f fVar) {
            if (fVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.aiS();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aiT();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.afE();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void O(com.baidu.swan.pms.model.f fVar) {
            String aiF = f.this.aiF();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.nR(aiF).aro().m34if(1);
            }
            super.O(fVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void P(com.baidu.swan.pms.model.f fVar) {
            String aiF = f.this.aiF();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.nR(aiF).aro().m34if(1);
            }
            super.P(fVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onDownloading");
            }
            f.this.b(fVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.f fVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) fVar, aVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.ckd.f(fVar);
            com.baidu.swan.apps.am.a sn = new com.baidu.swan.apps.am.a().bO(11L).bP(aVar.errorNo).sl("主包下载失败").sn(aVar.toString());
            if (f.this.ckn != null) {
                f.this.ckn.onError(new PkgDownloadError(fVar, sn));
            }
            c.ait().a(fVar, f.this.aiA(), sn);
            com.baidu.swan.c.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void M(com.baidu.swan.pms.model.f fVar) {
            String aiF = f.this.aiF();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.nR(aiF).aro().m34if(1);
            }
            super.M(fVar);
            f.this.ckv.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.am.a a = f.this.a(fVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.versionCode);
            if (a == null) {
                f.this.ckr = fVar;
                f.this.ckd.g(fVar);
                if (f.this.ckn != null) {
                    f.this.ckn.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.ckn.onCompleted();
                }
                c.ait().a(fVar, f.this.aiA());
                return;
            }
            f.this.ckd.f(fVar);
            if (f.this.ckn != null) {
                f.this.ckn.onError(new PkgDownloadError(fVar, a));
            }
            c.ait().a(fVar, f.this.aiA(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String aiF = f.this.aiF();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.nR(aiF).nS(fVar.toString()).m34if(1);
            }
            com.baidu.swan.apps.ap.e.b<i.a> bVar = new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.core.pms.f.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void I(i.a aVar) {
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
            com.baidu.swan.apps.r.f fVar2 = new com.baidu.swan.apps.r.f();
            fVar2.v(bVar);
            boolean isOk = fVar2.A(bundle).a(new com.baidu.swan.apps.r.e(fVar, f.this)).a(new com.baidu.swan.apps.r.c(fVar.sign, f.this)).a(bufferedSource).isOk();
            fVar2.w(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onProcessStream: installOk=" + isOk);
            }
            if (isOk) {
                com.baidu.swan.c.d.deleteFile(file);
            }
            return isOk ? new com.baidu.swan.pms.model.a(2300, "业务层处理下载流成功") : new com.baidu.swan.pms.model.a(PushConstants.DOWN_LOAD_LARGE_ICON_SUCCESS, "业务层处理下载流失败");
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> ckh = new k<f>(this) { // from class: com.baidu.swan.apps.core.pms.f.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.afE();
        }

        @Override // com.baidu.swan.apps.core.pms.k
        public String getAppKey() {
            return f.this.mAppId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void O(com.baidu.swan.pms.model.g gVar) {
            super.O(gVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "sub onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void P(com.baidu.swan.pms.model.g gVar) {
            super.P(gVar);
            f.this.b(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.g gVar, com.baidu.swan.pms.model.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.ckd.f(gVar);
            com.baidu.swan.apps.am.a sn = new com.baidu.swan.apps.am.a().bO(12L).bP(aVar.errorNo).sl("分包下载失败").sn(aVar.toString());
            if (f.this.cko != null) {
                f.this.cko.onError(new PkgDownloadError(gVar, sn));
            }
            c.ait().a(gVar, f.this.aiA(), sn);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k
        public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.versionCode);
            if (f.this.ckf == null) {
                f.this.ckf = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            if (aVar == null) {
                f.this.ckf.add(gVar);
                f.this.ckd.g(gVar);
                c.ait().a(gVar, f.this.aiA());
            } else {
                f.this.ckd.f(gVar);
                c.ait().a(gVar, f.this.aiA(), aVar);
            }
            if (f.this.cko != null) {
                f.this.cko.onNext(gVar);
                if (!f.this.ckd.aUQ()) {
                    f.this.cko.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> ckD = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String Q(com.baidu.swan.pms.model.d dVar) {
            if (dVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.aiU();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aiV();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.afE();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void O(com.baidu.swan.pms.model.d dVar) {
            super.O(dVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "framework onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void P(com.baidu.swan.pms.model.d dVar) {
            super.P(dVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": framework onDownloading");
            }
            f.this.b(dVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass15) dVar, aVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.ckd.f(dVar);
            com.baidu.swan.apps.am.a sn = new com.baidu.swan.apps.am.a().bO(13L).bP(aVar.errorNo).sl("Framework包下载失败").sn(aVar.toString());
            if (f.this.ckp != null) {
                f.this.ckp.onError(new PkgDownloadError(dVar, sn));
            }
            c.ait().a(dVar, f.this.aiA(), sn);
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void M(com.baidu.swan.pms.model.d dVar) {
            super.M(dVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.versionCode);
            com.baidu.swan.apps.am.a a = f.this.a(dVar);
            if (a == null) {
                f.this.cks = dVar;
                f.this.ckd.g(dVar);
                if (f.this.ckp != null) {
                    f.this.ckp.onNext(dVar);
                    f.this.ckp.onCompleted();
                }
                c.ait().a(dVar, f.this.aiA());
                return;
            }
            f.this.ckd.f(dVar);
            if (f.this.ckp != null) {
                f.this.ckp.onError(new PkgDownloadError(dVar, a));
            }
            c.ait().a(dVar, f.this.aiA(), a);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> ckE = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String Q(com.baidu.swan.pms.model.b bVar) {
            if (bVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.aiM();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aiW();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.afE();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void O(com.baidu.swan.pms.model.b bVar) {
            super.O(bVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "extension onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void P(com.baidu.swan.pms.model.b bVar) {
            super.P(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": extension onDownloading");
            }
            f.this.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass16) bVar, aVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.ckd.f(bVar);
            com.baidu.swan.apps.am.a sn = new com.baidu.swan.apps.am.a().bO(14L).bP(aVar.errorNo).sl("Extension下载失败").sn(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", sn.toString());
            }
            f.this.c(bVar);
            c.ait().a(bVar, f.this.aiA(), sn);
            com.baidu.swan.c.d.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void M(com.baidu.swan.pms.model.b bVar) {
            super.M(bVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.versionCode);
            com.baidu.swan.apps.am.a a = f.this.a(bVar);
            if (a != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.ckd.f(bVar);
                f.this.c(bVar);
                c.ait().a(bVar, f.this.aiA(), a);
                return;
            }
            f.this.ckt = bVar;
            f.this.ckd.g(bVar);
            f.this.c(bVar);
            c.ait().a(bVar, f.this.aiA());
        }
    };
    private com.baidu.swan.pms.a.f ckF = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void e(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.cku = pMSAppInfo;
            if (f.this.cku != null) {
                f.this.c(f.this.cku);
                com.baidu.swan.apps.ac.g.b.U(f.this.cku.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> ckG = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", f.this.aiA() + " : 包下载onCompleted");
            f.this.aiz();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            com.baidu.swan.apps.console.c.f("SwanAppPkgDownloadCallback", f.this.aiA() + " : 包下载OnError", th);
            f.this.o(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", f.this.aiA() + " : 单个包下载、业务层处理完成：" + eVar.versionCode);
        }
    };
    protected List<UbcFlowEvent> ckv = new ArrayList();

    protected abstract PMSDownloadType aiA();

    protected abstract void o(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void afD() {
        this.ckv.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiw() {
        this.ckv.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.errorNo == 1010) {
            aiG();
        }
        this.ckv.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cky = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.cky);
        }
        if (fVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + fVar.aUK());
            }
            this.ckv.add(new UbcFlowEvent("na_pms_start_download"));
            this.ckd = fVar;
            if (!this.ckd.isEmpty()) {
                aiJ();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> aiB() {
        return this.ckC;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aiy() {
        return this.ckh;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> aiC() {
        return this.ckD;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> aiD() {
        return this.ckE;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f aiE() {
        return this.ckF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aiF() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int afE() {
        return 100;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.f fVar) {
        if (fVar == null) {
            com.baidu.swan.apps.am.a sn = new com.baidu.swan.apps.am.a().bO(11L).bP(2310L).sn("pkg info is empty");
            com.baidu.swan.apps.am.e.aEg().j(sn);
            return sn;
        }
        return null;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0450a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.am.a().bO(13L).bQ(2907L).sl("Core包更新失败");
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.crC = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.am.a().bO(14L).bQ(2908L).sl("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hi(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.aTt().ab(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.aTt().ab(this.mAppId, 0);
        }
    }

    private void aiG() {
        PMSAppInfo wA = com.baidu.swan.pms.database.a.aTt().wA(this.mAppId);
        com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + wA.createTime + " lastLaunchTime=" + wA.getLastLaunchTime() + " maxAge=" + wA.maxAge);
        if (wA != null) {
            wA.aTE();
            wA.lO(aiN());
            if (this.ckr != null) {
                this.ckr.createTime = wA.createTime;
            }
            if (this.cku != null) {
                this.cku.createTime = wA.createTime;
                this.cku.lO(aiN());
            }
            com.baidu.swan.pms.database.a.aTt().r(wA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.am.a aiH() {
        if (this.cku == null) {
            if (this.ckr == null) {
                return new com.baidu.swan.apps.am.a().bO(10L).bP(2903L).sl("Server未返回主包&AppInfo");
            }
            PMSAppInfo wA = com.baidu.swan.pms.database.a.aTt().wA(this.mAppId);
            if (wA == null) {
                return new com.baidu.swan.apps.am.a().bO(10L).bP(2904L).sl("Server未返回AppInfo数据，本地也没有数据");
            }
            this.cku = wA;
            com.baidu.swan.apps.core.pms.f.a.a(this.cku, this.ckr);
            this.cku.aTE();
            this.cku.lO(aiN());
            if (com.baidu.swan.pms.database.a.aTt().a(this.ckr, this.ckf, this.cks, this.ckt, this.cku)) {
                return null;
            }
            return new com.baidu.swan.apps.am.a().bO(10L).bP(2906L).sl("更新DB失败");
        }
        if (this.ckr != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.cku, this.ckr);
        } else if (com.baidu.swan.apps.core.pms.f.b.Z(this.ckf)) {
            this.ckx = this.ckf.get(0);
            this.ckx.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.cku, this.ckx);
        } else {
            PMSAppInfo wA2 = com.baidu.swan.pms.database.a.aTt().wA(this.mAppId);
            if (wA2 == null) {
                return new com.baidu.swan.apps.am.a().bO(10L).bP(2905L).sl("Server未返回包数据，本地也没有数据");
            }
            this.cku.appId = this.mAppId;
            this.cku.u(wA2);
        }
        this.cku.aTE();
        this.cku.lO(aiN());
        if (com.baidu.swan.pms.database.a.aTt().a(this.ckr, this.ckf, this.cks, this.ckt, this.cku)) {
            com.baidu.swan.apps.core.pms.f.a.g(this.cku);
            return null;
        }
        return new com.baidu.swan.apps.am.a().bO(10L).bP(2906L).sl("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiI() {
        if (this.cku != null) {
            PMSAppInfo wA = com.baidu.swan.pms.database.a.aTt().wA(this.mAppId);
            if (wA == null) {
                com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                return;
            }
            this.cku.appId = this.mAppId;
            wA.lO(aiN());
            this.cku.u(wA);
            this.cku.aTE();
            if (com.baidu.swan.pms.database.a.aTt().r(this.cku)) {
                com.baidu.swan.apps.core.pms.f.a.g(this.cku);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiz() {
        com.baidu.swan.apps.console.c.i("SwanAppPkgDownloadCallback", "pms download time : " + (System.currentTimeMillis() - this.cky));
    }

    public f c(com.baidu.swan.apps.ap.e.b<PMSAppInfo> bVar) {
        return a((Collection<Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>>) this.ckA, (Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>) bVar);
    }

    protected f c(final PMSAppInfo pMSAppInfo) {
        return a((Collection) this.ckA, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: e */
            public void I(com.baidu.swan.apps.ap.e.b<PMSAppInfo> bVar) {
                bVar.I(pMSAppInfo);
            }
        });
    }

    private synchronized <CallbackT> f a(final Collection<CallbackT> collection, final CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.ckB.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
                @Override // java.lang.Runnable
                public void run() {
                    collection.add(callbackt);
                }
            });
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized <CallbackT> f b(final Collection<CallbackT> collection, final CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.ckB.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.ap.e.b<CallbackT> bVar) {
        this.ckB.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : collection) {
                    bVar.I(obj);
                }
            }
        });
        return this;
    }

    public synchronized f a(com.baidu.swan.apps.core.pms.a.a aVar) {
        return a(this.ckz, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f d(@NonNull final com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a((Collection) this.ckz, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void I(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.I(aVar);
                f.this.b((Collection<Set>) f.this.ckz, (Set) aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final com.baidu.swan.apps.am.a aVar, final boolean z) {
        d(new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void I(com.baidu.swan.apps.core.pms.a.a aVar2) {
                aVar2.b(aVar, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(final PMSAppInfo pMSAppInfo) {
        d(new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void I(com.baidu.swan.apps.core.pms.a.a aVar) {
                aVar.f(pMSAppInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        c.ait().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.ckr = fVar;
                f.this.ckd.g(fVar);
                if (f.this.ckn != null) {
                    f.this.ckn.onNext(fVar);
                    f.this.ckn.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.ckd.f(fVar);
                if (f.this.ckn != null) {
                    f.this.ckn.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.ait().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.ckf == null) {
                    f.this.ckf = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.ckf.add(gVar);
                f.this.ckd.g(gVar);
                if (f.this.cko != null) {
                    f.this.cko.onNext(gVar);
                    if (!f.this.ckd.aUQ()) {
                        f.this.cko.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.ckd.f(gVar);
                if (f.this.cko != null) {
                    f.this.cko.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.ait().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cks = dVar;
                f.this.ckd.g(dVar);
                if (f.this.ckp != null) {
                    f.this.ckp.onNext(dVar);
                    f.this.ckp.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.ckd.f(dVar);
                if (f.this.ckp != null) {
                    f.this.ckp.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.ait().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f.this.ckt = bVar;
                f.this.ckd.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                f.this.ckd.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.ckq != null) {
            this.ckq.onNext(bVar);
            this.ckq.onCompleted();
        }
    }

    private void aiJ() {
        ArrayList arrayList = new ArrayList();
        if (this.ckd.aUL()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.ckn = jVar;
                }
            }));
        }
        if (this.ckd.aUM()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.cko = jVar;
                }
            }));
        }
        if (this.ckd.aUO()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.ckp = jVar;
                }
            }));
        }
        if (this.ckd.aUP()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.ckq = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.ckG);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bm(String str, String str2) {
        com.baidu.swan.apps.performance.f.a.a(this.mAppId, str, this.ckv, str2);
        this.ckv.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
