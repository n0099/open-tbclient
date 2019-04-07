package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class w extends a {
    private float alV;
    private float alW;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.alV = (float) jSONArray.optDouble(0);
            this.alW = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alV > 0.0f && this.alW > 0.0f) {
            if (bVar.wy() == 0) {
                bVar.bQ(canvas.save());
            }
            canvas.scale(this.alV, this.alW);
        }
    }
}
