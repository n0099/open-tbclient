package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes2.dex */
class ak implements Cloneable {
    i alT;
    int amh;
    int ami;
    int amj;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        h(jSONArray);
    }

    public boolean isValid() {
        return this.alT != null && this.alT.isValid();
    }

    public void h(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.amh = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
                this.ami = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
                this.amj = jSONArray.optInt(2);
                this.alT = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
