package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class an extends a {
    private i cKi;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cKi = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cKi != null && this.cKi.isValid()) {
            if (this.cKi.akP()) {
                bVar.mStrokePaint.setShader(this.cKi.getShader());
                return;
            }
            bVar.aFr = this.cKi.getColor();
            bVar.mStrokePaint.setColor(this.cKi.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
