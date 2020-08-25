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
/* loaded from: classes8.dex */
public final class k extends m implements com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cQA;
    private boolean cQB;
    private int cQC;
    private boolean cQD;
    String cQE;
    private boolean cQF;
    private boolean cQy;
    private boolean cQz;
    private final e ckP;
    private PMSAppInfo ckq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.cQy = false;
        this.cQz = false;
        this.cQA = false;
        this.cQB = false;
        this.cQC = -1;
        this.cQD = false;
        this.cQE = "";
        this.cQF = false;
        this.ckP = eVar;
    }

    public com.baidu.swan.apps.u.c.b aAh() {
        return this.ckP.azM();
    }

    public synchronized boolean aAi() {
        return this.cQy;
    }

    public boolean aAj() {
        return this.cQz;
    }

    public int azP() {
        return this.cQC;
    }

    public synchronized boolean aAk() {
        return this.cQA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aAl() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.ckP.cQc && !aAi() && !aAk()) {
                this.cQy = true;
                com.baidu.swan.apps.performance.i.oW("startup").f(new UbcFlowEvent("maintain_start").fb(true));
                boolean z = 1 == this.ckP.azM().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.ajS().aka()) {
                    qg("event_on_still_maintaining");
                }
                if (z) {
                    aAm();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void aAm() {
        final HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
        oW.f(new UbcFlowEvent("postExec-onhold").fb(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                oW.f(new UbcFlowEvent("postExec-run").fb(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.cQC = 99;
            f("KEY_PKG_STATE", "event_pms_check_start", this.cQC);
            b.a azM = this.ckP.azM();
            if (com.baidu.swan.apps.ad.a.a.axd() || !TextUtils.isEmpty(azM.arc()) || (DEBUG && azM.isDebug())) {
                fL(true);
            } else {
                this.cQE = azM.arg();
                if (DEBUG) {
                    com.baidu.swan.apps.u.e.a.nQ(this.cQE).nR("start");
                }
                com.baidu.swan.apps.inlinewidget.f.b.b.nc("1");
                HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
                oW.r("type", "1");
                oW.bW("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.afH().afI()));
                oW.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo ard = this.ckP.azM().ard();
                if (ard == null || ard.aTD()) {
                    ard = com.baidu.swan.pms.database.a.aTt().wz(getAppId());
                }
                oW.f(new UbcFlowEvent("na_query_db"));
                this.cQF = com.baidu.swan.apps.u.f.a.m(ard);
                this.cQB = (ard == null || this.cQF) ? false : false;
                oW.f(new UbcFlowEvent("has_local_file").fb(true));
                if (this.cQF) {
                    n(ard);
                    o(this.ckq);
                    oW.f(new UbcFlowEvent("update_icon").fb(true));
                }
                if (!this.cQF && com.baidu.swan.apps.u.f.a.a(this.ckq, azM.getPage())) {
                    aAn();
                } else {
                    aAo();
                }
            }
        }
    }

    private void aAn() {
        HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
        oW.f(new UbcFlowEvent("updateForIndependentPkgStart").fb(true));
        if (DEBUG) {
            log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        }
        com.baidu.swan.apps.u.c.b aAh = aAh();
        String b = com.baidu.swan.apps.u.f.a.b(this.ckq, aAh.getPage());
        aAh.eG(true);
        aAh.nM(b);
        Bundle bundle = new Bundle();
        bundle.putLong("pms_update_expect_pkg_ver", this.ckq.versionCode);
        T(bundle);
        oW.f(new UbcFlowEvent("updateForIndependentPkgEnd").fb(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(final Bundle bundle) {
        HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
        oW.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").fb(true));
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
                bundle2.putInt("appFrameType", k.this.aAh().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                if (k.DEBUG) {
                    k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                com.baidu.swan.apps.process.messaging.a.axs().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).bC(5000L));
            }
        });
        oW.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").fb(true));
    }

    private void aAo() {
        HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
        oW.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").fb(true));
        if (DEBUG) {
            log(this.ckq == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        }
        com.baidu.swan.apps.core.j.c lO = com.baidu.swan.apps.core.j.f.ajq().lO(getAppId());
        long j = this.ckq == null ? -1L : this.ckq.versionCode;
        long j2 = lO != null ? lO.versionCode : -1L;
        boolean z = j2 > j;
        if (DEBUG) {
            log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (!z) {
            aAp();
            return;
        }
        qg("event_on_still_maintaining");
        oW.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").fb(true));
        com.baidu.swan.apps.core.j.f.ajq().a(lO, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void i(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow oW2 = com.baidu.swan.apps.performance.i.oW("startup");
                oW2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").fb(true));
                k.this.o(pMSAppInfo);
                oW2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").fb(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void j(PMSAppInfo pMSAppInfo) {
                k.this.cQC = 5;
                k.this.f("KEY_PKG_STATE", "event_pms_check_finish", k.this.cQC);
                HybridUbcFlow oW2 = com.baidu.swan.apps.performance.i.oW("startup");
                oW2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").fb(true));
                if (k.DEBUG) {
                    k.log("预制包安装成功");
                }
                k.a(k.this.aAh(), pMSAppInfo, false, false, true);
                k.this.n(pMSAppInfo);
                k.this.T(null);
                oW2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").fb(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i) {
                HybridUbcFlow oW2 = com.baidu.swan.apps.performance.i.oW("startup");
                oW2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").fb(true));
                if (k.DEBUG) {
                    k.log("预制包安装失败");
                }
                k.this.aAp();
                oW2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").fb(true));
            }
        });
        oW.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").fb(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAp() {
        d.azE().qg("event_pms_check_start");
        final HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
        oW.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").fb(true));
        final com.baidu.swan.apps.u.c.b aAh = aAh();
        if (DEBUG) {
            log("预置包不可用");
        }
        boolean aAq = aAq();
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + aAq);
        }
        if (!aAq) {
            if (DEBUG) {
                log("可以直接打开小程序，异步从Server拉取新包");
            }
            this.cQC = 4;
            a(aAh, this.ckq, false, false, false);
            this.cQC = this.cQD ? 3 : 4;
            T(null);
            f("KEY_PKG_STATE", "event_pms_check_finish", this.cQC);
            return;
        }
        if (DEBUG) {
            log("不能直接打开小程序，同步从Server拉取新包");
        }
        f("KEY_PKG_STATE", "event_pms_check_finish", this.cQC);
        a(this.ckP.azM().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(aAh, k.this.ckq, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aAh.getAppFrameType());
        cVar.wN("3");
        cVar.cl(this.ckq == null ? 0L : this.ckq.versionCode);
        cVar.cm(this.ckq != null ? this.ckq.appSign : 0L);
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(aAh.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.wJ(delAllParamsFromUrl);
        }
        oW.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").fb(true));
        i((i.a) new i.a("event_on_still_maintaining").T(" event_params_pkg_update", this.cQF));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.ckP) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.utils.f fVar) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading set onPrepareDownload");
                }
                k.this.cQz = true;
                d.azE().qg("event_pkg_download_start");
                super.a(fVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void air() {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                }
                k.this.cQz = false;
                d.azE().qg("event_pkg_download_finish");
                super.air();
            }
        }.c(new com.baidu.swan.apps.ap.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: q */
            public void I(PMSAppInfo pMSAppInfo) {
                oW.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").fb(true));
                if (k.DEBUG) {
                    k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                k.this.n(pMSAppInfo);
                k.this.o(pMSAppInfo);
                oW.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").fb(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.am.a aVar, boolean z) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalFailed");
                }
                k.this.cQz = false;
                d.azE().qg("event_pkg_download_finish");
                oW.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").fb(true));
                if (k.DEBUG) {
                    k.log("onFinalFailed");
                }
                com.baidu.swan.apps.am.e.aEg().j(aVar);
                if (z) {
                    k.this.cQC = k.this.cQD ? 3 : 4;
                    k.this.f("KEY_PKG_STATE", "event_pms_check_finish", k.this.cQC);
                    k.this.e(aVar);
                } else {
                    if (aVar != null && aVar.aDY() == 1020) {
                        k.this.h(aVar);
                    }
                    k.this.fL(false);
                }
                oW.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").fb(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void f(PMSAppInfo pMSAppInfo) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalComplete");
                }
                k.this.cQz = false;
                k.this.cQC = k.this.cQB ? 2 : 0;
                k.this.cQC = k.this.cQD ? 1 : k.this.cQC;
                k.this.f("KEY_PKG_STATE", "event_pms_check_finish", k.this.cQC);
                oW.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").fb(true));
                if (k.DEBUG) {
                    k.log("onFinalComplete");
                }
                k.this.n(pMSAppInfo);
                k.this.f((com.baidu.swan.apps.am.a) null);
                oW.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").fb(true));
            }
        }).hj(this.cQD ? 2 : 1));
        oW.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").fb(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        d.azE().f(str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(PMSAppInfo pMSAppInfo) {
        this.ckq = pMSAppInfo;
        this.ckP.azM().l(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").bJ("mAppId", getAppId())).O("appFrameType", pMSAppInfo.appCategory);
            if (DEBUG) {
                log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                if (DEBUG) {
                    log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                }
                aVar.bJ("app_name", pMSAppInfo.appName);
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
                aVar.bJ("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.T("event_flag_force_post", true);
            i(aVar);
        }
    }

    private boolean aAq() {
        HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
        if (this.ckq == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            oW.bW("launch_state", String.valueOf(0));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
            return true;
        } else if (this.ckq.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.cQB = true;
            oW.bW("launch_state", String.valueOf(2));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.ckq.aTC()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.cQB = true;
            oW.bW("launch_state", String.valueOf(2));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.ckq.aTD()) {
            if (com.baidu.swan.apps.core.a.b.a.afH().kZ(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                oW.bW("launch_state", String.valueOf(3));
                f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
            oW.bW("launch_state", String.valueOf(1));
            this.cQD = true;
            return true;
        } else {
            oW.bW("launch_state", String.valueOf(4));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.u.c.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.aqT().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.aqT().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.aqT().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.jv(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.cXE = z ? "1" : "0";
        fVar.cXG = z3 ? "1" : "0";
        fVar.cXF = z2 ? "1" : "0";
        long j = eVar.getLong("launch_interval", -1L);
        if (j >= 0 && j <= 5000) {
            fVar.u("launchInterval", Long.valueOf(j));
        }
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        final String aqP = eVar.aqP();
        final String string = eVar.aqT().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.8
            @Override // java.lang.Runnable
            public void run() {
                k.a(com.baidu.swan.apps.statistic.a.f.this, aqP, string);
            }
        }, "launchStatistic", 2);
    }

    public static void a(com.baidu.swan.apps.statistic.a.f fVar, String str, String str2) {
        JSONObject rp = com.baidu.swan.apps.statistic.h.rp(str);
        fVar.ry(str2);
        fVar.bO(rp);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private void a(boolean z, String str, com.baidu.swan.apps.am.a aVar) {
        if (this.ckq != null) {
            Context context = getContext();
            e azJ = e.azJ();
            if (azJ != null) {
                String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.arY().arA(), azJ.XZ().getAppFrameType()), String.valueOf(aVar.aEc()));
                if (!com.baidu.swan.apps.t.a.aps().a(context, azJ.getAppKey(), aVar)) {
                    Intent intent = new Intent();
                    intent.putExtra("pms_db_info_onload", this.ckq);
                    intent.putExtra("swan_error_type", z ? "type_path_forbidden" : "type_app_forbidden");
                    ForbiddenInfo forbiddenInfo = new ForbiddenInfo(aAh(), str, format);
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
            com.baidu.swan.apps.u.c.b aAh = aAh();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.jv(aAh.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aAh);
            fVar.u("status", "2");
            fVar.ry(aAh.aqT().getString("ubc"));
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
        int appFrameType = aAh().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 10002;
        }
        return 0;
    }

    private com.baidu.swan.apps.am.a jm(int i) {
        com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
        switch (i) {
            case 10001:
                aVar.bO(10L).bP(2902L).sm("no aiapps info in database");
                break;
            case 10002:
                aVar.bO(10L).bP(27L).sm("category not match");
                break;
            case 10003:
                aVar.bO(10L).bP(2107L).sk("app forbiddeon");
                break;
            case 10004:
                aVar.bO(10L).bP(48L).sk("path forbiddeon");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.swan.apps.am.a aVar) {
        if (f(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aAh()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(com.baidu.swan.apps.am.a aVar) {
        HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
        oW.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").fb(true));
        if (!g(aVar)) {
            if (DEBUG) {
                log("updateInstalledPkgWithFinalCheck by null launchParams");
            }
            fL(false);
            return false;
        }
        oW.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").fb(true));
        b.a azM = this.ckP.azM();
        long sb = com.baidu.swan.apps.swancore.b.sb(azM.aqY());
        long j = azM.akn() != null ? azM.akn().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + azM.aqY() + " targetSwanVersion: " + sb + " ,curSwanVersion: " + j);
        }
        if (sb > j) {
            com.baidu.swan.apps.swancore.b.jB(azM.getAppFrameType());
        }
        com.baidu.swan.apps.performance.i.oW("startup").bW("launch_type", String.valueOf(com.baidu.swan.apps.ao.a.aEl()));
        if (azM.getAppFrameType() == 0) {
            aAr();
        }
        oW.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").fb(true));
        fL(true);
        com.baidu.swan.apps.env.c als = com.baidu.swan.apps.env.e.alr().als();
        if (als != null && als.all()) {
            als.mg(getAppId());
        }
        return true;
    }

    private void aAr() {
        com.baidu.swan.apps.r.d.e(this.ckP);
    }

    private boolean g(com.baidu.swan.apps.am.a aVar) {
        com.baidu.swan.apps.performance.i.oW("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").fb(true));
        if (DEBUG) {
            log("updateInfoWithFinalCheck: mAppInfo=" + this.ckq);
        }
        if (this.ckq == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.am.a().bO(10L).bP(2902L).sm("no pkg was installed");
            }
            com.baidu.swan.apps.am.e.aEg().j(aVar);
            h(aVar);
            return false;
        }
        int p = p(this.ckq);
        if (p == 10001 || p == 10002) {
            if (aVar == null) {
                aVar = jm(p);
            }
            com.baidu.swan.apps.am.e.aEg().j(aVar);
            h(aVar);
            return false;
        }
        aAs();
        if (p != 0) {
            com.baidu.swan.apps.am.a jm = jm(10003);
            com.baidu.swan.apps.am.e.aEg().j(jm);
            a(false, (String) null, jm);
            com.baidu.swan.apps.performance.i.d(jm);
            com.baidu.swan.apps.t.a.apL().flush(false);
            return false;
        }
        if (com.baidu.swan.apps.scheme.actions.forbidden.a.aAS().qN(azA().azM().getPage())) {
            com.baidu.swan.apps.am.a jm2 = jm(10004);
            com.baidu.swan.apps.am.e.aEg().j(jm2);
            a(true, com.baidu.swan.apps.scheme.actions.forbidden.a.aAS().aAT(), jm2);
            com.baidu.swan.apps.performance.i.d(jm2);
            com.baidu.swan.apps.t.a.apL().flush(false);
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
        com.baidu.swan.apps.u.c.b aAh = aAh();
        int appFrameType = aAh.getAppFrameType();
        com.baidu.swan.apps.u.b.a.a((Context) com.baidu.swan.apps.t.a.aoJ(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.jv(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = "fail";
        fVar.u("errcode", String.valueOf(aVar.aEc()));
        fVar.u("msg", aVar.aEb().toString());
        fVar.d(aAh);
        fVar.ry(aAh.aqT().getString("ubc"));
        fVar.bO(com.baidu.swan.apps.statistic.h.rp(aAh.aqP()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.aEd()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().ru(com.baidu.swan.apps.statistic.h.jv(appFrameType)).i(aVar).rv(getAppId()).rw(aAh.aqN()));
            aVar.aEe();
        }
        com.baidu.swan.apps.t.a.apL().flush(false);
    }

    private void aAs() {
        final b.a azM = azA().azM();
        boolean z = (this.ckq == null || TextUtils.isEmpty(this.ckq.appId) || !TextUtils.equals(getAppId(), this.ckq.appId)) ? false : true;
        if (z) {
            azM.k(this.ckq);
        }
        final int i = (z && this.ckq.appCategory == 1) ? 1 : 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            azM.ic(i);
        } else {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.9
                @Override // java.lang.Runnable
                public void run() {
                    azM.ic(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void fL(boolean z) {
        this.cQy = false;
        this.cQA = z;
        this.ckq = null;
        if (DEBUG) {
            log("notifyMaintainFinish: " + z);
        }
        i((i.a) new i.a("event_on_pkg_maintain_finish").bJ("mAppId", this.ckP.id));
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.nQ(this.cQE).arp();
        }
        this.cQE = "";
    }

    private Context getContext() {
        SwanAppActivity azC = this.ckP.azC();
        return (azC == null || azC.isDestroyed()) ? com.baidu.swan.apps.t.a.aoJ() : azC;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a axC = com.baidu.swan.apps.process.messaging.client.a.axC();
        if (axC == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.axi());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.n(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        axC.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes8.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void y(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.cIG.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean ww = com.baidu.swan.pms.c.ww(string);
            boolean wx = com.baidu.swan.pms.c.wx(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + ww + ", isInQueue: " + wx);
            }
            this.cIG.putBoolean("isDownloading", (ww || wx) ? true : true);
            finish();
        }
    }
}
