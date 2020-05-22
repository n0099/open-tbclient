package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes11.dex */
class ak implements Cloneable {
    int bOI;
    i bOv;
    int mOffsetX;
    int mOffsetY;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        w(jSONArray);
    }

    public boolean isValid() {
        return this.bOv != null && this.bOv.isValid();
    }

    public void w(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.mOffsetX = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(0));
                this.mOffsetY = com.baidu.swan.apps.aq.ag.B((float) jSONArray.optDouble(1));
                this.bOI = jSONArray.optInt(2);
                this.bOv = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
