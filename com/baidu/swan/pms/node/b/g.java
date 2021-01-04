package com.baidu.swan.pms.node.b;

import com.baidu.swan.c.i;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    private static volatile g eyl;
    private a eyn = new a();

    public static g bhn() {
        if (eyl == null) {
            synchronized (g.class) {
                if (eyl == null) {
                    eyl = new g();
                }
            }
        }
        return eyl;
    }

    private g() {
    }

    public String getVersion() {
        return this.eyn.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cW(JSONObject jSONObject) {
        f cX;
        if (jSONObject != null && (cX = f.cX(jSONObject)) != null) {
            com.baidu.swan.pms.d.bfV().a(cX);
        }
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.eyn.edit().putString("version", fVar.getVersion()).apply();
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
