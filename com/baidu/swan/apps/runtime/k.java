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
/* loaded from: classes10.dex */
public final class k extends l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean bLl;
    private boolean bLm;
    String bLn;
    private PMSAppInfo blR;
    private final e bmi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.bLl = false;
        this.bLm = false;
        this.bLn = "";
        this.bmi = eVar;
    }

    public com.baidu.swan.apps.x.b.b aaN() {
        return this.bmi.aas();
    }

    public synchronized boolean aaO() {
        return this.bLl;
    }

    public synchronized boolean aaP() {
        return this.bLm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aaQ() {
        if (SwanAppProcessInfo.current().isSwanAppProcess() && this.bmi.bKP && !aaO() && !aaP()) {
            this.bLl = true;
            com.baidu.swan.apps.performance.f.jA("startup").f(new UbcFlowEvent("maintain_start").cZ(true));
            if (1 == this.bmi.aas().getAppFrameType()) {
                aaR();
            } else {
                exec();
            }
        }
    }

    private synchronized void aaR() {
        final HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
        jA.f(new UbcFlowEvent("postExec-onhold").cZ(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                jA.f(new UbcFlowEvent("postExec-run").cZ(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        b.a aas = this.bmi.aas();
        if (com.baidu.swan.apps.ah.a.a.Yn() || !TextUtils.isEmpty(aas.TI())) {
            dH(true);
        } else {
            this.bLn = aas.TM();
            com.baidu.swan.apps.x.c.a.ix(this.bLn).iy("start");
            HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
            jA.k("type", "1");
            jA.aS("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.KO().KP()));
            jA.f(new UbcFlowEvent("na_query_db_start"));
            PMSAppInfo pZ = com.baidu.swan.pms.database.a.arf().pZ(getAppId());
            jA.f(new UbcFlowEvent("na_query_db"));
            boolean i = com.baidu.swan.apps.x.d.a.i(pZ);
            jA.f(new UbcFlowEvent("has_local_file").cZ(true));
            if (i) {
                j(pZ);
                k(this.blR);
                jA.f(new UbcFlowEvent("update_icon").cZ(true));
            }
            if (!i && com.baidu.swan.apps.x.d.a.a(this.blR, aas.getPage())) {
                aaS();
            } else {
                aaT();
            }
        }
    }

    private void aaS() {
        HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
        jA.f(new UbcFlowEvent("updateForIndependentPkgStart").cZ(true));
        log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        com.baidu.swan.apps.x.b.b aaN = aaN();
        String aY = aY(String.valueOf(this.blR.versionCode), aaN.getPage());
        aaN.cH(true);
        aaN.it(aY);
        Bundle bundle = new Bundle();
        bundle.putInt("pms_update_expect_pkg_ver", this.blR.versionCode);
        O(bundle);
        jA.f(new UbcFlowEvent("updateForIndependentPkgEnd").cZ(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(final Bundle bundle) {
        HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
        jA.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").cZ(true));
        log("启动本地包，进程预处理-加载本地包-后台异步更新");
        b((com.baidu.swan.apps.ap.a) null);
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.2
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                bundle2.putInt("appFrameType", k.this.aaN().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).ar(5000L));
            }
        });
        jA.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").cZ(true));
    }

    private void aaT() {
        HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
        jA.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").cZ(true));
        log(this.blR == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        com.baidu.swan.apps.core.i.c hb = com.baidu.swan.apps.core.i.f.NG().hb(getAppId());
        int i = this.blR == null ? -1 : this.blR.versionCode;
        int i2 = hb != null ? hb.versionCode : -1;
        boolean z = i2 > i;
        log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)));
        if (!z) {
            aaU();
            return;
        }
        jA.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").cZ(true));
        com.baidu.swan.apps.core.i.f.NG().a(hb, new com.baidu.swan.apps.core.i.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.i.d
            public void e(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow jA2 = com.baidu.swan.apps.performance.f.jA("startup");
                jA2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").cZ(true));
                k.this.k(pMSAppInfo);
                jA2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").cZ(true));
            }

            @Override // com.baidu.swan.apps.core.i.d
            public void f(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow jA2 = com.baidu.swan.apps.performance.f.jA("startup");
                jA2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").cZ(true));
                k.log("预制包安装成功");
                k.a(k.this.aaN(), pMSAppInfo, false, true);
                k.this.j(pMSAppInfo);
                k.this.O(null);
                jA2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").cZ(true));
            }

            @Override // com.baidu.swan.apps.core.i.d
            public void onFailed(int i3) {
                HybridUbcFlow jA2 = com.baidu.swan.apps.performance.f.jA("startup");
                jA2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").cZ(true));
                k.log("预制包安装失败");
                k.this.aaU();
                jA2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").cZ(true));
            }
        });
        jA.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").cZ(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaU() {
        final HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
        jA.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").cZ(true));
        com.baidu.swan.apps.x.b.b aaN = aaN();
        log("预置包不可用");
        if (!aaV()) {
            log("可以直接打开小程序，异步从Server拉取新包");
            a(aaN, this.blR, false, false);
            O(null);
            return;
        }
        log("不能直接打开小程序，同步从Server拉取新包");
        a(aaN, this.blR, true, false);
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aaN.getAppFrameType());
        cVar.qn("3");
        cVar.it(this.blR != null ? this.blR.versionCode : 0);
        cVar.bh(this.blR == null ? 0L : this.blR.appSign);
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(aaN.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.qj(delAllParamsFromUrl);
        }
        jA.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").cZ(true));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.bmi) { // from class: com.baidu.swan.apps.runtime.k.4
            @Override // com.baidu.swan.apps.core.pms.g
            protected void a(com.baidu.swan.apps.ap.a aVar, boolean z) {
                jA.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").cZ(true));
                k.log("onFinalFailed");
                com.baidu.swan.apps.ap.e.adY().f(aVar);
                if (z) {
                    k.this.a(aVar);
                } else {
                    k.this.dH(false);
                }
                jA.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").cZ(true));
            }

            @Override // com.baidu.swan.apps.core.pms.g
            protected void c(PMSAppInfo pMSAppInfo) {
                jA.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").cZ(true));
                k.log("onFinalComplete");
                k.this.j(pMSAppInfo);
                k.this.b((com.baidu.swan.apps.ap.a) null);
                jA.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").cZ(true));
            }

            @Override // com.baidu.swan.apps.core.pms.f
            public void a(PMSAppInfo pMSAppInfo) {
                jA.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").cZ(true));
                k.log("onAppInfoReceived");
                super.a(pMSAppInfo);
                k.this.k(pMSAppInfo);
                jA.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").cZ(true));
            }
        });
        jA.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").cZ(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PMSAppInfo pMSAppInfo) {
        this.blR = pMSAppInfo;
        this.bmi.aas().h(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").aI("mAppId", getAppId())).C("appFrameType", pMSAppInfo.appCategory);
            log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                aVar.aI("app_name", pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                log("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                aVar.C(Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                log("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                aVar.aI("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.w("event_flag_force_post", true);
            d(aVar);
        }
    }

    private boolean aaV() {
        HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
        if (this.blR == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            jA.aS("launch_state", String.valueOf(0));
            return true;
        } else if (this.blR.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            jA.aS("launch_state", String.valueOf(2));
            return true;
        } else if (this.blR.arr()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            jA.aS("launch_state", String.valueOf(2));
            return true;
        } else if (this.blR.agK()) {
            if (com.baidu.swan.apps.core.a.b.a.KO().gA(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                jA.aS("launch_state", String.valueOf(3));
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            jA.aS("launch_state", String.valueOf(1));
            return true;
        } else {
            jA.aS("launch_state", String.valueOf(4));
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.x.b.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        eVar.Tz().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.Tz().putString("aiapp_extra_preset_pkg", z2 ? "1" : "0");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.bRk = z ? "1" : "0";
        fVar.bRl = z2 ? "1" : "0";
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        JSONObject lt = com.baidu.swan.apps.statistic.f.lt(eVar.Tv());
        fVar.lC(eVar.Tz().getString("ubc"));
        fVar.ba(lt);
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private String aY(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String mD = ag.mD(str2);
        String str3 = mD;
        int lastIndexOf = mD.lastIndexOf(File.separator);
        while (lastIndexOf != -1) {
            str3 = str3.substring(0, lastIndexOf);
            if (!com.baidu.swan.apps.t.e.z(getAppId(), str, str3)) {
                lastIndexOf = str3.lastIndexOf(File.separator);
            } else {
                return str3;
            }
        }
        return !com.baidu.swan.apps.t.e.z(getAppId(), str, str3) ? "" : str3;
    }

    private void aaW() {
        if (this.blR != null) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.putExtra("pms_db_info_onload", this.blR);
            intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            com.baidu.swan.apps.x.b.b aaN = aaN();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(aaN.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aaN);
            fVar.n("status", "2");
            fVar.lC(aaN.Tz().getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
    }

    private int l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId)) {
            return 1;
        }
        int appFrameType = aaN().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 2;
        }
        return 0;
    }

    private com.baidu.swan.apps.ap.a fU(int i) {
        com.baidu.swan.apps.ap.a aVar = new com.baidu.swan.apps.ap.a();
        switch (i) {
            case 1:
                aVar.aE(10L).aF(2902L).mk("no aiapps info in database");
                break;
            case 2:
                aVar.aE(10L).aF(27L).mk("category not match");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ap.a aVar) {
        if (b(aVar)) {
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().e(aVar).a(aaN()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.swan.apps.ap.a aVar) {
        HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
        jA.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").cZ(true));
        if (!c(aVar)) {
            log("updateInstalledPkgWithFinalCheck by null launchParams");
            dH(false);
            return false;
        }
        jA.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").cZ(true));
        b.a aas = this.bmi.aas();
        long ma = com.baidu.swan.apps.swancore.b.ma(aas.TE());
        long j = aas.OA() != null ? aas.OA().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + aas.TE() + " targetSwanVersion: " + ma + " ,curSwanVersion: " + j);
        }
        if (ma > j) {
            com.baidu.swan.apps.swancore.b.gg(aas.getAppFrameType());
        }
        aas.aH("extra_data_uid_key", com.baidu.swan.apps.w.a.RL().bm(getContext()));
        com.baidu.swan.apps.performance.f.jA("startup").aS("launch_type", String.valueOf(com.baidu.swan.apps.ar.a.aed()));
        if (aas.getAppFrameType() == 0) {
            aaX();
        }
        jA.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").cZ(true));
        dH(true);
        com.baidu.swan.apps.env.c Po = com.baidu.swan.apps.env.e.Pn().Po();
        if (Po != null && Po.Pi()) {
            Po.hs(getAppId());
        }
        return true;
    }

    private void aaX() {
        b.a aas = this.bmi.aas();
        File a = com.baidu.swan.apps.t.e.a(getAppId(), aas.getVersion(), aas.TN(), aas.TO(), null);
        if (a.exists()) {
            String n = com.baidu.swan.apps.t.e.n(new File(a, "app.json"));
            if (DEBUG && !TextUtils.isEmpty(n)) {
                Log.i("SwanPkgMaintainer", "pre handle configData : " + n);
            }
            SwanAppConfigData l = SwanAppConfigData.l(n, a);
            if (l != null) {
                d.aam().aaj().c(l);
            }
            com.baidu.swan.apps.ag.b.b.a(l, true);
            com.baidu.swan.apps.ag.g.b.b(l);
        }
    }

    private boolean c(com.baidu.swan.apps.ap.a aVar) {
        com.baidu.swan.apps.performance.f.jA("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").cZ(true));
        if (this.blR == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.ap.a().aE(10L).aF(2902L).mk("no pkg was installed");
            }
            com.baidu.swan.apps.ap.e.adY().f(aVar);
            d(aVar);
            return false;
        }
        int l = l(this.blR);
        if (l != 0) {
            com.baidu.swan.apps.ap.a fU = fU(l);
            com.baidu.swan.apps.ap.e.adY().f(fU);
            d(fU);
            return false;
        }
        aaY();
        if (this.blR.appStatus != 0) {
            com.baidu.swan.apps.ap.e.adY().f(fU(l));
            aaW();
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
        com.baidu.swan.apps.x.b.b aaN = aaN();
        int appFrameType = aaN.getAppFrameType();
        com.baidu.swan.apps.x.a.a.a(com.baidu.swan.apps.w.a.RG(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        fVar.n("errcode", String.valueOf(aVar.adU()));
        fVar.n("msg", aVar.adT().toString());
        fVar.d(aaN);
        fVar.lC(aaN.Tz().getString("ubc"));
        fVar.ba(com.baidu.swan.apps.statistic.f.lt(aaN.Tv()));
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
        if (!aVar.adV()) {
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().ly(com.baidu.swan.apps.statistic.f.gb(appFrameType)).e(aVar).lz(getAppId()).lA(aaN.Tt()));
            aVar.adW();
        }
    }

    private void aaY() {
        int i = 1;
        b.a aas = aaj().aas();
        boolean z = (this.blR == null || TextUtils.isEmpty(this.blR.appId) || !TextUtils.equals(getAppId(), this.blR.appId)) ? false : true;
        if (z) {
            aas.g(this.blR);
        }
        if (!z || this.blR.appCategory != 1) {
            i = 0;
        }
        aas.eT(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dH(boolean z) {
        this.bLl = false;
        this.bLm = z;
        this.blR = null;
        log("notifyMaintainFinish: " + z);
        d((i.a) new i.a("event_on_pkg_maintain_finish").aI("mAppId", this.bmi.id));
        com.baidu.swan.apps.x.c.a.ix(this.bLn).TU();
        this.bLn = "";
    }

    private Context getContext() {
        SwanAppActivity aal = this.bmi.aal();
        return (aal == null || aal.isDestroyed()) ? com.baidu.swan.apps.w.a.RG() : aal;
    }
}
