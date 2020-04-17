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
    private static int bWo = -1;

    @Override // com.baidu.swan.config.a
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.config.a
    public String acV() {
        return com.baidu.swan.apps.w.a.aca().PT();
    }

    @Override // com.baidu.swan.config.a
    public String acK() {
        return com.baidu.swan.apps.w.a.abT().be(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.config.a
    public String getUUID() {
        return com.baidu.swan.uuid.b.du(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.config.a
    public String acL() {
        return com.baidu.swan.apps.w.a.acz().getHostName();
    }

    @Override // com.baidu.swan.config.a
    public String acM() {
        return ai.getVersionName();
    }

    @Override // com.baidu.swan.config.a
    public String acN() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.config.a
    public String acO() {
        return com.baidu.swan.apps.swancore.b.gF(0);
    }

    @Override // com.baidu.swan.config.a
    public String acQ() {
        return com.baidu.swan.apps.swancore.b.gF(1);
    }

    @Override // com.baidu.swan.config.a
    public void au(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d ck = com.baidu.swan.pms.f.d.ck(jSONObject);
        if (ck != null && ck.XM()) {
            h(ck);
        }
    }

    @Override // com.baidu.swan.config.a
    public void av(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d ck = com.baidu.swan.pms.f.d.ck(jSONObject);
        if (ck != null && ck.XM()) {
            h(ck);
        }
    }

    @Override // com.baidu.swan.config.a
    public void aw(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b cl = com.baidu.swan.pms.f.d.cl(jSONObject);
        if (cl != null && cl.XM()) {
            i(cl);
        }
    }

    @Override // com.baidu.swan.config.a
    public void ax(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b cl = com.baidu.swan.pms.f.d.cl(jSONObject);
        if (cl != null && cl.XM()) {
            i(cl);
        }
    }

    @Override // com.baidu.swan.config.a
    public String acP() {
        return com.baidu.swan.apps.extcore.b.eU(0);
    }

    @Override // com.baidu.swan.config.a
    public String acR() {
        return com.baidu.swan.apps.extcore.b.eU(1);
    }

    @Override // com.baidu.swan.config.a
    public CookieManager acS() {
        return com.baidu.swan.apps.w.a.acm().Qj();
    }

    private void h(com.baidu.swan.pms.model.d dVar) {
        if (dVar != null) {
            g acX = dVar.category == 1 ? acX() : acW();
            acX.Xe();
            e eVar = new e();
            eVar.a(dVar, PMSPkgStatus.WAIT);
            acX.a(eVar);
            com.baidu.swan.pms.c.a.a.a(dVar, acX);
        }
    }

    private void i(com.baidu.swan.pms.model.b bVar) {
        if (bVar != null) {
            g acX = bVar.category == 1 ? acX() : acW();
            acX.Xe();
            e eVar = new e();
            eVar.a(bVar, PMSPkgStatus.WAIT);
            acX.a(eVar);
            com.baidu.swan.pms.c.a.a.a(bVar, acX);
        }
    }

    private i acW() {
        return new i() { // from class: com.baidu.swan.apps.w.a.c.1
            @Override // com.baidu.swan.apps.core.pms.k
            protected void Xw() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.bx(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void Xv() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }

    private com.baidu.swan.games.j.b.a acX() {
        return new com.baidu.swan.games.j.b.a() { // from class: com.baidu.swan.apps.w.a.c.2
            @Override // com.baidu.swan.apps.core.pms.k
            protected void Xw() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.bx(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void Xv() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }
}
