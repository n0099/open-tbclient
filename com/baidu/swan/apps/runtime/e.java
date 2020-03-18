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
/* loaded from: classes11.dex */
public class e extends l {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final boolean bPh;
    SwanAppConfigData bPi;
    com.baidu.swan.games.s.a.a bPj;
    private com.baidu.swan.apps.storage.c bPk;
    private com.baidu.swan.apps.storage.b.c bPl;
    private com.baidu.swan.apps.setting.a bPm;
    private com.baidu.swan.apps.a.b bPn;
    private com.baidu.swan.apps.network.j bPo;
    private com.baidu.swan.games.network.b bPp;
    private com.baidu.swan.apps.aj.a.a bPq;
    private com.baidu.swan.apps.media.audio.d bPr;
    private com.baidu.swan.apps.network.k bPs;
    private g bPt;
    private Map<String, String> bPu;
    private final k bPv;
    protected final b.a bPw;
    private boolean bPx;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.bPv = new k(this);
        this.bPw = new b.a();
        this.bPx = false;
        this.id = str == null ? "" : str;
        this.bPh = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.bPh) {
            this.bPq = new com.baidu.swan.apps.aj.a.a();
            this.bPq.lf(this.id);
        }
    }

    @Deprecated
    public static e acI() {
        return acJ();
    }

    public static e acJ() {
        d acF = d.acF();
        if (acF.abm()) {
            return acF.acC();
        }
        return null;
    }

    @Deprecated
    public static String acK() {
        return d.acF().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean abm() {
        return this.bPh;
    }

    public boolean JI() {
        com.baidu.swan.apps.framework.c GA;
        if (com.baidu.swan.apps.core.prefetch.a.a.PS() == 0) {
            return false;
        }
        SwanAppActivity acE = acE();
        return acE == null || (GA = acE.GA()) == null || !GA.SM().hasStarted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String w(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity acE = acE();
        if (acE != null && !acE.isDestroyed() && !acE.isFinishing() && acE.GB()) {
            acE.q(strArr);
        }
        com.baidu.swan.apps.y.f.release();
        if (this.bPt != null) {
            this.bPt.onDestroy();
        }
        com.baidu.swan.d.c.deleteFile(com.baidu.swan.apps.storage.b.lX(this.id));
        if (this.bPr != null) {
            this.bPr.release();
        }
        if (this.bPq != null) {
            this.bPq.release();
        }
        if (this.bPs != null) {
            this.bPs.release();
        }
        this.bPk = null;
        this.bPm = null;
        this.bPp = null;
        this.bPx = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores abn() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(acL().QT());
        swanAppCores.a(acL().QU());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public e acC() {
        return this;
    }

    @NonNull
    public b.a acL() {
        return this.bPw;
    }

    @NonNull
    @Deprecated
    public b.a GJ() {
        return acL();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Gz() {
        if (this.bPh) {
            return acL().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = bPz.contains(str);
        b.a acL = acL();
        HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
        jO.f(new UbcFlowEvent("swan_app_update_info_start").dh(true));
        acL.B(bundle);
        jO.f(new UbcFlowEvent("swan_app_update_info_end").dh(true));
        if (z) {
            kK("event_on_app_occupied");
        }
        if (this.bPh && !this.bPv.adi() && !this.bPv.adh()) {
            jO.f(new UbcFlowEvent("swan_app_maintain_start").dh(true));
            this.bPv.adj();
            jO.f(new UbcFlowEvent("swan_app_maintain_return").dh(true));
            return true;
        }
        if (this.bPv.adi() && contains) {
            k.a(acL, acL.Wc(), false, false);
        }
        return this.bPv.adh();
    }

    public com.baidu.swan.apps.x.b.b N(Bundle bundle) {
        b.a acL = acL();
        acL.B(bundle);
        return acL;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void acD() {
        acS().aeb();
        acQ().T(true);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void kK(String str) {
        d(str, acN());
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = acN();
        } else {
            bundle.putAll(acN());
        }
        super.d(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(i.a aVar) {
        super.d((i.a) aVar.B(acN()));
    }

    public boolean acM() {
        return this.bPv.adh();
    }

    private Bundle acN() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void onActivityResume(Activity activity) {
        acS().onActivityResume(activity);
    }

    public void c(SwanAppConfigData swanAppConfigData) {
        this.bPi = swanAppConfigData;
    }

    public SwanAppConfigData acO() {
        return this.bPi;
    }

    public void a(com.baidu.swan.games.s.a.a aVar) {
        this.bPj = aVar;
    }

    public com.baidu.swan.games.s.a.a acP() {
        return this.bPj;
    }

    public com.baidu.swan.apps.storage.c acQ() {
        if (this.bPk == null) {
            this.bPk = new com.baidu.swan.apps.storage.c(this);
        }
        return this.bPk;
    }

    public com.baidu.swan.apps.storage.b.c acR() {
        if (this.bPl == null) {
            if (acZ()) {
                this.bPl = new com.baidu.swan.games.h.k();
            } else {
                this.bPl = new com.baidu.swan.apps.storage.b.b();
            }
        }
        return this.bPl;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a acS() {
        if (this.bPm == null) {
            this.bPm = new com.baidu.swan.apps.setting.a(this);
        }
        return this.bPm;
    }

    public com.baidu.swan.apps.a.b acT() {
        if (this.bPn == null) {
            this.bPn = new com.baidu.swan.apps.a.b(this);
        }
        return this.bPn;
    }

    public synchronized com.baidu.swan.apps.network.j acU() {
        if (this.bPo == null) {
            this.bPo = new com.baidu.swan.apps.network.j(this);
        }
        return this.bPo;
    }

    public synchronized com.baidu.swan.games.network.b acV() {
        if (this.bPp == null) {
            this.bPp = com.baidu.swan.games.network.b.aoU();
        }
        return this.bPp;
    }

    public com.baidu.swan.apps.network.k acW() {
        if (this.bPs == null) {
            this.bPs = new com.baidu.swan.apps.network.k();
        }
        return this.bPs;
    }

    public com.baidu.swan.apps.media.audio.d acX() {
        if (this.bPr == null) {
            this.bPr = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.bPr;
    }

    @NonNull
    public g acY() {
        if (this.bPt == null) {
            this.bPt = new g(this);
        }
        return this.bPt;
    }

    public String getAppKey() {
        return acL().getAppKey();
    }

    public boolean acZ() {
        return acL().getAppFrameType() == 1;
    }

    public String getName() {
        return acL().Re();
    }

    public String getVersion() {
        return acL().getVersion();
    }

    public com.baidu.swan.apps.aj.a.a ada() {
        if (this.bPq == null) {
            this.bPq = new com.baidu.swan.apps.aj.a.a();
        }
        return this.bPq;
    }

    public boolean kL(String str) {
        if (TextUtils.isEmpty(str) || this.bPi == null || this.bPi.bPO == null) {
            return false;
        }
        return this.bPi.bPO.ld(str);
    }

    public boolean kM(String str) {
        if (TextUtils.isEmpty(str) || this.bPi == null || this.bPi.bPP == null || this.bPi.bPP.bQk == null || !this.bPi.bPP.bQk.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.bPi.bPP.bQk.get(str).booleanValue();
    }

    public boolean kN(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.aty().Q(this.id, getVersion(), str);
    }

    public boolean kO(String str) {
        return new File(com.baidu.swan.apps.y.f.WV().WD(), str).exists();
    }

    public void y(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.bPi != null && this.bPi.bPP != null && this.bPi.bPP.bQk != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bPi.bPP.bQk.put(str, Boolean.valueOf(z));
        }
    }

    public String kP(String str) {
        if (this.bPi == null || this.bPi.bPP == null || this.bPi.bPP.bQl == null) {
            return null;
        }
        return this.bPi.bPP.bQl.get(str);
    }

    public String kQ(String str) {
        if (this.bPi == null || this.bPi.bPQ == null || this.bPi.bPQ.bQn == null) {
            return null;
        }
        return this.bPi.bPQ.bQn.get(str);
    }

    public String kR(String str) {
        if (this.bPi == null) {
            return "";
        }
        return this.bPi.kR(str);
    }

    public boolean kS(String str) {
        if (TextUtils.isEmpty(str) || this.bPi == null) {
            return false;
        }
        return this.bPi.la(str);
    }

    public boolean adb() {
        return kS(com.baidu.swan.apps.y.f.WV().WZ());
    }

    public String adc() {
        b.a acL = acL();
        return acL != null ? gj(acL.getType()) : "0";
    }

    private String gj(int i) {
        if (i == 0) {
            String versionCode = this.bPw != null ? this.bPw.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String mT = ai.mT(versionCode);
            com.baidu.swan.apps.console.c.e("SwanApp", TextUtils.isEmpty(mT) ? " version is empty " : mT);
            return mT;
        }
        return "0";
    }

    public void bf(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.bPu == null) {
                this.bPu = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.bPu.put(str2, str);
        }
    }

    @Nullable
    public String kT(String str) {
        if (TextUtils.isEmpty(str) || this.bPu == null) {
            return null;
        }
        return this.bPu.get(str);
    }

    public boolean available() {
        return this.bPh && this.bPv.adi() && Gz() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return acE();
    }

    public e dO(boolean z) {
        this.bPx = z;
        kK("event_first_action_launched");
        return this;
    }

    public boolean add() {
        return this.bPx;
    }
}
