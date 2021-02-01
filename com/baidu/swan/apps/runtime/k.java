package com.baidu.swan.apps.runtime;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class k extends m implements com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private PMSAppInfo cUJ;
    private final e cVi;
    private int dEA;
    private boolean dEB;
    String dEC;
    private boolean dED;
    private boolean dEw;
    private boolean dEx;
    private boolean dEy;
    private boolean dEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.dEw = false;
        this.dEx = false;
        this.dEy = false;
        this.dEz = false;
        this.dEA = -1;
        this.dEB = false;
        this.dEC = "";
        this.dED = false;
        this.cVi = eVar;
    }

    public com.baidu.swan.apps.u.c.b aJj() {
        return this.cVi.aIO();
    }

    public synchronized boolean aJk() {
        return this.dEw;
    }

    public boolean aJl() {
        return this.dEx;
    }

    public int aIR() {
        return this.dEA;
    }

    public synchronized boolean aJm() {
        return this.dEy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aJn() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.cVi.dEa && !aJk() && !aJm()) {
                this.dEw = true;
                com.baidu.swan.apps.performance.i.qk("startup").f(new UbcFlowEvent("maintain_start").gr(true));
                boolean z = 1 == this.cVi.aIO().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.ase().asn()) {
                    rz("event_on_still_maintaining");
                }
                if (z) {
                    aJo();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void aJo() {
        final HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
        qk.f(new UbcFlowEvent("postExec-onhold").gr(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                qk.f(new UbcFlowEvent("postExec-run").gr(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.dEA = 99;
            j("KEY_PKG_STATE", "event_pms_check_start", this.dEA);
            b.a aIO = this.cVi.aIO();
            if (com.baidu.swan.apps.ad.a.a.aFm() || !TextUtils.isEmpty(aIO.azp()) || (DEBUG && aIO.isDebug())) {
                hk(true);
            } else {
                this.dEC = aIO.azt();
                if (DEBUG) {
                    com.baidu.swan.apps.u.e.a.pg(this.dEC).ph("start");
                }
                com.baidu.swan.apps.inlinewidget.f.b.b.os("1");
                HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
                qk.o("type", "1");
                qk.cg("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.anM().anN()));
                qk.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo azq = this.cVi.aIO().azq();
                if (azq == null || azq.bcF()) {
                    azq = com.baidu.swan.pms.database.a.bcv().xV(getAppId());
                }
                qk.f(new UbcFlowEvent("na_query_db"));
                this.dED = com.baidu.swan.apps.u.f.a.m(azq);
                this.dEz = (azq == null || this.dED) ? false : false;
                qk.f(new UbcFlowEvent("has_local_file").gr(true));
                if (this.dED) {
                    n(azq);
                    o(this.cUJ);
                    qk.f(new UbcFlowEvent("update_icon").gr(true));
                }
                if (!this.dED && com.baidu.swan.apps.u.f.a.a(this.cUJ, aIO.getPage())) {
                    aJp();
                } else {
                    aJq();
                }
            }
        }
    }

    private void aJp() {
        HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
        qk.f(new UbcFlowEvent("updateForIndependentPkgStart").gr(true));
        if (DEBUG) {
            log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        }
        com.baidu.swan.apps.u.c.b aJj = aJj();
        String b2 = com.baidu.swan.apps.u.f.a.b(this.cUJ, aJj.getPage());
        aJj.fW(true);
        aJj.pc(b2);
        Bundle bundle = new Bundle();
        bundle.putLong("pms_update_expect_pkg_ver", this.cUJ.versionCode);
        T(bundle);
        qk.f(new UbcFlowEvent("updateForIndependentPkgEnd").gr(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(final Bundle bundle) {
        HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
        qk.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").gr(true));
        if (DEBUG) {
            log("启动本地包，进程预处理-加载本地包-后台异步更新");
        }
        f((com.baidu.swan.apps.al.a) null);
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.2
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                bundle2.putInt("appFrameType", k.this.aJj().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                if (k.DEBUG) {
                    k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                com.baidu.swan.apps.process.messaging.a.aFz().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).cP(5000L));
            }
        });
        qk.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").gr(true));
    }

    private void aJq() {
        HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
        qk.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").gr(true));
        if (DEBUG) {
            log(this.cUJ == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        }
        com.baidu.swan.apps.core.j.c nd = com.baidu.swan.apps.core.j.f.arB().nd(getAppId());
        long j = this.cUJ == null ? -1L : this.cUJ.versionCode;
        long j2 = nd != null ? nd.versionCode : -1L;
        boolean z = j2 > j;
        if (DEBUG) {
            log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (!z) {
            aJr();
            return;
        }
        rz("event_on_still_maintaining");
        qk.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").gr(true));
        com.baidu.swan.apps.core.j.f.arB().a(nd, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void i(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow qk2 = com.baidu.swan.apps.performance.i.qk("startup");
                qk2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").gr(true));
                k.this.o(pMSAppInfo);
                qk2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").gr(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void j(PMSAppInfo pMSAppInfo) {
                k.this.dEA = 5;
                k.this.j("KEY_PKG_STATE", "event_pms_check_finish", k.this.dEA);
                HybridUbcFlow qk2 = com.baidu.swan.apps.performance.i.qk("startup");
                qk2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").gr(true));
                if (k.DEBUG) {
                    k.log("预制包安装成功");
                }
                k.a(k.this.aJj(), pMSAppInfo, false, false, true);
                k.this.n(pMSAppInfo);
                k.this.T(null);
                qk2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").gr(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i) {
                HybridUbcFlow qk2 = com.baidu.swan.apps.performance.i.qk("startup");
                qk2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").gr(true));
                if (k.DEBUG) {
                    k.log("预制包安装失败");
                }
                k.this.aJr();
                qk2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").gr(true));
            }
        });
        qk.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").gr(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJr() {
        d.aIG().rz("event_pms_check_start");
        final HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
        qk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").gr(true));
        final com.baidu.swan.apps.u.c.b aJj = aJj();
        if (DEBUG) {
            log("预置包不可用");
        }
        boolean aJs = aJs();
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + aJs);
        }
        if (!aJs) {
            if (DEBUG) {
                log("可以直接打开小程序，异步从Server拉取新包");
            }
            this.dEA = 4;
            a(aJj, this.cUJ, false, false, false);
            this.dEA = this.dEB ? 3 : 4;
            T(null);
            j("KEY_PKG_STATE", "event_pms_check_finish", this.dEA);
            return;
        }
        if (DEBUG) {
            log("不能直接打开小程序，同步从Server拉取新包");
        }
        j("KEY_PKG_STATE", "event_pms_check_finish", this.dEA);
        a(this.cVi.aIO().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(aJj, k.this.cUJ, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aJj.getAppFrameType());
        cVar.yj("3");
        cVar.dy(this.cUJ == null ? 0L : this.cUJ.versionCode);
        cVar.dz(this.cUJ != null ? this.cUJ.appSign : 0L);
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(aJj.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.yf(delAllParamsFromUrl);
        }
        qk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").gr(true));
        i((i.a) new i.a("event_on_still_maintaining").Z(" event_params_pkg_update", this.dED));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.cVi) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.utils.f fVar) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading set onPrepareDownload");
                }
                k.this.dEx = true;
                d.aIG().rz("event_pkg_download_start");
                super.a(fVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void aqC() {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                }
                k.this.dEx = false;
                d.aIG().rz("event_pkg_download_finish");
                super.aqC();
            }
        }.c(new com.baidu.swan.apps.ao.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: q */
            public void L(PMSAppInfo pMSAppInfo) {
                qk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").gr(true));
                if (k.DEBUG) {
                    k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                k.this.n(pMSAppInfo);
                k.this.o(pMSAppInfo);
                qk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").gr(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.al.a aVar, boolean z) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalFailed");
                }
                k.this.dEx = false;
                d.aIG().rz("event_pkg_download_finish");
                qk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").gr(true));
                if (k.DEBUG) {
                    k.log("onFinalFailed");
                }
                com.baidu.swan.apps.al.e.aNj().j(aVar);
                if (z) {
                    k.this.dEA = k.this.dEB ? 3 : 4;
                    k.this.j("KEY_PKG_STATE", "event_pms_check_finish", k.this.dEA);
                    k.this.e(aVar);
                } else {
                    if (aVar != null && aVar.aNb() == 1020) {
                        k.this.h(aVar);
                    }
                    k.this.hk(false);
                }
                qk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").gr(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void f(PMSAppInfo pMSAppInfo) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalComplete");
                }
                k.this.dEx = false;
                k.this.dEA = k.this.dEz ? 2 : 0;
                k.this.dEA = k.this.dEB ? 1 : k.this.dEA;
                k.this.j("KEY_PKG_STATE", "event_pms_check_finish", k.this.dEA);
                qk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").gr(true));
                if (k.DEBUG) {
                    k.log("onFinalComplete");
                }
                k.this.n(pMSAppInfo);
                k.this.f((com.baidu.swan.apps.al.a) null);
                qk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").gr(true));
            }
        }).gW(this.dEB ? 2 : 1));
        qk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").gr(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        d.aIG().g(str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(PMSAppInfo pMSAppInfo) {
        this.cUJ = pMSAppInfo;
        this.cVi.aIO().l(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").bT("mAppId", getAppId())).W("appFrameType", pMSAppInfo.appCategory);
            if (DEBUG) {
                log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                if (DEBUG) {
                    log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                }
                aVar.bT("app_name", pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                if (DEBUG) {
                    log("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                }
                aVar.o(Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                if (DEBUG) {
                    log("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                }
                aVar.bT("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.Z("event_flag_force_post", true);
            i(aVar);
        }
    }

    private boolean aJs() {
        HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
        if (this.cUJ == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            qk.cg("launch_state", String.valueOf(0));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
            return true;
        } else if (this.cUJ.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.dEz = true;
            qk.cg("launch_state", String.valueOf(2));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cUJ.bcE()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.dEz = true;
            qk.cg("launch_state", String.valueOf(2));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cUJ.bcF()) {
            if (com.baidu.swan.apps.core.a.b.a.anM().mo(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                qk.cg("launch_state", String.valueOf(3));
                j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
            qk.cg("launch_state", String.valueOf(1));
            this.dEB = true;
            return true;
        } else {
            qk.cg("launch_state", String.valueOf(4));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.u.c.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.azg().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.azg().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.azg().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.ju(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.dLA = z ? "1" : "0";
        fVar.dLC = z3 ? "1" : "0";
        fVar.dLB = z2 ? "1" : "0";
        long j = eVar.getLong("launch_interval", -1L);
        if (j >= 0 && j <= 5000) {
            fVar.r("launchInterval", Long.valueOf(j));
        }
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        final String azc = eVar.azc();
        final String string = eVar.azg().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.8
            @Override // java.lang.Runnable
            public void run() {
                k.a(com.baidu.swan.apps.statistic.a.f.this, azc, string);
            }
        }, "launchStatistic", 2);
    }

    public static void a(com.baidu.swan.apps.statistic.a.f fVar, String str, String str2) {
        JSONObject sK = com.baidu.swan.apps.statistic.h.sK(str);
        fVar.sT(str2);
        fVar.ci(sK);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private void a(boolean z, String str, com.baidu.swan.apps.al.a aVar) {
        if (this.cUJ != null) {
            Context context = getContext();
            e aIL = e.aIL();
            if (aIL != null) {
                String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.aAl().azN(), aIL.afZ().getAppFrameType()), String.valueOf(aVar.aNf()));
                if (!com.baidu.swan.apps.t.a.axE().a(context, aIL.getAppKey(), aVar)) {
                    Intent intent = new Intent();
                    intent.putExtra("pms_db_info_onload", this.cUJ);
                    intent.putExtra("swan_error_type", z ? "type_path_forbidden" : "type_app_forbidden");
                    ForbiddenInfo forbiddenInfo = new ForbiddenInfo(aJj(), str, format);
                    forbiddenInfo.enableSlidingFlag = -1;
                    intent.putExtra("swan_error_forbidden_info", forbiddenInfo);
                    intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    context.startActivity(intent);
                }
            }
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            com.baidu.swan.apps.u.c.b aJj = aJj();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.ju(aJj.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aJj);
            fVar.r("status", "2");
            fVar.sT(aJj.azg().getString("ubc"));
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
        }
    }

    private int p(@NonNull PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo.appStatus != 0) {
            return pMSAppInfo.appStatus;
        }
        if (TextUtils.isEmpty(pMSAppInfo.appId)) {
            return 10001;
        }
        int appFrameType = aJj().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 10002;
        }
        return 0;
    }

    private com.baidu.swan.apps.al.a jm(int i) {
        com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a();
        switch (i) {
            case 10001:
                aVar.db(10L).dc(2902L).tH("no aiapps info in database");
                break;
            case 10002:
                aVar.db(10L).dc(27L).tH("category not match");
                break;
            case 10003:
                aVar.db(10L).dc(2107L).tF("app forbiddeon");
                break;
            case 10004:
                aVar.db(10L).dc(48L).tF("path forbiddeon");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.swan.apps.al.a aVar) {
        if (f(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aJj()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(com.baidu.swan.apps.al.a aVar) {
        HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
        qk.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").gr(true));
        if (!g(aVar)) {
            if (DEBUG) {
                log("updateInstalledPkgWithFinalCheck by null launchParams");
            }
            hk(false);
            return false;
        }
        qk.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").gr(true));
        b.a aIO = this.cVi.aIO();
        long tw = com.baidu.swan.apps.swancore.b.tw(aIO.azl());
        long j = aIO.asA() != null ? aIO.asA().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + aIO.azl() + " targetSwanVersion: " + tw + " ,curSwanVersion: " + j);
        }
        if (tw > j) {
            com.baidu.swan.apps.swancore.b.jA(aIO.getAppFrameType());
        }
        com.baidu.swan.apps.performance.i.qk("startup").cg("launch_type", String.valueOf(com.baidu.swan.apps.an.a.aNo()));
        if (aIO.getAppFrameType() == 0) {
            aJt();
        }
        qk.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").gr(true));
        hk(true);
        com.baidu.swan.apps.env.c atG = com.baidu.swan.apps.env.e.atF().atG();
        if (atG != null && atG.atz()) {
            atG.nu(getAppId());
        }
        return true;
    }

    private void aJt() {
        com.baidu.swan.apps.r.d.e(this.cVi);
    }

    private boolean g(com.baidu.swan.apps.al.a aVar) {
        com.baidu.swan.apps.performance.i.qk("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").gr(true));
        if (DEBUG) {
            log("updateInfoWithFinalCheck: mAppInfo=" + this.cUJ);
        }
        if (this.cUJ == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.al.a().db(10L).dc(2902L).tH("no pkg was installed");
            }
            com.baidu.swan.apps.al.e.aNj().j(aVar);
            h(aVar);
            return false;
        }
        int p = p(this.cUJ);
        if (p == 10001 || p == 10002) {
            if (aVar == null) {
                aVar = jm(p);
            }
            com.baidu.swan.apps.al.e.aNj().j(aVar);
            h(aVar);
            return false;
        }
        aJu();
        if (p != 0) {
            com.baidu.swan.apps.al.a jm = jm(10003);
            com.baidu.swan.apps.al.e.aNj().j(jm);
            a(false, (String) null, jm);
            com.baidu.swan.apps.performance.i.d(jm);
            com.baidu.swan.apps.t.a.axX().flush(false);
            return false;
        }
        if (com.baidu.swan.apps.scheme.actions.forbidden.a.aJU().sh(aIC().aIO().getPage())) {
            com.baidu.swan.apps.al.a jm2 = jm(10004);
            com.baidu.swan.apps.al.e.aNj().j(jm2);
            a(true, com.baidu.swan.apps.scheme.actions.forbidden.a.aJU().aJV(), jm2);
            com.baidu.swan.apps.performance.i.d(jm2);
            com.baidu.swan.apps.t.a.axX().flush(false);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.baidu.swan.apps.al.a aVar) {
        com.baidu.swan.apps.performance.i.d(aVar);
        Context context = getContext();
        if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
            if (DEBUG) {
                Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                return;
            }
            return;
        }
        com.baidu.swan.apps.u.c.b aJj = aJj();
        int appFrameType = aJj.getAppFrameType();
        com.baidu.swan.apps.u.b.a.a((Context) com.baidu.swan.apps.t.a.awW(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.ju(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = com.baidu.pass.biometrics.face.liveness.c.a.p;
        fVar.r("errcode", String.valueOf(aVar.aNf()));
        fVar.r("msg", aVar.aNe().toString());
        fVar.d(aJj);
        fVar.sT(aJj.azg().getString("ubc"));
        fVar.ci(com.baidu.swan.apps.statistic.h.sK(aJj.azc()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.aNg()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().sP(com.baidu.swan.apps.statistic.h.ju(appFrameType)).i(aVar).sQ(getAppId()).sR(aJj.aza()));
            aVar.aNh();
        }
        com.baidu.swan.apps.t.a.axX().flush(false);
    }

    private void aJu() {
        final b.a aIO = aIC().aIO();
        boolean z = (this.cUJ == null || TextUtils.isEmpty(this.cUJ.appId) || !TextUtils.equals(getAppId(), this.cUJ.appId)) ? false : true;
        if (z) {
            aIO.k(this.cUJ);
        }
        final int i = (z && this.cUJ.appCategory == 1) ? 1 : 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aIO.hQ(i);
        } else {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.9
                @Override // java.lang.Runnable
                public void run() {
                    aIO.hQ(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void hk(boolean z) {
        this.dEw = false;
        this.dEy = z;
        this.cUJ = null;
        if (DEBUG) {
            log("notifyMaintainFinish: " + z);
        }
        i((i.a) new i.a("event_on_pkg_maintain_finish").bT("mAppId", this.cVi.id));
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.pg(this.dEC).azC();
        }
        this.dEC = "";
    }

    private Context getContext() {
        SwanAppActivity aIE = this.cVi.aIE();
        return (aIE == null || aIE.isDestroyed()) ? com.baidu.swan.apps.t.a.awW() : aIE;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a aFJ = com.baidu.swan.apps.process.messaging.client.a.aFJ();
        if (aFJ == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.aFr());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.k(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        aFJ.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes9.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void y(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.dsX.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean xS = com.baidu.swan.pms.c.xS(string);
            boolean xT = com.baidu.swan.pms.c.xT(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + xS + ", isInQueue: " + xT);
            }
            this.dsX.putBoolean("isDownloading", (xS || xT) ? true : true);
            finish();
        }
    }
}
