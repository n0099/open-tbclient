package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes8.dex */
class ak implements Cloneable {
    i cHQ;
    int cIc;
    int cId;
    int cIe;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        z(jSONArray);
    }

    public boolean isValid() {
        return this.cHQ != null && this.cHQ.isValid();
    }

    public void z(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.cIc = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(0));
                this.cId = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
                this.cIe = jSONArray.optInt(2);
                this.cHQ = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
