package com.baidu.swan.pms.node.b;

import com.baidu.swan.d.i;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class g {
    private static volatile g dxE;
    private a dxF = new a();

    public static g aMh() {
        if (dxE == null) {
            synchronized (g.class) {
                if (dxE == null) {
                    dxE = new g();
                }
            }
        }
        return dxE;
    }

    private g() {
    }

    public String getVersion() {
        return this.dxF.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cu(JSONObject jSONObject) {
        f cv;
        if (jSONObject != null && (cv = f.cv(jSONObject)) != null) {
            com.baidu.swan.pms.d.aKM().a(cv);
        }
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.dxF.edit().putString("version", fVar.getVersion()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public static class a extends i {
        private a() {
            super("swan_preload_package");
        }
    }
}
