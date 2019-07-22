package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class x extends a {
    private i amN;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.amN = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.amN != null && this.amN.isValid()) {
            if (this.amN.xU()) {
                bVar.mFillPaint.setShader(this.amN.xV());
                return;
            }
            bVar.amc.setColor(this.amN.getColor());
            bVar.mFillPaint.setColor(this.amN.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
