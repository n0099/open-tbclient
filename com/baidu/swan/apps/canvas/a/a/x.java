package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class x extends a {
    private i bha;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bha = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bha != null && this.bha.isValid()) {
            if (this.bha.Kr()) {
                bVar.mFillPaint.setShader(this.bha.Ks());
                return;
            }
            bVar.bgv.setColor(this.bha.getColor());
            bVar.mFillPaint.setColor(this.bha.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
