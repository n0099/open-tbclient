package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class w extends a {
    private float bgW;
    private float bgX;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.bgW = (float) jSONArray.optDouble(0);
            this.bgX = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bgW > 0.0f && this.bgX > 0.0f) {
            if (bVar.Ko() == 0) {
                bVar.ec(canvas.save());
            }
            canvas.scale(this.bgW, this.bgX);
        }
    }
}
