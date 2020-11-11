package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class af extends a {
    private ak cBY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        this.cBY = new ak(jSONArray);
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cBY != null && this.cBY.isValid()) {
            bVar.cBY = this.cBY;
        }
    }
}
