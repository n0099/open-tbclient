package com.baidu.swan.apps.d.a.b.a;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    private com.baidu.swan.apps.b.a.b cCd;

    public static d ajk() {
        return a.cCe;
    }

    public void fX(int i) {
        if (this.cCd != null) {
            this.cCd.fX(i);
            this.cCd = null;
        }
    }

    public void aH(JSONObject jSONObject) {
        if (this.cCd != null) {
            this.cCd.aH(jSONObject);
            this.cCd = null;
        }
    }

    /* loaded from: classes8.dex */
    private static class a {
        private static final d cCe = new d();
    }
}
