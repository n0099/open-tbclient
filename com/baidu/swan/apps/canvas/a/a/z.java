package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class z extends a {
    private float cMD = -1.0f;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cMD = (float) jSONArray.optDouble(0);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cMD >= 0.0f && this.cMD <= 1.0f) {
            bVar.cLY = (int) (this.cMD * 255.0f);
        }
    }
}
