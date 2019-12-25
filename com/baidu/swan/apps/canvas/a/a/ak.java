package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes9.dex */
class ak implements Cloneable {
    i bbT;
    int bcg;
    int bch;
    int mOffsetY;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        t(jSONArray);
    }

    public boolean isValid() {
        return this.bbT != null && this.bbT.isValid();
    }

    public void t(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.bcg = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(0));
                this.mOffsetY = com.baidu.swan.apps.as.af.T((float) jSONArray.optDouble(1));
                this.bch = jSONArray.optInt(2);
                this.bbT = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
