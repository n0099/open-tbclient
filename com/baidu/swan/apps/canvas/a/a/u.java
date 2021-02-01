package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class u extends a {
    private float cKf;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cKf = (float) jSONArray.optDouble(0);
            this.cKf = (float) Math.toDegrees(this.cKf);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.akO() == 0) {
            bVar.gp(canvas.save());
        }
        canvas.rotate(this.cKf);
    }
}
