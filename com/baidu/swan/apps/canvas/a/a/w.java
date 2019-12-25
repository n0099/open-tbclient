package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class w extends a {
    private float bbR;
    private float bbS;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.bbR = (float) jSONArray.optDouble(0);
            this.bbS = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bbR > 0.0f && this.bbS > 0.0f) {
            if (bVar.HD() == 0) {
                bVar.dL(canvas.save());
            }
            canvas.scale(this.bbR, this.bbS);
        }
    }
}
