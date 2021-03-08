package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class w extends a {
    private float cLG;
    private float cLH;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cLG = (float) jSONArray.optDouble(0);
            this.cLH = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.akR() == 0) {
            bVar.gq(canvas.save());
        }
        canvas.scale(this.cLG, this.cLH);
    }
}
