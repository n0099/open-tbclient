package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class ae extends a {
    private int cMH = -1;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cMH = com.baidu.swan.apps.ao.ah.O((float) jSONArray.optDouble(0));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cMH >= 0) {
            bVar.mStrokePaint.setStrokeMiter(this.cMH);
        }
    }
}
