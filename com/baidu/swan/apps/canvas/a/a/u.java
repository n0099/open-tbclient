package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class u extends a {
    private float alV;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.alV = (float) jSONArray.optDouble(0);
            this.alV = (float) Math.toDegrees(this.alV);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.wy() == 0) {
            bVar.bQ(canvas.save());
        }
        canvas.rotate(this.alV);
    }
}
