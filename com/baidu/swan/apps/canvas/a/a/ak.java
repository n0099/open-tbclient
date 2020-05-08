package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes11.dex */
class ak implements Cloneable {
    i bFD;
    int bFQ;
    int mOffsetX;
    int mOffsetY;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        v(jSONArray);
    }

    public boolean isValid() {
        return this.bFD != null && this.bFD.isValid();
    }

    public void v(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.mOffsetX = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(0));
                this.mOffsetY = com.baidu.swan.apps.as.af.C((float) jSONArray.optDouble(1));
                this.bFQ = jSONArray.optInt(2);
                this.bFD = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
