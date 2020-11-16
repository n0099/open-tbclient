package com.baidu.swan.apps.d.a.b.a;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    private com.baidu.swan.apps.b.a.b cvh;

    public static d aiL() {
        return a.cvi;
    }

    public void hm(int i) {
        if (this.cvh != null) {
            this.cvh.hm(i);
            this.cvh = null;
        }
    }

    public void ax(JSONObject jSONObject) {
        if (this.cvh != null) {
            this.cvh.ax(jSONObject);
            this.cvh = null;
        }
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static final d cvi = new d();
    }
}
