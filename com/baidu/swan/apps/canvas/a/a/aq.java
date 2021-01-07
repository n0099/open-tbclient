package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class aq extends a {
    private int cMr;
    private int cMs;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cMr = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(0));
            this.cMs = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.aok() == 0) {
            bVar.hS(canvas.save());
        }
        canvas.translate(this.cMr, this.cMs);
    }
}
