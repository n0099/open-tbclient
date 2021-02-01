package com.baidu.swan.apps.d.a.b.a;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    private com.baidu.swan.apps.b.a.b cEz;

    public static d ajI() {
        return a.cEA;
    }

    public void ga(int i) {
        if (this.cEz != null) {
            this.cEz.ga(i);
            this.cEz = null;
        }
    }

    public void aE(JSONObject jSONObject) {
        if (this.cEz != null) {
            this.cEz.aE(jSONObject);
            this.cEz = null;
        }
    }

    /* loaded from: classes9.dex */
    private static class a {
        private static final d cEA = new d();
    }
}
