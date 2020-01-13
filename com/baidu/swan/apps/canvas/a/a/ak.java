package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes10.dex */
class ak implements Cloneable {
    i bcJ;
    int bcW;
    int mOffsetX;
    int mOffsetY;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        u(jSONArray);
    }

    public boolean isValid() {
        return this.bcJ != null && this.bcJ.isValid();
    }

    public void u(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.mOffsetX = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(0));
                this.mOffsetY = com.baidu.swan.apps.as.af.S((float) jSONArray.optDouble(1));
                this.bcW = jSONArray.optInt(2);
                this.bcJ = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
