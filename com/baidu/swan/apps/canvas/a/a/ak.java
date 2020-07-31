package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes7.dex */
class ak implements Cloneable {
    i bUb;
    int bUo;
    int mOffsetX;
    int mOffsetY;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        x(jSONArray);
    }

    public boolean isValid() {
        return this.bUb != null && this.bUb.isValid();
    }

    public void x(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.mOffsetX = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(0));
                this.mOffsetY = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(1));
                this.bUo = jSONArray.optInt(2);
                this.bUb = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
