package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class w extends a {
    private float alR;
    private float alS;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.alR = (float) jSONArray.optDouble(0);
            this.alS = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alR > 0.0f && this.alS > 0.0f) {
            if (bVar.wz() == 0) {
                bVar.bR(canvas.save());
            }
            canvas.scale(this.alR, this.alS);
        }
    }
}
