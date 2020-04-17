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
    private final e bON;
    private PMSAppInfo bOw;
    private boolean cop;
    private boolean coq;
    String cor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.cop = false;
        this.coq = false;
        this.cor = "";
        this.bON = eVar;
    }

    public com.baidu.swan.apps.x.b.b all() {
        return this.bON.akQ();
    }

    public synchronized boolean alm() {
        return this.cop;
    }

    public synchronized boolean aln() {
        return this.coq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void alo() {
        if (SwanAppProcessInfo.current().isSwanAppProcess() && this.bON.cnT && !alm() && !aln()) {
            this.cop = true;
            com.baidu.swan.apps.performance.f.lb("startup").f(new UbcFlowEvent("maintain_start").ed(true));
            if (1 == this.bON.akQ().getAppFrameType()) {
                alp();
            } else {
                exec();
            }
        }
    }

    private synchronized void alp() {
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
        b.a akQ = this.bON.akQ();
        if (com.baidu.swan.apps.ah.a.a.aiL() || !TextUtils.isEmpty(akQ.adQ())) {
            eL(true);
        } else {
            this.cor = akQ.adU();
            com.baidu.swan.apps.x.c.a.jY(this.cor).jZ("start");
            HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
            lb.p("type", "1");
            lb.bk("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.UV().UW()));
            lb.f(new UbcFlowEvent("na_query_db_start"));
            PMSAppInfo rA = com.baidu.swan.pms.database.a.aBI().rA(getAppId());
            lb.f(new UbcFlowEvent("na_query_db"));
            boolean i = com.baidu.swan.apps.x.d.a.i(rA);
            lb.f(new UbcFlowEvent("has_local_file").ed(true));
            if (i) {
                j(rA);
                k(this.bOw);
                lb.f(new UbcFlowEvent("update_icon").ed(true));
            }
            if (!i && com.baidu.swan.apps.x.d.a.a(this.bOw, akQ.getPage())) {
                alq();
            } else {
                alr();
            }
        }
    }

    private void alq() {
        HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        lb.f(new UbcFlowEvent("updateForIndependentPkgStart").ed(true));
        log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        com.baidu.swan.apps.x.b.b all = all();
        String bq = bq(String.valueOf(this.bOw.versionCode), all.getPage());
        all.dL(true);
        all.jU(bq);
        Bundle bundle = new Bundle();
        bundle.putInt("pms_update_expect_pkg_ver", this.bOw.versionCode);
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
                bundle2.putInt("appFrameType", k.this.all().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                com.baidu.swan.apps.process.messaging.a.aiT().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).ba(5000L));
            }
        });
        lb.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").ed(true));
    }

    private void alr() {
        HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        lb.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").ed(true));
        log(this.bOw == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        com.baidu.swan.apps.core.i.c iD = com.baidu.swan.apps.core.i.f.XO().iD(getAppId());
        int i = this.bOw == null ? -1 : this.bOw.versionCode;
        int i2 = iD != null ? iD.versionCode : -1;
        boolean z = i2 > i;
        log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)));
        if (!z) {
            als();
            return;
        }
        lb.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").ed(true));
        com.baidu.swan.apps.core.i.f.XO().a(iD, new com.baidu.swan.apps.core.i.d() { // from class: com.baidu.swan.apps.runtime.k.3
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
                k.a(k.this.all(), pMSAppInfo, false, true);
                k.this.j(pMSAppInfo);
                k.this.O(null);
                lb2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").ed(true));
            }

            @Override // com.baidu.swan.apps.core.i.d
            public void onFailed(int i3) {
                HybridUbcFlow lb2 = com.baidu.swan.apps.performance.f.lb("startup");
                lb2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").ed(true));
                k.log("预制包安装失败");
                k.this.als();
                lb2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").ed(true));
            }
        });
        lb.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").ed(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void als() {
        final HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        lb.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").ed(true));
        com.baidu.swan.apps.x.b.b all = all();
        log("预置包不可用");
        if (!alt()) {
            log("可以直接打开小程序，异步从Server拉取新包");
            a(all, this.bOw, false, false);
            O(null);
            return;
        }
        log("不能直接打开小程序，同步从Server拉取新包");
        a(all, this.bOw, true, false);
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), all.getAppFrameType());
        cVar.rO("3");
        cVar.iR(this.bOw != null ? this.bOw.versionCode : 0);
        cVar.bQ(this.bOw == null ? 0L : this.bOw.appSign);
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(all.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.rK(delAllParamsFromUrl);
        }
        lb.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").ed(true));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.bON) { // from class: com.baidu.swan.apps.runtime.k.4
            @Override // com.baidu.swan.apps.core.pms.g
            protected void a(com.baidu.swan.apps.ap.a aVar, boolean z) {
                lb.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").ed(true));
                k.log("onFinalFailed");
                com.baidu.swan.apps.ap.e.aow().f(aVar);
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
        this.bOw = pMSAppInfo;
        this.bON.akQ().h(pMSAppInfo);
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

    private boolean alt() {
        HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        if (this.bOw == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            lb.bk("launch_state", String.valueOf(0));
            return true;
        } else if (this.bOw.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            lb.bk("launch_state", String.valueOf(2));
            return true;
        } else if (this.bOw.aBU()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            lb.bk("launch_state", String.valueOf(2));
            return true;
        } else if (this.bOw.arl()) {
            if (com.baidu.swan.apps.core.a.b.a.UV().ic(getAppId())) {
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
        eVar.adH().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.adH().putString("aiapp_extra_preset_pkg", z2 ? "1" : "0");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.cuu = z ? "1" : "0";
        fVar.cuv = z2 ? "1" : "0";
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        JSONObject mU = com.baidu.swan.apps.statistic.f.mU(eVar.adD());
        fVar.nd(eVar.adH().getString("ubc"));
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

    private void alu() {
        if (this.bOw != null) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.putExtra("pms_db_info_onload", this.bOw);
            intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            com.baidu.swan.apps.x.b.b all = all();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(all.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(all);
            fVar.s("status", "2");
            fVar.nd(all.adH().getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
    }

    private int l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId)) {
            return 1;
        }
        int appFrameType = all().getAppFrameType();
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
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().e(aVar).a(all()));
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
        b.a akQ = this.bON.akQ();
        long nB = com.baidu.swan.apps.swancore.b.nB(akQ.adM());
        long j = akQ.YI() != null ? akQ.YI().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + akQ.adM() + " targetSwanVersion: " + nB + " ,curSwanVersion: " + j);
        }
        if (nB > j) {
            com.baidu.swan.apps.swancore.b.gE(akQ.getAppFrameType());
        }
        akQ.ba("extra_data_uid_key", com.baidu.swan.apps.w.a.abT().bd(getContext()));
        com.baidu.swan.apps.performance.f.lb("startup").bk("launch_type", String.valueOf(com.baidu.swan.apps.ar.a.aoB()));
        if (akQ.getAppFrameType() == 0) {
            alv();
        }
        lb.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").ed(true));
        eL(true);
        com.baidu.swan.apps.env.c Zw = com.baidu.swan.apps.env.e.Zv().Zw();
        if (Zw != null && Zw.Zq()) {
            Zw.iU(getAppId());
        }
        return true;
    }

    private void alv() {
        b.a akQ = this.bON.akQ();
        File a = com.baidu.swan.apps.t.e.a(getAppId(), akQ.getVersion(), akQ.adV(), akQ.adW(), null);
        if (a.exists()) {
            String p = com.baidu.swan.apps.t.e.p(new File(a, "app.json"));
            if (DEBUG && !TextUtils.isEmpty(p)) {
                Log.i("SwanPkgMaintainer", "pre handle configData : " + p);
            }
            SwanAppConfigData k = SwanAppConfigData.k(p, a);
            if (k != null) {
                d.akK().akH().c(k);
            }
            com.baidu.swan.apps.ag.b.b.a(k, true);
            com.baidu.swan.apps.ag.g.b.b(k);
        }
    }

    private boolean c(com.baidu.swan.apps.ap.a aVar) {
        com.baidu.swan.apps.performance.f.lb("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").ed(true));
        if (this.bOw == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.ap.a().bn(10L).bo(2902L).nL("no pkg was installed");
            }
            com.baidu.swan.apps.ap.e.aow().f(aVar);
            d(aVar);
            return false;
        }
        int l = l(this.bOw);
        if (l != 0) {
            com.baidu.swan.apps.ap.a gs = gs(l);
            com.baidu.swan.apps.ap.e.aow().f(gs);
            d(gs);
            return false;
        }
        alw();
        if (this.bOw.appStatus != 0) {
            com.baidu.swan.apps.ap.e.aow().f(gs(l));
            alu();
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
        com.baidu.swan.apps.x.b.b all = all();
        int appFrameType = all.getAppFrameType();
        com.baidu.swan.apps.x.a.a.a(com.baidu.swan.apps.w.a.abO(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = "fail";
        fVar.s("errcode", String.valueOf(aVar.aos()));
        fVar.s("msg", aVar.aor().toString());
        fVar.d(all);
        fVar.nd(all.adH().getString("ubc"));
        fVar.bl(com.baidu.swan.apps.statistic.f.mU(all.adD()));
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
        if (!aVar.aot()) {
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().mZ(com.baidu.swan.apps.statistic.f.gz(appFrameType)).e(aVar).na(getAppId()).nb(all.adB()));
            aVar.aou();
        }
    }

    private void alw() {
        int i = 1;
        b.a akQ = akH().akQ();
        boolean z = (this.bOw == null || TextUtils.isEmpty(this.bOw.appId) || !TextUtils.equals(getAppId(), this.bOw.appId)) ? false : true;
        if (z) {
            akQ.g(this.bOw);
        }
        if (!z || this.bOw.appCategory != 1) {
            i = 0;
        }
        akQ.fo(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eL(boolean z) {
        this.cop = false;
        this.coq = z;
        this.bOw = null;
        log("notifyMaintainFinish: " + z);
        d((i.a) new i.a("event_on_pkg_maintain_finish").bb("mAppId", this.bON.id));
        com.baidu.swan.apps.x.c.a.jY(this.cor).aec();
        this.cor = "";
    }

    private Context getContext() {
        SwanAppActivity akJ = this.bON.akJ();
        return (akJ == null || akJ.isDestroyed()) ? com.baidu.swan.apps.w.a.abO() : akJ;
    }
}
