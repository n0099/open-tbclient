package com.baidu.swan.apps.runtime;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.u.c.b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class e extends m {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final boolean drb;
    SwanAppConfigData drc;
    com.baidu.swan.games.t.a.a drd;
    private com.baidu.swan.apps.storage.c dre;
    private com.baidu.swan.apps.storage.b.c drf;
    private com.baidu.swan.apps.setting.a drg;
    private com.baidu.swan.apps.a.b drh;
    private com.baidu.swan.apps.network.j dri;
    private com.baidu.swan.games.network.b drj;
    private com.baidu.swan.apps.ag.a.a drk;
    private com.baidu.swan.apps.media.audio.d drl;
    private com.baidu.swan.apps.network.k drm;
    private g drn;
    private Map<String, String> dro;
    private final k drp;
    protected final b.a drq;
    private boolean drr;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.drp = new k(this);
        this.drq = new b.a();
        this.drr = false;
        this.id = str == null ? "" : str;
        this.drb = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.drb) {
            this.drk = new com.baidu.swan.apps.ag.a.a();
            this.drk.sk(this.id);
        }
    }

    @Deprecated
    public static e aGM() {
        return aGN();
    }

    public static e aGN() {
        d aGI = d.aGI();
        if (aGI.aEV()) {
            return aGI.aGE();
        }
        return null;
    }

    @Deprecated
    public static String aGO() {
        return d.aGI().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aEV() {
        return this.drb;
    }

    public boolean aiS() {
        com.baidu.swan.apps.framework.c aeX;
        if (com.baidu.swan.apps.core.prefetch.a.a.isOn()) {
            SwanAppActivity aGG = aGG();
            return aGG == null || (aeX = aGG.aeX()) == null || !aeX.auj().hasStarted();
        }
        return false;
    }

    public boolean aGP() {
        com.baidu.swan.apps.framework.c aeX;
        SwanAppActivity aGG = aGG();
        if (aGG == null || (aeX = aGG.aeX()) == null) {
            return false;
        }
        return aeX.auj().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String z(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity aGG = aGG();
        if (aGG != null && !aGG.isDestroyed() && !aGG.isFinishing() && aGG.aeY()) {
            aGG.q(strArr);
        }
        com.baidu.swan.apps.v.f.release();
        if (this.drn != null) {
            this.drn.onDestroy();
        }
        com.baidu.swan.c.d.deleteFile(com.baidu.swan.apps.storage.b.tq(this.id));
        if (this.drl != null) {
            this.drl.release();
        }
        if (this.drk != null) {
            this.drk.release();
        }
        if (this.drm != null) {
            this.drm.release();
        }
        this.dre = null;
        this.drg = null;
        this.drj = null;
        this.drr = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aEW() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(aGQ().arv());
        swanAppCores.a(aGQ().arw());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e aGE() {
        return this;
    }

    @NonNull
    public b.a aGQ() {
        return this.drq;
    }

    @NonNull
    @Deprecated
    public b.a afg() {
        return aGQ();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int aeW() {
        if (this.drb) {
            return aGQ().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = dru.contains(str);
        b.a aGQ = aGQ();
        HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
        qD.f(new UbcFlowEvent("swan_app_update_info_start").fV(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.drp.aHo() && aGP()) {
            if (aGQ.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (aGQ.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        aGQ.D(bundle);
        qD.f(new UbcFlowEvent("swan_app_update_info_end").fV(true));
        if (z) {
            rN("event_on_app_occupied");
        }
        if (this.drb && !this.drp.aHo() && !this.drp.aHm()) {
            qD.f(new UbcFlowEvent("swan_app_maintain_start").fV(true));
            this.drp.aHp();
            qD.f(new UbcFlowEvent("swan_app_maintain_return").fV(true));
            return true;
        }
        if (this.drp.aHo() && contains) {
            k.a(aGQ, aGQ.ayl(), false, false, false);
        }
        return this.drp.aHm();
    }

    public com.baidu.swan.apps.u.c.b S(Bundle bundle) {
        b.a aGQ = aGQ();
        aGQ.D(bundle);
        return aGQ;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void aGF() {
        aGY().aIt();
        aGX().aw(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void rN(String str) {
        f(str, aGU());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = aGU();
        } else {
            bundle.putAll(aGU());
        }
        super.f(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.D(aGU()));
    }

    public boolean aGR() {
        return this.drp.aHm();
    }

    public boolean aGS() {
        return this.drp.aHn();
    }

    public int aGT() {
        return this.drp.aGT();
    }

    private Bundle aGU() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void K(Activity activity) {
        aGY().K(activity);
    }

    public void g(SwanAppConfigData swanAppConfigData) {
        this.drc = swanAppConfigData;
    }

    public SwanAppConfigData aGV() {
        return this.drc;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.drd = aVar;
    }

    public com.baidu.swan.games.t.a.a aGW() {
        return this.drd;
    }

    public com.baidu.swan.apps.storage.c aGX() {
        if (this.dre == null) {
            this.dre = new com.baidu.swan.apps.storage.c(this);
        }
        return this.dre;
    }

    public com.baidu.swan.apps.storage.b.c ayM() {
        if (this.drf == null) {
            if (aHf()) {
                this.drf = new com.baidu.swan.games.i.l();
            } else {
                this.drf = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.drf;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a aGY() {
        if (this.drg == null) {
            this.drg = new com.baidu.swan.apps.setting.a(this);
        }
        return this.drg;
    }

    public com.baidu.swan.apps.a.b aGZ() {
        if (this.drh == null) {
            this.drh = new com.baidu.swan.apps.a.b(this);
        }
        return this.drh;
    }

    public synchronized com.baidu.swan.apps.network.j aHa() {
        if (this.dri == null) {
            this.dri = new com.baidu.swan.apps.network.j(this);
        }
        return this.dri;
    }

    public synchronized com.baidu.swan.games.network.b aHb() {
        if (this.drj == null) {
            this.drj = com.baidu.swan.games.network.b.aVI();
        }
        return this.drj;
    }

    public com.baidu.swan.apps.network.k aHc() {
        if (this.drm == null) {
            this.drm = new com.baidu.swan.apps.network.k();
        }
        return this.drm;
    }

    public com.baidu.swan.apps.media.audio.d aHd() {
        if (this.drl == null) {
            this.drl = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.drl;
    }

    @NonNull
    public g aHe() {
        if (this.drn == null) {
            this.drn = new g(this);
        }
        return this.drn;
    }

    public String getAppKey() {
        return aGQ().getAppKey();
    }

    public boolean aHf() {
        return aGQ().getAppFrameType() == 1;
    }

    public String getName() {
        return aGQ().arW();
    }

    public String getVersion() {
        return aGQ().getVersion();
    }

    public com.baidu.swan.apps.ag.a.a aHg() {
        if (this.drk == null) {
            this.drk = new com.baidu.swan.apps.ag.a.a();
        }
        return this.drk;
    }

    public boolean rO(String str) {
        if (TextUtils.isEmpty(str) || this.drc == null || this.drc.drR == null) {
            return false;
        }
        return this.drc.drR.si(str);
    }

    public boolean rP(String str) {
        if (TextUtils.isEmpty(str) || this.drc == null || this.drc.drS == null || this.drc.drS.dsu == null || !this.drc.drS.dsu.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.drc.drS.dsu.get(str).booleanValue();
    }

    public boolean rQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.baA().ae(this.id, getVersion(), str);
    }

    public boolean rR(String str) {
        return new File(com.baidu.swan.apps.v.f.azg().ayN(), str).exists();
    }

    public void ab(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.drc != null && this.drc.drS != null && this.drc.drS.dsu != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.drc.drS.dsu.put(str, Boolean.valueOf(z));
        }
    }

    public String ku(String str) {
        if (this.drc == null || this.drc.drS == null || this.drc.drS.dsv == null) {
            return null;
        }
        return this.drc.drS.dsv.get(com.baidu.swan.apps.scheme.actions.k.j.sF(str));
    }

    public String rS(String str) {
        if (this.drc == null || this.drc.drT == null || this.drc.drT.dsx == null) {
            return null;
        }
        return this.drc.drT.dsx.get(str);
    }

    public String rT(String str) {
        if (this.drc == null) {
            return "";
        }
        return this.drc.rT(str);
    }

    public boolean rU(String str) {
        if (TextUtils.isEmpty(str) || this.drc == null) {
            return false;
        }
        return this.drc.se(str);
    }

    public boolean aHh() {
        return rU(com.baidu.swan.apps.v.f.azg().azl());
    }

    public String aHi() {
        b.a aGQ = aGQ();
        return aGQ != null ? kk(aGQ.getType()) : "0";
    }

    private String kk(int i) {
        if (i == 0) {
            String versionCode = this.drq != null ? this.drq.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String ut = ak.ut(versionCode);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(ut) ? " version is empty " : ut;
            com.baidu.swan.apps.console.c.d("SwanApp", objArr);
            return ut;
        }
        return "0";
    }

    public void cp(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.dro == null) {
                this.dro = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.dro.put(str2, str);
        }
    }

    @Nullable
    public String rV(String str) {
        if (TextUtils.isEmpty(str) || this.dro == null) {
            return null;
        }
        return this.dro.get(str);
    }

    public boolean available() {
        return this.drb && this.drp.aHo() && aeW() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return aGG();
    }

    public e gE(boolean z) {
        this.drr = z;
        rN("event_first_action_launched");
        return this;
    }

    public boolean aHj() {
        return this.drr;
    }
}
