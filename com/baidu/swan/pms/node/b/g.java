package com.baidu.swan.pms.node.b;

import com.baidu.swan.c.i;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class g {
    private static volatile g ejh;
    private a eji = new a();

    public static g bcu() {
        if (ejh == null) {
            synchronized (g.class) {
                if (ejh == null) {
                    ejh = new g();
                }
            }
        }
        return ejh;
    }

    private g() {
    }

    public String getVersion() {
        return this.eji.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cS(JSONObject jSONObject) {
        f cT;
        if (jSONObject != null && (cT = f.cT(jSONObject)) != null) {
            com.baidu.swan.pms.d.bbb().a(cT);
        }
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.eji.edit().putString("version", fVar.getVersion()).apply();
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
