package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class w extends a {
    private float bhl;
    private float bhm;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.bhl = (float) jSONArray.optDouble(0);
            this.bhm = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bhl > 0.0f && this.bhm > 0.0f) {
            if (bVar.Kt() == 0) {
                bVar.ec(canvas.save());
            }
            canvas.scale(this.bhl, this.bhm);
        }
    }
}
