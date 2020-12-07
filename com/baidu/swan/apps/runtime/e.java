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
/* loaded from: classes25.dex */
public class e extends m {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final boolean dyd;
    SwanAppConfigData dye;
    com.baidu.swan.games.t.a.a dyf;
    private com.baidu.swan.apps.storage.c dyg;
    private com.baidu.swan.apps.storage.b.c dyh;
    private com.baidu.swan.apps.setting.a dyi;
    private com.baidu.swan.apps.a.b dyj;
    private com.baidu.swan.apps.network.j dyk;
    private com.baidu.swan.games.network.b dyl;
    private com.baidu.swan.apps.ag.a.a dym;
    private com.baidu.swan.apps.media.audio.d dyn;
    private com.baidu.swan.apps.network.k dyo;
    private g dyp;
    private Map<String, String> dyq;
    private final k dyr;
    protected final b.a dys;
    private boolean dyt;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.dyr = new k(this);
        this.dys = new b.a();
        this.dyt = false;
        this.id = str == null ? "" : str;
        this.dyd = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.dyd) {
            this.dym = new com.baidu.swan.apps.ag.a.a();
            this.dym.sS(this.id);
        }
    }

    @Deprecated
    public static e aJU() {
        return aJV();
    }

    public static e aJV() {
        d aJQ = d.aJQ();
        if (aJQ.aId()) {
            return aJQ.aJM();
        }
        return null;
    }

    @Deprecated
    public static String aJW() {
        return d.aJQ().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aId() {
        return this.dyd;
    }

    public boolean ama() {
        com.baidu.swan.apps.framework.c aif;
        if (com.baidu.swan.apps.core.prefetch.a.a.isOn()) {
            SwanAppActivity aJO = aJO();
            return aJO == null || (aif = aJO.aif()) == null || !aif.axr().hasStarted();
        }
        return false;
    }

    public boolean aJX() {
        com.baidu.swan.apps.framework.c aif;
        SwanAppActivity aJO = aJO();
        if (aJO == null || (aif = aJO.aif()) == null) {
            return false;
        }
        return aif.axr().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String z(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity aJO = aJO();
        if (aJO != null && !aJO.isDestroyed() && !aJO.isFinishing() && aJO.aig()) {
            aJO.q(strArr);
        }
        com.baidu.swan.apps.v.f.release();
        if (this.dyp != null) {
            this.dyp.onDestroy();
        }
        com.baidu.swan.c.d.deleteFile(com.baidu.swan.apps.storage.b.tX(this.id));
        if (this.dyn != null) {
            this.dyn.release();
        }
        if (this.dym != null) {
            this.dym.release();
        }
        if (this.dyo != null) {
            this.dyo.release();
        }
        this.dyg = null;
        this.dyi = null;
        this.dyl = null;
        this.dyt = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aIe() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(aJY().auD());
        swanAppCores.a(aJY().auE());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e aJM() {
        return this;
    }

    @NonNull
    public b.a aJY() {
        return this.dys;
    }

    @NonNull
    @Deprecated
    public b.a aio() {
        return aJY();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int aie() {
        if (this.dyd) {
            return aJY().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = dyv.contains(str);
        b.a aJY = aJY();
        HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
        rk.f(new UbcFlowEvent("swan_app_update_info_start").gk(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.dyr.aKw() && aJX()) {
            if (aJY.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (aJY.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        aJY.D(bundle);
        rk.f(new UbcFlowEvent("swan_app_update_info_end").gk(true));
        if (z) {
            sv("event_on_app_occupied");
        }
        if (this.dyd && !this.dyr.aKw() && !this.dyr.aKu()) {
            rk.f(new UbcFlowEvent("swan_app_maintain_start").gk(true));
            this.dyr.aKx();
            rk.f(new UbcFlowEvent("swan_app_maintain_return").gk(true));
            return true;
        }
        if (this.dyr.aKw() && contains) {
            k.a(aJY, aJY.aBu(), false, false, false);
        }
        return this.dyr.aKu();
    }

    public com.baidu.swan.apps.u.c.b S(Bundle bundle) {
        b.a aJY = aJY();
        aJY.D(bundle);
        return aJY;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void aJN() {
        aKg().aLB();
        aKf().av(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void sv(String str) {
        f(str, aKc());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = aKc();
        } else {
            bundle.putAll(aKc());
        }
        super.f(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.D(aKc()));
    }

    public boolean aJZ() {
        return this.dyr.aKu();
    }

    public boolean aKa() {
        return this.dyr.aKv();
    }

    public int aKb() {
        return this.dyr.aKb();
    }

    private Bundle aKc() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void K(Activity activity) {
        aKg().K(activity);
    }

    public void g(SwanAppConfigData swanAppConfigData) {
        this.dye = swanAppConfigData;
    }

    public SwanAppConfigData aKd() {
        return this.dye;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.dyf = aVar;
    }

    public com.baidu.swan.games.t.a.a aKe() {
        return this.dyf;
    }

    public com.baidu.swan.apps.storage.c aKf() {
        if (this.dyg == null) {
            this.dyg = new com.baidu.swan.apps.storage.c(this);
        }
        return this.dyg;
    }

    public com.baidu.swan.apps.storage.b.c aBV() {
        if (this.dyh == null) {
            if (aKn()) {
                this.dyh = new com.baidu.swan.games.i.l();
            } else {
                this.dyh = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.dyh;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a aKg() {
        if (this.dyi == null) {
            this.dyi = new com.baidu.swan.apps.setting.a(this);
        }
        return this.dyi;
    }

    public com.baidu.swan.apps.a.b aKh() {
        if (this.dyj == null) {
            this.dyj = new com.baidu.swan.apps.a.b(this);
        }
        return this.dyj;
    }

    public synchronized com.baidu.swan.apps.network.j aKi() {
        if (this.dyk == null) {
            this.dyk = new com.baidu.swan.apps.network.j(this);
        }
        return this.dyk;
    }

    public synchronized com.baidu.swan.games.network.b aKj() {
        if (this.dyl == null) {
            this.dyl = com.baidu.swan.games.network.b.aYN();
        }
        return this.dyl;
    }

    public com.baidu.swan.apps.network.k aKk() {
        if (this.dyo == null) {
            this.dyo = new com.baidu.swan.apps.network.k();
        }
        return this.dyo;
    }

    public com.baidu.swan.apps.media.audio.d aKl() {
        if (this.dyn == null) {
            this.dyn = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.dyn;
    }

    @NonNull
    public g aKm() {
        if (this.dyp == null) {
            this.dyp = new g(this);
        }
        return this.dyp;
    }

    public String getAppKey() {
        return aJY().getAppKey();
    }

    public boolean aKn() {
        return aJY().getAppFrameType() == 1;
    }

    public String getName() {
        return aJY().avf();
    }

    public String getVersion() {
        return aJY().getVersion();
    }

    public com.baidu.swan.apps.ag.a.a aKo() {
        if (this.dym == null) {
            this.dym = new com.baidu.swan.apps.ag.a.a();
        }
        return this.dym;
    }

    public boolean sw(String str) {
        if (TextUtils.isEmpty(str) || this.dye == null || this.dye.dyS == null) {
            return false;
        }
        return this.dye.dyS.sQ(str);
    }

    public boolean sx(String str) {
        if (TextUtils.isEmpty(str) || this.dye == null || this.dye.dyT == null || this.dye.dyT.dzu == null || !this.dye.dyT.dzu.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.dye.dyT.dzu.get(str).booleanValue();
    }

    public boolean sy(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.bdF().ah(this.id, getVersion(), str);
    }

    public boolean sz(String str) {
        return new File(com.baidu.swan.apps.v.f.aCp().aBW(), str).exists();
    }

    public void ac(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dye != null && this.dye.dyT != null && this.dye.dyT.dzu != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dye.dyT.dzu.put(str, Boolean.valueOf(z));
        }
    }

    public String lb(String str) {
        if (this.dye == null || this.dye.dyT == null || this.dye.dyT.dzv == null) {
            return null;
        }
        return this.dye.dyT.dzv.get(com.baidu.swan.apps.scheme.actions.k.j.tm(str));
    }

    public String sA(String str) {
        if (this.dye == null || this.dye.dyU == null || this.dye.dyU.dzx == null) {
            return null;
        }
        return this.dye.dyU.dzx.get(str);
    }

    public String sB(String str) {
        if (this.dye == null) {
            return "";
        }
        return this.dye.sB(str);
    }

    public boolean sC(String str) {
        if (TextUtils.isEmpty(str) || this.dye == null) {
            return false;
        }
        return this.dye.sM(str);
    }

    public boolean aKp() {
        return sC(com.baidu.swan.apps.v.f.aCp().aCu());
    }

    public String aKq() {
        b.a aJY = aJY();
        return aJY != null ? kI(aJY.getType()) : "0";
    }

    private String kI(int i) {
        if (i == 0) {
            String versionCode = this.dys != null ? this.dys.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String va = ak.va(versionCode);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(va) ? " version is empty " : va;
            com.baidu.swan.apps.console.c.d("SwanApp", objArr);
            return va;
        }
        return "0";
    }

    public void cw(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.dyq == null) {
                this.dyq = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.dyq.put(str2, str);
        }
    }

    @Nullable
    public String sD(String str) {
        if (TextUtils.isEmpty(str) || this.dyq == null) {
            return null;
        }
        return this.dyq.get(str);
    }

    public boolean available() {
        return this.dyd && this.dyr.aKw() && aie() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return aJO();
    }

    public e gT(boolean z) {
        this.dyt = z;
        sv("event_first_action_launched");
        return this;
    }

    public boolean aKr() {
        return this.dyt;
    }
}
