package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class ag extends a {
    private i bbT;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bbT = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bbT != null && this.bbT.isValid()) {
            if (this.bbT.HE()) {
                bVar.mStrokePaint.setShader(this.bbT.HF());
                return;
            }
            bVar.mStrokeColor = this.bbT.getColor();
            bVar.mStrokePaint.setColor(this.bbT.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
