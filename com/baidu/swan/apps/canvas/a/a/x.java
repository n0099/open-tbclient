package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class x extends a {
    private i bFD;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bFD = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bFD != null && this.bFD.isValid()) {
            if (this.bFD.Sh()) {
                bVar.mFillPaint.setShader(this.bFD.Si());
                return;
            }
            bVar.bEY.setColor(this.bFD.getColor());
            bVar.mFillPaint.setColor(this.bFD.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
