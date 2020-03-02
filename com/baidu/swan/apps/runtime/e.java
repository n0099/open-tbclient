package com.baidu.swan.apps.runtime;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.x.b.b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class e extends l {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final boolean bOV;
    SwanAppConfigData bOW;
    com.baidu.swan.games.s.a.a bOX;
    private com.baidu.swan.apps.storage.c bOY;
    private com.baidu.swan.apps.storage.b.c bOZ;
    private com.baidu.swan.apps.setting.a bPa;
    private com.baidu.swan.apps.a.b bPb;
    private com.baidu.swan.apps.network.j bPc;
    private com.baidu.swan.games.network.b bPd;
    private com.baidu.swan.apps.aj.a.a bPe;
    private com.baidu.swan.apps.media.audio.d bPf;
    private com.baidu.swan.apps.network.k bPg;
    private g bPh;
    private Map<String, String> bPi;
    private final k bPj;
    protected final b.a bPk;
    private boolean bPl;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.bPj = new k(this);
        this.bPk = new b.a();
        this.bPl = false;
        this.id = str == null ? "" : str;
        this.bOV = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.bOV) {
            this.bPe = new com.baidu.swan.apps.aj.a.a();
            this.bPe.lg(this.id);
        }
    }

    @Deprecated
    public static e acF() {
        return acG();
    }

    public static e acG() {
        d acC = d.acC();
        if (acC.abj()) {
            return acC.acz();
        }
        return null;
    }

    @Deprecated
    public static String acH() {
        return d.acC().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean abj() {
        return this.bOV;
    }

    public boolean JF() {
        com.baidu.swan.apps.framework.c Gv;
        if (com.baidu.swan.apps.core.prefetch.a.a.PP() == 0) {
            return false;
        }
        SwanAppActivity acB = acB();
        return acB == null || (Gv = acB.Gv()) == null || !Gv.SJ().hasStarted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String w(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity acB = acB();
        if (acB != null && !acB.isDestroyed() && !acB.isFinishing() && acB.Gw()) {
            acB.q(strArr);
        }
        com.baidu.swan.apps.y.f.release();
        if (this.bPh != null) {
            this.bPh.onDestroy();
        }
        com.baidu.swan.d.c.deleteFile(com.baidu.swan.apps.storage.b.lY(this.id));
        if (this.bPf != null) {
            this.bPf.release();
        }
        if (this.bPe != null) {
            this.bPe.release();
        }
        if (this.bPg != null) {
            this.bPg.release();
        }
        this.bOY = null;
        this.bPa = null;
        this.bPd = null;
        this.bPl = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores abk() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(acI().QQ());
        swanAppCores.a(acI().QR());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public e acz() {
        return this;
    }

    @NonNull
    public b.a acI() {
        return this.bPk;
    }

    @NonNull
    @Deprecated
    public b.a GE() {
        return acI();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Gu() {
        if (this.bOV) {
            return acI().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = bPn.contains(str);
        b.a acI = acI();
        HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
        jP.f(new UbcFlowEvent("swan_app_update_info_start").dg(true));
        acI.B(bundle);
        jP.f(new UbcFlowEvent("swan_app_update_info_end").dg(true));
        if (z) {
            kL("event_on_app_occupied");
        }
        if (this.bOV && !this.bPj.adf() && !this.bPj.ade()) {
            jP.f(new UbcFlowEvent("swan_app_maintain_start").dg(true));
            this.bPj.adg();
            jP.f(new UbcFlowEvent("swan_app_maintain_return").dg(true));
            return true;
        }
        if (this.bPj.adf() && contains) {
            k.a(acI, acI.VZ(), false, false);
        }
        return this.bPj.ade();
    }

    public com.baidu.swan.apps.x.b.b N(Bundle bundle) {
        b.a acI = acI();
        acI.B(bundle);
        return acI;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void acA() {
        acP().adY();
        acN().T(true);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void kL(String str) {
        d(str, acK());
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = acK();
        } else {
            bundle.putAll(acK());
        }
        super.d(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(i.a aVar) {
        super.d((i.a) aVar.B(acK()));
    }

    public boolean acJ() {
        return this.bPj.ade();
    }

    private Bundle acK() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void onActivityResume(Activity activity) {
        acP().onActivityResume(activity);
    }

    public void c(SwanAppConfigData swanAppConfigData) {
        this.bOW = swanAppConfigData;
    }

    public SwanAppConfigData acL() {
        return this.bOW;
    }

    public void a(com.baidu.swan.games.s.a.a aVar) {
        this.bOX = aVar;
    }

    public com.baidu.swan.games.s.a.a acM() {
        return this.bOX;
    }

    public com.baidu.swan.apps.storage.c acN() {
        if (this.bOY == null) {
            this.bOY = new com.baidu.swan.apps.storage.c(this);
        }
        return this.bOY;
    }

    public com.baidu.swan.apps.storage.b.c acO() {
        if (this.bOZ == null) {
            if (acW()) {
                this.bOZ = new com.baidu.swan.games.h.k();
            } else {
                this.bOZ = new com.baidu.swan.apps.storage.b.b();
            }
        }
        return this.bOZ;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a acP() {
        if (this.bPa == null) {
            this.bPa = new com.baidu.swan.apps.setting.a(this);
        }
        return this.bPa;
    }

    public com.baidu.swan.apps.a.b acQ() {
        if (this.bPb == null) {
            this.bPb = new com.baidu.swan.apps.a.b(this);
        }
        return this.bPb;
    }

    public synchronized com.baidu.swan.apps.network.j acR() {
        if (this.bPc == null) {
            this.bPc = new com.baidu.swan.apps.network.j(this);
        }
        return this.bPc;
    }

    public synchronized com.baidu.swan.games.network.b acS() {
        if (this.bPd == null) {
            this.bPd = com.baidu.swan.games.network.b.aoR();
        }
        return this.bPd;
    }

    public com.baidu.swan.apps.network.k acT() {
        if (this.bPg == null) {
            this.bPg = new com.baidu.swan.apps.network.k();
        }
        return this.bPg;
    }

    public com.baidu.swan.apps.media.audio.d acU() {
        if (this.bPf == null) {
            this.bPf = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.bPf;
    }

    @NonNull
    public g acV() {
        if (this.bPh == null) {
            this.bPh = new g(this);
        }
        return this.bPh;
    }

    public String getAppKey() {
        return acI().getAppKey();
    }

    public boolean acW() {
        return acI().getAppFrameType() == 1;
    }

    public String getName() {
        return acI().Rb();
    }

    public String getVersion() {
        return acI().getVersion();
    }

    public com.baidu.swan.apps.aj.a.a acX() {
        if (this.bPe == null) {
            this.bPe = new com.baidu.swan.apps.aj.a.a();
        }
        return this.bPe;
    }

    public boolean kM(String str) {
        if (TextUtils.isEmpty(str) || this.bOW == null || this.bOW.bPC == null) {
            return false;
        }
        return this.bOW.bPC.le(str);
    }

    public boolean kN(String str) {
        if (TextUtils.isEmpty(str) || this.bOW == null || this.bOW.bPD == null || this.bOW.bPD.bPY == null || !this.bOW.bPD.bPY.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.bOW.bPD.bPY.get(str).booleanValue();
    }

    public boolean kO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.atv().Q(this.id, getVersion(), str);
    }

    public boolean kP(String str) {
        return new File(com.baidu.swan.apps.y.f.WS().WA(), str).exists();
    }

    public void y(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.bOW != null && this.bOW.bPD != null && this.bOW.bPD.bPY != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bOW.bPD.bPY.put(str, Boolean.valueOf(z));
        }
    }

    public String kQ(String str) {
        if (this.bOW == null || this.bOW.bPD == null || this.bOW.bPD.bPZ == null) {
            return null;
        }
        return this.bOW.bPD.bPZ.get(str);
    }

    public String kR(String str) {
        if (this.bOW == null || this.bOW.bPE == null || this.bOW.bPE.bQb == null) {
            return null;
        }
        return this.bOW.bPE.bQb.get(str);
    }

    public String kS(String str) {
        if (this.bOW == null) {
            return "";
        }
        return this.bOW.kS(str);
    }

    public boolean kT(String str) {
        if (TextUtils.isEmpty(str) || this.bOW == null) {
            return false;
        }
        return this.bOW.lb(str);
    }

    public boolean acY() {
        return kT(com.baidu.swan.apps.y.f.WS().WW());
    }

    public String acZ() {
        b.a acI = acI();
        return acI != null ? gj(acI.getType()) : "0";
    }

    private String gj(int i) {
        if (i == 0) {
            String versionCode = this.bPk != null ? this.bPk.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String mU = ai.mU(versionCode);
            com.baidu.swan.apps.console.c.e("SwanApp", TextUtils.isEmpty(mU) ? " version is empty " : mU);
            return mU;
        }
        return "0";
    }

    public void bg(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.bPi == null) {
                this.bPi = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.bPi.put(str2, str);
        }
    }

    @Nullable
    public String kU(String str) {
        if (TextUtils.isEmpty(str) || this.bPi == null) {
            return null;
        }
        return this.bPi.get(str);
    }

    public boolean available() {
        return this.bOV && this.bPj.adf() && Gu() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return acB();
    }

    public e dN(boolean z) {
        this.bPl = z;
        kL("event_first_action_launched");
        return this;
    }

    public boolean ada() {
        return this.bPl;
    }
}
