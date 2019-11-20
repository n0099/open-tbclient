package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes2.dex */
class ak implements Cloneable {
    int aGA;
    i aGl;
    int aGy;
    int aGz;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        n(jSONArray);
    }

    public boolean isValid() {
        return this.aGl != null && this.aGl.isValid();
    }

    public void n(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.aGy = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(0));
                this.aGz = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1));
                this.aGA = jSONArray.optInt(2);
                this.aGl = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
