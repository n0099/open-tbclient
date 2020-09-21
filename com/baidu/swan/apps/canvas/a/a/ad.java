package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class ad extends a {
    private int bqF = -1;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bqF = com.baidu.swan.apps.ap.ah.H((float) jSONArray.optDouble(0));
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bqF >= 0) {
            bVar.mStrokePaint.setStrokeWidth(this.bqF);
        }
    }
}
