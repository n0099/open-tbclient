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
    public final boolean czG;
    SwanAppConfigData czH;
    com.baidu.swan.games.t.a.a czI;
    private com.baidu.swan.apps.storage.c czJ;
    private com.baidu.swan.apps.storage.b.c czK;
    private com.baidu.swan.apps.setting.a czL;
    private com.baidu.swan.apps.a.b czM;
    private com.baidu.swan.apps.network.j czN;
    private com.baidu.swan.games.network.b czO;
    private com.baidu.swan.apps.ah.a.a czP;
    private com.baidu.swan.apps.media.audio.d czQ;
    private com.baidu.swan.apps.network.k czR;
    private g czS;
    private Map<String, String> czT;
    private final k czU;
    protected final b.a czV;
    private boolean czW;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.czU = new k(this);
        this.czV = new b.a();
        this.czW = false;
        this.id = str == null ? "" : str;
        this.czG = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.czG) {
            this.czP = new com.baidu.swan.apps.ah.a.a();
            this.czP.nP(this.id);
        }
    }

    @Deprecated
    public static e aoF() {
        return aoG();
    }

    public static e aoG() {
        d aoB = d.aoB();
        if (aoB.ane()) {
            return aoB.aox();
        }
        return null;
    }

    @Deprecated
    public static String aoH() {
        return d.aoB().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public boolean ane() {
        return this.czG;
    }

    public boolean TU() {
        com.baidu.swan.apps.framework.c QA;
        if (com.baidu.swan.apps.core.prefetch.a.a.aav() == 0) {
            return false;
        }
        SwanAppActivity aoz = aoz();
        return aoz == null || (QA = aoz.QA()) == null || !QA.adB().hasStarted();
    }

    public boolean aoI() {
        com.baidu.swan.apps.framework.c QA;
        SwanAppActivity aoz = aoz();
        if (aoz == null || (QA = aoz.QA()) == null) {
            return false;
        }
        return QA.adB().hasCreated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String x(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity aoz = aoz();
        if (aoz != null && !aoz.isDestroyed() && !aoz.isFinishing() && aoz.QB()) {
            aoz.p(strArr);
        }
        com.baidu.swan.apps.w.f.release();
        if (this.czS != null) {
            this.czS.onDestroy();
        }
        com.baidu.swan.e.d.deleteFile(com.baidu.swan.apps.storage.b.oO(this.id));
        if (this.czQ != null) {
            this.czQ.release();
        }
        if (this.czP != null) {
            this.czP.release();
        }
        if (this.czR != null) {
            this.czR.release();
        }
        this.czJ = null;
        this.czL = null;
        this.czO = null;
        this.czW = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public SwanAppCores anf() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(aoJ().abG());
        swanAppCores.a(aoJ().abH());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public e aox() {
        return this;
    }

    @NonNull
    public b.a aoJ() {
        return this.czV;
    }

    @NonNull
    @Deprecated
    public b.a QJ() {
        return aoJ();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int Qz() {
        if (this.czG) {
            return aoJ().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = czY.contains(str);
        b.a aoJ = aoJ();
        HybridUbcFlow mp = com.baidu.swan.apps.performance.g.mp("startup");
        mp.f(new UbcFlowEvent("swan_app_update_info_start").eu(true));
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.czU.apj() && aoI()) {
            if (aoJ.containsKey("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (aoJ.containsKey("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        aoJ.E(bundle);
        mp.f(new UbcFlowEvent("swan_app_update_info_end").eu(true));
        if (z) {
            ns("event_on_app_occupied");
        }
        if (this.czG && !this.czU.apj() && !this.czU.apg()) {
            mp.f(new UbcFlowEvent("swan_app_maintain_start").eu(true));
            this.czU.apk();
            mp.f(new UbcFlowEvent("swan_app_maintain_return").eu(true));
            return true;
        }
        if (this.czU.apj() && contains) {
            k.a(aoJ, aoJ.aha(), false, false, false);
        }
        return this.czU.apg();
    }

    public com.baidu.swan.apps.v.b.b T(Bundle bundle) {
        b.a aoJ = aoJ();
        aoJ.E(bundle);
        return aoJ;
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void aoy() {
        aoR().aqi();
        aoQ().au(true);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void ns(String str) {
        g(str, aoN());
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void g(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = aoN();
        } else {
            bundle.putAll(aoN());
        }
        super.g(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public void i(i.a aVar) {
        super.i((i.a) aVar.E(aoN()));
    }

    public boolean aoK() {
        return this.czU.apg();
    }

    public boolean aoL() {
        return this.czU.aph();
    }

    public int aoM() {
        return this.czU.aoM();
    }

    private Bundle aoN() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void onActivityResume(Activity activity) {
        aoR().onActivityResume(activity);
    }

    public void f(SwanAppConfigData swanAppConfigData) {
        this.czH = swanAppConfigData;
    }

    public SwanAppConfigData aoO() {
        return this.czH;
    }

    public void a(com.baidu.swan.games.t.a.a aVar) {
        this.czI = aVar;
    }

    public com.baidu.swan.games.t.a.a aoP() {
        return this.czI;
    }

    public com.baidu.swan.apps.storage.c aoQ() {
        if (this.czJ == null) {
            this.czJ = new com.baidu.swan.apps.storage.c(this);
        }
        return this.czJ;
    }

    public com.baidu.swan.apps.storage.b.c ahB() {
        if (this.czK == null) {
            if (aoY()) {
                this.czK = new com.baidu.swan.games.i.l();
            } else {
                this.czK = new com.baidu.swan.apps.storage.b.e();
            }
        }
        return this.czK;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a aoR() {
        if (this.czL == null) {
            this.czL = new com.baidu.swan.apps.setting.a(this);
        }
        return this.czL;
    }

    public com.baidu.swan.apps.a.b aoS() {
        if (this.czM == null) {
            this.czM = new com.baidu.swan.apps.a.b(this);
        }
        return this.czM;
    }

    public synchronized com.baidu.swan.apps.network.j aoT() {
        if (this.czN == null) {
            this.czN = new com.baidu.swan.apps.network.j(this);
        }
        return this.czN;
    }

    public synchronized com.baidu.swan.games.network.b aoU() {
        if (this.czO == null) {
            this.czO = com.baidu.swan.games.network.b.aAY();
        }
        return this.czO;
    }

    public com.baidu.swan.apps.network.k aoV() {
        if (this.czR == null) {
            this.czR = new com.baidu.swan.apps.network.k();
        }
        return this.czR;
    }

    public com.baidu.swan.apps.media.audio.d aoW() {
        if (this.czQ == null) {
            this.czQ = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.czQ;
    }

    @NonNull
    public g aoX() {
        if (this.czS == null) {
            this.czS = new g(this);
        }
        return this.czS;
    }

    public String getAppKey() {
        return aoJ().getAppKey();
    }

    public boolean aoY() {
        return aoJ().getAppFrameType() == 1;
    }

    public String getName() {
        return aoJ().abT();
    }

    public String getVersion() {
        return aoJ().getVersion();
    }

    public com.baidu.swan.apps.ah.a.a aoZ() {
        if (this.czP == null) {
            this.czP = new com.baidu.swan.apps.ah.a.a();
        }
        return this.czP;
    }

    public boolean nt(String str) {
        if (TextUtils.isEmpty(str) || this.czH == null || this.czH.cAs == null) {
            return false;
        }
        return this.czH.cAs.nN(str);
    }

    public boolean nu(String str) {
        if (TextUtils.isEmpty(str) || this.czH == null || this.czH.cAt == null || this.czH.cAt.cAS == null || !this.czH.cAt.cAS.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.czH.cAt.cAS.get(str).booleanValue();
    }

    public boolean nv(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.aFV().V(this.id, getVersion(), str);
    }

    public boolean nw(String str) {
        return new File(com.baidu.swan.apps.w.f.ahV().ahC(), str).exists();
    }

    public void P(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.czH != null && this.czH.cAt != null && this.czH.cAt.cAS != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.czH.cAt.cAS.put(str, Boolean.valueOf(z));
        }
    }

    public String nx(String str) {
        if (this.czH == null || this.czH.cAt == null || this.czH.cAt.cAT == null) {
            return null;
        }
        return this.czH.cAt.cAT.get(com.baidu.swan.apps.scheme.actions.k.j.oh(str));
    }

    public String ny(String str) {
        if (this.czH == null || this.czH.cAu == null || this.czH.cAu.cAV == null) {
            return null;
        }
        return this.czH.cAu.cAV.get(str);
    }

    public String nz(String str) {
        if (this.czH == null) {
            return "";
        }
        return this.czH.nz(str);
    }

    public boolean nA(String str) {
        if (TextUtils.isEmpty(str) || this.czH == null) {
            return false;
        }
        return this.czH.nJ(str);
    }

    public boolean apa() {
        return nA(com.baidu.swan.apps.w.f.ahV().aia());
    }

    public String apb() {
        b.a aoJ = aoJ();
        return aoJ != null ? gI(aoJ.getType()) : "0";
    }

    private String gI(int i) {
        if (i == 0) {
            String versionCode = this.czV != null ? this.czV.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String pP = aj.pP(versionCode);
            com.baidu.swan.apps.console.c.e("SwanApp", TextUtils.isEmpty(pP) ? " version is empty " : pP);
            return pP;
        }
        return "0";
    }

    public void bK(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.czT == null) {
                this.czT = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.czT.put(str2, str);
        }
    }

    @Nullable
    public String nB(String str) {
        if (TextUtils.isEmpty(str) || this.czT == null) {
            return null;
        }
        return this.czT.get(str);
    }

    public boolean available() {
        return this.czG && this.czU.apj() && Qz() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return aoz();
    }

    public e fd(boolean z) {
        this.czW = z;
        ns("event_first_action_launched");
        return this;
    }

    public boolean apc() {
        return this.czW;
    }
}
