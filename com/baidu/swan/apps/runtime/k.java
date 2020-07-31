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
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.al;
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
/* loaded from: classes7.dex */
public final class k extends m implements com.baidu.swan.apps.env.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cHA;
    private boolean cHB;
    private boolean cHC;
    private int cHD;
    private boolean cHE;
    String cHF;
    private boolean cHG;
    private boolean cHz;
    private PMSAppInfo cea;
    private final e cez;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        super(eVar);
        this.cHz = false;
        this.cHA = false;
        this.cHB = false;
        this.cHC = false;
        this.cHD = -1;
        this.cHE = false;
        this.cHF = "";
        this.cHG = false;
        this.cez = eVar;
    }

    public com.baidu.swan.apps.u.c.b arU() {
        return this.cez.arz();
    }

    public synchronized boolean arV() {
        return this.cHz;
    }

    public boolean arW() {
        return this.cHA;
    }

    public int arC() {
        return this.cHD;
    }

    public synchronized boolean arX() {
        return this.cHB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void arY() {
        synchronized (this) {
            if (SwanAppProcessInfo.current().isSwanAppProcess() && this.cez.cHd && !arV() && !arX()) {
                this.cHz = true;
                com.baidu.swan.apps.performance.i.mX("startup").f(new UbcFlowEvent("maintain_start").eI(true));
                boolean z = 1 == this.cez.arz().getAppFrameType();
                if (z || !com.baidu.swan.apps.core.turbo.d.adw().adC()) {
                    oi("event_on_still_maintaining");
                }
                if (z) {
                    arZ();
                } else {
                    exec();
                }
            }
        }
    }

    private synchronized void arZ() {
        final HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
        mX.f(new UbcFlowEvent("postExec-onhold").eI(true));
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.1
            @Override // java.lang.Runnable
            public void run() {
                mX.f(new UbcFlowEvent("postExec-run").eI(true));
                k.this.exec();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exec() {
        boolean z = true;
        synchronized (this) {
            this.cHD = 99;
            d("KEY_PKG_STATE", "event_pms_check_start", this.cHD);
            b.a arz = this.cez.arz();
            if (com.baidu.swan.apps.ae.a.a.apg() || !TextUtils.isEmpty(arz.ajv()) || (DEBUG && arz.isDebug())) {
                fs(true);
            } else {
                this.cHF = arz.ajz();
                if (com.baidu.swan.apps.performance.b.b.aoo()) {
                    if (DEBUG) {
                        com.baidu.swan.apps.u.d.a.lT(this.cHF).lU("start");
                    }
                } else {
                    com.baidu.swan.apps.u.d.a.lT(this.cHF).lU("start");
                }
                HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
                mX.r("type", "1");
                mX.bH("is_updating", String.valueOf(com.baidu.swan.apps.core.a.b.a.Zy().Zz()));
                mX.f(new UbcFlowEvent("na_query_db_start"));
                PMSAppInfo ajw = this.cez.arz().ajw();
                if (ajw == null || ajw.aLf()) {
                    ajw = com.baidu.swan.pms.database.a.aKS().uq(getAppId());
                }
                mX.f(new UbcFlowEvent("na_query_db"));
                this.cHG = com.baidu.swan.apps.u.e.a.m(ajw);
                this.cHC = (ajw == null || this.cHG) ? false : false;
                mX.f(new UbcFlowEvent("has_local_file").eI(true));
                if (this.cHG) {
                    n(ajw);
                    o(this.cea);
                    mX.f(new UbcFlowEvent("update_icon").eI(true));
                }
                if (!this.cHG && com.baidu.swan.apps.u.e.a.a(this.cea, arz.getPage())) {
                    asa();
                } else {
                    asb();
                }
            }
        }
    }

    private void asa() {
        HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
        mX.f(new UbcFlowEvent("updateForIndependentPkgStart").eI(true));
        log("独立分包启动，本地有包--->打开小程序，异步更新主包");
        com.baidu.swan.apps.u.c.b arU = arU();
        String b = com.baidu.swan.apps.u.e.a.b(this.cea, arU.getPage());
        arU.eo(true);
        arU.lP(b);
        Bundle bundle = new Bundle();
        bundle.putInt("pms_update_expect_pkg_ver", this.cea.versionCode);
        V(bundle);
        mX.f(new UbcFlowEvent("updateForIndependentPkgEnd").eI(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final Bundle bundle) {
        HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
        mX.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart").eI(true));
        log("启动本地包，进程预处理-加载本地包-后台异步更新");
        c((com.baidu.swan.apps.an.a) null);
        d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.2
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                bundle2.putInt("appFrameType", k.this.arU().getAppFrameType());
                bundle2.putString("mAppId", k.this.getAppId());
                k.log("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(17, bundle2).bv(5000L));
            }
        });
        mX.f(new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd").eI(true));
    }

    private void asb() {
        HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
        mX.f(new UbcFlowEvent("updatePkgWithPresetCheckStart").eI(true));
        log(this.cea == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        com.baidu.swan.apps.core.j.c kk = com.baidu.swan.apps.core.j.f.acR().kk(getAppId());
        int i = this.cea == null ? -1 : this.cea.versionCode;
        int i2 = kk != null ? kk.versionCode : -1;
        boolean z = i2 > i;
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)));
            }
        } else {
            log(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        if (!z) {
            asc();
            return;
        }
        oi("event_on_still_maintaining");
        mX.f(new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp").eI(true));
        com.baidu.swan.apps.core.j.f.acR().a(kk, new com.baidu.swan.apps.core.j.d() { // from class: com.baidu.swan.apps.runtime.k.3
            @Override // com.baidu.swan.apps.core.j.d
            public void i(PMSAppInfo pMSAppInfo) {
                HybridUbcFlow mX2 = com.baidu.swan.apps.performance.i.mX("startup");
                mX2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdate").eI(true));
                k.this.o(pMSAppInfo);
                mX2.f(new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon").eI(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void j(PMSAppInfo pMSAppInfo) {
                k.this.cHD = 5;
                k.this.d("KEY_PKG_STATE", "event_pms_check_finish", k.this.cHD);
                HybridUbcFlow mX2 = com.baidu.swan.apps.performance.i.mX("startup");
                mX2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart").eI(true));
                k.log("预制包安装成功");
                k.a(k.this.arU(), pMSAppInfo, false, false, true);
                k.this.n(pMSAppInfo);
                k.this.V(null);
                mX2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd").eI(true));
            }

            @Override // com.baidu.swan.apps.core.j.d
            public void onFailed(int i3) {
                HybridUbcFlow mX2 = com.baidu.swan.apps.performance.i.mX("startup");
                mX2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart").eI(true));
                k.log("预制包安装失败");
                k.this.asc();
                mX2.f(new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd").eI(true));
            }
        });
        mX.f(new UbcFlowEvent("updatePkgWithPresetCheckReturn").eI(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asc() {
        d.arr().oi("event_pms_check_start");
        final HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
        mX.f(new UbcFlowEvent("updatePkgOnPresetUnavailableStart").eI(true));
        final com.baidu.swan.apps.u.c.b arU = arU();
        log("预置包不可用");
        boolean asd = asd();
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + asd);
        }
        if (!asd) {
            log("可以直接打开小程序，异步从Server拉取新包");
            this.cHD = 4;
            a(arU, this.cea, false, false, false);
            this.cHD = this.cHE ? 3 : 4;
            V(null);
            d("KEY_PKG_STATE", "event_pms_check_finish", this.cHD);
            return;
        }
        log("不能直接打开小程序，同步从Server拉取新包");
        d("KEY_PKG_STATE", "event_pms_check_finish", this.cHD);
        a(this.cez.arz().getAppId(), new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.runtime.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                Bundle result = bVar.getResult();
                k.a(arU, k.this.cea, true, result != null ? result.getBoolean("isDownloading", false) : false, false);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 1000L;
            }
        });
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(getAppId(), arU.getAppFrameType());
        cVar.uE("3");
        cVar.jN(this.cea == null ? 0 : this.cea.versionCode);
        cVar.ce(this.cea == null ? 0L : this.cea.appSign);
        String delAllParamsFromUrl = aj.delAllParamsFromUrl(arU.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl)) {
            if (delAllParamsFromUrl.startsWith(File.separator)) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            cVar.uA(delAllParamsFromUrl);
        }
        mX.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest").eI(true));
        i((i.a) new i.a("event_on_still_maintaining").O(" event_params_pkg_update", this.cHG));
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.g(this.cez) { // from class: com.baidu.swan.apps.runtime.k.7
            @Override // com.baidu.swan.apps.core.pms.g, com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
            public void a(com.baidu.swan.pms.f.f fVar) {
                k.log("mFlagDownloading set onPrepareDownload");
                k.this.cHA = true;
                d.arr().oi("event_pkg_download_start");
                super.a(fVar);
            }

            @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
            public void abS() {
                k.log("mFlagDownloading reset onTotalPkgDownloadFinish");
                k.this.cHA = false;
                d.arr().oi("event_pkg_download_finish");
                super.abS();
            }
        }.c(new com.baidu.swan.apps.aq.e.b<PMSAppInfo>() { // from class: com.baidu.swan.apps.runtime.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: q */
            public void H(PMSAppInfo pMSAppInfo) {
                mX.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart").eI(true));
                if (com.baidu.swan.apps.performance.b.b.aoo()) {
                    if (k.DEBUG) {
                        k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                    }
                } else {
                    k.log("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                k.this.n(pMSAppInfo);
                mX.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd").eI(true));
            }
        }).a(new com.baidu.swan.apps.core.pms.a.a() { // from class: com.baidu.swan.apps.runtime.k.5
            @Override // com.baidu.swan.apps.core.pms.a.a
            public void b(com.baidu.swan.apps.an.a aVar, boolean z) {
                k.log("mFlagDownloading reset onFinalFailed");
                k.this.cHA = false;
                d.arr().oi("event_pkg_download_finish");
                mX.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart").eI(true));
                k.log("onFinalFailed");
                com.baidu.swan.apps.an.e.avX().g(aVar);
                if (z) {
                    k.this.cHD = k.this.cHE ? 3 : 4;
                    k.this.d("KEY_PKG_STATE", "event_pms_check_finish", k.this.cHD);
                    k.this.b(aVar);
                } else {
                    if (aVar != null && aVar.avP() == 1020) {
                        k.this.e(aVar);
                    }
                    k.this.fs(false);
                }
                mX.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd").eI(true));
            }

            @Override // com.baidu.swan.apps.core.pms.a.a
            public void f(PMSAppInfo pMSAppInfo) {
                k.log("mFlagDownloading reset onFinalComplete");
                k.this.cHA = false;
                k.this.cHD = k.this.cHC ? 2 : 0;
                k.this.cHD = k.this.cHE ? 1 : k.this.cHD;
                k.this.d("KEY_PKG_STATE", "event_pms_check_finish", k.this.cHD);
                mX.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart").eI(true));
                k.log("onFinalComplete");
                k.this.n(pMSAppInfo);
                k.this.c((com.baidu.swan.apps.an.a) null);
                mX.f(new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd").eI(true));
            }
        }).fn(this.cHE ? 2 : 1));
        mX.f(new UbcFlowEvent("updatePkgOnPresetUnavailableReturn").eI(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        d.arr().g(str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(PMSAppInfo pMSAppInfo) {
        this.cea = pMSAppInfo;
        this.cez.arz().l(pMSAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").bw("mAppId", getAppId())).M("appFrameType", pMSAppInfo.appCategory);
            log("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                log("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                aVar.bw("app_name", pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                log("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                aVar.M(Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                log("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                aVar.bw("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.O("event_flag_force_post", true);
            i(aVar);
        }
    }

    private boolean asd() {
        HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
        if (this.cea == null) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            mX.bH("launch_state", String.valueOf(0));
            d("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
            return true;
        } else if (this.cea.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.cHC = true;
            mX.bH("launch_state", String.valueOf(2));
            d("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cea.aLe()) {
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.cHC = true;
            mX.bH("launch_state", String.valueOf(2));
            d("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.cea.aLf()) {
            if (com.baidu.swan.apps.core.a.b.a.Zy().jA(getAppId())) {
                if (DEBUG) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                mX.bH("launch_state", String.valueOf(3));
                d("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            d("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
            mX.bH("launch_state", String.valueOf(1));
            this.cHE = true;
            return true;
        } else {
            mX.bH("launch_state", String.valueOf(4));
            d("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
            return false;
        }
    }

    public static void a(com.baidu.swan.apps.u.c.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.ajm().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.ajm().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.ajm().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.ho(eVar.getAppFrameType());
        fVar.d(eVar);
        fVar.mType = Config.LAUNCH;
        fVar.cOE = z ? "1" : "0";
        fVar.cOG = z3 ? "1" : "0";
        fVar.cOF = z2 ? "1" : "0";
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        final String aji = eVar.aji();
        final String string = eVar.ajm().getString("ubc");
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.runtime.k.8
                @Override // java.lang.Runnable
                public void run() {
                    k.a(com.baidu.swan.apps.statistic.a.f.this, aji, string);
                }
            }, "launchStatistic", 2);
        } else {
            a(fVar, aji, string);
        }
    }

    public static void a(com.baidu.swan.apps.statistic.a.f fVar, String str, String str2) {
        JSONObject pp = com.baidu.swan.apps.statistic.h.pp(str);
        fVar.py(str2);
        fVar.bG(pp);
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    private void a(boolean z, String str, com.baidu.swan.apps.an.a aVar) {
        if (this.cea != null) {
            Context context = getContext();
            e arw = e.arw();
            if (arw != null) {
                String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), al.getVersionName(), com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.akr().ajT(), arw.Se().getAppFrameType()), String.valueOf(aVar.avT()));
                if (!com.baidu.swan.apps.t.a.ahQ().a(context, arw.getAppKey(), aVar)) {
                    Intent intent = new Intent();
                    intent.putExtra("pms_db_info_onload", this.cea);
                    intent.putExtra("swan_error_type", z ? "type_path_forbidden" : "type_app_forbidden");
                    ForbiddenInfo forbiddenInfo = new ForbiddenInfo(arU(), str, format);
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
            com.baidu.swan.apps.u.c.b arU = arU();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.ho(arU.getAppFrameType());
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.c(arU);
            fVar.v("status", "2");
            fVar.py(arU.ajm().getString("ubc"));
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
        int appFrameType = arU().getAppFrameType();
        int i = pMSAppInfo.appCategory;
        if (i <= -1 && appFrameType != i) {
            return 10002;
        }
        return 0;
    }

    private com.baidu.swan.apps.an.a hf(int i) {
        com.baidu.swan.apps.an.a aVar = new com.baidu.swan.apps.an.a();
        switch (i) {
            case 10001:
                aVar.bJ(10L).bK(2902L).qm("no aiapps info in database");
                break;
            case 10002:
                aVar.bJ(10L).bK(27L).qm("category not match");
                break;
            case 10003:
                aVar.bJ(10L).bK(2107L).qk("app forbiddeon");
                break;
            case 10004:
                aVar.bJ(10L).bK(48L).qk("path forbiddeon");
                break;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.an.a aVar) {
        if (c(aVar)) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().f(aVar).a(arU()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.swan.apps.an.a aVar) {
        HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
        mX.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart").eI(true));
        if (!d(aVar)) {
            log("updateInstalledPkgWithFinalCheck by null launchParams");
            fs(false);
            return false;
        }
        mX.f(new UbcFlowEvent("updateInfoWithFinalCheckOk").eI(true));
        b.a arz = this.cez.arz();
        long qb = com.baidu.swan.apps.swancore.b.qb(arz.ajr());
        long j = arz.adQ() != null ? arz.adQ().swanCoreVersion : 0L;
        if (DEBUG) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + arz.ajr() + " targetSwanVersion: " + qb + " ,curSwanVersion: " + j);
        }
        if (qb > j) {
            com.baidu.swan.apps.swancore.b.hu(arz.getAppFrameType());
        }
        if (!com.baidu.swan.apps.performance.b.b.aoo()) {
            arz.bv("extra_data_uid_key", com.baidu.swan.apps.t.a.aho().be(getContext()));
        }
        com.baidu.swan.apps.performance.i.mX("startup").bH("launch_type", String.valueOf(com.baidu.swan.apps.ap.a.awc()));
        if (arz.getAppFrameType() == 0) {
            ase();
        }
        mX.f(new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd").eI(true));
        fs(true);
        com.baidu.swan.apps.env.c aeJ = com.baidu.swan.apps.env.e.aeI().aeJ();
        if (aeJ != null && aeJ.aeC()) {
            aeJ.kD(getAppId());
        }
        return true;
    }

    private void ase() {
        com.baidu.swan.apps.r.d.d(this.cez);
    }

    private boolean d(com.baidu.swan.apps.an.a aVar) {
        com.baidu.swan.apps.performance.i.mX("startup").f(new UbcFlowEvent("updateInfoWithFinalCheckStart").eI(true));
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                log("updateInfoWithFinalCheck: mAppInfo=" + this.cea);
            }
        } else {
            log("updateInfoWithFinalCheck: mAppInfo=" + this.cea);
        }
        if (this.cea == null) {
            if (aVar == null) {
                aVar = new com.baidu.swan.apps.an.a().bJ(10L).bK(2902L).qm("no pkg was installed");
            }
            com.baidu.swan.apps.an.e.avX().g(aVar);
            e(aVar);
            return false;
        }
        int p = p(this.cea);
        if (p == 10001 || p == 10002) {
            if (aVar == null) {
                aVar = hf(p);
            }
            com.baidu.swan.apps.an.e.avX().g(aVar);
            e(aVar);
            return false;
        }
        asf();
        if (p != 0) {
            com.baidu.swan.apps.an.a hf = hf(10003);
            com.baidu.swan.apps.an.e.avX().g(hf);
            a(false, (String) null, hf);
            com.baidu.swan.apps.performance.i.a(hf);
            return false;
        }
        if (com.baidu.swan.apps.scheme.actions.forbidden.a.asG().oQ(arn().arz().getPage())) {
            com.baidu.swan.apps.an.a hf2 = hf(10004);
            com.baidu.swan.apps.an.e.avX().g(hf2);
            a(true, com.baidu.swan.apps.scheme.actions.forbidden.a.asG().asH(), hf2);
            com.baidu.swan.apps.performance.i.a(hf2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.swan.apps.an.a aVar) {
        com.baidu.swan.apps.performance.i.a(aVar);
        Context context = getContext();
        if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
            if (DEBUG) {
                Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                return;
            }
            return;
        }
        com.baidu.swan.apps.u.c.b arU = arU();
        int appFrameType = arU.getAppFrameType();
        com.baidu.swan.apps.u.b.a.a(com.baidu.swan.apps.t.a.ahj(), aVar, appFrameType, getAppId(), true);
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.h.ho(appFrameType);
        fVar.mType = Config.LAUNCH;
        fVar.mValue = "fail";
        fVar.v("errcode", String.valueOf(aVar.avT()));
        fVar.v("msg", aVar.avS().toString());
        fVar.d(arU);
        fVar.py(arU.ajm().getString("ubc"));
        fVar.bG(com.baidu.swan.apps.statistic.h.pp(arU.aji()));
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
        if (!aVar.avU()) {
            com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().pu(com.baidu.swan.apps.statistic.h.ho(appFrameType)).f(aVar).pv(getAppId()).pw(arU.ajg()));
            aVar.avV();
        }
    }

    private void asf() {
        int i = 1;
        b.a arz = arn().arz();
        boolean z = (this.cea == null || TextUtils.isEmpty(this.cea.appId) || !TextUtils.equals(getAppId(), this.cea.appId)) ? false : true;
        if (z) {
            arz.k(this.cea);
        }
        if (!z || this.cea.appCategory != 1) {
            i = 0;
        }
        arz.fY(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void fs(boolean z) {
        this.cHz = false;
        this.cHB = z;
        this.cea = null;
        log("notifyMaintainFinish: " + z);
        i((i.a) new i.a("event_on_pkg_maintain_finish").bw("mAppId", this.cez.id));
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                com.baidu.swan.apps.u.d.a.lT(this.cHF).ajI();
            }
        } else {
            com.baidu.swan.apps.u.d.a.lT(this.cHF).ajI();
        }
        this.cHF = "";
    }

    private Context getContext() {
        SwanAppActivity arp = this.cez.arp();
        return (arp == null || arp.isDestroyed()) ? com.baidu.swan.apps.t.a.ahj() : arp;
    }

    private void a(@NonNull String str, @NonNull com.baidu.swan.apps.process.a.b.c.b bVar) {
        com.baidu.swan.apps.process.messaging.client.a apG = com.baidu.swan.apps.process.messaging.client.a.apG();
        if (apG == null) {
            com.baidu.swan.apps.process.a.b.a.b bVar2 = new com.baidu.swan.apps.process.a.b.a.b(bVar.apm());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.m(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appId", str);
        apG.b(bundle2, a.class, bVar);
    }

    /* loaded from: classes7.dex */
    public static class a extends com.baidu.swan.apps.process.a.a.a {
        @Override // com.baidu.swan.apps.process.a.a.a
        public void A(@NonNull Bundle bundle) {
            boolean z = false;
            String string = bundle.getString("appId");
            if (TextUtils.isEmpty(string)) {
                this.cAx.putBoolean("isDownloading", false);
                finish();
                return;
            }
            boolean uo = com.baidu.swan.pms.c.uo(string);
            boolean up = com.baidu.swan.pms.c.up(string);
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "isDownloading: " + uo + ", isInQueue: " + up);
            }
            this.cAx.putBoolean("isDownloading", (uo || up) ? true : true);
            finish();
        }
    }
}
