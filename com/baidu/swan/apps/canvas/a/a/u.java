package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class u extends a {
    private float cMz;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cMz = (float) jSONArray.optDouble(0);
            this.cMz = (float) Math.toDegrees(this.cMz);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.aoj() == 0) {
            bVar.hS(canvas.save());
        }
        canvas.rotate(this.cMz);
    }
}
