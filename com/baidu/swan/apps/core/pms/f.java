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
/* loaded from: classes3.dex */
public abstract class f extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.pms.utils.f cmf;
    protected List<com.baidu.swan.pms.model.g> cmh;
    private rx.j<? super com.baidu.swan.pms.model.f> cmp;
    private rx.j<? super com.baidu.swan.pms.model.g> cmq;
    private rx.j<? super com.baidu.swan.pms.model.d> cmr;
    private rx.j<? super com.baidu.swan.pms.model.b> cms;
    protected com.baidu.swan.pms.model.f cmt;
    protected com.baidu.swan.pms.model.d cmu;
    protected com.baidu.swan.pms.model.b cmv;
    protected PMSAppInfo cmw;
    protected com.baidu.swan.pms.model.g cmz;
    protected String mAppId;
    private String mClassName = "";
    protected String cmy = "0";
    private long cmA = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> cmB = new HashSet();
    private final Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>> cmC = new HashSet();
    private final aq cmD = new aq();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> cmE = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String R(com.baidu.swan.pms.model.f fVar) {
            if (fVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.ajC();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.ajD();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.ago();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void P(com.baidu.swan.pms.model.f fVar) {
            String ajp = f.this.ajp();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.ol(ajp).arY().ip(1);
            }
            super.P(fVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void Q(com.baidu.swan.pms.model.f fVar) {
            String ajp = f.this.ajp();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.ol(ajp).arY().ip(1);
            }
            super.Q(fVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onDownloading");
            }
            f.this.b(fVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.f fVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) fVar, aVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.cmf.f(fVar);
            com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(11L).bQ(aVar.errorNo).sF("主包下载失败").sH(aVar.toString());
            if (f.this.cmp != null) {
                f.this.cmp.onError(new PkgDownloadError(fVar, sH));
            }
            c.ajd().a(fVar, f.this.ajk(), sH);
            com.baidu.swan.c.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void N(com.baidu.swan.pms.model.f fVar) {
            String ajp = f.this.ajp();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.ol(ajp).arY().ip(1);
            }
            super.N(fVar);
            f.this.cmx.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.am.a a = f.this.a(fVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.versionCode);
            if (a == null) {
                f.this.cmt = fVar;
                f.this.cmf.g(fVar);
                if (f.this.cmp != null) {
                    f.this.cmp.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.cmp.onCompleted();
                }
                c.ajd().a(fVar, f.this.ajk());
                return;
            }
            f.this.cmf.f(fVar);
            if (f.this.cmp != null) {
                f.this.cmp.onError(new PkgDownloadError(fVar, a));
            }
            c.ajd().a(fVar, f.this.ajk(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String ajp = f.this.ajp();
            if (f.DEBUG) {
                com.baidu.swan.apps.u.e.a.ol(ajp).om(fVar.toString()).ip(1);
            }
            com.baidu.swan.apps.ap.e.b<i.a> bVar = new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.core.pms.f.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: b */
                public void J(i.a aVar) {
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cmj = new k<f>(this) { // from class: com.baidu.swan.apps.core.pms.f.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.ago();
        }

        @Override // com.baidu.swan.apps.core.pms.k
        public String getAppKey() {
            return f.this.mAppId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void P(com.baidu.swan.pms.model.g gVar) {
            super.P(gVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "sub onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void Q(com.baidu.swan.pms.model.g gVar) {
            super.Q(gVar);
            f.this.b(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.g gVar, com.baidu.swan.pms.model.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.cmf.f(gVar);
            com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(12L).bQ(aVar.errorNo).sF("分包下载失败").sH(aVar.toString());
            if (f.this.cmq != null) {
                f.this.cmq.onError(new PkgDownloadError(gVar, sH));
            }
            c.ajd().a(gVar, f.this.ajk(), sH);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k
        public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.am.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.versionCode);
            if (f.this.cmh == null) {
                f.this.cmh = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            if (aVar == null) {
                f.this.cmh.add(gVar);
                f.this.cmf.g(gVar);
                c.ajd().a(gVar, f.this.ajk());
            } else {
                f.this.cmf.f(gVar);
                c.ajd().a(gVar, f.this.ajk(), aVar);
            }
            if (f.this.cmq != null) {
                f.this.cmq.onNext(gVar);
                if (!f.this.cmf.aVC()) {
                    f.this.cmq.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cmF = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String R(com.baidu.swan.pms.model.d dVar) {
            if (dVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.ajE();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.ajF();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.ago();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void P(com.baidu.swan.pms.model.d dVar) {
            super.P(dVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "framework onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void Q(com.baidu.swan.pms.model.d dVar) {
            super.Q(dVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": framework onDownloading");
            }
            f.this.b(dVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass15) dVar, aVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.cmf.f(dVar);
            com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(13L).bQ(aVar.errorNo).sF("Framework包下载失败").sH(aVar.toString());
            if (f.this.cmr != null) {
                f.this.cmr.onError(new PkgDownloadError(dVar, sH));
            }
            c.ajd().a(dVar, f.this.ajk(), sH);
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void N(com.baidu.swan.pms.model.d dVar) {
            super.N(dVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.versionCode);
            com.baidu.swan.apps.am.a a = f.this.a(dVar);
            if (a == null) {
                f.this.cmu = dVar;
                f.this.cmf.g(dVar);
                if (f.this.cmr != null) {
                    f.this.cmr.onNext(dVar);
                    f.this.cmr.onCompleted();
                }
                c.ajd().a(dVar, f.this.ajk());
                return;
            }
            f.this.cmf.f(dVar);
            if (f.this.cmr != null) {
                f.this.cmr.onError(new PkgDownloadError(dVar, a));
            }
            c.ajd().a(dVar, f.this.ajk(), a);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cmG = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String R(com.baidu.swan.pms.model.b bVar) {
            if (bVar.category == 0) {
                return com.baidu.swan.apps.core.pms.f.a.ajw();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.ajG();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.ago();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void P(com.baidu.swan.pms.model.b bVar) {
            super.P(bVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "extension onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void Q(com.baidu.swan.pms.model.b bVar) {
            super.Q(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": extension onDownloading");
            }
            f.this.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass16) bVar, aVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.cmf.f(bVar);
            com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(14L).bQ(aVar.errorNo).sF("Extension下载失败").sH(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", sH.toString());
            }
            f.this.c(bVar);
            c.ajd().a(bVar, f.this.ajk(), sH);
            com.baidu.swan.c.d.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void N(com.baidu.swan.pms.model.b bVar) {
            super.N(bVar);
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.versionCode);
            com.baidu.swan.apps.am.a a = f.this.a(bVar);
            if (a != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.cmf.f(bVar);
                f.this.c(bVar);
                c.ajd().a(bVar, f.this.ajk(), a);
                return;
            }
            f.this.cmv = bVar;
            f.this.cmf.g(bVar);
            f.this.c(bVar);
            c.ajd().a(bVar, f.this.ajk());
        }
    };
    private com.baidu.swan.pms.a.f cmH = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void e(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.cmw = pMSAppInfo;
            if (f.this.cmw != null) {
                f.this.c(f.this.cmw);
                com.baidu.swan.apps.ac.g.b.U(f.this.cmw.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> cmI = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", f.this.ajk() + " : 包下载onCompleted");
            f.this.ajj();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            com.baidu.swan.apps.console.c.f("SwanAppPkgDownloadCallback", f.this.ajk() + " : 包下载OnError", th);
            f.this.o(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", f.this.ajk() + " : 单个包下载、业务层处理完成：" + eVar.versionCode);
        }
    };
    protected List<UbcFlowEvent> cmx = new ArrayList();

    protected abstract PMSDownloadType ajk();

    protected abstract void o(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void agn() {
        this.cmx.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void ajg() {
        this.cmx.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.errorNo == 1010) {
            ajq();
        }
        this.cmx.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        super.a(fVar);
        this.cmA = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.cmA);
        }
        if (fVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + fVar.aVw());
            }
            this.cmx.add(new UbcFlowEvent("na_pms_start_download"));
            this.cmf = fVar;
            if (!this.cmf.isEmpty()) {
                ajt();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> ajl() {
        return this.cmE;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> aji() {
        return this.cmj;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> ajm() {
        return this.cmF;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> ajn() {
        return this.cmG;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f ajo() {
        return this.cmH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ajp() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int ago() {
        return 100;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.f fVar) {
        if (fVar == null) {
            com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(11L).bQ(2310L).sH("pkg info is empty");
            com.baidu.swan.apps.am.e.aEQ().j(sH);
            return sH;
        }
        return null;
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0445a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.c.d.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.am.a().bP(13L).bR(2907L).sF("Core包更新失败");
    }

    protected com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.ctG = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.am.a().bP(14L).bR(2908L).sF("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hr(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.aUf().ab(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.aUf().ab(this.mAppId, 0);
        }
    }

    private void ajq() {
        PMSAppInfo wT = com.baidu.swan.pms.database.a.aUf().wT(this.mAppId);
        com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + wT.createTime + " lastLaunchTime=" + wT.getLastLaunchTime() + " maxAge=" + wT.maxAge);
        if (wT != null) {
            wT.aUq();
            wT.lZ(ajx());
            if (this.cmt != null) {
                this.cmt.createTime = wT.createTime;
            }
            if (this.cmw != null) {
                this.cmw.createTime = wT.createTime;
                this.cmw.lZ(ajx());
            }
            com.baidu.swan.pms.database.a.aUf().r(wT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.am.a ajr() {
        if (this.cmw == null) {
            if (this.cmt == null) {
                return new com.baidu.swan.apps.am.a().bP(10L).bQ(2903L).sF("Server未返回主包&AppInfo");
            }
            PMSAppInfo wT = com.baidu.swan.pms.database.a.aUf().wT(this.mAppId);
            if (wT == null) {
                return new com.baidu.swan.apps.am.a().bP(10L).bQ(2904L).sF("Server未返回AppInfo数据，本地也没有数据");
            }
            this.cmw = wT;
            com.baidu.swan.apps.core.pms.f.a.a(this.cmw, this.cmt);
            this.cmw.aUq();
            this.cmw.lZ(ajx());
            if (com.baidu.swan.pms.database.a.aUf().a(this.cmt, this.cmh, this.cmu, this.cmv, this.cmw)) {
                return null;
            }
            return new com.baidu.swan.apps.am.a().bP(10L).bQ(2906L).sF("更新DB失败");
        }
        if (this.cmt != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.cmw, this.cmt);
        } else if (com.baidu.swan.apps.core.pms.f.b.ad(this.cmh)) {
            this.cmz = this.cmh.get(0);
            this.cmz.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.cmw, this.cmz);
        } else {
            PMSAppInfo wT2 = com.baidu.swan.pms.database.a.aUf().wT(this.mAppId);
            if (wT2 == null) {
                return new com.baidu.swan.apps.am.a().bP(10L).bQ(2905L).sF("Server未返回包数据，本地也没有数据");
            }
            this.cmw.appId = this.mAppId;
            this.cmw.u(wT2);
        }
        this.cmw.aUq();
        this.cmw.lZ(ajx());
        if (com.baidu.swan.pms.database.a.aUf().a(this.cmt, this.cmh, this.cmu, this.cmv, this.cmw)) {
            com.baidu.swan.apps.core.pms.f.a.g(this.cmw);
            return null;
        }
        return new com.baidu.swan.apps.am.a().bP(10L).bQ(2906L).sF("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajs() {
        if (this.cmw != null) {
            PMSAppInfo wT = com.baidu.swan.pms.database.a.aUf().wT(this.mAppId);
            if (wT == null) {
                com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                return;
            }
            this.cmw.appId = this.mAppId;
            wT.lZ(ajx());
            this.cmw.u(wT);
            this.cmw.aUq();
            if (com.baidu.swan.pms.database.a.aUf().r(this.cmw)) {
                com.baidu.swan.apps.core.pms.f.a.g(this.cmw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajj() {
        com.baidu.swan.apps.console.c.i("SwanAppPkgDownloadCallback", "pms download time : " + (System.currentTimeMillis() - this.cmA));
    }

    public f c(com.baidu.swan.apps.ap.e.b<PMSAppInfo> bVar) {
        return a((Collection<Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>>) this.cmC, (Set<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>) bVar);
    }

    protected f c(final PMSAppInfo pMSAppInfo) {
        return a((Collection) this.cmC, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: e */
            public void J(com.baidu.swan.apps.ap.e.b<PMSAppInfo> bVar) {
                bVar.J(pMSAppInfo);
            }
        });
    }

    private synchronized <CallbackT> f a(final Collection<CallbackT> collection, final CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.cmD.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
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
            this.cmD.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.ap.e.b<CallbackT> bVar) {
        this.cmD.n(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : collection) {
                    bVar.J(obj);
                }
            }
        });
        return this;
    }

    public synchronized f a(com.baidu.swan.apps.core.pms.a.a aVar) {
        return a(this.cmB, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f d(@NonNull final com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a((Collection) this.cmB, (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void J(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.J(aVar);
                f.this.b((Collection<Set>) f.this.cmB, (Set) aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final com.baidu.swan.apps.am.a aVar, final boolean z) {
        d(new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void J(com.baidu.swan.apps.core.pms.a.a aVar2) {
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
            public void J(com.baidu.swan.apps.core.pms.a.a aVar) {
                aVar.f(pMSAppInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        c.ajd().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cmt = fVar;
                f.this.cmf.g(fVar);
                if (f.this.cmp != null) {
                    f.this.cmp.onNext(fVar);
                    f.this.cmp.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cmf.f(fVar);
                if (f.this.cmp != null) {
                    f.this.cmp.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.ajd().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.cmh == null) {
                    f.this.cmh = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.cmh.add(gVar);
                f.this.cmf.g(gVar);
                if (f.this.cmq != null) {
                    f.this.cmq.onNext(gVar);
                    if (!f.this.cmf.aVC()) {
                        f.this.cmq.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cmf.f(gVar);
                if (f.this.cmq != null) {
                    f.this.cmq.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.ajd().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cmu = dVar;
                f.this.cmf.g(dVar);
                if (f.this.cmr != null) {
                    f.this.cmr.onNext(dVar);
                    f.this.cmr.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cmf.f(dVar);
                if (f.this.cmr != null) {
                    f.this.cmr.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.ajd().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f.this.cmv = bVar;
                f.this.cmf.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                com.baidu.swan.apps.console.c.bb("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                f.this.cmf.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.cms != null) {
            this.cms.onNext(bVar);
            this.cms.onCompleted();
        }
    }

    private void ajt() {
        ArrayList arrayList = new ArrayList();
        if (this.cmf.aVx()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.cmp = jVar;
                }
            }));
        }
        if (this.cmf.aVy()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.cmq = jVar;
                }
            }));
        }
        if (this.cmf.aVA()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.cmr = jVar;
                }
            }));
        }
        if (this.cmf.aVB()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.cms = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.cmI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bm(String str, String str2) {
        com.baidu.swan.apps.performance.f.a.a(this.mAppId, str, this.cmx, str2);
        this.cmx.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
