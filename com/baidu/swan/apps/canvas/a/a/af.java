package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class af extends a {
    private ak cbm;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        this.cbm = new ak(jSONArray);
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cbm != null && this.cbm.isValid()) {
            bVar.cbm = this.cbm;
        }
    }
}
