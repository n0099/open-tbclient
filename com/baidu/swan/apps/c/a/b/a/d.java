package com.baidu.swan.apps.c.a.b.a;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.swan.apps.b.a.b bcK;

    public static d JC() {
        return a.bcL;
    }

    public void dX(int i) {
        if (this.bcK != null) {
            this.bcK.dX(i);
            this.bcK = null;
        }
    }

    public void L(JSONObject jSONObject) {
        if (this.bcK != null) {
            this.bcK.L(jSONObject);
            this.bcK = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final d bcL = new d();
    }
}
