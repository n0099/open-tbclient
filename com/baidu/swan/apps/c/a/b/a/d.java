package com.baidu.swan.apps.c.a.b.a;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    private com.baidu.swan.apps.b.a.b aXt;

    public static d GM() {
        return a.aXu;
    }

    public void dG(int i) {
        if (this.aXt != null) {
            this.aXt.dG(i);
            this.aXt = null;
        }
    }

    public void L(JSONObject jSONObject) {
        if (this.aXt != null) {
            this.aXt.L(jSONObject);
            this.aXt = null;
        }
    }

    /* loaded from: classes9.dex */
    private static class a {
        private static final d aXu = new d();
    }
}
