package com.baidu.swan.apps.runtime;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class k extends l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean bPD;
    private boolean bPE;
    String bPF;
    private final e bqG;
    private PMSAppInfo bqp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.bPD = false;
        this.bPE = false;
        this.bPF = "";
        this.bqG = eVar;
    }

    public com.baidu.swan.apps.x.b.b adg() {
        return this.bqG.acL();
    }

    public synchronized boolean adh() {
        return this.bPD;
    }

    public synchronized boolean adi() {
        return this.bPE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void adj() {
        if (SwanAppProcessInfo.current().isSwanAppProcess() && this.bqG.bPh && !adh() && !adi()) {
            this.bPD = true;
            com.baidu.swan.apps.performance.f.jO("startup").f(new UbcFlowEvent("maintain_start").dh(true));
            if (1 == this.bqG.acL().getAppFrameType()) {
                adk();
            } else {
                exec();
            }
        }
    }

    private synchronized void adk() {
        final HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
        jO.f(new UbcFlowEvent("postExec-onhold").dh(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                jO.f(new UbcFlowEvent("postExec-run").dh(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        b.a acL = this.bqG.acL();
        if (com.baidu.swan.apps.ah.a.a.aaG() || !TextUtils.isEmpty(acL.Wb())) {
            dP(true);
        } else {
            this.bPF = acL.Wf();
            com.baidu.swan.apps.x.c.a.iL(this.bPF).iM("start");
            HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
            jO.k("type", "1");
            jO.ba("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.Ni().Nj()));
            jO.f(new UbcFlowEvent("na_query_db_start"));
            PMSAppInfo qn = com.baidu.swan.pms.database.a.aty().qn(getAppId());
            jO.f(new UbcFlowEvent("na_query_db"));
            boolean i = com.baidu.swan.apps.x.d.a.i(qn);
            jO.f(new UbcFlowEvent("has_local_file").dh(true));
            if (i) {
                j(qn);
                k(this.bqp);
                jO.f(new UbcFlowEvent("update_icon").dh(true));
            }
            if (!i && com.baidu.swan.apps.x.d.a.a(this.bqp, acL.getPage())) {
                adl();
            } else {
                adm();
            }
        }
    }

    private void adl() {
        HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
        jO.f(new UbcFlowEvent("updateForIndependentPkgStart").dh(true));
        log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        com.baidu.swan.apps.x.b.b adg = adg();
        String bg = bg(String.valueOf(this.bqp.versionCode), adg.getPage());
        adg.cP(true);
        adg.iH(bg);
        Bundle bundle = new Bundle();
        bundle.putInt("pms_update_expect_pkg_ver", this.bqp.versionCode);
        O(bundle);
        jO.f(new UbcFlowEvent("updateForIndependentPkgEnd").dh(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(final Bundle bundle) {
        HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
        jO.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").dh(true));
        log("启动本地包，进程预处理-加载本地包-后台异步更新");
        b((com.baidu.swan.apps.ap.a) null);
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.2
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                bundle2.putInt("appFrameType", k.this.adg().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                com.baidu.swan.apps.process.messaging.a.aaO().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).av(5000L));
            }
        });
        jO.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").dh(true));
    }

    private void adm() {
        HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
        jO.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").dh(true));
        log(this.bqp == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        com.baidu.swan.apps.core.i.c hp = com.baidu.swan.apps.core.i.f.PZ().hp(getAppId());
        int i = this.bqp == null ? -1 : this.bqp.versionCode;
        int i2 = hp != null ? hp.versionCode : -1;
        boolean z = i2 > i;
        log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)));
        if (!z) {
            adn();
            return;
        }
        jO.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").dh(true));
        com.baidu.swan.apps.core.i.f.PZ().a(hp, new com.baidu.swan.apps.core.i.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.i.d
            public void e(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow jO2 = com.baidu.swan.apps.performance.f.jO("startup");
                jO2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").dh(true));
                k.this.k(pMSAppInfo);
                jO2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").dh(true));
            }

            @Override // com.baidu.swan.apps.core.i.d
            public void f(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow jO2 = com.baidu.swan.apps.performance.f.jO("startup");
                jO2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").dh(true));
                k.log("预制包安装成功");
                k.a(k.this.adg(), pMSAppInfo, false, true);
                k.this.j(pMSAppInfo);
                k.this.O(null);
                jO2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").dh(true));
            }

            @Override // com.baidu.swan.apps.core.i.d
            public void onFailed(int i3) {
                HybridUbcFlow jO2 = com.baidu.swan.apps.performance.f.jO("startup");
                jO2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").dh(true));
                k.log("预制包安装失败");
                k.this.adn();
                jO2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").dh(true));
            }
        });
        jO.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").dh(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adn() {
        final HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
        jO.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").dh(true));
        com.baidu.swan.apps.x.b.b adg = adg();
        log("预置包不可用");
        if (!ado()) {
            log("可以直接打开小程序，异步从Server拉取新包");
            a(adg, this.bqp, false, false);
            O(null);
            return;
        }
        log("不能直接打开小程序，同步从Server拉取新包");
        a(adg, this.bqp, true, false);
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), adg.getAppFrameType());
        cVar.qB("3");
        cVar.iK(this.bqp != null ? this.bqp.versionCode : 0);
        cVar.bl(this.bqp == null ? 0L : this.bqp.appSign);
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(adg.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.qx(delAllParamsFromUrl);
        }
        jO.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").dh(true));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.bqG) { // from class: com.baidu.swan.apps.runtime.k.4
            @Override // com.baidu.swan.apps.core.pms.g
            protected void a(com.baidu.swan.apps.ap.a aVar, boolean z) {
                jO.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").dh(true));
                k.log("onFinalFailed");
                com.baidu.swan.apps.ap.e.agr().f(aVar);
                if (z) {
                    k.this.a(aVar);
                } else {
                    k.this.dP(false);
                }
                jO.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").dh(true));
            }

            @Override // com.baidu.swan.apps.core.pms.g
            protected void c(PMSAppInfo pMSAppInfo) {
                jO.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").dh(true));
                k.log("onFinalComplete");
                k.this.j(pMSAppInfo);
                k.this.b((com.baidu.swan.apps.ap.a) null);
                jO.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").dh(true));
            }

            @Override // com.baidu.swan.apps.core.pms.f
            public void a(PMSAppInfo pMSAppInfo) {
                jO.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").dh(true));
                k.log("onAppInfoReceived");
                super.a(pMSAppInfo);
                k.this.k(pMSAppInfo);
                jO.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").dh(true));
            }
        });
        jO.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").dh(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PMSAppInfo pMSAppInfo) {
        this.bqp = pMSAppInfo;
        this.bqG.acL().h(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").aR("mAppId", getAppId())).A("appFrameType", pMSAppInfo.appCategory);
            log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                aVar.aR("app_name", pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                log("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                aVar.A(Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                log("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                aVar.aR("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.w("event_flag_force_post", true);
            d(aVar);
        }
    }

    private boolean ado() {
        HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
        if (this.bqp == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            jO.ba("launch_state", String.valueOf(0));
            return true;
        } else if (this.bqp.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            jO.ba("launch_state", String.valueOf(2));
            return true;
        } else if (this.bqp.atK()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            jO.ba("launch_state", String.valueOf(2));
            return true;
        } else if (this.bqp.ajd()) {
            if (com.baidu.swan.apps.core.a.b.a.Ni().gO(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                jO.ba("launch_state", String.valueOf(3));
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            jO.ba("launch_state", String.valueOf(1));
            return true;
        } else {
            jO.ba("launch_state", String.valueOf(4));
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.x.b.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        eVar.VS().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.VS().putString("aiapp_extra_preset_pkg", z2 ? "1" : "0");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.bVC = z ? "1" : "0";
        fVar.bVD = z2 ? "1" : "0";
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        JSONObject lH = com.baidu.swan.apps.statistic.f.lH(eVar.VO());
        fVar.lQ(eVar.VS().getString("ubc"));
        fVar.ba(lH);
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private String bg(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String mR = ag.mR(str2);
        String str3 = mR;
        int lastIndexOf = mR.lastIndexOf(File.separator);
        while (lastIndexOf != -1) {
            str3 = str3.substring(0, lastIndexOf);
            if (!com.baidu.swan.apps.t.e.A(getAppId(), str, str3)) {
                lastIndexOf = str3.lastIndexOf(File.separator);
            } else {
                return str3;
            }
        }
        return !com.baidu.swan.apps.t.e.A(getAppId(), str, str3) ? "" : str3;
    }

    private void adp() {
        if (this.bqp != null) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.putExtra("pms_db_info_onload", this.bqp);
            intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            com.baidu.swan.apps.x.b.b adg = adg();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(adg.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(adg);
            fVar.n("status", "2");
            fVar.lQ(adg.VS().getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
    }

    private int l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId)) {
            return 1;
        }
        int appFrameType = adg().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 2;
        }
        return 0;
    }

    private com.baidu.swan.apps.ap.a gk(int i) {
        com.baidu.swan.apps.ap.a aVar = new com.baidu.swan.apps.ap.a();
        switch (i) {
            case 1:
                aVar.aI(10L).aJ(2902L).my("no aiapps info in database");
                break;
            case 2:
                aVar.aI(10L).aJ(27L).my("category not match");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ap.a aVar) {
        if (b(aVar)) {
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().e(aVar).a(adg()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.swan.apps.ap.a aVar) {
        HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
        jO.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").dh(true));
        if (!c(aVar)) {
            log("updateInstalledPkgWithFinalCheck by null launchParams");
            dP(false);
            return false;
        }
        jO.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").dh(true));
        b.a acL = this.bqG.acL();
        long mo = com.baidu.swan.apps.swancore.b.mo(acL.VX());
        long j = acL.QT() != null ? acL.QT().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + acL.VX() + " targetSwanVersion: " + mo + " ,curSwanVersion: " + j);
        }
        if (mo > j) {
            com.baidu.swan.apps.swancore.b.gx(acL.getAppFrameType());
        }
        acL.aQ("extra_data_uid_key", com.baidu.swan.apps.w.a.Ue().bp(getContext()));
        com.baidu.swan.apps.performance.f.jO("startup").ba("launch_type", String.valueOf(com.baidu.swan.apps.ar.a.agw()));
        if (acL.getAppFrameType() == 0) {
            adq();
        }
        jO.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").dh(true));
        dP(true);
        com.baidu.swan.apps.env.c RH = com.baidu.swan.apps.env.e.RG().RH();
        if (RH != null && RH.RB()) {
            RH.hG(getAppId());
        }
        return true;
    }

    private void adq() {
        b.a acL = this.bqG.acL();
        File a = com.baidu.swan.apps.t.e.a(getAppId(), acL.getVersion(), acL.Wg(), acL.Wh(), null);
        if (a.exists()) {
            String o = com.baidu.swan.apps.t.e.o(new File(a, "app.json"));
            if (DEBUG && !TextUtils.isEmpty(o)) {
                Log.i("SwanPkgMaintainer", "pre handle configData : " + o);
            }
            SwanAppConfigData l = SwanAppConfigData.l(o, a);
            if (l != null) {
                d.acF().acC().c(l);
            }
            com.baidu.swan.apps.ag.b.b.a(l, true);
            com.baidu.swan.apps.ag.g.b.b(l);
        }
    }

    private boolean c(com.baidu.swan.apps.ap.a aVar) {
        com.baidu.swan.apps.performance.f.jO("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").dh(true));
        if (this.bqp == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.ap.a().aI(10L).aJ(2902L).my("no pkg was installed");
            }
            com.baidu.swan.apps.ap.e.agr().f(aVar);
            d(aVar);
            return false;
        }
        int l = l(this.bqp);
        if (l != 0) {
            com.baidu.swan.apps.ap.a gk = gk(l);
            com.baidu.swan.apps.ap.e.agr().f(gk);
            d(gk);
            return false;
        }
        adr();
        if (this.bqp.appStatus != 0) {
            com.baidu.swan.apps.ap.e.agr().f(gk(l));
            adp();
            return false;
        }
        return true;
    }

    private void d(com.baidu.swan.apps.ap.a aVar) {
        Context context = getContext();
        if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
            if (DEBUG) {
                Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                return;
            }
            return;
        }
        com.baidu.swan.apps.x.b.b adg = adg();
        int appFrameType = adg.getAppFrameType();
        com.baidu.swan.apps.x.a.a.a(com.baidu.swan.apps.w.a.TZ(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        fVar.n("errcode", String.valueOf(aVar.agn()));
        fVar.n("msg", aVar.agm().toString());
        fVar.d(adg);
        fVar.lQ(adg.VS().getString("ubc"));
        fVar.ba(com.baidu.swan.apps.statistic.f.lH(adg.VO()));
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
        if (!aVar.ago()) {
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().lM(com.baidu.swan.apps.statistic.f.gs(appFrameType)).e(aVar).lN(getAppId()).lO(adg.VM()));
            aVar.agp();
        }
    }

    private void adr() {
        int i = 1;
        b.a acL = acC().acL();
        boolean z = (this.bqp == null || TextUtils.isEmpty(this.bqp.appId) || !TextUtils.equals(getAppId(), this.bqp.appId)) ? false : true;
        if (z) {
            acL.g(this.bqp);
        }
        if (!z || this.bqp.appCategory != 1) {
            i = 0;
        }
        acL.fj(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dP(boolean z) {
        this.bPD = false;
        this.bPE = z;
        this.bqp = null;
        log("notifyMaintainFinish: " + z);
        d((i.a) new i.a("event_on_pkg_maintain_finish").aR("mAppId", this.bqG.id));
        com.baidu.swan.apps.x.c.a.iL(this.bPF).Wn();
        this.bPF = "";
    }

    private Context getContext() {
        SwanAppActivity acE = this.bqG.acE();
        return (acE == null || acE.isDestroyed()) ? com.baidu.swan.apps.w.a.TZ() : acE;
    }
}
