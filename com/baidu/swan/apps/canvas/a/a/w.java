package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class w extends a {
    private float cMA;
    private float cMB;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cMA = (float) jSONArray.optDouble(0);
            this.cMB = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.aok() == 0) {
            bVar.hS(canvas.save());
        }
        canvas.scale(this.cMA, this.cMB);
    }
}
