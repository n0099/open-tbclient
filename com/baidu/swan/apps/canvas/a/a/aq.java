package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aq extends a {
    private int alR;
    private int alS;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.alR = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(0));
            this.alS = com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.xq() == 0) {
            bVar.bQ(canvas.save());
        }
        canvas.translate(this.alR, this.alS);
    }
}
