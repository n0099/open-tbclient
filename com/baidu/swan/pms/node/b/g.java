package com.baidu.swan.pms.node.b;

import com.baidu.swan.e.j;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
    private static volatile g drN;
    private a drO = new a();

    public static g aIp() {
        if (drN == null) {
            synchronized (g.class) {
                if (drN == null) {
                    drN = new g();
                }
            }
        }
        return drN;
    }

    private g() {
    }

    public String getVersion() {
        return this.drO.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void co(JSONObject jSONObject) {
        f cp;
        if (jSONObject != null && (cp = f.cp(jSONObject)) != null) {
            com.baidu.swan.pms.d.aGV().a(cp);
        }
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.drO.edit().putString("version", fVar.getVersion()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends j {
        private a() {
            super("swan_preload_package");
        }
    }
}
