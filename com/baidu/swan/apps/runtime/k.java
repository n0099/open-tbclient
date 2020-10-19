package com.baidu.swan.apps.runtime;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
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
/* loaded from: classes10.dex */
public final class k extends m implements com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private PMSAppInfo cyN;
    private final e czm;
    private boolean deK;
    private boolean deL;
    private boolean deM;
    private boolean deN;
    private int deO;
    private boolean deP;
    String deQ;
    private boolean deR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.deK = false;
        this.deL = false;
        this.deM = false;
        this.deN = false;
        this.deO = -1;
        this.deP = false;
        this.deQ = "";
        this.deR = false;
        this.czm = eVar;
    }

    public com.baidu.swan.apps.u.c.b aDz() {
        return this.czm.aDe();
    }

    public synchronized boolean aDA() {
        return this.deK;
    }

    public boolean aDB() {
        return this.deL;
    }

    public int aDh() {
        return this.deO;
    }

    public synchronized boolean aDC() {
        return this.deM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aDD() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.czm.den && !aDA() && !aDC()) {
                this.deK = true;
                com.baidu.swan.apps.performance.i.qc("startup").f(new UbcFlowEvent("maintain_start").fw(true));
                boolean z = 1 == this.czm.aDe().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.ann().anv()) {
                    rm("event_on_still_maintaining");
                }
                if (z) {
                    aDE();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void aDE() {
        final HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
        qc.f(new UbcFlowEvent("postExec-onhold").fw(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                qc.f(new UbcFlowEvent("postExec-run").fw(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.deO = 99;
            f("KEY_PKG_STATE", "event_pms_check_start", this.deO);
            b.a aDe = this.czm.aDe();
            if (com.baidu.swan.apps.ad.a.a.aAx() || !TextUtils.isEmpty(aDe.auy()) || (DEBUG && aDe.isDebug())) {
                gg(true);
            } else {
                this.deQ = aDe.auC();
                if (DEBUG) {
                    com.baidu.swan.apps.u.e.a.oY(this.deQ).oZ("start");
                }
                com.baidu.swan.apps.inlinewidget.f.b.b.oj("1");
                HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
                qc.r("type", "1");
                qc.cb("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.ajc().ajd()));
                qc.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo auz = this.czm.aDe().auz();
                if (auz == null || auz.aWY()) {
                    auz = com.baidu.swan.pms.database.a.aWO().xF(getAppId());
                }
                qc.f(new UbcFlowEvent("na_query_db"));
                this.deR = com.baidu.swan.apps.u.f.a.m(auz);
                this.deN = (auz == null || this.deR) ? false : false;
                qc.f(new UbcFlowEvent("has_local_file").fw(true));
                if (this.deR) {
                    n(auz);
                    o(this.cyN);
                    qc.f(new UbcFlowEvent("update_icon").fw(true));
                }
                if (!this.deR && com.baidu.swan.apps.u.f.a.a(this.cyN, aDe.getPage())) {
                    aDF();
                } else {
                    aDG();
                }
            }
        }
    }

    private void aDF() {
        HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
        qc.f(new UbcFlowEvent("updateForIndependentPkgStart").fw(true));
        if (DEBUG) {
            log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        }
        com.baidu.swan.apps.u.c.b aDz = aDz();
        String b = com.baidu.swan.apps.u.f.a.b(this.cyN, aDz.getPage());
        aDz.fb(true);
        aDz.oU(b);
        Bundle bundle = new Bundle();
        bundle.putLong("pms_update_expect_pkg_ver", this.cyN.versionCode);
        T(bundle);
        qc.f(new UbcFlowEvent("updateForIndependentPkgEnd").fw(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(final Bundle bundle) {
        HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
        qc.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").fw(true));
        if (DEBUG) {
            log("启动本地包，进程预处理-加载本地包-后台异步更新");
        }
        f((com.baidu.swan.apps.am.a) null);
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.2
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                bundle2.putInt("appFrameType", k.this.aDz().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                if (k.DEBUG) {
                    k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                com.baidu.swan.apps.process.messaging.a.aAK().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).bL(5000L));
            }
        });
        qc.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").fw(true));
    }

    private void aDG() {
        HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
        qc.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").fw(true));
        if (DEBUG) {
            log(this.cyN == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        }
        com.baidu.swan.apps.core.j.c mU = com.baidu.swan.apps.core.j.f.amL().mU(getAppId());
        long j = this.cyN == null ? -1L : this.cyN.versionCode;
        long j2 = mU != null ? mU.versionCode : -1L;
        boolean z = j2 > j;
        if (DEBUG) {
            log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (!z) {
            aDH();
            return;
        }
        rm("event_on_still_maintaining");
        qc.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").fw(true));
        com.baidu.swan.apps.core.j.f.amL().a(mU, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void i(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow qc2 = com.baidu.swan.apps.performance.i.qc("startup");
                qc2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").fw(true));
                k.this.o(pMSAppInfo);
                qc2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").fw(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void j(PMSAppInfo pMSAppInfo) {
                k.this.deO = 5;
                k.this.f("KEY_PKG_STATE", "event_pms_check_finish", k.this.deO);
                HybridUbcFlow qc2 = com.baidu.swan.apps.performance.i.qc("startup");
                qc2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").fw(true));
                if (k.DEBUG) {
                    k.log("预制包安装成功");
                }
                k.a(k.this.aDz(), pMSAppInfo, false, false, true);
                k.this.n(pMSAppInfo);
                k.this.T(null);
                qc2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").fw(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i) {
                HybridUbcFlow qc2 = com.baidu.swan.apps.performance.i.qc("startup");
                qc2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").fw(true));
                if (k.DEBUG) {
                    k.log("预制包安装失败");
                }
                k.this.aDH();
                qc2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").fw(true));
            }
        });
        qc.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").fw(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDH() {
        d.aCW().rm("event_pms_check_start");
        final HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
        qc.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").fw(true));
        final com.baidu.swan.apps.u.c.b aDz = aDz();
        if (DEBUG) {
            log("预置包不可用");
        }
        boolean aDI = aDI();
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + aDI);
        }
        if (!aDI) {
            if (DEBUG) {
                log("可以直接打开小程序，异步从Server拉取新包");
            }
            this.deO = 4;
            a(aDz, this.cyN, false, false, false);
            this.deO = this.deP ? 3 : 4;
            T(null);
            f("KEY_PKG_STATE", "event_pms_check_finish", this.deO);
            return;
        }
        if (DEBUG) {
            log("不能直接打开小程序，同步从Server拉取新包");
        }
        f("KEY_PKG_STATE", "event_pms_check_finish", this.deO);
        a(this.czm.aDe().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(aDz, k.this.cyN, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aDz.getAppFrameType());
        cVar.xT("3");
        cVar.cu(this.cyN == null ? 0L : this.cyN.versionCode);
        cVar.cv(this.cyN != null ? this.cyN.appSign : 0L);
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(aDz.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.xP(delAllParamsFromUrl);
        }
        qc.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").fw(true));
        i((i.a) new i.a("event_on_still_maintaining").X(" event_params_pkg_update", this.deR));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.czm) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.utils.f fVar) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading set onPrepareDownload");
                }
                k.this.deL = true;
                d.aCW().rm("event_pkg_download_start");
                super.a(fVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void alM() {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                }
                k.this.deL = false;
                d.aCW().rm("event_pkg_download_finish");
                super.alM();
            }
        }.c(new com.baidu.swan.apps.ap.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: q */
            public void M(PMSAppInfo pMSAppInfo) {
                qc.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").fw(true));
                if (k.DEBUG) {
                    k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                k.this.n(pMSAppInfo);
                k.this.o(pMSAppInfo);
                qc.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").fw(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.am.a aVar, boolean z) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalFailed");
                }
                k.this.deL = false;
                d.aCW().rm("event_pkg_download_finish");
                qc.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").fw(true));
                if (k.DEBUG) {
                    k.log("onFinalFailed");
                }
                com.baidu.swan.apps.am.e.aHz().j(aVar);
                if (z) {
                    k.this.deO = k.this.deP ? 3 : 4;
                    k.this.f("KEY_PKG_STATE", "event_pms_check_finish", k.this.deO);
                    k.this.e(aVar);
                } else {
                    if (aVar != null && aVar.aHr() == 1020) {
                        k.this.h(aVar);
                    }
                    k.this.gg(false);
                }
                qc.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").fw(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void f(PMSAppInfo pMSAppInfo) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalComplete");
                }
                k.this.deL = false;
                k.this.deO = k.this.deN ? 2 : 0;
                k.this.deO = k.this.deP ? 1 : k.this.deO;
                k.this.f("KEY_PKG_STATE", "event_pms_check_finish", k.this.deO);
                qc.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").fw(true));
                if (k.DEBUG) {
                    k.log("onFinalComplete");
                }
                k.this.n(pMSAppInfo);
                k.this.f((com.baidu.swan.apps.am.a) null);
                qc.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").fw(true));
            }
        }).hP(this.deP ? 2 : 1));
        qc.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").fw(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        d.aCW().f(str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(PMSAppInfo pMSAppInfo) {
        this.cyN = pMSAppInfo;
        this.czm.aDe().l(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").bO("mAppId", getAppId())).P("appFrameType", pMSAppInfo.appCategory);
            if (DEBUG) {
                log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                if (DEBUG) {
                    log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                }
                aVar.bO("app_name", pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                if (DEBUG) {
                    log("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                }
                aVar.n(Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                if (DEBUG) {
                    log("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                }
                aVar.bO("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.X("event_flag_force_post", true);
            i(aVar);
        }
    }

    private boolean aDI() {
        HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
        if (this.cyN == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            qc.cb("launch_state", String.valueOf(0));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
            return true;
        } else if (this.cyN.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.deN = true;
            qc.cb("launch_state", String.valueOf(2));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cyN.aWX()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.deN = true;
            qc.cb("launch_state", String.valueOf(2));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cyN.aWY()) {
            if (com.baidu.swan.apps.core.a.b.a.ajc().mf(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                qc.cb("launch_state", String.valueOf(3));
                f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
            qc.cb("launch_state", String.valueOf(1));
            this.deP = true;
            return true;
        } else {
            qc.cb("launch_state", String.valueOf(4));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.u.c.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.aup().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.aup().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.aup().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.kd(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.dlS = z ? "1" : "0";
        fVar.dlU = z3 ? "1" : "0";
        fVar.dlT = z2 ? "1" : "0";
        long j = eVar.getLong("launch_interval", -1L);
        if (j >= 0 && j <= 5000) {
            fVar.u("launchInterval", Long.valueOf(j));
        }
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        final String aul = eVar.aul();
        final String string = eVar.aup().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.8
            @Override // java.lang.Runnable
            public void run() {
                k.a(com.baidu.swan.apps.statistic.a.f.this, aul, string);
            }
        }, "launchStatistic", 2);
    }

    public static void a(com.baidu.swan.apps.statistic.a.f fVar, String str, String str2) {
        JSONObject sw = com.baidu.swan.apps.statistic.h.sw(str);
        fVar.sF(str2);
        fVar.bY(sw);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private void a(boolean z, String str, com.baidu.swan.apps.am.a aVar) {
        if (this.cyN != null) {
            Context context = getContext();
            e aDb = e.aDb();
            if (aDb != null) {
                String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.avu().auW(), aDb.abu().getAppFrameType()), String.valueOf(aVar.aHv()));
                if (!com.baidu.swan.apps.t.a.asO().a(context, aDb.getAppKey(), aVar)) {
                    Intent intent = new Intent();
                    intent.putExtra("pms_db_info_onload", this.cyN);
                    intent.putExtra("swan_error_type", z ? "type_path_forbidden" : "type_app_forbidden");
                    ForbiddenInfo forbiddenInfo = new ForbiddenInfo(aDz(), str, format);
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
            com.baidu.swan.apps.u.c.b aDz = aDz();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.kd(aDz.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aDz);
            fVar.u("status", "2");
            fVar.sF(aDz.aup().getString("ubc"));
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
        int appFrameType = aDz().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 10002;
        }
        return 0;
    }

    private com.baidu.swan.apps.am.a jU(int i) {
        com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
        switch (i) {
            case 10001:
                aVar.bX(10L).bY(2902L).tt("no aiapps info in database");
                break;
            case 10002:
                aVar.bX(10L).bY(27L).tt("category not match");
                break;
            case 10003:
                aVar.bX(10L).bY(2107L).tr("app forbiddeon");
                break;
            case 10004:
                aVar.bX(10L).bY(48L).tr("path forbiddeon");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.swan.apps.am.a aVar) {
        if (f(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aDz()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(com.baidu.swan.apps.am.a aVar) {
        HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
        qc.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").fw(true));
        if (!g(aVar)) {
            if (DEBUG) {
                log("updateInstalledPkgWithFinalCheck by null launchParams");
            }
            gg(false);
            return false;
        }
        qc.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").fw(true));
        b.a aDe = this.czm.aDe();
        long ti = com.baidu.swan.apps.swancore.b.ti(aDe.auu());
        long j = aDe.anI() != null ? aDe.anI().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + aDe.auu() + " targetSwanVersion: " + ti + " ,curSwanVersion: " + j);
        }
        if (ti > j) {
            com.baidu.swan.apps.swancore.b.kj(aDe.getAppFrameType());
        }
        com.baidu.swan.apps.performance.i.qc("startup").cb("launch_type", String.valueOf(com.baidu.swan.apps.ao.a.aHE()));
        if (aDe.getAppFrameType() == 0) {
            aDJ();
        }
        qc.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").fw(true));
        gg(true);
        com.baidu.swan.apps.env.c aoN = com.baidu.swan.apps.env.e.aoM().aoN();
        if (aoN != null && aoN.aoG()) {
            aoN.nm(getAppId());
        }
        return true;
    }

    private void aDJ() {
        com.baidu.swan.apps.r.d.e(this.czm);
    }

    private boolean g(com.baidu.swan.apps.am.a aVar) {
        com.baidu.swan.apps.performance.i.qc("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").fw(true));
        if (DEBUG) {
            log("updateInfoWithFinalCheck: mAppInfo=" + this.cyN);
        }
        if (this.cyN == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.am.a().bX(10L).bY(2902L).tt("no pkg was installed");
            }
            com.baidu.swan.apps.am.e.aHz().j(aVar);
            h(aVar);
            return false;
        }
        int p = p(this.cyN);
        if (p == 10001 || p == 10002) {
            if (aVar == null) {
                aVar = jU(p);
            }
            com.baidu.swan.apps.am.e.aHz().j(aVar);
            h(aVar);
            return false;
        }
        aDK();
        if (p != 0) {
            com.baidu.swan.apps.am.a jU = jU(10003);
            com.baidu.swan.apps.am.e.aHz().j(jU);
            a(false, (String) null, jU);
            com.baidu.swan.apps.performance.i.d(jU);
            com.baidu.swan.apps.t.a.ath().flush(false);
            return false;
        }
        if (com.baidu.swan.apps.scheme.actions.forbidden.a.aEk().rT(aCS().aDe().getPage())) {
            com.baidu.swan.apps.am.a jU2 = jU(10004);
            com.baidu.swan.apps.am.e.aHz().j(jU2);
            a(true, com.baidu.swan.apps.scheme.actions.forbidden.a.aEk().aEl(), jU2);
            com.baidu.swan.apps.performance.i.d(jU2);
            com.baidu.swan.apps.t.a.ath().flush(false);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.baidu.swan.apps.am.a aVar) {
        com.baidu.swan.apps.performance.i.d(aVar);
        Context context = getContext();
        if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
            if (DEBUG) {
                Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                return;
            }
            return;
        }
        com.baidu.swan.apps.u.c.b aDz = aDz();
        int appFrameType = aDz.getAppFrameType();
        com.baidu.swan.apps.u.b.a.a((Context) com.baidu.swan.apps.t.a.asf(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.kd(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = "fail";
        fVar.u("errcode", String.valueOf(aVar.aHv()));
        fVar.u("msg", aVar.aHu().toString());
        fVar.d(aDz);
        fVar.sF(aDz.aup().getString("ubc"));
        fVar.bY(com.baidu.swan.apps.statistic.h.sw(aDz.aul()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.aHw()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().sB(com.baidu.swan.apps.statistic.h.kd(appFrameType)).i(aVar).sC(getAppId()).sD(aDz.auj()));
            aVar.aHx();
        }
        com.baidu.swan.apps.t.a.ath().flush(false);
    }

    private void aDK() {
        final b.a aDe = aCS().aDe();
        boolean z = (this.cyN == null || TextUtils.isEmpty(this.cyN.appId) || !TextUtils.equals(getAppId(), this.cyN.appId)) ? false : true;
        if (z) {
            aDe.k(this.cyN);
        }
        final int i = (z && this.cyN.appCategory == 1) ? 1 : 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aDe.iJ(i);
        } else {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.9
                @Override // java.lang.Runnable
                public void run() {
                    aDe.iJ(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void gg(boolean z) {
        this.deK = false;
        this.deM = z;
        this.cyN = null;
        if (DEBUG) {
            log("notifyMaintainFinish: " + z);
        }
        i((i.a) new i.a("event_on_pkg_maintain_finish").bO("mAppId", this.czm.id));
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.oY(this.deQ).auL();
        }
        this.deQ = "";
    }

    private Context getContext() {
        SwanAppActivity aCU = this.czm.aCU();
        return (aCU == null || aCU.isDestroyed()) ? com.baidu.swan.apps.t.a.asf() : aCU;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a aAU = com.baidu.swan.apps.process.messaging.client.a.aAU();
        if (aAU == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.aAC());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.n(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        aAU.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes10.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void y(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.cWN.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean xC = com.baidu.swan.pms.c.xC(string);
            boolean xD = com.baidu.swan.pms.c.xD(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + xC + ", isInQueue: " + xD);
            }
            this.cWN.putBoolean("isDownloading", (xC || xD) ? true : true);
            finish();
        }
    }
}
