package com.baidu.swan.apps.d.a.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.swan.apps.b.a.b cit;

    public static d aeZ() {
        return a.ciu;
    }

    public void gV(int i) {
        if (this.cit != null) {
            this.cit.gV(i);
            this.cit = null;
        }
    }

    public void au(JSONObject jSONObject) {
        if (this.cit != null) {
            this.cit.au(jSONObject);
            this.cit = null;
        }
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final d ciu = new d();
    }
}
