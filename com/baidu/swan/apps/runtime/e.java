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
    public final boolean cnZ;
    SwanAppConfigData coa;
    com.baidu.swan.games.s.a.a cob;
    private com.baidu.swan.apps.storage.c coc;
    private com.baidu.swan.apps.storage.b.c cod;
    private com.baidu.swan.apps.setting.a coe;
    private com.baidu.swan.apps.a.b cof;
    private com.baidu.swan.apps.network.j cog;
    private com.baidu.swan.games.network.b coh;
    private com.baidu.swan.apps.aj.a.a coi;
    private com.baidu.swan.apps.media.audio.d coj;
    private com.baidu.swan.apps.network.k cok;
    private g col;

    /* renamed from: com  reason: collision with root package name */
    private Map<String, String> f1002com;
    private final k con;
    protected final b.a coo;
    private boolean cop;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.con = new k(this);
        this.coo = new b.a();
        this.cop = false;
        this.id = str == null ? "" : str;
        this.cnZ = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.cnZ) {
            this.coi = new com.baidu.swan.apps.aj.a.a();
            this.coi.ms(this.id);
        }
    }

    @Deprecated
    public static e akM() {
        return akN();
    }

    public static e akN() {
        d akJ = d.akJ();
        if (akJ.ajq()) {
            return akJ.akG();
        }
        return null;
    }

    @Deprecated
    public static String akO() {
        return d.akJ().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean ajq() {
        return this.cnZ;
    }

    public boolean Rt() {
        com.baidu.swan.apps.framework.c Om;
        if (com.baidu.swan.apps.core.prefetch.a.a.XG() == 0) {
            return false;
        }
        SwanAppActivity akI = akI();
        return akI == null || (Om = akI.Om()) == null || !Om.aaA().hasStarted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String w(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity akI = akI();
        if (akI != null && !akI.isDestroyed() && !akI.isFinishing() && akI.On()) {
            akI.q(strArr);
        }
        com.baidu.swan.apps.y.f.release();
        if (this.col != null) {
            this.col.onDestroy();
        }
        com.baidu.swan.d.c.deleteFile(com.baidu.swan.apps.storage.b.nk(this.id));
        if (this.coj != null) {
            this.coj.release();
        }
        if (this.coi != null) {
            this.coi.release();
        }
        if (this.cok != null) {
            this.cok.release();
        }
        this.coc = null;
        this.coe = null;
        this.coh = null;
        this.cop = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores ajr() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(akP().YH());
        swanAppCores.a(akP().YI());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public e akG() {
        return this;
    }

    @NonNull
    public b.a akP() {
        return this.coo;
    }

    @NonNull
    @Deprecated
    public b.a Ov() {
        return akP();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Ol() {
        if (this.cnZ) {
            return akP().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = cor.contains(str);
        b.a akP = akP();
        HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        lb.f(new UbcFlowEvent("swan_app_update_info_start").ed(true));
        akP.B(bundle);
        lb.f(new UbcFlowEvent("swan_app_update_info_end").ed(true));
        if (z) {
            lX("event_on_app_occupied");
        }
        if (this.cnZ && !this.con.alm() && !this.con.all()) {
            lb.f(new UbcFlowEvent("swan_app_maintain_start").ed(true));
            this.con.aln();
            lb.f(new UbcFlowEvent("swan_app_maintain_return").ed(true));
            return true;
        }
        if (this.con.alm() && contains) {
            k.a(akP, akP.adQ(), false, false);
        }
        return this.con.all();
    }

    public com.baidu.swan.apps.x.b.b N(Bundle bundle) {
        b.a akP = akP();
        akP.B(bundle);
        return akP;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void akH() {
        akW().amf();
        akU().as(true);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void lX(String str) {
        d(str, akR());
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = akR();
        } else {
            bundle.putAll(akR());
        }
        super.d(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(i.a aVar) {
        super.d((i.a) aVar.B(akR()));
    }

    public boolean akQ() {
        return this.con.all();
    }

    private Bundle akR() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void onActivityResume(Activity activity) {
        akW().onActivityResume(activity);
    }

    public void c(SwanAppConfigData swanAppConfigData) {
        this.coa = swanAppConfigData;
    }

    public SwanAppConfigData akS() {
        return this.coa;
    }

    public void a(com.baidu.swan.games.s.a.a aVar) {
        this.cob = aVar;
    }

    public com.baidu.swan.games.s.a.a akT() {
        return this.cob;
    }

    public com.baidu.swan.apps.storage.c akU() {
        if (this.coc == null) {
            this.coc = new com.baidu.swan.apps.storage.c(this);
        }
        return this.coc;
    }

    public com.baidu.swan.apps.storage.b.c akV() {
        if (this.cod == null) {
            if (ald()) {
                this.cod = new com.baidu.swan.games.h.k();
            } else {
                this.cod = new com.baidu.swan.apps.storage.b.b();
            }
        }
        return this.cod;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a akW() {
        if (this.coe == null) {
            this.coe = new com.baidu.swan.apps.setting.a(this);
        }
        return this.coe;
    }

    public com.baidu.swan.apps.a.b akX() {
        if (this.cof == null) {
            this.cof = new com.baidu.swan.apps.a.b(this);
        }
        return this.cof;
    }

    public synchronized com.baidu.swan.apps.network.j akY() {
        if (this.cog == null) {
            this.cog = new com.baidu.swan.apps.network.j(this);
        }
        return this.cog;
    }

    public synchronized com.baidu.swan.games.network.b akZ() {
        if (this.coh == null) {
            this.coh = com.baidu.swan.games.network.b.axh();
        }
        return this.coh;
    }

    public com.baidu.swan.apps.network.k ala() {
        if (this.cok == null) {
            this.cok = new com.baidu.swan.apps.network.k();
        }
        return this.cok;
    }

    public com.baidu.swan.apps.media.audio.d alb() {
        if (this.coj == null) {
            this.coj = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.coj;
    }

    @NonNull
    public g alc() {
        if (this.col == null) {
            this.col = new g(this);
        }
        return this.col;
    }

    public String getAppKey() {
        return akP().getAppKey();
    }

    public boolean ald() {
        return akP().getAppFrameType() == 1;
    }

    public String getName() {
        return akP().YS();
    }

    public String getVersion() {
        return akP().getVersion();
    }

    public com.baidu.swan.apps.aj.a.a ale() {
        if (this.coi == null) {
            this.coi = new com.baidu.swan.apps.aj.a.a();
        }
        return this.coi;
    }

    public boolean lY(String str) {
        if (TextUtils.isEmpty(str) || this.coa == null || this.coa.coG == null) {
            return false;
        }
        return this.coa.coG.mq(str);
    }

    public boolean lZ(String str) {
        if (TextUtils.isEmpty(str) || this.coa == null || this.coa.coH == null || this.coa.coH.cpc == null || !this.coa.coH.cpc.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.coa.coH.cpc.get(str).booleanValue();
    }

    public boolean ma(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.aBI().Q(this.id, getVersion(), str);
    }

    public boolean mb(String str) {
        return new File(com.baidu.swan.apps.y.f.aeJ().aer(), str).exists();
    }

    public void D(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.coa != null && this.coa.coH != null && this.coa.coH.cpc != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.coa.coH.cpc.put(str, Boolean.valueOf(z));
        }
    }

    public String mc(String str) {
        if (this.coa == null || this.coa.coH == null || this.coa.coH.cpd == null) {
            return null;
        }
        return this.coa.coH.cpd.get(str);
    }

    public String md(String str) {
        if (this.coa == null || this.coa.coI == null || this.coa.coI.cpf == null) {
            return null;
        }
        return this.coa.coI.cpf.get(str);
    }

    public String me(String str) {
        if (this.coa == null) {
            return "";
        }
        return this.coa.me(str);
    }

    public boolean mf(String str) {
        if (TextUtils.isEmpty(str) || this.coa == null) {
            return false;
        }
        return this.coa.mn(str);
    }

    public boolean alf() {
        return mf(com.baidu.swan.apps.y.f.aeJ().aeO());
    }

    public String alg() {
        b.a akP = akP();
        return akP != null ? gr(akP.getType()) : "0";
    }

    private String gr(int i) {
        if (i == 0) {
            String versionCode = this.coo != null ? this.coo.getVersionCode() : "";
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
            if (this.f1002com == null) {
                this.f1002com = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.f1002com.put(str2, str);
        }
    }

    @Nullable
    public String mg(String str) {
        if (TextUtils.isEmpty(str) || this.f1002com == null) {
            return null;
        }
        return this.f1002com.get(str);
    }

    public boolean available() {
        return this.cnZ && this.con.alm() && Ol() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return akI();
    }

    public e eK(boolean z) {
        this.cop = z;
        lX("event_first_action_launched");
        return this;
    }

    public boolean alh() {
        return this.cop;
    }
}
