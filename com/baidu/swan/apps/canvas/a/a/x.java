package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class x extends a {
    private i aGl;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.aGl = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.aGl != null && this.aGl.isValid()) {
            if (this.aGl.CU()) {
                bVar.mFillPaint.setShader(this.aGl.CV());
                return;
            }
            bVar.aFB.setColor(this.aGl.getColor());
            bVar.mFillPaint.setColor(this.aGl.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
