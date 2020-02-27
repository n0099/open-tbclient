package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class ag extends a {
    private i bgY;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bgY = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bgY != null && this.bgY.isValid()) {
            if (this.bgY.Kp()) {
                bVar.mStrokePaint.setShader(this.bgY.Kq());
                return;
            }
            bVar.mStrokeColor = this.bgY.getColor();
            bVar.mStrokePaint.setColor(this.bgY.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
