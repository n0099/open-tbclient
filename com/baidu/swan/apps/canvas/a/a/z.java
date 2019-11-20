package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class z extends a {
    private float aGm = -1.0f;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.aGm = (float) jSONArray.optDouble(0);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.aGm >= 0.0f && this.aGm <= 1.0f) {
            bVar.aFF = (int) (this.aGm * 255.0f);
        }
    }
}
