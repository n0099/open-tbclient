package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class x extends a {
    private i bOv;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bOv = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bOv != null && this.bOv.isValid()) {
            if (this.bOv.UT()) {
                bVar.mFillPaint.setShader(this.bOv.UU());
                return;
            }
            bVar.bNQ.setColor(this.bOv.getColor());
            bVar.mFillPaint.setColor(this.bOv.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
