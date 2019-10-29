package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class x extends a {
    private i aGD;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.aGD = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.aGD != null && this.aGD.isValid()) {
            if (this.aGD.CT()) {
                bVar.mFillPaint.setShader(this.aGD.CU());
                return;
            }
            bVar.aFT.setColor(this.aGD.getColor());
            bVar.mFillPaint.setColor(this.aGD.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
