package com.baidu.swan.pms.node.b;

import com.baidu.swan.c.i;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    private static volatile g exe;
    private a exf = new a();

    public static g bdJ() {
        if (exe == null) {
            synchronized (g.class) {
                if (exe == null) {
                    exe = new g();
                }
            }
        }
        return exe;
    }

    private g() {
    }

    public String getVersion() {
        return this.exf.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cV(JSONObject jSONObject) {
        f cW;
        if (jSONObject != null && (cW = f.cW(jSONObject)) != null) {
            com.baidu.swan.pms.d.bcr().a(cW);
        }
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.exf.edit().putString("version", fVar.getVersion()).apply();
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
