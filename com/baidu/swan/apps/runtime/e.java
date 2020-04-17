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
    public final boolean cnT;
    SwanAppConfigData cnU;
    com.baidu.swan.games.s.a.a cnV;
    private com.baidu.swan.apps.storage.c cnW;
    private com.baidu.swan.apps.storage.b.c cnX;
    private com.baidu.swan.apps.setting.a cnY;
    private com.baidu.swan.apps.a.b cnZ;
    private com.baidu.swan.apps.network.j coa;
    private com.baidu.swan.games.network.b cob;
    private com.baidu.swan.apps.aj.a.a coc;
    private com.baidu.swan.apps.media.audio.d cod;
    private com.baidu.swan.apps.network.k coe;
    private g cof;
    private Map<String, String> cog;
    private final k coh;
    protected final b.a coi;
    private boolean coj;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.coh = new k(this);
        this.coi = new b.a();
        this.coj = false;
        this.id = str == null ? "" : str;
        this.cnT = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.cnT) {
            this.coc = new com.baidu.swan.apps.aj.a.a();
            this.coc.ms(this.id);
        }
    }

    @Deprecated
    public static e akN() {
        return akO();
    }

    public static e akO() {
        d akK = d.akK();
        if (akK.ajr()) {
            return akK.akH();
        }
        return null;
    }

    @Deprecated
    public static String akP() {
        return d.akK().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean ajr() {
        return this.cnT;
    }

    public boolean Ru() {
        com.baidu.swan.apps.framework.c On;
        if (com.baidu.swan.apps.core.prefetch.a.a.XH() == 0) {
            return false;
        }
        SwanAppActivity akJ = akJ();
        return akJ == null || (On = akJ.On()) == null || !On.aaB().hasStarted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String w(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity akJ = akJ();
        if (akJ != null && !akJ.isDestroyed() && !akJ.isFinishing() && akJ.Oo()) {
            akJ.q(strArr);
        }
        com.baidu.swan.apps.y.f.release();
        if (this.cof != null) {
            this.cof.onDestroy();
        }
        com.baidu.swan.d.c.deleteFile(com.baidu.swan.apps.storage.b.nk(this.id));
        if (this.cod != null) {
            this.cod.release();
        }
        if (this.coc != null) {
            this.coc.release();
        }
        if (this.coe != null) {
            this.coe.release();
        }
        this.cnW = null;
        this.cnY = null;
        this.cob = null;
        this.coj = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores ajs() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(akQ().YI());
        swanAppCores.a(akQ().YJ());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public e akH() {
        return this;
    }

    @NonNull
    public b.a akQ() {
        return this.coi;
    }

    @NonNull
    @Deprecated
    public b.a Ow() {
        return akQ();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Om() {
        if (this.cnT) {
            return akQ().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = col.contains(str);
        b.a akQ = akQ();
        HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        lb.f(new UbcFlowEvent("swan_app_update_info_start").ed(true));
        akQ.B(bundle);
        lb.f(new UbcFlowEvent("swan_app_update_info_end").ed(true));
        if (z) {
            lX("event_on_app_occupied");
        }
        if (this.cnT && !this.coh.aln() && !this.coh.alm()) {
            lb.f(new UbcFlowEvent("swan_app_maintain_start").ed(true));
            this.coh.alo();
            lb.f(new UbcFlowEvent("swan_app_maintain_return").ed(true));
            return true;
        }
        if (this.coh.aln() && contains) {
            k.a(akQ, akQ.adR(), false, false);
        }
        return this.coh.alm();
    }

    public com.baidu.swan.apps.x.b.b N(Bundle bundle) {
        b.a akQ = akQ();
        akQ.B(bundle);
        return akQ;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void akI() {
        akX().amg();
        akV().as(true);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void lX(String str) {
        d(str, akS());
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = akS();
        } else {
            bundle.putAll(akS());
        }
        super.d(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(i.a aVar) {
        super.d((i.a) aVar.B(akS()));
    }

    public boolean akR() {
        return this.coh.alm();
    }

    private Bundle akS() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void onActivityResume(Activity activity) {
        akX().onActivityResume(activity);
    }

    public void c(SwanAppConfigData swanAppConfigData) {
        this.cnU = swanAppConfigData;
    }

    public SwanAppConfigData akT() {
        return this.cnU;
    }

    public void a(com.baidu.swan.games.s.a.a aVar) {
        this.cnV = aVar;
    }

    public com.baidu.swan.games.s.a.a akU() {
        return this.cnV;
    }

    public com.baidu.swan.apps.storage.c akV() {
        if (this.cnW == null) {
            this.cnW = new com.baidu.swan.apps.storage.c(this);
        }
        return this.cnW;
    }

    public com.baidu.swan.apps.storage.b.c akW() {
        if (this.cnX == null) {
            if (ale()) {
                this.cnX = new com.baidu.swan.games.h.k();
            } else {
                this.cnX = new com.baidu.swan.apps.storage.b.b();
            }
        }
        return this.cnX;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a akX() {
        if (this.cnY == null) {
            this.cnY = new com.baidu.swan.apps.setting.a(this);
        }
        return this.cnY;
    }

    public com.baidu.swan.apps.a.b akY() {
        if (this.cnZ == null) {
            this.cnZ = new com.baidu.swan.apps.a.b(this);
        }
        return this.cnZ;
    }

    public synchronized com.baidu.swan.apps.network.j akZ() {
        if (this.coa == null) {
            this.coa = new com.baidu.swan.apps.network.j(this);
        }
        return this.coa;
    }

    public synchronized com.baidu.swan.games.network.b ala() {
        if (this.cob == null) {
            this.cob = com.baidu.swan.games.network.b.axh();
        }
        return this.cob;
    }

    public com.baidu.swan.apps.network.k alb() {
        if (this.coe == null) {
            this.coe = new com.baidu.swan.apps.network.k();
        }
        return this.coe;
    }

    public com.baidu.swan.apps.media.audio.d alc() {
        if (this.cod == null) {
            this.cod = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.cod;
    }

    @NonNull
    public g ald() {
        if (this.cof == null) {
            this.cof = new g(this);
        }
        return this.cof;
    }

    public String getAppKey() {
        return akQ().getAppKey();
    }

    public boolean ale() {
        return akQ().getAppFrameType() == 1;
    }

    public String getName() {
        return akQ().YT();
    }

    public String getVersion() {
        return akQ().getVersion();
    }

    public com.baidu.swan.apps.aj.a.a alf() {
        if (this.coc == null) {
            this.coc = new com.baidu.swan.apps.aj.a.a();
        }
        return this.coc;
    }

    public boolean lY(String str) {
        if (TextUtils.isEmpty(str) || this.cnU == null || this.cnU.coA == null) {
            return false;
        }
        return this.cnU.coA.mq(str);
    }

    public boolean lZ(String str) {
        if (TextUtils.isEmpty(str) || this.cnU == null || this.cnU.coB == null || this.cnU.coB.coW == null || !this.cnU.coB.coW.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.cnU.coB.coW.get(str).booleanValue();
    }

    public boolean ma(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.aBI().Q(this.id, getVersion(), str);
    }

    public boolean mb(String str) {
        return new File(com.baidu.swan.apps.y.f.aeK().aes(), str).exists();
    }

    public void D(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.cnU != null && this.cnU.coB != null && this.cnU.coB.coW != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.cnU.coB.coW.put(str, Boolean.valueOf(z));
        }
    }

    public String mc(String str) {
        if (this.cnU == null || this.cnU.coB == null || this.cnU.coB.coX == null) {
            return null;
        }
        return this.cnU.coB.coX.get(str);
    }

    public String md(String str) {
        if (this.cnU == null || this.cnU.coC == null || this.cnU.coC.coZ == null) {
            return null;
        }
        return this.cnU.coC.coZ.get(str);
    }

    public String me(String str) {
        if (this.cnU == null) {
            return "";
        }
        return this.cnU.me(str);
    }

    public boolean mf(String str) {
        if (TextUtils.isEmpty(str) || this.cnU == null) {
            return false;
        }
        return this.cnU.mn(str);
    }

    public boolean alg() {
        return mf(com.baidu.swan.apps.y.f.aeK().aeP());
    }

    public String alh() {
        b.a akQ = akQ();
        return akQ != null ? gr(akQ.getType()) : "0";
    }

    private String gr(int i) {
        if (i == 0) {
            String versionCode = this.coi != null ? this.coi.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String oh = ai.oh(versionCode);
            com.baidu.swan.apps.console.c.e("SwanApp", TextUtils.isEmpty(oh) ? " version is empty " : oh);
            return oh;
        }
        return "0";
    }

    public void bp(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.cog == null) {
                this.cog = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.cog.put(str2, str);
        }
    }

    @Nullable
    public String mg(String str) {
        if (TextUtils.isEmpty(str) || this.cog == null) {
            return null;
        }
        return this.cog.get(str);
    }

    public boolean available() {
        return this.cnT && this.coh.aln() && Om() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return akJ();
    }

    public e eK(boolean z) {
        this.coj = z;
        lX("event_first_action_launched");
        return this;
    }

    public boolean ali() {
        return this.coj;
    }
}
