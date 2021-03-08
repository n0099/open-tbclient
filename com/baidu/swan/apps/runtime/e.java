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
/* loaded from: classes8.dex */
public class e extends m {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final boolean dFB;
    SwanAppConfigData dFC;
    com.baidu.swan.games.t.a.a dFD;
    private com.baidu.swan.apps.storage.c dFE;
    private com.baidu.swan.apps.storage.b.c dFF;
    private com.baidu.swan.apps.setting.a dFG;
    private com.baidu.swan.apps.a.b dFH;
    private com.baidu.swan.apps.network.j dFI;
    private com.baidu.swan.games.network.b dFJ;
    private com.baidu.swan.apps.af.a.a dFK;
    private com.baidu.swan.apps.media.audio.d dFL;
    private com.baidu.swan.apps.network.k dFM;
    private g dFN;
    private Map<String, String> dFO;
    private final k dFP;
    protected final b.a dFQ;
    private boolean dFR;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.dFP = new k(this);
        this.dFQ = new b.a();
        this.dFR = false;
        this.id = str == null ? "" : str;
        this.dFB = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.dFB) {
            this.dFK = new com.baidu.swan.apps.af.a.a();
            this.dFK.sd(this.id);
        }
    }

    @Deprecated
    public static e aIN() {
        return aIO();
    }

    public static e aIO() {
        d aIJ = d.aIJ();
        if (aIJ.aGb()) {
            return aIJ.aIF();
        }
        return null;
    }

    @Deprecated
    public static String aIP() {
        return d.aIJ().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aGb() {
        return this.dFB;
    }

    public boolean ajS() {
        com.baidu.swan.apps.framework.c afT;
        if (com.baidu.swan.apps.core.prefetch.a.a.isOn()) {
            SwanAppActivity aIH = aIH();
            return aIH == null || (afT = aIH.afT()) == null || !afT.avq().hasStarted();
        }
        return false;
    }

    public boolean aIQ() {
        com.baidu.swan.apps.framework.c afT;
        SwanAppActivity aIH = aIH();
        if (aIH == null || (afT = aIH.afT()) == null) {
            return false;
        }
        return afT.avq().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String G(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity aIH = aIH();
        if (aIH != null && !aIH.isDestroyed() && !aIH.isFinishing() && aIH.afU()) {
            aIH.x(strArr);
        }
        com.baidu.swan.apps.v.f.release();
        if (this.dFN != null) {
            this.dFN.onDestroy();
        }
        com.baidu.swan.c.d.deleteFile(com.baidu.swan.apps.storage.b.tj(this.id));
        if (this.dFL != null) {
            this.dFL.release();
        }
        if (this.dFK != null) {
            this.dFK.release();
        }
        if (this.dFM != null) {
            this.dFM.release();
        }
        this.dFE = null;
        this.dFG = null;
        this.dFJ = null;
        this.dFR = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aGc() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(aIR().asD());
        swanAppCores.a(aIR().asE());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e aIF() {
        return this;
    }

    @NonNull
    public b.a aIR() {
        return this.dFQ;
    }

    @NonNull
    @Deprecated
    public b.a agc() {
        return aIR();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int getFrameType() {
        if (this.dFB) {
            return aIR().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = dFT.contains(str);
        b.a aIR = aIR();
        HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
        qr.f(new UbcFlowEvent("swan_app_update_info_start").gr(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.dFP.aJp() && aIQ()) {
            if (aIR.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (aIR.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        aIR.D(bundle);
        qr.f(new UbcFlowEvent("swan_app_update_info_end").gr(true));
        if (z) {
            rG("event_on_app_occupied");
        }
        if (this.dFB && !this.dFP.aJp() && !this.dFP.aJn()) {
            qr.f(new UbcFlowEvent("swan_app_maintain_start").gr(true));
            this.dFP.aJq();
            qr.f(new UbcFlowEvent("swan_app_maintain_return").gr(true));
            return true;
        }
        if (this.dFP.aJp() && contains) {
            k.a(aIR, aIR.azt(), false, false, false);
        }
        return this.dFP.aJn();
    }

    public com.baidu.swan.apps.u.c.b S(Bundle bundle) {
        b.a aIR = aIR();
        aIR.D(bundle);
        return aIR;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void aIG() {
        aIZ().aKu();
        aIY().au(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void rG(String str) {
        g(str, aIV());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void g(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = aIV();
        } else {
            bundle.putAll(aIV());
        }
        super.g(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.D(aIV()));
    }

    public boolean aIS() {
        return this.dFP.aJn();
    }

    public boolean aIT() {
        return this.dFP.aJo();
    }

    public int aIU() {
        return this.dFP.aIU();
    }

    private Bundle aIV() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void F(Activity activity) {
        aIZ().F(activity);
    }

    public void g(SwanAppConfigData swanAppConfigData) {
        this.dFC = swanAppConfigData;
    }

    public SwanAppConfigData aIW() {
        return this.dFC;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.dFD = aVar;
    }

    public com.baidu.swan.games.t.a.a aIX() {
        return this.dFD;
    }

    public com.baidu.swan.apps.storage.c aIY() {
        if (this.dFE == null) {
            this.dFE = new com.baidu.swan.apps.storage.c(this);
        }
        return this.dFE;
    }

    public com.baidu.swan.apps.storage.b.c azU() {
        if (this.dFF == null) {
            if (aJg()) {
                this.dFF = new com.baidu.swan.games.i.l();
            } else {
                this.dFF = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.dFF;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a aIZ() {
        if (this.dFG == null) {
            this.dFG = new com.baidu.swan.apps.setting.a(this);
        }
        return this.dFG;
    }

    public com.baidu.swan.apps.a.b aJa() {
        if (this.dFH == null) {
            this.dFH = new com.baidu.swan.apps.a.b(this);
        }
        return this.dFH;
    }

    public synchronized com.baidu.swan.apps.network.j aJb() {
        if (this.dFI == null) {
            this.dFI = new com.baidu.swan.apps.network.j(this);
        }
        return this.dFI;
    }

    public synchronized com.baidu.swan.games.network.b aJc() {
        if (this.dFJ == null) {
            this.dFJ = com.baidu.swan.games.network.b.aXD();
        }
        return this.dFJ;
    }

    public com.baidu.swan.apps.network.k aJd() {
        if (this.dFM == null) {
            this.dFM = new com.baidu.swan.apps.network.k();
        }
        return this.dFM;
    }

    public com.baidu.swan.apps.media.audio.d aJe() {
        if (this.dFL == null) {
            this.dFL = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.dFL;
    }

    @NonNull
    public g aJf() {
        if (this.dFN == null) {
            this.dFN = new g(this);
        }
        return this.dFN;
    }

    public String getAppKey() {
        return aIR().getAppKey();
    }

    public boolean aJg() {
        return aIR().getAppFrameType() == 1;
    }

    public String getName() {
        return aIR().atf();
    }

    public String getVersion() {
        return aIR().getVersion();
    }

    public com.baidu.swan.apps.af.a.a aJh() {
        if (this.dFK == null) {
            this.dFK = new com.baidu.swan.apps.af.a.a();
        }
        return this.dFK;
    }

    public boolean rH(String str) {
        if (TextUtils.isEmpty(str) || this.dFC == null || this.dFC.dGq == null) {
            return false;
        }
        return this.dFC.dGq.sb(str);
    }

    public boolean rI(String str) {
        if (TextUtils.isEmpty(str) || this.dFC == null || this.dFC.dGr == null || this.dFC.dGr.dGS == null || !this.dFC.dGr.dGS.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.dFC.dGr.dGS.get(str).booleanValue();
    }

    public boolean rJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.bcx().ak(this.id, getVersion(), str);
    }

    public boolean rK(String str) {
        return new File(com.baidu.swan.apps.v.f.aAo().azV(), str).exists();
    }

    public void ab(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dFC != null && this.dFC.dGr != null && this.dFC.dGr.dGS != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dFC.dGr.dGS.put(str, Boolean.valueOf(z));
        }
    }

    public String ki(String str) {
        if (this.dFC == null || this.dFC.dGr == null || this.dFC.dGr.dGT == null) {
            return null;
        }
        return this.dFC.dGr.dGT.get(com.baidu.swan.apps.scheme.actions.k.j.sy(str));
    }

    public String rL(String str) {
        if (this.dFC == null || this.dFC.dGs == null || this.dFC.dGs.dGV == null) {
            return null;
        }
        return this.dFC.dGs.dGV.get(str);
    }

    public String rM(String str) {
        if (this.dFC == null) {
            return "";
        }
        return this.dFC.rM(str);
    }

    public boolean rN(String str) {
        if (TextUtils.isEmpty(str) || this.dFC == null) {
            return false;
        }
        return this.dFC.rX(str);
    }

    public boolean aJi() {
        return rN(com.baidu.swan.apps.v.f.aAo().aAt());
    }

    public String aJj() {
        b.a aIR = aIR();
        return aIR != null ? jm(aIR.getType()) : "0";
    }

    private String jm(int i) {
        if (i == 0) {
            String versionCode = this.dFQ != null ? this.dFQ.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String uo = ak.uo(versionCode);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(uo) ? " version is empty " : uo;
            com.baidu.swan.apps.console.c.d("SwanApp", objArr);
            return uo;
        }
        return "0";
    }

    public void co(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.dFO == null) {
                this.dFO = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.dFO.put(str2, str);
        }
    }

    @Nullable
    public String rO(String str) {
        if (TextUtils.isEmpty(str) || this.dFO == null) {
            return null;
        }
        return this.dFO.get(str);
    }

    public boolean available() {
        return this.dFB && this.dFP.aJp() && getFrameType() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return aIH();
    }

    public e hj(boolean z) {
        this.dFR = z;
        rG("event_first_action_launched");
        return this;
    }

    public boolean aJk() {
        return this.dFR;
    }
}
