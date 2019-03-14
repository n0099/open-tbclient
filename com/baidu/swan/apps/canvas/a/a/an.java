package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class an extends a {
    private i alT;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.alT = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alT != null && this.alT.isValid()) {
            if (this.alT.wA()) {
                bVar.mStrokePaint.setShader(this.alT.getShader());
                return;
            }
            bVar.mStrokeColor = this.alT.getColor();
            bVar.mStrokePaint.setColor(this.alT.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
