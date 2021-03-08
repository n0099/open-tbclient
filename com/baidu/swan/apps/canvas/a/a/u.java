package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class u extends a {
    private float cLF;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cLF = (float) jSONArray.optDouble(0);
            this.cLF = (float) Math.toDegrees(this.cLF);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.akR() == 0) {
            bVar.gq(canvas.save());
        }
        canvas.rotate(this.cLF);
    }
}
