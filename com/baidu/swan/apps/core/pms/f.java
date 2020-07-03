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
    protected com.baidu.swan.pms.f.e ccf;
    private rx.j<? super com.baidu.swan.pms.model.f> ccn;
    private rx.j<? super com.baidu.swan.pms.model.g> cco;
    private rx.j<? super com.baidu.swan.pms.model.d> ccp;
    private rx.j<? super com.baidu.swan.pms.model.b> ccq;
    protected com.baidu.swan.pms.model.f ccr;
    protected List<com.baidu.swan.pms.model.g> cct;
    protected com.baidu.swan.pms.model.d ccu;
    protected com.baidu.swan.pms.model.b ccv;
    protected PMSAppInfo ccw;
    protected com.baidu.swan.pms.model.g ccz;
    protected String mAppId;
    private String mClassName = "";
    protected String ccy = "0";
    private long ccA = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> ccB = new HashSet();
    private final Set<com.baidu.swan.apps.aq.e.b<PMSAppInfo>> ccC = new HashSet();
    private final ao ccD = new ao();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> ccE = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
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
                return com.baidu.swan.apps.core.pms.f.a.abs();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.abt();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.YD();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void N(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.ls(f.this.abe()).aiq().fR(1);
            super.N(fVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void O(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.ls(f.this.abe()).aiq().fR(1);
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
            f.this.ccf.f(fVar);
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(11L).bx(aVar.errorNo).pz("主包下载失败").pB(aVar.toString());
            if (f.this.ccn != null) {
                f.this.ccn.onError(new PkgDownloadError(fVar, pB));
            }
            c.aaT().a(fVar, f.this.aaY(), pB);
            com.baidu.swan.e.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.v.c.a.ls(f.this.abe()).aiq().fR(1);
            super.L(fVar);
            f.this.ccx.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.an.a a = f.this.a(fVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: pmsPkgMain=" + fVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: errCode=" + a);
            }
            if (a == null) {
                f.this.ccr = fVar;
                f.this.ccf.g(fVar);
                if (f.this.ccn != null) {
                    f.this.ccn.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.ccn.onCompleted();
                }
                c.aaT().a(fVar, f.this.aaY());
                return;
            }
            f.this.ccf.f(fVar);
            if (f.this.ccn != null) {
                f.this.ccn.onError(new PkgDownloadError(fVar, a));
            }
            c.aaT().a(fVar, f.this.aaY(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            com.baidu.swan.apps.v.c.a.ls(f.this.abe()).lt(fVar.toString()).fR(1);
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> ccF = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.12
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
                return com.baidu.swan.apps.core.pms.f.b.be(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            if (gVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.b.bf(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.YD();
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
            f.this.ccf.f(gVar);
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(12L).bx(aVar.errorNo).pz("分包下载失败").pB(aVar.toString());
            if (f.this.cco != null) {
                f.this.cco.onError(new PkgDownloadError(gVar, pB));
            }
            c.aaT().a(gVar, f.this.aaY(), pB);
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
            if (f.this.cct == null) {
                f.this.cct = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            com.baidu.swan.apps.an.a a = f.this.a(gVar);
            if (a == null) {
                f.this.cct.add(gVar);
                f.this.ccf.g(gVar);
                c.aaT().a(gVar, f.this.aaY());
            } else {
                f.this.ccf.f(gVar);
                c.aaT().a(gVar, f.this.aaY(), a);
            }
            if (f.this.cco != null) {
                f.this.cco.onNext(gVar);
                if (!f.this.ccf.aIy()) {
                    f.this.cco.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> ccG = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
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
                return com.baidu.swan.apps.core.pms.f.a.abu();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.abv();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.YD();
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
            f.this.ccf.f(dVar);
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(13L).bx(aVar.errorNo).pz("Framework包下载失败").pB(aVar.toString());
            if (f.this.ccp != null) {
                f.this.ccp.onError(new PkgDownloadError(dVar, pB));
            }
            c.aaT().a(dVar, f.this.aaY(), pB);
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
                f.this.ccu = dVar;
                f.this.ccf.g(dVar);
                if (f.this.ccp != null) {
                    f.this.ccp.onNext(dVar);
                    f.this.ccp.onCompleted();
                }
                c.aaT().a(dVar, f.this.aaY());
                return;
            }
            f.this.ccf.f(dVar);
            if (f.this.ccp != null) {
                f.this.ccp.onError(new PkgDownloadError(dVar, a));
            }
            c.aaT().a(dVar, f.this.aaY(), a);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> ccH = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
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
                return com.baidu.swan.apps.core.pms.f.a.abl();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.abw();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.YD();
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
            f.this.ccf.f(bVar);
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(14L).bx(aVar.errorNo).pz("Extension下载失败").pB(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", pB.toString());
            }
            f.this.c(bVar);
            c.aaT().a(bVar, f.this.aaY(), pB);
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
                f.this.ccf.f(bVar);
                f.this.c(bVar);
                c.aaT().a(bVar, f.this.aaY(), a);
                return;
            }
            f.this.ccv = bVar;
            f.this.ccf.g(bVar);
            f.this.c(bVar);
            c.aaT().a(bVar, f.this.aaY());
        }
    };
    private com.baidu.swan.pms.a.f ccI = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void c(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.ccw = pMSAppInfo;
            if (f.this.ccw != null) {
                f.this.a(f.this.ccw);
                com.baidu.swan.apps.ae.g.b.Q(f.this.ccw.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> ccJ = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.aaY() + " : 包下载onCompleted");
            }
            f.this.aaX();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.aaY() + " : 包下载OnError：" + th.toString());
            }
            f.this.p(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.aaY() + " : 单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> ccx = new ArrayList();

    protected abstract PMSDownloadType aaY();

    protected abstract void p(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void YC() {
        this.ccx.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaV() {
        this.ccx.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        }
        if (aVar != null && aVar.errorNo == 1010) {
            abf();
        }
        this.ccx.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        this.ccA = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.ccA);
        }
        if (eVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + eVar.aIt());
            }
            this.ccx.add(new UbcFlowEvent("na_pms_start_download"));
            this.ccf = eVar;
            if (!this.ccf.isEmpty()) {
                abi();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> aaZ() {
        return this.ccE;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aba() {
        return this.ccF;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> abb() {
        return this.ccG;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> abc() {
        return this.ccH;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f abd() {
        return this.ccI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String abe() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int YD() {
        return 100;
    }

    protected com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.apps.v.c.a ls = com.baidu.swan.apps.v.c.a.ls(abe());
        ls.aiq().fR(1);
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.an.a b = com.baidu.swan.apps.core.pms.f.a.b(fVar);
        ls.lt("CostRenameZip: " + (System.currentTimeMillis() - currentTimeMillis));
        return b;
    }

    protected com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.g gVar) {
        if (!ac.e(new File(gVar.filePath), gVar.sign)) {
            return new com.baidu.swan.apps.an.a().bw(12L).by(2300L).pz("分包签名校验失败");
        }
        if (!com.baidu.swan.apps.core.pms.f.b.i(gVar)) {
            return new com.baidu.swan.apps.an.a().bw(12L).by(2320L).pz("分包解压失败");
        }
        return null;
    }

    protected com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0398a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.e.d.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.an.a().bw(13L).by(2907L).pz("Core包更新失败");
    }

    protected com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.cio = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.an.a().bw(14L).by(2908L).pz("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fi(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.aHb().Z(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.aHb().Z(this.mAppId, 0);
        }
    }

    private void abf() {
        PMSAppInfo tn = com.baidu.swan.pms.database.a.aHb().tn(this.mAppId);
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "updateMainMaxageTime: localAppInfo = " + tn);
        }
        if (tn != null) {
            tn.aHp();
            if (this.ccr != null) {
                this.ccr.createTime = tn.createTime;
            }
            if (this.ccw != null) {
                this.ccw.createTime = tn.createTime;
            }
            com.baidu.swan.pms.database.a.aHb().o(tn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.an.a abg() {
        if (this.ccw == null) {
            if (this.ccr == null) {
                return new com.baidu.swan.apps.an.a().bw(10L).bx(2903L).pz("Server未返回主包&AppInfo");
            }
            PMSAppInfo tn = com.baidu.swan.pms.database.a.aHb().tn(this.mAppId);
            if (tn == null) {
                return new com.baidu.swan.apps.an.a().bw(10L).bx(2904L).pz("Server未返回AppInfo数据，本地也没有数据");
            }
            this.ccw = tn;
            com.baidu.swan.apps.core.pms.f.a.a(this.ccw, this.ccr);
            this.ccw.aHp();
            if (com.baidu.swan.pms.database.a.aHb().a(this.ccr, this.cct, this.ccu, this.ccv, this.ccw)) {
                return null;
            }
            return new com.baidu.swan.apps.an.a().bw(10L).bx(2906L).pz("更新DB失败");
        }
        if (this.ccr != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.ccw, this.ccr);
        } else if (com.baidu.swan.apps.core.pms.f.b.Y(this.cct)) {
            this.ccz = this.cct.get(0);
            this.ccz.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.ccw, this.ccz);
        } else {
            PMSAppInfo tn2 = com.baidu.swan.pms.database.a.aHb().tn(this.mAppId);
            if (tn2 == null) {
                return new com.baidu.swan.apps.an.a().bw(10L).bx(2905L).pz("Server未返回包数据，本地也没有数据");
            }
            this.ccw.appId = this.mAppId;
            this.ccw.q(tn2);
        }
        this.ccw.aHp();
        if (com.baidu.swan.pms.database.a.aHb().a(this.ccr, this.cct, this.ccu, this.ccv, this.ccw)) {
            com.baidu.swan.apps.core.pms.f.a.e(this.ccw);
            return null;
        }
        return new com.baidu.swan.apps.an.a().bw(10L).bx(2906L).pz("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abh() {
        if (this.ccw != null) {
            PMSAppInfo tn = com.baidu.swan.pms.database.a.aHb().tn(this.mAppId);
            if (tn == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", getClassName() + ": Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.ccw.appId = this.mAppId;
            this.ccw.q(tn);
            this.ccw.aHp();
            if (com.baidu.swan.pms.database.a.aHb().o(this.ccw)) {
                com.baidu.swan.apps.core.pms.f.a.e(this.ccw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaX() {
        long currentTimeMillis = System.currentTimeMillis() - this.ccA;
        int amW = com.baidu.swan.apps.performance.e.a.amW();
        if (amW > 0 && currentTimeMillis > amW) {
            aO(currentTimeMillis);
        }
    }

    private void aO(long j) {
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "pms download too slow:" + j);
        }
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN != null && apN.RF() == 0) {
            com.baidu.swan.apps.an.a pz = new com.baidu.swan.apps.an.a().bw(10L).bx(2912L).pz("pms download too slow");
            com.baidu.swan.apps.statistic.a.d oL = new com.baidu.swan.apps.statistic.a.d().f(pz).a(apN.RP()).oK(com.baidu.swan.apps.statistic.h.hf(apN.RF())).oL(this.mAppId);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("downloadTime", j);
                if (this.ccw != null) {
                    jSONObject.put("PMSAppInfo", this.ccw.toString());
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            oL.bA(jSONObject);
            com.baidu.swan.apps.statistic.h.b(oL);
            com.baidu.swan.apps.al.a.arZ().u(pz.atP(), oL.toJSONObject());
            if (DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", "downloadSlowStatistic:" + j + " event=" + oL.toJSONObject().toString());
            }
        }
    }

    public f b(com.baidu.swan.apps.aq.e.b<PMSAppInfo> bVar) {
        return a((Collection<Set<com.baidu.swan.apps.aq.e.b<PMSAppInfo>>>) this.ccC, (Set<com.baidu.swan.apps.aq.e.b<PMSAppInfo>>) bVar);
    }

    protected f a(final PMSAppInfo pMSAppInfo) {
        return a((Collection) this.ccC, (com.baidu.swan.apps.aq.e.b) new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
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
            this.ccD.q(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
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
            this.ccD.q(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.aq.e.b<CallbackT> bVar) {
        this.ccD.q(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
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
        return a(this.ccB, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f c(@NonNull final com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a((Collection) this.ccB, (com.baidu.swan.apps.aq.e.b) new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.H(aVar);
                f.this.b((Collection<Set>) f.this.ccB, (Set) aVar);
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
        c.aaT().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.ccr = fVar;
                f.this.ccf.g(fVar);
                if (f.this.ccn != null) {
                    f.this.ccn.onNext(fVar);
                    f.this.ccn.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                f.this.ccf.f(fVar);
                if (f.this.ccn != null) {
                    f.this.ccn.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.aaT().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.cct == null) {
                    f.this.cct = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.cct.add(gVar);
                f.this.ccf.g(gVar);
                if (f.this.cco != null) {
                    f.this.cco.onNext(gVar);
                    if (!f.this.ccf.aIy()) {
                        f.this.cco.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                f.this.ccf.f(gVar);
                if (f.this.cco != null) {
                    f.this.cco.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.aaT().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.ccu = dVar;
                f.this.ccf.g(dVar);
                if (f.this.ccp != null) {
                    f.this.ccp.onNext(dVar);
                    f.this.ccp.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                f.this.ccf.f(dVar);
                if (f.this.ccp != null) {
                    f.this.ccp.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.aaT().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onSuccess ：" + pMSDownloadType);
                }
                f.this.ccv = bVar;
                f.this.ccf.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                }
                f.this.ccf.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.ccq != null) {
            this.ccq.onNext(bVar);
            this.ccq.onCompleted();
        }
    }

    private void abi() {
        ArrayList arrayList = new ArrayList();
        if (this.ccf.aIu()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.ccn = jVar;
                }
            }));
        }
        if (this.ccf.aIv()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.cco = jVar;
                }
            }));
        }
        if (this.ccf.aIw()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.ccp = jVar;
                }
            }));
        }
        if (this.ccf.aIx()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.ccq = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.ccJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bc(String str, String str2) {
        com.baidu.swan.apps.performance.e.a.a(this.mAppId, str, this.ccx, str2);
        this.ccx.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
