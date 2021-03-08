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
    protected com.baidu.swan.pms.utils.f cVS;
    protected List<com.baidu.swan.pms.model.g> cVU;
    private rx.j<? super com.baidu.swan.pms.model.f> cWc;
    private rx.j<? super com.baidu.swan.pms.model.g> cWd;
    private rx.j<? super com.baidu.swan.pms.model.d> cWe;
    private rx.j<? super com.baidu.swan.pms.model.b> cWf;
    protected com.baidu.swan.pms.model.f cWg;
    protected com.baidu.swan.pms.model.d cWh;
    protected com.baidu.swan.pms.model.b cWi;
    protected PMSAppInfo cWj;
    protected com.baidu.swan.pms.model.g cWm;
    protected String mAppId;
    private String mClassName = "";
    protected String cWl = "0";
    private long cWn = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> cWo = new HashSet();
    private final Set<com.baidu.swan.apps.ao.e.b<PMSAppInfo>> cWp = new HashSet();
    private final aq cWq = new aq();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> cWr = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String W(com.baidu.swan.pms.model.f fVar) {
            if (fVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.arg();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.arh();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.anM();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void U(com.baidu.swan.pms.model.f fVar) {
            String aqT = f.this.aqT();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pn(aqT).azE().hU(1);
            }
            super.U(fVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void V(com.baidu.swan.pms.model.f fVar) {
            String aqT = f.this.aqT();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pn(aqT).azE().hU(1);
            }
            super.V(fVar);
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
            f.this.cVS.f(fVar);
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(11L).dc(aVar.errorNo).tM("主包下载失败").tO(aVar.toString());
            if (f.this.cWc != null) {
                f.this.cWc.onError(new PkgDownloadError(fVar, tO));
            }
            c.aqH().a(fVar, f.this.aqO(), tO);
            com.baidu.swan.c.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void S(com.baidu.swan.pms.model.f fVar) {
            String aqT = f.this.aqT();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pn(aqT).azE().hU(1);
            }
            super.S(fVar);
            f.this.cWk.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.al.a a2 = f.this.a(fVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.versionCode);
            if (a2 == null) {
                f.this.cWg = fVar;
                f.this.cVS.g(fVar);
                if (f.this.cWc != null) {
                    f.this.cWc.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.cWc.onCompleted();
                }
                c.aqH().a(fVar, f.this.aqO());
                return;
            }
            f.this.cVS.f(fVar);
            if (f.this.cWc != null) {
                f.this.cWc.onError(new PkgDownloadError(fVar, a2));
            }
            c.aqH().a(fVar, f.this.aqO(), a2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String aqT = f.this.aqT();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pn(aqT).po(fVar.toString()).hU(1);
            }
            com.baidu.swan.apps.ao.e.b<i.a> bVar = new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.core.pms.f.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: b */
                public void N(i.a aVar) {
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cVW = new k<f>(this) { // from class: com.baidu.swan.apps.core.pms.f.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.anM();
        }

        @Override // com.baidu.swan.apps.core.pms.k
        public String getAppKey() {
            return f.this.mAppId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void U(com.baidu.swan.pms.model.g gVar) {
            super.U(gVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "sub onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void V(com.baidu.swan.pms.model.g gVar) {
            super.V(gVar);
            f.this.b(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.g gVar, com.baidu.swan.pms.model.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.cVS.f(gVar);
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(12L).dc(aVar.errorNo).tM("分包下载失败").tO(aVar.toString());
            if (f.this.cWd != null) {
                f.this.cWd.onError(new PkgDownloadError(gVar, tO));
            }
            c.aqH().a(gVar, f.this.aqO(), tO);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k
        public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.al.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.versionCode);
            if (f.this.cVU == null) {
                f.this.cVU = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            if (aVar == null) {
                f.this.cVU.add(gVar);
                f.this.cVS.g(gVar);
                c.aqH().a(gVar, f.this.aqO());
            } else {
                f.this.cVS.f(gVar);
                c.aqH().a(gVar, f.this.aqO(), aVar);
            }
            if (f.this.cWd != null) {
                f.this.cWd.onNext(gVar);
                if (!f.this.cVS.bdT()) {
                    f.this.cWd.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cWs = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String W(com.baidu.swan.pms.model.d dVar) {
            if (dVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.ari();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.arj();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.anM();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void U(com.baidu.swan.pms.model.d dVar) {
            super.U(dVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "framework onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void V(com.baidu.swan.pms.model.d dVar) {
            super.V(dVar);
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
            f.this.cVS.f(dVar);
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(13L).dc(aVar.errorNo).tM("Framework包下载失败").tO(aVar.toString());
            if (f.this.cWe != null) {
                f.this.cWe.onError(new PkgDownloadError(dVar, tO));
            }
            c.aqH().a(dVar, f.this.aqO(), tO);
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void S(com.baidu.swan.pms.model.d dVar) {
            super.S(dVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.versionCode);
            com.baidu.swan.apps.al.a a2 = f.this.a(dVar);
            if (a2 == null) {
                f.this.cWh = dVar;
                f.this.cVS.g(dVar);
                if (f.this.cWe != null) {
                    f.this.cWe.onNext(dVar);
                    f.this.cWe.onCompleted();
                }
                c.aqH().a(dVar, f.this.aqO());
                return;
            }
            f.this.cVS.f(dVar);
            if (f.this.cWe != null) {
                f.this.cWe.onError(new PkgDownloadError(dVar, a2));
            }
            c.aqH().a(dVar, f.this.aqO(), a2);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cWt = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String W(com.baidu.swan.pms.model.b bVar) {
            if (bVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.ara();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.ark();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.anM();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void U(com.baidu.swan.pms.model.b bVar) {
            super.U(bVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "extension onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void V(com.baidu.swan.pms.model.b bVar) {
            super.V(bVar);
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
            f.this.cVS.f(bVar);
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(14L).dc(aVar.errorNo).tM("Extension下载失败").tO(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", tO.toString());
            }
            f.this.c(bVar);
            c.aqH().a(bVar, f.this.aqO(), tO);
            com.baidu.swan.c.d.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void S(com.baidu.swan.pms.model.b bVar) {
            super.S(bVar);
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.versionCode);
            com.baidu.swan.apps.al.a a2 = f.this.a(bVar);
            if (a2 != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.cVS.f(bVar);
                f.this.c(bVar);
                c.aqH().a(bVar, f.this.aqO(), a2);
                return;
            }
            f.this.cWi = bVar;
            f.this.cVS.g(bVar);
            f.this.c(bVar);
            c.aqH().a(bVar, f.this.aqO());
        }
    };
    private com.baidu.swan.pms.a.f cWu = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void e(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.cWj = pMSAppInfo;
            if (f.this.cWj != null) {
                f.this.c(f.this.cWj);
                com.baidu.swan.apps.ac.g.b.aa(f.this.cWj.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> cWv = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", f.this.aqO() + " : 包下载onCompleted");
            f.this.aqN();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            com.baidu.swan.apps.console.c.g("SwanAppPkgDownloadCallback", f.this.aqO() + " : 包下载OnError", th);
            f.this.l(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", f.this.aqO() + " : 单个包下载、业务层处理完成：" + eVar.versionCode);
        }
    };
    protected List<UbcFlowEvent> cWk = new ArrayList();

    protected abstract PMSDownloadType aqO();

    protected abstract void l(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void anL() {
        this.cWk.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqK() {
        this.cWk.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.errorNo == 1010) {
            aqU();
        }
        this.cWk.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cWn = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.cWn);
        }
        if (fVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + fVar.bdN());
            }
            this.cWk.add(new UbcFlowEvent("na_pms_start_download"));
            this.cVS = fVar;
            if (!this.cVS.isEmpty()) {
                aqX();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> aqP() {
        return this.cWr;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aqM() {
        return this.cVW;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> aqQ() {
        return this.cWs;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> aqR() {
        return this.cWt;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f aqS() {
        return this.cWu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aqT() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int anM() {
        return 100;
    }

    protected com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.f fVar) {
        if (fVar == null) {
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(11L).dc(2310L).tO("pkg info is empty");
            com.baidu.swan.apps.al.e.aNm().j(tO);
            return tO;
        }
        return null;
    }

    protected com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0477a h = com.baidu.swan.apps.swancore.d.a.h(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }
        if (h.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.al.a().db(13L).dd(2907L).tM("Core包更新失败");
    }

    protected com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.ddh = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.al.a().db(14L).dd(2908L).tM("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gW(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.bcx().ak(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.bcx().ak(this.mAppId, 0);
        }
    }

    private void aqU() {
        PMSAppInfo yc = com.baidu.swan.pms.database.a.bcx().yc(this.mAppId);
        com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + yc.createTime + " lastLaunchTime=" + yc.getLastLaunchTime() + " maxAge=" + yc.maxAge);
        if (yc != null) {
            yc.bcI();
            yc.lS(arb());
            if (this.cWg != null) {
                this.cWg.createTime = yc.createTime;
            }
            if (this.cWj != null) {
                this.cWj.createTime = yc.createTime;
                this.cWj.lS(arb());
            }
            com.baidu.swan.pms.database.a.bcx().r(yc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.al.a aqV() {
        if (this.cWj == null) {
            if (this.cWg == null) {
                return new com.baidu.swan.apps.al.a().db(10L).dc(2903L).tM("Server未返回主包&AppInfo");
            }
            PMSAppInfo yc = com.baidu.swan.pms.database.a.bcx().yc(this.mAppId);
            if (yc == null) {
                return new com.baidu.swan.apps.al.a().db(10L).dc(2904L).tM("Server未返回AppInfo数据，本地也没有数据");
            }
            this.cWj = yc;
            com.baidu.swan.apps.core.pms.f.a.a(this.cWj, this.cWg);
            this.cWj.bcI();
            this.cWj.lS(arb());
            if (com.baidu.swan.pms.database.a.bcx().a(this.cWg, this.cVU, this.cWh, this.cWi, this.cWj)) {
                return null;
            }
            return new com.baidu.swan.apps.al.a().db(10L).dc(2906L).tM("更新DB失败");
        }
        if (this.cWg != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.cWj, this.cWg);
        } else if (com.baidu.swan.apps.core.pms.f.b.az(this.cVU)) {
            this.cWm = this.cVU.get(0);
            this.cWm.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.cWj, this.cWm);
        } else {
            PMSAppInfo yc2 = com.baidu.swan.pms.database.a.bcx().yc(this.mAppId);
            if (yc2 == null) {
                return new com.baidu.swan.apps.al.a().db(10L).dc(2905L).tM("Server未返回包数据，本地也没有数据");
            }
            this.cWj.appId = this.mAppId;
            this.cWj.u(yc2);
        }
        this.cWj.bcI();
        this.cWj.lS(arb());
        if (com.baidu.swan.pms.database.a.bcx().a(this.cWg, this.cVU, this.cWh, this.cWi, this.cWj)) {
            com.baidu.swan.apps.core.pms.f.a.g(this.cWj);
            return null;
        }
        return new com.baidu.swan.apps.al.a().db(10L).dc(2906L).tM("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqW() {
        if (this.cWj != null) {
            PMSAppInfo yc = com.baidu.swan.pms.database.a.bcx().yc(this.mAppId);
            if (yc == null) {
                com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                return;
            }
            this.cWj.appId = this.mAppId;
            yc.lS(arb());
            this.cWj.u(yc);
            this.cWj.bcI();
            if (com.baidu.swan.pms.database.a.bcx().r(this.cWj)) {
                com.baidu.swan.apps.core.pms.f.a.g(this.cWj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqN() {
        com.baidu.swan.apps.console.c.i("SwanAppPkgDownloadCallback", "pms download time : " + (System.currentTimeMillis() - this.cWn));
    }

    public f c(com.baidu.swan.apps.ao.e.b<PMSAppInfo> bVar) {
        return d((Collection<Set<com.baidu.swan.apps.ao.e.b<PMSAppInfo>>>) this.cWp, (Set<com.baidu.swan.apps.ao.e.b<PMSAppInfo>>) bVar);
    }

    protected f c(final PMSAppInfo pMSAppInfo) {
        return a(this.cWp, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: e */
            public void N(com.baidu.swan.apps.ao.e.b<PMSAppInfo> bVar) {
                bVar.N(pMSAppInfo);
            }
        });
    }

    private synchronized <CallbackT> f d(final Collection<CallbackT> collection, final CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.cWq.k(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
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
            this.cWq.k(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.ao.e.b<CallbackT> bVar) {
        this.cWq.k(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : collection) {
                    bVar.N(obj);
                }
            }
        });
        return this;
    }

    public synchronized f a(com.baidu.swan.apps.core.pms.a.a aVar) {
        return d(this.cWo, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f d(@NonNull final com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a(this.cWo, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void N(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.N(aVar);
                f.this.e(f.this.cWo, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final com.baidu.swan.apps.al.a aVar, final boolean z) {
        d(new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void N(com.baidu.swan.apps.core.pms.a.a aVar2) {
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
            public void N(com.baidu.swan.apps.core.pms.a.a aVar) {
                aVar.f(pMSAppInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        c.aqH().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cWg = fVar;
                f.this.cVS.g(fVar);
                if (f.this.cWc != null) {
                    f.this.cWc.onNext(fVar);
                    f.this.cWc.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cVS.f(fVar);
                if (f.this.cWc != null) {
                    f.this.cWc.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.aqH().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.cVU == null) {
                    f.this.cVU = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.cVU.add(gVar);
                f.this.cVS.g(gVar);
                if (f.this.cWd != null) {
                    f.this.cWd.onNext(gVar);
                    if (!f.this.cVS.bdT()) {
                        f.this.cWd.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cVS.f(gVar);
                if (f.this.cWd != null) {
                    f.this.cWd.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.aqH().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cWh = dVar;
                f.this.cVS.g(dVar);
                if (f.this.cWe != null) {
                    f.this.cWe.onNext(dVar);
                    f.this.cWe.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cVS.f(dVar);
                if (f.this.cWe != null) {
                    f.this.cWe.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.aqH().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f.this.cWi = bVar;
                f.this.cVS.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                com.baidu.swan.apps.console.c.bl("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                f.this.cVS.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.cWf != null) {
            this.cWf.onNext(bVar);
            this.cWf.onCompleted();
        }
    }

    private void aqX() {
        ArrayList arrayList = new ArrayList();
        if (this.cVS.bdO()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.cWc = jVar;
                }
            }));
        }
        if (this.cVS.bdP()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.cWd = jVar;
                }
            }));
        }
        if (this.cVS.bdR()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.cWe = jVar;
                }
            }));
        }
        if (this.cVS.bdS()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.cWf = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.cWv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bw(String str, String str2) {
        com.baidu.swan.apps.performance.f.a.a(this.mAppId, str, this.cWk, str2);
        this.cWk.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
