package com.baidu.swan.apps.core.pms;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ab;
import com.baidu.swan.apps.core.pms.c;
import com.baidu.swan.apps.core.pms.d.c;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.swancore.e.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import okio.BufferedSource;
import rx.d;
/* loaded from: classes11.dex */
public abstract class f extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.pms.f.e bpZ;
    private rx.j<? super com.baidu.swan.pms.model.f> bqh;
    private rx.j<? super com.baidu.swan.pms.model.g> bqi;
    private rx.j<? super com.baidu.swan.pms.model.d> bqj;
    private rx.j<? super com.baidu.swan.pms.model.b> bqk;
    protected com.baidu.swan.pms.model.f bql;
    protected List<com.baidu.swan.pms.model.g> bqm;
    protected com.baidu.swan.pms.model.d bqn;
    protected com.baidu.swan.pms.model.b bqo;
    protected PMSAppInfo bqp;
    protected com.baidu.swan.pms.model.g bqs;
    protected String mAppId;
    private String mClassName = "";
    protected String bqr = "0";
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> bqt = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String K(com.baidu.swan.pms.model.f fVar) {
            if (fVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.PK();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.PL();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Nf();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void I(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.iL(f.this.Py()).Wm().fm(1);
            super.I(fVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void J(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.iL(f.this.Py()).Wm().fm(1);
            super.J(fVar);
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
            f.this.bpZ.f(fVar);
            com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(11L).aJ(aVar.errorNo).mx("主包下载失败").my(aVar.toString());
            if (f.this.bqh != null) {
                f.this.bqh.onError(new PkgDownloadError(fVar, my));
            }
            c.Pn().a(fVar, f.this.Ps(), my);
            com.baidu.swan.d.c.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void G(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.iL(f.this.Py()).Wm().fm(1);
            super.G(fVar);
            f.this.bqq.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ap.a a = f.this.a(fVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: pmsPkgMain=" + fVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: errCode=" + a);
            }
            if (a == null) {
                f.this.bql = fVar;
                f.this.bpZ.g(fVar);
                if (f.this.bqh != null) {
                    f.this.bqh.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.bqh.onCompleted();
                }
                c.Pn().a(fVar, f.this.Ps());
                return;
            }
            f.this.bpZ.f(fVar);
            if (f.this.bqh != null) {
                f.this.bqh.onError(new PkgDownloadError(fVar, a));
            }
            c.Pn().a(fVar, f.this.Ps(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            com.baidu.swan.apps.x.c.a.iL(f.this.Py()).iM(fVar.toString()).fm(1);
            com.baidu.swan.apps.as.d.b<i.a> bVar = new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.core.pms.f.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(i.a aVar) {
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
            com.baidu.swan.apps.t.g gVar = new com.baidu.swan.apps.t.g();
            gVar.e(bVar);
            boolean isOk = gVar.x(bundle).a(new com.baidu.swan.apps.t.f(fVar, f.this)).a(new com.baidu.swan.apps.t.d(fVar.sign, f.this)).a(new com.baidu.swan.apps.t.c(file)).a(bufferedSource).isOk();
            gVar.f(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onProcessStream: installOk=" + isOk);
            }
            return isOk ? new com.baidu.swan.pms.model.a(PushConstants.DOWN_LOAD_LARGE_ICON_ERROR, "业务层处理下载流成功") : new com.baidu.swan.pms.model.a(PushConstants.DOWN_LOAD_LARGE_ICON_SUCCESS, "业务层处理下载流失败");
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> bqu = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.7
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String K(com.baidu.swan.pms.model.g gVar) {
            if (gVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.b.aB(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            if (gVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.b.aC(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Nf();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void I(com.baidu.swan.pms.model.g gVar) {
            super.I(gVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void J(com.baidu.swan.pms.model.g gVar) {
            super.J(gVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onDownloading");
            }
            f.this.b(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.g gVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass7) gVar, aVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onDownloadError：" + aVar.toString());
            }
            f.this.bpZ.f(gVar);
            com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(12L).aJ(aVar.errorNo).mx("分包下载失败").my(aVar.toString());
            if (f.this.bqi != null) {
                f.this.bqi.onError(new PkgDownloadError(gVar, my));
            }
            c.Pn().a(gVar, f.this.Ps(), my);
            com.baidu.swan.d.c.deleteFile(gVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void G(com.baidu.swan.pms.model.g gVar) {
            super.G(gVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onFileDownloaded: " + gVar.toString());
            }
            if (f.this.bqm == null) {
                f.this.bqm = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            com.baidu.swan.apps.ap.a a = f.this.a(gVar);
            if (a == null) {
                f.this.bqm.add(gVar);
                f.this.bpZ.g(gVar);
                c.Pn().a(gVar, f.this.Ps());
            } else {
                f.this.bpZ.f(gVar);
                c.Pn().a(gVar, f.this.Ps(), a);
            }
            if (f.this.bqi != null) {
                f.this.bqi.onNext(gVar);
                if (!f.this.bpZ.auB()) {
                    f.this.bqi.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> bqv = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.8
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String K(com.baidu.swan.pms.model.d dVar) {
            if (dVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.PM();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.PN();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Nf();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void I(com.baidu.swan.pms.model.d dVar) {
            super.I(dVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void J(com.baidu.swan.pms.model.d dVar) {
            super.J(dVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": framework onDownloading");
            }
            f.this.b(dVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass8) dVar, aVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onDownloadError：" + aVar.toString());
            }
            f.this.bpZ.f(dVar);
            com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(13L).aJ(aVar.errorNo).mx("Framework包下载失败").my(aVar.toString());
            if (f.this.bqj != null) {
                f.this.bqj.onError(new PkgDownloadError(dVar, my));
            }
            c.Pn().a(dVar, f.this.Ps(), my);
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void G(com.baidu.swan.pms.model.d dVar) {
            super.G(dVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": swancore onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ap.a a = f.this.a(dVar);
            if (a == null) {
                f.this.bqn = dVar;
                f.this.bpZ.g(dVar);
                if (f.this.bqj != null) {
                    f.this.bqj.onNext(dVar);
                    f.this.bqj.onCompleted();
                }
                c.Pn().a(dVar, f.this.Ps());
                return;
            }
            f.this.bpZ.f(dVar);
            if (f.this.bqj != null) {
                f.this.bqj.onError(new PkgDownloadError(dVar, a));
            }
            c.Pn().a(dVar, f.this.Ps(), a);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> bqw = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String K(com.baidu.swan.pms.model.b bVar) {
            if (bVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.PF();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.PO();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Nf();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void I(com.baidu.swan.pms.model.b bVar) {
            super.I(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void J(com.baidu.swan.pms.model.b bVar) {
            super.J(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": extension onDownloading");
            }
            f.this.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass9) bVar, aVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onDownloadError：" + aVar.toString());
            }
            f.this.bpZ.f(bVar);
            com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(14L).aJ(aVar.errorNo).mx("Extension下载失败").my(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", my.toString());
            }
            f.this.c(bVar);
            c.Pn().a(bVar, f.this.Ps(), my);
            com.baidu.swan.d.c.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void G(com.baidu.swan.pms.model.b bVar) {
            super.G(bVar);
            com.baidu.swan.apps.ap.a a = f.this.a(bVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext onFileDownloaded: " + bVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext errcode=" + a);
            }
            if (a != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.bpZ.f(bVar);
                f.this.c(bVar);
                c.Pn().a(bVar, f.this.Ps(), a);
                return;
            }
            f.this.bqo = bVar;
            f.this.bpZ.g(bVar);
            f.this.c(bVar);
            c.Pn().a(bVar, f.this.Ps());
        }
    };
    private com.baidu.swan.pms.a.f bqx = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.10
        @Override // com.baidu.swan.pms.a.f
        public void b(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.bqp = pMSAppInfo;
            if (f.this.bqp != null) {
                f.this.a(f.this.bqp);
                com.baidu.swan.apps.ag.g.b.x(f.this.bqp.pluginInfo, true);
                if (f.this.bqq != null) {
                    f.this.bqq.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.d.c.a(f.this.bqp.iconUrl, f.this.bqp.appCategory, new c.a() { // from class: com.baidu.swan.apps.core.pms.f.10.1
                    @Override // com.baidu.swan.apps.core.pms.d.c.a
                    public void h(Bitmap bitmap) {
                        if (f.this.bqq != null) {
                            f.this.bqq.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> bqy = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.2
        @Override // rx.e
        public void onCompleted() {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.Ps() + " : 包下载onCompleted");
            }
            f.this.Pr();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.Ps() + " : 包下载OnError：" + th.toString());
            }
            f.this.m(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.Ps() + " : 单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> bqq = new ArrayList();

    protected abstract void Pr();

    protected abstract PMSDownloadType Ps();

    protected abstract void m(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Ne() {
        this.bqq.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pp() {
        this.bqq.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        }
        if (aVar != null && aVar.errorNo == 1010) {
            Pz();
        }
        this.bqq.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + eVar.auw());
            }
            this.bqq.add(new UbcFlowEvent("na_pms_start_download"));
            this.bpZ = eVar;
            if (!this.bpZ.isEmpty()) {
                PC();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> Pt() {
        return this.bqt;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> Pu() {
        return this.bqu;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> Pv() {
        return this.bqv;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> Pw() {
        return this.bqw;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f Px() {
        return this.bqx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Py() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int Nf() {
        return 100;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.apps.x.c.a iL = com.baidu.swan.apps.x.c.a.iL(Py());
        iL.Wm().fm(1);
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.ap.a b = com.baidu.swan.apps.core.pms.d.a.b(fVar);
        iL.iM("CostRenameZip: " + (System.currentTimeMillis() - currentTimeMillis));
        return b;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.g gVar) {
        if (!ab.d(new File(gVar.filePath), gVar.sign)) {
            return new com.baidu.swan.apps.ap.a().aI(12L).aK(2300L).mx("分包签名校验失败");
        }
        if (!com.baidu.swan.apps.core.pms.d.b.i(gVar)) {
            return new com.baidu.swan.apps.ap.a().aI(12L).aK(2320L).mx("分包解压失败");
        }
        return null;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0300a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aI(13L).aK(2907L).mx("Core包更新失败");
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.bvu = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(bVar.category, aVar)) {
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aI(14L).aK(2908L).mx("Extension包更新失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eH(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.aty().Q(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.aty().Q(this.mAppId, 0);
        }
    }

    private void Pz() {
        PMSAppInfo qn = com.baidu.swan.pms.database.a.aty().qn(this.mAppId);
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "updateMainMaxageTime: localAppInfo = " + qn);
        }
        if (qn != null) {
            qn.atL();
            if (this.bql != null) {
                this.bql.createTime = qn.createTime;
            }
            if (this.bqp != null) {
                this.bqp.createTime = qn.createTime;
            }
            com.baidu.swan.pms.database.a.aty().m(qn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.ap.a PA() {
        if (this.bqp == null) {
            if (this.bql == null) {
                return new com.baidu.swan.apps.ap.a().aI(10L).aJ(2903L).mx("Server未返回主包&AppInfo");
            }
            PMSAppInfo qn = com.baidu.swan.pms.database.a.aty().qn(this.mAppId);
            if (qn == null) {
                return new com.baidu.swan.apps.ap.a().aI(10L).aJ(2904L).mx("Server未返回AppInfo数据，本地也没有数据");
            }
            this.bqp = qn;
            com.baidu.swan.apps.core.pms.d.a.a(this.bqp, this.bql);
            this.bqp.atL();
            if (com.baidu.swan.pms.database.a.aty().a(this.bql, this.bqm, this.bqn, this.bqo, this.bqp)) {
                return null;
            }
            return new com.baidu.swan.apps.ap.a().aI(10L).aJ(2906L).mx("更新DB失败");
        }
        if (this.bql != null) {
            com.baidu.swan.apps.core.pms.d.a.a(this.bqp, this.bql);
        } else if (com.baidu.swan.apps.core.pms.d.b.L(this.bqm)) {
            this.bqs = this.bqm.get(0);
            this.bqs.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.d.a.a(this.bqp, this.bqs);
        } else {
            PMSAppInfo qn2 = com.baidu.swan.pms.database.a.aty().qn(this.mAppId);
            if (qn2 == null) {
                return new com.baidu.swan.apps.ap.a().aI(10L).aJ(2905L).mx("Server未返回包数据，本地也没有数据");
            }
            this.bqp.appId = this.mAppId;
            this.bqp.o(qn2);
        }
        this.bqp.atL();
        if (com.baidu.swan.pms.database.a.aty().a(this.bql, this.bqm, this.bqn, this.bqo, this.bqp)) {
            com.baidu.swan.apps.core.pms.d.a.d(this.bqp);
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aI(10L).aJ(2906L).mx("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void PB() {
        if (this.bqp != null) {
            PMSAppInfo qn = com.baidu.swan.pms.database.a.aty().qn(this.mAppId);
            if (qn == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", getClassName() + ": Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.bqp.appId = this.mAppId;
            this.bqp.o(qn);
            if (this.bqp.ajd()) {
                this.bqp.atL();
            }
            if (com.baidu.swan.pms.database.a.aty().m(this.bqp)) {
                com.baidu.swan.apps.core.pms.d.a.d(this.bqp);
            }
        }
    }

    public void a(PMSAppInfo pMSAppInfo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        c.Pn().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.11
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.bql = fVar;
                f.this.bpZ.g(fVar);
                if (f.this.bqh != null) {
                    f.this.bqh.onNext(fVar);
                    f.this.bqh.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bpZ.f(fVar);
                if (f.this.bqh != null) {
                    f.this.bqh.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.Pn().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.12
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.bqm == null) {
                    f.this.bqm = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.bqm.add(gVar);
                f.this.bpZ.g(gVar);
                if (f.this.bqi != null) {
                    f.this.bqi.onNext(gVar);
                    if (!f.this.bpZ.auB()) {
                        f.this.bqi.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bpZ.f(gVar);
                if (f.this.bqi != null) {
                    f.this.bqi.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.Pn().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.13
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.bqn = dVar;
                f.this.bpZ.g(dVar);
                if (f.this.bqj != null) {
                    f.this.bqj.onNext(dVar);
                    f.this.bqj.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bpZ.f(dVar);
                if (f.this.bqj != null) {
                    f.this.bqj.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.Pn().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.14
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onSuccess ：" + pMSDownloadType);
                }
                f.this.bqo = bVar;
                f.this.bpZ.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                }
                f.this.bpZ.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.bqk != null) {
            this.bqk.onNext(bVar);
            this.bqk.onCompleted();
        }
    }

    private void PC() {
        ArrayList arrayList = new ArrayList();
        if (this.bpZ.aux()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.bqh = jVar;
                }
            }));
        }
        if (this.bpZ.auy()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.bqi = jVar;
                }
            }));
        }
        if (this.bpZ.auz()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.bqj = jVar;
                }
            }));
        }
        if (this.bpZ.auA()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.bqk = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.m(arrayList).b(this.bqy);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aA(String str, String str2) {
        com.baidu.swan.apps.performance.c.a.a(this.mAppId, str, this.bqq, str2);
        this.bqq.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
