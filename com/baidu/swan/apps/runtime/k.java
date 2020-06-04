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
    private PMSAppInfo bXH;
    private final e bYh;
    private boolean cAc;
    private boolean cAd;
    private boolean cAe;
    private boolean cAf;
    private int cAg;
    private boolean cAh;
    String cAi;
    private boolean cAj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.cAc = false;
        this.cAd = false;
        this.cAe = false;
        this.cAf = false;
        this.cAg = -1;
        this.cAh = false;
        this.cAi = "";
        this.cAj = false;
        this.bYh = eVar;
    }

    public com.baidu.swan.apps.v.b.b apf() {
        return this.bYh.aoJ();
    }

    public synchronized boolean apg() {
        return this.cAc;
    }

    public boolean aph() {
        return this.cAd;
    }

    public int aoM() {
        return this.cAg;
    }

    public synchronized boolean apj() {
        return this.cAe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void apk() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.bYh.czG && !apg() && !apj()) {
                this.cAc = true;
                com.baidu.swan.apps.performance.g.mp("startup").f(new UbcFlowEvent("maintain_start").eu(true));
                boolean z = 1 == this.bYh.aoJ().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.abl().abr()) {
                    ns("event_on_still_maintaining");
                }
                if (z) {
                    apl();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void apl() {
        final HybridUbcFlow mp = com.baidu.swan.apps.performance.g.mp("startup");
        mp.f(new UbcFlowEvent("postExec-onhold").eu(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                mp.f(new UbcFlowEvent("postExec-run").eu(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.cAg = 99;
            b.a aoJ = this.bYh.aoJ();
            if (com.baidu.swan.apps.af.a.a.amr() || !TextUtils.isEmpty(aoJ.agZ())) {
                fe(true);
            } else {
                this.cAi = aoJ.ahd();
                com.baidu.swan.apps.v.c.a.lk(this.cAi).ll("start");
                HybridUbcFlow mp = com.baidu.swan.apps.performance.g.mp("startup");
                mp.r("type", "1");
                mp.bD("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.XA().XB()));
                mp.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo aha = this.bYh.aoJ().aha();
                if (aha == null || aha.aGi()) {
                    aha = com.baidu.swan.pms.database.a.aFV().tf(getAppId());
                }
                mp.f(new UbcFlowEvent("na_query_db"));
                this.cAj = com.baidu.swan.apps.v.d.a.j(aha);
                this.cAf = (aha == null || this.cAj) ? false : false;
                mp.f(new UbcFlowEvent("has_local_file").eu(true));
                if (this.cAj) {
                    k(aha);
                    l(this.bXH);
                    mp.f(new UbcFlowEvent("update_icon").eu(true));
                }
                if (!this.cAj && com.baidu.swan.apps.v.d.a.a(this.bXH, aoJ.getPage())) {
                    apm();
                } else {
                    apn();
                }
            }
        }
    }

    private void apm() {
        HybridUbcFlow mp = com.baidu.swan.apps.performance.g.mp("startup");
        mp.f(new UbcFlowEvent("updateForIndependentPkgStart").eu(true));
        log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        com.baidu.swan.apps.v.b.b apf = apf();
        String bL = bL(String.valueOf(this.bXH.versionCode), apf.getPage());
        apf.eb(true);
        apf.lg(bL);
        Bundle bundle = new Bundle();
        bundle.putInt("pms_update_expect_pkg_ver", this.bXH.versionCode);
        U(bundle);
        mp.f(new UbcFlowEvent("updateForIndependentPkgEnd").eu(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(final Bundle bundle) {
        HybridUbcFlow mp = com.baidu.swan.apps.performance.g.mp("startup");
        mp.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").eu(true));
        log("启动本地包，进程预处理-加载本地包-后台异步更新");
        c((com.baidu.swan.apps.an.a) null);
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.2
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                bundle2.putInt("appFrameType", k.this.apf().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).bk(5000L));
            }
        });
        mp.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").eu(true));
    }

    private void apn() {
        HybridUbcFlow mp = com.baidu.swan.apps.performance.g.mp("startup");
        mp.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").eu(true));
        log(this.bXH == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        com.baidu.swan.apps.core.j.c jJ = com.baidu.swan.apps.core.j.f.aaH().jJ(getAppId());
        int i = this.bXH == null ? -1 : this.bXH.versionCode;
        int i2 = jJ != null ? jJ.versionCode : -1;
        boolean z = i2 > i;
        log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)));
        if (!z) {
            apo();
            return;
        }
        ns("event_on_still_maintaining");
        mp.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").eu(true));
        com.baidu.swan.apps.core.j.f.aaH().a(jJ, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void f(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow mp2 = com.baidu.swan.apps.performance.g.mp("startup");
                mp2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").eu(true));
                k.this.l(pMSAppInfo);
                mp2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").eu(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void g(PMSAppInfo pMSAppInfo) {
                k.this.cAg = 5;
                HybridUbcFlow mp2 = com.baidu.swan.apps.performance.g.mp("startup");
                mp2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").eu(true));
                k.log("预制包安装成功");
                k.a(k.this.apf(), pMSAppInfo, false, false, true);
                k.this.k(pMSAppInfo);
                k.this.U(null);
                mp2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").eu(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i3) {
                HybridUbcFlow mp2 = com.baidu.swan.apps.performance.g.mp("startup");
                mp2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").eu(true));
                k.log("预制包安装失败");
                k.this.apo();
                mp2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").eu(true));
            }
        });
        mp.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").eu(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apo() {
        final HybridUbcFlow mp = com.baidu.swan.apps.performance.g.mp("startup");
        mp.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").eu(true));
        final com.baidu.swan.apps.v.b.b apf = apf();
        log("预置包不可用");
        if (!app()) {
            log("可以直接打开小程序，异步从Server拉取新包");
            this.cAg = 4;
            a(apf, this.bXH, false, false, false);
            this.cAg = this.cAh ? 3 : 4;
            U(null);
            return;
        }
        log("不能直接打开小程序，同步从Server拉取新包");
        a(this.bYh.aoJ().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(apf, k.this.bXH, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), apf.getAppFrameType());
        cVar.tt("3");
        cVar.jj(this.bXH == null ? 0 : this.bXH.versionCode);
        cVar.bO(this.bXH == null ? 0L : this.bXH.appSign);
        String delAllParamsFromUrl = ah.delAllParamsFromUrl(apf.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.tp(delAllParamsFromUrl);
        }
        mp.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").eu(true));
        i((i.a) new i.a("event_on_still_maintaining").N(" event_params_pkg_update", this.cAj));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.bYh) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.f.e eVar) {
                k.log("mFlagDownloading set onPrepareDownload");
                k.this.cAd = true;
                super.a(eVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void ZK() {
                k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                k.this.cAd = false;
                super.ZK();
            }
        }.b(new com.baidu.swan.apps.aq.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: n */
            public void H(PMSAppInfo pMSAppInfo) {
                mp.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").eu(true));
                k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                k.this.k(pMSAppInfo);
                mp.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").eu(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.an.a aVar, boolean z) {
                k.log("mFlagDownloading reset onFinalFailed");
                k.this.cAd = false;
                mp.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").eu(true));
                k.log("onFinalFailed");
                com.baidu.swan.apps.an.e.asQ().g(aVar);
                if (z) {
                    k.this.cAg = k.this.cAh ? 3 : 4;
                    k.this.b(aVar);
                } else {
                    if (aVar != null && aVar.asI() == 1020) {
                        k.this.e(aVar);
                    }
                    k.this.fe(false);
                }
                mp.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").eu(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void d(PMSAppInfo pMSAppInfo) {
                k.log("mFlagDownloading reset onFinalComplete");
                k.this.cAd = false;
                k.this.cAg = k.this.cAf ? 2 : 0;
                k.this.cAg = k.this.cAh ? 1 : k.this.cAg;
                mp.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").eu(true));
                k.log("onFinalComplete");
                k.this.k(pMSAppInfo);
                k.this.c((com.baidu.swan.apps.an.a) null);
                mp.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").eu(true));
            }
        }));
        mp.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").eu(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PMSAppInfo pMSAppInfo) {
        this.bXH = pMSAppInfo;
        this.bYh.aoJ().i(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").bs("mAppId", getAppId())).M("appFrameType", pMSAppInfo.appCategory);
            log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                aVar.bs("app_name", pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                log("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                aVar.M(Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                log("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                aVar.bs("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.N("event_flag_force_post", true);
            i(aVar);
        }
    }

    private boolean app() {
        HybridUbcFlow mp = com.baidu.swan.apps.performance.g.mp("startup");
        if (this.bXH == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            mp.bD("launch_state", String.valueOf(0));
            return true;
        } else if (this.bXH.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.cAf = true;
            mp.bD("launch_state", String.valueOf(2));
            return true;
        } else if (this.bXH.aGh()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.cAf = true;
            mp.bD("launch_state", String.valueOf(2));
            return true;
        } else if (this.bXH.aGi()) {
            if (com.baidu.swan.apps.core.a.b.a.XA().jd(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                mp.bD("launch_state", String.valueOf(3));
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            mp.bD("launch_state", String.valueOf(1));
            this.cAh = true;
            return true;
        } else {
            mp.bD("launch_state", String.valueOf(4));
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.v.b.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.agQ().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.agQ().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.agQ().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.gU(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.cGz = z ? "1" : "0";
        fVar.cGB = z3 ? "1" : "0";
        fVar.cGA = z2 ? "1" : "0";
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        JSONObject ox = com.baidu.swan.apps.statistic.h.ox(eVar.agM());
        fVar.oG(eVar.agQ().getString("ubc"));
        fVar.bu(ox);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private String bL(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String pN = ah.pN(str2);
        String str3 = pN;
        int lastIndexOf = pN.lastIndexOf(File.separator);
        while (lastIndexOf != -1) {
            str3 = str3.substring(0, lastIndexOf);
            if (!com.baidu.swan.apps.r.e.D(getAppId(), str, str3)) {
                lastIndexOf = str3.lastIndexOf(File.separator);
            } else {
                return str3;
            }
        }
        return !com.baidu.swan.apps.r.e.D(getAppId(), str, str3) ? "" : str3;
    }

    private void apq() {
        if (this.bXH != null) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.putExtra("pms_db_info_onload", this.bXH);
            intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            com.baidu.swan.apps.v.b.b apf = apf();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.gU(apf.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(apf);
            fVar.v("status", "2");
            fVar.oG(apf.agQ().getString("ubc"));
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
        int appFrameType = apf().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 2;
        }
        return 0;
    }

    private com.baidu.swan.apps.an.a gL(int i) {
        com.baidu.swan.apps.an.a aVar = new com.baidu.swan.apps.an.a();
        switch (i) {
            case 1:
                aVar.bw(10L).bx(2902L).pt("no aiapps info in database");
                break;
            case 2:
                aVar.bw(10L).bx(27L).pt("category not match");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.an.a aVar) {
        if (c(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().f(aVar).a(apf()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.swan.apps.an.a aVar) {
        HybridUbcFlow mp = com.baidu.swan.apps.performance.g.mp("startup");
        mp.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").eu(true));
        if (!d(aVar)) {
            log("updateInstalledPkgWithFinalCheck by null launchParams");
            fe(false);
            return false;
        }
        mp.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").eu(true));
        b.a aoJ = this.bYh.aoJ();
        long pi = com.baidu.swan.apps.swancore.b.pi(aoJ.agV());
        long j = aoJ.abG() != null ? aoJ.abG().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + aoJ.agV() + " targetSwanVersion: " + pi + " ,curSwanVersion: " + j);
        }
        if (pi > j) {
            com.baidu.swan.apps.swancore.b.ha(aoJ.getAppFrameType());
        }
        aoJ.br("extra_data_uid_key", com.baidu.swan.apps.u.a.aeW().bb(getContext()));
        com.baidu.swan.apps.performance.g.mp("startup").bD("launch_type", String.valueOf(com.baidu.swan.apps.ap.a.asV()));
        if (aoJ.getAppFrameType() == 0) {
            apr();
        }
        mp.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").eu(true));
        fe(true);
        com.baidu.swan.apps.env.c acw = com.baidu.swan.apps.env.e.acv().acw();
        if (acw != null && acw.acq()) {
            acw.kb(getAppId());
        }
        return true;
    }

    private void apr() {
        com.baidu.swan.apps.r.e.d(this.bYh);
    }

    private boolean d(com.baidu.swan.apps.an.a aVar) {
        com.baidu.swan.apps.performance.g.mp("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").eu(true));
        log("updateInfoWithFinalCheck: mAppInfo=" + this.bXH);
        if (this.bXH == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.an.a().bw(10L).bx(2902L).pt("no pkg was installed");
            }
            com.baidu.swan.apps.an.e.asQ().g(aVar);
            e(aVar);
            com.baidu.swan.apps.performance.g.a(aVar);
            return false;
        }
        int m = m(this.bXH);
        if (m == 1 || m == 2) {
            com.baidu.swan.apps.an.a gL = gL(m);
            com.baidu.swan.apps.an.e.asQ().g(gL);
            e(gL);
            com.baidu.swan.apps.performance.g.a(gL);
            return false;
        }
        aps();
        if (m != 0) {
            com.baidu.swan.apps.an.a gL2 = gL(m);
            com.baidu.swan.apps.an.e.asQ().g(gL2);
            apq();
            com.baidu.swan.apps.performance.g.a(gL2);
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
        com.baidu.swan.apps.v.b.b apf = apf();
        int appFrameType = apf.getAppFrameType();
        com.baidu.swan.apps.v.a.a.a(com.baidu.swan.apps.u.a.aeR(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.gU(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = "fail";
        fVar.v("errcode", String.valueOf(aVar.asM()));
        fVar.v("msg", aVar.asL().toString());
        fVar.d(apf);
        fVar.oG(apf.agQ().getString("ubc"));
        fVar.bu(com.baidu.swan.apps.statistic.h.ox(apf.agM()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.asN()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().oC(com.baidu.swan.apps.statistic.h.gU(appFrameType)).f(aVar).oD(getAppId()).oE(apf.agK()));
            aVar.asO();
        }
    }

    private void aps() {
        int i = 1;
        b.a aoJ = aox().aoJ();
        boolean z = (this.bXH == null || TextUtils.isEmpty(this.bXH.appId) || !TextUtils.equals(getAppId(), this.bXH.appId)) ? false : true;
        if (z) {
            aoJ.h(this.bXH);
        }
        if (!z || this.bXH.appCategory != 1) {
            i = 0;
        }
        aoJ.fD(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void fe(boolean z) {
        this.cAc = false;
        this.cAe = z;
        this.bXH = null;
        log("notifyMaintainFinish: " + z);
        i((i.a) new i.a("event_on_pkg_maintain_finish").bs("mAppId", this.bYh.id));
        com.baidu.swan.apps.v.c.a.lk(this.cAi).ahl();
        this.cAi = "";
    }

    private Context getContext() {
        SwanAppActivity aoz = this.bYh.aoz();
        return (aoz == null || aoz.isDestroyed()) ? com.baidu.swan.apps.u.a.aeR() : aoz;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a amQ = com.baidu.swan.apps.process.messaging.client.a.amQ();
        if (amQ == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.amw());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.m(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        amQ.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes11.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void A(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.ctk.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean td = com.baidu.swan.pms.c.td(string);
            boolean te = com.baidu.swan.pms.c.te(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + td + ", isInQueue: " + te);
            }
            this.ctk.putBoolean("isDownloading", (td || te) ? true : true);
            finish();
        }
    }
}
