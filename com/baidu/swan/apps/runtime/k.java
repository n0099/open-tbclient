package com.baidu.swan.apps.runtime;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class k extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cEM;
    private boolean cEN;
    private boolean cEO;
    private boolean cEP;
    private int cEQ;
    private boolean cER;
    String cES;
    private boolean cET;
    private final e ccW;
    private PMSAppInfo ccw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.cEM = false;
        this.cEN = false;
        this.cEO = false;
        this.cEP = false;
        this.cEQ = -1;
        this.cER = false;
        this.cES = "";
        this.cET = false;
        this.ccW = eVar;
    }

    public com.baidu.swan.apps.v.b.b aqm() {
        return this.ccW.apQ();
    }

    public synchronized boolean aqn() {
        return this.cEM;
    }

    public boolean aqo() {
        return this.cEN;
    }

    public int apT() {
        return this.cEQ;
    }

    public synchronized boolean aqp() {
        return this.cEO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aqq() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.ccW.cEq && !aqn() && !aqp()) {
                this.cEM = true;
                com.baidu.swan.apps.performance.g.mx("startup").f(new UbcFlowEvent("maintain_start").ez(true));
                boolean z = 1 == this.ccW.apQ().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.acr().acx()) {
                    nA("event_on_still_maintaining");
                }
                if (z) {
                    aqr();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void aqr() {
        final HybridUbcFlow mx = com.baidu.swan.apps.performance.g.mx("startup");
        mx.f(new UbcFlowEvent("postExec-onhold").ez(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                mx.f(new UbcFlowEvent("postExec-run").ez(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.cEQ = 99;
            b.a apQ = this.ccW.apQ();
            if (com.baidu.swan.apps.af.a.a.anx() || !TextUtils.isEmpty(apQ.aif())) {
                fj(true);
            } else {
                this.cES = apQ.aij();
                com.baidu.swan.apps.v.c.a.ls(this.cES).lt("start");
                HybridUbcFlow mx = com.baidu.swan.apps.performance.g.mx("startup");
                mx.r("type", "1");
                mx.bF("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.YG().YH()));
                mx.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo aig = this.ccW.apQ().aig();
                if (aig == null || aig.aHo()) {
                    aig = com.baidu.swan.pms.database.a.aHb().tn(getAppId());
                }
                mx.f(new UbcFlowEvent("na_query_db"));
                this.cET = com.baidu.swan.apps.v.d.a.j(aig);
                this.cEP = (aig == null || this.cET) ? false : false;
                mx.f(new UbcFlowEvent("has_local_file").ez(true));
                if (this.cET) {
                    k(aig);
                    l(this.ccw);
                    mx.f(new UbcFlowEvent("update_icon").ez(true));
                }
                if (!this.cET && com.baidu.swan.apps.v.d.a.a(this.ccw, apQ.getPage())) {
                    aqs();
                } else {
                    aqt();
                }
            }
        }
    }

    private void aqs() {
        HybridUbcFlow mx = com.baidu.swan.apps.performance.g.mx("startup");
        mx.f(new UbcFlowEvent("updateForIndependentPkgStart").ez(true));
        log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        com.baidu.swan.apps.v.b.b aqm = aqm();
        String bN = bN(String.valueOf(this.ccw.versionCode), aqm.getPage());
        aqm.eg(true);
        aqm.lo(bN);
        Bundle bundle = new Bundle();
        bundle.putInt("pms_update_expect_pkg_ver", this.ccw.versionCode);
        U(bundle);
        mx.f(new UbcFlowEvent("updateForIndependentPkgEnd").ez(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(final Bundle bundle) {
        HybridUbcFlow mx = com.baidu.swan.apps.performance.g.mx("startup");
        mx.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").ez(true));
        log("启动本地包，进程预处理-加载本地包-后台异步更新");
        c((com.baidu.swan.apps.an.a) null);
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.2
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                bundle2.putInt("appFrameType", k.this.aqm().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                com.baidu.swan.apps.process.messaging.a.anM().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).bk(5000L));
            }
        });
        mx.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").ez(true));
    }

    private void aqt() {
        HybridUbcFlow mx = com.baidu.swan.apps.performance.g.mx("startup");
        mx.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").ez(true));
        log(this.ccw == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        com.baidu.swan.apps.core.j.c jR = com.baidu.swan.apps.core.j.f.abN().jR(getAppId());
        int i = this.ccw == null ? -1 : this.ccw.versionCode;
        int i2 = jR != null ? jR.versionCode : -1;
        boolean z = i2 > i;
        log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)));
        if (!z) {
            aqu();
            return;
        }
        nA("event_on_still_maintaining");
        mx.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").ez(true));
        com.baidu.swan.apps.core.j.f.abN().a(jR, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void f(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow mx2 = com.baidu.swan.apps.performance.g.mx("startup");
                mx2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").ez(true));
                k.this.l(pMSAppInfo);
                mx2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").ez(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void g(PMSAppInfo pMSAppInfo) {
                k.this.cEQ = 5;
                HybridUbcFlow mx2 = com.baidu.swan.apps.performance.g.mx("startup");
                mx2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").ez(true));
                k.log("预制包安装成功");
                k.a(k.this.aqm(), pMSAppInfo, false, false, true);
                k.this.k(pMSAppInfo);
                k.this.U(null);
                mx2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").ez(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i3) {
                HybridUbcFlow mx2 = com.baidu.swan.apps.performance.g.mx("startup");
                mx2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").ez(true));
                k.log("预制包安装失败");
                k.this.aqu();
                mx2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").ez(true));
            }
        });
        mx.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").ez(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqu() {
        final HybridUbcFlow mx = com.baidu.swan.apps.performance.g.mx("startup");
        mx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").ez(true));
        final com.baidu.swan.apps.v.b.b aqm = aqm();
        log("预置包不可用");
        if (!aqv()) {
            log("可以直接打开小程序，异步从Server拉取新包");
            this.cEQ = 4;
            a(aqm, this.ccw, false, false, false);
            this.cEQ = this.cER ? 3 : 4;
            U(null);
            return;
        }
        log("不能直接打开小程序，同步从Server拉取新包");
        a(this.ccW.apQ().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(aqm, k.this.ccw, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aqm.getAppFrameType());
        cVar.tB("3");
        cVar.ju(this.ccw == null ? 0 : this.ccw.versionCode);
        cVar.bO(this.ccw == null ? 0L : this.ccw.appSign);
        String delAllParamsFromUrl = ah.delAllParamsFromUrl(aqm.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.tx(delAllParamsFromUrl);
        }
        mx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").ez(true));
        i((i.a) new i.a("event_on_still_maintaining").P(" event_params_pkg_update", this.cET));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.ccW) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.f.e eVar) {
                k.log("mFlagDownloading set onPrepareDownload");
                k.this.cEN = true;
                super.a(eVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void aaQ() {
                k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                k.this.cEN = false;
                super.aaQ();
            }
        }.b(new com.baidu.swan.apps.aq.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: n */
            public void H(PMSAppInfo pMSAppInfo) {
                mx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").ez(true));
                k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                k.this.k(pMSAppInfo);
                mx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").ez(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.an.a aVar, boolean z) {
                k.log("mFlagDownloading reset onFinalFailed");
                k.this.cEN = false;
                mx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").ez(true));
                k.log("onFinalFailed");
                com.baidu.swan.apps.an.e.atW().g(aVar);
                if (z) {
                    k.this.cEQ = k.this.cER ? 3 : 4;
                    k.this.b(aVar);
                } else {
                    if (aVar != null && aVar.atO() == 1020) {
                        k.this.e(aVar);
                    }
                    k.this.fj(false);
                }
                mx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").ez(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void d(PMSAppInfo pMSAppInfo) {
                k.log("mFlagDownloading reset onFinalComplete");
                k.this.cEN = false;
                k.this.cEQ = k.this.cEP ? 2 : 0;
                k.this.cEQ = k.this.cER ? 1 : k.this.cEQ;
                mx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").ez(true));
                k.log("onFinalComplete");
                k.this.k(pMSAppInfo);
                k.this.c((com.baidu.swan.apps.an.a) null);
                mx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").ez(true));
            }
        }));
        mx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").ez(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PMSAppInfo pMSAppInfo) {
        this.ccw = pMSAppInfo;
        this.ccW.apQ().i(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").bu("mAppId", getAppId())).M("appFrameType", pMSAppInfo.appCategory);
            log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                aVar.bu("app_name", pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                log("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                aVar.M(Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                log("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                aVar.bu("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.P("event_flag_force_post", true);
            i(aVar);
        }
    }

    private boolean aqv() {
        HybridUbcFlow mx = com.baidu.swan.apps.performance.g.mx("startup");
        if (this.ccw == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            mx.bF("launch_state", String.valueOf(0));
            return true;
        } else if (this.ccw.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.cEP = true;
            mx.bF("launch_state", String.valueOf(2));
            return true;
        } else if (this.ccw.aHn()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.cEP = true;
            mx.bF("launch_state", String.valueOf(2));
            return true;
        } else if (this.ccw.aHo()) {
            if (com.baidu.swan.apps.core.a.b.a.YG().jl(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                mx.bF("launch_state", String.valueOf(3));
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            mx.bF("launch_state", String.valueOf(1));
            this.cER = true;
            return true;
        } else {
            mx.bF("launch_state", String.valueOf(4));
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.v.b.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.ahW().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.ahW().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.ahW().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.hf(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.cLj = z ? "1" : "0";
        fVar.cLl = z3 ? "1" : "0";
        fVar.cLk = z2 ? "1" : "0";
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        JSONObject oF = com.baidu.swan.apps.statistic.h.oF(eVar.ahS());
        fVar.oO(eVar.ahW().getString("ubc"));
        fVar.bB(oF);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private String bN(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String pV = ah.pV(str2);
        String str3 = pV;
        int lastIndexOf = pV.lastIndexOf(File.separator);
        while (lastIndexOf != -1) {
            str3 = str3.substring(0, lastIndexOf);
            if (!com.baidu.swan.apps.r.e.E(getAppId(), str, str3)) {
                lastIndexOf = str3.lastIndexOf(File.separator);
            } else {
                return str3;
            }
        }
        return !com.baidu.swan.apps.r.e.E(getAppId(), str, str3) ? "" : str3;
    }

    private void aqw() {
        if (this.ccw != null) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.putExtra("pms_db_info_onload", this.ccw);
            intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            com.baidu.swan.apps.v.b.b aqm = aqm();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.hf(aqm.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aqm);
            fVar.v("status", "2");
            fVar.oO(aqm.ahW().getString("ubc"));
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
        }
    }

    private int m(@NonNull PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo.appStatus != 0) {
            return pMSAppInfo.appStatus;
        }
        if (TextUtils.isEmpty(pMSAppInfo.appId)) {
            return 1;
        }
        int appFrameType = aqm().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 2;
        }
        return 0;
    }

    private com.baidu.swan.apps.an.a gW(int i) {
        com.baidu.swan.apps.an.a aVar = new com.baidu.swan.apps.an.a();
        switch (i) {
            case 1:
                aVar.bw(10L).bx(2902L).pB("no aiapps info in database");
                break;
            case 2:
                aVar.bw(10L).bx(27L).pB("category not match");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.an.a aVar) {
        if (c(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().f(aVar).a(aqm()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.swan.apps.an.a aVar) {
        HybridUbcFlow mx = com.baidu.swan.apps.performance.g.mx("startup");
        mx.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").ez(true));
        if (!d(aVar)) {
            log("updateInstalledPkgWithFinalCheck by null launchParams");
            fj(false);
            return false;
        }
        mx.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").ez(true));
        b.a apQ = this.ccW.apQ();
        long pq = com.baidu.swan.apps.swancore.b.pq(apQ.aib());
        long j = apQ.acM() != null ? apQ.acM().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + apQ.aib() + " targetSwanVersion: " + pq + " ,curSwanVersion: " + j);
        }
        if (pq > j) {
            com.baidu.swan.apps.swancore.b.hl(apQ.getAppFrameType());
        }
        apQ.bt("extra_data_uid_key", com.baidu.swan.apps.u.a.agc().bc(getContext()));
        com.baidu.swan.apps.performance.g.mx("startup").bF("launch_type", String.valueOf(com.baidu.swan.apps.ap.a.aub()));
        if (apQ.getAppFrameType() == 0) {
            aqx();
        }
        mx.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").ez(true));
        fj(true);
        com.baidu.swan.apps.env.c adC = com.baidu.swan.apps.env.e.adB().adC();
        if (adC != null && adC.adw()) {
            adC.kj(getAppId());
        }
        return true;
    }

    private void aqx() {
        com.baidu.swan.apps.r.e.d(this.ccW);
    }

    private boolean d(com.baidu.swan.apps.an.a aVar) {
        com.baidu.swan.apps.performance.g.mx("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").ez(true));
        log("updateInfoWithFinalCheck: mAppInfo=" + this.ccw);
        if (this.ccw == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.an.a().bw(10L).bx(2902L).pB("no pkg was installed");
            }
            com.baidu.swan.apps.an.e.atW().g(aVar);
            e(aVar);
            com.baidu.swan.apps.performance.g.a(aVar);
            return false;
        }
        int m = m(this.ccw);
        if (m == 1 || m == 2) {
            com.baidu.swan.apps.an.a gW = gW(m);
            com.baidu.swan.apps.an.e.atW().g(gW);
            e(gW);
            com.baidu.swan.apps.performance.g.a(gW);
            return false;
        }
        aqy();
        if (m != 0) {
            com.baidu.swan.apps.an.a gW2 = gW(m);
            com.baidu.swan.apps.an.e.atW().g(gW2);
            aqw();
            com.baidu.swan.apps.performance.g.a(gW2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.swan.apps.an.a aVar) {
        com.baidu.swan.apps.performance.g.a(aVar);
        Context context = getContext();
        if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
            if (DEBUG) {
                Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                return;
            }
            return;
        }
        com.baidu.swan.apps.v.b.b aqm = aqm();
        int appFrameType = aqm.getAppFrameType();
        com.baidu.swan.apps.v.a.a.a(com.baidu.swan.apps.u.a.afX(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.hf(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = "fail";
        fVar.v("errcode", String.valueOf(aVar.atS()));
        fVar.v("msg", aVar.atR().toString());
        fVar.d(aqm);
        fVar.oO(aqm.ahW().getString("ubc"));
        fVar.bB(com.baidu.swan.apps.statistic.h.oF(aqm.ahS()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.atT()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().oK(com.baidu.swan.apps.statistic.h.hf(appFrameType)).f(aVar).oL(getAppId()).oM(aqm.ahQ()));
            aVar.atU();
        }
    }

    private void aqy() {
        int i = 1;
        b.a apQ = apE().apQ();
        boolean z = (this.ccw == null || TextUtils.isEmpty(this.ccw.appId) || !TextUtils.equals(getAppId(), this.ccw.appId)) ? false : true;
        if (z) {
            apQ.h(this.ccw);
        }
        if (!z || this.ccw.appCategory != 1) {
            i = 0;
        }
        apQ.fO(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void fj(boolean z) {
        this.cEM = false;
        this.cEO = z;
        this.ccw = null;
        log("notifyMaintainFinish: " + z);
        i((i.a) new i.a("event_on_pkg_maintain_finish").bu("mAppId", this.ccW.id));
        com.baidu.swan.apps.v.c.a.ls(this.cES).air();
        this.cES = "";
    }

    private Context getContext() {
        SwanAppActivity apG = this.ccW.apG();
        return (apG == null || apG.isDestroyed()) ? com.baidu.swan.apps.u.a.afX() : apG;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a anW = com.baidu.swan.apps.process.messaging.client.a.anW();
        if (anW == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.anC());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.m(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        anW.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes11.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void A(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.cxY.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean tl = com.baidu.swan.pms.c.tl(string);
            boolean tm = com.baidu.swan.pms.c.tm(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + tl + ", isInQueue: " + tm);
            }
            this.cxY.putBoolean("isDownloading", (tl || tm) ? true : true);
            finish();
        }
    }
}
