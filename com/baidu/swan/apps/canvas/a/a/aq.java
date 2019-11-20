package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aq extends a {
    private int aFT;
    private int aFU;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.aFT = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(0));
            this.aFU = com.baidu.swan.apps.an.z.S((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.CT() == 0) {
            bVar.cN(canvas.save());
        }
        canvas.translate(this.aFT, this.aFU);
    }
}
