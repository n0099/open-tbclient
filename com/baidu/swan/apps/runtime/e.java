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
/* loaded from: classes9.dex */
public class e extends l {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final boolean bKf;
    SwanAppConfigData bKg;
    com.baidu.swan.games.s.a.a bKh;
    private com.baidu.swan.apps.storage.c bKi;
    private com.baidu.swan.apps.storage.b.c bKj;
    private com.baidu.swan.apps.setting.a bKk;
    private com.baidu.swan.apps.a.b bKl;
    private com.baidu.swan.apps.network.j bKm;
    private com.baidu.swan.games.network.b bKn;
    private com.baidu.swan.apps.aj.a.a bKo;
    private com.baidu.swan.apps.media.audio.d bKp;
    private com.baidu.swan.apps.network.k bKq;
    private g bKr;
    private Map<String, String> bKs;
    private final k bKt;
    protected final b.a bKu;
    private boolean bKv;
    public final String id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        boolean z = false;
        this.bKt = new k(this);
        this.bKu = new b.a();
        this.bKv = false;
        this.id = str == null ? "" : str;
        this.bKf = (!TextUtils.isEmpty(this.id) || TextUtils.equals(this.id, "swan_id_unknown")) ? true : true;
        if (this.bKf) {
            this.bKo = new com.baidu.swan.apps.aj.a.a();
            this.bKo.kO(this.id);
        }
    }

    @Deprecated
    public static e ZS() {
        return ZT();
    }

    public static e ZT() {
        d ZP = d.ZP();
        if (ZP.Yw()) {
            return ZP.ZM();
        }
        return null;
    }

    @Deprecated
    public static String ZU() {
        return d.ZP().getAppId();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public boolean Yw() {
        return this.bKf;
    }

    public boolean GS() {
        com.baidu.swan.apps.framework.c DI;
        if (com.baidu.swan.apps.core.prefetch.a.a.Nd() == 0) {
            return false;
        }
        SwanAppActivity ZO = ZO();
        return ZO == null || (DI = ZO.DI()) == null || !DI.PX().hasStarted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String s(String... strArr) {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + this.id);
        }
        SwanAppActivity ZO = ZO();
        if (ZO != null && !ZO.isDestroyed() && !ZO.isFinishing() && ZO.DJ()) {
            ZO.m(strArr);
        }
        com.baidu.swan.apps.y.f.release();
        if (this.bKr != null) {
            this.bKr.onDestroy();
        }
        com.baidu.swan.d.c.deleteFile(com.baidu.swan.apps.storage.b.lG(this.id));
        if (this.bKp != null) {
            this.bKp.release();
        }
        if (this.bKo != null) {
            this.bKo.release();
        }
        if (this.bKq != null) {
            this.bKq.release();
        }
        this.bKi = null;
        this.bKk = null;
        this.bKn = null;
        this.bKv = false;
        return this.id;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public SwanAppCores Yx() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(ZV().Oe());
        swanAppCores.a(ZV().Of());
        return swanAppCores;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public e ZM() {
        return this;
    }

    @NonNull
    public b.a ZV() {
        return this.bKu;
    }

    @NonNull
    @Deprecated
    public b.a DR() {
        return ZV();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int DH() {
        if (this.bKf) {
            return ZV().getAppFrameType();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Bundle bundle, String str, boolean z) {
        boolean contains = bKx.contains(str);
        b.a ZV = ZV();
        HybridUbcFlow jx = com.baidu.swan.apps.performance.f.jx("startup");
        jx.f(new UbcFlowEvent("swan_app_update_info_start").cU(true));
        ZV.B(bundle);
        jx.f(new UbcFlowEvent("swan_app_update_info_end").cU(true));
        if (z) {
            kt("event_on_app_occupied");
        }
        if (this.bKf && !this.bKt.aas() && !this.bKt.aar()) {
            jx.f(new UbcFlowEvent("swan_app_maintain_start").cU(true));
            this.bKt.aat();
            jx.f(new UbcFlowEvent("swan_app_maintain_return").cU(true));
            return true;
        }
        if (this.bKt.aas() && contains) {
            k.a(ZV, ZV.Tm(), false, false);
        }
        return this.bKt.aar();
    }

    public com.baidu.swan.apps.x.b.b N(Bundle bundle) {
        b.a ZV = ZV();
        ZV.B(bundle);
        return ZV;
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void ZN() {
        aac().abl();
        aaa().Q(true);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void kt(String str) {
        d(str, ZX());
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = ZX();
        } else {
            bundle.putAll(ZX());
        }
        super.d(str, bundle);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public void d(i.a aVar) {
        super.d((i.a) aVar.B(ZX()));
    }

    public boolean ZW() {
        return this.bKt.aar();
    }

    private Bundle ZX() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.id);
        return bundle;
    }

    public void onActivityResume(Activity activity) {
        aac().onActivityResume(activity);
    }

    public void c(SwanAppConfigData swanAppConfigData) {
        this.bKg = swanAppConfigData;
    }

    public SwanAppConfigData ZY() {
        return this.bKg;
    }

    public void a(com.baidu.swan.games.s.a.a aVar) {
        this.bKh = aVar;
    }

    public com.baidu.swan.games.s.a.a ZZ() {
        return this.bKh;
    }

    public com.baidu.swan.apps.storage.c aaa() {
        if (this.bKi == null) {
            this.bKi = new com.baidu.swan.apps.storage.c(this);
        }
        return this.bKi;
    }

    public com.baidu.swan.apps.storage.b.c aab() {
        if (this.bKj == null) {
            if (aaj()) {
                this.bKj = new com.baidu.swan.games.h.k();
            } else {
                this.bKj = new com.baidu.swan.apps.storage.b.b();
            }
        }
        return this.bKj;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a aac() {
        if (this.bKk == null) {
            this.bKk = new com.baidu.swan.apps.setting.a(this);
        }
        return this.bKk;
    }

    public com.baidu.swan.apps.a.b aad() {
        if (this.bKl == null) {
            this.bKl = new com.baidu.swan.apps.a.b(this);
        }
        return this.bKl;
    }

    public synchronized com.baidu.swan.apps.network.j aae() {
        if (this.bKm == null) {
            this.bKm = new com.baidu.swan.apps.network.j(this);
        }
        return this.bKm;
    }

    public synchronized com.baidu.swan.games.network.b aaf() {
        if (this.bKn == null) {
            this.bKn = com.baidu.swan.games.network.b.amj();
        }
        return this.bKn;
    }

    public com.baidu.swan.apps.network.k aag() {
        if (this.bKq == null) {
            this.bKq = new com.baidu.swan.apps.network.k();
        }
        return this.bKq;
    }

    public com.baidu.swan.apps.media.audio.d aah() {
        if (this.bKp == null) {
            this.bKp = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.bKp;
    }

    @NonNull
    public g aai() {
        if (this.bKr == null) {
            this.bKr = new g(this);
        }
        return this.bKr;
    }

    public String getAppKey() {
        return ZV().getAppKey();
    }

    public boolean aaj() {
        return ZV().getAppFrameType() == 1;
    }

    public String getName() {
        return ZV().Op();
    }

    public String getVersion() {
        return ZV().getVersion();
    }

    public com.baidu.swan.apps.aj.a.a aak() {
        if (this.bKo == null) {
            this.bKo = new com.baidu.swan.apps.aj.a.a();
        }
        return this.bKo;
    }

    public boolean ku(String str) {
        if (TextUtils.isEmpty(str) || this.bKg == null || this.bKg.bKM == null) {
            return false;
        }
        return this.bKg.bKM.kM(str);
    }

    public boolean kv(String str) {
        if (TextUtils.isEmpty(str) || this.bKg == null || this.bKg.bKN == null || this.bKg.bKN.bLi == null || !this.bKg.bKN.bLi.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.bKg.bKN.bLi.get(str).booleanValue();
    }

    public boolean kw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.pms.database.a.aqM().P(this.id, getVersion(), str);
    }

    public boolean kx(String str) {
        return new File(com.baidu.swan.apps.y.f.Uf().TN(), str).exists();
    }

    public void y(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.bKg != null && this.bKg.bKN != null && this.bKg.bKN.bLi != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bKg.bKN.bLi.put(str, Boolean.valueOf(z));
        }
    }

    public String ky(String str) {
        if (this.bKg == null || this.bKg.bKN == null || this.bKg.bKN.bLj == null) {
            return null;
        }
        return this.bKg.bKN.bLj.get(str);
    }

    public String kz(String str) {
        if (this.bKg == null || this.bKg.bKO == null || this.bKg.bKO.bLl == null) {
            return null;
        }
        return this.bKg.bKO.bLl.get(str);
    }

    public String kA(String str) {
        if (this.bKg == null) {
            return "";
        }
        return this.bKg.kA(str);
    }

    public boolean kB(String str) {
        if (TextUtils.isEmpty(str) || this.bKg == null) {
            return false;
        }
        return this.bKg.kJ(str);
    }

    public boolean aal() {
        return kB(com.baidu.swan.apps.y.f.Uf().Uj());
    }

    public String aam() {
        b.a ZV = ZV();
        return ZV != null ? fS(ZV.getType()) : "0";
    }

    private String fS(int i) {
        if (i == 0) {
            String versionCode = this.bKu != null ? this.bKu.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String mC = ai.mC(versionCode);
            com.baidu.swan.apps.console.c.e("SwanApp", TextUtils.isEmpty(mC) ? " version is empty " : mC);
            return mC;
        }
        return "0";
    }

    public void aW(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.bKs == null) {
                this.bKs = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.bKs.put(str2, str);
        }
    }

    @Nullable
    public String kC(String str) {
        if (TextUtils.isEmpty(str) || this.bKs == null) {
            return null;
        }
        return this.bKs.get(str);
    }

    public boolean available() {
        return this.bKf && this.bKt.aas() && DH() > -1;
    }

    @Deprecated
    public Activity getActivity() {
        return ZO();
    }

    public e dB(boolean z) {
        this.bKv = z;
        kt("event_first_action_launched");
        return this;
    }

    public boolean aan() {
        return this.bKv;
    }
}
