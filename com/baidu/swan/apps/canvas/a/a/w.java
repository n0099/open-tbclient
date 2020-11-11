package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class w extends a {
    private float cCy;
    private float cCz;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cCy = (float) jSONArray.optDouble(0);
            this.cCz = (float) jSONArray.optDouble(1);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.akz() == 0) {
            bVar.hE(canvas.save());
        }
        canvas.scale(this.cCy, this.cCz);
    }
}
