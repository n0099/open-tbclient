package com.baidu.swan.apps.canvas.a.a;

import org.json.JSONArray;
/* loaded from: classes2.dex */
class ak implements Cloneable {
    int anA;
    int anB;
    i anl;
    int anz;

    public ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(JSONArray jSONArray) {
        f(jSONArray);
    }

    public boolean isValid() {
        return this.anl != null && this.anl.isValid();
    }

    public void f(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.anz = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
                this.anA = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
                this.anB = jSONArray.optInt(2);
                this.anl = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
