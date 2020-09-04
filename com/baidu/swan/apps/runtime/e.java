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
/* loaded from: classes8.dex */
public class e extends m {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final boolean cQg;
    SwanAppConfigData cQh;
    com.baidu.swan.games.t.a.a cQi;
    private com.baidu.swan.apps.storage.c cQj;
    private com.baidu.swan.apps.storage.b.c cQk;
    private com.baidu.swan.apps.setting.a cQl;
    private com.baidu.swan.apps.a.b cQm;
    private com.baidu.swan.apps.network.j cQn;
    private com.baidu.swan.games.network.b cQo;
    private com.baidu.swan.apps.ag.a.a cQp;
    private com.baidu.swan.apps.media.audio.d cQq;
    private com.baidu.swan.apps.network.k cQr;
    private g cQs;
    private Map<String, String> cQt;
    private final k cQu;
    protected final b.a cQv;
    private boolean cQw;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.cQu = new k(this);
        this.cQv = new b.a();
        this.cQw = false;
        this.id = str == null ? "" : str;
        this.cQg = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.cQg) {
            this.cQp = new com.baidu.swan.apps.ag.a.a();
            this.cQp.qD(this.id);
        }
    }

    @Deprecated
    public static e azI() {
        return azJ();
    }

    public static e azJ() {
        d azE = d.azE();
        if (azE.axR()) {
            return azE.azA();
        }
        return null;
    }

    @Deprecated
    public static String azK() {
        return d.azE().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean axR() {
        return this.cQg;
    }

    public boolean abL() {
        com.baidu.swan.apps.framework.c XQ;
        if (com.baidu.swan.apps.core.prefetch.a.a.isOn()) {
            SwanAppActivity azC = azC();
            return azC == null || (XQ = azC.XQ()) == null || !XQ.ana().hasStarted();
        }
        return false;
    }

    public boolean azL() {
        com.baidu.swan.apps.framework.c XQ;
        SwanAppActivity azC = azC();
        if (azC == null || (XQ = azC.XQ()) == null) {
            return false;
        }
        return XQ.ana().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String x(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity azC = azC();
        if (azC != null && !azC.isDestroyed() && !azC.isFinishing() && azC.XR()) {
            azC.o(strArr);
        }
        com.baidu.swan.apps.v.f.release();
        if (this.cQs != null) {
            this.cQs.onDestroy();
        }
        com.baidu.swan.c.d.deleteFile(com.baidu.swan.apps.storage.b.rI(this.id));
        if (this.cQq != null) {
            this.cQq.release();
        }
        if (this.cQp != null) {
            this.cQp.release();
        }
        if (this.cQr != null) {
            this.cQr.release();
        }
        this.cQj = null;
        this.cQl = null;
        this.cQo = null;
        this.cQw = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores axS() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(azM().akn());
        swanAppCores.a(azM().ako());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e azA() {
        return this;
    }

    @NonNull
    public b.a azM() {
        return this.cQv;
    }

    @NonNull
    @Deprecated
    public b.a XZ() {
        return azM();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int XP() {
        if (this.cQg) {
            return azM().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = cQy.contains(str);
        b.a azM = azM();
        HybridUbcFlow oX = com.baidu.swan.apps.performance.i.oX("startup");
        oX.f(new UbcFlowEvent("swan_app_update_info_start").fc(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.cQu.aAk() && azL()) {
            if (azM.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (azM.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        azM.D(bundle);
        oX.f(new UbcFlowEvent("swan_app_update_info_end").fc(true));
        if (z) {
            qh("event_on_app_occupied");
        }
        if (this.cQg && !this.cQu.aAk() && !this.cQu.aAi()) {
            oX.f(new UbcFlowEvent("swan_app_maintain_start").fc(true));
            this.cQu.aAl();
            oX.f(new UbcFlowEvent("swan_app_maintain_return").fc(true));
            return true;
        }
        if (this.cQu.aAk() && contains) {
            k.a(azM, azM.ard(), false, false, false);
        }
        return this.cQu.aAi();
    }

    public com.baidu.swan.apps.u.c.b S(Bundle bundle) {
        b.a azM = azM();
        azM.D(bundle);
        return azM;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void azB() {
        azU().aBo();
        azT().aw(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void qh(String str) {
        f(str, azQ());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = azQ();
        } else {
            bundle.putAll(azQ());
        }
        super.f(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.D(azQ()));
    }

    public boolean azN() {
        return this.cQu.aAi();
    }

    public boolean azO() {
        return this.cQu.aAj();
    }

    public int azP() {
        return this.cQu.azP();
    }

    private Bundle azQ() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void onActivityResume(Activity activity) {
        azU().onActivityResume(activity);
    }

    public void g(SwanAppConfigData swanAppConfigData) {
        this.cQh = swanAppConfigData;
    }

    public SwanAppConfigData azR() {
        return this.cQh;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.cQi = aVar;
    }

    public com.baidu.swan.games.t.a.a azS() {
        return this.cQi;
    }

    public com.baidu.swan.apps.storage.c azT() {
        if (this.cQj == null) {
            this.cQj = new com.baidu.swan.apps.storage.c(this);
        }
        return this.cQj;
    }

    public com.baidu.swan.apps.storage.b.c arE() {
        if (this.cQk == null) {
            if (aAb()) {
                this.cQk = new com.baidu.swan.games.i.l();
            } else {
                this.cQk = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.cQk;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a azU() {
        if (this.cQl == null) {
            this.cQl = new com.baidu.swan.apps.setting.a(this);
        }
        return this.cQl;
    }

    public com.baidu.swan.apps.a.b azV() {
        if (this.cQm == null) {
            this.cQm = new com.baidu.swan.apps.a.b(this);
        }
        return this.cQm;
    }

    public synchronized com.baidu.swan.apps.network.j azW() {
        if (this.cQn == null) {
            this.cQn = new com.baidu.swan.apps.network.j(this);
        }
        return this.cQn;
    }

    public synchronized com.baidu.swan.games.network.b azX() {
        if (this.cQo == null) {
            this.cQo = com.baidu.swan.games.network.b.aOC();
        }
        return this.cQo;
    }

    public com.baidu.swan.apps.network.k azY() {
        if (this.cQr == null) {
            this.cQr = new com.baidu.swan.apps.network.k();
        }
        return this.cQr;
    }

    public com.baidu.swan.apps.media.audio.d azZ() {
        if (this.cQq == null) {
            this.cQq = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.cQq;
    }

    @NonNull
    public g aAa() {
        if (this.cQs == null) {
            this.cQs = new g(this);
        }
        return this.cQs;
    }

    public String getAppKey() {
        return azM().getAppKey();
    }

    public boolean aAb() {
        return azM().getAppFrameType() == 1;
    }

    public String getName() {
        return azM().akO();
    }

    public String getVersion() {
        return azM().getVersion();
    }

    public com.baidu.swan.apps.ag.a.a aAc() {
        if (this.cQp == null) {
            this.cQp = new com.baidu.swan.apps.ag.a.a();
        }
        return this.cQp;
    }

    public boolean qi(String str) {
        if (TextUtils.isEmpty(str) || this.cQh == null || this.cQh.cQV == null) {
            return false;
        }
        return this.cQh.cQV.qB(str);
    }

    public boolean qj(String str) {
        if (TextUtils.isEmpty(str) || this.cQh == null || this.cQh.cQW == null || this.cQh.cQW.cRx == null || !this.cQh.cQW.cRx.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.cQh.cQW.cRx.get(str).booleanValue();
    }

    public boolean qk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.aTt().W(this.id, getVersion(), str);
    }

    public boolean ql(String str) {
        return new File(com.baidu.swan.apps.v.f.arY().arF(), str).exists();
    }

    public void V(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.cQh != null && this.cQh.cQW != null && this.cQh.cQW.cRx != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.cQh.cQW.cRx.put(str, Boolean.valueOf(z));
        }
    }

    public String iN(String str) {
        if (this.cQh == null || this.cQh.cQW == null || this.cQh.cQW.cRy == null) {
            return null;
        }
        return this.cQh.cQW.cRy.get(com.baidu.swan.apps.scheme.actions.k.j.qX(str));
    }

    public String qm(String str) {
        if (this.cQh == null || this.cQh.cQX == null || this.cQh.cQX.cRA == null) {
            return null;
        }
        return this.cQh.cQX.cRA.get(str);
    }

    public String qn(String str) {
        if (this.cQh == null) {
            return "";
        }
        return this.cQh.qn(str);
    }

    public boolean qo(String str) {
        if (TextUtils.isEmpty(str) || this.cQh == null) {
            return false;
        }
        return this.cQh.qx(str);
    }

    public boolean aAd() {
        return qo(com.baidu.swan.apps.v.f.arY().asd());
    }

    public String aAe() {
        b.a azM = azM();
        return azM != null ? jl(azM.getType()) : "0";
    }

    private String jl(int i) {
        if (i == 0) {
            String versionCode = this.cQv != null ? this.cQv.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String sM = ak.sM(versionCode);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(sM) ? " version is empty " : sM;
            com.baidu.swan.apps.console.c.d("SwanApp", objArr);
            return sM;
        }
        return "0";
    }

    public void ce(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.cQt == null) {
                this.cQt = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.cQt.put(str2, str);
        }
    }

    @Nullable
    public String qp(String str) {
        if (TextUtils.isEmpty(str) || this.cQt == null) {
            return null;
        }
        return this.cQt.get(str);
    }

    public boolean available() {
        return this.cQg && this.cQu.aAk() && XP() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return azC();
    }

    public e fL(boolean z) {
        this.cQw = z;
        qh("event_first_action_launched");
        return this;
    }

    public boolean aAf() {
        return this.cQw;
    }
}
