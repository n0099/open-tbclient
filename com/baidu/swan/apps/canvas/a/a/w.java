package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class w extends a {
    private float aGB;
    private float aGC;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.aGB = (float) jSONArray.optDouble(0);
            this.aGC = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.aGB > 0.0f && this.aGC > 0.0f) {
            if (bVar.CS() == 0) {
                bVar.cN(canvas.save());
            }
            canvas.scale(this.aGB, this.aGC);
        }
    }
}
