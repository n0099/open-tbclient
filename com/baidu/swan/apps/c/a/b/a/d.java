package com.baidu.swan.apps.c.a.b.a;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.swan.apps.b.a.b bcw;

    public static d Jz() {
        return a.bcx;
    }

    public void dX(int i) {
        if (this.bcw != null) {
            this.bcw.dX(i);
            this.bcw = null;
        }
    }

    public void L(JSONObject jSONObject) {
        if (this.bcw != null) {
            this.bcw.L(jSONObject);
            this.bcw = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final d bcx = new d();
    }
}
