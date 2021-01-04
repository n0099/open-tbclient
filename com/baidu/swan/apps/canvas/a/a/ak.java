package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes9.dex */
class ak implements Cloneable {
    i cMC;
    int cMO;
    int cMP;
    int cMQ;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        z(jSONArray);
    }

    public boolean isValid() {
        return this.cMC != null && this.cMC.isValid();
    }

    public void z(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.cMO = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(0));
                this.cMP = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
                this.cMQ = jSONArray.optInt(2);
                this.cMC = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
