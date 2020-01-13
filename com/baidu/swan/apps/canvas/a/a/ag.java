package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class ag extends a {
    private i bcJ;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bcJ = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bcJ != null && this.bcJ.isValid()) {
            if (this.bcJ.Ia()) {
                bVar.mStrokePaint.setShader(this.bcJ.Ib());
                return;
            }
            bVar.mStrokeColor = this.bcJ.getColor();
            bVar.mStrokePaint.setColor(this.bcJ.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
