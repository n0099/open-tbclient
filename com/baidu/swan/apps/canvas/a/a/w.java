package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class w extends a {
    private float bcH;
    private float bcI;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.bcH = (float) jSONArray.optDouble(0);
            this.bcI = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bcH > 0.0f && this.bcI > 0.0f) {
            if (bVar.HZ() == 0) {
                bVar.dM(canvas.save());
            }
            canvas.scale(this.bcH, this.bcI);
        }
    }
}
