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
/* loaded from: classes9.dex */
public class c implements com.baidu.swan.config.a {
    private static int bsX = -1;

    @Override // com.baidu.swan.config.a
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.config.a
    public String Sr() {
        return com.baidu.swan.apps.w.a.Rw().Fr();
    }

    @Override // com.baidu.swan.config.a
    public String Sg() {
        return com.baidu.swan.apps.w.a.Rp().bn(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.config.a
    public String getUUID() {
        return com.baidu.swan.uuid.b.dD(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.config.a
    public String Sh() {
        return com.baidu.swan.apps.w.a.RV().getHostName();
    }

    @Override // com.baidu.swan.config.a
    public String Si() {
        return ai.getVersionName();
    }

    @Override // com.baidu.swan.config.a
    public String Sj() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.config.a
    public String Sk() {
        return com.baidu.swan.apps.swancore.b.gg(0);
    }

    @Override // com.baidu.swan.config.a
    public String Sm() {
        return com.baidu.swan.apps.swancore.b.gg(1);
    }

    @Override // com.baidu.swan.config.a
    public void aj(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d bZ = com.baidu.swan.pms.f.d.bZ(jSONObject);
        if (bZ != null && bZ.Ni()) {
            h(bZ);
        }
    }

    @Override // com.baidu.swan.config.a
    public void ak(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d bZ = com.baidu.swan.pms.f.d.bZ(jSONObject);
        if (bZ != null && bZ.Ni()) {
            h(bZ);
        }
    }

    @Override // com.baidu.swan.config.a
    public void al(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b ca = com.baidu.swan.pms.f.d.ca(jSONObject);
        if (ca != null && ca.Ni()) {
            i(ca);
        }
    }

    @Override // com.baidu.swan.config.a
    public void am(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b ca = com.baidu.swan.pms.f.d.ca(jSONObject);
        if (ca != null && ca.Ni()) {
            i(ca);
        }
    }

    @Override // com.baidu.swan.config.a
    public String Sl() {
        return com.baidu.swan.apps.extcore.b.ey(0);
    }

    @Override // com.baidu.swan.config.a
    public String Sn() {
        return com.baidu.swan.apps.extcore.b.ey(1);
    }

    @Override // com.baidu.swan.config.a
    public CookieManager So() {
        return com.baidu.swan.apps.w.a.RI().FH();
    }

    private void h(com.baidu.swan.pms.model.d dVar) {
        if (dVar != null) {
            g St = dVar.category == 1 ? St() : Ss();
            St.MA();
            e eVar = new e();
            eVar.a(dVar, PMSPkgStatus.WAIT);
            St.a(eVar);
            com.baidu.swan.pms.c.a.a.a(dVar, St);
        }
    }

    private void i(com.baidu.swan.pms.model.b bVar) {
        if (bVar != null) {
            g St = bVar.category == 1 ? St() : Ss();
            St.MA();
            e eVar = new e();
            eVar.a(bVar, PMSPkgStatus.WAIT);
            St.a(eVar);
            com.baidu.swan.pms.c.a.a.a(bVar, St);
        }
    }

    private i Ss() {
        return new i() { // from class: com.baidu.swan.apps.w.a.c.1
            @Override // com.baidu.swan.apps.core.pms.k
            protected void MS() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.aL(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void MR() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }

    private com.baidu.swan.games.j.b.a St() {
        return new com.baidu.swan.games.j.b.a() { // from class: com.baidu.swan.apps.w.a.c.2
            @Override // com.baidu.swan.apps.core.pms.k
            protected void MS() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.aL(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void MR() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }
}
