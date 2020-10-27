package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class w extends a {
    private float cwF;
    private float cwG;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cwF = (float) jSONArray.optDouble(0);
            this.cwG = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.ahZ() == 0) {
            bVar.hu(canvas.save());
        }
        canvas.scale(this.cwF, this.cwG);
    }
}
