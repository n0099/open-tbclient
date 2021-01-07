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
    public final boolean dGI;
    SwanAppConfigData dGJ;
    com.baidu.swan.games.t.a.a dGK;
    private com.baidu.swan.apps.storage.c dGL;
    private com.baidu.swan.apps.storage.b.c dGM;
    private com.baidu.swan.apps.setting.a dGN;
    private com.baidu.swan.apps.a.b dGO;
    private com.baidu.swan.apps.network.j dGP;
    private com.baidu.swan.games.network.b dGQ;
    private com.baidu.swan.apps.af.a.a dGR;
    private com.baidu.swan.apps.media.audio.d dGS;
    private com.baidu.swan.apps.network.k dGT;
    private g dGU;
    private Map<String, String> dGV;
    private final k dGW;
    protected final b.a dGX;
    private boolean dGY;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.dGW = new k(this);
        this.dGX = new b.a();
        this.dGY = false;
        this.id = str == null ? "" : str;
        this.dGI = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.dGI) {
            this.dGR = new com.baidu.swan.apps.af.a.a();
            this.dGR.sP(this.id);
        }
    }

    @Deprecated
    public static e aMl() {
        return aMm();
    }

    public static e aMm() {
        d aMh = d.aMh();
        if (aMh.aJx()) {
            return aMh.aMd();
        }
        return null;
    }

    @Deprecated
    public static String aMn() {
        return d.aMh().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aJx() {
        return this.dGI;
    }

    public boolean anl() {
        com.baidu.swan.apps.framework.c ajm;
        if (com.baidu.swan.apps.core.prefetch.a.a.isOn()) {
            SwanAppActivity aMf = aMf();
            return aMf == null || (ajm = aMf.ajm()) == null || !ajm.ayJ().hasStarted();
        }
        return false;
    }

    public boolean aMo() {
        com.baidu.swan.apps.framework.c ajm;
        SwanAppActivity aMf = aMf();
        if (aMf == null || (ajm = aMf.ajm()) == null) {
            return false;
        }
        return ajm.ayJ().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String G(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity aMf = aMf();
        if (aMf != null && !aMf.isDestroyed() && !aMf.isFinishing() && aMf.ajn()) {
            aMf.x(strArr);
        }
        com.baidu.swan.apps.v.f.release();
        if (this.dGU != null) {
            this.dGU.onDestroy();
        }
        com.baidu.swan.c.d.deleteFile(com.baidu.swan.apps.storage.b.tU(this.id));
        if (this.dGS != null) {
            this.dGS.release();
        }
        if (this.dGR != null) {
            this.dGR.release();
        }
        if (this.dGT != null) {
            this.dGT.release();
        }
        this.dGL = null;
        this.dGN = null;
        this.dGQ = null;
        this.dGY = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aJy() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(aMp().avW());
        swanAppCores.a(aMp().avX());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e aMd() {
        return this;
    }

    @NonNull
    public b.a aMp() {
        return this.dGX;
    }

    @NonNull
    @Deprecated
    public b.a ajv() {
        return aMp();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int ajl() {
        if (this.dGI) {
            return aMp().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = dHa.contains(str);
        b.a aMp = aMp();
        HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
        rd.f(new UbcFlowEvent("swan_app_update_info_start").gt(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.dGW.aMN() && aMo()) {
            if (aMp.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (aMp.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        aMp.D(bundle);
        rd.f(new UbcFlowEvent("swan_app_update_info_end").gt(true));
        if (z) {
            ss("event_on_app_occupied");
        }
        if (this.dGI && !this.dGW.aMN() && !this.dGW.aML()) {
            rd.f(new UbcFlowEvent("swan_app_maintain_start").gt(true));
            this.dGW.aMO();
            rd.f(new UbcFlowEvent("swan_app_maintain_return").gt(true));
            return true;
        }
        if (this.dGW.aMN() && contains) {
            k.a(aMp, aMp.aCM(), false, false, false);
        }
        return this.dGW.aML();
    }

    public com.baidu.swan.apps.u.c.b S(Bundle bundle) {
        b.a aMp = aMp();
        aMp.D(bundle);
        return aMp;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void aMe() {
        aMx().aNS();
        aMw().au(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void ss(String str) {
        f(str, aMt());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = aMt();
        } else {
            bundle.putAll(aMt());
        }
        super.f(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.D(aMt()));
    }

    public boolean aMq() {
        return this.dGW.aML();
    }

    public boolean aMr() {
        return this.dGW.aMM();
    }

    public int aMs() {
        return this.dGW.aMs();
    }

    private Bundle aMt() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void L(Activity activity) {
        aMx().L(activity);
    }

    public void g(SwanAppConfigData swanAppConfigData) {
        this.dGJ = swanAppConfigData;
    }

    public SwanAppConfigData aMu() {
        return this.dGJ;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.dGK = aVar;
    }

    public com.baidu.swan.games.t.a.a aMv() {
        return this.dGK;
    }

    public com.baidu.swan.apps.storage.c aMw() {
        if (this.dGL == null) {
            this.dGL = new com.baidu.swan.apps.storage.c(this);
        }
        return this.dGL;
    }

    public com.baidu.swan.apps.storage.b.c aDn() {
        if (this.dGM == null) {
            if (aME()) {
                this.dGM = new com.baidu.swan.games.i.l();
            } else {
                this.dGM = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.dGM;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a aMx() {
        if (this.dGN == null) {
            this.dGN = new com.baidu.swan.apps.setting.a(this);
        }
        return this.dGN;
    }

    public com.baidu.swan.apps.a.b aMy() {
        if (this.dGO == null) {
            this.dGO = new com.baidu.swan.apps.a.b(this);
        }
        return this.dGO;
    }

    public synchronized com.baidu.swan.apps.network.j aMz() {
        if (this.dGP == null) {
            this.dGP = new com.baidu.swan.apps.network.j(this);
        }
        return this.dGP;
    }

    public synchronized com.baidu.swan.games.network.b aMA() {
        if (this.dGQ == null) {
            this.dGQ = com.baidu.swan.games.network.b.bbi();
        }
        return this.dGQ;
    }

    public com.baidu.swan.apps.network.k aMB() {
        if (this.dGT == null) {
            this.dGT = new com.baidu.swan.apps.network.k();
        }
        return this.dGT;
    }

    public com.baidu.swan.apps.media.audio.d aMC() {
        if (this.dGS == null) {
            this.dGS = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.dGS;
    }

    @NonNull
    public g aMD() {
        if (this.dGU == null) {
            this.dGU = new g(this);
        }
        return this.dGU;
    }

    public String getAppKey() {
        return aMp().getAppKey();
    }

    public boolean aME() {
        return aMp().getAppFrameType() == 1;
    }

    public String getName() {
        return aMp().awy();
    }

    public String getVersion() {
        return aMp().getVersion();
    }

    public com.baidu.swan.apps.af.a.a aMF() {
        if (this.dGR == null) {
            this.dGR = new com.baidu.swan.apps.af.a.a();
        }
        return this.dGR;
    }

    public boolean st(String str) {
        if (TextUtils.isEmpty(str) || this.dGJ == null || this.dGJ.dHx == null) {
            return false;
        }
        return this.dGJ.dHx.sN(str);
    }

    public boolean su(String str) {
        if (TextUtils.isEmpty(str) || this.dGJ == null || this.dGJ.dHy == null || this.dGJ.dHy.dHZ == null || !this.dGJ.dHy.dHZ.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.dGJ.dHy.dHZ.get(str).booleanValue();
    }

    public boolean sv(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.bgc().ak(this.id, getVersion(), str);
    }

    public boolean sw(String str) {
        return new File(com.baidu.swan.apps.v.f.aDH().aDo(), str).exists();
    }

    public void ac(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dGJ != null && this.dGJ.dHy != null && this.dGJ.dHy.dHZ != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dGJ.dHy.dHZ.put(str, Boolean.valueOf(z));
        }
    }

    public String kU(String str) {
        if (this.dGJ == null || this.dGJ.dHy == null || this.dGJ.dHy.dIa == null) {
            return null;
        }
        return this.dGJ.dHy.dIa.get(com.baidu.swan.apps.scheme.actions.k.j.tj(str));
    }

    public String sx(String str) {
        if (this.dGJ == null || this.dGJ.dHz == null || this.dGJ.dHz.dIc == null) {
            return null;
        }
        return this.dGJ.dHz.dIc.get(str);
    }

    public String sy(String str) {
        if (this.dGJ == null) {
            return "";
        }
        return this.dGJ.sy(str);
    }

    public boolean sz(String str) {
        if (TextUtils.isEmpty(str) || this.dGJ == null) {
            return false;
        }
        return this.dGJ.sJ(str);
    }

    public boolean aMG() {
        return sz(com.baidu.swan.apps.v.f.aDH().aDM());
    }

    public String aMH() {
        b.a aMp = aMp();
        return aMp != null ? kO(aMp.getType()) : "0";
    }

    private String kO(int i) {
        if (i == 0) {
            String versionCode = this.dGX != null ? this.dGX.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String uZ = ak.uZ(versionCode);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(uZ) ? " version is empty " : uZ;
            com.baidu.swan.apps.console.c.d("SwanApp", objArr);
            return uZ;
        }
        return "0";
    }

    public void cv(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.dGV == null) {
                this.dGV = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.dGV.put(str2, str);
        }
    }

    @Nullable
    public String sA(String str) {
        if (TextUtils.isEmpty(str) || this.dGV == null) {
            return null;
        }
        return this.dGV.get(str);
    }

    public boolean available() {
        return this.dGI && this.dGW.aMN() && ajl() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return aMf();
    }

    public e hl(boolean z) {
        this.dGY = z;
        ss("event_first_action_launched");
        return this;
    }

    public boolean aMI() {
        return this.dGY;
    }
}
