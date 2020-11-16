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
/* loaded from: classes7.dex */
public final class k extends m implements com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final e cLR;
    private PMSAppInfo cLs;
    private boolean drA;
    private boolean drB;
    private int drC;
    private boolean drD;
    String drE;
    private boolean drF;
    private boolean dry;
    private boolean drz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.dry = false;
        this.drz = false;
        this.drA = false;
        this.drB = false;
        this.drC = -1;
        this.drD = false;
        this.drE = "";
        this.drF = false;
        this.cLR = eVar;
    }

    public com.baidu.swan.apps.u.c.b aHl() {
        return this.cLR.aGQ();
    }

    public synchronized boolean aHm() {
        return this.dry;
    }

    public boolean aHn() {
        return this.drz;
    }

    public int aGT() {
        return this.drC;
    }

    public synchronized boolean aHo() {
        return this.drA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aHp() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.cLR.drb && !aHm() && !aHo()) {
                this.dry = true;
                com.baidu.swan.apps.performance.i.qD("startup").f(new UbcFlowEvent("maintain_start").fV(true));
                boolean z = 1 == this.cLR.aGQ().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.ara().ari()) {
                    rN("event_on_still_maintaining");
                }
                if (z) {
                    aHq();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void aHq() {
        final HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
        qD.f(new UbcFlowEvent("postExec-onhold").fV(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                qD.f(new UbcFlowEvent("postExec-run").fV(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.drC = 99;
            g("KEY_PKG_STATE", "event_pms_check_start", this.drC);
            b.a aGQ = this.cLR.aGQ();
            if (com.baidu.swan.apps.ad.a.a.aEj() || !TextUtils.isEmpty(aGQ.ayk()) || (DEBUG && aGQ.isDebug())) {
                gF(true);
            } else {
                this.drE = aGQ.ayo();
                if (DEBUG) {
                    com.baidu.swan.apps.u.e.a.pz(this.drE).pA("start");
                }
                com.baidu.swan.apps.inlinewidget.f.b.b.oL("1");
                HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
                qD.r("type", "1");
                qD.ch("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.amO().amP()));
                qD.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo ayl = this.cLR.aGQ().ayl();
                if (ayl == null || ayl.baK()) {
                    ayl = com.baidu.swan.pms.database.a.baA().yh(getAppId());
                }
                qD.f(new UbcFlowEvent("na_query_db"));
                this.drF = com.baidu.swan.apps.u.f.a.m(ayl);
                this.drB = (ayl == null || this.drF) ? false : false;
                qD.f(new UbcFlowEvent("has_local_file").fV(true));
                if (this.drF) {
                    n(ayl);
                    o(this.cLs);
                    qD.f(new UbcFlowEvent("update_icon").fV(true));
                }
                if (!this.drF && com.baidu.swan.apps.u.f.a.a(this.cLs, aGQ.getPage())) {
                    aHr();
                } else {
                    aHs();
                }
            }
        }
    }

    private void aHr() {
        HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
        qD.f(new UbcFlowEvent("updateForIndependentPkgStart").fV(true));
        if (DEBUG) {
            log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        }
        com.baidu.swan.apps.u.c.b aHl = aHl();
        String b = com.baidu.swan.apps.u.f.a.b(this.cLs, aHl.getPage());
        aHl.fA(true);
        aHl.pv(b);
        Bundle bundle = new Bundle();
        bundle.putLong("pms_update_expect_pkg_ver", this.cLs.versionCode);
        T(bundle);
        qD.f(new UbcFlowEvent("updateForIndependentPkgEnd").fV(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(final Bundle bundle) {
        HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
        qD.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").fV(true));
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
                bundle2.putInt("appFrameType", k.this.aHl().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                if (k.DEBUG) {
                    k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).cj(5000L));
            }
        });
        qD.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").fV(true));
    }

    private void aHs() {
        HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
        qD.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").fV(true));
        if (DEBUG) {
            log(this.cLs == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        }
        com.baidu.swan.apps.core.j.c nw = com.baidu.swan.apps.core.j.f.aqy().nw(getAppId());
        long j = this.cLs == null ? -1L : this.cLs.versionCode;
        long j2 = nw != null ? nw.versionCode : -1L;
        boolean z = j2 > j;
        if (DEBUG) {
            log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (!z) {
            aHt();
            return;
        }
        rN("event_on_still_maintaining");
        qD.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").fV(true));
        com.baidu.swan.apps.core.j.f.aqy().a(nw, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void i(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow qD2 = com.baidu.swan.apps.performance.i.qD("startup");
                qD2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").fV(true));
                k.this.o(pMSAppInfo);
                qD2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").fV(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void j(PMSAppInfo pMSAppInfo) {
                k.this.drC = 5;
                k.this.g("KEY_PKG_STATE", "event_pms_check_finish", k.this.drC);
                HybridUbcFlow qD2 = com.baidu.swan.apps.performance.i.qD("startup");
                qD2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").fV(true));
                if (k.DEBUG) {
                    k.log("预制包安装成功");
                }
                k.a(k.this.aHl(), pMSAppInfo, false, false, true);
                k.this.n(pMSAppInfo);
                k.this.T(null);
                qD2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").fV(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i) {
                HybridUbcFlow qD2 = com.baidu.swan.apps.performance.i.qD("startup");
                qD2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").fV(true));
                if (k.DEBUG) {
                    k.log("预制包安装失败");
                }
                k.this.aHt();
                qD2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").fV(true));
            }
        });
        qD.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").fV(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHt() {
        d.aGI().rN("event_pms_check_start");
        final HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
        qD.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").fV(true));
        final com.baidu.swan.apps.u.c.b aHl = aHl();
        if (DEBUG) {
            log("预置包不可用");
        }
        boolean aHu = aHu();
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + aHu);
        }
        if (!aHu) {
            if (DEBUG) {
                log("可以直接打开小程序，异步从Server拉取新包");
            }
            this.drC = 4;
            a(aHl, this.cLs, false, false, false);
            this.drC = this.drD ? 3 : 4;
            T(null);
            g("KEY_PKG_STATE", "event_pms_check_finish", this.drC);
            return;
        }
        if (DEBUG) {
            log("不能直接打开小程序，同步从Server拉取新包");
        }
        g("KEY_PKG_STATE", "event_pms_check_finish", this.drC);
        a(this.cLR.aGQ().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(aHl, k.this.cLs, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aHl.getAppFrameType());
        cVar.yv("3");
        cVar.cS(this.cLs == null ? 0L : this.cLs.versionCode);
        cVar.cT(this.cLs != null ? this.cLs.appSign : 0L);
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(aHl.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.yr(delAllParamsFromUrl);
        }
        qD.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").fV(true));
        i((i.a) new i.a("event_on_still_maintaining").Z(" event_params_pkg_update", this.drF));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.cLR) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.utils.f fVar) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading set onPrepareDownload");
                }
                k.this.drz = true;
                d.aGI().rN("event_pkg_download_start");
                super.a(fVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void apz() {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                }
                k.this.drz = false;
                d.aGI().rN("event_pkg_download_finish");
                super.apz();
            }
        }.c(new com.baidu.swan.apps.ap.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: q */
            public void M(PMSAppInfo pMSAppInfo) {
                qD.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").fV(true));
                if (k.DEBUG) {
                    k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                k.this.n(pMSAppInfo);
                k.this.o(pMSAppInfo);
                qD.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").fV(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.am.a aVar, boolean z) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalFailed");
                }
                k.this.drz = false;
                d.aGI().rN("event_pkg_download_finish");
                qD.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").fV(true));
                if (k.DEBUG) {
                    k.log("onFinalFailed");
                }
                com.baidu.swan.apps.am.e.aLl().j(aVar);
                if (z) {
                    k.this.drC = k.this.drD ? 3 : 4;
                    k.this.g("KEY_PKG_STATE", "event_pms_check_finish", k.this.drC);
                    k.this.e(aVar);
                } else {
                    if (aVar != null && aVar.aLd() == 1020) {
                        k.this.h(aVar);
                    }
                    k.this.gF(false);
                }
                qD.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").fV(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void f(PMSAppInfo pMSAppInfo) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalComplete");
                }
                k.this.drz = false;
                k.this.drC = k.this.drB ? 2 : 0;
                k.this.drC = k.this.drD ? 1 : k.this.drC;
                k.this.g("KEY_PKG_STATE", "event_pms_check_finish", k.this.drC);
                qD.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").fV(true));
                if (k.DEBUG) {
                    k.log("onFinalComplete");
                }
                k.this.n(pMSAppInfo);
                k.this.f((com.baidu.swan.apps.am.a) null);
                qD.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").fV(true));
            }
        }).ig(this.drD ? 2 : 1));
        qD.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").fV(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        d.aGI().f(str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(PMSAppInfo pMSAppInfo) {
        this.cLs = pMSAppInfo;
        this.cLR.aGQ().l(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").bU("mAppId", getAppId())).R("appFrameType", pMSAppInfo.appCategory);
            if (DEBUG) {
                log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                if (DEBUG) {
                    log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                }
                aVar.bU("app_name", pMSAppInfo.appName);
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
                aVar.bU("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.Z("event_flag_force_post", true);
            i(aVar);
        }
    }

    private boolean aHu() {
        HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
        if (this.cLs == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            qD.ch("launch_state", String.valueOf(0));
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
            return true;
        } else if (this.cLs.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.drB = true;
            qD.ch("launch_state", String.valueOf(2));
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cLs.baJ()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.drB = true;
            qD.ch("launch_state", String.valueOf(2));
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cLs.baK()) {
            if (com.baidu.swan.apps.core.a.b.a.amO().mH(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                qD.ch("launch_state", String.valueOf(3));
                g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
            qD.ch("launch_state", String.valueOf(1));
            this.drD = true;
            return true;
        } else {
            qD.ch("launch_state", String.valueOf(4));
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.u.c.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.ayb().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.ayb().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.ayb().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.ku(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.dyF = z ? "1" : "0";
        fVar.dyH = z3 ? "1" : "0";
        fVar.dyG = z2 ? "1" : "0";
        long j = eVar.getLong("launch_interval", -1L);
        if (j >= 0 && j <= 5000) {
            fVar.u("launchInterval", Long.valueOf(j));
        }
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        final String axX = eVar.axX();
        final String string = eVar.ayb().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.8
            @Override // java.lang.Runnable
            public void run() {
                k.a(com.baidu.swan.apps.statistic.a.f.this, axX, string);
            }
        }, "launchStatistic", 2);
    }

    public static void a(com.baidu.swan.apps.statistic.a.f fVar, String str, String str2) {
        JSONObject sY = com.baidu.swan.apps.statistic.h.sY(str);
        fVar.th(str2);
        fVar.cb(sY);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private void a(boolean z, String str, com.baidu.swan.apps.am.a aVar) {
        if (this.cLs != null) {
            Context context = getContext();
            e aGN = e.aGN();
            if (aGN != null) {
                String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.azg().ayI(), aGN.afg().getAppFrameType()), String.valueOf(aVar.aLh()));
                if (!com.baidu.swan.apps.t.a.awA().a(context, aGN.getAppKey(), aVar)) {
                    Intent intent = new Intent();
                    intent.putExtra("pms_db_info_onload", this.cLs);
                    intent.putExtra("swan_error_type", z ? "type_path_forbidden" : "type_app_forbidden");
                    ForbiddenInfo forbiddenInfo = new ForbiddenInfo(aHl(), str, format);
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
            com.baidu.swan.apps.u.c.b aHl = aHl();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.ku(aHl.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aHl);
            fVar.u("status", "2");
            fVar.th(aHl.ayb().getString("ubc"));
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
        int appFrameType = aHl().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 10002;
        }
        return 0;
    }

    private com.baidu.swan.apps.am.a kl(int i) {
        com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
        switch (i) {
            case 10001:
                aVar.cv(10L).cw(2902L).tV("no aiapps info in database");
                break;
            case 10002:
                aVar.cv(10L).cw(27L).tV("category not match");
                break;
            case 10003:
                aVar.cv(10L).cw(2107L).tT("app forbiddeon");
                break;
            case 10004:
                aVar.cv(10L).cw(48L).tT("path forbiddeon");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.swan.apps.am.a aVar) {
        if (f(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aHl()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(com.baidu.swan.apps.am.a aVar) {
        HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
        qD.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").fV(true));
        if (!g(aVar)) {
            if (DEBUG) {
                log("updateInstalledPkgWithFinalCheck by null launchParams");
            }
            gF(false);
            return false;
        }
        qD.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").fV(true));
        b.a aGQ = this.cLR.aGQ();
        long tK = com.baidu.swan.apps.swancore.b.tK(aGQ.ayg());
        long j = aGQ.arv() != null ? aGQ.arv().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + aGQ.ayg() + " targetSwanVersion: " + tK + " ,curSwanVersion: " + j);
        }
        if (tK > j) {
            com.baidu.swan.apps.swancore.b.kA(aGQ.getAppFrameType());
        }
        com.baidu.swan.apps.performance.i.qD("startup").ch("launch_type", String.valueOf(com.baidu.swan.apps.ao.a.aLq()));
        if (aGQ.getAppFrameType() == 0) {
            aHv();
        }
        qD.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").fV(true));
        gF(true);
        com.baidu.swan.apps.env.c asB = com.baidu.swan.apps.env.e.asA().asB();
        if (asB != null && asB.asu()) {
            asB.nN(getAppId());
        }
        return true;
    }

    private void aHv() {
        com.baidu.swan.apps.r.d.e(this.cLR);
    }

    private boolean g(com.baidu.swan.apps.am.a aVar) {
        com.baidu.swan.apps.performance.i.qD("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").fV(true));
        if (DEBUG) {
            log("updateInfoWithFinalCheck: mAppInfo=" + this.cLs);
        }
        if (this.cLs == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.am.a().cv(10L).cw(2902L).tV("no pkg was installed");
            }
            com.baidu.swan.apps.am.e.aLl().j(aVar);
            h(aVar);
            return false;
        }
        int p = p(this.cLs);
        if (p == 10001 || p == 10002) {
            if (aVar == null) {
                aVar = kl(p);
            }
            com.baidu.swan.apps.am.e.aLl().j(aVar);
            h(aVar);
            return false;
        }
        aHw();
        if (p != 0) {
            com.baidu.swan.apps.am.a kl = kl(10003);
            com.baidu.swan.apps.am.e.aLl().j(kl);
            a(false, (String) null, kl);
            com.baidu.swan.apps.performance.i.d(kl);
            com.baidu.swan.apps.t.a.awT().flush(false);
            return false;
        }
        if (com.baidu.swan.apps.scheme.actions.forbidden.a.aHW().sw(aGE().aGQ().getPage())) {
            com.baidu.swan.apps.am.a kl2 = kl(10004);
            com.baidu.swan.apps.am.e.aLl().j(kl2);
            a(true, com.baidu.swan.apps.scheme.actions.forbidden.a.aHW().aHX(), kl2);
            com.baidu.swan.apps.performance.i.d(kl2);
            com.baidu.swan.apps.t.a.awT().flush(false);
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
        com.baidu.swan.apps.u.c.b aHl = aHl();
        int appFrameType = aHl.getAppFrameType();
        com.baidu.swan.apps.u.b.a.a((Context) com.baidu.swan.apps.t.a.avS(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.ku(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = "fail";
        fVar.u("errcode", String.valueOf(aVar.aLh()));
        fVar.u("msg", aVar.aLg().toString());
        fVar.d(aHl);
        fVar.th(aHl.ayb().getString("ubc"));
        fVar.cb(com.baidu.swan.apps.statistic.h.sY(aHl.axX()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.aLi()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().td(com.baidu.swan.apps.statistic.h.ku(appFrameType)).i(aVar).te(getAppId()).tf(aHl.axV()));
            aVar.aLj();
        }
        com.baidu.swan.apps.t.a.awT().flush(false);
    }

    private void aHw() {
        final b.a aGQ = aGE().aGQ();
        boolean z = (this.cLs == null || TextUtils.isEmpty(this.cLs.appId) || !TextUtils.equals(getAppId(), this.cLs.appId)) ? false : true;
        if (z) {
            aGQ.k(this.cLs);
        }
        final int i = (z && this.cLs.appCategory == 1) ? 1 : 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aGQ.ja(i);
        } else {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.9
                @Override // java.lang.Runnable
                public void run() {
                    aGQ.ja(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void gF(boolean z) {
        this.dry = false;
        this.drA = z;
        this.cLs = null;
        if (DEBUG) {
            log("notifyMaintainFinish: " + z);
        }
        i((i.a) new i.a("event_on_pkg_maintain_finish").bU("mAppId", this.cLR.id));
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.pz(this.drE).ayx();
        }
        this.drE = "";
    }

    private Context getContext() {
        SwanAppActivity aGG = this.cLR.aGG();
        return (aGG == null || aGG.isDestroyed()) ? com.baidu.swan.apps.t.a.avS() : aGG;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a aEG = com.baidu.swan.apps.process.messaging.client.a.aEG();
        if (aEG == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.aEo());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.n(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        aEG.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes7.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void y(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.djC.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean ye = com.baidu.swan.pms.c.ye(string);
            boolean yf = com.baidu.swan.pms.c.yf(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + ye + ", isInQueue: " + yf);
            }
            this.djC.putBoolean("isDownloading", (ye || yf) ? true : true);
            finish();
        }
    }
}
