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
    private final e cXH;
    private PMSAppInfo cXi;
    private boolean dHe;
    private boolean dHf;
    private boolean dHg;
    private boolean dHh;
    private int dHi;
    private boolean dHj;
    String dHk;
    private boolean dHl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.dHe = false;
        this.dHf = false;
        this.dHg = false;
        this.dHh = false;
        this.dHi = -1;
        this.dHj = false;
        this.dHk = "";
        this.dHl = false;
        this.cXH = eVar;
    }

    public com.baidu.swan.apps.u.c.b aMJ() {
        return this.cXH.aMo();
    }

    public synchronized boolean aMK() {
        return this.dHe;
    }

    public boolean aML() {
        return this.dHf;
    }

    public int aMr() {
        return this.dHi;
    }

    public synchronized boolean aMM() {
        return this.dHg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aMN() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.cXH.dGI && !aMK() && !aMM()) {
                this.dHe = true;
                com.baidu.swan.apps.performance.i.rd("startup").f(new UbcFlowEvent("maintain_start").gt(true));
                boolean z = 1 == this.cXH.aMo().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.avA().avI()) {
                    ss("event_on_still_maintaining");
                }
                if (z) {
                    aMO();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void aMO() {
        final HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
        rd.f(new UbcFlowEvent("postExec-onhold").gt(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                rd.f(new UbcFlowEvent("postExec-run").gt(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.dHi = 99;
            j("KEY_PKG_STATE", "event_pms_check_start", this.dHi);
            b.a aMo = this.cXH.aMo();
            if (com.baidu.swan.apps.ad.a.a.aIK() || !TextUtils.isEmpty(aMo.aCK()) || (DEBUG && aMo.isDebug())) {
                hm(true);
            } else {
                this.dHk = aMo.aCO();
                if (DEBUG) {
                    com.baidu.swan.apps.u.e.a.pZ(this.dHk).qa("start");
                }
                com.baidu.swan.apps.inlinewidget.f.b.b.pl("1");
                HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
                rd.q("type", "1");
                rd.cn("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.ari().arj()));
                rd.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo aCL = this.cXH.aMo().aCL();
                if (aCL == null || aCL.bgl()) {
                    aCL = com.baidu.swan.pms.database.a.bgb().yN(getAppId());
                }
                rd.f(new UbcFlowEvent("na_query_db"));
                this.dHl = com.baidu.swan.apps.u.f.a.m(aCL);
                this.dHh = (aCL == null || this.dHl) ? false : false;
                rd.f(new UbcFlowEvent("has_local_file").gt(true));
                if (this.dHl) {
                    n(aCL);
                    o(this.cXi);
                    rd.f(new UbcFlowEvent("update_icon").gt(true));
                }
                if (!this.dHl && com.baidu.swan.apps.u.f.a.a(this.cXi, aMo.getPage())) {
                    aMP();
                } else {
                    aMQ();
                }
            }
        }
    }

    private void aMP() {
        HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
        rd.f(new UbcFlowEvent("updateForIndependentPkgStart").gt(true));
        if (DEBUG) {
            log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        }
        com.baidu.swan.apps.u.c.b aMJ = aMJ();
        String b2 = com.baidu.swan.apps.u.f.a.b(this.cXi, aMJ.getPage());
        aMJ.fY(true);
        aMJ.pV(b2);
        Bundle bundle = new Bundle();
        bundle.putLong("pms_update_expect_pkg_ver", this.cXi.versionCode);
        T(bundle);
        rd.f(new UbcFlowEvent("updateForIndependentPkgEnd").gt(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(final Bundle bundle) {
        HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
        rd.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").gt(true));
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
                bundle2.putInt("appFrameType", k.this.aMJ().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                if (k.DEBUG) {
                    k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                com.baidu.swan.apps.process.messaging.a.aIX().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).cJ(5000L));
            }
        });
        rd.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").gt(true));
    }

    private void aMQ() {
        HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
        rd.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").gt(true));
        if (DEBUG) {
            log(this.cXi == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        }
        com.baidu.swan.apps.core.j.c nW = com.baidu.swan.apps.core.j.f.auX().nW(getAppId());
        long j = this.cXi == null ? -1L : this.cXi.versionCode;
        long j2 = nW != null ? nW.versionCode : -1L;
        boolean z = j2 > j;
        if (DEBUG) {
            log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (!z) {
            aMR();
            return;
        }
        ss("event_on_still_maintaining");
        rd.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").gt(true));
        com.baidu.swan.apps.core.j.f.auX().a(nW, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void i(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow rd2 = com.baidu.swan.apps.performance.i.rd("startup");
                rd2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").gt(true));
                k.this.o(pMSAppInfo);
                rd2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").gt(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void j(PMSAppInfo pMSAppInfo) {
                k.this.dHi = 5;
                k.this.j("KEY_PKG_STATE", "event_pms_check_finish", k.this.dHi);
                HybridUbcFlow rd2 = com.baidu.swan.apps.performance.i.rd("startup");
                rd2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").gt(true));
                if (k.DEBUG) {
                    k.log("预制包安装成功");
                }
                k.a(k.this.aMJ(), pMSAppInfo, false, false, true);
                k.this.n(pMSAppInfo);
                k.this.T(null);
                rd2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").gt(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i) {
                HybridUbcFlow rd2 = com.baidu.swan.apps.performance.i.rd("startup");
                rd2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").gt(true));
                if (k.DEBUG) {
                    k.log("预制包安装失败");
                }
                k.this.aMR();
                rd2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").gt(true));
            }
        });
        rd.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").gt(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMR() {
        d.aMg().ss("event_pms_check_start");
        final HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
        rd.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").gt(true));
        final com.baidu.swan.apps.u.c.b aMJ = aMJ();
        if (DEBUG) {
            log("预置包不可用");
        }
        boolean aMS = aMS();
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + aMS);
        }
        if (!aMS) {
            if (DEBUG) {
                log("可以直接打开小程序，异步从Server拉取新包");
            }
            this.dHi = 4;
            a(aMJ, this.cXi, false, false, false);
            this.dHi = this.dHj ? 3 : 4;
            T(null);
            j("KEY_PKG_STATE", "event_pms_check_finish", this.dHi);
            return;
        }
        if (DEBUG) {
            log("不能直接打开小程序，同步从Server拉取新包");
        }
        j("KEY_PKG_STATE", "event_pms_check_finish", this.dHi);
        a(this.cXH.aMo().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(aMJ, k.this.cXi, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aMJ.getAppFrameType());
        cVar.zb("3");
        cVar.ds(this.cXi == null ? 0L : this.cXi.versionCode);
        cVar.dt(this.cXi != null ? this.cXi.appSign : 0L);
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(aMJ.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.yX(delAllParamsFromUrl);
        }
        rd.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").gt(true));
        i((i.a) new i.a("event_on_still_maintaining").aa(" event_params_pkg_update", this.dHl));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.cXH) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.utils.f fVar) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading set onPrepareDownload");
                }
                k.this.dHf = true;
                d.aMg().ss("event_pkg_download_start");
                super.a(fVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void atY() {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                }
                k.this.dHf = false;
                d.aMg().ss("event_pkg_download_finish");
                super.atY();
            }
        }.c(new com.baidu.swan.apps.ao.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: q */
            public void L(PMSAppInfo pMSAppInfo) {
                rd.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").gt(true));
                if (k.DEBUG) {
                    k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                k.this.n(pMSAppInfo);
                k.this.o(pMSAppInfo);
                rd.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").gt(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.al.a aVar, boolean z) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalFailed");
                }
                k.this.dHf = false;
                d.aMg().ss("event_pkg_download_finish");
                rd.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").gt(true));
                if (k.DEBUG) {
                    k.log("onFinalFailed");
                }
                com.baidu.swan.apps.al.e.aQJ().j(aVar);
                if (z) {
                    k.this.dHi = k.this.dHj ? 3 : 4;
                    k.this.j("KEY_PKG_STATE", "event_pms_check_finish", k.this.dHi);
                    k.this.e(aVar);
                } else {
                    if (aVar != null && aVar.aQB() == 1020) {
                        k.this.h(aVar);
                    }
                    k.this.hm(false);
                }
                rd.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").gt(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void f(PMSAppInfo pMSAppInfo) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalComplete");
                }
                k.this.dHf = false;
                k.this.dHi = k.this.dHh ? 2 : 0;
                k.this.dHi = k.this.dHj ? 1 : k.this.dHi;
                k.this.j("KEY_PKG_STATE", "event_pms_check_finish", k.this.dHi);
                rd.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").gt(true));
                if (k.DEBUG) {
                    k.log("onFinalComplete");
                }
                k.this.n(pMSAppInfo);
                k.this.f((com.baidu.swan.apps.al.a) null);
                rd.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").gt(true));
            }
        }).iz(this.dHj ? 2 : 1));
        rd.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").gt(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        d.aMg().f(str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(PMSAppInfo pMSAppInfo) {
        this.cXi = pMSAppInfo;
        this.cXH.aMo().l(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").ca("mAppId", getAppId())).U("appFrameType", pMSAppInfo.appCategory);
            if (DEBUG) {
                log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                if (DEBUG) {
                    log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                }
                aVar.ca("app_name", pMSAppInfo.appName);
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
                aVar.ca("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.aa("event_flag_force_post", true);
            i(aVar);
        }
    }

    private boolean aMS() {
        HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
        if (this.cXi == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            rd.cn("launch_state", String.valueOf(0));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
            return true;
        } else if (this.cXi.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.dHh = true;
            rd.cn("launch_state", String.valueOf(2));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cXi.bgk()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.dHh = true;
            rd.cn("launch_state", String.valueOf(2));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cXi.bgl()) {
            if (com.baidu.swan.apps.core.a.b.a.ari().nh(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                rd.cn("launch_state", String.valueOf(3));
                j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
            rd.cn("launch_state", String.valueOf(1));
            this.dHj = true;
            return true;
        } else {
            rd.cn("launch_state", String.valueOf(4));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.u.c.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.aCB().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.aCB().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.aCB().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.kX(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.dOi = z ? "1" : "0";
        fVar.dOk = z3 ? "1" : "0";
        fVar.dOj = z2 ? "1" : "0";
        long j = eVar.getLong("launch_interval", -1L);
        if (j >= 0 && j <= 5000) {
            fVar.t("launchInterval", Long.valueOf(j));
        }
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        final String aCx = eVar.aCx();
        final String string = eVar.aCB().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.8
            @Override // java.lang.Runnable
            public void run() {
                k.a(com.baidu.swan.apps.statistic.a.f.this, aCx, string);
            }
        }, "launchStatistic", 2);
    }

    public static void a(com.baidu.swan.apps.statistic.a.f fVar, String str, String str2) {
        JSONObject tC = com.baidu.swan.apps.statistic.h.tC(str);
        fVar.tL(str2);
        fVar.cl(tC);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private void a(boolean z, String str, com.baidu.swan.apps.al.a aVar) {
        if (this.cXi != null) {
            Context context = getContext();
            e aMl = e.aMl();
            if (aMl != null) {
                String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.aDG().aDi(), aMl.aju().getAppFrameType()), String.valueOf(aVar.aQF()));
                if (!com.baidu.swan.apps.t.a.aAZ().a(context, aMl.getAppKey(), aVar)) {
                    Intent intent = new Intent();
                    intent.putExtra("pms_db_info_onload", this.cXi);
                    intent.putExtra("swan_error_type", z ? "type_path_forbidden" : "type_app_forbidden");
                    ForbiddenInfo forbiddenInfo = new ForbiddenInfo(aMJ(), str, format);
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
            com.baidu.swan.apps.u.c.b aMJ = aMJ();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.kX(aMJ.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aMJ);
            fVar.t("status", "2");
            fVar.tL(aMJ.aCB().getString("ubc"));
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
        int appFrameType = aMJ().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 10002;
        }
        return 0;
    }

    private com.baidu.swan.apps.al.a kP(int i) {
        com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a();
        switch (i) {
            case 10001:
                aVar.cV(10L).cW(2902L).uz("no aiapps info in database");
                break;
            case 10002:
                aVar.cV(10L).cW(27L).uz("category not match");
                break;
            case 10003:
                aVar.cV(10L).cW(2107L).ux("app forbiddeon");
                break;
            case 10004:
                aVar.cV(10L).cW(48L).ux("path forbiddeon");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.swan.apps.al.a aVar) {
        if (f(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aMJ()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(com.baidu.swan.apps.al.a aVar) {
        HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
        rd.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").gt(true));
        if (!g(aVar)) {
            if (DEBUG) {
                log("updateInstalledPkgWithFinalCheck by null launchParams");
            }
            hm(false);
            return false;
        }
        rd.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").gt(true));
        b.a aMo = this.cXH.aMo();
        long uo = com.baidu.swan.apps.swancore.b.uo(aMo.aCG());
        long j = aMo.avV() != null ? aMo.avV().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + aMo.aCG() + " targetSwanVersion: " + uo + " ,curSwanVersion: " + j);
        }
        if (uo > j) {
            com.baidu.swan.apps.swancore.b.ld(aMo.getAppFrameType());
        }
        com.baidu.swan.apps.performance.i.rd("startup").cn("launch_type", String.valueOf(com.baidu.swan.apps.an.a.aQO()));
        if (aMo.getAppFrameType() == 0) {
            aMT();
        }
        rd.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").gt(true));
        hm(true);
        com.baidu.swan.apps.env.c axb = com.baidu.swan.apps.env.e.axa().axb();
        if (axb != null && axb.awU()) {
            axb.op(getAppId());
        }
        return true;
    }

    private void aMT() {
        com.baidu.swan.apps.r.d.e(this.cXH);
    }

    private boolean g(com.baidu.swan.apps.al.a aVar) {
        com.baidu.swan.apps.performance.i.rd("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").gt(true));
        if (DEBUG) {
            log("updateInfoWithFinalCheck: mAppInfo=" + this.cXi);
        }
        if (this.cXi == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.al.a().cV(10L).cW(2902L).uz("no pkg was installed");
            }
            com.baidu.swan.apps.al.e.aQJ().j(aVar);
            h(aVar);
            return false;
        }
        int p = p(this.cXi);
        if (p == 10001 || p == 10002) {
            if (aVar == null) {
                aVar = kP(p);
            }
            com.baidu.swan.apps.al.e.aQJ().j(aVar);
            h(aVar);
            return false;
        }
        aMU();
        if (p != 0) {
            com.baidu.swan.apps.al.a kP = kP(10003);
            com.baidu.swan.apps.al.e.aQJ().j(kP);
            a(false, (String) null, kP);
            com.baidu.swan.apps.performance.i.d(kP);
            com.baidu.swan.apps.t.a.aBs().flush(false);
            return false;
        }
        if (com.baidu.swan.apps.scheme.actions.forbidden.a.aNu().ta(aMc().aMo().getPage())) {
            com.baidu.swan.apps.al.a kP2 = kP(10004);
            com.baidu.swan.apps.al.e.aQJ().j(kP2);
            a(true, com.baidu.swan.apps.scheme.actions.forbidden.a.aNu().aNv(), kP2);
            com.baidu.swan.apps.performance.i.d(kP2);
            com.baidu.swan.apps.t.a.aBs().flush(false);
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
        com.baidu.swan.apps.u.c.b aMJ = aMJ();
        int appFrameType = aMJ.getAppFrameType();
        com.baidu.swan.apps.u.b.a.a((Context) com.baidu.swan.apps.t.a.aAr(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.kX(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = com.baidu.pass.biometrics.face.liveness.c.a.p;
        fVar.t("errcode", String.valueOf(aVar.aQF()));
        fVar.t("msg", aVar.aQE().toString());
        fVar.d(aMJ);
        fVar.tL(aMJ.aCB().getString("ubc"));
        fVar.cl(com.baidu.swan.apps.statistic.h.tC(aMJ.aCx()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.aQG()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().tH(com.baidu.swan.apps.statistic.h.kX(appFrameType)).i(aVar).tI(getAppId()).tJ(aMJ.aCv()));
            aVar.aQH();
        }
        com.baidu.swan.apps.t.a.aBs().flush(false);
    }

    private void aMU() {
        final b.a aMo = aMc().aMo();
        boolean z = (this.cXi == null || TextUtils.isEmpty(this.cXi.appId) || !TextUtils.equals(getAppId(), this.cXi.appId)) ? false : true;
        if (z) {
            aMo.k(this.cXi);
        }
        final int i = (z && this.cXi.appCategory == 1) ? 1 : 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aMo.jt(i);
        } else {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.9
                @Override // java.lang.Runnable
                public void run() {
                    aMo.jt(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void hm(boolean z) {
        this.dHe = false;
        this.dHg = z;
        this.cXi = null;
        if (DEBUG) {
            log("notifyMaintainFinish: " + z);
        }
        i((i.a) new i.a("event_on_pkg_maintain_finish").ca("mAppId", this.cXH.id));
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.pZ(this.dHk).aCX();
        }
        this.dHk = "";
    }

    private Context getContext() {
        SwanAppActivity aMe = this.cXH.aMe();
        return (aMe == null || aMe.isDestroyed()) ? com.baidu.swan.apps.t.a.aAr() : aMe;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a aJh = com.baidu.swan.apps.process.messaging.client.a.aJh();
        if (aJh == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.aIP());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.k(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        aJh.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes9.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void y(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.dvA.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean yK = com.baidu.swan.pms.c.yK(string);
            boolean yL = com.baidu.swan.pms.c.yL(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + yK + ", isInQueue: " + yL);
            }
            this.dvA.putBoolean("isDownloading", (yK || yL) ? true : true);
            finish();
        }
    }
}
