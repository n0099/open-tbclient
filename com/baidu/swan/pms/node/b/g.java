package com.baidu.swan.pms.node.b;

import com.baidu.swan.c.i;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class g {
    private static volatile g dIS;
    private a dIT = new a();

    public static g aVs() {
        if (dIS == null) {
            synchronized (g.class) {
                if (dIS == null) {
                    dIS = new g();
                }
            }
        }
        return dIS;
    }

    private g() {
    }

    public String getVersion() {
        return this.dIT.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cC(JSONObject jSONObject) {
        f cD;
        if (jSONObject != null && (cD = f.cD(jSONObject)) != null) {
            com.baidu.swan.pms.d.aTZ().a(cD);
        }
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.dIT.edit().putString("version", fVar.getVersion()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public static class a extends i {
        private a() {
            super("swan_preload_package");
        }
    }
}
