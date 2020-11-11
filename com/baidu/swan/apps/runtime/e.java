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
/* loaded from: classes10.dex */
public class e extends m {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final boolean dsK;
    SwanAppConfigData dsL;
    com.baidu.swan.games.t.a.a dsM;
    private com.baidu.swan.apps.storage.c dsN;
    private com.baidu.swan.apps.storage.b.c dsO;
    private com.baidu.swan.apps.setting.a dsP;
    private com.baidu.swan.apps.a.b dsQ;
    private com.baidu.swan.apps.network.j dsR;
    private com.baidu.swan.games.network.b dsS;
    private com.baidu.swan.apps.ag.a.a dsT;
    private com.baidu.swan.apps.media.audio.d dsU;
    private com.baidu.swan.apps.network.k dsV;
    private g dsW;
    private Map<String, String> dsX;
    private final k dsY;
    protected final b.a dsZ;
    private boolean dta;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.dsY = new k(this);
        this.dsZ = new b.a();
        this.dta = false;
        this.id = str == null ? "" : str;
        this.dsK = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.dsK) {
            this.dsT = new com.baidu.swan.apps.ag.a.a();
            this.dsT.sp(this.id);
        }
    }

    @Deprecated
    public static e aHu() {
        return aHv();
    }

    public static e aHv() {
        d aHq = d.aHq();
        if (aHq.aFD()) {
            return aHq.aHm();
        }
        return null;
    }

    @Deprecated
    public static String aHw() {
        return d.aHq().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aFD() {
        return this.dsK;
    }

    public boolean ajA() {
        com.baidu.swan.apps.framework.c afF;
        if (com.baidu.swan.apps.core.prefetch.a.a.isOn()) {
            SwanAppActivity aHo = aHo();
            return aHo == null || (afF = aHo.afF()) == null || !afF.auR().hasStarted();
        }
        return false;
    }

    public boolean aHx() {
        com.baidu.swan.apps.framework.c afF;
        SwanAppActivity aHo = aHo();
        if (aHo == null || (afF = aHo.afF()) == null) {
            return false;
        }
        return afF.auR().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String z(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity aHo = aHo();
        if (aHo != null && !aHo.isDestroyed() && !aHo.isFinishing() && aHo.afG()) {
            aHo.q(strArr);
        }
        com.baidu.swan.apps.v.f.release();
        if (this.dsW != null) {
            this.dsW.onDestroy();
        }
        com.baidu.swan.c.d.deleteFile(com.baidu.swan.apps.storage.b.tv(this.id));
        if (this.dsU != null) {
            this.dsU.release();
        }
        if (this.dsT != null) {
            this.dsT.release();
        }
        if (this.dsV != null) {
            this.dsV.release();
        }
        this.dsN = null;
        this.dsP = null;
        this.dsS = null;
        this.dta = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aFE() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(aHy().asd());
        swanAppCores.a(aHy().ase());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e aHm() {
        return this;
    }

    @NonNull
    public b.a aHy() {
        return this.dsZ;
    }

    @NonNull
    @Deprecated
    public b.a afO() {
        return aHy();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int afE() {
        if (this.dsK) {
            return aHy().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = dtc.contains(str);
        b.a aHy = aHy();
        HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
        qJ.f(new UbcFlowEvent("swan_app_update_info_start").fS(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.dsY.aHW() && aHx()) {
            if (aHy.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (aHy.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        aHy.D(bundle);
        qJ.f(new UbcFlowEvent("swan_app_update_info_end").fS(true));
        if (z) {
            rT("event_on_app_occupied");
        }
        if (this.dsK && !this.dsY.aHW() && !this.dsY.aHU()) {
            qJ.f(new UbcFlowEvent("swan_app_maintain_start").fS(true));
            this.dsY.aHX();
            qJ.f(new UbcFlowEvent("swan_app_maintain_return").fS(true));
            return true;
        }
        if (this.dsY.aHW() && contains) {
            k.a(aHy, aHy.ayT(), false, false, false);
        }
        return this.dsY.aHU();
    }

    public com.baidu.swan.apps.u.c.b S(Bundle bundle) {
        b.a aHy = aHy();
        aHy.D(bundle);
        return aHy;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void aHn() {
        aHG().aJb();
        aHF().aw(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void rT(String str) {
        f(str, aHC());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = aHC();
        } else {
            bundle.putAll(aHC());
        }
        super.f(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.D(aHC()));
    }

    public boolean aHz() {
        return this.dsY.aHU();
    }

    public boolean aHA() {
        return this.dsY.aHV();
    }

    public int aHB() {
        return this.dsY.aHB();
    }

    private Bundle aHC() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void L(Activity activity) {
        aHG().L(activity);
    }

    public void g(SwanAppConfigData swanAppConfigData) {
        this.dsL = swanAppConfigData;
    }

    public SwanAppConfigData aHD() {
        return this.dsL;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.dsM = aVar;
    }

    public com.baidu.swan.games.t.a.a aHE() {
        return this.dsM;
    }

    public com.baidu.swan.apps.storage.c aHF() {
        if (this.dsN == null) {
            this.dsN = new com.baidu.swan.apps.storage.c(this);
        }
        return this.dsN;
    }

    public com.baidu.swan.apps.storage.b.c azu() {
        if (this.dsO == null) {
            if (aHN()) {
                this.dsO = new com.baidu.swan.games.i.l();
            } else {
                this.dsO = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.dsO;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a aHG() {
        if (this.dsP == null) {
            this.dsP = new com.baidu.swan.apps.setting.a(this);
        }
        return this.dsP;
    }

    public com.baidu.swan.apps.a.b aHH() {
        if (this.dsQ == null) {
            this.dsQ = new com.baidu.swan.apps.a.b(this);
        }
        return this.dsQ;
    }

    public synchronized com.baidu.swan.apps.network.j aHI() {
        if (this.dsR == null) {
            this.dsR = new com.baidu.swan.apps.network.j(this);
        }
        return this.dsR;
    }

    public synchronized com.baidu.swan.games.network.b aHJ() {
        if (this.dsS == null) {
            this.dsS = com.baidu.swan.games.network.b.aWq();
        }
        return this.dsS;
    }

    public com.baidu.swan.apps.network.k aHK() {
        if (this.dsV == null) {
            this.dsV = new com.baidu.swan.apps.network.k();
        }
        return this.dsV;
    }

    public com.baidu.swan.apps.media.audio.d aHL() {
        if (this.dsU == null) {
            this.dsU = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.dsU;
    }

    @NonNull
    public g aHM() {
        if (this.dsW == null) {
            this.dsW = new g(this);
        }
        return this.dsW;
    }

    public String getAppKey() {
        return aHy().getAppKey();
    }

    public boolean aHN() {
        return aHy().getAppFrameType() == 1;
    }

    public String getName() {
        return aHy().asF();
    }

    public String getVersion() {
        return aHy().getVersion();
    }

    public com.baidu.swan.apps.ag.a.a aHO() {
        if (this.dsT == null) {
            this.dsT = new com.baidu.swan.apps.ag.a.a();
        }
        return this.dsT;
    }

    public boolean rU(String str) {
        if (TextUtils.isEmpty(str) || this.dsL == null || this.dsL.dtA == null) {
            return false;
        }
        return this.dsL.dtA.sn(str);
    }

    public boolean rV(String str) {
        if (TextUtils.isEmpty(str) || this.dsL == null || this.dsL.dtB == null || this.dsL.dtB.duc == null || !this.dsL.dtB.duc.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.dsL.dtB.duc.get(str).booleanValue();
    }

    public boolean rW(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.bbh().ae(this.id, getVersion(), str);
    }

    public boolean rX(String str) {
        return new File(com.baidu.swan.apps.v.f.azO().azv(), str).exists();
    }

    public void ab(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dsL != null && this.dsL.dtB != null && this.dsL.dtB.duc != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dsL.dtB.duc.put(str, Boolean.valueOf(z));
        }
    }

    public String kA(String str) {
        if (this.dsL == null || this.dsL.dtB == null || this.dsL.dtB.dud == null) {
            return null;
        }
        return this.dsL.dtB.dud.get(com.baidu.swan.apps.scheme.actions.k.j.sK(str));
    }

    public String rY(String str) {
        if (this.dsL == null || this.dsL.dtC == null || this.dsL.dtC.duf == null) {
            return null;
        }
        return this.dsL.dtC.duf.get(str);
    }

    public String rZ(String str) {
        if (this.dsL == null) {
            return "";
        }
        return this.dsL.rZ(str);
    }

    public boolean sa(String str) {
        if (TextUtils.isEmpty(str) || this.dsL == null) {
            return false;
        }
        return this.dsL.sj(str);
    }

    public boolean aHP() {
        return sa(com.baidu.swan.apps.v.f.azO().azT());
    }

    public String aHQ() {
        b.a aHy = aHy();
        return aHy != null ? ko(aHy.getType()) : "0";
    }

    private String ko(int i) {
        if (i == 0) {
            String versionCode = this.dsZ != null ? this.dsZ.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String uy = ak.uy(versionCode);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(uy) ? " version is empty " : uy;
            com.baidu.swan.apps.console.c.d("SwanApp", objArr);
            return uy;
        }
        return "0";
    }

    public void cq(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.dsX == null) {
                this.dsX = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.dsX.put(str2, str);
        }
    }

    @Nullable
    public String sb(String str) {
        if (TextUtils.isEmpty(str) || this.dsX == null) {
            return null;
        }
        return this.dsX.get(str);
    }

    public boolean available() {
        return this.dsK && this.dsY.aHW() && afE() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return aHo();
    }

    public e gB(boolean z) {
        this.dta = z;
        rT("event_first_action_launched");
        return this;
    }

    public boolean aHR() {
        return this.dta;
    }
}
