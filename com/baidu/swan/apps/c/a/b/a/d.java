package com.baidu.swan.apps.c.a.b.a;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.swan.apps.b.a.b bBd;

    public static d Rn() {
        return a.bBe;
    }

    public void ec(int i) {
        if (this.bBd != null) {
            this.bBd.ec(i);
            this.bBd = null;
        }
    }

    public void W(JSONObject jSONObject) {
        if (this.bBd != null) {
            this.bBd.W(jSONObject);
            this.bBd = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final d bBe = new d();
    }
}
