package com.baidu.swan.pms.node.b;

import com.baidu.swan.c.i;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    private static volatile g evD;
    private a evE = new a();

    public static g bdH() {
        if (evD == null) {
            synchronized (g.class) {
                if (evD == null) {
                    evD = new g();
                }
            }
        }
        return evD;
    }

    private g() {
    }

    public String getVersion() {
        return this.evE.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cT(JSONObject jSONObject) {
        f cU;
        if (jSONObject != null && (cU = f.cU(jSONObject)) != null) {
            com.baidu.swan.pms.d.bcp().a(cU);
        }
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.evE.edit().putString("version", fVar.getVersion()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends i {
        private a() {
            super("swan_preload_package");
        }
    }
}
