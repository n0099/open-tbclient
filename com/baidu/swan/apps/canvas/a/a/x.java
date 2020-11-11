package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class x extends a {
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
                bVar.mFillPaint.setShader(this.cCA.akB());
                return;
            }
            bVar.cBV.setColor(this.cCA.getColor());
            bVar.mFillPaint.setColor(this.cCA.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
