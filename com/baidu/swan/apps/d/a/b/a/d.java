package com.baidu.swan.apps.d.a.b.a;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    private com.baidu.swan.apps.b.a.b cFZ;

    public static d ajL() {
        return a.cGa;
    }

    public void gb(int i) {
        if (this.cFZ != null) {
            this.cFZ.gb(i);
            this.cFZ = null;
        }
    }

    public void aG(JSONObject jSONObject) {
        if (this.cFZ != null) {
            this.cFZ.aG(jSONObject);
            this.cFZ = null;
        }
    }

    /* loaded from: classes8.dex */
    private static class a {
        private static final d cGa = new d();
    }
}
