package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class w extends a {
    private float bTh;
    private float bTi;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.bTh = (float) jSONArray.optDouble(0);
            this.bTi = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bTh > 0.0f && this.bTi > 0.0f) {
            if (bVar.VY() == 0) {
                bVar.eD(canvas.save());
            }
            canvas.scale(this.bTh, this.bTi);
        }
    }
}
