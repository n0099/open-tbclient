package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class u extends a {
    private float aGi;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.aGi = (float) jSONArray.optDouble(0);
            this.aGi = (float) Math.toDegrees(this.aGi);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.CT() == 0) {
            bVar.cN(canvas.save());
        }
        canvas.rotate(this.aGi);
    }
}
