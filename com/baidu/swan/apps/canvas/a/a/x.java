package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class x extends a {
    private i coe;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.coe = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.coe != null && this.coe.isValid()) {
            if (this.coe.agg()) {
                bVar.mFillPaint.setShader(this.coe.agh());
                return;
            }
            bVar.cnz.setColor(this.coe.getColor());
            bVar.mFillPaint.setColor(this.coe.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
