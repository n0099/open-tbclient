package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class ag extends a {
    private i bTj;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bTj = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bTj != null && this.bTj.isValid()) {
            if (this.bTj.VZ()) {
                bVar.mStrokePaint.setShader(this.bTj.Wa());
                return;
            }
            bVar.mStrokeColor = this.bTj.getColor();
            bVar.mStrokePaint.setColor(this.bTj.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
