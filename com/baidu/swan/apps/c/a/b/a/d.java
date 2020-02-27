package com.baidu.swan.apps.c.a.b.a;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.swan.apps.b.a.b bcv;

    public static d Jx() {
        return a.bcw;
    }

    public void dX(int i) {
        if (this.bcv != null) {
            this.bcv.dX(i);
            this.bcv = null;
        }
    }

    public void L(JSONObject jSONObject) {
        if (this.bcv != null) {
            this.bcv.L(jSONObject);
            this.bcv = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final d bcw = new d();
    }
}
