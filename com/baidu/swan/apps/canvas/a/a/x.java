package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class x extends a {
    private i bFy;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.bFy = new i(jSONArray);
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (this.bFy != null && this.bFy.isValid()) {
            if (this.bFy.Si()) {
                bVar.mFillPaint.setShader(this.bFy.Sj());
                return;
            }
            bVar.bET.setColor(this.bFy.getColor());
            bVar.mFillPaint.setColor(this.bFy.getColor());
            bVar.mFillPaint.setShader(null);
        }
    }
}
