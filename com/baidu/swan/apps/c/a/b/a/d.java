package com.baidu.swan.apps.c.a.b.a;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.swan.apps.b.a.b bAY;

    public static d Ro() {
        return a.bAZ;
    }

    public void ec(int i) {
        if (this.bAY != null) {
            this.bAY.ec(i);
            this.bAY = null;
        }
    }

    public void W(JSONObject jSONObject) {
        if (this.bAY != null) {
            this.bAY.W(jSONObject);
            this.bAY = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final d bAZ = new d();
    }
}
