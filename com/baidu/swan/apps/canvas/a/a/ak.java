package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes10.dex */
class ak implements Cloneable {
    i cCA;
    int cCN;
    int mOffsetX;
    int mOffsetY;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        y(jSONArray);
    }

    public boolean isValid() {
        return this.cCA != null && this.cCA.isValid();
    }

    public void y(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.mOffsetX = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(0));
                this.mOffsetY = com.baidu.swan.apps.ap.ah.N((float) jSONArray.optDouble(1));
                this.cCN = jSONArray.optInt(2);
                this.cCA = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
