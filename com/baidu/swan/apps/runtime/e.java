package com.baidu.swan.apps.runtime;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.v.b.b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class e extends m {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.audio.d cEA;
    private com.baidu.swan.apps.network.k cEB;
    private g cEC;
    private Map<String, String> cED;
    private final k cEE;
    protected final b.a cEF;
    private boolean cEG;
    public final boolean cEq;
    SwanAppConfigData cEr;
    com.baidu.swan.games.t.a.a cEs;
    private com.baidu.swan.apps.storage.c cEt;
    private com.baidu.swan.apps.storage.b.c cEu;
    private com.baidu.swan.apps.setting.a cEv;
    private com.baidu.swan.apps.a.b cEw;
    private com.baidu.swan.apps.network.j cEx;
    private com.baidu.swan.games.network.b cEy;
    private com.baidu.swan.apps.ah.a.a cEz;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.cEE = new k(this);
        this.cEF = new b.a();
        this.cEG = false;
        this.id = str == null ? "" : str;
        this.cEq = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.cEq) {
            this.cEz = new com.baidu.swan.apps.ah.a.a();
            this.cEz.nX(this.id);
        }
    }

    @Deprecated
    public static e apM() {
        return apN();
    }

    public static e apN() {
        d apI = d.apI();
        if (apI.aok()) {
            return apI.apE();
        }
        return null;
    }

    @Deprecated
    public static String apO() {
        return d.apI().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aok() {
        return this.cEq;
    }

    public boolean Va() {
        com.baidu.swan.apps.framework.c RG;
        if (com.baidu.swan.apps.core.prefetch.a.a.abB() == 0) {
            return false;
        }
        SwanAppActivity apG = apG();
        return apG == null || (RG = apG.RG()) == null || !RG.aeH().hasStarted();
    }

    public boolean apP() {
        com.baidu.swan.apps.framework.c RG;
        SwanAppActivity apG = apG();
        if (apG == null || (RG = apG.RG()) == null) {
            return false;
        }
        return RG.aeH().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String w(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity apG = apG();
        if (apG != null && !apG.isDestroyed() && !apG.isFinishing() && apG.RH()) {
            apG.o(strArr);
        }
        com.baidu.swan.apps.w.f.release();
        if (this.cEC != null) {
            this.cEC.onDestroy();
        }
        com.baidu.swan.e.d.deleteFile(com.baidu.swan.apps.storage.b.oW(this.id));
        if (this.cEA != null) {
            this.cEA.release();
        }
        if (this.cEz != null) {
            this.cEz.release();
        }
        if (this.cEB != null) {
            this.cEB.release();
        }
        this.cEt = null;
        this.cEv = null;
        this.cEy = null;
        this.cEG = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aol() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(apQ().acM());
        swanAppCores.a(apQ().acN());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e apE() {
        return this;
    }

    @NonNull
    public b.a apQ() {
        return this.cEF;
    }

    @NonNull
    @Deprecated
    public b.a RP() {
        return apQ();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int RF() {
        if (this.cEq) {
            return apQ().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = cEI.contains(str);
        b.a apQ = apQ();
        HybridUbcFlow mx = com.baidu.swan.apps.performance.g.mx("startup");
        mx.f(new UbcFlowEvent("swan_app_update_info_start").ez(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.cEE.aqp() && apP()) {
            if (apQ.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (apQ.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        apQ.E(bundle);
        mx.f(new UbcFlowEvent("swan_app_update_info_end").ez(true));
        if (z) {
            nA("event_on_app_occupied");
        }
        if (this.cEq && !this.cEE.aqp() && !this.cEE.aqn()) {
            mx.f(new UbcFlowEvent("swan_app_maintain_start").ez(true));
            this.cEE.aqq();
            mx.f(new UbcFlowEvent("swan_app_maintain_return").ez(true));
            return true;
        }
        if (this.cEE.aqp() && contains) {
            k.a(apQ, apQ.aig(), false, false, false);
        }
        return this.cEE.aqn();
    }

    public com.baidu.swan.apps.v.b.b T(Bundle bundle) {
        b.a apQ = apQ();
        apQ.E(bundle);
        return apQ;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void apF() {
        apY().aro();
        apX().av(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void nA(String str) {
        g(str, apU());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void g(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = apU();
        } else {
            bundle.putAll(apU());
        }
        super.g(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.E(apU()));
    }

    public boolean apR() {
        return this.cEE.aqn();
    }

    public boolean apS() {
        return this.cEE.aqo();
    }

    public int apT() {
        return this.cEE.apT();
    }

    private Bundle apU() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void onActivityResume(Activity activity) {
        apY().onActivityResume(activity);
    }

    public void f(SwanAppConfigData swanAppConfigData) {
        this.cEr = swanAppConfigData;
    }

    public SwanAppConfigData apV() {
        return this.cEr;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.cEs = aVar;
    }

    public com.baidu.swan.games.t.a.a apW() {
        return this.cEs;
    }

    public com.baidu.swan.apps.storage.c apX() {
        if (this.cEt == null) {
            this.cEt = new com.baidu.swan.apps.storage.c(this);
        }
        return this.cEt;
    }

    public com.baidu.swan.apps.storage.b.c aiH() {
        if (this.cEu == null) {
            if (aqf()) {
                this.cEu = new com.baidu.swan.games.i.l();
            } else {
                this.cEu = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.cEu;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a apY() {
        if (this.cEv == null) {
            this.cEv = new com.baidu.swan.apps.setting.a(this);
        }
        return this.cEv;
    }

    public com.baidu.swan.apps.a.b apZ() {
        if (this.cEw == null) {
            this.cEw = new com.baidu.swan.apps.a.b(this);
        }
        return this.cEw;
    }

    public synchronized com.baidu.swan.apps.network.j aqa() {
        if (this.cEx == null) {
            this.cEx = new com.baidu.swan.apps.network.j(this);
        }
        return this.cEx;
    }

    public synchronized com.baidu.swan.games.network.b aqb() {
        if (this.cEy == null) {
            this.cEy = com.baidu.swan.games.network.b.aCe();
        }
        return this.cEy;
    }

    public com.baidu.swan.apps.network.k aqc() {
        if (this.cEB == null) {
            this.cEB = new com.baidu.swan.apps.network.k();
        }
        return this.cEB;
    }

    public com.baidu.swan.apps.media.audio.d aqd() {
        if (this.cEA == null) {
            this.cEA = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.cEA;
    }

    @NonNull
    public g aqe() {
        if (this.cEC == null) {
            this.cEC = new g(this);
        }
        return this.cEC;
    }

    public String getAppKey() {
        return apQ().getAppKey();
    }

    public boolean aqf() {
        return apQ().getAppFrameType() == 1;
    }

    public String getName() {
        return apQ().acZ();
    }

    public String getVersion() {
        return apQ().getVersion();
    }

    public com.baidu.swan.apps.ah.a.a aqg() {
        if (this.cEz == null) {
            this.cEz = new com.baidu.swan.apps.ah.a.a();
        }
        return this.cEz;
    }

    public boolean nB(String str) {
        if (TextUtils.isEmpty(str) || this.cEr == null || this.cEr.cFc == null) {
            return false;
        }
        return this.cEr.cFc.nV(str);
    }

    public boolean nC(String str) {
        if (TextUtils.isEmpty(str) || this.cEr == null || this.cEr.cFd == null || this.cEr.cFd.cFC == null || !this.cEr.cFd.cFC.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.cEr.cFd.cFC.get(str).booleanValue();
    }

    public boolean nD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.aHb().W(this.id, getVersion(), str);
    }

    public boolean nE(String str) {
        return new File(com.baidu.swan.apps.w.f.ajb().aiI(), str).exists();
    }

    public void R(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.cEr != null && this.cEr.cFd != null && this.cEr.cFd.cFC != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.cEr.cFd.cFC.put(str, Boolean.valueOf(z));
        }
    }

    public String nF(String str) {
        if (this.cEr == null || this.cEr.cFd == null || this.cEr.cFd.cFD == null) {
            return null;
        }
        return this.cEr.cFd.cFD.get(com.baidu.swan.apps.scheme.actions.k.j.oq(str));
    }

    public String nG(String str) {
        if (this.cEr == null || this.cEr.cFe == null || this.cEr.cFe.cFF == null) {
            return null;
        }
        return this.cEr.cFe.cFF.get(str);
    }

    public String nH(String str) {
        if (this.cEr == null) {
            return "";
        }
        return this.cEr.nH(str);
    }

    public boolean nI(String str) {
        if (TextUtils.isEmpty(str) || this.cEr == null) {
            return false;
        }
        return this.cEr.nR(str);
    }

    public boolean aqh() {
        return nI(com.baidu.swan.apps.w.f.ajb().ajg());
    }

    public String aqi() {
        b.a apQ = apQ();
        return apQ != null ? gV(apQ.getType()) : "0";
    }

    private String gV(int i) {
        if (i == 0) {
            String versionCode = this.cEF != null ? this.cEF.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String pX = aj.pX(versionCode);
            com.baidu.swan.apps.console.c.e("SwanApp", TextUtils.isEmpty(pX) ? " version is empty " : pX);
            return pX;
        }
        return "0";
    }

    public void bM(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.cED == null) {
                this.cED = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.cED.put(str2, str);
        }
    }

    @Nullable
    public String nJ(String str) {
        if (TextUtils.isEmpty(str) || this.cED == null) {
            return null;
        }
        return this.cED.get(str);
    }

    public boolean available() {
        return this.cEq && this.cEE.aqp() && RF() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return apG();
    }

    public e fi(boolean z) {
        this.cEG = z;
        nA("event_first_action_launched");
        return this;
    }

    public boolean aqj() {
        return this.cEG;
    }
}
