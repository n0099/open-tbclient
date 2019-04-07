package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class u extends a {
    private float alU;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.alU = (float) jSONArray.optDouble(0);
            this.alU = (float) Math.toDegrees(this.alU);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.wy() == 0) {
            bVar.bQ(canvas.save());
        }
        canvas.rotate(this.alU);
    }
}
