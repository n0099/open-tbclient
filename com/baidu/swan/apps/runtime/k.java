package com.baidu.swan.apps.runtime;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
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
    private PMSAppInfo bOB;
    private final e bOS;
    private boolean cov;
    private boolean cow;
    String cox;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.cov = false;
        this.cow = false;
        this.cox = "";
        this.bOS = eVar;
    }

    public com.baidu.swan.apps.x.b.b alk() {
        return this.bOS.akP();
    }

    public synchronized boolean all() {
        return this.cov;
    }

    public synchronized boolean alm() {
        return this.cow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aln() {
        if (SwanAppProcessInfo.current().isSwanAppProcess() && this.bOS.cnZ && !all() && !alm()) {
            this.cov = true;
            com.baidu.swan.apps.performance.f.lb("startup").f(new UbcFlowEvent("maintain_start").ed(true));
            if (1 == this.bOS.akP().getAppFrameType()) {
                alo();
            } else {
                exec();
            }
        }
    }

    private synchronized void alo() {
        final HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        lb.f(new UbcFlowEvent("postExec-onhold").ed(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                lb.f(new UbcFlowEvent("postExec-run").ed(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        b.a akP = this.bOS.akP();
        if (com.baidu.swan.apps.ah.a.a.aiK() || !TextUtils.isEmpty(akP.adP())) {
            eL(true);
        } else {
            this.cox = akP.adT();
            com.baidu.swan.apps.x.c.a.jY(this.cox).jZ("start");
            HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
            lb.p("type", "1");
            lb.bk("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.UU().UV()));
            lb.f(new UbcFlowEvent("na_query_db_start"));
            PMSAppInfo rA = com.baidu.swan.pms.database.a.aBI().rA(getAppId());
            lb.f(new UbcFlowEvent("na_query_db"));
            boolean i = com.baidu.swan.apps.x.d.a.i(rA);
            lb.f(new UbcFlowEvent("has_local_file").ed(true));
            if (i) {
                j(rA);
                k(this.bOB);
                lb.f(new UbcFlowEvent("update_icon").ed(true));
            }
            if (!i && com.baidu.swan.apps.x.d.a.a(this.bOB, akP.getPage())) {
                alp();
            } else {
                alq();
            }
        }
    }

    private void alp() {
        HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        lb.f(new UbcFlowEvent("updateForIndependentPkgStart").ed(true));
        log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        com.baidu.swan.apps.x.b.b alk = alk();
        String bq = bq(String.valueOf(this.bOB.versionCode), alk.getPage());
        alk.dL(true);
        alk.jU(bq);
        Bundle bundle = new Bundle();
        bundle.putInt("pms_update_expect_pkg_ver", this.bOB.versionCode);
        O(bundle);
        lb.f(new UbcFlowEvent("updateForIndependentPkgEnd").ed(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(final Bundle bundle) {
        HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        lb.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").ed(true));
        log("启动本地包，进程预处理-加载本地包-后台异步更新");
        b((com.baidu.swan.apps.ap.a) null);
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.2
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                bundle2.putInt("appFrameType", k.this.alk().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                com.baidu.swan.apps.process.messaging.a.aiS().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).ba(5000L));
            }
        });
        lb.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").ed(true));
    }

    private void alq() {
        HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        lb.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").ed(true));
        log(this.bOB == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        com.baidu.swan.apps.core.i.c iD = com.baidu.swan.apps.core.i.f.XN().iD(getAppId());
        int i = this.bOB == null ? -1 : this.bOB.versionCode;
        int i2 = iD != null ? iD.versionCode : -1;
        boolean z = i2 > i;
        log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)));
        if (!z) {
            alr();
            return;
        }
        lb.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").ed(true));
        com.baidu.swan.apps.core.i.f.XN().a(iD, new com.baidu.swan.apps.core.i.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.i.d
            public void e(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow lb2 = com.baidu.swan.apps.performance.f.lb("startup");
                lb2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").ed(true));
                k.this.k(pMSAppInfo);
                lb2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").ed(true));
            }

            @Override // com.baidu.swan.apps.core.i.d
            public void f(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow lb2 = com.baidu.swan.apps.performance.f.lb("startup");
                lb2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").ed(true));
                k.log("预制包安装成功");
                k.a(k.this.alk(), pMSAppInfo, false, true);
                k.this.j(pMSAppInfo);
                k.this.O(null);
                lb2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").ed(true));
            }

            @Override // com.baidu.swan.apps.core.i.d
            public void onFailed(int i3) {
                HybridUbcFlow lb2 = com.baidu.swan.apps.performance.f.lb("startup");
                lb2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").ed(true));
                k.log("预制包安装失败");
                k.this.alr();
                lb2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").ed(true));
            }
        });
        lb.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").ed(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alr() {
        final HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        lb.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").ed(true));
        com.baidu.swan.apps.x.b.b alk = alk();
        log("预置包不可用");
        if (!als()) {
            log("可以直接打开小程序，异步从Server拉取新包");
            a(alk, this.bOB, false, false);
            O(null);
            return;
        }
        log("不能直接打开小程序，同步从Server拉取新包");
        a(alk, this.bOB, true, false);
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), alk.getAppFrameType());
        cVar.rO("3");
        cVar.iR(this.bOB != null ? this.bOB.versionCode : 0);
        cVar.bQ(this.bOB == null ? 0L : this.bOB.appSign);
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(alk.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.rK(delAllParamsFromUrl);
        }
        lb.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").ed(true));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.bOS) { // from class: com.baidu.swan.apps.runtime.k.4
            @Override // com.baidu.swan.apps.core.pms.g
            protected void a(com.baidu.swan.apps.ap.a aVar, boolean z) {
                lb.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").ed(true));
                k.log("onFinalFailed");
                com.baidu.swan.apps.ap.e.aov().f(aVar);
                if (z) {
                    k.this.a(aVar);
                } else {
                    k.this.eL(false);
                }
                lb.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").ed(true));
            }

            @Override // com.baidu.swan.apps.core.pms.g
            protected void c(PMSAppInfo pMSAppInfo) {
                lb.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").ed(true));
                k.log("onFinalComplete");
                k.this.j(pMSAppInfo);
                k.this.b((com.baidu.swan.apps.ap.a) null);
                lb.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").ed(true));
            }

            @Override // com.baidu.swan.apps.core.pms.f
            public void a(PMSAppInfo pMSAppInfo) {
                lb.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").ed(true));
                k.log("onAppInfoReceived");
                super.a(pMSAppInfo);
                k.this.k(pMSAppInfo);
                lb.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").ed(true));
            }
        });
        lb.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").ed(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PMSAppInfo pMSAppInfo) {
        this.bOB = pMSAppInfo;
        this.bOS.akP().h(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").bb("mAppId", getAppId())).I("appFrameType", pMSAppInfo.appCategory);
            log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                aVar.bb("app_name", pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                log("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                aVar.I(Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                log("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                aVar.bb("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.B("event_flag_force_post", true);
            d(aVar);
        }
    }

    private boolean als() {
        HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        if (this.bOB == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            lb.bk("launch_state", String.valueOf(0));
            return true;
        } else if (this.bOB.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            lb.bk("launch_state", String.valueOf(2));
            return true;
        } else if (this.bOB.aBU()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            lb.bk("launch_state", String.valueOf(2));
            return true;
        } else if (this.bOB.ark()) {
            if (com.baidu.swan.apps.core.a.b.a.UU().ic(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                lb.bk("launch_state", String.valueOf(3));
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            lb.bk("launch_state", String.valueOf(1));
            return true;
        } else {
            lb.bk("launch_state", String.valueOf(4));
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.x.b.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        eVar.adG().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.adG().putString("aiapp_extra_preset_pkg", z2 ? "1" : "0");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.cuA = z ? "1" : "0";
        fVar.cuB = z2 ? "1" : "0";
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        JSONObject mU = com.baidu.swan.apps.statistic.f.mU(eVar.adC());
        fVar.nd(eVar.adG().getString("ubc"));
        fVar.bl(mU);
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private String bq(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String oe = ag.oe(str2);
        String str3 = oe;
        int lastIndexOf = oe.lastIndexOf(File.separator);
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

    private void alt() {
        if (this.bOB != null) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.putExtra("pms_db_info_onload", this.bOB);
            intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            com.baidu.swan.apps.x.b.b alk = alk();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(alk.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(alk);
            fVar.s("status", "2");
            fVar.nd(alk.adG().getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
    }

    private int l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId)) {
            return 1;
        }
        int appFrameType = alk().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 2;
        }
        return 0;
    }

    private com.baidu.swan.apps.ap.a gs(int i) {
        com.baidu.swan.apps.ap.a aVar = new com.baidu.swan.apps.ap.a();
        switch (i) {
            case 1:
                aVar.bn(10L).bo(2902L).nL("no aiapps info in database");
                break;
            case 2:
                aVar.bn(10L).bo(27L).nL("category not match");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ap.a aVar) {
        if (b(aVar)) {
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().e(aVar).a(alk()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.swan.apps.ap.a aVar) {
        HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        lb.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").ed(true));
        if (!c(aVar)) {
            log("updateInstalledPkgWithFinalCheck by null launchParams");
            eL(false);
            return false;
        }
        lb.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").ed(true));
        b.a akP = this.bOS.akP();
        long nB = com.baidu.swan.apps.swancore.b.nB(akP.adL());
        long j = akP.YH() != null ? akP.YH().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + akP.adL() + " targetSwanVersion: " + nB + " ,curSwanVersion: " + j);
        }
        if (nB > j) {
            com.baidu.swan.apps.swancore.b.gE(akP.getAppFrameType());
        }
        akP.ba("extra_data_uid_key", com.baidu.swan.apps.w.a.abS().aR(getContext()));
        com.baidu.swan.apps.performance.f.lb("startup").bk("launch_type", String.valueOf(com.baidu.swan.apps.ar.a.aoA()));
        if (akP.getAppFrameType() == 0) {
            alu();
        }
        lb.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").ed(true));
        eL(true);
        com.baidu.swan.apps.env.c Zv = com.baidu.swan.apps.env.e.Zu().Zv();
        if (Zv != null && Zv.Zp()) {
            Zv.iU(getAppId());
        }
        return true;
    }

    private void alu() {
        b.a akP = this.bOS.akP();
        File a = com.baidu.swan.apps.t.e.a(getAppId(), akP.getVersion(), akP.adU(), akP.adV(), null);
        if (a.exists()) {
            String p = com.baidu.swan.apps.t.e.p(new File(a, "app.json"));
            if (DEBUG && !TextUtils.isEmpty(p)) {
                Log.i("SwanPkgMaintainer", "pre handle configData : " + p);
            }
            SwanAppConfigData k = SwanAppConfigData.k(p, a);
            if (k != null) {
                d.akJ().akG().c(k);
            }
            com.baidu.swan.apps.ag.b.b.a(k, true);
            com.baidu.swan.apps.ag.g.b.b(k);
        }
    }

    private boolean c(com.baidu.swan.apps.ap.a aVar) {
        com.baidu.swan.apps.performance.f.lb("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").ed(true));
        if (this.bOB == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.ap.a().bn(10L).bo(2902L).nL("no pkg was installed");
            }
            com.baidu.swan.apps.ap.e.aov().f(aVar);
            d(aVar);
            return false;
        }
        int l = l(this.bOB);
        if (l != 0) {
            com.baidu.swan.apps.ap.a gs = gs(l);
            com.baidu.swan.apps.ap.e.aov().f(gs);
            d(gs);
            return false;
        }
        alv();
        if (this.bOB.appStatus != 0) {
            com.baidu.swan.apps.ap.e.aov().f(gs(l));
            alt();
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
        com.baidu.swan.apps.x.b.b alk = alk();
        int appFrameType = alk.getAppFrameType();
        com.baidu.swan.apps.x.a.a.a(com.baidu.swan.apps.w.a.abN(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = "fail";
        fVar.s("errcode", String.valueOf(aVar.aor()));
        fVar.s("msg", aVar.aoq().toString());
        fVar.d(alk);
        fVar.nd(alk.adG().getString("ubc"));
        fVar.bl(com.baidu.swan.apps.statistic.f.mU(alk.adC()));
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
        if (!aVar.aos()) {
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().mZ(com.baidu.swan.apps.statistic.f.gz(appFrameType)).e(aVar).na(getAppId()).nb(alk.adA()));
            aVar.aot();
        }
    }

    private void alv() {
        int i = 1;
        b.a akP = akG().akP();
        boolean z = (this.bOB == null || TextUtils.isEmpty(this.bOB.appId) || !TextUtils.equals(getAppId(), this.bOB.appId)) ? false : true;
        if (z) {
            akP.g(this.bOB);
        }
        if (!z || this.bOB.appCategory != 1) {
            i = 0;
        }
        akP.fo(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eL(boolean z) {
        this.cov = false;
        this.cow = z;
        this.bOB = null;
        log("notifyMaintainFinish: " + z);
        d((i.a) new i.a("event_on_pkg_maintain_finish").bb("mAppId", this.bOS.id));
        com.baidu.swan.apps.x.c.a.jY(this.cox).aeb();
        this.cox = "";
    }

    private Context getContext() {
        SwanAppActivity akI = this.bOS.akI();
        return (akI == null || akI.isDestroyed()) ? com.baidu.swan.apps.w.a.abN() : akI;
    }
}
