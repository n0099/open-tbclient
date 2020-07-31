package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class ad extends a {
    private int bhZ = -1;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bhZ = com.baidu.swan.apps.aq.ai.D((float) jSONArray.optDouble(0));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bhZ >= 0) {
            bVar.mStrokePaint.setStrokeWidth(this.bhZ);
        }
    }
}
