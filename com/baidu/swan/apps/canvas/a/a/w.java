package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class w extends a {
    private float bFw;
    private float bFx;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.bFw = (float) jSONArray.optDouble(0);
            this.bFx = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bFw > 0.0f && this.bFx > 0.0f) {
            if (bVar.Sh() == 0) {
                bVar.eh(canvas.save());
            }
            canvas.scale(this.bFw, this.bFx);
        }
    }
}
