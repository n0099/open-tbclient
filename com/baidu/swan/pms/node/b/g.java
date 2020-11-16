package com.baidu.swan.pms.node.b;

import com.baidu.swan.c.i;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    private static volatile g ehA;
    private a ehB = new a();

    public static g bbN() {
        if (ehA == null) {
            synchronized (g.class) {
                if (ehA == null) {
                    ehA = new g();
                }
            }
        }
        return ehA;
    }

    private g() {
    }

    public String getVersion() {
        return this.ehB.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cM(JSONObject jSONObject) {
        f cN;
        if (jSONObject != null && (cN = f.cN(jSONObject)) != null) {
            com.baidu.swan.pms.d.bau().a(cN);
        }
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.ehB.edit().putString("version", fVar.getVersion()).apply();
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
