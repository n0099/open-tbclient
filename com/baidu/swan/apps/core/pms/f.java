package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.aq;
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
    protected com.baidu.swan.pms.utils.f cSf;
    protected List<com.baidu.swan.pms.model.g> cSh;
    private rx.j<? super com.baidu.swan.pms.model.f> cSp;
    private rx.j<? super com.baidu.swan.pms.model.g> cSq;
    private rx.j<? super com.baidu.swan.pms.model.d> cSr;
    private rx.j<? super com.baidu.swan.pms.model.b> cSs;
    protected com.baidu.swan.pms.model.f cSt;
    protected com.baidu.swan.pms.model.d cSu;
    protected com.baidu.swan.pms.model.b cSv;
    protected PMSAppInfo cSw;
    protected com.baidu.swan.pms.model.g cSz;
    protected String mAppId;
    private String mClassName = "";
    protected String cSy = "0";
    private long cSA = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> cSB = new HashSet();
    private final Set<com.baidu.swan.apps.ao.e.b<PMSAppInfo>> cSC = new HashSet();
    private final aq cSD = new aq();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> cSE = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
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
                return com.baidu.swan.apps.core.pms.f.a.aqF();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aqG();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.anl();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.f fVar) {
            String aqs = f.this.aqs();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.oO(aqs).azd().hQ(1);
            }
            super.S(fVar);
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void T(com.baidu.swan.pms.model.f fVar) {
            String aqs = f.this.aqs();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.oO(aqs).azd().hQ(1);
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
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.cSf.f(fVar);
            com.baidu.swan.apps.al.a aVar2 = new com.baidu.swan.apps.al.a().cV(11L).cW(aVar.errorNo).tm("主包下载失败").to(aVar.toString());
            if (f.this.cSp != null) {
                f.this.cSp.onError(new PkgDownloadError(fVar, aVar2));
            }
            c.aqg().a(fVar, f.this.aqn(), aVar2);
            com.baidu.swan.c.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.f fVar) {
            String aqs = f.this.aqs();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.oO(aqs).azd().hQ(1);
            }
            super.Q(fVar);
            f.this.cSx.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.al.a a2 = f.this.a(fVar);
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.versionCode);
            if (a2 == null) {
                f.this.cSt = fVar;
                f.this.cSf.g(fVar);
                if (f.this.cSp != null) {
                    f.this.cSp.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.cSp.onCompleted();
                }
                c.aqg().a(fVar, f.this.aqn());
                return;
            }
            f.this.cSf.f(fVar);
            if (f.this.cSp != null) {
                f.this.cSp.onError(new PkgDownloadError(fVar, a2));
            }
            c.aqg().a(fVar, f.this.aqn(), a2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String aqs = f.this.aqs();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.oO(aqs).oP(fVar.toString()).hQ(1);
            }
            com.baidu.swan.apps.ao.e.b<i.a> bVar = new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.core.pms.f.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void L(i.a aVar) {
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cSj = new k<f>(this) { // from class: com.baidu.swan.apps.core.pms.f.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.anl();
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
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "sub onDownloadStart");
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
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.cSf.f(gVar);
            com.baidu.swan.apps.al.a aVar2 = new com.baidu.swan.apps.al.a().cV(12L).cW(aVar.errorNo).tm("分包下载失败").to(aVar.toString());
            if (f.this.cSq != null) {
                f.this.cSq.onError(new PkgDownloadError(gVar, aVar2));
            }
            c.aqg().a(gVar, f.this.aqn(), aVar2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k
        public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.al.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.versionCode);
            if (f.this.cSh == null) {
                f.this.cSh = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            if (aVar == null) {
                f.this.cSh.add(gVar);
                f.this.cSf.g(gVar);
                c.aqg().a(gVar, f.this.aqn());
            } else {
                f.this.cSf.f(gVar);
                c.aqg().a(gVar, f.this.aqn(), aVar);
            }
            if (f.this.cSq != null) {
                f.this.cSq.onNext(gVar);
                if (!f.this.cSf.bdE()) {
                    f.this.cSq.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cSF = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
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
                return com.baidu.swan.apps.core.pms.f.a.aqH();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aqI();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.anl();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.d dVar) {
            super.S(dVar);
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "framework onDownloadStart");
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
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.cSf.f(dVar);
            com.baidu.swan.apps.al.a aVar2 = new com.baidu.swan.apps.al.a().cV(13L).cW(aVar.errorNo).tm("Framework包下载失败").to(aVar.toString());
            if (f.this.cSr != null) {
                f.this.cSr.onError(new PkgDownloadError(dVar, aVar2));
            }
            c.aqg().a(dVar, f.this.aqn(), aVar2);
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.d dVar) {
            super.Q(dVar);
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.versionCode);
            com.baidu.swan.apps.al.a a2 = f.this.a(dVar);
            if (a2 == null) {
                f.this.cSu = dVar;
                f.this.cSf.g(dVar);
                if (f.this.cSr != null) {
                    f.this.cSr.onNext(dVar);
                    f.this.cSr.onCompleted();
                }
                c.aqg().a(dVar, f.this.aqn());
                return;
            }
            f.this.cSf.f(dVar);
            if (f.this.cSr != null) {
                f.this.cSr.onError(new PkgDownloadError(dVar, a2));
            }
            c.aqg().a(dVar, f.this.aqn(), a2);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cSG = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
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
                return com.baidu.swan.apps.core.pms.f.a.aqz();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aqJ();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.anl();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void S(com.baidu.swan.pms.model.b bVar) {
            super.S(bVar);
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "extension onDownloadStart");
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
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.cSf.f(bVar);
            com.baidu.swan.apps.al.a aVar2 = new com.baidu.swan.apps.al.a().cV(14L).cW(aVar.errorNo).tm("Extension下载失败").to(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", aVar2.toString());
            }
            f.this.c(bVar);
            c.aqg().a(bVar, f.this.aqn(), aVar2);
            com.baidu.swan.c.d.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void Q(com.baidu.swan.pms.model.b bVar) {
            super.Q(bVar);
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.versionCode);
            com.baidu.swan.apps.al.a a2 = f.this.a(bVar);
            if (a2 != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.cSf.f(bVar);
                f.this.c(bVar);
                c.aqg().a(bVar, f.this.aqn(), a2);
                return;
            }
            f.this.cSv = bVar;
            f.this.cSf.g(bVar);
            f.this.c(bVar);
            c.aqg().a(bVar, f.this.aqn());
        }
    };
    private com.baidu.swan.pms.a.f cSH = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void e(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.cSw = pMSAppInfo;
            if (f.this.cSw != null) {
                f.this.c(f.this.cSw);
                com.baidu.swan.apps.ac.g.b.ab(f.this.cSw.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> cSI = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", f.this.aqn() + " : 包下载onCompleted");
            f.this.aqm();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            com.baidu.swan.apps.console.c.g("SwanAppPkgDownloadCallback", f.this.aqn() + " : 包下载OnError", th);
            f.this.m(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", f.this.aqn() + " : 单个包下载、业务层处理完成：" + eVar.versionCode);
        }
    };
    protected List<UbcFlowEvent> cSx = new ArrayList();

    protected abstract PMSDownloadType aqn();

    protected abstract void m(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ank() {
        this.cSx.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqj() {
        this.cSx.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.errorNo == 1010) {
            aqt();
        }
        this.cSx.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cSA = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.cSA);
        }
        if (fVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + fVar.bdy());
            }
            this.cSx.add(new UbcFlowEvent("na_pms_start_download"));
            this.cSf = fVar;
            if (!this.cSf.isEmpty()) {
                aqw();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> aqo() {
        return this.cSE;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aql() {
        return this.cSj;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> aqp() {
        return this.cSF;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> aqq() {
        return this.cSG;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f aqr() {
        return this.cSH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aqs() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int anl() {
        return 100;
    }

    protected com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.f fVar) {
        if (fVar == null) {
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(11L).cW(2310L).to("pkg info is empty");
            com.baidu.swan.apps.al.e.aMQ().j(aVar);
            return aVar;
        }
        return null;
    }

    protected com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0474a h = com.baidu.swan.apps.swancore.d.a.h(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }
        if (h.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.al.a().cV(13L).cX(2907L).tm("Core包更新失败");
    }

    protected com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cZt = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.al.a().cV(14L).cX(2908L).tm("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gS(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.bci().ah(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.bci().ah(this.mAppId, 0);
        }
    }

    private void aqt() {
        PMSAppInfo xC = com.baidu.swan.pms.database.a.bci().xC(this.mAppId);
        com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + xC.createTime + " lastLaunchTime=" + xC.getLastLaunchTime() + " maxAge=" + xC.maxAge);
        if (xC != null) {
            xC.bct();
            xC.lO(aqA());
            if (this.cSt != null) {
                this.cSt.createTime = xC.createTime;
            }
            if (this.cSw != null) {
                this.cSw.createTime = xC.createTime;
                this.cSw.lO(aqA());
            }
            com.baidu.swan.pms.database.a.bci().r(xC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.al.a aqu() {
        if (this.cSw == null) {
            if (this.cSt == null) {
                return new com.baidu.swan.apps.al.a().cV(10L).cW(2903L).tm("Server未返回主包&AppInfo");
            }
            PMSAppInfo xC = com.baidu.swan.pms.database.a.bci().xC(this.mAppId);
            if (xC == null) {
                return new com.baidu.swan.apps.al.a().cV(10L).cW(2904L).tm("Server未返回AppInfo数据，本地也没有数据");
            }
            this.cSw = xC;
            com.baidu.swan.apps.core.pms.f.a.a(this.cSw, this.cSt);
            this.cSw.bct();
            this.cSw.lO(aqA());
            if (com.baidu.swan.pms.database.a.bci().a(this.cSt, this.cSh, this.cSu, this.cSv, this.cSw)) {
                return null;
            }
            return new com.baidu.swan.apps.al.a().cV(10L).cW(2906L).tm("更新DB失败");
        }
        if (this.cSt != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.cSw, this.cSt);
        } else if (com.baidu.swan.apps.core.pms.f.b.aE(this.cSh)) {
            this.cSz = this.cSh.get(0);
            this.cSz.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.cSw, this.cSz);
        } else {
            PMSAppInfo xC2 = com.baidu.swan.pms.database.a.bci().xC(this.mAppId);
            if (xC2 == null) {
                return new com.baidu.swan.apps.al.a().cV(10L).cW(2905L).tm("Server未返回包数据，本地也没有数据");
            }
            this.cSw.appId = this.mAppId;
            this.cSw.u(xC2);
        }
        this.cSw.bct();
        this.cSw.lO(aqA());
        if (com.baidu.swan.pms.database.a.bci().a(this.cSt, this.cSh, this.cSu, this.cSv, this.cSw)) {
            com.baidu.swan.apps.core.pms.f.a.g(this.cSw);
            return null;
        }
        return new com.baidu.swan.apps.al.a().cV(10L).cW(2906L).tm("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqv() {
        if (this.cSw != null) {
            PMSAppInfo xC = com.baidu.swan.pms.database.a.bci().xC(this.mAppId);
            if (xC == null) {
                com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                return;
            }
            this.cSw.appId = this.mAppId;
            xC.lO(aqA());
            this.cSw.u(xC);
            this.cSw.bct();
            if (com.baidu.swan.pms.database.a.bci().r(this.cSw)) {
                com.baidu.swan.apps.core.pms.f.a.g(this.cSw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqm() {
        com.baidu.swan.apps.console.c.i("SwanAppPkgDownloadCallback", "pms download time : " + (System.currentTimeMillis() - this.cSA));
    }

    public f c(com.baidu.swan.apps.ao.e.b<PMSAppInfo> bVar) {
        return d((Collection<Set<com.baidu.swan.apps.ao.e.b<PMSAppInfo>>>) this.cSC, (Set<com.baidu.swan.apps.ao.e.b<PMSAppInfo>>) bVar);
    }

    protected f c(final PMSAppInfo pMSAppInfo) {
        return a(this.cSC, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: e */
            public void L(com.baidu.swan.apps.ao.e.b<PMSAppInfo> bVar) {
                bVar.L(pMSAppInfo);
            }
        });
    }

    private synchronized <CallbackT> f d(final Collection<CallbackT> collection, final CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.cSD.m(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
                @Override // java.lang.Runnable
                public void run() {
                    collection.add(callbackt);
                }
            });
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized <CallbackT> f e(final Collection<CallbackT> collection, final CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.cSD.m(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.ao.e.b<CallbackT> bVar) {
        this.cSD.m(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : collection) {
                    bVar.L(obj);
                }
            }
        });
        return this;
    }

    public synchronized f a(com.baidu.swan.apps.core.pms.a.a aVar) {
        return d(this.cSB, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f d(@NonNull final com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a(this.cSB, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void L(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.L(aVar);
                f.this.e(f.this.cSB, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final com.baidu.swan.apps.al.a aVar, final boolean z) {
        d(new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void L(com.baidu.swan.apps.core.pms.a.a aVar2) {
                aVar2.b(aVar, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(final PMSAppInfo pMSAppInfo) {
        d(new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void L(com.baidu.swan.apps.core.pms.a.a aVar) {
                aVar.f(pMSAppInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        c.aqg().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cSt = fVar;
                f.this.cSf.g(fVar);
                if (f.this.cSp != null) {
                    f.this.cSp.onNext(fVar);
                    f.this.cSp.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cSf.f(fVar);
                if (f.this.cSp != null) {
                    f.this.cSp.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.aqg().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.cSh == null) {
                    f.this.cSh = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.cSh.add(gVar);
                f.this.cSf.g(gVar);
                if (f.this.cSq != null) {
                    f.this.cSq.onNext(gVar);
                    if (!f.this.cSf.bdE()) {
                        f.this.cSq.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cSf.f(gVar);
                if (f.this.cSq != null) {
                    f.this.cSq.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.aqg().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cSu = dVar;
                f.this.cSf.g(dVar);
                if (f.this.cSr != null) {
                    f.this.cSr.onNext(dVar);
                    f.this.cSr.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cSf.f(dVar);
                if (f.this.cSr != null) {
                    f.this.cSr.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.aqg().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f.this.cSv = bVar;
                f.this.cSf.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                com.baidu.swan.apps.console.c.br("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                f.this.cSf.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.cSs != null) {
            this.cSs.onNext(bVar);
            this.cSs.onCompleted();
        }
    }

    private void aqw() {
        ArrayList arrayList = new ArrayList();
        if (this.cSf.bdz()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.cSp = jVar;
                }
            }));
        }
        if (this.cSf.bdA()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.cSq = jVar;
                }
            }));
        }
        if (this.cSf.bdC()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.cSr = jVar;
                }
            }));
        }
        if (this.cSf.bdD()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.cSs = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.cSI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bC(String str, String str2) {
        com.baidu.swan.apps.performance.f.a.a(this.mAppId, str, this.cSx, str2);
        this.cSx.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
