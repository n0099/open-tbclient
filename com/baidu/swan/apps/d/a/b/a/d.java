package com.baidu.swan.apps.d.a.b.a;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    private com.baidu.swan.apps.b.a.b bTZ;

    public static d abE() {
        return a.bUa;
    }

    public void gp(int i) {
        if (this.bTZ != null) {
            this.bTZ.gp(i);
            this.bTZ = null;
        }
    }

    public void ak(JSONObject jSONObject) {
        if (this.bTZ != null) {
            this.bTZ.ak(jSONObject);
            this.bTZ = null;
        }
    }

    /* loaded from: classes8.dex */
    private static class a {
        private static final d bUa = new d();
    }
}
