package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes9.dex */
class ak implements Cloneable {
    i cKi;
    int cKu;
    int mOffsetX;
    int mOffsetY;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        y(jSONArray);
    }

    public boolean isValid() {
        return this.cKi != null && this.cKi.isValid();
    }

    public void y(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.mOffsetX = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(0));
                this.mOffsetY = com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(1));
                this.cKu = jSONArray.optInt(2);
                this.cKi = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
