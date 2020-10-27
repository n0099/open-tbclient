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
    public final boolean dmN;
    SwanAppConfigData dmO;
    com.baidu.swan.games.t.a.a dmP;
    private com.baidu.swan.apps.storage.c dmQ;
    private com.baidu.swan.apps.storage.b.c dmR;
    private com.baidu.swan.apps.setting.a dmS;
    private com.baidu.swan.apps.a.b dmT;
    private com.baidu.swan.apps.network.j dmU;
    private com.baidu.swan.games.network.b dmV;
    private com.baidu.swan.apps.ag.a.a dmW;
    private com.baidu.swan.apps.media.audio.d dmX;
    private com.baidu.swan.apps.network.k dmY;
    private g dmZ;
    private Map<String, String> dna;
    private final k dnb;
    protected final b.a dnc;
    private boolean dnd;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.dnb = new k(this);
        this.dnc = new b.a();
        this.dnd = false;
        this.id = str == null ? "" : str;
        this.dmN = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.dmN) {
            this.dmW = new com.baidu.swan.apps.ag.a.a();
            this.dmW.sb(this.id);
        }
    }

    @Deprecated
    public static e aEU() {
        return aEV();
    }

    public static e aEV() {
        d aEQ = d.aEQ();
        if (aEQ.aDd()) {
            return aEQ.aEM();
        }
        return null;
    }

    @Deprecated
    public static String aEW() {
        return d.aEQ().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aDd() {
        return this.dmN;
    }

    public boolean aha() {
        com.baidu.swan.apps.framework.c adf;
        if (com.baidu.swan.apps.core.prefetch.a.a.isOn()) {
            SwanAppActivity aEO = aEO();
            return aEO == null || (adf = aEO.adf()) == null || !adf.asr().hasStarted();
        }
        return false;
    }

    public boolean aEX() {
        com.baidu.swan.apps.framework.c adf;
        SwanAppActivity aEO = aEO();
        if (aEO == null || (adf = aEO.adf()) == null) {
            return false;
        }
        return adf.asr().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String z(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity aEO = aEO();
        if (aEO != null && !aEO.isDestroyed() && !aEO.isFinishing() && aEO.adg()) {
            aEO.q(strArr);
        }
        com.baidu.swan.apps.v.f.release();
        if (this.dmZ != null) {
            this.dmZ.onDestroy();
        }
        com.baidu.swan.c.d.deleteFile(com.baidu.swan.apps.storage.b.th(this.id));
        if (this.dmX != null) {
            this.dmX.release();
        }
        if (this.dmW != null) {
            this.dmW.release();
        }
        if (this.dmY != null) {
            this.dmY.release();
        }
        this.dmQ = null;
        this.dmS = null;
        this.dmV = null;
        this.dnd = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aDe() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(aEY().apD());
        swanAppCores.a(aEY().apE());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e aEM() {
        return this;
    }

    @NonNull
    public b.a aEY() {
        return this.dnc;
    }

    @NonNull
    @Deprecated
    public b.a ado() {
        return aEY();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int ade() {
        if (this.dmN) {
            return aEY().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = dnf.contains(str);
        b.a aEY = aEY();
        HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
        qv.f(new UbcFlowEvent("swan_app_update_info_start").fJ(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.dnb.aFw() && aEX()) {
            if (aEY.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (aEY.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        aEY.D(bundle);
        qv.f(new UbcFlowEvent("swan_app_update_info_end").fJ(true));
        if (z) {
            rF("event_on_app_occupied");
        }
        if (this.dmN && !this.dnb.aFw() && !this.dnb.aFu()) {
            qv.f(new UbcFlowEvent("swan_app_maintain_start").fJ(true));
            this.dnb.aFx();
            qv.f(new UbcFlowEvent("swan_app_maintain_return").fJ(true));
            return true;
        }
        if (this.dnb.aFw() && contains) {
            k.a(aEY, aEY.awt(), false, false, false);
        }
        return this.dnb.aFu();
    }

    public com.baidu.swan.apps.u.c.b S(Bundle bundle) {
        b.a aEY = aEY();
        aEY.D(bundle);
        return aEY;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void aEN() {
        aFg().aGB();
        aFf().aw(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void rF(String str) {
        f(str, aFc());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = aFc();
        } else {
            bundle.putAll(aFc());
        }
        super.f(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.D(aFc()));
    }

    public boolean aEZ() {
        return this.dnb.aFu();
    }

    public boolean aFa() {
        return this.dnb.aFv();
    }

    public int aFb() {
        return this.dnb.aFb();
    }

    private Bundle aFc() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void L(Activity activity) {
        aFg().L(activity);
    }

    public void g(SwanAppConfigData swanAppConfigData) {
        this.dmO = swanAppConfigData;
    }

    public SwanAppConfigData aFd() {
        return this.dmO;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.dmP = aVar;
    }

    public com.baidu.swan.games.t.a.a aFe() {
        return this.dmP;
    }

    public com.baidu.swan.apps.storage.c aFf() {
        if (this.dmQ == null) {
            this.dmQ = new com.baidu.swan.apps.storage.c(this);
        }
        return this.dmQ;
    }

    public com.baidu.swan.apps.storage.b.c awU() {
        if (this.dmR == null) {
            if (aFn()) {
                this.dmR = new com.baidu.swan.games.i.l();
            } else {
                this.dmR = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.dmR;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a aFg() {
        if (this.dmS == null) {
            this.dmS = new com.baidu.swan.apps.setting.a(this);
        }
        return this.dmS;
    }

    public com.baidu.swan.apps.a.b aFh() {
        if (this.dmT == null) {
            this.dmT = new com.baidu.swan.apps.a.b(this);
        }
        return this.dmT;
    }

    public synchronized com.baidu.swan.apps.network.j aFi() {
        if (this.dmU == null) {
            this.dmU = new com.baidu.swan.apps.network.j(this);
        }
        return this.dmU;
    }

    public synchronized com.baidu.swan.games.network.b aFj() {
        if (this.dmV == null) {
            this.dmV = com.baidu.swan.games.network.b.aTQ();
        }
        return this.dmV;
    }

    public com.baidu.swan.apps.network.k aFk() {
        if (this.dmY == null) {
            this.dmY = new com.baidu.swan.apps.network.k();
        }
        return this.dmY;
    }

    public com.baidu.swan.apps.media.audio.d aFl() {
        if (this.dmX == null) {
            this.dmX = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.dmX;
    }

    @NonNull
    public g aFm() {
        if (this.dmZ == null) {
            this.dmZ = new g(this);
        }
        return this.dmZ;
    }

    public String getAppKey() {
        return aEY().getAppKey();
    }

    public boolean aFn() {
        return aEY().getAppFrameType() == 1;
    }

    public String getName() {
        return aEY().aqe();
    }

    public String getVersion() {
        return aEY().getVersion();
    }

    public com.baidu.swan.apps.ag.a.a aFo() {
        if (this.dmW == null) {
            this.dmW = new com.baidu.swan.apps.ag.a.a();
        }
        return this.dmW;
    }

    public boolean rG(String str) {
        if (TextUtils.isEmpty(str) || this.dmO == null || this.dmO.dnD == null) {
            return false;
        }
        return this.dmO.dnD.rZ(str);
    }

    public boolean rH(String str) {
        if (TextUtils.isEmpty(str) || this.dmO == null || this.dmO.dnE == null || this.dmO.dnE.dog == null || !this.dmO.dnE.dog.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.dmO.dnE.dog.get(str).booleanValue();
    }

    public boolean rI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.aYH().ae(this.id, getVersion(), str);
    }

    public boolean rJ(String str) {
        return new File(com.baidu.swan.apps.v.f.axo().awV(), str).exists();
    }

    public void ab(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dmO != null && this.dmO.dnE != null && this.dmO.dnE.dog != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dmO.dnE.dog.put(str, Boolean.valueOf(z));
        }
    }

    public String kl(String str) {
        if (this.dmO == null || this.dmO.dnE == null || this.dmO.dnE.doh == null) {
            return null;
        }
        return this.dmO.dnE.doh.get(com.baidu.swan.apps.scheme.actions.k.j.sw(str));
    }

    public String rK(String str) {
        if (this.dmO == null || this.dmO.dnF == null || this.dmO.dnF.doj == null) {
            return null;
        }
        return this.dmO.dnF.doj.get(str);
    }

    public String rL(String str) {
        if (this.dmO == null) {
            return "";
        }
        return this.dmO.rL(str);
    }

    public boolean rM(String str) {
        if (TextUtils.isEmpty(str) || this.dmO == null) {
            return false;
        }
        return this.dmO.rV(str);
    }

    public boolean aFp() {
        return rM(com.baidu.swan.apps.v.f.axo().axt());
    }

    public String aFq() {
        b.a aEY = aEY();
        return aEY != null ? ke(aEY.getType()) : "0";
    }

    private String ke(int i) {
        if (i == 0) {
            String versionCode = this.dnc != null ? this.dnc.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String uk = ak.uk(versionCode);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(uk) ? " version is empty " : uk;
            com.baidu.swan.apps.console.c.d("SwanApp", objArr);
            return uk;
        }
        return "0";
    }

    public void cq(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.dna == null) {
                this.dna = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.dna.put(str2, str);
        }
    }

    @Nullable
    public String rN(String str) {
        if (TextUtils.isEmpty(str) || this.dna == null) {
            return null;
        }
        return this.dna.get(str);
    }

    public boolean available() {
        return this.dmN && this.dnb.aFw() && ade() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return aEO();
    }

    public e gs(boolean z) {
        this.dnd = z;
        rF("event_first_action_launched");
        return this;
    }

    public boolean aFr() {
        return this.dnd;
    }
}
