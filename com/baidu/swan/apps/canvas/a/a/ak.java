package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes2.dex */
class ak implements Cloneable {
    int amA;
    i amk;
    int amy;
    int amz;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        f(jSONArray);
    }

    public boolean isValid() {
        return this.amk != null && this.amk.isValid();
    }

    public void f(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.amy = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
                this.amz = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
                this.amA = jSONArray.optInt(2);
                this.amk = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
