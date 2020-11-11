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
    private final e cNB;
    private PMSAppInfo cNc;
    private boolean dtg;
    private boolean dth;
    private boolean dti;
    private boolean dtj;
    private int dtk;
    private boolean dtl;
    String dtm;
    private boolean dtn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.dtg = false;
        this.dth = false;
        this.dti = false;
        this.dtj = false;
        this.dtk = -1;
        this.dtl = false;
        this.dtm = "";
        this.dtn = false;
        this.cNB = eVar;
    }

    public com.baidu.swan.apps.u.c.b aHT() {
        return this.cNB.aHy();
    }

    public synchronized boolean aHU() {
        return this.dtg;
    }

    public boolean aHV() {
        return this.dth;
    }

    public int aHB() {
        return this.dtk;
    }

    public synchronized boolean aHW() {
        return this.dti;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aHX() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.cNB.dsK && !aHU() && !aHW()) {
                this.dtg = true;
                com.baidu.swan.apps.performance.i.qJ("startup").f(new UbcFlowEvent("maintain_start").fS(true));
                boolean z = 1 == this.cNB.aHy().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.arI().arQ()) {
                    rT("event_on_still_maintaining");
                }
                if (z) {
                    aHY();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void aHY() {
        final HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
        qJ.f(new UbcFlowEvent("postExec-onhold").fS(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                qJ.f(new UbcFlowEvent("postExec-run").fS(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.dtk = 99;
            g("KEY_PKG_STATE", "event_pms_check_start", this.dtk);
            b.a aHy = this.cNB.aHy();
            if (com.baidu.swan.apps.ad.a.a.aER() || !TextUtils.isEmpty(aHy.ayS()) || (DEBUG && aHy.isDebug())) {
                gC(true);
            } else {
                this.dtm = aHy.ayW();
                if (DEBUG) {
                    com.baidu.swan.apps.u.e.a.pF(this.dtm).pG("start");
                }
                com.baidu.swan.apps.inlinewidget.f.b.b.oR("1");
                HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
                qJ.r("type", "1");
                qJ.ci("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.anw().anx()));
                qJ.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo ayT = this.cNB.aHy().ayT();
                if (ayT == null || ayT.bbr()) {
                    ayT = com.baidu.swan.pms.database.a.bbh().ym(getAppId());
                }
                qJ.f(new UbcFlowEvent("na_query_db"));
                this.dtn = com.baidu.swan.apps.u.f.a.m(ayT);
                this.dtj = (ayT == null || this.dtn) ? false : false;
                qJ.f(new UbcFlowEvent("has_local_file").fS(true));
                if (this.dtn) {
                    n(ayT);
                    o(this.cNc);
                    qJ.f(new UbcFlowEvent("update_icon").fS(true));
                }
                if (!this.dtn && com.baidu.swan.apps.u.f.a.a(this.cNc, aHy.getPage())) {
                    aHZ();
                } else {
                    aIa();
                }
            }
        }
    }

    private void aHZ() {
        HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
        qJ.f(new UbcFlowEvent("updateForIndependentPkgStart").fS(true));
        if (DEBUG) {
            log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        }
        com.baidu.swan.apps.u.c.b aHT = aHT();
        String b = com.baidu.swan.apps.u.f.a.b(this.cNc, aHT.getPage());
        aHT.fx(true);
        aHT.pB(b);
        Bundle bundle = new Bundle();
        bundle.putLong("pms_update_expect_pkg_ver", this.cNc.versionCode);
        T(bundle);
        qJ.f(new UbcFlowEvent("updateForIndependentPkgEnd").fS(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(final Bundle bundle) {
        HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
        qJ.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").fS(true));
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
                bundle2.putInt("appFrameType", k.this.aHT().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                if (k.DEBUG) {
                    k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).cj(5000L));
            }
        });
        qJ.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").fS(true));
    }

    private void aIa() {
        HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
        qJ.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").fS(true));
        if (DEBUG) {
            log(this.cNc == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        }
        com.baidu.swan.apps.core.j.c nC = com.baidu.swan.apps.core.j.f.arg().nC(getAppId());
        long j = this.cNc == null ? -1L : this.cNc.versionCode;
        long j2 = nC != null ? nC.versionCode : -1L;
        boolean z = j2 > j;
        if (DEBUG) {
            log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (!z) {
            aIb();
            return;
        }
        rT("event_on_still_maintaining");
        qJ.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").fS(true));
        com.baidu.swan.apps.core.j.f.arg().a(nC, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void i(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow qJ2 = com.baidu.swan.apps.performance.i.qJ("startup");
                qJ2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").fS(true));
                k.this.o(pMSAppInfo);
                qJ2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").fS(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void j(PMSAppInfo pMSAppInfo) {
                k.this.dtk = 5;
                k.this.g("KEY_PKG_STATE", "event_pms_check_finish", k.this.dtk);
                HybridUbcFlow qJ2 = com.baidu.swan.apps.performance.i.qJ("startup");
                qJ2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").fS(true));
                if (k.DEBUG) {
                    k.log("预制包安装成功");
                }
                k.a(k.this.aHT(), pMSAppInfo, false, false, true);
                k.this.n(pMSAppInfo);
                k.this.T(null);
                qJ2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").fS(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i) {
                HybridUbcFlow qJ2 = com.baidu.swan.apps.performance.i.qJ("startup");
                qJ2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").fS(true));
                if (k.DEBUG) {
                    k.log("预制包安装失败");
                }
                k.this.aIb();
                qJ2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").fS(true));
            }
        });
        qJ.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").fS(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIb() {
        d.aHq().rT("event_pms_check_start");
        final HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
        qJ.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").fS(true));
        final com.baidu.swan.apps.u.c.b aHT = aHT();
        if (DEBUG) {
            log("预置包不可用");
        }
        boolean aIc = aIc();
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + aIc);
        }
        if (!aIc) {
            if (DEBUG) {
                log("可以直接打开小程序，异步从Server拉取新包");
            }
            this.dtk = 4;
            a(aHT, this.cNc, false, false, false);
            this.dtk = this.dtl ? 3 : 4;
            T(null);
            g("KEY_PKG_STATE", "event_pms_check_finish", this.dtk);
            return;
        }
        if (DEBUG) {
            log("不能直接打开小程序，同步从Server拉取新包");
        }
        g("KEY_PKG_STATE", "event_pms_check_finish", this.dtk);
        a(this.cNB.aHy().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(aHT, k.this.cNc, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aHT.getAppFrameType());
        cVar.yA("3");
        cVar.cS(this.cNc == null ? 0L : this.cNc.versionCode);
        cVar.cT(this.cNc != null ? this.cNc.appSign : 0L);
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(aHT.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.yw(delAllParamsFromUrl);
        }
        qJ.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").fS(true));
        i((i.a) new i.a("event_on_still_maintaining").Z(" event_params_pkg_update", this.dtn));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.cNB) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.utils.f fVar) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading set onPrepareDownload");
                }
                k.this.dth = true;
                d.aHq().rT("event_pkg_download_start");
                super.a(fVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void aqh() {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                }
                k.this.dth = false;
                d.aHq().rT("event_pkg_download_finish");
                super.aqh();
            }
        }.c(new com.baidu.swan.apps.ap.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: q */
            public void M(PMSAppInfo pMSAppInfo) {
                qJ.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").fS(true));
                if (k.DEBUG) {
                    k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                k.this.n(pMSAppInfo);
                k.this.o(pMSAppInfo);
                qJ.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").fS(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.am.a aVar, boolean z) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalFailed");
                }
                k.this.dth = false;
                d.aHq().rT("event_pkg_download_finish");
                qJ.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").fS(true));
                if (k.DEBUG) {
                    k.log("onFinalFailed");
                }
                com.baidu.swan.apps.am.e.aLT().j(aVar);
                if (z) {
                    k.this.dtk = k.this.dtl ? 3 : 4;
                    k.this.g("KEY_PKG_STATE", "event_pms_check_finish", k.this.dtk);
                    k.this.e(aVar);
                } else {
                    if (aVar != null && aVar.aLL() == 1020) {
                        k.this.h(aVar);
                    }
                    k.this.gC(false);
                }
                qJ.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").fS(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void f(PMSAppInfo pMSAppInfo) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalComplete");
                }
                k.this.dth = false;
                k.this.dtk = k.this.dtj ? 2 : 0;
                k.this.dtk = k.this.dtl ? 1 : k.this.dtk;
                k.this.g("KEY_PKG_STATE", "event_pms_check_finish", k.this.dtk);
                qJ.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").fS(true));
                if (k.DEBUG) {
                    k.log("onFinalComplete");
                }
                k.this.n(pMSAppInfo);
                k.this.f((com.baidu.swan.apps.am.a) null);
                qJ.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").fS(true));
            }
        }).ik(this.dtl ? 2 : 1));
        qJ.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").fS(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        d.aHq().f(str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(PMSAppInfo pMSAppInfo) {
        this.cNc = pMSAppInfo;
        this.cNB.aHy().l(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").bV("mAppId", getAppId())).R("appFrameType", pMSAppInfo.appCategory);
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

    private boolean aIc() {
        HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
        if (this.cNc == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            qJ.ci("launch_state", String.valueOf(0));
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
            return true;
        } else if (this.cNc.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.dtj = true;
            qJ.ci("launch_state", String.valueOf(2));
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cNc.bbq()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.dtj = true;
            qJ.ci("launch_state", String.valueOf(2));
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cNc.bbr()) {
            if (com.baidu.swan.apps.core.a.b.a.anw().mN(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                qJ.ci("launch_state", String.valueOf(3));
                g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
            qJ.ci("launch_state", String.valueOf(1));
            this.dtl = true;
            return true;
        } else {
            qJ.ci("launch_state", String.valueOf(4));
            g("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.u.c.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.ayJ().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.ayJ().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.ayJ().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.ky(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.dAm = z ? "1" : "0";
        fVar.dAo = z3 ? "1" : "0";
        fVar.dAn = z2 ? "1" : "0";
        long j = eVar.getLong("launch_interval", -1L);
        if (j >= 0 && j <= 5000) {
            fVar.u("launchInterval", Long.valueOf(j));
        }
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        final String ayF = eVar.ayF();
        final String string = eVar.ayJ().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.8
            @Override // java.lang.Runnable
            public void run() {
                k.a(com.baidu.swan.apps.statistic.a.f.this, ayF, string);
            }
        }, "launchStatistic", 2);
    }

    public static void a(com.baidu.swan.apps.statistic.a.f fVar, String str, String str2) {
        JSONObject td = com.baidu.swan.apps.statistic.h.td(str);
        fVar.tm(str2);
        fVar.ch(td);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private void a(boolean z, String str, com.baidu.swan.apps.am.a aVar) {
        if (this.cNc != null) {
            Context context = getContext();
            e aHv = e.aHv();
            if (aHv != null) {
                String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.azO().azq(), aHv.afO().getAppFrameType()), String.valueOf(aVar.aLP()));
                if (!com.baidu.swan.apps.t.a.axi().a(context, aHv.getAppKey(), aVar)) {
                    Intent intent = new Intent();
                    intent.putExtra("pms_db_info_onload", this.cNc);
                    intent.putExtra("swan_error_type", z ? "type_path_forbidden" : "type_app_forbidden");
                    ForbiddenInfo forbiddenInfo = new ForbiddenInfo(aHT(), str, format);
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
            com.baidu.swan.apps.u.c.b aHT = aHT();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.ky(aHT.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aHT);
            fVar.u("status", "2");
            fVar.tm(aHT.ayJ().getString("ubc"));
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
        int appFrameType = aHT().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 10002;
        }
        return 0;
    }

    private com.baidu.swan.apps.am.a kp(int i) {
        com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
        switch (i) {
            case 10001:
                aVar.cv(10L).cw(2902L).ua("no aiapps info in database");
                break;
            case 10002:
                aVar.cv(10L).cw(27L).ua("category not match");
                break;
            case 10003:
                aVar.cv(10L).cw(2107L).tY("app forbiddeon");
                break;
            case 10004:
                aVar.cv(10L).cw(48L).tY("path forbiddeon");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.swan.apps.am.a aVar) {
        if (f(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aHT()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(com.baidu.swan.apps.am.a aVar) {
        HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
        qJ.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").fS(true));
        if (!g(aVar)) {
            if (DEBUG) {
                log("updateInstalledPkgWithFinalCheck by null launchParams");
            }
            gC(false);
            return false;
        }
        qJ.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").fS(true));
        b.a aHy = this.cNB.aHy();
        long tP = com.baidu.swan.apps.swancore.b.tP(aHy.ayO());
        long j = aHy.asd() != null ? aHy.asd().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + aHy.ayO() + " targetSwanVersion: " + tP + " ,curSwanVersion: " + j);
        }
        if (tP > j) {
            com.baidu.swan.apps.swancore.b.kE(aHy.getAppFrameType());
        }
        com.baidu.swan.apps.performance.i.qJ("startup").ci("launch_type", String.valueOf(com.baidu.swan.apps.ao.a.aLY()));
        if (aHy.getAppFrameType() == 0) {
            aId();
        }
        qJ.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").fS(true));
        gC(true);
        com.baidu.swan.apps.env.c atj = com.baidu.swan.apps.env.e.ati().atj();
        if (atj != null && atj.atc()) {
            atj.nT(getAppId());
        }
        return true;
    }

    private void aId() {
        com.baidu.swan.apps.r.d.e(this.cNB);
    }

    private boolean g(com.baidu.swan.apps.am.a aVar) {
        com.baidu.swan.apps.performance.i.qJ("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").fS(true));
        if (DEBUG) {
            log("updateInfoWithFinalCheck: mAppInfo=" + this.cNc);
        }
        if (this.cNc == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.am.a().cv(10L).cw(2902L).ua("no pkg was installed");
            }
            com.baidu.swan.apps.am.e.aLT().j(aVar);
            h(aVar);
            return false;
        }
        int p = p(this.cNc);
        if (p == 10001 || p == 10002) {
            if (aVar == null) {
                aVar = kp(p);
            }
            com.baidu.swan.apps.am.e.aLT().j(aVar);
            h(aVar);
            return false;
        }
        aIe();
        if (p != 0) {
            com.baidu.swan.apps.am.a kp = kp(10003);
            com.baidu.swan.apps.am.e.aLT().j(kp);
            a(false, (String) null, kp);
            com.baidu.swan.apps.performance.i.d(kp);
            com.baidu.swan.apps.t.a.axB().flush(false);
            return false;
        }
        if (com.baidu.swan.apps.scheme.actions.forbidden.a.aIE().sB(aHm().aHy().getPage())) {
            com.baidu.swan.apps.am.a kp2 = kp(10004);
            com.baidu.swan.apps.am.e.aLT().j(kp2);
            a(true, com.baidu.swan.apps.scheme.actions.forbidden.a.aIE().aIF(), kp2);
            com.baidu.swan.apps.performance.i.d(kp2);
            com.baidu.swan.apps.t.a.axB().flush(false);
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
        com.baidu.swan.apps.u.c.b aHT = aHT();
        int appFrameType = aHT.getAppFrameType();
        com.baidu.swan.apps.u.b.a.a((Context) com.baidu.swan.apps.t.a.awA(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.ky(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = "fail";
        fVar.u("errcode", String.valueOf(aVar.aLP()));
        fVar.u("msg", aVar.aLO().toString());
        fVar.d(aHT);
        fVar.tm(aHT.ayJ().getString("ubc"));
        fVar.ch(com.baidu.swan.apps.statistic.h.td(aHT.ayF()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.aLQ()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().ti(com.baidu.swan.apps.statistic.h.ky(appFrameType)).i(aVar).tj(getAppId()).tk(aHT.ayD()));
            aVar.aLR();
        }
        com.baidu.swan.apps.t.a.axB().flush(false);
    }

    private void aIe() {
        final b.a aHy = aHm().aHy();
        boolean z = (this.cNc == null || TextUtils.isEmpty(this.cNc.appId) || !TextUtils.equals(getAppId(), this.cNc.appId)) ? false : true;
        if (z) {
            aHy.k(this.cNc);
        }
        final int i = (z && this.cNc.appCategory == 1) ? 1 : 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aHy.je(i);
        } else {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.9
                @Override // java.lang.Runnable
                public void run() {
                    aHy.je(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void gC(boolean z) {
        this.dtg = false;
        this.dti = z;
        this.cNc = null;
        if (DEBUG) {
            log("notifyMaintainFinish: " + z);
        }
        i((i.a) new i.a("event_on_pkg_maintain_finish").bV("mAppId", this.cNB.id));
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.pF(this.dtm).azf();
        }
        this.dtm = "";
    }

    private Context getContext() {
        SwanAppActivity aHo = this.cNB.aHo();
        return (aHo == null || aHo.isDestroyed()) ? com.baidu.swan.apps.t.a.awA() : aHo;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a aFo = com.baidu.swan.apps.process.messaging.client.a.aFo();
        if (aFo == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.aEW());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.n(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        aFo.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes10.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void y(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.dlj.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean yj = com.baidu.swan.pms.c.yj(string);
            boolean yk = com.baidu.swan.pms.c.yk(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + yj + ", isInQueue: " + yk);
            }
            this.dlj.putBoolean("isDownloading", (yj || yk) ? true : true);
            finish();
        }
    }
}
