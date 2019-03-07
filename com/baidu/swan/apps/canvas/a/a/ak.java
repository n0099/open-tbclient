package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes2.dex */
class ak implements Cloneable {
    i alS;
    int amg;
    int amh;
    int ami;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        h(jSONArray);
    }

    public boolean isValid() {
        return this.alS != null && this.alS.isValid();
    }

    public void h(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.amg = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
                this.amh = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
                this.ami = jSONArray.optInt(2);
                this.alS = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.c.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
