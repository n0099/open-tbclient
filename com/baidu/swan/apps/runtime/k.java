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
    private final e cWI;
    private PMSAppInfo cWj;
    private boolean dFX;
    private boolean dFY;
    private boolean dFZ;
    private boolean dGa;
    private int dGb;
    private boolean dGc;
    String dGd;
    private boolean dGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.dFX = false;
        this.dFY = false;
        this.dFZ = false;
        this.dGa = false;
        this.dGb = -1;
        this.dGc = false;
        this.dGd = "";
        this.dGe = false;
        this.cWI = eVar;
    }

    public com.baidu.swan.apps.u.c.b aJm() {
        return this.cWI.aIR();
    }

    public synchronized boolean aJn() {
        return this.dFX;
    }

    public boolean aJo() {
        return this.dFY;
    }

    public int aIU() {
        return this.dGb;
    }

    public synchronized boolean aJp() {
        return this.dFZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aJq() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.cWI.dFB && !aJn() && !aJp()) {
                this.dFX = true;
                com.baidu.swan.apps.performance.i.qr("startup").f(new UbcFlowEvent("maintain_start").gr(true));
                boolean z = 1 == this.cWI.aIR().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.ash().asq()) {
                    rG("event_on_still_maintaining");
                }
                if (z) {
                    aJr();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void aJr() {
        final HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
        qr.f(new UbcFlowEvent("postExec-onhold").gr(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                qr.f(new UbcFlowEvent("postExec-run").gr(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.dGb = 99;
            j("KEY_PKG_STATE", "event_pms_check_start", this.dGb);
            b.a aIR = this.cWI.aIR();
            if (com.baidu.swan.apps.ad.a.a.aFp() || !TextUtils.isEmpty(aIR.azs()) || (DEBUG && aIR.isDebug())) {
                hk(true);
            } else {
                this.dGd = aIR.azw();
                if (DEBUG) {
                    com.baidu.swan.apps.u.e.a.pn(this.dGd).po("start");
                }
                com.baidu.swan.apps.inlinewidget.f.b.b.oz("1");
                HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
                qr.p("type", "1");
                qr.cg("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.anP().anQ()));
                qr.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo azt = this.cWI.aIR().azt();
                if (azt == null || azt.bcH()) {
                    azt = com.baidu.swan.pms.database.a.bcx().yc(getAppId());
                }
                qr.f(new UbcFlowEvent("na_query_db"));
                this.dGe = com.baidu.swan.apps.u.f.a.m(azt);
                this.dGa = (azt == null || this.dGe) ? false : false;
                qr.f(new UbcFlowEvent("has_local_file").gr(true));
                if (this.dGe) {
                    n(azt);
                    o(this.cWj);
                    qr.f(new UbcFlowEvent("update_icon").gr(true));
                }
                if (!this.dGe && com.baidu.swan.apps.u.f.a.a(this.cWj, aIR.getPage())) {
                    aJs();
                } else {
                    aJt();
                }
            }
        }
    }

    private void aJs() {
        HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
        qr.f(new UbcFlowEvent("updateForIndependentPkgStart").gr(true));
        if (DEBUG) {
            log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        }
        com.baidu.swan.apps.u.c.b aJm = aJm();
        String b = com.baidu.swan.apps.u.f.a.b(this.cWj, aJm.getPage());
        aJm.fW(true);
        aJm.pj(b);
        Bundle bundle = new Bundle();
        bundle.putLong("pms_update_expect_pkg_ver", this.cWj.versionCode);
        T(bundle);
        qr.f(new UbcFlowEvent("updateForIndependentPkgEnd").gr(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(final Bundle bundle) {
        HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
        qr.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").gr(true));
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
                bundle2.putInt("appFrameType", k.this.aJm().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                if (k.DEBUG) {
                    k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                com.baidu.swan.apps.process.messaging.a.aFC().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).cP(5000L));
            }
        });
        qr.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").gr(true));
    }

    private void aJt() {
        HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
        qr.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").gr(true));
        if (DEBUG) {
            log(this.cWj == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        }
        com.baidu.swan.apps.core.j.c nk = com.baidu.swan.apps.core.j.f.arE().nk(getAppId());
        long j = this.cWj == null ? -1L : this.cWj.versionCode;
        long j2 = nk != null ? nk.versionCode : -1L;
        boolean z = j2 > j;
        if (DEBUG) {
            log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (!z) {
            aJu();
            return;
        }
        rG("event_on_still_maintaining");
        qr.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").gr(true));
        com.baidu.swan.apps.core.j.f.arE().a(nk, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void i(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow qr2 = com.baidu.swan.apps.performance.i.qr("startup");
                qr2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").gr(true));
                k.this.o(pMSAppInfo);
                qr2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").gr(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void j(PMSAppInfo pMSAppInfo) {
                k.this.dGb = 5;
                k.this.j("KEY_PKG_STATE", "event_pms_check_finish", k.this.dGb);
                HybridUbcFlow qr2 = com.baidu.swan.apps.performance.i.qr("startup");
                qr2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").gr(true));
                if (k.DEBUG) {
                    k.log("预制包安装成功");
                }
                k.a(k.this.aJm(), pMSAppInfo, false, false, true);
                k.this.n(pMSAppInfo);
                k.this.T(null);
                qr2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").gr(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i) {
                HybridUbcFlow qr2 = com.baidu.swan.apps.performance.i.qr("startup");
                qr2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").gr(true));
                if (k.DEBUG) {
                    k.log("预制包安装失败");
                }
                k.this.aJu();
                qr2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").gr(true));
            }
        });
        qr.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").gr(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJu() {
        d.aIJ().rG("event_pms_check_start");
        final HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
        qr.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").gr(true));
        final com.baidu.swan.apps.u.c.b aJm = aJm();
        if (DEBUG) {
            log("预置包不可用");
        }
        boolean aJv = aJv();
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + aJv);
        }
        if (!aJv) {
            if (DEBUG) {
                log("可以直接打开小程序，异步从Server拉取新包");
            }
            this.dGb = 4;
            a(aJm, this.cWj, false, false, false);
            this.dGb = this.dGc ? 3 : 4;
            T(null);
            j("KEY_PKG_STATE", "event_pms_check_finish", this.dGb);
            return;
        }
        if (DEBUG) {
            log("不能直接打开小程序，同步从Server拉取新包");
        }
        j("KEY_PKG_STATE", "event_pms_check_finish", this.dGb);
        a(this.cWI.aIR().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(aJm, k.this.cWj, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aJm.getAppFrameType());
        cVar.yq("3");
        cVar.dy(this.cWj == null ? 0L : this.cWj.versionCode);
        cVar.dz(this.cWj != null ? this.cWj.appSign : 0L);
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(aJm.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.ym(delAllParamsFromUrl);
        }
        qr.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").gr(true));
        i((i.a) new i.a("event_on_still_maintaining").Z(" event_params_pkg_update", this.dGe));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.cWI) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.utils.f fVar) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading set onPrepareDownload");
                }
                k.this.dFY = true;
                d.aIJ().rG("event_pkg_download_start");
                super.a(fVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void aqF() {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                }
                k.this.dFY = false;
                d.aIJ().rG("event_pkg_download_finish");
                super.aqF();
            }
        }.c(new com.baidu.swan.apps.ao.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: q */
            public void N(PMSAppInfo pMSAppInfo) {
                qr.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").gr(true));
                if (k.DEBUG) {
                    k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                k.this.n(pMSAppInfo);
                k.this.o(pMSAppInfo);
                qr.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").gr(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.al.a aVar, boolean z) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalFailed");
                }
                k.this.dFY = false;
                d.aIJ().rG("event_pkg_download_finish");
                qr.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").gr(true));
                if (k.DEBUG) {
                    k.log("onFinalFailed");
                }
                com.baidu.swan.apps.al.e.aNm().j(aVar);
                if (z) {
                    k.this.dGb = k.this.dGc ? 3 : 4;
                    k.this.j("KEY_PKG_STATE", "event_pms_check_finish", k.this.dGb);
                    k.this.e(aVar);
                } else {
                    if (aVar != null && aVar.aNe() == 1020) {
                        k.this.h(aVar);
                    }
                    k.this.hk(false);
                }
                qr.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").gr(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void f(PMSAppInfo pMSAppInfo) {
                if (k.DEBUG) {
                    k.log("mFlagDownloading reset onFinalComplete");
                }
                k.this.dFY = false;
                k.this.dGb = k.this.dGa ? 2 : 0;
                k.this.dGb = k.this.dGc ? 1 : k.this.dGb;
                k.this.j("KEY_PKG_STATE", "event_pms_check_finish", k.this.dGb);
                qr.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").gr(true));
                if (k.DEBUG) {
                    k.log("onFinalComplete");
                }
                k.this.n(pMSAppInfo);
                k.this.f((com.baidu.swan.apps.al.a) null);
                qr.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").gr(true));
            }
        }).gX(this.dGc ? 2 : 1));
        qr.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").gr(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        d.aIJ().g(str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(PMSAppInfo pMSAppInfo) {
        this.cWj = pMSAppInfo;
        this.cWI.aIR().l(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").bT("mAppId", getAppId())).X("appFrameType", pMSAppInfo.appCategory);
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

    private boolean aJv() {
        HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
        if (this.cWj == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            qr.cg("launch_state", String.valueOf(0));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
            return true;
        } else if (this.cWj.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.dGa = true;
            qr.cg("launch_state", String.valueOf(2));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cWj.bcG()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.dGa = true;
            qr.cg("launch_state", String.valueOf(2));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cWj.bcH()) {
            if (com.baidu.swan.apps.core.a.b.a.anP().mv(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                qr.cg("launch_state", String.valueOf(3));
                j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
            qr.cg("launch_state", String.valueOf(1));
            this.dGc = true;
            return true;
        } else {
            qr.cg("launch_state", String.valueOf(4));
            j("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.u.c.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.azj().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.azj().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.azj().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.jv(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.dNb = z ? "1" : "0";
        fVar.dNd = z3 ? "1" : "0";
        fVar.dNc = z2 ? "1" : "0";
        long j = eVar.getLong("launch_interval", -1L);
        if (j >= 0 && j <= 5000) {
            fVar.s("launchInterval", Long.valueOf(j));
        }
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        final String azf = eVar.azf();
        final String string = eVar.azj().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.8
            @Override // java.lang.Runnable
            public void run() {
                k.a(com.baidu.swan.apps.statistic.a.f.this, azf, string);
            }
        }, "launchStatistic", 2);
    }

    public static void a(com.baidu.swan.apps.statistic.a.f fVar, String str, String str2) {
        JSONObject sR = com.baidu.swan.apps.statistic.h.sR(str);
        fVar.ta(str2);
        fVar.ck(sR);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private void a(boolean z, String str, com.baidu.swan.apps.al.a aVar) {
        if (this.cWj != null) {
            Context context = getContext();
            e aIO = e.aIO();
            if (aIO != null) {
                String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.aAo().azQ(), aIO.agc().getAppFrameType()), String.valueOf(aVar.aNi()));
                if (!com.baidu.swan.apps.t.a.axH().a(context, aIO.getAppKey(), aVar)) {
                    Intent intent = new Intent();
                    intent.putExtra("pms_db_info_onload", this.cWj);
                    intent.putExtra("swan_error_type", z ? "type_path_forbidden" : "type_app_forbidden");
                    ForbiddenInfo forbiddenInfo = new ForbiddenInfo(aJm(), str, format);
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
            com.baidu.swan.apps.u.c.b aJm = aJm();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.jv(aJm.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aJm);
            fVar.s("status", "2");
            fVar.ta(aJm.azj().getString("ubc"));
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
        int appFrameType = aJm().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 10002;
        }
        return 0;
    }

    private com.baidu.swan.apps.al.a jn(int i) {
        com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a();
        switch (i) {
            case 10001:
                aVar.db(10L).dc(2902L).tO("no aiapps info in database");
                break;
            case 10002:
                aVar.db(10L).dc(27L).tO("category not match");
                break;
            case 10003:
                aVar.db(10L).dc(2107L).tM("app forbiddeon");
                break;
            case 10004:
                aVar.db(10L).dc(48L).tM("path forbiddeon");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.swan.apps.al.a aVar) {
        if (f(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aJm()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(com.baidu.swan.apps.al.a aVar) {
        HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
        qr.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").gr(true));
        if (!g(aVar)) {
            if (DEBUG) {
                log("updateInstalledPkgWithFinalCheck by null launchParams");
            }
            hk(false);
            return false;
        }
        qr.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").gr(true));
        b.a aIR = this.cWI.aIR();
        long tD = com.baidu.swan.apps.swancore.b.tD(aIR.azo());
        long j = aIR.asD() != null ? aIR.asD().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + aIR.azo() + " targetSwanVersion: " + tD + " ,curSwanVersion: " + j);
        }
        if (tD > j) {
            com.baidu.swan.apps.swancore.b.jB(aIR.getAppFrameType());
        }
        com.baidu.swan.apps.performance.i.qr("startup").cg("launch_type", String.valueOf(com.baidu.swan.apps.an.a.aNr()));
        if (aIR.getAppFrameType() == 0) {
            aJw();
        }
        qr.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").gr(true));
        hk(true);
        com.baidu.swan.apps.env.c atJ = com.baidu.swan.apps.env.e.atI().atJ();
        if (atJ != null && atJ.atC()) {
            atJ.nB(getAppId());
        }
        return true;
    }

    private void aJw() {
        com.baidu.swan.apps.r.d.e(this.cWI);
    }

    private boolean g(com.baidu.swan.apps.al.a aVar) {
        com.baidu.swan.apps.performance.i.qr("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").gr(true));
        if (DEBUG) {
            log("updateInfoWithFinalCheck: mAppInfo=" + this.cWj);
        }
        if (this.cWj == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.al.a().db(10L).dc(2902L).tO("no pkg was installed");
            }
            com.baidu.swan.apps.al.e.aNm().j(aVar);
            h(aVar);
            return false;
        }
        int p = p(this.cWj);
        if (p == 10001 || p == 10002) {
            if (aVar == null) {
                aVar = jn(p);
            }
            com.baidu.swan.apps.al.e.aNm().j(aVar);
            h(aVar);
            return false;
        }
        aJx();
        if (p != 0) {
            com.baidu.swan.apps.al.a jn = jn(10003);
            com.baidu.swan.apps.al.e.aNm().j(jn);
            a(false, (String) null, jn);
            com.baidu.swan.apps.performance.i.d(jn);
            com.baidu.swan.apps.t.a.aya().flush(false);
            return false;
        }
        if (com.baidu.swan.apps.scheme.actions.forbidden.a.aJX().so(aIF().aIR().getPage())) {
            com.baidu.swan.apps.al.a jn2 = jn(10004);
            com.baidu.swan.apps.al.e.aNm().j(jn2);
            a(true, com.baidu.swan.apps.scheme.actions.forbidden.a.aJX().aJY(), jn2);
            com.baidu.swan.apps.performance.i.d(jn2);
            com.baidu.swan.apps.t.a.aya().flush(false);
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
        com.baidu.swan.apps.u.c.b aJm = aJm();
        int appFrameType = aJm.getAppFrameType();
        com.baidu.swan.apps.u.b.a.a((Context) com.baidu.swan.apps.t.a.awZ(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.jv(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = com.baidu.pass.biometrics.face.liveness.c.a.p;
        fVar.s("errcode", String.valueOf(aVar.aNi()));
        fVar.s("msg", aVar.aNh().toString());
        fVar.d(aJm);
        fVar.ta(aJm.azj().getString("ubc"));
        fVar.ck(com.baidu.swan.apps.statistic.h.sR(aJm.azf()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.aNj()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().sW(com.baidu.swan.apps.statistic.h.jv(appFrameType)).i(aVar).sX(getAppId()).sY(aJm.azd()));
            aVar.aNk();
        }
        com.baidu.swan.apps.t.a.aya().flush(false);
    }

    private void aJx() {
        final b.a aIR = aIF().aIR();
        boolean z = (this.cWj == null || TextUtils.isEmpty(this.cWj.appId) || !TextUtils.equals(getAppId(), this.cWj.appId)) ? false : true;
        if (z) {
            aIR.k(this.cWj);
        }
        final int i = (z && this.cWj.appCategory == 1) ? 1 : 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aIR.hR(i);
        } else {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.9
                @Override // java.lang.Runnable
                public void run() {
                    aIR.hR(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void hk(boolean z) {
        this.dFX = false;
        this.dFZ = z;
        this.cWj = null;
        if (DEBUG) {
            log("notifyMaintainFinish: " + z);
        }
        i((i.a) new i.a("event_on_pkg_maintain_finish").bT("mAppId", this.cWI.id));
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.pn(this.dGd).azF();
        }
        this.dGd = "";
    }

    private Context getContext() {
        SwanAppActivity aIH = this.cWI.aIH();
        return (aIH == null || aIH.isDestroyed()) ? com.baidu.swan.apps.t.a.awZ() : aIH;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a aFM = com.baidu.swan.apps.process.messaging.client.a.aFM();
        if (aFM == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.aFu());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.m(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        aFM.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes8.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void y(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.duz.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean xZ = com.baidu.swan.pms.c.xZ(string);
            boolean ya = com.baidu.swan.pms.c.ya(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + xZ + ", isInQueue: " + ya);
            }
            this.duz.putBoolean("isDownloading", (xZ || ya) ? true : true);
            finish();
        }
    }
}
