package com.baidu.swan.apps.d.a.b.a;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    private com.baidu.swan.apps.b.a.b bUd;

    public static d abE() {
        return a.bUe;
    }

    public void gp(int i) {
        if (this.bUd != null) {
            this.bUd.gp(i);
            this.bUd = null;
        }
    }

    public void ak(JSONObject jSONObject) {
        if (this.bUd != null) {
            this.bUd.ak(jSONObject);
            this.bUd = null;
        }
    }

    /* loaded from: classes8.dex */
    private static class a {
        private static final d bUe = new d();
    }
}
