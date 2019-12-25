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
/* loaded from: classes9.dex */
public abstract class f extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.pms.f.e bkM;
    private rx.j<? super com.baidu.swan.pms.model.f> bkU;
    private rx.j<? super com.baidu.swan.pms.model.g> bkV;
    private rx.j<? super com.baidu.swan.pms.model.d> bkW;
    private rx.j<? super com.baidu.swan.pms.model.b> bkX;
    protected com.baidu.swan.pms.model.f bkY;
    protected List<com.baidu.swan.pms.model.g> bkZ;
    protected com.baidu.swan.pms.model.d bla;
    protected com.baidu.swan.pms.model.b blb;
    protected PMSAppInfo blc;
    protected com.baidu.swan.pms.model.g blf;
    protected String mAppId;
    private String mClassName = "";
    protected String ble = "0";
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> blg = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String I(com.baidu.swan.pms.model.f fVar) {
            if (fVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.MV();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.MW();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Kp();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.iu(f.this.MJ()).Tw().eV(1);
            super.G(fVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void H(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.iu(f.this.MJ()).Tw().eV(1);
            super.H(fVar);
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
            f.this.bkM.f(fVar);
            com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(11L).aC(aVar.errorNo).mg("主包下载失败").mh(aVar.toString());
            if (f.this.bkU != null) {
                f.this.bkU.onError(new PkgDownloadError(fVar, mh));
            }
            c.My().a(fVar, f.this.MD(), mh);
            com.baidu.swan.d.c.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void E(com.baidu.swan.pms.model.f fVar) {
            com.baidu.swan.apps.x.c.a.iu(f.this.MJ()).Tw().eV(1);
            super.E(fVar);
            f.this.bld.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.ap.a a = f.this.a(fVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: pmsPkgMain=" + fVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: errCode=" + a);
            }
            if (a == null) {
                f.this.bkY = fVar;
                f.this.bkM.g(fVar);
                if (f.this.bkU != null) {
                    f.this.bkU.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.bkU.onCompleted();
                }
                c.My().a(fVar, f.this.MD());
                return;
            }
            f.this.bkM.f(fVar);
            if (f.this.bkU != null) {
                f.this.bkU.onError(new PkgDownloadError(fVar, a));
            }
            c.My().a(fVar, f.this.MD(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            com.baidu.swan.apps.x.c.a.iu(f.this.MJ()).iv(fVar.toString()).eV(1);
            com.baidu.swan.apps.as.d.b<i.a> bVar = new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.core.pms.f.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(i.a aVar) {
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
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> blh = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.7
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String I(com.baidu.swan.pms.model.g gVar) {
            if (gVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.b.ar(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            if (gVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.b.as(f.this.mAppId, String.valueOf(gVar.versionCode));
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Kp();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.g gVar) {
            super.G(gVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void H(com.baidu.swan.pms.model.g gVar) {
            super.H(gVar);
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
            f.this.bkM.f(gVar);
            com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(12L).aC(aVar.errorNo).mg("分包下载失败").mh(aVar.toString());
            if (f.this.bkV != null) {
                f.this.bkV.onError(new PkgDownloadError(gVar, mh));
            }
            c.My().a(gVar, f.this.MD(), mh);
            com.baidu.swan.d.c.deleteFile(gVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void E(com.baidu.swan.pms.model.g gVar) {
            super.E(gVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": sub onFileDownloaded: " + gVar.toString());
            }
            if (f.this.bkZ == null) {
                f.this.bkZ = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            com.baidu.swan.apps.ap.a a = f.this.a(gVar);
            if (a == null) {
                f.this.bkZ.add(gVar);
                f.this.bkM.g(gVar);
                c.My().a(gVar, f.this.MD());
            } else {
                f.this.bkM.f(gVar);
                c.My().a(gVar, f.this.MD(), a);
            }
            if (f.this.bkV != null) {
                f.this.bkV.onNext(gVar);
                if (!f.this.bkM.arP()) {
                    f.this.bkV.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> bli = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.8
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: c */
        public String I(com.baidu.swan.pms.model.d dVar) {
            if (dVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.MX();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.MY();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Kp();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void G(com.baidu.swan.pms.model.d dVar) {
            super.G(dVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void H(com.baidu.swan.pms.model.d dVar) {
            super.H(dVar);
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
            f.this.bkM.f(dVar);
            com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(13L).aC(aVar.errorNo).mg("Framework包下载失败").mh(aVar.toString());
            if (f.this.bkW != null) {
                f.this.bkW.onError(new PkgDownloadError(dVar, mh));
            }
            c.My().a(dVar, f.this.MD(), mh);
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void E(com.baidu.swan.pms.model.d dVar) {
            super.E(dVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": swancore onFileDownloaded: " + dVar.toString());
            }
            com.baidu.swan.apps.ap.a a = f.this.a(dVar);
            if (a == null) {
                f.this.bla = dVar;
                f.this.bkM.g(dVar);
                if (f.this.bkW != null) {
                    f.this.bkW.onNext(dVar);
                    f.this.bkW.onCompleted();
                }
                c.My().a(dVar, f.this.MD());
                return;
            }
            f.this.bkM.f(dVar);
            if (f.this.bkW != null) {
                f.this.bkW.onError(new PkgDownloadError(dVar, a));
            }
            c.My().a(dVar, f.this.MD(), a);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> blj = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: d */
        public String I(com.baidu.swan.pms.model.b bVar) {
            if (bVar.category == 0) {
                return com.baidu.swan.apps.core.pms.d.a.MQ();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.d.a.MZ();
            }
            return null;
        }

        @Override // com.baidu.swan.pms.a.b
        protected int getPriority() {
            return f.this.Kp();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void G(com.baidu.swan.pms.model.b bVar) {
            super.G(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void H(com.baidu.swan.pms.model.b bVar) {
            super.H(bVar);
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
            f.this.bkM.f(bVar);
            com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(14L).aC(aVar.errorNo).mg("Extension下载失败").mh(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", mh.toString());
            }
            f.this.c(bVar);
            c.My().a(bVar, f.this.MD(), mh);
            com.baidu.swan.d.c.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void E(com.baidu.swan.pms.model.b bVar) {
            super.E(bVar);
            com.baidu.swan.apps.ap.a a = f.this.a(bVar);
            if (f.DEBUG) {
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext onFileDownloaded: " + bVar.toString());
                Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": ext errcode=" + a);
            }
            if (a != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.bkM.f(bVar);
                f.this.c(bVar);
                c.My().a(bVar, f.this.MD(), a);
                return;
            }
            f.this.blb = bVar;
            f.this.bkM.g(bVar);
            f.this.c(bVar);
            c.My().a(bVar, f.this.MD());
        }
    };
    private com.baidu.swan.pms.a.f blk = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.10
        @Override // com.baidu.swan.pms.a.f
        public void b(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.blc = pMSAppInfo;
            if (f.this.blc != null) {
                f.this.a(f.this.blc);
                com.baidu.swan.apps.ag.g.b.x(f.this.blc.pluginInfo, true);
                if (f.this.bld != null) {
                    f.this.bld.add(new UbcFlowEvent("na_pms_start_icon"));
                }
                com.baidu.swan.apps.core.pms.d.c.a(f.this.blc.iconUrl, f.this.blc.appCategory, new c.a() { // from class: com.baidu.swan.apps.core.pms.f.10.1
                    @Override // com.baidu.swan.apps.core.pms.d.c.a
                    public void h(Bitmap bitmap) {
                        if (f.this.bld != null) {
                            f.this.bld.add(new UbcFlowEvent("na_pms_end_icon"));
                        }
                    }
                });
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> bll = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.2
        @Override // rx.e
        public void onCompleted() {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.MD() + " : 包下载onCompleted");
            }
            f.this.MC();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.MD() + " : 包下载OnError：" + th.toString());
            }
            f.this.n(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": " + f.this.MD() + " : 单个包下载、业务层处理完成：" + eVar.toString());
            }
        }
    };
    protected List<UbcFlowEvent> bld = new ArrayList();

    protected abstract void MC();

    protected abstract PMSDownloadType MD();

    protected abstract void n(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Ko() {
        this.bld.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void MA() {
        this.bld.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        }
        if (aVar != null && aVar.errorNo == 1010) {
            MK();
        }
        this.bld.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
        if (eVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + eVar.arK());
            }
            this.bld.add(new UbcFlowEvent("na_pms_start_download"));
            this.bkM = eVar;
            if (!this.bkM.isEmpty()) {
                MN();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> ME() {
        return this.blg;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> MF() {
        return this.blh;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> MG() {
        return this.bli;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> MH() {
        return this.blj;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f MI() {
        return this.blk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String MJ() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int Kp() {
        return 100;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.apps.x.c.a iu = com.baidu.swan.apps.x.c.a.iu(MJ());
        iu.Tw().eV(1);
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.ap.a b = com.baidu.swan.apps.core.pms.d.a.b(fVar);
        iu.iv("CostRenameZip: " + (System.currentTimeMillis() - currentTimeMillis));
        return b;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.g gVar) {
        if (!ab.d(new File(gVar.filePath), gVar.sign)) {
            return new com.baidu.swan.apps.ap.a().aB(12L).aD(2300L).mg("分包签名校验失败");
        }
        if (!com.baidu.swan.apps.core.pms.d.b.i(gVar)) {
            return new com.baidu.swan.apps.ap.a().aB(12L).aD(2320L).mg("分包解压失败");
        }
        return null;
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0288a c = com.baidu.swan.apps.swancore.e.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.d.c.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aB(13L).aD(2907L).mg("Core包更新失败");
    }

    protected com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.bqi = bVar.filePath;
        aVar.sign = bVar.sign;
        if (com.baidu.swan.apps.extcore.b.a(bVar.category, aVar)) {
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aB(14L).aD(2908L).mg("Extension包更新失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eq(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.aqM().S(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.aqM().S(this.mAppId, 0);
        }
    }

    private void MK() {
        PMSAppInfo pW = com.baidu.swan.pms.database.a.aqM().pW(this.mAppId);
        if (DEBUG) {
            Log.i("SwanAppPkgDownloadCallback", "updateMainMaxageTime: localAppInfo = " + pW);
        }
        if (pW != null) {
            pW.aqZ();
            if (this.bkY != null) {
                this.bkY.createTime = pW.createTime;
            }
            if (this.blc != null) {
                this.blc.createTime = pW.createTime;
            }
            com.baidu.swan.pms.database.a.aqM().m(pW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.ap.a ML() {
        if (this.blc == null) {
            if (this.bkY == null) {
                return new com.baidu.swan.apps.ap.a().aB(10L).aC(2903L).mg("Server未返回主包&AppInfo");
            }
            PMSAppInfo pW = com.baidu.swan.pms.database.a.aqM().pW(this.mAppId);
            if (pW == null) {
                return new com.baidu.swan.apps.ap.a().aB(10L).aC(2904L).mg("Server未返回AppInfo数据，本地也没有数据");
            }
            this.blc = pW;
            com.baidu.swan.apps.core.pms.d.a.a(this.blc, this.bkY);
            this.blc.aqZ();
            if (com.baidu.swan.pms.database.a.aqM().a(this.bkY, this.bkZ, this.bla, this.blb, this.blc)) {
                return null;
            }
            return new com.baidu.swan.apps.ap.a().aB(10L).aC(2906L).mg("更新DB失败");
        }
        if (this.bkY != null) {
            com.baidu.swan.apps.core.pms.d.a.a(this.blc, this.bkY);
        } else if (com.baidu.swan.apps.core.pms.d.b.M(this.bkZ)) {
            this.blf = this.bkZ.get(0);
            this.blf.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.d.a.a(this.blc, this.blf);
        } else {
            PMSAppInfo pW2 = com.baidu.swan.pms.database.a.aqM().pW(this.mAppId);
            if (pW2 == null) {
                return new com.baidu.swan.apps.ap.a().aB(10L).aC(2905L).mg("Server未返回包数据，本地也没有数据");
            }
            this.blc.appId = this.mAppId;
            this.blc.o(pW2);
        }
        this.blc.aqZ();
        if (com.baidu.swan.pms.database.a.aqM().a(this.bkY, this.bkZ, this.bla, this.blb, this.blc)) {
            com.baidu.swan.apps.core.pms.d.a.d(this.blc);
            return null;
        }
        return new com.baidu.swan.apps.ap.a().aB(10L).aC(2906L).mg("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MM() {
        if (this.blc != null) {
            PMSAppInfo pW = com.baidu.swan.pms.database.a.aqM().pW(this.mAppId);
            if (pW == null) {
                if (DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", getClassName() + ": Server未返回包数据，本地也没查到");
                    return;
                }
                return;
            }
            this.blc.appId = this.mAppId;
            this.blc.o(pW);
            if (this.blc.agr()) {
                this.blc.aqZ();
            }
            if (com.baidu.swan.pms.database.a.aqM().m(this.blc)) {
                com.baidu.swan.apps.core.pms.d.a.d(this.blc);
            }
        }
    }

    public void a(PMSAppInfo pMSAppInfo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        c.My().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.11
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.bkY = fVar;
                f.this.bkM.g(fVar);
                if (f.this.bkU != null) {
                    f.this.bkU.onNext(fVar);
                    f.this.bkU.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bkM.f(fVar);
                if (f.this.bkU != null) {
                    f.this.bkU.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.My().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.12
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.bkZ == null) {
                    f.this.bkZ = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.bkZ.add(gVar);
                f.this.bkM.g(gVar);
                if (f.this.bkV != null) {
                    f.this.bkV.onNext(gVar);
                    if (!f.this.bkM.arP()) {
                        f.this.bkV.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bkM.f(gVar);
                if (f.this.bkV != null) {
                    f.this.bkV.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.My().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.13
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.bla = dVar;
                f.this.bkM.g(dVar);
                if (f.this.bkW != null) {
                    f.this.bkW.onNext(dVar);
                    f.this.bkW.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                f.this.bkM.f(dVar);
                if (f.this.bkW != null) {
                    f.this.bkW.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.My().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.14
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onSuccess ：" + pMSDownloadType);
                }
                f.this.blb = bVar;
                f.this.bkM.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.ap.a aVar) {
                if (f.DEBUG) {
                    Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                }
                f.this.bkM.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.bkX != null) {
            this.bkX.onNext(bVar);
            this.bkX.onCompleted();
        }
    }

    private void MN() {
        ArrayList arrayList = new ArrayList();
        if (this.bkM.arL()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.bkU = jVar;
                }
            }));
        }
        if (this.bkM.arM()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.bkV = jVar;
                }
            }));
        }
        if (this.bkM.arN()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.bkW = jVar;
                }
            }));
        }
        if (this.bkM.arO()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.bkX = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.m(arrayList).b(this.bll);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aq(String str, String str2) {
        com.baidu.swan.apps.performance.c.a.a(this.mAppId, str, this.bld, str2);
        this.bld.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
