package com.baidu.swan.apps.d.a.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.swan.apps.b.a.b cwR;

    public static d ajt() {
        return a.cwS;
    }

    public void hq(int i) {
        if (this.cwR != null) {
            this.cwR.hq(i);
            this.cwR = null;
        }
    }

    public void aD(JSONObject jSONObject) {
        if (this.cwR != null) {
            this.cwR.aD(jSONObject);
            this.cwR = null;
        }
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final d cwS = new d();
    }
}
