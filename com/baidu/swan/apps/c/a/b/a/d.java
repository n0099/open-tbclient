package com.baidu.swan.apps.c.a.b.a;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.swan.apps.b.a.b bIX;

    public static d TN() {
        return a.bIY;
    }

    public void ek(int i) {
        if (this.bIX != null) {
            this.bIX.ek(i);
            this.bIX = null;
        }
    }

    public void ab(JSONObject jSONObject) {
        if (this.bIX != null) {
            this.bIX.ab(jSONObject);
            this.bIX = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final d bIY = new d();
    }
}
