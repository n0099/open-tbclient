package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class an extends a {
    private i cbO;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.cbO = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.cbO != null && this.cbO.isValid()) {
            if (this.cbO.adv()) {
                bVar.mStrokePaint.setShader(this.cbO.adw());
                return;
            }
            bVar.mStrokeColor = this.cbO.getColor();
            bVar.mStrokePaint.setColor(this.cbO.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
