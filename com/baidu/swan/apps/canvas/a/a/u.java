package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class u extends a {
    private float alP;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.alP = (float) jSONArray.optDouble(0);
            this.alP = (float) Math.toDegrees(this.alP);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.wz() == 0) {
            bVar.bR(canvas.save());
        }
        canvas.rotate(this.alP);
    }
}
