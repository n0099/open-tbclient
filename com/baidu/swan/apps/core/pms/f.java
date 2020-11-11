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
    protected com.baidu.swan.pms.utils.f cML;
    protected List<com.baidu.swan.pms.model.g> cMN;
    private rx.j<? super com.baidu.swan.pms.model.f> cMV;
    private rx.j<? super com.baidu.swan.pms.model.g> cMW;
    private rx.j<? super com.baidu.swan.pms.model.d> cMX;
    private rx.j<? super com.baidu.swan.pms.model.b> cMY;
    protected com.baidu.swan.pms.model.f cMZ;
    protected com.baidu.swan.pms.model.d cNa;
    protected com.baidu.swan.pms.model.b cNb;
    protected PMSAppInfo cNc;
    protected com.baidu.swan.pms.model.g cNf;
    protected String mAppId;
    private String mClassName = "";
    protected String cNe = "0";
    private long cNg = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> cNh = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>> cNi = new HashSet();
    private final aq cNj = new aq();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> cNk = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
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
                return com.baidu.swan.apps.core.pms.f.a.aqI();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aqJ();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.ant();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.f fVar) {
            String aqv = f.this.aqv();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pF(aqv).aze().jh(1);
            }
            super.S(fVar);
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void T(com.baidu.swan.pms.model.f fVar) {
            String aqv = f.this.aqv();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pF(aqv).aze().jh(1);
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
            f.this.cML.f(fVar);
            com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(11L).cw(aVar.errorNo).tY("主包下载失败").ua(aVar.toString());
            if (f.this.cMV != null) {
                f.this.cMV.onError(new PkgDownloadError(fVar, ua));
            }
            c.aqj().a(fVar, f.this.aqq(), ua);
            com.baidu.swan.c.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.f fVar) {
            String aqv = f.this.aqv();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pF(aqv).aze().jh(1);
            }
            super.Q(fVar);
            f.this.cNd.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.am.a a2 = f.this.a(fVar);
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.versionCode);
            if (a2 == null) {
                f.this.cMZ = fVar;
                f.this.cML.g(fVar);
                if (f.this.cMV != null) {
                    f.this.cMV.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.cMV.onCompleted();
                }
                c.aqj().a(fVar, f.this.aqq());
                return;
            }
            f.this.cML.f(fVar);
            if (f.this.cMV != null) {
                f.this.cMV.onError(new PkgDownloadError(fVar, a2));
            }
            c.aqj().a(fVar, f.this.aqq(), a2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String aqv = f.this.aqv();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pF(aqv).pG(fVar.toString()).jh(1);
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cMP = new k<f>(this) { // from class: com.baidu.swan.apps.core.pms.f.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.ant();
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
            f.this.cML.f(gVar);
            com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(12L).cw(aVar.errorNo).tY("分包下载失败").ua(aVar.toString());
            if (f.this.cMW != null) {
                f.this.cMW.onError(new PkgDownloadError(gVar, ua));
            }
            c.aqj().a(gVar, f.this.aqq(), ua);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k
        public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.versionCode);
            if (f.this.cMN == null) {
                f.this.cMN = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            if (aVar == null) {
                f.this.cMN.add(gVar);
                f.this.cML.g(gVar);
                c.aqj().a(gVar, f.this.aqq());
            } else {
                f.this.cML.f(gVar);
                c.aqj().a(gVar, f.this.aqq(), aVar);
            }
            if (f.this.cMW != null) {
                f.this.cMW.onNext(gVar);
                if (!f.this.cML.bcE()) {
                    f.this.cMW.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cNl = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
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
                return com.baidu.swan.apps.core.pms.f.a.aqK();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aqL();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.ant();
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
            f.this.cML.f(dVar);
            com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(13L).cw(aVar.errorNo).tY("Framework包下载失败").ua(aVar.toString());
            if (f.this.cMX != null) {
                f.this.cMX.onError(new PkgDownloadError(dVar, ua));
            }
            c.aqj().a(dVar, f.this.aqq(), ua);
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
                f.this.cNa = dVar;
                f.this.cML.g(dVar);
                if (f.this.cMX != null) {
                    f.this.cMX.onNext(dVar);
                    f.this.cMX.onCompleted();
                }
                c.aqj().a(dVar, f.this.aqq());
                return;
            }
            f.this.cML.f(dVar);
            if (f.this.cMX != null) {
                f.this.cMX.onError(new PkgDownloadError(dVar, a2));
            }
            c.aqj().a(dVar, f.this.aqq(), a2);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cNm = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
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
                return com.baidu.swan.apps.core.pms.f.a.aqC();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aqM();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.ant();
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
            f.this.cML.f(bVar);
            com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(14L).cw(aVar.errorNo).tY("Extension下载失败").ua(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", ua.toString());
            }
            f.this.c(bVar);
            c.aqj().a(bVar, f.this.aqq(), ua);
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
                f.this.cML.f(bVar);
                f.this.c(bVar);
                c.aqj().a(bVar, f.this.aqq(), a2);
                return;
            }
            f.this.cNb = bVar;
            f.this.cML.g(bVar);
            f.this.c(bVar);
            c.aqj().a(bVar, f.this.aqq());
        }
    };
    private com.baidu.swan.pms.a.f cNn = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void e(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.cNc = pMSAppInfo;
            if (f.this.cNc != null) {
                f.this.c(f.this.cNc);
                com.baidu.swan.apps.ac.g.b.aa(f.this.cNc.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> cNo = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", f.this.aqq() + " : 包下载onCompleted");
            f.this.aqp();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            com.baidu.swan.apps.console.c.f("SwanAppPkgDownloadCallback", f.this.aqq() + " : 包下载OnError", th);
            f.this.o(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", f.this.aqq() + " : 单个包下载、业务层处理完成：" + eVar.versionCode);
        }
    };
    protected List<UbcFlowEvent> cNd = new ArrayList();

    protected abstract PMSDownloadType aqq();

    protected abstract void o(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ans() {
        this.cNd.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqm() {
        this.cNd.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.errorNo == 1010) {
            aqw();
        }
        this.cNd.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cNg = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.cNg);
        }
        if (fVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + fVar.bcy());
            }
            this.cNd.add(new UbcFlowEvent("na_pms_start_download"));
            this.cML = fVar;
            if (!this.cML.isEmpty()) {
                aqz();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> aqr() {
        return this.cNk;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aqo() {
        return this.cMP;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> aqs() {
        return this.cNl;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> aqt() {
        return this.cNm;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f aqu() {
        return this.cNn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aqv() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int ant() {
        return 100;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.f fVar) {
        if (fVar == null) {
            com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(11L).cw(2310L).ua("pkg info is empty");
            com.baidu.swan.apps.am.e.aLT().j(ua);
            return ua;
        }
        return null;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0488a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.am.a().cv(13L).cx(2907L).tY("Core包更新失败");
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cUe = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.am.a().cv(14L).cx(2908L).tY("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ij(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.bbh().ae(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.bbh().ae(this.mAppId, 0);
        }
    }

    private void aqw() {
        PMSAppInfo ym = com.baidu.swan.pms.database.a.bbh().ym(this.mAppId);
        com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + ym.createTime + " lastLaunchTime=" + ym.getLastLaunchTime() + " maxAge=" + ym.maxAge);
        if (ym != null) {
            ym.bbs();
            ym.mR(aqD());
            if (this.cMZ != null) {
                this.cMZ.createTime = ym.createTime;
            }
            if (this.cNc != null) {
                this.cNc.createTime = ym.createTime;
                this.cNc.mR(aqD());
            }
            com.baidu.swan.pms.database.a.bbh().r(ym);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.am.a aqx() {
        if (this.cNc == null) {
            if (this.cMZ == null) {
                return new com.baidu.swan.apps.am.a().cv(10L).cw(2903L).tY("Server未返回主包&AppInfo");
            }
            PMSAppInfo ym = com.baidu.swan.pms.database.a.bbh().ym(this.mAppId);
            if (ym == null) {
                return new com.baidu.swan.apps.am.a().cv(10L).cw(2904L).tY("Server未返回AppInfo数据，本地也没有数据");
            }
            this.cNc = ym;
            com.baidu.swan.apps.core.pms.f.a.a(this.cNc, this.cMZ);
            this.cNc.bbs();
            this.cNc.mR(aqD());
            if (com.baidu.swan.pms.database.a.bbh().a(this.cMZ, this.cMN, this.cNa, this.cNb, this.cNc)) {
                return null;
            }
            return new com.baidu.swan.apps.am.a().cv(10L).cw(2906L).tY("更新DB失败");
        }
        if (this.cMZ != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.cNc, this.cMZ);
        } else if (com.baidu.swan.apps.core.pms.f.b.ax(this.cMN)) {
            this.cNf = this.cMN.get(0);
            this.cNf.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.cNc, this.cNf);
        } else {
            PMSAppInfo ym2 = com.baidu.swan.pms.database.a.bbh().ym(this.mAppId);
            if (ym2 == null) {
                return new com.baidu.swan.apps.am.a().cv(10L).cw(2905L).tY("Server未返回包数据，本地也没有数据");
            }
            this.cNc.appId = this.mAppId;
            this.cNc.u(ym2);
        }
        this.cNc.bbs();
        this.cNc.mR(aqD());
        if (com.baidu.swan.pms.database.a.bbh().a(this.cMZ, this.cMN, this.cNa, this.cNb, this.cNc)) {
            com.baidu.swan.apps.core.pms.f.a.g(this.cNc);
            return null;
        }
        return new com.baidu.swan.apps.am.a().cv(10L).cw(2906L).tY("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqy() {
        if (this.cNc != null) {
            PMSAppInfo ym = com.baidu.swan.pms.database.a.bbh().ym(this.mAppId);
            if (ym == null) {
                com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                return;
            }
            this.cNc.appId = this.mAppId;
            ym.mR(aqD());
            this.cNc.u(ym);
            this.cNc.bbs();
            if (com.baidu.swan.pms.database.a.bbh().r(this.cNc)) {
                com.baidu.swan.apps.core.pms.f.a.g(this.cNc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqp() {
        com.baidu.swan.apps.console.c.i("SwanAppPkgDownloadCallback", "pms download time : " + (System.currentTimeMillis() - this.cNg));
    }

    public f c(com.baidu.swan.apps.ap.e.b<PMSAppInfo> bVar) {
        return a((Collection<Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>>) this.cNi, (Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>) bVar);
    }

    protected f c(final PMSAppInfo pMSAppInfo) {
        return a((Collection) this.cNi, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
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
            this.cNj.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
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
            this.cNj.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.ap.e.b<CallbackT> bVar) {
        this.cNj.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
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
        return a(this.cNh, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f d(@NonNull final com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a((Collection) this.cNh, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.M(aVar);
                f.this.b((Collection<Set>) f.this.cNh, (Set) aVar);
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
        c.aqj().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cMZ = fVar;
                f.this.cML.g(fVar);
                if (f.this.cMV != null) {
                    f.this.cMV.onNext(fVar);
                    f.this.cMV.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cML.f(fVar);
                if (f.this.cMV != null) {
                    f.this.cMV.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.aqj().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.cMN == null) {
                    f.this.cMN = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.cMN.add(gVar);
                f.this.cML.g(gVar);
                if (f.this.cMW != null) {
                    f.this.cMW.onNext(gVar);
                    if (!f.this.cML.bcE()) {
                        f.this.cMW.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cML.f(gVar);
                if (f.this.cMW != null) {
                    f.this.cMW.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.aqj().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cNa = dVar;
                f.this.cML.g(dVar);
                if (f.this.cMX != null) {
                    f.this.cMX.onNext(dVar);
                    f.this.cMX.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cML.f(dVar);
                if (f.this.cMX != null) {
                    f.this.cMX.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.aqj().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f.this.cNb = bVar;
                f.this.cML.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                com.baidu.swan.apps.console.c.bn("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                f.this.cML.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.cMY != null) {
            this.cMY.onNext(bVar);
            this.cMY.onCompleted();
        }
    }

    private void aqz() {
        ArrayList arrayList = new ArrayList();
        if (this.cML.bcz()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.cMV = jVar;
                }
            }));
        }
        if (this.cML.bcA()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.cMW = jVar;
                }
            }));
        }
        if (this.cML.bcC()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.cMX = jVar;
                }
            }));
        }
        if (this.cML.bcD()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.cMY = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.cNo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void by(String str, String str2) {
        com.baidu.swan.apps.performance.f.a.a(this.mAppId, str, this.cNd, str2);
        this.cNd.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
