package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes8.dex */
class ak implements Cloneable {
    i bZJ;
    int bZW;
    int mOffsetX;
    int mOffsetY;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        y(jSONArray);
    }

    public boolean isValid() {
        return this.bZJ != null && this.bZJ.isValid();
    }

    public void y(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.mOffsetX = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(0));
                this.mOffsetY = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(1));
                this.bZW = jSONArray.optInt(2);
                this.bZJ = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
