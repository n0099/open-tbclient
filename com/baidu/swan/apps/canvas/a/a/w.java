package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class w extends a {
    private float bTZ;
    private float bUa;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.bTZ = (float) jSONArray.optDouble(0);
            this.bUa = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.WF() == 0) {
            bVar.eF(canvas.save());
        }
        canvas.scale(this.bTZ, this.bUa);
    }
}
