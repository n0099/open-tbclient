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
/* loaded from: classes10.dex */
public class c implements com.baidu.swan.config.a {
    private static int btL = -1;

    @Override // com.baidu.swan.config.a
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.config.a
    public String SN() {
        return com.baidu.swan.apps.w.a.RS().FN();
    }

    @Override // com.baidu.swan.config.a
    public String SC() {
        return com.baidu.swan.apps.w.a.RL().bn(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.config.a
    public String getUUID() {
        return com.baidu.swan.uuid.b.dD(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.config.a
    public String SD() {
        return com.baidu.swan.apps.w.a.Sr().getHostName();
    }

    @Override // com.baidu.swan.config.a
    public String SE() {
        return ai.getVersionName();
    }

    @Override // com.baidu.swan.config.a
    public String SF() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.config.a
    public String SG() {
        return com.baidu.swan.apps.swancore.b.gh(0);
    }

    @Override // com.baidu.swan.config.a
    public String SI() {
        return com.baidu.swan.apps.swancore.b.gh(1);
    }

    @Override // com.baidu.swan.config.a
    public void aj(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d bZ = com.baidu.swan.pms.f.d.bZ(jSONObject);
        if (bZ != null && bZ.NE()) {
            h(bZ);
        }
    }

    @Override // com.baidu.swan.config.a
    public void ak(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d bZ = com.baidu.swan.pms.f.d.bZ(jSONObject);
        if (bZ != null && bZ.NE()) {
            h(bZ);
        }
    }

    @Override // com.baidu.swan.config.a
    public void al(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b ca = com.baidu.swan.pms.f.d.ca(jSONObject);
        if (ca != null && ca.NE()) {
            i(ca);
        }
    }

    @Override // com.baidu.swan.config.a
    public void am(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b ca = com.baidu.swan.pms.f.d.ca(jSONObject);
        if (ca != null && ca.NE()) {
            i(ca);
        }
    }

    @Override // com.baidu.swan.config.a
    public String SH() {
        return com.baidu.swan.apps.extcore.b.ez(0);
    }

    @Override // com.baidu.swan.config.a
    public String SJ() {
        return com.baidu.swan.apps.extcore.b.ez(1);
    }

    @Override // com.baidu.swan.config.a
    public CookieManager SK() {
        return com.baidu.swan.apps.w.a.Se().Gd();
    }

    private void h(com.baidu.swan.pms.model.d dVar) {
        if (dVar != null) {
            g SP = dVar.category == 1 ? SP() : SO();
            SP.MW();
            e eVar = new e();
            eVar.a(dVar, PMSPkgStatus.WAIT);
            SP.a(eVar);
            com.baidu.swan.pms.c.a.a.a(dVar, SP);
        }
    }

    private void i(com.baidu.swan.pms.model.b bVar) {
        if (bVar != null) {
            g SP = bVar.category == 1 ? SP() : SO();
            SP.MW();
            e eVar = new e();
            eVar.a(bVar, PMSPkgStatus.WAIT);
            SP.a(eVar);
            com.baidu.swan.pms.c.a.a.a(bVar, SP);
        }
    }

    private i SO() {
        return new i() { // from class: com.baidu.swan.apps.w.a.c.1
            @Override // com.baidu.swan.apps.core.pms.k
            protected void No() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.aO(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void Nn() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }

    private com.baidu.swan.games.j.b.a SP() {
        return new com.baidu.swan.games.j.b.a() { // from class: com.baidu.swan.apps.w.a.c.2
            @Override // com.baidu.swan.apps.core.pms.k
            protected void No() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.aO(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void Nn() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }
}
