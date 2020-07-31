package com.baidu.swan.apps.c.a.b.a;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    private com.baidu.swan.apps.b.a.b bOB;

    public static d Vy() {
        return a.bOC;
    }

    public void er(int i) {
        if (this.bOB != null) {
            this.bOB.er(i);
            this.bOB = null;
        }
    }

    public void ai(JSONObject jSONObject) {
        if (this.bOB != null) {
            this.bOB.ai(jSONObject);
            this.bOB = null;
        }
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static final d bOC = new d();
    }
}
