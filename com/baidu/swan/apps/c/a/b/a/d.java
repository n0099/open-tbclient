package com.baidu.swan.apps.c.a.b.a;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.swan.apps.b.a.b bNL;

    public static d UT() {
        return a.bNM;
    }

    public void ev(int i) {
        if (this.bNL != null) {
            this.bNL.ev(i);
            this.bNL = null;
        }
    }

    public void ai(JSONObject jSONObject) {
        if (this.bNL != null) {
            this.bNL.ai(jSONObject);
            this.bNL = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final d bNM = new d();
    }
}
