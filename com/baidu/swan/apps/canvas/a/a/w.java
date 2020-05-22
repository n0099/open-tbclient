package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class w extends a {
    private float bOt;
    private float bOu;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.bOt = (float) jSONArray.optDouble(0);
            this.bOu = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bOt > 0.0f && this.bOu > 0.0f) {
            if (bVar.US() == 0) {
                bVar.eq(canvas.save());
            }
            canvas.scale(this.bOt, this.bOu);
        }
    }
}
