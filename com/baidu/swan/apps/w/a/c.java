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
    private static int bxW = -1;

    @Override // com.baidu.swan.config.a
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.config.a
    public String Vd() {
        return com.baidu.swan.apps.w.a.Ui().Ie();
    }

    @Override // com.baidu.swan.config.a
    public String US() {
        return com.baidu.swan.apps.w.a.Ub().br(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.config.a
    public String getUUID() {
        return com.baidu.swan.uuid.b.dH(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.config.a
    public String UT() {
        return com.baidu.swan.apps.w.a.UH().getHostName();
    }

    @Override // com.baidu.swan.config.a
    public String UU() {
        return ai.getVersionName();
    }

    @Override // com.baidu.swan.config.a
    public String UV() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.config.a
    public String UW() {
        return com.baidu.swan.apps.swancore.b.gy(0);
    }

    @Override // com.baidu.swan.config.a
    public String UY() {
        return com.baidu.swan.apps.swancore.b.gy(1);
    }

    @Override // com.baidu.swan.config.a
    public void aj(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d bZ = com.baidu.swan.pms.f.d.bZ(jSONObject);
        if (bZ != null && bZ.PU()) {
            h(bZ);
        }
    }

    @Override // com.baidu.swan.config.a
    public void ak(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d bZ = com.baidu.swan.pms.f.d.bZ(jSONObject);
        if (bZ != null && bZ.PU()) {
            h(bZ);
        }
    }

    @Override // com.baidu.swan.config.a
    public void al(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b ca = com.baidu.swan.pms.f.d.ca(jSONObject);
        if (ca != null && ca.PU()) {
            i(ca);
        }
    }

    @Override // com.baidu.swan.config.a
    public void am(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b ca = com.baidu.swan.pms.f.d.ca(jSONObject);
        if (ca != null && ca.PU()) {
            i(ca);
        }
    }

    @Override // com.baidu.swan.config.a
    public String UX() {
        return com.baidu.swan.apps.extcore.b.eP(0);
    }

    @Override // com.baidu.swan.config.a
    public String UZ() {
        return com.baidu.swan.apps.extcore.b.eP(1);
    }

    @Override // com.baidu.swan.config.a
    public CookieManager Va() {
        return com.baidu.swan.apps.w.a.Uu().Iu();
    }

    private void h(com.baidu.swan.pms.model.d dVar) {
        if (dVar != null) {
            g Vf = dVar.category == 1 ? Vf() : Ve();
            Vf.Pm();
            e eVar = new e();
            eVar.a(dVar, PMSPkgStatus.WAIT);
            Vf.a(eVar);
            com.baidu.swan.pms.c.a.a.a(dVar, Vf);
        }
    }

    private void i(com.baidu.swan.pms.model.b bVar) {
        if (bVar != null) {
            g Vf = bVar.category == 1 ? Vf() : Ve();
            Vf.Pm();
            e eVar = new e();
            eVar.a(bVar, PMSPkgStatus.WAIT);
            Vf.a(eVar);
            com.baidu.swan.pms.c.a.a.a(bVar, Vf);
        }
    }

    private i Ve() {
        return new i() { // from class: com.baidu.swan.apps.w.a.c.1
            @Override // com.baidu.swan.apps.core.pms.k
            protected void PE() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.aS(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void PD() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }

    private com.baidu.swan.games.j.b.a Vf() {
        return new com.baidu.swan.games.j.b.a() { // from class: com.baidu.swan.apps.w.a.c.2
            @Override // com.baidu.swan.apps.core.pms.k
            protected void PE() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.aS(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void PD() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }
}
