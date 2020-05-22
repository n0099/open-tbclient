package com.baidu.swan.pms.node.b;

import com.baidu.swan.e.j;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
    private static volatile g dnb;
    private a dnc = new a();

    public static g aHj() {
        if (dnb == null) {
            synchronized (g.class) {
                if (dnb == null) {
                    dnb = new g();
                }
            }
        }
        return dnb;
    }

    private g() {
    }

    public String getVersion() {
        return this.dnc.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ch(JSONObject jSONObject) {
        f ci;
        if (jSONObject != null && (ci = f.ci(jSONObject)) != null) {
            com.baidu.swan.pms.d.aFP().a(ci);
        }
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.dnc.edit().putString("version", fVar.getVersion()).apply();
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
