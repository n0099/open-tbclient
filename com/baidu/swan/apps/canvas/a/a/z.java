package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class z extends a {
    private float bTk = -1.0f;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bTk = (float) jSONArray.optDouble(0);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bTk >= 0.0f && this.bTk <= 1.0f) {
            bVar.bSI = (int) (this.bTk * 255.0f);
        }
    }
}
