package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class w extends a {
    private float cKg;
    private float cKh;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cKg = (float) jSONArray.optDouble(0);
            this.cKh = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.akO() == 0) {
            bVar.gp(canvas.save());
        }
        canvas.scale(this.cKg, this.cKh);
    }
}
