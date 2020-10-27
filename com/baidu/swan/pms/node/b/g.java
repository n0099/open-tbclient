package com.baidu.swan.pms.node.b;

import com.baidu.swan.c.i;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class g {
    private static volatile g edp;
    private a edq = new a();

    public static g aZU() {
        if (edp == null) {
            synchronized (g.class) {
                if (edp == null) {
                    edp = new g();
                }
            }
        }
        return edp;
    }

    private g() {
    }

    public String getVersion() {
        return this.edq.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cM(JSONObject jSONObject) {
        f cN;
        if (jSONObject != null && (cN = f.cN(jSONObject)) != null) {
            com.baidu.swan.pms.d.aYB().a(cN);
        }
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.edq.edit().putString("version", fVar.getVersion()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a extends i {
        private a() {
            super("swan_preload_package");
        }
    }
}
