package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes25.dex */
class ak implements Cloneable {
    i cHM;
    int cHY;
    int cHZ;
    int mOffsetY;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        z(jSONArray);
    }

    public boolean isValid() {
        return this.cHM != null && this.cHM.isValid();
    }

    public void z(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.cHY = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(0));
                this.mOffsetY = com.baidu.swan.apps.ap.ah.M((float) jSONArray.optDouble(1));
                this.cHZ = jSONArray.optInt(2);
                this.cHM = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
