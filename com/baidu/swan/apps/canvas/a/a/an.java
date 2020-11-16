package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class an extends a {
    private i cAQ;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cAQ = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cAQ != null && this.cAQ.isValid()) {
            if (this.cAQ.ajS()) {
                bVar.mStrokePaint.setShader(this.cAQ.ajT());
                return;
            }
            bVar.mStrokeColor = this.cAQ.getColor();
            bVar.mStrokePaint.setColor(this.cAQ.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
