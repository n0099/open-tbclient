package com.baidu.swan.apps.runtime;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.u.c.b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class e extends m {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final boolean cHd;
    SwanAppConfigData cHe;
    com.baidu.swan.games.t.a.a cHf;
    private com.baidu.swan.apps.storage.c cHg;
    private com.baidu.swan.apps.storage.b.c cHh;
    private com.baidu.swan.apps.setting.a cHi;
    private com.baidu.swan.apps.a.b cHj;
    private com.baidu.swan.apps.network.j cHk;
    private com.baidu.swan.games.network.b cHl;
    private com.baidu.swan.apps.ah.a.a cHm;
    private com.baidu.swan.apps.media.audio.d cHn;
    private com.baidu.swan.apps.network.k cHo;
    private g cHp;
    private Map<String, String> cHq;
    private final k cHr;
    protected final b.a cHs;
    private boolean cHt;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.cHr = new k(this);
        this.cHs = new b.a();
        this.cHt = false;
        this.id = str == null ? "" : str;
        this.cHd = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.cHd) {
            this.cHm = new com.baidu.swan.apps.ah.a.a();
            this.cHm.oF(this.id);
        }
    }

    @Deprecated
    public static e arv() {
        return arw();
    }

    public static e arw() {
        d arr = d.arr();
        if (arr.apU()) {
            return arr.arn();
        }
        return null;
    }

    @Deprecated
    public static String arx() {
        return d.arr().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean apU() {
        return this.cHd;
    }

    public boolean VF() {
        com.baidu.swan.apps.framework.c RV;
        if (com.baidu.swan.apps.core.prefetch.a.a.acD() == 0) {
            return false;
        }
        SwanAppActivity arp = arp();
        return arp == null || (RV = arp.RV()) == null || !RV.afT().hasStarted();
    }

    public boolean ary() {
        com.baidu.swan.apps.framework.c RV;
        SwanAppActivity arp = arp();
        if (arp == null || (RV = arp.RV()) == null) {
            return false;
        }
        return RV.afT().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String w(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity arp = arp();
        if (arp != null && !arp.isDestroyed() && !arp.isFinishing() && arp.RW()) {
            arp.o(strArr);
        }
        com.baidu.swan.apps.v.f.release();
        if (this.cHp != null) {
            this.cHp.onDestroy();
        }
        com.baidu.swan.d.d.deleteFile(com.baidu.swan.apps.storage.b.pH(this.id));
        if (this.cHn != null) {
            this.cHn.release();
        }
        if (this.cHm != null) {
            this.cHm.release();
        }
        if (this.cHo != null) {
            this.cHo.release();
        }
        this.cHg = null;
        this.cHi = null;
        this.cHl = null;
        this.cHt = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores apV() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(arz().adQ());
        swanAppCores.a(arz().adR());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e arn() {
        return this;
    }

    @NonNull
    public b.a arz() {
        return this.cHs;
    }

    @NonNull
    @Deprecated
    public b.a Se() {
        return arz();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int RU() {
        if (this.cHd) {
            return arz().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = cHv.contains(str);
        b.a arz = arz();
        HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
        mX.f(new UbcFlowEvent("swan_app_update_info_start").eI(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.cHr.arX() && ary()) {
            if (arz.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (arz.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        arz.F(bundle);
        mX.f(new UbcFlowEvent("swan_app_update_info_end").eI(true));
        if (z) {
            oi("event_on_app_occupied");
        }
        if (this.cHd && !this.cHr.arX() && !this.cHr.arV()) {
            mX.f(new UbcFlowEvent("swan_app_maintain_start").eI(true));
            this.cHr.arY();
            mX.f(new UbcFlowEvent("swan_app_maintain_return").eI(true));
            return true;
        }
        if (this.cHr.arX() && contains) {
            k.a(arz, arz.ajw(), false, false, false);
        }
        return this.cHr.arV();
    }

    public com.baidu.swan.apps.u.c.b U(Bundle bundle) {
        b.a arz = arz();
        arz.F(bundle);
        return arz;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void aro() {
        arH().atg();
        arG().av(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void oi(String str) {
        g(str, arD());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void g(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = arD();
        } else {
            bundle.putAll(arD());
        }
        super.g(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.F(arD()));
    }

    public boolean arA() {
        return this.cHr.arV();
    }

    public boolean arB() {
        return this.cHr.arW();
    }

    public int arC() {
        return this.cHr.arC();
    }

    private Bundle arD() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void onActivityResume(Activity activity) {
        arH().onActivityResume(activity);
    }

    public void f(SwanAppConfigData swanAppConfigData) {
        this.cHe = swanAppConfigData;
    }

    public SwanAppConfigData arE() {
        return this.cHe;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.cHf = aVar;
    }

    public com.baidu.swan.games.t.a.a arF() {
        return this.cHf;
    }

    public com.baidu.swan.apps.storage.c arG() {
        if (this.cHg == null) {
            this.cHg = new com.baidu.swan.apps.storage.c(this);
        }
        return this.cHg;
    }

    public com.baidu.swan.apps.storage.b.c ajX() {
        if (this.cHh == null) {
            if (arO()) {
                this.cHh = new com.baidu.swan.games.i.l();
            } else {
                this.cHh = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.cHh;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a arH() {
        if (this.cHi == null) {
            this.cHi = new com.baidu.swan.apps.setting.a(this);
        }
        return this.cHi;
    }

    public com.baidu.swan.apps.a.b arI() {
        if (this.cHj == null) {
            this.cHj = new com.baidu.swan.apps.a.b(this);
        }
        return this.cHj;
    }

    public synchronized com.baidu.swan.apps.network.j arJ() {
        if (this.cHk == null) {
            this.cHk = new com.baidu.swan.apps.network.j(this);
        }
        return this.cHk;
    }

    public synchronized com.baidu.swan.games.network.b arK() {
        if (this.cHl == null) {
            this.cHl = com.baidu.swan.games.network.b.aFL();
        }
        return this.cHl;
    }

    public com.baidu.swan.apps.network.k arL() {
        if (this.cHo == null) {
            this.cHo = new com.baidu.swan.apps.network.k();
        }
        return this.cHo;
    }

    public com.baidu.swan.apps.media.audio.d arM() {
        if (this.cHn == null) {
            this.cHn = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.cHn;
    }

    @NonNull
    public g arN() {
        if (this.cHp == null) {
            this.cHp = new g(this);
        }
        return this.cHp;
    }

    public String getAppKey() {
        return arz().getAppKey();
    }

    public boolean arO() {
        return arz().getAppFrameType() == 1;
    }

    public String getName() {
        return arz().aee();
    }

    public String getVersion() {
        return arz().getVersion();
    }

    public com.baidu.swan.apps.ah.a.a arP() {
        if (this.cHm == null) {
            this.cHm = new com.baidu.swan.apps.ah.a.a();
        }
        return this.cHm;
    }

    public boolean oj(String str) {
        if (TextUtils.isEmpty(str) || this.cHe == null || this.cHe.cHS == null) {
            return false;
        }
        return this.cHe.cHS.oD(str);
    }

    public boolean ok(String str) {
        if (TextUtils.isEmpty(str) || this.cHe == null || this.cHe.cHT == null || this.cHe.cHT.cIu == null || !this.cHe.cHT.cIu.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.cHe.cHT.cIu.get(str).booleanValue();
    }

    public boolean ol(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.aKS().W(this.id, getVersion(), str);
    }

    public boolean om(String str) {
        return new File(com.baidu.swan.apps.v.f.akr().ajY(), str).exists();
    }

    public void Q(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.cHe != null && this.cHe.cHT != null && this.cHe.cHT.cIu != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.cHe.cHT.cIu.put(str, Boolean.valueOf(z));
        }
    }

    public String hq(String str) {
        if (this.cHe == null || this.cHe.cHT == null || this.cHe.cHT.cIv == null) {
            return null;
        }
        return this.cHe.cHT.cIv.get(com.baidu.swan.apps.scheme.actions.k.j.oZ(str));
    }

    public String oo(String str) {
        if (this.cHe == null || this.cHe.cHU == null || this.cHe.cHU.cIx == null) {
            return null;
        }
        return this.cHe.cHU.cIx.get(str);
    }

    public String op(String str) {
        if (this.cHe == null) {
            return "";
        }
        return this.cHe.op(str);
    }

    public boolean oq(String str) {
        if (TextUtils.isEmpty(str) || this.cHe == null) {
            return false;
        }
        return this.cHe.oz(str);
    }

    public boolean arQ() {
        return oq(com.baidu.swan.apps.v.f.akr().akw());
    }

    public String arR() {
        b.a arz = arz();
        return arz != null ? he(arz.getType()) : "0";
    }

    private String he(int i) {
        if (i == 0) {
            String versionCode = this.cHs != null ? this.cHs.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String qJ = al.qJ(versionCode);
            com.baidu.swan.apps.console.c.d("SwanApp", TextUtils.isEmpty(qJ) ? " version is empty " : qJ);
            return qJ;
        }
        return "0";
    }

    public void bO(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.cHq == null) {
                this.cHq = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.cHq.put(str2, str);
        }
    }

    @Nullable
    public String or(String str) {
        if (TextUtils.isEmpty(str) || this.cHq == null) {
            return null;
        }
        return this.cHq.get(str);
    }

    public boolean available() {
        return this.cHd && this.cHr.arX() && RU() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return arp();
    }

    public e fr(boolean z) {
        this.cHt = z;
        oi("event_first_action_launched");
        return this;
    }

    public boolean arS() {
        return this.cHt;
    }
}
