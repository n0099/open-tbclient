package com.baidu.swan.apps.d.a.b.a;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    private com.baidu.swan.apps.b.a.b cGP;

    public static d ane() {
        return a.cGQ;
    }

    public void hE(int i) {
        if (this.cGP != null) {
            this.cGP.hE(i);
            this.cGP = null;
        }
    }

    public void aH(JSONObject jSONObject) {
        if (this.cGP != null) {
            this.cGP.aH(jSONObject);
            this.cGP = null;
        }
    }

    /* loaded from: classes9.dex */
    private static class a {
        private static final d cGQ = new d();
    }
}
