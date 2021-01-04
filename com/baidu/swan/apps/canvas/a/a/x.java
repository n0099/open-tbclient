package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class x extends a {
    private i cMC;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cMC = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cMC != null && this.cMC.isValid()) {
            if (this.cMC.aok()) {
                bVar.mFillPaint.setShader(this.cMC.getShader());
                return;
            }
            bVar.cLU.setColor(this.cMC.getColor());
            bVar.mFillPaint.setColor(this.cMC.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
