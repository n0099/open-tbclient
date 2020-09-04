package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class w extends a {
    private float bZL;
    private float bZM;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.bZL = (float) jSONArray.optDouble(0);
            this.bZM = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.acL() == 0) {
            bVar.gD(canvas.save());
        }
        canvas.scale(this.bZL, this.bZM);
    }
}
