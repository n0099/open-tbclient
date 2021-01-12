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
    public final boolean dBW;
    SwanAppConfigData dBX;
    com.baidu.swan.games.t.a.a dBY;
    private com.baidu.swan.apps.storage.c dBZ;
    private com.baidu.swan.apps.storage.b.c dCa;
    private com.baidu.swan.apps.setting.a dCb;
    private com.baidu.swan.apps.a.b dCc;
    private com.baidu.swan.apps.network.j dCd;
    private com.baidu.swan.games.network.b dCe;
    private com.baidu.swan.apps.af.a.a dCf;
    private com.baidu.swan.apps.media.audio.d dCg;
    private com.baidu.swan.apps.network.k dCh;
    private g dCi;
    private Map<String, String> dCj;
    private final k dCk;
    protected final b.a dCl;
    private boolean dCm;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.dCk = new k(this);
        this.dCl = new b.a();
        this.dCm = false;
        this.id = str == null ? "" : str;
        this.dBW = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.dBW) {
            this.dCf = new com.baidu.swan.apps.af.a.a();
            this.dCf.rD(this.id);
        }
    }

    @Deprecated
    public static e aIr() {
        return aIs();
    }

    public static e aIs() {
        d aIn = d.aIn();
        if (aIn.aFD()) {
            return aIn.aIj();
        }
        return null;
    }

    @Deprecated
    public static String aIt() {
        return d.aIn().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean aFD() {
        return this.dBW;
    }

    public boolean ajr() {
        com.baidu.swan.apps.framework.c afs;
        if (com.baidu.swan.apps.core.prefetch.a.a.isOn()) {
            SwanAppActivity aIl = aIl();
            return aIl == null || (afs = aIl.afs()) == null || !afs.auP().hasStarted();
        }
        return false;
    }

    public boolean aIu() {
        com.baidu.swan.apps.framework.c afs;
        SwanAppActivity aIl = aIl();
        if (aIl == null || (afs = aIl.afs()) == null) {
            return false;
        }
        return afs.auP().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String G(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity aIl = aIl();
        if (aIl != null && !aIl.isDestroyed() && !aIl.isFinishing() && aIl.aft()) {
            aIl.x(strArr);
        }
        com.baidu.swan.apps.v.f.release();
        if (this.dCi != null) {
            this.dCi.onDestroy();
        }
        com.baidu.swan.c.d.deleteFile(com.baidu.swan.apps.storage.b.sJ(this.id));
        if (this.dCg != null) {
            this.dCg.release();
        }
        if (this.dCf != null) {
            this.dCf.release();
        }
        if (this.dCh != null) {
            this.dCh.release();
        }
        this.dBZ = null;
        this.dCb = null;
        this.dCe = null;
        this.dCm = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores aFE() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(aIv().asb());
        swanAppCores.a(aIv().asc());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e aIj() {
        return this;
    }

    @NonNull
    public b.a aIv() {
        return this.dCl;
    }

    @NonNull
    @Deprecated
    public b.a afB() {
        return aIv();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int afr() {
        if (this.dBW) {
            return aIv().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = dCo.contains(str);
        b.a aIv = aIv();
        HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
        pS.f(new UbcFlowEvent("swan_app_update_info_start").gp(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.dCk.aIT() && aIu()) {
            if (aIv.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (aIv.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        aIv.D(bundle);
        pS.f(new UbcFlowEvent("swan_app_update_info_end").gp(true));
        if (z) {
            rg("event_on_app_occupied");
        }
        if (this.dBW && !this.dCk.aIT() && !this.dCk.aIR()) {
            pS.f(new UbcFlowEvent("swan_app_maintain_start").gp(true));
            this.dCk.aIU();
            pS.f(new UbcFlowEvent("swan_app_maintain_return").gp(true));
            return true;
        }
        if (this.dCk.aIT() && contains) {
            k.a(aIv, aIv.ayS(), false, false, false);
        }
        return this.dCk.aIR();
    }

    public com.baidu.swan.apps.u.c.b S(Bundle bundle) {
        b.a aIv = aIv();
        aIv.D(bundle);
        return aIv;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void aIk() {
        aID().aJY();
        aIC().au(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void rg(String str) {
        g(str, aIz());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void g(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = aIz();
        } else {
            bundle.putAll(aIz());
        }
        super.g(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.D(aIz()));
    }

    public boolean aIw() {
        return this.dCk.aIR();
    }

    public boolean aIx() {
        return this.dCk.aIS();
    }

    public int aIy() {
        return this.dCk.aIy();
    }

    private Bundle aIz() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void L(Activity activity) {
        aID().L(activity);
    }

    public void g(SwanAppConfigData swanAppConfigData) {
        this.dBX = swanAppConfigData;
    }

    public SwanAppConfigData aIA() {
        return this.dBX;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.dBY = aVar;
    }

    public com.baidu.swan.games.t.a.a aIB() {
        return this.dBY;
    }

    public com.baidu.swan.apps.storage.c aIC() {
        if (this.dBZ == null) {
            this.dBZ = new com.baidu.swan.apps.storage.c(this);
        }
        return this.dBZ;
    }

    public com.baidu.swan.apps.storage.b.c azt() {
        if (this.dCa == null) {
            if (aIK()) {
                this.dCa = new com.baidu.swan.games.i.l();
            } else {
                this.dCa = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.dCa;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a aID() {
        if (this.dCb == null) {
            this.dCb = new com.baidu.swan.apps.setting.a(this);
        }
        return this.dCb;
    }

    public com.baidu.swan.apps.a.b aIE() {
        if (this.dCc == null) {
            this.dCc = new com.baidu.swan.apps.a.b(this);
        }
        return this.dCc;
    }

    public synchronized com.baidu.swan.apps.network.j aIF() {
        if (this.dCd == null) {
            this.dCd = new com.baidu.swan.apps.network.j(this);
        }
        return this.dCd;
    }

    public synchronized com.baidu.swan.games.network.b aIG() {
        if (this.dCe == null) {
            this.dCe = com.baidu.swan.games.network.b.aXo();
        }
        return this.dCe;
    }

    public com.baidu.swan.apps.network.k aIH() {
        if (this.dCh == null) {
            this.dCh = new com.baidu.swan.apps.network.k();
        }
        return this.dCh;
    }

    public com.baidu.swan.apps.media.audio.d aII() {
        if (this.dCg == null) {
            this.dCg = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.dCg;
    }

    @NonNull
    public g aIJ() {
        if (this.dCi == null) {
            this.dCi = new g(this);
        }
        return this.dCi;
    }

    public String getAppKey() {
        return aIv().getAppKey();
    }

    public boolean aIK() {
        return aIv().getAppFrameType() == 1;
    }

    public String getName() {
        return aIv().asE();
    }

    public String getVersion() {
        return aIv().getVersion();
    }

    public com.baidu.swan.apps.af.a.a aIL() {
        if (this.dCf == null) {
            this.dCf = new com.baidu.swan.apps.af.a.a();
        }
        return this.dCf;
    }

    public boolean rh(String str) {
        if (TextUtils.isEmpty(str) || this.dBX == null || this.dBX.dCL == null) {
            return false;
        }
        return this.dBX.dCL.rB(str);
    }

    public boolean ri(String str) {
        if (TextUtils.isEmpty(str) || this.dBX == null || this.dBX.dCM == null || this.dBX.dCM.dDn == null || !this.dBX.dCM.dDn.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.dBX.dCM.dDn.get(str).booleanValue();
    }

    public boolean rj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.bci().aj(this.id, getVersion(), str);
    }

    public boolean rk(String str) {
        return new File(com.baidu.swan.apps.v.f.azN().azu(), str).exists();
    }

    public void ac(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dBX != null && this.dBX.dCM != null && this.dBX.dCM.dDn != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dBX.dCM.dDn.put(str, Boolean.valueOf(z));
        }
    }

    public String jJ(String str) {
        if (this.dBX == null || this.dBX.dCM == null || this.dBX.dCM.dDo == null) {
            return null;
        }
        return this.dBX.dCM.dDo.get(com.baidu.swan.apps.scheme.actions.k.j.rX(str));
    }

    public String rl(String str) {
        if (this.dBX == null || this.dBX.dCN == null || this.dBX.dCN.dDq == null) {
            return null;
        }
        return this.dBX.dCN.dDq.get(str);
    }

    public String rm(String str) {
        if (this.dBX == null) {
            return "";
        }
        return this.dBX.rm(str);
    }

    public boolean rn(String str) {
        if (TextUtils.isEmpty(str) || this.dBX == null) {
            return false;
        }
        return this.dBX.rx(str);
    }

    public boolean aIM() {
        return rn(com.baidu.swan.apps.v.f.azN().azS());
    }

    public String aIN() {
        b.a aIv = aIv();
        return aIv != null ? ji(aIv.getType()) : "0";
    }

    private String ji(int i) {
        if (i == 0) {
            String versionCode = this.dCl != null ? this.dCl.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String tO = ak.tO(versionCode);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(tO) ? " version is empty " : tO;
            com.baidu.swan.apps.console.c.d("SwanApp", objArr);
            return tO;
        }
        return "0";
    }

    public void cu(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.dCj == null) {
                this.dCj = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.dCj.put(str2, str);
        }
    }

    @Nullable
    public String ro(String str) {
        if (TextUtils.isEmpty(str) || this.dCj == null) {
            return null;
        }
        return this.dCj.get(str);
    }

    public boolean available() {
        return this.dBW && this.dCk.aIT() && afr() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return aIl();
    }

    public e hh(boolean z) {
        this.dCm = z;
        rg("event_first_action_launched");
        return this;
    }

    public boolean aIO() {
        return this.dCm;
    }
}
