package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes2.dex */
class ak implements Cloneable {
    i aGD;
    int aGQ;
    int aGR;
    int aGS;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        n(jSONArray);
    }

    public boolean isValid() {
        return this.aGD != null && this.aGD.isValid();
    }

    public void n(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.aGQ = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(0));
                this.aGR = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1));
                this.aGS = jSONArray.optInt(2);
                this.aGD = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
