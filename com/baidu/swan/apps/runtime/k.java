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
/* loaded from: classes8.dex */
public final class k extends m implements com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final e cSV;
    private PMSAppInfo cSw;
    private boolean dCs;
    private boolean dCt;
    private boolean dCu;
    private boolean dCv;
    private int dCw;
    private boolean dCx;
    String dCy;
    private boolean dCz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.dCs = false;
        this.dCt = false;
        this.dCu = false;
        this.dCv = false;
        this.dCw = -1;
        this.dCx = false;
        this.dCy = "";
        this.dCz = false;
        this.cSV = eVar;
    }

    public com.baidu.swan.apps.u.c.b aIQ() {
        return this.cSV.aIv();
    }

    public synchronized boolean aIR() {
        return this.dCs;
    }

    public boolean aIS() {
        return this.dCt;
    }

    public int aIy() {
        return this.dCw;
    }

    public synchronized boolean aIT() {
        return this.dCu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aIU() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.cSV.dBW && !aIR() && !aIT()) {
                this.dCs = true;
                com.baidu.swan.apps.performance.i.pS("startup").f(new UbcFlowEvent("maintain_start").gp(true));
                boolean z = 1 == this.cSV.aIv().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.arG().arO()) {
                    rg("event_on_still_maintaining");
                }
                if (z) {
                    aIV();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void aIV() {
        final HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
        pS.f(new UbcFlowEvent("postExec-onhold").gp(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                pS.f(new UbcFlowEvent("postExec-run").gp(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.dCw = 99;
            j("KEY_PKG_STATE", "event_pms_check_start", this.dCw);
            b.a aIv = this.cSV.aIv();
            if (com.baidu.swan.apps.ad.a.a.aER() || !TextUtils.isEmpty(aIv.ayR()) || (DEBUG && aIv.isDebug())) {
                hi(true);
            } else {
                this.dCy = aIv.ayV();
                if (DEBUG) {
                    com.baidu.swan.apps.u.e.a.oO(this.dCy).oP("start");
                }
                com.baidu.swan.apps.inlinewidget.f.b.b.nY("1");
                HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
                pS.q("type", "1");
                pS.cm("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.ano().anp()));
                pS.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo ayS = this.cSV.aIv().ayS();
                if (ayS == null || ayS.bcs()) {
                    ayS = com.baidu.swan.pms.database.a.bci().xC(getAppId());
                }
                pS.f(new UbcFlowEvent("na_query_db"));
                this.dCz = com.baidu.swan.apps.u.f.a.m(ayS);
                this.dCv = (ayS == null || this.dCz) ? false : false;
                pS.f(new UbcFlowEvent("has_local_file").gp(true));
                if (this.dCz) {
                    n(ayS);
                    o(this.cSw);
                    pS.f(new UbcFlowEvent("update_icon").gp(true));
                }
                if (!this.dCz && com.baidu.swan.apps.u.f.a.a(this.cSw, aIv.getPage())) {
                    aIW();
                } else {
                    aIX();
                }
            }
        }
    }

    private void aIW() {
        HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
        pS.f(new UbcFlowEvent("updateForIndependentPkgStart").gp(true));
        if (DEBUG) {
            log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        }
        com.baidu.swan.apps.u.c.b aIQ = aIQ();
        String b2 = com.baidu.swan.apps.u.f.a.b(this.cSw, aIQ.getPage());
        aIQ.fU(true);
        aIQ.oK(b2);
        Bundle bundle = new Bundle();
        bundle.putLong("pms_update_expect_pkg_ver", this.cSw.versionCode);
        T(bundle);
        pS.f(new UbcFlowEvent("updateForIndependentPkgEnd").gp(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(final Bundle bundle) {
        HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
        pS.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").gp(true));
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
                bundle2.putInt("appFrameType", k.this.aIQ().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                if (k.DEBUG) {
                    k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).cJ(5000L));
            }
        });
        pS.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").gp(true));
    }

    private void aIX() {
        HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
        pS.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").gp(true));
        if (DEBUG) {
            log(this.cSw == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        }
        com.baidu.swan.apps.core.j.c mL = com.baidu.swan.apps.core.j.f.ard().mL(getAppId());
        long j = this.cSw == null ? -1L : this.cSw.versionCode;
        long j2 = mL != null ? mL.versionCode : -1L;
        boolean z = j2 > j;
        if (DEBUG) {
            log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (!z) {
            aIY();
            return;
        }
        rg("event_on_still_maintaining");
        pS.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").gp(true));
        com.baidu.swan.apps.core.j.f.ard().a(mL, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void i(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow pS2 = com.baidu.swan.apps.performance.i.pS("startup");
                pS2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").gp(true));
                k.this.o(pMSAppInfo);
                pS2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").gp(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void j(PMSAppInfo pMSAppInfo) {
                k.this.dCw = 5;
                k.this.j("KEY_PKG_STATE", "event_pms_check_finish", k.this.dCw);
                HybridUbcFlow pS2 = com.baidu.swan.apps.performance.i.pS("startup");
                pS2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").gp(true));
                if (k.DEBUG) {
                    k.log("预制包安装成功");
                }
                k.a(k.this.aIQ(), pMSAppInfo, false, false, true);
                k.this.n(pMSAppInfo);
                k.this.T(null);
                pS2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").gp(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i) {
                HybridUbcFlow pS2 = com.baidu.swan.apps.performance.i.pS("startup");
                pS2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").gp(true));
                if (k.DEBUG) {
                    k.log("预制包安装失败");
                }
                k.this.aIY();
                pS2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").gp(true));
            }
        });
        pS.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").gp(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIY() {
        d.aIn().rg("event_pms_check_start");
        final HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
        pS.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").gp(true));
        final com.baidu.swan.apps.u.c.b aIQ = aIQ();
        if (DEBUG) {
            log("预置包不可用");
        }
        boolean aIZ = aIZ();
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + aIZ);
        }
        if (!aIZ) {
            if (DEBUG) {
                log("可以直接打开小程序，异步从Server拉取新包");
            }
            this.dCw = 4;
            a(aIQ, this.cSw, false, false, false);
            this.dCw = this.dCx ? 3 : 4;
            T(null);
            j("KEY_PKG_STATE", "event_pms_check_finish", this.dCw);
            return;
        }
        if (DEBUG) {
            log("不能直接打开小程序，同步从Server拉取新包");
        }
        j("KEY_PKG_STATE", "event_pms_check_finish", this.dCw);
        a(this.cSV.aIv().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(aIQ, k.this.cSw, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aIQ.getAppFrameType());
        cVar.xQ("3");
        cVar.ds(this.cSw == null ? 0L : this.cSw.versionCode);
        cVar.dt(this.cSw != null ? this.cSw.appSign : 0L);
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(aIQ.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.xM(delAllParamsFromUrl);
        }
        pS.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").gp(true));
        i((i.a) new i.a("event_on_still_maintaining").aa(" event_params_pkg_update", this.dCz));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.cSV) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.utils.f fVar) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading set onPrepareDownload");
                }
                k.this.dCt = true;
                d.aIn().rg("event_pkg_download_start");
                super.a(fVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void aqe() {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                }
                k.this.dCt = false;
                d.aIn().rg("event_pkg_download_finish");
                super.aqe();
            }
        }.c(new com.baidu.swan.apps.ao.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: q */
            public void L(PMSAppInfo pMSAppInfo) {
                pS.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").gp(true));
                if (k.DEBUG) {
                    k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                k.this.n(pMSAppInfo);
                k.this.o(pMSAppInfo);
                pS.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").gp(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.al.a aVar, boolean z) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalFailed");
                }
                k.this.dCt = false;
                d.aIn().rg("event_pkg_download_finish");
                pS.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").gp(true));
                if (k.DEBUG) {
                    k.log("onFinalFailed");
                }
                com.baidu.swan.apps.al.e.aMQ().j(aVar);
                if (z) {
                    k.this.dCw = k.this.dCx ? 3 : 4;
                    k.this.j("KEY_PKG_STATE", "event_pms_check_finish", k.this.dCw);
                    k.this.e(aVar);
                } else {
                    if (aVar != null && aVar.aMI() == 1020) {
                        k.this.h(aVar);
                    }
                    k.this.hi(false);
                }
                pS.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").gp(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void f(PMSAppInfo pMSAppInfo) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalComplete");
                }
                k.this.dCt = false;
                k.this.dCw = k.this.dCv ? 2 : 0;
                k.this.dCw = k.this.dCx ? 1 : k.this.dCw;
                k.this.j("KEY_PKG_STATE", "event_pms_check_finish", k.this.dCw);
                pS.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").gp(true));
                if (k.DEBUG) {
                    k.log("onFinalComplete");
                }
                k.this.n(pMSAppInfo);
                k.this.f((com.baidu.swan.apps.al.a) null);
                pS.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").gp(true));
            }
        }).gT(this.dCx ? 2 : 1));
        pS.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").gp(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        d.aIn().g(str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(PMSAppInfo pMSAppInfo) {
        this.cSw = pMSAppInfo;
        this.cSV.aIv().l(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").bZ("mAppId", getAppId())).U("appFrameType", pMSAppInfo.appCategory);
            if (DEBUG) {
                log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                if (DEBUG) {
                    log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                }
                aVar.bZ("app_name", pMSAppInfo.appName);
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
                aVar.bZ("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.aa("event_flag_force_post", true);
            i(aVar);
        }
    }

    private boolean aIZ() {
        HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
        if (this.cSw == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            pS.cm("launch_state", String.valueOf(0));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
            return true;
        } else if (this.cSw.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.dCv = true;
            pS.cm("launch_state", String.valueOf(2));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cSw.bcr()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.dCv = true;
            pS.cm("launch_state", String.valueOf(2));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cSw.bcs()) {
            if (com.baidu.swan.apps.core.a.b.a.ano().lW(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                pS.cm("launch_state", String.valueOf(3));
                j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
            pS.cm("launch_state", String.valueOf(1));
            this.dCx = true;
            return true;
        } else {
            pS.cm("launch_state", String.valueOf(4));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.u.c.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.ayI().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.ayI().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.ayI().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.jr(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.dJw = z ? "1" : "0";
        fVar.dJy = z3 ? "1" : "0";
        fVar.dJx = z2 ? "1" : "0";
        long j = eVar.getLong("launch_interval", -1L);
        if (j >= 0 && j <= 5000) {
            fVar.t("launchInterval", Long.valueOf(j));
        }
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        final String ayE = eVar.ayE();
        final String string = eVar.ayI().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.8
            @Override // java.lang.Runnable
            public void run() {
                k.a(com.baidu.swan.apps.statistic.a.f.this, ayE, string);
            }
        }, "launchStatistic", 2);
    }

    public static void a(com.baidu.swan.apps.statistic.a.f fVar, String str, String str2) {
        JSONObject sq = com.baidu.swan.apps.statistic.h.sq(str);
        fVar.sA(str2);
        fVar.cl(sq);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private void a(boolean z, String str, com.baidu.swan.apps.al.a aVar) {
        if (this.cSw != null) {
            Context context = getContext();
            e aIs = e.aIs();
            if (aIs != null) {
                String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.azN().azp(), aIs.afB().getAppFrameType()), String.valueOf(aVar.aMM()));
                if (!com.baidu.swan.apps.t.a.axg().a(context, aIs.getAppKey(), aVar)) {
                    Intent intent = new Intent();
                    intent.putExtra("pms_db_info_onload", this.cSw);
                    intent.putExtra("swan_error_type", z ? "type_path_forbidden" : "type_app_forbidden");
                    ForbiddenInfo forbiddenInfo = new ForbiddenInfo(aIQ(), str, format);
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
            com.baidu.swan.apps.u.c.b aIQ = aIQ();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.jr(aIQ.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aIQ);
            fVar.t("status", "2");
            fVar.sA(aIQ.ayI().getString("ubc"));
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
        int appFrameType = aIQ().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 10002;
        }
        return 0;
    }

    private com.baidu.swan.apps.al.a jj(int i) {
        com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a();
        switch (i) {
            case 10001:
                aVar.cV(10L).cW(2902L).to("no aiapps info in database");
                break;
            case 10002:
                aVar.cV(10L).cW(27L).to("category not match");
                break;
            case 10003:
                aVar.cV(10L).cW(2107L).tm("app forbiddeon");
                break;
            case 10004:
                aVar.cV(10L).cW(48L).tm("path forbiddeon");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.swan.apps.al.a aVar) {
        if (f(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aIQ()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(com.baidu.swan.apps.al.a aVar) {
        HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
        pS.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").gp(true));
        if (!g(aVar)) {
            if (DEBUG) {
                log("updateInstalledPkgWithFinalCheck by null launchParams");
            }
            hi(false);
            return false;
        }
        pS.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").gp(true));
        b.a aIv = this.cSV.aIv();
        long td = com.baidu.swan.apps.swancore.b.td(aIv.ayN());
        long j = aIv.asb() != null ? aIv.asb().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + aIv.ayN() + " targetSwanVersion: " + td + " ,curSwanVersion: " + j);
        }
        if (td > j) {
            com.baidu.swan.apps.swancore.b.jx(aIv.getAppFrameType());
        }
        com.baidu.swan.apps.performance.i.pS("startup").cm("launch_type", String.valueOf(com.baidu.swan.apps.an.a.aMV()));
        if (aIv.getAppFrameType() == 0) {
            aJa();
        }
        pS.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").gp(true));
        hi(true);
        com.baidu.swan.apps.env.c ati = com.baidu.swan.apps.env.e.ath().ati();
        if (ati != null && ati.atb()) {
            ati.nc(getAppId());
        }
        return true;
    }

    private void aJa() {
        com.baidu.swan.apps.r.d.e(this.cSV);
    }

    private boolean g(com.baidu.swan.apps.al.a aVar) {
        com.baidu.swan.apps.performance.i.pS("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").gp(true));
        if (DEBUG) {
            log("updateInfoWithFinalCheck: mAppInfo=" + this.cSw);
        }
        if (this.cSw == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.al.a().cV(10L).cW(2902L).to("no pkg was installed");
            }
            com.baidu.swan.apps.al.e.aMQ().j(aVar);
            h(aVar);
            return false;
        }
        int p = p(this.cSw);
        if (p == 10001 || p == 10002) {
            if (aVar == null) {
                aVar = jj(p);
            }
            com.baidu.swan.apps.al.e.aMQ().j(aVar);
            h(aVar);
            return false;
        }
        aJb();
        if (p != 0) {
            com.baidu.swan.apps.al.a jj = jj(10003);
            com.baidu.swan.apps.al.e.aMQ().j(jj);
            a(false, (String) null, jj);
            com.baidu.swan.apps.performance.i.d(jj);
            com.baidu.swan.apps.t.a.axz().flush(false);
            return false;
        }
        if (com.baidu.swan.apps.scheme.actions.forbidden.a.aJB().rO(aIj().aIv().getPage())) {
            com.baidu.swan.apps.al.a jj2 = jj(10004);
            com.baidu.swan.apps.al.e.aMQ().j(jj2);
            a(true, com.baidu.swan.apps.scheme.actions.forbidden.a.aJB().aJC(), jj2);
            com.baidu.swan.apps.performance.i.d(jj2);
            com.baidu.swan.apps.t.a.axz().flush(false);
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
        com.baidu.swan.apps.u.c.b aIQ = aIQ();
        int appFrameType = aIQ.getAppFrameType();
        com.baidu.swan.apps.u.b.a.a((Context) com.baidu.swan.apps.t.a.awy(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.jr(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = com.baidu.pass.biometrics.face.liveness.c.a.p;
        fVar.t("errcode", String.valueOf(aVar.aMM()));
        fVar.t("msg", aVar.aML().toString());
        fVar.d(aIQ);
        fVar.sA(aIQ.ayI().getString("ubc"));
        fVar.cl(com.baidu.swan.apps.statistic.h.sq(aIQ.ayE()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.aMN()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().sw(com.baidu.swan.apps.statistic.h.jr(appFrameType)).i(aVar).sx(getAppId()).sy(aIQ.ayC()));
            aVar.aMO();
        }
        com.baidu.swan.apps.t.a.axz().flush(false);
    }

    private void aJb() {
        final b.a aIv = aIj().aIv();
        boolean z = (this.cSw == null || TextUtils.isEmpty(this.cSw.appId) || !TextUtils.equals(getAppId(), this.cSw.appId)) ? false : true;
        if (z) {
            aIv.k(this.cSw);
        }
        final int i = (z && this.cSw.appCategory == 1) ? 1 : 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aIv.hN(i);
        } else {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.9
                @Override // java.lang.Runnable
                public void run() {
                    aIv.hN(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void hi(boolean z) {
        this.dCs = false;
        this.dCu = z;
        this.cSw = null;
        if (DEBUG) {
            log("notifyMaintainFinish: " + z);
        }
        i((i.a) new i.a("event_on_pkg_maintain_finish").bZ("mAppId", this.cSV.id));
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.oO(this.dCy).aze();
        }
        this.dCy = "";
    }

    private Context getContext() {
        SwanAppActivity aIl = this.cSV.aIl();
        return (aIl == null || aIl.isDestroyed()) ? com.baidu.swan.apps.t.a.awy() : aIl;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a aFo = com.baidu.swan.apps.process.messaging.client.a.aFo();
        if (aFo == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.aEW());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.k(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        aFo.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes8.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void y(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.dqL.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean xz = com.baidu.swan.pms.c.xz(string);
            boolean xA = com.baidu.swan.pms.c.xA(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + xz + ", isInQueue: " + xA);
            }
            this.dqL.putBoolean("isDownloading", (xz || xA) ? true : true);
            finish();
        }
    }
}
