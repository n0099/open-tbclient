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
/* loaded from: classes10.dex */
public class e extends l {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final boolean bKP;
    SwanAppConfigData bKQ;
    com.baidu.swan.games.s.a.a bKR;
    private com.baidu.swan.apps.storage.c bKS;
    private com.baidu.swan.apps.storage.b.c bKT;
    private com.baidu.swan.apps.setting.a bKU;
    private com.baidu.swan.apps.a.b bKV;
    private com.baidu.swan.apps.network.j bKW;
    private com.baidu.swan.games.network.b bKX;
    private com.baidu.swan.apps.aj.a.a bKY;
    private com.baidu.swan.apps.media.audio.d bKZ;
    private com.baidu.swan.apps.network.k bLa;
    private g bLb;
    private Map<String, String> bLc;
    private final k bLd;
    protected final b.a bLe;
    private boolean bLf;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.bLd = new k(this);
        this.bLe = new b.a();
        this.bLf = false;
        this.id = str == null ? "" : str;
        this.bKP = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.bKP) {
            this.bKY = new com.baidu.swan.apps.aj.a.a();
            this.bKY.kR(this.id);
        }
    }

    @Deprecated
    public static e aap() {
        return aaq();
    }

    public static e aaq() {
        d aam = d.aam();
        if (aam.YT()) {
            return aam.aaj();
        }
        return null;
    }

    @Deprecated
    public static String aar() {
        return d.aam().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean YT() {
        return this.bKP;
    }

    public boolean Ho() {
        com.baidu.swan.apps.framework.c Ee;
        if (com.baidu.swan.apps.core.prefetch.a.a.Nz() == 0) {
            return false;
        }
        SwanAppActivity aal = aal();
        return aal == null || (Ee = aal.Ee()) == null || !Ee.Qt().hasStarted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String s(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity aal = aal();
        if (aal != null && !aal.isDestroyed() && !aal.isFinishing() && aal.Ef()) {
            aal.m(strArr);
        }
        com.baidu.swan.apps.y.f.release();
        if (this.bLb != null) {
            this.bLb.onDestroy();
        }
        com.baidu.swan.d.c.deleteFile(com.baidu.swan.apps.storage.b.lJ(this.id));
        if (this.bKZ != null) {
            this.bKZ.release();
        }
        if (this.bKY != null) {
            this.bKY.release();
        }
        if (this.bLa != null) {
            this.bLa.release();
        }
        this.bKS = null;
        this.bKU = null;
        this.bKX = null;
        this.bLf = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores YU() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(aas().OA());
        swanAppCores.a(aas().OB());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public e aaj() {
        return this;
    }

    @NonNull
    public b.a aas() {
        return this.bLe;
    }

    @NonNull
    @Deprecated
    public b.a En() {
        return aas();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Ed() {
        if (this.bKP) {
            return aas().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = bLh.contains(str);
        b.a aas = aas();
        HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
        jA.f(new UbcFlowEvent("swan_app_update_info_start").cZ(true));
        aas.B(bundle);
        jA.f(new UbcFlowEvent("swan_app_update_info_end").cZ(true));
        if (z) {
            kw("event_on_app_occupied");
        }
        if (this.bKP && !this.bLd.aaP() && !this.bLd.aaO()) {
            jA.f(new UbcFlowEvent("swan_app_maintain_start").cZ(true));
            this.bLd.aaQ();
            jA.f(new UbcFlowEvent("swan_app_maintain_return").cZ(true));
            return true;
        }
        if (this.bLd.aaP() && contains) {
            k.a(aas, aas.TJ(), false, false);
        }
        return this.bLd.aaO();
    }

    public com.baidu.swan.apps.x.b.b N(Bundle bundle) {
        b.a aas = aas();
        aas.B(bundle);
        return aas;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void aak() {
        aaz().abI();
        aax().Q(true);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void kw(String str) {
        d(str, aau());
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = aau();
        } else {
            bundle.putAll(aau());
        }
        super.d(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(i.a aVar) {
        super.d((i.a) aVar.B(aau()));
    }

    public boolean aat() {
        return this.bLd.aaO();
    }

    private Bundle aau() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void onActivityResume(Activity activity) {
        aaz().onActivityResume(activity);
    }

    public void c(SwanAppConfigData swanAppConfigData) {
        this.bKQ = swanAppConfigData;
    }

    public SwanAppConfigData aav() {
        return this.bKQ;
    }

    public void a(com.baidu.swan.games.s.a.a aVar) {
        this.bKR = aVar;
    }

    public com.baidu.swan.games.s.a.a aaw() {
        return this.bKR;
    }

    public com.baidu.swan.apps.storage.c aax() {
        if (this.bKS == null) {
            this.bKS = new com.baidu.swan.apps.storage.c(this);
        }
        return this.bKS;
    }

    public com.baidu.swan.apps.storage.b.c aay() {
        if (this.bKT == null) {
            if (aaG()) {
                this.bKT = new com.baidu.swan.games.h.k();
            } else {
                this.bKT = new com.baidu.swan.apps.storage.b.b();
            }
        }
        return this.bKT;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a aaz() {
        if (this.bKU == null) {
            this.bKU = new com.baidu.swan.apps.setting.a(this);
        }
        return this.bKU;
    }

    public com.baidu.swan.apps.a.b aaA() {
        if (this.bKV == null) {
            this.bKV = new com.baidu.swan.apps.a.b(this);
        }
        return this.bKV;
    }

    public synchronized com.baidu.swan.apps.network.j aaB() {
        if (this.bKW == null) {
            this.bKW = new com.baidu.swan.apps.network.j(this);
        }
        return this.bKW;
    }

    public synchronized com.baidu.swan.games.network.b aaC() {
        if (this.bKX == null) {
            this.bKX = com.baidu.swan.games.network.b.amC();
        }
        return this.bKX;
    }

    public com.baidu.swan.apps.network.k aaD() {
        if (this.bLa == null) {
            this.bLa = new com.baidu.swan.apps.network.k();
        }
        return this.bLa;
    }

    public com.baidu.swan.apps.media.audio.d aaE() {
        if (this.bKZ == null) {
            this.bKZ = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.bKZ;
    }

    @NonNull
    public g aaF() {
        if (this.bLb == null) {
            this.bLb = new g(this);
        }
        return this.bLb;
    }

    public String getAppKey() {
        return aas().getAppKey();
    }

    public boolean aaG() {
        return aas().getAppFrameType() == 1;
    }

    public String getName() {
        return aas().OL();
    }

    public String getVersion() {
        return aas().getVersion();
    }

    public com.baidu.swan.apps.aj.a.a aaH() {
        if (this.bKY == null) {
            this.bKY = new com.baidu.swan.apps.aj.a.a();
        }
        return this.bKY;
    }

    public boolean kx(String str) {
        if (TextUtils.isEmpty(str) || this.bKQ == null || this.bKQ.bLw == null) {
            return false;
        }
        return this.bKQ.bLw.kP(str);
    }

    public boolean ky(String str) {
        if (TextUtils.isEmpty(str) || this.bKQ == null || this.bKQ.bLx == null || this.bKQ.bLx.bLS == null || !this.bKQ.bLx.bLS.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.bKQ.bLx.bLS.get(str).booleanValue();
    }

    public boolean kz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.arf().P(this.id, getVersion(), str);
    }

    public boolean kA(String str) {
        return new File(com.baidu.swan.apps.y.f.UC().Uk(), str).exists();
    }

    public void y(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.bKQ != null && this.bKQ.bLx != null && this.bKQ.bLx.bLS != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bKQ.bLx.bLS.put(str, Boolean.valueOf(z));
        }
    }

    public String kB(String str) {
        if (this.bKQ == null || this.bKQ.bLx == null || this.bKQ.bLx.bLT == null) {
            return null;
        }
        return this.bKQ.bLx.bLT.get(str);
    }

    public String kC(String str) {
        if (this.bKQ == null || this.bKQ.bLy == null || this.bKQ.bLy.bLV == null) {
            return null;
        }
        return this.bKQ.bLy.bLV.get(str);
    }

    public String kD(String str) {
        if (this.bKQ == null) {
            return "";
        }
        return this.bKQ.kD(str);
    }

    public boolean kE(String str) {
        if (TextUtils.isEmpty(str) || this.bKQ == null) {
            return false;
        }
        return this.bKQ.kM(str);
    }

    public boolean aaI() {
        return kE(com.baidu.swan.apps.y.f.UC().UG());
    }

    public String aaJ() {
        b.a aas = aas();
        return aas != null ? fT(aas.getType()) : "0";
    }

    private String fT(int i) {
        if (i == 0) {
            String versionCode = this.bLe != null ? this.bLe.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String mF = ai.mF(versionCode);
            com.baidu.swan.apps.console.c.e("SwanApp", TextUtils.isEmpty(mF) ? " version is empty " : mF);
            return mF;
        }
        return "0";
    }

    public void aX(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.bLc == null) {
                this.bLc = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.bLc.put(str2, str);
        }
    }

    @Nullable
    public String kF(String str) {
        if (TextUtils.isEmpty(str) || this.bLc == null) {
            return null;
        }
        return this.bLc.get(str);
    }

    public boolean available() {
        return this.bKP && this.bLd.aaP() && Ed() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return aal();
    }

    public e dG(boolean z) {
        this.bLf = z;
        kw("event_first_action_launched");
        return this;
    }

    public boolean aaK() {
        return this.bLf;
    }
}
