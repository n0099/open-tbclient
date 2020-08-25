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
    protected com.baidu.swan.pms.utils.f cjZ;
    protected List<com.baidu.swan.pms.model.g> ckb;
    private rx.j<? super com.baidu.swan.pms.model.f> ckj;
    private rx.j<? super com.baidu.swan.pms.model.g> ckk;
    private rx.j<? super com.baidu.swan.pms.model.d> ckl;
    private rx.j<? super com.baidu.swan.pms.model.b> ckm;
    protected com.baidu.swan.pms.model.f ckn;
    protected com.baidu.swan.pms.model.d cko;
    protected com.baidu.swan.pms.model.b ckp;
    protected PMSAppInfo ckq;
    protected com.baidu.swan.pms.model.g ckt;
    protected String mAppId;
    private String mClassName = "";
    protected String cks = "0";
    private long cku = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> ckv = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>> ckw = new HashSet();
    private final aq ckx = new aq();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> cky = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
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
                com.baidu.swan.apps.u.e.a.nQ(aiF).aro().m34if(1);
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
                com.baidu.swan.apps.u.e.a.nQ(aiF).aro().m34if(1);
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
            f.this.cjZ.f(fVar);
            com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(11L).bP(aVar.errorNo).sk("主包下载失败").sm(aVar.toString());
            if (f.this.ckj != null) {
                f.this.ckj.onError(new PkgDownloadError(fVar, sm));
            }
            c.ait().a(fVar, f.this.aiA(), sm);
            com.baidu.swan.c.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void M(com.baidu.swan.pms.model.f fVar) {
            String aiF = f.this.aiF();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.nQ(aiF).aro().m34if(1);
            }
            super.M(fVar);
            f.this.ckr.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.am.a a = f.this.a(fVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.versionCode);
            if (a == null) {
                f.this.ckn = fVar;
                f.this.cjZ.g(fVar);
                if (f.this.ckj != null) {
                    f.this.ckj.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.ckj.onCompleted();
                }
                c.ait().a(fVar, f.this.aiA());
                return;
            }
            f.this.cjZ.f(fVar);
            if (f.this.ckj != null) {
                f.this.ckj.onError(new PkgDownloadError(fVar, a));
            }
            c.ait().a(fVar, f.this.aiA(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String aiF = f.this.aiF();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.nQ(aiF).nR(fVar.toString()).m34if(1);
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> ckd = new k<f>(this) { // from class: com.baidu.swan.apps.core.pms.f.12
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
            f.this.cjZ.f(gVar);
            com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(12L).bP(aVar.errorNo).sk("分包下载失败").sm(aVar.toString());
            if (f.this.ckk != null) {
                f.this.ckk.onError(new PkgDownloadError(gVar, sm));
            }
            c.ait().a(gVar, f.this.aiA(), sm);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k
        public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.versionCode);
            if (f.this.ckb == null) {
                f.this.ckb = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            if (aVar == null) {
                f.this.ckb.add(gVar);
                f.this.cjZ.g(gVar);
                c.ait().a(gVar, f.this.aiA());
            } else {
                f.this.cjZ.f(gVar);
                c.ait().a(gVar, f.this.aiA(), aVar);
            }
            if (f.this.ckk != null) {
                f.this.ckk.onNext(gVar);
                if (!f.this.cjZ.aUQ()) {
                    f.this.ckk.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> ckz = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
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
            f.this.cjZ.f(dVar);
            com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(13L).bP(aVar.errorNo).sk("Framework包下载失败").sm(aVar.toString());
            if (f.this.ckl != null) {
                f.this.ckl.onError(new PkgDownloadError(dVar, sm));
            }
            c.ait().a(dVar, f.this.aiA(), sm);
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
                f.this.cko = dVar;
                f.this.cjZ.g(dVar);
                if (f.this.ckl != null) {
                    f.this.ckl.onNext(dVar);
                    f.this.ckl.onCompleted();
                }
                c.ait().a(dVar, f.this.aiA());
                return;
            }
            f.this.cjZ.f(dVar);
            if (f.this.ckl != null) {
                f.this.ckl.onError(new PkgDownloadError(dVar, a));
            }
            c.ait().a(dVar, f.this.aiA(), a);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> ckA = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
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
            f.this.cjZ.f(bVar);
            com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(14L).bP(aVar.errorNo).sk("Extension下载失败").sm(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", sm.toString());
            }
            f.this.c(bVar);
            c.ait().a(bVar, f.this.aiA(), sm);
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
                f.this.cjZ.f(bVar);
                f.this.c(bVar);
                c.ait().a(bVar, f.this.aiA(), a);
                return;
            }
            f.this.ckp = bVar;
            f.this.cjZ.g(bVar);
            f.this.c(bVar);
            c.ait().a(bVar, f.this.aiA());
        }
    };
    private com.baidu.swan.pms.a.f ckB = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void e(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.ckq = pMSAppInfo;
            if (f.this.ckq != null) {
                f.this.c(f.this.ckq);
                com.baidu.swan.apps.ac.g.b.U(f.this.ckq.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> ckC = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
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
    protected List<UbcFlowEvent> ckr = new ArrayList();

    protected abstract PMSDownloadType aiA();

    protected abstract void o(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void afD() {
        this.ckr.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiw() {
        this.ckr.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.errorNo == 1010) {
            aiG();
        }
        this.ckr.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cku = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.cku);
        }
        if (fVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + fVar.aUK());
            }
            this.ckr.add(new UbcFlowEvent("na_pms_start_download"));
            this.cjZ = fVar;
            if (!this.cjZ.isEmpty()) {
                aiJ();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> aiB() {
        return this.cky;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aiy() {
        return this.ckd;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> aiC() {
        return this.ckz;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> aiD() {
        return this.ckA;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f aiE() {
        return this.ckB;
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
            com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(11L).bP(2310L).sm("pkg info is empty");
            com.baidu.swan.apps.am.e.aEg().j(sm);
            return sm;
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
        return new com.baidu.swan.apps.am.a().bO(13L).bQ(2907L).sk("Core包更新失败");
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cry = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.am.a().bO(14L).bQ(2908L).sk("Extension包更新失败");
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
        PMSAppInfo wz = com.baidu.swan.pms.database.a.aTt().wz(this.mAppId);
        com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + wz.createTime + " lastLaunchTime=" + wz.getLastLaunchTime() + " maxAge=" + wz.maxAge);
        if (wz != null) {
            wz.aTE();
            wz.lO(aiN());
            if (this.ckn != null) {
                this.ckn.createTime = wz.createTime;
            }
            if (this.ckq != null) {
                this.ckq.createTime = wz.createTime;
                this.ckq.lO(aiN());
            }
            com.baidu.swan.pms.database.a.aTt().r(wz);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.am.a aiH() {
        if (this.ckq == null) {
            if (this.ckn == null) {
                return new com.baidu.swan.apps.am.a().bO(10L).bP(2903L).sk("Server未返回主包&AppInfo");
            }
            PMSAppInfo wz = com.baidu.swan.pms.database.a.aTt().wz(this.mAppId);
            if (wz == null) {
                return new com.baidu.swan.apps.am.a().bO(10L).bP(2904L).sk("Server未返回AppInfo数据，本地也没有数据");
            }
            this.ckq = wz;
            com.baidu.swan.apps.core.pms.f.a.a(this.ckq, this.ckn);
            this.ckq.aTE();
            this.ckq.lO(aiN());
            if (com.baidu.swan.pms.database.a.aTt().a(this.ckn, this.ckb, this.cko, this.ckp, this.ckq)) {
                return null;
            }
            return new com.baidu.swan.apps.am.a().bO(10L).bP(2906L).sk("更新DB失败");
        }
        if (this.ckn != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.ckq, this.ckn);
        } else if (com.baidu.swan.apps.core.pms.f.b.Z(this.ckb)) {
            this.ckt = this.ckb.get(0);
            this.ckt.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.ckq, this.ckt);
        } else {
            PMSAppInfo wz2 = com.baidu.swan.pms.database.a.aTt().wz(this.mAppId);
            if (wz2 == null) {
                return new com.baidu.swan.apps.am.a().bO(10L).bP(2905L).sk("Server未返回包数据，本地也没有数据");
            }
            this.ckq.appId = this.mAppId;
            this.ckq.u(wz2);
        }
        this.ckq.aTE();
        this.ckq.lO(aiN());
        if (com.baidu.swan.pms.database.a.aTt().a(this.ckn, this.ckb, this.cko, this.ckp, this.ckq)) {
            com.baidu.swan.apps.core.pms.f.a.g(this.ckq);
            return null;
        }
        return new com.baidu.swan.apps.am.a().bO(10L).bP(2906L).sk("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiI() {
        if (this.ckq != null) {
            PMSAppInfo wz = com.baidu.swan.pms.database.a.aTt().wz(this.mAppId);
            if (wz == null) {
                com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                return;
            }
            this.ckq.appId = this.mAppId;
            wz.lO(aiN());
            this.ckq.u(wz);
            this.ckq.aTE();
            if (com.baidu.swan.pms.database.a.aTt().r(this.ckq)) {
                com.baidu.swan.apps.core.pms.f.a.g(this.ckq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiz() {
        com.baidu.swan.apps.console.c.i("SwanAppPkgDownloadCallback", "pms download time : " + (System.currentTimeMillis() - this.cku));
    }

    public f c(com.baidu.swan.apps.ap.e.b<PMSAppInfo> bVar) {
        return a((Collection<Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>>) this.ckw, (Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>) bVar);
    }

    protected f c(final PMSAppInfo pMSAppInfo) {
        return a((Collection) this.ckw, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
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
            this.ckx.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
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
            this.ckx.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.ap.e.b<CallbackT> bVar) {
        this.ckx.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
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
        return a(this.ckv, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f d(@NonNull final com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a((Collection) this.ckv, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void I(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.I(aVar);
                f.this.b((Collection<Set>) f.this.ckv, (Set) aVar);
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
                f.this.ckn = fVar;
                f.this.cjZ.g(fVar);
                if (f.this.ckj != null) {
                    f.this.ckj.onNext(fVar);
                    f.this.ckj.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cjZ.f(fVar);
                if (f.this.ckj != null) {
                    f.this.ckj.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.ait().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.ckb == null) {
                    f.this.ckb = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.ckb.add(gVar);
                f.this.cjZ.g(gVar);
                if (f.this.ckk != null) {
                    f.this.ckk.onNext(gVar);
                    if (!f.this.cjZ.aUQ()) {
                        f.this.ckk.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cjZ.f(gVar);
                if (f.this.ckk != null) {
                    f.this.ckk.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.ait().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cko = dVar;
                f.this.cjZ.g(dVar);
                if (f.this.ckl != null) {
                    f.this.ckl.onNext(dVar);
                    f.this.ckl.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cjZ.f(dVar);
                if (f.this.ckl != null) {
                    f.this.ckl.onError(new PkgDownloadError(dVar, aVar));
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
                f.this.ckp = bVar;
                f.this.cjZ.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                f.this.cjZ.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.ckm != null) {
            this.ckm.onNext(bVar);
            this.ckm.onCompleted();
        }
    }

    private void aiJ() {
        ArrayList arrayList = new ArrayList();
        if (this.cjZ.aUL()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.ckj = jVar;
                }
            }));
        }
        if (this.cjZ.aUM()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.ckk = jVar;
                }
            }));
        }
        if (this.cjZ.aUO()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.ckl = jVar;
                }
            }));
        }
        if (this.cjZ.aUP()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.ckm = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.ckC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bm(String str, String str2) {
        com.baidu.swan.apps.performance.f.a.a(this.mAppId, str, this.ckr, str2);
        this.ckr.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
