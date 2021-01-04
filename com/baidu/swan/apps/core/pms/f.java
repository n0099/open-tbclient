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
    protected com.baidu.swan.pms.utils.f cWR;
    protected List<com.baidu.swan.pms.model.g> cWT;
    private rx.j<? super com.baidu.swan.pms.model.f> cXb;
    private rx.j<? super com.baidu.swan.pms.model.g> cXc;
    private rx.j<? super com.baidu.swan.pms.model.d> cXd;
    private rx.j<? super com.baidu.swan.pms.model.b> cXe;
    protected com.baidu.swan.pms.model.f cXf;
    protected com.baidu.swan.pms.model.d cXg;
    protected com.baidu.swan.pms.model.b cXh;
    protected PMSAppInfo cXi;
    protected com.baidu.swan.pms.model.g cXl;
    protected String mAppId;
    private String mClassName = "";
    protected String cXk = "0";
    private long cXm = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> cXn = new HashSet();
    private final Set<com.baidu.swan.apps.ao.e.b<PMSAppInfo>> cXo = new HashSet();
    private final aq cXp = new aq();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> cXq = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
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
                return com.baidu.swan.apps.core.pms.f.a.auz();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.auA();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.arf();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.f fVar) {
            String aum = f.this.aum();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pZ(aum).aCW().jw(1);
            }
            super.S(fVar);
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void T(com.baidu.swan.pms.model.f fVar) {
            String aum = f.this.aum();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pZ(aum).aCW().jw(1);
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
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.cWR.f(fVar);
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(11L).cW(aVar.errorNo).ux("主包下载失败").uz(aVar.toString());
            if (f.this.cXb != null) {
                f.this.cXb.onError(new PkgDownloadError(fVar, uz));
            }
            c.aua().a(fVar, f.this.auh(), uz);
            com.baidu.swan.c.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.f fVar) {
            String aum = f.this.aum();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pZ(aum).aCW().jw(1);
            }
            super.Q(fVar);
            f.this.cXj.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.al.a a2 = f.this.a(fVar);
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.versionCode);
            if (a2 == null) {
                f.this.cXf = fVar;
                f.this.cWR.g(fVar);
                if (f.this.cXb != null) {
                    f.this.cXb.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.cXb.onCompleted();
                }
                c.aua().a(fVar, f.this.auh());
                return;
            }
            f.this.cWR.f(fVar);
            if (f.this.cXb != null) {
                f.this.cXb.onError(new PkgDownloadError(fVar, a2));
            }
            c.aua().a(fVar, f.this.auh(), a2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String aum = f.this.aum();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.pZ(aum).qa(fVar.toString()).jw(1);
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cWV = new k<f>(this) { // from class: com.baidu.swan.apps.core.pms.f.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.arf();
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
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "sub onDownloadStart");
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
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.cWR.f(gVar);
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(12L).cW(aVar.errorNo).ux("分包下载失败").uz(aVar.toString());
            if (f.this.cXc != null) {
                f.this.cXc.onError(new PkgDownloadError(gVar, uz));
            }
            c.aua().a(gVar, f.this.auh(), uz);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k
        public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.al.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.versionCode);
            if (f.this.cWT == null) {
                f.this.cWT = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            if (aVar == null) {
                f.this.cWT.add(gVar);
                f.this.cWR.g(gVar);
                c.aua().a(gVar, f.this.auh());
            } else {
                f.this.cWR.f(gVar);
                c.aua().a(gVar, f.this.auh(), aVar);
            }
            if (f.this.cXc != null) {
                f.this.cXc.onNext(gVar);
                if (!f.this.cWR.bhx()) {
                    f.this.cXc.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cXr = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
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
                return com.baidu.swan.apps.core.pms.f.a.auB();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.auC();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.arf();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(com.baidu.swan.pms.model.d dVar) {
            super.S(dVar);
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "framework onDownloadStart");
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
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.cWR.f(dVar);
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(13L).cW(aVar.errorNo).ux("Framework包下载失败").uz(aVar.toString());
            if (f.this.cXd != null) {
                f.this.cXd.onError(new PkgDownloadError(dVar, uz));
            }
            c.aua().a(dVar, f.this.auh(), uz);
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.d dVar) {
            super.Q(dVar);
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.versionCode);
            com.baidu.swan.apps.al.a a2 = f.this.a(dVar);
            if (a2 == null) {
                f.this.cXg = dVar;
                f.this.cWR.g(dVar);
                if (f.this.cXd != null) {
                    f.this.cXd.onNext(dVar);
                    f.this.cXd.onCompleted();
                }
                c.aua().a(dVar, f.this.auh());
                return;
            }
            f.this.cWR.f(dVar);
            if (f.this.cXd != null) {
                f.this.cXd.onError(new PkgDownloadError(dVar, a2));
            }
            c.aua().a(dVar, f.this.auh(), a2);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cXs = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
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
                return com.baidu.swan.apps.core.pms.f.a.aut();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.auD();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.arf();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void S(com.baidu.swan.pms.model.b bVar) {
            super.S(bVar);
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "extension onDownloadStart");
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
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.cWR.f(bVar);
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(14L).cW(aVar.errorNo).ux("Extension下载失败").uz(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", uz.toString());
            }
            f.this.c(bVar);
            c.aua().a(bVar, f.this.auh(), uz);
            com.baidu.swan.c.d.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void Q(com.baidu.swan.pms.model.b bVar) {
            super.Q(bVar);
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.versionCode);
            com.baidu.swan.apps.al.a a2 = f.this.a(bVar);
            if (a2 != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.cWR.f(bVar);
                f.this.c(bVar);
                c.aua().a(bVar, f.this.auh(), a2);
                return;
            }
            f.this.cXh = bVar;
            f.this.cWR.g(bVar);
            f.this.c(bVar);
            c.aua().a(bVar, f.this.auh());
        }
    };
    private com.baidu.swan.pms.a.f cXt = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void e(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.cXi = pMSAppInfo;
            if (f.this.cXi != null) {
                f.this.c(f.this.cXi);
                com.baidu.swan.apps.ac.g.b.ab(f.this.cXi.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> cXu = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", f.this.auh() + " : 包下载onCompleted");
            f.this.aug();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            com.baidu.swan.apps.console.c.g("SwanAppPkgDownloadCallback", f.this.auh() + " : 包下载OnError", th);
            f.this.m(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", f.this.auh() + " : 单个包下载、业务层处理完成：" + eVar.versionCode);
        }
    };
    protected List<UbcFlowEvent> cXj = new ArrayList();

    protected abstract PMSDownloadType auh();

    protected abstract void m(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void are() {
        this.cXj.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void aud() {
        this.cXj.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.errorNo == 1010) {
            aun();
        }
        this.cXj.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cXm = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.cXm);
        }
        if (fVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + fVar.bhr());
            }
            this.cXj.add(new UbcFlowEvent("na_pms_start_download"));
            this.cWR = fVar;
            if (!this.cWR.isEmpty()) {
                auq();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> aui() {
        return this.cXq;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> auf() {
        return this.cWV;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> auj() {
        return this.cXr;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> auk() {
        return this.cXs;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f aul() {
        return this.cXt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aum() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int arf() {
        return 100;
    }

    protected com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.f fVar) {
        if (fVar == null) {
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(11L).cW(2310L).uz("pkg info is empty");
            com.baidu.swan.apps.al.e.aQJ().j(uz);
            return uz;
        }
        return null;
    }

    protected com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0491a h = com.baidu.swan.apps.swancore.d.a.h(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }
        if (h.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.al.a().cV(13L).cX(2907L).ux("Core包更新失败");
    }

    protected com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.dej = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.al.a().cV(14L).cX(2908L).ux("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iy(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.bgb().ah(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.bgb().ah(this.mAppId, 0);
        }
    }

    private void aun() {
        PMSAppInfo yN = com.baidu.swan.pms.database.a.bgb().yN(this.mAppId);
        com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + yN.createTime + " lastLaunchTime=" + yN.getLastLaunchTime() + " maxAge=" + yN.maxAge);
        if (yN != null) {
            yN.bgm();
            yN.nu(auu());
            if (this.cXf != null) {
                this.cXf.createTime = yN.createTime;
            }
            if (this.cXi != null) {
                this.cXi.createTime = yN.createTime;
                this.cXi.nu(auu());
            }
            com.baidu.swan.pms.database.a.bgb().r(yN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.al.a auo() {
        if (this.cXi == null) {
            if (this.cXf == null) {
                return new com.baidu.swan.apps.al.a().cV(10L).cW(2903L).ux("Server未返回主包&AppInfo");
            }
            PMSAppInfo yN = com.baidu.swan.pms.database.a.bgb().yN(this.mAppId);
            if (yN == null) {
                return new com.baidu.swan.apps.al.a().cV(10L).cW(2904L).ux("Server未返回AppInfo数据，本地也没有数据");
            }
            this.cXi = yN;
            com.baidu.swan.apps.core.pms.f.a.a(this.cXi, this.cXf);
            this.cXi.bgm();
            this.cXi.nu(auu());
            if (com.baidu.swan.pms.database.a.bgb().a(this.cXf, this.cWT, this.cXg, this.cXh, this.cXi)) {
                return null;
            }
            return new com.baidu.swan.apps.al.a().cV(10L).cW(2906L).ux("更新DB失败");
        }
        if (this.cXf != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.cXi, this.cXf);
        } else if (com.baidu.swan.apps.core.pms.f.b.aE(this.cWT)) {
            this.cXl = this.cWT.get(0);
            this.cXl.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.cXi, this.cXl);
        } else {
            PMSAppInfo yN2 = com.baidu.swan.pms.database.a.bgb().yN(this.mAppId);
            if (yN2 == null) {
                return new com.baidu.swan.apps.al.a().cV(10L).cW(2905L).ux("Server未返回包数据，本地也没有数据");
            }
            this.cXi.appId = this.mAppId;
            this.cXi.u(yN2);
        }
        this.cXi.bgm();
        this.cXi.nu(auu());
        if (com.baidu.swan.pms.database.a.bgb().a(this.cXf, this.cWT, this.cXg, this.cXh, this.cXi)) {
            com.baidu.swan.apps.core.pms.f.a.g(this.cXi);
            return null;
        }
        return new com.baidu.swan.apps.al.a().cV(10L).cW(2906L).ux("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aup() {
        if (this.cXi != null) {
            PMSAppInfo yN = com.baidu.swan.pms.database.a.bgb().yN(this.mAppId);
            if (yN == null) {
                com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                return;
            }
            this.cXi.appId = this.mAppId;
            yN.nu(auu());
            this.cXi.u(yN);
            this.cXi.bgm();
            if (com.baidu.swan.pms.database.a.bgb().r(this.cXi)) {
                com.baidu.swan.apps.core.pms.f.a.g(this.cXi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aug() {
        com.baidu.swan.apps.console.c.i("SwanAppPkgDownloadCallback", "pms download time : " + (System.currentTimeMillis() - this.cXm));
    }

    public f c(com.baidu.swan.apps.ao.e.b<PMSAppInfo> bVar) {
        return d((Collection<Set<com.baidu.swan.apps.ao.e.b<PMSAppInfo>>>) this.cXo, (Set<com.baidu.swan.apps.ao.e.b<PMSAppInfo>>) bVar);
    }

    protected f c(final PMSAppInfo pMSAppInfo) {
        return a(this.cXo, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
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
            this.cXp.m(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
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
            this.cXp.m(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.ao.e.b<CallbackT> bVar) {
        this.cXp.m(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
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
        return d(this.cXn, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f d(@NonNull final com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a(this.cXn, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void L(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.L(aVar);
                f.this.e(f.this.cXn, aVar);
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
        c.aua().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cXf = fVar;
                f.this.cWR.g(fVar);
                if (f.this.cXb != null) {
                    f.this.cXb.onNext(fVar);
                    f.this.cXb.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cWR.f(fVar);
                if (f.this.cXb != null) {
                    f.this.cXb.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.aua().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.cWT == null) {
                    f.this.cWT = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.cWT.add(gVar);
                f.this.cWR.g(gVar);
                if (f.this.cXc != null) {
                    f.this.cXc.onNext(gVar);
                    if (!f.this.cWR.bhx()) {
                        f.this.cXc.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cWR.f(gVar);
                if (f.this.cXc != null) {
                    f.this.cXc.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.aua().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cXg = dVar;
                f.this.cWR.g(dVar);
                if (f.this.cXd != null) {
                    f.this.cXd.onNext(dVar);
                    f.this.cXd.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cWR.f(dVar);
                if (f.this.cXd != null) {
                    f.this.cXd.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.aua().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f.this.cXh = bVar;
                f.this.cWR.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                com.baidu.swan.apps.console.c.bs("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                f.this.cWR.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.cXe != null) {
            this.cXe.onNext(bVar);
            this.cXe.onCompleted();
        }
    }

    private void auq() {
        ArrayList arrayList = new ArrayList();
        if (this.cWR.bhs()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.cXb = jVar;
                }
            }));
        }
        if (this.cWR.bht()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.cXc = jVar;
                }
            }));
        }
        if (this.cWR.bhv()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.cXd = jVar;
                }
            }));
        }
        if (this.cWR.bhw()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.cXe = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.cXu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bD(String str, String str2) {
        com.baidu.swan.apps.performance.f.a.a(this.mAppId, str, this.cXj, str2);
        this.cXj.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
