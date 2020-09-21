package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class w extends a {
    private float cbM;
    private float cbN;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cbM = (float) jSONArray.optDouble(0);
            this.cbN = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.adu() == 0) {
            bVar.gM(canvas.save());
        }
        canvas.scale(this.cbM, this.cbN);
    }
}
