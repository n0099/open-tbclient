package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ac;
import com.baidu.swan.apps.aq.ao;
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
import org.json.JSONException;
import org.json.JSONObject;
import rx.d;
/* loaded from: classes11.dex */
public abstract class f extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private rx.j<? super com.baidu.swan.pms.model.g> bXA;
    private rx.j<? super com.baidu.swan.pms.model.d> bXB;
    private rx.j<? super com.baidu.swan.pms.model.b> bXC;
    protected com.baidu.swan.pms.model.f bXD;
    protected List<com.baidu.swan.pms.model.g> bXE;
    protected com.baidu.swan.pms.model.d bXF;
    protected com.baidu.swan.pms.model.b bXG;
    protected PMSAppInfo bXH;
    protected com.baidu.swan.pms.model.g bXK;
    protected com.baidu.swan.pms.f.e bXr;
    private rx.j<? super com.baidu.swan.pms.model.f> bXz;
    protected String mAppId;
    private String mClassName = "";
    protected String bXJ = "0";
    private long bXL = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> bXM = new HashSet();
    private final Set<com.baidu.swan.apps.aq.e.b<PMSAppInfo>> bXN = new HashSet();
    private final ao bXO = new ao();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> bXP = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String P(com.baidu.swan.pms.model.f fVar) {
            if (fVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.aam();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aan();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Xx();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void N(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.lk(f.this.ZY()).ahk().fE(1);
            super.N(fVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void O(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.lk(f.this.ZY()).ahk().fE(1);
            super.O(fVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onDownloading");
            }
            f.this.b(fVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.f fVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) fVar, aVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onDownloadError：" + aVar.toString());
            }
            f.this.bXr.f(fVar);
            com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(11L).bx(aVar.errorNo).pr("主包下载失败").pt(aVar.toString());
            if (f.this.bXz != null) {
                f.this.bXz.onError(new PkgDownloadError(fVar, pt));
            }
            c.ZN().a(fVar, f.this.ZS(), pt);
            com.baidu.swan.e.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.lk(f.this.ZY()).ahk().fE(1);
            super.L(fVar);
            f.this.bXI.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.an.a a = f.this.a(fVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: pmsPkgMain=" + fVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: errCode=" + a);
            }
            if (a == null) {
                f.this.bXD = fVar;
                f.this.bXr.g(fVar);
                if (f.this.bXz != null) {
                    f.this.bXz.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.bXz.onCompleted();
                }
                c.ZN().a(fVar, f.this.ZS());
                return;
            }
            f.this.bXr.f(fVar);
            if (f.this.bXz != null) {
                f.this.bXz.onError(new PkgDownloadError(fVar, a));
            }
            c.ZN().a(fVar, f.this.ZS(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            com.baidu.swan.apps.v.c.a.lk(f.this.ZY()).ll(fVar.toString()).fE(1);
            com.baidu.swan.apps.aq.e.b<i.a> bVar = new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.core.pms.f.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: b */
                public void H(i.a aVar) {
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
            com.baidu.swan.apps.r.g gVar = new com.baidu.swan.apps.r.g();
            gVar.n(bVar);
            boolean isOk = gVar.B(bundle).a(new com.baidu.swan.apps.r.f(fVar, f.this)).a(new com.baidu.swan.apps.r.d(fVar.sign, f.this)).a(new com.baidu.swan.apps.r.c(file)).a(bufferedSource).isOk();
            gVar.o(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onProcessStream: installOk=" + isOk);
            }
            return isOk ? new com.baidu.swan.pms.model.a(PushConstants.DOWN_LOAD_LARGE_ICON_ERROR, "业务层处理下载流成功") : new com.baidu.swan.pms.model.a(PushConstants.DOWN_LOAD_LARGE_ICON_SUCCESS, "业务层处理下载流失败");
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> bXQ = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.12
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String P(com.baidu.swan.pms.model.g gVar) {
            if (gVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.b.bc(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            if (gVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.b.bd(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Xx();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void N(com.baidu.swan.pms.model.g gVar) {
            super.N(gVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void O(com.baidu.swan.pms.model.g gVar) {
            super.O(gVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onDownloading");
            }
            f.this.b(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.g gVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass12) gVar, aVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onDownloadError：" + aVar.toString());
            }
            f.this.bXr.f(gVar);
            com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(12L).bx(aVar.errorNo).pr("分包下载失败").pt(aVar.toString());
            if (f.this.bXA != null) {
                f.this.bXA.onError(new PkgDownloadError(gVar, pt));
            }
            c.ZN().a(gVar, f.this.ZS(), pt);
            com.baidu.swan.e.d.deleteFile(gVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(com.baidu.swan.pms.model.g gVar) {
            super.L(gVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onFileDownloaded: " + gVar.toString());
            }
            if (f.this.bXE == null) {
                f.this.bXE = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            com.baidu.swan.apps.an.a a = f.this.a(gVar);
            if (a == null) {
                f.this.bXE.add(gVar);
                f.this.bXr.g(gVar);
                c.ZN().a(gVar, f.this.ZS());
            } else {
                f.this.bXr.f(gVar);
                c.ZN().a(gVar, f.this.ZS(), a);
            }
            if (f.this.bXA != null) {
                f.this.bXA.onNext(gVar);
                if (!f.this.bXr.aHs()) {
                    f.this.bXA.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> bXR = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String P(com.baidu.swan.pms.model.d dVar) {
            if (dVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.aao();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aap();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Xx();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void N(com.baidu.swan.pms.model.d dVar) {
            super.N(dVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void O(com.baidu.swan.pms.model.d dVar) {
            super.O(dVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": framework onDownloading");
            }
            f.this.b(dVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass15) dVar, aVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onDownloadError：" + aVar.toString());
            }
            f.this.bXr.f(dVar);
            com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(13L).bx(aVar.errorNo).pr("Framework包下载失败").pt(aVar.toString());
            if (f.this.bXB != null) {
                f.this.bXB.onError(new PkgDownloadError(dVar, pt));
            }
            c.ZN().a(dVar, f.this.ZS(), pt);
            com.baidu.swan.e.d.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(com.baidu.swan.pms.model.d dVar) {
            super.L(dVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": swancore onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.an.a a = f.this.a(dVar);
            if (a == null) {
                f.this.bXF = dVar;
                f.this.bXr.g(dVar);
                if (f.this.bXB != null) {
                    f.this.bXB.onNext(dVar);
                    f.this.bXB.onCompleted();
                }
                c.ZN().a(dVar, f.this.ZS());
                return;
            }
            f.this.bXr.f(dVar);
            if (f.this.bXB != null) {
                f.this.bXB.onError(new PkgDownloadError(dVar, a));
            }
            c.ZN().a(dVar, f.this.ZS(), a);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> bXS = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String P(com.baidu.swan.pms.model.b bVar) {
            if (bVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.aaf();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.aaq();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Xx();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void N(com.baidu.swan.pms.model.b bVar) {
            super.N(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void O(com.baidu.swan.pms.model.b bVar) {
            super.O(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": extension onDownloading");
            }
            f.this.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass16) bVar, aVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onDownloadError：" + aVar.toString());
            }
            f.this.bXr.f(bVar);
            com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(14L).bx(aVar.errorNo).pr("Extension下载失败").pt(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", pt.toString());
            }
            f.this.c(bVar);
            c.ZN().a(bVar, f.this.ZS(), pt);
            com.baidu.swan.e.d.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void L(com.baidu.swan.pms.model.b bVar) {
            super.L(bVar);
            com.baidu.swan.apps.an.a a = f.this.a(bVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext onFileDownloaded: " + bVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext errcode=" + a);
            }
            if (a != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.bXr.f(bVar);
                f.this.c(bVar);
                c.ZN().a(bVar, f.this.ZS(), a);
                return;
            }
            f.this.bXG = bVar;
            f.this.bXr.g(bVar);
            f.this.c(bVar);
            c.ZN().a(bVar, f.this.ZS());
        }
    };
    private com.baidu.swan.pms.a.f bXT = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void c(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.bXH = pMSAppInfo;
            if (f.this.bXH != null) {
                f.this.a(f.this.bXH);
                com.baidu.swan.apps.ae.g.b.O(f.this.bXH.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> bXU = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.ZS() + " : 包下载onCompleted");
            }
            f.this.ZR();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.ZS() + " : 包下载OnError：" + th.toString());
            }
            f.this.p(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.ZS() + " : 单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> bXI = new ArrayList();

    protected abstract PMSDownloadType ZS();

    protected abstract void p(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xw() {
        this.bXI.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZP() {
        this.bXI.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        }
        if (aVar != null && aVar.errorNo == 1010) {
            ZZ();
        }
        this.bXI.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        this.bXL = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.bXL);
        }
        if (eVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + eVar.aHn());
            }
            this.bXI.add(new UbcFlowEvent("na_pms_start_download"));
            this.bXr = eVar;
            if (!this.bXr.isEmpty()) {
                aac();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> ZT() {
        return this.bXP;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> ZU() {
        return this.bXQ;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> ZV() {
        return this.bXR;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> ZW() {
        return this.bXS;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f ZX() {
        return this.bXT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ZY() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int Xx() {
        return 100;
    }

    protected com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.apps.v.c.a lk = com.baidu.swan.apps.v.c.a.lk(ZY());
        lk.ahk().fE(1);
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.an.a b = com.baidu.swan.apps.core.pms.f.a.b(fVar);
        lk.ll("CostRenameZip: " + (System.currentTimeMillis() - currentTimeMillis));
        return b;
    }

    protected com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.g gVar) {
        if (!ac.e(new File(gVar.filePath), gVar.sign)) {
            return new com.baidu.swan.apps.an.a().bw(12L).by(2300L).pr("分包签名校验失败");
        }
        if (!com.baidu.swan.apps.core.pms.f.b.i(gVar)) {
            return new com.baidu.swan.apps.an.a().bw(12L).by(2320L).pr("分包解压失败");
        }
        return null;
    }

    protected com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0392a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.e.d.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.an.a().bw(13L).by(2907L).pr("Core包更新失败");
    }

    protected com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cdA = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.an.a().bw(14L).by(2908L).pr("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eV(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.aFV().Z(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.aFV().Z(this.mAppId, 0);
        }
    }

    private void ZZ() {
        PMSAppInfo tf = com.baidu.swan.pms.database.a.aFV().tf(this.mAppId);
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "updateMainMaxageTime: localAppInfo = " + tf);
        }
        if (tf != null) {
            tf.aGj();
            if (this.bXD != null) {
                this.bXD.createTime = tf.createTime;
            }
            if (this.bXH != null) {
                this.bXH.createTime = tf.createTime;
            }
            com.baidu.swan.pms.database.a.aFV().o(tf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.an.a aaa() {
        if (this.bXH == null) {
            if (this.bXD == null) {
                return new com.baidu.swan.apps.an.a().bw(10L).bx(2903L).pr("Server未返回主包&AppInfo");
            }
            PMSAppInfo tf = com.baidu.swan.pms.database.a.aFV().tf(this.mAppId);
            if (tf == null) {
                return new com.baidu.swan.apps.an.a().bw(10L).bx(2904L).pr("Server未返回AppInfo数据，本地也没有数据");
            }
            this.bXH = tf;
            com.baidu.swan.apps.core.pms.f.a.a(this.bXH, this.bXD);
            this.bXH.aGj();
            if (com.baidu.swan.pms.database.a.aFV().a(this.bXD, this.bXE, this.bXF, this.bXG, this.bXH)) {
                return null;
            }
            return new com.baidu.swan.apps.an.a().bw(10L).bx(2906L).pr("更新DB失败");
        }
        if (this.bXD != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.bXH, this.bXD);
        } else if (com.baidu.swan.apps.core.pms.f.b.U(this.bXE)) {
            this.bXK = this.bXE.get(0);
            this.bXK.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.bXH, this.bXK);
        } else {
            PMSAppInfo tf2 = com.baidu.swan.pms.database.a.aFV().tf(this.mAppId);
            if (tf2 == null) {
                return new com.baidu.swan.apps.an.a().bw(10L).bx(2905L).pr("Server未返回包数据，本地也没有数据");
            }
            this.bXH.appId = this.mAppId;
            this.bXH.q(tf2);
        }
        this.bXH.aGj();
        if (com.baidu.swan.pms.database.a.aFV().a(this.bXD, this.bXE, this.bXF, this.bXG, this.bXH)) {
            com.baidu.swan.apps.core.pms.f.a.e(this.bXH);
            return null;
        }
        return new com.baidu.swan.apps.an.a().bw(10L).bx(2906L).pr("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aab() {
        if (this.bXH != null) {
            PMSAppInfo tf = com.baidu.swan.pms.database.a.aFV().tf(this.mAppId);
            if (tf == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", getClassName() + ": Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.bXH.appId = this.mAppId;
            this.bXH.q(tf);
            this.bXH.aGj();
            if (com.baidu.swan.pms.database.a.aFV().o(this.bXH)) {
                com.baidu.swan.apps.core.pms.f.a.e(this.bXH);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZR() {
        long currentTimeMillis = System.currentTimeMillis() - this.bXL;
        int alQ = com.baidu.swan.apps.performance.e.a.alQ();
        if (alQ > 0 && currentTimeMillis > alQ) {
            aO(currentTimeMillis);
        }
    }

    private void aO(long j) {
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "pms download too slow:" + j);
        }
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        if (aoG != null && aoG.Qz() == 0) {
            com.baidu.swan.apps.an.a pr = new com.baidu.swan.apps.an.a().bw(10L).bx(2912L).pr("pms download too slow");
            com.baidu.swan.apps.statistic.a.d oD = new com.baidu.swan.apps.statistic.a.d().f(pr).a(aoG.QJ()).oC(com.baidu.swan.apps.statistic.h.gS(aoG.Qz())).oD(this.mAppId);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("downloadTime", j);
                if (this.bXH != null) {
                    jSONObject.put("PMSAppInfo", this.bXH.toString());
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            oD.bt(jSONObject);
            com.baidu.swan.apps.statistic.h.b(oD);
            com.baidu.swan.apps.al.a.aqT().u(pr.asJ(), oD.toJSONObject());
            if (DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "downloadSlowStatistic:" + j + " event=" + oD.toJSONObject().toString());
            }
        }
    }

    public f b(com.baidu.swan.apps.aq.e.b<PMSAppInfo> bVar) {
        return a((Collection<Set<com.baidu.swan.apps.aq.e.b<PMSAppInfo>>>) this.bXN, (Set<com.baidu.swan.apps.aq.e.b<PMSAppInfo>>) bVar);
    }

    protected f a(final PMSAppInfo pMSAppInfo) {
        return a((Collection) this.bXN, (com.baidu.swan.apps.aq.e.b) new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: d */
            public void H(com.baidu.swan.apps.aq.e.b<PMSAppInfo> bVar) {
                bVar.H(pMSAppInfo);
            }
        });
    }

    private synchronized <CallbackT> f a(final Collection<CallbackT> collection, final CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.bXO.q(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
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
            this.bXO.q(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.aq.e.b<CallbackT> bVar) {
        this.bXO.q(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : collection) {
                    bVar.H(obj);
                }
            }
        });
        return this;
    }

    public synchronized f a(com.baidu.swan.apps.core.pms.a.a aVar) {
        return a(this.bXM, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f c(@NonNull final com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a((Collection) this.bXM, (com.baidu.swan.apps.aq.e.b) new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.H(aVar);
                f.this.b((Collection<Set>) f.this.bXM, (Set) aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final com.baidu.swan.apps.an.a aVar, final boolean z) {
        c(new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(com.baidu.swan.apps.core.pms.a.a aVar2) {
                aVar2.b(aVar, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(final PMSAppInfo pMSAppInfo) {
        c(new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(com.baidu.swan.apps.core.pms.a.a aVar) {
                aVar.d(pMSAppInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        c.ZN().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.bXD = fVar;
                f.this.bXr.g(fVar);
                if (f.this.bXz != null) {
                    f.this.bXz.onNext(fVar);
                    f.this.bXz.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                f.this.bXr.f(fVar);
                if (f.this.bXz != null) {
                    f.this.bXz.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.ZN().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.bXE == null) {
                    f.this.bXE = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.bXE.add(gVar);
                f.this.bXr.g(gVar);
                if (f.this.bXA != null) {
                    f.this.bXA.onNext(gVar);
                    if (!f.this.bXr.aHs()) {
                        f.this.bXA.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                f.this.bXr.f(gVar);
                if (f.this.bXA != null) {
                    f.this.bXA.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.ZN().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.bXF = dVar;
                f.this.bXr.g(dVar);
                if (f.this.bXB != null) {
                    f.this.bXB.onNext(dVar);
                    f.this.bXB.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                f.this.bXr.f(dVar);
                if (f.this.bXB != null) {
                    f.this.bXB.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.ZN().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onSuccess ：" + pMSDownloadType);
                }
                f.this.bXG = bVar;
                f.this.bXr.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                }
                f.this.bXr.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.bXC != null) {
            this.bXC.onNext(bVar);
            this.bXC.onCompleted();
        }
    }

    private void aac() {
        ArrayList arrayList = new ArrayList();
        if (this.bXr.aHo()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.bXz = jVar;
                }
            }));
        }
        if (this.bXr.aHp()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.bXA = jVar;
                }
            }));
        }
        if (this.bXr.aHq()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.bXB = jVar;
                }
            }));
        }
        if (this.bXr.aHr()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.bXC = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.bXU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ba(String str, String str2) {
        com.baidu.swan.apps.performance.e.a.a(this.mAppId, str, this.bXI, str2);
        this.bXI.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
