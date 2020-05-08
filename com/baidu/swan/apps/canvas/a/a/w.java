package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class w extends a {
    private float bFB;
    private float bFC;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.bFB = (float) jSONArray.optDouble(0);
            this.bFC = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bFB > 0.0f && this.bFC > 0.0f) {
            if (bVar.Sg() == 0) {
                bVar.eh(canvas.save());
            }
            canvas.scale(this.bFB, this.bFC);
        }
    }
}
