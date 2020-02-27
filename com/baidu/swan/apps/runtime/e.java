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
    public final boolean bOU;
    SwanAppConfigData bOV;
    com.baidu.swan.games.s.a.a bOW;
    private com.baidu.swan.apps.storage.c bOX;
    private com.baidu.swan.apps.storage.b.c bOY;
    private com.baidu.swan.apps.setting.a bOZ;
    private com.baidu.swan.apps.a.b bPa;
    private com.baidu.swan.apps.network.j bPb;
    private com.baidu.swan.games.network.b bPc;
    private com.baidu.swan.apps.aj.a.a bPd;
    private com.baidu.swan.apps.media.audio.d bPe;
    private com.baidu.swan.apps.network.k bPf;
    private g bPg;
    private Map<String, String> bPh;
    private final k bPi;
    protected final b.a bPj;
    private boolean bPk;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.bPi = new k(this);
        this.bPj = new b.a();
        this.bPk = false;
        this.id = str == null ? "" : str;
        this.bOU = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.bOU) {
            this.bPd = new com.baidu.swan.apps.aj.a.a();
            this.bPd.lg(this.id);
        }
    }

    @Deprecated
    public static e acD() {
        return acE();
    }

    public static e acE() {
        d acA = d.acA();
        if (acA.abh()) {
            return acA.acx();
        }
        return null;
    }

    @Deprecated
    public static String acF() {
        return d.acA().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean abh() {
        return this.bOU;
    }

    public boolean JD() {
        com.baidu.swan.apps.framework.c Gt;
        if (com.baidu.swan.apps.core.prefetch.a.a.PN() == 0) {
            return false;
        }
        SwanAppActivity acz = acz();
        return acz == null || (Gt = acz.Gt()) == null || !Gt.SH().hasStarted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String w(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity acz = acz();
        if (acz != null && !acz.isDestroyed() && !acz.isFinishing() && acz.Gu()) {
            acz.q(strArr);
        }
        com.baidu.swan.apps.y.f.release();
        if (this.bPg != null) {
            this.bPg.onDestroy();
        }
        com.baidu.swan.d.c.deleteFile(com.baidu.swan.apps.storage.b.lY(this.id));
        if (this.bPe != null) {
            this.bPe.release();
        }
        if (this.bPd != null) {
            this.bPd.release();
        }
        if (this.bPf != null) {
            this.bPf.release();
        }
        this.bOX = null;
        this.bOZ = null;
        this.bPc = null;
        this.bPk = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores abi() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(acG().QO());
        swanAppCores.a(acG().QP());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public e acx() {
        return this;
    }

    @NonNull
    public b.a acG() {
        return this.bPj;
    }

    @NonNull
    @Deprecated
    public b.a GC() {
        return acG();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Gs() {
        if (this.bOU) {
            return acG().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = bPm.contains(str);
        b.a acG = acG();
        HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
        jP.f(new UbcFlowEvent("swan_app_update_info_start").dg(true));
        acG.B(bundle);
        jP.f(new UbcFlowEvent("swan_app_update_info_end").dg(true));
        if (z) {
            kL("event_on_app_occupied");
        }
        if (this.bOU && !this.bPi.add() && !this.bPi.adc()) {
            jP.f(new UbcFlowEvent("swan_app_maintain_start").dg(true));
            this.bPi.ade();
            jP.f(new UbcFlowEvent("swan_app_maintain_return").dg(true));
            return true;
        }
        if (this.bPi.add() && contains) {
            k.a(acG, acG.VX(), false, false);
        }
        return this.bPi.adc();
    }

    public com.baidu.swan.apps.x.b.b N(Bundle bundle) {
        b.a acG = acG();
        acG.B(bundle);
        return acG;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void acy() {
        acN().adW();
        acL().T(true);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void kL(String str) {
        d(str, acI());
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = acI();
        } else {
            bundle.putAll(acI());
        }
        super.d(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(i.a aVar) {
        super.d((i.a) aVar.B(acI()));
    }

    public boolean acH() {
        return this.bPi.adc();
    }

    private Bundle acI() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void onActivityResume(Activity activity) {
        acN().onActivityResume(activity);
    }

    public void c(SwanAppConfigData swanAppConfigData) {
        this.bOV = swanAppConfigData;
    }

    public SwanAppConfigData acJ() {
        return this.bOV;
    }

    public void a(com.baidu.swan.games.s.a.a aVar) {
        this.bOW = aVar;
    }

    public com.baidu.swan.games.s.a.a acK() {
        return this.bOW;
    }

    public com.baidu.swan.apps.storage.c acL() {
        if (this.bOX == null) {
            this.bOX = new com.baidu.swan.apps.storage.c(this);
        }
        return this.bOX;
    }

    public com.baidu.swan.apps.storage.b.c acM() {
        if (this.bOY == null) {
            if (acU()) {
                this.bOY = new com.baidu.swan.games.h.k();
            } else {
                this.bOY = new com.baidu.swan.apps.storage.b.b();
            }
        }
        return this.bOY;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a acN() {
        if (this.bOZ == null) {
            this.bOZ = new com.baidu.swan.apps.setting.a(this);
        }
        return this.bOZ;
    }

    public com.baidu.swan.apps.a.b acO() {
        if (this.bPa == null) {
            this.bPa = new com.baidu.swan.apps.a.b(this);
        }
        return this.bPa;
    }

    public synchronized com.baidu.swan.apps.network.j acP() {
        if (this.bPb == null) {
            this.bPb = new com.baidu.swan.apps.network.j(this);
        }
        return this.bPb;
    }

    public synchronized com.baidu.swan.games.network.b acQ() {
        if (this.bPc == null) {
            this.bPc = com.baidu.swan.games.network.b.aoP();
        }
        return this.bPc;
    }

    public com.baidu.swan.apps.network.k acR() {
        if (this.bPf == null) {
            this.bPf = new com.baidu.swan.apps.network.k();
        }
        return this.bPf;
    }

    public com.baidu.swan.apps.media.audio.d acS() {
        if (this.bPe == null) {
            this.bPe = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.bPe;
    }

    @NonNull
    public g acT() {
        if (this.bPg == null) {
            this.bPg = new g(this);
        }
        return this.bPg;
    }

    public String getAppKey() {
        return acG().getAppKey();
    }

    public boolean acU() {
        return acG().getAppFrameType() == 1;
    }

    public String getName() {
        return acG().QZ();
    }

    public String getVersion() {
        return acG().getVersion();
    }

    public com.baidu.swan.apps.aj.a.a acV() {
        if (this.bPd == null) {
            this.bPd = new com.baidu.swan.apps.aj.a.a();
        }
        return this.bPd;
    }

    public boolean kM(String str) {
        if (TextUtils.isEmpty(str) || this.bOV == null || this.bOV.bPB == null) {
            return false;
        }
        return this.bOV.bPB.le(str);
    }

    public boolean kN(String str) {
        if (TextUtils.isEmpty(str) || this.bOV == null || this.bOV.bPC == null || this.bOV.bPC.bPX == null || !this.bOV.bPC.bPX.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.bOV.bPC.bPX.get(str).booleanValue();
    }

    public boolean kO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.att().Q(this.id, getVersion(), str);
    }

    public boolean kP(String str) {
        return new File(com.baidu.swan.apps.y.f.WQ().Wy(), str).exists();
    }

    public void y(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.bOV != null && this.bOV.bPC != null && this.bOV.bPC.bPX != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bOV.bPC.bPX.put(str, Boolean.valueOf(z));
        }
    }

    public String kQ(String str) {
        if (this.bOV == null || this.bOV.bPC == null || this.bOV.bPC.bPY == null) {
            return null;
        }
        return this.bOV.bPC.bPY.get(str);
    }

    public String kR(String str) {
        if (this.bOV == null || this.bOV.bPD == null || this.bOV.bPD.bQa == null) {
            return null;
        }
        return this.bOV.bPD.bQa.get(str);
    }

    public String kS(String str) {
        if (this.bOV == null) {
            return "";
        }
        return this.bOV.kS(str);
    }

    public boolean kT(String str) {
        if (TextUtils.isEmpty(str) || this.bOV == null) {
            return false;
        }
        return this.bOV.lb(str);
    }

    public boolean acW() {
        return kT(com.baidu.swan.apps.y.f.WQ().WU());
    }

    public String acX() {
        b.a acG = acG();
        return acG != null ? gj(acG.getType()) : "0";
    }

    private String gj(int i) {
        if (i == 0) {
            String versionCode = this.bPj != null ? this.bPj.getVersionCode() : "";
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
            if (this.bPh == null) {
                this.bPh = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.bPh.put(str2, str);
        }
    }

    @Nullable
    public String kU(String str) {
        if (TextUtils.isEmpty(str) || this.bPh == null) {
            return null;
        }
        return this.bPh.get(str);
    }

    public boolean available() {
        return this.bOU && this.bPi.add() && Gs() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return acz();
    }

    public e dN(boolean z) {
        this.bPk = z;
        kL("event_first_action_launched");
        return this;
    }

    public boolean acY() {
        return this.bPk;
    }
}
