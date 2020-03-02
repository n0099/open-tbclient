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
    private boolean bPr;
    private boolean bPs;
    String bPt;
    private PMSAppInfo bqc;
    private final e bqt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.bPr = false;
        this.bPs = false;
        this.bPt = "";
        this.bqt = eVar;
    }

    public com.baidu.swan.apps.x.b.b add() {
        return this.bqt.acI();
    }

    public synchronized boolean ade() {
        return this.bPr;
    }

    public synchronized boolean adf() {
        return this.bPs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void adg() {
        if (SwanAppProcessInfo.current().isSwanAppProcess() && this.bqt.bOV && !ade() && !adf()) {
            this.bPr = true;
            com.baidu.swan.apps.performance.f.jP("startup").f(new UbcFlowEvent("maintain_start").dg(true));
            if (1 == this.bqt.acI().getAppFrameType()) {
                adh();
            } else {
                exec();
            }
        }
    }

    private synchronized void adh() {
        final HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
        jP.f(new UbcFlowEvent("postExec-onhold").dg(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                jP.f(new UbcFlowEvent("postExec-run").dg(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        b.a acI = this.bqt.acI();
        if (com.baidu.swan.apps.ah.a.a.aaD() || !TextUtils.isEmpty(acI.VY())) {
            dO(true);
        } else {
            this.bPt = acI.Wc();
            com.baidu.swan.apps.x.c.a.iM(this.bPt).iN("start");
            HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
            jP.k("type", "1");
            jP.bb("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.Nf().Ng()));
            jP.f(new UbcFlowEvent("na_query_db_start"));
            PMSAppInfo qo = com.baidu.swan.pms.database.a.atv().qo(getAppId());
            jP.f(new UbcFlowEvent("na_query_db"));
            boolean i = com.baidu.swan.apps.x.d.a.i(qo);
            jP.f(new UbcFlowEvent("has_local_file").dg(true));
            if (i) {
                j(qo);
                k(this.bqc);
                jP.f(new UbcFlowEvent("update_icon").dg(true));
            }
            if (!i && com.baidu.swan.apps.x.d.a.a(this.bqc, acI.getPage())) {
                adi();
            } else {
                adj();
            }
        }
    }

    private void adi() {
        HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
        jP.f(new UbcFlowEvent("updateForIndependentPkgStart").dg(true));
        log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        com.baidu.swan.apps.x.b.b add = add();
        String bh = bh(String.valueOf(this.bqc.versionCode), add.getPage());
        add.cO(true);
        add.iI(bh);
        Bundle bundle = new Bundle();
        bundle.putInt("pms_update_expect_pkg_ver", this.bqc.versionCode);
        O(bundle);
        jP.f(new UbcFlowEvent("updateForIndependentPkgEnd").dg(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(final Bundle bundle) {
        HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
        jP.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").dg(true));
        log("启动本地包，进程预处理-加载本地包-后台异步更新");
        b((com.baidu.swan.apps.ap.a) null);
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.2
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                bundle2.putInt("appFrameType", k.this.add().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).av(5000L));
            }
        });
        jP.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").dg(true));
    }

    private void adj() {
        HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
        jP.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").dg(true));
        log(this.bqc == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        com.baidu.swan.apps.core.i.c hq = com.baidu.swan.apps.core.i.f.PW().hq(getAppId());
        int i = this.bqc == null ? -1 : this.bqc.versionCode;
        int i2 = hq != null ? hq.versionCode : -1;
        boolean z = i2 > i;
        log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)));
        if (!z) {
            adk();
            return;
        }
        jP.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").dg(true));
        com.baidu.swan.apps.core.i.f.PW().a(hq, new com.baidu.swan.apps.core.i.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.i.d
            public void e(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow jP2 = com.baidu.swan.apps.performance.f.jP("startup");
                jP2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").dg(true));
                k.this.k(pMSAppInfo);
                jP2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").dg(true));
            }

            @Override // com.baidu.swan.apps.core.i.d
            public void f(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow jP2 = com.baidu.swan.apps.performance.f.jP("startup");
                jP2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").dg(true));
                k.log("预制包安装成功");
                k.a(k.this.add(), pMSAppInfo, false, true);
                k.this.j(pMSAppInfo);
                k.this.O(null);
                jP2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").dg(true));
            }

            @Override // com.baidu.swan.apps.core.i.d
            public void onFailed(int i3) {
                HybridUbcFlow jP2 = com.baidu.swan.apps.performance.f.jP("startup");
                jP2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").dg(true));
                k.log("预制包安装失败");
                k.this.adk();
                jP2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").dg(true));
            }
        });
        jP.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").dg(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adk() {
        final HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
        jP.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").dg(true));
        com.baidu.swan.apps.x.b.b add = add();
        log("预置包不可用");
        if (!adl()) {
            log("可以直接打开小程序，异步从Server拉取新包");
            a(add, this.bqc, false, false);
            O(null);
            return;
        }
        log("不能直接打开小程序，同步从Server拉取新包");
        a(add, this.bqc, true, false);
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), add.getAppFrameType());
        cVar.qC("3");
        cVar.iK(this.bqc != null ? this.bqc.versionCode : 0);
        cVar.bl(this.bqc == null ? 0L : this.bqc.appSign);
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(add.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.qy(delAllParamsFromUrl);
        }
        jP.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").dg(true));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.bqt) { // from class: com.baidu.swan.apps.runtime.k.4
            @Override // com.baidu.swan.apps.core.pms.g
            protected void a(com.baidu.swan.apps.ap.a aVar, boolean z) {
                jP.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").dg(true));
                k.log("onFinalFailed");
                com.baidu.swan.apps.ap.e.ago().f(aVar);
                if (z) {
                    k.this.a(aVar);
                } else {
                    k.this.dO(false);
                }
                jP.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").dg(true));
            }

            @Override // com.baidu.swan.apps.core.pms.g
            protected void c(PMSAppInfo pMSAppInfo) {
                jP.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").dg(true));
                k.log("onFinalComplete");
                k.this.j(pMSAppInfo);
                k.this.b((com.baidu.swan.apps.ap.a) null);
                jP.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").dg(true));
            }

            @Override // com.baidu.swan.apps.core.pms.f
            public void a(PMSAppInfo pMSAppInfo) {
                jP.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").dg(true));
                k.log("onAppInfoReceived");
                super.a(pMSAppInfo);
                k.this.k(pMSAppInfo);
                jP.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").dg(true));
            }
        });
        jP.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").dg(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PMSAppInfo pMSAppInfo) {
        this.bqc = pMSAppInfo;
        this.bqt.acI().h(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").aS("mAppId", getAppId())).A("appFrameType", pMSAppInfo.appCategory);
            log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                aVar.aS("app_name", pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                log("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                aVar.A(Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                log("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                aVar.aS("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.w("event_flag_force_post", true);
            d(aVar);
        }
    }

    private boolean adl() {
        HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
        if (this.bqc == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            jP.bb("launch_state", String.valueOf(0));
            return true;
        } else if (this.bqc.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            jP.bb("launch_state", String.valueOf(2));
            return true;
        } else if (this.bqc.atH()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            jP.bb("launch_state", String.valueOf(2));
            return true;
        } else if (this.bqc.aja()) {
            if (com.baidu.swan.apps.core.a.b.a.Nf().gP(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                jP.bb("launch_state", String.valueOf(3));
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            jP.bb("launch_state", String.valueOf(1));
            return true;
        } else {
            jP.bb("launch_state", String.valueOf(4));
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.x.b.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        eVar.VP().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.VP().putString("aiapp_extra_preset_pkg", z2 ? "1" : "0");
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.bVq = z ? "1" : "0";
        fVar.bVr = z2 ? "1" : "0";
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        JSONObject lI = com.baidu.swan.apps.statistic.f.lI(eVar.VL());
        fVar.lR(eVar.VP().getString("ubc"));
        fVar.ba(lI);
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private String bh(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String mS = ag.mS(str2);
        String str3 = mS;
        int lastIndexOf = mS.lastIndexOf(File.separator);
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

    private void adm() {
        if (this.bqc != null) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.putExtra("pms_db_info_onload", this.bqc);
            intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            com.baidu.swan.apps.x.b.b add = add();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(add.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(add);
            fVar.n("status", "2");
            fVar.lR(add.VP().getString("ubc"));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
    }

    private int l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId)) {
            return 1;
        }
        int appFrameType = add().getAppFrameType();
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
                aVar.aI(10L).aJ(2902L).mz("no aiapps info in database");
                break;
            case 2:
                aVar.aI(10L).aJ(27L).mz("category not match");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ap.a aVar) {
        if (b(aVar)) {
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().e(aVar).a(add()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.swan.apps.ap.a aVar) {
        HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
        jP.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").dg(true));
        if (!c(aVar)) {
            log("updateInstalledPkgWithFinalCheck by null launchParams");
            dO(false);
            return false;
        }
        jP.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").dg(true));
        b.a acI = this.bqt.acI();
        long mp = com.baidu.swan.apps.swancore.b.mp(acI.VU());
        long j = acI.QQ() != null ? acI.QQ().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + acI.VU() + " targetSwanVersion: " + mp + " ,curSwanVersion: " + j);
        }
        if (mp > j) {
            com.baidu.swan.apps.swancore.b.gx(acI.getAppFrameType());
        }
        acI.aR("extra_data_uid_key", com.baidu.swan.apps.w.a.Ub().bq(getContext()));
        com.baidu.swan.apps.performance.f.jP("startup").bb("launch_type", String.valueOf(com.baidu.swan.apps.ar.a.agt()));
        if (acI.getAppFrameType() == 0) {
            adn();
        }
        jP.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").dg(true));
        dO(true);
        com.baidu.swan.apps.env.c RE = com.baidu.swan.apps.env.e.RD().RE();
        if (RE != null && RE.Ry()) {
            RE.hH(getAppId());
        }
        return true;
    }

    private void adn() {
        b.a acI = this.bqt.acI();
        File a = com.baidu.swan.apps.t.e.a(getAppId(), acI.getVersion(), acI.Wd(), acI.We(), null);
        if (a.exists()) {
            String o = com.baidu.swan.apps.t.e.o(new File(a, "app.json"));
            if (DEBUG && !TextUtils.isEmpty(o)) {
                Log.i("SwanPkgMaintainer", "pre handle configData : " + o);
            }
            SwanAppConfigData l = SwanAppConfigData.l(o, a);
            if (l != null) {
                d.acC().acz().c(l);
            }
            com.baidu.swan.apps.ag.b.b.a(l, true);
            com.baidu.swan.apps.ag.g.b.b(l);
        }
    }

    private boolean c(com.baidu.swan.apps.ap.a aVar) {
        com.baidu.swan.apps.performance.f.jP("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").dg(true));
        if (this.bqc == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.ap.a().aI(10L).aJ(2902L).mz("no pkg was installed");
            }
            com.baidu.swan.apps.ap.e.ago().f(aVar);
            d(aVar);
            return false;
        }
        int l = l(this.bqc);
        if (l != 0) {
            com.baidu.swan.apps.ap.a gk = gk(l);
            com.baidu.swan.apps.ap.e.ago().f(gk);
            d(gk);
            return false;
        }
        ado();
        if (this.bqc.appStatus != 0) {
            com.baidu.swan.apps.ap.e.ago().f(gk(l));
            adm();
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
        com.baidu.swan.apps.x.b.b add = add();
        int appFrameType = add.getAppFrameType();
        com.baidu.swan.apps.x.a.a.a(com.baidu.swan.apps.w.a.TW(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        fVar.n("errcode", String.valueOf(aVar.agk()));
        fVar.n("msg", aVar.agj().toString());
        fVar.d(add);
        fVar.lR(add.VP().getString("ubc"));
        fVar.ba(com.baidu.swan.apps.statistic.f.lI(add.VL()));
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
        if (!aVar.agl()) {
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().lN(com.baidu.swan.apps.statistic.f.gs(appFrameType)).e(aVar).lO(getAppId()).lP(add.VJ()));
            aVar.agm();
        }
    }

    private void ado() {
        int i = 1;
        b.a acI = acz().acI();
        boolean z = (this.bqc == null || TextUtils.isEmpty(this.bqc.appId) || !TextUtils.equals(getAppId(), this.bqc.appId)) ? false : true;
        if (z) {
            acI.g(this.bqc);
        }
        if (!z || this.bqc.appCategory != 1) {
            i = 0;
        }
        acI.fj(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dO(boolean z) {
        this.bPr = false;
        this.bPs = z;
        this.bqc = null;
        log("notifyMaintainFinish: " + z);
        d((i.a) new i.a("event_on_pkg_maintain_finish").aS("mAppId", this.bqt.id));
        com.baidu.swan.apps.x.c.a.iM(this.bPt).Wk();
        this.bPt = "";
    }

    private Context getContext() {
        SwanAppActivity acB = this.bqt.acB();
        return (acB == null || acB.isDestroyed()) ? com.baidu.swan.apps.w.a.TW() : acB;
    }
}
