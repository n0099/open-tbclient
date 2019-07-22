package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class u extends a {
    private float amK;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.amK = (float) jSONArray.optDouble(0);
            this.amK = (float) Math.toDegrees(this.amK);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.xT() == 0) {
            bVar.bQ(canvas.save());
        }
        canvas.rotate(this.amK);
    }
}
