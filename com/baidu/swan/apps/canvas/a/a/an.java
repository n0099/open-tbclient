package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class an extends a {
    private i bhn;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bhn = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bhn != null && this.bhn.isValid()) {
            if (this.bhn.Ku()) {
                bVar.mStrokePaint.setShader(this.bhn.Kv());
                return;
            }
            bVar.mStrokeColor = this.bhn.getColor();
            bVar.mStrokePaint.setColor(this.bhn.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
