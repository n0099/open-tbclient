package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class an extends a {
    private i alS;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.alS = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alS != null && this.alS.isValid()) {
            if (this.alS.wA()) {
                bVar.mStrokePaint.setShader(this.alS.getShader());
                return;
            }
            bVar.mStrokeColor = this.alS.getColor();
            bVar.mStrokePaint.setColor(this.alS.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
