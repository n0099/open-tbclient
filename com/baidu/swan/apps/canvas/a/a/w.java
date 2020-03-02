package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class w extends a {
    private float bgX;
    private float bgY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.bgX = (float) jSONArray.optDouble(0);
            this.bgY = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bgX > 0.0f && this.bgY > 0.0f) {
            if (bVar.Kq() == 0) {
                bVar.ec(canvas.save());
            }
            canvas.scale(this.bgX, this.bgY);
        }
    }
}
