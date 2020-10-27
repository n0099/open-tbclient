package com.baidu.swan.apps.d.a.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.swan.apps.b.a.b cqT;

    public static d agT() {
        return a.cqU;
    }

    public void hg(int i) {
        if (this.cqT != null) {
            this.cqT.hg(i);
            this.cqT = null;
        }
    }

    public void ax(JSONObject jSONObject) {
        if (this.cqT != null) {
            this.cqT.ax(jSONObject);
            this.cqT = null;
        }
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final d cqU = new d();
    }
}
