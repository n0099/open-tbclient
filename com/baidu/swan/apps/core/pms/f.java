package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ar;
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
/* loaded from: classes7.dex */
public abstract class f extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.pms.f.f cdJ;
    protected List<com.baidu.swan.pms.model.g> cdL;
    private rx.j<? super com.baidu.swan.pms.model.f> cdT;
    private rx.j<? super com.baidu.swan.pms.model.g> cdU;
    private rx.j<? super com.baidu.swan.pms.model.d> cdV;
    private rx.j<? super com.baidu.swan.pms.model.b> cdW;
    protected com.baidu.swan.pms.model.f cdX;
    protected com.baidu.swan.pms.model.d cdY;
    protected com.baidu.swan.pms.model.b cdZ;
    protected PMSAppInfo cea;
    protected com.baidu.swan.pms.model.g ced;
    protected String mAppId;
    private String mClassName = "";
    protected String cec = "0";
    private long cee = -1;
    private final Set<com.baidu.swan.apps.core.pms.a.a> cef = new HashSet();
    private final Set<com.baidu.swan.apps.aq.e.b<PMSAppInfo>> ceg = new HashSet();
    private final ar ceh = new ar();
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> cei = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.1
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
                return com.baidu.swan.apps.core.pms.f.a.act();
            }
            if (fVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.acu();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.Zv();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void N(com.baidu.swan.pms.model.f fVar) {
            String acg = f.this.acg();
            if (com.baidu.swan.apps.performance.b.b.aoo()) {
                if (f.DEBUG) {
                    com.baidu.swan.apps.u.d.a.lT(acg).ajH().gb(1);
                }
            } else {
                com.baidu.swan.apps.u.d.a.lT(acg).ajH().gb(1);
            }
            super.N(fVar);
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void O(com.baidu.swan.pms.model.f fVar) {
            String acg = f.this.acg();
            if (com.baidu.swan.apps.performance.b.b.aoo()) {
                if (f.DEBUG) {
                    com.baidu.swan.apps.u.d.a.lT(acg).ajH().gb(1);
                }
            } else {
                com.baidu.swan.apps.u.d.a.lT(acg).ajH().gb(1);
            }
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
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.cdJ.f(fVar);
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(11L).bK(aVar.errorNo).qk("主包下载失败").qm(aVar.toString());
            if (f.this.cdT != null) {
                f.this.cdT.onError(new PkgDownloadError(fVar, qm));
            }
            c.abU().a(fVar, f.this.acb(), qm);
            com.baidu.swan.d.d.deleteFile(fVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(com.baidu.swan.pms.model.f fVar) {
            String acg = f.this.acg();
            if (com.baidu.swan.apps.performance.b.b.aoo()) {
                if (f.DEBUG) {
                    com.baidu.swan.apps.u.d.a.lT(acg).ajH().gb(1);
                }
            } else {
                com.baidu.swan.apps.u.d.a.lT(acg).ajH().gb(1);
            }
            super.L(fVar);
            f.this.ceb.add(new UbcFlowEvent("na_pms_end_download"));
            com.baidu.swan.apps.an.a a = f.this.a(fVar);
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.versionCode);
            if (a == null) {
                f.this.cdX = fVar;
                f.this.cdJ.g(fVar);
                if (f.this.cdT != null) {
                    f.this.cdT.onNext(fVar);
                    if (f.DEBUG) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.getClassName() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.cdT.onCompleted();
                }
                c.abU().a(fVar, f.this.acb());
                return;
            }
            f.this.cdJ.f(fVar);
            if (f.this.cdT != null) {
                f.this.cdT.onError(new PkgDownloadError(fVar, a));
            }
            c.abU().a(fVar, f.this.acb(), a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public com.baidu.swan.pms.model.a a(com.baidu.swan.pms.model.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String acg = f.this.acg();
            if (com.baidu.swan.apps.performance.b.b.aoo()) {
                if (f.DEBUG) {
                    com.baidu.swan.apps.u.d.a.lT(acg).lU(fVar.toString()).gb(1);
                }
            } else {
                com.baidu.swan.apps.u.d.a.lT(acg).lU(fVar.toString()).gb(1);
            }
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
            com.baidu.swan.apps.r.f fVar2 = new com.baidu.swan.apps.r.f();
            fVar2.o(bVar);
            boolean isOk = fVar2.C(bundle).a(new com.baidu.swan.apps.r.e(fVar, f.this)).a(new com.baidu.swan.apps.r.c(fVar.sign, f.this)).a(bufferedSource).isOk();
            fVar2.p(bVar);
            if (f.DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onProcessStream: installOk=" + isOk);
            }
            if (isOk) {
                com.baidu.swan.d.d.deleteFile(file);
            }
            return isOk ? new com.baidu.swan.pms.model.a(PushConstants.DOWN_LOAD_LARGE_ICON_ERROR, "业务层处理下载流成功") : new com.baidu.swan.pms.model.a(PushConstants.DOWN_LOAD_LARGE_ICON_SUCCESS, "业务层处理下载流失败");
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> cdN = new k<f>(this) { // from class: com.baidu.swan.apps.core.pms.f.12
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.Zv();
        }

        @Override // com.baidu.swan.apps.core.pms.k
        public String getAppKey() {
            return f.this.mAppId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void N(com.baidu.swan.pms.model.g gVar) {
            super.N(gVar);
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "sub onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void O(com.baidu.swan.pms.model.g gVar) {
            super.O(gVar);
            f.this.b(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.core.pms.k, com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(com.baidu.swan.pms.model.g gVar, com.baidu.swan.pms.model.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.cdJ.f(gVar);
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(12L).bK(aVar.errorNo).qk("分包下载失败").qm(aVar.toString());
            if (f.this.cdU != null) {
                f.this.cdU.onError(new PkgDownloadError(gVar, qm));
            }
            c.abU().a(gVar, f.this.acb(), qm);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.core.pms.k
        public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.an.a aVar) {
            super.a(gVar, aVar);
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.versionCode);
            if (f.this.cdL == null) {
                f.this.cdL = new ArrayList();
            }
            gVar.appId = f.this.mAppId;
            if (aVar == null) {
                f.this.cdL.add(gVar);
                f.this.cdJ.g(gVar);
                c.abU().a(gVar, f.this.acb());
            } else {
                f.this.cdJ.f(gVar);
                c.abU().a(gVar, f.this.acb(), aVar);
            }
            if (f.this.cdU != null) {
                f.this.cdU.onNext(gVar);
                if (!f.this.cdJ.aMq()) {
                    f.this.cdU.onCompleted();
                }
            }
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> cej = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.15
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
                return com.baidu.swan.apps.core.pms.f.a.acv();
            }
            if (dVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.acw();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.Zv();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void N(com.baidu.swan.pms.model.d dVar) {
            super.N(dVar);
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "framework onDownloadStart");
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
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.cdJ.f(dVar);
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(13L).bK(aVar.errorNo).qk("Framework包下载失败").qm(aVar.toString());
            if (f.this.cdV != null) {
                f.this.cdV.onError(new PkgDownloadError(dVar, qm));
            }
            c.abU().a(dVar, f.this.acb(), qm);
            com.baidu.swan.d.d.deleteFile(dVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void L(com.baidu.swan.pms.model.d dVar) {
            super.L(dVar);
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.versionCode);
            com.baidu.swan.apps.an.a a = f.this.a(dVar);
            if (a == null) {
                f.this.cdY = dVar;
                f.this.cdJ.g(dVar);
                if (f.this.cdV != null) {
                    f.this.cdV.onNext(dVar);
                    f.this.cdV.onCompleted();
                }
                c.abU().a(dVar, f.this.acb());
                return;
            }
            f.this.cdJ.f(dVar);
            if (f.this.cdV != null) {
                f.this.cdV.onError(new PkgDownloadError(dVar, a));
            }
            c.abU().a(dVar, f.this.acb(), a);
        }
    };
    private com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> cek = new com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.16
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
                return com.baidu.swan.apps.core.pms.f.a.acn();
            }
            if (bVar.category == 1) {
                return com.baidu.swan.apps.core.pms.f.a.acx();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.pms.a.b
        public int getPriority() {
            return f.this.Zv();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: e */
        public void N(com.baidu.swan.pms.model.b bVar) {
            super.N(bVar);
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "extension onDownloadStart");
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
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.cdJ.f(bVar);
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(14L).bK(aVar.errorNo).qk("Extension下载失败").qm(aVar.toString());
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", qm.toString());
            }
            f.this.c(bVar);
            c.abU().a(bVar, f.this.acb(), qm);
            com.baidu.swan.d.d.deleteFile(bVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void L(com.baidu.swan.pms.model.b bVar) {
            super.L(bVar);
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.versionCode);
            com.baidu.swan.apps.an.a a = f.this.a(bVar);
            if (a != null) {
                if (f.DEBUG) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.cdJ.f(bVar);
                f.this.c(bVar);
                c.abU().a(bVar, f.this.acb(), a);
                return;
            }
            f.this.cdZ = bVar;
            f.this.cdJ.g(bVar);
            f.this.c(bVar);
            c.abU().a(bVar, f.this.acb());
        }
    };
    private com.baidu.swan.pms.a.f cel = new com.baidu.swan.pms.a.f() { // from class: com.baidu.swan.apps.core.pms.f.17
        @Override // com.baidu.swan.pms.a.f
        public void e(PMSAppInfo pMSAppInfo) {
            if (f.DEBUG) {
                Log.e("SwanAppPkgDownloadCallback", f.this.getClassName() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f.this.cea = pMSAppInfo;
            if (f.this.cea != null) {
                f.this.c(f.this.cea);
                com.baidu.swan.apps.ad.g.b.P(f.this.cea.pluginInfo, true);
            }
        }
    };
    private rx.j<com.baidu.swan.pms.model.e> cem = new rx.j<com.baidu.swan.pms.model.e>() { // from class: com.baidu.swan.apps.core.pms.f.9
        @Override // rx.e
        public void onCompleted() {
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", f.this.acb() + " : 包下载onCompleted");
            f.this.aca();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            com.baidu.swan.apps.console.c.f("SwanAppPkgDownloadCallback", f.this.acb() + " : 包下载OnError", th);
            f.this.p(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(com.baidu.swan.pms.model.e eVar) {
            com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", f.this.acb() + " : 单个包下载、业务层处理完成：" + eVar.versionCode);
        }
    };
    protected List<UbcFlowEvent> ceb = new ArrayList();

    protected abstract PMSDownloadType acb();

    protected abstract void p(Throwable th);

    public f(String str) {
        this.mAppId = str;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Zu() {
        this.ceb.add(new UbcFlowEvent("na_pms_start_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void abX() {
        this.ceb.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.errorNo == 1010) {
            ach();
        }
        this.ceb.add(new UbcFlowEvent("na_pms_end_req"));
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.f fVar) {
        super.a(fVar);
        this.cee = System.currentTimeMillis();
        if (DEBUG) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.cee);
        }
        if (fVar != null) {
            if (DEBUG) {
                Log.i("SwanAppPkgDownloadCallback", getClassName() + ": onPrepareDownload: countSet=" + fVar.aMl());
            }
            this.ceb.add(new UbcFlowEvent("na_pms_start_download"));
            this.cdJ = fVar;
            if (!this.cdJ.isEmpty()) {
                ack();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.f> acc() {
        return this.cei;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.g> abZ() {
        return this.cdN;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.d> acd() {
        return this.cej;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<com.baidu.swan.pms.model.b> ace() {
        return this.cek;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.f acf() {
        return this.cel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String acg() {
        return com.baidu.swan.pms.a.h.a(this, "get_launch_id").getString("launch_id", "");
    }

    protected int Zv() {
        return 100;
    }

    protected com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.f fVar) {
        if (fVar == null) {
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(11L).bK(2310L).qm("pkg info is empty");
            com.baidu.swan.apps.an.e.avX().g(qm);
            return qm;
        }
        return null;
    }

    protected com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.d dVar) {
        a.C0404a c = com.baidu.swan.apps.swancore.d.a.c(dVar.versionName, dVar.filePath, dVar.sign, dVar.category);
        if (!TextUtils.isEmpty(dVar.filePath)) {
            com.baidu.swan.d.d.deleteFile(dVar.filePath);
        }
        if (c.isOk()) {
            return null;
        }
        return new com.baidu.swan.apps.an.a().bJ(13L).bL(2907L).qk("Core包更新失败");
    }

    protected com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.b bVar) {
        com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
        aVar.versionName = bVar.versionName;
        aVar.ckm = bVar.filePath;
        aVar.sign = bVar.sign;
        if (!(com.baidu.swan.apps.extcore.b.a(bVar.category, aVar) == null)) {
            return new com.baidu.swan.apps.an.a().bJ(14L).bL(2908L).qk("Extension包更新失败");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fm(int i) {
        if (i == 1013) {
            com.baidu.swan.pms.database.a.aKS().Z(this.mAppId, i);
        } else {
            com.baidu.swan.pms.database.a.aKS().Z(this.mAppId, 0);
        }
    }

    private void ach() {
        PMSAppInfo uq = com.baidu.swan.pms.database.a.aKS().uq(this.mAppId);
        com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + uq.createTime + " lastLaunchTime=" + uq.getLastLaunchTime() + " maxAge=" + uq.maxAge);
        if (uq != null) {
            uq.aLg();
            uq.jG(aco());
            if (this.cdX != null) {
                this.cdX.createTime = uq.createTime;
            }
            if (this.cea != null) {
                this.cea.createTime = uq.createTime;
                this.cea.jG(aco());
            }
            com.baidu.swan.pms.database.a.aKS().r(uq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.an.a aci() {
        if (this.cea == null) {
            if (this.cdX == null) {
                return new com.baidu.swan.apps.an.a().bJ(10L).bK(2903L).qk("Server未返回主包&AppInfo");
            }
            PMSAppInfo uq = com.baidu.swan.pms.database.a.aKS().uq(this.mAppId);
            if (uq == null) {
                return new com.baidu.swan.apps.an.a().bJ(10L).bK(2904L).qk("Server未返回AppInfo数据，本地也没有数据");
            }
            this.cea = uq;
            com.baidu.swan.apps.core.pms.f.a.a(this.cea, this.cdX);
            this.cea.aLg();
            this.cea.jG(aco());
            if (com.baidu.swan.pms.database.a.aKS().a(this.cdX, this.cdL, this.cdY, this.cdZ, this.cea)) {
                return null;
            }
            return new com.baidu.swan.apps.an.a().bJ(10L).bK(2906L).qk("更新DB失败");
        }
        if (this.cdX != null) {
            com.baidu.swan.apps.core.pms.f.a.a(this.cea, this.cdX);
        } else if (com.baidu.swan.apps.core.pms.f.b.Y(this.cdL)) {
            this.ced = this.cdL.get(0);
            this.ced.appId = this.mAppId;
            com.baidu.swan.apps.core.pms.f.a.a(this.cea, this.ced);
        } else {
            PMSAppInfo uq2 = com.baidu.swan.pms.database.a.aKS().uq(this.mAppId);
            if (uq2 == null) {
                return new com.baidu.swan.apps.an.a().bJ(10L).bK(2905L).qk("Server未返回包数据，本地也没有数据");
            }
            this.cea.appId = this.mAppId;
            this.cea.u(uq2);
        }
        this.cea.aLg();
        this.cea.jG(aco());
        if (com.baidu.swan.pms.database.a.aKS().a(this.cdX, this.cdL, this.cdY, this.cdZ, this.cea)) {
            com.baidu.swan.apps.core.pms.f.a.g(this.cea);
            return null;
        }
        return new com.baidu.swan.apps.an.a().bJ(10L).bK(2906L).qk("更新DB失败");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acj() {
        if (this.cea != null) {
            PMSAppInfo uq = com.baidu.swan.pms.database.a.aKS().uq(this.mAppId);
            if (uq == null) {
                com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
                return;
            }
            this.cea.appId = this.mAppId;
            uq.jG(aco());
            this.cea.u(uq);
            this.cea.aLg();
            if (com.baidu.swan.pms.database.a.aKS().r(this.cea)) {
                com.baidu.swan.apps.core.pms.f.a.g(this.cea);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aca() {
        long currentTimeMillis = System.currentTimeMillis() - this.cee;
        int aoE = com.baidu.swan.apps.performance.f.a.aoE();
        if (aoE > 0 && currentTimeMillis > aoE) {
            aR(currentTimeMillis);
        }
    }

    private void aR(long j) {
        com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "pms download too slow:" + j);
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw != null && arw.RU() == 0) {
            com.baidu.swan.apps.an.a qk = new com.baidu.swan.apps.an.a().bJ(10L).bK(2912L).qk("pms download too slow");
            com.baidu.swan.apps.statistic.a.d pv = new com.baidu.swan.apps.statistic.a.d().f(qk).a(arw.Se()).pu(com.baidu.swan.apps.statistic.h.ho(arw.RU())).pv(this.mAppId);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("downloadTime", j);
                if (this.cea != null) {
                    jSONObject.put("PMSAppInfo", this.cea.toString());
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            pv.bF(jSONObject);
            com.baidu.swan.apps.statistic.h.b(pv);
            com.baidu.swan.apps.al.a.atW().u(qk.avQ(), pv.toJSONObject());
        }
    }

    public f c(com.baidu.swan.apps.aq.e.b<PMSAppInfo> bVar) {
        return a((Collection<Set<com.baidu.swan.apps.aq.e.b<PMSAppInfo>>>) this.ceg, (Set<com.baidu.swan.apps.aq.e.b<PMSAppInfo>>) bVar);
    }

    protected f c(final PMSAppInfo pMSAppInfo) {
        return a((Collection) this.ceg, (com.baidu.swan.apps.aq.e.b) new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b<PMSAppInfo>>() { // from class: com.baidu.swan.apps.core.pms.f.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: e */
            public void H(com.baidu.swan.apps.aq.e.b<PMSAppInfo> bVar) {
                bVar.H(pMSAppInfo);
            }
        });
    }

    private synchronized <CallbackT> f a(final Collection<CallbackT> collection, final CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.ceh.q(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.19
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
            this.ceh.q(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.20
                @Override // java.lang.Runnable
                public void run() {
                    collection.remove(callbackt);
                }
            });
        }
        return this;
    }

    private synchronized <CallbackT> f a(@NonNull final Collection<CallbackT> collection, @NonNull final com.baidu.swan.apps.aq.e.b<CallbackT> bVar) {
        this.ceh.q(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.21
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
        return a(this.cef, (Set<com.baidu.swan.apps.core.pms.a.a>) aVar);
    }

    protected f d(@NonNull final com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.core.pms.a.a> bVar) {
        return a((Collection) this.cef, (com.baidu.swan.apps.aq.e.b) new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(com.baidu.swan.apps.core.pms.a.a aVar) {
                bVar.H(aVar);
                f.this.b((Collection<Set>) f.this.cef, (Set) aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final com.baidu.swan.apps.an.a aVar, final boolean z) {
        d(new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(com.baidu.swan.apps.core.pms.a.a aVar2) {
                aVar2.b(aVar, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(final PMSAppInfo pMSAppInfo) {
        d(new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.core.pms.a.a>() { // from class: com.baidu.swan.apps.core.pms.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(com.baidu.swan.apps.core.pms.a.a aVar) {
                aVar.f(pMSAppInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.f fVar) {
        c.abU().a(fVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.5
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cdX = fVar;
                f.this.cdJ.g(fVar);
                if (f.this.cdT != null) {
                    f.this.cdT.onNext(fVar);
                    f.this.cdT.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                f.this.cdJ.f(fVar);
                if (f.this.cdT != null) {
                    f.this.cdT.onError(new PkgDownloadError(fVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.g gVar) {
        c.abU().a(gVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.6
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                if (f.this.cdL == null) {
                    f.this.cdL = new ArrayList();
                }
                gVar.appId = f.this.mAppId;
                f.this.cdL.add(gVar);
                f.this.cdJ.g(gVar);
                if (f.this.cdU != null) {
                    f.this.cdU.onNext(gVar);
                    if (!f.this.cdJ.aMq()) {
                        f.this.cdU.onCompleted();
                    }
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                f.this.cdJ.f(gVar);
                if (f.this.cdU != null) {
                    f.this.cdU.onError(new PkgDownloadError(gVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.d dVar) {
        c.abU().a(dVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.7
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cdY = dVar;
                f.this.cdJ.g(dVar);
                if (f.this.cdV != null) {
                    f.this.cdV.onNext(dVar);
                    f.this.cdV.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                f.this.cdJ.f(dVar);
                if (f.this.cdV != null) {
                    f.this.cdV.onError(new PkgDownloadError(dVar, aVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.pms.model.b bVar) {
        c.abU().a(bVar, new c.b() { // from class: com.baidu.swan.apps.core.pms.f.8
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f.this.cdZ = bVar;
                f.this.cdJ.g(bVar);
                f.this.c(bVar);
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.an.a aVar) {
                com.baidu.swan.apps.console.c.aW("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                f.this.cdJ.f(bVar);
                f.this.c(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.pms.model.b bVar) {
        if (this.cdW != null) {
            this.cdW.onNext(bVar);
            this.cdW.onCompleted();
        }
    }

    private void ack() {
        ArrayList arrayList = new ArrayList();
        if (this.cdJ.aMm()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.f>() { // from class: com.baidu.swan.apps.core.pms.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.f> jVar) {
                    f.this.cdT = jVar;
                }
            }));
        }
        if (this.cdJ.aMn()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.g>() { // from class: com.baidu.swan.apps.core.pms.f.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.g> jVar) {
                    f.this.cdU = jVar;
                }
            }));
        }
        if (this.cdJ.aMo()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.d>() { // from class: com.baidu.swan.apps.core.pms.f.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.d> jVar) {
                    f.this.cdV = jVar;
                }
            }));
        }
        if (this.cdJ.aMp()) {
            arrayList.add(rx.d.a((d.a) new d.a<com.baidu.swan.pms.model.b>() { // from class: com.baidu.swan.apps.core.pms.f.14
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super com.baidu.swan.pms.model.b> jVar) {
                    f.this.cdW = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(this.cem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void be(String str, String str2) {
        com.baidu.swan.apps.performance.f.a.a(this.mAppId, str, this.ceb, str2);
        this.ceb.clear();
    }

    protected String getClassName() {
        if (TextUtils.isEmpty(this.mClassName)) {
            this.mClassName = getClass().toString();
        }
        return this.mClassName;
    }
}
