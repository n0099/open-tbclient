package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class an extends a {
    private i alY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.alY = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alY != null && this.alY.isValid()) {
            if (this.alY.wz()) {
                bVar.mStrokePaint.setShader(this.alY.getShader());
                return;
            }
            bVar.mStrokeColor = this.alY.getColor();
            bVar.mStrokePaint.setColor(this.alY.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
