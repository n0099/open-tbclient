package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes2.dex */
class ak implements Cloneable {
    i amN;
    int anb;
    int anc;
    int and;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        f(jSONArray);
    }

    public boolean isValid() {
        return this.amN != null && this.amN.isValid();
    }

    public void f(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.anb = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
                this.anc = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
                this.and = jSONArray.optInt(2);
                this.amN = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
