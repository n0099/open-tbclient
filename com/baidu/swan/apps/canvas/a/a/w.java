package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class w extends a {
    private float aGj;
    private float aGk;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.aGj = (float) jSONArray.optDouble(0);
            this.aGk = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.aGj > 0.0f && this.aGk > 0.0f) {
            if (bVar.CT() == 0) {
                bVar.cN(canvas.save());
            }
            canvas.scale(this.aGj, this.aGk);
        }
    }
}
