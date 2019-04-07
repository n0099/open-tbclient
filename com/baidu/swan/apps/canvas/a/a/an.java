package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class an extends a {
    private i alX;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.alX = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.alX != null && this.alX.isValid()) {
            if (this.alX.wz()) {
                bVar.mStrokePaint.setShader(this.alX.getShader());
                return;
            }
            bVar.mStrokeColor = this.alX.getColor();
            bVar.mStrokePaint.setColor(this.alX.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
