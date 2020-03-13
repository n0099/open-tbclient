package com.baidu.swan.apps.c.a.b.a;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.swan.apps.b.a.b bcx;

    public static d Jz() {
        return a.bcy;
    }

    public void dX(int i) {
        if (this.bcx != null) {
            this.bcx.dX(i);
            this.bcx = null;
        }
    }

    public void L(JSONObject jSONObject) {
        if (this.bcx != null) {
            this.bcx.L(jSONObject);
            this.bcx = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final d bcy = new d();
    }
}
