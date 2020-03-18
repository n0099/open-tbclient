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
    private static int byi = -1;

    @Override // com.baidu.swan.config.a
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.config.a
    public String Vg() {
        return com.baidu.swan.apps.w.a.Ul().Ih();
    }

    @Override // com.baidu.swan.config.a
    public String UV() {
        return com.baidu.swan.apps.w.a.Ue().bq(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.config.a
    public String getUUID() {
        return com.baidu.swan.uuid.b.dG(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.config.a
    public String UW() {
        return com.baidu.swan.apps.w.a.UK().getHostName();
    }

    @Override // com.baidu.swan.config.a
    public String UX() {
        return ai.getVersionName();
    }

    @Override // com.baidu.swan.config.a
    public String UY() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.config.a
    public String UZ() {
        return com.baidu.swan.apps.swancore.b.gy(0);
    }

    @Override // com.baidu.swan.config.a
    public String Vb() {
        return com.baidu.swan.apps.swancore.b.gy(1);
    }

    @Override // com.baidu.swan.config.a
    public void aj(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d bZ = com.baidu.swan.pms.f.d.bZ(jSONObject);
        if (bZ != null && bZ.PX()) {
            h(bZ);
        }
    }

    @Override // com.baidu.swan.config.a
    public void ak(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d bZ = com.baidu.swan.pms.f.d.bZ(jSONObject);
        if (bZ != null && bZ.PX()) {
            h(bZ);
        }
    }

    @Override // com.baidu.swan.config.a
    public void al(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b ca = com.baidu.swan.pms.f.d.ca(jSONObject);
        if (ca != null && ca.PX()) {
            i(ca);
        }
    }

    @Override // com.baidu.swan.config.a
    public void am(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b ca = com.baidu.swan.pms.f.d.ca(jSONObject);
        if (ca != null && ca.PX()) {
            i(ca);
        }
    }

    @Override // com.baidu.swan.config.a
    public String Va() {
        return com.baidu.swan.apps.extcore.b.eP(0);
    }

    @Override // com.baidu.swan.config.a
    public String Vc() {
        return com.baidu.swan.apps.extcore.b.eP(1);
    }

    @Override // com.baidu.swan.config.a
    public CookieManager Vd() {
        return com.baidu.swan.apps.w.a.Ux().Ix();
    }

    private void h(com.baidu.swan.pms.model.d dVar) {
        if (dVar != null) {
            g Vi = dVar.category == 1 ? Vi() : Vh();
            Vi.Pp();
            e eVar = new e();
            eVar.a(dVar, PMSPkgStatus.WAIT);
            Vi.a(eVar);
            com.baidu.swan.pms.c.a.a.a(dVar, Vi);
        }
    }

    private void i(com.baidu.swan.pms.model.b bVar) {
        if (bVar != null) {
            g Vi = bVar.category == 1 ? Vi() : Vh();
            Vi.Pp();
            e eVar = new e();
            eVar.a(bVar, PMSPkgStatus.WAIT);
            Vi.a(eVar);
            com.baidu.swan.pms.c.a.a.a(bVar, Vi);
        }
    }

    private i Vh() {
        return new i() { // from class: com.baidu.swan.apps.w.a.c.1
            @Override // com.baidu.swan.apps.core.pms.k
            protected void PH() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.aS(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void PG() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }

    private com.baidu.swan.games.j.b.a Vi() {
        return new com.baidu.swan.games.j.b.a() { // from class: com.baidu.swan.apps.w.a.c.2
            @Override // com.baidu.swan.apps.core.pms.k
            protected void PH() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.aS(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void PG() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }
}
