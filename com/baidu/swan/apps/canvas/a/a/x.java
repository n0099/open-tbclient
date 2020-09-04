package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class x extends a {
    private i bZN;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bZN = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bZN != null && this.bZN.isValid()) {
            if (this.bZN.acM()) {
                bVar.mFillPaint.setShader(this.bZN.acN());
                return;
            }
            bVar.bZi.setColor(this.bZN.getColor());
            bVar.mFillPaint.setColor(this.bZN.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
