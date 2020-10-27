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
/* loaded from: classes10.dex */
public abstract class f extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.pms.utils.f cGS;
    protected List<com.baidu.swan.pms.model.g> cGU;
    private rx.j<? super com.baidu.swan.pms.model.f> cHc;
    private rx.j<? super com.baidu.swan.pms.model.g> cHd;
    private rx.j<? super com.baidu.swan.pms.model.d> cHe;
    private rx.j<? super com.baidu.swan.pms.model.b> cHf;
    protected com.baidu.swan.pms.model.f cHg;
    protected com.baidu.swan.pms.model.d cHh;
    protected com.baidu.swan.pms.model.b cHi;
    protected PMSAppInfo cHj;
    protected com.baidu.swan.pms.model.g cHm;
    protected String mAppId;
    private String mClassName = "";
    protected String cHl = "0";
    private long cHn = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> cHo = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>> cHp = new HashSet();
    private final aq cHq = new aq();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> cHr = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
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
                return com.baidu.swan.apps.core.pms.f.a.aoh();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aoi();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.akT();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.f fVar) {
            String anU = f.this.anU();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pr(anU).awE().iX(1);
            }
            super.S(fVar);
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void T(com.baidu.swan.pms.model.f fVar) {
            String anU = f.this.anU();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pr(anU).awE().iX(1);
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
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.cGS.f(fVar);
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(11L).ca(aVar.errorNo).tK("主包下载失败").tM(aVar.toString());
            if (f.this.cHc != null) {
                f.this.cHc.onError(new PkgDownloadError(fVar, tM));
            }
            c.anI().a(fVar, f.this.anP(), tM);
            com.baidu.swan.c.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.f fVar) {
            String anU = f.this.anU();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pr(anU).awE().iX(1);
            }
            super.Q(fVar);
            f.this.cHk.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.am.a a2 = f.this.a(fVar);
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.versionCode);
            if (a2 == null) {
                f.this.cHg = fVar;
                f.this.cGS.g(fVar);
                if (f.this.cHc != null) {
                    f.this.cHc.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.cHc.onCompleted();
                }
                c.anI().a(fVar, f.this.anP());
                return;
            }
            f.this.cGS.f(fVar);
            if (f.this.cHc != null) {
                f.this.cHc.onError(new PkgDownloadError(fVar, a2));
            }
            c.anI().a(fVar, f.this.anP(), a2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String anU = f.this.anU();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pr(anU).ps(fVar.toString()).iX(1);
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cGW = new k<f>(this) { // from class: com.baidu.swan.apps.core.pms.f.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.akT();
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
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "sub onDownloadStart");
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
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.cGS.f(gVar);
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(12L).ca(aVar.errorNo).tK("分包下载失败").tM(aVar.toString());
            if (f.this.cHd != null) {
                f.this.cHd.onError(new PkgDownloadError(gVar, tM));
            }
            c.anI().a(gVar, f.this.anP(), tM);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k
        public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.versionCode);
            if (f.this.cGU == null) {
                f.this.cGU = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            if (aVar == null) {
                f.this.cGU.add(gVar);
                f.this.cGS.g(gVar);
                c.anI().a(gVar, f.this.anP());
            } else {
                f.this.cGS.f(gVar);
                c.anI().a(gVar, f.this.anP(), aVar);
            }
            if (f.this.cHd != null) {
                f.this.cHd.onNext(gVar);
                if (!f.this.cGS.bae()) {
                    f.this.cHd.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cHs = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
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
                return com.baidu.swan.apps.core.pms.f.a.aoj();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aok();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.akT();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.d dVar) {
            super.S(dVar);
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "framework onDownloadStart");
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
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.cGS.f(dVar);
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(13L).ca(aVar.errorNo).tK("Framework包下载失败").tM(aVar.toString());
            if (f.this.cHe != null) {
                f.this.cHe.onError(new PkgDownloadError(dVar, tM));
            }
            c.anI().a(dVar, f.this.anP(), tM);
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.d dVar) {
            super.Q(dVar);
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.versionCode);
            com.baidu.swan.apps.am.a a2 = f.this.a(dVar);
            if (a2 == null) {
                f.this.cHh = dVar;
                f.this.cGS.g(dVar);
                if (f.this.cHe != null) {
                    f.this.cHe.onNext(dVar);
                    f.this.cHe.onCompleted();
                }
                c.anI().a(dVar, f.this.anP());
                return;
            }
            f.this.cGS.f(dVar);
            if (f.this.cHe != null) {
                f.this.cHe.onError(new PkgDownloadError(dVar, a2));
            }
            c.anI().a(dVar, f.this.anP(), a2);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cHt = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
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
                return com.baidu.swan.apps.core.pms.f.a.aob();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aol();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.akT();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void S(com.baidu.swan.pms.model.b bVar) {
            super.S(bVar);
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "extension onDownloadStart");
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
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.cGS.f(bVar);
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(14L).ca(aVar.errorNo).tK("Extension下载失败").tM(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", tM.toString());
            }
            f.this.c(bVar);
            c.anI().a(bVar, f.this.anP(), tM);
            com.baidu.swan.c.d.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void Q(com.baidu.swan.pms.model.b bVar) {
            super.Q(bVar);
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.versionCode);
            com.baidu.swan.apps.am.a a2 = f.this.a(bVar);
            if (a2 != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.cGS.f(bVar);
                f.this.c(bVar);
                c.anI().a(bVar, f.this.anP(), a2);
                return;
            }
            f.this.cHi = bVar;
            f.this.cGS.g(bVar);
            f.this.c(bVar);
            c.anI().a(bVar, f.this.anP());
        }
    };
    private com.baidu.swan.pms.a.f cHu = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void e(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.cHj = pMSAppInfo;
            if (f.this.cHj != null) {
                f.this.c(f.this.cHj);
                com.baidu.swan.apps.ac.g.b.aa(f.this.cHj.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> cHv = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", f.this.anP() + " : 包下载onCompleted");
            f.this.anO();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            com.baidu.swan.apps.console.c.f("SwanAppPkgDownloadCallback", f.this.anP() + " : 包下载OnError", th);
            f.this.o(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", f.this.anP() + " : 单个包下载、业务层处理完成：" + eVar.versionCode);
        }
    };
    protected List<UbcFlowEvent> cHk = new ArrayList();

    protected abstract PMSDownloadType anP();

    protected abstract void o(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void akS() {
        this.cHk.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void anL() {
        this.cHk.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.errorNo == 1010) {
            anV();
        }
        this.cHk.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cHn = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.cHn);
        }
        if (fVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + fVar.aZY());
            }
            this.cHk.add(new UbcFlowEvent("na_pms_start_download"));
            this.cGS = fVar;
            if (!this.cGS.isEmpty()) {
                anY();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> anQ() {
        return this.cHr;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> anN() {
        return this.cGW;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> anR() {
        return this.cHs;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> anS() {
        return this.cHt;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f anT() {
        return this.cHu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String anU() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int akT() {
        return 100;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.f fVar) {
        if (fVar == null) {
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(11L).ca(2310L).tM("pkg info is empty");
            com.baidu.swan.apps.am.e.aJt().j(tM);
            return tM;
        }
        return null;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0476a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.am.a().bZ(13L).cb(2907L).tK("Core包更新失败");
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cOl = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.am.a().bZ(14L).cb(2908L).tK("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hZ(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.aYH().ac(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.aYH().ac(this.mAppId, 0);
        }
    }

    private void anV() {
        PMSAppInfo xY = com.baidu.swan.pms.database.a.aYH().xY(this.mAppId);
        com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + xY.createTime + " lastLaunchTime=" + xY.getLastLaunchTime() + " maxAge=" + xY.maxAge);
        if (xY != null) {
            xY.aYS();
            xY.mH(aoc());
            if (this.cHg != null) {
                this.cHg.createTime = xY.createTime;
            }
            if (this.cHj != null) {
                this.cHj.createTime = xY.createTime;
                this.cHj.mH(aoc());
            }
            com.baidu.swan.pms.database.a.aYH().r(xY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.am.a anW() {
        if (this.cHj == null) {
            if (this.cHg == null) {
                return new com.baidu.swan.apps.am.a().bZ(10L).ca(2903L).tK("Server未返回主包&AppInfo");
            }
            PMSAppInfo xY = com.baidu.swan.pms.database.a.aYH().xY(this.mAppId);
            if (xY == null) {
                return new com.baidu.swan.apps.am.a().bZ(10L).ca(2904L).tK("Server未返回AppInfo数据，本地也没有数据");
            }
            this.cHj = xY;
            com.baidu.swan.apps.core.pms.f.a.a(this.cHj, this.cHg);
            this.cHj.aYS();
            this.cHj.mH(aoc());
            if (com.baidu.swan.pms.database.a.aYH().a(this.cHg, this.cGU, this.cHh, this.cHi, this.cHj)) {
                return null;
            }
            return new com.baidu.swan.apps.am.a().bZ(10L).ca(2906L).tK("更新DB失败");
        }
        if (this.cHg != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.cHj, this.cHg);
        } else if (com.baidu.swan.apps.core.pms.f.b.aq(this.cGU)) {
            this.cHm = this.cGU.get(0);
            this.cHm.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.cHj, this.cHm);
        } else {
            PMSAppInfo xY2 = com.baidu.swan.pms.database.a.aYH().xY(this.mAppId);
            if (xY2 == null) {
                return new com.baidu.swan.apps.am.a().bZ(10L).ca(2905L).tK("Server未返回包数据，本地也没有数据");
            }
            this.cHj.appId = this.mAppId;
            this.cHj.u(xY2);
        }
        this.cHj.aYS();
        this.cHj.mH(aoc());
        if (com.baidu.swan.pms.database.a.aYH().a(this.cHg, this.cGU, this.cHh, this.cHi, this.cHj)) {
            com.baidu.swan.apps.core.pms.f.a.g(this.cHj);
            return null;
        }
        return new com.baidu.swan.apps.am.a().bZ(10L).ca(2906L).tK("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anX() {
        if (this.cHj != null) {
            PMSAppInfo xY = com.baidu.swan.pms.database.a.aYH().xY(this.mAppId);
            if (xY == null) {
                com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                return;
            }
            this.cHj.appId = this.mAppId;
            xY.mH(aoc());
            this.cHj.u(xY);
            this.cHj.aYS();
            if (com.baidu.swan.pms.database.a.aYH().r(this.cHj)) {
                com.baidu.swan.apps.core.pms.f.a.g(this.cHj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anO() {
        com.baidu.swan.apps.console.c.i("SwanAppPkgDownloadCallback", "pms download time : " + (System.currentTimeMillis() - this.cHn));
    }

    public f c(com.baidu.swan.apps.ap.e.b<PMSAppInfo> bVar) {
        return a((Collection<Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>>) this.cHp, (Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>) bVar);
    }

    protected f c(final PMSAppInfo pMSAppInfo) {
        return a((Collection) this.cHp, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
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
            this.cHq.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
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
            this.cHq.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.ap.e.b<CallbackT> bVar) {
        this.cHq.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
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
        return a(this.cHo, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f d(@NonNull final com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a((Collection) this.cHo, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.M(aVar);
                f.this.b((Collection<Set>) f.this.cHo, (Set) aVar);
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
        c.anI().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cHg = fVar;
                f.this.cGS.g(fVar);
                if (f.this.cHc != null) {
                    f.this.cHc.onNext(fVar);
                    f.this.cHc.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cGS.f(fVar);
                if (f.this.cHc != null) {
                    f.this.cHc.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.anI().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.cGU == null) {
                    f.this.cGU = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.cGU.add(gVar);
                f.this.cGS.g(gVar);
                if (f.this.cHd != null) {
                    f.this.cHd.onNext(gVar);
                    if (!f.this.cGS.bae()) {
                        f.this.cHd.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cGS.f(gVar);
                if (f.this.cHd != null) {
                    f.this.cHd.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.anI().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cHh = dVar;
                f.this.cGS.g(dVar);
                if (f.this.cHe != null) {
                    f.this.cHe.onNext(dVar);
                    f.this.cHe.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cGS.f(dVar);
                if (f.this.cHe != null) {
                    f.this.cHe.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.anI().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f.this.cHi = bVar;
                f.this.cGS.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                f.this.cGS.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.cHf != null) {
            this.cHf.onNext(bVar);
            this.cHf.onCompleted();
        }
    }

    private void anY() {
        ArrayList arrayList = new ArrayList();
        if (this.cGS.aZZ()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.cHc = jVar;
                }
            }));
        }
        if (this.cGS.baa()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.cHd = jVar;
                }
            }));
        }
        if (this.cGS.bac()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.cHe = jVar;
                }
            }));
        }
        if (this.cGS.bad()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.cHf = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.cHv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void by(String str, String str2) {
        com.baidu.swan.apps.performance.f.a.a(this.mAppId, str, this.cHk, str2);
        this.cHk.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
