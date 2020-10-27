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
    private final e cHI;
    private PMSAppInfo cHj;
    private boolean dnj;
    private boolean dnk;
    private boolean dnl;
    private boolean dnm;
    private int dnn;
    private boolean dno;
    String dnp;
    private boolean dnq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.dnj = false;
        this.dnk = false;
        this.dnl = false;
        this.dnm = false;
        this.dnn = -1;
        this.dno = false;
        this.dnp = "";
        this.dnq = false;
        this.cHI = eVar;
    }

    public com.baidu.swan.apps.u.c.b aFt() {
        return this.cHI.aEY();
    }

    public synchronized boolean aFu() {
        return this.dnj;
    }

    public boolean aFv() {
        return this.dnk;
    }

    public int aFb() {
        return this.dnn;
    }

    public synchronized boolean aFw() {
        return this.dnl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aFx() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.cHI.dmN && !aFu() && !aFw()) {
                this.dnj = true;
                com.baidu.swan.apps.performance.i.qv("startup").f(new UbcFlowEvent("maintain_start").fJ(true));
                boolean z = 1 == this.cHI.aEY().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.aph().apq()) {
                    rF("event_on_still_maintaining");
                }
                if (z) {
                    aFy();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void aFy() {
        final HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
        qv.f(new UbcFlowEvent("postExec-onhold").fJ(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                qv.f(new UbcFlowEvent("postExec-run").fJ(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.dnn = 99;
            f("KEY_PKG_STATE", "event_pms_check_start", this.dnn);
            b.a aEY = this.cHI.aEY();
            if (com.baidu.swan.apps.ad.a.a.aCr() || !TextUtils.isEmpty(aEY.aws()) || (DEBUG && aEY.isDebug())) {
                gt(true);
            } else {
                this.dnp = aEY.aww();
                if (DEBUG) {
                    com.baidu.swan.apps.u.e.a.pr(this.dnp).ps("start");
                }
                com.baidu.swan.apps.inlinewidget.f.b.b.oD("1");
                HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
                qv.r("type", "1");
                qv.ci("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.akW().akX()));
                qv.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo awt = this.cHI.aEY().awt();
                if (awt == null || awt.aYR()) {
                    awt = com.baidu.swan.pms.database.a.aYH().xY(getAppId());
                }
                qv.f(new UbcFlowEvent("na_query_db"));
                this.dnq = com.baidu.swan.apps.u.f.a.m(awt);
                this.dnm = (awt == null || this.dnq) ? false : false;
                qv.f(new UbcFlowEvent("has_local_file").fJ(true));
                if (this.dnq) {
                    n(awt);
                    o(this.cHj);
                    qv.f(new UbcFlowEvent("update_icon").fJ(true));
                }
                if (!this.dnq && com.baidu.swan.apps.u.f.a.a(this.cHj, aEY.getPage())) {
                    aFz();
                } else {
                    aFA();
                }
            }
        }
    }

    private void aFz() {
        HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
        qv.f(new UbcFlowEvent("updateForIndependentPkgStart").fJ(true));
        if (DEBUG) {
            log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        }
        com.baidu.swan.apps.u.c.b aFt = aFt();
        String b = com.baidu.swan.apps.u.f.a.b(this.cHj, aFt.getPage());
        aFt.fo(true);
        aFt.pn(b);
        Bundle bundle = new Bundle();
        bundle.putLong("pms_update_expect_pkg_ver", this.cHj.versionCode);
        T(bundle);
        qv.f(new UbcFlowEvent("updateForIndependentPkgEnd").fJ(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(final Bundle bundle) {
        HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
        qv.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").fJ(true));
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
                bundle2.putInt("appFrameType", k.this.aFt().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                if (k.DEBUG) {
                    k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).bN(5000L));
            }
        });
        qv.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").fJ(true));
    }

    private void aFA() {
        HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
        qv.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").fJ(true));
        if (DEBUG) {
            log(this.cHj == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        }
        com.baidu.swan.apps.core.j.c nn = com.baidu.swan.apps.core.j.f.aoF().nn(getAppId());
        long j = this.cHj == null ? -1L : this.cHj.versionCode;
        long j2 = nn != null ? nn.versionCode : -1L;
        boolean z = j2 > j;
        if (DEBUG) {
            log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (!z) {
            aFB();
            return;
        }
        rF("event_on_still_maintaining");
        qv.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").fJ(true));
        com.baidu.swan.apps.core.j.f.aoF().a(nn, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void i(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow qv2 = com.baidu.swan.apps.performance.i.qv("startup");
                qv2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").fJ(true));
                k.this.o(pMSAppInfo);
                qv2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").fJ(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void j(PMSAppInfo pMSAppInfo) {
                k.this.dnn = 5;
                k.this.f("KEY_PKG_STATE", "event_pms_check_finish", k.this.dnn);
                HybridUbcFlow qv2 = com.baidu.swan.apps.performance.i.qv("startup");
                qv2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").fJ(true));
                if (k.DEBUG) {
                    k.log("预制包安装成功");
                }
                k.a(k.this.aFt(), pMSAppInfo, false, false, true);
                k.this.n(pMSAppInfo);
                k.this.T(null);
                qv2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").fJ(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i) {
                HybridUbcFlow qv2 = com.baidu.swan.apps.performance.i.qv("startup");
                qv2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").fJ(true));
                if (k.DEBUG) {
                    k.log("预制包安装失败");
                }
                k.this.aFB();
                qv2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").fJ(true));
            }
        });
        qv.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").fJ(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFB() {
        d.aEQ().rF("event_pms_check_start");
        final HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
        qv.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").fJ(true));
        final com.baidu.swan.apps.u.c.b aFt = aFt();
        if (DEBUG) {
            log("预置包不可用");
        }
        boolean aFC = aFC();
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + aFC);
        }
        if (!aFC) {
            if (DEBUG) {
                log("可以直接打开小程序，异步从Server拉取新包");
            }
            this.dnn = 4;
            a(aFt, this.cHj, false, false, false);
            this.dnn = this.dno ? 3 : 4;
            T(null);
            f("KEY_PKG_STATE", "event_pms_check_finish", this.dnn);
            return;
        }
        if (DEBUG) {
            log("不能直接打开小程序，同步从Server拉取新包");
        }
        f("KEY_PKG_STATE", "event_pms_check_finish", this.dnn);
        a(this.cHI.aEY().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(aFt, k.this.cHj, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aFt.getAppFrameType());
        cVar.ym("3");
        cVar.cw(this.cHj == null ? 0L : this.cHj.versionCode);
        cVar.cx(this.cHj != null ? this.cHj.appSign : 0L);
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(aFt.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.yi(delAllParamsFromUrl);
        }
        qv.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").fJ(true));
        i((i.a) new i.a("event_on_still_maintaining").Z(" event_params_pkg_update", this.dnq));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.cHI) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.utils.f fVar) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading set onPrepareDownload");
                }
                k.this.dnk = true;
                d.aEQ().rF("event_pkg_download_start");
                super.a(fVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void anG() {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                }
                k.this.dnk = false;
                d.aEQ().rF("event_pkg_download_finish");
                super.anG();
            }
        }.c(new com.baidu.swan.apps.ap.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: q */
            public void M(PMSAppInfo pMSAppInfo) {
                qv.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").fJ(true));
                if (k.DEBUG) {
                    k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                k.this.n(pMSAppInfo);
                k.this.o(pMSAppInfo);
                qv.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").fJ(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.am.a aVar, boolean z) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalFailed");
                }
                k.this.dnk = false;
                d.aEQ().rF("event_pkg_download_finish");
                qv.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").fJ(true));
                if (k.DEBUG) {
                    k.log("onFinalFailed");
                }
                com.baidu.swan.apps.am.e.aJt().j(aVar);
                if (z) {
                    k.this.dnn = k.this.dno ? 3 : 4;
                    k.this.f("KEY_PKG_STATE", "event_pms_check_finish", k.this.dnn);
                    k.this.e(aVar);
                } else {
                    if (aVar != null && aVar.aJl() == 1020) {
                        k.this.h(aVar);
                    }
                    k.this.gt(false);
                }
                qv.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").fJ(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void f(PMSAppInfo pMSAppInfo) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalComplete");
                }
                k.this.dnk = false;
                k.this.dnn = k.this.dnm ? 2 : 0;
                k.this.dnn = k.this.dno ? 1 : k.this.dnn;
                k.this.f("KEY_PKG_STATE", "event_pms_check_finish", k.this.dnn);
                qv.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").fJ(true));
                if (k.DEBUG) {
                    k.log("onFinalComplete");
                }
                k.this.n(pMSAppInfo);
                k.this.f((com.baidu.swan.apps.am.a) null);
                qv.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").fJ(true));
            }
        }).ia(this.dno ? 2 : 1));
        qv.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").fJ(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        d.aEQ().f(str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(PMSAppInfo pMSAppInfo) {
        this.cHj = pMSAppInfo;
        this.cHI.aEY().l(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").bV("mAppId", getAppId())).P("appFrameType", pMSAppInfo.appCategory);
            if (DEBUG) {
                log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                if (DEBUG) {
                    log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                }
                aVar.bV("app_name", pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                if (DEBUG) {
                    log("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                }
                aVar.p(Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                if (DEBUG) {
                    log("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                }
                aVar.bV("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.Z("event_flag_force_post", true);
            i(aVar);
        }
    }

    private boolean aFC() {
        HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
        if (this.cHj == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            qv.ci("launch_state", String.valueOf(0));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
            return true;
        } else if (this.cHj.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.dnm = true;
            qv.ci("launch_state", String.valueOf(2));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cHj.aYQ()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.dnm = true;
            qv.ci("launch_state", String.valueOf(2));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cHj.aYR()) {
            if (com.baidu.swan.apps.core.a.b.a.akW().my(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                qv.ci("launch_state", String.valueOf(3));
                f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
            qv.ci("launch_state", String.valueOf(1));
            this.dno = true;
            return true;
        } else {
            qv.ci("launch_state", String.valueOf(4));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.u.c.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.awj().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.awj().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.awj().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.ko(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.duu = z ? "1" : "0";
        fVar.duw = z3 ? "1" : "0";
        fVar.duv = z2 ? "1" : "0";
        long j = eVar.getLong("launch_interval", -1L);
        if (j >= 0 && j <= 5000) {
            fVar.u("launchInterval", Long.valueOf(j));
        }
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        final String awf = eVar.awf();
        final String string = eVar.awj().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.8
            @Override // java.lang.Runnable
            public void run() {
                k.a(com.baidu.swan.apps.statistic.a.f.this, awf, string);
            }
        }, "launchStatistic", 2);
    }

    public static void a(com.baidu.swan.apps.statistic.a.f fVar, String str, String str2) {
        JSONObject sP = com.baidu.swan.apps.statistic.h.sP(str);
        fVar.sY(str2);
        fVar.cb(sP);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private void a(boolean z, String str, com.baidu.swan.apps.am.a aVar) {
        if (this.cHj != null) {
            Context context = getContext();
            e aEV = e.aEV();
            if (aEV != null) {
                String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.axo().awQ(), aEV.ado().getAppFrameType()), String.valueOf(aVar.aJp()));
                if (!com.baidu.swan.apps.t.a.auI().a(context, aEV.getAppKey(), aVar)) {
                    Intent intent = new Intent();
                    intent.putExtra("pms_db_info_onload", this.cHj);
                    intent.putExtra("swan_error_type", z ? "type_path_forbidden" : "type_app_forbidden");
                    ForbiddenInfo forbiddenInfo = new ForbiddenInfo(aFt(), str, format);
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
            com.baidu.swan.apps.u.c.b aFt = aFt();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.ko(aFt.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aFt);
            fVar.u("status", "2");
            fVar.sY(aFt.awj().getString("ubc"));
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
        int appFrameType = aFt().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 10002;
        }
        return 0;
    }

    private com.baidu.swan.apps.am.a kf(int i) {
        com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
        switch (i) {
            case 10001:
                aVar.bZ(10L).ca(2902L).tM("no aiapps info in database");
                break;
            case 10002:
                aVar.bZ(10L).ca(27L).tM("category not match");
                break;
            case 10003:
                aVar.bZ(10L).ca(2107L).tK("app forbiddeon");
                break;
            case 10004:
                aVar.bZ(10L).ca(48L).tK("path forbiddeon");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.swan.apps.am.a aVar) {
        if (f(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aFt()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(com.baidu.swan.apps.am.a aVar) {
        HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
        qv.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").fJ(true));
        if (!g(aVar)) {
            if (DEBUG) {
                log("updateInstalledPkgWithFinalCheck by null launchParams");
            }
            gt(false);
            return false;
        }
        qv.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").fJ(true));
        b.a aEY = this.cHI.aEY();
        long tB = com.baidu.swan.apps.swancore.b.tB(aEY.awo());
        long j = aEY.apD() != null ? aEY.apD().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + aEY.awo() + " targetSwanVersion: " + tB + " ,curSwanVersion: " + j);
        }
        if (tB > j) {
            com.baidu.swan.apps.swancore.b.ku(aEY.getAppFrameType());
        }
        com.baidu.swan.apps.performance.i.qv("startup").ci("launch_type", String.valueOf(com.baidu.swan.apps.ao.a.aJy()));
        if (aEY.getAppFrameType() == 0) {
            aFD();
        }
        qv.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").fJ(true));
        gt(true);
        com.baidu.swan.apps.env.c aqI = com.baidu.swan.apps.env.e.aqH().aqI();
        if (aqI != null && aqI.aqB()) {
            aqI.nF(getAppId());
        }
        return true;
    }

    private void aFD() {
        com.baidu.swan.apps.r.d.e(this.cHI);
    }

    private boolean g(com.baidu.swan.apps.am.a aVar) {
        com.baidu.swan.apps.performance.i.qv("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").fJ(true));
        if (DEBUG) {
            log("updateInfoWithFinalCheck: mAppInfo=" + this.cHj);
        }
        if (this.cHj == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.am.a().bZ(10L).ca(2902L).tM("no pkg was installed");
            }
            com.baidu.swan.apps.am.e.aJt().j(aVar);
            h(aVar);
            return false;
        }
        int p = p(this.cHj);
        if (p == 10001 || p == 10002) {
            if (aVar == null) {
                aVar = kf(p);
            }
            com.baidu.swan.apps.am.e.aJt().j(aVar);
            h(aVar);
            return false;
        }
        aFE();
        if (p != 0) {
            com.baidu.swan.apps.am.a kf = kf(10003);
            com.baidu.swan.apps.am.e.aJt().j(kf);
            a(false, (String) null, kf);
            com.baidu.swan.apps.performance.i.d(kf);
            com.baidu.swan.apps.t.a.avb().flush(false);
            return false;
        }
        if (com.baidu.swan.apps.scheme.actions.forbidden.a.aGe().sm(aEM().aEY().getPage())) {
            com.baidu.swan.apps.am.a kf2 = kf(10004);
            com.baidu.swan.apps.am.e.aJt().j(kf2);
            a(true, com.baidu.swan.apps.scheme.actions.forbidden.a.aGe().aGf(), kf2);
            com.baidu.swan.apps.performance.i.d(kf2);
            com.baidu.swan.apps.t.a.avb().flush(false);
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
        com.baidu.swan.apps.u.c.b aFt = aFt();
        int appFrameType = aFt.getAppFrameType();
        com.baidu.swan.apps.u.b.a.a((Context) com.baidu.swan.apps.t.a.aua(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.ko(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = "fail";
        fVar.u("errcode", String.valueOf(aVar.aJp()));
        fVar.u("msg", aVar.aJo().toString());
        fVar.d(aFt);
        fVar.sY(aFt.awj().getString("ubc"));
        fVar.cb(com.baidu.swan.apps.statistic.h.sP(aFt.awf()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.aJq()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().sU(com.baidu.swan.apps.statistic.h.ko(appFrameType)).i(aVar).sV(getAppId()).sW(aFt.awd()));
            aVar.aJr();
        }
        com.baidu.swan.apps.t.a.avb().flush(false);
    }

    private void aFE() {
        final b.a aEY = aEM().aEY();
        boolean z = (this.cHj == null || TextUtils.isEmpty(this.cHj.appId) || !TextUtils.equals(getAppId(), this.cHj.appId)) ? false : true;
        if (z) {
            aEY.k(this.cHj);
        }
        final int i = (z && this.cHj.appCategory == 1) ? 1 : 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aEY.iU(i);
        } else {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.9
                @Override // java.lang.Runnable
                public void run() {
                    aEY.iU(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void gt(boolean z) {
        this.dnj = false;
        this.dnl = z;
        this.cHj = null;
        if (DEBUG) {
            log("notifyMaintainFinish: " + z);
        }
        i((i.a) new i.a("event_on_pkg_maintain_finish").bV("mAppId", this.cHI.id));
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.pr(this.dnp).awF();
        }
        this.dnp = "";
    }

    private Context getContext() {
        SwanAppActivity aEO = this.cHI.aEO();
        return (aEO == null || aEO.isDestroyed()) ? com.baidu.swan.apps.t.a.aua() : aEO;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a aCO = com.baidu.swan.apps.process.messaging.client.a.aCO();
        if (aCO == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.aCw());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.n(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        aCO.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes10.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void y(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.dfo.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean xV = com.baidu.swan.pms.c.xV(string);
            boolean xW = com.baidu.swan.pms.c.xW(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + xV + ", isInQueue: " + xW);
            }
            this.dfo.putBoolean("isDownloading", (xV || xW) ? true : true);
            finish();
        }
    }
}
