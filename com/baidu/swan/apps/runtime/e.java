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
    private g deA;
    private Map<String, String> deB;
    private final k deC;
    protected final b.a deD;
    private boolean deE;
    public final boolean den;
    SwanAppConfigData deo;
    com.baidu.swan.games.t.a.a dep;
    private com.baidu.swan.apps.storage.c deq;
    private com.baidu.swan.apps.storage.b.c der;
    private com.baidu.swan.apps.setting.a det;
    private com.baidu.swan.apps.a.b deu;
    private com.baidu.swan.apps.network.j dev;
    private com.baidu.swan.games.network.b dew;
    private com.baidu.swan.apps.ag.a.a dex;
    private com.baidu.swan.apps.media.audio.d dey;
    private com.baidu.swan.apps.network.k dez;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.deC = new k(this);
        this.deD = new b.a();
        this.deE = false;
        this.id = str == null ? "" : str;
        this.den = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.den) {
            this.dex = new com.baidu.swan.apps.ag.a.a();
            this.dex.rI(this.id);
        }
    }

    @Deprecated
    public static e aDa() {
        return aDb();
    }

    public static e aDb() {
        d aCW = d.aCW();
        if (aCW.aBj()) {
            return aCW.aCS();
        }
        return null;
    }

    @Deprecated
    public static String aDc() {
        return d.aCW().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aBj() {
        return this.den;
    }

    public boolean afg() {
        com.baidu.swan.apps.framework.c abl;
        if (com.baidu.swan.apps.core.prefetch.a.a.isOn()) {
            SwanAppActivity aCU = aCU();
            return aCU == null || (abl = aCU.abl()) == null || !abl.aqw().hasStarted();
        }
        return false;
    }

    public boolean aDd() {
        com.baidu.swan.apps.framework.c abl;
        SwanAppActivity aCU = aCU();
        if (aCU == null || (abl = aCU.abl()) == null) {
            return false;
        }
        return abl.aqw().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String y(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity aCU = aCU();
        if (aCU != null && !aCU.isDestroyed() && !aCU.isFinishing() && aCU.abm()) {
            aCU.p(strArr);
        }
        com.baidu.swan.apps.v.f.release();
        if (this.deA != null) {
            this.deA.onDestroy();
        }
        com.baidu.swan.c.d.deleteFile(com.baidu.swan.apps.storage.b.sO(this.id));
        if (this.dey != null) {
            this.dey.release();
        }
        if (this.dex != null) {
            this.dex.release();
        }
        if (this.dez != null) {
            this.dez.release();
        }
        this.deq = null;
        this.det = null;
        this.dew = null;
        this.deE = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aBk() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(aDe().anI());
        swanAppCores.a(aDe().anJ());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e aCS() {
        return this;
    }

    @NonNull
    public b.a aDe() {
        return this.deD;
    }

    @NonNull
    @Deprecated
    public b.a abu() {
        return aDe();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int abk() {
        if (this.den) {
            return aDe().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = deG.contains(str);
        b.a aDe = aDe();
        HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
        qc.f(new UbcFlowEvent("swan_app_update_info_start").fw(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.deC.aDC() && aDd()) {
            if (aDe.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (aDe.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        aDe.D(bundle);
        qc.f(new UbcFlowEvent("swan_app_update_info_end").fw(true));
        if (z) {
            rm("event_on_app_occupied");
        }
        if (this.den && !this.deC.aDC() && !this.deC.aDA()) {
            qc.f(new UbcFlowEvent("swan_app_maintain_start").fw(true));
            this.deC.aDD();
            qc.f(new UbcFlowEvent("swan_app_maintain_return").fw(true));
            return true;
        }
        if (this.deC.aDC() && contains) {
            k.a(aDe, aDe.auz(), false, false, false);
        }
        return this.deC.aDA();
    }

    public com.baidu.swan.apps.u.c.b S(Bundle bundle) {
        b.a aDe = aDe();
        aDe.D(bundle);
        return aDe;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void aCT() {
        aDm().aEH();
        aDl().aw(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void rm(String str) {
        f(str, aDi());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = aDi();
        } else {
            bundle.putAll(aDi());
        }
        super.f(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.D(aDi()));
    }

    public boolean aDf() {
        return this.deC.aDA();
    }

    public boolean aDg() {
        return this.deC.aDB();
    }

    public int aDh() {
        return this.deC.aDh();
    }

    private Bundle aDi() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void L(Activity activity) {
        aDm().L(activity);
    }

    public void g(SwanAppConfigData swanAppConfigData) {
        this.deo = swanAppConfigData;
    }

    public SwanAppConfigData aDj() {
        return this.deo;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.dep = aVar;
    }

    public com.baidu.swan.games.t.a.a aDk() {
        return this.dep;
    }

    public com.baidu.swan.apps.storage.c aDl() {
        if (this.deq == null) {
            this.deq = new com.baidu.swan.apps.storage.c(this);
        }
        return this.deq;
    }

    public com.baidu.swan.apps.storage.b.c ava() {
        if (this.der == null) {
            if (aDt()) {
                this.der = new com.baidu.swan.games.i.l();
            } else {
                this.der = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.der;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a aDm() {
        if (this.det == null) {
            this.det = new com.baidu.swan.apps.setting.a(this);
        }
        return this.det;
    }

    public com.baidu.swan.apps.a.b aDn() {
        if (this.deu == null) {
            this.deu = new com.baidu.swan.apps.a.b(this);
        }
        return this.deu;
    }

    public synchronized com.baidu.swan.apps.network.j aDo() {
        if (this.dev == null) {
            this.dev = new com.baidu.swan.apps.network.j(this);
        }
        return this.dev;
    }

    public synchronized com.baidu.swan.games.network.b aDp() {
        if (this.dew == null) {
            this.dew = com.baidu.swan.games.network.b.aRW();
        }
        return this.dew;
    }

    public com.baidu.swan.apps.network.k aDq() {
        if (this.dez == null) {
            this.dez = new com.baidu.swan.apps.network.k();
        }
        return this.dez;
    }

    public com.baidu.swan.apps.media.audio.d aDr() {
        if (this.dey == null) {
            this.dey = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.dey;
    }

    @NonNull
    public g aDs() {
        if (this.deA == null) {
            this.deA = new g(this);
        }
        return this.deA;
    }

    public String getAppKey() {
        return aDe().getAppKey();
    }

    public boolean aDt() {
        return aDe().getAppFrameType() == 1;
    }

    public String getName() {
        return aDe().aoj();
    }

    public String getVersion() {
        return aDe().getVersion();
    }

    public com.baidu.swan.apps.ag.a.a aDu() {
        if (this.dex == null) {
            this.dex = new com.baidu.swan.apps.ag.a.a();
        }
        return this.dex;
    }

    public boolean rn(String str) {
        if (TextUtils.isEmpty(str) || this.deo == null || this.deo.dfd == null) {
            return false;
        }
        return this.deo.dfd.rG(str);
    }

    public boolean ro(String str) {
        if (TextUtils.isEmpty(str) || this.deo == null || this.deo.dfe == null || this.deo.dfe.dfF == null || !this.deo.dfe.dfF.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.deo.dfe.dfF.get(str).booleanValue();
    }

    public boolean rp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.aWO().X(this.id, getVersion(), str);
    }

    public boolean rq(String str) {
        return new File(com.baidu.swan.apps.v.f.avu().avb(), str).exists();
    }

    public void Z(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.deo != null && this.deo.dfe != null && this.deo.dfe.dfF != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.deo.dfe.dfF.put(str, Boolean.valueOf(z));
        }
    }

    public String jS(String str) {
        if (this.deo == null || this.deo.dfe == null || this.deo.dfe.dfG == null) {
            return null;
        }
        return this.deo.dfe.dfG.get(com.baidu.swan.apps.scheme.actions.k.j.sc(str));
    }

    public String rr(String str) {
        if (this.deo == null || this.deo.dff == null || this.deo.dff.dfI == null) {
            return null;
        }
        return this.deo.dff.dfI.get(str);
    }

    public String rs(String str) {
        if (this.deo == null) {
            return "";
        }
        return this.deo.rs(str);
    }

    public boolean rt(String str) {
        if (TextUtils.isEmpty(str) || this.deo == null) {
            return false;
        }
        return this.deo.rC(str);
    }

    public boolean aDv() {
        return rt(com.baidu.swan.apps.v.f.avu().avz());
    }

    public String aDw() {
        b.a aDe = aDe();
        return aDe != null ? jT(aDe.getType()) : "0";
    }

    private String jT(int i) {
        if (i == 0) {
            String versionCode = this.deD != null ? this.deD.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String tR = ak.tR(versionCode);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(tR) ? " version is empty " : tR;
            com.baidu.swan.apps.console.c.d("SwanApp", objArr);
            return tR;
        }
        return "0";
    }

    public void cj(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.deB == null) {
                this.deB = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.deB.put(str2, str);
        }
    }

    @Nullable
    public String ru(String str) {
        if (TextUtils.isEmpty(str) || this.deB == null) {
            return null;
        }
        return this.deB.get(str);
    }

    public boolean available() {
        return this.den && this.deC.aDC() && abk() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return aCU();
    }

    public e gf(boolean z) {
        this.deE = z;
        rm("event_first_action_launched");
        return this;
    }

    public boolean aDx() {
        return this.deE;
    }
}
