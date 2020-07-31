package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class z extends a {
    private float bUc = -1.0f;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bUc = (float) jSONArray.optDouble(0);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bUc >= 0.0f && this.bUc <= 1.0f) {
            bVar.bTA = (int) (this.bUc * 255.0f);
        }
    }
}
