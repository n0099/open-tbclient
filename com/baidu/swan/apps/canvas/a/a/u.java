package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class u extends a {
    private float cHN;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cHN = (float) jSONArray.optDouble(0);
            this.cHN = (float) Math.toDegrees(this.cHN);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.akq() == 0) {
            bVar.gl(canvas.save());
        }
        canvas.rotate(this.cHN);
    }
}
