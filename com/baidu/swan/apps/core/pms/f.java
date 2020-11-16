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
/* loaded from: classes7.dex */
public abstract class f extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.pms.utils.f cLb;
    protected List<com.baidu.swan.pms.model.g> cLd;
    private rx.j<? super com.baidu.swan.pms.model.f> cLl;
    private rx.j<? super com.baidu.swan.pms.model.g> cLm;
    private rx.j<? super com.baidu.swan.pms.model.d> cLn;
    private rx.j<? super com.baidu.swan.pms.model.b> cLo;
    protected com.baidu.swan.pms.model.f cLp;
    protected com.baidu.swan.pms.model.d cLq;
    protected com.baidu.swan.pms.model.b cLr;
    protected PMSAppInfo cLs;
    protected com.baidu.swan.pms.model.g cLv;
    protected String mAppId;
    private String mClassName = "";
    protected String cLu = "0";
    private long cLw = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> cLx = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>> cLy = new HashSet();
    private final aq cLz = new aq();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> cLA = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String U(com.baidu.swan.pms.model.f fVar) {
            if (fVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.aqa();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aqb();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.amL();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.f fVar) {
            String apN = f.this.apN();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pz(apN).ayw().jd(1);
            }
            super.S(fVar);
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void T(com.baidu.swan.pms.model.f fVar) {
            String apN = f.this.apN();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pz(apN).ayw().jd(1);
            }
            super.T(fVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onDownloading");
            }
            f.this.b(fVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.f fVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) fVar, aVar);
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.cLb.f(fVar);
            com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(11L).cw(aVar.errorNo).tT("主包下载失败").tV(aVar.toString());
            if (f.this.cLl != null) {
                f.this.cLl.onError(new PkgDownloadError(fVar, tV));
            }
            c.apB().a(fVar, f.this.apI(), tV);
            com.baidu.swan.c.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.f fVar) {
            String apN = f.this.apN();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pz(apN).ayw().jd(1);
            }
            super.Q(fVar);
            f.this.cLt.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.am.a a2 = f.this.a(fVar);
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.versionCode);
            if (a2 == null) {
                f.this.cLp = fVar;
                f.this.cLb.g(fVar);
                if (f.this.cLl != null) {
                    f.this.cLl.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.cLl.onCompleted();
                }
                c.apB().a(fVar, f.this.apI());
                return;
            }
            f.this.cLb.f(fVar);
            if (f.this.cLl != null) {
                f.this.cLl.onError(new PkgDownloadError(fVar, a2));
            }
            c.apB().a(fVar, f.this.apI(), a2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String apN = f.this.apN();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pz(apN).pA(fVar.toString()).jd(1);
            }
            com.baidu.swan.apps.ap.e.b<i.a> bVar = new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.core.pms.f.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void M(i.a aVar) {
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cLf = new k<f>(this) { // from class: com.baidu.swan.apps.core.pms.f.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.amL();
        }

        @Override // com.baidu.swan.apps.core.pms.k
        public String getAppKey() {
            return f.this.mAppId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void S(com.baidu.swan.pms.model.g gVar) {
            super.S(gVar);
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "sub onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void T(com.baidu.swan.pms.model.g gVar) {
            super.T(gVar);
            f.this.b(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.g gVar, com.baidu.swan.pms.model.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.cLb.f(gVar);
            com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(12L).cw(aVar.errorNo).tT("分包下载失败").tV(aVar.toString());
            if (f.this.cLm != null) {
                f.this.cLm.onError(new PkgDownloadError(gVar, tV));
            }
            c.apB().a(gVar, f.this.apI(), tV);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k
        public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.versionCode);
            if (f.this.cLd == null) {
                f.this.cLd = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            if (aVar == null) {
                f.this.cLd.add(gVar);
                f.this.cLb.g(gVar);
                c.apB().a(gVar, f.this.apI());
            } else {
                f.this.cLb.f(gVar);
                c.apB().a(gVar, f.this.apI(), aVar);
            }
            if (f.this.cLm != null) {
                f.this.cLm.onNext(gVar);
                if (!f.this.cLb.bbX()) {
                    f.this.cLm.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cLB = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String U(com.baidu.swan.pms.model.d dVar) {
            if (dVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.aqc();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aqd();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.amL();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.d dVar) {
            super.S(dVar);
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "framework onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void T(com.baidu.swan.pms.model.d dVar) {
            super.T(dVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": framework onDownloading");
            }
            f.this.b(dVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass15) dVar, aVar);
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.cLb.f(dVar);
            com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(13L).cw(aVar.errorNo).tT("Framework包下载失败").tV(aVar.toString());
            if (f.this.cLn != null) {
                f.this.cLn.onError(new PkgDownloadError(dVar, tV));
            }
            c.apB().a(dVar, f.this.apI(), tV);
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.d dVar) {
            super.Q(dVar);
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.versionCode);
            com.baidu.swan.apps.am.a a2 = f.this.a(dVar);
            if (a2 == null) {
                f.this.cLq = dVar;
                f.this.cLb.g(dVar);
                if (f.this.cLn != null) {
                    f.this.cLn.onNext(dVar);
                    f.this.cLn.onCompleted();
                }
                c.apB().a(dVar, f.this.apI());
                return;
            }
            f.this.cLb.f(dVar);
            if (f.this.cLn != null) {
                f.this.cLn.onError(new PkgDownloadError(dVar, a2));
            }
            c.apB().a(dVar, f.this.apI(), a2);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cLC = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String U(com.baidu.swan.pms.model.b bVar) {
            if (bVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.apU();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aqe();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.amL();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void S(com.baidu.swan.pms.model.b bVar) {
            super.S(bVar);
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "extension onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void T(com.baidu.swan.pms.model.b bVar) {
            super.T(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": extension onDownloading");
            }
            f.this.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass16) bVar, aVar);
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.cLb.f(bVar);
            com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(14L).cw(aVar.errorNo).tT("Extension下载失败").tV(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", tV.toString());
            }
            f.this.c(bVar);
            c.apB().a(bVar, f.this.apI(), tV);
            com.baidu.swan.c.d.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void Q(com.baidu.swan.pms.model.b bVar) {
            super.Q(bVar);
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.versionCode);
            com.baidu.swan.apps.am.a a2 = f.this.a(bVar);
            if (a2 != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.cLb.f(bVar);
                f.this.c(bVar);
                c.apB().a(bVar, f.this.apI(), a2);
                return;
            }
            f.this.cLr = bVar;
            f.this.cLb.g(bVar);
            f.this.c(bVar);
            c.apB().a(bVar, f.this.apI());
        }
    };
    private com.baidu.swan.pms.a.f cLD = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void e(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.cLs = pMSAppInfo;
            if (f.this.cLs != null) {
                f.this.c(f.this.cLs);
                com.baidu.swan.apps.ac.g.b.aa(f.this.cLs.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> cLE = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", f.this.apI() + " : 包下载onCompleted");
            f.this.apH();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            com.baidu.swan.apps.console.c.f("SwanAppPkgDownloadCallback", f.this.apI() + " : 包下载OnError", th);
            f.this.o(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", f.this.apI() + " : 单个包下载、业务层处理完成：" + eVar.versionCode);
        }
    };
    protected List<UbcFlowEvent> cLt = new ArrayList();

    protected abstract PMSDownloadType apI();

    protected abstract void o(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void amK() {
        this.cLt.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void apE() {
        this.cLt.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.errorNo == 1010) {
            apO();
        }
        this.cLt.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cLw = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.cLw);
        }
        if (fVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + fVar.bbR());
            }
            this.cLt.add(new UbcFlowEvent("na_pms_start_download"));
            this.cLb = fVar;
            if (!this.cLb.isEmpty()) {
                apR();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> apJ() {
        return this.cLA;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> apG() {
        return this.cLf;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> apK() {
        return this.cLB;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> apL() {
        return this.cLC;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f apM() {
        return this.cLD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String apN() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int amL() {
        return 100;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.f fVar) {
        if (fVar == null) {
            com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(11L).cw(2310L).tV("pkg info is empty");
            com.baidu.swan.apps.am.e.aLl().j(tV);
            return tV;
        }
        return null;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0486a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.am.a().cv(13L).cx(2907L).tT("Core包更新失败");
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cSu = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.am.a().cv(14L).cx(2908L).tT("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: if  reason: not valid java name */
    public void m33if(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.baA().ae(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.baA().ae(this.mAppId, 0);
        }
    }

    private void apO() {
        PMSAppInfo yh = com.baidu.swan.pms.database.a.baA().yh(this.mAppId);
        com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + yh.createTime + " lastLaunchTime=" + yh.getLastLaunchTime() + " maxAge=" + yh.maxAge);
        if (yh != null) {
            yh.baL();
            yh.mN(apV());
            if (this.cLp != null) {
                this.cLp.createTime = yh.createTime;
            }
            if (this.cLs != null) {
                this.cLs.createTime = yh.createTime;
                this.cLs.mN(apV());
            }
            com.baidu.swan.pms.database.a.baA().r(yh);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.am.a apP() {
        if (this.cLs == null) {
            if (this.cLp == null) {
                return new com.baidu.swan.apps.am.a().cv(10L).cw(2903L).tT("Server未返回主包&AppInfo");
            }
            PMSAppInfo yh = com.baidu.swan.pms.database.a.baA().yh(this.mAppId);
            if (yh == null) {
                return new com.baidu.swan.apps.am.a().cv(10L).cw(2904L).tT("Server未返回AppInfo数据，本地也没有数据");
            }
            this.cLs = yh;
            com.baidu.swan.apps.core.pms.f.a.a(this.cLs, this.cLp);
            this.cLs.baL();
            this.cLs.mN(apV());
            if (com.baidu.swan.pms.database.a.baA().a(this.cLp, this.cLd, this.cLq, this.cLr, this.cLs)) {
                return null;
            }
            return new com.baidu.swan.apps.am.a().cv(10L).cw(2906L).tT("更新DB失败");
        }
        if (this.cLp != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.cLs, this.cLp);
        } else if (com.baidu.swan.apps.core.pms.f.b.ax(this.cLd)) {
            this.cLv = this.cLd.get(0);
            this.cLv.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.cLs, this.cLv);
        } else {
            PMSAppInfo yh2 = com.baidu.swan.pms.database.a.baA().yh(this.mAppId);
            if (yh2 == null) {
                return new com.baidu.swan.apps.am.a().cv(10L).cw(2905L).tT("Server未返回包数据，本地也没有数据");
            }
            this.cLs.appId = this.mAppId;
            this.cLs.u(yh2);
        }
        this.cLs.baL();
        this.cLs.mN(apV());
        if (com.baidu.swan.pms.database.a.baA().a(this.cLp, this.cLd, this.cLq, this.cLr, this.cLs)) {
            com.baidu.swan.apps.core.pms.f.a.g(this.cLs);
            return null;
        }
        return new com.baidu.swan.apps.am.a().cv(10L).cw(2906L).tT("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apQ() {
        if (this.cLs != null) {
            PMSAppInfo yh = com.baidu.swan.pms.database.a.baA().yh(this.mAppId);
            if (yh == null) {
                com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                return;
            }
            this.cLs.appId = this.mAppId;
            yh.mN(apV());
            this.cLs.u(yh);
            this.cLs.baL();
            if (com.baidu.swan.pms.database.a.baA().r(this.cLs)) {
                com.baidu.swan.apps.core.pms.f.a.g(this.cLs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apH() {
        com.baidu.swan.apps.console.c.i("SwanAppPkgDownloadCallback", "pms download time : " + (System.currentTimeMillis() - this.cLw));
    }

    public f c(com.baidu.swan.apps.ap.e.b<PMSAppInfo> bVar) {
        return a((Collection<Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>>) this.cLy, (Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>) bVar);
    }

    protected f c(final PMSAppInfo pMSAppInfo) {
        return a((Collection) this.cLy, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: e */
            public void M(com.baidu.swan.apps.ap.e.b<PMSAppInfo> bVar) {
                bVar.M(pMSAppInfo);
            }
        });
    }

    private synchronized <CallbackT> f a(final Collection<CallbackT> collection, final CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.cLz.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
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
            this.cLz.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.ap.e.b<CallbackT> bVar) {
        this.cLz.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : collection) {
                    bVar.M(obj);
                }
            }
        });
        return this;
    }

    public synchronized f a(com.baidu.swan.apps.core.pms.a.a aVar) {
        return a(this.cLx, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f d(@NonNull final com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a((Collection) this.cLx, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.M(aVar);
                f.this.b((Collection<Set>) f.this.cLx, (Set) aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final com.baidu.swan.apps.am.a aVar, final boolean z) {
        d(new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(com.baidu.swan.apps.core.pms.a.a aVar2) {
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
            public void M(com.baidu.swan.apps.core.pms.a.a aVar) {
                aVar.f(pMSAppInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        c.apB().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cLp = fVar;
                f.this.cLb.g(fVar);
                if (f.this.cLl != null) {
                    f.this.cLl.onNext(fVar);
                    f.this.cLl.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cLb.f(fVar);
                if (f.this.cLl != null) {
                    f.this.cLl.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.apB().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.cLd == null) {
                    f.this.cLd = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.cLd.add(gVar);
                f.this.cLb.g(gVar);
                if (f.this.cLm != null) {
                    f.this.cLm.onNext(gVar);
                    if (!f.this.cLb.bbX()) {
                        f.this.cLm.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cLb.f(gVar);
                if (f.this.cLm != null) {
                    f.this.cLm.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.apB().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cLq = dVar;
                f.this.cLb.g(dVar);
                if (f.this.cLn != null) {
                    f.this.cLn.onNext(dVar);
                    f.this.cLn.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cLb.f(dVar);
                if (f.this.cLn != null) {
                    f.this.cLn.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.apB().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f.this.cLr = bVar;
                f.this.cLb.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                com.baidu.swan.apps.console.c.bm("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                f.this.cLb.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.cLo != null) {
            this.cLo.onNext(bVar);
            this.cLo.onCompleted();
        }
    }

    private void apR() {
        ArrayList arrayList = new ArrayList();
        if (this.cLb.bbS()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.cLl = jVar;
                }
            }));
        }
        if (this.cLb.bbT()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.cLm = jVar;
                }
            }));
        }
        if (this.cLb.bbV()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.cLn = jVar;
                }
            }));
        }
        if (this.cLb.bbW()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.cLo = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.cLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bx(String str, String str2) {
        com.baidu.swan.apps.performance.f.a.a(this.mAppId, str, this.cLt, str2);
        this.cLt.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
