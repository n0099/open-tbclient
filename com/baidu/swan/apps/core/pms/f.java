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
/* loaded from: classes25.dex */
public abstract class f extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.pms.utils.f cRU;
    protected List<com.baidu.swan.pms.model.g> cRW;
    private rx.j<? super com.baidu.swan.pms.model.f> cSe;
    private rx.j<? super com.baidu.swan.pms.model.g> cSf;
    private rx.j<? super com.baidu.swan.pms.model.d> cSg;
    private rx.j<? super com.baidu.swan.pms.model.b> cSh;
    protected com.baidu.swan.pms.model.f cSi;
    protected com.baidu.swan.pms.model.d cSj;
    protected com.baidu.swan.pms.model.b cSk;
    protected PMSAppInfo cSl;
    protected com.baidu.swan.pms.model.g cSo;
    protected String mAppId;
    private String mClassName = "";
    protected String cSn = "0";
    private long cSp = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> cSq = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>> cSr = new HashSet();
    private final aq cSs = new aq();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> cSt = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
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
                return com.baidu.swan.apps.core.pms.f.a.ati();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.atj();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.apT();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.f fVar) {
            String asV = f.this.asV();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.qg(asV).aBF().jB(1);
            }
            super.S(fVar);
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void T(com.baidu.swan.pms.model.f fVar) {
            String asV = f.this.asV();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.qg(asV).aBF().jB(1);
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
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.cRU.f(fVar);
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(11L).cV(aVar.errorNo).uA("主包下载失败").uC(aVar.toString());
            if (f.this.cSe != null) {
                f.this.cSe.onError(new PkgDownloadError(fVar, uC));
            }
            c.asJ().a(fVar, f.this.asQ(), uC);
            com.baidu.swan.c.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.f fVar) {
            String asV = f.this.asV();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.qg(asV).aBF().jB(1);
            }
            super.Q(fVar);
            f.this.cSm.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.am.a a2 = f.this.a(fVar);
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.versionCode);
            if (a2 == null) {
                f.this.cSi = fVar;
                f.this.cRU.g(fVar);
                if (f.this.cSe != null) {
                    f.this.cSe.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.cSe.onCompleted();
                }
                c.asJ().a(fVar, f.this.asQ());
                return;
            }
            f.this.cRU.f(fVar);
            if (f.this.cSe != null) {
                f.this.cSe.onError(new PkgDownloadError(fVar, a2));
            }
            c.asJ().a(fVar, f.this.asQ(), a2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String asV = f.this.asV();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.qg(asV).qh(fVar.toString()).jB(1);
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cRY = new k<f>(this) { // from class: com.baidu.swan.apps.core.pms.f.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.apT();
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
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "sub onDownloadStart");
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
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.cRU.f(gVar);
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(12L).cV(aVar.errorNo).uA("分包下载失败").uC(aVar.toString());
            if (f.this.cSf != null) {
                f.this.cSf.onError(new PkgDownloadError(gVar, uC));
            }
            c.asJ().a(gVar, f.this.asQ(), uC);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k
        public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.versionCode);
            if (f.this.cRW == null) {
                f.this.cRW = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            if (aVar == null) {
                f.this.cRW.add(gVar);
                f.this.cRU.g(gVar);
                c.asJ().a(gVar, f.this.asQ());
            } else {
                f.this.cRU.f(gVar);
                c.asJ().a(gVar, f.this.asQ(), aVar);
            }
            if (f.this.cSf != null) {
                f.this.cSf.onNext(gVar);
                if (!f.this.cRU.bfc()) {
                    f.this.cSf.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cSu = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
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
                return com.baidu.swan.apps.core.pms.f.a.atk();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.atl();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.apT();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.d dVar) {
            super.S(dVar);
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "framework onDownloadStart");
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
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.cRU.f(dVar);
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(13L).cV(aVar.errorNo).uA("Framework包下载失败").uC(aVar.toString());
            if (f.this.cSg != null) {
                f.this.cSg.onError(new PkgDownloadError(dVar, uC));
            }
            c.asJ().a(dVar, f.this.asQ(), uC);
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.d dVar) {
            super.Q(dVar);
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.versionCode);
            com.baidu.swan.apps.am.a a2 = f.this.a(dVar);
            if (a2 == null) {
                f.this.cSj = dVar;
                f.this.cRU.g(dVar);
                if (f.this.cSg != null) {
                    f.this.cSg.onNext(dVar);
                    f.this.cSg.onCompleted();
                }
                c.asJ().a(dVar, f.this.asQ());
                return;
            }
            f.this.cRU.f(dVar);
            if (f.this.cSg != null) {
                f.this.cSg.onError(new PkgDownloadError(dVar, a2));
            }
            c.asJ().a(dVar, f.this.asQ(), a2);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cSv = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
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
                return com.baidu.swan.apps.core.pms.f.a.atc();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.atm();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.apT();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void S(com.baidu.swan.pms.model.b bVar) {
            super.S(bVar);
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "extension onDownloadStart");
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
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.cRU.f(bVar);
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(14L).cV(aVar.errorNo).uA("Extension下载失败").uC(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", uC.toString());
            }
            f.this.c(bVar);
            c.asJ().a(bVar, f.this.asQ(), uC);
            com.baidu.swan.c.d.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void Q(com.baidu.swan.pms.model.b bVar) {
            super.Q(bVar);
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.versionCode);
            com.baidu.swan.apps.am.a a2 = f.this.a(bVar);
            if (a2 != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.cRU.f(bVar);
                f.this.c(bVar);
                c.asJ().a(bVar, f.this.asQ(), a2);
                return;
            }
            f.this.cSk = bVar;
            f.this.cRU.g(bVar);
            f.this.c(bVar);
            c.asJ().a(bVar, f.this.asQ());
        }
    };
    private com.baidu.swan.pms.a.f cSw = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void e(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.cSl = pMSAppInfo;
            if (f.this.cSl != null) {
                f.this.c(f.this.cSl);
                com.baidu.swan.apps.ac.g.b.ab(f.this.cSl.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> cSx = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", f.this.asQ() + " : 包下载onCompleted");
            f.this.asP();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            com.baidu.swan.apps.console.c.f("SwanAppPkgDownloadCallback", f.this.asQ() + " : 包下载OnError", th);
            f.this.o(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", f.this.asQ() + " : 单个包下载、业务层处理完成：" + eVar.versionCode);
        }
    };
    protected List<UbcFlowEvent> cSm = new ArrayList();

    protected abstract PMSDownloadType asQ();

    protected abstract void o(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void apS() {
        this.cSm.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void asM() {
        this.cSm.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.errorNo == 1010) {
            asW();
        }
        this.cSm.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cSp = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.cSp);
        }
        if (fVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + fVar.beW());
            }
            this.cSm.add(new UbcFlowEvent("na_pms_start_download"));
            this.cRU = fVar;
            if (!this.cRU.isEmpty()) {
                asZ();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> asR() {
        return this.cSt;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> asO() {
        return this.cRY;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> asS() {
        return this.cSu;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> asT() {
        return this.cSv;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f asU() {
        return this.cSw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String asV() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int apT() {
        return 100;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.f fVar) {
        if (fVar == null) {
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(11L).cV(2310L).uC("pkg info is empty");
            com.baidu.swan.apps.am.e.aOs().j(uC);
            return uC;
        }
        return null;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0498a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.am.a().cU(13L).cW(2907L).uA("Core包更新失败");
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cZn = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.am.a().cU(14L).cW(2908L).uA("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iD(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.bdF().af(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.bdF().af(this.mAppId, 0);
        }
    }

    private void asW() {
        PMSAppInfo yO = com.baidu.swan.pms.database.a.bdF().yO(this.mAppId);
        com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + yO.createTime + " lastLaunchTime=" + yO.getLastLaunchTime() + " maxAge=" + yO.maxAge);
        if (yO != null) {
            yO.bdQ();
            yO.nl(atd());
            if (this.cSi != null) {
                this.cSi.createTime = yO.createTime;
            }
            if (this.cSl != null) {
                this.cSl.createTime = yO.createTime;
                this.cSl.nl(atd());
            }
            com.baidu.swan.pms.database.a.bdF().r(yO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.am.a asX() {
        if (this.cSl == null) {
            if (this.cSi == null) {
                return new com.baidu.swan.apps.am.a().cU(10L).cV(2903L).uA("Server未返回主包&AppInfo");
            }
            PMSAppInfo yO = com.baidu.swan.pms.database.a.bdF().yO(this.mAppId);
            if (yO == null) {
                return new com.baidu.swan.apps.am.a().cU(10L).cV(2904L).uA("Server未返回AppInfo数据，本地也没有数据");
            }
            this.cSl = yO;
            com.baidu.swan.apps.core.pms.f.a.a(this.cSl, this.cSi);
            this.cSl.bdQ();
            this.cSl.nl(atd());
            if (com.baidu.swan.pms.database.a.bdF().a(this.cSi, this.cRW, this.cSj, this.cSk, this.cSl)) {
                return null;
            }
            return new com.baidu.swan.apps.am.a().cU(10L).cV(2906L).uA("更新DB失败");
        }
        if (this.cSi != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.cSl, this.cSi);
        } else if (com.baidu.swan.apps.core.pms.f.b.aA(this.cRW)) {
            this.cSo = this.cRW.get(0);
            this.cSo.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.cSl, this.cSo);
        } else {
            PMSAppInfo yO2 = com.baidu.swan.pms.database.a.bdF().yO(this.mAppId);
            if (yO2 == null) {
                return new com.baidu.swan.apps.am.a().cU(10L).cV(2905L).uA("Server未返回包数据，本地也没有数据");
            }
            this.cSl.appId = this.mAppId;
            this.cSl.u(yO2);
        }
        this.cSl.bdQ();
        this.cSl.nl(atd());
        if (com.baidu.swan.pms.database.a.bdF().a(this.cSi, this.cRW, this.cSj, this.cSk, this.cSl)) {
            com.baidu.swan.apps.core.pms.f.a.g(this.cSl);
            return null;
        }
        return new com.baidu.swan.apps.am.a().cU(10L).cV(2906L).uA("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asY() {
        if (this.cSl != null) {
            PMSAppInfo yO = com.baidu.swan.pms.database.a.bdF().yO(this.mAppId);
            if (yO == null) {
                com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                return;
            }
            this.cSl.appId = this.mAppId;
            yO.nl(atd());
            this.cSl.u(yO);
            this.cSl.bdQ();
            if (com.baidu.swan.pms.database.a.bdF().r(this.cSl)) {
                com.baidu.swan.apps.core.pms.f.a.g(this.cSl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asP() {
        com.baidu.swan.apps.console.c.i("SwanAppPkgDownloadCallback", "pms download time : " + (System.currentTimeMillis() - this.cSp));
    }

    public f c(com.baidu.swan.apps.ap.e.b<PMSAppInfo> bVar) {
        return a((Collection<Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>>) this.cSr, (Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>) bVar);
    }

    protected f c(final PMSAppInfo pMSAppInfo) {
        return a((Collection) this.cSr, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
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
            this.cSs.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
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
            this.cSs.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.ap.e.b<CallbackT> bVar) {
        this.cSs.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
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
        return a(this.cSq, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f d(@NonNull final com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a((Collection) this.cSq, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.M(aVar);
                f.this.b((Collection<Set>) f.this.cSq, (Set) aVar);
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
        c.asJ().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cSi = fVar;
                f.this.cRU.g(fVar);
                if (f.this.cSe != null) {
                    f.this.cSe.onNext(fVar);
                    f.this.cSe.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cRU.f(fVar);
                if (f.this.cSe != null) {
                    f.this.cSe.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.asJ().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.cRW == null) {
                    f.this.cRW = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.cRW.add(gVar);
                f.this.cRU.g(gVar);
                if (f.this.cSf != null) {
                    f.this.cSf.onNext(gVar);
                    if (!f.this.cRU.bfc()) {
                        f.this.cSf.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cRU.f(gVar);
                if (f.this.cSf != null) {
                    f.this.cSf.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.asJ().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cSj = dVar;
                f.this.cRU.g(dVar);
                if (f.this.cSg != null) {
                    f.this.cSg.onNext(dVar);
                    f.this.cSg.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cRU.f(dVar);
                if (f.this.cSg != null) {
                    f.this.cSg.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.asJ().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f.this.cSk = bVar;
                f.this.cRU.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                com.baidu.swan.apps.console.c.bt("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                f.this.cRU.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.cSh != null) {
            this.cSh.onNext(bVar);
            this.cSh.onCompleted();
        }
    }

    private void asZ() {
        ArrayList arrayList = new ArrayList();
        if (this.cRU.beX()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.cSe = jVar;
                }
            }));
        }
        if (this.cRU.beY()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.cSf = jVar;
                }
            }));
        }
        if (this.cRU.bfa()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.cSg = jVar;
                }
            }));
        }
        if (this.cRU.bfb()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.cSh = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.cSx);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bE(String str, String str2) {
        com.baidu.swan.apps.performance.f.a.a(this.mAppId, str, this.cSm, str2);
        this.cSm.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
