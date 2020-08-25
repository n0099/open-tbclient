package com.baidu.swan.pms.node.b;

import com.baidu.swan.c.i;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class g {
    private static volatile g dGK;
    private a dGL = new a();

    public static g aUG() {
        if (dGK == null) {
            synchronized (g.class) {
                if (dGK == null) {
                    dGK = new g();
                }
            }
        }
        return dGK;
    }

    private g() {
    }

    public String getVersion() {
        return this.dGL.getString("version", "0");
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
            this.dGL.edit().putString("version", fVar.getVersion()).apply();
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
