package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes2.dex */
class ak implements Cloneable {
    i alX;
    int aml;
    int amm;
    int amn;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        h(jSONArray);
    }

    public boolean isValid() {
        return this.alX != null && this.alX.isValid();
    }

    public void h(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.aml = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
                this.amm = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
                this.amn = jSONArray.optInt(2);
                this.alX = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
