package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class an extends a {
    private i bZJ;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bZJ = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bZJ != null && this.bZJ.isValid()) {
            if (this.bZJ.acM()) {
                bVar.mStrokePaint.setShader(this.bZJ.acN());
                return;
            }
            bVar.mStrokeColor = this.bZJ.getColor();
            bVar.mStrokePaint.setColor(this.bZJ.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
