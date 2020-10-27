package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class x extends a {
    private i cwH;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cwH = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cwH != null && this.cwH.isValid()) {
            if (this.cwH.aia()) {
                bVar.mFillPaint.setShader(this.cwH.aib());
                return;
            }
            bVar.cwc.setColor(this.cwH.getColor());
            bVar.mFillPaint.setColor(this.cwH.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
