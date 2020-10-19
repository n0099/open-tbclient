package com.baidu.swan.pms.node.b;

import com.baidu.swan.c.i;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class g {
    private static volatile g dUT;
    private a dUU = new a();

    public static g aYb() {
        if (dUT == null) {
            synchronized (g.class) {
                if (dUT == null) {
                    dUT = new g();
                }
            }
        }
        return dUT;
    }

    private g() {
    }

    public String getVersion() {
        return this.dUU.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cJ(JSONObject jSONObject) {
        f cK;
        if (jSONObject != null && (cK = f.cK(jSONObject)) != null) {
            com.baidu.swan.pms.d.aWI().a(cK);
        }
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.dUU.edit().putString("version", fVar.getVersion()).apply();
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
