package com.baidu.swan.pms.node.b;

import com.baidu.swan.c.i;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class g {
    private static volatile g dGO;
    private a dGP = new a();

    public static g aUG() {
        if (dGO == null) {
            synchronized (g.class) {
                if (dGO == null) {
                    dGO = new g();
                }
            }
        }
        return dGO;
    }

    private g() {
    }

    public String getVersion() {
        return this.dGP.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cz(JSONObject jSONObject) {
        f cA;
        if (jSONObject != null && (cA = f.cA(jSONObject)) != null) {
            com.baidu.swan.pms.d.aTn().a(cA);
        }
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.dGP.edit().putString("version", fVar.getVersion()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class a extends i {
        private a() {
            super("swan_preload_package");
        }
    }
}
