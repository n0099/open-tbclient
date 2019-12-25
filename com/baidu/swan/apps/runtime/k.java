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
/* loaded from: classes9.dex */
public final class k extends l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean bKB;
    private boolean bKC;
    String bKD;
    private PMSAppInfo blc;
    private final e blt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.bKB = false;
        this.bKC = false;
        this.bKD = "";
        this.blt = eVar;
    }

    public com.baidu.swan.apps.x.b.b aaq() {
        return this.blt.ZV();
    }

    public synchronized boolean aar() {
        return this.bKB;
    }

    public synchronized boolean aas() {
        return this.bKC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void aat() {
        if (SwanAppProcessInfo.current().isSwanAppProcess() && this.blt.bKf && !aar() && !aas()) {
            this.bKB = true;
            com.baidu.swan.apps.performance.f.jx("startup").f(new UbcFlowEvent("maintain_start").cU(true));
            if (1 == this.blt.ZV().getAppFrameType()) {
                aau();
            } else {
                exec();
            }
        }
    }

    private synchronized void aau() {
        final HybridUbcFlow jx = com.baidu.swan.apps.performance.f.jx("startup");
        jx.f(new UbcFlowEvent("postExec-onhold").cU(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                jx.f(new UbcFlowEvent("postExec-run").cU(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        b.a ZV = this.blt.ZV();
        if (com.baidu.swan.apps.ah.a.a.XQ() || !TextUtils.isEmpty(ZV.Tl())) {
            dC(true);
        } else {
            this.bKD = ZV.Tp();
            com.baidu.swan.apps.x.c.a.iu(this.bKD).iv("start");
            HybridUbcFlow jx = com.baidu.swan.apps.performance.f.jx("startup");
            jx.k("type", "1");
            jx.aR("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.Ks().Kt()));
            jx.f(new UbcFlowEvent("na_query_db_start"));
            PMSAppInfo pW = com.baidu.swan.pms.database.a.aqM().pW(getAppId());
            jx.f(new UbcFlowEvent("na_query_db"));
            boolean i = com.baidu.swan.apps.x.d.a.i(pW);
            jx.f(new UbcFlowEvent("has_local_file").cU(true));
            if (i) {
                j(pW);
                k(this.blc);
                jx.f(new UbcFlowEvent("update_icon").cU(true));
            }
            if (!i && com.baidu.swan.apps.x.d.a.a(this.blc, ZV.getPage())) {
                aav();
            } else {
                aaw();
            }
        }
    }

    private void aav() {
        HybridUbcFlow jx = com.baidu.swan.apps.performance.f.jx("startup");
        jx.f(new UbcFlowEvent("updateForIndependentPkgStart").cU(true));
        log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        com.baidu.swan.apps.x.b.b aaq = aaq();
        String aX = aX(String.valueOf(this.blc.versionCode), aaq.getPage());
        aaq.cC(true);
        aaq.iq(aX);
        Bundle bundle = new Bundle();
        bundle.putInt("pms_update_expect_pkg_ver", this.blc.versionCode);
        O(bundle);
        jx.f(new UbcFlowEvent("updateForIndependentPkgEnd").cU(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(final Bundle bundle) {
        HybridUbcFlow jx = com.baidu.swan.apps.performance.f.jx("startup");
        jx.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").cU(true));
        log("启动本地包，进程预处理-加载本地包-后台异步更新");
        b((com.baidu.swan.apps.ap.a) null);
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.2
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                bundle2.putInt("appFrameType", k.this.aaq().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                com.baidu.swan.apps.process.messaging.a.XY().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).ao(5000L));
            }
        });
        jx.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").cU(true));
    }

    private void aaw() {
        HybridUbcFlow jx = com.baidu.swan.apps.performance.f.jx("startup");
        jx.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").cU(true));
        log(this.blc == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        com.baidu.swan.apps.core.i.c gY = com.baidu.swan.apps.core.i.f.Nk().gY(getAppId());
        int i = this.blc == null ? -1 : this.blc.versionCode;
        int i2 = gY != null ? gY.versionCode : -1;
        boolean z = i2 > i;
        log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)));
        if (!z) {
            aax();
            return;
        }
        jx.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").cU(true));
        com.baidu.swan.apps.core.i.f.Nk().a(gY, new com.baidu.swan.apps.core.i.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.i.d
            public void e(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow jx2 = com.baidu.swan.apps.performance.f.jx("startup");
                jx2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").cU(true));
                k.this.k(pMSAppInfo);
                jx2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").cU(true));
            }

            @Override // com.baidu.swan.apps.core.i.d
            public void f(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow jx2 = com.baidu.swan.apps.performance.f.jx("startup");
                jx2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").cU(true));
                k.log("预制包安装成功");
                k.a(k.this.aaq(), pMSAppInfo, false, true);
                k.this.j(pMSAppInfo);
                k.this.O(null);
                jx2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").cU(true));
            }

            @Override // com.baidu.swan.apps.core.i.d
            public void onFailed(int i3) {
                HybridUbcFlow jx2 = com.baidu.swan.apps.performance.f.jx("startup");
                jx2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").cU(true));
                k.log("预制包安装失败");
                k.this.aax();
                jx2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").cU(true));
            }
        });
        jx.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").cU(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aax() {
        final HybridUbcFlow jx = com.baidu.swan.apps.performance.f.jx("startup");
        jx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").cU(true));
        com.baidu.swan.apps.x.b.b aaq = aaq();
        log("预置包不可用");
        if (!aay()) {
            log("可以直接打开小程序，异步从Server拉取新包");
            a(aaq, this.blc, false, false);
            O(null);
            return;
        }
        log("不能直接打开小程序，同步从Server拉取新包");
        a(aaq, this.blc, true, false);
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), aaq.getAppFrameType());
        cVar.qk("3");
        cVar.it(this.blc != null ? this.blc.versionCode : 0);
        cVar.be(this.blc == null ? 0L : this.blc.appSign);
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(aaq.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.qg(delAllParamsFromUrl);
        }
        jx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").cU(true));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.blt) { // from class: com.baidu.swan.apps.runtime.k.4
            @Override // com.baidu.swan.apps.core.pms.g
            protected void a(com.baidu.swan.apps.ap.a aVar, boolean z) {
                jx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").cU(true));
                k.log("onFinalFailed");
                com.baidu.swan.apps.ap.e.adF().f(aVar);
                if (z) {
                    k.this.a(aVar);
                } else {
                    k.this.dC(false);
                }
                jx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").cU(true));
            }

            @Override // com.baidu.swan.apps.core.pms.g
            protected void c(PMSAppInfo pMSAppInfo) {
                jx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").cU(true));
                k.log("onFinalComplete");
                k.this.j(pMSAppInfo);
                k.this.b((com.baidu.swan.apps.ap.a) null);
                jx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").cU(true));
            }

            @Override // com.baidu.swan.apps.core.pms.f
            public void a(PMSAppInfo pMSAppInfo) {
                jx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").cU(true));
                k.log("onAppInfoReceived");
                super.a(pMSAppInfo);
                k.this.k(pMSAppInfo);
                jx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").cU(true));
            }
        });
        jx.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").cU(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PMSAppInfo pMSAppInfo) {
        this.blc = pMSAppInfo;
        this.blt.ZV().h(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").aH("mAppId", getAppId())).C("appFrameType", pMSAppInfo.appCategory);
            log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                aVar.aH("app_name", pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                log("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                aVar.C(Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                log("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                aVar.aH("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.w("event_flag_force_post", true);
            d(aVar);
        }
    }

    private boolean aay() {
        HybridUbcFlow jx = com.baidu.swan.apps.performance.f.jx("startup");
        if (this.blc == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            jx.aR("launch_state", String.valueOf(0));
            return true;
        } else if (this.blc.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            jx.aR("launch_state", String.valueOf(2));
            return true;
        } else if (this.blc.aqY()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            jx.aR("launch_state", String.valueOf(2));
            return true;
        } else if (this.blc.agr()) {
            if (com.baidu.swan.apps.core.a.b.a.Ks().gx(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                jx.aR("launch_state", String.valueOf(3));
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            jx.aR("launch_state", String.valueOf(1));
            return true;
        } else {
            jx.aR("launch_state", String.valueOf(4));
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.x.b.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        eVar.Tc().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.Tc().putString("aiapp_extra_preset_pkg", z2 ? "1" : "0");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.ga(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.bQA = z ? "1" : "0";
        fVar.bQB = z2 ? "1" : "0";
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        JSONObject lq = com.baidu.swan.apps.statistic.f.lq(eVar.SY());
        fVar.lz(eVar.Tc().getString("ubc"));
        fVar.ba(lq);
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private String aX(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String mA = ag.mA(str2);
        String str3 = mA;
        int lastIndexOf = mA.lastIndexOf(File.separator);
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

    private void aaz() {
        if (this.blc != null) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.putExtra("pms_db_info_onload", this.blc);
            intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            com.baidu.swan.apps.x.b.b aaq = aaq();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.ga(aaq.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(aaq);
            fVar.n("status", "2");
            fVar.lz(aaq.Tc().getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
    }

    private int l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId)) {
            return 1;
        }
        int appFrameType = aaq().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 2;
        }
        return 0;
    }

    private com.baidu.swan.apps.ap.a fT(int i) {
        com.baidu.swan.apps.ap.a aVar = new com.baidu.swan.apps.ap.a();
        switch (i) {
            case 1:
                aVar.aB(10L).aC(2902L).mh("no aiapps info in database");
                break;
            case 2:
                aVar.aB(10L).aC(27L).mh("category not match");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ap.a aVar) {
        if (b(aVar)) {
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().e(aVar).a(aaq()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.swan.apps.ap.a aVar) {
        HybridUbcFlow jx = com.baidu.swan.apps.performance.f.jx("startup");
        jx.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").cU(true));
        if (!c(aVar)) {
            log("updateInstalledPkgWithFinalCheck by null launchParams");
            dC(false);
            return false;
        }
        jx.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").cU(true));
        b.a ZV = this.blt.ZV();
        long lX = com.baidu.swan.apps.swancore.b.lX(ZV.Th());
        long j = ZV.Oe() != null ? ZV.Oe().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + ZV.Th() + " targetSwanVersion: " + lX + " ,curSwanVersion: " + j);
        }
        if (lX > j) {
            com.baidu.swan.apps.swancore.b.gf(ZV.getAppFrameType());
        }
        ZV.aG("extra_data_uid_key", com.baidu.swan.apps.w.a.Rp().bm(getContext()));
        com.baidu.swan.apps.performance.f.jx("startup").aR("launch_type", String.valueOf(com.baidu.swan.apps.ar.a.adK()));
        if (ZV.getAppFrameType() == 0) {
            aaA();
        }
        jx.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").cU(true));
        dC(true);
        com.baidu.swan.apps.env.c OS = com.baidu.swan.apps.env.e.OR().OS();
        if (OS != null && OS.OM()) {
            OS.hp(getAppId());
        }
        return true;
    }

    private void aaA() {
        b.a ZV = this.blt.ZV();
        File a = com.baidu.swan.apps.t.e.a(getAppId(), ZV.getVersion(), ZV.Tq(), ZV.Tr(), null);
        if (a.exists()) {
            String n = com.baidu.swan.apps.t.e.n(new File(a, "app.json"));
            if (DEBUG && !TextUtils.isEmpty(n)) {
                Log.i("SwanPkgMaintainer", "pre handle configData : " + n);
            }
            SwanAppConfigData l = SwanAppConfigData.l(n, a);
            if (l != null) {
                d.ZP().ZM().c(l);
            }
            com.baidu.swan.apps.ag.b.b.a(l, true);
            com.baidu.swan.apps.ag.g.b.b(l);
        }
    }

    private boolean c(com.baidu.swan.apps.ap.a aVar) {
        com.baidu.swan.apps.performance.f.jx("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").cU(true));
        if (this.blc == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.ap.a().aB(10L).aC(2902L).mh("no pkg was installed");
            }
            com.baidu.swan.apps.ap.e.adF().f(aVar);
            d(aVar);
            return false;
        }
        int l = l(this.blc);
        if (l != 0) {
            com.baidu.swan.apps.ap.a fT = fT(l);
            com.baidu.swan.apps.ap.e.adF().f(fT);
            d(fT);
            return false;
        }
        aaB();
        if (this.blc.appStatus != 0) {
            com.baidu.swan.apps.ap.e.adF().f(fT(l));
            aaz();
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
        com.baidu.swan.apps.x.b.b aaq = aaq();
        int appFrameType = aaq.getAppFrameType();
        com.baidu.swan.apps.x.a.a.a(com.baidu.swan.apps.w.a.Rk(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.ga(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        fVar.n("errcode", String.valueOf(aVar.adB()));
        fVar.n("msg", aVar.adA().toString());
        fVar.d(aaq);
        fVar.lz(aaq.Tc().getString("ubc"));
        fVar.ba(com.baidu.swan.apps.statistic.f.lq(aaq.SY()));
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
        if (!aVar.adC()) {
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().lv(com.baidu.swan.apps.statistic.f.ga(appFrameType)).e(aVar).lw(getAppId()).lx(aaq.SW()));
            aVar.adD();
        }
    }

    private void aaB() {
        int i = 1;
        b.a ZV = ZM().ZV();
        boolean z = (this.blc == null || TextUtils.isEmpty(this.blc.appId) || !TextUtils.equals(getAppId(), this.blc.appId)) ? false : true;
        if (z) {
            ZV.g(this.blc);
        }
        if (!z || this.blc.appCategory != 1) {
            i = 0;
        }
        ZV.eS(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dC(boolean z) {
        this.bKB = false;
        this.bKC = z;
        this.blc = null;
        log("notifyMaintainFinish: " + z);
        d((i.a) new i.a("event_on_pkg_maintain_finish").aH("mAppId", this.blt.id));
        com.baidu.swan.apps.x.c.a.iu(this.bKD).Tx();
        this.bKD = "";
    }

    private Context getContext() {
        SwanAppActivity ZO = this.blt.ZO();
        return (ZO == null || ZO.isDestroyed()) ? com.baidu.swan.apps.w.a.Rk() : ZO;
    }
}
