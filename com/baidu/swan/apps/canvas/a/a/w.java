package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class w extends a {
    private float cHK;
    private float cHL;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cHK = (float) jSONArray.optDouble(0);
            this.cHL = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.amZ() == 0) {
            bVar.hY(canvas.save());
        }
        canvas.scale(this.cHK, this.cHL);
    }
}
