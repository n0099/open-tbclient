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
/* loaded from: classes3.dex */
public class e extends m {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final boolean cSg;
    SwanAppConfigData cSh;
    com.baidu.swan.games.t.a.a cSi;
    private com.baidu.swan.apps.storage.c cSj;
    private com.baidu.swan.apps.storage.b.c cSk;
    private com.baidu.swan.apps.setting.a cSl;
    private com.baidu.swan.apps.a.b cSm;
    private com.baidu.swan.apps.network.j cSn;
    private com.baidu.swan.games.network.b cSo;
    private com.baidu.swan.apps.ag.a.a cSp;
    private com.baidu.swan.apps.media.audio.d cSq;
    private com.baidu.swan.apps.network.k cSr;
    private g cSs;
    private Map<String, String> cSt;
    private final k cSu;
    protected final b.a cSv;
    private boolean cSw;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.cSu = new k(this);
        this.cSv = new b.a();
        this.cSw = false;
        this.id = str == null ? "" : str;
        this.cSg = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.cSg) {
            this.cSp = new com.baidu.swan.apps.ag.a.a();
            this.cSp.qW(this.id);
        }
    }

    @Deprecated
    public static e aAr() {
        return aAs();
    }

    public static e aAs() {
        d aAn = d.aAn();
        if (aAn.ayA()) {
            return aAn.aAj();
        }
        return null;
    }

    @Deprecated
    public static String aAt() {
        return d.aAn().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean ayA() {
        return this.cSg;
    }

    public boolean acu() {
        com.baidu.swan.apps.framework.c Yz;
        if (com.baidu.swan.apps.core.prefetch.a.a.isOn()) {
            SwanAppActivity aAl = aAl();
            return aAl == null || (Yz = aAl.Yz()) == null || !Yz.anK().hasStarted();
        }
        return false;
    }

    public boolean aAu() {
        com.baidu.swan.apps.framework.c Yz;
        SwanAppActivity aAl = aAl();
        if (aAl == null || (Yz = aAl.Yz()) == null) {
            return false;
        }
        return Yz.anK().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String x(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity aAl = aAl();
        if (aAl != null && !aAl.isDestroyed() && !aAl.isFinishing() && aAl.YA()) {
            aAl.o(strArr);
        }
        com.baidu.swan.apps.v.f.release();
        if (this.cSs != null) {
            this.cSs.onDestroy();
        }
        com.baidu.swan.c.d.deleteFile(com.baidu.swan.apps.storage.b.sb(this.id));
        if (this.cSq != null) {
            this.cSq.release();
        }
        if (this.cSp != null) {
            this.cSp.release();
        }
        if (this.cSr != null) {
            this.cSr.release();
        }
        this.cSj = null;
        this.cSl = null;
        this.cSo = null;
        this.cSw = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores ayB() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(aAv().akX());
        swanAppCores.a(aAv().akY());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e aAj() {
        return this;
    }

    @NonNull
    public b.a aAv() {
        return this.cSv;
    }

    @NonNull
    @Deprecated
    public b.a YI() {
        return aAv();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int Yy() {
        if (this.cSg) {
            return aAv().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = cSy.contains(str);
        b.a aAv = aAv();
        HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
        pq.f(new UbcFlowEvent("swan_app_update_info_start").fa(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.cSu.aAT() && aAu()) {
            if (aAv.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (aAv.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        aAv.D(bundle);
        pq.f(new UbcFlowEvent("swan_app_update_info_end").fa(true));
        if (z) {
            qA("event_on_app_occupied");
        }
        if (this.cSg && !this.cSu.aAT() && !this.cSu.aAR()) {
            pq.f(new UbcFlowEvent("swan_app_maintain_start").fa(true));
            this.cSu.aAU();
            pq.f(new UbcFlowEvent("swan_app_maintain_return").fa(true));
            return true;
        }
        if (this.cSu.aAT() && contains) {
            k.a(aAv, aAv.arN(), false, false, false);
        }
        return this.cSu.aAR();
    }

    public com.baidu.swan.apps.u.c.b S(Bundle bundle) {
        b.a aAv = aAv();
        aAv.D(bundle);
        return aAv;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void aAk() {
        aAD().aBY();
        aAC().aw(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void qA(String str) {
        f(str, aAz());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = aAz();
        } else {
            bundle.putAll(aAz());
        }
        super.f(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.D(aAz()));
    }

    public boolean aAw() {
        return this.cSu.aAR();
    }

    public boolean aAx() {
        return this.cSu.aAS();
    }

    public int aAy() {
        return this.cSu.aAy();
    }

    private Bundle aAz() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void K(Activity activity) {
        aAD().K(activity);
    }

    public void g(SwanAppConfigData swanAppConfigData) {
        this.cSh = swanAppConfigData;
    }

    public SwanAppConfigData aAA() {
        return this.cSh;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.cSi = aVar;
    }

    public com.baidu.swan.games.t.a.a aAB() {
        return this.cSi;
    }

    public com.baidu.swan.apps.storage.c aAC() {
        if (this.cSj == null) {
            this.cSj = new com.baidu.swan.apps.storage.c(this);
        }
        return this.cSj;
    }

    public com.baidu.swan.apps.storage.b.c asp() {
        if (this.cSk == null) {
            if (aAK()) {
                this.cSk = new com.baidu.swan.games.i.l();
            } else {
                this.cSk = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.cSk;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a aAD() {
        if (this.cSl == null) {
            this.cSl = new com.baidu.swan.apps.setting.a(this);
        }
        return this.cSl;
    }

    public com.baidu.swan.apps.a.b aAE() {
        if (this.cSm == null) {
            this.cSm = new com.baidu.swan.apps.a.b(this);
        }
        return this.cSm;
    }

    public synchronized com.baidu.swan.apps.network.j aAF() {
        if (this.cSn == null) {
            this.cSn = new com.baidu.swan.apps.network.j(this);
        }
        return this.cSn;
    }

    public synchronized com.baidu.swan.games.network.b aAG() {
        if (this.cSo == null) {
            this.cSo = com.baidu.swan.games.network.b.aPn();
        }
        return this.cSo;
    }

    public com.baidu.swan.apps.network.k aAH() {
        if (this.cSr == null) {
            this.cSr = new com.baidu.swan.apps.network.k();
        }
        return this.cSr;
    }

    public com.baidu.swan.apps.media.audio.d aAI() {
        if (this.cSq == null) {
            this.cSq = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.cSq;
    }

    @NonNull
    public g aAJ() {
        if (this.cSs == null) {
            this.cSs = new g(this);
        }
        return this.cSs;
    }

    public String getAppKey() {
        return aAv().getAppKey();
    }

    public boolean aAK() {
        return aAv().getAppFrameType() == 1;
    }

    public String getName() {
        return aAv().aly();
    }

    public String getVersion() {
        return aAv().getVersion();
    }

    public com.baidu.swan.apps.ag.a.a aAL() {
        if (this.cSp == null) {
            this.cSp = new com.baidu.swan.apps.ag.a.a();
        }
        return this.cSp;
    }

    public boolean qB(String str) {
        if (TextUtils.isEmpty(str) || this.cSh == null || this.cSh.cSV == null) {
            return false;
        }
        return this.cSh.cSV.qU(str);
    }

    public boolean qC(String str) {
        if (TextUtils.isEmpty(str) || this.cSh == null || this.cSh.cSW == null || this.cSh.cSW.cTx == null || !this.cSh.cSW.cTx.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.cSh.cSW.cTx.get(str).booleanValue();
    }

    public boolean qD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.aUf().W(this.id, getVersion(), str);
    }

    public boolean qE(String str) {
        return new File(com.baidu.swan.apps.v.f.asJ().asq(), str).exists();
    }

    public void V(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.cSh != null && this.cSh.cSW != null && this.cSh.cSW.cTx != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.cSh.cSW.cTx.put(str, Boolean.valueOf(z));
        }
    }

    public String jg(String str) {
        if (this.cSh == null || this.cSh.cSW == null || this.cSh.cSW.cTy == null) {
            return null;
        }
        return this.cSh.cSW.cTy.get(com.baidu.swan.apps.scheme.actions.k.j.rq(str));
    }

    public String qF(String str) {
        if (this.cSh == null || this.cSh.cSX == null || this.cSh.cSX.cTA == null) {
            return null;
        }
        return this.cSh.cSX.cTA.get(str);
    }

    public String qG(String str) {
        if (this.cSh == null) {
            return "";
        }
        return this.cSh.qG(str);
    }

    public boolean qH(String str) {
        if (TextUtils.isEmpty(str) || this.cSh == null) {
            return false;
        }
        return this.cSh.qQ(str);
    }

    public boolean aAM() {
        return qH(com.baidu.swan.apps.v.f.asJ().asO());
    }

    public String aAN() {
        b.a aAv = aAv();
        return aAv != null ? jw(aAv.getType()) : "0";
    }

    private String jw(int i) {
        if (i == 0) {
            String versionCode = this.cSv != null ? this.cSv.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String tf = ak.tf(versionCode);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(tf) ? " version is empty " : tf;
            com.baidu.swan.apps.console.c.d("SwanApp", objArr);
            return tf;
        }
        return "0";
    }

    public void ce(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.cSt == null) {
                this.cSt = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.cSt.put(str2, str);
        }
    }

    @Nullable
    public String qI(String str) {
        if (TextUtils.isEmpty(str) || this.cSt == null) {
            return null;
        }
        return this.cSt.get(str);
    }

    public boolean available() {
        return this.cSg && this.cSu.aAT() && Yy() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return aAl();
    }

    public e fJ(boolean z) {
        this.cSw = z;
        qA("event_first_action_launched");
        return this;
    }

    public boolean aAO() {
        return this.cSw;
    }
}
