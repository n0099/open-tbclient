package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class ag extends a {
    private i cCA;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cCA = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cCA != null && this.cCA.isValid()) {
            if (this.cCA.akA()) {
                bVar.mStrokePaint.setShader(this.cCA.akB());
                return;
            }
            bVar.mStrokeColor = this.cCA.getColor();
            bVar.mStrokePaint.setColor(this.cCA.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
