package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class an extends a {
    private i cHQ;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cHQ = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cHQ != null && this.cHQ.isValid()) {
            if (this.cHQ.akr()) {
                bVar.mStrokePaint.setShader(this.cHQ.getShader());
                return;
            }
            bVar.aDE = this.cHQ.getColor();
            bVar.mStrokePaint.setColor(this.cHQ.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
