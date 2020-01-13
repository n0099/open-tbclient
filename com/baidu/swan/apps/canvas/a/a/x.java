package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class x extends a {
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
                bVar.mFillPaint.setShader(this.bcJ.Ib());
                return;
            }
            bVar.bce.setColor(this.bcJ.getColor());
            bVar.mFillPaint.setColor(this.bcJ.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
