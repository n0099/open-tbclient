package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class w extends a {
    private float cAO;
    private float cAP;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cAO = (float) jSONArray.optDouble(0);
            this.cAP = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.ajR() == 0) {
            bVar.hA(canvas.save());
        }
        canvas.scale(this.cAO, this.cAP);
    }
}
