package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class an extends a {
    private i cHM;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cHM = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cHM != null && this.cHM.isValid()) {
            if (this.cHM.ana()) {
                bVar.mStrokePaint.setShader(this.cHM.anb());
                return;
            }
            bVar.mStrokeColor = this.cHM.getColor();
            bVar.mStrokePaint.setColor(this.cHM.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
