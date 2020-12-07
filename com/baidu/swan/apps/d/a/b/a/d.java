package com.baidu.swan.apps.d.a.b.a;

import org.json.JSONObject;
/* loaded from: classes25.dex */
public class d {
    private com.baidu.swan.apps.b.a.b cBZ;

    public static d alT() {
        return a.cCa;
    }

    public void hK(int i) {
        if (this.cBZ != null) {
            this.cBZ.hK(i);
            this.cBZ = null;
        }
    }

    public void az(JSONObject jSONObject) {
        if (this.cBZ != null) {
            this.cBZ.az(jSONObject);
            this.cBZ = null;
        }
    }

    /* loaded from: classes25.dex */
    private static class a {
        private static final d cCa = new d();
    }
}
