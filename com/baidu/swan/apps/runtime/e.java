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
    public final boolean bOW;
    SwanAppConfigData bOX;
    com.baidu.swan.games.s.a.a bOY;
    private com.baidu.swan.apps.storage.c bOZ;
    private com.baidu.swan.apps.storage.b.c bPa;
    private com.baidu.swan.apps.setting.a bPb;
    private com.baidu.swan.apps.a.b bPc;
    private com.baidu.swan.apps.network.j bPd;
    private com.baidu.swan.games.network.b bPe;
    private com.baidu.swan.apps.aj.a.a bPf;
    private com.baidu.swan.apps.media.audio.d bPg;
    private com.baidu.swan.apps.network.k bPh;
    private g bPi;
    private Map<String, String> bPj;
    private final k bPk;
    protected final b.a bPl;
    private boolean bPm;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.bPk = new k(this);
        this.bPl = new b.a();
        this.bPm = false;
        this.id = str == null ? "" : str;
        this.bOW = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.bOW) {
            this.bPf = new com.baidu.swan.apps.aj.a.a();
            this.bPf.lg(this.id);
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
        return this.bOW;
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
        if (this.bPi != null) {
            this.bPi.onDestroy();
        }
        com.baidu.swan.d.c.deleteFile(com.baidu.swan.apps.storage.b.lY(this.id));
        if (this.bPg != null) {
            this.bPg.release();
        }
        if (this.bPf != null) {
            this.bPf.release();
        }
        if (this.bPh != null) {
            this.bPh.release();
        }
        this.bOZ = null;
        this.bPb = null;
        this.bPe = null;
        this.bPm = false;
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
        return this.bPl;
    }

    @NonNull
    @Deprecated
    public b.a GE() {
        return acI();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Gu() {
        if (this.bOW) {
            return acI().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = bPo.contains(str);
        b.a acI = acI();
        HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
        jP.f(new UbcFlowEvent("swan_app_update_info_start").dg(true));
        acI.B(bundle);
        jP.f(new UbcFlowEvent("swan_app_update_info_end").dg(true));
        if (z) {
            kL("event_on_app_occupied");
        }
        if (this.bOW && !this.bPk.adf() && !this.bPk.ade()) {
            jP.f(new UbcFlowEvent("swan_app_maintain_start").dg(true));
            this.bPk.adg();
            jP.f(new UbcFlowEvent("swan_app_maintain_return").dg(true));
            return true;
        }
        if (this.bPk.adf() && contains) {
            k.a(acI, acI.VZ(), false, false);
        }
        return this.bPk.ade();
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
        return this.bPk.ade();
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
        this.bOX = swanAppConfigData;
    }

    public SwanAppConfigData acL() {
        return this.bOX;
    }

    public void a(com.baidu.swan.games.s.a.a aVar) {
        this.bOY = aVar;
    }

    public com.baidu.swan.games.s.a.a acM() {
        return this.bOY;
    }

    public com.baidu.swan.apps.storage.c acN() {
        if (this.bOZ == null) {
            this.bOZ = new com.baidu.swan.apps.storage.c(this);
        }
        return this.bOZ;
    }

    public com.baidu.swan.apps.storage.b.c acO() {
        if (this.bPa == null) {
            if (acW()) {
                this.bPa = new com.baidu.swan.games.h.k();
            } else {
                this.bPa = new com.baidu.swan.apps.storage.b.b();
            }
        }
        return this.bPa;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a acP() {
        if (this.bPb == null) {
            this.bPb = new com.baidu.swan.apps.setting.a(this);
        }
        return this.bPb;
    }

    public com.baidu.swan.apps.a.b acQ() {
        if (this.bPc == null) {
            this.bPc = new com.baidu.swan.apps.a.b(this);
        }
        return this.bPc;
    }

    public synchronized com.baidu.swan.apps.network.j acR() {
        if (this.bPd == null) {
            this.bPd = new com.baidu.swan.apps.network.j(this);
        }
        return this.bPd;
    }

    public synchronized com.baidu.swan.games.network.b acS() {
        if (this.bPe == null) {
            this.bPe = com.baidu.swan.games.network.b.aoR();
        }
        return this.bPe;
    }

    public com.baidu.swan.apps.network.k acT() {
        if (this.bPh == null) {
            this.bPh = new com.baidu.swan.apps.network.k();
        }
        return this.bPh;
    }

    public com.baidu.swan.apps.media.audio.d acU() {
        if (this.bPg == null) {
            this.bPg = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.bPg;
    }

    @NonNull
    public g acV() {
        if (this.bPi == null) {
            this.bPi = new g(this);
        }
        return this.bPi;
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
        if (this.bPf == null) {
            this.bPf = new com.baidu.swan.apps.aj.a.a();
        }
        return this.bPf;
    }

    public boolean kM(String str) {
        if (TextUtils.isEmpty(str) || this.bOX == null || this.bOX.bPD == null) {
            return false;
        }
        return this.bOX.bPD.le(str);
    }

    public boolean kN(String str) {
        if (TextUtils.isEmpty(str) || this.bOX == null || this.bOX.bPE == null || this.bOX.bPE.bPZ == null || !this.bOX.bPE.bPZ.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.bOX.bPE.bPZ.get(str).booleanValue();
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
        if (!TextUtils.isEmpty(str) && this.bOX != null && this.bOX.bPE != null && this.bOX.bPE.bPZ != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bOX.bPE.bPZ.put(str, Boolean.valueOf(z));
        }
    }

    public String kQ(String str) {
        if (this.bOX == null || this.bOX.bPE == null || this.bOX.bPE.bQa == null) {
            return null;
        }
        return this.bOX.bPE.bQa.get(str);
    }

    public String kR(String str) {
        if (this.bOX == null || this.bOX.bPF == null || this.bOX.bPF.bQc == null) {
            return null;
        }
        return this.bOX.bPF.bQc.get(str);
    }

    public String kS(String str) {
        if (this.bOX == null) {
            return "";
        }
        return this.bOX.kS(str);
    }

    public boolean kT(String str) {
        if (TextUtils.isEmpty(str) || this.bOX == null) {
            return false;
        }
        return this.bOX.lb(str);
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
            String versionCode = this.bPl != null ? this.bPl.getVersionCode() : "";
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
            if (this.bPj == null) {
                this.bPj = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.bPj.put(str2, str);
        }
    }

    @Nullable
    public String kU(String str) {
        if (TextUtils.isEmpty(str) || this.bPj == null) {
            return null;
        }
        return this.bPj.get(str);
    }

    public boolean available() {
        return this.bOW && this.bPk.adf() && Gu() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return acB();
    }

    public e dN(boolean z) {
        this.bPm = z;
        kL("event_first_action_launched");
        return this;
    }

    public boolean ada() {
        return this.bPm;
    }
}
