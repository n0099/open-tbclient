package com.baidu.swan.apps.w.a;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.pms.i;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.f.e;
import com.baidu.swan.pms.model.PMSPkgStatus;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements com.baidu.swan.config.a {
    private static int bxV = -1;

    @Override // com.baidu.swan.config.a
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.config.a
    public String Vb() {
        return com.baidu.swan.apps.w.a.Ug().Ic();
    }

    @Override // com.baidu.swan.config.a
    public String UQ() {
        return com.baidu.swan.apps.w.a.TZ().br(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.config.a
    public String getUUID() {
        return com.baidu.swan.uuid.b.dH(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.config.a
    public String UR() {
        return com.baidu.swan.apps.w.a.UF().getHostName();
    }

    @Override // com.baidu.swan.config.a
    public String US() {
        return ai.getVersionName();
    }

    @Override // com.baidu.swan.config.a
    public String UT() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.config.a
    public String UU() {
        return com.baidu.swan.apps.swancore.b.gy(0);
    }

    @Override // com.baidu.swan.config.a
    public String UW() {
        return com.baidu.swan.apps.swancore.b.gy(1);
    }

    @Override // com.baidu.swan.config.a
    public void aj(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d bZ = com.baidu.swan.pms.f.d.bZ(jSONObject);
        if (bZ != null && bZ.PS()) {
            h(bZ);
        }
    }

    @Override // com.baidu.swan.config.a
    public void ak(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d bZ = com.baidu.swan.pms.f.d.bZ(jSONObject);
        if (bZ != null && bZ.PS()) {
            h(bZ);
        }
    }

    @Override // com.baidu.swan.config.a
    public void al(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b ca = com.baidu.swan.pms.f.d.ca(jSONObject);
        if (ca != null && ca.PS()) {
            i(ca);
        }
    }

    @Override // com.baidu.swan.config.a
    public void am(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b ca = com.baidu.swan.pms.f.d.ca(jSONObject);
        if (ca != null && ca.PS()) {
            i(ca);
        }
    }

    @Override // com.baidu.swan.config.a
    public String UV() {
        return com.baidu.swan.apps.extcore.b.eP(0);
    }

    @Override // com.baidu.swan.config.a
    public String UX() {
        return com.baidu.swan.apps.extcore.b.eP(1);
    }

    @Override // com.baidu.swan.config.a
    public CookieManager UY() {
        return com.baidu.swan.apps.w.a.Us().Is();
    }

    private void h(com.baidu.swan.pms.model.d dVar) {
        if (dVar != null) {
            g Vd = dVar.category == 1 ? Vd() : Vc();
            Vd.Pk();
            e eVar = new e();
            eVar.a(dVar, PMSPkgStatus.WAIT);
            Vd.a(eVar);
            com.baidu.swan.pms.c.a.a.a(dVar, Vd);
        }
    }

    private void i(com.baidu.swan.pms.model.b bVar) {
        if (bVar != null) {
            g Vd = bVar.category == 1 ? Vd() : Vc();
            Vd.Pk();
            e eVar = new e();
            eVar.a(bVar, PMSPkgStatus.WAIT);
            Vd.a(eVar);
            com.baidu.swan.pms.c.a.a.a(bVar, Vd);
        }
    }

    private i Vc() {
        return new i() { // from class: com.baidu.swan.apps.w.a.c.1
            @Override // com.baidu.swan.apps.core.pms.k
            protected void PC() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.aS(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void PB() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }

    private com.baidu.swan.games.j.b.a Vd() {
        return new com.baidu.swan.games.j.b.a() { // from class: com.baidu.swan.apps.w.a.c.2
            @Override // com.baidu.swan.apps.core.pms.k
            protected void PC() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.aS(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void PB() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }
}
