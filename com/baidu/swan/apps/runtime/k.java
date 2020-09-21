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
/* loaded from: classes3.dex */
public final class k extends m implements com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cSC;
    private boolean cSD;
    private boolean cSE;
    private boolean cSF;
    private int cSG;
    private boolean cSH;
    String cSI;
    private boolean cSJ;
    private final e cmV;
    private PMSAppInfo cmw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.cSC = false;
        this.cSD = false;
        this.cSE = false;
        this.cSF = false;
        this.cSG = -1;
        this.cSH = false;
        this.cSI = "";
        this.cSJ = false;
        this.cmV = eVar;
    }

    public com.baidu.swan.apps.u.c.b aAQ() {
        return this.cmV.aAv();
    }

    public synchronized boolean aAR() {
        return this.cSC;
    }

    public boolean aAS() {
        return this.cSD;
    }

    public int aAy() {
        return this.cSG;
    }

    public synchronized boolean aAT() {
        return this.cSE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aAU() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.cmV.cSg && !aAR() && !aAT()) {
                this.cSC = true;
                com.baidu.swan.apps.performance.i.pq("startup").f(new UbcFlowEvent("maintain_start").fa(true));
                boolean z = 1 == this.cmV.aAv().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.akC().akK()) {
                    qA("event_on_still_maintaining");
                }
                if (z) {
                    aAV();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void aAV() {
        final HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
        pq.f(new UbcFlowEvent("postExec-onhold").fa(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                pq.f(new UbcFlowEvent("postExec-run").fa(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.cSG = 99;
            f("KEY_PKG_STATE", "event_pms_check_start", this.cSG);
            b.a aAv = this.cmV.aAv();
            if (com.baidu.swan.apps.ad.a.a.axM() || !TextUtils.isEmpty(aAv.arM()) || (DEBUG && aAv.isDebug())) {
                fK(true);
            } else {
                this.cSI = aAv.arQ();
                if (DEBUG) {
                    com.baidu.swan.apps.u.e.a.ol(this.cSI).om("start");
                }
                com.baidu.swan.apps.inlinewidget.f.b.b.nw("1");
                HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
                pq.r("type", "1");
                pq.bW("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.agr().ags()));
                pq.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo arN = this.cmV.aAv().arN();
                if (arN == null || arN.aUp()) {
                    arN = com.baidu.swan.pms.database.a.aUf().wT(getAppId());
                }
                pq.f(new UbcFlowEvent("na_query_db"));
                this.cSJ = com.baidu.swan.apps.u.f.a.m(arN);
                this.cSF = (arN == null || this.cSJ) ? false : false;
                pq.f(new UbcFlowEvent("has_local_file").fa(true));
                if (this.cSJ) {
                    n(arN);
                    o(this.cmw);
                    pq.f(new UbcFlowEvent("update_icon").fa(true));
                }
                if (!this.cSJ && com.baidu.swan.apps.u.f.a.a(this.cmw, aAv.getPage())) {
                    aAW();
                } else {
                    aAX();
                }
            }
        }
    }

    private void aAW() {
        HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
        pq.f(new UbcFlowEvent("updateForIndependentPkgStart").fa(true));
        if (DEBUG) {
            log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        }
        com.baidu.swan.apps.u.c.b aAQ = aAQ();
        String b = com.baidu.swan.apps.u.f.a.b(this.cmw, aAQ.getPage());
        aAQ.eF(true);
        aAQ.oh(b);
        Bundle bundle = new Bundle();
        bundle.putLong("pms_update_expect_pkg_ver", this.cmw.versionCode);
        T(bundle);
        pq.f(new UbcFlowEvent("updateForIndependentPkgEnd").fa(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(final Bundle bundle) {
        HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
        pq.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").fa(true));
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
                bundle2.putInt("appFrameType", k.this.aAQ().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                if (k.DEBUG) {
                    k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).bD(5000L));
            }
        });
        pq.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").fa(true));
    }

    private void aAX() {
        HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
        pq.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").fa(true));
        if (DEBUG) {
            log(this.cmw == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        }
        com.baidu.swan.apps.core.j.c mi = com.baidu.swan.apps.core.j.f.aka().mi(getAppId());
        long j = this.cmw == null ? -1L : this.cmw.versionCode;
        long j2 = mi != null ? mi.versionCode : -1L;
        boolean z = j2 > j;
        if (DEBUG) {
            log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (!z) {
            aAY();
            return;
        }
        qA("event_on_still_maintaining");
        pq.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").fa(true));
        com.baidu.swan.apps.core.j.f.aka().a(mi, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void i(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow pq2 = com.baidu.swan.apps.performance.i.pq("startup");
                pq2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").fa(true));
                k.this.o(pMSAppInfo);
                pq2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").fa(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void j(PMSAppInfo pMSAppInfo) {
                k.this.cSG = 5;
                k.this.f("KEY_PKG_STATE", "event_pms_check_finish", k.this.cSG);
                HybridUbcFlow pq2 = com.baidu.swan.apps.performance.i.pq("startup");
                pq2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").fa(true));
                if (k.DEBUG) {
                    k.log("预制包安装成功");
                }
                k.a(k.this.aAQ(), pMSAppInfo, false, false, true);
                k.this.n(pMSAppInfo);
                k.this.T(null);
                pq2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").fa(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i) {
                HybridUbcFlow pq2 = com.baidu.swan.apps.performance.i.pq("startup");
                pq2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").fa(true));
                if (k.DEBUG) {
                    k.log("预制包安装失败");
                }
                k.this.aAY();
                pq2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").fa(true));
            }
        });
        pq.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").fa(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAY() {
        d.aAn().qA("event_pms_check_start");
        final HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
        pq.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").fa(true));
        final com.baidu.swan.apps.u.c.b aAQ = aAQ();
        if (DEBUG) {
            log("预置包不可用");
        }
        boolean aAZ = aAZ();
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + aAZ);
        }
        if (!aAZ) {
            if (DEBUG) {
                log("可以直接打开小程序，异步从Server拉取新包");
            }
            this.cSG = 4;
            a(aAQ, this.cmw, false, false, false);
            this.cSG = this.cSH ? 3 : 4;
            T(null);
            f("KEY_PKG_STATE", "event_pms_check_finish", this.cSG);
            return;
        }
        if (DEBUG) {
            log("不能直接打开小程序，同步从Server拉取新包");
        }
        f("KEY_PKG_STATE", "event_pms_check_finish", this.cSG);
        a(this.cmV.aAv().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(aAQ, k.this.cmw, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aAQ.getAppFrameType());
        cVar.xh("3");
        cVar.cm(this.cmw == null ? 0L : this.cmw.versionCode);
        cVar.cn(this.cmw != null ? this.cmw.appSign : 0L);
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(aAQ.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.xd(delAllParamsFromUrl);
        }
        pq.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").fa(true));
        i((i.a) new i.a("event_on_still_maintaining").T(" event_params_pkg_update", this.cSJ));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.cmV) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.utils.f fVar) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading set onPrepareDownload");
                }
                k.this.cSD = true;
                d.aAn().qA("event_pkg_download_start");
                super.a(fVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void ajb() {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                }
                k.this.cSD = false;
                d.aAn().qA("event_pkg_download_finish");
                super.ajb();
            }
        }.c(new com.baidu.swan.apps.ap.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: q */
            public void J(PMSAppInfo pMSAppInfo) {
                pq.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").fa(true));
                if (k.DEBUG) {
                    k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                k.this.n(pMSAppInfo);
                k.this.o(pMSAppInfo);
                pq.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").fa(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.am.a aVar, boolean z) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalFailed");
                }
                k.this.cSD = false;
                d.aAn().qA("event_pkg_download_finish");
                pq.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").fa(true));
                if (k.DEBUG) {
                    k.log("onFinalFailed");
                }
                com.baidu.swan.apps.am.e.aEQ().j(aVar);
                if (z) {
                    k.this.cSG = k.this.cSH ? 3 : 4;
                    k.this.f("KEY_PKG_STATE", "event_pms_check_finish", k.this.cSG);
                    k.this.e(aVar);
                } else {
                    if (aVar != null && aVar.aEI() == 1020) {
                        k.this.h(aVar);
                    }
                    k.this.fK(false);
                }
                pq.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").fa(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void f(PMSAppInfo pMSAppInfo) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalComplete");
                }
                k.this.cSD = false;
                k.this.cSG = k.this.cSF ? 2 : 0;
                k.this.cSG = k.this.cSH ? 1 : k.this.cSG;
                k.this.f("KEY_PKG_STATE", "event_pms_check_finish", k.this.cSG);
                pq.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").fa(true));
                if (k.DEBUG) {
                    k.log("onFinalComplete");
                }
                k.this.n(pMSAppInfo);
                k.this.f((com.baidu.swan.apps.am.a) null);
                pq.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").fa(true));
            }
        }).hs(this.cSH ? 2 : 1));
        pq.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").fa(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        d.aAn().f(str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(PMSAppInfo pMSAppInfo) {
        this.cmw = pMSAppInfo;
        this.cmV.aAv().l(pMSAppInfo);
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

    private boolean aAZ() {
        HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
        if (this.cmw == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            pq.bW("launch_state", String.valueOf(0));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
            return true;
        } else if (this.cmw.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.cSF = true;
            pq.bW("launch_state", String.valueOf(2));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cmw.aUo()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.cSF = true;
            pq.bW("launch_state", String.valueOf(2));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cmw.aUp()) {
            if (com.baidu.swan.apps.core.a.b.a.agr().lt(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                pq.bW("launch_state", String.valueOf(3));
                f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
            pq.bW("launch_state", String.valueOf(1));
            this.cSH = true;
            return true;
        } else {
            pq.bW("launch_state", String.valueOf(4));
            f("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.u.c.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.arD().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.arD().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.arD().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.jG(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.cZI = z ? "1" : "0";
        fVar.cZK = z3 ? "1" : "0";
        fVar.cZJ = z2 ? "1" : "0";
        long j = eVar.getLong("launch_interval", -1L);
        if (j >= 0 && j <= 5000) {
            fVar.u("launchInterval", Long.valueOf(j));
        }
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        final String arz = eVar.arz();
        final String string = eVar.arD().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.8
            @Override // java.lang.Runnable
            public void run() {
                k.a(com.baidu.swan.apps.statistic.a.f.this, arz, string);
            }
        }, "launchStatistic", 2);
    }

    public static void a(com.baidu.swan.apps.statistic.a.f fVar, String str, String str2) {
        JSONObject rJ = com.baidu.swan.apps.statistic.h.rJ(str);
        fVar.rS(str2);
        fVar.bR(rJ);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private void a(boolean z, String str, com.baidu.swan.apps.am.a aVar) {
        if (this.cmw != null) {
            Context context = getContext();
            e aAs = e.aAs();
            if (aAs != null) {
                String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.asJ().ask(), aAs.YI().getAppFrameType()), String.valueOf(aVar.aEM()));
                if (!com.baidu.swan.apps.t.a.aqc().a(context, aAs.getAppKey(), aVar)) {
                    Intent intent = new Intent();
                    intent.putExtra("pms_db_info_onload", this.cmw);
                    intent.putExtra("swan_error_type", z ? "type_path_forbidden" : "type_app_forbidden");
                    ForbiddenInfo forbiddenInfo = new ForbiddenInfo(aAQ(), str, format);
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
            com.baidu.swan.apps.u.c.b aAQ = aAQ();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.jG(aAQ.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aAQ);
            fVar.u("status", "2");
            fVar.rS(aAQ.arD().getString("ubc"));
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
        int appFrameType = aAQ().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 10002;
        }
        return 0;
    }

    private com.baidu.swan.apps.am.a jx(int i) {
        com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
        switch (i) {
            case 10001:
                aVar.bP(10L).bQ(2902L).sH("no aiapps info in database");
                break;
            case 10002:
                aVar.bP(10L).bQ(27L).sH("category not match");
                break;
            case 10003:
                aVar.bP(10L).bQ(2107L).sF("app forbiddeon");
                break;
            case 10004:
                aVar.bP(10L).bQ(48L).sF("path forbiddeon");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.swan.apps.am.a aVar) {
        if (f(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aAQ()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(com.baidu.swan.apps.am.a aVar) {
        HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
        pq.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").fa(true));
        if (!g(aVar)) {
            if (DEBUG) {
                log("updateInstalledPkgWithFinalCheck by null launchParams");
            }
            fK(false);
            return false;
        }
        pq.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").fa(true));
        b.a aAv = this.cmV.aAv();
        long sw = com.baidu.swan.apps.swancore.b.sw(aAv.arI());
        long j = aAv.akX() != null ? aAv.akX().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + aAv.arI() + " targetSwanVersion: " + sw + " ,curSwanVersion: " + j);
        }
        if (sw > j) {
            com.baidu.swan.apps.swancore.b.jM(aAv.getAppFrameType());
        }
        com.baidu.swan.apps.performance.i.pq("startup").bW("launch_type", String.valueOf(com.baidu.swan.apps.ao.a.aEV()));
        if (aAv.getAppFrameType() == 0) {
            aBa();
        }
        pq.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").fa(true));
        fK(true);
        com.baidu.swan.apps.env.c amc = com.baidu.swan.apps.env.e.amb().amc();
        if (amc != null && amc.alV()) {
            amc.mA(getAppId());
        }
        return true;
    }

    private void aBa() {
        com.baidu.swan.apps.r.d.e(this.cmV);
    }

    private boolean g(com.baidu.swan.apps.am.a aVar) {
        com.baidu.swan.apps.performance.i.pq("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").fa(true));
        if (DEBUG) {
            log("updateInfoWithFinalCheck: mAppInfo=" + this.cmw);
        }
        if (this.cmw == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.am.a().bP(10L).bQ(2902L).sH("no pkg was installed");
            }
            com.baidu.swan.apps.am.e.aEQ().j(aVar);
            h(aVar);
            return false;
        }
        int p = p(this.cmw);
        if (p == 10001 || p == 10002) {
            if (aVar == null) {
                aVar = jx(p);
            }
            com.baidu.swan.apps.am.e.aEQ().j(aVar);
            h(aVar);
            return false;
        }
        aBb();
        if (p != 0) {
            com.baidu.swan.apps.am.a jx = jx(10003);
            com.baidu.swan.apps.am.e.aEQ().j(jx);
            a(false, (String) null, jx);
            com.baidu.swan.apps.performance.i.d(jx);
            com.baidu.swan.apps.t.a.aqv().flush(false);
            return false;
        }
        if (com.baidu.swan.apps.scheme.actions.forbidden.a.aBB().rh(aAj().aAv().getPage())) {
            com.baidu.swan.apps.am.a jx2 = jx(10004);
            com.baidu.swan.apps.am.e.aEQ().j(jx2);
            a(true, com.baidu.swan.apps.scheme.actions.forbidden.a.aBB().aBC(), jx2);
            com.baidu.swan.apps.performance.i.d(jx2);
            com.baidu.swan.apps.t.a.aqv().flush(false);
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
        com.baidu.swan.apps.u.c.b aAQ = aAQ();
        int appFrameType = aAQ.getAppFrameType();
        com.baidu.swan.apps.u.b.a.a((Context) com.baidu.swan.apps.t.a.apu(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.jG(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = "fail";
        fVar.u("errcode", String.valueOf(aVar.aEM()));
        fVar.u("msg", aVar.aEL().toString());
        fVar.d(aAQ);
        fVar.rS(aAQ.arD().getString("ubc"));
        fVar.bR(com.baidu.swan.apps.statistic.h.rJ(aAQ.arz()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.aEN()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().rO(com.baidu.swan.apps.statistic.h.jG(appFrameType)).i(aVar).rP(getAppId()).rQ(aAQ.arx()));
            aVar.aEO();
        }
        com.baidu.swan.apps.t.a.aqv().flush(false);
    }

    private void aBb() {
        final b.a aAv = aAj().aAv();
        boolean z = (this.cmw == null || TextUtils.isEmpty(this.cmw.appId) || !TextUtils.equals(getAppId(), this.cmw.appId)) ? false : true;
        if (z) {
            aAv.k(this.cmw);
        }
        final int i = (z && this.cmw.appCategory == 1) ? 1 : 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aAv.im(i);
        } else {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.9
                @Override // java.lang.Runnable
                public void run() {
                    aAv.im(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void fK(boolean z) {
        this.cSC = false;
        this.cSE = z;
        this.cmw = null;
        if (DEBUG) {
            log("notifyMaintainFinish: " + z);
        }
        i((i.a) new i.a("event_on_pkg_maintain_finish").bJ("mAppId", this.cmV.id));
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.ol(this.cSI).arZ();
        }
        this.cSI = "";
    }

    private Context getContext() {
        SwanAppActivity aAl = this.cmV.aAl();
        return (aAl == null || aAl.isDestroyed()) ? com.baidu.swan.apps.t.a.apu() : aAl;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a ayl = com.baidu.swan.apps.process.messaging.client.a.ayl();
        if (ayl == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.axR());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.n(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        ayl.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void y(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.cKK.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean wQ = com.baidu.swan.pms.c.wQ(string);
            boolean wR = com.baidu.swan.pms.c.wR(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + wQ + ", isInQueue: " + wR);
            }
            this.cKK.putBoolean("isDownloading", (wQ || wR) ? true : true);
            finish();
        }
    }
}
