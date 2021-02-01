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
/* loaded from: classes9.dex */
public abstract class f extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private rx.j<? super com.baidu.swan.pms.model.f> cUC;
    private rx.j<? super com.baidu.swan.pms.model.g> cUD;
    private rx.j<? super com.baidu.swan.pms.model.d> cUE;
    private rx.j<? super com.baidu.swan.pms.model.b> cUF;
    protected com.baidu.swan.pms.model.f cUG;
    protected com.baidu.swan.pms.model.d cUH;
    protected com.baidu.swan.pms.model.b cUI;
    protected PMSAppInfo cUJ;
    protected com.baidu.swan.pms.model.g cUM;
    protected com.baidu.swan.pms.utils.f cUs;
    protected List<com.baidu.swan.pms.model.g> cUu;
    protected String mAppId;
    private String mClassName = "";
    protected String cUL = "0";
    private long cUN = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> cUO = new HashSet();
    private final Set<com.baidu.swan.apps.ao.e.b<PMSAppInfo>> cUP = new HashSet();
    private final aq cUQ = new aq();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> cUR = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
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
                return com.baidu.swan.apps.core.pms.f.a.ard();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.are();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.anJ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.f fVar) {
            String aqQ = f.this.aqQ();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pg(aqQ).azB().hT(1);
            }
            super.S(fVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void T(com.baidu.swan.pms.model.f fVar) {
            String aqQ = f.this.aqQ();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pg(aqQ).azB().hT(1);
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
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.cUs.f(fVar);
            com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(11L).dc(aVar.errorNo).tF("主包下载失败").tH(aVar.toString());
            if (f.this.cUC != null) {
                f.this.cUC.onError(new PkgDownloadError(fVar, tH));
            }
            c.aqE().a(fVar, f.this.aqL(), tH);
            com.baidu.swan.c.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.f fVar) {
            String aqQ = f.this.aqQ();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pg(aqQ).azB().hT(1);
            }
            super.Q(fVar);
            f.this.cUK.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.al.a a2 = f.this.a(fVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.versionCode);
            if (a2 == null) {
                f.this.cUG = fVar;
                f.this.cUs.g(fVar);
                if (f.this.cUC != null) {
                    f.this.cUC.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.cUC.onCompleted();
                }
                c.aqE().a(fVar, f.this.aqL());
                return;
            }
            f.this.cUs.f(fVar);
            if (f.this.cUC != null) {
                f.this.cUC.onError(new PkgDownloadError(fVar, a2));
            }
            c.aqE().a(fVar, f.this.aqL(), a2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String aqQ = f.this.aqQ();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pg(aqQ).ph(fVar.toString()).hT(1);
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cUw = new k<f>(this) { // from class: com.baidu.swan.apps.core.pms.f.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.anJ();
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
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "sub onDownloadStart");
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
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.cUs.f(gVar);
            com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(12L).dc(aVar.errorNo).tF("分包下载失败").tH(aVar.toString());
            if (f.this.cUD != null) {
                f.this.cUD.onError(new PkgDownloadError(gVar, tH));
            }
            c.aqE().a(gVar, f.this.aqL(), tH);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k
        public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.al.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.versionCode);
            if (f.this.cUu == null) {
                f.this.cUu = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            if (aVar == null) {
                f.this.cUu.add(gVar);
                f.this.cUs.g(gVar);
                c.aqE().a(gVar, f.this.aqL());
            } else {
                f.this.cUs.f(gVar);
                c.aqE().a(gVar, f.this.aqL(), aVar);
            }
            if (f.this.cUD != null) {
                f.this.cUD.onNext(gVar);
                if (!f.this.cUs.bdR()) {
                    f.this.cUD.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cUS = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
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
                return com.baidu.swan.apps.core.pms.f.a.arf();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.arg();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.anJ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.d dVar) {
            super.S(dVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "framework onDownloadStart");
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
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.cUs.f(dVar);
            com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(13L).dc(aVar.errorNo).tF("Framework包下载失败").tH(aVar.toString());
            if (f.this.cUE != null) {
                f.this.cUE.onError(new PkgDownloadError(dVar, tH));
            }
            c.aqE().a(dVar, f.this.aqL(), tH);
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.d dVar) {
            super.Q(dVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.versionCode);
            com.baidu.swan.apps.al.a a2 = f.this.a(dVar);
            if (a2 == null) {
                f.this.cUH = dVar;
                f.this.cUs.g(dVar);
                if (f.this.cUE != null) {
                    f.this.cUE.onNext(dVar);
                    f.this.cUE.onCompleted();
                }
                c.aqE().a(dVar, f.this.aqL());
                return;
            }
            f.this.cUs.f(dVar);
            if (f.this.cUE != null) {
                f.this.cUE.onError(new PkgDownloadError(dVar, a2));
            }
            c.aqE().a(dVar, f.this.aqL(), a2);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cUT = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
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
                return com.baidu.swan.apps.core.pms.f.a.aqX();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.arh();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.anJ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void S(com.baidu.swan.pms.model.b bVar) {
            super.S(bVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "extension onDownloadStart");
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
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.cUs.f(bVar);
            com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(14L).dc(aVar.errorNo).tF("Extension下载失败").tH(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", tH.toString());
            }
            f.this.c(bVar);
            c.aqE().a(bVar, f.this.aqL(), tH);
            com.baidu.swan.c.d.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void Q(com.baidu.swan.pms.model.b bVar) {
            super.Q(bVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.versionCode);
            com.baidu.swan.apps.al.a a2 = f.this.a(bVar);
            if (a2 != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.cUs.f(bVar);
                f.this.c(bVar);
                c.aqE().a(bVar, f.this.aqL(), a2);
                return;
            }
            f.this.cUI = bVar;
            f.this.cUs.g(bVar);
            f.this.c(bVar);
            c.aqE().a(bVar, f.this.aqL());
        }
    };
    private com.baidu.swan.pms.a.f cUU = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void e(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.cUJ = pMSAppInfo;
            if (f.this.cUJ != null) {
                f.this.c(f.this.cUJ);
                com.baidu.swan.apps.ac.g.b.aa(f.this.cUJ.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> cUV = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", f.this.aqL() + " : 包下载onCompleted");
            f.this.aqK();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            com.baidu.swan.apps.console.c.g("SwanAppPkgDownloadCallback", f.this.aqL() + " : 包下载OnError", th);
            f.this.l(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", f.this.aqL() + " : 单个包下载、业务层处理完成：" + eVar.versionCode);
        }
    };
    protected List<UbcFlowEvent> cUK = new ArrayList();

    protected abstract PMSDownloadType aqL();

    protected abstract void l(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void anI() {
        this.cUK.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqH() {
        this.cUK.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.errorNo == 1010) {
            aqR();
        }
        this.cUK.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cUN = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.cUN);
        }
        if (fVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + fVar.bdL());
            }
            this.cUK.add(new UbcFlowEvent("na_pms_start_download"));
            this.cUs = fVar;
            if (!this.cUs.isEmpty()) {
                aqU();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> aqM() {
        return this.cUR;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aqJ() {
        return this.cUw;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> aqN() {
        return this.cUS;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> aqO() {
        return this.cUT;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f aqP() {
        return this.cUU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aqQ() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int anJ() {
        return 100;
    }

    protected com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.f fVar) {
        if (fVar == null) {
            com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(11L).dc(2310L).tH("pkg info is empty");
            com.baidu.swan.apps.al.e.aNj().j(tH);
            return tH;
        }
        return null;
    }

    protected com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0471a h = com.baidu.swan.apps.swancore.d.a.h(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }
        if (h.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.al.a().db(13L).dd(2907L).tF("Core包更新失败");
    }

    protected com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.dbF = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.al.a().db(14L).dd(2908L).tF("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gV(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.bcv().aj(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.bcv().aj(this.mAppId, 0);
        }
    }

    private void aqR() {
        PMSAppInfo xV = com.baidu.swan.pms.database.a.bcv().xV(this.mAppId);
        com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + xV.createTime + " lastLaunchTime=" + xV.getLastLaunchTime() + " maxAge=" + xV.maxAge);
        if (xV != null) {
            xV.bcG();
            xV.lR(aqY());
            if (this.cUG != null) {
                this.cUG.createTime = xV.createTime;
            }
            if (this.cUJ != null) {
                this.cUJ.createTime = xV.createTime;
                this.cUJ.lR(aqY());
            }
            com.baidu.swan.pms.database.a.bcv().r(xV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.al.a aqS() {
        if (this.cUJ == null) {
            if (this.cUG == null) {
                return new com.baidu.swan.apps.al.a().db(10L).dc(2903L).tF("Server未返回主包&AppInfo");
            }
            PMSAppInfo xV = com.baidu.swan.pms.database.a.bcv().xV(this.mAppId);
            if (xV == null) {
                return new com.baidu.swan.apps.al.a().db(10L).dc(2904L).tF("Server未返回AppInfo数据，本地也没有数据");
            }
            this.cUJ = xV;
            com.baidu.swan.apps.core.pms.f.a.a(this.cUJ, this.cUG);
            this.cUJ.bcG();
            this.cUJ.lR(aqY());
            if (com.baidu.swan.pms.database.a.bcv().a(this.cUG, this.cUu, this.cUH, this.cUI, this.cUJ)) {
                return null;
            }
            return new com.baidu.swan.apps.al.a().db(10L).dc(2906L).tF("更新DB失败");
        }
        if (this.cUG != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.cUJ, this.cUG);
        } else if (com.baidu.swan.apps.core.pms.f.b.az(this.cUu)) {
            this.cUM = this.cUu.get(0);
            this.cUM.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.cUJ, this.cUM);
        } else {
            PMSAppInfo xV2 = com.baidu.swan.pms.database.a.bcv().xV(this.mAppId);
            if (xV2 == null) {
                return new com.baidu.swan.apps.al.a().db(10L).dc(2905L).tF("Server未返回包数据，本地也没有数据");
            }
            this.cUJ.appId = this.mAppId;
            this.cUJ.u(xV2);
        }
        this.cUJ.bcG();
        this.cUJ.lR(aqY());
        if (com.baidu.swan.pms.database.a.bcv().a(this.cUG, this.cUu, this.cUH, this.cUI, this.cUJ)) {
            com.baidu.swan.apps.core.pms.f.a.g(this.cUJ);
            return null;
        }
        return new com.baidu.swan.apps.al.a().db(10L).dc(2906L).tF("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqT() {
        if (this.cUJ != null) {
            PMSAppInfo xV = com.baidu.swan.pms.database.a.bcv().xV(this.mAppId);
            if (xV == null) {
                com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                return;
            }
            this.cUJ.appId = this.mAppId;
            xV.lR(aqY());
            this.cUJ.u(xV);
            this.cUJ.bcG();
            if (com.baidu.swan.pms.database.a.bcv().r(this.cUJ)) {
                com.baidu.swan.apps.core.pms.f.a.g(this.cUJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqK() {
        com.baidu.swan.apps.console.c.i("SwanAppPkgDownloadCallback", "pms download time : " + (System.currentTimeMillis() - this.cUN));
    }

    public f c(com.baidu.swan.apps.ao.e.b<PMSAppInfo> bVar) {
        return d((Collection<Set<com.baidu.swan.apps.ao.e.b<PMSAppInfo>>>) this.cUP, (Set<com.baidu.swan.apps.ao.e.b<PMSAppInfo>>) bVar);
    }

    protected f c(final PMSAppInfo pMSAppInfo) {
        return a(this.cUP, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
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
            this.cUQ.l(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
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
            this.cUQ.l(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.ao.e.b<CallbackT> bVar) {
        this.cUQ.l(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
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
        return d(this.cUO, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f d(@NonNull final com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a(this.cUO, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void L(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.L(aVar);
                f.this.e(f.this.cUO, aVar);
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
        c.aqE().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cUG = fVar;
                f.this.cUs.g(fVar);
                if (f.this.cUC != null) {
                    f.this.cUC.onNext(fVar);
                    f.this.cUC.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cUs.f(fVar);
                if (f.this.cUC != null) {
                    f.this.cUC.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.aqE().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.cUu == null) {
                    f.this.cUu = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.cUu.add(gVar);
                f.this.cUs.g(gVar);
                if (f.this.cUD != null) {
                    f.this.cUD.onNext(gVar);
                    if (!f.this.cUs.bdR()) {
                        f.this.cUD.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cUs.f(gVar);
                if (f.this.cUD != null) {
                    f.this.cUD.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.aqE().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cUH = dVar;
                f.this.cUs.g(dVar);
                if (f.this.cUE != null) {
                    f.this.cUE.onNext(dVar);
                    f.this.cUE.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cUs.f(dVar);
                if (f.this.cUE != null) {
                    f.this.cUE.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.aqE().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f.this.cUI = bVar;
                f.this.cUs.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                f.this.cUs.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.cUF != null) {
            this.cUF.onNext(bVar);
            this.cUF.onCompleted();
        }
    }

    private void aqU() {
        ArrayList arrayList = new ArrayList();
        if (this.cUs.bdM()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.cUC = jVar;
                }
            }));
        }
        if (this.cUs.bdN()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.cUD = jVar;
                }
            }));
        }
        if (this.cUs.bdP()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.cUE = jVar;
                }
            }));
        }
        if (this.cUs.bdQ()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.cUF = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.cUV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bw(String str, String str2) {
        com.baidu.swan.apps.performance.f.a.a(this.mAppId, str, this.cUK, str2);
        this.cUK.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
