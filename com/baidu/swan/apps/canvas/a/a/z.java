package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class z extends a {
    private float bZK = -1.0f;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bZK = (float) jSONArray.optDouble(0);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bZK >= 0.0f && this.bZK <= 1.0f) {
            bVar.bZi = (int) (this.bZK * 255.0f);
        }
    }
}
