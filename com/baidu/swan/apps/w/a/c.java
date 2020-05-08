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
    private static int bWu = -1;

    @Override // com.baidu.swan.config.a
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.config.a
    public String acU() {
        return com.baidu.swan.apps.w.a.abZ().PS();
    }

    @Override // com.baidu.swan.config.a
    public String acJ() {
        return com.baidu.swan.apps.w.a.abS().aS(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.config.a
    public String getUUID() {
        return com.baidu.swan.uuid.b.di(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.config.a
    public String acK() {
        return com.baidu.swan.apps.w.a.acy().getHostName();
    }

    @Override // com.baidu.swan.config.a
    public String acL() {
        return ai.getVersionName();
    }

    @Override // com.baidu.swan.config.a
    public String acM() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.config.a
    public String acN() {
        return com.baidu.swan.apps.swancore.b.gF(0);
    }

    @Override // com.baidu.swan.config.a
    public String acP() {
        return com.baidu.swan.apps.swancore.b.gF(1);
    }

    @Override // com.baidu.swan.config.a
    public void au(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d ck = com.baidu.swan.pms.f.d.ck(jSONObject);
        if (ck != null && ck.XL()) {
            h(ck);
        }
    }

    @Override // com.baidu.swan.config.a
    public void av(JSONObject jSONObject) {
        com.baidu.swan.pms.model.d ck = com.baidu.swan.pms.f.d.ck(jSONObject);
        if (ck != null && ck.XL()) {
            h(ck);
        }
    }

    @Override // com.baidu.swan.config.a
    public void aw(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b cl = com.baidu.swan.pms.f.d.cl(jSONObject);
        if (cl != null && cl.XL()) {
            i(cl);
        }
    }

    @Override // com.baidu.swan.config.a
    public void ax(JSONObject jSONObject) {
        com.baidu.swan.pms.model.b cl = com.baidu.swan.pms.f.d.cl(jSONObject);
        if (cl != null && cl.XL()) {
            i(cl);
        }
    }

    @Override // com.baidu.swan.config.a
    public String acO() {
        return com.baidu.swan.apps.extcore.b.eU(0);
    }

    @Override // com.baidu.swan.config.a
    public String acQ() {
        return com.baidu.swan.apps.extcore.b.eU(1);
    }

    @Override // com.baidu.swan.config.a
    public CookieManager acR() {
        return com.baidu.swan.apps.w.a.acl().Qi();
    }

    private void h(com.baidu.swan.pms.model.d dVar) {
        if (dVar != null) {
            g acW = dVar.category == 1 ? acW() : acV();
            acW.Xd();
            e eVar = new e();
            eVar.a(dVar, PMSPkgStatus.WAIT);
            acW.a(eVar);
            com.baidu.swan.pms.c.a.a.a(dVar, acW);
        }
    }

    private void i(com.baidu.swan.pms.model.b bVar) {
        if (bVar != null) {
            g acW = bVar.category == 1 ? acW() : acV();
            acW.Xd();
            e eVar = new e();
            eVar.a(bVar, PMSPkgStatus.WAIT);
            acW.a(eVar);
            com.baidu.swan.pms.c.a.a.a(bVar, acW);
        }
    }

    private i acV() {
        return new i() { // from class: com.baidu.swan.apps.w.a.c.1
            @Override // com.baidu.swan.apps.core.pms.k
            protected void Xv() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.bx(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void Xu() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }

    private com.baidu.swan.games.j.b.a acW() {
        return new com.baidu.swan.games.j.b.a() { // from class: com.baidu.swan.apps.w.a.c.2
            @Override // com.baidu.swan.apps.core.pms.k
            protected void Xv() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateFailed");
                }
                com.baidu.swan.config.core.c.bx(0L);
            }

            @Override // com.baidu.swan.apps.core.pms.k
            protected void Xu() {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("SwanConfigImpl", "onUpdateSuccess");
                }
            }
        };
    }
}
