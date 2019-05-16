package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class an extends a {
    private i amk;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.amk = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amk != null && this.amk.isValid()) {
            if (this.amk.xr()) {
                bVar.mStrokePaint.setShader(this.amk.getShader());
                return;
            }
            bVar.mStrokeColor = this.amk.getColor();
            bVar.mStrokePaint.setColor(this.amk.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
