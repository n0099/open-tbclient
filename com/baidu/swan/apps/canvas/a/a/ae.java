package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class ae extends a {
    private int bUg = -1;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bUg = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(0));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bUg >= 0) {
            bVar.mStrokePaint.setStrokeMiter(this.bUg);
        }
    }
}
