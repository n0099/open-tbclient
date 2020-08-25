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
    public final boolean cQc;
    SwanAppConfigData cQd;
    com.baidu.swan.games.t.a.a cQe;
    private com.baidu.swan.apps.storage.c cQf;
    private com.baidu.swan.apps.storage.b.c cQg;
    private com.baidu.swan.apps.setting.a cQh;
    private com.baidu.swan.apps.a.b cQi;
    private com.baidu.swan.apps.network.j cQj;
    private com.baidu.swan.games.network.b cQk;
    private com.baidu.swan.apps.ag.a.a cQl;
    private com.baidu.swan.apps.media.audio.d cQm;
    private com.baidu.swan.apps.network.k cQn;
    private g cQo;
    private Map<String, String> cQp;
    private final k cQq;
    protected final b.a cQr;
    private boolean cQs;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.cQq = new k(this);
        this.cQr = new b.a();
        this.cQs = false;
        this.id = str == null ? "" : str;
        this.cQc = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.cQc) {
            this.cQl = new com.baidu.swan.apps.ag.a.a();
            this.cQl.qC(this.id);
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
        return this.cQc;
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
        if (this.cQo != null) {
            this.cQo.onDestroy();
        }
        com.baidu.swan.c.d.deleteFile(com.baidu.swan.apps.storage.b.rH(this.id));
        if (this.cQm != null) {
            this.cQm.release();
        }
        if (this.cQl != null) {
            this.cQl.release();
        }
        if (this.cQn != null) {
            this.cQn.release();
        }
        this.cQf = null;
        this.cQh = null;
        this.cQk = null;
        this.cQs = false;
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
        return this.cQr;
    }

    @NonNull
    @Deprecated
    public b.a XZ() {
        return azM();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int XP() {
        if (this.cQc) {
            return azM().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = cQu.contains(str);
        b.a azM = azM();
        HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
        oW.f(new UbcFlowEvent("swan_app_update_info_start").fb(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.cQq.aAk() && azL()) {
            if (azM.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (azM.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        azM.D(bundle);
        oW.f(new UbcFlowEvent("swan_app_update_info_end").fb(true));
        if (z) {
            qg("event_on_app_occupied");
        }
        if (this.cQc && !this.cQq.aAk() && !this.cQq.aAi()) {
            oW.f(new UbcFlowEvent("swan_app_maintain_start").fb(true));
            this.cQq.aAl();
            oW.f(new UbcFlowEvent("swan_app_maintain_return").fb(true));
            return true;
        }
        if (this.cQq.aAk() && contains) {
            k.a(azM, azM.ard(), false, false, false);
        }
        return this.cQq.aAi();
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
    public void qg(String str) {
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
        return this.cQq.aAi();
    }

    public boolean azO() {
        return this.cQq.aAj();
    }

    public int azP() {
        return this.cQq.azP();
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
        this.cQd = swanAppConfigData;
    }

    public SwanAppConfigData azR() {
        return this.cQd;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.cQe = aVar;
    }

    public com.baidu.swan.games.t.a.a azS() {
        return this.cQe;
    }

    public com.baidu.swan.apps.storage.c azT() {
        if (this.cQf == null) {
            this.cQf = new com.baidu.swan.apps.storage.c(this);
        }
        return this.cQf;
    }

    public com.baidu.swan.apps.storage.b.c arE() {
        if (this.cQg == null) {
            if (aAb()) {
                this.cQg = new com.baidu.swan.games.i.l();
            } else {
                this.cQg = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.cQg;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a azU() {
        if (this.cQh == null) {
            this.cQh = new com.baidu.swan.apps.setting.a(this);
        }
        return this.cQh;
    }

    public com.baidu.swan.apps.a.b azV() {
        if (this.cQi == null) {
            this.cQi = new com.baidu.swan.apps.a.b(this);
        }
        return this.cQi;
    }

    public synchronized com.baidu.swan.apps.network.j azW() {
        if (this.cQj == null) {
            this.cQj = new com.baidu.swan.apps.network.j(this);
        }
        return this.cQj;
    }

    public synchronized com.baidu.swan.games.network.b azX() {
        if (this.cQk == null) {
            this.cQk = com.baidu.swan.games.network.b.aOC();
        }
        return this.cQk;
    }

    public com.baidu.swan.apps.network.k azY() {
        if (this.cQn == null) {
            this.cQn = new com.baidu.swan.apps.network.k();
        }
        return this.cQn;
    }

    public com.baidu.swan.apps.media.audio.d azZ() {
        if (this.cQm == null) {
            this.cQm = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.cQm;
    }

    @NonNull
    public g aAa() {
        if (this.cQo == null) {
            this.cQo = new g(this);
        }
        return this.cQo;
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
        if (this.cQl == null) {
            this.cQl = new com.baidu.swan.apps.ag.a.a();
        }
        return this.cQl;
    }

    public boolean qh(String str) {
        if (TextUtils.isEmpty(str) || this.cQd == null || this.cQd.cQR == null) {
            return false;
        }
        return this.cQd.cQR.qA(str);
    }

    public boolean qi(String str) {
        if (TextUtils.isEmpty(str) || this.cQd == null || this.cQd.cQS == null || this.cQd.cQS.cRt == null || !this.cQd.cQS.cRt.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.cQd.cQS.cRt.get(str).booleanValue();
    }

    public boolean qj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.aTt().W(this.id, getVersion(), str);
    }

    public boolean qk(String str) {
        return new File(com.baidu.swan.apps.v.f.arY().arF(), str).exists();
    }

    public void V(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.cQd != null && this.cQd.cQS != null && this.cQd.cQS.cRt != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.cQd.cQS.cRt.put(str, Boolean.valueOf(z));
        }
    }

    public String iM(String str) {
        if (this.cQd == null || this.cQd.cQS == null || this.cQd.cQS.cRu == null) {
            return null;
        }
        return this.cQd.cQS.cRu.get(com.baidu.swan.apps.scheme.actions.k.j.qW(str));
    }

    public String ql(String str) {
        if (this.cQd == null || this.cQd.cQT == null || this.cQd.cQT.cRw == null) {
            return null;
        }
        return this.cQd.cQT.cRw.get(str);
    }

    public String qm(String str) {
        if (this.cQd == null) {
            return "";
        }
        return this.cQd.qm(str);
    }

    public boolean qn(String str) {
        if (TextUtils.isEmpty(str) || this.cQd == null) {
            return false;
        }
        return this.cQd.qw(str);
    }

    public boolean aAd() {
        return qn(com.baidu.swan.apps.v.f.arY().asd());
    }

    public String aAe() {
        b.a azM = azM();
        return azM != null ? jl(azM.getType()) : "0";
    }

    private String jl(int i) {
        if (i == 0) {
            String versionCode = this.cQr != null ? this.cQr.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String sL = ak.sL(versionCode);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(sL) ? " version is empty " : sL;
            com.baidu.swan.apps.console.c.d("SwanApp", objArr);
            return sL;
        }
        return "0";
    }

    public void ce(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.cQp == null) {
                this.cQp = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.cQp.put(str2, str);
        }
    }

    @Nullable
    public String qo(String str) {
        if (TextUtils.isEmpty(str) || this.cQp == null) {
            return null;
        }
        return this.cQp.get(str);
    }

    public boolean available() {
        return this.cQc && this.cQq.aAk() && XP() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return azC();
    }

    public e fK(boolean z) {
        this.cQs = z;
        qg("event_first_action_launched");
        return this;
    }

    public boolean aAf() {
        return this.cQs;
    }
}
