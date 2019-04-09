package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class aq extends a {
    private int alF;
    private int alG;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.alF = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(0));
            this.alG = com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.wy() == 0) {
            bVar.bQ(canvas.save());
        }
        canvas.translate(this.alF, this.alG);
    }
}
