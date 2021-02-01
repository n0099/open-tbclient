package com.baidu.swan.apps.runtime;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.u.c.b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class e extends m {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final boolean dEa;
    SwanAppConfigData dEb;
    com.baidu.swan.games.t.a.a dEc;
    private com.baidu.swan.apps.storage.c dEd;
    private com.baidu.swan.apps.storage.b.c dEe;
    private com.baidu.swan.apps.setting.a dEf;
    private com.baidu.swan.apps.a.b dEg;
    private com.baidu.swan.apps.network.j dEh;
    private com.baidu.swan.games.network.b dEi;
    private com.baidu.swan.apps.af.a.a dEj;
    private com.baidu.swan.apps.media.audio.d dEk;
    private com.baidu.swan.apps.network.k dEl;
    private g dEm;
    private Map<String, String> dEn;
    private final k dEo;
    protected final b.a dEp;
    private boolean dEq;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.dEo = new k(this);
        this.dEp = new b.a();
        this.dEq = false;
        this.id = str == null ? "" : str;
        this.dEa = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.dEa) {
            this.dEj = new com.baidu.swan.apps.af.a.a();
            this.dEj.rW(this.id);
        }
    }

    @Deprecated
    public static e aIK() {
        return aIL();
    }

    public static e aIL() {
        d aIG = d.aIG();
        if (aIG.aFY()) {
            return aIG.aIC();
        }
        return null;
    }

    @Deprecated
    public static String aIM() {
        return d.aIG().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aFY() {
        return this.dEa;
    }

    public boolean ajP() {
        com.baidu.swan.apps.framework.c afQ;
        if (com.baidu.swan.apps.core.prefetch.a.a.isOn()) {
            SwanAppActivity aIE = aIE();
            return aIE == null || (afQ = aIE.afQ()) == null || !afQ.avn().hasStarted();
        }
        return false;
    }

    public boolean aIN() {
        com.baidu.swan.apps.framework.c afQ;
        SwanAppActivity aIE = aIE();
        if (aIE == null || (afQ = aIE.afQ()) == null) {
            return false;
        }
        return afQ.avn().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String G(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity aIE = aIE();
        if (aIE != null && !aIE.isDestroyed() && !aIE.isFinishing() && aIE.afR()) {
            aIE.x(strArr);
        }
        com.baidu.swan.apps.v.f.release();
        if (this.dEm != null) {
            this.dEm.onDestroy();
        }
        com.baidu.swan.c.d.deleteFile(com.baidu.swan.apps.storage.b.tc(this.id));
        if (this.dEk != null) {
            this.dEk.release();
        }
        if (this.dEj != null) {
            this.dEj.release();
        }
        if (this.dEl != null) {
            this.dEl.release();
        }
        this.dEd = null;
        this.dEf = null;
        this.dEi = null;
        this.dEq = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aFZ() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(aIO().asA());
        swanAppCores.a(aIO().asB());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e aIC() {
        return this;
    }

    @NonNull
    public b.a aIO() {
        return this.dEp;
    }

    @NonNull
    @Deprecated
    public b.a afZ() {
        return aIO();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int getFrameType() {
        if (this.dEa) {
            return aIO().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = dEs.contains(str);
        b.a aIO = aIO();
        HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
        qk.f(new UbcFlowEvent("swan_app_update_info_start").gr(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.dEo.aJm() && aIN()) {
            if (aIO.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (aIO.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        aIO.D(bundle);
        qk.f(new UbcFlowEvent("swan_app_update_info_end").gr(true));
        if (z) {
            rz("event_on_app_occupied");
        }
        if (this.dEa && !this.dEo.aJm() && !this.dEo.aJk()) {
            qk.f(new UbcFlowEvent("swan_app_maintain_start").gr(true));
            this.dEo.aJn();
            qk.f(new UbcFlowEvent("swan_app_maintain_return").gr(true));
            return true;
        }
        if (this.dEo.aJm() && contains) {
            k.a(aIO, aIO.azq(), false, false, false);
        }
        return this.dEo.aJk();
    }

    public com.baidu.swan.apps.u.c.b S(Bundle bundle) {
        b.a aIO = aIO();
        aIO.D(bundle);
        return aIO;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void aID() {
        aIW().aKr();
        aIV().au(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void rz(String str) {
        g(str, aIS());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void g(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = aIS();
        } else {
            bundle.putAll(aIS());
        }
        super.g(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.D(aIS()));
    }

    public boolean aIP() {
        return this.dEo.aJk();
    }

    public boolean aIQ() {
        return this.dEo.aJl();
    }

    public int aIR() {
        return this.dEo.aIR();
    }

    private Bundle aIS() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void F(Activity activity) {
        aIW().F(activity);
    }

    public void g(SwanAppConfigData swanAppConfigData) {
        this.dEb = swanAppConfigData;
    }

    public SwanAppConfigData aIT() {
        return this.dEb;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.dEc = aVar;
    }

    public com.baidu.swan.games.t.a.a aIU() {
        return this.dEc;
    }

    public com.baidu.swan.apps.storage.c aIV() {
        if (this.dEd == null) {
            this.dEd = new com.baidu.swan.apps.storage.c(this);
        }
        return this.dEd;
    }

    public com.baidu.swan.apps.storage.b.c azR() {
        if (this.dEe == null) {
            if (aJd()) {
                this.dEe = new com.baidu.swan.games.i.l();
            } else {
                this.dEe = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.dEe;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a aIW() {
        if (this.dEf == null) {
            this.dEf = new com.baidu.swan.apps.setting.a(this);
        }
        return this.dEf;
    }

    public com.baidu.swan.apps.a.b aIX() {
        if (this.dEg == null) {
            this.dEg = new com.baidu.swan.apps.a.b(this);
        }
        return this.dEg;
    }

    public synchronized com.baidu.swan.apps.network.j aIY() {
        if (this.dEh == null) {
            this.dEh = new com.baidu.swan.apps.network.j(this);
        }
        return this.dEh;
    }

    public synchronized com.baidu.swan.games.network.b aIZ() {
        if (this.dEi == null) {
            this.dEi = com.baidu.swan.games.network.b.aXA();
        }
        return this.dEi;
    }

    public com.baidu.swan.apps.network.k aJa() {
        if (this.dEl == null) {
            this.dEl = new com.baidu.swan.apps.network.k();
        }
        return this.dEl;
    }

    public com.baidu.swan.apps.media.audio.d aJb() {
        if (this.dEk == null) {
            this.dEk = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.dEk;
    }

    @NonNull
    public g aJc() {
        if (this.dEm == null) {
            this.dEm = new g(this);
        }
        return this.dEm;
    }

    public String getAppKey() {
        return aIO().getAppKey();
    }

    public boolean aJd() {
        return aIO().getAppFrameType() == 1;
    }

    public String getName() {
        return aIO().atc();
    }

    public String getVersion() {
        return aIO().getVersion();
    }

    public com.baidu.swan.apps.af.a.a aJe() {
        if (this.dEj == null) {
            this.dEj = new com.baidu.swan.apps.af.a.a();
        }
        return this.dEj;
    }

    public boolean rA(String str) {
        if (TextUtils.isEmpty(str) || this.dEb == null || this.dEb.dEP == null) {
            return false;
        }
        return this.dEb.dEP.rU(str);
    }

    public boolean rB(String str) {
        if (TextUtils.isEmpty(str) || this.dEb == null || this.dEb.dEQ == null || this.dEb.dEQ.dFr == null || !this.dEb.dEQ.dFr.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.dEb.dEQ.dFr.get(str).booleanValue();
    }

    public boolean rC(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.bcv().ak(this.id, getVersion(), str);
    }

    public boolean rD(String str) {
        return new File(com.baidu.swan.apps.v.f.aAl().azS(), str).exists();
    }

    public void ab(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dEb != null && this.dEb.dEQ != null && this.dEb.dEQ.dFr != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dEb.dEQ.dFr.put(str, Boolean.valueOf(z));
        }
    }

    public String kb(String str) {
        if (this.dEb == null || this.dEb.dEQ == null || this.dEb.dEQ.dFs == null) {
            return null;
        }
        return this.dEb.dEQ.dFs.get(com.baidu.swan.apps.scheme.actions.k.j.sq(str));
    }

    public String rE(String str) {
        if (this.dEb == null || this.dEb.dER == null || this.dEb.dER.dFu == null) {
            return null;
        }
        return this.dEb.dER.dFu.get(str);
    }

    public String rF(String str) {
        if (this.dEb == null) {
            return "";
        }
        return this.dEb.rF(str);
    }

    public boolean rG(String str) {
        if (TextUtils.isEmpty(str) || this.dEb == null) {
            return false;
        }
        return this.dEb.rQ(str);
    }

    public boolean aJf() {
        return rG(com.baidu.swan.apps.v.f.aAl().aAq());
    }

    public String aJg() {
        b.a aIO = aIO();
        return aIO != null ? jl(aIO.getType()) : "0";
    }

    private String jl(int i) {
        if (i == 0) {
            String versionCode = this.dEp != null ? this.dEp.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String uh = ak.uh(versionCode);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(uh) ? " version is empty " : uh;
            com.baidu.swan.apps.console.c.d("SwanApp", objArr);
            return uh;
        }
        return "0";
    }

    public void co(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.dEn == null) {
                this.dEn = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.dEn.put(str2, str);
        }
    }

    @Nullable
    public String rH(String str) {
        if (TextUtils.isEmpty(str) || this.dEn == null) {
            return null;
        }
        return this.dEn.get(str);
    }

    public boolean available() {
        return this.dEa && this.dEo.aJm() && getFrameType() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return aIE();
    }

    public e hj(boolean z) {
        this.dEq = z;
        rz("event_first_action_launched");
        return this;
    }

    public boolean aJh() {
        return this.dEq;
    }
}
