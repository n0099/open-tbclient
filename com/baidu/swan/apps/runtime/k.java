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
/* loaded from: classes25.dex */
public final class k extends m implements com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final e cSK;
    private PMSAppInfo cSl;
    private boolean dyA;
    private boolean dyB;
    private boolean dyC;
    private int dyD;
    private boolean dyE;
    String dyF;
    private boolean dyG;
    private boolean dyz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.dyz = false;
        this.dyA = false;
        this.dyB = false;
        this.dyC = false;
        this.dyD = -1;
        this.dyE = false;
        this.dyF = "";
        this.dyG = false;
        this.cSK = eVar;
    }

    public com.baidu.swan.apps.u.c.b aKt() {
        return this.cSK.aJY();
    }

    public synchronized boolean aKu() {
        return this.dyz;
    }

    public boolean aKv() {
        return this.dyA;
    }

    public int aKb() {
        return this.dyD;
    }

    public synchronized boolean aKw() {
        return this.dyB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aKx() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.cSK.dyd && !aKu() && !aKw()) {
                this.dyz = true;
                com.baidu.swan.apps.performance.i.rk("startup").f(new UbcFlowEvent("maintain_start").gk(true));
                boolean z = 1 == this.cSK.aJY().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.aui().auq()) {
                    sv("event_on_still_maintaining");
                }
                if (z) {
                    aKy();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void aKy() {
        final HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
        rk.f(new UbcFlowEvent("postExec-onhold").gk(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                rk.f(new UbcFlowEvent("postExec-run").gk(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.dyD = 99;
            g("KEY_PKG_STATE", "event_pms_check_start", this.dyD);
            b.a aJY = this.cSK.aJY();
            if (com.baidu.swan.apps.ad.a.a.aHr() || !TextUtils.isEmpty(aJY.aBt()) || (DEBUG && aJY.isDebug())) {
                gU(true);
            } else {
                this.dyF = aJY.aBx();
                if (DEBUG) {
                    com.baidu.swan.apps.u.e.a.qg(this.dyF).qh("start");
                }
                com.baidu.swan.apps.inlinewidget.f.b.b.ps("1");
                HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
                rk.q("type", "1");
                rk.co("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.apW().apX()));
                rk.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo aBu = this.cSK.aJY().aBu();
                if (aBu == null || aBu.bdP()) {
                    aBu = com.baidu.swan.pms.database.a.bdF().yO(getAppId());
                }
                rk.f(new UbcFlowEvent("na_query_db"));
                this.dyG = com.baidu.swan.apps.u.f.a.m(aBu);
                this.dyC = (aBu == null || this.dyG) ? false : false;
                rk.f(new UbcFlowEvent("has_local_file").gk(true));
                if (this.dyG) {
                    n(aBu);
                    o(this.cSl);
                    rk.f(new UbcFlowEvent("update_icon").gk(true));
                }
                if (!this.dyG && com.baidu.swan.apps.u.f.a.a(this.cSl, aJY.getPage())) {
                    aKz();
                } else {
                    aKA();
                }
            }
        }
    }

    private void aKz() {
        HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
        rk.f(new UbcFlowEvent("updateForIndependentPkgStart").gk(true));
        if (DEBUG) {
            log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        }
        com.baidu.swan.apps.u.c.b aKt = aKt();
        String b = com.baidu.swan.apps.u.f.a.b(this.cSl, aKt.getPage());
        aKt.fP(true);
        aKt.qc(b);
        Bundle bundle = new Bundle();
        bundle.putLong("pms_update_expect_pkg_ver", this.cSl.versionCode);
        T(bundle);
        rk.f(new UbcFlowEvent("updateForIndependentPkgEnd").gk(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(final Bundle bundle) {
        HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
        rk.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").gk(true));
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
                bundle2.putInt("appFrameType", k.this.aKt().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                if (k.DEBUG) {
                    k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).cI(5000L));
            }
        });
        rk.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").gk(true));
    }

    private void aKA() {
        HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
        rk.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").gk(true));
        if (DEBUG) {
            log(this.cSl == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        }
        com.baidu.swan.apps.core.j.c od = com.baidu.swan.apps.core.j.f.atG().od(getAppId());
        long j = this.cSl == null ? -1L : this.cSl.versionCode;
        long j2 = od != null ? od.versionCode : -1L;
        boolean z = j2 > j;
        if (DEBUG) {
            log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (!z) {
            aKB();
            return;
        }
        sv("event_on_still_maintaining");
        rk.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").gk(true));
        com.baidu.swan.apps.core.j.f.atG().a(od, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void i(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow rk2 = com.baidu.swan.apps.performance.i.rk("startup");
                rk2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").gk(true));
                k.this.o(pMSAppInfo);
                rk2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").gk(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void j(PMSAppInfo pMSAppInfo) {
                k.this.dyD = 5;
                k.this.g("KEY_PKG_STATE", "event_pms_check_finish", k.this.dyD);
                HybridUbcFlow rk2 = com.baidu.swan.apps.performance.i.rk("startup");
                rk2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").gk(true));
                if (k.DEBUG) {
                    k.log("预制包安装成功");
                }
                k.a(k.this.aKt(), pMSAppInfo, false, false, true);
                k.this.n(pMSAppInfo);
                k.this.T(null);
                rk2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").gk(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i) {
                HybridUbcFlow rk2 = com.baidu.swan.apps.performance.i.rk("startup");
                rk2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").gk(true));
                if (k.DEBUG) {
                    k.log("预制包安装失败");
                }
                k.this.aKB();
                rk2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").gk(true));
            }
        });
        rk.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").gk(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKB() {
        d.aJQ().sv("event_pms_check_start");
        final HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
        rk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").gk(true));
        final com.baidu.swan.apps.u.c.b aKt = aKt();
        if (DEBUG) {
            log("预置包不可用");
        }
        boolean aKC = aKC();
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + aKC);
        }
        if (!aKC) {
            if (DEBUG) {
                log("可以直接打开小程序，异步从Server拉取新包");
            }
            this.dyD = 4;
            a(aKt, this.cSl, false, false, false);
            this.dyD = this.dyE ? 3 : 4;
            T(null);
            g("KEY_PKG_STATE", "event_pms_check_finish", this.dyD);
            return;
        }
        if (DEBUG) {
            log("不能直接打开小程序，同步从Server拉取新包");
        }
        g("KEY_PKG_STATE", "event_pms_check_finish", this.dyD);
        a(this.cSK.aJY().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(aKt, k.this.cSl, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aKt.getAppFrameType());
        cVar.zc("3");
        cVar.dr(this.cSl == null ? 0L : this.cSl.versionCode);
        cVar.ds(this.cSl != null ? this.cSl.appSign : 0L);
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(aKt.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.yY(delAllParamsFromUrl);
        }
        rk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").gk(true));
        i((i.a) new i.a("event_on_still_maintaining").aa(" event_params_pkg_update", this.dyG));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.cSK) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.utils.f fVar) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading set onPrepareDownload");
                }
                k.this.dyA = true;
                d.aJQ().sv("event_pkg_download_start");
                super.a(fVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void asH() {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                }
                k.this.dyA = false;
                d.aJQ().sv("event_pkg_download_finish");
                super.asH();
            }
        }.c(new com.baidu.swan.apps.ap.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: q */
            public void M(PMSAppInfo pMSAppInfo) {
                rk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").gk(true));
                if (k.DEBUG) {
                    k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                k.this.n(pMSAppInfo);
                k.this.o(pMSAppInfo);
                rk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").gk(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.am.a aVar, boolean z) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalFailed");
                }
                k.this.dyA = false;
                d.aJQ().sv("event_pkg_download_finish");
                rk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").gk(true));
                if (k.DEBUG) {
                    k.log("onFinalFailed");
                }
                com.baidu.swan.apps.am.e.aOs().j(aVar);
                if (z) {
                    k.this.dyD = k.this.dyE ? 3 : 4;
                    k.this.g("KEY_PKG_STATE", "event_pms_check_finish", k.this.dyD);
                    k.this.e(aVar);
                } else {
                    if (aVar != null && aVar.aOk() == 1020) {
                        k.this.h(aVar);
                    }
                    k.this.gU(false);
                }
                rk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").gk(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void f(PMSAppInfo pMSAppInfo) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalComplete");
                }
                k.this.dyA = false;
                k.this.dyD = k.this.dyC ? 2 : 0;
                k.this.dyD = k.this.dyE ? 1 : k.this.dyD;
                k.this.g("KEY_PKG_STATE", "event_pms_check_finish", k.this.dyD);
                rk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").gk(true));
                if (k.DEBUG) {
                    k.log("onFinalComplete");
                }
                k.this.n(pMSAppInfo);
                k.this.f((com.baidu.swan.apps.am.a) null);
                rk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").gk(true));
            }
        }).iE(this.dyE ? 2 : 1));
        rk.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").gk(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        d.aJQ().f(str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(PMSAppInfo pMSAppInfo) {
        this.cSl = pMSAppInfo;
        this.cSK.aJY().l(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").cb("mAppId", getAppId())).S("appFrameType", pMSAppInfo.appCategory);
            if (DEBUG) {
                log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                if (DEBUG) {
                    log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                }
                aVar.cb("app_name", pMSAppInfo.appName);
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
                aVar.cb("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.aa("event_flag_force_post", true);
            i(aVar);
        }
    }

    private boolean aKC() {
        HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
        if (this.cSl == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            rk.co("launch_state", String.valueOf(0));
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
            return true;
        } else if (this.cSl.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.dyC = true;
            rk.co("launch_state", String.valueOf(2));
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cSl.bdO()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.dyC = true;
            rk.co("launch_state", String.valueOf(2));
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cSl.bdP()) {
            if (com.baidu.swan.apps.core.a.b.a.apW().no(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                rk.co("launch_state", String.valueOf(3));
                g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
            rk.co("launch_state", String.valueOf(1));
            this.dyE = true;
            return true;
        } else {
            rk.co("launch_state", String.valueOf(4));
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.u.c.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.aBk().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.aBk().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.aBk().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.kS(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.dFE = z ? "1" : "0";
        fVar.dFG = z3 ? "1" : "0";
        fVar.dFF = z2 ? "1" : "0";
        long j = eVar.getLong("launch_interval", -1L);
        if (j >= 0 && j <= 5000) {
            fVar.t("launchInterval", Long.valueOf(j));
        }
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        final String aBg = eVar.aBg();
        final String string = eVar.aBk().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.8
            @Override // java.lang.Runnable
            public void run() {
                k.a(com.baidu.swan.apps.statistic.a.f.this, aBg, string);
            }
        }, "launchStatistic", 2);
    }

    public static void a(com.baidu.swan.apps.statistic.a.f fVar, String str, String str2) {
        JSONObject tF = com.baidu.swan.apps.statistic.h.tF(str);
        fVar.tO(str2);
        fVar.cd(tF);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private void a(boolean z, String str, com.baidu.swan.apps.am.a aVar) {
        if (this.cSl != null) {
            Context context = getContext();
            e aJV = e.aJV();
            if (aJV != null) {
                String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.aCp().aBR(), aJV.aio().getAppFrameType()), String.valueOf(aVar.aOo()));
                if (!com.baidu.swan.apps.t.a.azI().a(context, aJV.getAppKey(), aVar)) {
                    Intent intent = new Intent();
                    intent.putExtra("pms_db_info_onload", this.cSl);
                    intent.putExtra("swan_error_type", z ? "type_path_forbidden" : "type_app_forbidden");
                    ForbiddenInfo forbiddenInfo = new ForbiddenInfo(aKt(), str, format);
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
            com.baidu.swan.apps.u.c.b aKt = aKt();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.kS(aKt.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aKt);
            fVar.t("status", "2");
            fVar.tO(aKt.aBk().getString("ubc"));
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
        int appFrameType = aKt().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 10002;
        }
        return 0;
    }

    private com.baidu.swan.apps.am.a kJ(int i) {
        com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
        switch (i) {
            case 10001:
                aVar.cU(10L).cV(2902L).uC("no aiapps info in database");
                break;
            case 10002:
                aVar.cU(10L).cV(27L).uC("category not match");
                break;
            case 10003:
                aVar.cU(10L).cV(2107L).uA("app forbiddeon");
                break;
            case 10004:
                aVar.cU(10L).cV(48L).uA("path forbiddeon");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.swan.apps.am.a aVar) {
        if (f(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aKt()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(com.baidu.swan.apps.am.a aVar) {
        HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
        rk.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").gk(true));
        if (!g(aVar)) {
            if (DEBUG) {
                log("updateInstalledPkgWithFinalCheck by null launchParams");
            }
            gU(false);
            return false;
        }
        rk.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").gk(true));
        b.a aJY = this.cSK.aJY();
        long ur = com.baidu.swan.apps.swancore.b.ur(aJY.aBp());
        long j = aJY.auD() != null ? aJY.auD().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + aJY.aBp() + " targetSwanVersion: " + ur + " ,curSwanVersion: " + j);
        }
        if (ur > j) {
            com.baidu.swan.apps.swancore.b.kY(aJY.getAppFrameType());
        }
        com.baidu.swan.apps.performance.i.rk("startup").co("launch_type", String.valueOf(com.baidu.swan.apps.ao.a.aOx()));
        if (aJY.getAppFrameType() == 0) {
            aKD();
        }
        rk.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").gk(true));
        gU(true);
        com.baidu.swan.apps.env.c avJ = com.baidu.swan.apps.env.e.avI().avJ();
        if (avJ != null && avJ.avC()) {
            avJ.ow(getAppId());
        }
        return true;
    }

    private void aKD() {
        com.baidu.swan.apps.r.d.e(this.cSK);
    }

    private boolean g(com.baidu.swan.apps.am.a aVar) {
        com.baidu.swan.apps.performance.i.rk("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").gk(true));
        if (DEBUG) {
            log("updateInfoWithFinalCheck: mAppInfo=" + this.cSl);
        }
        if (this.cSl == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.am.a().cU(10L).cV(2902L).uC("no pkg was installed");
            }
            com.baidu.swan.apps.am.e.aOs().j(aVar);
            h(aVar);
            return false;
        }
        int p = p(this.cSl);
        if (p == 10001 || p == 10002) {
            if (aVar == null) {
                aVar = kJ(p);
            }
            com.baidu.swan.apps.am.e.aOs().j(aVar);
            h(aVar);
            return false;
        }
        aKE();
        if (p != 0) {
            com.baidu.swan.apps.am.a kJ = kJ(10003);
            com.baidu.swan.apps.am.e.aOs().j(kJ);
            a(false, (String) null, kJ);
            com.baidu.swan.apps.performance.i.d(kJ);
            com.baidu.swan.apps.t.a.aAb().flush(false);
            return false;
        }
        if (com.baidu.swan.apps.scheme.actions.forbidden.a.aLe().td(aJM().aJY().getPage())) {
            com.baidu.swan.apps.am.a kJ2 = kJ(10004);
            com.baidu.swan.apps.am.e.aOs().j(kJ2);
            a(true, com.baidu.swan.apps.scheme.actions.forbidden.a.aLe().aLf(), kJ2);
            com.baidu.swan.apps.performance.i.d(kJ2);
            com.baidu.swan.apps.t.a.aAb().flush(false);
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
        com.baidu.swan.apps.u.c.b aKt = aKt();
        int appFrameType = aKt.getAppFrameType();
        com.baidu.swan.apps.u.b.a.a((Context) com.baidu.swan.apps.t.a.aza(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.kS(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = "fail";
        fVar.t("errcode", String.valueOf(aVar.aOo()));
        fVar.t("msg", aVar.aOn().toString());
        fVar.d(aKt);
        fVar.tO(aKt.aBk().getString("ubc"));
        fVar.cd(com.baidu.swan.apps.statistic.h.tF(aKt.aBg()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.aOp()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().tK(com.baidu.swan.apps.statistic.h.kS(appFrameType)).i(aVar).tL(getAppId()).tM(aKt.aBe()));
            aVar.aOq();
        }
        com.baidu.swan.apps.t.a.aAb().flush(false);
    }

    private void aKE() {
        final b.a aJY = aJM().aJY();
        boolean z = (this.cSl == null || TextUtils.isEmpty(this.cSl.appId) || !TextUtils.equals(getAppId(), this.cSl.appId)) ? false : true;
        if (z) {
            aJY.k(this.cSl);
        }
        final int i = (z && this.cSl.appCategory == 1) ? 1 : 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aJY.jy(i);
        } else {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.9
                @Override // java.lang.Runnable
                public void run() {
                    aJY.jy(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void gU(boolean z) {
        this.dyz = false;
        this.dyB = z;
        this.cSl = null;
        if (DEBUG) {
            log("notifyMaintainFinish: " + z);
        }
        i((i.a) new i.a("event_on_pkg_maintain_finish").cb("mAppId", this.cSK.id));
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.qg(this.dyF).aBG();
        }
        this.dyF = "";
    }

    private Context getContext() {
        SwanAppActivity aJO = this.cSK.aJO();
        return (aJO == null || aJO.isDestroyed()) ? com.baidu.swan.apps.t.a.aza() : aJO;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a aHO = com.baidu.swan.apps.process.messaging.client.a.aHO();
        if (aHO == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.aHw());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.n(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        aHO.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes25.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void y(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.dqB.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean yL = com.baidu.swan.pms.c.yL(string);
            boolean yM = com.baidu.swan.pms.c.yM(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + yL + ", isInQueue: " + yM);
            }
            this.dqB.putBoolean("isDownloading", (yL || yM) ? true : true);
            finish();
        }
    }
}
