package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class x extends a {
    private i bbT;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bbT = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bbT != null && this.bbT.isValid()) {
            if (this.bbT.HE()) {
                bVar.mFillPaint.setShader(this.bbT.HF());
                return;
            }
            bVar.bbm.setColor(this.bbT.getColor());
            bVar.mFillPaint.setColor(this.bbT.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
