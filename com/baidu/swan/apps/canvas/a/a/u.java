package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class u extends a {
    private float aGA;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.aGA = (float) jSONArray.optDouble(0);
            this.aGA = (float) Math.toDegrees(this.aGA);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.CS() == 0) {
            bVar.cN(canvas.save());
        }
        canvas.rotate(this.aGA);
    }
}
