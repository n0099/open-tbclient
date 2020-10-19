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
    private rx.j<? super com.baidu.swan.pms.model.f> cyG;
    private rx.j<? super com.baidu.swan.pms.model.g> cyH;
    private rx.j<? super com.baidu.swan.pms.model.d> cyI;
    private rx.j<? super com.baidu.swan.pms.model.b> cyJ;
    protected com.baidu.swan.pms.model.f cyK;
    protected com.baidu.swan.pms.model.d cyL;
    protected com.baidu.swan.pms.model.b cyM;
    protected PMSAppInfo cyN;
    protected com.baidu.swan.pms.model.g cyQ;
    protected com.baidu.swan.pms.utils.f cyw;
    protected List<com.baidu.swan.pms.model.g> cyy;
    protected String mAppId;
    private String mClassName = "";
    protected String cyP = "0";
    private long cyR = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> cyS = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>> cyT = new HashSet();
    private final aq cyU = new aq();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> cyV = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
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
                return com.baidu.swan.apps.core.pms.f.a.amn();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.amo();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.aiZ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.f fVar) {
            String ama = f.this.ama();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.oY(ama).auK().iM(1);
            }
            super.S(fVar);
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void T(com.baidu.swan.pms.model.f fVar) {
            String ama = f.this.ama();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.oY(ama).auK().iM(1);
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
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.cyw.f(fVar);
            com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(11L).bY(aVar.errorNo).tr("主包下载失败").tt(aVar.toString());
            if (f.this.cyG != null) {
                f.this.cyG.onError(new PkgDownloadError(fVar, tt));
            }
            c.alO().a(fVar, f.this.alV(), tt);
            com.baidu.swan.c.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.f fVar) {
            String ama = f.this.ama();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.oY(ama).auK().iM(1);
            }
            super.Q(fVar);
            f.this.cyO.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.am.a a2 = f.this.a(fVar);
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.versionCode);
            if (a2 == null) {
                f.this.cyK = fVar;
                f.this.cyw.g(fVar);
                if (f.this.cyG != null) {
                    f.this.cyG.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.cyG.onCompleted();
                }
                c.alO().a(fVar, f.this.alV());
                return;
            }
            f.this.cyw.f(fVar);
            if (f.this.cyG != null) {
                f.this.cyG.onError(new PkgDownloadError(fVar, a2));
            }
            c.alO().a(fVar, f.this.alV(), a2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String ama = f.this.ama();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.oY(ama).oZ(fVar.toString()).iM(1);
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cyA = new k<f>(this) { // from class: com.baidu.swan.apps.core.pms.f.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.aiZ();
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
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "sub onDownloadStart");
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
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.cyw.f(gVar);
            com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(12L).bY(aVar.errorNo).tr("分包下载失败").tt(aVar.toString());
            if (f.this.cyH != null) {
                f.this.cyH.onError(new PkgDownloadError(gVar, tt));
            }
            c.alO().a(gVar, f.this.alV(), tt);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k
        public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.versionCode);
            if (f.this.cyy == null) {
                f.this.cyy = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            if (aVar == null) {
                f.this.cyy.add(gVar);
                f.this.cyw.g(gVar);
                c.alO().a(gVar, f.this.alV());
            } else {
                f.this.cyw.f(gVar);
                c.alO().a(gVar, f.this.alV(), aVar);
            }
            if (f.this.cyH != null) {
                f.this.cyH.onNext(gVar);
                if (!f.this.cyw.aYl()) {
                    f.this.cyH.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cyW = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
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
                return com.baidu.swan.apps.core.pms.f.a.amp();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.amq();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.aiZ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.d dVar) {
            super.S(dVar);
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "framework onDownloadStart");
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
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.cyw.f(dVar);
            com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(13L).bY(aVar.errorNo).tr("Framework包下载失败").tt(aVar.toString());
            if (f.this.cyI != null) {
                f.this.cyI.onError(new PkgDownloadError(dVar, tt));
            }
            c.alO().a(dVar, f.this.alV(), tt);
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.d dVar) {
            super.Q(dVar);
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.versionCode);
            com.baidu.swan.apps.am.a a2 = f.this.a(dVar);
            if (a2 == null) {
                f.this.cyL = dVar;
                f.this.cyw.g(dVar);
                if (f.this.cyI != null) {
                    f.this.cyI.onNext(dVar);
                    f.this.cyI.onCompleted();
                }
                c.alO().a(dVar, f.this.alV());
                return;
            }
            f.this.cyw.f(dVar);
            if (f.this.cyI != null) {
                f.this.cyI.onError(new PkgDownloadError(dVar, a2));
            }
            c.alO().a(dVar, f.this.alV(), a2);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cyX = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
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
                return com.baidu.swan.apps.core.pms.f.a.amh();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.amr();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.aiZ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void S(com.baidu.swan.pms.model.b bVar) {
            super.S(bVar);
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "extension onDownloadStart");
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
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.cyw.f(bVar);
            com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(14L).bY(aVar.errorNo).tr("Extension下载失败").tt(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", tt.toString());
            }
            f.this.c(bVar);
            c.alO().a(bVar, f.this.alV(), tt);
            com.baidu.swan.c.d.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void Q(com.baidu.swan.pms.model.b bVar) {
            super.Q(bVar);
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.versionCode);
            com.baidu.swan.apps.am.a a2 = f.this.a(bVar);
            if (a2 != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.cyw.f(bVar);
                f.this.c(bVar);
                c.alO().a(bVar, f.this.alV(), a2);
                return;
            }
            f.this.cyM = bVar;
            f.this.cyw.g(bVar);
            f.this.c(bVar);
            c.alO().a(bVar, f.this.alV());
        }
    };
    private com.baidu.swan.pms.a.f cyY = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void e(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.cyN = pMSAppInfo;
            if (f.this.cyN != null) {
                f.this.c(f.this.cyN);
                com.baidu.swan.apps.ac.g.b.Y(f.this.cyN.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> cyZ = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", f.this.alV() + " : 包下载onCompleted");
            f.this.alU();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            com.baidu.swan.apps.console.c.f("SwanAppPkgDownloadCallback", f.this.alV() + " : 包下载OnError", th);
            f.this.o(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", f.this.alV() + " : 单个包下载、业务层处理完成：" + eVar.versionCode);
        }
    };
    protected List<UbcFlowEvent> cyO = new ArrayList();

    protected abstract PMSDownloadType alV();

    protected abstract void o(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiY() {
        this.cyO.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void alR() {
        this.cyO.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.errorNo == 1010) {
            amb();
        }
        this.cyO.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cyR = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.cyR);
        }
        if (fVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + fVar.aYf());
            }
            this.cyO.add(new UbcFlowEvent("na_pms_start_download"));
            this.cyw = fVar;
            if (!this.cyw.isEmpty()) {
                ame();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> alW() {
        return this.cyV;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> alT() {
        return this.cyA;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> alX() {
        return this.cyW;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> alY() {
        return this.cyX;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f alZ() {
        return this.cyY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ama() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int aiZ() {
        return 100;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.f fVar) {
        if (fVar == null) {
            com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(11L).bY(2310L).tt("pkg info is empty");
            com.baidu.swan.apps.am.e.aHz().j(tt);
            return tt;
        }
        return null;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0462a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.am.a().bX(13L).bZ(2907L).tr("Core包更新失败");
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cFP = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.am.a().bX(14L).bZ(2908L).tr("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hO(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.aWO().ac(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.aWO().ac(this.mAppId, 0);
        }
    }

    private void amb() {
        PMSAppInfo xF = com.baidu.swan.pms.database.a.aWO().xF(this.mAppId);
        com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + xF.createTime + " lastLaunchTime=" + xF.getLastLaunchTime() + " maxAge=" + xF.maxAge);
        if (xF != null) {
            xF.aWZ();
            xF.mw(ami());
            if (this.cyK != null) {
                this.cyK.createTime = xF.createTime;
            }
            if (this.cyN != null) {
                this.cyN.createTime = xF.createTime;
                this.cyN.mw(ami());
            }
            com.baidu.swan.pms.database.a.aWO().r(xF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.am.a amc() {
        if (this.cyN == null) {
            if (this.cyK == null) {
                return new com.baidu.swan.apps.am.a().bX(10L).bY(2903L).tr("Server未返回主包&AppInfo");
            }
            PMSAppInfo xF = com.baidu.swan.pms.database.a.aWO().xF(this.mAppId);
            if (xF == null) {
                return new com.baidu.swan.apps.am.a().bX(10L).bY(2904L).tr("Server未返回AppInfo数据，本地也没有数据");
            }
            this.cyN = xF;
            com.baidu.swan.apps.core.pms.f.a.a(this.cyN, this.cyK);
            this.cyN.aWZ();
            this.cyN.mw(ami());
            if (com.baidu.swan.pms.database.a.aWO().a(this.cyK, this.cyy, this.cyL, this.cyM, this.cyN)) {
                return null;
            }
            return new com.baidu.swan.apps.am.a().bX(10L).bY(2906L).tr("更新DB失败");
        }
        if (this.cyK != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.cyN, this.cyK);
        } else if (com.baidu.swan.apps.core.pms.f.b.ag(this.cyy)) {
            this.cyQ = this.cyy.get(0);
            this.cyQ.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.cyN, this.cyQ);
        } else {
            PMSAppInfo xF2 = com.baidu.swan.pms.database.a.aWO().xF(this.mAppId);
            if (xF2 == null) {
                return new com.baidu.swan.apps.am.a().bX(10L).bY(2905L).tr("Server未返回包数据，本地也没有数据");
            }
            this.cyN.appId = this.mAppId;
            this.cyN.u(xF2);
        }
        this.cyN.aWZ();
        this.cyN.mw(ami());
        if (com.baidu.swan.pms.database.a.aWO().a(this.cyK, this.cyy, this.cyL, this.cyM, this.cyN)) {
            com.baidu.swan.apps.core.pms.f.a.g(this.cyN);
            return null;
        }
        return new com.baidu.swan.apps.am.a().bX(10L).bY(2906L).tr("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amd() {
        if (this.cyN != null) {
            PMSAppInfo xF = com.baidu.swan.pms.database.a.aWO().xF(this.mAppId);
            if (xF == null) {
                com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                return;
            }
            this.cyN.appId = this.mAppId;
            xF.mw(ami());
            this.cyN.u(xF);
            this.cyN.aWZ();
            if (com.baidu.swan.pms.database.a.aWO().r(this.cyN)) {
                com.baidu.swan.apps.core.pms.f.a.g(this.cyN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alU() {
        com.baidu.swan.apps.console.c.i("SwanAppPkgDownloadCallback", "pms download time : " + (System.currentTimeMillis() - this.cyR));
    }

    public f c(com.baidu.swan.apps.ap.e.b<PMSAppInfo> bVar) {
        return a((Collection<Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>>) this.cyT, (Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>) bVar);
    }

    protected f c(final PMSAppInfo pMSAppInfo) {
        return a((Collection) this.cyT, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
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
            this.cyU.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
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
            this.cyU.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.ap.e.b<CallbackT> bVar) {
        this.cyU.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
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
        return a(this.cyS, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f d(@NonNull final com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a((Collection) this.cyS, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.M(aVar);
                f.this.b((Collection<Set>) f.this.cyS, (Set) aVar);
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
        c.alO().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cyK = fVar;
                f.this.cyw.g(fVar);
                if (f.this.cyG != null) {
                    f.this.cyG.onNext(fVar);
                    f.this.cyG.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cyw.f(fVar);
                if (f.this.cyG != null) {
                    f.this.cyG.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.alO().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.cyy == null) {
                    f.this.cyy = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.cyy.add(gVar);
                f.this.cyw.g(gVar);
                if (f.this.cyH != null) {
                    f.this.cyH.onNext(gVar);
                    if (!f.this.cyw.aYl()) {
                        f.this.cyH.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cyw.f(gVar);
                if (f.this.cyH != null) {
                    f.this.cyH.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.alO().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cyL = dVar;
                f.this.cyw.g(dVar);
                if (f.this.cyI != null) {
                    f.this.cyI.onNext(dVar);
                    f.this.cyI.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cyw.f(dVar);
                if (f.this.cyI != null) {
                    f.this.cyI.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.alO().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f.this.cyM = bVar;
                f.this.cyw.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                com.baidu.swan.apps.console.c.bg("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                f.this.cyw.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.cyJ != null) {
            this.cyJ.onNext(bVar);
            this.cyJ.onCompleted();
        }
    }

    private void ame() {
        ArrayList arrayList = new ArrayList();
        if (this.cyw.aYg()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.cyG = jVar;
                }
            }));
        }
        if (this.cyw.aYh()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.cyH = jVar;
                }
            }));
        }
        if (this.cyw.aYj()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.cyI = jVar;
                }
            }));
        }
        if (this.cyw.aYk()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.cyJ = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.cyZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void br(String str, String str2) {
        com.baidu.swan.apps.performance.f.a.a(this.mAppId, str, this.cyO, str2);
        this.cyO.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
