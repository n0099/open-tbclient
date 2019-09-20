package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class ag extends a {
    private i anl;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.anl = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.anl != null && this.anl.isValid()) {
            if (this.anl.xY()) {
                bVar.mStrokePaint.setShader(this.anl.xZ());
                return;
            }
            bVar.mStrokeColor = this.anl.getColor();
            bVar.mStrokePaint.setColor(this.anl.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
