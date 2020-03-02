package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class an extends a {
    private i bgZ;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bgZ = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bgZ != null && this.bgZ.isValid()) {
            if (this.bgZ.Kr()) {
                bVar.mStrokePaint.setShader(this.bgZ.Ks());
                return;
            }
            bVar.mStrokeColor = this.bgZ.getColor();
            bVar.mStrokePaint.setColor(this.bgZ.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
