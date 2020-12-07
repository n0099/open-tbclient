package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class x extends a {
    private i cHM;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cHM = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cHM != null && this.cHM.isValid()) {
            if (this.cHM.ana()) {
                bVar.mFillPaint.setShader(this.cHM.anb());
                return;
            }
            bVar.cHd.setColor(this.cHM.getColor());
            bVar.mFillPaint.setColor(this.cHM.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
