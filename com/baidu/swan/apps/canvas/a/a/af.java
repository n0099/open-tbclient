package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class af extends a {
    private ak cLX;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        this.cLX = new ak(jSONArray);
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cLX != null && this.cLX.isValid()) {
            bVar.cLX = this.cLX;
        }
    }
}
