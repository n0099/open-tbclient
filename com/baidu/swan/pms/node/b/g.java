package com.baidu.swan.pms.node.b;

import com.baidu.swan.c.i;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    private static volatile g eoC;
    private a eoD = new a();

    public static g beS() {
        if (eoC == null) {
            synchronized (g.class) {
                if (eoC == null) {
                    eoC = new g();
                }
            }
        }
        return eoC;
    }

    private g() {
    }

    public String getVersion() {
        return this.eoD.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cO(JSONObject jSONObject) {
        f cP;
        if (jSONObject != null && (cP = f.cP(jSONObject)) != null) {
            com.baidu.swan.pms.d.bdz().a(cP);
        }
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.eoD.edit().putString("version", fVar.getVersion()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends i {
        private a() {
            super("swan_preload_package");
        }
    }
}
