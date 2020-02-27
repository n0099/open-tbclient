package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes11.dex */
class ak implements Cloneable {
    i bgY;
    int bhl;
    int mOffsetX;
    int mOffsetY;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        u(jSONArray);
    }

    public boolean isValid() {
        return this.bgY != null && this.bgY.isValid();
    }

    public void u(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.mOffsetX = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(0));
                this.mOffsetY = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(1));
                this.bhl = jSONArray.optInt(2);
                this.bgY = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
