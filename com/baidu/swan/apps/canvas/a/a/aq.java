package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class aq extends a {
    private int cHF;
    private int cHG;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.cHF = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(0));
            this.cHG = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(1));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.akq() == 0) {
            bVar.gl(canvas.save());
        }
        canvas.translate(this.cHF, this.cHG);
    }
}
